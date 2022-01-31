package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bst;

public class ForwardUtils$SectionBase
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bst();
  public int a = 0;
  
  protected ForwardUtils$SectionBase() {}
  
  public ForwardUtils$SectionBase(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase
 * JD-Core Version:    0.7.0.1
 */