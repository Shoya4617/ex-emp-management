package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author yamaseki
 * 管理者情報をフォームから受け取るフォームクラス
 */
public class InsertAdministratorForm {
	//管理者名
	@NotBlank(message="登録者名を入力してください")
	private String name;
	//メールアドレス
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスは不正です")
	private String mailAddress;
	//パスワード
	@NotBlank(message="パスワードを入力してください")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	

}
