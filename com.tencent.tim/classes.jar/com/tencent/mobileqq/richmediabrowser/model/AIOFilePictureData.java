package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOFilePictureData
  extends AIOBrowserBaseData
{
  public long Jr;
  public String aVW = "I:N";
  public String aVX = "I:N";
  public String aVY = "I:N";
  public String aVZ = "I:N";
  public String aWa;
  public int bWF;
  public boolean bim;
  public boolean bin;
  public boolean bio;
  public boolean bip;
  public boolean biq;
  public String curUin;
  public int issend;
  public String mFileName;
  public long mFileSize;
  public String md5;
  public int peerType;
  public int picHeight;
  public int picWidth;
  public String strUin;
  
  public int getType()
  {
    return 102;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.strUin = paramParcel.readString();
    this.peerType = paramParcel.readInt();
    this.aVW = paramParcel.readString();
    this.aVX = paramParcel.readString();
    this.aVY = paramParcel.readString();
    this.aVZ = paramParcel.readString();
    this.curUin = paramParcel.readString();
    this.issend = paramParcel.readInt();
    this.mFileName = paramParcel.readString();
    this.bip = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.mFileSize = Long.valueOf(paramParcel.readString()).longValue();
    this.Jr = Long.valueOf(paramParcel.readString()).longValue();
    this.biq = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.aWa = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.picWidth = paramParcel.readInt();
    this.picHeight = paramParcel.readInt();
    this.bWF = paramParcel.readInt();
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
    paramParcel.writeString(this.strUin);
    paramParcel.writeInt(this.peerType);
    paramParcel.writeString(this.aVW);
    paramParcel.writeString(this.aVX);
    paramParcel.writeString(this.aVY);
    paramParcel.writeString(this.aVZ);
    paramParcel.writeString(this.curUin);
    paramParcel.writeInt(this.issend);
    paramParcel.writeString(this.mFileName);
    paramParcel.writeString(String.valueOf(this.bip));
    paramParcel.writeString(String.valueOf(this.mFileSize));
    paramParcel.writeString(String.valueOf(this.Jr));
    paramParcel.writeString(String.valueOf(this.biq));
    paramParcel.writeString(this.aWa);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.picWidth);
    paramParcel.writeInt(this.picHeight);
    paramParcel.writeInt(this.bWF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData
 * JD-Core Version:    0.7.0.1
 */