package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class n
{
  private static n c = null;
  private Context a = null;
  private File b = null;
  private String d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "https://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "https://log.tbs.qq.com/ajax?c=dl&k=";
  private String g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String i = "https://mqqad.html5.qq.com/adjs";
  private String j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "https://tbsrecovery.imtt.qq.com/getconfig";
  
  @TargetApi(11)
  private n(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    k();
  }
  
  public static n a()
  {
    try
    {
      n localn = c;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new n(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 108	com/tencent/smtt/utils/n:l	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +38 -> 48
    //   13: ldc 80
    //   15: ldc 110
    //   17: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 114	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   40: goto -8 -> 32
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: new 120	java/io/BufferedInputStream
    //   51: dup
    //   52: new 122	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 128	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: new 130	java/util/Properties
    //   67: dup
    //   68: invokespecial 131	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 134	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 136
    //   80: ldc 68
    //   82: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: ldc 68
    //   88: aload_3
    //   89: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +8 -> 100
    //   95: aload_0
    //   96: aload_3
    //   97: putfield 42	com/tencent/smtt/utils/n:d	Ljava/lang/String;
    //   100: aload_1
    //   101: ldc 148
    //   103: ldc 68
    //   105: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: ldc 68
    //   111: aload_3
    //   112: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +8 -> 123
    //   118: aload_0
    //   119: aload_3
    //   120: putfield 50	com/tencent/smtt/utils/n:f	Ljava/lang/String;
    //   123: aload_1
    //   124: ldc 150
    //   126: ldc 68
    //   128: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: ldc 80
    //   134: new 152	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   141: ldc 155
    //   143: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 165	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 68
    //   158: aload_3
    //   159: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifne +8 -> 170
    //   165: aload_0
    //   166: aload_3
    //   167: putfield 54	com/tencent/smtt/utils/n:g	Ljava/lang/String;
    //   170: aload_1
    //   171: ldc 167
    //   173: ldc 68
    //   175: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   178: astore_3
    //   179: ldc 80
    //   181: new 152	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   188: ldc 169
    //   190: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_3
    //   194: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 165	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: ldc 68
    //   205: aload_3
    //   206: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   209: ifne +8 -> 217
    //   212: aload_0
    //   213: aload_3
    //   214: putfield 70	com/tencent/smtt/utils/n:k	Ljava/lang/String;
    //   217: aload_1
    //   218: ldc 171
    //   220: ldc 68
    //   222: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_3
    //   226: ldc 80
    //   228: new 152	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   235: ldc 173
    //   237: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_3
    //   241: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 165	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: ldc 68
    //   252: aload_3
    //   253: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifne +8 -> 264
    //   259: aload_0
    //   260: aload_3
    //   261: putfield 72	com/tencent/smtt/utils/n:l	Ljava/lang/String;
    //   264: aload_1
    //   265: ldc 175
    //   267: ldc 68
    //   269: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_3
    //   273: ldc 80
    //   275: new 152	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   282: ldc 177
    //   284: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 165	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: ldc 68
    //   299: aload_3
    //   300: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: ifne +8 -> 311
    //   306: aload_0
    //   307: aload_3
    //   308: putfield 74	com/tencent/smtt/utils/n:m	Ljava/lang/String;
    //   311: aload_1
    //   312: ldc 179
    //   314: ldc 68
    //   316: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   319: astore_3
    //   320: ldc 68
    //   322: aload_3
    //   323: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifne +8 -> 334
    //   329: aload_0
    //   330: aload_3
    //   331: putfield 58	com/tencent/smtt/utils/n:h	Ljava/lang/String;
    //   334: aload_1
    //   335: ldc 181
    //   337: ldc 68
    //   339: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: astore_3
    //   343: ldc 68
    //   345: aload_3
    //   346: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   349: ifne +8 -> 357
    //   352: aload_0
    //   353: aload_3
    //   354: putfield 62	com/tencent/smtt/utils/n:i	Ljava/lang/String;
    //   357: aload_1
    //   358: ldc 183
    //   360: ldc 68
    //   362: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   365: astore_3
    //   366: ldc 68
    //   368: aload_3
    //   369: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifne +8 -> 380
    //   375: aload_0
    //   376: aload_3
    //   377: putfield 66	com/tencent/smtt/utils/n:j	Ljava/lang/String;
    //   380: aload_1
    //   381: ldc 185
    //   383: ldc 68
    //   385: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   388: astore_3
    //   389: ldc 68
    //   391: aload_3
    //   392: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   395: ifne +8 -> 403
    //   398: aload_0
    //   399: aload_3
    //   400: putfield 78	com/tencent/smtt/utils/n:n	Ljava/lang/String;
    //   403: aload_1
    //   404: ldc 187
    //   406: ldc 68
    //   408: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   411: astore_1
    //   412: ldc 68
    //   414: aload_1
    //   415: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   418: ifne +8 -> 426
    //   421: aload_0
    //   422: aload_1
    //   423: putfield 46	com/tencent/smtt/utils/n:e	Ljava/lang/String;
    //   426: aload_2
    //   427: ifnull -395 -> 32
    //   430: aload_2
    //   431: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   434: goto -402 -> 32
    //   437: astore_1
    //   438: aload_1
    //   439: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   442: goto -410 -> 32
    //   445: astore_2
    //   446: new 192	java/io/StringWriter
    //   449: dup
    //   450: invokespecial 193	java/io/StringWriter:<init>	()V
    //   453: astore_3
    //   454: aload_2
    //   455: new 195	java/io/PrintWriter
    //   458: dup
    //   459: aload_3
    //   460: invokespecial 198	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   463: invokevirtual 201	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   466: ldc 80
    //   468: new 152	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   475: ldc 203
    //   477: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_3
    //   481: invokevirtual 204	java/io/StringWriter:toString	()Ljava/lang/String;
    //   484: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_1
    //   494: ifnull -462 -> 32
    //   497: aload_1
    //   498: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   501: goto -469 -> 32
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   509: goto -477 -> 32
    //   512: astore_1
    //   513: aconst_null
    //   514: astore_2
    //   515: aload_2
    //   516: ifnull +7 -> 523
    //   519: aload_2
    //   520: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   523: aload_1
    //   524: athrow
    //   525: astore_2
    //   526: aload_2
    //   527: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   530: goto -7 -> 523
    //   533: astore_1
    //   534: goto -19 -> 515
    //   537: astore_3
    //   538: aload_1
    //   539: astore_2
    //   540: aload_3
    //   541: astore_1
    //   542: goto -27 -> 515
    //   545: astore_3
    //   546: aload_2
    //   547: astore_1
    //   548: aload_3
    //   549: astore_2
    //   550: goto -104 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	n
    //   3	1	1	localObject1	Object
    //   35	2	1	localIOException1	java.io.IOException
    //   43	4	1	localObject2	Object
    //   71	352	1	localObject3	Object
    //   437	61	1	localIOException2	java.io.IOException
    //   504	2	1	localIOException3	java.io.IOException
    //   512	12	1	localObject4	Object
    //   533	6	1	localObject5	Object
    //   541	7	1	localObject6	Object
    //   8	423	2	localObject7	Object
    //   445	10	2	localThrowable1	Throwable
    //   514	6	2	localObject8	Object
    //   525	2	2	localIOException4	java.io.IOException
    //   539	11	2	localObject9	Object
    //   85	396	3	localObject10	Object
    //   537	4	3	localObject11	Object
    //   545	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	35	java/io/IOException
    //   24	32	43	finally
    //   36	40	43	finally
    //   430	434	43	finally
    //   438	442	43	finally
    //   497	501	43	finally
    //   505	509	43	finally
    //   519	523	43	finally
    //   523	525	43	finally
    //   526	530	43	finally
    //   430	434	437	java/io/IOException
    //   4	9	445	java/lang/Throwable
    //   13	20	445	java/lang/Throwable
    //   48	64	445	java/lang/Throwable
    //   497	501	504	java/io/IOException
    //   4	9	512	finally
    //   13	20	512	finally
    //   48	64	512	finally
    //   519	523	525	java/io/IOException
    //   64	100	533	finally
    //   100	123	533	finally
    //   123	170	533	finally
    //   170	217	533	finally
    //   217	264	533	finally
    //   264	311	533	finally
    //   311	334	533	finally
    //   334	357	533	finally
    //   357	380	533	finally
    //   380	403	533	finally
    //   403	426	533	finally
    //   446	493	537	finally
    //   64	100	545	java/lang/Throwable
    //   100	123	545	java/lang/Throwable
    //   123	170	545	java/lang/Throwable
    //   170	217	545	java/lang/Throwable
    //   217	264	545	java/lang/Throwable
    //   264	311	545	java/lang/Throwable
    //   311	334	545	java/lang/Throwable
    //   334	357	545	java/lang/Throwable
    //   357	380	545	java/lang/Throwable
    //   380	403	545	java/lang/Throwable
    //   403	426	545	java/lang/Throwable
  }
  
  private File l()
  {
    int i2 = 1;
    label67:
    label216:
    label350:
    label352:
    label357:
    label360:
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        if (this.b != null) {
          break label216;
        }
        localObject = this.a.getApplicationContext().getApplicationInfo().packageName;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label193;
        }
        if (this.a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label352;
        }
        i1 = 1;
        if (this.a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label357;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject = null;
      }
      TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
      this.b = new File(FileUtil.a(this.a, 5));
      if (this.b != null) {
        if (!this.b.isDirectory())
        {
          break label350;
          label113:
          this.b = new File(FileUtil.a(this.a, 8));
        }
        else
        {
          for (;;)
          {
            StringWriter localStringWriter = new StringWriter();
            localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
            return localObject;
            this.b = new File(FileUtil.a(this.a, 8));
            break;
            TbsLog.i("TbsCommonConfig", "mTbsConfigDir is " + this.b.getAbsolutePath());
            localObject = new File(this.b, "tbsnet.conf");
            if (!((File)localObject).exists())
            {
              TbsLog.e("TbsCommonConfig", "Get file(" + ((File)localObject).getCanonicalPath() + ") failed!");
              return null;
            }
            try
            {
              TbsLog.w("TbsCommonConfig", "pathc:" + ((File)localObject).getCanonicalPath());
              return localObject;
            }
            catch (Throwable localThrowable2) {}
          }
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          break label360;
        }
        if (i2 == 0) {
          break label113;
        }
        break label67;
        return null;
        i1 = 0;
        break;
        i2 = 0;
      }
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public String e()
  {
    return this.l;
  }
  
  public String f()
  {
    return this.m;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.e;
  }
  
  public String j()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */