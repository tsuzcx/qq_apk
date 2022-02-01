package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ReceivePacket$1
  implements Parcelable.Creator<ReceivePacket>
{
  public ReceivePacket createFromParcel(Parcel paramParcel)
  {
    return new ReceivePacket(paramParcel);
  }
  
  public ReceivePacket[] newArray(int paramInt)
  {
    return new ReceivePacket[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket.1
 * JD-Core Version:    0.7.0.1
 */