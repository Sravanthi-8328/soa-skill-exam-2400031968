package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Message;
import com.klef.soa.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService service;
	@GetMapping
	public  String test() {
		return "SOA Programming and services";
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<Message>> displayAllMessages(){
		List<Message> message=service.displayAllMessages();
		return ResponseEntity.status(200).body(message);
	}
	@PostMapping("/add")
	public ResponseEntity<Message> addMessage(@RequestBody Message  message){
		Message m= service.addMessage(message);
		return ResponseEntity.status(200).body(m);
		
	}
	 @GetMapping("/display")
	   public ResponseEntity<?> displayMessageById(@RequestParam Long id)
	   {
		   Message m=service.displayMessageById(id);
		   if(m!=null) {
			   return ResponseEntity.status(200).body(m);
		   }
		   else {
			   return ResponseEntity.status(404).body("Message Id not found");
		   }
	   }
	 @PutMapping("/update")
	 public ResponseEntity<?>updateMessage(@RequestBody Message m)
	   {
		   Message updatedMessage=service.updateMessage(m);
		   if(updatedMessage!=null) {
			   return ResponseEntity.ok(m);
		   }
		   else {
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message Id Not Found");
		   }
	   }
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<String> deleteMessageById(@PathVariable Long id)
	   {
		   String message = service.deleteMessageById(id);
		   return new ResponseEntity<>(message, HttpStatus.OK);
	   }
	   @GetMapping("/displaybyName/{name}")
	   public ResponseEntity<List<Message>> displayMessageByName(@PathVariable String name)
	   {
	  	   List<Message>m=service.displayMessageByName(name);
	  			   return ResponseEntity.status(200).body(m);
	   }
	   @GetMapping("/displaybyType/{type}")
	   public ResponseEntity<List<Message>> displayMessageByType(@PathVariable String type)
	   {
	  	   List<Message>m=service.displayMessageByType(type);
	  			   return ResponseEntity.status(200).body(m);
	   }
           
}
