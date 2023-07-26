/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tyler
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customer.findByCompany", query = "SELECT c FROM Customer c WHERE c.company = :company")
    , @NamedQuery(name = "Customer.findByAddress1", query = "SELECT c FROM Customer c WHERE c.address1 = :address1")
    , @NamedQuery(name = "Customer.findByAddress2", query = "SELECT c FROM Customer c WHERE c.address2 = :address2")
    , @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city")
    , @NamedQuery(name = "Customer.findByProvince", query = "SELECT c FROM Customer c WHERE c.province = :province")
    , @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country")
    , @NamedQuery(name = "Customer.findByPostalCode", query = "SELECT c FROM Customer c WHERE c.postalCode = :postalCode")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByContactList", query = "SELECT c FROM Customer c WHERE c.contactList = :contactList")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByExtension", query = "SELECT c FROM Customer c WHERE c.extension = :extension")
    , @NamedQuery(name = "Customer.findByIsVendor", query = "SELECT c FROM Customer c WHERE c.isVendor = :isVendor")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_list")
    private String contactList;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Column(name = "extension")
    private String extension;
    @Basic(optional = false)
    @Column(name = "IsVendor")
    private boolean isVendor;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String company, String address1, String city, String province, String country, String postalCode, String phone, boolean isVendor) {
        this.customerId = customerId;
        this.company = company;
        this.address1 = address1;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.isVendor = isVendor;
    }
    
    public Customer( String company, String address1, String address2, String city, String province, 
            String country, String postalCode, String email, String contactList, String phone, String extension, boolean isVendor) {
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.email = email;
        this.contactList = contactList;
        this.phone = phone;
        this.extension = extension;
        this.isVendor = isVendor;
    }
    public Customer(Integer customerId, String company, String address1, String address2, String city, String province, 
            String country, String postalCode, String email, String contactList, String phone, String extension, boolean isVendor) {
        this.customerId = customerId;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.email = email;
        this.contactList = contactList;
        this.phone = phone;
        this.extension = extension;
        this.isVendor = isVendor;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactList() {
        return contactList;
    }

    public void setContactList(String contactList) {
        this.contactList = contactList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public boolean getIsVendor() {
        return isVendor;
    }

    public void setIsVendor(boolean isVendor) {
        this.isVendor = isVendor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Customer[ customerId=" + customerId + " ]";
    }
    
}
