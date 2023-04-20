package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Myprojectdata;
import com.example.demo.entity.Projectdetails;
import com.example.demo.repository.ProjectdetailsRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("project")
public class ProjectController {

	@Autowired
	ProjectdetailsRepo projectdetailsRepo;

	@PostMapping("setProjectDetails")
	public boolean setProjectDetails(@RequestBody Projectdetails details) {
		try {

			projectdetailsRepo.save(details);
			System.out.println(details);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@GetMapping("getAllProjects")
	public List<Projectdetails> getAllProjects() {
		try {
			List<Projectdetails> allprojects = projectdetailsRepo.findAll();
			return allprojects;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	@GetMapping("updateStatus{projectId}and{status}")
	public boolean updateStatus(@PathVariable int projectId, @PathVariable String status) {
		try {

			Projectdetails projectdetails = projectdetailsRepo.findById(projectId).get();
			projectdetails.setStatus(status);
			projectdetailsRepo.save(projectdetails);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("getProjectCnt")
	public Myprojectdata getProjectCnt()
	{
		try {
			Myprojectdata getcnt=projectdetailsRepo.getProject();
			return getcnt;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	

}
