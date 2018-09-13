package com.dharma.spring.form.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dharma.spring.form.model.Product;

@Controller
public class ProductController {

	private Map<Integer, Product> products = null;

	@Autowired
	@Qualifier("productValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	public ProductController() {
		products = new HashMap<Integer, Product>();
	}

	@ModelAttribute("product")
	public Product createProductModel() {
		//direct to jsp page modal
		return new Product();
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.GET)
	public String saveProductPage(Model model) {
		return "productSave";
	}

	@RequestMapping(value = "/product/save.do", method = RequestMethod.POST)
	public String saveProductAction(
			@ModelAttribute("product") @Validated Product product,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "productSave";
		}
		model.addAttribute("product", product);
		products.put(product.getId(), product);
		return "productSaveSuccess";
	}
}
