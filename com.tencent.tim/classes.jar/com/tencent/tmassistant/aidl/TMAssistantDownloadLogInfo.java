package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TMAssistantDownloadLogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantDownloadLogInfo> CREATOR = new g();
  public String logLevel;
  public String logMsg;
  public String logTag;
  public String logThrowableMsg;
  public long logTime;
  
  public TMAssistantDownloadLogInfo() {}
  
  public TMAssistantDownloadLogInfo(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    this.logLevel = paramString1;
    this.logTime = paramLong;
    this.logTag = paramString2;
    this.logMsg = paramString3;
    this.logThrowableMsg = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.logLevel != null)
    {
      paramParcel.writeString(this.logLevel);
      paramParcel.writeLong(this.logTime);
      if (this.logTag == null) {
        break label78;
      }
      paramParcel.writeString(this.logTag);
      label38:
      if (this.logMsg == null) {
        break label87;
      }
      paramParcel.writeString(this.logMsg);
    }
    for (;;)
    {
      if (this.logThrowableMsg == null) {
        break label96;
      }
      paramParcel.writeString(this.logThrowableMsg);
      return;
      paramParcel.writeString("");
      break;
      label78:
      paramParcel.writeString("");
      break label38;
      label87:
      paramParcel.writeString("");
    }
    label96:
    paramParcel.writeString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo
 * JD-Core Version:    0.7.0.1
 */