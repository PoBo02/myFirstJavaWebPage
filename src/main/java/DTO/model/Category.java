package DTO.model;

public class Category {
    private int typeID;
    private String categoryName; 
    private String memo;

    public Category() {
    }

    public Category(int typeID, String categoryName, String memo) {
        this.typeID = typeID;
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
