package com.tencent.mobileqq.intervideo.yiqikan;

import aiib;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aoii;
import aoij;
import com.tencent.mobileqq.app.QQAppInterface;

public class WatchTogetherSession
  extends aoii
  implements Parcelable
{
  public static final Parcelable.Creator<WatchTogetherSession> CREATOR = new aiib();
  public String aif = "";
  public String jumpurl = "";
  public long roomId;
  public String roomName;
  public int roomType;
  
  public WatchTogetherSession(Parcel paramParcel)
  {
    this.serviceType = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.dOD = paramParcel.readInt();
    this.status = paramParcel.readInt();
    this.deR = paramParcel.readInt();
    this.ckN = paramParcel.readString();
    this.timeStamp = paramParcel.readLong();
    this.videoType = paramParcel.readInt();
    this.dOE = paramParcel.readInt();
    this.ckO = paramParcel.readString();
    this.roomType = paramParcel.readInt();
    this.jumpurl = paramParcel.readString();
    this.roomId = paramParcel.readInt();
    this.roomName = paramParcel.readString();
    this.aif = paramParcel.readString();
    this.apd = paramParcel.readLong();
  }
  
  public WatchTogetherSession(String paramString)
  {
    this.serviceType = 2;
    this.type = 1;
    this.uin = paramString;
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return "收起";
    }
    return v(paramQQAppInterface);
  }
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)super.clone();
    localWatchTogetherSession.serviceType = this.serviceType;
    localWatchTogetherSession.type = this.type;
    localWatchTogetherSession.uin = this.uin;
    localWatchTogetherSession.dOD = this.dOD;
    localWatchTogetherSession.status = this.status;
    localWatchTogetherSession.deR = this.deR;
    localWatchTogetherSession.ckN = this.ckN;
    localWatchTogetherSession.timeStamp = this.timeStamp;
    localWatchTogetherSession.videoType = this.videoType;
    localWatchTogetherSession.dOE = this.dOE;
    localWatchTogetherSession.ckO = this.ckO;
    localWatchTogetherSession.roomType = this.roomType;
    localWatchTogetherSession.jumpurl = this.jumpurl;
    localWatchTogetherSession.roomId = this.roomId;
    localWatchTogetherSession.roomName = this.roomName;
    localWatchTogetherSession.aif = this.aif;
    localWatchTogetherSession.apd = this.apd;
    return localWatchTogetherSession;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WatchTogetherSession{roomType=" + this.roomType + ", jumpurl='" + this.jumpurl + '\'' + ", roomId=" + this.roomId + ", roomName='" + this.roomName + '\'' + ", roomCover='" + this.aif + '\'' + ", serviceType=" + this.serviceType + ", type=" + this.type + ", uin='" + this.uin + '\'' + ", joinNum=" + this.dOD + ", status=" + this.status + ", userState=" + this.deR + ", creator='" + this.ckN + '\'' + ", timeStamp=" + this.timeStamp + ", videoType=" + this.videoType + ", videoJumpType=" + this.dOE + ", videoJumpURL='" + this.ckO + '\'' + ", identifyId=" + this.apd + '}';
  }
  
  public String v(QQAppInterface paramQQAppInterface)
  {
    String str = "";
    if (this.status != 3)
    {
      if (this.dOD != 0) {
        break label90;
      }
      if (TextUtils.isEmpty(this.ckN)) {
        break label84;
      }
      paramQQAppInterface = h(paramQQAppInterface, this.uin, this.ckN);
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break label78;
      }
      paramQQAppInterface = aoij.M(16, paramQQAppInterface);
    }
    for (;;)
    {
      str = paramQQAppInterface + "发起一起看";
      return str;
      label78:
      paramQQAppInterface = "群友";
      continue;
      label84:
      paramQQAppInterface = "群友";
    }
    label90:
    if (this.dOD == 1) {
      return "1人正在看";
    }
    return this.dOD + "人正在一起看";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.serviceType);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.dOD);
    paramParcel.writeInt(this.status);
    paramParcel.writeInt(this.deR);
    paramParcel.writeString(this.ckN);
    paramParcel.writeLong(this.timeStamp);
    paramParcel.writeInt(this.videoType);
    paramParcel.writeInt(this.dOE);
    paramParcel.writeString(this.ckO);
    paramParcel.writeInt(this.roomType);
    paramParcel.writeString(this.jumpurl);
    paramParcel.writeLong(this.roomId);
    paramParcel.writeString(this.roomName);
    paramParcel.writeString(this.aif);
    paramParcel.writeLong(this.apd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession
 * JD-Core Version:    0.7.0.1
 */