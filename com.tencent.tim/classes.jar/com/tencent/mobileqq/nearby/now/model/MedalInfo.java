package com.tencent.mobileqq.nearby.now.model;

import ajwn;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MedalInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MedalInfo> CREATOR = new ajwn();
  public List<MedalItem> DH = new ArrayList();
  public int dln;
  public int dlo;
  public int level;
  
  public MedalInfo() {}
  
  public MedalInfo(Parcel paramParcel)
  {
    this.level = paramParcel.readInt();
    this.dln = paramParcel.readInt();
    this.dlo = paramParcel.readInt();
    paramParcel.readTypedList(this.DH, MedalItem.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MedalInfo)) {}
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.level);
    paramParcel.writeInt(this.dln);
    paramParcel.writeInt(this.dlo);
    if (this.DH != null) {
      paramParcel.writeTypedList(this.DH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.MedalInfo
 * JD-Core Version:    0.7.0.1
 */