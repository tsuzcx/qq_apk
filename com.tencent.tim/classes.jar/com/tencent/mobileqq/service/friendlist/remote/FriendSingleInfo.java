package com.tencent.mobileqq.service.friendlist.remote;

import anam;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FriendSingleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendSingleInfo> CREATOR = new anam();
  public String alias = "";
  public byte bw;
  public String ccH = "";
  public int faceId;
  public int groupId;
  public int status;
  public String strName = "";
  public String strSignature = "";
  public String strUin = "";
  
  public FriendSingleInfo() {}
  
  public FriendSingleInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.strUin = paramParcel.readString();
    this.strName = paramParcel.readString();
    this.strSignature = paramParcel.readString();
    this.faceId = paramParcel.readInt();
    this.status = paramParcel.readInt();
    this.bw = paramParcel.readByte();
    this.groupId = paramParcel.readInt();
    this.alias = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.strUin);
    paramParcel.writeString(this.strName);
    paramParcel.writeString(this.strSignature);
    paramParcel.writeInt(this.faceId);
    paramParcel.writeInt(this.status);
    paramParcel.writeByte(this.bw);
    paramParcel.writeInt(this.groupId);
    paramParcel.writeString(this.alias);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendSingleInfo
 * JD-Core Version:    0.7.0.1
 */