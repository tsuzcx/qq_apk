package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import java.util.ArrayList;

public class AIOFileVideoData
  extends AIOBrowserBaseData
{
  public long Js;
  public boolean aZm;
  public long aix;
  public String bN;
  public boolean bis;
  public boolean bit;
  public boolean biv;
  public Bundle bundle;
  public int dBG;
  public String downloadUrl;
  public String fileName;
  public String fileUuid;
  public int height;
  public boolean isAutoPlay;
  public boolean isCancel;
  public boolean isMutePlay;
  public int isSend;
  public String mFilePath;
  public String md5;
  public int peerType;
  public long retCode;
  public String retMsg;
  public String strErr;
  public String strUin;
  public int width;
  public ArrayList<String> zi;
  
  public int getType()
  {
    return 103;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.bN = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.mFilePath = paramParcel.readString();
    this.Js = paramParcel.readLong();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.strUin = paramParcel.readString();
    this.peerType = paramParcel.readInt();
    this.isSend = paramParcel.readInt();
    this.fileUuid = paramParcel.readString();
    this.md5 = paramParcel.readString();
  }
  
  public void updateProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void updateStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.bN);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.mFilePath);
    paramParcel.writeLong(this.Js);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.strUin);
    paramParcel.writeInt(this.peerType);
    paramParcel.writeInt(this.isSend);
    paramParcel.writeString(this.fileUuid);
    paramParcel.writeString(this.md5);
  }
  
  public String yQ()
  {
    switch (this.status)
    {
    default: 
      return "undefine";
    case 0: 
      return "Nomal";
    case 3: 
      return "Buffering";
    case 1: 
      return "Downloading";
    case 7: 
      return "Error";
    case 4: 
      return "Get URL";
    case 6: 
      return "Pause";
    case 5: 
      return "Playing";
    }
    return "Saving";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */