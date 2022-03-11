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
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
    , @NamedQuery(name = "Inventory.findByItemId", query = "SELECT i FROM Inventory i WHERE i.itemId = :itemId")
    , @NamedQuery(name = "Inventory.findBySerialNumber", query = "SELECT i FROM Inventory i WHERE i.serialNumber = :serialNumber")
    , @NamedQuery(name = "Inventory.findByDescription", query = "SELECT i FROM Inventory i WHERE i.description = :description")
    , @NamedQuery(name = "Inventory.findByOd", query = "SELECT i FROM Inventory i WHERE i.od = :od")
    , @NamedQuery(name = "Inventory.findByPinConnect", query = "SELECT i FROM Inventory i WHERE i.pinConnect = :pinConnect")
    , @NamedQuery(name = "Inventory.findByBoxConnect", query = "SELECT i FROM Inventory i WHERE i.boxConnect = :boxConnect")
    , @NamedQuery(name = "Inventory.findById", query = "SELECT i FROM Inventory i WHERE i.id = :id")
    , @NamedQuery(name = "Inventory.findByLength", query = "SELECT i FROM Inventory i WHERE i.length = :length")
    , @NamedQuery(name = "Inventory.findByStatusName", query = "SELECT i FROM Inventory i WHERE i.statusName = :statusName")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "serial_number")
    private String serialNumber;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "od")
    private String od;
    @Basic(optional = false)
    @Column(name = "pin_connect")
    private String pinConnect;
    @Basic(optional = false)
    @Column(name = "box_connect")
    private String boxConnect;
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "length")
    private String length;
    @Basic(optional = false)
    @Column(name = "status_name")
    private String statusName;

    public Inventory() {
    }

    public Inventory(Integer itemId) {
        this.itemId = itemId;
    }

    public Inventory(Integer itemId, String serialNumber, String description, String od, String pinConnect, String boxConnect, String id, String length, String statusName) {
        this.itemId = itemId;
        this.serialNumber = serialNumber;
        this.description = description;
        this.od = od;
        this.pinConnect = pinConnect;
        this.boxConnect = boxConnect;
        this.id = id;
        this.length = length;
        this.statusName = statusName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getPinConnect() {
        return pinConnect;
    }

    public void setPinConnect(String pinConnect) {
        this.pinConnect = pinConnect;
    }

    public String getBoxConnect() {
        return boxConnect;
    }

    public void setBoxConnect(String boxConnect) {
        this.boxConnect = boxConnect;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Inventory[ itemId=" + itemId + " ]";
    }
    
}
