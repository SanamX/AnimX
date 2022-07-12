package com.samx08.animx.model;

public class ImageModel {
    String ImageName;
    String ImageUrl;
    String ImageInfo;

    public ImageModel(String imageName, String imageUrl, String imageInfo) {
        ImageName = imageName;
        ImageUrl = imageUrl;
        ImageInfo = imageInfo;
    }

    public ImageModel() {

    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageInfo() {
        return ImageInfo;
    }

    public void setImageInfo(String imageInfo) {
        ImageInfo = imageInfo;
    }
}
