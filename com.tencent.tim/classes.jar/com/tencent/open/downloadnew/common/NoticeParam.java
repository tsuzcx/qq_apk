package com.tencent.open.downloadnew.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asaf;

public class NoticeParam
  implements Parcelable
{
  public static final Parcelable.Creator<NoticeParam> CREATOR = new asaf();
  public String appId = "";
  public Intent as;
  public String cDW = "";
  public String content = "";
  public String nKey = "";
  public int noticeType;
  public String packName = "";
  public long time;
  public String title = "";
  public int typeId;
  public String via;
  
  public NoticeParam() {}
  
  public NoticeParam(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.packName = paramParcel.readString();
    this.cDW = paramParcel.readString();
    this.typeId = paramParcel.readInt();
    this.noticeType = paramParcel.readInt();
    this.nKey = paramParcel.readString();
    this.time = paramParcel.readLong();
    this.as = ((Intent)paramParcel.readParcelable(null));
    this.via = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.packName);
    paramParcel.writeString(this.cDW);
    paramParcel.writeInt(this.typeId);
    paramParcel.writeInt(this.noticeType);
    paramParcel.writeString(this.nKey);
    paramParcel.writeLong(this.time);
    paramParcel.writeParcelable(this.as, paramInt);
    paramParcel.writeString(this.via);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeParam
 * JD-Core Version:    0.7.0.1
 */