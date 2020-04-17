package com.ksoft.data

import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeDAO {
    private val empMap: MutableMap<String, Employee> = mutableMapOf();

    init {
        val emp1 = Employee("E01", "Smith", "Clerk")
        val emp2 = Employee("E02", "Allen", "Salesman")
        val emp3 = Employee("E03", "Jones", "Manager")
        empMap[emp1.id] = emp1
        empMap[emp2.id] = emp2
        empMap[emp3.id] = emp3
    }

    fun getEmployee(empNo: String): Employee? {
        return empMap[empNo]
    }

    fun addEmployee(emp: Employee): Employee? {
        empMap[emp.id] = emp
        return emp
    }

    fun updateEmployee(emp: Employee): Employee? {
        empMap[emp.id] = emp
        return emp
    }

    fun deleteEmployee(empNo: String) {
        empMap.remove(empNo)
    }

    fun getAllEmployees(): List<Employee>? {
        val c: Collection<Employee> = empMap.values
        val list: MutableList<Employee> = ArrayList()
        list.addAll(c)
        return list
    }
}