package com.tencent.mobileqq.activity.richmedia.subtitles;

import aauo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WordingItem
  implements Parcelable
{
  public static final Parcelable.Creator<WordingItem> CREATOR = new aauo();
  public long MH;
  public String beq;
  public String ber;
  public byte[] cE;
  public long mID;
  public long qB;
  
  public WordingItem() {}
  
  public WordingItem(Parcel paramParcel)
  {
    this.mID = paramParcel.readLong();
    this.qB = paramParcel.readLong();
    this.MH = paramParcel.readLong();
    this.beq = paramParcel.readString();
    this.ber = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.cE = new byte[i];
      paramParcel.readByteArray(this.cE);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mID);
    paramParcel.writeLong(this.qB);
    paramParcel.writeLong(this.MH);
    paramParcel.writeString(this.beq);
    paramParcel.writeString(this.ber);
    paramInt = 0;
    if (this.cE != null) {
      paramInt = this.cE.length;
    }
    paramParcel.writeInt(paramInt);
    if (paramInt > 0) {
      paramParcel.writeByteArray(this.cE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem
 * JD-Core Version:    0.7.0.1
 */