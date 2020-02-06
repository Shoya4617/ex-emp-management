package jp.co.sample.domain;

/**
 * 管理者クラスのドメイン.
 * 
 * @author yamaseki
 */
public class Administrator {
	/** ID */
	private Integer id;
	//名前
	private String name;
	//管理者のメールアドレス
	private String mailAddress;
	//管理者のログインパスワード
	private String password;
	
	
	//引数なしのコンストラクタ
	public Administrator() {

	}
	
	public Administrator(Integer id, String name, String mailAddress, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}


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
