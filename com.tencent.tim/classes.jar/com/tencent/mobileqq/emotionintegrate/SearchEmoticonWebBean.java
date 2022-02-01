package com.tencent.mobileqq.emotionintegrate;

import afrv;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchEmoticonWebBean
  implements Parcelable
{
  public static final Parcelable.Creator<SearchEmoticonWebBean> CREATOR = new afrv();
  public String bEN = "";
  public String bEO = "";
  public String bEP = "";
  public String bEQ = "";
  public String bER = "";
  public String bES = "";
  public String bET = "";
  public String bEU = "";
  public String bEV = "";
  public int cTA;
  public int cTB;
  public int cTy;
  public int cTz;
  
  public SearchEmoticonWebBean() {}
  
  public SearchEmoticonWebBean(Parcel paramParcel)
  {
    this.bEN = paramParcel.readString();
    this.bEO = paramParcel.readString();
    this.bEP = paramParcel.readString();
    this.cTy = paramParcel.readInt();
    this.cTz = paramParcel.readInt();
    this.cTA = paramParcel.readInt();
    this.cTB = paramParcel.readInt();
    this.bEQ = paramParcel.readString();
    this.bER = paramParcel.readString();
    this.bES = paramParcel.readString();
    this.bET = paramParcel.readString();
    this.bEU = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bEN);
    paramParcel.writeString(this.bEO);
    paramParcel.writeString(this.bEP);
    paramParcel.writeInt(this.cTy);
    paramParcel.writeInt(this.cTz);
    paramParcel.writeInt(this.cTA);
    paramParcel.writeInt(this.cTB);
    paramParcel.writeString(this.bEQ);
    paramParcel.writeString(this.bER);
    paramParcel.writeString(this.bES);
    paramParcel.writeString(this.bET);
    paramParcel.writeString(this.bEU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean
 * JD-Core Version:    0.7.0.1
 */