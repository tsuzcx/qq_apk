package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ea;

public class SendInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SendInfo> CREATOR = new ea();
  private String bN;
  private int mFileType;
  private long mMsgId;
  private String mPath;
  
  private SendInfo(Parcel paramParcel)
  {
    this.mPath = paramParcel.readString();
    this.bN = paramParcel.readString();
    this.mMsgId = paramParcel.readLong();
    this.mFileType = paramParcel.readInt();
  }
  
  private boolean a(SendInfo paramSendInfo)
  {
    return (this.mPath.equals(paramSendInfo.mPath)) && (this.bN.equals(paramSendInfo.bN)) && (this.mMsgId == paramSendInfo.mMsgId) && (this.mFileType == paramSendInfo.mFileType);
  }
  
  public String L()
  {
    return this.bN;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof SendInfo))) {
      return false;
    }
    return a((SendInfo)paramObject);
  }
  
  public long getMsgId()
  {
    return this.mMsgId;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int hashCode()
  {
    return (this.mPath + this.bN + this.mMsgId).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPath);
    paramParcel.writeString(this.bN);
    paramParcel.writeLong(this.mMsgId);
    paramParcel.writeInt(this.mFileType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.util.file.SendInfo
 * JD-Core Version:    0.7.0.1
 */