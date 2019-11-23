package com.sapient.football.leagueinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.leagueinfo.model.Standing;
import com.sapient.football.leagueinfo.service.LeagueInfoService;

@RestController
public class LeagueInfoController {
	
	@Autowired
	
	LeagueInfoService LeagueInfoService;
	
	@RequestMapping(value = "/country")
	public @ResponseBody List<Standing> getStandingsByCountryName(@RequestParam String countryName,@RequestParam String leagueId,@RequestParam String apiKey) {
		
		List<Standing> result = LeagueInfoService.getStandingsByCountryName(countryName, leagueId, apiKey);
		
		return result;
		
	}
	
	@RequestMapping(value = "/team")
	public  @ResponseBody List<Standing>  getStandingsByTeamName(@RequestParam String teamName,@RequestParam String leagueId,@RequestParam String apiKey) {
		
		List<Standing> result = LeagueInfoService.getStandingsByTeamName(teamName, leagueId, apiKey);
				
				return result;
		
	}
	
	@RequestMapping(value = "/league")
	public  @ResponseBody List<Standing>  getStandingsByLeaguName(@RequestParam String LeagueName,@RequestParam String apiKey) {
		
		List<Standing> result = LeagueInfoService.getStandingsByLeagueName(LeagueName, apiKey);
		
		return result;
		
	}
	
	
	

}
