package com.tencent.mobileqq.troop.homework.arithmetic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apgp;

public class HWGuideItem
  implements Parcelable
{
  public static final Parcelable.Creator<HWGuideItem> CREATOR = new apgp();
  public String coP;
  public String mPicUrl;
  
  public HWGuideItem(Parcel paramParcel)
  {
    this.mPicUrl = paramParcel.readString();
    this.coP = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPicUrl);
    paramParcel.writeString(this.coP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem
 * JD-Core Version:    0.7.0.1
 */