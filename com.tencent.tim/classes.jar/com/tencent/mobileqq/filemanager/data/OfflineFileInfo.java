package com.tencent.mobileqq.filemanager.data;

import agni;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OfflineFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OfflineFileInfo> CREATOR = new agni();
  public long Zm;
  public long Zn;
  public String bHK;
  public String bHL;
  public String bIz;
  public boolean bSend;
  public int cYg;
  private int cYh = 1;
  public long nFileSize;
  public String strFileName;
  public long uFriendUin;
  
  public OfflineFileInfo() {}
  
  public OfflineFileInfo(Parcel paramParcel)
  {
    this.cYh = paramParcel.readInt();
    this.bHK = paramParcel.readString();
    this.uFriendUin = paramParcel.readLong();
    this.cYg = paramParcel.readInt();
    this.strFileName = paramParcel.readString();
    this.nFileSize = paramParcel.readLong();
    this.Zm = paramParcel.readLong();
    this.Zn = paramParcel.readLong();
    this.bIz = paramParcel.readString();
    if (this.cYh == 2)
    {
      this.bSend = true;
      return;
    }
    this.bSend = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bSend[").append(this.bSend).append("]");
    localStringBuilder.append("strUuid[").append(this.bHK).append("]");
    localStringBuilder.append("uFriendUin[").append(this.uFriendUin).append("]");
    localStringBuilder.append("nDangerLv[").append(this.cYg).append("]");
    localStringBuilder.append("strFileName[").append(this.strFileName).append("]");
    localStringBuilder.append("nFileSize[").append(this.nFileSize).append("]");
    localStringBuilder.append("nLiftTime[").append(this.Zm).append("]");
    localStringBuilder.append("nUploadTime[").append(this.Zn).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.bSend) {}
    for (this.cYh = 2;; this.cYh = 1)
    {
      paramParcel.writeInt(this.cYh);
      paramParcel.writeString(this.bHK);
      paramParcel.writeLong(this.uFriendUin);
      paramParcel.writeInt(this.cYg);
      paramParcel.writeString(this.strFileName);
      paramParcel.writeLong(this.nFileSize);
      paramParcel.writeLong(this.Zm);
      paramParcel.writeLong(this.Zn);
      paramParcel.writeString(this.bIz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OfflineFileInfo
 * JD-Core Version:    0.7.0.1
 */