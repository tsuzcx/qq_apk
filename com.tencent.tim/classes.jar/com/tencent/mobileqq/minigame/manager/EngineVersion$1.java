package com.tencent.mobileqq.minigame.manager;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class EngineVersion$1
  implements Parcelable.Creator<EngineVersion>
{
  public EngineVersion createFromParcel(Parcel paramParcel)
  {
    EngineVersion localEngineVersion = new EngineVersion();
    localEngineVersion.mMajor = paramParcel.readString();
    localEngineVersion.mMinor = paramParcel.readString();
    return localEngineVersion;
  }
  
  public EngineVersion[] newArray(int paramInt)
  {
    return new EngineVersion[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineVersion.1
 * JD-Core Version:    0.7.0.1
 */