package dojosAndNinjas.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="ninjas")
public class Ninja {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private int age;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="dojo_id")
 private Dojo dojo;
 @Transient
 private Long dojo_id;
 
 
 public Ninja() {
     
 }
 
 public Ninja(String firstName, String lastName, int age, Dojo d) {
	 this.firstName= firstName;
	 this.lastName = lastName;
	 this.age = age;
	 this.dojo = d;
	 
 }
 public Ninja (Long id, String firstName, String lastName, int age, Dojo d) {
	 this.id = id;
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.age= age;
	 this.dojo= d;
	 
 }
 
 
 public Ninja (Long id, String firstName, String lastName, int age, Long dojo_id) {
	 this.id = id;
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.age= age;
	 this.dojo_id= dojo_id;
	 
 }


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public Long getDojo_id() {
	return dojo_id;
}

public void setDojo_id(Long dojo_id) {
	this.dojo_id = dojo_id;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public Dojo getDojo() {
	return dojo;
}

public void setDojo(Dojo dojo) {
	this.dojo = dojo;
}

}