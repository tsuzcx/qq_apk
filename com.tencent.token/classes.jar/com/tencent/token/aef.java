package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aef
{
  public static final String a;
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("turingfd_conf_");
    localStringBuilder.append(agh.a);
    localStringBuilder.append("_qps");
    a = localStringBuilder.toString();
  }
  
  public aef(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  /* Error */
  public static adt a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 49
    //   3: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 5
    //   8: aload 5
    //   10: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +10 -> 23
    //   16: iconst_1
    //   17: invokestatic 63	com/tencent/token/adt:a	(I)Lcom/tencent/token/adt;
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: lconst_0
    //   24: lstore_1
    //   25: aload_0
    //   26: ldc 65
    //   28: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 71	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   34: invokevirtual 75	java/lang/Long:longValue	()J
    //   37: lstore_3
    //   38: lload_3
    //   39: lstore_1
    //   40: aload_0
    //   41: ldc 77
    //   43: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 6
    //   48: aload_0
    //   49: ldc 79
    //   51: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 7
    //   56: aload_0
    //   57: ldc 81
    //   59: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 8
    //   64: aload_0
    //   65: ldc 83
    //   67: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 9
    //   72: aload_0
    //   73: ldc 85
    //   75: invokestatic 52	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   78: astore_0
    //   79: new 87	com/tencent/token/adt$a
    //   82: dup
    //   83: invokespecial 88	com/tencent/token/adt$a:<init>	()V
    //   86: astore 10
    //   88: aload 10
    //   90: lload_1
    //   91: putfield 91	com/tencent/token/adt$a:b	J
    //   94: aload 10
    //   96: aload 5
    //   98: putfield 92	com/tencent/token/adt$a:a	Ljava/lang/String;
    //   101: aload 10
    //   103: aload 6
    //   105: putfield 95	com/tencent/token/adt$a:d	Ljava/lang/String;
    //   108: aload 10
    //   110: aload 7
    //   112: putfield 98	com/tencent/token/adt$a:e	Ljava/lang/String;
    //   115: aload 10
    //   117: aload 8
    //   119: putfield 101	com/tencent/token/adt$a:f	Ljava/lang/String;
    //   122: aload 10
    //   124: aload 9
    //   126: putfield 104	com/tencent/token/adt$a:g	Ljava/lang/String;
    //   129: aload 10
    //   131: new 106	com/tencent/token/aeg
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 107	com/tencent/token/aeg:<init>	(Ljava/lang/String;)V
    //   139: putfield 111	com/tencent/token/adt$a:h	Lcom/tencent/token/aeg;
    //   142: new 60	com/tencent/token/adt
    //   145: dup
    //   146: aload 10
    //   148: invokespecial 114	com/tencent/token/adt:<init>	(Lcom/tencent/token/adt$a;)V
    //   151: astore_0
    //   152: aload_0
    //   153: areturn
    //   154: iconst_1
    //   155: invokestatic 63	com/tencent/token/adt:a	(I)Lcom/tencent/token/adt;
    //   158: areturn
    //   159: astore_0
    //   160: goto -6 -> 154
    //   163: astore 6
    //   165: goto -125 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   24	67	1	l1	long
    //   37	2	3	l2	long
    //   6	91	5	str1	String
    //   46	58	6	str2	String
    //   163	1	6	localObject	Object
    //   54	57	7	str3	String
    //   62	56	8	str4	String
    //   70	55	9	str5	String
    //   86	61	10	locala	adt.a
    // Exception table:
    //   from	to	target	type
    //   0	21	159	finally
    //   40	152	159	finally
    //   25	38	163	finally
  }
  
  public static String a(Context paramContext, String paramString)
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
      paramContext = new String(agn.b(paramContext, agn.b()), "UTF-8");
      return paramContext;
    }
    finally
    {
      label130:
      break label130;
    }
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 40	com/tencent/token/aef:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 120	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: invokeinterface 165 1 0
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: aload_1
    //   32: invokeinterface 171 1 0
    //   37: invokeinterface 177 1 0
    //   42: astore_2
    //   43: aload_2
    //   44: invokeinterface 183 1 0
    //   49: ifeq +53 -> 102
    //   52: aload_2
    //   53: invokeinterface 187 1 0
    //   58: checkcast 130	java/lang/String
    //   61: astore_3
    //   62: aload_1
    //   63: aload_3
    //   64: invokeinterface 191 2 0
    //   69: checkcast 130	java/lang/String
    //   72: astore 4
    //   74: aload_0
    //   75: aload_3
    //   76: aload 4
    //   78: invokevirtual 194	java/lang/String:getBytes	()[B
    //   81: invokestatic 152	com/tencent/token/agn:b	()[B
    //   84: invokestatic 196	com/tencent/token/agn:a	([B[B)[B
    //   87: invokestatic 199	com/tencent/token/agn:d	([B)Ljava/lang/String;
    //   90: invokeinterface 205 3 0
    //   95: pop
    //   96: goto -53 -> 43
    //   99: goto -56 -> 43
    //   102: aload_0
    //   103: invokeinterface 208 1 0
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
  
  public static long b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
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
  
  public static adh<Long> b(Context paramContext)
  {
    System.currentTimeMillis();
    adh localadh = new adh(30);
    paramContext = a(paramContext, "402").split("_");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
      try
      {
        long l = Long.valueOf(str).longValue();
        localadh.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label60:
        break label60;
      }
      i += 1;
    }
    return localadh;
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("902", String.valueOf(paramLong));
    a(paramContext, localHashMap);
  }
  
  public final void a(Context paramContext, long paramLong)
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
  
  public final void b(Context paramContext, long paramLong)
  {
    a(paramContext, "503", String.valueOf(paramLong), true);
  }
  
  public final class a
    implements Runnable
  {
    public a(Map paramMap) {}
    
    public final void run()
    {
      aef.a(aef.this, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aef
 * JD-Core Version:    0.7.0.1
 */