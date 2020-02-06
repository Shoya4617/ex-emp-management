package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateForm() {
		return new UpdateEmployeeForm();
	}
	
	/*
	 * 従業員一覧画面に推移するためのメソッド
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		if(session.getAttribute("admin")==null) {
			return "forward:/";
		}
		//EmployeeServiceのshowListメソッドを呼び出し従業員一覧を受け取る
		List<Employee>employeeList = service.showList();
		model.addAttribute("employeeList",employeeList);
		return "employee/list.html";
	}
	
	/*
	 * 従業員詳細画面に遷移するためのメソッド
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		if(session.getAttribute("admin")==null) {
			return "forward:/";
		}
		Integer intId = Integer.parseInt(id);
		Employee emp = service.showDetail(intId);
		model.addAttribute("employee",emp);
		session.setAttribute("employee",emp);
		return "employee/detail.html";
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model) {
		if(session.getAttribute("admin")==null) {
			return "forward:/";
		}
		model.addAttribute("employee",session.getAttribute("employee"));
		return "employee/updatedetail";
	}
	
	/*
	 * 従業員情報を更新するためのメソッド
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form,BindingResult result,Model model) {
		if(session.getAttribute("admin")==null) {
			return "forward:/";
		}
		
		if(result.hasErrors()) {
			return toUpdate(model);
		}
		Employee employee = new Employee();
		
		//formから受け取ったidとDependentCountをemployee型に合うようにInteger型にパースする
		Integer intId = Integer.parseInt(form.getId());
		Integer intDepend = Integer.parseInt(form.getDependentCount());
		Integer intSalary = Integer.parseInt(form.getSalary());
		
		employee.setId(intId);
		employee.setCharacteristics(form.getCharacteristics());
		employee.setSalary(intSalary);
		employee.setDependentCount(intDepend);
		employee.setTelephone(form.getTelephone());
		employee.setAddress(form.getAddress());
		employee.setZipCode(form.getZipCode());
		employee.setMailAddress(form.getMailAddress());
		employee.setGender(form.getGender());
		employee.setName(form.getName());
		
		service.update(employee);
		return "redirect:/employee/showDetail?id="+employee.getId();
	}
	
}
