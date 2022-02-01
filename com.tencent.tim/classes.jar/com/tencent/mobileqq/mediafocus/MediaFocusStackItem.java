package com.tencent.mobileqq.mediafocus;

import ajav;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaFocusStackItem
  implements Parcelable
{
  public static final Parcelable.Creator<MediaFocusStackItem> CREATOR = new ajav();
  private long BY;
  private int dhI;
  private String mClientId;
  private String mProcessName;
  
  public MediaFocusStackItem(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.dhI = paramInt;
    this.BY = paramLong;
    this.mClientId = paramString1;
    this.mProcessName = paramString2;
  }
  
  public MediaFocusStackItem(Parcel paramParcel)
  {
    this.dhI = paramParcel.readInt();
    this.BY = paramParcel.readLong();
    this.mClientId = paramParcel.readString();
    this.mProcessName = paramParcel.readString();
  }
  
  public int Gf()
  {
    return this.dhI;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getClientId()
  {
    return this.mClientId;
  }
  
  public String getProcessName()
  {
    return this.mProcessName;
  }
  
  public String toString()
  {
    return "MediaFocusStackItem{type='" + this.dhI + '\'' + ", time='" + this.BY + '\'' + ", id='" + this.mClientId + '\'' + ", pname='" + this.mProcessName + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dhI);
    paramParcel.writeLong(this.BY);
    paramParcel.writeString(this.mClientId);
    paramParcel.writeString(this.mProcessName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusStackItem
 * JD-Core Version:    0.7.0.1
 */