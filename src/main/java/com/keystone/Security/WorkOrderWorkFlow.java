package com.keystone.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.keystone.Enum.WorkStatus;

@Component

public class WorkOrderWorkFlow {

	private final Map<WorkStatus,Set<WorkStatus>>transactions= new HashMap<>();
	
	public WorkOrderWorkFlow() {

	    transactions.put(WorkStatus.NEW,
	        new HashSet<>(Arrays.asList(WorkStatus.ASSIGNED,
	                                    WorkStatus.CANCELLED)));	
		transactions.put(WorkStatus.NEW, new HashSet<WorkStatus>(Arrays.asList(WorkStatus.ASSIGNED,
				WorkStatus.CANCELLED)));
		transactions.put(WorkStatus.ASSIGNED,new HashSet<WorkStatus>(Arrays.asList(WorkStatus.IN_PROGRESS
				,WorkStatus.CANCELLED)));
		transactions.put(WorkStatus.IN_PROGRESS,new HashSet<WorkStatus>(Arrays.asList(WorkStatus.COMPLETED,
				WorkStatus.ON_HOLD)));
		transactions.put(WorkStatus.ON_HOLD,new HashSet<WorkStatus>(Arrays.asList(WorkStatus.IN_PROGRESS,
				WorkStatus.CANCELLED)));
		transactions.put(WorkStatus.COMPLETED,new HashSet<WorkStatus>(Arrays.asList(WorkStatus.CLOSED)));
		
	transactions.put(WorkStatus.CLOSED,new HashSet<WorkStatus>());
	}
	public boolean isAllowed(WorkStatus from,WorkStatus to) {
	
		Set<WorkStatus>allowedStatus=transactions.get(from);
		
		if(allowedStatus ==null) {
			
			return false;
	}
	
	return allowedStatus.contains(to);}
	}

