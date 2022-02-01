import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ahwp
  implements Handler.Callback
{
  private static ConcurrentHashMap<String, String> fy = new ConcurrentHashMap();
  public static String msg;
  private ahwp.a a;
  public boolean aS;
  private aqju c;
  private boolean ciJ;
  private Activity mActivity;
  public Context mAppContext;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  public boolean waiting;
  
  public ahwp(Activity paramActivity, boolean paramBoolean, ahwp.a parama)
  {
    this.mActivity = paramActivity;
    this.mAppContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.ciJ = paramBoolean;
    this.a = parama;
  }
  
  private void F(String paramString)
  {
    if (!this.ciJ) {}
    aqju localaqju;
    do
    {
      return;
      localaqju = new aqju(this.mActivity, 2131756467);
      localaqju.setContentView(2131559151);
      localaqju.setTitle(this.mAppContext.getString(2131721103));
      localaqju.setMessage(paramString);
      localaqju.setCanceledOnTouchOutside(false);
      localaqju.setCancelable(false);
      localaqju.setNegativeButton(this.mAppContext.getString(2131691039), new ahwu(this));
    } while (this.mActivity.isFinishing());
    localaqju.show();
  }
  
  private static void G(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 36	ahwp:fy	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 162	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 168	java/lang/String
    //   13: astore 6
    //   15: aload 6
    //   17: ifnull +21 -> 38
    //   20: new 127	java/io/File
    //   23: dup
    //   24: aload 6
    //   26: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 132	java/io/File:exists	()Z
    //   32: ifeq +6 -> 38
    //   35: aload 6
    //   37: areturn
    //   38: aconst_null
    //   39: putstatic 170	ahwp:msg	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 54	ahwp:mActivity	Landroid/app/Activity;
    //   46: invokevirtual 174	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   49: astore 8
    //   51: aload 8
    //   53: aload_1
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokestatic 180	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnonnull +25 -> 90
    //   68: ldc 182
    //   70: iconst_1
    //   71: ldc 184
    //   73: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 6
    //   78: ifnull +10 -> 88
    //   81: aload 6
    //   83: invokeinterface 195 1 0
    //   88: aconst_null
    //   89: areturn
    //   90: aload 6
    //   92: ldc 197
    //   94: invokeinterface 201 2 0
    //   99: istore_2
    //   100: aload 6
    //   102: ldc 203
    //   104: invokeinterface 201 2 0
    //   109: istore_3
    //   110: aload 6
    //   112: invokeinterface 206 1 0
    //   117: pop
    //   118: aload 6
    //   120: iload_3
    //   121: invokeinterface 210 2 0
    //   126: lstore 4
    //   128: lload 4
    //   130: l2f
    //   131: invokestatic 216	aqhq:bB	()F
    //   134: fcmpl
    //   135: ifle +29 -> 164
    //   138: aload_0
    //   139: getfield 54	ahwp:mActivity	Landroid/app/Activity;
    //   142: ldc 217
    //   144: invokevirtual 218	android/app/Activity:getString	(I)Ljava/lang/String;
    //   147: putstatic 170	ahwp:msg	Ljava/lang/String;
    //   150: aload 6
    //   152: ifnull +10 -> 162
    //   155: aload 6
    //   157: invokeinterface 195 1 0
    //   162: aconst_null
    //   163: areturn
    //   164: iload_2
    //   165: iconst_m1
    //   166: if_icmpne +144 -> 310
    //   169: new 220	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   176: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: ldc 227
    //   184: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 7
    //   192: new 220	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   199: aload_0
    //   200: getfield 54	ahwp:mActivity	Landroid/app/Activity;
    //   203: invokevirtual 235	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   206: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: ldc 240
    //   211: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 242
    //   216: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 240
    //   221: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 9
    //   229: new 220	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   236: aload 9
    //   238: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 9
    //   243: aload 7
    //   245: invokestatic 246	aqhq:bY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 7
    //   256: aload 9
    //   258: invokestatic 248	ahwp:G	(Ljava/lang/String;)V
    //   261: new 127	java/io/File
    //   264: dup
    //   265: aload 9
    //   267: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: astore 9
    //   272: aload 9
    //   274: invokevirtual 132	java/io/File:exists	()Z
    //   277: ifne +46 -> 323
    //   280: aload 9
    //   282: invokevirtual 251	java/io/File:mkdirs	()Z
    //   285: ifne +38 -> 323
    //   288: ldc 252
    //   290: invokestatic 257	acfp:m	(I)Ljava/lang/String;
    //   293: putstatic 170	ahwp:msg	Ljava/lang/String;
    //   296: aload 6
    //   298: ifnull +10 -> 308
    //   301: aload 6
    //   303: invokeinterface 195 1 0
    //   308: aconst_null
    //   309: areturn
    //   310: aload 6
    //   312: iload_2
    //   313: invokeinterface 258 2 0
    //   318: astore 7
    //   320: goto -128 -> 192
    //   323: aload 8
    //   325: aload_1
    //   326: invokevirtual 264	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   329: astore 8
    //   331: aload 8
    //   333: ifnonnull +26 -> 359
    //   336: ldc 182
    //   338: iconst_1
    //   339: ldc_w 266
    //   342: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 6
    //   347: ifnull +10 -> 357
    //   350: aload 6
    //   352: invokeinterface 195 1 0
    //   357: aconst_null
    //   358: areturn
    //   359: lload 4
    //   361: ldc2_w 267
    //   364: lcmp
    //   365: ifle +150 -> 515
    //   368: aload_0
    //   369: iconst_1
    //   370: putfield 270	ahwp:waiting	Z
    //   373: new 74	aqju
    //   376: dup
    //   377: aload_0
    //   378: getfield 54	ahwp:mActivity	Landroid/app/Activity;
    //   381: ldc 75
    //   383: invokespecial 78	aqju:<init>	(Landroid/content/Context;I)V
    //   386: astore 9
    //   388: aload 9
    //   390: ldc 79
    //   392: invokevirtual 83	aqju:setContentView	(I)V
    //   395: aload 9
    //   397: aload_0
    //   398: getfield 66	ahwp:mAppContext	Landroid/content/Context;
    //   401: ldc 84
    //   403: invokevirtual 90	android/content/Context:getString	(I)Ljava/lang/String;
    //   406: invokevirtual 94	aqju:setTitle	(Ljava/lang/String;)Laqju;
    //   409: pop
    //   410: aload 9
    //   412: aload_0
    //   413: getfield 66	ahwp:mAppContext	Landroid/content/Context;
    //   416: ldc_w 271
    //   419: invokevirtual 90	android/content/Context:getString	(I)Ljava/lang/String;
    //   422: invokevirtual 98	aqju:setMessage	(Ljava/lang/CharSequence;)Laqju;
    //   425: pop
    //   426: aload 9
    //   428: iconst_0
    //   429: invokevirtual 102	aqju:setCanceledOnTouchOutside	(Z)V
    //   432: aload 9
    //   434: iconst_0
    //   435: invokevirtual 105	aqju:setCancelable	(Z)V
    //   438: aload 9
    //   440: aload_0
    //   441: getfield 66	ahwp:mAppContext	Landroid/content/Context;
    //   444: ldc_w 272
    //   447: invokevirtual 90	android/content/Context:getString	(I)Ljava/lang/String;
    //   450: new 274	ahwq
    //   453: dup
    //   454: aload_0
    //   455: aload 8
    //   457: invokespecial 277	ahwq:<init>	(Lahwp;Ljava/io/InputStream;)V
    //   460: invokevirtual 115	aqju:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   463: pop
    //   464: aload 9
    //   466: aload_0
    //   467: getfield 66	ahwp:mAppContext	Landroid/content/Context;
    //   470: ldc_w 278
    //   473: invokevirtual 90	android/content/Context:getString	(I)Ljava/lang/String;
    //   476: new 280	ahwr
    //   479: dup
    //   480: aload_0
    //   481: aload_1
    //   482: aload 7
    //   484: aload 8
    //   486: lload 4
    //   488: invokespecial 283	ahwr:<init>	(Lahwp;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   491: invokevirtual 286	aqju:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   494: pop
    //   495: aload 9
    //   497: invokevirtual 124	aqju:show	()V
    //   500: aload 6
    //   502: ifnull +10 -> 512
    //   505: aload 6
    //   507: invokeinterface 195 1 0
    //   512: aload 7
    //   514: areturn
    //   515: aload_0
    //   516: aload_1
    //   517: aload 7
    //   519: aload 8
    //   521: lload 4
    //   523: invokespecial 289	ahwp:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   526: goto -26 -> 500
    //   529: astore 7
    //   531: aload 6
    //   533: astore_1
    //   534: aload 7
    //   536: astore 6
    //   538: aload_0
    //   539: iconst_0
    //   540: putfield 291	ahwp:aS	Z
    //   543: ldc 182
    //   545: iconst_1
    //   546: ldc_w 293
    //   549: aload 6
    //   551: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   554: aload_1
    //   555: ifnull +9 -> 564
    //   558: aload_1
    //   559: invokeinterface 195 1 0
    //   564: aconst_null
    //   565: areturn
    //   566: astore_1
    //   567: aconst_null
    //   568: astore 6
    //   570: aload 6
    //   572: ifnull +10 -> 582
    //   575: aload 6
    //   577: invokeinterface 195 1 0
    //   582: aload_1
    //   583: athrow
    //   584: astore_1
    //   585: goto -15 -> 570
    //   588: astore 7
    //   590: aload_1
    //   591: astore 6
    //   593: aload 7
    //   595: astore_1
    //   596: goto -26 -> 570
    //   599: astore 6
    //   601: aconst_null
    //   602: astore_1
    //   603: goto -65 -> 538
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	ahwp
    //   0	606	1	paramUri	Uri
    //   99	214	2	i	int
    //   109	12	3	j	int
    //   126	396	4	l	long
    //   13	579	6	localObject1	Object
    //   599	1	6	localException1	Exception
    //   190	328	7	str	String
    //   529	6	7	localException2	Exception
    //   588	6	7	localObject2	Object
    //   49	471	8	localObject3	Object
    //   227	269	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   68	76	529	java/lang/Exception
    //   90	150	529	java/lang/Exception
    //   169	192	529	java/lang/Exception
    //   192	296	529	java/lang/Exception
    //   310	320	529	java/lang/Exception
    //   323	331	529	java/lang/Exception
    //   336	345	529	java/lang/Exception
    //   368	500	529	java/lang/Exception
    //   515	526	529	java/lang/Exception
    //   51	63	566	finally
    //   68	76	584	finally
    //   90	150	584	finally
    //   169	192	584	finally
    //   192	296	584	finally
    //   310	320	584	finally
    //   323	331	584	finally
    //   336	345	584	finally
    //   368	500	584	finally
    //   515	526	584	finally
    //   538	554	588	finally
    //   51	63	599	java/lang/Exception
  }
  
  /* Error */
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 304	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: aload_0
    //   9: iconst_1
    //   10: anewarray 168	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 307
    //   18: aastore
    //   19: aload_1
    //   20: aload_2
    //   21: aconst_null
    //   22: invokestatic 180	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +40 -> 67
    //   30: aload_0
    //   31: invokeinterface 206 1 0
    //   36: ifeq +31 -> 67
    //   39: aload_0
    //   40: aload_0
    //   41: ldc_w 307
    //   44: invokeinterface 310 2 0
    //   49: invokeinterface 258 2 0
    //   54: astore_1
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokeinterface 195 1 0
    //   65: aload_1
    //   66: areturn
    //   67: aload_0
    //   68: ifnull +9 -> 77
    //   71: aload_0
    //   72: invokeinterface 195 1 0
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull -6 -> 77
    //   86: aload_0
    //   87: invokeinterface 195 1 0
    //   92: goto -15 -> 77
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +9 -> 108
    //   102: aload_0
    //   103: invokeinterface 195 1 0
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: goto -13 -> 98
    //   114: astore_1
    //   115: goto -33 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramUri	Uri
    //   0	118	1	paramString	String
    //   0	118	2	paramArrayOfString	String[]
    //   3	2	3	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   4	26	79	java/lang/Throwable
    //   4	26	95	finally
    //   30	55	110	finally
    //   30	55	114	java/lang/Throwable
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.aS = true;
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.ciJ) {
      return;
    }
    if (this.c == null)
    {
      this.c = aqha.a(this.mActivity, this.mAppContext.getString(2131692335), acfp.m(2131716273), new ahws(this));
      this.c.setOnDismissListener(new ahwt(this));
    }
    this.c.show();
  }
  
  /* Error */
  public static boolean b(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: ifnonnull +6 -> 12
    //   9: iload 4
    //   11: ireturn
    //   12: aload_0
    //   13: invokevirtual 349	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: astore 5
    //   18: new 220	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 351
    //   25: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: astore 6
    //   30: aload 6
    //   32: ldc_w 354
    //   35: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: ifnull +14 -> 59
    //   48: aload 5
    //   50: ldc_w 356
    //   53: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +162 -> 218
    //   59: new 127	java/io/File
    //   62: dup
    //   63: aload_0
    //   64: invokevirtual 363	android/net/Uri:getPath	()Ljava/lang/String;
    //   67: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +435 -> 509
    //   77: aload 5
    //   79: invokevirtual 366	java/io/File:canRead	()Z
    //   82: istore 4
    //   84: iload 4
    //   86: ifeq +423 -> 509
    //   89: iconst_1
    //   90: istore_3
    //   91: iload_3
    //   92: istore 4
    //   94: aload 6
    //   96: ldc_w 368
    //   99: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: iload_3
    //   108: istore 4
    //   110: iload_3
    //   111: ifne -102 -> 9
    //   114: iload_3
    //   115: istore 4
    //   117: aload_1
    //   118: ifnull -109 -> 9
    //   121: aload_1
    //   122: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   125: astore 5
    //   127: aload 5
    //   129: aload_0
    //   130: aconst_null
    //   131: aconst_null
    //   132: aconst_null
    //   133: aconst_null
    //   134: invokestatic 180	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +357 -> 496
    //   142: aload_1
    //   143: ldc 197
    //   145: invokeinterface 201 2 0
    //   150: istore_2
    //   151: aload_1
    //   152: invokeinterface 206 1 0
    //   157: pop
    //   158: iload_2
    //   159: iconst_m1
    //   160: if_icmpne +283 -> 443
    //   163: aconst_null
    //   164: astore_1
    //   165: aload 5
    //   167: aload_0
    //   168: invokevirtual 264	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   171: ifnull +325 -> 496
    //   174: aload_1
    //   175: invokestatic 377	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +318 -> 496
    //   181: ldc 182
    //   183: iconst_1
    //   184: iconst_2
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc_w 379
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: aload_1
    //   197: aastore
    //   198: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   201: iconst_1
    //   202: istore_3
    //   203: aload 6
    //   205: ldc_w 384
    //   208: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload_3
    //   212: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: iload_3
    //   217: ireturn
    //   218: aload 5
    //   220: ldc_w 386
    //   223: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: istore 4
    //   228: iload 4
    //   230: ifeq +274 -> 504
    //   233: aload_1
    //   234: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   237: aload_0
    //   238: iconst_1
    //   239: anewarray 168	java/lang/String
    //   242: dup
    //   243: iconst_0
    //   244: ldc_w 307
    //   247: aastore
    //   248: aconst_null
    //   249: aconst_null
    //   250: aconst_null
    //   251: invokestatic 180	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   254: astore 5
    //   256: aload 5
    //   258: ldc_w 307
    //   261: invokeinterface 310 2 0
    //   266: istore_2
    //   267: aload 5
    //   269: invokeinterface 206 1 0
    //   274: pop
    //   275: aload 5
    //   277: iload_2
    //   278: invokeinterface 258 2 0
    //   283: astore 7
    //   285: aload 5
    //   287: invokeinterface 195 1 0
    //   292: aload 7
    //   294: invokestatic 377	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +202 -> 499
    //   300: ldc 182
    //   302: iconst_1
    //   303: iconst_2
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: ldc_w 388
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: aload 7
    //   317: aastore
    //   318: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   321: new 127	java/io/File
    //   324: dup
    //   325: aload 7
    //   327: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   330: astore 5
    //   332: aload 5
    //   334: ifnull +165 -> 499
    //   337: aload 5
    //   339: invokevirtual 366	java/io/File:canRead	()Z
    //   342: istore 4
    //   344: iload 4
    //   346: ifeq +153 -> 499
    //   349: iconst_1
    //   350: istore_3
    //   351: iload_3
    //   352: istore 4
    //   354: aload 6
    //   356: ldc_w 393
    //   359: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload_3
    //   363: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: goto -260 -> 107
    //   370: astore 5
    //   372: iload 4
    //   374: istore_3
    //   375: ldc 182
    //   377: iconst_1
    //   378: ldc_w 395
    //   381: aload 5
    //   383: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   386: goto -279 -> 107
    //   389: astore 5
    //   391: ldc 182
    //   393: iconst_1
    //   394: ldc_w 397
    //   397: aload 5
    //   399: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: aload 6
    //   404: ldc_w 393
    //   407: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iconst_0
    //   411: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: iconst_0
    //   416: istore_3
    //   417: goto -310 -> 107
    //   420: astore 5
    //   422: aload 6
    //   424: ldc_w 393
    //   427: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: iconst_0
    //   431: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 5
    //   437: athrow
    //   438: astore 5
    //   440: goto -65 -> 375
    //   443: aload_1
    //   444: iload_2
    //   445: invokeinterface 258 2 0
    //   450: astore_1
    //   451: goto -286 -> 165
    //   454: astore_0
    //   455: ldc 182
    //   457: iconst_1
    //   458: ldc_w 399
    //   461: aload_0
    //   462: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   465: aload 6
    //   467: ldc_w 384
    //   470: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: iload_3
    //   474: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: iload_3
    //   479: ireturn
    //   480: astore_0
    //   481: aload 6
    //   483: ldc_w 384
    //   486: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload_3
    //   490: invokevirtual 371	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_0
    //   495: athrow
    //   496: goto -293 -> 203
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -150 -> 351
    //   504: iconst_0
    //   505: istore_3
    //   506: goto -399 -> 107
    //   509: iconst_0
    //   510: istore_3
    //   511: goto -420 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	paramUri	Uri
    //   0	514	1	paramContext	Context
    //   150	295	2	i	int
    //   1	510	3	bool1	boolean
    //   3	370	4	bool2	boolean
    //   16	322	5	localObject1	Object
    //   370	12	5	localException1	Exception
    //   389	9	5	localThrowable	Throwable
    //   420	16	5	localObject2	Object
    //   438	1	5	localException2	Exception
    //   28	454	6	localStringBuilder	StringBuilder
    //   283	43	7	str	String
    // Exception table:
    //   from	to	target	type
    //   94	107	370	java/lang/Exception
    //   354	367	370	java/lang/Exception
    //   233	332	389	java/lang/Throwable
    //   337	344	389	java/lang/Throwable
    //   233	332	420	finally
    //   337	344	420	finally
    //   391	402	420	finally
    //   48	59	438	java/lang/Exception
    //   59	72	438	java/lang/Exception
    //   77	84	438	java/lang/Exception
    //   218	228	438	java/lang/Exception
    //   402	415	438	java/lang/Exception
    //   422	438	438	java/lang/Exception
    //   121	138	454	java/lang/Exception
    //   142	158	454	java/lang/Exception
    //   165	201	454	java/lang/Exception
    //   443	451	454	java/lang/Exception
    //   121	138	480	finally
    //   142	158	480	finally
    //   165	201	480	finally
    //   443	451	480	finally
    //   455	465	480	finally
  }
  
  private void bF()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  protected String B()
  {
    if (msg == null) {
      return this.mAppContext.getString(2131720159);
    }
    return msg;
  }
  
  public String a(Uri paramUri, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UriParserPathHelper", 2, "uri= " + paramUri);
    }
    this.aS = false;
    this.waiting = false;
    if ((VersionUtils.isNougat()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject1).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", acbn.SDCARD_ROOT);
        if (QLog.isColorLevel()) {
          QLog.d("UriParserPathHelper", 2, "Nougat path: " + paramUri);
        }
        return paramUri;
      }
    }
    else if (VersionUtils.isKITKAT())
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() < 2) || (!"document".equals(((List)localObject1).get(0)))) {
        break label449;
      }
    }
    label449:
    Object localObject2;
    for (Object localObject1 = (String)((List)localObject1).get(1);; localObject2 = null) {
      for (;;)
      {
        try
        {
          if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
          {
            localObject1 = ((String)localObject1).split(":");
            if ("primary".equalsIgnoreCase(localObject1[0])) {
              return Environment.getExternalStorageDirectory() + "/" + localObject1[1];
            }
          }
          else
          {
            if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject1).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              String[] arrayOfString = ((String)localObject1).split(":");
              localObject1 = arrayOfString[0];
              if ("image".equals(localObject1))
              {
                localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                return a((Uri)localObject1, "_id=?", new String[] { arrayOfString[1] });
              }
              if ("video".equals(localObject1))
              {
                localObject1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                continue;
              }
              if (!"audio".equals(localObject1)) {
                break;
              }
              localObject1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              continue;
            }
            boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
            if (!bool) {}
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("UriParserPathHelper", 2, "handle exeption ", localException);
          continue;
        }
        return b(paramUri, paramBoolean);
        if ((localException.size() >= 2) && ("my_external".equals(localException.get(0))) && ("com.android.contacts.files".equals(paramUri.getAuthority())))
        {
          paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
          int i = 1;
          while (i < localException.size())
          {
            paramUri.append('/').append((String)localException.get(i));
            i += 1;
          }
          return paramUri.toString();
        }
      }
    }
  }
  
  public String b(Uri paramUri, boolean paramBoolean)
  {
    Object localObject = paramUri.getScheme();
    if ((localObject == null) || (((String)localObject).equals("file"))) {
      localObject = new File(paramUri.getPath()).getAbsolutePath();
    }
    for (;;)
    {
      return localObject;
      if (((String)localObject).equals("content")) {
        try
        {
          localObject = alld.query(this.mActivity.getContentResolver(), paramUri, new String[] { "_data" }, null, null, null);
          int i = ((Cursor)localObject).getColumnIndexOrThrow("_data");
          ((Cursor)localObject).moveToFirst();
          String str = ((Cursor)localObject).getString(i);
          ((Cursor)localObject).close();
          localObject = str;
          if (!new File(str).canRead())
          {
            localObject = str;
            if (paramBoolean)
            {
              localObject = a(paramUri);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          if (paramBoolean) {
            return a(paramUri);
          }
        }
      }
    }
    return null;
  }
  
  public String f(Uri paramUri)
  {
    return a(paramUri, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bF();
      F(B());
      if (this.a != null)
      {
        this.a.f(null);
        this.a = null;
        continue;
        bF();
        continue;
        QLog.i("UriParserPathHelper", 1, "handleMessage.progress: " + paramMessage.arg1);
        if ((this.c != null) && (this.c.isShowing())) {
          this.c.setProgress(paramMessage.arg1);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(Uri paramUri);
    
    public abstract void o(String paramString1, String paramString2, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwp
 * JD-Core Version:    0.7.0.1
 */