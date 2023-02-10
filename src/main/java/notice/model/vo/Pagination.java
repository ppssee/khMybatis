package notice.model.vo;

public class Pagination {
	private int currentPage;
	private int recordCountPerPage = 10;
	private int start;
	private int end;
	
	public Pagination() {}
	
	public Pagination(int currentPage, int recordCountPerPage) {
		super();
		this.currentPage = currentPage;
		this.recordCountPerPage = recordCountPerPage;
		this.start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		this.end = currentPage * recordCountPerPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	
	
}
