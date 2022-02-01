import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.FileObserver;
import android.provider.MediaStore.Images.Media;

public class ubl
  extends ContentObserver
{
  private static final String jdField_a_of_type_JavaLangString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "date_added" };
  private static final String jdField_b_of_type_JavaLangString = anni.a(2131712351);
  private int jdField_a_of_type_Int;
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  private FileObserver jdField_a_of_type_AndroidOsFileObserver;
  private ubn jdField_a_of_type_Ubn;
  private int jdField_b_of_type_Int;
  private String c;
  
  public ubl(Context paramContext, int paramInt1, int paramInt2)
  {
    super(null);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (Build.VERSION.SDK_INT < 23) {
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        paramContext = ubo.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidOsFileObserver = new ubm(this, paramContext, 256, paramContext);
      }
    }
    for (;;)
    {
      b();
      return;
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        paramContext = ubo.c;
        break;
      }
      paramContext = ubo.jdField_a_of_type_JavaLangString;
      break;
      this.jdField_a_of_type_AndroidContentContentResolver = paramContext.getContentResolver();
    }
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - 1000L * paramLong < 1500L;
  }
  
  private boolean a(String paramString)
  {
    paramString = paramString.toLowerCase();
    return (paramString.contains("screenshot")) || (paramString.contains(jdField_b_of_type_JavaLangString));
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.startWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.stopWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void a()
  {
    c();
    this.jdField_a_of_type_AndroidOsFileObserver = null;
    this.jdField_a_of_type_AndroidContentContentResolver = null;
    this.jdField_a_of_type_Ubn = null;
  }
  
  public void a(ubn paramubn)
  {
    this.jdField_a_of_type_Ubn = paramubn;
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
    //   9: invokestatic 158	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12: ifeq +30 -> 42
    //   15: ldc 160
    //   17: iconst_2
    //   18: new 162	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   25: ldc 166
    //   27: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   33: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: ifnonnull +301 -> 344
    //   46: aload_0
    //   47: getfield 96	ubl:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   50: getstatic 21	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: getstatic 37	ubl:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   56: aconst_null
    //   57: aconst_null
    //   58: ldc 180
    //   60: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +205 -> 272
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 190 1 0
    //   80: ifle +192 -> 272
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: invokeinterface 193 1 0
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: aload 4
    //   99: aload 4
    //   101: ldc 33
    //   103: invokeinterface 197 2 0
    //   108: invokeinterface 200 2 0
    //   113: astore 5
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: aload 4
    //   121: aload 4
    //   123: ldc 35
    //   125: invokeinterface 197 2 0
    //   130: invokeinterface 204 2 0
    //   135: invokespecial 206	ubl:a	(J)Z
    //   138: ifeq +134 -> 272
    //   141: aload 4
    //   143: astore_3
    //   144: aload_0
    //   145: aload 5
    //   147: invokespecial 208	ubl:a	(Ljava/lang/String;)Z
    //   150: ifeq +122 -> 272
    //   153: aload 4
    //   155: astore_3
    //   156: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +37 -> 196
    //   162: aload 4
    //   164: astore_3
    //   165: ldc 160
    //   167: iconst_2
    //   168: new 162	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   175: ldc 213
    //   177: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 215
    //   187: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 5
    //   198: ifnull +48 -> 246
    //   201: aload 4
    //   203: astore_3
    //   204: aload 5
    //   206: aload_0
    //   207: getfield 98	ubl:c	Ljava/lang/String;
    //   210: invokevirtual 71	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: istore_1
    //   214: iload_1
    //   215: ifeq +22 -> 237
    //   218: aload 4
    //   220: ifnull +10 -> 230
    //   223: aload 4
    //   225: invokeinterface 218 1 0
    //   230: return
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   236: return
    //   237: aload 4
    //   239: astore_3
    //   240: aload_0
    //   241: aload 5
    //   243: putfield 98	ubl:c	Ljava/lang/String;
    //   246: aload 4
    //   248: astore_3
    //   249: aload_0
    //   250: getfield 102	ubl:jdField_a_of_type_Ubn	Lubn;
    //   253: ifnull +19 -> 272
    //   256: aload 4
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 102	ubl:jdField_a_of_type_Ubn	Lubn;
    //   263: aload_2
    //   264: aload 5
    //   266: iconst_1
    //   267: invokeinterface 226 4 0
    //   272: aload 4
    //   274: ifnull -44 -> 230
    //   277: aload 4
    //   279: invokeinterface 218 1 0
    //   284: return
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   290: return
    //   291: astore_2
    //   292: aconst_null
    //   293: astore 4
    //   295: aload 4
    //   297: astore_3
    //   298: aload_2
    //   299: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   302: aload 4
    //   304: ifnull -74 -> 230
    //   307: aload 4
    //   309: invokeinterface 218 1 0
    //   314: return
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   320: return
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +9 -> 334
    //   328: aload_3
    //   329: invokeinterface 218 1 0
    //   334: aload_2
    //   335: athrow
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   341: goto -7 -> 334
    //   344: aload 5
    //   346: astore 4
    //   348: aload 7
    //   350: astore_3
    //   351: aload_2
    //   352: invokevirtual 27	android/net/Uri:toString	()Ljava/lang/String;
    //   355: getstatic 29	ubl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   358: invokevirtual 229	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   361: ifeq +306 -> 667
    //   364: aload 5
    //   366: astore 4
    //   368: aload 7
    //   370: astore_3
    //   371: aload_0
    //   372: getfield 96	ubl:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   375: aload_2
    //   376: getstatic 37	ubl:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   379: aconst_null
    //   380: aconst_null
    //   381: ldc 180
    //   383: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   410: invokeinterface 190 1 0
    //   415: ifle +252 -> 667
    //   418: aload 5
    //   420: astore 4
    //   422: aload 5
    //   424: astore_3
    //   425: aload 5
    //   427: invokeinterface 193 1 0
    //   432: pop
    //   433: aload 5
    //   435: astore 4
    //   437: aload 5
    //   439: astore_3
    //   440: aload 5
    //   442: aload 5
    //   444: ldc 33
    //   446: invokeinterface 197 2 0
    //   451: invokeinterface 200 2 0
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
    //   474: ldc 35
    //   476: invokeinterface 197 2 0
    //   481: invokeinterface 204 2 0
    //   486: invokespecial 206	ubl:a	(J)Z
    //   489: ifeq +178 -> 667
    //   492: aload 5
    //   494: astore 6
    //   496: aload 5
    //   498: astore 4
    //   500: aload 5
    //   502: astore_3
    //   503: aload_0
    //   504: aload 7
    //   506: invokespecial 208	ubl:a	(Ljava/lang/String;)Z
    //   509: ifeq +158 -> 667
    //   512: aload 5
    //   514: astore 4
    //   516: aload 5
    //   518: astore_3
    //   519: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +45 -> 567
    //   525: aload 5
    //   527: astore 4
    //   529: aload 5
    //   531: astore_3
    //   532: ldc 160
    //   534: iconst_2
    //   535: new 162	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   542: ldc 213
    //   544: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 7
    //   549: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc 231
    //   554: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_2
    //   558: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload 7
    //   569: ifnull +56 -> 625
    //   572: aload 5
    //   574: astore 4
    //   576: aload 5
    //   578: astore_3
    //   579: aload 7
    //   581: aload_0
    //   582: getfield 98	ubl:c	Ljava/lang/String;
    //   585: invokevirtual 71	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   588: istore_1
    //   589: iload_1
    //   590: ifeq +22 -> 612
    //   593: aload 5
    //   595: ifnull -365 -> 230
    //   598: aload 5
    //   600: invokeinterface 218 1 0
    //   605: return
    //   606: astore_2
    //   607: aload_2
    //   608: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   611: return
    //   612: aload 5
    //   614: astore 4
    //   616: aload 5
    //   618: astore_3
    //   619: aload_0
    //   620: aload 7
    //   622: putfield 98	ubl:c	Ljava/lang/String;
    //   625: aload 5
    //   627: astore 6
    //   629: aload 5
    //   631: astore 4
    //   633: aload 5
    //   635: astore_3
    //   636: aload_0
    //   637: getfield 102	ubl:jdField_a_of_type_Ubn	Lubn;
    //   640: ifnull +27 -> 667
    //   643: aload 5
    //   645: astore 4
    //   647: aload 5
    //   649: astore_3
    //   650: aload_0
    //   651: getfield 102	ubl:jdField_a_of_type_Ubn	Lubn;
    //   654: aload_2
    //   655: aload 7
    //   657: iconst_1
    //   658: invokeinterface 226 4 0
    //   663: aload 5
    //   665: astore 6
    //   667: aload 6
    //   669: ifnull -439 -> 230
    //   672: aload 6
    //   674: invokeinterface 218 1 0
    //   679: return
    //   680: astore_2
    //   681: aload_2
    //   682: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   685: return
    //   686: astore_2
    //   687: aload 4
    //   689: astore_3
    //   690: aload_2
    //   691: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   694: aload 4
    //   696: ifnull -466 -> 230
    //   699: aload 4
    //   701: invokeinterface 218 1 0
    //   706: return
    //   707: astore_2
    //   708: aload_2
    //   709: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   712: return
    //   713: astore_2
    //   714: aload_3
    //   715: ifnull +9 -> 724
    //   718: aload_3
    //   719: invokeinterface 218 1 0
    //   724: aload_2
    //   725: athrow
    //   726: astore_3
    //   727: aload_3
    //   728: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   731: goto -7 -> 724
    //   734: astore_2
    //   735: goto -411 -> 324
    //   738: astore_2
    //   739: goto -444 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	this	ubl
    //   0	742	1	paramBoolean	boolean
    //   0	742	2	paramUri	Uri
    //   72	257	3	localObject1	java.lang.Object
    //   336	2	3	localException1	java.lang.Exception
    //   350	369	3	localObject2	java.lang.Object
    //   726	2	3	localException2	java.lang.Exception
    //   63	637	4	localObject3	java.lang.Object
    //   1	663	5	localObject4	java.lang.Object
    //   7	666	6	localObject5	java.lang.Object
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubl
 * JD-Core Version:    0.7.0.1
 */