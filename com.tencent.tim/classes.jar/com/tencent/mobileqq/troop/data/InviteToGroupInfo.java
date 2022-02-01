package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aozt;
import aozu;
import java.util.ArrayList;

public class InviteToGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<InviteToGroupInfo> CREATOR = new aozt();
  public ArrayList<UinInfo> BM;
  public String cnA = "";
  public String groupCode = "";
  public String msg = "";
  public int verifyType;
  
  public InviteToGroupInfo() {}
  
  public InviteToGroupInfo(Parcel paramParcel)
  {
    this.groupCode = paramParcel.readString();
    this.msg = paramParcel.readString();
    this.BM = paramParcel.createTypedArrayList(UinInfo.CREATOR);
    this.verifyType = paramParcel.readInt();
    this.cnA = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "InviteToGroupInfo{groupCode='" + this.groupCode + '\'' + ", msg='" + this.msg + '\'' + ", invitedUinInfos=" + this.BM + ", verifyType=" + this.verifyType + ", verifyToken='" + this.cnA + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.groupCode);
    paramParcel.writeString(this.msg);
    paramParcel.writeTypedList(this.BM);
    paramParcel.writeInt(this.verifyType);
    paramParcel.writeString(this.cnA);
  }
  
  public static class UinInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<UinInfo> CREATOR = new aozu();
    public String cnB;
    public String groupCode;
    public String uin;
    
    public UinInfo() {}
    
    public UinInfo(Parcel paramParcel)
    {
      this.uin = paramParcel.readString();
      this.groupCode = paramParcel.readString();
      this.cnB = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "UinInfo{uin=" + this.uin + ", groupCode=" + this.groupCode + ", confCode=" + this.cnB + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.uin);
      paramParcel.writeString(this.groupCode);
      paramParcel.writeString(this.cnB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo
 * JD-Core Version:    0.7.0.1
 */