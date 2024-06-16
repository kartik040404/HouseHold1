package com.example.household;

public class UserHelperClass {
    String name, username, email, phoneNo, password, key, DetailsAddress, DetailsDescription, DetailsPhoneNo;
    String buildSerial, buildManufacturer, buildId, buildUser, buildType, buildBrand, buildHost, buildBoard, buildBase, buildVersioncode, buildFingerprint;

    public UserHelperClass() {
    }

    public String getDetailsAddress() {
        return DetailsAddress;
    }

    public String getDetailsDescription() {
        return DetailsDescription;
    }

    public String getDetailsPhoneNo() {
        return DetailsPhoneNo;
    }

    public void setDetailsPhoneNo(String detailsPhoneNo) {
        DetailsPhoneNo = detailsPhoneNo;
    }

    public void setDetailsDescription(String detailsDescription) {
        DetailsDescription = detailsDescription;
    }

    public void setDetailsAddress(String detailsAddress) {
        DetailsAddress = detailsAddress;
    }

    public UserHelperClass(String name, String username, String email, String phoneNo, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;

    }


    //Delete
    public UserHelperClass(String buildSerial, String buildManufacturer, String buildId, String buildUser, String buildType, String buildBrand, String buildHost, String buildBoard, String buildBase, String buildVersioncode, String buildFingerprint) {
        this.buildSerial = buildSerial;
        this.buildManufacturer = buildManufacturer;
        this.buildId = buildId;
        this.buildUser = buildUser;
        this.buildType = buildType;
        this.buildBrand = buildBrand;
        this.buildHost = buildHost;
        this.buildBoard = buildBoard;
        this.buildBase = buildBase;
        this.buildVersioncode = buildVersioncode;
        this.buildFingerprint = buildFingerprint;

    }

    public UserHelperClass(String DetailsAddress, String DetailsDescription, String DetailsPhoneno) {
        this.DetailsAddress = DetailsAddress;
        this.DetailsDescription = DetailsDescription;
        this.DetailsPhoneNo = DetailsPhoneno;
    }
    //Delete


    public String getBuildFingerprint() {
        return buildFingerprint;
    }

    public void setBuildFingerprint(String buildFingerprint) {
        this.buildFingerprint = buildFingerprint;
    }

    public String getBuildVersioncode() {
        return buildVersioncode;
    }

    public void setBuildVersioncode(String buildVersioncode) {
        this.buildVersioncode = buildVersioncode;
    }

    public String getBuildBase() {
        return buildBase;
    }

    public void setBuildBase(String buildBase) {
        this.buildBase = buildBase;
    }

    public String getBuildBoard() {
        return buildBoard;
    }

    public void setBuildBoard(String buildBoard) {
        this.buildBoard = buildBoard;
    }

    public String getBuildHost() {
        return buildHost;
    }

    public void setBuildHost(String buildHost) {
        this.buildHost = buildHost;
    }

    public String getBuildBrand() {
        return buildBrand;
    }

    public void setBuildBrand(String buildBrand) {
        this.buildBrand = buildBrand;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildUser() {
        return buildUser;
    }

    public void setBuildUser(String buildUser) {
        this.buildUser = buildUser;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getBuildManufacturer() {
        return buildManufacturer;
    }

    public void setBuildManufacturer(String buildManufacturer) {
        this.buildManufacturer = buildManufacturer;
    }

    public String getBuildSerial() {
        return buildSerial;
    }

    public void setBuildSerial(String buildSerial) {
        this.buildSerial = buildSerial;
    }


    public UserHelperClass(String key) {
        this.key = key;
    }


    //Getters
    public String getKey() {
        return key;
    }

    public String getVal() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPassword() {
        return password;
    }


    //Setters
    public void setKey(String key) {
        this.key = key;
    }

    public void setVal(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
