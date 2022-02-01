import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.troop.TroopFileProxyActivity;
import java.util.HashMap;
import java.util.UUID;

public class xpw
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.a
{
  public static int bTD = 100;
  static int bWi;
  static int bWj;
  public static HashMap<String, Long> gQ = new HashMap();
  public static LruCache<String, Drawable> j = new LruCache(20);
  private agho a;
  public View.OnClickListener mSourceOnClickListener;
  public Handler mUiHandler;
  protected View wS;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131296407);
    bWi = (int)(localDisplayMetrics.widthPixels - aqho.convertDpToPixel(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.paddingLeft - BaseChatItemLayout.paddingRight - i * 2 - aqho.convertDpToPixel(localBaseApplication, 10.0F));
    if (bWi > 640) {
      bWi = 640;
    }
    bWj = bWi * 9 / 16;
  }
  
  /* Error */
  public static Drawable a(Context paramContext, apcy paramapcy, MessageForTroopFile paramMessageForTroopFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 104	apcy:coc	Ljava/lang/String;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 107	apcy:LocalFile	Ljava/lang/String;
    //   10: ifnull +80 -> 90
    //   13: aload_1
    //   14: getfield 107	apcy:LocalFile	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 113	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: astore 10
    //   29: aload 10
    //   31: invokevirtual 54	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   34: getfield 116	android/util/DisplayMetrics:densityDpi	I
    //   37: istore 6
    //   39: ldc 117
    //   41: iload 6
    //   43: i2f
    //   44: ldc 118
    //   46: fdiv
    //   47: fmul
    //   48: fstore_3
    //   49: aload_2
    //   50: ifnull +742 -> 792
    //   53: aload_2
    //   54: invokevirtual 124	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: ldc 126
    //   59: invokestatic 132	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   62: ifeq +730 -> 792
    //   65: getstatic 36	xpw:j	Landroid/support/v4/util/LruCache;
    //   68: aload 8
    //   70: invokevirtual 136	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 138	android/graphics/drawable/Drawable
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: instanceof 140
    //   85: ifeq +11 -> 96
    //   88: aload_0
    //   89: areturn
    //   90: aload 8
    //   92: astore_2
    //   93: goto -75 -> 18
    //   96: aload_1
    //   97: getfield 107	apcy:LocalFile	Ljava/lang/String;
    //   100: ifnull +692 -> 792
    //   103: new 142	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: getfield 107	apcy:LocalFile	Ljava/lang/String;
    //   111: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_0
    //   117: invokestatic 151	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   120: astore_0
    //   121: aload_0
    //   122: getfield 156	android/graphics/Rect:right	I
    //   125: aload_0
    //   126: getfield 159	android/graphics/Rect:bottom	I
    //   129: invokestatic 163	xpw:b	(II)[I
    //   132: astore_2
    //   133: aload_0
    //   134: aload_2
    //   135: iconst_0
    //   136: iaload
    //   137: iload 6
    //   139: sipush 160
    //   142: idiv
    //   143: idiv
    //   144: putfield 156	android/graphics/Rect:right	I
    //   147: aload_0
    //   148: aload_2
    //   149: iconst_1
    //   150: iaload
    //   151: iload 6
    //   153: sipush 160
    //   156: idiv
    //   157: idiv
    //   158: putfield 159	android/graphics/Rect:bottom	I
    //   161: aload_1
    //   162: iconst_0
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual 167	android/graphics/Rect:width	()I
    //   168: aload_0
    //   169: invokevirtual 170	android/graphics/Rect:height	()I
    //   172: ldc 117
    //   174: invokestatic 176	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +388 -> 567
    //   182: new 140	com/tencent/image/GifDrawable
    //   185: dup
    //   186: aload_1
    //   187: aload 10
    //   189: invokespecial 179	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   192: astore_0
    //   193: getstatic 36	xpw:j	Landroid/support/v4/util/LruCache;
    //   196: aload 8
    //   198: aload_0
    //   199: invokevirtual 183	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: ldc 117
    //   208: fstore_3
    //   209: aload_0
    //   210: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   213: new 142	java/io/File
    //   216: dup
    //   217: aload 8
    //   219: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: getstatic 36	xpw:j	Landroid/support/v4/util/LruCache;
    //   226: aload 8
    //   228: invokevirtual 136	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 138	android/graphics/drawable/Drawable
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_1
    //   238: ifnonnull -150 -> 88
    //   241: aload_1
    //   242: astore_0
    //   243: aload_2
    //   244: invokevirtual 190	java/io/File:exists	()Z
    //   247: ifeq -159 -> 88
    //   250: new 192	android/graphics/BitmapFactory$Options
    //   253: dup
    //   254: invokespecial 193	android/graphics/BitmapFactory$Options:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 197	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   263: aload_2
    //   264: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   267: aload_0
    //   268: invokestatic 206	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   271: pop
    //   272: aload_0
    //   273: getfield 209	android/graphics/BitmapFactory$Options:outWidth	I
    //   276: istore 4
    //   278: aload_0
    //   279: getfield 212	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: istore 5
    //   284: aload_2
    //   285: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   288: invokestatic 218	aoop:eI	(Ljava/lang/String;)I
    //   291: istore 7
    //   293: iload 7
    //   295: bipush 90
    //   297: if_icmpeq +11 -> 308
    //   300: iload 7
    //   302: sipush 270
    //   305: if_icmpne +15 -> 320
    //   308: aload_0
    //   309: getfield 212	android/graphics/BitmapFactory$Options:outHeight	I
    //   312: istore 4
    //   314: aload_0
    //   315: getfield 209	android/graphics/BitmapFactory$Options:outWidth	I
    //   318: istore 5
    //   320: iload 4
    //   322: iload 5
    //   324: invokestatic 163	xpw:b	(II)[I
    //   327: astore_0
    //   328: aload_0
    //   329: iconst_0
    //   330: iaload
    //   331: istore 4
    //   333: aload_0
    //   334: iconst_1
    //   335: iaload
    //   336: istore 5
    //   338: new 220	java/io/BufferedInputStream
    //   341: dup
    //   342: new 222	java/io/FileInputStream
    //   345: dup
    //   346: aload_2
    //   347: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: aload_1
    //   357: invokestatic 234	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: iload 6
    //   366: invokevirtual 239	android/graphics/Bitmap:setDensity	(I)V
    //   369: aload_1
    //   370: astore_0
    //   371: aload_2
    //   372: invokevirtual 242	android/graphics/Bitmap:getWidth	()I
    //   375: iload 4
    //   377: if_icmpne +14 -> 391
    //   380: aload_1
    //   381: astore_0
    //   382: aload_2
    //   383: invokevirtual 245	android/graphics/Bitmap:getHeight	()I
    //   386: iload 5
    //   388: if_icmpeq +401 -> 789
    //   391: aload_1
    //   392: astore_0
    //   393: aload_2
    //   394: invokevirtual 242	android/graphics/Bitmap:getWidth	()I
    //   397: ifeq +392 -> 789
    //   400: aload_1
    //   401: astore_0
    //   402: aload_2
    //   403: invokevirtual 245	android/graphics/Bitmap:getHeight	()I
    //   406: ifeq +383 -> 789
    //   409: aload_1
    //   410: astore_0
    //   411: new 247	android/graphics/Matrix
    //   414: dup
    //   415: invokespecial 248	android/graphics/Matrix:<init>	()V
    //   418: astore 9
    //   420: aload_1
    //   421: astore_0
    //   422: aload 9
    //   424: iload 4
    //   426: i2f
    //   427: aload_2
    //   428: invokevirtual 242	android/graphics/Bitmap:getWidth	()I
    //   431: i2f
    //   432: fdiv
    //   433: iload 5
    //   435: i2f
    //   436: aload_2
    //   437: invokevirtual 245	android/graphics/Bitmap:getHeight	()I
    //   440: i2f
    //   441: fdiv
    //   442: invokevirtual 252	android/graphics/Matrix:setScale	(FF)V
    //   445: aload_1
    //   446: astore_0
    //   447: aload_2
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_2
    //   451: invokevirtual 242	android/graphics/Bitmap:getWidth	()I
    //   454: aload_2
    //   455: invokevirtual 245	android/graphics/Bitmap:getHeight	()I
    //   458: aload 9
    //   460: iconst_0
    //   461: invokestatic 256	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   464: astore 9
    //   466: aload_1
    //   467: astore_0
    //   468: aload 9
    //   470: iload 6
    //   472: invokevirtual 239	android/graphics/Bitmap:setDensity	(I)V
    //   475: aload_1
    //   476: astore_0
    //   477: aload_2
    //   478: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   481: aload 9
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: new 261	android/graphics/drawable/BitmapDrawable
    //   489: dup
    //   490: aload 10
    //   492: aload_2
    //   493: fload_3
    //   494: iload 4
    //   496: iload 5
    //   498: invokestatic 265	aqhu:c	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   501: invokespecial 268	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   504: astore 9
    //   506: aload_1
    //   507: astore_0
    //   508: aload_2
    //   509: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   512: aload_1
    //   513: astore_0
    //   514: getstatic 36	xpw:j	Landroid/support/v4/util/LruCache;
    //   517: aload 8
    //   519: aload 9
    //   521: invokevirtual 183	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload 9
    //   527: astore_0
    //   528: aload_1
    //   529: ifnull -441 -> 88
    //   532: aload_1
    //   533: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   536: aload 9
    //   538: areturn
    //   539: astore_1
    //   540: aload_1
    //   541: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   544: aload 9
    //   546: astore_0
    //   547: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -462 -> 88
    //   553: ldc_w 278
    //   556: iconst_2
    //   557: ldc_w 280
    //   560: aload_1
    //   561: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload 9
    //   566: areturn
    //   567: iconst_1
    //   568: aload_0
    //   569: invokevirtual 167	android/graphics/Rect:width	()I
    //   572: aload_0
    //   573: invokevirtual 170	android/graphics/Rect:height	()I
    //   576: invokestatic 287	xpw:b	(III)Landroid/graphics/drawable/Drawable;
    //   579: astore_0
    //   580: aload_0
    //   581: areturn
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: iconst_1
    //   586: iload 4
    //   588: iload 5
    //   590: invokestatic 287	xpw:b	(III)Landroid/graphics/drawable/Drawable;
    //   593: astore_2
    //   594: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +14 -> 611
    //   600: ldc_w 278
    //   603: iconst_2
    //   604: ldc_w 289
    //   607: aload_0
    //   608: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: aload_2
    //   612: astore_0
    //   613: aload_1
    //   614: ifnull -526 -> 88
    //   617: aload_1
    //   618: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   621: aload_2
    //   622: areturn
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   628: aload_2
    //   629: astore_0
    //   630: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq -545 -> 88
    //   636: ldc_w 278
    //   639: iconst_2
    //   640: ldc_w 280
    //   643: aload_1
    //   644: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   647: aload_2
    //   648: areturn
    //   649: astore_2
    //   650: aconst_null
    //   651: astore_1
    //   652: aload_1
    //   653: astore_0
    //   654: iconst_1
    //   655: iload 4
    //   657: iload 5
    //   659: invokestatic 287	xpw:b	(III)Landroid/graphics/drawable/Drawable;
    //   662: astore 8
    //   664: aload_1
    //   665: astore_0
    //   666: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +16 -> 685
    //   672: aload_1
    //   673: astore_0
    //   674: ldc_w 278
    //   677: iconst_2
    //   678: ldc_w 291
    //   681: aload_2
    //   682: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload 8
    //   687: astore_0
    //   688: aload_1
    //   689: ifnull -601 -> 88
    //   692: aload_1
    //   693: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   696: aload 8
    //   698: areturn
    //   699: astore_1
    //   700: aload_1
    //   701: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   704: aload 8
    //   706: astore_0
    //   707: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -622 -> 88
    //   713: ldc_w 278
    //   716: iconst_2
    //   717: ldc_w 280
    //   720: aload_1
    //   721: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: aload 8
    //   726: areturn
    //   727: astore_1
    //   728: aconst_null
    //   729: astore_0
    //   730: aload_0
    //   731: ifnull +7 -> 738
    //   734: aload_0
    //   735: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   738: aload_1
    //   739: athrow
    //   740: astore_0
    //   741: aload_0
    //   742: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   745: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -10 -> 738
    //   751: ldc_w 278
    //   754: iconst_2
    //   755: ldc_w 280
    //   758: aload_0
    //   759: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   762: goto -24 -> 738
    //   765: astore_1
    //   766: goto -36 -> 730
    //   769: astore_2
    //   770: aload_1
    //   771: astore_0
    //   772: aload_2
    //   773: astore_1
    //   774: goto -44 -> 730
    //   777: astore_2
    //   778: goto -126 -> 652
    //   781: astore_0
    //   782: goto -197 -> 585
    //   785: astore_0
    //   786: goto -577 -> 209
    //   789: goto -305 -> 484
    //   792: goto -579 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	paramContext	Context
    //   0	795	1	paramapcy	apcy
    //   0	795	2	paramMessageForTroopFile	MessageForTroopFile
    //   48	446	3	f	float
    //   276	380	4	i	int
    //   282	376	5	k	int
    //   37	434	6	m	int
    //   291	15	7	n	int
    //   4	721	8	localObject1	Object
    //   418	147	9	localObject2	Object
    //   27	464	10	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   161	178	205	java/lang/Exception
    //   182	203	205	java/lang/Exception
    //   567	580	205	java/lang/Exception
    //   532	536	539	java/lang/Exception
    //   338	354	582	java/lang/OutOfMemoryError
    //   617	621	623	java/lang/Exception
    //   338	354	649	java/lang/Exception
    //   692	696	699	java/lang/Exception
    //   338	354	727	finally
    //   734	738	740	java/lang/Exception
    //   356	361	765	finally
    //   363	369	765	finally
    //   371	380	765	finally
    //   382	391	765	finally
    //   393	400	765	finally
    //   402	409	765	finally
    //   411	420	765	finally
    //   422	445	765	finally
    //   447	466	765	finally
    //   468	475	765	finally
    //   477	481	765	finally
    //   486	506	765	finally
    //   508	512	765	finally
    //   514	525	765	finally
    //   654	664	765	finally
    //   666	672	765	finally
    //   674	685	765	finally
    //   585	611	769	finally
    //   356	361	777	java/lang/Exception
    //   363	369	777	java/lang/Exception
    //   371	380	777	java/lang/Exception
    //   382	391	777	java/lang/Exception
    //   393	400	777	java/lang/Exception
    //   402	409	777	java/lang/Exception
    //   411	420	777	java/lang/Exception
    //   422	445	777	java/lang/Exception
    //   447	466	777	java/lang/Exception
    //   468	475	777	java/lang/Exception
    //   477	481	777	java/lang/Exception
    //   486	506	777	java/lang/Exception
    //   508	512	777	java/lang/Exception
    //   514	525	777	java/lang/Exception
    //   356	361	781	java/lang/OutOfMemoryError
    //   363	369	781	java/lang/OutOfMemoryError
    //   371	380	781	java/lang/OutOfMemoryError
    //   382	391	781	java/lang/OutOfMemoryError
    //   393	400	781	java/lang/OutOfMemoryError
    //   402	409	781	java/lang/OutOfMemoryError
    //   411	420	781	java/lang/OutOfMemoryError
    //   422	445	781	java/lang/OutOfMemoryError
    //   447	466	781	java/lang/OutOfMemoryError
    //   468	475	781	java/lang/OutOfMemoryError
    //   477	481	781	java/lang/OutOfMemoryError
    //   486	506	781	java/lang/OutOfMemoryError
    //   508	512	781	java/lang/OutOfMemoryError
    //   514	525	781	java/lang/OutOfMemoryError
    //   115	161	785	java/lang/Exception
  }
  
  private void a(apcy paramapcy, MessageForTroopFile paramMessageForTroopFile)
  {
    if (paramapcy != null)
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.filePath = paramapcy.LocalFile;
      localTeamWorkFileImportInfo.fileName = paramapcy.FileName;
      localTeamWorkFileImportInfo.dNS = ahav.getFileType(paramapcy.FileName);
      localTeamWorkFileImportInfo.isFromAIO = true;
      localTeamWorkFileImportInfo.dNQ = 1;
      localTeamWorkFileImportInfo.fileSize = paramMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.cjE = paramapcy.FilePath;
      localTeamWorkFileImportInfo.dNP = paramapcy.BusId;
      localTeamWorkFileImportInfo.troopUin = this.sessionInfo.troopUin;
      localTeamWorkFileImportInfo.peerUin = this.sessionInfo.aTl;
      if (paramapcy.Status != 12) {
        localTeamWorkFileImportInfo.cKX = true;
      }
      localTeamWorkFileImportInfo.peerType = 1;
      aoag.a(localTeamWorkFileImportInfo, this.mContext, this.app, localTeamWorkFileImportInfo.dNQ);
    }
  }
  
  public static Drawable b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return new afeg(BaseApplicationImpl.getApplication().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = aoop.am();
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new afeg(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = aoop.getFailedDrawable();
        }
      }
      else
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          return new afeg(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        }
        return null;
      }
      localObject = null;
    }
  }
  
  public static int[] b(int paramInt1, int paramInt2)
  {
    int k;
    int i;
    if (paramInt1 <= 383)
    {
      k = paramInt1;
      i = paramInt2;
      if (paramInt2 <= 383) {}
    }
    else
    {
      k = paramInt1;
      i = paramInt2;
      if (paramInt1 != 0)
      {
        k = paramInt1;
        i = paramInt2;
        if (paramInt2 != 0) {
          if (paramInt1 <= paramInt2) {
            break label105;
          }
        }
      }
    }
    int[] arrayOfInt;
    label105:
    for (float f1 = 383 / paramInt1;; f1 = 383 / paramInt2)
    {
      k = (int)(paramInt1 * f1);
      i = (int)(f1 * paramInt2);
      arrayOfInt = new int[2];
      if ((k != 0) && (i != 0)) {
        break;
      }
      arrayOfInt[0] = bWi;
      arrayOfInt[1] = (bWi * 9 / 16);
      return arrayOfInt;
    }
    if ((k < bWj) || (i < bWj)) {
      if (k < i)
      {
        f1 = bWj / k;
        k = bWj;
        i = (int)(f1 * i + 0.5F);
        paramInt1 = i;
        paramInt2 = k;
        if (i > bWi)
        {
          paramInt1 = bWi;
          paramInt2 = k;
        }
      }
    }
    for (;;)
    {
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      paramInt2 = (int)(bWj / i * k + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > bWi) {
        paramInt1 = bWi;
      }
      i = bWj;
      paramInt2 = paramInt1;
      paramInt1 = i;
      continue;
      if ((k < bWi) && (i < bWi))
      {
        paramInt2 = k;
        paramInt1 = i;
      }
      else
      {
        if (k > i)
        {
          f1 = bWi / k;
          label284:
          if (k <= i) {
            break label402;
          }
        }
        label402:
        for (float f2 = bWj / i;; f2 = bWj / k)
        {
          f1 = Math.max(f1, f2);
          paramInt1 = (int)(k * f1 + 0.5F);
          i = (int)(f1 * i + 0.5F);
          paramInt2 = paramInt1;
          if (paramInt1 < bWj) {
            paramInt2 = bWj;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > bWi) {
            paramInt1 = bWi;
          }
          paramInt2 = i;
          if (i < bWj) {
            paramInt2 = bWj;
          }
          if (paramInt2 <= bWi) {
            break label414;
          }
          i = bWi;
          paramInt2 = paramInt1;
          paramInt1 = i;
          break;
          f1 = bWi / i;
          break label284;
        }
        label414:
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
  }
  
  public static boolean u(ChatMessage paramChatMessage)
  {
    return ahav.getFileType(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean v(ChatMessage paramChatMessage)
  {
    return ahav.getFileType(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean w(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    return ((paramChatMessage.width == 0) || (paramChatMessage.height != 0)) || (ahav.getFileType(paramChatMessage.fileName) == 2);
  }
  
  void A(View paramView, boolean paramBoolean)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    paramView = a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramView;
    anot.a(this.app, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
    apcy localapcy = apsv.a(this.app, localMessageForTroopFile);
    if (localapcy.Status == 12) {
      apsd.y(localActivity, String.format(localActivity.getString(2131699539), new Object[] { apsv.oR(localapcy.FileName) }), 1);
    }
    do
    {
      return;
      switch (localapcy.Status)
      {
      case 4: 
      case 5: 
      default: 
        return;
      }
    } while (!paramBoolean);
    localIntent.putExtra(TroopFileProxyActivity.cjr, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.app.getCurrentAccountUin());
    return;
    localIntent.putExtra(TroopFileProxyActivity.cjr, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.app.getCurrentAccountUin());
    return;
    long l = Long.valueOf(this.sessionInfo.aTl).longValue();
    ahbr.a(this.app, this.mContext, this.sessionInfo, paramView, l, localapcy, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  public void J(ChatMessage paramChatMessage)
  {
    this.app.b().t(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.app.a().oy(this.app.a().y(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    boolean bool1 = u(paramChatMessage);
    boolean bool2 = w(paramChatMessage);
    if (bool1) {}
    while (bool2) {
      return paramView;
    }
    paramView = a(paramView, paramChatMessage);
    paramViewGroup = (BaseBubbleBuilder.e)wja.a(paramView);
    this.a.b(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    xpw.a locala = (xpw.a)paramViewGroup.getTag();
    if (locala.wU != null) {
      locala.wU.setVisibility(0);
    }
    if (locala.wV != null) {
      locala.wV.setVisibility(8);
    }
    if (locala.jdField_E_of_type_AndroidViewView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = locala.jdField_E_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = BaseChatItemLayout.bOh;
      localLayoutParams.height = -2;
      locala.jdField_E_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      a(locala, paramViewGroup, paramChatMessage);
      if (aTl) {}
      try
      {
        locala.jdField_E_of_type_JavaLangStringBuilder.append(locala.T.getText()).append(" ");
        locala.jdField_E_of_type_JavaLangStringBuilder.append(locala.U.getText());
        locala.jdField_E_of_type_JavaLangStringBuilder.append(locala.IX.getText());
        locala.jdField_E_of_type_JavaLangStringBuilder.append("按钮");
        paramViewGroup.setContentDescription(locala.jdField_E_of_type_JavaLangStringBuilder.toString());
        return paramViewGroup;
      }
      catch (Exception paramChatMessage) {}
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramChatMessage = (xpw.a)parame;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = new RelativeLayout(this.mContext);
    }
    return paramChatMessage;
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    return paramaqoa;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xpw.a();
  }
  
  protected MessageForTroopFile a(View paramView)
  {
    paramView = (wko.a)wja.a(paramView);
    if (paramView.mMessage.isMultiMsg) {
      return (MessageForTroopFile)ahav.e(paramView.mMessage);
    }
    return (MessageForTroopFile)paramView.mMessage;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject3 = TroopFileTransferManager.a(this.app, Long.parseLong(paramChatMessage.frienduin));
    if (localObject3 == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject4;
    label1518:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i;
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject1 = (MessageForTroopFile)paramChatMessage;
                              localObject2 = apsv.a(this.app, (MessageForTroopFile)localObject1);
                            } while (localObject2 == null);
                            i = aqiw.getSystemNetwork((Activity)paramContext);
                            localObject4 = new apca(Long.parseLong(paramChatMessage.frienduin), this.app, (Activity)paramContext);
                            switch (paramInt)
                            {
                            default: 
                              super.a(paramInt, paramContext, paramChatMessage);
                              return;
                            case 2131374449: 
                              if (i == 0)
                              {
                                apsd.ck(paramContext, this.mContext.getString(2131699827));
                                return;
                              }
                              anot.a(this.app, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                            }
                          } while (((apcy)localObject2).Status != 8);
                          ((TroopFileTransferManager)localObject3).d(((apcy)localObject2).Id);
                          return;
                          if (i == 0)
                          {
                            apsd.ck(paramContext, this.mContext.getString(2131699827));
                            return;
                          }
                          anot.a(this.app, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                        } while ((((apcy)localObject2).Status != 0) && (((apcy)localObject2).Status != 1));
                        ((TroopFileTransferManager)localObject3).a(((apcy)localObject2).Id);
                        return;
                      } while (((apcy)localObject2).Status != 9);
                      ((apca)localObject4).b(((apcy)localObject2).Id);
                      return;
                    } while (((apcy)localObject2).Status != 2);
                    ((apca)localObject4).a(((apcy)localObject2).Id);
                    return;
                  } while ((((apcy)localObject2).Status != 8) && (((apcy)localObject2).Status != 9) && (((apcy)localObject2).Status != 10));
                  ((TroopFileTransferManager)localObject3).d(((apcy)localObject2).Id);
                  a(((apcy)localObject2).TroopUin, (Activity)paramContext, ((apcy)localObject2).Id);
                  return;
                  if (i == 0)
                  {
                    apsd.ck(paramContext, this.mContext.getString(2131699827));
                    return;
                  }
                } while ((((apcy)localObject2).Status != 1) && (((apcy)localObject2).Status != 0) && (((apcy)localObject2).Status != 2) && (((apcy)localObject2).Status != 3));
                ((TroopFileTransferManager)localObject3).a(((apcy)localObject2).Id);
                a(((apcy)localObject2).TroopUin, (Activity)paramContext, ((apcy)localObject2).Id, paramChatMessage);
                return;
                if (i == 0)
                {
                  apsd.ck(paramContext, this.mContext.getString(2131699827));
                  return;
                }
                paramContext = new Bundle();
                paramContext.putInt("forward_type", 0);
                localObject3 = ahav.a((apcy)localObject2);
                ((FileManagerEntity)localObject3).status = 2;
                ((FileManagerEntity)localObject3).nOpType = 24;
                localObject4 = new ForwardFileInfo();
                ((ForwardFileInfo)localObject4).p(((FileManagerEntity)localObject3).nSessionId);
                ((ForwardFileInfo)localObject4).setType(10006);
                if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
                  ((ForwardFileInfo)localObject4).setLocalPath(((apcy)localObject2).LocalFile);
                }
                ((ForwardFileInfo)localObject4).setFileName(((apcy)localObject2).FileName);
                ((ForwardFileInfo)localObject4).setFileSize(((apcy)localObject2).ProgressTotal);
                ((ForwardFileInfo)localObject4).jA(Long.parseLong(paramChatMessage.frienduin));
                if (((apcy)localObject2).Id != null) {
                  ((ForwardFileInfo)localObject4).Ja(((apcy)localObject2).Id.toString());
                }
                if (!TextUtils.isEmpty(((apcy)localObject2).ThumbnailFile_Large)) {
                  ((ForwardFileInfo)localObject4).aA(((apcy)localObject2).ThumbnailFile_Large);
                }
                for (;;)
                {
                  ((ForwardFileInfo)localObject4).Oj(1);
                  ((ForwardFileInfo)localObject4).Oh(1);
                  paramContext.putParcelable("fileinfo", (Parcelable)localObject4);
                  paramContext.putBoolean("not_forward", true);
                  paramContext.putInt("selection_mode", this.bOY);
                  paramChatMessage = new Intent();
                  paramChatMessage.putExtras(paramContext);
                  paramChatMessage.putExtra("forward_text", ((apcy)localObject2).FileName);
                  paramChatMessage.putExtra("forward_from_troop_file", true);
                  paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
                  paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
                  paramChatMessage.putExtra("forward _key_nojump", true);
                  paramChatMessage.putExtra("sender_uin", ((MessageForTroopFile)localObject1).senderuin);
                  paramChatMessage.putExtra("last_time", ((MessageForTroopFile)localObject1).lastTime);
                  ahgq.f((Activity)this.mContext, paramChatMessage, 21);
                  if (((MessageForTroopFile)localObject1).isMultiMsg) {
                    anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
                  }
                  anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
                  return;
                  if (!TextUtils.isEmpty(((apcy)localObject2).coc)) {
                    ((ForwardFileInfo)localObject4).aA(((apcy)localObject2).coc);
                  }
                }
                apsv.d((Activity)this.mContext, this.app, paramChatMessage);
                return;
                ahav.by((Activity)paramContext, ((apcy)localObject2).LocalFile);
                return;
              } while (((apcy)localObject2).Status != 3);
              ((apca)localObject4).a(((apcy)localObject2).Id);
              return;
            } while (((apcy)localObject2).Status != 10);
            ((apca)localObject4).b(((apcy)localObject2).Id);
            return;
            anot.a(this.app, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
          } while ((localObject2 != null) && (((apcy)localObject2).Status != 7));
          ((apca)localObject4).i(((apcy)localObject2).FilePath, ((apcy)localObject2).FileName, ((apcy)localObject2).ProgressTotal, ((apcy)localObject2).BusId);
          return;
          anot.a(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          apsv.c(this.mContext, this.app, paramChatMessage);
          return;
          paramContext = ahav.a((apcy)localObject2);
          localObject2 = apsf.a(this.app, ((apcy)localObject2).TroopUin).a(paramContext.strTroopFilePath);
          if (localObject2 != null)
          {
            paramContext.lastTime = ((apbr)localObject2).dTh;
            paramContext.selfUin = String.valueOf(((apbr)localObject2).aqT);
          }
          new aviz(3).a(this.app, (Activity)this.mContext, paramContext, paramChatMessage, false);
        } while (!((MessageForTroopFile)localObject1).isMultiMsg);
        anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
        return;
        super.m(paramChatMessage);
        return;
        localObject2 = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
        localObject1 = "2";
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          if ((((TroopInfo)localObject2).troopowneruin != null) && (((TroopInfo)localObject2).troopowneruin.equals(this.app.getCurrentAccountUin()))) {
            paramContext = "1";
          }
        }
        else
        {
          if (!v(paramChatMessage)) {
            break label1518;
          }
          localObject1 = "1";
        }
        for (;;)
        {
          anot.a(this.app, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.sessionInfo.aTl, "", paramContext, (String)localObject1);
          j(paramChatMessage);
          return;
          paramContext = (Context)localObject1;
          if (((TroopInfo)localObject2).Administrator == null) {
            break;
          }
          paramContext = (Context)localObject1;
          if (!((TroopInfo)localObject2).Administrator.equals(this.app.getCurrentAccountUin())) {
            break;
          }
          paramContext = "2";
          break;
          if (w(paramChatMessage)) {
            localObject1 = "2";
          } else {
            localObject1 = "3";
          }
        }
      } while (localObject2 == null);
      a((apcy)localObject2, (MessageForTroopFile)localObject1);
      anot.a(this.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!((MessageForTroopFile)localObject1).isMultiMsg);
    anot.a(this.app, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    ApolloUtil.a(((apcy)localObject2).FileName, ((apcy)localObject2).LocalFile, new xpz(this, (apcy)localObject2, (apca)localObject4));
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new xpx(this, paramLong, paramUUID, paramActivity);
    aqha.a(paramActivity, 230, this.mContext.getString(2131699498), this.mContext.getString(2131699520), 2131699496, 2131699507, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new xpy(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    aqha.a(paramActivity, 230, this.mContext.getString(2131699502), this.mContext.getString(2131699521), 2131699500, 2131699509, paramUUID, paramUUID).show();
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    boolean bool1 = u(paramChatMessage);
    boolean bool2 = w(paramChatMessage);
    if ((!bool1) && (!bool2) && (parame.jdField_E_of_type_AndroidViewView != null))
    {
      if (paramChatMessage.isSend()) {
        parame.jdField_E_of_type_AndroidViewView.setBackgroundResource(2130851006);
      }
    }
    else {
      return;
    }
    parame.jdField_E_of_type_AndroidViewView.setBackgroundResource(2130850829);
  }
  
  public void a(xpw.a parama, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (parama.Jq == null)
    {
      parama.Jq = new TextView(this.mContext);
      parama.Jq.setBackgroundResource(2130843454);
      parama.Jq.setTextSize(1, 12.0F);
      parama.Jq.setTextColor(this.mContext.getResources().getColor(2131167654));
      parama.Jq.setText(2131699437);
      parama.Jq.setSingleLine();
      parama.Jq.setGravity(16);
      parama.Jq.setPadding(aqcx.dip2px(this.mContext, 5.0F), 0, aqcx.dip2px(this.mContext, 5.0F), 0);
      parama.Jq.setOnClickListener(this.mSourceOnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364503);
      this.mContext.getResources().getDimensionPixelSize(2131296407);
      aqcx.dip2px(this.mContext, 10.0F);
      paramViewGroup.addView(parama.Jq, localLayoutParams);
    }
    parama.Jq.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)parama.Jq.getLayoutParams();
      paramViewGroup.addRule(7, 2131364503);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.mContext.getResources().getDimensionPixelSize(2131296407) + aqcx.dip2px(this.mContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      parama.Jq.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)parama.Jq.getLayoutParams();
    paramViewGroup.addRule(5, 2131364503);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.mContext.getResources().getDimensionPixelSize(2131296407) + aqcx.dip2px(this.mContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    parama.Jq.setLayoutParams(paramViewGroup);
  }
  
  public aqob[] a(View paramView)
  {
    this.wS = paramView;
    aqoa localaqoa = new aqoa();
    paramView = a(paramView);
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label43;
      }
      a(localaqoa, paramView, null);
    }
    for (;;)
    {
      return localaqoa.a();
      label43:
      b(localaqoa, paramView, null);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    return paramaqoa;
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131715673);
    }
    return acfp.m(2131715677);
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    A((View)paramView.getParent(), true);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = wja.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
      }
      else if (!xpw.a.class.isInstance(localObject))
      {
        QLog.e("TroopFileItemBuilder", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
      }
      else
      {
        anot.a(this.app, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
        localObject = (xpw.a)localObject;
        localObject = a(paramView);
        if ((!u((ChatMessage)localObject)) && (!w((ChatMessage)localObject)) && ((!((MessageForTroopFile)localObject).isMultiMsg) || (ahav.a((ChatMessage)localObject, this.app, this.mContext))))
        {
          A(paramView, false);
          wja.bcO = true;
        }
      }
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public TextView IX;
    public TextView Jq;
    public TextView T;
    public TextView U;
    public View wU;
    public View wV;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpw
 * JD-Core Version:    0.7.0.1
 */