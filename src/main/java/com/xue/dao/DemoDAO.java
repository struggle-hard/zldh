package com.xue.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xue.pojo.Demo;

/**
 * 
 * Description: 数据层 <br/>
 * Date: 2017年3月9日 上午11:52:07 <br/>
 *
 * @author xuejianxin
 */

public interface DemoDAO {

	List<Demo> queryByPage(@Param("params") Map<String, Object> params);

	int deleteByIds(@Param("ids") List<String> ids);

	Integer save(Demo entity);

	Integer update(Demo entity);

	Demo queryById(Integer id);
}