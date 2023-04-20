package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reguser;
import com.example.demo.repository.ReguserRepo;

@RestController

@CrossOrigin("http://localhost:4200/")

@RequestMapping("Niks")
public class MyController {

	@Autowired
	ReguserRepo reguserRepo;

	@GetMapping("login{username}and{password}")
	public boolean loginUser(@PathVariable String username, @PathVariable String password) {

		try {

			int count = reguserRepo.countByUsername(username);
			System.out.println(count);
			if (count == 1) {

				Reguser dbreguser = reguserRepo.findByUsername(username);
				// System.out.println(dbreguser.getUsername().equals(user name) &&
				// dbreguser.getPassword().equals(password));
				if (dbreguser.getUsername().equals(username) && dbreguser.getPassword().equals(password))

					return true;

				else
					return false;
			}

			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@PostMapping("register")
	public boolean registration(@RequestBody Reguser reguser) {
		try {

			int count = reguserRepo.countByUsername(reguser.getUsername());
			if (count == 0) {
				reguserRepo.save(reguser);
				System.out.println(reguser);
				return true;
			} else

				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
