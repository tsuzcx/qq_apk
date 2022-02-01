package com.tencent.mobileqq.filemanager.data;

import agnl;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeiYunFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeiYunFileInfo> CREATOR = new agnl();
  public String bIk;
  public String bIz;
  public int cYi = 0;
  public boolean cet;
  public String cookieName;
  public String cookieValue;
  public String dirKey;
  public String encodeUrl;
  public String hostName;
  public String md5;
  public long mtime;
  public long nFileSize;
  public int port;
  public String sha;
  public String strFileName;
  
  public WeiYunFileInfo() {}
  
  public WeiYunFileInfo(Parcel paramParcel)
  {
    this.bIk = paramParcel.readString();
    this.dirKey = paramParcel.readString();
    this.strFileName = paramParcel.readString();
    this.nFileSize = paramParcel.readLong();
    this.mtime = paramParcel.readLong();
    this.cYi = paramParcel.readInt();
    this.hostName = paramParcel.readString();
    this.port = paramParcel.readInt();
    this.encodeUrl = paramParcel.readString();
    this.cookieName = paramParcel.readString();
    this.cookieValue = paramParcel.readString();
    this.bIz = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.sha = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.cet = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bIk);
    paramParcel.writeString(this.dirKey);
    paramParcel.writeString(this.strFileName);
    paramParcel.writeLong(this.nFileSize);
    paramParcel.writeLong(this.mtime);
    paramParcel.writeInt(this.cYi);
    paramParcel.writeString(this.hostName);
    paramParcel.writeInt(this.port);
    paramParcel.writeString(this.encodeUrl);
    paramParcel.writeString(this.cookieName);
    paramParcel.writeString(this.cookieValue);
    paramParcel.writeString(this.bIz);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.sha);
    if (this.cet) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.WeiYunFileInfo
 * JD-Core Version:    0.7.0.1
 */