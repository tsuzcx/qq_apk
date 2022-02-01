package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dy;

public class ImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageInfo> CREATOR = new dy();
  private String mDescription;
  private long mModifiedDate;
  private String mName;
  private String mPath;
  private long mSize;
  
  private ImageInfo(Parcel paramParcel)
  {
    this.mPath = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mSize = paramParcel.readLong();
    this.mModifiedDate = paramParcel.readLong();
    this.mDescription = paramParcel.readString();
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return (this.mName.equals(paramImageInfo.mName)) && (this.mSize == paramImageInfo.mSize) && (this.mModifiedDate == paramImageInfo.mModifiedDate) && (this.mPath.equals(paramImageInfo.mPath));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof ImageInfo))) {
      return false;
    }
    return a((ImageInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (this.mName + this.mSize + this.mModifiedDate).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPath);
    paramParcel.writeString(this.mName);
    paramParcel.writeLong(this.mSize);
    paramParcel.writeLong(this.mModifiedDate);
    paramParcel.writeString(this.mDescription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.util.file.ImageInfo
 * JD-Core Version:    0.7.0.1
 */