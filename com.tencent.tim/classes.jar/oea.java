import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.provider.MediaStore.Images.Media;
import java.io.File;

public class oea
  extends ContentObserver
{
  private static final String[] PROJECTION = { "_data", "date_added" };
  private static final String apU = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private FileObserver jdField_a_of_type_AndroidOsFileObserver;
  private oea.a jdField_a_of_type_Oea$a;
  private String apV;
  private ContentResolver mContentResolver;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public oea(Context paramContext, int paramInt1, int paramInt2)
  {
    super(null);
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
    if (Build.VERSION.SDK_INT < 23) {
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        paramContext = oea.b.XIAOMI;
        this.jdField_a_of_type_AndroidOsFileObserver = new oeb(this, paramContext, 256, paramContext);
      }
    }
    for (;;)
    {
      bdL();
      return;
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        paramContext = oea.b.VIVO;
        break;
      }
      paramContext = oea.b.NORMAL;
      break;
      this.mContentResolver = paramContext.getContentResolver();
    }
  }
  
  private boolean aU(long paramLong)
  {
    return System.currentTimeMillis() - 1000L * paramLong < 1500L;
  }
  
  private void bdL()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.startWatching();
      return;
    }
    this.mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  private void bdM()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.stopWatching();
      return;
    }
    this.mContentResolver.unregisterContentObserver(this);
  }
  
  private boolean eE(String paramString)
  {
    paramString = paramString.toLowerCase();
    return (paramString.contains("screenshot")) || (paramString.contains(""));
  }
  
  public void a(oea.a parama)
  {
    this.jdField_a_of_type_Oea$a = parama;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  /* Error */
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 167	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12: ifeq +30 -> 42
    //   15: ldc 169
    //   17: iconst_2
    //   18: new 171	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   25: ldc 175
    //   27: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   33: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: ifnonnull +301 -> 344
    //   46: aload_0
    //   47: getfield 101	oea:mContentResolver	Landroid/content/ContentResolver;
    //   50: getstatic 30	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: getstatic 46	oea:PROJECTION	[Ljava/lang/String;
    //   56: aconst_null
    //   57: aconst_null
    //   58: ldc 189
    //   60: invokestatic 195	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +205 -> 272
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 201 1 0
    //   80: ifle +192 -> 272
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: invokeinterface 204 1 0
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: aload 4
    //   99: aload 4
    //   101: ldc 42
    //   103: invokeinterface 208 2 0
    //   108: invokeinterface 212 2 0
    //   113: astore 5
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: aload 4
    //   121: aload 4
    //   123: ldc 44
    //   125: invokeinterface 208 2 0
    //   130: invokeinterface 216 2 0
    //   135: invokespecial 218	oea:aU	(J)Z
    //   138: ifeq +134 -> 272
    //   141: aload 4
    //   143: astore_3
    //   144: aload_0
    //   145: aload 5
    //   147: invokespecial 220	oea:eE	(Ljava/lang/String;)Z
    //   150: ifeq +122 -> 272
    //   153: aload 4
    //   155: astore_3
    //   156: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +37 -> 196
    //   162: aload 4
    //   164: astore_3
    //   165: ldc 169
    //   167: iconst_2
    //   168: new 171	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   175: ldc 225
    //   177: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 227
    //   187: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 5
    //   198: ifnull +48 -> 246
    //   201: aload 4
    //   203: astore_3
    //   204: aload 5
    //   206: aload_0
    //   207: getfield 104	oea:apV	Ljava/lang/String;
    //   210: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: istore_1
    //   214: iload_1
    //   215: ifeq +22 -> 237
    //   218: aload 4
    //   220: ifnull +10 -> 230
    //   223: aload 4
    //   225: invokeinterface 230 1 0
    //   230: return
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   236: return
    //   237: aload 4
    //   239: astore_3
    //   240: aload_0
    //   241: aload 5
    //   243: putfield 104	oea:apV	Ljava/lang/String;
    //   246: aload 4
    //   248: astore_3
    //   249: aload_0
    //   250: getfield 108	oea:jdField_a_of_type_Oea$a	Loea$a;
    //   253: ifnull +19 -> 272
    //   256: aload 4
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 108	oea:jdField_a_of_type_Oea$a	Loea$a;
    //   263: aload_2
    //   264: aload 5
    //   266: iconst_1
    //   267: invokeinterface 236 4 0
    //   272: aload 4
    //   274: ifnull -44 -> 230
    //   277: aload 4
    //   279: invokeinterface 230 1 0
    //   284: return
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   290: return
    //   291: astore_2
    //   292: aconst_null
    //   293: astore 4
    //   295: aload 4
    //   297: astore_3
    //   298: aload_2
    //   299: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   302: aload 4
    //   304: ifnull -74 -> 230
    //   307: aload 4
    //   309: invokeinterface 230 1 0
    //   314: return
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   320: return
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +9 -> 334
    //   328: aload_3
    //   329: invokeinterface 230 1 0
    //   334: aload_2
    //   335: athrow
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   341: goto -7 -> 334
    //   344: aload 5
    //   346: astore 4
    //   348: aload 7
    //   350: astore_3
    //   351: aload_2
    //   352: invokevirtual 36	android/net/Uri:toString	()Ljava/lang/String;
    //   355: getstatic 38	oea:apU	Ljava/lang/String;
    //   358: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   361: ifeq +306 -> 667
    //   364: aload 5
    //   366: astore 4
    //   368: aload 7
    //   370: astore_3
    //   371: aload_0
    //   372: getfield 101	oea:mContentResolver	Landroid/content/ContentResolver;
    //   375: aload_2
    //   376: getstatic 46	oea:PROJECTION	[Ljava/lang/String;
    //   379: aconst_null
    //   380: aconst_null
    //   381: ldc 189
    //   383: invokestatic 195	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   386: astore 5
    //   388: aload 5
    //   390: astore 6
    //   392: aload 5
    //   394: ifnull +273 -> 667
    //   397: aload 5
    //   399: astore 6
    //   401: aload 5
    //   403: astore 4
    //   405: aload 5
    //   407: astore_3
    //   408: aload 5
    //   410: invokeinterface 201 1 0
    //   415: ifle +252 -> 667
    //   418: aload 5
    //   420: astore 4
    //   422: aload 5
    //   424: astore_3
    //   425: aload 5
    //   427: invokeinterface 204 1 0
    //   432: pop
    //   433: aload 5
    //   435: astore 4
    //   437: aload 5
    //   439: astore_3
    //   440: aload 5
    //   442: aload 5
    //   444: ldc 42
    //   446: invokeinterface 208 2 0
    //   451: invokeinterface 212 2 0
    //   456: astore 7
    //   458: aload 5
    //   460: astore 6
    //   462: aload 5
    //   464: astore 4
    //   466: aload 5
    //   468: astore_3
    //   469: aload_0
    //   470: aload 5
    //   472: aload 5
    //   474: ldc 44
    //   476: invokeinterface 208 2 0
    //   481: invokeinterface 216 2 0
    //   486: invokespecial 218	oea:aU	(J)Z
    //   489: ifeq +178 -> 667
    //   492: aload 5
    //   494: astore 6
    //   496: aload 5
    //   498: astore 4
    //   500: aload 5
    //   502: astore_3
    //   503: aload_0
    //   504: aload 7
    //   506: invokespecial 220	oea:eE	(Ljava/lang/String;)Z
    //   509: ifeq +158 -> 667
    //   512: aload 5
    //   514: astore 4
    //   516: aload 5
    //   518: astore_3
    //   519: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +45 -> 567
    //   525: aload 5
    //   527: astore 4
    //   529: aload 5
    //   531: astore_3
    //   532: ldc 169
    //   534: iconst_2
    //   535: new 171	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   542: ldc 225
    //   544: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 7
    //   549: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc 241
    //   554: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_2
    //   558: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload 7
    //   569: ifnull +56 -> 625
    //   572: aload 5
    //   574: astore 4
    //   576: aload 5
    //   578: astore_3
    //   579: aload 7
    //   581: aload_0
    //   582: getfield 104	oea:apV	Ljava/lang/String;
    //   585: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   588: istore_1
    //   589: iload_1
    //   590: ifeq +22 -> 612
    //   593: aload 5
    //   595: ifnull -365 -> 230
    //   598: aload 5
    //   600: invokeinterface 230 1 0
    //   605: return
    //   606: astore_2
    //   607: aload_2
    //   608: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   611: return
    //   612: aload 5
    //   614: astore 4
    //   616: aload 5
    //   618: astore_3
    //   619: aload_0
    //   620: aload 7
    //   622: putfield 104	oea:apV	Ljava/lang/String;
    //   625: aload 5
    //   627: astore 6
    //   629: aload 5
    //   631: astore 4
    //   633: aload 5
    //   635: astore_3
    //   636: aload_0
    //   637: getfield 108	oea:jdField_a_of_type_Oea$a	Loea$a;
    //   640: ifnull +27 -> 667
    //   643: aload 5
    //   645: astore 4
    //   647: aload 5
    //   649: astore_3
    //   650: aload_0
    //   651: getfield 108	oea:jdField_a_of_type_Oea$a	Loea$a;
    //   654: aload_2
    //   655: aload 7
    //   657: iconst_1
    //   658: invokeinterface 236 4 0
    //   663: aload 5
    //   665: astore 6
    //   667: aload 6
    //   669: ifnull -439 -> 230
    //   672: aload 6
    //   674: invokeinterface 230 1 0
    //   679: return
    //   680: astore_2
    //   681: aload_2
    //   682: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   685: return
    //   686: astore_2
    //   687: aload 4
    //   689: astore_3
    //   690: aload_2
    //   691: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   694: aload 4
    //   696: ifnull -466 -> 230
    //   699: aload 4
    //   701: invokeinterface 230 1 0
    //   706: return
    //   707: astore_2
    //   708: aload_2
    //   709: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   712: return
    //   713: astore_2
    //   714: aload_3
    //   715: ifnull +9 -> 724
    //   718: aload_3
    //   719: invokeinterface 230 1 0
    //   724: aload_2
    //   725: athrow
    //   726: astore_3
    //   727: aload_3
    //   728: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   731: goto -7 -> 724
    //   734: astore_2
    //   735: goto -411 -> 324
    //   738: astore_2
    //   739: goto -444 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	this	oea
    //   0	742	1	paramBoolean	boolean
    //   0	742	2	paramUri	Uri
    //   72	257	3	localObject1	Object
    //   336	2	3	localException1	java.lang.Exception
    //   350	369	3	localObject2	Object
    //   726	2	3	localException2	java.lang.Exception
    //   63	637	4	localObject3	Object
    //   1	663	5	localObject4	Object
    //   7	666	6	localObject5	Object
    //   4	652	7	str	String
    // Exception table:
    //   from	to	target	type
    //   223	230	231	java/lang/Exception
    //   277	284	285	java/lang/Exception
    //   46	65	291	java/lang/Exception
    //   307	314	315	java/lang/Exception
    //   46	65	321	finally
    //   328	334	336	java/lang/Exception
    //   598	605	606	java/lang/Exception
    //   672	679	680	java/lang/Exception
    //   351	364	686	java/lang/Exception
    //   371	388	686	java/lang/Exception
    //   408	418	686	java/lang/Exception
    //   425	433	686	java/lang/Exception
    //   440	458	686	java/lang/Exception
    //   469	492	686	java/lang/Exception
    //   503	512	686	java/lang/Exception
    //   519	525	686	java/lang/Exception
    //   532	567	686	java/lang/Exception
    //   579	589	686	java/lang/Exception
    //   619	625	686	java/lang/Exception
    //   636	643	686	java/lang/Exception
    //   650	663	686	java/lang/Exception
    //   699	706	707	java/lang/Exception
    //   351	364	713	finally
    //   371	388	713	finally
    //   408	418	713	finally
    //   425	433	713	finally
    //   440	458	713	finally
    //   469	492	713	finally
    //   503	512	713	finally
    //   519	525	713	finally
    //   532	567	713	finally
    //   579	589	713	finally
    //   619	625	713	finally
    //   636	643	713	finally
    //   650	663	713	finally
    //   690	694	713	finally
    //   718	724	726	java/lang/Exception
    //   73	83	734	finally
    //   86	94	734	finally
    //   97	115	734	finally
    //   118	141	734	finally
    //   144	153	734	finally
    //   156	162	734	finally
    //   165	196	734	finally
    //   204	214	734	finally
    //   240	246	734	finally
    //   249	256	734	finally
    //   259	272	734	finally
    //   298	302	734	finally
    //   73	83	738	java/lang/Exception
    //   86	94	738	java/lang/Exception
    //   97	115	738	java/lang/Exception
    //   118	141	738	java/lang/Exception
    //   144	153	738	java/lang/Exception
    //   156	162	738	java/lang/Exception
    //   165	196	738	java/lang/Exception
    //   204	214	738	java/lang/Exception
    //   240	246	738	java/lang/Exception
    //   249	256	738	java/lang/Exception
    //   259	272	738	java/lang/Exception
  }
  
  public void onDestroy()
  {
    bdM();
    this.jdField_a_of_type_AndroidOsFileObserver = null;
    this.mContentResolver = null;
    this.jdField_a_of_type_Oea$a = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(Uri paramUri, String paramString, int paramInt);
  }
  
  public static final class b
  {
    public static final String NORMAL = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator;
    public static final String VIVO = Environment.getExternalStorageDirectory() + File.separator + "" + File.separator;
    public static final String XIAOMI = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oea
 * JD-Core Version:    0.7.0.1
 */