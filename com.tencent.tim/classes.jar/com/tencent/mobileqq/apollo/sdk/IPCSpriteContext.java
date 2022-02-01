package com.tencent.mobileqq.apollo.sdk;

import absq;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCSpriteContext
  implements Parcelable
{
  public static final Parcelable.Creator<IPCSpriteContext> CREATOR = new absq();
  public float bU = -2.147484E+009F;
  public int cqS;
  public int cqU = 0;
  public int crp;
  public int crq;
  public int mAioType;
  public String mFriendUin;
  public String mSelfUin;
  public float scale = 1.0F;
  public float xPos = -2.147484E+009F;
  
  public IPCSpriteContext() {}
  
  public IPCSpriteContext(Parcel paramParcel)
  {
    this.mAioType = paramParcel.readInt();
    this.mFriendUin = paramParcel.readString();
    this.mSelfUin = paramParcel.readString();
    this.cqS = paramParcel.readInt();
    this.scale = paramParcel.readFloat();
    this.xPos = paramParcel.readFloat();
    this.bU = paramParcel.readFloat();
    this.cqU = paramParcel.readInt();
    this.crp = paramParcel.readInt();
    this.crq = paramParcel.readInt();
  }
  
  public boolean Zb()
  {
    return (this.mAioType == 1) || (this.mAioType == 3000);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mAioType);
    paramParcel.writeString(this.mFriendUin);
    paramParcel.writeString(this.mSelfUin);
    paramParcel.writeInt(this.cqS);
    paramParcel.writeFloat(this.scale);
    paramParcel.writeFloat(this.xPos);
    paramParcel.writeFloat(this.bU);
    paramParcel.writeInt(this.cqU);
    paramParcel.writeInt(this.crp);
    paramParcel.writeInt(this.crq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.IPCSpriteContext
 * JD-Core Version:    0.7.0.1
 */