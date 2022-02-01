package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator<TMAssistantDownloadTaskInfo>
{
  public TMAssistantDownloadTaskInfo a(Parcel paramParcel)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
    localTMAssistantDownloadTaskInfo.mAppId = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mTaskPackageName = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mTaskVersionCode = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mIconUrl = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mAppName = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mStartTime = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mEndTime = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mVia = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mChannelid = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.showNotification = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localTMAssistantDownloadTaskInfo.isAutoInstallBySDK = bool;
      return localTMAssistantDownloadTaskInfo;
    }
  }
  
  public TMAssistantDownloadTaskInfo[] a(int paramInt)
  {
    return new TMAssistantDownloadTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.h
 * JD-Core Version:    0.7.0.1
 */