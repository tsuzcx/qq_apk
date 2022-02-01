package com.tencent.mobileqq.nearby.now.model;

import ajwp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MedalItem
  implements Parcelable
{
  public static final Parcelable.Creator<MedalItem> CREATOR = new ajwp();
  public long adq;
  public long adr;
  public String bSA;
  public String bSB;
  public String bSC;
  public String bSD;
  public String bSE;
  public int dlp;
  public int dlq;
  public int dlr;
  public int dls;
  public int dlt;
  public int medalId;
  public int medalType;
  
  public MedalItem() {}
  
  public MedalItem(Parcel paramParcel)
  {
    this.medalId = paramParcel.readInt();
    this.dlp = paramParcel.readInt();
    this.bSA = paramParcel.readString();
    this.bSB = paramParcel.readString();
    this.bSC = paramParcel.readString();
    this.medalType = paramParcel.readInt();
    this.adq = paramParcel.readLong();
    this.adr = paramParcel.readLong();
    this.dlq = paramParcel.readInt();
    this.bSD = paramParcel.readString();
    this.bSE = paramParcel.readString();
    this.dlr = paramParcel.readInt();
    this.dls = paramParcel.readInt();
    this.dlt = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MedalItem)) {}
    do
    {
      return false;
      paramObject = (MedalItem)paramObject;
    } while (paramObject.medalId != this.medalId);
    return equalsString(paramObject.bSA, this.bSA);
  }
  
  public boolean equalsString(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 != null)) {}
    while (((paramString1 != null) && (paramString2 == null)) || ((paramString1 != null) && (!paramString1.equals(paramString2)))) {
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.medalId);
    paramParcel.writeInt(this.dlp);
    paramParcel.writeString(this.bSA);
    paramParcel.writeString(this.bSB);
    paramParcel.writeString(this.bSC);
    paramParcel.writeInt(this.medalType);
    paramParcel.writeLong(this.adq);
    paramParcel.writeLong(this.adr);
    paramParcel.writeInt(this.dlq);
    paramParcel.writeString(this.bSD);
    paramParcel.writeString(this.bSE);
    paramParcel.writeInt(this.dlr);
    paramParcel.writeInt(this.dls);
    paramParcel.writeInt(this.dlt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.MedalItem
 * JD-Core Version:    0.7.0.1
 */