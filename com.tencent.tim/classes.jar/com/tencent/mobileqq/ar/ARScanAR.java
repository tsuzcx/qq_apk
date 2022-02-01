package com.tencent.mobileqq.ar;

import adeb;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanAR
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanAR> CREATOR = new adeb();
  public long Su;
  public long Sv;
  public long aRBegin;
  public long aREnd;
  public String bsk;
  public String bsl;
  public String bsm;
  public String bsn;
  public String bso;
  public String bsp;
  public String bsq;
  public String bsr;
  public int cDS;
  public int cDT;
  public int cDU;
  public String scanLine1;
  public String scanLine2;
  public String scanLineLink;
  public String scanLinkUrl;
  
  public ARScanAR() {}
  
  public ARScanAR(Parcel paramParcel)
  {
    this.cDS = paramParcel.readInt();
    this.aRBegin = paramParcel.readLong();
    this.aREnd = paramParcel.readLong();
    this.Su = paramParcel.readLong();
    this.Sv = paramParcel.readLong();
    this.cDT = paramParcel.readInt();
    this.cDU = paramParcel.readInt();
    this.bsk = paramParcel.readString();
    this.bsl = paramParcel.readString();
    this.bsm = paramParcel.readString();
    this.bsn = paramParcel.readString();
    this.bso = paramParcel.readString();
    this.scanLine1 = paramParcel.readString();
    this.scanLine2 = paramParcel.readString();
    this.scanLineLink = paramParcel.readString();
    this.scanLinkUrl = paramParcel.readString();
    this.bsp = paramParcel.readString();
    this.bsq = paramParcel.readString();
    this.bsr = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ScanAR{");
    localStringBuffer.append("EntryType='").append(this.cDS).append('\'');
    localStringBuffer.append(", aRBegin=").append(this.aRBegin);
    localStringBuffer.append(", aREnd=").append(this.aREnd);
    localStringBuffer.append(", userGuideBeginTime=").append(this.Su);
    localStringBuffer.append(", userGuideEndTime=").append(this.Sv);
    localStringBuffer.append(", actType=").append(this.cDT);
    localStringBuffer.append(", userGuideShowCount=").append(this.cDU);
    localStringBuffer.append(", scanIconImg='").append(this.bsk).append('\'');
    localStringBuffer.append(", scanIconPressed='").append(this.bsm).append('\'');
    localStringBuffer.append(", scanIconText='").append(this.bso).append('\'');
    localStringBuffer.append(", scanLine1='").append(this.scanLine1).append('\'');
    localStringBuffer.append(", scanLine2='").append(this.scanLine2).append('\'');
    localStringBuffer.append(", scanLineLink='").append(this.scanLineLink).append('\'');
    localStringBuffer.append(", scanLinkUrl='").append(this.scanLinkUrl).append('\'');
    localStringBuffer.append(", what2scanUrl='").append(this.bsp).append('\'');
    localStringBuffer.append(", userGuideWording='").append(this.bsq).append('\'');
    localStringBuffer.append(", userGuideType='").append(this.bsr).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cDS);
    paramParcel.writeLong(this.aRBegin);
    paramParcel.writeLong(this.aREnd);
    paramParcel.writeLong(this.Su);
    paramParcel.writeLong(this.Sv);
    paramParcel.writeInt(this.cDT);
    paramParcel.writeInt(this.cDU);
    paramParcel.writeString(this.bsk);
    paramParcel.writeString(this.bsl);
    paramParcel.writeString(this.bsm);
    paramParcel.writeString(this.bsn);
    paramParcel.writeString(this.bso);
    paramParcel.writeString(this.scanLine1);
    paramParcel.writeString(this.scanLine2);
    paramParcel.writeString(this.scanLineLink);
    paramParcel.writeString(this.scanLinkUrl);
    paramParcel.writeString(this.bsp);
    paramParcel.writeString(this.bsq);
    paramParcel.writeString(this.bsr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARScanAR
 * JD-Core Version:    0.7.0.1
 */