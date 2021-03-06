package com.codingdojo.repasoexamen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.repasoexamen.models.Event;
import com.codingdojo.repasoexamen.repositories.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepo;

	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	public Event create(Event e) {
		return eventRepo.save(e);
	}

	public List<Event> getAll() {
		return (List<Event>) eventRepo.findAll();
	}

	public Event getOne(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		return event.isPresent() ? event.get() : null;
	}

	public Event update(Event toUpdate) {
		return eventRepo.save(toUpdate);
	}
}
