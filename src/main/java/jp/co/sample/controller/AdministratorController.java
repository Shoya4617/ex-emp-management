package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者用コントローラークラス.
 * 
 * @author yamaseki
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private AdministratorService service;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	/*
	 * insert.htmlに遷移するためのメソッド
	 * 
	 * */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert.html";
	}
	
	/*
	 * dbに管理者情報を挿入するためのメソッド
	 * @param 管理者登録画面のフォーム
	 * */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator admin = new Administrator();
		BeanUtils.copyProperties(form, admin);
		service.insert(admin);
		return "redirect:/";
	}
	
	/*
	 * ログイン画面に遷移するためのメソッド
	 * 
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login.html";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator admin = service.login(form.getMailAddress(), form.getPassword());
		if(admin==null) {
			String error = "メールアドレスまたはパスワードが不正です";
			model.addAttribute("error",error);
		}else {
			session.setAttribute("administratorName", admin.getName());
		}
		
		return "forward:/employee/showList";
	}
}
