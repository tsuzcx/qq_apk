import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLState;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.AbsDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import mqq.os.MqqHandler;

public abstract class aoiz
  extends ProtocolDownloader.Adapter
{
  public static final String ckP = acbn.SDCARD_PATH + "chatpic" + File.separator;
  
  private void a(aokj.a parama, File paramFile)
  {
    ThreadManager.getFileThreadHandler().post(new AbsDownloader.1(this, parama));
  }
  
  public static void aZ(String paramString1, String paramString2, String paramString3)
  {
    int i = aqhq.ad(paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ChatImageMigrate", 2, "migrate:" + paramString1 + " from:" + paramString2 + " to:" + paramString3 + " status:" + i);
    }
  }
  
  public static String bG(String paramString1, String paramString2)
  {
    String str = paramString2.substring(paramString2.length() - 3);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(ckP);
    localStringBuffer.append(paramString1);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(str);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(paramString2);
    return aoqr.oz(localStringBuffer.toString());
  }
  
  public static final File getFile(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(getFilePath(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final String getFileName(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("pubaccountimage")) {
        str = paramString.replace("pubaccountimage:", "");
      }
    }
    return "Cache_" + Utils.Crc64String(str);
  }
  
  public static final String getFilePath(String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    if (paramString == null) {}
    for (;;)
    {
      return localObject2;
      String str = getFileName(paramString);
      Object localObject1 = aoop.aW + File.separator + str;
      try
      {
        localObject2 = new URL(paramString);
        if (localObject2 != null) {
          localObject4 = ((URL)localObject2).getProtocol();
        }
        if ("chatthumb".equals(localObject4))
        {
          localObject2 = bG((String)localObject4, str);
          if (new File((String)localObject2 + "_hd").exists())
          {
            localObject2 = (String)localObject2 + "_hd";
            i = 0;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (i == 0) {
              continue;
            }
            aZ(paramString, (String)localObject4, (String)localObject1);
            return localObject1;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          int i;
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
          continue;
          if (new File((String)localObject1 + "_hd").exists())
          {
            localObject4 = (String)localObject1 + "_hd";
            localObject1 = (String)localObject3 + "_hd";
            i = 1;
          }
          else
          {
            if (new File((String)localObject1).exists())
            {
              localObject4 = localObject1;
              i = 1;
              localObject1 = localObject3;
              continue;
              if ("chatimg".equals(localObject4))
              {
                localObject4 = bG((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                aZ(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              if ("chatraw".equals(localObject4))
              {
                localObject4 = bG((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                aZ(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              return localObject1;
            }
            localObject4 = localObject1;
            i = 0;
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public static final boolean hasFile(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.startsWith("regionalthumb")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring("regionalthumb:".length());
      }
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
      try
      {
        if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring("file:".length());
        }
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = on(paramString);
          if (paramString != null) {
            return getFile(paramString) != null;
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static final File k(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(getFilePath(paramString) + "_fp");
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static String on(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d("AbsDownloader", 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static String oo(String paramString)
  {
    return getFilePath(paramString) + "_dp";
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception;
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean azK()
  {
    return false;
  }
  
  public boolean azL()
  {
    return false;
  }
  
  protected int c(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return URLState.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!azK()) {
      return false;
    }
    return hasFile(paramDownloadParams.urlStr);
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 8
    //   8: aload_0
    //   9: invokevirtual 251	aoiz:azK	()Z
    //   12: ifeq +441 -> 453
    //   15: aload_1
    //   16: getfield 256	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   19: astore 7
    //   21: aload 7
    //   23: invokestatic 221	aoiz:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +55 -> 85
    //   33: ldc 228
    //   35: ldc_w 263
    //   38: new 10	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 265
    //   48: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 6
    //   53: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 273	akxe:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +14 -> 80
    //   69: aload_2
    //   70: aload 6
    //   72: invokevirtual 276	java/io/File:length	()J
    //   75: invokeinterface 282 3 0
    //   80: aload 6
    //   82: astore_1
    //   83: aload_1
    //   84: areturn
    //   85: aload_1
    //   86: getfield 286	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   89: ifnull +14 -> 103
    //   92: aload_0
    //   93: aconst_null
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 288	aoiz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   99: pop
    //   100: aload 6
    //   102: areturn
    //   103: aload 7
    //   105: invokestatic 149	aoiz:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 10
    //   110: getstatic 294	com/tencent/mobileqq/startup/step/InitUrlDrawable:b	Laokj;
    //   113: aload 10
    //   115: invokevirtual 299	aokj:a	(Ljava/lang/String;)Laokj$a;
    //   118: astore 11
    //   120: aload_0
    //   121: invokevirtual 301	aoiz:azL	()Z
    //   124: istore 4
    //   126: iload 4
    //   128: ifeq +398 -> 526
    //   131: aload_1
    //   132: aload 11
    //   134: getfield 306	aokj$a:aS	Ljava/io/File;
    //   137: invokevirtual 276	java/io/File:length	()J
    //   140: putfield 310	com/tencent/image/DownloadParams:downloaded	J
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 312	aoiz:a	(Lcom/tencent/image/DownloadParams;)Z
    //   148: istore 5
    //   150: iload 5
    //   152: ifne +5 -> 157
    //   155: iconst_1
    //   156: istore_3
    //   157: iload 4
    //   159: iload_3
    //   160: iand
    //   161: istore 4
    //   163: new 314	java/io/FileOutputStream
    //   166: dup
    //   167: aload 11
    //   169: getfield 306	aokj$a:aS	Ljava/io/File;
    //   172: iload 4
    //   174: invokespecial 317	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   177: astore 6
    //   179: aload_0
    //   180: aload 6
    //   182: aload_1
    //   183: aload_2
    //   184: invokevirtual 288	aoiz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   187: astore_2
    //   188: aload 7
    //   190: ldc_w 319
    //   193: invokevirtual 322	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   196: ifeq +324 -> 520
    //   199: aload 7
    //   201: iconst_0
    //   202: aload 7
    //   204: ldc_w 319
    //   207: invokevirtual 326	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   210: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   213: astore_1
    //   214: aload_1
    //   215: invokestatic 221	aoiz:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   218: astore 7
    //   220: aload 7
    //   222: ifnull +74 -> 296
    //   225: ldc 228
    //   227: ldc_w 263
    //   230: new 10	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 328
    //   240: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 7
    //   245: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   248: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 273	akxe:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 11
    //   259: getfield 306	aokj$a:aS	Ljava/io/File;
    //   262: invokevirtual 331	java/io/File:delete	()Z
    //   265: pop
    //   266: aload 7
    //   268: astore_1
    //   269: aload 6
    //   271: ifnull -188 -> 83
    //   274: aload 7
    //   276: astore_1
    //   277: aload_2
    //   278: instanceof 333
    //   281: ifne -198 -> 83
    //   284: aload 6
    //   286: invokevirtual 338	java/io/OutputStream:close	()V
    //   289: aload 7
    //   291: areturn
    //   292: astore_1
    //   293: aload 7
    //   295: areturn
    //   296: aload_0
    //   297: aload_2
    //   298: invokevirtual 342	aoiz:r	(Ljava/io/File;)Z
    //   301: ifeq +29 -> 330
    //   304: aload_0
    //   305: aload 11
    //   307: aload_2
    //   308: invokespecial 344	aoiz:a	(Laokj$a;Ljava/io/File;)V
    //   311: aload 6
    //   313: ifnull +15 -> 328
    //   316: aload_2
    //   317: instanceof 333
    //   320: ifne +8 -> 328
    //   323: aload 6
    //   325: invokevirtual 338	java/io/OutputStream:close	()V
    //   328: aload_2
    //   329: areturn
    //   330: aload 11
    //   332: invokevirtual 348	aokj$a:I	()Ljava/io/File;
    //   335: astore 7
    //   337: aload 7
    //   339: astore_1
    //   340: aload 6
    //   342: ifnull -259 -> 83
    //   345: aload 7
    //   347: astore_1
    //   348: aload_2
    //   349: instanceof 333
    //   352: ifne -269 -> 83
    //   355: aload 6
    //   357: invokevirtual 338	java/io/OutputStream:close	()V
    //   360: aload 7
    //   362: areturn
    //   363: astore_1
    //   364: aload 7
    //   366: areturn
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: aload 8
    //   372: astore 6
    //   374: aload 11
    //   376: ifnull +10 -> 386
    //   379: aload 11
    //   381: iload 4
    //   383: invokevirtual 352	aokj$a:abort	(Z)V
    //   386: ldc_w 354
    //   389: ldc_w 263
    //   392: new 10	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 356
    //   402: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 10
    //   407: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc_w 358
    //   413: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 7
    //   418: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 360	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_1
    //   428: invokevirtual 361	java/lang/Exception:printStackTrace	()V
    //   431: aload_1
    //   432: athrow
    //   433: astore_1
    //   434: aload 6
    //   436: ifnull +15 -> 451
    //   439: aload_2
    //   440: instanceof 333
    //   443: ifne +8 -> 451
    //   446: aload 6
    //   448: invokevirtual 338	java/io/OutputStream:close	()V
    //   451: aload_1
    //   452: athrow
    //   453: aload_0
    //   454: aconst_null
    //   455: aload_1
    //   456: aload_2
    //   457: invokevirtual 288	aoiz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   460: areturn
    //   461: astore_2
    //   462: goto -11 -> 451
    //   465: astore_1
    //   466: aconst_null
    //   467: astore_2
    //   468: aload 9
    //   470: astore 6
    //   472: goto -38 -> 434
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -44 -> 434
    //   481: astore_1
    //   482: goto -48 -> 434
    //   485: astore_1
    //   486: aconst_null
    //   487: astore_2
    //   488: aload 8
    //   490: astore 6
    //   492: goto -118 -> 374
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_2
    //   498: goto -124 -> 374
    //   501: astore_1
    //   502: goto -128 -> 374
    //   505: astore 8
    //   507: aload_1
    //   508: astore 7
    //   510: aload 8
    //   512: astore_1
    //   513: goto -139 -> 374
    //   516: astore_1
    //   517: goto -189 -> 328
    //   520: aload 7
    //   522: astore_1
    //   523: goto -309 -> 214
    //   526: goto -363 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	aoiz
    //   0	529	1	paramDownloadParams	DownloadParams
    //   0	529	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	160	3	bool1	boolean
    //   124	258	4	bool2	boolean
    //   148	3	5	bool3	boolean
    //   26	465	6	localObject1	Object
    //   19	502	7	localObject2	Object
    //   6	483	8	localObject3	Object
    //   505	6	8	localException	Exception
    //   3	466	9	localObject4	Object
    //   108	298	10	str	String
    //   118	262	11	locala	aokj.a
    // Exception table:
    //   from	to	target	type
    //   277	289	292	java/io/IOException
    //   348	360	363	java/io/IOException
    //   131	150	367	java/lang/Exception
    //   379	386	433	finally
    //   386	433	433	finally
    //   439	451	461	java/io/IOException
    //   131	150	465	finally
    //   163	179	465	finally
    //   179	188	475	finally
    //   188	214	481	finally
    //   214	220	481	finally
    //   225	266	481	finally
    //   296	311	481	finally
    //   330	337	481	finally
    //   163	179	485	java/lang/Exception
    //   179	188	495	java/lang/Exception
    //   188	214	501	java/lang/Exception
    //   214	220	505	java/lang/Exception
    //   225	266	505	java/lang/Exception
    //   296	311	505	java/lang/Exception
    //   330	337	505	java/lang/Exception
    //   316	328	516	java/io/IOException
  }
  
  protected boolean r(File paramFile)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoiz
 * JD-Core Version:    0.7.0.1
 */