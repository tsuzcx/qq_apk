package com.tencent.mobileqq.activity.richmedia.subtitles;

import aatl;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BarrageParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<BarrageParcelItem> CREATOR = new aatl();
  public int cjW;
  public int cjX;
  public int mColor;
  public float mSpeed;
  
  public BarrageParcelItem() {}
  
  public BarrageParcelItem(Parcel paramParcel)
  {
    this.mColor = paramParcel.readInt();
    this.cjW = paramParcel.readInt();
    this.cjX = paramParcel.readInt();
    this.mSpeed = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mColor);
    paramParcel.writeInt(this.cjW);
    paramParcel.writeInt(this.cjX);
    paramParcel.writeFloat(this.mSpeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.BarrageParcelItem
 * JD-Core Version:    0.7.0.1
 */