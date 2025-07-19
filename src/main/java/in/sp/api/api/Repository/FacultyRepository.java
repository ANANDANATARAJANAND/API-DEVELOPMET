package in.sp.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.sp.api.api.Entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    
    @Modifying
    @Query(value = "INSERT INTO faculty (id, firstname, lastname, email, department, specialization, officelocation, officehours) VALUES (:id, :firstName, :lastName, :email, :department, :specialization, :officeLocation, :officeHours)", nativeQuery = true)
    @Transactional
    void insertWithId(@Param("id") int id, 
                     @Param("firstName") String firstName,
                     @Param("lastName") String lastName,
                     @Param("email") String email,
                     @Param("department") String department,
                     @Param("specialization") String specialization,
                     @Param("officeLocation") String officeLocation,
                     @Param("officeHours") String officeHours);
}
