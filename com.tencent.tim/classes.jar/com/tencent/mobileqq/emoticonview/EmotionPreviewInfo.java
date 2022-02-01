package com.tencent.mobileqq.emoticonview;

import afou;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EmotionPreviewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionPreviewInfo> CREATOR = new afou();
  public boolean isCheck;
  public String path;
  
  public EmotionPreviewInfo() {}
  
  public EmotionPreviewInfo(Parcel paramParcel)
  {
    this.path = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.isCheck = bool;
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" path: ").append(this.path);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.path);
    if (this.isCheck) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewInfo
 * JD-Core Version:    0.7.0.1
 */