package com.tencent.mobileqq.activity.richmedia.subtitles;

import aaub;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PacmanParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<PacmanParcelItem> CREATOR = new aaub();
  public int cjX;
  public int mIndex;
  public float mSpeed;
  
  public PacmanParcelItem() {}
  
  public PacmanParcelItem(Parcel paramParcel)
  {
    this.mIndex = paramParcel.readInt();
    this.cjX = paramParcel.readInt();
    this.mSpeed = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.cjX);
    paramParcel.writeFloat(this.mSpeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem
 * JD-Core Version:    0.7.0.1
 */