package com.tencent.biz.pubaccount.ecshopassit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kef;

public class RecentShopParcel
  implements Parcelable
{
  public static final Parcelable.Creator<RecentShopParcel> CREATOR = new kef();
  public String YF;
  public String YG;
  public int aIi;
  public long lastMsgTime;
  public int mAuthenIconId;
  public String msg;
  public String nickName;
  public String puin;
  public long rR;
  public String time;
  public int unReadNum;
  
  public RecentShopParcel() {}
  
  public RecentShopParcel(Parcel paramParcel)
  {
    this.puin = paramParcel.readString();
    this.nickName = paramParcel.readString();
    this.time = paramParcel.readString();
    this.msg = paramParcel.readString();
    this.YF = paramParcel.readString();
    this.YG = paramParcel.readString();
    this.mAuthenIconId = paramParcel.readInt();
    this.unReadNum = paramParcel.readInt();
    this.aIi = paramParcel.readInt();
    this.lastMsgTime = paramParcel.readLong();
    this.rR = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.puin);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.time);
    paramParcel.writeString(this.msg);
    paramParcel.writeString(this.YF);
    paramParcel.writeString(this.YG);
    paramParcel.writeInt(this.mAuthenIconId);
    paramParcel.writeInt(this.unReadNum);
    paramParcel.writeInt(this.aIi);
    paramParcel.writeLong(this.lastMsgTime);
    paramParcel.writeLong(this.rR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel
 * JD-Core Version:    0.7.0.1
 */