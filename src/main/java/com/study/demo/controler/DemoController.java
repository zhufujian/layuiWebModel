package com.study.demo.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

//@Controller
public class DemoController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userName, String passwd, Model model) {
		logger.info("login");
        return "result";
    }
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login2(String userName, String passwd, Model model) {
		logger.info("login2");
		 return "result";
    }
}
