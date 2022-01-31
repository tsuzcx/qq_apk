package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.z;
import java.util.Map;
import java.util.UUID;

public class CrashDetailBean
  implements Parcelable, Comparable<CrashDetailBean>
{
  public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator() {};
  public String A = "";
  public String B = "";
  public long C = -1L;
  public long D = -1L;
  public long E = -1L;
  public long F = -1L;
  public long G = -1L;
  public long H = -1L;
  public String I = "";
  public String J = "";
  public String K = "";
  public String L = "";
  public long M = -1L;
  public boolean N = false;
  public Map<String, String> O = null;
  public int P = -1;
  public int Q = -1;
  public Map<String, String> R = null;
  public Map<String, String> S = null;
  public byte[] T = null;
  public String U = null;
  public String V = null;
  private String W = "";
  public long a = -1L;
  public int b = 0;
  public String c = UUID.randomUUID().toString();
  public boolean d = false;
  public String e = "";
  public String f = "";
  public String g = "";
  public Map<String, PlugInBean> h = null;
  public Map<String, PlugInBean> i = null;
  public boolean j = false;
  public boolean k = false;
  public int l = 0;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public long r = -1L;
  public String s = null;
  public int t = 0;
  public String u = "";
  public String v = "";
  public String w = null;
  public String x = null;
  public byte[] y = null;
  public Map<String, String> z = null;
  
  public CrashDetailBean() {}
  
  public CrashDetailBean(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.d = bool1;
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label709;
      }
      bool1 = true;
      label356:
      this.j = bool1;
      if (paramParcel.readByte() != 1) {
        break label714;
      }
      bool1 = true;
      label371:
      this.k = bool1;
      this.l = paramParcel.readInt();
      this.m = paramParcel.readString();
      this.n = paramParcel.readString();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      this.q = paramParcel.readString();
      this.r = paramParcel.readLong();
      this.s = paramParcel.readString();
      this.t = paramParcel.readInt();
      this.u = paramParcel.readString();
      this.v = paramParcel.readString();
      this.w = paramParcel.readString();
      this.z = z.b(paramParcel);
      this.A = paramParcel.readString();
      this.B = paramParcel.readString();
      this.C = paramParcel.readLong();
      this.D = paramParcel.readLong();
      this.E = paramParcel.readLong();
      this.F = paramParcel.readLong();
      this.G = paramParcel.readLong();
      this.H = paramParcel.readLong();
      this.I = paramParcel.readString();
      this.W = paramParcel.readString();
      this.J = paramParcel.readString();
      this.K = paramParcel.readString();
      this.L = paramParcel.readString();
      this.M = paramParcel.readLong();
      if (paramParcel.readByte() != 1) {
        break label719;
      }
    }
    label709:
    label714:
    label719:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.N = bool1;
      this.O = z.b(paramParcel);
      this.h = z.a(paramParcel);
      this.i = z.a(paramParcel);
      this.P = paramParcel.readInt();
      this.Q = paramParcel.readInt();
      this.R = z.b(paramParcel);
      this.S = z.b(paramParcel);
      this.T = paramParcel.createByteArray();
      this.y = paramParcel.createByteArray();
      this.U = paramParcel.readString();
      this.V = paramParcel.readString();
      this.x = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label356;
      bool1 = false;
      break label371;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    if (this.d)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      if (!this.j) {
        break label420;
      }
      paramInt = 1;
      label66:
      paramParcel.writeByte((byte)paramInt);
      if (!this.k) {
        break label425;
      }
      paramInt = 1;
      label81:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.l);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      paramParcel.writeString(this.q);
      paramParcel.writeLong(this.r);
      paramParcel.writeString(this.s);
      paramParcel.writeInt(this.t);
      paramParcel.writeString(this.u);
      paramParcel.writeString(this.v);
      paramParcel.writeString(this.w);
      z.b(paramParcel, this.z);
      paramParcel.writeString(this.A);
      paramParcel.writeString(this.B);
      paramParcel.writeLong(this.C);
      paramParcel.writeLong(this.D);
      paramParcel.writeLong(this.E);
      paramParcel.writeLong(this.F);
      paramParcel.writeLong(this.G);
      paramParcel.writeLong(this.H);
      paramParcel.writeString(this.I);
      paramParcel.writeString(this.W);
      paramParcel.writeString(this.J);
      paramParcel.writeString(this.K);
      paramParcel.writeString(this.L);
      paramParcel.writeLong(this.M);
      if (!this.N) {
        break label430;
      }
    }
    label420:
    label425:
    label430:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      z.b(paramParcel, this.O);
      z.a(paramParcel, this.h);
      z.a(paramParcel, this.i);
      paramParcel.writeInt(this.P);
      paramParcel.writeInt(this.Q);
      z.b(paramParcel, this.R);
      z.b(paramParcel, this.S);
      paramParcel.writeByteArray(this.T);
      paramParcel.writeByteArray(this.y);
      paramParcel.writeString(this.U);
      paramParcel.writeString(this.V);
      paramParcel.writeString(this.x);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label66;
      paramInt = 0;
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.CrashDetailBean
 * JD-Core Version:    0.7.0.1
 */