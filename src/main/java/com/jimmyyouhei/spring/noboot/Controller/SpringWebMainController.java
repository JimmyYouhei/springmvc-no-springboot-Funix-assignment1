package com.jimmyyouhei.spring.noboot.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmyyouhei.spring.noboot.entity.OddNumber;


@Controller
public class SpringWebMainController {
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@GetMapping("/printOdd")
	public String printOddPage(Model model) {
		
		List<OddNumber> from1To500OddNumberList = new ArrayList<>();
		
		for(int i=1; i<=500 ; i++) {
			
			if(i%2 !=0) {
				OddNumber thisOddNumber = new OddNumber();
				
				thisOddNumber.setValue(i);
				thisOddNumber.setDivisibleBy5(i%5 == 0);
				
				from1To500OddNumberList.add(thisOddNumber);
			}
		}
		
		model.addAttribute("OddNumberList", from1To500OddNumberList);
		
		return "printOdd";
		
	}
	
	@GetMapping("/fibonacci")
	public String fibonacciPage (Model model) {
		
		List<Integer> fibonacciList = new ArrayList<>();
		
		fibonacciList.add(0);
		fibonacciList.add(1);
		
		int recursion =1;
		
		while(recursion < 10946) {
			
			fibonacciList.add(recursion);
			
			recursion = recursion + fibonacciList.get(fibonacciList.size()-2);
		}
		
		model.addAttribute("fibonacciList", fibonacciList);
		
		return "fibonacci";
		
	}
	
	
	@GetMapping("/courseForm")
	public String courseFormPage() {
		
		return "courseForm";
		
	}
	
	@PostMapping("/show")
	public String showInforPage(@RequestParam("givenName")String givenName,
			@RequestParam("familyName")String familyName,
			@RequestParam("phoneNumber")String phoneNumber,
			@RequestParam("email")String email,
			@RequestParam(value="course" , required = false)String[] courses,
			Model model) {
		
		Boolean enrollIt = null;
		Boolean enrollEconomics = null;
		Boolean enrollHealth = null;
		
		if(courses != null) {
			enrollIt = Boolean.valueOf(Arrays.stream(courses).anyMatch("it"::equals));
			enrollEconomics = Boolean.valueOf(Arrays.stream(courses).anyMatch("economics"::equals));
			enrollHealth = Boolean.valueOf(Arrays.stream(courses).anyMatch("health"::equals));
		} else {
			enrollIt = Boolean.FALSE;
			enrollEconomics = Boolean.FALSE;
			enrollHealth = Boolean.FALSE;
		}
		
		model.addAttribute("givenName", givenName);
		model.addAttribute("familyName", familyName);
		model.addAttribute("phoneNumber", phoneNumber);
		model.addAttribute("email", email);
		model.addAttribute("enrollIt", enrollIt);
		model.addAttribute("enrollEconomics", enrollEconomics);
		model.addAttribute("enrollHealth", enrollHealth);
		
		return "showInfor";
		
		
		
	}
	
	
}

