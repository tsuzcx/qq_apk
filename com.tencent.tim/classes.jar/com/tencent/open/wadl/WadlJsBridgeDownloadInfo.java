package com.tencent.open.wadl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ascb;

public class WadlJsBridgeDownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WadlJsBridgeDownloadInfo> CREATOR = new ascb();
  public String appId;
  public String appName = "";
  public long awM;
  public String cCL;
  public String cDF;
  public String cDG;
  public boolean ddw = true;
  public int downloadType = 0;
  public int ell;
  public int elm;
  public String extraData;
  public String filePath = "";
  public int from = 0;
  public String iconUrl = "";
  public boolean isAutoInstall = true;
  public boolean isAutoInstallBySDK;
  public String packageName;
  public volatile int progress;
  public String pushTitle;
  public String sendTime = "";
  public int source = 2;
  public volatile int state = 1;
  public long time;
  public int updateType = 0;
  public String urlStr;
  public int versionCode;
  public String via;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadInfo [appId=" + this.appId + ", urlStr=" + this.urlStr + ", packageName=" + this.packageName + ", push_title=" + this.pushTitle + ", sendTime=" + this.sendTime + ", progress=" + this.progress + ", time=" + this.time + ", filePath=" + this.filePath + ", state=" + this.state + ", urlPatch=" + this.cDF + ", updateType=" + this.updateType + ", myAppId=" + this.cDG + ", apkId=" + this.updateType + ", versionCode=" + this.versionCode + ", lastDownloadSize=" + this.awM + ", isApk=" + this.ddw + ", iconUrl=" + this.iconUrl + ", isShowNotification=" + this.ell + ", writeCodeState=" + this.elm + ", extraInfo =" + this.extraData + ", isAutoInstallBySDK =" + this.isAutoInstallBySDK + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.urlStr);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.pushTitle);
    paramParcel.writeString(this.sendTime);
    paramParcel.writeLong(this.time);
    paramParcel.writeString(this.via);
    paramParcel.writeString(this.cDF);
    paramParcel.writeInt(this.updateType);
    paramParcel.writeString(this.filePath);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.awM);
    if (this.ddw)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeInt(this.ell);
      paramParcel.writeInt(this.elm);
      paramParcel.writeString(this.extraData);
      if (!this.isAutoInstallBySDK) {
        break label174;
      }
    }
    label174:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeDownloadInfo
 * JD-Core Version:    0.7.0.1
 */