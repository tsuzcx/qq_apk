package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import thu;

public final class GdtInterstitialStatus
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialStatus> CREATOR = new thu();
  long En = -2147483648L;
  long Eo = -2147483648L;
  long Ep = -2147483648L;
  public boolean aPa;
  public boolean aPb;
  public boolean aPc;
  public boolean aPd;
  public boolean aPe;
  public int activityStatus = 0;
  public int bBr = -2147483648;
  public int bBs = -2147483648;
  public int bBt = -2147483648;
  public int bBu = -2147483648;
  public boolean exposed;
  public String processName;
  public long videoPositionMillis = -2147483648L;
  public int videoStatus = 0;
  
  public GdtInterstitialStatus() {}
  
  public GdtInterstitialStatus(Parcel paramParcel)
  {
    this.processName = paramParcel.readString();
    this.activityStatus = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aPa = bool1;
      if (paramParcel.readByte() == 0) {
        break label246;
      }
      bool1 = true;
      label107:
      this.aPb = bool1;
      if (paramParcel.readByte() == 0) {
        break label251;
      }
      bool1 = true;
      label121:
      this.aPc = bool1;
      if (paramParcel.readByte() == 0) {
        break label256;
      }
      bool1 = true;
      label135:
      this.aPd = bool1;
      if (paramParcel.readByte() == 0) {
        break label261;
      }
      bool1 = true;
      label149:
      this.aPe = bool1;
      if (paramParcel.readByte() == 0) {
        break label266;
      }
    }
    label256:
    label261:
    label266:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.exposed = bool1;
      this.bBr = paramParcel.readInt();
      this.bBs = paramParcel.readInt();
      this.bBt = paramParcel.readInt();
      this.bBu = paramParcel.readInt();
      this.videoPositionMillis = paramParcel.readLong();
      this.videoStatus = paramParcel.readInt();
      this.En = paramParcel.readLong();
      this.Eo = paramParcel.readLong();
      this.Ep = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      label246:
      bool1 = false;
      break label107;
      label251:
      bool1 = false;
      break label121;
      bool1 = false;
      break label135;
      bool1 = false;
      break label149;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long ee()
  {
    long l = -2147483648L;
    if (this.En != -2147483648L) {
      l = System.currentTimeMillis() - this.En;
    }
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.processName);
    paramParcel.writeInt(this.activityStatus);
    if (this.aPa)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aPb) {
        break label186;
      }
      paramInt = 1;
      label42:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aPc) {
        break label191;
      }
      paramInt = 1;
      label57:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aPd) {
        break label196;
      }
      paramInt = 1;
      label72:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aPe) {
        break label201;
      }
      paramInt = 1;
      label87:
      paramParcel.writeByte((byte)paramInt);
      if (!this.exposed) {
        break label206;
      }
    }
    label186:
    label191:
    label196:
    label201:
    label206:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.bBr);
      paramParcel.writeInt(this.bBs);
      paramParcel.writeInt(this.bBt);
      paramParcel.writeInt(this.bBu);
      paramParcel.writeLong(this.videoPositionMillis);
      paramParcel.writeInt(this.videoStatus);
      paramParcel.writeLong(this.En);
      paramParcel.writeLong(this.Eo);
      paramParcel.writeLong(this.Ep);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label42;
      paramInt = 0;
      break label57;
      paramInt = 0;
      break label72;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialStatus
 * JD-Core Version:    0.7.0.1
 */