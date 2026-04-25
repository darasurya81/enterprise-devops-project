@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee emp) {
        return service.save(emp);
    }

    // Health API (for K8s + UI test)
    @GetMapping("/health")
    public String health() {
        return "Application is running";
    }
}