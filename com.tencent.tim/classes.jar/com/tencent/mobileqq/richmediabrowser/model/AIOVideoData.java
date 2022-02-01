package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOVideoData
  extends AIOBrowserBaseData
{
  public String aWo = "I:N";
  public String aWp = "I:N";
  public long aiy;
  public boolean bio;
  public boolean bjB;
  public int bqB;
  public boolean cCk;
  public String friendUin = "";
  public int height;
  public boolean isAutoPlay;
  public boolean isMutePlay;
  public int isSend;
  public int mBusiType;
  public int redBagStat;
  public int redBagType;
  public String senderUin = "";
  public String shortVideoId = "";
  public int specialVideoType;
  public String templateId;
  public String templateName;
  public long uniseq;
  public int videoFileStatus;
  public int width;
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 101;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.aWo = paramParcel.readString();
    this.aWp = paramParcel.readString();
    this.bqB = paramParcel.readInt();
    this.mBusiType = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.uniseq = paramParcel.readLong();
    this.redBagType = paramParcel.readInt();
    this.shortVideoId = paramParcel.readString();
    this.senderUin = paramParcel.readString();
    this.redBagStat = paramParcel.readInt();
    this.friendUin = paramParcel.readString();
    this.isSend = paramParcel.readInt();
    this.specialVideoType = paramParcel.readInt();
    this.videoFileStatus = paramParcel.readInt();
    this.templateId = paramParcel.readString();
    this.templateName = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.aWo);
    paramParcel.writeString(this.aWp);
    paramParcel.writeInt(this.bqB);
    paramParcel.writeInt(this.mBusiType);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeLong(this.uniseq);
    paramParcel.writeInt(this.redBagType);
    paramParcel.writeString(this.shortVideoId);
    paramParcel.writeString(this.senderUin);
    paramParcel.writeInt(this.redBagStat);
    paramParcel.writeString(this.friendUin);
    paramParcel.writeInt(this.isSend);
    paramParcel.writeInt(this.specialVideoType);
    paramParcel.writeInt(this.videoFileStatus);
    paramParcel.writeString(this.templateId);
    paramParcel.writeString(this.templateName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoData
 * JD-Core Version:    0.7.0.1
 */