package com.tencent.qqmail.activity.aba;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PushWebAttach$1
  implements Parcelable.Creator<PushWebAttach>
{
  public PushWebAttach createFromParcel(Parcel paramParcel)
  {
    PushWebAttach localPushWebAttach = new PushWebAttach();
    localPushWebAttach.readFromParcel(paramParcel);
    return localPushWebAttach;
  }
  
  public PushWebAttach[] newArray(int paramInt)
  {
    return new PushWebAttach[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.PushWebAttach.1
 * JD-Core Version:    0.7.0.1
 */