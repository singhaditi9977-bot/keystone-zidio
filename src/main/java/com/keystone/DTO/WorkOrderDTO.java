package com.keystone.DTO;

import java.time.LocalDateTime;

import com.keystone.Enum.WorkStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderDTO {

	public Long id;
	public String WorkOrderCode;
	public String title;
	public String description;
	public String priority;
	public WorkStatus status;
	public Long customerid;
	public Long siteId;
	public Long technicianId;
	public LocalDateTime slaDueDate;
	public LocalDateTime creatwdtAt;
	public LocalDateTime updateAt;
}