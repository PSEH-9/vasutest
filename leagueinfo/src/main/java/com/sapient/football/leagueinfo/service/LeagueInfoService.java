package com.sapient.football.leagueinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sapient.football.leagueinfo.model.Standing;

@Service
public class LeagueInfoService {

	@Autowired
	RestTemplate restTemplate;

	public static final String LEAGUE_BASE_URL = "https://apiv2.apifootball.com/?action=get_standings";

	List<Standing> result = new ArrayList<>();
	
	public List<Standing> getStandingsByCountryName(String countryName, String leagueId,String apiKey) {
		
		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(LEAGUE_BASE_URL)
		        // Add query parameter
		        .queryParam("league_id", leagueId)
		        .queryParam("country_name", countryName)
				.queryParam("APIKey", apiKey);		
		
		result = (List<Standing>) restTemplate.getForEntity(builder.buildAndExpand(LEAGUE_BASE_URL).toUri(), List.class);
		
		return result;
	}

	public List<Standing> getStandingsByTeamName(String teamName, String leagueId,String apiKey) {
		
		// Query parameters
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(LEAGUE_BASE_URL)
				        // Add query parameter
				        .queryParam("league_id", leagueId)
				        .queryParam("country_name", teamName)
						.queryParam("APIKey", apiKey);	
		result = (List<Standing>) restTemplate.getForEntity(LEAGUE_BASE_URL, List.class);
		
		return result;
	}

	public List<Standing> getStandingsByLeagueName(String leagueName,String apiKey) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(LEAGUE_BASE_URL)
		        // Add query parameter
		        .queryParam("league_id", leagueName)		        
				.queryParam("APIKey", apiKey);	
		
		List<Standing> result = (List<Standing>) restTemplate.getForEntity(LEAGUE_BASE_URL, List.class);
		
		return result;
	}

}
