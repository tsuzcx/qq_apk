package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PluginInfo$1
  implements Parcelable.Creator<PluginInfo>
{
  public PluginInfo createFromParcel(Parcel paramParcel)
  {
    PluginInfo localPluginInfo = new PluginInfo();
    PluginInfo.access$002(localPluginInfo, paramParcel.readString());
    PluginInfo.access$102(localPluginInfo, paramParcel.readString());
    return localPluginInfo;
  }
  
  public PluginInfo[] newArray(int paramInt)
  {
    return new PluginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PluginInfo.1
 * JD-Core Version:    0.7.0.1
 */