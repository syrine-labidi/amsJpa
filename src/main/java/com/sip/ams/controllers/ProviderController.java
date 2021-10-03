package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;
import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping("/provider/")
public class ProviderController {
	private final ProviderRepository providerRepository;

	//injection une dependence + IOC (inversion of control)
	@Autowired
	// constructeur (nomClass + non type retour )
	// param de type interface
	public ProviderController(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@GetMapping("list")
	// @ResponseBody
	public String listProviders(Model model) {
		
		model.addAttribute("providers", providerRepository.findAll());
		return "provider/listProviders";

	}

	
}
