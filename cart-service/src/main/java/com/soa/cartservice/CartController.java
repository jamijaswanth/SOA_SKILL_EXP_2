package com.soa.cartservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@GetMapping("/cart")
	public Cart getCart() {

		return new Cart(101, List.of(1, 2, 3));
	}
}