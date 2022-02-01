package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PushWebImage$1
  implements Parcelable.Creator<PushWebImage>
{
  public PushWebImage createFromParcel(Parcel paramParcel)
  {
    PushWebImage localPushWebImage = new PushWebImage();
    localPushWebImage.readFromParcel(paramParcel);
    return localPushWebImage;
  }
  
  public PushWebImage[] newArray(int paramInt)
  {
    return new PushWebImage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushWebImage.1
 * JD-Core Version:    0.7.0.1
 */