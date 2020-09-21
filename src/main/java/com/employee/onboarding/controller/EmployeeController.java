package com.employee.onboarding.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.employee.onboarding.model.Employee;
import com.employee.onboarding.service.EmployeeService;

/**
 * @author aryansh
 *
 */
@Controller
public class EmployeeController extends WebMvcConfigurerAdapter{

	  @Override 
	  public void addViewControllers(ViewControllerRegistry registry) {
	  registry.addViewController("/employee").setViewName("employee"); }
	 

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

 
    @RequestMapping("employee/new")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @PostMapping("employee")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employeeform";
        }    
        Employee employeeWithTax = employeeService.taxCalculator(employee);   
        employeeService.saveEmployee(employeeWithTax);
        return "redirect:/";
    }

    @RequestMapping("employee/{id}")
    public String showEmployeeDetails(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employeeshow";
    }

    @GetMapping("/")
    public String showEmployee(Model model){
        model.addAttribute("showEmployee", employeeService.findAllEmployees());
        return "showEmployee";
    }

    @RequestMapping("employee/delete/{id}")
    public String delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}

