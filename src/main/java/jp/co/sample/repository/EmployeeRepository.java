package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * @author yamaseki
 * 従業員リポジトリ
 */
@Repository
public class EmployeeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Employee>EMP_ROW_MAPPER = (rs,i) -> {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setImg(rs.getString("image"));
		emp.setGender(rs.getString("gender"));
		emp.setHireDate(rs.getDate("hire_date"));
		emp.setMailAddress(rs.getString("mail_address"));
		emp.setZipCode(rs.getString("zip_code"));
		emp.setAddress(rs.getString("address"));
		emp.setTelephone(rs.getString("telephone"));
		emp.setSalary(rs.getInt("salary"));
		emp.setCharacteristics(rs.getString("characteristics"));
		emp.setDependentCount(rs.getInt("dependents_count"));
		return emp;
	};
	
	/*
	 * findAllメソッド
	 * 従業員情報を一覧で出力するメソッド
	 * @return List<Employee>
	 */
	public List<Employee> findAll(){
		String sql = "select id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count from employees"; 
		List<Employee>empList = template.query(sql, EMP_ROW_MAPPER);
		return empList;
	}
	
	/*
	 * loadメソッド
	 * 従業員情報をidを元に一件出力するメソッド
	 * @return Employee
	 * @param Integer id
	 */
	public Employee load(Integer id) {
		String sql = "select id,name,image,gende,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count from employees where id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee emp = new Employee();
		emp = template.queryForObject(sql, param, EMP_ROW_MAPPER);
		
		return emp;
	}
	
	/*
	 * updateメソッド
	 * 従業員情報を更新するメソッド
	 * 今回は扶養人数だけの更新
	 * @param Employee
	 */
	public void update(Employee employee) {
		String sql = "update employees set dependents_count = :dependentCount";
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		template.update(sql, param);
	}
}
