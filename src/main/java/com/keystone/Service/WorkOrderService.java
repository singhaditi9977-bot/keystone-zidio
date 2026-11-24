package com.keystone.Service;

import java.util.List;

import com.keystone.DTO.AssignmentRequestDTO;
import com.keystone.DTO.WorkOrderDTO;
import com.keystone.Enum.WorkStatus;

public interface WorkOrderService {
	
	public WorkOrderDTO createWorkOrder(WorkOrderDTO workorder);
	
	public WorkOrderDTO getWorkOrder(Long id);
	
	public List<WorkOrderDTO>getAllWorkOrder();
	
	public WorkOrderDTO updateWO(Long id,WorkOrderDTO woDTO);
	
	public WorkOrderDTO updateWO(Long id,AssignmentRequestDTO assign);
	
	public WorkOrderDTO changeStatus(Long id,WorkStatus status,String performedBy);
	
	public 	void deleteWO(Long id);
}
