package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import vsu;

public class RiskInfoItem
  implements Parcelable
{
  public static final Parcelable.Creator<RiskInfoItem> CREATOR = new vsu();
  public String Qv;
  public String Vf;
  public String aPJ;
  public String aPK;
  public String aPL;
  public int bKE;
  public int mItemId;
  
  public RiskInfoItem() {}
  
  private RiskInfoItem(Parcel paramParcel)
  {
    this.Qv = paramParcel.readString();
    this.aPJ = paramParcel.readString();
    this.Vf = paramParcel.readString();
    this.aPK = paramParcel.readString();
    this.bKE = paramParcel.readInt();
    this.mItemId = paramParcel.readInt();
    this.aPL = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.Qv);
    paramParcel.writeString(this.aPJ);
    paramParcel.writeString(this.Vf);
    paramParcel.writeString(this.aPK);
    paramParcel.writeInt(this.bKE);
    paramParcel.writeInt(this.mItemId);
    paramParcel.writeString(this.aPL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoItem
 * JD-Core Version:    0.7.0.1
 */