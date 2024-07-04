@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(Integer limit, Integer offset) {
    if (limit != null && offset != null) {
        return vehicleRepository.findAll(PageRequest.of(offset, limit)).getContent();
    } else if (limit != null) {
        return vehicleRepository.findAll(Sort.by("id").limit(limit));
    } else {
        return vehicleRepository.findAll();
    }
}

public Optional<Vehicle> getVehicleById(Long id) {
    return vehicleRepository.findById(id);
}

public Vehicle createVehicle(Vehicle vehicle) {
    // Set created_at timestamp
    vehicle.setCreatedAt(LocalDateTime.now());
    return vehicleRepository.save(vehicle);
}

public Optional<Vehicle> updateVehicle(Long id, Vehicle vehicle) {
    return vehicleRepository.findById(id)
            .map(existingVehicle -> {
                // Update existing vehicle properties
                existingVehicle.setName(vehicle.getName());
                existingVehicle.setType(vehicle.getType());
                existingVehicle.setYear(vehicle.getYear());
                existingVehicle.setPrice(vehicle.getPrice());
                
                // Set updated_at timestamp
                existingVehicle.setUpdatedAt(LocalDateTime.now());
                return vehicleRepository.save(existingVehicle);
            });
}

public void deleteVehicle(Long id) {
    vehicleRepository.deleteById(id);
}

