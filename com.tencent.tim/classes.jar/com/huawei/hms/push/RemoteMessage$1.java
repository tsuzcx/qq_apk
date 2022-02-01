package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RemoteMessage$1
  implements Parcelable.Creator<RemoteMessage>
{
  public RemoteMessage a(Parcel paramParcel)
  {
    return new RemoteMessage(paramParcel);
  }
  
  public RemoteMessage[] a(int paramInt)
  {
    return new RemoteMessage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage.1
 * JD-Core Version:    0.7.0.1
 */