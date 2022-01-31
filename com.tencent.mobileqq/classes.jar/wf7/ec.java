package wf7;

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
  
  /* Error */
  public static void a(boolean paramBoolean1, android.content.Context paramContext, dp paramdp, dt paramdt, boolean paramBoolean2, boolean paramBoolean3, java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 40	wf7/ea:ly	Z
    //   9: ifne +62 -> 71
    //   12: iload_0
    //   13: invokestatic 46	wf7/dg:i	(Z)V
    //   16: aload_1
    //   17: invokevirtual 52	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   20: invokestatic 56	wf7/ea:h	(Landroid/content/Context;)V
    //   23: aload_2
    //   24: invokestatic 59	wf7/ea:a	(Lwf7/dp;)V
    //   27: aload_3
    //   28: invokestatic 62	wf7/ea:a	(Lwf7/dt;)V
    //   31: iload 5
    //   33: invokestatic 65	wf7/ea:q	(Z)V
    //   36: aload 6
    //   38: invokestatic 69	wf7/ea:y	(Ljava/lang/String;)V
    //   41: iload 4
    //   43: ifne +32 -> 75
    //   46: iload 7
    //   48: istore_0
    //   49: iload_0
    //   50: invokestatic 72	wf7/ea:s	(Z)V
    //   53: aload_3
    //   54: invokevirtual 78	wf7/dt:bX	()Z
    //   57: invokestatic 81	wf7/ea:r	(Z)V
    //   60: invokestatic 87	wf7/eo:da	()Lwf7/eo;
    //   63: aload_3
    //   64: invokevirtual 90	wf7/eo:c	(Lwf7/dt;)V
    //   67: iconst_1
    //   68: putstatic 40	wf7/ea:ly	Z
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: iconst_0
    //   76: istore_0
    //   77: goto -28 -> 49
    //   80: astore_1
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramBoolean1	boolean
    //   0	86	1	paramContext	android.content.Context
    //   0	86	2	paramdp	dp
    //   0	86	3	paramdt	dt
    //   0	86	4	paramBoolean2	boolean
    //   0	86	5	paramBoolean3	boolean
    //   0	86	6	paramString	java.lang.String
    //   1	46	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	41	80	finally
    //   49	71	80	finally
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
    }
    finally {}
    if (!lP)
    {
      lP = true;
      ea.bV().b(new ec.1(), "init SharkProtocolQueue async");
    }
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
      if (paramBoolean) {}
      for (;;)
      {
        cy().a(paramLong, paramInt1, paramJceStruct, paramInt2, paramdu, paramBoolean);
        return;
        paramLong = this.lM;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ec
 * JD-Core Version:    0.7.0.1
 */