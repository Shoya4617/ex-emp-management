package jp.co.sample.form;
/*
 * ログインフォームからリクエストパラメーターを受け取るフォーム
 * @author yamaseki
 */
public class LoginForm {
	/*ログイン用メールアドレス*/
	private String mailAddress;
	/*ログイン用パスワード*/
	private String password;
	
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
		return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	
	

}
