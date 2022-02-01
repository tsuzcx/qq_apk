package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PushMailBody$1
  implements Parcelable.Creator<PushMailBody>
{
  public PushMailBody createFromParcel(Parcel paramParcel)
  {
    return new PushMailBody(paramParcel, null);
  }
  
  public PushMailBody[] newArray(int paramInt)
  {
    return new PushMailBody[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushMailBody.1
 * JD-Core Version:    0.7.0.1
 */