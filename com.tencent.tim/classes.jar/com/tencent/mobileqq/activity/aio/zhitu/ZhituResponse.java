package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqec.b;
import java.util.List;
import yky;

public class ZhituResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ZhituResponse> CREATOR = new yky();
  public String cat;
  public String cookie;
  public int hasMore;
  @aqec.b(ZhituImgResponse.class)
  public List<ZhituImgResponse> list;
  @aqec.b(String.class)
  public List<String> tokens;
  
  public ZhituResponse() {}
  
  public ZhituResponse(Parcel paramParcel)
  {
    this.cat = paramParcel.readString();
    this.list = paramParcel.createTypedArrayList(ZhituImgResponse.CREATOR);
    this.tokens = paramParcel.createStringArrayList();
    this.cookie = paramParcel.readString();
    this.hasMore = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ZhituResponse{cat='" + this.cat + '\'' + ", list=" + this.list + ", cookie='" + this.cookie + '\'' + ", hasMore=" + this.hasMore + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cat);
    paramParcel.writeTypedList(this.list);
    paramParcel.writeStringList(this.tokens);
    paramParcel.writeString(this.cookie);
    paramParcel.writeInt(this.hasMore);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse
 * JD-Core Version:    0.7.0.1
 */