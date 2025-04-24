package com.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxi.model.BookingForm;
import com.taxi.service.AdminCredentialsService;
import com.taxi.service.BookingFormService;
import com.taxi.service.ContactFormService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	private ContactFormService contactFormService;
	private AdminCredentialsService adminCredentialsService;
	private BookingFormService bookingFormService;
	
	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}
	@Autowired
	public void setAdminCredentialsService(AdminCredentialsService adminCredentialsService) {
		this.adminCredentialsService = adminCredentialsService;
	}
	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}
	@GetMapping("/dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}
	@GetMapping("/readAllContacts")
	public String readAllContacts(Model model) {
		
		model.addAttribute("allcontacts",
				contactFormService.readAllContactsService());
		return "admin/readallcontacts";
	}
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable int id, RedirectAttributes redirectAttributes) {
		contactFormService.deleteContactService(id);
		redirectAttributes.addFlashAttribute("message", "CONTACT DELETED SUCCESSFULLY");
		return "redirect:/admin/readAllContacts";
	}
	@GetMapping("changeCredentials")
	public String changeCredentialsView() {
		return "admin/changecredentials";
	}
	@PostMapping("changeCredentials")
	public String changeCredentials(
			@RequestParam("oldusername") String oldusername,
			@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newusername") String newusername,
			@RequestParam("newpassword") String newpassword,
			RedirectAttributes redirectAttributes
			) {
		
		String result = adminCredentialsService.checkAdminCredentials(oldusername, oldpassword);
		System.out.println(result);
		if(result.equals("SUCCESS")) {
			result = adminCredentialsService.updateAdminCredentials(oldusername, newusername, newpassword);
		
			redirectAttributes.addFlashAttribute("message", result);
	
		}else {
			redirectAttributes.addFlashAttribute("message", result);
			
		}
		return "redirect:/admin/dashboard";
	}
	@GetMapping("/readAllBookings")
	public String readAllBookings(Model model) {
		List<BookingForm> allBookingService =bookingFormService.readAllBookingsService();
		System.out.println(allBookingService);
		model.addAttribute("allBookings",
				bookingFormService.readAllBookingsService());
		return "admin/readallbookings";
	}
	@GetMapping("/deleteBooking/{id}")
	public String deleteBooking(@PathVariable int id, RedirectAttributes redirectAttributes) {
		bookingFormService.deleteBookingService(id);
		redirectAttributes.addFlashAttribute("message", "BOOKING DELETED SUCCESSFULLY");
		return "redirect:/admin/readAllBookings";
	}
	@GetMapping("/addService")
	public String addServiceView() {
		return "admin/addservice";
	}
}
