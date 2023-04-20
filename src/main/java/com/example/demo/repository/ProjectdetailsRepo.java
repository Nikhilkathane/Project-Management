package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Myprojectdata;
import com.example.demo.entity.Projectdetails;

@Repository
public interface ProjectdetailsRepo extends JpaRepository<Projectdetails, Integer> {

	@Query(value = "select\r\n" + "(SELECT count(*) FROM myproject.projectdetails) as projectCnt,\r\n"
			+ "(SELECT count(*) FROM myproject.projectdetails where status='running') as runningCnt,\r\n"
			+ "(SELECT count(*) FROM myproject.projectdetails where status='closed') as closedCnt,\r\n"
			+ "(SELECT count(*) FROM myproject.projectdetails where status='cancelled') as cancelledCnt", nativeQuery = true)
	Myprojectdata getProject();

}
