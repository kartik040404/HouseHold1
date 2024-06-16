package com.example.household;

public class UserHelperClass2 {
    String detailsProblem, detailsPhone, detailsAddress, spexp, dummy;

    public UserHelperClass2() {
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    public UserHelperClass2(String detailsAddress, String detailsProblem, String detailsPhone) {
        this.detailsAddress = detailsAddress;
        this.detailsProblem = detailsProblem;
        this.detailsPhone = detailsPhone;
    }

    public UserHelperClass2(String spexp, String dummy)
    {
        this.spexp = spexp;
        this.dummy = dummy;
    }

    public String getSpexp() {
        return spexp;
    }

    public void setSpexp(String spexp) {
        this.spexp = spexp;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
    }

    public String getDetailsPhone() {
        return detailsPhone;
    }

    public void setDetailsPhone(String detailsPhone) {
        this.detailsPhone = detailsPhone;
    }

    public String getDetailsProblem() {
        return detailsProblem;
    }

    public void setDetailsProblem(String detailsProblem) {
        this.detailsProblem = detailsProblem;
    }
}
