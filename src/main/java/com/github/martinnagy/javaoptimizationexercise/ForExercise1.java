package com.github.martinnagy.javaoptimizationexercise;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

public class ForExercise1 {
    public static void main(String[] args) {
        List<Department> departments = IntStream.range(0, 1_000)
                .mapToObj(i -> new Department(
                        i,
                        "name" + i,
                        IntStream.range(0, 100_000)
                                .mapToObj(j -> new Employee(j))
                                .toList()
                ))
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(departments);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Department> departments) {
        for (Department department : departments) {
            if (department.name().matches(".*2$")) {
                for (Employee employee : department.employees()) {
                    System.out.println(department.departmentId() + " " + employee.employeeId());
                }
            }
        }
    }

    private record Employee(int employeeId) {
    }

    private record Department(int departmentId, String name, List<Employee> employees) {
    }

}
