package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import tgm;
import thq;
import tkw;

public class GdtInterstitialParams
  extends tgm
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new thq();
  public GdtHandler.Options a;
  public boolean aOZ;
  public int height = -2147483648;
  public int orientation = -2147483648;
  public int width = -2147483648;
  
  public GdtInterstitialParams() {}
  
  public GdtInterstitialParams(Parcel paramParcel)
  {
    if (paramParcel == null)
    {
      tkw.e("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
      return;
    }
    this.a = ((GdtHandler.Options)paramParcel.readParcelable(GdtHandler.Options.class.getClassLoader()));
    this.orientation = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aOZ = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getTraceId()
  {
    if (!isValid()) {}
    while ((this.a.ad == null) || (!this.a.ad.isValid())) {
      return null;
    }
    return this.a.ad.getTraceId();
  }
  
  public boolean iD()
  {
    return (isValid()) && (this.a.isValid());
  }
  
  public boolean isValid()
  {
    return (this.a != null) && (this.orientation != -2147483648);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null)
    {
      tkw.e("GdtInterstitialParams", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeInt(this.orientation);
    if (this.aOZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */