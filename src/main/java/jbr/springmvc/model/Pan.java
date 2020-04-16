package jbr.springmvc.model;

public class Pan {
	private String panNo;
	
	private Double score;
	
	public Pan() {}

	public Pan(String panNo, Double score) {
		this.panNo = panNo;
		this.score = score;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	

	 
}
