/**
 * Date:2018年1月9日上午11:15:46
 *
 */

package com.xue.common.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 封装json 返回结果 <br/>
 * Date: 2018年1月9日 上午11:15:46 <br/>
 * 链式调用样例:最后一定要调用toMap 方法<br/>
 * ResultMap.get().success().setMessage("删除成功!").setPager(pager).setData("mydata",obj).toMap();<br/>
 * 
 * @author xuejianxin
 */
public class ResultMap {
	// 代码
	private String code;
	// 消息
	private String message;
	// 是否成功
	private Boolean success;
	// 主要数据
	private Map<String, Object> data = new HashMap<String, Object>();

	private ResultMap() {
		// 防止new
	}

	/**
	 * 
	 * Description:获取一个实例<br/>
	 * Date: 2018年1月9日 下午3:20:15 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public static ResultMap get() {
		return new ResultMap();
	}

	/**
	 * 
	 * Description:成功时填充默认的参数<br/>
	 * Date: 2018年1月9日 下午3:20:30 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap success() {
		this.code = "0";
		this.success = true;
		this.message = "操作成功   ";
		return this;
	}

	/**
	 * 
	 * Description:成功时填充默认的参数,并设置分页数据<br/>
	 * Date: 2018年1月9日 下午3:21:04 <br/>
	 * 
	 * @author xuejianxin
	 * @param pager
	 * @return
	 */
	public ResultMap successWithPager(Object pager) {
		this.success();
		this.setPager(pager);
		return this;
	}

	/**
	 * Description:设置分页的数据<br/>
	 * Date: 2018年1月9日 下午3:22:07 <br/>
	 * 
	 * @author xuejianxin
	 * @param pager
	 * @return
	 */
	public ResultMap setPager(Object pager) {
		return this.setData("pager", pager);
	}

	/**
	 * 
	 * Description:错误时填充默认的参数<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap error(Exception e) {
		error(e.getMessage());
		return this;
	}

	public ResultMap error() {
		error("");
		return this;
	}

	public ResultMap error(String msg) {
		this.code = "-1";
		this.message = "操作失败   " + msg;
		this.success = false;
		return this;
	}

	/**
	 * 
	 * Description:设置是否成功<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	/**
	 * 
	 * Description:设置返回错误代码<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap setCode(String code) {
		this.code = code;
		return this;
	}

	/**
	 * 
	 * Description:设置提示信息<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap setMessage(String message) {
		this.message += message;
		return this;
	}

	/**
	 * 
	 * Description:设置其他额外数据<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public ResultMap setData(String key, Object message) {
		this.data.put(key, message);
		return this;
	}

	/**
	 * 
	 * Description:返回设置完成后的map<br/>
	 * Date: 2018年1月9日 下午3:22:21 <br/>
	 * 
	 * @author xuejianxin
	 * @return
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", code);
		result.put("message", message);
		result.put("success", success);
		if (!data.isEmpty()) {
			result.putAll(this.data);
		}
		return result;
	}

}
