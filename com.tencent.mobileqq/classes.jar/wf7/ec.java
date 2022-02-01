package wf7;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

public class ec
  implements eb
{
  private static boolean lP = false;
  protected long lM;
  private eo lN;
  private en lO;
  
  public ec()
  {
    this.lM = et.b(3, 8589934592L);
  }
  
  public ec(long paramLong)
  {
    this.lM = paramLong;
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, dp paramdp, dt paramdt, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    for (;;)
    {
      try
      {
        if (!ea.ly)
        {
          dg.i(paramBoolean1);
          ea.h(paramContext.getApplicationContext());
          ea.a(paramdp);
          ea.a(paramdt);
          ea.q(paramBoolean3);
          ea.y(paramString);
          if (!paramBoolean2)
          {
            paramBoolean1 = true;
            ea.s(paramBoolean1);
            ea.r(paramdt.bX());
            eo.da().c(paramdt);
            ea.ly = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramBoolean1 = false;
    }
  }
  
  private en cx()
  {
    if ((ea.cv()) && (!ea.ly)) {
      throw new RuntimeException("getSharkProcessProxy too early");
    }
    try
    {
      if (this.lO == null) {
        this.lO = en.cY();
      }
      return this.lO;
    }
    finally {}
  }
  
  private eo cy()
  {
    if ((ea.cv()) && (!ea.ly)) {
      throw new RuntimeException("getSharkProtocolQueue too early");
    }
    try
    {
      if (this.lN == null) {
        this.lN = eo.da();
      }
      return this.lN;
    }
    finally {}
  }
  
  public static void start()
  {
    try
    {
      if ((ea.cv()) && (!ea.ly)) {
        throw new RuntimeException("must call start() before init()!");
      }
      if (!lP)
      {
        lP = true;
        ea.bV().b(new ec.1(), "init SharkProtocolQueue async");
      }
      return;
    }
    finally {}
  }
  
  public WeakReference<dz> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, dq paramdq, dr paramdr, long paramLong3, long paramLong4)
  {
    if (ea.bX()) {
      return cy().a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramInt4, paramJceStruct1, paramArrayOfByte, paramJceStruct2, paramInt5, paramdq, paramdr, paramLong3, paramLong4);
    }
    cx().a(paramInt1, this.lM, paramInt3, paramLong1, paramInt4, paramJceStruct1, paramJceStruct2, paramInt5, paramdq, paramLong3, paramLong4);
    return null;
  }
  
  public WeakReference<dz> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, dq paramdq)
  {
    return a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramdq, 0L);
  }
  
  public WeakReference<dz> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, dq paramdq, long paramLong)
  {
    return a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramdq, paramLong, 0L);
  }
  
  public WeakReference<dz> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, dq paramdq, long paramLong1, long paramLong2)
  {
    return a(Process.myPid(), 0, 0, 0L, this.lM, paramInt1, paramJceStruct1, null, paramJceStruct2, paramInt2, paramdq, null, paramLong1, paramLong2);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, du paramdu)
  {
    a(0L, paramInt1, paramJceStruct, paramInt2, paramdu, false);
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, du paramdu, boolean paramBoolean)
  {
    if (ea.bX())
    {
      if (!paramBoolean) {
        paramLong = this.lM;
      }
      cy().a(paramLong, paramInt1, paramJceStruct, paramInt2, paramdu, paramBoolean);
      return;
    }
    cx().a(this.lM, paramInt1, paramJceStruct, paramInt2, paramdu);
  }
  
  public du w(int paramInt1, int paramInt2)
  {
    if (ea.bX()) {
      return cy().w(paramInt1, paramInt2);
    }
    return cx().w(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ec
 * JD-Core Version:    0.7.0.1
 */