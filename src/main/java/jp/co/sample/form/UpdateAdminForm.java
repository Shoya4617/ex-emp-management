package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdateAdminForm {
	
	@NotBlank(message="入力必須項目です")
	private String name;
	@Email(message="メールアドレスを入力してください")
	@NotBlank(message="入力必須項目です")
	private String mailAddress;
	@NotBlank(message="入力必須項目です")
	private String password;
	
	@Override
	public String toString() {
		return "UpdateAdminForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}

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
	
	

}
