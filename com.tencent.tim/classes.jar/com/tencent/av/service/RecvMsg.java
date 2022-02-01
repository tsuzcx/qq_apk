package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import iut;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new iut();
  static String TAG = "RecvMsg";
  String QB;
  String QC;
  int atM;
  public int atN;
  public int atO;
  public int atP;
  public int atQ;
  String mFriendUin;
  String mMsg;
  String mSenderUin;
  public int msgType;
  String nS;
  public long oh;
  
  public RecvMsg()
  {
    this.atM = 0;
    this.nS = null;
    this.mFriendUin = null;
    this.mSenderUin = null;
    this.QB = null;
    this.mMsg = null;
    this.atN = 0;
    this.atO = 0;
    this.atP = 0;
    this.oh = 0L;
    this.QC = "";
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMsg()
  {
    return this.mMsg;
  }
  
  public String getSenderName()
  {
    return this.QB;
  }
  
  public String hf()
  {
    return this.mSenderUin;
  }
  
  public String hg()
  {
    return this.mFriendUin;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.atM = paramParcel.readInt();
      this.nS = paramParcel.readString();
      this.mFriendUin = paramParcel.readString();
      this.mSenderUin = paramParcel.readString();
      this.QB = paramParcel.readString();
      this.mMsg = paramParcel.readString();
      this.atN = paramParcel.readInt();
      this.atO = paramParcel.readInt();
      this.atP = paramParcel.readInt();
      this.oh = paramParcel.readLong();
      this.QC = paramParcel.readString();
      this.msgType = paramParcel.readInt();
      this.atQ = paramParcel.readInt();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public String toString()
  {
    return TAG + ", mVipBubbleId:" + this.atM + ", mAccountUin:" + this.nS + ", mFriendUin:" + this.mFriendUin + ", mSenderUin:" + this.mSenderUin + ", mSenderName:" + this.QB + ", mMsg:" + this.mMsg + ", msgType:" + this.msgType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.atM);
      paramParcel.writeString(this.nS);
      paramParcel.writeString(this.mFriendUin);
      paramParcel.writeString(this.mSenderUin);
      paramParcel.writeString(this.QB);
      paramParcel.writeString(this.mMsg);
      paramParcel.writeInt(this.atN);
      paramParcel.writeInt(this.atO);
      paramParcel.writeInt(this.atP);
      paramParcel.writeLong(this.oh);
      paramParcel.writeString(this.QC);
      paramParcel.writeInt(this.msgType);
      paramParcel.writeInt(this.atQ);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.RecvMsg
 * JD-Core Version:    0.7.0.1
 */