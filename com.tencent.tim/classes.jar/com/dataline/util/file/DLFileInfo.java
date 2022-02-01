package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dw;

public class DLFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DLFileInfo> CREATOR = new dw();
  public String fileName;
  public long fileSize;
  public String localPath;
  public long sessionid;
  public int state;
  
  public DLFileInfo() {}
  
  private DLFileInfo(Parcel paramParcel)
  {
    this.sessionid = paramParcel.readLong();
    this.state = paramParcel.readInt();
    this.localPath = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.fileSize = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.sessionid);
    paramParcel.writeInt(this.state);
    paramParcel.writeString(this.localPath);
    paramParcel.writeString(this.fileName);
    paramParcel.writeLong(this.fileSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.util.file.DLFileInfo
 * JD-Core Version:    0.7.0.1
 */