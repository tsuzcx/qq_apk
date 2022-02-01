package com.immersion.stickersampleapp;

import afel;
import afem;
import affc;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import anpc;
import aszr;
import com.immersion.touchsensesdk.HapticMediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mb;
import mqq.os.MqqHandler;
import xks;

public class HapticManager
{
  private static HapticManager jdField_a_of_type_ComImmersionStickersampleappHapticManager = new HapticManager(BaseApplicationImpl.sApplication);
  private static final String eP = xks.pt() + "poke/immersion_source/libTouchSenseSDK.so";
  private HashMap<Integer, String> E;
  private final List<a> X = new ArrayList();
  private ClockTask jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask = new ClockTask();
  private DisposeTask jdField_a_of_type_ComImmersionStickersampleappHapticManager$DisposeTask = new DisposeTask();
  private InitHMPRunnable jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable;
  private HapticMediaPlayer jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
  private mb jdField_a_of_type_Mb;
  private boolean cK;
  private boolean cL;
  boolean isInit = false;
  private Context mContext;
  
  private HapticManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Mb = new mb();
    this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable = new InitHMPRunnable();
  }
  
  private boolean B(int paramInt)
  {
    if (!aK()) {}
    while (paramInt < 0) {
      return false;
    }
    return true;
  }
  
  private void W(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 4, "HapticManager doRequest so zip");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = (afem)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(77);
      if (localObject != null)
      {
        localObject = (affc)((afem)localObject).a("qq.android.poke.res_0625");
        if (localObject != null)
        {
          if (paramBoolean)
          {
            XmlData localXmlData = ((affc)localObject).b();
            localXmlData.loadState = 0;
            afel.a(localXmlData, new String[0]);
          }
          ((affc)localObject).HL(false);
        }
      }
    }
  }
  
  private a a(String paramString)
  {
    synchronized (this.X)
    {
      Iterator localIterator = this.X.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (a.a(locala).equals(paramString)) {
          return locala;
        }
      }
      return null;
    }
  }
  
  public static HapticManager a()
  {
    try
    {
      HapticManager localHapticManager = jdField_a_of_type_ComImmersionStickersampleappHapticManager;
      return localHapticManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean aL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HapticManager", 2, "HapticMediaPlayer start check so");
    }
    this.cK = false;
    Object localObject1 = new File(eP);
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HapticManager", 2, "getFilesDir is null");
      }
      return false;
    }
    localObject2 = ((File)localObject2).getParent() + "/immer";
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    localObject2 = new File((String)localObject2 + File.separator + "libTouchSenseSDK.so");
    if ((((File)localObject2).exists()) || ((((File)localObject1).exists()) && (c((File)localObject1, (File)localObject2)))) {}
    try
    {
      localObject1 = com.tencent.qphone.base.util.BaseApplication.getContext().getSharedPreferences("early_qq.android.poke.res_0625", 0);
      localObject3 = ((SharedPreferences)localObject1).getString("SoMD5", "");
      l = ((SharedPreferences)localObject1).getLong("SoLength", 0L);
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "somd5 : " + (String)localObject3 + "\nsolength :" + l);
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (l == 0L))
      {
        W(false);
        return false;
      }
    }
    catch (IOException localIOException)
    {
      long l;
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
      }
      this.cK = false;
      localIOException.printStackTrace();
      W(true);
      return false;
      if ((!((String)localObject3).equals(aszr.getFileMD5String((File)localObject2))) || (((File)localObject2).length() != l))
      {
        W(true);
        ((File)localObject2).delete();
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
        }
        localUnsatisfiedLinkError.printStackTrace();
        this.cK = false;
      }
      System.load(((File)localObject2).getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load success");
      }
      this.cK = true;
    }
    return true;
  }
  
  /* Error */
  private String b(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore_3
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore 12
    //   30: aload_0
    //   31: getfield 90	com/immersion/stickersampleapp/HapticManager:mContext	Landroid/content/Context;
    //   34: invokevirtual 325	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   37: iload_1
    //   38: invokevirtual 331	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   41: astore 11
    //   43: aload 11
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload 10
    //   53: astore_3
    //   54: aload_0
    //   55: getfield 90	com/immersion/stickersampleapp/HapticManager:mContext	Landroid/content/Context;
    //   58: new 40	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   65: aload_2
    //   66: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 333
    //   72: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: iconst_0
    //   79: invokevirtual 337	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   82: astore 6
    //   84: aload 5
    //   86: astore 4
    //   88: aload 6
    //   90: astore_3
    //   91: aload 6
    //   93: astore 7
    //   95: aload 6
    //   97: astore 8
    //   99: aload 6
    //   101: astore 9
    //   103: aload 5
    //   105: invokevirtual 343	java/io/InputStream:available	()I
    //   108: istore_1
    //   109: iload_1
    //   110: ifle +65 -> 175
    //   113: aload 5
    //   115: astore 4
    //   117: aload 6
    //   119: astore_3
    //   120: aload 6
    //   122: astore 7
    //   124: aload 6
    //   126: astore 8
    //   128: aload 6
    //   130: astore 9
    //   132: aload 6
    //   134: aload 12
    //   136: iconst_0
    //   137: aload 5
    //   139: aload 12
    //   141: invokevirtual 347	java/io/InputStream:read	([B)I
    //   144: invokevirtual 353	java/io/FileOutputStream:write	([BII)V
    //   147: aload 5
    //   149: astore 4
    //   151: aload 6
    //   153: astore_3
    //   154: aload 6
    //   156: astore 7
    //   158: aload 6
    //   160: astore 8
    //   162: aload 6
    //   164: astore 9
    //   166: aload 5
    //   168: invokevirtual 343	java/io/InputStream:available	()I
    //   171: istore_1
    //   172: goto -63 -> 109
    //   175: aload 5
    //   177: astore 4
    //   179: aload 6
    //   181: astore_3
    //   182: aload 6
    //   184: astore 7
    //   186: aload 6
    //   188: astore 8
    //   190: aload 6
    //   192: astore 9
    //   194: aload 6
    //   196: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   199: aload 5
    //   201: astore 4
    //   203: aload 6
    //   205: astore_3
    //   206: aload 6
    //   208: astore 7
    //   210: aload 6
    //   212: astore 8
    //   214: aload 6
    //   216: astore 9
    //   218: aload 5
    //   220: invokevirtual 357	java/io/InputStream:close	()V
    //   223: aload 6
    //   225: ifnull +8 -> 233
    //   228: aload 6
    //   230: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 357	java/io/InputStream:close	()V
    //   243: aload_0
    //   244: getfield 90	com/immersion/stickersampleapp/HapticManager:mContext	Landroid/content/Context;
    //   247: invokevirtual 219	android/content/Context:getFilesDir	()Ljava/io/File;
    //   250: astore_3
    //   251: new 40	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   258: aload_3
    //   259: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   262: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: getstatic 235	java/io/File:separator	Ljava/lang/String;
    //   268: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_2
    //   272: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 333
    //   278: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: areturn
    //   285: astore_3
    //   286: aload_3
    //   287: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   290: goto -57 -> 233
    //   293: astore_3
    //   294: aload_3
    //   295: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   298: goto -55 -> 243
    //   301: astore 6
    //   303: aconst_null
    //   304: astore 5
    //   306: aload_3
    //   307: astore 9
    //   309: aload 5
    //   311: astore 4
    //   313: aload 9
    //   315: astore_3
    //   316: ldc 113
    //   318: iconst_2
    //   319: aload 6
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   328: aload 9
    //   330: ifnull +8 -> 338
    //   333: aload 9
    //   335: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   338: aload 5
    //   340: ifnull -97 -> 243
    //   343: aload 5
    //   345: invokevirtual 357	java/io/InputStream:close	()V
    //   348: goto -105 -> 243
    //   351: astore_3
    //   352: aload_3
    //   353: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   356: goto -113 -> 243
    //   359: astore_3
    //   360: aload_3
    //   361: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   364: goto -26 -> 338
    //   367: astore 6
    //   369: aconst_null
    //   370: astore 5
    //   372: aload 4
    //   374: astore 8
    //   376: aload 5
    //   378: astore 4
    //   380: aload 8
    //   382: astore_3
    //   383: ldc 113
    //   385: iconst_2
    //   386: aload 6
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   395: aload 8
    //   397: ifnull +8 -> 405
    //   400: aload 8
    //   402: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   405: aload 5
    //   407: ifnull -164 -> 243
    //   410: aload 5
    //   412: invokevirtual 357	java/io/InputStream:close	()V
    //   415: goto -172 -> 243
    //   418: astore_3
    //   419: aload_3
    //   420: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   423: goto -180 -> 243
    //   426: astore_3
    //   427: aload_3
    //   428: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   431: goto -26 -> 405
    //   434: astore 6
    //   436: aconst_null
    //   437: astore_3
    //   438: aload 5
    //   440: astore 7
    //   442: aload_3
    //   443: astore 5
    //   445: aload 5
    //   447: astore 4
    //   449: aload 7
    //   451: astore_3
    //   452: ldc 113
    //   454: iconst_2
    //   455: aload 6
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   464: aload 7
    //   466: ifnull +8 -> 474
    //   469: aload 7
    //   471: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   474: aload 5
    //   476: ifnull -233 -> 243
    //   479: aload 5
    //   481: invokevirtual 357	java/io/InputStream:close	()V
    //   484: goto -241 -> 243
    //   487: astore_3
    //   488: aload_3
    //   489: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   492: goto -249 -> 243
    //   495: astore_3
    //   496: aload_3
    //   497: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   500: goto -26 -> 474
    //   503: astore_2
    //   504: aconst_null
    //   505: astore 4
    //   507: aload 6
    //   509: astore_3
    //   510: aload_3
    //   511: ifnull +7 -> 518
    //   514: aload_3
    //   515: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   518: aload 4
    //   520: ifnull +8 -> 528
    //   523: aload 4
    //   525: invokevirtual 357	java/io/InputStream:close	()V
    //   528: aload_2
    //   529: athrow
    //   530: astore_3
    //   531: aload_3
    //   532: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   535: goto -17 -> 518
    //   538: astore_3
    //   539: aload_3
    //   540: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   543: goto -15 -> 528
    //   546: astore_2
    //   547: goto -37 -> 510
    //   550: astore 6
    //   552: goto -107 -> 445
    //   555: astore 6
    //   557: goto -181 -> 376
    //   560: astore 6
    //   562: goto -253 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	HapticManager
    //   0	565	1	paramInt	int
    //   0	565	2	paramString	String
    //   22	237	3	localObject1	Object
    //   285	2	3	localIOException1	IOException
    //   293	14	3	localIOException2	IOException
    //   315	1	3	localObject2	Object
    //   351	2	3	localIOException3	IOException
    //   359	2	3	localIOException4	IOException
    //   382	1	3	localObject3	Object
    //   418	2	3	localIOException5	IOException
    //   426	2	3	localIOException6	IOException
    //   437	15	3	localObject4	Object
    //   487	2	3	localIOException7	IOException
    //   495	2	3	localIOException8	IOException
    //   509	6	3	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   530	2	3	localIOException9	IOException
    //   538	2	3	localIOException10	IOException
    //   1	523	4	localObject5	Object
    //   4	476	5	localObject6	Object
    //   7	222	6	localFileOutputStream	java.io.FileOutputStream
    //   301	19	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   367	20	6	localIOException11	IOException
    //   434	74	6	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   550	1	6	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
    //   555	1	6	localIOException12	IOException
    //   560	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   13	457	7	localObject7	Object
    //   16	385	8	localObject8	Object
    //   19	315	9	localObject9	Object
    //   10	42	10	localObject10	Object
    //   41	3	11	localInputStream	java.io.InputStream
    //   28	112	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   228	233	285	java/io/IOException
    //   238	243	293	java/io/IOException
    //   30	43	301	java/io/FileNotFoundException
    //   343	348	351	java/io/IOException
    //   333	338	359	java/io/IOException
    //   30	43	367	java/io/IOException
    //   410	415	418	java/io/IOException
    //   400	405	426	java/io/IOException
    //   30	43	434	java/lang/ArrayIndexOutOfBoundsException
    //   479	484	487	java/io/IOException
    //   469	474	495	java/io/IOException
    //   30	43	503	finally
    //   514	518	530	java/io/IOException
    //   523	528	538	java/io/IOException
    //   54	84	546	finally
    //   103	109	546	finally
    //   132	147	546	finally
    //   166	172	546	finally
    //   194	199	546	finally
    //   218	223	546	finally
    //   316	328	546	finally
    //   383	395	546	finally
    //   452	464	546	finally
    //   54	84	550	java/lang/ArrayIndexOutOfBoundsException
    //   103	109	550	java/lang/ArrayIndexOutOfBoundsException
    //   132	147	550	java/lang/ArrayIndexOutOfBoundsException
    //   166	172	550	java/lang/ArrayIndexOutOfBoundsException
    //   194	199	550	java/lang/ArrayIndexOutOfBoundsException
    //   218	223	550	java/lang/ArrayIndexOutOfBoundsException
    //   54	84	555	java/io/IOException
    //   103	109	555	java/io/IOException
    //   132	147	555	java/io/IOException
    //   166	172	555	java/io/IOException
    //   194	199	555	java/io/IOException
    //   218	223	555	java/io/IOException
    //   54	84	560	java/io/FileNotFoundException
    //   103	109	560	java/io/FileNotFoundException
    //   132	147	560	java/io/FileNotFoundException
    //   166	172	560	java/io/FileNotFoundException
    //   194	199	560	java/io/FileNotFoundException
    //   218	223	560	java/io/FileNotFoundException
  }
  
  /* Error */
  private void eZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 366	com/immersion/stickersampleapp/HapticManager:fd	()V
    //   6: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: ldc 113
    //   14: iconst_2
    //   15: ldc_w 368
    //   18: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 90	com/immersion/stickersampleapp/HapticManager:mContext	Landroid/content/Context;
    //   26: ldc_w 370
    //   29: ldc_w 372
    //   32: ldc_w 374
    //   35: aload_0
    //   36: getfield 95	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_Mb	Lmb;
    //   39: invokestatic 380	com/immersion/touchsensesdk/HapticMediaPlayer:create	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/immersion/touchsensesdk/AsyncConnectionProxy;)Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   42: putfield 382	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   45: aload_0
    //   46: getfield 382	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   49: ifnull +84 -> 133
    //   52: aload_0
    //   53: getfield 382	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   56: bipush 40
    //   58: invokevirtual 386	com/immersion/touchsensesdk/HapticMediaPlayer:getPlayerInfo	(I)I
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +70 -> 133
    //   66: new 363	java/lang/Exception
    //   69: dup
    //   70: new 40	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 388
    //   80: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 390	com/immersion/stickersampleapp/HapticManager:E	Ljava/util/HashMap;
    //   87: iload_1
    //   88: invokestatic 396	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokevirtual 402	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 157	java/lang/String
    //   97: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 403	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore_2
    //   108: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +22 -> 133
    //   114: ldc 113
    //   116: iconst_2
    //   117: ldc_w 405
    //   120: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 113
    //   125: iconst_2
    //   126: aload_2
    //   127: invokevirtual 408	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +22 -> 162
    //   143: ldc 113
    //   145: iconst_2
    //   146: ldc_w 410
    //   149: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: ldc 113
    //   154: iconst_2
    //   155: aload_2
    //   156: invokevirtual 411	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   159: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 208	com/immersion/stickersampleapp/HapticManager:cK	Z
    //   167: goto -34 -> 133
    //   170: astore_2
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	HapticManager
    //   61	27	1	i	int
    //   107	20	2	localException	java.lang.Exception
    //   136	20	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   170	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	21	107	java/lang/Exception
    //   21	62	107	java/lang/Exception
    //   66	107	107	java/lang/Exception
    //   6	21	136	java/lang/UnsatisfiedLinkError
    //   21	62	136	java/lang/UnsatisfiedLinkError
    //   66	107	136	java/lang/UnsatisfiedLinkError
    //   2	6	170	finally
    //   6	21	170	finally
    //   21	62	170	finally
    //   66	107	170	finally
    //   108	133	170	finally
    //   137	162	170	finally
    //   162	167	170	finally
  }
  
  private void fb()
  {
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null) {
      this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.dispose();
    }
    if (this.X != null) {
      stopAll();
    }
    synchronized (this.X)
    {
      this.X.clear();
      if (this.E != null) {
        this.E.clear();
      }
      this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer = null;
      this.isInit = false;
      return;
    }
  }
  
  private void fc()
  {
    int i = 0;
    int[] arrayOfInt = new int[9];
    int[] tmp8_7 = arrayOfInt;
    tmp8_7[0] = 2131230727;
    int[] tmp14_8 = tmp8_7;
    tmp14_8[1] = 2131230726;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131230728;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131230729;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131230730;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131230731;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 2131230732;
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 2131230733;
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 2131230734;
    tmp58_51;
    String[] arrayOfString = new String[9];
    arrayOfString[0] = "chat_item_for_qq666";
    arrayOfString[1] = "chat_item_for_likeplus";
    arrayOfString[2] = "chat_item_for_qqbixin_light";
    arrayOfString[3] = "chat_item_for_qqbixin_strong";
    arrayOfString[4] = "chat_item_for_qqheartbroken";
    arrayOfString[5] = "chat_item_for_qqlikenew";
    arrayOfString[6] = "chat_item_for_qqpokenew";
    arrayOfString[7] = "chat_item_for_qqultnew";
    arrayOfString[8] = "chat_item_for_sticker40";
    while (i < arrayOfInt.length)
    {
      ??? = b(arrayOfInt[i], arrayOfString[i]);
      int j = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource((String)???, 1);
      synchronized (this.X)
      {
        this.X.add(new a(arrayOfString[i], j));
        i += 1;
      }
    }
  }
  
  private void fd()
  {
    this.E = new HashMap();
    this.E.put(Integer.valueOf(0), "SUCCESS");
    this.E.put(Integer.valueOf(2), "MISSING_PERMISSIONS");
    this.E.put(Integer.valueOf(1), "INVALID_PARAMETER");
    this.E.put(Integer.valueOf(-1), "INVALID_PARAMETER");
    this.E.put(Integer.valueOf(-2), "INVALID_URI");
    this.E.put(Integer.valueOf(-3), "INVALID_EFFECT");
    this.E.put(Integer.valueOf(-5), "OUT_OF_MEMORY");
    this.E.put(Integer.valueOf(-7), "IO_ERROR");
    this.E.put(Integer.valueOf(-9), "HAPT_NOT_READY");
    this.E.put(Integer.valueOf(-10), "TOO_MANY_EFFECTS");
    this.E.put(Integer.valueOf(-11), "PLAYER_NOT_INITIALIZED");
    this.E.put(Integer.valueOf(3), "INVALID_CREDENTIALS");
    this.E.put(Integer.valueOf(-12), "TOO_MANY_CONCURRENT_EFFECTS");
    this.E.put(Integer.valueOf(-13), "INVALID_STATE");
    this.E.put(Integer.valueOf(-14), "LIB_VERSION_NOT_FOUND");
  }
  
  public boolean A(int paramInt)
  {
    return (aK()) && (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.getEffectInfo(paramInt, 51) == 21);
  }
  
  public void V(int paramInt)
  {
    if (!B(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.pause(paramInt) == 0) {
      return;
    }
  }
  
  public void W(int paramInt)
  {
    if (!B(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.resume(paramInt) == 0) {
      return;
    }
  }
  
  public void X(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopEffect: " + paramInt);
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {}
    while ((!B(paramInt)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.stop(paramInt) == 0)) {
      return;
    }
  }
  
  public boolean aK()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null)
        {
          if (this.cK) {
            break label81;
          }
          if (!this.cL)
          {
            this.cL = true;
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              continue;
            }
            ThreadManager.post(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable, 10, null, false);
          }
        }
        HapticMediaPlayer localHapticMediaPlayer = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
        if (localHapticMediaPlayer == null) {
          break label88;
        }
        return bool;
        this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable.run();
        continue;
        eZ();
      }
      finally {}
      label81:
      continue;
      label88:
      bool = false;
    }
  }
  
  public int b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "playEffect: " + paramString);
    }
    if (!aK()) {
      return -1;
    }
    fa();
    a locala = a(paramString);
    if (locala == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "No effect added with name " + paramString);
      }
      return -1;
    }
    stopAll();
    int i = a.a(locala);
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "Invalid resource id for effect with name " + paramString + "! Error code returned = " + (String)this.E.get(Integer.valueOf(i)));
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "resource id:" + i);
    }
    paramInt = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.play(i, paramInt);
    if (paramInt < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "Error while playing haptic effect with name " + paramString + "! Error returned = " + (String)this.E.get(Integer.valueOf(paramInt)));
      }
    }
    for (;;)
    {
      return paramInt;
      a.a(locala, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "effect id:" + a.b(locala));
      }
    }
  }
  
  /* Error */
  public boolean c(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 582	java/io/File:createNewFile	()Z
    //   13: pop
    //   14: new 584	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 587	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: new 349	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 588	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_2
    //   39: aload 6
    //   41: aload_2
    //   42: invokevirtual 589	java/io/FileInputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: ifle +54 -> 101
    //   50: aload_1
    //   51: aload_2
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 353	java/io/FileOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore 7
    //   62: aload 6
    //   64: astore_2
    //   65: aload 7
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 590	java/io/FileInputStream:close	()V
    //   82: iload 5
    //   84: istore 4
    //   86: aload_1
    //   87: ifnull +11 -> 98
    //   90: aload_1
    //   91: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   94: iload 5
    //   96: istore 4
    //   98: iload 4
    //   100: ireturn
    //   101: iconst_1
    //   102: istore 4
    //   104: aload 6
    //   106: ifnull +8 -> 114
    //   109: aload 6
    //   111: invokevirtual 590	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: ifnull -17 -> 98
    //   118: aload_1
    //   119: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   144: goto -62 -> 82
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 7
    //   160: astore_2
    //   161: aload 6
    //   163: ifnull +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 590	java/io/FileInputStream:close	()V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   188: goto -17 -> 171
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   196: goto -17 -> 179
    //   199: astore_1
    //   200: aload 7
    //   202: astore_2
    //   203: goto -42 -> 161
    //   206: astore 7
    //   208: aload_1
    //   209: astore_2
    //   210: aload 7
    //   212: astore_1
    //   213: goto -52 -> 161
    //   216: astore 7
    //   218: aload_2
    //   219: astore 6
    //   221: aload_1
    //   222: astore_2
    //   223: aload 7
    //   225: astore_1
    //   226: goto -65 -> 161
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_1
    //   233: aload 8
    //   235: astore_2
    //   236: goto -167 -> 69
    //   239: astore 7
    //   241: aconst_null
    //   242: astore_1
    //   243: aload 6
    //   245: astore_2
    //   246: aload 7
    //   248: astore 6
    //   250: goto -181 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	HapticManager
    //   0	253	1	paramFile1	File
    //   0	253	2	paramFile2	File
    //   45	9	3	i	int
    //   84	19	4	bool1	boolean
    //   7	88	5	bool2	boolean
    //   22	145	6	localObject1	Object
    //   181	3	6	localIOException1	IOException
    //   219	1	6	localFile	File
    //   229	15	6	localIOException2	IOException
    //   248	1	6	localIOException3	IOException
    //   1	1	7	localObject2	Object
    //   60	141	7	localIOException4	IOException
    //   206	5	7	localObject3	Object
    //   216	8	7	localObject4	Object
    //   239	8	7	localIOException5	IOException
    //   4	230	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	60	java/io/IOException
    //   39	46	60	java/io/IOException
    //   50	57	60	java/io/IOException
    //   118	122	124	java/io/IOException
    //   109	114	131	java/io/IOException
    //   78	82	139	java/io/IOException
    //   90	94	147	java/io/IOException
    //   9	24	154	finally
    //   166	171	181	java/io/IOException
    //   175	179	191	java/io/IOException
    //   24	33	199	finally
    //   33	39	206	finally
    //   39	46	206	finally
    //   50	57	206	finally
    //   69	74	216	finally
    //   9	24	229	java/io/IOException
    //   24	33	239	java/io/IOException
  }
  
  public void dispose()
  {
    try
    {
      this.jdField_a_of_type_Mb.setConnection(null);
      fb();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void fa()
  {
    if (this.isInit) {
      return;
    }
    try
    {
      if (aK())
      {
        fc();
        this.isInit = true;
      }
      return;
    }
    finally {}
  }
  
  public int h(String paramString, int paramInt)
  {
    boolean bool = false;
    paramInt = b(paramString, paramInt, false);
    if (paramInt > 0) {
      bool = true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("effectName", paramString);
    anpc.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, "pokeEffectSucessRate", bool, 0L, 0L, localHashMap, "");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask, 60000L);
    return paramInt;
  }
  
  public void h(String paramString1, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 2, "add effect from sd card, effectName: " + paramString1 + ".");
    }
    if (!new File(???).exists())
    {
      QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " not exists.");
      return;
    }
    synchronized (this.X)
    {
      Iterator localIterator = this.X.iterator();
      while (localIterator.hasNext()) {
        if (a.a((a)localIterator.next()).equals(paramString1)) {
          return;
        }
      }
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null)
    {
      int i = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource(???, 1);
      synchronized (this.X)
      {
        this.X.add(new a(paramString1, i));
        QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load success.");
        return;
      }
    }
    QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load failure, because mHapticMediaPlayer is null.");
  }
  
  public void stopAll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopAll");
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {
      return;
    }
    synchronized (this.X)
    {
      Iterator localIterator = this.X.iterator();
      while (localIterator.hasNext())
      {
        int i = a.b((a)localIterator.next());
        if ((i > 0) && (A(i))) {
          X(i);
        }
      }
    }
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    if (!B(paramInt1)) {}
    while ((!A(paramInt1)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.update(paramInt1, paramInt2) == 0)) {
      return;
    }
  }
  
  class ClockTask
    implements Runnable
  {
    ClockTask() {}
    
    public void run()
    {
      ThreadManager.getUIHandler().post(HapticManager.a(HapticManager.this));
    }
  }
  
  class DisposeTask
    implements Runnable
  {
    DisposeTask() {}
    
    public void run()
    {
      HapticManager.this.dispose();
    }
  }
  
  class InitHMPRunnable
    implements Runnable
  {
    InitHMPRunnable() {}
    
    public void run()
    {
      if (HapticManager.a(HapticManager.this)) {
        HapticManager.this.aK();
      }
      HapticManager.a(HapticManager.this, false);
    }
  }
  
  class a
  {
    private String eQ;
    private int jD;
    private int mResourceId;
    
    public a(String paramString, int paramInt)
    {
      this.eQ = paramString;
      this.mResourceId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.immersion.stickersampleapp.HapticManager
 * JD-Core Version:    0.7.0.1
 */