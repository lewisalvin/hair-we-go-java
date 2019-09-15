package org.launchcode.hairwegospring.models;

import javax.validation.constraints.NotNull;

public class PersonForm {

    private String fullName;

    @NotNull(message = "Must select hair type")
    private Long typeId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}