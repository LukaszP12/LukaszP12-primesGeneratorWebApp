package primeGeneratorWeb.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrimes() throws Exception {
        mockMvc
                .perform(get("/primes"))
                .andExpect(view().name("primesForm"));
    }

    @Test
    public void getPrimes_input_30() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getPrimes").param("pNumber", "30"))
                .andExpect(MockMvcResultMatchers.model().attribute("primes", Matchers.contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)))
                .andExpect(view().name("primesForm"));
    }

    @Test
    public void getPrimes_input_50() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getPrimes").param("pNumber", "50"))
                .andExpect(MockMvcResultMatchers.model().attribute("primes", Matchers.contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)))
                .andExpect(view().name("primesForm"));
    }

    @Test
    public void getPrimes_input_300() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getPrimes").param("pNumber", "300"))
                .andExpect(MockMvcResultMatchers.model().attribute("primes", Matchers.contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                        37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                        79, 83, 89, 97, 101, 103, 107, 109, 113,
                        127, 131, 137, 139, 149, 151, 157, 163,
                        167, 173, 179, 181, 191, 193, 197, 199,
                        211, 223, 227, 229, 233, 239, 241, 251,
                        257, 263, 269, 271, 277, 281, 283, 293)))
                .andExpect(view().name("primesForm"));
    }

    @Test
    public void getPrimes_input_500() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getPrimes").param("pNumber", "500"))
                .andExpect(MockMvcResultMatchers.model().attribute("primes", Matchers.contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                        37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                        79, 83, 89, 97, 101, 103, 107, 109, 113,
                        127, 131, 137, 139, 149, 151, 157, 163,
                        167, 173, 179, 181, 191, 193, 197, 199,
                        211, 223, 227, 229, 233, 239, 241, 251,
                        257, 263, 269, 271, 277, 281, 283, 293,
                        307, 311, 313, 317, 331, 337, 347, 349,
                        353, 359, 367, 373, 379, 383, 389, 397,
                        401, 409, 419, 421, 431, 433, 439, 443,
                        449, 457, 461, 463, 467, 479, 487, 491, 499)))
                .andExpect(view().name("primesForm"));
    }

}
