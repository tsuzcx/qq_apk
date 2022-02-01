package com.tencent.mobileqq.pic;

import akxa;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.BaseApplication;

public class CompressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CompressInfo> CREATOR = new akxa();
  public ThumbWidthHeightDP a;
  public String bUC;
  public String bUD;
  public String bUE;
  public int busiType = -1;
  public boolean cuN;
  public boolean cuO;
  public boolean cuP = true;
  public boolean cuQ;
  public boolean cuR;
  public boolean cuS;
  public String destPath;
  public int dpv;
  public int dpw;
  public int dpx;
  public int dpy;
  public int dpz;
  public boolean isSuccess;
  public String localUUID;
  public int networkType = 2;
  public int picQuality;
  public int picType;
  public String srcPath;
  public int uinType = -1;
  
  public CompressInfo() {}
  
  private CompressInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public CompressInfo(String paramString, int paramInt)
  {
    this.srcPath = paramString;
    this.picQuality = paramInt;
  }
  
  public CompressInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.srcPath = paramString;
    this.picQuality = paramInt1;
    this.busiType = paramInt2;
  }
  
  public void Nr(boolean paramBoolean)
  {
    this.cuN = true;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (paramBoolean) {}
    for (int i = 2131691941;; i = 2131691937)
    {
      this.bUC = localBaseApplication.getString(i);
      return;
    }
  }
  
  public void Ns(boolean paramBoolean)
  {
    this.cuO = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean = new boolean[7];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.isSuccess = arrayOfBoolean[0];
    this.cuN = arrayOfBoolean[1];
    this.isSuccess = arrayOfBoolean[0];
    this.cuN = arrayOfBoolean[1];
    this.cuO = arrayOfBoolean[2];
    this.cuP = arrayOfBoolean[3];
    this.cuQ = arrayOfBoolean[4];
    this.cuR = arrayOfBoolean[5];
    this.cuS = arrayOfBoolean[6];
    this.localUUID = paramParcel.readString();
    this.busiType = paramParcel.readInt();
    this.bUC = paramParcel.readString();
    this.srcPath = paramParcel.readString();
    this.dpv = paramParcel.readInt();
    this.dpw = paramParcel.readInt();
    this.bUD = paramParcel.readString();
    this.destPath = paramParcel.readString();
    this.dpx = paramParcel.readInt();
    this.dpy = paramParcel.readInt();
    this.picType = paramParcel.readInt();
    this.picQuality = paramParcel.readInt();
    this.networkType = paramParcel.readInt();
    this.dpz = paramParcel.readInt();
    this.bUE = paramParcel.readString();
    this.uinType = paramParcel.readInt();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nCompressInfo");
    localStringBuilder.append("\n|-").append("localUUID:").append(this.localUUID);
    localStringBuilder.append("\n|-").append("isSuccess:").append(this.isSuccess);
    localStringBuilder.append("\n|-").append("isOOM:").append(this.cuN);
    localStringBuilder.append("\n|-").append("isOOS:").append(this.cuO);
    localStringBuilder.append("\n|-").append("oomMsg:").append(this.bUC);
    localStringBuilder.append("\n|-").append("srcPath:").append(this.srcPath);
    localStringBuilder.append("\n|-").append("specPath:").append(this.bUD);
    localStringBuilder.append("\n|-").append("destPath:").append(this.destPath);
    localStringBuilder.append("\n|-").append("picType:").append(this.picType);
    localStringBuilder.append("\n|-").append("picQuality:").append(this.picQuality);
    localStringBuilder.append("\n|-").append("networkType:").append(this.networkType);
    localStringBuilder.append("\n|-").append("sampleCompressCnt:").append(this.dpz);
    localStringBuilder.append("\n|-").append("compressMsg:").append(this.bUE);
    localStringBuilder.append("\n|-").append("isResultOriginal:").append(this.cuQ);
    localStringBuilder.append("\n|-").append("uinType:").append(this.uinType);
    localStringBuilder.append("\n|-").append("mCheckJpgQualityAndSize:").append(this.cuS);
    localStringBuilder.append("\n|-").append("isOverride:").append(this.cuR);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.isSuccess, this.cuN, this.cuO, this.cuP, this.cuQ, this.cuR, this.cuS });
    paramParcel.writeString(this.localUUID);
    paramParcel.writeInt(this.busiType);
    paramParcel.writeString(this.bUC);
    paramParcel.writeString(this.srcPath);
    paramParcel.writeInt(this.dpv);
    paramParcel.writeInt(this.dpw);
    paramParcel.writeString(this.bUD);
    paramParcel.writeString(this.destPath);
    paramParcel.writeInt(this.dpx);
    paramParcel.writeInt(this.dpy);
    paramParcel.writeInt(this.picType);
    paramParcel.writeInt(this.picQuality);
    paramParcel.writeInt(this.networkType);
    paramParcel.writeInt(this.dpz);
    paramParcel.writeString(this.bUE);
    paramParcel.writeInt(this.uinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CompressInfo
 * JD-Core Version:    0.7.0.1
 */