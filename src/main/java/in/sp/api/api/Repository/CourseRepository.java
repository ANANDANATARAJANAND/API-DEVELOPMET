package in.sp.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.api.api.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
