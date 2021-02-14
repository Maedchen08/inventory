package com.enigma.coba.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.LocalDateTime;


@MappedSuperclass
public abstract class AbstractEntity<ID> {

    public abstract ID getId();
    public abstract void setId(ID id);

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    //membuat nilai default saat melakukan insert dengan local time now
    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    //membuat nilai default saat melakukan update dengan local time now
    @PreUpdate
    public void preUpdate() {
        modifiedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
