package model;

public class Player {

	
	private int numOfPlayedGames = 0;	
	private int percentageOfWins = 0;
	private int currentStreak = 0;
	private int maxStreak = 0;
	private int totalWins = 0;
	
//	public Player (int numOfPlayedGames, int percentageOfWins, int currentStreak, int maxStreak, int totalWins) {
//		this.numOfPlayedGames = numOfPlayedGames;
//		this.percentageOfWins = percentageOfWins;
//		this.currentStreak = currentStreak;
//		this.maxStreak = maxStreak;
//		this.totalWins = totalWins;
//	}
//	
	public Player() {
		
	}

	public int getNumOfPlayedGames() {
		return numOfPlayedGames;
	}
	
	public void setNumOfPlayedGames(int numOfPlayedGames) {
		this.numOfPlayedGames = numOfPlayedGames;
	}

	public int getPertengeOfWins() {
		return percentageOfWins;
	}

	public void setPercentageOfWins(int percentageOfWins) {
		this.percentageOfWins = percentageOfWins;
	}

	public int getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
	}

	public int getMaxStreak() {
		return maxStreak;
	}

	public void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
	}
	
	public int getTotalWins() {
		return totalWins;
	}

	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}

	
}
