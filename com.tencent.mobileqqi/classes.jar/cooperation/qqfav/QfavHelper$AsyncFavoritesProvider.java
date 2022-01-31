package cooperation.qqfav;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class QfavHelper$AsyncFavoritesProvider
  extends OnPluginInstallListener.Stub
{
  public static final long a = 1L;
  public static final String a = "req_opt_type";
  public static final long b = 2L;
  public static final String b = "req_biz_type";
  public static final long c = 3L;
  public static final String c = "req_biz_key";
  public static final long d = 2L;
  public static final String d = "req_fav_uin";
  public static final String e = "req_fav_id";
  public static final String f = "rsp_fav_id";
  public Bundle a;
  
  public QfavHelper$AsyncFavoritesProvider(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public void a()
  {
    QfavHelper.a(BaseApplication.getContext(), this);
  }
  
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    a(false, this.a);
  }
  
  /* Error */
  public void onInstallFinish(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   4: ifnonnull +13 -> 17
    //   7: aload_0
    //   8: iconst_0
    //   9: aload_0
    //   10: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   13: invokevirtual 59	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	(ZLandroid/os/Bundle;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   21: ldc 11
    //   23: ldc2_w 63
    //   26: invokevirtual 70	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   29: lstore_2
    //   30: aload_0
    //   31: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   34: ldc 16
    //   36: ldc2_w 63
    //   39: invokevirtual 70	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   42: lstore 4
    //   44: aload_0
    //   45: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   48: ldc 21
    //   50: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 9
    //   55: aload_0
    //   56: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   59: ldc 24
    //   61: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 12
    //   66: ldc2_w 63
    //   69: lload_2
    //   70: lcmp
    //   71: ifeq +28 -> 99
    //   74: ldc2_w 63
    //   77: lload 4
    //   79: lcmp
    //   80: ifeq +19 -> 99
    //   83: aload 9
    //   85: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +11 -> 99
    //   91: aload 12
    //   93: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifeq +13 -> 109
    //   99: aload_0
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   105: invokevirtual 59	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	(ZLandroid/os/Bundle;)V
    //   108: return
    //   109: invokestatic 45	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   112: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   115: astore 11
    //   117: aload 11
    //   119: ifnonnull +13 -> 132
    //   122: aload_0
    //   123: iconst_0
    //   124: aload_0
    //   125: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   128: invokevirtual 59	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	(ZLandroid/os/Bundle;)V
    //   131: return
    //   132: new 66	android/os/Bundle
    //   135: dup
    //   136: aload_0
    //   137: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   140: invokespecial 88	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   143: astore 10
    //   145: aconst_null
    //   146: astore 8
    //   148: aconst_null
    //   149: astore_1
    //   150: lconst_1
    //   151: lload_2
    //   152: lcmp
    //   153: ifne +170 -> 323
    //   156: new 90	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   163: ldc 93
    //   165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 12
    //   170: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 107	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   179: astore_1
    //   180: new 90	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   187: ldc 109
    //   189: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: lload 4
    //   194: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 12
    //   202: aload 11
    //   204: aload_1
    //   205: iconst_1
    //   206: anewarray 114	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: ldc 116
    //   213: aastore
    //   214: ldc 118
    //   216: iconst_2
    //   217: anewarray 114	java/lang/String
    //   220: dup
    //   221: iconst_0
    //   222: aload 12
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload 9
    //   229: aastore
    //   230: aconst_null
    //   231: invokevirtual 124	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +365 -> 601
    //   239: aload_1
    //   240: astore 8
    //   242: aload_1
    //   243: invokeinterface 130 1 0
    //   248: ifeq +353 -> 601
    //   251: aload_1
    //   252: astore 8
    //   254: aload_1
    //   255: aload_1
    //   256: ldc 116
    //   258: invokeinterface 134 2 0
    //   263: invokeinterface 137 2 0
    //   268: astore 9
    //   270: aload 9
    //   272: ifnull +323 -> 595
    //   275: iconst_1
    //   276: istore 7
    //   278: iconst_1
    //   279: istore 6
    //   281: aload_1
    //   282: astore 8
    //   284: aload 10
    //   286: ldc 30
    //   288: aload 9
    //   290: invokestatic 141	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: iload 6
    //   298: istore 7
    //   300: aload_1
    //   301: ifnull +13 -> 314
    //   304: aload_1
    //   305: invokeinterface 148 1 0
    //   310: iload 6
    //   312: istore 7
    //   314: aload_0
    //   315: iload 7
    //   317: aload 10
    //   319: invokevirtual 59	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	(ZLandroid/os/Bundle;)V
    //   322: return
    //   323: ldc2_w 13
    //   326: lload_2
    //   327: lcmp
    //   328: ifne +74 -> 402
    //   331: aload 11
    //   333: new 90	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   340: ldc 93
    //   342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 12
    //   347: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 107	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   356: ldc 118
    //   358: iconst_2
    //   359: anewarray 114	java/lang/String
    //   362: dup
    //   363: iconst_0
    //   364: new 90	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   371: ldc 109
    //   373: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: lload 4
    //   378: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   381: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: aastore
    //   385: dup
    //   386: iconst_1
    //   387: aload 9
    //   389: aastore
    //   390: invokevirtual 152	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   393: ifle +214 -> 607
    //   396: iconst_1
    //   397: istore 6
    //   399: goto -103 -> 296
    //   402: ldc2_w 18
    //   405: lload_2
    //   406: lcmp
    //   407: ifne +182 -> 589
    //   410: aload_0
    //   411: getfield 38	cooperation/qqfav/QfavHelper$AsyncFavoritesProvider:a	Landroid/os/Bundle;
    //   414: ldc 27
    //   416: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: astore 13
    //   421: aload 13
    //   423: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   426: ifne +163 -> 589
    //   429: new 154	android/content/ContentValues
    //   432: dup
    //   433: invokespecial 155	android/content/ContentValues:<init>	()V
    //   436: astore 14
    //   438: aload 14
    //   440: ldc 157
    //   442: lload 4
    //   444: invokestatic 163	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   447: invokevirtual 167	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   450: aload 14
    //   452: ldc 169
    //   454: aload 9
    //   456: invokevirtual 171	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 14
    //   461: ldc 116
    //   463: aload 13
    //   465: invokevirtual 171	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 11
    //   470: new 90	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   477: ldc 93
    //   479: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 12
    //   484: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 107	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   493: aload 14
    //   495: invokevirtual 175	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   498: astore 9
    //   500: aload 9
    //   502: ifnull +9 -> 511
    //   505: iconst_1
    //   506: istore 6
    //   508: goto -212 -> 296
    //   511: iconst_0
    //   512: istore 6
    //   514: goto -218 -> 296
    //   517: astore 9
    //   519: aconst_null
    //   520: astore_1
    //   521: iconst_0
    //   522: istore 6
    //   524: aload_1
    //   525: astore 8
    //   527: aload 9
    //   529: invokevirtual 178	java/lang/Exception:printStackTrace	()V
    //   532: iload 6
    //   534: istore 7
    //   536: aload_1
    //   537: ifnull -223 -> 314
    //   540: aload_1
    //   541: invokeinterface 148 1 0
    //   546: iload 6
    //   548: istore 7
    //   550: goto -236 -> 314
    //   553: astore_1
    //   554: aload 8
    //   556: ifnull +10 -> 566
    //   559: aload 8
    //   561: invokeinterface 148 1 0
    //   566: aload_1
    //   567: athrow
    //   568: astore_1
    //   569: goto -15 -> 554
    //   572: astore 9
    //   574: iconst_0
    //   575: istore 6
    //   577: goto -53 -> 524
    //   580: astore 9
    //   582: iload 7
    //   584: istore 6
    //   586: goto -62 -> 524
    //   589: iconst_0
    //   590: istore 6
    //   592: goto -296 -> 296
    //   595: iconst_0
    //   596: istore 6
    //   598: goto -302 -> 296
    //   601: iconst_0
    //   602: istore 6
    //   604: goto -308 -> 296
    //   607: iconst_0
    //   608: istore 6
    //   610: goto -314 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	AsyncFavoritesProvider
    //   0	613	1	paramString	String
    //   29	377	2	l1	long
    //   42	401	4	l2	long
    //   279	330	6	bool1	boolean
    //   276	307	7	bool2	boolean
    //   146	414	8	str1	String
    //   53	448	9	localObject	java.lang.Object
    //   517	11	9	localException1	java.lang.Exception
    //   572	1	9	localException2	java.lang.Exception
    //   580	1	9	localException3	java.lang.Exception
    //   143	175	10	localBundle	Bundle
    //   115	354	11	localContentResolver	android.content.ContentResolver
    //   64	419	12	str2	String
    //   419	45	13	str3	String
    //   436	58	14	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   156	235	517	java/lang/Exception
    //   331	396	517	java/lang/Exception
    //   410	500	517	java/lang/Exception
    //   156	235	553	finally
    //   331	396	553	finally
    //   410	500	553	finally
    //   242	251	568	finally
    //   254	270	568	finally
    //   284	296	568	finally
    //   527	532	568	finally
    //   242	251	572	java/lang/Exception
    //   254	270	572	java/lang/Exception
    //   284	296	580	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.AsyncFavoritesProvider
 * JD-Core Version:    0.7.0.1
 */