package com.tencent.qqpimsecure.taiji;

import android.content.Context;
import android.os.Build.VERSION;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class d
{
  private int a = 0;
  private long b = 0L;
  private long c = 0L;
  private int d = 0;
  private long e = 0L;
  private long f = 0L;
  private int g = 0;
  private String h;
  private Context i;
  
  public d(Context paramContext, String paramString, long paramLong, int paramInt)
  {
    this(paramContext, paramString, paramLong, paramInt, 0L);
  }
  
  public d(Context paramContext, String paramString, long paramLong1, int paramInt, long paramLong2)
  {
    this.i = paramContext;
    this.h = paramString;
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 9223372036854775807L;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      this.g = 4;
    }
    paramContext = c.a();
    paramString = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("freq_ctrl_");
    localStringBuilder.append(this.h);
    paramContext = paramContext.a(paramString, localStringBuilder.toString(), this.g);
    this.a = paramInt;
    this.b = l;
    this.c = paramLong2;
    this.d = paramContext.getInt("times_now", this.d);
    this.e = paramContext.getLong("time_span_start", this.e);
    this.f = paramContext.getLong("time_span_end", this.f);
    paramContext.putInt("times", paramInt);
    paramContext.putLong("time_span", l);
    paramContext.putLong("interval", paramLong2);
  }
  
  private void a(int paramInt)
  {
    this.d = paramInt;
    c localc = c.a();
    Context localContext = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("freq_ctrl_");
    localStringBuilder.append(this.h);
    localc.a(localContext, localStringBuilder.toString(), this.g).putInt("times_now", this.d);
  }
  
  private void a(long paramLong)
  {
    this.e = paramLong;
    this.f = (this.b + paramLong);
    Object localObject = c.a();
    Context localContext = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("freq_ctrl_");
    localStringBuilder.append(this.h);
    localObject = ((c)localObject).a(localContext, localStringBuilder.toString(), this.g);
    ((ITaijiPreferenceManager)localObject).putLong("time_span_start", this.e);
    ((ITaijiPreferenceManager)localObject).putLong("time_span_end", this.f);
    ((ITaijiPreferenceManager)localObject).putLong("last", paramLong);
  }
  
  public boolean a()
  {
    if (this.e == 0L) {
      return true;
    }
    long l1 = System.currentTimeMillis();
    c localc = c.a();
    Context localContext = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("freq_ctrl_");
    localStringBuilder.append(this.h);
    long l2 = localc.a(localContext, localStringBuilder.toString(), this.g).getLong("last", 0L);
    long l3;
    if ((this.d < this.a) || (l1 >= this.f)) {
      l3 = this.c;
    }
    return (l3 <= 0L) || (l1 - l2 >= l3);
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if (this.e == 0L) {}
    while (l >= this.f)
    {
      a(l);
      a(0);
      break;
    }
    a(this.d + 1);
    c localc = c.a();
    Context localContext = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("freq_ctrl_");
    localStringBuilder.append(this.h);
    localc.a(localContext, localStringBuilder.toString(), this.g).putLong("last", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.d
 * JD-Core Version:    0.7.0.1
 */