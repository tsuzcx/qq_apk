package com.tencent.tim.timfiletab.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aunk;

public class TeamFileEntity
  implements Parcelable
{
  public static final Parcelable.Creator<TeamFileEntity> CREATOR = new aunk();
  public String cIG;
  public String cjj;
  public String fileName;
  public long fileSize;
  public int fileType = -1;
  public long height;
  public String localPath;
  public String padId;
  public long width;
  
  public TeamFileEntity() {}
  
  public TeamFileEntity(Parcel paramParcel)
  {
    this.fileType = paramParcel.readInt();
    this.cjj = paramParcel.readString();
    this.padId = paramParcel.readString();
    this.cIG = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.localPath = paramParcel.readString();
    this.fileSize = paramParcel.readLong();
    this.width = paramParcel.readLong();
    this.height = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.cjj);
    paramParcel.writeString(this.padId);
    paramParcel.writeString(this.cIG);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.localPath);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeLong(this.width);
    paramParcel.writeLong(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.data.TeamFileEntity
 * JD-Core Version:    0.7.0.1
 */