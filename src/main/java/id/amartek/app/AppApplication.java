package id.amartek.app;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import id.amartek.app.model.Department;
import id.amartek.app.model.Employee;
import id.amartek.app.model.Region;
import id.amartek.app.repository.DepartmentRepository;
import id.amartek.app.repository.RegionRepository;
import id.amartek.app.service.RegionServices;
import id.amartek.app.service.implementation.DepartmentServicesImpl;
import id.amartek.app.service.implementation.RegionServicesImpl;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppApplication.class, args);
	}
}
