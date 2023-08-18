package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.amartek.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e.id FROM Employee e WHERE numberphone = ?1 ")
    public Integer findIdByPhoneNumber(String phonenumber);
}
