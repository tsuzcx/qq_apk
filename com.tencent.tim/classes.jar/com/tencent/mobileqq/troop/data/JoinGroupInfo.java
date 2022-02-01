package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aozv;
import java.util.Arrays;

public class JoinGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<JoinGroupInfo> CREATOR = new aozv();
  public String authKey;
  public String authSig;
  public String cnA;
  public int dSn;
  public byte[] gn;
  public String groupCode;
  public String picUrl;
  public String reason;
  public int verifyType;
  
  public JoinGroupInfo() {}
  
  public JoinGroupInfo(Parcel paramParcel)
  {
    this.groupCode = paramParcel.readString();
    this.reason = paramParcel.readString();
    this.dSn = paramParcel.readInt();
    this.authKey = paramParcel.readString();
    this.authSig = paramParcel.readString();
    this.gn = paramParcel.createByteArray();
    this.picUrl = paramParcel.readString();
    this.verifyType = paramParcel.readInt();
    this.cnA = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "JoinGroupInfo{groupCode='" + this.groupCode + '\'' + ", reason='" + this.reason + '\'' + ", statOption='" + this.dSn + '\'' + ", authKey='" + this.authKey + '\'' + ", authSig='" + this.authSig + '\'' + ", newMemberMsg=" + Arrays.toString(this.gn) + ", picUrl='" + this.picUrl + '\'' + ", verifyType=" + this.verifyType + ", verifyToken='" + this.cnA + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.groupCode);
    paramParcel.writeString(this.reason);
    paramParcel.writeInt(this.dSn);
    paramParcel.writeString(this.authKey);
    paramParcel.writeString(this.authSig);
    paramParcel.writeByteArray(this.gn);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeInt(this.verifyType);
    paramParcel.writeString(this.cnA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.JoinGroupInfo
 * JD-Core Version:    0.7.0.1
 */