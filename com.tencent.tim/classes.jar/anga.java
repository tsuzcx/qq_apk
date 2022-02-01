import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import java.io.File;

public class anga
{
  private static String cdD = "Xiaomi;Redmi 4X;23|LGE;Nexus 5X;27|HUAWEI;CAM-UL00;23|Meizu;M2 E;23|vivo;vivo X9s Plus L;25";
  
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    return ankq.isSupportPortarit();
  }
  
  static boolean awC()
  {
    return PTHumanSegmenter.HUMAN_SEGMENT.isResourceReady();
  }
  
  public static boolean awE()
  {
    return isFoundProduct(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, cdD);
  }
  
  /* Error */
  static boolean b(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 77	anga:zz	()Ljava/lang/String;
    //   12: astore_0
    //   13: new 36	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   31: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_0
    //   38: new 79	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokevirtual 88	java/io/File:exists	()Z
    //   53: ifeq +65 -> 118
    //   56: invokestatic 91	anga:zy	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +26 -> 89
    //   66: aload_0
    //   67: ldc 99
    //   69: invokestatic 104	anfi:by	(Ljava/lang/String;Ljava/lang/String;)Z
    //   72: ifeq +17 -> 89
    //   75: ldc 106
    //   77: ldc 108
    //   79: aconst_null
    //   80: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: ldc 2
    //   85: monitorexit
    //   86: iload 4
    //   88: ireturn
    //   89: aload_0
    //   90: invokestatic 119	aqhq:cn	(Ljava/lang/String;)V
    //   93: ldc 106
    //   95: new 36	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   102: ldc 121
    //   104: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aconst_null
    //   115: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload 7
    //   120: invokevirtual 124	java/io/File:mkdirs	()Z
    //   123: istore 4
    //   125: ldc 106
    //   127: new 36	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   134: ldc 126
    //   136: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: iload 4
    //   141: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aconst_null
    //   148: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_2
    //   152: aload_0
    //   153: iconst_0
    //   154: invokestatic 133	aqhq:W	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   157: aload_0
    //   158: ldc 99
    //   160: invokestatic 104	anfi:by	(Ljava/lang/String;Ljava/lang/String;)Z
    //   163: istore 4
    //   165: ldc 106
    //   167: new 36	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   174: ldc 135
    //   176: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 4
    //   181: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: iload 4
    //   193: ifeq +155 -> 348
    //   196: aload_1
    //   197: invokestatic 139	anga:oX	(Ljava/lang/String;)Z
    //   200: istore 6
    //   202: ldc 106
    //   204: new 36	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   211: ldc 141
    //   213: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 6
    //   218: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   221: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: aconst_null
    //   225: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: iload 5
    //   230: istore 4
    //   232: iload 6
    //   234: ifne +97 -> 331
    //   237: aload_1
    //   238: invokestatic 139	anga:oX	(Ljava/lang/String;)Z
    //   241: istore 6
    //   243: ldc 106
    //   245: new 36	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   252: ldc 143
    //   254: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: iload 6
    //   259: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aconst_null
    //   266: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: iload 5
    //   271: istore 4
    //   273: iload 6
    //   275: ifne +56 -> 331
    //   278: ldc 106
    //   280: ldc 145
    //   282: aconst_null
    //   283: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   286: ldc 147
    //   288: invokestatic 139	anga:oX	(Ljava/lang/String;)Z
    //   291: istore 4
    //   293: ldc 106
    //   295: new 36	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   302: ldc 149
    //   304: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: ldc 151
    //   314: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_1
    //   318: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aconst_null
    //   325: invokestatic 114	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: iconst_1
    //   329: istore 4
    //   331: invokestatic 154	anga:dPk	()V
    //   334: goto -251 -> 83
    //   337: astore_0
    //   338: aload_0
    //   339: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   342: iconst_1
    //   343: istore 4
    //   345: goto -262 -> 83
    //   348: iconst_1
    //   349: istore 4
    //   351: goto -268 -> 83
    //   354: astore_0
    //   355: ldc 2
    //   357: monitorexit
    //   358: aload_0
    //   359: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	360	1	paramString1	String
    //   0	360	2	paramString2	String
    //   0	360	3	paramInt	int
    //   4	346	4	bool1	boolean
    //   1	269	5	bool2	boolean
    //   200	74	6	bool3	boolean
    //   46	73	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   151	191	337	java/lang/Exception
    //   196	228	337	java/lang/Exception
    //   237	269	337	java/lang/Exception
    //   278	328	337	java/lang/Exception
    //   331	334	337	java/lang/Exception
    //   9	83	354	finally
    //   89	118	354	finally
    //   118	151	354	finally
    //   151	191	354	finally
    //   196	228	354	finally
    //   237	269	354	finally
    //   278	328	354	finally
    //   331	334	354	finally
    //   338	342	354	finally
  }
  
  public static void dPk() {}
  
  private static boolean isFoundProduct(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString2 == null) {}
    do
    {
      return bool2;
      paramString2 = paramString2.split("\\|");
    } while (paramString2 == null);
    int j = paramString2.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool3;
      if (i < j)
      {
        if (paramString2[i].equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ShortVideoPortraitResourceManager", 2, "in black list:" + bool1 + ", buildType:" + paramString1);
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean oX(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).edit();
    localEditor.putString("portrait_sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.k("ShortVideoPortraitResourceManager", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  public static String zy()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).getString("portrait_sv_md5_version_soname_key", "Portrait000_0");
    boolean bool = anfi.aj(str, 9);
    VideoEnvironment.k("ShortVideoPortraitResourceManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Portrait000_0";
  }
  
  public static String zz()
  {
    String str = ankq.aK(VideoEnvironment.getContext());
    return str + "portrait_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anga
 * JD-Core Version:    0.7.0.1
 */