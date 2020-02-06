package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

	/*
	 * 管理者作成の際の入力チェックのためのsetFormメソッド
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/*
	 * ログインフォームにおける入力チェックのためのsetformメソッド
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * 管理者登録画面に遷移する.
	 * 
	 * @return 管理者登録画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert.html";
	}

	/*
	 * dbに管理者情報を挿入するためのメソッド
	 * 
	 * @param 管理者登録画面のフォーム
	 */
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form,BindingResult result) {
		if(result.hasErrors()) {
			return toInsert();
		}
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

	/*
	 * ログインを実行するためのメソッド param ログイン画面から受け取ったパラメターを格納するフォーム param リクエストフォーム
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator admin = service.login(form.getMailAddress(),form.getPassword());
		// ログインチェック
		if (admin == null) {
			String error = "メールアドレスまたはパスワードが不正です";
			model.addAttribute("error", error);

			// ログインに失敗したら再度ログインページに戻る
			return toLogin();
		}

		session.setAttribute("administratorName", admin.getName());

		// ログインに成功したらemployeeコントローラー内のshowListにフォワード
		return "forward:/employee/showList";
	}

	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return toLogin();
	}

}
