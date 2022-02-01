package com.tencent.tpns.mqttchannel.core.common.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.mqttchannel.core.common.c.b;
import org.json.JSONObject;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public int a;
  public volatile boolean b = false;
  private long c;
  private String d;
  private String e;
  private String f = "";
  private int g = 0;
  
  public a(long paramLong, String paramString1, String paramString2)
  {
    this.c = paramLong;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  protected a(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public long a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    if (b.a(paramString)) {
      return;
    }
    try
    {
      if (!b.a(this.e))
      {
        JSONObject localJSONObject = new JSONObject(this.e);
        com.tencent.tpns.mqttchannel.core.common.c.a.b("Request", "Update token to: " + paramString);
        localJSONObject.put("token", paramString);
        this.e = localJSONObject.toString();
        this.f = Md5.md5(this.e);
        return;
      }
    }
    catch (Throwable paramString)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("Request", "setCurrentToken", paramString);
      return;
    }
    com.tencent.tpns.mqttchannel.core.common.c.a.d("Request", "request content null");
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void d()
  {
    this.g += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
    } while ((this.a == paramObject.a) && (this.c == paramObject.c));
    return false;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return "Request{type=" + this.a + ", id=" + this.c + ", topic='" + this.d + '\'' + ", content='" + this.e + '\'' + ", retryCount=" + this.g + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.a.a
 * JD-Core Version:    0.7.0.1
 */