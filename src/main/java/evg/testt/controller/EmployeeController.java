package evg.testt.controller;

import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by dima on 12.03.16.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/dep/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer depId) {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
            for (int i = 0; i < employees.size(); ) {
                if(employees.get(i).getDepartmentId() != depId)employees.remove(i);
                else i++;
            }
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
        return mav.addObject("depId", depId);
    }

    @RequestMapping(value = "/dep/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(
            @RequestParam(required = true) Integer depId) {
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "depId", depId);
    }

    @RequestMapping(value = "/dep/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer depId
    ) {
        Employee addedEmployee = new Employee();
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        addedEmployee.setDepartmentId(depId);
        try {
            employeeService.insert(addedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep/emp?depId="+depId;
    }

    @RequestMapping(value = "/dep/empEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(required = true) Integer id) {
        try{
            ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_EDIT, "employee", employeeService.getById(id));
            return mav.addObject("depId",employeeService.getById(id).getDepartmentId());
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/dep/empUpdate", method = RequestMethod.POST)
    public String update(@RequestParam(required = true) String name,
                         @RequestParam(required = true) String surname,
                         @RequestParam(required = true) Integer depId,
                         @RequestParam(required = true) Integer id){
        Employee updatedEmployee;
        try {
            updatedEmployee = employeeService.getById(id);
            updatedEmployee.setFirstName(name);
            updatedEmployee.setSecondName(surname);
            updatedEmployee.setDepartmentId(depId);
            employeeService.update(updatedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep/emp?depId="+depId;
    }

    @RequestMapping(value = "/dep/deleteEmp", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam(required = true) Integer id) {
        Employee employeeToDelete;
        try {
            employeeToDelete = employeeService.getById(id);
            Integer depId =employeeToDelete.getDepartmentId();
            employeeService.delete(employeeToDelete);
            return "redirect:/dep/emp?depId="+depId;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }



}
