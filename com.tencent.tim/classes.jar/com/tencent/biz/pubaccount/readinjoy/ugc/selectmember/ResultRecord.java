package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mos;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new mos();
  private String name;
  private int type;
  private String uin;
  
  public ResultRecord() {}
  
  public ResultRecord(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.name = paramParcel.readString();
    this.type = paramParcel.readInt();
  }
  
  private ResultRecord(String paramString1, String paramString2)
  {
    this.uin = paramString1;
    this.name = paramString2;
  }
  
  private ResultRecord(String paramString1, String paramString2, int paramInt)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.type = paramInt;
  }
  
  public static ResultRecord a(String paramString1, String paramString2)
  {
    return new ResultRecord(paramString1, paramString2);
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt)
  {
    return new ResultRecord(paramString1, paramString2, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (ResultRecord)paramObject;
    return this.uin.equals(paramObject.uin);
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    return this.uin.hashCode() * 31 + this.name.hashCode();
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    return "ResultRecord{uin='" + this.uin + '\'' + ", name='" + this.name + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */