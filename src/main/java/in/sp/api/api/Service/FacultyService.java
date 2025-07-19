package in.sp.api.api.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sp.api.api.Entity.Faculty;
import in.sp.api.api.Repository.FacultyRepository;

@Service
public class FacultyService {
    
    private final FacultyRepository facultyRepository;
    
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    @Transactional
    public Faculty createFaculty(Faculty faculty) {
        if (faculty.getId() > 0) {
            // Use direct SQL insert for explicit ID
            facultyRepository.insertWithId(
                faculty.getId(),
                faculty.getFirstName(),
                faculty.getLastName(),
                faculty.getEmail(),
                faculty.getDepartment(),
                faculty.getSpecialization(),
                faculty.getOfficeLocation(),
                faculty.getOfficeHours()
            );
            return faculty;
        } else {
            // Let JPA handle auto-increment
            return facultyRepository.save(faculty);
        }
    }
}
