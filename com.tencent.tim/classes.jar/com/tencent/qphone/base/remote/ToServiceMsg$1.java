package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ToServiceMsg$1
  implements Parcelable.Creator
{
  public ToServiceMsg createFromParcel(Parcel paramParcel)
  {
    return new ToServiceMsg(paramParcel);
  }
  
  public ToServiceMsg[] newArray(int paramInt)
  {
    return new ToServiceMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg.1
 * JD-Core Version:    0.7.0.1
 */