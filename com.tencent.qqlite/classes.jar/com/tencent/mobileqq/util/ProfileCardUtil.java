package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import esi;
import esj;
import esk;
import esn;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.AccountManager;
import pttcenterservice.PttCenter.ServerListInfo;

public class ProfileCardUtil
{
  public static final String A = "VIP_profilecard";
  public static final String B = "profileCardDownload";
  public static final String C = "profileCardSet";
  public static final String D = "profileCardGet";
  public static final String E = "profileCardSendFavorite";
  public static final String F = "profileCardTimeStat";
  public static final String G = "inside.myCardBackground";
  public static final String H = "inside.blackBar";
  public static final String I = "inside.friendCardBackground";
  public static final String J = "1";
  public static final String K = "2";
  public static final String L = "pttcenter_filepath";
  public static final String M = "pttcenter_shDuration";
  public static final String N = "pttcenter_cmd";
  public static final String O = "pttcenter_filekey";
  public static final String P = "pttcenter_selfuin";
  public static final String Q = "pttcenter_targetuin";
  public static final String R = "pttcenter_voice_optype";
  private static String S = null;
  public static final int a = 100;
  public static final long a = 0L;
  public static final String a = "Q.profilecard.Troop";
  protected static HashMap a;
  public static final boolean a = true;
  public static final int b = 640;
  protected static long b = 0L;
  public static final String b = "Q.profilecard.SummaryCard";
  private static boolean b = false;
  public static final int c = 482;
  private static final long c = 614400L;
  public static final String c = "Q.profilecard.FrdProfileCard";
  public static final int d = -1;
  public static final String d = "Q.profilecard.MicroPhone";
  public static final int e = 1;
  public static final String e = "Q.profilecard.VoicePlayer";
  public static final int f = 2;
  public static final String f = "Q.profilecard.Avatar";
  public static final int g = 0;
  public static final String g = "Q.profilecard.TResource";
  public static final int h = 1;
  public static final String h = "Q.profilecard.VoiceIntro";
  public static final int i = 2;
  public static final String i = "Q.profilecard.PhotoWall";
  public static final int j = 3;
  public static final String j = "Q.profilecard.PhotoWall.Bg";
  public static final int k = 4;
  public static final String k = "Q.profilecard.Detail";
  public static final int l = 5;
  public static final String l = "Q.profilecard.PhotoWall.Trans";
  public static final int m = 6;
  public static final String m = "Q.profilecard.VoiceIntro.Trans";
  public static final int n = 7;
  public static final String n = "Q.profilecard.Visitor";
  public static final int o = 8;
  public static final String o = "ProfileCard.setcard";
  public static final int p = 9;
  public static final String p = "mvip.gongneng.android.mingpian_zhuangbanopen";
  public static final int q = 10;
  public static final String q = "mvip.gongneng.android.mingpian_urlopen";
  public static final int r = 11;
  public static final String r = "profilecard";
  public static final int s = 12;
  public static final String s = "labelList";
  public static final int t = 13;
  public static final String t = "profilecard_sp_file";
  public static final int u = 14;
  public static final String u = "user_visited_profile_browser";
  public static final int v = 15;
  public static final String v = "http://imgcache.qq.com/club/client/card/rel/mall.html?_bid=238&closeSpecialLogic=1&ADTAG=%1$s&sid=%2$s&isCache=%3$s&entryId=%4$s&_wv=5123";
  public static final int w = 16;
  public static final String w = "0X8004436";
  public static final String x = "0X8004437";
  public static final String y = "0X80044DF";
  public static final String z = "0X80044E0";
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(640, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static final int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i1 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i1;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i1 = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i1;
      if ((paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 21)) {
        i1 = 1000;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42)) {
        i1 = 1001;
      } else if (paramAllInOne.jdField_a_of_type_Int == 3) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 2) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 74) {
        i1 = 1023;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 32) || (paramAllInOne.jdField_a_of_type_Int == 31) || (paramAllInOne.jdField_a_of_type_Int == 51) || (paramAllInOne.jdField_a_of_type_Int == 50) || (paramAllInOne.jdField_a_of_type_Int == 34)) {
        i1 = 1006;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47)) {
        i1 = 1004;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57)) {
        i1 = 1009;
      } else if (paramAllInOne.jdField_a_of_type_Int == 58) {
        i1 = 1020;
      } else if (paramAllInOne.jdField_a_of_type_Int != 70) {
        if (paramAllInOne.jdField_a_of_type_Int == 27) {
          i1 = 1022;
        } else {
          i1 = 1001;
        }
      }
    }
  }
  
  public static long a()
  {
    return System.currentTimeMillis() - jdField_b_of_type_Long;
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return MediaPlayer.create(paramContext, Uri.parse(paramString)).getDuration() / 1000;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.c != null) && (paramAllInOne.c.length() > 0)) {
      paramQQAppInterface = paramAllInOne.c;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l1 = Long.valueOf(paramAllInOne).longValue();
        return l1;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.d != null) && (paramAllInOne.d.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.d });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  /* Error */
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +66 -> 67
    //   4: new 347	android/text/SpannableString
    //   7: dup
    //   8: ldc_w 349
    //   11: invokespecial 352	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   14: astore 10
    //   16: aload_0
    //   17: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 353
    //   23: invokevirtual 357	android/content/res/Resources:getDimension	(I)F
    //   26: f2i
    //   27: istore_1
    //   28: aload_0
    //   29: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: ldc_w 358
    //   35: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: iconst_0
    //   42: iload_1
    //   43: iload_1
    //   44: invokevirtual 368	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   47: aload 10
    //   49: new 370	android/text/style/ImageSpan
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 373	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   57: iconst_0
    //   58: iconst_1
    //   59: bipush 33
    //   61: invokevirtual 377	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   64: aload 10
    //   66: areturn
    //   67: iload_2
    //   68: bipush 64
    //   70: idiv
    //   71: istore 6
    //   73: iload_2
    //   74: bipush 64
    //   76: irem
    //   77: istore_2
    //   78: iload_2
    //   79: bipush 16
    //   81: idiv
    //   82: istore 7
    //   84: iload_2
    //   85: bipush 16
    //   87: irem
    //   88: istore 9
    //   90: iload 9
    //   92: iconst_4
    //   93: idiv
    //   94: istore 8
    //   96: ldc_w 379
    //   99: astore 11
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: iconst_4
    //   107: if_icmpge +136 -> 243
    //   110: iconst_0
    //   111: istore_2
    //   112: ldc_w 379
    //   115: astore 10
    //   117: iload 4
    //   119: tableswitch	default:+29 -> 148, 0:+69->188, 1:+80->199, 2:+91->210, 3:+102->221
    //   149: istore 5
    //   151: iload 5
    //   153: iload_2
    //   154: if_icmpge +80 -> 234
    //   157: new 381	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   164: aload 11
    //   166: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 10
    //   171: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 11
    //   179: iload 5
    //   181: iconst_1
    //   182: iadd
    //   183: istore 5
    //   185: goto -34 -> 151
    //   188: ldc_w 392
    //   191: astore 10
    //   193: iload 6
    //   195: istore_2
    //   196: goto -48 -> 148
    //   199: ldc_w 394
    //   202: astore 10
    //   204: iload 7
    //   206: istore_2
    //   207: goto -59 -> 148
    //   210: ldc_w 396
    //   213: astore 10
    //   215: iload 8
    //   217: istore_2
    //   218: goto -70 -> 148
    //   221: ldc_w 398
    //   224: astore 10
    //   226: iload 9
    //   228: iconst_4
    //   229: irem
    //   230: istore_2
    //   231: goto -83 -> 148
    //   234: iload 4
    //   236: iconst_1
    //   237: iadd
    //   238: istore 4
    //   240: goto -136 -> 104
    //   243: iload_3
    //   244: ifeq +489 -> 733
    //   247: aload 11
    //   249: invokevirtual 306	java/lang/String:length	()I
    //   252: iload_1
    //   253: if_icmple +480 -> 733
    //   256: aload 11
    //   258: iconst_0
    //   259: iload_1
    //   260: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   263: astore 10
    //   265: aload 10
    //   267: astore 14
    //   269: new 347	android/text/SpannableString
    //   272: dup
    //   273: aload 14
    //   275: invokespecial 352	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   278: astore 16
    //   280: aload_0
    //   281: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   284: ldc_w 353
    //   287: invokevirtual 357	android/content/res/Resources:getDimension	(I)F
    //   290: f2i
    //   291: istore 4
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: aload 14
    //   298: invokevirtual 306	java/lang/String:length	()I
    //   301: if_icmpge +404 -> 705
    //   304: aconst_null
    //   305: astore 13
    //   307: aconst_null
    //   308: astore 15
    //   310: aconst_null
    //   311: astore 12
    //   313: iload_2
    //   314: iload_1
    //   315: iconst_1
    //   316: isub
    //   317: if_icmpne +97 -> 414
    //   320: iload_3
    //   321: iconst_1
    //   322: if_icmpne +92 -> 414
    //   325: aload 13
    //   327: astore 10
    //   329: aload 15
    //   331: astore 11
    //   333: aload_0
    //   334: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 403
    //   340: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   343: astore 12
    //   345: aload 12
    //   347: ifnull +50 -> 397
    //   350: aload 12
    //   352: astore 10
    //   354: aload 12
    //   356: astore 11
    //   358: aload 12
    //   360: iconst_0
    //   361: iconst_0
    //   362: iload 4
    //   364: iload 4
    //   366: invokevirtual 368	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   369: aload 12
    //   371: astore 10
    //   373: aload 12
    //   375: astore 11
    //   377: aload 16
    //   379: new 370	android/text/style/ImageSpan
    //   382: dup
    //   383: aload 12
    //   385: invokespecial 373	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   388: iload_2
    //   389: iload_2
    //   390: iconst_1
    //   391: iadd
    //   392: bipush 33
    //   394: invokevirtual 377	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   397: aload 16
    //   399: areturn
    //   400: astore 10
    //   402: aload 10
    //   404: invokevirtual 406	java/lang/Exception:printStackTrace	()V
    //   407: aload 11
    //   409: astore 14
    //   411: goto -142 -> 269
    //   414: aload 13
    //   416: astore 10
    //   418: aload 15
    //   420: astore 11
    //   422: ldc_w 392
    //   425: aload 14
    //   427: iload_2
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   434: invokevirtual 410	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   437: ifeq +23 -> 460
    //   440: aload 13
    //   442: astore 10
    //   444: aload 15
    //   446: astore 11
    //   448: aload_0
    //   449: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 411
    //   455: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   458: astore 12
    //   460: aload 12
    //   462: astore 13
    //   464: aload 12
    //   466: astore 10
    //   468: aload 12
    //   470: astore 11
    //   472: ldc_w 394
    //   475: aload 14
    //   477: iload_2
    //   478: iload_2
    //   479: iconst_1
    //   480: iadd
    //   481: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: invokevirtual 410	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   487: ifeq +23 -> 510
    //   490: aload 12
    //   492: astore 10
    //   494: aload 12
    //   496: astore 11
    //   498: aload_0
    //   499: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   502: ldc_w 412
    //   505: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   508: astore 13
    //   510: aload 13
    //   512: astore 10
    //   514: aload 13
    //   516: astore 11
    //   518: ldc_w 396
    //   521: aload 14
    //   523: iload_2
    //   524: iload_2
    //   525: iconst_1
    //   526: iadd
    //   527: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   530: invokevirtual 410	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   533: ifeq +193 -> 726
    //   536: aload 13
    //   538: astore 10
    //   540: aload 13
    //   542: astore 11
    //   544: aload_0
    //   545: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   548: ldc_w 413
    //   551: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   554: astore 12
    //   556: aload 12
    //   558: astore 10
    //   560: aload 10
    //   562: astore 11
    //   564: ldc_w 398
    //   567: aload 14
    //   569: iload_2
    //   570: iload_2
    //   571: iconst_1
    //   572: iadd
    //   573: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   576: invokevirtual 410	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +15 -> 594
    //   582: aload_0
    //   583: invokevirtual 222	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   586: ldc_w 414
    //   589: invokevirtual 362	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   592: astore 11
    //   594: aload 11
    //   596: astore 10
    //   598: aload 10
    //   600: ifnull +34 -> 634
    //   603: aload 10
    //   605: iconst_0
    //   606: iconst_0
    //   607: iload 4
    //   609: iload 4
    //   611: invokevirtual 368	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   614: aload 16
    //   616: new 370	android/text/style/ImageSpan
    //   619: dup
    //   620: aload 10
    //   622: invokespecial 373	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   625: iload_2
    //   626: iload_2
    //   627: iconst_1
    //   628: iadd
    //   629: bipush 33
    //   631: invokevirtual 377	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   634: iload_2
    //   635: iconst_1
    //   636: iadd
    //   637: istore_2
    //   638: goto -343 -> 295
    //   641: astore 12
    //   643: aload 10
    //   645: astore 11
    //   647: aload 11
    //   649: astore 10
    //   651: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -56 -> 598
    //   657: ldc 80
    //   659: iconst_2
    //   660: aload 12
    //   662: invokevirtual 421	java/lang/Error:toString	()Ljava/lang/String;
    //   665: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload 11
    //   670: astore 10
    //   672: goto -74 -> 598
    //   675: astore 12
    //   677: aload 11
    //   679: astore 10
    //   681: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq -86 -> 598
    //   687: ldc 80
    //   689: iconst_2
    //   690: aload 12
    //   692: invokevirtual 425	java/lang/Exception:toString	()Ljava/lang/String;
    //   695: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aload 11
    //   700: astore 10
    //   702: goto -104 -> 598
    //   705: aload 16
    //   707: areturn
    //   708: astore 12
    //   710: aload 10
    //   712: astore 11
    //   714: goto -37 -> 677
    //   717: astore 12
    //   719: aload 10
    //   721: astore 11
    //   723: goto -76 -> 647
    //   726: aload 13
    //   728: astore 10
    //   730: goto -170 -> 560
    //   733: aload 11
    //   735: astore 10
    //   737: goto -472 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	paramContext	Context
    //   0	740	1	paramInt1	int
    //   0	740	2	paramInt2	int
    //   0	740	3	paramBoolean	boolean
    //   102	508	4	i1	int
    //   149	35	5	i2	int
    //   71	123	6	i3	int
    //   82	123	7	i4	int
    //   94	122	8	i5	int
    //   88	142	9	i6	int
    //   14	358	10	localObject1	Object
    //   400	3	10	localException1	Exception
    //   416	320	10	localObject2	Object
    //   99	635	11	localObject3	Object
    //   311	246	12	localDrawable	Drawable
    //   641	20	12	localError1	java.lang.Error
    //   675	16	12	localException2	Exception
    //   708	1	12	localException3	Exception
    //   717	1	12	localError2	java.lang.Error
    //   305	422	13	localObject4	Object
    //   267	301	14	localObject5	Object
    //   308	137	15	localObject6	Object
    //   278	428	16	localSpannableString	SpannableString
    // Exception table:
    //   from	to	target	type
    //   247	265	400	java/lang/Exception
    //   333	345	641	java/lang/Error
    //   358	369	641	java/lang/Error
    //   377	397	641	java/lang/Error
    //   422	440	641	java/lang/Error
    //   448	460	641	java/lang/Error
    //   472	490	641	java/lang/Error
    //   498	510	641	java/lang/Error
    //   518	536	641	java/lang/Error
    //   544	556	641	java/lang/Error
    //   333	345	675	java/lang/Exception
    //   358	369	675	java/lang/Exception
    //   377	397	675	java/lang/Exception
    //   422	440	675	java/lang/Exception
    //   448	460	675	java/lang/Exception
    //   472	490	675	java/lang/Exception
    //   498	510	675	java/lang/Exception
    //   518	536	675	java/lang/Exception
    //   544	556	675	java/lang/Exception
    //   564	594	708	java/lang/Exception
    //   564	594	717	java/lang/Error
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    int i1 = 0;
    byte b2 = 1;
    for (;;)
    {
      FriendsManagerImp localFriendsManagerImp;
      try
      {
        localFriendsManagerImp = (FriendsManagerImp)paramQQAppInterface.getManager(8);
        if (localFriendsManagerImp == null) {
          break label404;
        }
        localObject1 = localFriendsManagerImp.c(paramString);
        paramQQAppInterface = localFriendsManagerImp.a(paramString);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = new Card();
          paramQQAppInterface.uin = paramString;
          paramQQAppInterface.shGender = -1;
          if (localObject1 != null)
          {
            paramQQAppInterface.strSign = ((Friends)localObject1).signature;
            paramQQAppInterface.strNick = ((Friends)localObject1).name;
            paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
            paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
            if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
            {
              b1 = 1;
              paramQQAppInterface.bQQVipOpen = b1;
              if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
              {
                b1 = 1;
                paramQQAppInterface.bSuperVipOpen = b1;
                if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                  continue;
                }
                b1 = b2;
                paramQQAppInterface.bSuperQQOpen = b1;
                paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
                paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
                paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
                paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
                paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
                paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
                paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
                if (localFriendsManagerImp == null) {
                  break label401;
                }
                localFriendsManagerImp.a(paramQQAppInterface);
                return paramQQAppInterface;
              }
            }
            else
            {
              b1 = 0;
              continue;
            }
            byte b1 = 0;
            continue;
            b1 = 0;
            continue;
          }
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
          continue;
        }
        if (localObject1 == null) {
          break label398;
        }
      }
      finally {}
      if (!Utils.a(((Friends)localObject1).signature, paramQQAppInterface.strSign))
      {
        paramQQAppInterface.strSign = ((Friends)localObject1).signature;
        i1 = 1;
      }
      if (!Utils.a(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
      {
        paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
        i1 = 1;
      }
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      if ((localFriendsManagerImp != null) && (i1 != 0)) {
        localFriendsManagerImp.a(paramQQAppInterface);
      }
      label398:
      continue;
      label401:
      continue;
      label404:
      Object localObject2 = null;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_uploading.jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return "水瓶";
    case 2: 
      return "双鱼";
    case 3: 
      return "白羊";
    case 4: 
      return "金牛";
    case 5: 
      return "双子";
    case 6: 
      return "巨蟹";
    case 7: 
      return "狮子";
    case 8: 
      return "处女";
    case 9: 
      return "天秤";
    case 10: 
      return "天蝎";
    case 11: 
      return "射手";
    }
    return "摩羯";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() ip = " + paramInt1 + ", port = " + paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramInt1 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    localStringBuilder.append(':').append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() url = " + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    if (Utils.e()) {
      return AppConstants.bn;
    }
    return paramContext.getDir("profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    int i2 = -1;
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i1;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      label60:
      String str;
      if (i1 == 0)
      {
        paramProfileCardInfo = paramContext.getString(2131363199);
        str = "";
        if (localCard == null) {
          break label485;
        }
        i1 = localCard.age;
        label76:
        if (i1 > 0) {
          str = i1 + paramContext.getString(2131363201);
        }
        localObject = "";
        if (localCard == null) {
          break label501;
        }
        paramContext = (Context)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramContext = (Context)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramContext = "" + localCard.strCountry;
          }
        }
        localObject = paramContext;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramContext;
          if (!TextUtils.isEmpty(paramContext)) {
            localObject = paramContext + " ";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramContext = (Context)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramContext = (String)localObject + " ";
          }
          paramContext = paramContext + localCard.strCity;
        }
      }
      for (;;)
      {
        localObject = paramProfileCardInfo;
        if (str != null)
        {
          localObject = paramProfileCardInfo;
          if (str.length() > 0) {
            localObject = paramProfileCardInfo + " " + str;
          }
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (paramContext != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (paramContext.length() > 0) {
            paramProfileCardInfo = (String)localObject + " " + paramContext;
          }
        }
        return paramProfileCardInfo;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i1 = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label709;
        }
        i1 = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i1 != 1) {
          break label60;
        }
        paramProfileCardInfo = paramContext.getString(2131363200);
        break label60;
        label485:
        i1 = i2;
        if (localContactCard == null) {
          break label76;
        }
        i1 = localContactCard.bAge;
        break label76;
        label501:
        paramContext = (Context)localObject;
        if (localContactCard != null)
        {
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramContext = (Context)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramContext = "" + localContactCard.strCountry;
            }
          }
          localObject = paramContext;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramContext;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject = paramContext + " ";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramContext = (String)localObject + " ";
            }
            paramContext = paramContext + localContactCard.strCity;
          }
        }
      }
      label709:
      i1 = -1;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return a(paramContext) + e(paramString);
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return paramQQAppInterface + File.separator + "common_" + "53";
    }
    return null;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    if (paramByteStringMicro != null)
    {
      byte[] arrayOfByte = new byte[paramByteStringMicro.size()];
      paramByteStringMicro.copyTo(arrayOfByte, 0);
      return c(HexUtil.a(arrayOfByte));
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, float paramFloat, TextPaint paramTextPaint)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int i2 = paramString.length();
    int i1 = i2 / 2;
    for (;;)
    {
      if ((i1 > 0) && (i1 < i2))
      {
        float f1 = paramTextPaint.measureText(paramString, 0, i1);
        if (paramFloat - f1 <= 10.0F) {
          break label135;
        }
        if (paramTextPaint.measureText(paramString, i1, i2) - f1 <= 0.1F) {}
      }
      else
      {
        if ((i1 <= 0) || (i1 >= i2)) {
          break;
        }
        paramTextPaint = new StringBuffer();
        paramTextPaint.append(paramString.substring(0, i1)).append("\n").append(paramString.substring(i1));
        return paramTextPaint.toString();
      }
      i1 -= 1;
      continue;
      label135:
      i1 -= 1;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString1 = MD5.toMD5(paramString1 + paramString2);
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("voice").append("/").append(paramString1).append(".amr");
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return c(HexUtil.a(paramArrayOfByte));
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      PttCenter.ServerListInfo localServerListInfo = (PttCenter.ServerListInfo)paramList.get(i1);
      if (localServerListInfo != null) {
        localArrayList.add(a(localServerListInfo.uint32_up_ip.get(), localServerListInfo.uint32_up_port.get()));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public static short a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    if (paramQQAppInterface == null) {
      return -1;
    }
    paramQQAppInterface = paramQQAppInterface.a(paramString);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.shGender;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    jdField_b_of_type_Boolean = false;
    S = null;
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 880);
    localIntent.putExtra("filekey", paramString2);
    localIntent.putExtra("index", paramInt);
    localIntent.putExtra("friendUin", paramString1);
    paramActivity.startActivityForResult(localIntent, 880);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", String.format("http://imgcache.qq.com/club/client/card/rel/mall.html?_bid=238&closeSpecialLogic=1&ADTAG=%1$s&sid=%2$s&isCache=%3$s&entryId=%4$s&_wv=5123", new Object[] { paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Resources paramResources, View paramView, StatusManager paramStatusManager, RichStatus paramRichStatus, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i2 = 0;
    TextView localTextView = (TextView)paramView.findViewById(2131296953);
    ImageView localImageView = (ImageView)paramView.findViewById(2131297744);
    if (paramRichStatus != null) {
      localObject1 = paramRichStatus.a(null, -8947849, paramResources.getColor(2131427354));
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SpannableString("");
    }
    int i1;
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.c)))
    {
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      if (paramStatusManager != null)
      {
        localObject1 = paramStatusManager.a(paramRichStatus.b, 200);
        localObject1 = new StatableBitmapDrawable(paramResources, (Bitmap)localObject1, false, false);
        i1 = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i1, i1);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, "[S]".length(), 17);
        localTextView.setText((CharSequence)localObject2);
        label209:
        if (!paramBoolean) {
          break label528;
        }
        if (paramStatusManager != null) {
          break label436;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label221:
      if (paramBoolean)
      {
        i1 = 2130837910;
        label231:
        paramResources = paramResources.getDrawable(i1);
        if (localImageView.getDrawable() != paramResources)
        {
          localImageView.setImageDrawable(paramResources);
          if ((paramResources instanceof Animatable)) {
            ((Animatable)paramResources).start();
          }
        }
        paramResources = "";
        if (paramRichStatus == null) {
          break label459;
        }
        if (paramRichStatus.c != null) {
          paramResources = "" + paramRichStatus.c;
        }
        paramStatusManager = paramResources;
        if (paramRichStatus.d != null) {
          paramStatusManager = paramResources + paramRichStatus.d;
        }
        if (paramRichStatus.jdField_a_of_type_JavaUtilArrayList == null) {
          break label453;
        }
        i1 = paramRichStatus.jdField_a_of_type_JavaUtilArrayList.size();
        label355:
        paramResources = paramStatusManager;
        label357:
        paramStatusManager = paramResources;
        if (i2 >= i1) {
          break label463;
        }
        paramStatusManager = (String)paramRichStatus.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (TextUtils.isEmpty(paramStatusManager)) {
          break label525;
        }
        paramResources = paramResources + paramStatusManager;
      }
      label525:
      for (;;)
      {
        i2 += 1;
        break label357;
        localObject1 = BitmapManager.a(paramResources, 2130839082);
        break;
        localTextView.setText((CharSequence)localObject2);
        break label209;
        label436:
        paramBoolean = paramStatusManager.a();
        break label221;
        i1 = 2130837716;
        break label231;
        label453:
        i1 = 0;
        break label355;
        label459:
        paramStatusManager = "";
        label463:
        if ((paramView.getTag() instanceof DataTag)) {
          ((DataTag)paramView.getTag()).a = paramStatusManager;
        }
        for (;;)
        {
          paramView.setContentDescription("个性签名是" + paramStatusManager);
          return;
          paramView.setTag(new DataTag(3, paramStatusManager));
        }
      }
      label528:
      paramBoolean = false;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    localQQProgressDialog.show();
    new Thread(new esk(paramBaseActivity, paramString2, paramBoolean, paramString1, paramString3, localQQProgressDialog)).start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    paramQQAppInterface.a(new esn(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject2 = ((FriendManager)localObject1).c(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).alias)))
      {
        str = ((Friends)localObject2).alias;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|f.alias = " + ((Friends)localObject2).alias);
          localObject1 = str;
        }
      }
    }
    for (;;)
    {
      if (Utils.a(paramString, paramQQAppInterface.a())) {}
      for (paramString = String.format("http://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-3.4.0", localObject1 });; paramString = String.format("http://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-3.4.0", localObject1 }))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Detail", 2, "openDetail() url = " + paramString);
        }
        localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramString);
        ((Intent)localObject1).putExtra("uin", paramQQAppInterface.a());
        ((Intent)localObject1).putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        ((Intent)localObject1).putExtra("reqType", 1);
        paramActivity.startActivity((Intent)localObject1);
        return;
        localObject2 = ((FriendManager)localObject1).a(paramString);
        if ((localObject2 == null) || (TextUtils.isEmpty(((Card)localObject2).strShowName))) {
          break label354;
        }
        str = ((Card)localObject2).strShowName;
        localObject1 = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|card.strShowName = " + ((Card)localObject2).strShowName);
        localObject1 = str;
        break;
      }
      label354:
      localObject1 = paramString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "removeAvatarFromCache, uin=" + paramString);
      }
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, a(paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "qq_error|" + paramQQAppInterface.toString());
    }
  }
  
  public static void a(ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test start");
    }
    String str1 = a(paramByteStringMicro);
    byte[] arrayOfByte1 = a(str1);
    String str2 = a(arrayOfByte1);
    byte[] arrayOfByte2 = new byte[paramByteStringMicro.size()];
    paramByteStringMicro.copyTo(arrayOfByte2, 0);
    if ((Utils.a(str1, str2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bs -> str : 相等");
    }
    if ((a(arrayOfByte1, arrayOfByte2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bsm -> bs : 相等");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test end");
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      jdField_b_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    S = paramString;
    jdField_b_of_type_Boolean = true;
  }
  
  public static void a(String paramString, int paramInt, FileMsg paramFileMsg)
  {
    HashMap localHashMap;
    String str;
    long l2;
    long l1;
    if ((paramInt == 2003) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 1003))
    {
      localHashMap = new HashMap();
      str = "";
      if (paramFileMsg.jdField_a_of_type_Int != 1) {
        break label275;
      }
      str = "actPicDownloadV2.Card.Picture";
      long l3 = System.currentTimeMillis() - paramFileMsg.f;
      long l4 = paramFileMsg.jdField_a_of_type_Long;
      localHashMap.put("param_Server", StringUtil.a(paramFileMsg.i));
      l2 = l3;
      l1 = l4;
      if (paramInt == 1005)
      {
        localHashMap.put("param_fsized", paramFileMsg.e + "");
        localHashMap.put("param_fsizeo", paramFileMsg.jdField_a_of_type_Long + "");
        localHashMap.put("param_PicScale", paramFileMsg.ab + "");
        l2 = l3;
        l1 = l4;
        if (paramFileMsg.jdField_a_of_type_Int == 1)
        {
          l2 = 0L;
          l1 = 0L;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, paramFileMsg.i);
      }
      paramFileMsg = StatisticCollector.a(BaseApplication.getContext());
      if ((paramInt != 2003) && (paramInt != 1003)) {
        break label290;
      }
    }
    label275:
    label290:
    for (boolean bool = true;; bool = false)
    {
      paramFileMsg.a(paramString, str, bool, l2, l1, localHashMap, "");
      return;
      if (paramFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      str = "actPicUploadV2.Card.Picture";
      break;
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      StatisticCollector.a(BaseApplication.getContext()).a(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!BaseTransProcessor.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == -9527) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(BaseTransProcessor.N, paramString4);
        label316:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label379;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      label379:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject2 = ((FriendManager)localObject1).c(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).alias)))
      {
        str = ((Friends)localObject2).alias;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|f.alias = " + ((Friends)localObject2).alias);
          localObject1 = str;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|strShowName = " + (String)localObject1);
        }
        if (!paramString.equals(paramQQAppInterface.a())) {
          break label368;
        }
      }
    }
    label368:
    for (paramString = String.format("http://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-3.4.0", localObject1 });; paramString = String.format("http://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-3.4.0", localObject1 }))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
      }
      localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramString);
      ((Intent)localObject1).putExtra("uin", paramQQAppInterface.a());
      ((Intent)localObject1).putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
      ((Intent)localObject1).putExtra("reqType", 1);
      paramActivity.startActivity((Intent)localObject1);
      return;
      localObject2 = ((FriendManager)localObject1).a(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Card)localObject2).strShowName)))
      {
        str = ((Card)localObject2).strShowName;
        localObject1 = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|card.strShowName = " + ((Card)localObject2).strShowName);
        localObject1 = str;
        break;
        a(paramQQAppInterface, paramActivity, paramString);
      }
      localObject1 = paramString;
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a == null) {
      a = new HashMap();
    }
    a.put(paramString1, paramString2);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = HexUtil.a(paramArrayOfByte);
      String str = HexUtil.a(paramArrayOfByte);
      new esi(str, b(paramArrayOfByte)).start();
      b(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    try
    {
      paramString = new File(paramContext);
      if (!b(paramContext))
      {
        paramString.delete();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not picture");
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
        return true;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    File localFile = new File(paramString);
    long l1 = localFile.length();
    if ((!localFile.exists()) || (l1 <= 0L) || (l1 >= 614400L)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|avatarFilePath not exist, or len = " + l1);
      }
    }
    do
    {
      return false;
      if (NetworkUtil.e(paramQQAppInterface.a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|net is not available");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l1);
    }
    boolean bool = true;
    if (TextUtils.isEmpty(paramQQAppInterface.getSid()))
    {
      paramQQAppInterface = (AccountManager)paramQQAppInterface.getManager(0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.updateSid(null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|sid is null");
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      a(paramString);
      paramQQAppInterface.a().a(paramQQAppInterface.a(), paramString, (byte)4, 0);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return false;
    }
    paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(32)).a(paramString);
    boolean bool;
    if ((paramImageView != null) && (paramQQAppInterface != null) && (paramQQAppInterface.iNewFlag.get() != 0))
    {
      paramImageView.setVisibility(0);
      switch (paramQQAppInterface.type.get())
      {
      default: 
        paramImageView.setVisibility(8);
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      paramImageView.setImageResource(2130839338);
      bool = true;
      continue;
      paramImageView.setImageResource(2130839335);
      bool = true;
      continue;
      bool = false;
      continue;
      if (paramImageView != null) {
        paramImageView.setVisibility(8);
      }
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i1;
    int i2;
    label12:
    label20:
    boolean bool2;
    if (paramArrayOfByte1 == null)
    {
      i1 = 0;
      if (paramArrayOfByte2 != null) {
        break label74;
      }
      i2 = 0;
      if (i1 != i2) {
        break label80;
      }
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      i2 = 0;
      label31:
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      bool2 = bool1;
      if (i2 >= i1) {
        break label92;
      }
      if (paramArrayOfByte1[i2] != paramArrayOfByte2[i2]) {
        break label86;
      }
    }
    label74:
    label80:
    label86:
    for (boolean bool1 = true;; bool1 = false)
    {
      i2 += 1;
      break label31;
      i1 = paramArrayOfByte1.length;
      break;
      i2 = paramArrayOfByte2.length;
      break label12;
      bool1 = false;
      break label20;
    }
    label92:
    return bool2;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = HexUtil.a(paramString);
    }
    return arrayOfByte;
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static long b()
  {
    try
    {
      if (Utils.e()) {
        return Utils.a(new File(AppConstants.aq));
      }
      long l1 = Utils.a(new File(Environment.getRootDirectory().getPath()));
      return l1;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (a != null) {
      return (String)a.get(paramString);
    }
    return null;
  }
  
  public static void b(String paramString)
  {
    if (a != null) {
      a.remove(paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "delVoiceFile() uin = " + paramString1 + ", filekey = " + paramString2);
    }
    paramString1 = a(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      FileUtils.d(paramString1);
    }
  }
  
  public static boolean b(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static final int c(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static String c()
  {
    return S;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      localStringBuffer.append(Character.toLowerCase(paramString.charAt(i1)));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void c(String paramString)
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public static String d(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.lastIndexOf('/');
      str1 = str2;
      if (i1 > 0)
      {
        str1 = str2;
        if (i1 < paramString.length()) {
          str1 = paramString.substring(i1 + 1);
        }
      }
    }
    return str1;
  }
  
  public static void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.a().post(new esj(paramString));
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */