package com.adel2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService FortuneService;
	
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.FortuneService = fortuneService;
	}

	public TrackCoach() {
	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do it: " + FortuneService.getFortune();
	}
}
