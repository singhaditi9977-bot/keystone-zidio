package com.keystone.Service;

import java.util.List;

import com.keystone.DTO.SiteDTO;

public interface SiteService {

	public SiteDTO createSite(SiteDTO site);
	
	public SiteDTO updatesite(Long siteId,SiteDTO sites);
	
	public SiteDTO getsite(Long id);
	
	public List<SiteDTO>getAllSite(Long customerId);
	
	public void deleteSite(Long id);
}
