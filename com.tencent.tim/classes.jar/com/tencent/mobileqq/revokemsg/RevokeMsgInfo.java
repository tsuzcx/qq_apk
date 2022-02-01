package com.tencent.mobileqq.revokemsg;

import alvo;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RevokeMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RevokeMsgInfo> CREATOR = new alvo();
  public String authorUin;
  public String bYD;
  public String bYE;
  public String bYF;
  public boolean czE = true;
  public int dyi;
  public int dyj;
  public int dyk;
  public int dyl;
  public String frienduin;
  public int istroop;
  public long msguid;
  public int opType;
  public long shmsgseq;
  public long time;
  
  public RevokeMsgInfo() {}
  
  public RevokeMsgInfo(MessageRecord paramMessageRecord)
  {
    this.istroop = paramMessageRecord.istroop;
    this.frienduin = paramMessageRecord.frienduin;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.msguid = paramMessageRecord.msgUid;
    this.time = paramMessageRecord.time;
    this.bYF = paramMessageRecord.senderuin;
    this.dyi = paramMessageRecord.longMsgId;
    this.dyj = paramMessageRecord.longMsgCount;
    this.dyk = paramMessageRecord.longMsgIndex;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return String.format("RevokeMsgInfo[istroop= %d, shmsgseq= %d, frienduin= %s, fromuin= %s msguid= %d, time= %d, senduin= %s, longmsgid= %d, longmsgcount=%d longmsgindex=%d, showGrayTips = %s", new Object[] { Integer.valueOf(this.istroop), Long.valueOf(this.shmsgseq), this.frienduin, this.bYD, Long.valueOf(this.msguid), Long.valueOf(this.time), this.bYF, Integer.valueOf(this.dyi), Integer.valueOf(this.dyj), Integer.valueOf(this.dyk), Boolean.valueOf(this.czE) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramParcel.writeInt(this.istroop);
        paramParcel.writeLong(this.shmsgseq);
        paramParcel.writeString(this.frienduin);
        paramParcel.writeString(this.bYF);
        paramParcel.writeLong(this.msguid);
        paramParcel.writeLong(this.time);
        paramParcel.writeString(this.authorUin);
        paramParcel.writeInt(this.opType);
        paramParcel.writeInt(this.dyl);
        if (this.czE)
        {
          paramInt = 1;
          paramParcel.writeInt(paramInt);
          return;
        }
      }
      catch (Exception paramParcel)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("revokeMsg", 2, "revokeMsgInfo writeToParcel failed");
      }
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.revokemsg.RevokeMsgInfo
 * JD-Core Version:    0.7.0.1
 */