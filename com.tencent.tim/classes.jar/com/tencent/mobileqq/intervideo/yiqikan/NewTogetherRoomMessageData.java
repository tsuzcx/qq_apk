package com.tencent.mobileqq.intervideo.yiqikan;

import aihe;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NewTogetherRoomMessageData
  implements Parcelable
{
  public static final Parcelable.Creator<NewTogetherRoomMessageData> CREATOR = new aihe();
  public String QD;
  public long abA;
  public long abz;
  public String aif;
  public String bNH;
  public String bNI = "";
  public String bNJ;
  public int ddo;
  public int ddp;
  public int ddq;
  public String roomName;
  public String wV;
  
  public NewTogetherRoomMessageData() {}
  
  public NewTogetherRoomMessageData(Parcel paramParcel)
  {
    this.QD = paramParcel.readString();
    this.bNH = paramParcel.readString();
    this.ddo = paramParcel.readInt();
    this.abz = paramParcel.readLong();
    this.ddq = paramParcel.readInt();
    this.abA = paramParcel.readLong();
    this.roomName = paramParcel.readString();
    this.wV = paramParcel.readString();
    this.aif = paramParcel.readString();
    this.bNJ = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" groupUin = " + this.QD);
    localStringBuilder.append(" groupOwnerUin = " + this.bNH);
    localStringBuilder.append(" roomid = " + this.abz);
    localStringBuilder.append(" oldRoomid = " + this.abA);
    localStringBuilder.append(" roomName = " + this.roomName);
    localStringBuilder.append(" jumpScheme = " + this.wV);
    localStringBuilder.append(" roomCover = " + this.aif);
    localStringBuilder.append(" roomtype = " + this.ddo);
    localStringBuilder.append(" fromid = " + this.bNJ);
    localStringBuilder.append(" oldRoomtype = " + this.ddq);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.QD);
    paramParcel.writeString(this.bNH);
    paramParcel.writeInt(this.ddo);
    paramParcel.writeLong(this.abz);
    paramParcel.writeInt(this.ddq);
    paramParcel.writeLong(this.abA);
    paramParcel.writeString(this.roomName);
    paramParcel.writeString(this.wV);
    paramParcel.writeString(this.aif);
    paramParcel.writeString(this.bNJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData
 * JD-Core Version:    0.7.0.1
 */