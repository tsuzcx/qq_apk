package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import u;

public class SmsRawData
  implements Parcelable
{
  public static final Parcelable.Creator<SmsRawData> CREATOR = new u();
  byte[] data;
  
  public SmsRawData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.data.length);
    paramParcel.writeByteArray(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.android.internal.telephony.SmsRawData
 * JD-Core Version:    0.7.0.1
 */