package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;

public class WeiShiVideoArticleInfo
  extends BaseVideoArticleInfo
{
  public static final String TABLE_NAME = WeiShiVideoArticleInfo.class.getSimpleName();
  public String videoSubscriptColor;
  public String videoSubscriptTxt;
  
  public WeiShiVideoArticleInfo() {}
  
  protected WeiShiVideoArticleInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.videoSubscriptTxt = paramParcel.readString();
    this.videoSubscriptColor = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.videoSubscriptTxt);
    paramParcel.writeString(this.videoSubscriptColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo
 * JD-Core Version:    0.7.0.1
 */