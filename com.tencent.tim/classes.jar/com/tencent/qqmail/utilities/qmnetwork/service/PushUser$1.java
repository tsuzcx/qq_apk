package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PushUser$1
  implements Parcelable.Creator<PushUser>
{
  public PushUser createFromParcel(Parcel paramParcel)
  {
    PushUser localPushUser = new PushUser();
    localPushUser.readFromParcel(paramParcel);
    return localPushUser;
  }
  
  public PushUser[] newArray(int paramInt)
  {
    return new PushUser[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushUser.1
 * JD-Core Version:    0.7.0.1
 */