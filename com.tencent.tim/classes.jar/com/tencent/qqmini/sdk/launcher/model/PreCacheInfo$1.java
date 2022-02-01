package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PreCacheInfo$1
  implements Parcelable.Creator<PreCacheInfo>
{
  public PreCacheInfo createFromParcel(Parcel paramParcel)
  {
    PreCacheInfo localPreCacheInfo = new PreCacheInfo();
    localPreCacheInfo.getDataUrl = paramParcel.readString();
    localPreCacheInfo.preCacheKey = paramParcel.readString();
    localPreCacheInfo.expireTime = paramParcel.readLong();
    localPreCacheInfo.cacheType = paramParcel.readInt();
    localPreCacheInfo.useProxy = paramParcel.readInt();
    return localPreCacheInfo;
  }
  
  public PreCacheInfo[] newArray(int paramInt)
  {
    return new PreCacheInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PreCacheInfo.1
 * JD-Core Version:    0.7.0.1
 */