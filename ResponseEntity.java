@GetMapping
public ResponseEntity<Page<Vehicle>> getAllVehicles(
        @RequestParam(required = false) Integer limit,
        @RequestParam(required = false) Integer offset,
        @RequestParam(required = false) Long brandId) {
    Pageable pageable = Pageable.of(offset, limit);
    Page<Vehicle> vehicles;
    if (brandId != null) {
        vehicles = vehicleRepository.findByTypeBrandId(brandId, pageable);
    } else {
        vehicles = vehicleRepository.findAll(pageable);
    }
    return ResponseEntity.ok(vehicles);
}
