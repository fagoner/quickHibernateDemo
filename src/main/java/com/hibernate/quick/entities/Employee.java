package com.hibernate.quick.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String name;
 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Email> emails;

       
    public Employee() {
    	
    }
       
    
	public Employee(Long id, String name, List<Email> emails) {
		super();
		this.id = id;
		this.name = name;
		this.emails = emails;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
    
    
 
}