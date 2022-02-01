package com.huawei.hms.framework.network.grs.b.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.b.d;
import java.util.concurrent.Future;

public class b
{
  private Future<d> a;
  private long b;
  
  public b(Future<d> paramFuture)
  {
    this.a = paramFuture;
    this.b = SystemClock.elapsedRealtime();
  }
  
  public Future<d> a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return SystemClock.elapsedRealtime() - this.b <= 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.b.b
 * JD-Core Version:    0.7.0.1
 */