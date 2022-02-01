package com.tencent.biz.pubaccount.readinjoy.view.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import nqx;

public class AspectRatio
  implements Parcelable
{
  public static final Parcelable.Creator<AspectRatio> CREATOR = new nqx();
  @Nullable
  private final String any;
  private final float kU;
  private final float kV;
  
  public AspectRatio(Parcel paramParcel)
  {
    this.any = paramParcel.readString();
    this.kU = paramParcel.readFloat();
    this.kV = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.any);
    paramParcel.writeFloat(this.kU);
    paramParcel.writeFloat(this.kV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.model.AspectRatio
 * JD-Core Version:    0.7.0.1
 */