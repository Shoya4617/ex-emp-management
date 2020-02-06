package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * @author yamaseki
 * 従業員情報を更新するためにフォームからパラメーターを受け取るフォーム
 */
public class UpdateEmployeeForm {
	/*従業員id*/
	private String id;
	/*扶養人数*/
	@NotBlank(message="入力必須項目です")
	private String dependentCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentCount() {
		return dependentCount;
	}
	public void setDependentCount(String dependentCount) {
		this.dependentCount = dependentCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentCount=" + dependentCount + "]";
	}
	
	
	
	
	

}
