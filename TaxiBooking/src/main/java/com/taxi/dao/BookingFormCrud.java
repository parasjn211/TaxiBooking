package com.taxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taxi.model.BookingForm;
import com.taxi.model.ContactForm;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm, Integer> {

	@Override
	public  <S extends BookingForm> S save(S entity) ;
	@Override
	public List<BookingForm> findAll();
	
	@Override
	public void deleteById(Integer id);
}
