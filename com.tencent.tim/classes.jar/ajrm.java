import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.2;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.3;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ajrm
{
  private static String bSl = "need_show_auth_video_guide_";
  private static String bSm = "need_open_auth_video";
  
  public static void MV(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("VideoAuthEnable");
      String str = bSm;
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(str, bool).commit();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyVideoUtils", 2, "setAuthVideoConfig=" + paramString + ",error:" + localJSONException.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("video_url", paramString2);
    localIntent.putExtra("video_thumb_url", paramString3);
    localIntent.putExtra("mode", paramInt);
    localIntent.putExtra("uin", paramString4);
    localIntent.putExtra("is_authentic", paramBoolean);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, NearbyAuthVideoPlayerFragment.class, 11000);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aook paramaook)
  {
    paramaook.addFilter(new Class[] { aomd.class });
    paramQQAppInterface.a().a(paramaook);
    ThreadManager.post(new NearbyVideoUtils.2(paramQQAppInterface, paramString, (int)(System.currentTimeMillis() / 1000L)), 8, null, true);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (!bf(paramQQAppInterface)) {}
    do
    {
      return false;
      if (!paramActivity.isFinishing()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NearbyVideoUtils", 2, "showVoteUpdateDialog invoke, but activity is finishing");
    return false;
    ImageView localImageView = new ImageView(paramActivity);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170807/f2f569d65bc74317bb9a6bfe482dcd2c.png?_t=1502087876532"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(150.0F, paramActivity.getResources()));
    new akkn(paramActivity).a(localImageView, localLayoutParams).b(acfp.m(2131708944)).a(new akkh(acfp.m(2131708946), new ajrn(paramActivity, paramQQAppInterface))).show();
    dx(paramQQAppInterface);
    return true;
  }
  
  public static boolean arz()
  {
    String str = bSm;
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(str, true);
  }
  
  public static void as(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.execute(new NearbyVideoUtils.3(paramString, paramQQAppInterface));
  }
  
  public static void b(Activity paramActivity, AppInterface paramAppInterface, int paramInt) {}
  
  public static boolean bf(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = bSl + paramQQAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(paramQQAppInterface, true);
  }
  
  /* Error */
  private static String c(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 287	java/io/File
    //   6: dup
    //   7: getstatic 292	acbn:bna	Ljava/lang/String;
    //   10: invokestatic 298	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial 299	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 302	java/io/File:mkdirs	()Z
    //   21: pop
    //   22: new 287	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: new 70	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 304
    //   37: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   43: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 310	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: invokevirtual 313	java/io/File:exists	()Z
    //   59: ifeq +9 -> 68
    //   62: aload 4
    //   64: invokevirtual 316	java/io/File:delete	()Z
    //   67: pop
    //   68: new 318	java/io/FileOutputStream
    //   71: dup
    //   72: aload 4
    //   74: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore_1
    //   78: new 323	java/io/BufferedOutputStream
    //   81: dup
    //   82: aload_1
    //   83: sipush 4096
    //   86: invokespecial 326	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   89: astore 5
    //   91: aload 5
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: aload_0
    //   97: getstatic 332	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: bipush 100
    //   102: aload 5
    //   104: invokevirtual 338	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   107: pop
    //   108: aload 5
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload 5
    //   115: invokevirtual 341	java/io/BufferedOutputStream:flush	()V
    //   118: aload 5
    //   120: astore_3
    //   121: aload_1
    //   122: astore_2
    //   123: aload 4
    //   125: invokevirtual 344	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: astore_1
    //   139: aload 5
    //   141: ifnull +10 -> 151
    //   144: aload 5
    //   146: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   149: aload_0
    //   150: astore_1
    //   151: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +29 -> 183
    //   157: ldc 68
    //   159: iconst_2
    //   160: new 70	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 350
    //   170: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_1
    //   174: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   190: goto -53 -> 137
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   198: aload_0
    //   199: astore_1
    //   200: goto -49 -> 151
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_1
    //   209: aload_0
    //   210: astore_3
    //   211: aload_1
    //   212: astore_2
    //   213: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +18 -> 234
    //   219: aload_0
    //   220: astore_3
    //   221: aload_1
    //   222: astore_2
    //   223: ldc 68
    //   225: iconst_2
    //   226: ldc_w 355
    //   229: aload 4
    //   231: invokestatic 359	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   242: aload 6
    //   244: astore_1
    //   245: aload_0
    //   246: ifnull -95 -> 151
    //   249: aload_0
    //   250: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   253: aload 6
    //   255: astore_1
    //   256: goto -105 -> 151
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   264: aload 6
    //   266: astore_1
    //   267: goto -116 -> 151
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   275: goto -33 -> 242
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_3
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   291: aload_3
    //   292: ifnull +7 -> 299
    //   295: aload_3
    //   296: invokevirtual 348	java/io/BufferedOutputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   306: goto -15 -> 291
    //   309: astore_1
    //   310: aload_1
    //   311: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   314: goto -15 -> 299
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_3
    //   320: goto -37 -> 283
    //   323: astore_0
    //   324: aload_2
    //   325: astore_1
    //   326: goto -43 -> 283
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_0
    //   333: goto -124 -> 209
    //   336: astore 4
    //   338: aload 5
    //   340: astore_0
    //   341: goto -132 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramBitmap	android.graphics.Bitmap
    //   16	168	1	localObject1	Object
    //   185	2	1	localIOException1	java.io.IOException
    //   193	2	1	localIOException2	java.io.IOException
    //   199	68	1	localObject2	Object
    //   270	2	1	localIOException3	java.io.IOException
    //   282	6	1	localObject3	Object
    //   301	2	1	localIOException4	java.io.IOException
    //   309	2	1	localIOException5	java.io.IOException
    //   325	1	1	localObject4	Object
    //   95	230	2	localObject5	Object
    //   93	227	3	localObject6	Object
    //   52	72	4	localFile	java.io.File
    //   203	27	4	localException1	java.lang.Exception
    //   329	1	4	localException2	java.lang.Exception
    //   336	1	4	localException3	java.lang.Exception
    //   89	250	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1	264	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   133	137	185	java/io/IOException
    //   144	149	193	java/io/IOException
    //   68	78	203	java/lang/Exception
    //   249	253	259	java/io/IOException
    //   238	242	270	java/io/IOException
    //   68	78	278	finally
    //   287	291	301	java/io/IOException
    //   295	299	309	java/io/IOException
    //   78	91	317	finally
    //   96	108	323	finally
    //   113	118	323	finally
    //   123	129	323	finally
    //   213	219	323	finally
    //   223	234	323	finally
    //   78	91	329	java/lang/Exception
    //   96	108	336	java/lang/Exception
    //   113	118	336	java/lang/Exception
    //   123	129	336	java/lang/Exception
  }
  
  public static void dx(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = bSl + paramQQAppInterface.getCurrentAccountUin();
    PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  public static void e(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new anov(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).report();
  }
  
  public static void k(String paramString, String... paramVarArgs)
  {
    e("data_card", paramString, 0, 0, paramVarArgs);
  }
  
  public static String ms(String paramString)
  {
    return c(ShortVideoUtils.getVideoThumbnail(null, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrm
 * JD-Core Version:    0.7.0.1
 */