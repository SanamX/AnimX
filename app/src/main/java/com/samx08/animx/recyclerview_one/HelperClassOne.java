package com.samx08.animx.recyclerview_one;

public class HelperClassOne {

    int image;
    String text;
    String info;

    public HelperClassOne(int image, String text, String info) {
        this.image = image;
        this.text = text;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
