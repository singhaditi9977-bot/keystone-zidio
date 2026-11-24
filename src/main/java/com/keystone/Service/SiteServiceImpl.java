package com.keystone.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keystone.DTO.SiteDTO;
import com.keystone.Entity.Customer;
import com.keystone.Entity.Site;
import com.keystone.Repositery.CustomerRespositery;
import com.keystone.Repositery.SiteRepositery;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
	
	@Autowired
	private SiteRepositery siteRepo;

	@Autowired
	private CustomerRespositery customerRepo;
	
	
	public SiteDTO createSite(SiteDTO site) {
	
		Customer customer = customerRepo.findById(site.getCustomerId())
				.orElseThrow(()->new RuntimeException("Customer not found"));
		Site sites = new Site();
		sites.setSiteName(site.getSiteName());
		sites.setBuildingName(site.getBuildingName());
		sites.setRoomNo(site.getRoomNo());
		sites.setFloorNo(site.getFloorNo());
		sites.setLanNo(site.getRoomNo());
		sites.setCityname(site.getCityName());
		sites.setStateName(site.getStateName());
		sites.setCountryname(site.getCountryName());
		sites.setZipCode(site.getZipCode());
		sites.setCustomer(customer);
		siteRepo.save(sites);

		return mapToDTO(sites);
		}
	public SiteDTO updateSite(Long id, SiteDTO dtos) {
		Site site=siteRepo.findById(id).orElseThrow(()-> new RuntimeException("Site not found"));
		site.setStateName(dtos.getStateName());
		site.setCityname(dtos.getCityName());
		site.setStateName(dtos.getStateName());
		site.setCountryname(dtos.getCountryName());
		site.setZipCode(dtos.getZipCode());
		
		siteRepo.save(site);
		
		return mapToDTO(site);
	}
	
	public SiteDTO getSite(Long id) {
		Site site= siteRepo.findById(id).orElseThrow(()-> new RuntimeException("Site not found"));
		
		return mapToDTO(site);
		
	}
	@Override
	public List<SiteDTO> getAllSite(Long customerId) {
	    return new ArrayList<>();
	}
	
	private SiteDTO mapToDTO(Site site) {
		
		SiteDTO dto = new SiteDTO();
		dto.setBuildingName(site.getBuildingName());
		dto.setBuildingNo(site.getBuildingNo());
		dto.setFloorNo(site.getFloorNo());
		dto.setRoomNo(site.getRoomNo());
		dto.setSiteName(site.getSiteName());
		dto.setCityName(site.getCityname());
		dto.setStateName(site.getStateName());
		dto.setCountryName(site.getCountryname());
		dto.setZipCode(site.getZipCode());
		dto.setCustomerId(site.getCustomer().getId());
		
		return dto;
		
	}
	@Override
	public SiteDTO updatesite(Long siteId, SiteDTO sites) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SiteDTO getsite(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteSite(Long id) {
		// TODO Auto-generated method stub
		
	}
	}
