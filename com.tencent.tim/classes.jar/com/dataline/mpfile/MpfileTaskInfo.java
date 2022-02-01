package com.dataline.mpfile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cs;

public class MpfileTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MpfileTaskInfo> CREATOR = new cs();
  public static int dC;
  public static int dE = 1;
  public static int dF = 2;
  public static int dG = 3;
  public static int dH = 4;
  public long ak;
  public long al = System.currentTimeMillis();
  public long am;
  public long currentSize;
  public long din;
  public String fileId;
  public String fileMd5;
  public String fileName;
  public String filePath;
  public String fileTempPath;
  public String fileTime;
  public String key;
  public int status;
  public long taskId;
  public long totalSize;
  public int type;
  public String url;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.fileTempPath);
    paramParcel.writeString(this.fileMd5);
    paramParcel.writeString(this.fileTime);
    paramParcel.writeLong(this.ak);
    paramParcel.writeLong(this.totalSize);
    paramParcel.writeLong(this.currentSize);
    paramParcel.writeLong(this.taskId);
    paramParcel.writeLong(this.al);
    paramParcel.writeLong(this.am);
    paramParcel.writeLong(this.din);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskInfo
 * JD-Core Version:    0.7.0.1
 */