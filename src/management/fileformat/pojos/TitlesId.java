package management.fileformat.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TitlesId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TitlesId implements java.io.Serializable {

	// Fields

	private Integer empNo;
	private String title;
	private Date fromDate;

	// Constructors

	/** default constructor */
	public TitlesId() {
	}

	/** full constructor */
	public TitlesId(Integer empNo, String title, Date fromDate) {
		this.empNo = empNo;
		this.title = title;
		this.fromDate = fromDate;
	}

	// Property accessors

	@Column(name = "emp_no", nullable = false)
	public Integer getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", nullable = false, length = 10)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TitlesId))
			return false;
		TitlesId castOther = (TitlesId) other;

		return ((this.getEmpNo() == castOther.getEmpNo()) || (this.getEmpNo() != null
				&& castOther.getEmpNo() != null && this.getEmpNo().equals(
				castOther.getEmpNo())))
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null
						&& castOther.getTitle() != null && this.getTitle()
						.equals(castOther.getTitle())))
				&& ((this.getFromDate() == castOther.getFromDate()) || (this
						.getFromDate() != null
						&& castOther.getFromDate() != null && this
						.getFromDate().equals(castOther.getFromDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEmpNo() == null ? 0 : this.getEmpNo().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getFromDate() == null ? 0 : this.getFromDate().hashCode());
		return result;
	}

}