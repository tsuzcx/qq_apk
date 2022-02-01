package com.tencent.tim.call.qcall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import atdd;

public class PstnSessionInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PstnSessionInfo> CREATOR = new atdd();
  public int anh = 7;
  public String cGF;
  public String cGG;
  public String cGH = "";
  public int epd = -1;
  public String mNickName;
  public String mPeerUin;
  public int mUinType = -1;
  
  public PstnSessionInfo() {}
  
  public PstnSessionInfo(Parcel paramParcel)
  {
    this.mPeerUin = paramParcel.readString();
    this.cGF = paramParcel.readString();
    this.cGG = paramParcel.readString();
    this.mUinType = paramParcel.readInt();
    this.mNickName = paramParcel.readString();
    this.epd = paramParcel.readInt();
    this.anh = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "mPeerUin=" + this.mPeerUin + ", mUinType=" + this.mUinType + ", mPeerPhoneNum=" + this.cGF + ", mSelfPhoneNum=" + this.cGG + ", mNickName=" + this.mNickName + ", mStatus=" + this.epd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPeerUin);
    paramParcel.writeString(this.cGF);
    paramParcel.writeString(this.cGG);
    paramParcel.writeInt(this.mUinType);
    paramParcel.writeString(this.mNickName);
    paramParcel.writeInt(this.epd);
    paramParcel.writeInt(this.anh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.call.qcall.PstnSessionInfo
 * JD-Core Version:    0.7.0.1
 */