package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import iur;
import ius;
import java.util.ArrayList;
import java.util.List;

public class RecvGVideoLevelInfo
  implements Parcelable, Cloneable, Comparable<RecvGVideoLevelInfo>
{
  public static final Parcelable.Creator<RecvGVideoLevelInfo> CREATOR = new iur();
  static String TAG = "RecvGVideoLevelInfo";
  public int alW;
  public int atH;
  public int atI;
  public int atJ;
  public int atK;
  public int atL;
  public List<Medal> fw;
  public int identity;
  public String nickName;
  public int score;
  public long uin;
  
  public RecvGVideoLevelInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, List<Medal> paramList)
  {
    this.uin = paramLong;
    this.atH = paramInt1;
    this.atI = paramInt2;
    this.alW = paramInt3;
    this.score = paramInt4;
    this.atJ = paramInt5;
    this.atK = paramInt6;
    this.atL = paramInt7;
    this.identity = paramInt8;
    this.nickName = paramString;
    this.fw = paramList;
  }
  
  public RecvGVideoLevelInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int a(RecvGVideoLevelInfo paramRecvGVideoLevelInfo)
  {
    int i = lF();
    int j = paramRecvGVideoLevelInfo.lF();
    if (i != j) {
      return i - j;
    }
    if (this.identity != paramRecvGVideoLevelInfo.identity) {
      return this.identity - paramRecvGVideoLevelInfo.identity;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lF()
  {
    if ((this.fw == null) || (this.fw.size() == 0)) {}
    for (;;)
    {
      return 0;
      int i = 0;
      while (i < this.fw.size())
      {
        Medal localMedal = (Medal)this.fw.get(i);
        if (localMedal.type == 1) {
          return localMedal.level;
        }
        i += 1;
      }
    }
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.uin = paramParcel.readLong();
      this.atH = paramParcel.readInt();
      this.atI = paramParcel.readInt();
      this.alW = paramParcel.readInt();
      this.score = paramParcel.readInt();
      this.atJ = paramParcel.readInt();
      this.atK = paramParcel.readInt();
      this.atL = paramParcel.readInt();
      this.identity = paramParcel.readInt();
      this.nickName = paramParcel.readString();
      this.fw = new ArrayList();
      paramParcel.readTypedList(this.fw, Medal.CREATOR);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.uin);
      paramParcel.writeInt(this.atH);
      paramParcel.writeInt(this.atI);
      paramParcel.writeInt(this.alW);
      paramParcel.writeInt(this.score);
      paramParcel.writeInt(this.atJ);
      paramParcel.writeInt(this.atK);
      paramParcel.writeInt(this.atL);
      paramParcel.writeInt(this.identity);
      paramParcel.writeString(this.nickName);
      paramParcel.writeTypedList(this.fw);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
  
  public static class Medal
    implements Parcelable
  {
    public static final Parcelable.Creator<Medal> CREATOR = new ius();
    public String QA;
    public String iconUrl;
    public int id;
    public int level;
    public String name;
    public int type;
    
    public Medal(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
    {
      this.id = paramInt1;
      this.level = paramInt2;
      this.type = paramInt3;
      this.iconUrl = paramString1;
      this.QA = paramString2;
      this.name = paramString3;
    }
    
    public Medal(Parcel paramParcel)
    {
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      try
      {
        this.id = paramParcel.readInt();
        this.level = paramParcel.readInt();
        this.type = paramParcel.readInt();
        this.iconUrl = paramParcel.readString();
        this.QA = paramParcel.readString();
        this.name = paramParcel.readString();
        return;
      }
      catch (RuntimeException paramParcel)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(RecvGVideoLevelInfo.TAG, 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      try
      {
        paramParcel.writeInt(this.id);
        paramParcel.writeInt(this.level);
        paramParcel.writeInt(this.type);
        paramParcel.writeString(this.iconUrl);
        paramParcel.writeString(this.QA);
        paramParcel.writeString(this.name);
        return;
      }
      catch (RuntimeException paramParcel)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(RecvGVideoLevelInfo.TAG, 2, "writeToParcel RuntimeException", paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.RecvGVideoLevelInfo
 * JD-Core Version:    0.7.0.1
 */