package btmsdkobf;

import android.os.PowerManager;
import android.text.TextUtils;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class cv
{
  private static cv iA = null;
  private cl he = null;
  private PowerManager iB = null;
  public Map iC = new HashMap();
  private cc iz = new cc(200);
  
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
    //   2: new 71	btmsdkobf/cv$a
    //   5: dup
    //   6: invokespecial 72	btmsdkobf/cv$a:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: aload 4
    //   15: putfield 76	btmsdkobf/cv$a:iF	Ljava/lang/String;
    //   18: aload 5
    //   20: lload_2
    //   21: putfield 80	btmsdkobf/cv$a:iJ	J
    //   24: aload 5
    //   26: invokestatic 86	btmsdkobf/cr:bq	()Lbtmsdkobf/cr;
    //   29: iconst_0
    //   30: iconst_0
    //   31: invokevirtual 90	btmsdkobf/cr:b	(ZZ)I
    //   34: putfield 94	btmsdkobf/cv$a:iG	I
    //   37: aload_0
    //   38: getfield 33	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +15 -> 60
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 33	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   54: invokevirtual 100	android/os/PowerManager:isScreenOn	()Z
    //   57: putfield 104	btmsdkobf/cv$a:iH	Z
    //   60: aload_0
    //   61: getfield 29	btmsdkobf/cv:iz	Lbtmsdkobf/cc;
    //   64: iload_1
    //   65: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aload 5
    //   70: invokevirtual 105	btmsdkobf/cc:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   9	60	5	locala	cv.a
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
    for (;;)
    {
      label229:
      try
      {
        paramas = (cv.a)this.iz.get(Integer.valueOf(paramInt2));
        if (paramas == null) {
          return;
        }
        eh.i("" + paramString1, "[ocean][shark_funnel]|seqNo|seq_" + paramInt2 + "|step|" + paramInt3 + "|cmdId|cmd_" + paramInt1 + "|stepTime|" + (System.currentTimeMillis() - paramas.iN) + "|retCode|" + paramInt4 + "|flow|" + paramString2);
        if (paramInt1 == 21) {
          eh.i("SharkFunnelModel", "|step|" + paramInt3 + "|cmdId|" + paramInt1 + "|retCode|" + paramInt4);
        }
        paramas.bM = paramInt1;
        paramas.iE.set(paramInt3, true);
        if (paramString2 == null) {
          break label289;
        }
        paramas.iO = paramString2;
      }
      finally {}
      paramas.iK = paramInt4;
      if (this.he != null) {
        this.he.g(paramInt1, paramInt4);
      }
      paramas.iN = System.currentTimeMillis();
      continue;
      label289:
      do
      {
        if (paramInt3 == 16)
        {
          paramas.iL = paramInt4;
          if (this.he == null) {
            break label229;
          }
          this.he.h(paramInt1, paramInt4);
          break label229;
        }
        paramas.df = paramInt4;
        break label229;
        if ((paramInt3 == 14) || (paramInt3 == 9)) {
          break;
        }
      } while (paramInt3 != 10);
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
    for (;;)
    {
      try
      {
        paramba = (cv.a)this.iz.get(Integer.valueOf(paramInt2));
        if (paramba == null) {
          return;
        }
        eh.i("" + paramString1, "[ocean][shark_funnel]|seqNo|seq_" + paramInt2 + "|step|" + paramInt3 + "|cmdId|cmd_" + paramInt1 + "|stepTime|" + (System.currentTimeMillis() - paramba.iN) + "|retCode|" + paramInt4 + "|flow|" + paramString2);
        if (paramInt1 == 10021) {
          eh.i("SharkFunnelModel", "|step|" + paramInt3 + "|cmdId|" + paramInt1 + "|retCode|" + paramInt4);
        }
        paramba.bM = paramInt1;
        if (paramString2 != null) {
          paramba.iP = paramString2;
        }
        paramba.iE.set(paramInt3, true);
        if (paramInt3 == 14)
        {
          paramba.iK = paramInt4;
          paramba.iN = System.currentTimeMillis();
          continue;
        }
        if (paramInt3 != 16) {
          break label250;
        }
      }
      finally {}
      paramba.iL = paramInt4;
      continue;
      label250:
      paramba.df = paramInt4;
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      cv.a locala;
      boolean bool;
      int j;
      int k;
      int i;
      StringBuilder localStringBuilder;
      try
      {
        locala = (cv.a)this.iz.get(Integer.valueOf(paramInt));
        if (locala == null)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        this.iz.a(Integer.valueOf(paramInt));
        bool = locala.iE.get(15);
        j = locala.df;
        if (j == 0) {
          break label684;
        }
        k = bz.o(j);
        i = locala.iG;
        if (i == -2)
        {
          i = j - k - 160000;
          localStringBuilder = new StringBuilder();
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
            break label745;
          }
          String str1 = "http";
          localStringBuilder.append(str1);
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
            localStringBuilder.append("|timeOut|");
            localStringBuilder.append(locala.iJ);
            localStringBuilder.append("|totalTime|");
            localStringBuilder.append(System.currentTimeMillis() - locala.iM);
            localStringBuilder.append("|sendFlow|");
            localStringBuilder.append(locala.iO);
            localStringBuilder.append("|recFlow|");
            localStringBuilder.append(locala.iP);
            if (locala.df != 0) {
              break label585;
            }
            eh.e("SharkFunnelModel", "[shark_funnel]" + localStringBuilder.toString());
            if (this.he == null) {
              break label690;
            }
            if (locala.bM <= 10000) {
              break label653;
            }
            paramInt = locala.bM - 10000;
            if ((paramInt == 999) || (paramInt == 794) || (paramInt == 797) || (paramInt == 782)) {
              break label690;
            }
            if (i != 0) {
              break label662;
            }
            this.he.i(paramInt, i);
            break label690;
          }
        }
        else
        {
          if (k != -50000) {
            break label684;
          }
          if (!locala.iI) {
            break label707;
          }
          i = -550000;
          break label696;
        }
        localStringBuilder.append(locala.df).append("->").append(i);
        continue;
        if (!paramBoolean) {
          break label621;
        }
      }
      finally {}
      label585:
      eh.h("SharkFunnelModel", "xxxxxxxxxxxx [shark_funnel]" + localStringBuilder.toString());
      continue;
      label621:
      eh.h("SharkFunnelModel", "tttt [shark_funnel]" + localStringBuilder.toString());
      continue;
      label653:
      paramInt = locala.bM;
      continue;
      label662:
      if (paramBoolean)
      {
        this.he.i(paramInt, i);
        break label690;
        label678:
        i = k;
        break label696;
        label684:
        i = j;
        continue;
      }
      label690:
      paramBoolean = bool;
      continue;
      for (;;)
      {
        label696:
        i += j - k;
        break;
        label707:
        if (i == -4)
        {
          i = -530000;
        }
        else if (i == -1)
        {
          i = -220000;
        }
        else
        {
          if (i != -3) {
            break label678;
          }
          i = -540000;
        }
      }
      label745:
      String str2 = "tcp";
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
    //   4: putfield 31	btmsdkobf/cv:he	Lbtmsdkobf/cl;
    //   7: aload_0
    //   8: invokestatic 300	btmsdkobf/bc:n	()Landroid/content/Context;
    //   11: ldc_w 302
    //   14: invokevirtual 308	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 96	android/os/PowerManager
    //   20: putfield 33	btmsdkobf/cv:iB	Landroid/os/PowerManager;
    //   23: invokestatic 314	btmsdkobf/cz:bS	()Lbtmsdkobf/cz;
    //   26: new 316	btmsdkobf/fw
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 319	btmsdkobf/fw:<init>	(Lbtmsdkobf/cv;)V
    //   34: invokevirtual 322	btmsdkobf/cz:a	(Lbtmsdkobf/cz$b;)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cv
 * JD-Core Version:    0.7.0.1
 */