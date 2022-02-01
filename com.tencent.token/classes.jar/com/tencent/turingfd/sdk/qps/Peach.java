package com.tencent.turingfd.sdk.qps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.token.add;
import com.tencent.token.agb;
import com.tencent.token.ahr;
import java.util.HashMap;
import java.util.Map;

public class Peach
{
  public static final String a;
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("turingfd_conf_");
    localStringBuilder.append(agb.a);
    localStringBuilder.append("_qps");
    a = localStringBuilder.toString();
  }
  
  public Peach(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  /* Error */
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 40	com/tencent/turingfd/sdk/qps/Peach:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 53	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: invokeinterface 59 1 0
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: aload_1
    //   32: invokeinterface 65 1 0
    //   37: invokeinterface 71 1 0
    //   42: astore_2
    //   43: aload_2
    //   44: invokeinterface 77 1 0
    //   49: ifeq +53 -> 102
    //   52: aload_2
    //   53: invokeinterface 81 1 0
    //   58: checkcast 83	java/lang/String
    //   61: astore_3
    //   62: aload_1
    //   63: aload_3
    //   64: invokeinterface 87 2 0
    //   69: checkcast 83	java/lang/String
    //   72: astore 4
    //   74: aload_0
    //   75: aload_3
    //   76: aload 4
    //   78: invokevirtual 91	java/lang/String:getBytes	()[B
    //   81: invokestatic 96	com/tencent/token/ahr:c	()[B
    //   84: invokestatic 99	com/tencent/token/ahr:a	([B[B)[B
    //   87: invokestatic 102	com/tencent/token/ahr:b	([B)Ljava/lang/String;
    //   90: invokeinterface 108 3 0
    //   95: pop
    //   96: goto -53 -> 43
    //   99: goto -56 -> 43
    //   102: aload_0
    //   103: invokeinterface 111 1 0
    //   108: pop
    //   109: return
    //   110: astore_0
    //   111: goto -99 -> 12
    //   114: astore_3
    //   115: goto -16 -> 99
    //   118: astore_0
    //   119: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramMap	Map<String, String>
    //   42	11	2	localIterator	java.util.Iterator
    //   61	15	3	str1	String
    //   114	1	3	localObject	Object
    //   72	5	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	9	110	finally
    //   74	96	114	finally
    //   102	109	118	finally
  }
  
  public static String b(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getSharedPreferences(a, 0);
    }
    finally
    {
      label14:
      break label14;
    }
    paramContext = null;
    if (paramContext == null) {
      return "";
    }
    paramString = paramContext.getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      int j = paramString.length() / 2;
      paramContext = new byte[j];
      paramString = paramString.toUpperCase().toCharArray();
      while (i < j)
      {
        int k = i * 2;
        int m = (byte)"0123456789ABCDEF".indexOf(paramString[k]);
        paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
      paramContext = new String(ahr.b(paramContext, ahr.c()), "UTF-8");
      return paramContext;
    }
    finally
    {
      label130:
      break label130;
    }
    return "";
  }
  
  public final long a(Context paramContext, String paramString)
  {
    paramContext = b(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    finally
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public add<Long> a(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    add localadd = new add(paramInt);
    paramContext = b(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localadd.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label61:
        break label61;
      }
      paramInt += 1;
    }
    return localadd;
  }
  
  /* Error */
  public com.tencent.token.aew a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 194
    //   3: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 6
    //   8: aload 6
    //   10: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +10 -> 23
    //   16: iconst_1
    //   17: invokestatic 199	com/tencent/token/aew:a	(I)Lcom/tencent/token/aew;
    //   20: astore_1
    //   21: aload_1
    //   22: areturn
    //   23: lconst_0
    //   24: lstore_2
    //   25: aload_1
    //   26: ldc 201
    //   28: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 159	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   34: invokevirtual 163	java/lang/Long:longValue	()J
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_1
    //   43: ldc 203
    //   45: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload_1
    //   51: ldc 205
    //   53: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 8
    //   58: aload_1
    //   59: ldc 207
    //   61: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 9
    //   66: aload_1
    //   67: ldc 209
    //   69: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: aload_1
    //   75: ldc 211
    //   77: invokestatic 153	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_1
    //   81: new 213	com/tencent/token/aew$a
    //   84: dup
    //   85: invokespecial 214	com/tencent/token/aew$a:<init>	()V
    //   88: astore 11
    //   90: aload 11
    //   92: lload_2
    //   93: putfield 217	com/tencent/token/aew$a:b	J
    //   96: aload 11
    //   98: aload 6
    //   100: putfield 218	com/tencent/token/aew$a:a	Ljava/lang/String;
    //   103: aload 11
    //   105: aload 7
    //   107: putfield 221	com/tencent/token/aew$a:d	Ljava/lang/String;
    //   110: aload 11
    //   112: aload 8
    //   114: putfield 224	com/tencent/token/aew$a:e	Ljava/lang/String;
    //   117: aload 11
    //   119: aload 9
    //   121: putfield 227	com/tencent/token/aew$a:f	Ljava/lang/String;
    //   124: aload 11
    //   126: aload 10
    //   128: putfield 230	com/tencent/token/aew$a:g	Ljava/lang/String;
    //   131: aload 11
    //   133: new 232	com/tencent/token/afh
    //   136: dup
    //   137: aload_1
    //   138: invokespecial 233	com/tencent/token/afh:<init>	(Ljava/lang/String;)V
    //   141: putfield 237	com/tencent/token/aew$a:h	Lcom/tencent/token/afh;
    //   144: new 196	com/tencent/token/aew
    //   147: dup
    //   148: aload 11
    //   150: invokespecial 240	com/tencent/token/aew:<init>	(Lcom/tencent/token/aew$a;)V
    //   153: astore_1
    //   154: aload_1
    //   155: areturn
    //   156: iconst_1
    //   157: invokestatic 199	com/tencent/token/aew:a	(I)Lcom/tencent/token/aew;
    //   160: areturn
    //   161: astore_1
    //   162: goto -6 -> 156
    //   165: astore 7
    //   167: goto -125 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	Peach
    //   0	170	1	paramContext	Context
    //   24	69	2	l1	long
    //   37	3	4	l2	long
    //   6	93	6	str1	String
    //   48	58	7	str2	String
    //   165	1	7	localObject	Object
    //   56	57	8	str3	String
    //   64	56	9	str4	String
    //   72	55	10	str5	String
    //   88	61	11	locala	com.tencent.token.aew.a
    // Exception table:
    //   from	to	target	type
    //   0	21	161	finally
    //   42	154	161	finally
    //   25	39	165	finally
  }
  
  public void a(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "401", String.valueOf(l), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, false);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, paramBoolean);
  }
  
  public final void a(Context paramContext, final Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.b.post(new a(paramContext, paramMap));
  }
  
  public void b(Context paramContext, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("902", String.valueOf(paramLong));
    a(paramContext, localHashMap);
  }
  
  public void c(Context paramContext, long paramLong)
  {
    a(paramContext, "503", String.valueOf(paramLong), true);
  }
  
  public final class a
    implements Runnable
  {
    public a(Map paramMap) {}
    
    public final void run()
    {
      Peach.a(Peach.this, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Peach
 * JD-Core Version:    0.7.0.1
 */