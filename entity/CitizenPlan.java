package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="citizen_insurance_info")
public class CitizenPlan {
	@Id
	private Integer citizenId;
	private String citizenName;
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmount;
	private String denialReason;
	private LocalDate terminateDate;
	private String terminationReason;
	
	public CitizenPlan() {
		super();
	}

	/**
	 * @return the citizenId
	 */
	public Integer getCitizenId() {
		return citizenId;
	}

	/**
	 * @param citizenId the citizenId to set
	 */
	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	/**
	 * @return the citizenName
	 */
	public String getCitizenName() {
		return citizenName;
	}

	/**
	 * @param citizenName the citizenName to set
	 */
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}

	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}

	/**
	 * @return the planStatus
	 */
	public String getPlanStatus() {
		return planStatus;
	}

	/**
	 * @param planStatus the planStatus to set
	 */
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the planStartDate
	 */
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * @param planStartDate the planStartDate to set
	 */
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	/**
	 * @return the planEndDate
	 */
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * @param planEndDate the planEndDate to set
	 */
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	/**
	 * @return the benefitAmount
	 */
	public Double getBenefitAmount() {
		return benefitAmount;
	}

	/**
	 * @param benefitAmount the benefitAmount to set
	 */
	public void setBenefitAmount(Double benefitAmount) {
		this.benefitAmount = benefitAmount;
	}

	/**
	 * @return the denialReason
	 */
	public String getDenialReason() {
		return denialReason;
	}

	/**
	 * @param denialReason the denialReason to set
	 */
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	/**
	 * @return the terminateDate
	 */
	public LocalDate getTerminateDate() {
		return terminateDate;
	}

	/**
	 * @param terminateDate the terminateDate to set
	 */
	public void setTerminateDate(LocalDate terminateDate) {
		this.terminateDate = terminateDate;
	}

	/**
	 * @return the terminationReason
	 */
	public String getTerminationReason() {
		return terminationReason;
	}

	/**
	 * @param terminationReason the terminationReason to set
	 */
	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CitizenPlan [citizenId=" + citizenId + ", citizenName=" + citizenName + ", planName=" + planName
				+ ", planStatus=" + planStatus + ", gender=" + gender + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", benefitAmount=" + benefitAmount + ", denialReason=" + denialReason
				+ ", terminateDate=" + terminateDate + ", terminationReason=" + terminationReason + "]";
	}
	
	
	

}
