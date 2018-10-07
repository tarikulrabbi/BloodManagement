package com.rabbi.tarikul.travelsofbangladesh;

public class BloodGroups {
    private String textviewTitle, textViewDetails;
    private int image;

    public BloodGroups(String textviewTitle, String textViewDetails, int image) {
        this.textviewTitle = textviewTitle;
        this.textViewDetails = textViewDetails;
        this.image = image;
    }

    public String getTextviewTitle() {
        return textviewTitle;
    }

    public void setTextviewTitle(String textviewTitle) {
        this.textviewTitle = textviewTitle;
    }

    public String getTextViewDetails() {
        return textViewDetails;
    }

    public void setTextViewDetails(String textViewDetails) {
        this.textViewDetails = textViewDetails;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
