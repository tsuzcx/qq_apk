package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import java.io.File;
import xue;

public abstract class AIORichMediaData
  implements Parcelable
{
  public static final Parcelable.Creator<AIORichMediaData> CREATOR = new xue();
  public boolean bjq;
  public long id;
  public boolean isInMixedMsg;
  public boolean isMultiMsg;
  public int istroop;
  public long shmsgseq;
  public long size;
  public int subId;
  public long time;
  
  public static AIORichMediaData a(String paramString)
    throws ClassNotFoundException
  {
    if (AIOImageData.class.getSimpleName().equals(paramString)) {
      return new AIOImageData();
    }
    if (AIOShortVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOShortVideoData();
    }
    if (AIODevLittleVideoData.class.getSimpleName().equals(paramString)) {
      return new AIODevLittleVideoData();
    }
    if (AIOFilePicData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePicData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    if (AIOLightVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOLightVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public abstract File c(int paramInt);
  
  public abstract String cH(int paramInt);
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract boolean gF(int paramInt);
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.id = paramParcel.readLong();
    this.subId = paramParcel.readInt();
    this.time = paramParcel.readLong();
    this.size = paramParcel.readLong();
    this.shmsgseq = paramParcel.readLong();
    this.istroop = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.isMultiMsg = bool1;
      if (paramParcel.readInt() != 1) {
        break label101;
      }
      bool1 = true;
      label75:
      this.isInMixedMsg = bool1;
      if (paramParcel.readInt() != 1) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bjq = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label75;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(getClass().getSimpleName());
    paramParcel.writeLong(this.id);
    paramParcel.writeInt(this.subId);
    paramParcel.writeLong(this.time);
    paramParcel.writeLong(this.size);
    paramParcel.writeLong(this.shmsgseq);
    paramParcel.writeInt(this.istroop);
    if (this.isMultiMsg)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.isInMixedMsg) {
        break label109;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.bjq) {
        break label114;
      }
    }
    label109:
    label114:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
 * JD-Core Version:    0.7.0.1
 */