package com.tencent.biz.qqcircle.style;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import pdj;

public class QCircleWebViewTitleStyle
  extends WebViewTitleStyle
{
  public static final Parcelable.Creator<QCircleWebViewTitleStyle> CREATOR = new pdj();
  public int bht;
  
  public QCircleWebViewTitleStyle() {}
  
  public QCircleWebViewTitleStyle(Parcel paramParcel)
  {
    super(paramParcel);
    this.bht = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.bht);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */