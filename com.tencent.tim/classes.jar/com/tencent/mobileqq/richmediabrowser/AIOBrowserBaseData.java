package com.tencent.mobileqq.richmediabrowser;

import amcc;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public abstract class AIOBrowserBaseData
  extends RichMediaBaseData
{
  public static final Parcelable.Creator<AIOBrowserBaseData> CREATOR = new amcc();
  public boolean bjq;
  public boolean isInMixedMsg;
  public boolean isMultiMsg;
  public int istroop;
  public long msgId;
  public long shmsgseq;
  public long size;
  public int subId;
  public long time;
  
  public static AIOBrowserBaseData a(String paramString)
    throws ClassNotFoundException
  {
    if (AIOPictureData.class.getSimpleName().equals(paramString)) {
      return new AIOPictureData();
    }
    if (AIOVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOVideoData();
    }
    if (AIOFilePictureData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePictureData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.readFromParcel(paramParcel);
    this.msgId = paramParcel.readLong();
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
        break label106;
      }
      bool1 = true;
      label80:
      this.isInMixedMsg = bool1;
      if (paramParcel.readInt() != 1) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bjq = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.msgId);
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
        break label104;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      if (!this.bjq) {
        break label109;
      }
    }
    label104:
    label109:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData
 * JD-Core Version:    0.7.0.1
 */