package wf7;

import android.os.PowerManager;
import android.text.TextUtils;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class el
{
  private static el mB;
  private fk<Integer, el.a> mA = new fk(200);
  private dt mC = null;
  private PowerManager mD = null;
  public Map<Byte, Integer> mE = new HashMap();
  
  public static el cP()
  {
    try
    {
      if (mB == null) {
        mB = new el();
      }
      return mB;
    }
    finally {}
  }
  
  public int a(byte paramByte)
  {
    synchronized (this.mE)
    {
      Integer localInteger = (Integer)this.mE.get(Byte.valueOf(paramByte));
      if (localInteger != null)
      {
        int i = localInteger.intValue();
        return i;
      }
      return -1;
    }
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 69	wf7/el$a
    //   5: dup
    //   6: aconst_null
    //   7: invokespecial 72	wf7/el$a:<init>	(Lwf7/el$1;)V
    //   10: astore 5
    //   12: aload 5
    //   14: aload 4
    //   16: putfield 76	wf7/el$a:mH	Ljava/lang/String;
    //   19: aload 5
    //   21: lload_2
    //   22: putfield 80	wf7/el$a:mL	J
    //   25: aload 5
    //   27: invokestatic 86	wf7/eh:cE	()Lwf7/eh;
    //   30: iconst_0
    //   31: iconst_0
    //   32: invokevirtual 90	wf7/eh:b	(ZZ)I
    //   35: putfield 94	wf7/el$a:mI	I
    //   38: aload_0
    //   39: getfield 33	wf7/el:mD	Landroid/os/PowerManager;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +15 -> 61
    //   49: aload 5
    //   51: aload_0
    //   52: getfield 33	wf7/el:mD	Landroid/os/PowerManager;
    //   55: invokevirtual 100	android/os/PowerManager:isScreenOn	()Z
    //   58: putfield 104	wf7/el$a:mJ	Z
    //   61: aload_0
    //   62: getfield 29	wf7/el:mA	Lwf7/fk;
    //   65: iload_1
    //   66: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aload 5
    //   71: invokevirtual 111	wf7/fk:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore 4
    //   80: aload_0
    //   81: monitorexit
    //   82: aload 4
    //   84: athrow
    //   85: astore 4
    //   87: goto -26 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	el
    //   0	90	1	paramInt	int
    //   0	90	2	paramLong	long
    //   0	90	4	paramString	String
    //   10	60	5	locala	el.a
    // Exception table:
    //   from	to	target	type
    //   2	44	78	finally
    //   49	61	78	finally
    //   61	75	78	finally
    //   49	61	85	java/lang/Throwable
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ae paramae, int paramInt3, int paramInt4)
  {
    try
    {
      a(paramString, paramInt1, paramInt2, paramae, paramInt3, paramInt4, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, ae paramae, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      paramString1 = (el.a)this.mA.get(Integer.valueOf(paramInt2));
      if (paramString1 == null) {
        return;
      }
      paramString1.bH = paramInt1;
      if (paramString2 != null) {
        paramString1.mR = paramString2;
      }
      paramString1.mG.set(paramInt3, true);
      if (paramInt3 == 14) {
        paramString1.mM = paramInt4;
      } else if (paramInt3 == 16) {
        paramString1.mN = paramInt4;
      } else {
        paramString1.cc = paramInt4;
      }
      paramString1.mP = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, x paramx, int paramInt3)
  {
    try
    {
      a(paramString, paramInt1, paramInt2, paramx, paramInt3, 0, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, x paramx, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      paramString1 = (el.a)this.mA.get(Integer.valueOf(paramInt2));
      if (paramString1 == null) {
        return;
      }
      paramString1.bH = paramInt1;
      paramString1.mG.set(paramInt3, true);
      if (paramString2 == null) {
        break label133;
      }
      paramString1.mQ = paramString2;
    }
    finally {}
    if (paramInt3 == 16)
    {
      paramString1.mN = paramInt4;
      if (this.mC != null) {
        this.mC.v(paramInt1, paramInt4);
      }
    }
    else
    {
      paramString1.cc = paramInt4;
    }
    for (;;)
    {
      paramString1.mM = paramInt4;
      if (this.mC != null) {
        this.mC.u(paramInt1, paramInt4);
      }
      paramString1.mP = System.currentTimeMillis();
      return;
      label133:
      if ((paramInt3 != 14) && (paramInt3 != 9)) {
        if (paramInt3 != 10) {
          break;
        }
      }
    }
  }
  
  public void ai(int paramInt)
  {
    try
    {
      this.mA.a(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean aj(int paramInt)
  {
    try
    {
      boolean bool = c(paramInt, true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void b(dt paramdt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 31	wf7/el:mC	Lwf7/dt;
    //   7: aload_0
    //   8: invokestatic 183	wf7/ea:cr	()Landroid/content/Context;
    //   11: ldc 185
    //   13: invokevirtual 191	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 96	android/os/PowerManager
    //   19: putfield 33	wf7/el:mD	Landroid/os/PowerManager;
    //   22: invokestatic 197	wf7/ei:cI	()Lwf7/ei;
    //   25: new 199	wf7/el$1
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 202	wf7/el$1:<init>	(Lwf7/el;)V
    //   33: invokevirtual 205	wf7/ei:a	(Lwf7/ei$b;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: goto -23 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	el
    //   0	48	1	paramdt	dt
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   7	22	39	finally
    //   22	36	39	finally
    //   7	22	44	java/lang/Throwable
  }
  
  public boolean c(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        el.a locala = (el.a)this.mA.get(Integer.valueOf(paramInt));
        if (locala == null) {
          return false;
        }
        this.mA.a(Integer.valueOf(paramInt));
        boolean bool = locala.mG.get(15);
        j = locala.cc;
        i = j;
        if (j != 0)
        {
          k = dm.ac(j);
          m = locala.mI;
          if (m == -2)
          {
            i = j - k - 160000;
          }
          else
          {
            i = j;
            if (k == -50000)
            {
              if (!locala.mK) {
                break label602;
              }
              i = -550000;
              break label646;
            }
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("|cmd|cmd_");
        localStringBuilder.append(locala.bH);
        localStringBuilder.append("|seqNo|seq_");
        localStringBuilder.append(paramInt);
        if (!TextUtils.isEmpty(locala.mH))
        {
          localStringBuilder.append("|reason|");
          localStringBuilder.append(locala.mH);
        }
        localStringBuilder.append("|channel|");
        if (!bool) {
          break label657;
        }
        String str1 = "http";
        localStringBuilder.append(str1);
        localStringBuilder.append("|step|");
        localStringBuilder.append(locala.mG.toString());
        localStringBuilder.append("|netState|");
        localStringBuilder.append(eh.ag(locala.mI));
        localStringBuilder.append("|isScreenOn|");
        localStringBuilder.append(locala.mJ);
        localStringBuilder.append("|isNetworkChanged|");
        localStringBuilder.append(locala.mK);
        localStringBuilder.append("|tcpRetCode|");
        localStringBuilder.append(locala.mM);
        localStringBuilder.append("|httpRecCode|");
        localStringBuilder.append(locala.mN);
        localStringBuilder.append("|retCode|");
        if (i == locala.cc)
        {
          localStringBuilder.append(locala.cc);
        }
        else
        {
          localStringBuilder.append(locala.cc);
          localStringBuilder.append("->");
          localStringBuilder.append(i);
        }
        localStringBuilder.append("|timeOut|");
        localStringBuilder.append(locala.mL);
        localStringBuilder.append("|totalTime|");
        localStringBuilder.append(System.currentTimeMillis() - locala.mO);
        localStringBuilder.append("|sendFlow|");
        localStringBuilder.append(locala.mQ);
        localStringBuilder.append("|recFlow|");
        localStringBuilder.append(locala.mR);
        paramInt = locala.cc;
        if (this.mC != null)
        {
          if (locala.bH > 10000) {
            paramInt = locala.bH - 10000;
          } else {
            paramInt = locala.bH;
          }
          if ((paramInt != 999) && (paramInt != 794) && (paramInt != 797) && (paramInt != 782)) {
            if (i == 0) {
              this.mC.t(paramInt, i);
            } else if (paramBoolean) {
              this.mC.t(paramInt, i);
            }
          }
        }
        return bool;
      }
      finally {}
      label602:
      if (m == -4) {
        i = -530000;
      } else if (m == -1) {
        i = -220000;
      } else if (m == -3) {
        i = -540000;
      } else {
        i = k;
      }
      label646:
      int i = j - k + i;
      continue;
      label657:
      String str2 = "tcp";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.el
 * JD-Core Version:    0.7.0.1
 */