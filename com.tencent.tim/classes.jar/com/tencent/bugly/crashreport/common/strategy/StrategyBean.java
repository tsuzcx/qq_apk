package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class StrategyBean
  implements Parcelable
{
  public static final Parcelable.Creator<StrategyBean> CREATOR = new StrategyBean.1();
  public static String a = "https://android.bugly.qq.com/rqd/async";
  public static String b = "https://android.bugly.qq.com/rqd/async";
  public long c = -1L;
  public long d = -1L;
  public boolean e = true;
  public boolean f = true;
  public boolean g = true;
  public boolean h = true;
  public boolean i = false;
  public boolean j = true;
  public boolean k = true;
  public boolean l = true;
  public boolean m = true;
  public long n;
  public long o = 30000L;
  public String p = a;
  public String q = b;
  public String r;
  public Map<String, String> s;
  public int t = 10;
  public long u = 300000L;
  public long v = -1L;
  
  public StrategyBean()
  {
    this.d = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S(@L@L").append("@)");
    localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("*^@K#K").append("@!");
    this.r = localStringBuilder.toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("S(@L@L").append("@)");
      localStringBuilder.toString();
      this.d = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.e = bool1;
        if (paramParcel.readByte() != 1) {
          break label355;
        }
        bool1 = true;
        label167:
        this.f = bool1;
        if (paramParcel.readByte() != 1) {
          break label360;
        }
        bool1 = true;
        label182:
        this.g = bool1;
        this.p = paramParcel.readString();
        this.q = paramParcel.readString();
        this.r = paramParcel.readString();
        this.s = z.b(paramParcel);
        if (paramParcel.readByte() != 1) {
          break label365;
        }
        bool1 = true;
        label229:
        this.h = bool1;
        if (paramParcel.readByte() != 1) {
          break label370;
        }
        bool1 = true;
        label244:
        this.i = bool1;
        if (paramParcel.readByte() != 1) {
          break label375;
        }
        bool1 = true;
        label259:
        this.l = bool1;
        if (paramParcel.readByte() != 1) {
          break label380;
        }
        bool1 = true;
        label274:
        this.m = bool1;
        this.o = paramParcel.readLong();
        if (paramParcel.readByte() != 1) {
          break label385;
        }
        bool1 = true;
        label297:
        this.j = bool1;
        if (paramParcel.readByte() != 1) {
          break label390;
        }
      }
      label385:
      label390:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.k = bool1;
        this.n = paramParcel.readLong();
        this.t = paramParcel.readInt();
        this.u = paramParcel.readLong();
        this.v = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        label355:
        bool1 = false;
        break label167;
        label360:
        bool1 = false;
        break label182;
        label365:
        bool1 = false;
        break label229;
        label370:
        bool1 = false;
        break label244;
        label375:
        bool1 = false;
        break label259;
        label380:
        bool1 = false;
        break label274;
        bool1 = false;
        break label297;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(this.d);
    if (this.e)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.f) {
        break label223;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.g) {
        break label228;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.p);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.r);
      z.b(paramParcel, this.s);
      if (!this.h) {
        break label233;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.i) {
        break label238;
      }
      paramInt = 1;
      label111:
      paramParcel.writeByte((byte)paramInt);
      if (!this.l) {
        break label243;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.m) {
        break label248;
      }
      paramInt = 1;
      label141:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.o);
      if (!this.j) {
        break label253;
      }
      paramInt = 1;
      label164:
      paramParcel.writeByte((byte)paramInt);
      if (!this.k) {
        break label258;
      }
    }
    label258:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.n);
      paramParcel.writeInt(this.t);
      paramParcel.writeLong(this.u);
      paramParcel.writeLong(this.v);
      return;
      paramInt = 0;
      break;
      label223:
      paramInt = 0;
      break label34;
      label228:
      paramInt = 0;
      break label49;
      label233:
      paramInt = 0;
      break label96;
      label238:
      paramInt = 0;
      break label111;
      label243:
      paramInt = 0;
      break label126;
      label248:
      paramInt = 0;
      break label141;
      label253:
      paramInt = 0;
      break label164;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.StrategyBean
 * JD-Core Version:    0.7.0.1
 */