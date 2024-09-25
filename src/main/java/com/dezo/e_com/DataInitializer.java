// import org.springframework.boot.ApplicationRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.transaction.annotation.Transactional;
//
// @Configuration
// public class DataInitializer {
//
//     private final InstructorRepository instructorRepository;
//
//     public DataInitializer(InstructorRepository instructorRepository) {
//         this.instructorRepository = instructorRepository;
//     }
//
//     @Bean
//     @Transactional
//     public ApplicationRunner initializeData() {
//         return args -> {
//             // Check if data already exists
//             if (instructorRepository.count() == 0) {
//                 // No data exists, insert initial data
//                 Instructor instructor = new Instructor("John Doe");
//                 instructorRepository.save(instructor);
//
//                 // Add more entities or related data if necessary
//             }
//         };
//     }
// }
