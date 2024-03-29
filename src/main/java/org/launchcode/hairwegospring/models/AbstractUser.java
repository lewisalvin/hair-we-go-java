package org.launchcode.hairwegospring.models;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractUser {

    @Id
    @GeneratedValue
    private int uid;

    public int getUid() {
        return this.uid;
    }
}
