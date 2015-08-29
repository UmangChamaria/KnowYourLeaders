package com.example.uchamaria.retrofitsample;

import com.google.gson.annotations.SerializedName;

/**
 * @author Umang Chamaria
 */
public class PoliticianModel{
    @SerializedName("id")
    private String mPoliticianId;
    @SerializedName("name")
    private String mPoliticianName;
    @SerializedName("constituencyName")
    private String mConstituencyName;
    @SerializedName("partyName")
    private String mPartyName;
    @SerializedName("education")
    private String mPoliticianEducation;
    @SerializedName("criminalCasesPending")
    private String mPoliticianCriminalCasesPending;
    @SerializedName("totalAssets")
    private String mPoliticianTotalAssets;
    @SerializedName("liabilities")
    private String mPoliticianLiabilities;

    public String getPoliticianId() {
        return mPoliticianId;
    }

    public void setPoliticianId(String mPoliticianId) {
        this.mPoliticianId = mPoliticianId;
    }

    public String getPoliticianName() {
        return mPoliticianName;
    }

    public void setPoliticianName(String mPoliticianName) {
        this.mPoliticianName = mPoliticianName;
    }

    public String getConstituencyName() {
        return mConstituencyName;
    }

    public void setConstituencyName(String mConstituencyName) {
        this.mConstituencyName = mConstituencyName;
    }

    public String getPartyName() {
        return mPartyName;
    }

    public void setPartyName(String mPartyName) {
        this.mPartyName = mPartyName;
    }

    public String getPoliticianEducation() {
        return mPoliticianEducation;
    }

    public void setPoliticianEducation(String mPoliticianEducation) {
        this.mPoliticianEducation = mPoliticianEducation;
    }

    public String getPoliticianCriminalCasesPending() {
        return mPoliticianCriminalCasesPending;
    }

    public void setPoliticianCriminalCasesPending(String mPoliticianCriminalCasesPending) {
        this.mPoliticianCriminalCasesPending = mPoliticianCriminalCasesPending;
    }

    public String getPoliticianTotalAssets() {
        return mPoliticianTotalAssets;
    }

    public void setPoliticianTotalAssets(String mPoliticianTotalAssets) {
        this.mPoliticianTotalAssets = mPoliticianTotalAssets;
    }

    public String getPoliticianLiabilities() {
        return mPoliticianLiabilities;
    }

    public void setPoliticianLiabilities(String mPoliticianLiabilities) {
        this.mPoliticianLiabilities = mPoliticianLiabilities;
    }
}
