package com.wang.dao;

import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static { //static先加载，所以无法调用员工部门dao
        employees = new HashMap<Integer,Employee>();//创建一个运功表

        employees.put(1001, new Employee(1001, "AA", "231212342@qq.com", 0, new Department(101,"教学部")));
        employees.put(1002, new Employee(1002, "BB", "413422432@qq.com", 1, new Department(102,"教研部")));
        employees.put(1003, new Employee(1003, "CC", "432423532@qq.com", 0, new Department(103,"市场部")));
        employees.put(1004, new Employee(1004, "DD", "346546546@qq.com", 1, new Department(104,"运营部")));
        employees.put(1005, new Employee(1005, "EE", "765867876@qq.com", 0, new Department(105,"后勤部")));
    }


    //组件自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
