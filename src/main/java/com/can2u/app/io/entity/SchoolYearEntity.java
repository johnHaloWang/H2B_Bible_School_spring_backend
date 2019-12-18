package com.can2u.app.io.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "school_years")
public class SchoolYearEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(length = 30, nullable = false)
	private String schoolYearId;

	@Column(nullable = false)
	private String schoolYear;
	
	@Column(nullable = false)
	private String schoolPeriod;
	
	@Column(nullable = false)
	private Boolean isQuarterTerm = false;
	
	@Column(nullable = false)
	private Boolean issemesterTerm = false;
	
	@ManyToOne
	@JoinColumn(name = "courses_id")
	@JsonIgnore
	private List<CourseEntity> courseDetials;
	
	
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchoolYearId() {
		return schoolYearId;
	}

	public void setSchoolYearId(String schoolYearId) {
		this.schoolYearId = schoolYearId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getSchoolPeriod() {
		return schoolPeriod;
	}

	public void setSchoolPeriod(String schoolPeriod) {
		this.schoolPeriod = schoolPeriod;
	}

	public Boolean getIsQuarterTerm() {
		return isQuarterTerm;
	}

	public void setIsQuarterTerm(Boolean isQuarterTerm) {
		this.isQuarterTerm = isQuarterTerm;
	}

	public Boolean getIssemesterTerm() {
		return issemesterTerm;
	}

	public void setIssemesterTerm(Boolean issemesterTerm) {
		this.issemesterTerm = issemesterTerm;
	}

	private Date create_At;
    private Date update_At;
	
    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.update_At = new Date();
    }
    
	public Date getCreate_At() {
		return create_At;
	}

	public void setCreate_At(Date create_At) {
		this.create_At = create_At;
	}

	public Date getUpdate_At() {
		return update_At;
	}

	public void setUpdate_At(Date update_At) {
		this.update_At = update_At;
	}

}
