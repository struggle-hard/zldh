package com.xue.common.config;

import java.util.Properties;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 在service层开启事务
 * 事务管理配置,在mysql 中注意mysql表的类型如果是MyISAM 则不支持事物
 */
@Configuration
@Order(2)
public class TransactionConfiguration extends
		ProxyTransactionManagementConfiguration {
	/**
	 * 事物拦截器
	 * 
	 * @param transactionManager
	 * @return
	 * @since springboot 2.1.0
	 */
	@Bean(name = "transactionInterceptor")
	public TransactionInterceptor transactionInterceptor(
			PlatformTransactionManager transactionManager) {
		// 事物管理器
		TransactionInterceptor transactionInterceptor = super
				.transactionInterceptor();

		Properties transactionAttributes = new Properties();

		// save,insert,update,remove,delete,batch,cancel
		// 开头的方法使用PROPAGATION_REQUIRED传播特性
		transactionAttributes.setProperty("save*",
				"PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("insert*",
				"PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("update*",
				"PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("delete*",
				"PROPAGATION_REQUIRED,-Throwable");

		// 其他方法都使用PROPAGATION_SUPPORTS传播特性
		transactionAttributes.setProperty("*", "PROPAGATION_SUPPORTS,readOnly");
		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		return transactionInterceptor;
	}

	@Bean
	public BeanNameAutoProxyCreator transactionAutoProxy() {
		BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
		transactionAutoProxy.setProxyTargetClass(true);
		// 事物类以Service 或 ServiceImpl 结尾
		transactionAutoProxy.setBeanNames("*Service", "*ServiceImpl");
		transactionAutoProxy.setInterceptorNames("transactionInterceptor");
		return transactionAutoProxy;
	}

}
