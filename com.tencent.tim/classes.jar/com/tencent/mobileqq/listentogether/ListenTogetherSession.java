package com.tencent.mobileqq.listentogether;

import acfp;
import aioa;
import aiob;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aoii;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.ArrayList;
import java.util.List;

public class ListenTogetherSession
  extends aoii
  implements Parcelable
{
  public static final Parcelable.Creator<ListenTogetherSession> CREATOR = new aioa();
  public List<MusicInfo> CA;
  public String bPm;
  public String bPn;
  public boolean cbN;
  public boolean ckL;
  public boolean ckM;
  public boolean ckN;
  public int deh;
  public int playMode = 1;
  public int themeId;
  
  public ListenTogetherSession(int paramInt, String paramString)
  {
    this.serviceType = 1;
    this.type = paramInt;
    this.uin = paramString;
  }
  
  private ListenTogetherSession(Parcel paramParcel)
  {
    this.serviceType = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.CA = new ArrayList();
    paramParcel.readTypedList(this.CA, MusicInfo.CREATOR);
    this.timeStamp = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.cbN = bool1;
      this.deR = paramParcel.readInt();
      this.bPm = paramParcel.readString();
      this.jdField_ckN_of_type_JavaLangString = paramParcel.readString();
      this.deh = paramParcel.readInt();
      this.bPn = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ckL = bool1;
      this.playMode = paramParcel.readInt();
      this.apd = paramParcel.readLong();
      this.creatorNick = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int FI()
  {
    int i = 1;
    if (this.type == 1) {
      i = -1;
    }
    do
    {
      return i;
      if (acfp.m(2131695322).equals(this.bPm)) {
        return 3;
      }
      if (acfp.m(2131695333).equals(this.bPm)) {
        return 2;
      }
    } while (acfp.m(2131695352).equals(this.bPm));
    return 4;
  }
  
  public String I(int paramInt1, int paramInt2)
  {
    return aiob.k(this.type, paramInt1, paramInt2);
  }
  
  public MusicInfo b()
  {
    if (this.status == 3) {}
    while ((this.CA == null) || (this.CA.size() <= 0)) {
      return null;
    }
    return (MusicInfo)this.CA.get(0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(ListenTogetherSession paramListenTogetherSession)
  {
    this.status = paramListenTogetherSession.status;
    this.deR = paramListenTogetherSession.deR;
    this.bPm = paramListenTogetherSession.bPm;
    this.jdField_ckN_of_type_JavaLangString = paramListenTogetherSession.jdField_ckN_of_type_JavaLangString;
    this.creatorNick = paramListenTogetherSession.creatorNick;
    this.deh = paramListenTogetherSession.deh;
    this.bPn = paramListenTogetherSession.bPn;
    this.ckL = paramListenTogetherSession.ckL;
    this.timeStamp = paramListenTogetherSession.timeStamp;
    this.CA = paramListenTogetherSession.CA;
    this.themeId = paramListenTogetherSession.themeId;
    this.ckM = paramListenTogetherSession.ckM;
    this.jdField_ckN_of_type_Boolean = paramListenTogetherSession.jdField_ckN_of_type_Boolean;
    this.playMode = paramListenTogetherSession.playMode;
    this.apd = paramListenTogetherSession.apd;
  }
  
  public String getKey()
  {
    return this.type + "_" + this.uin;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ListenTogetherSession{type=").append(this.type).append(", uin='").append(this.uin).append('\'').append(", status=").append(this.status).append(", musicList=").append(this.CA).append(", timeStamp=").append(this.timeStamp).append(", fold=").append(this.cbN).append(", userState=").append(this.deR).append(", joinedNum=").append(this.bPm).append(", creator='").append(this.jdField_ckN_of_type_JavaLangString).append('\'').append(", creatorNick='");
    if (this.creatorNick == null) {}
    for (String str = "null";; str = this.creatorNick) {
      return str + '\'' + ", playMode='" + this.playMode + '\'' + ", joinedType=" + this.deh + ", joinedUin='" + this.bPn + '\'' + ", joinedIsCreator=" + this.ckL + ", themeId=" + this.themeId + ", bAlowMemberStart=" + this.ckM + ", bAlowMemberAddSong=" + this.jdField_ckN_of_type_Boolean + ", identifyId=" + this.apd + '}';
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.serviceType);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.status);
    paramParcel.writeTypedList(this.CA);
    paramParcel.writeLong(this.timeStamp);
    if (this.cbN)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.deR);
      paramParcel.writeString(this.bPm);
      paramParcel.writeString(this.jdField_ckN_of_type_JavaLangString);
      paramParcel.writeInt(this.deh);
      paramParcel.writeString(this.bPn);
      if (!this.ckL) {
        break label150;
      }
    }
    label150:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.playMode);
      paramParcel.writeLong(this.apd);
      paramParcel.writeString(this.creatorNick);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherSession
 * JD-Core Version:    0.7.0.1
 */