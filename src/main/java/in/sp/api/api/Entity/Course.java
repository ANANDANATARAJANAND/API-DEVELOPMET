package in.sp.api.api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="course")
public class Course {
    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private String code;
    private String description;
    private int credits;
    private String department;
    private String prerequisites;
    @Column(nullable = false)
    private Integer facultyId ;
}
