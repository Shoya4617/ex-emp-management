package jp.co.sample.domain;

import java.util.Date;

/**
 * @author yamaseki
 * 従業員用区クラスドメイン
 */
public class Employee {
	
	//引数なしのコンストラクタ
	public Employee() {
		
	}
	
	
	public Employee(Integer id, String name, String img, String gender, Date hireDate, String mailAddress,
			String zipCode, String address, String telephone, Integer salary, String characteristics,
			Integer dependentCount) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.gender = gender;
		this.hireDate = hireDate;
		this.mailAddress = mailAddress;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependentCount = dependentCount;
	}


	//従業員ID
	private Integer id;
	//従業員名
	private String name;
	//従業員写真
	private String img;
	//従業員の性別
	private String gender;
	//入社日
	private java.util.Date hireDate;
	//メールアドレス
	private String mailAddress;
	//居住地の郵便番号
	private String zipCode;
	//居住地住所
	private String address;
	//電話番号
	private String telephone;
	//給料
	private Integer salary;
	//特性
	private String characteristics;
	//扶養人数
	private Integer dependentCount;
	
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
	public java.util.Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public Integer getDependentCount() {
		return dependentCount;
	}
	public void setDependentCount(Integer dependentCount) {
		this.dependentCount = dependentCount;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", img=" + img + ", gender=" + gender + ", hireDate="
				+ hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentCount=" + dependentCount + "]";
	}
	
	

}
