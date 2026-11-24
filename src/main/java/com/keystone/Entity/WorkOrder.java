package com.keystone.Entity;

import java.time.LocalDateTime;

import com.keystone.Enum.Priority;
import com.keystone.Enum.WorkStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	@Column(length=5000)
	private String description;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private WorkStatus workstatus;
	
	@Column(name="customerId",nullable= false)
	private Long customerid;
	
	@Column(name="site_id",nullable=false)
	private Long siteId;
	
	@Column (name="technician_id",nullable=false)
	private long technicianId;
	
	private LocalDateTime createAt;
	private LocalDateTime slaDueDate;
	private LocalDateTime updateeAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public WorkStatus getWorkstatus() {
		return workstatus;
	}
	public void setWorkstatus(WorkStatus workstatus) {
		this.workstatus = workstatus;
	}
	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public long getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(long technicianId) {
		this.technicianId = technicianId;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getSlaDueDate() {
		return slaDueDate;
	}
	public void setSlaDueDate(LocalDateTime slaDueDate) {
		this.slaDueDate = slaDueDate;
	}
	public LocalDateTime getUpdateeAt() {
		return updateeAt;
	}
	public void setUpdateeAt(LocalDateTime updateeAt) {
		this.updateeAt = updateeAt;
	}
	
	
}
