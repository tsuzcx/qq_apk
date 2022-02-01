package com.tencent.mobileqq.intervideo.singtogether;

import aihb;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aoii;
import aoij;
import com.tencent.mobileqq.app.QQAppInterface;

public class SingTogetherSession
  extends aoii
  implements Parcelable
{
  public static final Parcelable.Creator<SingTogetherSession> CREATOR = new aihb();
  public long aby;
  public String aif;
  public int ddn;
  public String jumpUrl;
  public long roomId;
  public String roomName;
  public int roomType;
  public String songName;
  
  public SingTogetherSession(int paramInt, String paramString)
  {
    this.serviceType = 4;
    this.type = paramInt;
    this.uin = paramString;
  }
  
  private SingTogetherSession(Parcel paramParcel)
  {
    this.serviceType = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.timeStamp = paramParcel.readLong();
    this.deR = paramParcel.readInt();
    this.ckN = paramParcel.readString();
    this.dOD = paramParcel.readInt();
    this.aif = paramParcel.readString();
    this.aby = paramParcel.readLong();
    this.songName = paramParcel.readString();
    this.apd = paramParcel.readLong();
  }
  
  private String w(QQAppInterface paramQQAppInterface)
  {
    String str = "";
    if (this.type == 2) {
      if (!TextUtils.isEmpty(this.ckN))
      {
        paramQQAppInterface = p(paramQQAppInterface, this.ckN);
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          str = aoij.M(16, paramQQAppInterface);
        }
      }
    }
    for (;;)
    {
      return str + "发起一起K歌";
      str = "好友";
      continue;
      str = "好友";
      continue;
      if (this.type == 1) {
        if (!TextUtils.isEmpty(this.ckN))
        {
          paramQQAppInterface = h(paramQQAppInterface, this.uin, this.ckN);
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            str = aoij.M(16, paramQQAppInterface);
          } else {
            str = "群友";
          }
        }
        else
        {
          str = "群友";
        }
      }
    }
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return "收起";
    }
    return v(paramQQAppInterface);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ListenTogetherSession{type=" + this.type + ", uin='" + this.uin + '\'' + ", status=" + this.status + ", timeStamp=" + this.timeStamp + ", userState=" + this.deR + ", creator='" + this.ckN + '\'' + ", joinNum='" + this.dOD + '\'' + ", serviceType='" + this.serviceType + '\'' + ", roomCover='" + this.aif + '\'' + ", singerUin='" + this.aby + '\'' + ", songName='" + this.songName + '\'' + ", identifyId=" + this.apd + '}';
  }
  
  public String v(QQAppInterface paramQQAppInterface)
  {
    if (this.status == 3) {}
    do
    {
      return "";
      if (this.type == 2)
      {
        if (this.ddn == 1) {
          return "我正在K歌";
        }
        if (this.ddn == 3) {
          return "你们正在一起K歌";
        }
        if (this.ddn == 2) {
          return "对方正在K歌";
        }
        return w(paramQQAppInterface);
      }
    } while (this.type != 1);
    if (this.dOD > 1) {
      return this.dOD + "人正在一起K歌";
    }
    if (this.dOD == 1) {
      return this.dOD + "人正在K歌";
    }
    return w(paramQQAppInterface);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.serviceType);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.status);
    paramParcel.writeLong(this.timeStamp);
    paramParcel.writeInt(this.deR);
    paramParcel.writeString(this.ckN);
    paramParcel.writeInt(this.dOD);
    paramParcel.writeString(this.aif);
    paramParcel.writeLong(this.aby);
    paramParcel.writeString(this.songName);
    paramParcel.writeLong(this.apd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession
 * JD-Core Version:    0.7.0.1
 */