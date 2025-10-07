package primeGeneratorWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import primeGeneratorWeb.service.PrimeService;

import java.util.Set;

@Controller
public class PrimeController {

    private final PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @RequestMapping("/primes")
    public String showPrimes(@RequestParam(value = "pNumber", required = false) Integer pNumber) {
        return "primesForm";
    }

    @RequestMapping(value = "/getPrimes", method = RequestMethod.GET)
    public String getPrimes(Model model, @RequestParam("pNumber") Integer pNumber) {

        if (pNumber == null || pNumber < 2) {
            model.addAttribute("error", "Please enter a number greater than or equal to 2.");
            model.addAttribute("primes", null);
            return "primesForm";
        }

        int MAX_LIMIT = 10_000_000; // adjust as needed
        if (pNumber > MAX_LIMIT) {
            model.addAttribute("error", "The number is too large. Please enter a number below " + MAX_LIMIT + ".");
            model.addAttribute("primes", null);
            return "primesForm";
        }

        Set<Integer> primes = primeService.generatePrimes(pNumber);
        model.addAttribute("primes", primes);
        model.addAttribute("error", null);

        return "primesForm";
    }

    @RequestMapping(value = "/resetPrimes", method = RequestMethod.GET)
    public String resetPrimes(Model model) {
        model.addAttribute("primes", null);
        model.addAttribute("error", null);
        return "primesForm";
    }
}
