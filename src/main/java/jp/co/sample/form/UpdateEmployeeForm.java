package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * @author yamaseki
 * 従業員情報を更新するためにフォームからパラメーターを受け取るフォーム
 */
public class UpdateEmployeeForm {
	/*従業員id*/
	private String id;
	@NotBlank(message="入力必須項目です")
	private String name;
	//従業員写真
	private String img;
	//従業員の性別
	@NotBlank(message="入力必須項目です")
	private String gender;
	//メールアドレス
	@NotBlank(message="入力必須項目です")
	private String mailAddress;
	//居住地の郵便番号
	@NotBlank(message="入力必須項目です")
	private String zipCode;
	//居住地住所
	@NotBlank(message="入力必須項目です")
	private String address;
	//電話番号
	@NotBlank(message="入力必須項目です")
	private String telephone;
	//給料
	@NotBlank(message="入力必須項目です")
	private String salary;
	//特性
	@NotBlank(message="入力必須項目です")
	private String characteristics;
	/*扶養人数*/
	@NotBlank(message="入力必須項目です")
	private String dependentCount;
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", img=" + img + ", gender=" + gender
				+ ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address + ", telephone="
				+ telephone + ", salary=" + salary + ", characteristics=" + characteristics + ", dependentCount="
				+ dependentCount + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public String getDependentCount() {
		return dependentCount;
	}
	public void setDependentCount(String dependentCount) {
		this.dependentCount = dependentCount;
	}
	
	
	
	
	
	
	
	

}
