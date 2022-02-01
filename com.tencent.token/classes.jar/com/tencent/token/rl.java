package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;

public final class rl
{
  int a = 0;
  long b = 0L;
  int c = 0;
  long d = 0L;
  long e = 0L;
  int f = 0;
  String g;
  Context h;
  private long i = 0L;
  
  public rl(Context paramContext, String paramString, long paramLong)
  {
    this(paramContext, paramString, paramLong, (byte)0);
  }
  
  private rl(Context paramContext, String paramString, long paramLong, byte paramByte)
  {
    this.h = paramContext;
    this.g = paramString;
    long l = paramLong;
    if (paramLong < 0L) {
      l = 9223372036854775807L;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      this.f = 4;
    }
    paramContext = rk.a.a();
    paramString = new StringBuilder("freq_ctrl_");
    paramString.append(this.g);
    paramContext = paramContext.a(paramString.toString());
    this.a = 2;
    this.i = l;
    this.b = 0L;
    this.c = paramContext.a("times_now", this.c);
    this.d = paramContext.a("time_span_start", this.d);
    this.e = paramContext.a("time_span_end", this.e);
    paramContext.b("times", 2);
    paramContext.b("time_span", l);
    paramContext.b("interval", 0L);
  }
  
  final void a(int paramInt)
  {
    this.c = paramInt;
    rk localrk = rk.a.a();
    StringBuilder localStringBuilder = new StringBuilder("freq_ctrl_");
    localStringBuilder.append(this.g);
    localrk.a(localStringBuilder.toString()).b("times_now", this.c);
  }
  
  final void a(long paramLong)
  {
    this.d = paramLong;
    this.e = (this.i + paramLong);
    Object localObject = rk.a.a();
    StringBuilder localStringBuilder = new StringBuilder("freq_ctrl_");
    localStringBuilder.append(this.g);
    localObject = ((rk)localObject).a(localStringBuilder.toString());
    ((avb)localObject).b("time_span_start", this.d);
    ((avb)localObject).b("time_span_end", this.e);
    ((avb)localObject).b("last", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rl
 * JD-Core Version:    0.7.0.1
 */