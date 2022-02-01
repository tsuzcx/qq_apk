package com.tencent.mobileqq.nearby.now.model;

import ajwl;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalMediaInfo
  implements Parcelable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new ajwl();
  public long _id;
  public long addedDate;
  public String fakeVid = "";
  public String fileId = "";
  public long fileSize;
  public int index;
  public int latitude;
  public int longitude;
  public long mDuration;
  public String mMimeType;
  public String md5 = "";
  public int mediaHeight;
  public int mediaWidth;
  public long modifiedDate;
  public int orientation;
  public String path;
  public Integer position = Integer.valueOf(-1);
  public int rotation;
  public int selectStatus = 2;
  public int thumbHeight;
  public int thumbWidth;
  public String url = "";
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {}
    do
    {
      return -1;
      if (paramLocalMediaInfo.modifiedDate > this.modifiedDate) {
        return 1;
      }
    } while (paramLocalMediaInfo.modifiedDate != this.modifiedDate);
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + '\'' + ", fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + this.orientation + ", mDuration=" + this.mDuration + ", selectStatus=" + this.selectStatus + ", rotation=" + this.rotation + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", index=" + this.index + ", position=" + this.position + ", mMimeType='" + this.mMimeType + '\'' + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._id);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeLong(this.addedDate);
    paramParcel.writeLong(this.modifiedDate);
    paramParcel.writeInt(this.orientation);
    paramParcel.writeInt(this.rotation);
    paramParcel.writeLong(this.mDuration);
    paramParcel.writeInt(this.selectStatus);
    paramParcel.writeInt(this.thumbWidth);
    paramParcel.writeInt(this.thumbHeight);
    paramParcel.writeInt(this.index);
    paramParcel.writeInt(this.position.intValue());
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.mediaWidth);
    paramParcel.writeInt(this.mediaHeight);
    paramParcel.writeInt(this.longitude);
    paramParcel.writeInt(this.latitude);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */