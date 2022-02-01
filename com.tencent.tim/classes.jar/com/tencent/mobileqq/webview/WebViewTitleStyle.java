package com.tencent.mobileqq.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqyy;

public class WebViewTitleStyle
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewTitleStyle> CREATOR = new aqyy();
  public int edP;
  public int statusBarColor;
  public int titleColor;
  public int wP;
  
  public WebViewTitleStyle() {}
  
  public WebViewTitleStyle(Parcel paramParcel)
  {
    this.statusBarColor = paramParcel.readInt();
    this.wP = paramParcel.readInt();
    this.titleColor = paramParcel.readInt();
    this.edP = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.statusBarColor);
    paramParcel.writeInt(this.wP);
    paramParcel.writeInt(this.titleColor);
    paramParcel.writeInt(this.edP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */