package com.tencent.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import auqx;

public class BinderWarpper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWarpper> CREATOR = new auqx();
  public IBinder binder;
  
  public BinderWarpper(IBinder paramIBinder)
  {
    this.binder = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.binder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.BinderWarpper
 * JD-Core Version:    0.7.0.1
 */