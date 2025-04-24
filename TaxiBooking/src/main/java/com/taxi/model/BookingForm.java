package com.taxi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="bookingform")
public class BookingForm {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Name cannot be empty")
	@NotBlank(message="Name cannot be blank")
	@Size(min=2, max=30, message="Invalid name length")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only alphabets")
	@Column(length = 30)
	private String name;
	
	@NotEmpty(message="Source cannot be empty")
	@NotBlank(message="Source cannot be blank")
	@Size(min=2, max=100, message="Invalid source length")
	@Column(length = 100)
	private String source;
	
	@NotEmpty(message="Email cannot be empty")
	@NotBlank(message="Email cannot be blank")
	@Size(min=8, max=50, message="Invalid email length")
	@Column(length = 50)
	private String email;
	
	@NotEmpty(message="Destination cannot be empty")
	@NotBlank(message="Destination cannot be blank")
	@Size(min=2, max=100, message="Invalid destination length")
	@Column(length = 100)
	private String destination;
	
	@NotNull(message="Time cannot be empty")
	private LocalTime time;
	
	@NotNull(message="Date cannot be empty")
	private LocalDate date;
	
	@NotEmpty(message="Comfort cannot be empty")
	@Size(min=2, max=20, message="Invalid comfort length")
	@Column(length = 20)
	private String comfort;
	
	@Min(value=1, message="Adult can be at least 1")
	@Max(value=4, message="Adult can be at most 4")
	private int adults;

	@Max(value=3, message="Children can be at most 3")
	private int children;

	@NotEmpty(message="Message cannot be empty")
	@NotBlank(message="Message cannot be blank")
	@Size(min=2, max=2000, message="Invalid message length")
	@Column(length = 2000)
	private String message ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getComfort() {
		return comfort;
	}
	public void setComfort(String comfort) {
		this.comfort = comfort;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookingForm(int id, String name, String source, String email, String destination, LocalTime time, LocalDate date,
			String comfort, int adults, int children, String message) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.email = email;
		this.destination = destination;
		this.time = time;
		this.date = date;
		this.comfort = comfort;
		this.adults = adults;
		this.children = children;
		this.message = message;
	}
	@Override
	public String toString() {
		return "BookingForm [id=" + id + ", name=" + name + ", from=" + source + ", email=" + email + ", to=" + destination
				+ ", time=" + time + ", date=" + date + ", comfort=" + comfort + ", adults=" + adults + ", children="
				+ children + ", message=" + message + "]";
	}
	public BookingForm() {
		super();
	}
	
}
