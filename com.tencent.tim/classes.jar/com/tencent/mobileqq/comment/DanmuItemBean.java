package com.tencent.mobileqq.comment;

import aeet;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqft;
import com.tencent.qphone.base.util.QLog;

public class DanmuItemBean
  implements Parcelable
{
  public static final Parcelable.Creator<DanmuItemBean> CREATOR = new aeet();
  public long VS;
  public long VT;
  public long VU;
  public boolean bTv;
  public String bwD = "";
  public int cMq;
  public String content = "";
  public long createTime;
  public String nickName = "";
  
  public DanmuItemBean() {}
  
  public DanmuItemBean(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    this.VS = paramLong1;
    this.VT = paramLong2;
    this.createTime = paramLong3;
    this.VU = paramLong4;
    this.content = paramString1;
    this.nickName = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DanmuItemBean{commentUin=" + this.VS + ", commentSeq=" + this.VT + ", createTime=" + this.createTime + ", location=" + this.VU + ", content=" + aqft.pk(this.content) + ", nickName='" + this.nickName + ", createTime=" + this.createTime + ", anonymousFlag=" + this.bTv + ", anonymousNick=" + this.bwD + ", anonymousHeadPortrait=" + this.cMq + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.VS);
      paramParcel.writeLong(this.VT);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeLong(this.VU);
      paramParcel.writeString(this.content);
      paramParcel.writeString(this.nickName);
      if (this.bTv) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.bwD);
        paramParcel.writeInt(this.cMq);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      QLog.d("DanmuItemBean", 1, "writeToParcel failed, ", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuItemBean
 * JD-Core Version:    0.7.0.1
 */