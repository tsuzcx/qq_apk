package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mip;

public class VisibleSetParam
  implements Parcelable
{
  public static final Parcelable.Creator<VisibleSetParam> CREATOR = new mip();
  public static VisibleSetParam b = new VisibleSetParam(0, Collections.emptyList());
  public static VisibleSetParam c = new VisibleSetParam(2, Collections.emptyList());
  private final int aTn;
  private final List<Long> iY;
  
  public VisibleSetParam(int paramInt, @NonNull List<Long> paramList)
  {
    this.aTn = paramInt;
    this.iY = paramList;
  }
  
  public VisibleSetParam(Parcel paramParcel)
  {
    this.aTn = paramParcel.readInt();
    this.iY = new ArrayList();
    paramParcel.readList(this.iY, Long.class.getClassLoader());
  }
  
  public List<Long> aZ()
  {
    return this.iY;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int pi()
  {
    return this.aTn;
  }
  
  public String toString()
  {
    return "VisibleSetParam{visible_type=" + this.aTn + ", uinWhiteList=" + this.iY + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aTn);
    paramParcel.writeList(this.iY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam
 * JD-Core Version:    0.7.0.1
 */