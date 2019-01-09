package org.lanqiao.crud.controller;

import org.lanqiao.crud.dao.DepartmentDao;
import org.lanqiao.crud.dao.EmployeeDao;
import org.lanqiao.crud.entities.Department;
import org.lanqiao.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String emps(Model model){
        Collection<Employee> emps =  employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "list";
    }
    @GetMapping("emp")
    public String toAddEmpPage(Model model){
        System.out.println("dept");
        Collection<Department> depts= departmentDao.getDepartments();
        System.out.println(depts);
        model.addAttribute("depts",depts);
        return "addEmp";
    }
    @PostMapping("emp")
    public String saveEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:emps";
    }
    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable int id){
        System.out.println("id--"+id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
