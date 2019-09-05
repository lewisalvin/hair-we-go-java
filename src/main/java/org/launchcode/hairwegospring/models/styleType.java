package org.launchcode.hairwegospring.models;

public class styleType {

    private Long typeId;
    private String typeCode;
    private String typeName;

    public styleType() {

    }

    public styleType(Long typeId, String typeCode, String typeName) {
        super();
        this.typeId = typeId;
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}