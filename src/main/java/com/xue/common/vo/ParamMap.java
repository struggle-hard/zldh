package com.xue.common.vo;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.cglib.beans.BeanMap;

import com.github.pagehelper.PageInfo;

/**
 * Description: 封装查询参数 <br/>
 * Date: 2018年1月9日 上午10:15:13 <br/>
 *
 * @author xuejianxin
 */
public class ParamMap extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public <PT> PageInfo<PT> getPage() {
		PageInfo<PT> pg = new PageInfo<PT>();
		pg.setPageNum(getI("pageNum"));
		pg.setPageSize(getI("pageSize"));
		return pg;
	}

	/**
	 * 
	 * Description:从map中获取bean属性<br/>
	 * 例如：Demo d=getBean(new Demo());<br/>
	 * Date: 2018年1月10日 上午9:18:12 <br/>
	 * 
	 * @author xuejianxin
	 * @param t
	 * @return
	 */
	public <T> T getBean(T obj) {
		BeanMap beanMap = BeanMap.create(obj);
		beanMap.putAll(this);// putAll操作会直接修改pojo对象里的属性
		return obj;
	}

	/**
	 * 
	 * Description:直接获取一个对象<br/>
	 * 例如:Demo d=pm.getBean(Demo.class); Date: 2018年1月10日 上午9:18:12 <br/>
	 * 
	 * @author xuejianxin
	 * @param t
	 * @return
	 */
	public <T> T getBean(Class<T> t) {
		T obj = null;
		try {
			obj = t.getDeclaredConstructor().newInstance();
			obj = getBean(obj);
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@SuppressWarnings("unchecked")
	public <T> T getO(String key) {
		return (T) this.get(key);
	}

	/**
	 * 
	 * Description:返回 Integer <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @return
	 */
	public Integer getI(String key) {
		return null == get(key) ? null : Integer.valueOf(getS(key));
	}

	/**
	 * 
	 * Description:返回 Long <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @return
	 */
	public Long getL(String key) {
		return null == get(key) ? null : Long.valueOf(getS(key));
	}

	/**
	 * 
	 * Description:返回 Double <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @return
	 */
	public Double getD(String key) {
		return null == get(key) ? null : Double.valueOf(getS(key));
	}

	/**
	 * 
	 * Description:返回 Float <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @return
	 */
	public Float getF(String key) {
		return null == get(key) ? null : Float.valueOf(getS(key));
	}

	/**
	 * 
	 * Description:返回 String <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @return
	 */
	public String getS(String key) {
		return null == this.get(key) ? null : String.valueOf(this.get(key));
	}

	/**
	 * 
	 * Description:返回 Date <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @param format 日期格式字符串
	 * @return
	 */
	public Date getDate(String key, String format) {
		Date d = null;
		String v = getS(key);
		if (null != v && !"".equals(v.trim())) {
			try {
				new SimpleDateFormat(format).parse(v);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return d;
	}

	/**
	 * 
	 * Description:返回 Date <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @param format 日期格式字符串 yyyy-MM-dd
	 * @return
	 */
	public Date getDate(String key) {
		return getDate(key, "yyyy-MM-dd");
	}

	/**
	 * 
	 * Description:返回 Date <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @param format 日期格式字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public Date getDateTime(String key) {
		return getDate(key, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * Description:返回 List <br/>
	 * Date: 2018年1月9日 下午3:24:37 <br/>
	 * 
	 * @author xuejianxin
	 * @param key
	 * @param format 日期格式字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key) {
		List<T> list = null;
		List<Object> objList = getO(key);
		if (null != objList && !objList.isEmpty()) {
			list = new ArrayList<T>();
			for (Object o : objList) {
				list.add((T) o);
			}
		}
		return list;
	}

	public static ParamMap get() {
		return new ParamMap();
	}

	public ParamMap add(String key, Object value) {
		this.put(key, value);
		return this;
	}

}
