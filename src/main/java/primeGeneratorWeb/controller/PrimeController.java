package primeGeneratorWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import primeGeneratorWeb.service.PrimeService;
import primeGeneratorWeb.service.PrimeServiceImpl;

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
        Set<Integer> primes = primeService.getPrimes(pNumber);
        model.addAttribute("primes", primes);

        return "primesForm";
    }

    @RequestMapping(value = "/resetPrimes", method = RequestMethod.GET)
    public String resetPrimes(Model model) {
        model.addAttribute("primes", null);

        return "primesForm";
    }

}
