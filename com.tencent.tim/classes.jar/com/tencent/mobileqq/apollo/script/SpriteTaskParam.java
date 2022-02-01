package com.tencent.mobileqq.apollo.script;

import abri;
import abrl;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SpriteTaskParam
  implements Parcelable
{
  public static final Parcelable.Creator<SpriteTaskParam> CREATOR = new abri();
  public abrl a;
  public Bundle av;
  public boolean bEW;
  public int bGG;
  public String bbE;
  public String bhv;
  public String bhw;
  public String bhx;
  public int crb;
  public int crd;
  public int cre;
  public int crg;
  public int crh = 1;
  public int cri;
  public int crj;
  public int mActionId;
  public int mActionType;
  public int mAioType;
  public boolean mIsSend;
  public long mMsgId;
  public String mSenderUin;
  public int mStatus;
  public int mTaskId;
  public float sC = 0.0F;
  public ArrayList<Integer> sM;
  public ArrayList<Integer> sN;
  
  public SpriteTaskParam() {}
  
  public SpriteTaskParam(Parcel paramParcel)
  {
    this.mTaskId = paramParcel.readInt();
    this.mStatus = paramParcel.readInt();
    this.mActionType = paramParcel.readInt();
    this.bGG = paramParcel.readInt();
    this.crb = paramParcel.readInt();
    this.mActionId = paramParcel.readInt();
    this.crd = paramParcel.readInt();
    this.mMsgId = paramParcel.readLong();
    this.mAioType = paramParcel.readInt();
    this.mSenderUin = paramParcel.readString();
    this.bbE = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.mIsSend = bool1;
      this.cre = paramParcel.readInt();
      this.sC = paramParcel.readFloat();
      this.bhv = paramParcel.readString();
      this.crg = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bEW = bool1;
      this.bhw = paramParcel.readString();
      this.crh = paramParcel.readInt();
      this.bhx = paramParcel.readString();
      this.cri = paramParcel.readInt();
      this.crj = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SpriteTaskParam{");
    localStringBuffer.append("mTaskId=").append(this.mTaskId);
    localStringBuffer.append(", mStatus=").append(this.mStatus);
    localStringBuffer.append(", mActionType=").append(this.mActionType);
    localStringBuffer.append(", mSubType=").append(this.bGG);
    localStringBuffer.append(", mSpriteNum=").append(this.crb);
    localStringBuffer.append(", mActionId=").append(this.mActionId);
    localStringBuffer.append(", mFromWhere=").append(this.crd);
    localStringBuffer.append(", mMsgId=").append(this.mMsgId);
    localStringBuffer.append(", mAioType=").append(this.mAioType);
    localStringBuffer.append(", mSenderUin='").append(this.mSenderUin).append('\'');
    localStringBuffer.append(", mRecvUin='").append(this.bbE).append('\'');
    localStringBuffer.append(", mIsSend=").append(this.mIsSend);
    localStringBuffer.append(", mAudioId=").append(this.cre);
    localStringBuffer.append(", mAudioStartTime=").append(this.sC);
    localStringBuffer.append(", mInputText='").append(this.bhv).append('\'');
    localStringBuffer.append(", mInterruptWay=").append(this.crg);
    localStringBuffer.append(", mTextIsBarrage=").append(this.bEW);
    localStringBuffer.append(", mActionList=").append(this.sM);
    localStringBuffer.append(", mBackgroundActionList=").append(this.sN);
    localStringBuffer.append(", mExtendJson='").append(this.bhw).append('\'');
    localStringBuffer.append(", mBridgeImp=").append(this.a);
    localStringBuffer.append(", mRscType=").append(this.crh);
    localStringBuffer.append(", mActionJs='").append(this.bhx).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mTaskId);
    paramParcel.writeInt(this.mStatus);
    paramParcel.writeInt(this.mActionType);
    paramParcel.writeInt(this.bGG);
    paramParcel.writeInt(this.crb);
    paramParcel.writeInt(this.mActionId);
    paramParcel.writeInt(this.crd);
    paramParcel.writeLong(this.mMsgId);
    paramParcel.writeInt(this.mAioType);
    paramParcel.writeString(this.mSenderUin);
    paramParcel.writeString(this.bbE);
    if (this.mIsSend)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.cre);
      paramParcel.writeFloat(this.sC);
      paramParcel.writeString(this.bhv);
      paramParcel.writeInt(this.crg);
      if (!this.bEW) {
        break label198;
      }
    }
    label198:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.bhw);
      paramParcel.writeInt(this.crh);
      paramParcel.writeString(this.bhx);
      paramParcel.writeInt(this.cri);
      paramParcel.writeInt(this.crj);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskParam
 * JD-Core Version:    0.7.0.1
 */