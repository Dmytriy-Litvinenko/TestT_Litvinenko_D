package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.impl.DepartmentServiceImpl;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(required = true) Integer id) {
        try{
            return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", departmentService.getById(id));
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/depUpdate", method = RequestMethod.POST)
    public String update(@RequestParam(required = true) String name,
                         @RequestParam(required = true) Integer id) {
        Department updatedDepartment;
        try {
            updatedDepartment=departmentService.getById(id);
            updatedDepartment.setName(name);
            departmentService.update(updatedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/deleteDep", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam(required = true) Integer id) {
        Department departmentToDelete;
        try {
            departmentToDelete = departmentService.getById(id);
            departmentService.delete(departmentToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


}
