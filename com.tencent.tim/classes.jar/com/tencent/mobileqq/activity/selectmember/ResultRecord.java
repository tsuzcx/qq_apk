package com.tencent.mobileqq.activity.selectmember;

import aaxm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Comparator;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new aaxm();
  public long MO;
  public String QD;
  public String SB;
  public boolean isNewTroop;
  public String name;
  public int type;
  public String uin;
  public int uinType = -1;
  
  public ResultRecord() {}
  
  private ResultRecord(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.name = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.QD = paramParcel.readString();
    this.SB = paramParcel.readString();
    this.MO = paramParcel.readLong();
    this.uinType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isNewTroop = bool;
      return;
      bool = false;
    }
  }
  
  public ResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    b(paramString1, paramString2, paramInt, paramString3, paramString4);
  }
  
  public static ResultRecord a(ResultRecord paramResultRecord)
  {
    ResultRecord localResultRecord = null;
    if (paramResultRecord != null)
    {
      localResultRecord = new ResultRecord();
      localResultRecord.uin = paramResultRecord.uin;
      localResultRecord.name = paramResultRecord.name;
      localResultRecord.type = paramResultRecord.type;
      localResultRecord.QD = paramResultRecord.QD;
      localResultRecord.SB = paramResultRecord.SB;
      localResultRecord.uinType = paramResultRecord.uinType;
      localResultRecord.isNewTroop = paramResultRecord.isNewTroop;
    }
    return localResultRecord;
  }
  
  public void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.uinType = paramInt;
    this.QD = paramString3;
    this.SB = paramString4;
    this.MO = 0L;
    this.isNewTroop = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ResultRecord))
    {
      paramObject = (ResultRecord)paramObject;
      if ((paramObject.uin.equals(this.uin)) && (paramObject.type == this.type) && (((!TextUtils.isEmpty(this.SB)) && (!TextUtils.isEmpty(paramObject.SB)) && (this.SB.equals(paramObject.SB))) || ((TextUtils.isEmpty(this.SB)) && (TextUtils.isEmpty(paramObject.SB))))) {
        return true;
      }
    }
    return false;
  }
  
  public int lk()
  {
    return this.uinType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin:").append(this.uin);
    localStringBuilder.append(", name:").append(this.name);
    localStringBuilder.append(", type:").append(this.type);
    localStringBuilder.append(", groupUin:").append(this.QD);
    localStringBuilder.append(", uinType:").append(this.uinType);
    localStringBuilder.append(", phone:").append(this.SB).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.QD);
    paramParcel.writeString(this.SB);
    paramParcel.writeLong(this.MO);
    paramParcel.writeInt(this.uinType);
    if (this.isNewTroop) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static class a
    implements Comparator<ResultRecord>
  {
    public int a(ResultRecord paramResultRecord1, ResultRecord paramResultRecord2)
    {
      int j = -1;
      long l1;
      long l2;
      label17:
      int i;
      if (paramResultRecord1 == null)
      {
        l1 = 0L;
        if (paramResultRecord2 != null) {
          break label38;
        }
        l2 = 0L;
        if (l1 != l2) {
          break label47;
        }
        i = 0;
      }
      label38:
      label47:
      do
      {
        do
        {
          return i;
          l1 = paramResultRecord1.MO;
          break;
          l2 = paramResultRecord2.MO;
          break label17;
          i = j;
        } while (l1 == 0L);
        if (l2 == 0L) {
          return 1;
        }
        i = j;
      } while (l1 < l2);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */