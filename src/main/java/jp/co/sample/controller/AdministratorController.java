package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * @author yamaseki
 * 管理者コントローラークラス
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private AdministratorService service;
	
	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	//insert.htmlに遷移するメソッド
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert.html";
	}
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator admin = new Administrator();
		BeanUtils.copyProperties(form, admin);
		service.insert(admin);
		return "redirect:/";
		
	}
}
