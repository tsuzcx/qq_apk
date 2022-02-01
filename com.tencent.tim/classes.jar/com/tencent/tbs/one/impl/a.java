package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.logger.TBSLogger;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.a.b;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.tbs.one.impl.e.i;
import java.io.File;

public final class a
{
  private static final Object a = new Object();
  private static boolean b;
  
  public static com.tencent.tbs.one.impl.a.a<e<d>> a(i parami, int paramInt, File paramFile, Bundle paramBundle)
  {
    return new b(parami.a, parami.b, parami.g(), parami.f(), paramInt, paramFile, paramBundle);
  }
  
  public static com.tencent.tbs.one.impl.a.a<e<File>> a(i parami, d.a parama, File paramFile, Bundle paramBundle)
  {
    Context localContext = parami.a;
    String str1 = parami.b;
    String str2 = parami.g();
    parami.f();
    return new com.tencent.tbs.one.impl.e.a.a(localContext, str1, str2, parama, paramFile, paramBundle);
  }
  
  /* Error */
  public static h a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 60	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   3: astore_3
    //   4: aload_0
    //   5: ifnonnull +219 -> 224
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +226 -> 237
    //   14: new 62	java/io/File
    //   17: dup
    //   18: aload_3
    //   19: new 64	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 66
    //   25: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 74	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 80
    //   37: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_3
    //   48: invokevirtual 90	java/io/File:exists	()Z
    //   51: invokestatic 96	com/tencent/tbs/one/impl/common/statistic/StatisticReport:shiftRepService	(Z)V
    //   54: new 29	com/tencent/tbs/one/impl/e/i
    //   57: dup
    //   58: aload_0
    //   59: aload_1
    //   60: invokespecial 99	com/tencent/tbs/one/impl/e/i:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   63: astore 4
    //   65: aload_3
    //   66: invokevirtual 90	java/io/File:exists	()Z
    //   69: ifeq +94 -> 163
    //   72: aload 4
    //   74: ldc 101
    //   76: ldc 103
    //   78: invokevirtual 106	com/tencent/tbs/one/impl/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   81: new 108	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_0
    //   90: new 113	java/util/Properties
    //   93: dup
    //   94: invokespecial 114	java/util/Properties:<init>	()V
    //   97: astore_3
    //   98: aload_3
    //   99: aload_0
    //   100: invokevirtual 118	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   103: aload_3
    //   104: invokevirtual 122	java/util/Properties:entrySet	()Ljava/util/Set;
    //   107: invokeinterface 128 1 0
    //   112: astore_3
    //   113: aload_3
    //   114: invokeinterface 133 1 0
    //   119: ifeq +169 -> 288
    //   122: aload_3
    //   123: invokeinterface 137 1 0
    //   128: checkcast 139	java/util/Map$Entry
    //   131: astore 5
    //   133: aload 4
    //   135: aload 5
    //   137: invokeinterface 142 1 0
    //   142: invokevirtual 143	java/lang/Object:toString	()Ljava/lang/String;
    //   145: aload 5
    //   147: invokeinterface 146 1 0
    //   152: invokevirtual 106	com/tencent/tbs/one/impl/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   155: goto -42 -> 113
    //   158: astore_3
    //   159: aload_0
    //   160: invokestatic 151	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   163: ldc 153
    //   165: aload_1
    //   166: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +52 -> 221
    //   172: aload 4
    //   174: getfield 163	com/tencent/tbs/one/impl/e/i:q	Landroid/content/SharedPreferences;
    //   177: astore_3
    //   178: aload_3
    //   179: ldc 165
    //   181: invokeinterface 171 2 0
    //   186: ifne +35 -> 221
    //   189: getstatic 177	com/tencent/tbs/sdk/BuildConfig:COMPONENT_SDK_VERSIONS	Ljava/util/Map;
    //   192: invokeinterface 182 1 0
    //   197: astore_0
    //   198: aload_3
    //   199: invokeinterface 186 1 0
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 165
    //   208: aload_0
    //   209: invokeinterface 192 3 0
    //   214: pop
    //   215: aload_3
    //   216: invokeinterface 195 1 0
    //   221: aload 4
    //   223: areturn
    //   224: aload_0
    //   225: invokevirtual 74	android/content/Context:getPackageName	()Ljava/lang/String;
    //   228: ldc 197
    //   230: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: istore_2
    //   234: goto -224 -> 10
    //   237: new 62	java/io/File
    //   240: dup
    //   241: new 62	java/io/File
    //   244: dup
    //   245: new 62	java/io/File
    //   248: dup
    //   249: new 62	java/io/File
    //   252: dup
    //   253: new 62	java/io/File
    //   256: dup
    //   257: aload_3
    //   258: ldc 199
    //   260: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   263: ldc 201
    //   265: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   268: aload_0
    //   269: invokevirtual 74	android/content/Context:getPackageName	()Ljava/lang/String;
    //   272: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   275: aload_1
    //   276: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   279: ldc 203
    //   281: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   284: astore_3
    //   285: goto -238 -> 47
    //   288: aload_0
    //   289: invokestatic 151	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   292: goto -129 -> 163
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_0
    //   298: aload_0
    //   299: invokestatic 151	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   302: aload_1
    //   303: athrow
    //   304: astore_0
    //   305: ldc 205
    //   307: iconst_2
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_1
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_0
    //   318: aastore
    //   319: invokestatic 211	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload 4
    //   324: areturn
    //   325: astore_1
    //   326: goto -28 -> 298
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_0
    //   332: goto -173 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramContext	Context
    //   0	335	1	paramString	String
    //   9	225	2	bool	boolean
    //   3	120	3	localObject1	Object
    //   158	1	3	localIOException	java.io.IOException
    //   177	108	3	localObject2	Object
    //   63	260	4	locali	i
    //   131	15	5	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   90	113	158	java/io/IOException
    //   113	155	158	java/io/IOException
    //   81	90	295	finally
    //   189	221	304	java/lang/Throwable
    //   90	113	325	finally
    //   113	155	325	finally
    //   81	90	329	java/io/IOException
  }
  
  public static void a(Context paramContext)
  {
    synchronized (a)
    {
      if (!b)
      {
        TBSLogger.initialize(paramContext.getApplicationContext(), "onelog", 604800000L, 3145728L);
        f.a(new a.1());
        StatisticReport.initialize(paramContext.getApplicationContext());
        com.tencent.tbs.one.impl.common.h.a = new a.2();
        Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(paramContext.getDir("tbs", 0)));
        b = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a
 * JD-Core Version:    0.7.0.1
 */