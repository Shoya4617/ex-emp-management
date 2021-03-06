package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * @author yamaseki
 *従業員用サービスクラス
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	//従業員一覧をリポジトリから受け取るためのメソッド
	public List<Employee> showList(){
		List<Employee>empList = repository.findAll();
		return empList;
	}
	
	//従業員詳細情報をリポジトリから受け取るためのメソッド
	public Employee showDetail(Integer id) {
		return repository.load(id);
	}
	
	//従業員情報をリポジトリで更新するためのメソッド
	public void update(Employee employee) {
		repository.update(employee);
	}
}
