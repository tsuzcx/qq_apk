package com.tencent.mobileqq.medalwall;

import ajaj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MedalID
  implements Parcelable
{
  public static final Parcelable.Creator<MedalID> CREATOR = new ajaj();
  public int id;
  public int level;
  
  public MedalID(int paramInt1, int paramInt2)
  {
    this.id = paramInt1;
    this.level = paramInt2;
  }
  
  public MedalID(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.level = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalID
 * JD-Core Version:    0.7.0.1
 */