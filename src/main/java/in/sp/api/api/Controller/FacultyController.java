package in.sp.api.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.api.api.Entity.Faculty;
import in.sp.api.api.Repository.FacultyRepository;
import in.sp.api.api.Service.FacultyService;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
     @Autowired
     private final FacultyRepository facultyRepo;
     @Autowired
     private final FacultyService facultyService;

    public FacultyController(FacultyRepository facultyRepo, FacultyService facultyService) {
        this.facultyRepo = facultyRepo;
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        try {
            List<Faculty> faculties = facultyRepo.findAll();
            return new ResponseEntity<>(faculties, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public  Optional<Faculty> getFaculty(@PathVariable int id) {
                return facultyRepo.findById(id);

    }

    @PostMapping
    public ResponseEntity<?> createFaculty(@RequestBody Faculty faculty) {
        try {
            if (faculty.getId() > 0 && facultyRepo.existsById(faculty.getId())) {
                return new ResponseEntity<>("Faculty with ID " + faculty.getId() + " already exists", HttpStatus.CONFLICT);
            }
            Faculty savedFaculty = facultyService.createFaculty(faculty);
            return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating faculty: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
public Faculty updateFaculty(@PathVariable int id, @RequestBody Faculty faculty) {
    faculty.setId(id);
    return facultyRepo.save(faculty);
}



    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable int id) {
            facultyRepo.deleteById(id);

      }
    
}
