package btmsdkobf;

import android.os.PowerManager;
import android.text.TextUtils;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cv
{
  private static cv iA;
  private cl he = null;
  private PowerManager iB = null;
  public Map<Byte, Integer> iC = new HashMap();
  private cc<Integer, a> iz = new cc(200);
  
  public static cv by()
  {
    try
    {
      if (iA == null) {
        iA = new cv();
      }
      return iA;
    }
    finally {}
  }
  
  public void a(byte paramByte)
  {
    synchronized (this.iC)
    {
      this.iC.remove(Byte.valueOf(paramByte));
      return;
    }
  }
  
  public void a(byte paramByte, int paramInt)
  {
    synchronized (this.iC)
    {
      this.iC.put(Byte.valueOf(paramByte), Integer.valueOf(paramInt));
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 8	btmsdkobf/cv$a
    //   5: dup
    //   6: invokespecial 76	btmsdkobf/cv$a:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: aload 4
    //   15: putfield 80	btmsdkobf/cv$a:iF	Ljava/lang/String;
    //   18: aload 5
    //   20: lload_2
    //   21: putfield 84	btmsdkobf/cv$a:iJ	J
    //   24: aload 5
    //   26: invokestatic 90	btmsdkobf/cr:bq	()Lbtmsdkobf/cr;
    //   29: iconst_0
    //   30: iconst_0
    //   31: invokevirtual 94	btmsdkobf/cr:b	(ZZ)I
    //   34: putfield 98	btmsdkobf/cv$a:iG	I
    //   37: aload_0
    //   38: getfield 38	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +15 -> 60
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 38	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   54: invokevirtual 104	android/os/PowerManager:isScreenOn	()Z
    //   57: putfield 108	btmsdkobf/cv$a:iH	Z
    //   60: aload_0
    //   61: getfield 34	btmsdkobf/cv:iz	Lbtmsdkobf/cc;
    //   64: iload_1
    //   65: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aload 5
    //   70: invokevirtual 109	btmsdkobf/cc:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore 4
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 4
    //   83: athrow
    //   84: astore 4
    //   86: goto -26 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	cv
    //   0	89	1	paramInt	int
    //   0	89	2	paramLong	long
    //   0	89	4	paramString	String
    //   9	60	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	43	77	finally
    //   48	60	77	finally
    //   60	74	77	finally
    //   48	60	84	java/lang/Throwable
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, as paramas, int paramInt3)
  {
    try
    {
      a(paramString, paramInt1, paramInt2, paramas, paramInt3, 0, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, as paramas, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      paramas = (a)this.iz.get(Integer.valueOf(paramInt2));
      if (paramas == null) {
        return;
      }
      paramString1 = String.valueOf(paramString1);
      StringBuilder localStringBuilder = new StringBuilder("[ocean][shark_funnel]|seqNo|seq_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("|step|");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("|cmdId|cmd_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|stepTime|");
      localStringBuilder.append(System.currentTimeMillis() - paramas.iN);
      localStringBuilder.append("|retCode|");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("|flow|");
      localStringBuilder.append(paramString2);
      eh.i(paramString1, localStringBuilder.toString());
      if (paramInt1 == 21)
      {
        paramString1 = new StringBuilder("|step|");
        paramString1.append(paramInt3);
        paramString1.append("|cmdId|");
        paramString1.append(paramInt1);
        paramString1.append("|retCode|");
        paramString1.append(paramInt4);
        eh.i("SharkFunnelModel", paramString1.toString());
      }
      paramas.bM = paramInt1;
      paramas.iE.set(paramInt3, true);
      if (paramString2 == null) {
        break label319;
      }
      paramas.iO = paramString2;
    }
    finally {}
    if (paramInt3 == 16)
    {
      paramas.iL = paramInt4;
      if (this.he != null) {
        this.he.h(paramInt1, paramInt4);
      }
    }
    else
    {
      paramas.df = paramInt4;
    }
    for (;;)
    {
      paramas.iK = paramInt4;
      if (this.he != null) {
        this.he.g(paramInt1, paramInt4);
      }
      paramas.iN = System.currentTimeMillis();
      return;
      label319:
      if ((paramInt3 != 14) && (paramInt3 != 9)) {
        if (paramInt3 != 10) {
          break;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ba paramba, int paramInt3, int paramInt4)
  {
    try
    {
      a(paramString, paramInt1, paramInt2, paramba, paramInt3, paramInt4, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, ba paramba, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      paramba = (a)this.iz.get(Integer.valueOf(paramInt2));
      if (paramba == null) {
        return;
      }
      paramString1 = String.valueOf(paramString1);
      StringBuilder localStringBuilder = new StringBuilder("[ocean][shark_funnel]|seqNo|seq_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("|step|");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("|cmdId|cmd_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|stepTime|");
      localStringBuilder.append(System.currentTimeMillis() - paramba.iN);
      localStringBuilder.append("|retCode|");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("|flow|");
      localStringBuilder.append(paramString2);
      eh.i(paramString1, localStringBuilder.toString());
      if (paramInt1 == 10021)
      {
        paramString1 = new StringBuilder("|step|");
        paramString1.append(paramInt3);
        paramString1.append("|cmdId|");
        paramString1.append(paramInt1);
        paramString1.append("|retCode|");
        paramString1.append(paramInt4);
        eh.i("SharkFunnelModel", paramString1.toString());
      }
      paramba.bM = paramInt1;
      if (paramString2 != null) {
        paramba.iP = paramString2;
      }
      paramba.iE.set(paramInt3, true);
      if (paramInt3 == 14) {
        paramba.iK = paramInt4;
      } else if (paramInt3 == 16) {
        paramba.iL = paramInt4;
      } else {
        paramba.df = paramInt4;
      }
      paramba.iN = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        a locala = (a)this.iz.get(Integer.valueOf(paramInt));
        if (locala == null) {
          return false;
        }
        this.iz.a(Integer.valueOf(paramInt));
        boolean bool = locala.iE.get(15);
        j = locala.df;
        i = j;
        if (j != 0)
        {
          k = bz.o(j);
          m = locala.iG;
          if (m == -2)
          {
            i = j - k - 160000;
          }
          else
          {
            i = j;
            if (k == -50000)
            {
              if (!locala.iI) {
                break label720;
              }
              i = -550000;
              break label764;
            }
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("|cmd|cmd_");
        localStringBuilder.append(locala.bM);
        localStringBuilder.append("|seqNo|seq_");
        localStringBuilder.append(paramInt);
        if (!TextUtils.isEmpty(locala.iF))
        {
          localStringBuilder.append("|reason|");
          localStringBuilder.append(locala.iF);
        }
        localStringBuilder.append("|channel|");
        if (!bool) {
          break label775;
        }
        Object localObject1 = "http";
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("|step|");
        localStringBuilder.append(locala.iE.toString());
        localStringBuilder.append("|netState|");
        localStringBuilder.append(cr.u(locala.iG));
        localStringBuilder.append("|isScreenOn|");
        localStringBuilder.append(locala.iH);
        localStringBuilder.append("|isNetworkChanged|");
        localStringBuilder.append(locala.iI);
        localStringBuilder.append("|tcpRetCode|");
        localStringBuilder.append(locala.iK);
        localStringBuilder.append("|httpRecCode|");
        localStringBuilder.append(locala.iL);
        localStringBuilder.append("|retCode|");
        if (i == locala.df)
        {
          localStringBuilder.append(locala.df);
        }
        else
        {
          localStringBuilder.append(locala.df);
          localStringBuilder.append("->");
          localStringBuilder.append(i);
        }
        localStringBuilder.append("|timeOut|");
        localStringBuilder.append(locala.iJ);
        localStringBuilder.append("|totalTime|");
        localStringBuilder.append(System.currentTimeMillis() - locala.iM);
        localStringBuilder.append("|sendFlow|");
        localStringBuilder.append(locala.iO);
        localStringBuilder.append("|recFlow|");
        localStringBuilder.append(locala.iP);
        if (locala.df == 0)
        {
          localObject1 = new StringBuilder("[shark_funnel]");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
          eh.e("SharkFunnelModel", ((StringBuilder)localObject1).toString());
        }
        else if (paramBoolean)
        {
          localObject1 = new StringBuilder("xxxxxxxxxxxx [shark_funnel]");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
          localObject1 = ((StringBuilder)localObject1).toString();
          eh.h("SharkFunnelModel", (String)localObject1);
        }
        else
        {
          localObject1 = new StringBuilder("tttt [shark_funnel]");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
          localObject1 = ((StringBuilder)localObject1).toString();
          continue;
        }
        if (this.he != null)
        {
          if (locala.bM > 10000) {
            paramInt = locala.bM - 10000;
          } else {
            paramInt = locala.bM;
          }
          if ((paramInt != 999) && (paramInt != 794) && (paramInt != 797) && (paramInt != 782)) {
            if (i == 0)
            {
              localObject1 = this.he;
              ((cl)localObject1).i(paramInt, i);
            }
            else if (paramBoolean)
            {
              localObject1 = this.he;
              continue;
            }
          }
        }
        return bool;
      }
      finally {}
      label720:
      if (m == -4) {
        i = -530000;
      } else if (m == -1) {
        i = -220000;
      } else if (m == -3) {
        i = -540000;
      } else {
        i = k;
      }
      label764:
      int i = j - k + i;
      continue;
      label775:
      String str = "tcp";
    }
  }
  
  public int b(byte paramByte)
  {
    synchronized (this.iC)
    {
      Integer localInteger = (Integer)this.iC.get(Byte.valueOf(paramByte));
      if (localInteger != null)
      {
        int i = localInteger.intValue();
        return i;
      }
      return -1;
    }
  }
  
  /* Error */
  public void b(cl paramcl)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 36	btmsdkobf/cv:he	Lbtmsdkobf/cl;
    //   7: aload_0
    //   8: invokestatic 310	btmsdkobf/bc:n	()Landroid/content/Context;
    //   11: ldc_w 312
    //   14: invokevirtual 318	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 100	android/os/PowerManager
    //   20: putfield 38	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   23: invokestatic 324	btmsdkobf/cz:bS	()Lbtmsdkobf/cz;
    //   26: new 6	btmsdkobf/cv$1
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 327	btmsdkobf/cv$1:<init>	(Lbtmsdkobf/cv;)V
    //   34: invokevirtual 330	btmsdkobf/cz:a	(Lbtmsdkobf/cz$b;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: goto -23 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	cv
    //   0	49	1	paramcl	cl
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   7	23	40	finally
    //   23	37	40	finally
    //   7	23	45	java/lang/Throwable
  }
  
  public void w(int paramInt)
  {
    try
    {
      this.iz.a(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean x(int paramInt)
  {
    try
    {
      boolean bool = a(paramInt, true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static class a
  {
    public int bM = 0;
    public int df = 0;
    public BitSet iE = new BitSet();
    public String iF = "";
    public int iG = 0;
    public boolean iH = false;
    public boolean iI = false;
    public long iJ = 0L;
    public int iK = 0;
    public int iL = 0;
    public long iM = System.currentTimeMillis();
    public long iN = System.currentTimeMillis();
    public String iO = "";
    public String iP = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cv
 * JD-Core Version:    0.7.0.1
 */