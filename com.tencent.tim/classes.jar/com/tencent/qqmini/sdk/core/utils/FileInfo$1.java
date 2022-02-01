package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FileInfo$1
  implements Parcelable.Creator<FileInfo>
{
  public FileInfo createFromParcel(Parcel paramParcel)
  {
    return new FileInfo(paramParcel, null);
  }
  
  public FileInfo[] newArray(int paramInt)
  {
    return new FileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileInfo.1
 * JD-Core Version:    0.7.0.1
 */