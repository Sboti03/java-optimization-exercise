package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JoinExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Employee> employees = IntStream.range(0, 10_000_000)
                .mapToObj(i -> new Employee(i, random.nextInt(1_000)))
                .toList();
        List<Department> departments = IntStream.range(0, 1_000)
                .mapToObj(i -> new Department(i, "name" + i))
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(employees, departments);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Employee> employees, List<Department> departments) {

        Map<Integer, Department> departmentMap = departments.stream()
                .collect(Collectors.toMap(Department::departmentId, Function.identity()));

        employees.forEach(employee -> {
            Department department = departmentMap.get(employee.departmentId);
            System.out.println(employee + "\t" + department);
        });
    }

    private record Employee(int employeeId, int departmentId) {
    }

    private record Department(int departmentId, String name) {
    }

}
