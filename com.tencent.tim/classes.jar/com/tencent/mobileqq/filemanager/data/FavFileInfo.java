package com.tencent.mobileqq.filemanager.data;

import agna;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FavFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FavFileInfo> CREATOR = new agna();
  public String bIj;
  public String bIk;
  public String bIl;
  public String bIm;
  public boolean cet;
  public long favId;
  public String md5;
  public long mtime;
  public long nFileSize;
  public String sha;
  public String strFileName;
  
  public FavFileInfo() {}
  
  public FavFileInfo(Parcel paramParcel)
  {
    this.favId = paramParcel.readLong();
    this.bIj = paramParcel.readString();
    this.bIk = paramParcel.readString();
    this.strFileName = paramParcel.readString();
    this.bIl = paramParcel.readString();
    this.nFileSize = paramParcel.readLong();
    this.mtime = paramParcel.readLong();
    this.md5 = paramParcel.readString();
    this.sha = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cet = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.favId);
    paramParcel.writeString(this.bIj);
    paramParcel.writeString(this.bIk);
    paramParcel.writeString(this.strFileName);
    paramParcel.writeString(this.bIl);
    paramParcel.writeLong(this.nFileSize);
    paramParcel.writeLong(this.mtime);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.sha);
    if (this.cet) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FavFileInfo
 * JD-Core Version:    0.7.0.1
 */