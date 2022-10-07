package uk.gov.di.ipv.cri.drivingpermit.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.di.ipv.cri.common.library.annotations.ExcludeFromGeneratedCoverageReport;
import uk.gov.di.ipv.cri.common.library.domain.personidentity.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExcludeFromGeneratedCoverageReport
public class DrivingPermitForm {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String TIME_ZONE = "UTC";

    @JsonProperty private String drivingLicenceNumber;
    @JsonProperty private String postcode;
    @JsonProperty private String issueNumber;

    @JsonProperty private String licenceIssuer;

    @JsonProperty private String surname;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> forenames;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Address> addresses;

    @JsonFormat(pattern = DATE_FORMAT, timezone = TIME_ZONE)
    private LocalDate dateOfBirth;

    @JsonFormat(pattern = DATE_FORMAT, timezone = TIME_ZONE)
    private LocalDate issueDate;

    @JsonFormat(pattern = DATE_FORMAT, timezone = TIME_ZONE)
    public LocalDate dateOfIssue;

    @JsonFormat(pattern = DATE_FORMAT, timezone = TIME_ZONE)
    private LocalDate expiryDate;

    public DrivingPermitForm() {}

    @JsonCreator
    public DrivingPermitForm(
            @JsonProperty(value = "surname", required = true) String surname,
            @JsonProperty(value = "forenames", required = true) List<String> forenames,
            @JsonProperty(value = "dateOfBirth", required = true) LocalDate dateOfBirth,
            @JsonProperty(value = "issueDate", required = false) LocalDate issueDate,
            @JsonProperty(value = "expiryDate", required = true) LocalDate expiryDate,
            @JsonProperty(value = "licenceIssuer", required = true) String licenceIssuer,
            @JsonProperty(value = "drivingLicenceNumber", required = true)
                    String drivingLicenceNumber,
            @JsonProperty(value = "issueNumber", required = false) String issueNumber,
            @JsonProperty(value = "postcode", required = true) String postcode) {
        this.surname = surname;
        this.forenames = forenames;
        this.dateOfBirth = dateOfBirth;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.licenceIssuer = licenceIssuer;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.issueNumber = issueNumber;
        this.postcode = postcode;
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setPostalCode(postcode);
        addresses.add(address);
        this.addresses = addresses;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getForenames() {
        return forenames;
    }

    public void setForenames(List<String> forenames) {
        this.forenames = forenames;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getLicenceIssuer() {
        return licenceIssuer;
    }

    public void setLicenceIssuer(String licenceIssuer) {
        this.licenceIssuer = licenceIssuer;
    }

    @Override
    public String toString() {
        return "DrivingPermitForm{"
                + "drivingLicenceNumber='"
                + drivingLicenceNumber
                + '\''
                + ", postcode='"
                + postcode
                + '\''
                + ", issueNumber='"
                + issueNumber
                + '\''
                + ", surname='"
                + surname
                + '\''
                + ", forenames="
                + forenames
                + ", addresses="
                + addresses
                + ", dateOfBirth="
                + dateOfBirth
                + ", expiryDate="
                + expiryDate
                + ", issueDate="
                + issueDate
                + '}';
    }
}
