/**
 * Date:2017年12月25日上午11:09:32
 *
 */

package com.xue.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xue.common.vo.ParamMap;
import com.xue.common.vo.ResultMap;
import com.xue.pojo.Demo;
import com.xue.service.DemoService;

/**
 * Description: demo <br/>
 * Date: 2017年12月25日 上午11:09:32 <br/>
 * 
 * @author xuejianxinokok@163.com
 */

@RequestMapping(value = DemoController.PATH)
@RestController("demoController")
public class DemoController {
	public static final String PATH = "demo";
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DemoService service;

	@RequestMapping(value = "/listPage", method = { RequestMethod.POST })
	public Map<String, Object> listPage(@RequestBody ParamMap pm) {
		try {
			System.out.println(pm);
			return ResultMap.get().successWithPager(service.queryByPage(pm)).toMap();
		} catch (Exception e) {
			log.error("error", e);
			return ResultMap.get().error(e).toMap();
		}
	}

	@RequestMapping(value = "/getById", method = { RequestMethod.POST })
	public ResultMap getById(@RequestBody ParamMap pm) {
		return ResultMap.get().setData("vo", service.queryById(pm.getI("id"))) ;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String, Object> add(@RequestBody Demo vo) {
		try {
			service.save(vo);
			return ResultMap.get().setData("id", vo.getId()).success().toMap();
		} catch (Exception e) {
			log.error("error", e);
			return ResultMap.get().error(e).toMap();
		}
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public Map<String, Object> update(@RequestBody Demo vo) {
		try {
			service.update(vo);
			return ResultMap.get().success().toMap();
		} catch (Exception e) {
			log.error("error", e);
			return ResultMap.get().error(e).toMap();
		}
	}

	@RequestMapping(value = "/deleteByIds", method = { RequestMethod.POST })
	public Map<String, Object> deleteByIds(@RequestBody List<String> ids) {
		try {
			service.deleteByIds(ids);
			return ResultMap.get().success().toMap();
		} catch (Exception e) {
			log.error("error", e);
			return ResultMap.get().error(e).toMap();
		}
	}

}
