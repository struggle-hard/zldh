package com.xue.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.dao.DemoDAO;
import com.xue.pojo.Demo;

/**
 * Description: service层 <br/>
 * Date: 2017年3月9日 上午11:52:17 <br/>
 * 
 * @author xuejianxin
 */
@Service("DemoService")
public class DemoService {
	@Autowired
	private DemoDAO dao;

	/**
	 * ④为了支持startPage(Object params)方法，增加了该参数来配置参数映射，用于从对象中根据属性名取值，
	 * 可以配置pageNum,pageSize,count,pageSizeZero,reasonable，不配置映射的用默认值， 默认值为
	 * pageNum=pageNum; pageSize=pageSize; count=countSql; reasonable=reasonable;
	 * pageSizeZero=pageSizeZero。 support-methods-arguments支持通过 Mapper
	 * 接口参数来传递分页参数，默认值false，分页插件会从查询方法的参数值中，自动根据上面 params 配置的字段中取值，查找到合适的值时就会自动分页。
	 */
	public PageInfo<Demo> queryByPage(Map<String, Object> params) {
		// 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页!!!!
		PageHelper.startPage(params);
		//PageHelper.startPage(1,10);
		return PageInfo.of(dao.queryByPage(params));
	}

	/** 保存 */
	public void save(Demo vo) {
		dao.save(vo);
	}

	/** 修改 */
	public void update(Demo vo) {
		dao.update(vo);
	}

	/* 删除 */
	public int deleteByIds(List<String> ids) {
		return dao.deleteByIds(ids);
	}

	public Demo queryById(Integer id) {
		return dao.queryById(id);
	}

	public void saveTest(Demo vo) {
		dao.save(vo);
		System.out.println(1 / 0);// 制造异常测试事务
	}
}
