package com.tencent.android.tpush;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class XGPushTextMessage
  implements Parcelable
{
  public static final Parcelable.Creator<XGPushTextMessage> CREATOR = new XGPushTextMessage.1();
  long a = 0L;
  String b = "";
  String c = "";
  String d = "";
  int e = 100;
  String f = "";
  String g = "";
  private Intent h = null;
  
  protected XGPushTextMessage() {}
  
  protected XGPushTextMessage(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.h = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  Intent a()
  {
    return this.h;
  }
  
  void a(Intent paramIntent)
  {
    this.h = paramIntent;
    if (paramIntent != null) {
      this.h.removeExtra("content");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContent()
  {
    return this.c;
  }
  
  public String getCustomContent()
  {
    return this.d;
  }
  
  public long getMsgId()
  {
    return this.a;
  }
  
  public int getPushChannel()
  {
    return this.e;
  }
  
  public String getTemplateId()
  {
    return this.f;
  }
  
  public String getTitle()
  {
    return this.b;
  }
  
  public String getTraceId()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XGPushTextMessage [msgId = ").append(this.a).append(", title=").append(this.b).append(", content=").append(this.c).append(", customContent=").append(this.d).append(", pushChannel = ").append(this.e).append(", templateId = ").append(this.f).append(", traceId = ").append(this.g).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeParcelable(this.h, 1);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushTextMessage
 * JD-Core Version:    0.7.0.1
 */