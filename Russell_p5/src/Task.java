
public class Task {
	private String title, description;
	private String dateDue;
	private String isMarked;
	
	public Task() {
		
	}

	//Takes in the file string and parses it appropriately
	public Task(String parseString) {
		String[] splitParse = parseString.split("\t");
		
		title = splitParse[0];
		description = splitParse[1];
		dateDue = splitParse[2];
		
		if(splitParse.length == 4) 
			isMarked = splitParse[3];
		else
			isMarked = "";
	}
	
	public Task(String title, String description, String dateDue) {
		this.title = title;
		this.description = description;
		this.dateDue = dateDue;
		this.isMarked = "";
	}
	
	public Task(String title, String description, String dateDue, String isMarked) {
		this.title = title;
		this.description = description;
		this.dateDue = dateDue;
		this.isMarked = isMarked;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if(title.length() < 1) {
			System.out.println("INVALID TITLE; could not create");
			return;
		}
		
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateDue() {
		return dateDue;
	}

	public void setDateDue(String dateDue) {
		String[] splitDate = dateDue.split("-");
		if(splitDate.length == 3) {
			if(splitDate[0].length() == 4 && splitDate[1].length() == 2 && splitDate[2].length() == 2) 
				this.dateDue = dateDue;
		}
		else
			System.out.println("INVALID DATE");
	}

	public String isMarked() {
		return isMarked;
	}

	public void setMarked(String isMarked) {
		this.isMarked = isMarked;
	}
	
	public String toFileString() {
		//using the tab as a separator to make parsing easier when loading
		return title+"\t"+description+"\t"+dateDue+"\t"+isMarked;
	}
	
	public String toPrintString() {
		return isMarked + "["+dateDue+"] " + title + ": " + description;
	}
}
