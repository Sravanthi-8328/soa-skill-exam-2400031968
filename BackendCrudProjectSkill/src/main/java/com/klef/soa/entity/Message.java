package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="message")
public class Message {
          
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)	
	  @Column(name="messageid")
	  private Long messageId;
	  @Column(name="mname",nullable=false)
	  private String name;
	  @Column(name="mtype",nullable=false)
	  private String type;
	  @Column(name="mstatus",nullable=false)
	  private String status;
	  @Column(nullable=false)
	  private String location;
	  @CreationTimestamp
	  private LocalDateTime createdAt;
	  @UpdateTimestamp
	  private LocalDateTime updatedAt;
	  
	  
	  
	  
	  public Message() {
		  
	  }
	  
	  
	  
	  public Message(Long messageId, String name, String type, String status, String location, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.messageId = messageId;
		this.name = name;
		this.type = type;
		this.status = status;
		this.location = location;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	  public Long getMessageId() {
		  return messageId;
	  }
	  public void setMessageId(Long messageId) {
		  this.messageId = messageId;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getType() {
		  return type;
	  }
	  public void setType(String type) {
		  this.type = type;
	  }
	  public String getStatus() {
		  return status;
	  }
	  public void setStatus(String status) {
		  this.status = status;
	  }
	  public String getLocation() {
		  return location;
	  }
	  public void setLocation(String location) {
		  this.location = location;
	  }
	  public LocalDateTime getCreatedAt() {
		  return createdAt;
	  }
	  public void setCreatedAt(LocalDateTime createdAt) {
		  this.createdAt = createdAt;
	  }
	  public LocalDateTime getUpdatedAt() {
		  return updatedAt;
	  }
	  public void setUpdatedAt(LocalDateTime updatedAt) {
		  this.updatedAt = updatedAt;
	  }



	  @Override
	  public String toString() {
		return "Message [messageId=" + messageId + ", name=" + name + ", type=" + type + ", status=" + status
				+ ", location=" + location + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	  }
	  
	  
	  
	  
	  
	  
	  
}
