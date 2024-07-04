@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleService vehicleService;

    @Test
    public void getAllVehiclesTest() throws Exception {
        mockMvc.perform(get("/api/v1/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.totalElements").isNumber());
    }

    @Test
    public void getVehicleByIdTest() throws Exception {
        Long id = 1L; // Ganti dengan ID kendaraan yang valid
        mockMvc.perform(get("/api/v1/vehicles/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").isString());
    }

    // Tambahkan test untuk metode controller lainnya
}
