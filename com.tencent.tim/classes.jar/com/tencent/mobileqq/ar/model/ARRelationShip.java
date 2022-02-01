package com.tencent.mobileqq.ar.model;

import adkk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARRelationShip
  implements Parcelable
{
  public static final Parcelable.Creator<ARRelationShip> CREATOR = new adkk();
  public long Up;
  public String btM;
  public String btN;
  public String btO;
  public String btP;
  public String btQ;
  public String btR;
  public String btS;
  public String btT;
  public String btU;
  public String btV;
  public String btW;
  public String btX = "";
  public String nickName = "";
  public String taskId;
  
  public ARRelationShip() {}
  
  public ARRelationShip(Parcel paramParcel)
  {
    this.taskId = paramParcel.readString();
    this.btM = paramParcel.readString();
    this.btN = paramParcel.readString();
    this.btO = paramParcel.readString();
    this.btP = paramParcel.readString();
    this.btQ = paramParcel.readString();
    this.btR = paramParcel.readString();
    this.Up = paramParcel.readLong();
    this.btS = paramParcel.readString();
    this.btT = paramParcel.readString();
    this.btU = paramParcel.readString();
    this.btV = paramParcel.readString();
    this.btW = paramParcel.readString();
    this.btX = paramParcel.readString();
    this.nickName = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.taskId);
    paramParcel.writeString(this.btM);
    paramParcel.writeString(this.btN);
    paramParcel.writeString(this.btO);
    paramParcel.writeString(this.btP);
    paramParcel.writeString(this.btQ);
    paramParcel.writeString(this.btR);
    paramParcel.writeLong(this.Up);
    paramParcel.writeString(this.btS);
    paramParcel.writeString(this.btT);
    paramParcel.writeString(this.btU);
    paramParcel.writeString(this.btV);
    paramParcel.writeString(this.btW);
    paramParcel.writeString(this.btX);
    paramParcel.writeString(this.nickName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ARRelationShip
 * JD-Core Version:    0.7.0.1
 */