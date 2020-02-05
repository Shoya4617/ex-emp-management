package jp.co.sample.domain;

/**
 * @author yamaseki
 * 管理者クラスのドメイン
 */
public class Administrator {
	//管理者ID
	private Integer id;
	//管理者の名前
	private String name;
	//管理者のメールアドレス
	private String mailAddress;
	//管理者のログインパスワード
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

}
