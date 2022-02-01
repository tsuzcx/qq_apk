package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class UserInfoBean
  implements Parcelable
{
  public static final Parcelable.Creator<UserInfoBean> CREATOR = new UserInfoBean.1();
  public long a;
  public int b;
  public String c;
  public String d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public String j;
  public long k = 0L;
  public boolean l = false;
  public String m = "unknown";
  public String n;
  public int o;
  public int p = -1;
  public int q = -1;
  public Map<String, String> r = null;
  public Map<String, String> s = null;
  
  public UserInfoBean() {}
  
  public UserInfoBean(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readString();
    this.k = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.l = bool;
      this.m = paramParcel.readString();
      this.p = paramParcel.readInt();
      this.q = paramParcel.readInt();
      this.r = z.b(paramParcel);
      this.s = z.b(paramParcel);
      this.n = paramParcel.readString();
      this.o = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeLong(this.k);
    if (this.l) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.m);
      paramParcel.writeInt(this.p);
      paramParcel.writeInt(this.q);
      z.b(paramParcel, this.r);
      z.b(paramParcel, this.s);
      paramParcel.writeString(this.n);
      paramParcel.writeInt(this.o);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.UserInfoBean
 * JD-Core Version:    0.7.0.1
 */