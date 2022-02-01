package dov.com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import azbz;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoTrimmer
{
  public static int agR;
  private static boolean cHQ;
  public static AtomicBoolean dN = new AtomicBoolean(true);
  static Process f;
  static final Object lock = new Object();
  
  private static void GY(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
    if (cHQ) {
      Log.d("ShortVideoTrimmer", paramString);
    }
  }
  
  public static a a(String paramString)
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 1)) {}
    }
    int j;
    File localFile;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
        j = i;
        if (i <= 0) {
          j = 640;
        }
        localObject = new a();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((a)localObject).cHR = false;
          GY("[@] getCompressConfig : [!file.exists]");
        }
        paramString = o(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((a)localObject).cHR = false;
        GY("[@] getCompressConfig : values=" + paramString);
        if (paramString != null) {
          GY("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
        }
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfig -> get DpcConfig Erro", localNumberFormatException);
        }
      }
      i = 0;
    }
    localNumberFormatException.rotate = fm(paramString[3]);
    localNumberFormatException.srcWidth = paramString[1];
    localNumberFormatException.srcHeight = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.cHR = false;
      GY("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.alX = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.alX > 1688L)
      {
        localNumberFormatException.cHR = true;
        localNumberFormatException.dJq = 25;
        localNumberFormatException.dJo = paramString[1];
        localNumberFormatException.dJp = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.cHR = false;
      GY("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.cHR = true;
    float f1 = j / i;
    localNumberFormatException.dJo = ((int)(paramString[1] * f1));
    localNumberFormatException.dJp = ((int)(f1 * paramString[2]));
    localNumberFormatException.dJq = 25;
    return localNumberFormatException;
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 196	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 197	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: aload 7
    //   17: astore_2
    //   18: aload_0
    //   19: aload_1
    //   20: iload_3
    //   21: aload_1
    //   22: arraylength
    //   23: iload_3
    //   24: isub
    //   25: invokevirtual 203	java/io/InputStream:read	([BII)I
    //   28: istore 4
    //   30: iload 4
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: iload_3
    //   37: iload 4
    //   39: iadd
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload 7
    //   47: astore_2
    //   48: iload 4
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpne -37 -> 15
    //   55: aload 7
    //   57: astore_2
    //   58: aload 7
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 4
    //   64: invokevirtual 207	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: iload_3
    //   73: ifeq +14 -> 87
    //   76: aload 7
    //   78: astore_2
    //   79: aload 7
    //   81: aload_1
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 207	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 210	java/io/FileOutputStream:close	()V
    //   104: iload 6
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 210	java/io/FileOutputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 210	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_1
    //   150: goto -6 -> 144
    //   153: astore_0
    //   154: goto -18 -> 136
    //   157: astore_1
    //   158: aload 7
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   0	164	1	paramArrayOfByte	byte[]
    //   0	164	2	paramString	String
    //   14	70	3	i	int
    //   28	35	4	j	int
    //   1	108	5	bool1	boolean
    //   88	17	6	bool2	boolean
    //   11	148	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	13	111	java/io/IOException
    //   124	128	130	java/io/IOException
    //   3	13	133	finally
    //   99	104	146	java/io/IOException
    //   140	144	149	java/io/IOException
    //   18	30	153	finally
    //   48	55	153	finally
    //   58	67	153	finally
    //   79	87	153	finally
    //   116	120	153	finally
    //   18	30	157	java/io/IOException
    //   48	55	157	java/io/IOException
    //   58	67	157	java/io/IOException
    //   79	87	157	java/io/IOException
  }
  
  private static String[] a(String paramString1, String paramString2, a parama)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = parama.dJo + "x" + String.valueOf(parama.dJp);
    GY("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + parama.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(parama.dJq), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static boolean b(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = c(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.d("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private static boolean bD(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      GY("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  private static boolean c(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokestatic 355	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 101	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: aload 9
    //   28: invokevirtual 106	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 9
    //   36: invokevirtual 358	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +128 -> 173
    //   48: iconst_0
    //   49: putstatic 48	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   52: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +88 -> 145
    //   60: new 119	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 365
    //   75: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 9
    //   83: iconst_0
    //   84: istore_3
    //   85: new 119	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   92: aload 10
    //   94: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 367
    //   100: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore 10
    //   108: new 101	java/io/File
    //   111: dup
    //   112: aload 10
    //   114: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 106	java/io/File:exists	()Z
    //   120: ifeq +81 -> 201
    //   123: getstatic 48	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   126: ifne +75 -> 201
    //   129: aload 9
    //   131: aload 10
    //   133: invokestatic 369	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:bD	(Ljava/lang/String;Ljava/lang/String;)Z
    //   136: ifeq +65 -> 201
    //   139: iconst_1
    //   140: istore 4
    //   142: iload 4
    //   144: ireturn
    //   145: new 119	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   152: aload 10
    //   154: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 371
    //   160: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 9
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -85 -> 85
    //   173: iconst_1
    //   174: putstatic 48	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   177: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   180: bipush 16
    //   182: if_icmplt +11 -> 193
    //   185: iload_1
    //   186: istore_3
    //   187: aconst_null
    //   188: astore 9
    //   190: goto -105 -> 85
    //   193: iload_2
    //   194: istore_3
    //   195: aconst_null
    //   196: astore 9
    //   198: goto -113 -> 85
    //   201: iload_1
    //   202: ifeq +7 -> 209
    //   205: iload_2
    //   206: ifne +140 -> 346
    //   209: new 373	java/io/FileInputStream
    //   212: dup
    //   213: aload 9
    //   215: invokespecial 374	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   218: astore_0
    //   219: ldc_w 376
    //   222: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   225: aload_0
    //   226: astore 8
    //   228: aload_0
    //   229: astore 7
    //   231: aload_0
    //   232: sipush 8192
    //   235: newarray byte
    //   237: aload 10
    //   239: invokestatic 378	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   242: istore 6
    //   244: aload_0
    //   245: astore 8
    //   247: aload_0
    //   248: astore 7
    //   250: new 119	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 380
    //   260: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 6
    //   265: invokevirtual 383	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   268: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   274: iload 6
    //   276: istore 4
    //   278: iload 6
    //   280: ifeq +55 -> 335
    //   283: aload_0
    //   284: astore 8
    //   286: aload_0
    //   287: astore 7
    //   289: new 101	java/io/File
    //   292: dup
    //   293: aload 10
    //   295: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: iconst_1
    //   299: iconst_1
    //   300: invokevirtual 387	java/io/File:setExecutable	(ZZ)Z
    //   303: istore 4
    //   305: aload_0
    //   306: astore 8
    //   308: aload_0
    //   309: astore 7
    //   311: new 119	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 389
    //   321: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 4
    //   326: invokevirtual 383	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   329: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 390	java/io/InputStream:close	()V
    //   343: iload 4
    //   345: ireturn
    //   346: aload_0
    //   347: invokevirtual 396	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   350: iload_3
    //   351: invokevirtual 402	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   354: astore_0
    //   355: aload_0
    //   356: astore 8
    //   358: aload_0
    //   359: astore 7
    //   361: ldc_w 404
    //   364: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   367: goto -142 -> 225
    //   370: astore_0
    //   371: aload 8
    //   373: astore 7
    //   375: aload_0
    //   376: invokevirtual 405	java/lang/Exception:printStackTrace	()V
    //   379: aload 8
    //   381: astore 7
    //   383: new 119	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 407
    //   393: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 408	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   409: iload 5
    //   411: istore 4
    //   413: aload 8
    //   415: ifnull -273 -> 142
    //   418: aload 8
    //   420: invokevirtual 390	java/io/InputStream:close	()V
    //   423: iconst_0
    //   424: ireturn
    //   425: astore_0
    //   426: aload_0
    //   427: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   430: iconst_0
    //   431: ireturn
    //   432: astore_0
    //   433: aload_0
    //   434: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   437: goto -94 -> 343
    //   440: astore_0
    //   441: aload 7
    //   443: ifnull +8 -> 451
    //   446: aload 7
    //   448: invokevirtual 390	java/io/InputStream:close	()V
    //   451: aload_0
    //   452: athrow
    //   453: astore 7
    //   455: aload 7
    //   457: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   460: goto -9 -> 451
    //   463: astore 8
    //   465: aload_0
    //   466: astore 7
    //   468: aload 8
    //   470: astore_0
    //   471: goto -30 -> 441
    //   474: astore 7
    //   476: aload_0
    //   477: astore 8
    //   479: aload 7
    //   481: astore_0
    //   482: goto -111 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramContext	Context
    //   0	485	1	paramInt1	int
    //   0	485	2	paramInt2	int
    //   84	267	3	i	int
    //   140	272	4	bool1	boolean
    //   7	403	5	bool2	boolean
    //   242	37	6	bool3	boolean
    //   1	446	7	localObject1	Object
    //   453	3	7	localIOException	java.io.IOException
    //   466	1	7	localContext1	Context
    //   474	6	7	localException	Exception
    //   4	415	8	localContext2	Context
    //   463	6	8	localObject2	Object
    //   477	1	8	localContext3	Context
    //   24	190	9	localObject3	Object
    //   13	281	10	str	String
    // Exception table:
    //   from	to	target	type
    //   209	219	370	java/lang/Exception
    //   231	244	370	java/lang/Exception
    //   250	274	370	java/lang/Exception
    //   289	305	370	java/lang/Exception
    //   311	335	370	java/lang/Exception
    //   346	355	370	java/lang/Exception
    //   361	367	370	java/lang/Exception
    //   418	423	425	java/io/IOException
    //   339	343	432	java/io/IOException
    //   209	219	440	finally
    //   231	244	440	finally
    //   250	274	440	finally
    //   289	305	440	finally
    //   311	335	440	finally
    //   346	355	440	finally
    //   361	367	440	finally
    //   375	379	440	finally
    //   383	409	440	finally
    //   446	451	453	java/io/IOException
    //   219	225	463	finally
    //   219	225	474	java/lang/Exception
  }
  
  /* Error */
  public static int f(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_1
    //   6: invokestatic 419	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Ldov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 109	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:cHR	Z
    //   16: ifne +11 -> 27
    //   19: ldc_w 421
    //   22: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: ireturn
    //   27: aload_1
    //   28: aload_2
    //   29: aload 9
    //   31: invokestatic 423	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Ldov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;)[Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +12 -> 48
    //   39: ldc_w 425
    //   42: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   45: bipush 254
    //   47: ireturn
    //   48: aload_0
    //   49: invokestatic 355	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   52: astore 11
    //   54: invokestatic 428	com/tencent/mobileqq/shortvideo/VideoEnvironment:zQ	()Ljava/lang/String;
    //   57: astore_0
    //   58: getstatic 48	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   61: ifne +38 -> 99
    //   64: new 101	java/io/File
    //   67: dup
    //   68: new 119	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   75: aload 11
    //   77: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 106	java/io/File:exists	()Z
    //   93: ifne +6 -> 99
    //   96: bipush 253
    //   98: ireturn
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 10
    //   105: new 430	java/lang/ProcessBuilder
    //   108: dup
    //   109: iconst_0
    //   110: anewarray 79	java/lang/String
    //   113: invokespecial 433	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   116: astore 13
    //   118: aload 13
    //   120: iconst_1
    //   121: invokevirtual 437	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   124: pop
    //   125: new 439	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 440	java/util/ArrayList:<init>	()V
    //   132: astore 12
    //   134: aload 12
    //   136: new 119	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   143: aload 11
    //   145: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 367
    //   151: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokeinterface 445 2 0
    //   162: pop
    //   163: new 119	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 447
    //   173: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 12
    //   178: iconst_0
    //   179: invokeinterface 451 2 0
    //   184: checkcast 79	java/lang/String
    //   187: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   196: aload_1
    //   197: arraylength
    //   198: istore 4
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: iload 4
    //   205: if_icmpge +21 -> 226
    //   208: aload 12
    //   210: aload_1
    //   211: iload_3
    //   212: aaload
    //   213: invokeinterface 445 2 0
    //   218: pop
    //   219: iload_3
    //   220: iconst_1
    //   221: iadd
    //   222: istore_3
    //   223: goto -21 -> 202
    //   226: aload 12
    //   228: new 119	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   235: aload 11
    //   237: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokeinterface 445 2 0
    //   252: pop
    //   253: aload 13
    //   255: aload 12
    //   257: invokevirtual 455	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   260: pop
    //   261: new 119	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 457
    //   271: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 12
    //   276: aload 12
    //   278: invokeinterface 460 1 0
    //   283: iconst_1
    //   284: isub
    //   285: invokeinterface 451 2 0
    //   290: checkcast 79	java/lang/String
    //   293: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   302: aload 13
    //   304: invokevirtual 464	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   307: astore 13
    //   309: getstatic 24	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   312: astore_0
    //   313: aload_0
    //   314: monitorenter
    //   315: aload 13
    //   317: putstatic 466	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   320: aload_0
    //   321: monitorexit
    //   322: getstatic 31	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   325: invokevirtual 468	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   328: ifne +260 -> 588
    //   331: aconst_null
    //   332: putstatic 466	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   335: aload 13
    //   337: invokevirtual 473	java/lang/Process:destroy	()V
    //   340: getstatic 31	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   343: iconst_1
    //   344: invokevirtual 476	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   347: iconst_0
    //   348: ifeq +11 -> 359
    //   351: new 478	java/lang/NullPointerException
    //   354: dup
    //   355: invokespecial 479	java/lang/NullPointerException:<init>	()V
    //   358: athrow
    //   359: iconst_0
    //   360: ifeq +11 -> 371
    //   363: new 478	java/lang/NullPointerException
    //   366: dup
    //   367: invokespecial 479	java/lang/NullPointerException:<init>	()V
    //   370: athrow
    //   371: iconst_0
    //   372: ifeq -347 -> 25
    //   375: new 478	java/lang/NullPointerException
    //   378: dup
    //   379: invokespecial 479	java/lang/NullPointerException:<init>	()V
    //   382: athrow
    //   383: astore_0
    //   384: iconst_m1
    //   385: ireturn
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: astore 13
    //   393: aconst_null
    //   394: astore_0
    //   395: aconst_null
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 12
    //   400: sipush -1001
    //   403: istore 4
    //   405: aload 12
    //   407: astore 11
    //   409: aload_1
    //   410: astore 10
    //   412: aload_0
    //   413: astore 9
    //   415: aload 13
    //   417: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   420: aload 12
    //   422: astore 11
    //   424: aload_1
    //   425: astore 10
    //   427: aload_0
    //   428: astore 9
    //   430: new 119	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 481
    //   440: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 13
    //   445: invokevirtual 482	java/io/IOException:toString	()Ljava/lang/String;
    //   448: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: ifnull +7 -> 465
    //   461: aload_0
    //   462: invokevirtual 390	java/io/InputStream:close	()V
    //   465: aload_1
    //   466: ifnull +7 -> 473
    //   469: aload_1
    //   470: invokevirtual 485	java/io/InputStreamReader:close	()V
    //   473: iload 4
    //   475: istore_3
    //   476: aload 12
    //   478: ifnull +11 -> 489
    //   481: aload 12
    //   483: invokevirtual 488	java/io/BufferedReader:close	()V
    //   486: iload 4
    //   488: istore_3
    //   489: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   492: lstore 5
    //   494: new 119	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   501: ldc_w 490
    //   504: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: lload 5
    //   509: lload 7
    //   511: lsub
    //   512: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   515: ldc_w 495
    //   518: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: iload_3
    //   522: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   531: iload_3
    //   532: ifeq +47 -> 579
    //   535: new 101	java/io/File
    //   538: dup
    //   539: aload_2
    //   540: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   543: astore_0
    //   544: aload_0
    //   545: invokevirtual 106	java/io/File:exists	()Z
    //   548: ifeq +31 -> 579
    //   551: aload_0
    //   552: invokevirtual 498	java/io/File:delete	()Z
    //   555: pop
    //   556: new 119	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 500
    //   566: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: iload_3
    //   570: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   579: getstatic 31	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   582: iconst_1
    //   583: invokevirtual 476	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   586: iload_3
    //   587: ireturn
    //   588: aload 13
    //   590: invokevirtual 504	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   593: astore_0
    //   594: new 484	java/io/InputStreamReader
    //   597: dup
    //   598: aload_0
    //   599: invokespecial 507	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   602: astore_1
    //   603: new 487	java/io/BufferedReader
    //   606: dup
    //   607: aload_1
    //   608: invokespecial 510	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   611: astore 12
    //   613: aload 12
    //   615: astore 11
    //   617: aload_1
    //   618: astore 10
    //   620: aload_0
    //   621: astore 9
    //   623: aload 13
    //   625: invokevirtual 513	java/lang/Process:waitFor	()I
    //   628: pop
    //   629: aload 12
    //   631: astore 11
    //   633: aload_1
    //   634: astore 10
    //   636: aload_0
    //   637: astore 9
    //   639: aload 13
    //   641: invokevirtual 516	java/lang/Process:exitValue	()I
    //   644: istore 4
    //   646: aload 12
    //   648: astore 11
    //   650: aload_1
    //   651: astore 10
    //   653: aload_0
    //   654: astore 9
    //   656: new 119	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 518
    //   666: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: iload 4
    //   671: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   680: aload 12
    //   682: astore 11
    //   684: aload_1
    //   685: astore 10
    //   687: aload_0
    //   688: astore 9
    //   690: aload 12
    //   692: invokevirtual 521	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   695: astore 14
    //   697: aload 14
    //   699: ifnull +40 -> 739
    //   702: aload 12
    //   704: astore 11
    //   706: aload_1
    //   707: astore 10
    //   709: aload_0
    //   710: astore 9
    //   712: new 119	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 523
    //   722: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 14
    //   727: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   736: goto -56 -> 680
    //   739: aload 12
    //   741: astore 11
    //   743: aload_1
    //   744: astore 10
    //   746: aload_0
    //   747: astore 9
    //   749: aload 13
    //   751: invokevirtual 473	java/lang/Process:destroy	()V
    //   754: aload 12
    //   756: astore 11
    //   758: aload_1
    //   759: astore 10
    //   761: aload_0
    //   762: astore 9
    //   764: getstatic 24	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   767: astore 13
    //   769: aload 12
    //   771: astore 11
    //   773: aload_1
    //   774: astore 10
    //   776: aload_0
    //   777: astore 9
    //   779: aload 13
    //   781: monitorenter
    //   782: aconst_null
    //   783: putstatic 466	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   786: aload 13
    //   788: monitorexit
    //   789: aload 12
    //   791: astore 11
    //   793: aload_1
    //   794: astore 10
    //   796: aload_0
    //   797: astore 9
    //   799: ldc_w 525
    //   802: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   805: aload_0
    //   806: ifnull +7 -> 813
    //   809: aload_0
    //   810: invokevirtual 390	java/io/InputStream:close	()V
    //   813: aload_1
    //   814: ifnull +7 -> 821
    //   817: aload_1
    //   818: invokevirtual 485	java/io/InputStreamReader:close	()V
    //   821: iload 4
    //   823: istore_3
    //   824: aload 12
    //   826: ifnull -337 -> 489
    //   829: aload 12
    //   831: invokevirtual 488	java/io/BufferedReader:close	()V
    //   834: iload 4
    //   836: istore_3
    //   837: goto -348 -> 489
    //   840: astore_0
    //   841: iload 4
    //   843: istore_3
    //   844: goto -355 -> 489
    //   847: astore 14
    //   849: aload 13
    //   851: monitorexit
    //   852: aload 12
    //   854: astore 11
    //   856: aload_1
    //   857: astore 10
    //   859: aload_0
    //   860: astore 9
    //   862: aload 14
    //   864: athrow
    //   865: astore 13
    //   867: sipush -1002
    //   870: istore 4
    //   872: aload 12
    //   874: astore 11
    //   876: aload_1
    //   877: astore 10
    //   879: aload_0
    //   880: astore 9
    //   882: aload 13
    //   884: invokevirtual 526	java/lang/InterruptedException:printStackTrace	()V
    //   887: aload 12
    //   889: astore 11
    //   891: aload_1
    //   892: astore 10
    //   894: aload_0
    //   895: astore 9
    //   897: new 119	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   904: ldc_w 528
    //   907: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload 13
    //   912: invokevirtual 529	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   915: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   924: aload_0
    //   925: ifnull +7 -> 932
    //   928: aload_0
    //   929: invokevirtual 390	java/io/InputStream:close	()V
    //   932: aload_1
    //   933: ifnull +7 -> 940
    //   936: aload_1
    //   937: invokevirtual 485	java/io/InputStreamReader:close	()V
    //   940: iload 4
    //   942: istore_3
    //   943: aload 12
    //   945: ifnull -456 -> 489
    //   948: aload 12
    //   950: invokevirtual 488	java/io/BufferedReader:close	()V
    //   953: iload 4
    //   955: istore_3
    //   956: goto -467 -> 489
    //   959: astore_0
    //   960: iload 4
    //   962: istore_3
    //   963: goto -474 -> 489
    //   966: astore 13
    //   968: aconst_null
    //   969: astore_0
    //   970: aconst_null
    //   971: astore_1
    //   972: aconst_null
    //   973: astore 12
    //   975: sipush -1003
    //   978: istore 4
    //   980: aload 12
    //   982: astore 11
    //   984: aload_1
    //   985: astore 10
    //   987: aload_0
    //   988: astore 9
    //   990: aload 13
    //   992: invokevirtual 405	java/lang/Exception:printStackTrace	()V
    //   995: aload 12
    //   997: astore 11
    //   999: aload_1
    //   1000: astore 10
    //   1002: aload_0
    //   1003: astore 9
    //   1005: new 119	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1012: ldc_w 531
    //   1015: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 13
    //   1020: invokevirtual 408	java/lang/Exception:toString	()Ljava/lang/String;
    //   1023: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   1032: aload_0
    //   1033: ifnull +7 -> 1040
    //   1036: aload_0
    //   1037: invokevirtual 390	java/io/InputStream:close	()V
    //   1040: aload_1
    //   1041: ifnull +7 -> 1048
    //   1044: aload_1
    //   1045: invokevirtual 485	java/io/InputStreamReader:close	()V
    //   1048: iload 4
    //   1050: istore_3
    //   1051: aload 12
    //   1053: ifnull -564 -> 489
    //   1056: aload 12
    //   1058: invokevirtual 488	java/io/BufferedReader:close	()V
    //   1061: iload 4
    //   1063: istore_3
    //   1064: goto -575 -> 489
    //   1067: astore_0
    //   1068: iload 4
    //   1070: istore_3
    //   1071: goto -582 -> 489
    //   1074: astore_1
    //   1075: aconst_null
    //   1076: astore_0
    //   1077: aload 9
    //   1079: astore_2
    //   1080: aload_0
    //   1081: ifnull +7 -> 1088
    //   1084: aload_0
    //   1085: invokevirtual 390	java/io/InputStream:close	()V
    //   1088: aload_2
    //   1089: ifnull +7 -> 1096
    //   1092: aload_2
    //   1093: invokevirtual 485	java/io/InputStreamReader:close	()V
    //   1096: aload 10
    //   1098: ifnull +8 -> 1106
    //   1101: aload 10
    //   1103: invokevirtual 488	java/io/BufferedReader:close	()V
    //   1106: aload_1
    //   1107: athrow
    //   1108: astore_0
    //   1109: goto -530 -> 579
    //   1112: astore_0
    //   1113: goto -7 -> 1106
    //   1116: astore_1
    //   1117: aload 9
    //   1119: astore_2
    //   1120: goto -40 -> 1080
    //   1123: astore 9
    //   1125: aload_1
    //   1126: astore_2
    //   1127: aload 9
    //   1129: astore_1
    //   1130: goto -50 -> 1080
    //   1133: astore_1
    //   1134: aload 10
    //   1136: astore_2
    //   1137: aload 11
    //   1139: astore 10
    //   1141: aload 9
    //   1143: astore_0
    //   1144: goto -64 -> 1080
    //   1147: astore 13
    //   1149: aconst_null
    //   1150: astore_1
    //   1151: aconst_null
    //   1152: astore 12
    //   1154: goto -179 -> 975
    //   1157: astore 13
    //   1159: aconst_null
    //   1160: astore 12
    //   1162: goto -187 -> 975
    //   1165: astore 13
    //   1167: goto -192 -> 975
    //   1170: astore 13
    //   1172: aconst_null
    //   1173: astore_0
    //   1174: aconst_null
    //   1175: astore_1
    //   1176: aconst_null
    //   1177: astore 12
    //   1179: goto -312 -> 867
    //   1182: astore 13
    //   1184: aconst_null
    //   1185: astore_1
    //   1186: aconst_null
    //   1187: astore 12
    //   1189: goto -322 -> 867
    //   1192: astore 13
    //   1194: aconst_null
    //   1195: astore 12
    //   1197: goto -330 -> 867
    //   1200: astore_0
    //   1201: iload 4
    //   1203: istore_3
    //   1204: goto -715 -> 489
    //   1207: astore 13
    //   1209: aconst_null
    //   1210: astore_1
    //   1211: aconst_null
    //   1212: astore 12
    //   1214: goto -814 -> 400
    //   1217: astore 13
    //   1219: aconst_null
    //   1220: astore 12
    //   1222: goto -822 -> 400
    //   1225: astore 13
    //   1227: goto -827 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1230	0	paramContext	Context
    //   0	1230	1	paramString1	String
    //   0	1230	2	paramString2	String
    //   201	1003	3	i	int
    //   198	1004	4	j	int
    //   492	16	5	l1	long
    //   3	507	7	l2	long
    //   9	1109	9	localObject1	Object
    //   1123	19	9	localObject2	Object
    //   103	1037	10	localObject3	Object
    //   52	1086	11	localObject4	Object
    //   132	1089	12	localObject5	Object
    //   116	220	13	localObject6	Object
    //   391	359	13	localIOException1	java.io.IOException
    //   767	83	13	localObject7	Object
    //   865	46	13	localInterruptedException1	java.lang.InterruptedException
    //   966	53	13	localException1	Exception
    //   1147	1	13	localException2	Exception
    //   1157	1	13	localException3	Exception
    //   1165	1	13	localException4	Exception
    //   1170	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1182	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1192	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1207	1	13	localIOException2	java.io.IOException
    //   1217	1	13	localIOException3	java.io.IOException
    //   1225	1	13	localIOException4	java.io.IOException
    //   695	31	14	str	String
    //   847	16	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   351	359	383	java/io/IOException
    //   363	371	383	java/io/IOException
    //   375	383	383	java/io/IOException
    //   315	322	386	finally
    //   387	389	386	finally
    //   105	200	391	java/io/IOException
    //   208	219	391	java/io/IOException
    //   226	315	391	java/io/IOException
    //   322	347	391	java/io/IOException
    //   389	391	391	java/io/IOException
    //   588	594	391	java/io/IOException
    //   809	813	840	java/io/IOException
    //   817	821	840	java/io/IOException
    //   829	834	840	java/io/IOException
    //   782	789	847	finally
    //   849	852	847	finally
    //   623	629	865	java/lang/InterruptedException
    //   639	646	865	java/lang/InterruptedException
    //   656	680	865	java/lang/InterruptedException
    //   690	697	865	java/lang/InterruptedException
    //   712	736	865	java/lang/InterruptedException
    //   749	754	865	java/lang/InterruptedException
    //   764	769	865	java/lang/InterruptedException
    //   779	782	865	java/lang/InterruptedException
    //   799	805	865	java/lang/InterruptedException
    //   862	865	865	java/lang/InterruptedException
    //   928	932	959	java/io/IOException
    //   936	940	959	java/io/IOException
    //   948	953	959	java/io/IOException
    //   105	200	966	java/lang/Exception
    //   208	219	966	java/lang/Exception
    //   226	315	966	java/lang/Exception
    //   322	347	966	java/lang/Exception
    //   389	391	966	java/lang/Exception
    //   588	594	966	java/lang/Exception
    //   1036	1040	1067	java/io/IOException
    //   1044	1048	1067	java/io/IOException
    //   1056	1061	1067	java/io/IOException
    //   105	200	1074	finally
    //   208	219	1074	finally
    //   226	315	1074	finally
    //   322	347	1074	finally
    //   389	391	1074	finally
    //   588	594	1074	finally
    //   535	579	1108	java/lang/Exception
    //   1084	1088	1112	java/io/IOException
    //   1092	1096	1112	java/io/IOException
    //   1101	1106	1112	java/io/IOException
    //   594	603	1116	finally
    //   603	613	1123	finally
    //   415	420	1133	finally
    //   430	457	1133	finally
    //   623	629	1133	finally
    //   639	646	1133	finally
    //   656	680	1133	finally
    //   690	697	1133	finally
    //   712	736	1133	finally
    //   749	754	1133	finally
    //   764	769	1133	finally
    //   779	782	1133	finally
    //   799	805	1133	finally
    //   862	865	1133	finally
    //   882	887	1133	finally
    //   897	924	1133	finally
    //   990	995	1133	finally
    //   1005	1032	1133	finally
    //   594	603	1147	java/lang/Exception
    //   603	613	1157	java/lang/Exception
    //   623	629	1165	java/lang/Exception
    //   639	646	1165	java/lang/Exception
    //   656	680	1165	java/lang/Exception
    //   690	697	1165	java/lang/Exception
    //   712	736	1165	java/lang/Exception
    //   749	754	1165	java/lang/Exception
    //   764	769	1165	java/lang/Exception
    //   779	782	1165	java/lang/Exception
    //   799	805	1165	java/lang/Exception
    //   862	865	1165	java/lang/Exception
    //   105	200	1170	java/lang/InterruptedException
    //   208	219	1170	java/lang/InterruptedException
    //   226	315	1170	java/lang/InterruptedException
    //   322	347	1170	java/lang/InterruptedException
    //   389	391	1170	java/lang/InterruptedException
    //   588	594	1170	java/lang/InterruptedException
    //   594	603	1182	java/lang/InterruptedException
    //   603	613	1192	java/lang/InterruptedException
    //   461	465	1200	java/io/IOException
    //   469	473	1200	java/io/IOException
    //   481	486	1200	java/io/IOException
    //   594	603	1207	java/io/IOException
    //   603	613	1217	java/io/IOException
    //   623	629	1225	java/io/IOException
    //   639	646	1225	java/io/IOException
    //   656	680	1225	java/io/IOException
    //   690	697	1225	java/io/IOException
    //   712	736	1225	java/io/IOException
    //   749	754	1225	java/io/IOException
    //   764	769	1225	java/io/IOException
    //   779	782	1225	java/io/IOException
    //   799	805	1225	java/io/IOException
    //   862	865	1225	java/io/IOException
  }
  
  public static String fm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  public static int getCpuCores()
  {
    if (agR == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new azbz());
      if (arrayOfFile == null) {
        return 1;
      }
      agR = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        agR = 1;
      }
    }
    return agR;
  }
  
  public static native String getRealProperties(String paramString);
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] o(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +130 -> 137
    //   10: new 555	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 556	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 559	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 562	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 562	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 562	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 562	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 6
    //   54: iconst_5
    //   55: newarray int
    //   57: astore_0
    //   58: aload_0
    //   59: iconst_0
    //   60: iconst_0
    //   61: iastore
    //   62: aload_0
    //   63: iconst_1
    //   64: aload_2
    //   65: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 98	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 98	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 98	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 98	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 565	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 42
    //   116: iconst_1
    //   117: ldc_w 567
    //   120: aload_2
    //   121: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokevirtual 565	android/media/MediaMetadataRetriever:release	()V
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: aload_3
    //   132: invokevirtual 565	android/media/MediaMetadataRetriever:release	()V
    //   135: aload_0
    //   136: athrow
    //   137: aload_0
    //   138: invokestatic 569	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +79 -> 222
    //   146: aload_0
    //   147: ldc_w 571
    //   150: invokevirtual 89	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +67 -> 222
    //   158: aload_3
    //   159: arraylength
    //   160: ifle +62 -> 222
    //   163: aload_3
    //   164: arraylength
    //   165: newarray int
    //   167: astore_2
    //   168: aload_2
    //   169: astore_0
    //   170: iload_1
    //   171: aload_3
    //   172: arraylength
    //   173: if_icmpge -64 -> 109
    //   176: aload_2
    //   177: iload_1
    //   178: aload_3
    //   179: iload_1
    //   180: aaload
    //   181: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   184: invokevirtual 98	java/lang/Integer:intValue	()I
    //   187: iastore
    //   188: iload_1
    //   189: iconst_1
    //   190: iadd
    //   191: istore_1
    //   192: goto -24 -> 168
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 572	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   200: ldc_w 574
    //   203: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -66 -> 142
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 405	java/lang/Exception:printStackTrace	()V
    //   216: ldc_w 576
    //   219: invokestatic 113	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_2
    //   225: goto -111 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   1	191	1	i	int
    //   29	36	2	str1	String
    //   111	10	2	localException1	Exception
    //   167	10	2	arrayOfInt	int[]
    //   224	1	2	localException2	Exception
    //   17	162	3	localObject	Object
    //   36	39	4	str2	String
    //   44	42	5	str3	String
    //   52	45	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	111	java/lang/Exception
    //   18	58	130	finally
    //   62	105	130	finally
    //   114	124	130	finally
    //   137	142	195	java/lang/UnsatisfiedLinkError
    //   170	188	211	java/lang/Exception
    //   62	105	224	java/lang/Exception
  }
  
  public static class a
  {
    public long alW;
    public long alX;
    public boolean cHR;
    public int dJo;
    public int dJp;
    public int dJq;
    public String rotate;
    public int srcHeight;
    public int srcWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */