package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
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
import hfc;
import hfd;
import hfe;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.AccountManager;
import pttcenterservice.PttCenter.ServerListInfo;

public class ProfileCardUtil
{
  public static final int a = 100;
  protected static long a = 0L;
  public static final String a = "Q.profilecard.Troop";
  protected static HashMap a;
  public static final boolean a = true;
  public static final int b = 640;
  private static final long jdField_b_of_type_Long = 614400L;
  public static final String b = "Q.profilecard.SummaryCard";
  private static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 482;
  public static final String c = "Q.profilecard.FrdProfileCard";
  public static final int d = 0;
  public static final String d = "Q.profilecard.MicroPhone";
  public static final int e = -1;
  public static final String e = "Q.profilecard.VoicePlayer";
  public static final int f = 0;
  public static final String f = "Q.profilecard.Avatar";
  public static final int g = 1;
  public static final String g = "Q.profilecard.TResource";
  public static final int h = 2;
  public static final String h = "Q.profilecard.VoiceIntro";
  public static final int i = 3;
  public static final String i = "Q.profilecard.PhotoWall";
  public static final int j = 4;
  public static final String j = "Q.profilecard.PhotoWall.Bg";
  public static final int k = 5;
  public static final String k = "Q.profilecard.Detail";
  public static final int l = 6;
  public static final String l = "Q.profilecard.PhotoWall.Trans";
  public static final int m = 7;
  public static final String m = "Q.profilecard.VoiceIntro.Trans";
  public static final int n = 8;
  public static final String n = "Q.profilecard.Visitor";
  public static final int o = 9;
  public static final String o = "ProfileCard.setcard";
  public static final int p = 10;
  public static final String p = "profilecard";
  public static final int q = 11;
  public static final String q = "is_template_list_loaded";
  public static final int r = 12;
  public static final String r = "pttcenter_filepath";
  public static final int s = 13;
  public static final String s = "pttcenter_shDuration";
  public static final int t = 14;
  public static final String t = "pttcenter_cmd";
  public static final int u = 15;
  public static final String u = "pttcenter_filekey";
  public static final int v = 16;
  public static final String v = "pttcenter_selfuin";
  public static final int w = 17;
  public static final String w = "pttcenter_targetuin";
  public static final String x = "pttcenter_voice_optype";
  private static String y = null;
  
  static
  {
    b = false;
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
      } else if ((paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 72)) {
        i1 = 1021;
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
    return System.currentTimeMillis() - jdField_a_of_type_Long;
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
    if ((paramAllInOne.b != null) && (paramAllInOne.b.length() > 0)) {
      paramQQAppInterface = paramAllInOne.b;
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
      if ((paramAllInOne.c != null) && (paramAllInOne.c.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.c });
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
    //   1: bipush 64
    //   3: idiv
    //   4: istore 6
    //   6: iload_2
    //   7: bipush 64
    //   9: irem
    //   10: istore_2
    //   11: iload_2
    //   12: bipush 16
    //   14: idiv
    //   15: istore 7
    //   17: iload_2
    //   18: bipush 16
    //   20: irem
    //   21: istore 9
    //   23: iload 9
    //   25: iconst_4
    //   26: idiv
    //   27: istore 8
    //   29: ldc 238
    //   31: astore 11
    //   33: iconst_0
    //   34: istore 4
    //   36: iload 4
    //   38: iconst_4
    //   39: if_icmpge +133 -> 172
    //   42: iconst_0
    //   43: istore_2
    //   44: ldc 238
    //   46: astore 10
    //   48: iload 4
    //   50: tableswitch	default:+30 -> 80, 0:+70->120, 1:+80->130, 2:+90->140, 3:+100->150
    //   81: istore 5
    //   83: iload 5
    //   85: iload_2
    //   86: if_icmpge +77 -> 163
    //   89: new 240	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   96: aload 11
    //   98: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 10
    //   103: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 11
    //   111: iload 5
    //   113: iconst_1
    //   114: iadd
    //   115: istore 5
    //   117: goto -34 -> 83
    //   120: ldc 251
    //   122: astore 10
    //   124: iload 6
    //   126: istore_2
    //   127: goto -47 -> 80
    //   130: ldc 253
    //   132: astore 10
    //   134: iload 7
    //   136: istore_2
    //   137: goto -57 -> 80
    //   140: ldc 255
    //   142: astore 10
    //   144: iload 8
    //   146: istore_2
    //   147: goto -67 -> 80
    //   150: ldc_w 257
    //   153: astore 10
    //   155: iload 9
    //   157: iconst_4
    //   158: irem
    //   159: istore_2
    //   160: goto -80 -> 80
    //   163: iload 4
    //   165: iconst_1
    //   166: iadd
    //   167: istore 4
    //   169: goto -133 -> 36
    //   172: iload_3
    //   173: ifeq +486 -> 659
    //   176: aload 11
    //   178: invokevirtual 197	java/lang/String:length	()I
    //   181: iload_1
    //   182: if_icmple +477 -> 659
    //   185: aload 11
    //   187: iconst_0
    //   188: iload_1
    //   189: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   192: astore 10
    //   194: aload 10
    //   196: astore 14
    //   198: new 263	android/text/SpannableString
    //   201: dup
    //   202: aload 14
    //   204: invokespecial 266	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   207: astore 16
    //   209: aload_0
    //   210: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   213: ldc_w 273
    //   216: invokevirtual 279	android/content/res/Resources:getDimension	(I)F
    //   219: f2i
    //   220: istore 4
    //   222: iconst_0
    //   223: istore_2
    //   224: iload_2
    //   225: aload 14
    //   227: invokevirtual 197	java/lang/String:length	()I
    //   230: if_icmpge +401 -> 631
    //   233: aconst_null
    //   234: astore 13
    //   236: aconst_null
    //   237: astore 15
    //   239: aconst_null
    //   240: astore 12
    //   242: iload_2
    //   243: iload_1
    //   244: iconst_1
    //   245: isub
    //   246: if_icmpne +97 -> 343
    //   249: iload_3
    //   250: iconst_1
    //   251: if_icmpne +92 -> 343
    //   254: aload 13
    //   256: astore 10
    //   258: aload 15
    //   260: astore 11
    //   262: aload_0
    //   263: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   266: ldc_w 280
    //   269: invokevirtual 284	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   272: astore 12
    //   274: aload 12
    //   276: ifnull +50 -> 326
    //   279: aload 12
    //   281: astore 10
    //   283: aload 12
    //   285: astore 11
    //   287: aload 12
    //   289: iconst_0
    //   290: iconst_0
    //   291: iload 4
    //   293: iload 4
    //   295: invokevirtual 290	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   298: aload 12
    //   300: astore 10
    //   302: aload 12
    //   304: astore 11
    //   306: aload 16
    //   308: new 292	android/text/style/ImageSpan
    //   311: dup
    //   312: aload 12
    //   314: invokespecial 295	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   317: iload_2
    //   318: iload_2
    //   319: iconst_1
    //   320: iadd
    //   321: bipush 33
    //   323: invokevirtual 299	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   326: aload 16
    //   328: areturn
    //   329: astore 10
    //   331: aload 10
    //   333: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   336: aload 11
    //   338: astore 14
    //   340: goto -142 -> 198
    //   343: aload 13
    //   345: astore 10
    //   347: aload 15
    //   349: astore 11
    //   351: ldc 251
    //   353: aload 14
    //   355: iload_2
    //   356: iload_2
    //   357: iconst_1
    //   358: iadd
    //   359: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   362: invokevirtual 306	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   365: ifeq +23 -> 388
    //   368: aload 13
    //   370: astore 10
    //   372: aload 15
    //   374: astore 11
    //   376: aload_0
    //   377: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   380: ldc_w 307
    //   383: invokevirtual 284	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   386: astore 12
    //   388: aload 12
    //   390: astore 13
    //   392: aload 12
    //   394: astore 10
    //   396: aload 12
    //   398: astore 11
    //   400: ldc 253
    //   402: aload 14
    //   404: iload_2
    //   405: iload_2
    //   406: iconst_1
    //   407: iadd
    //   408: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   411: invokevirtual 306	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   414: ifeq +23 -> 437
    //   417: aload 12
    //   419: astore 10
    //   421: aload 12
    //   423: astore 11
    //   425: aload_0
    //   426: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   429: ldc_w 308
    //   432: invokevirtual 284	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   435: astore 13
    //   437: aload 13
    //   439: astore 10
    //   441: aload 13
    //   443: astore 11
    //   445: ldc 255
    //   447: aload 14
    //   449: iload_2
    //   450: iload_2
    //   451: iconst_1
    //   452: iadd
    //   453: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   456: invokevirtual 306	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   459: ifeq +193 -> 652
    //   462: aload 13
    //   464: astore 10
    //   466: aload 13
    //   468: astore 11
    //   470: aload_0
    //   471: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   474: ldc_w 309
    //   477: invokevirtual 284	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   480: astore 12
    //   482: aload 12
    //   484: astore 10
    //   486: aload 10
    //   488: astore 11
    //   490: ldc_w 257
    //   493: aload 14
    //   495: iload_2
    //   496: iload_2
    //   497: iconst_1
    //   498: iadd
    //   499: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   502: invokevirtual 306	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   505: ifeq +15 -> 520
    //   508: aload_0
    //   509: invokevirtual 272	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   512: ldc_w 310
    //   515: invokevirtual 284	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   518: astore 11
    //   520: aload 11
    //   522: astore 10
    //   524: aload 10
    //   526: ifnull +34 -> 560
    //   529: aload 10
    //   531: iconst_0
    //   532: iconst_0
    //   533: iload 4
    //   535: iload 4
    //   537: invokevirtual 290	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   540: aload 16
    //   542: new 292	android/text/style/ImageSpan
    //   545: dup
    //   546: aload 10
    //   548: invokespecial 295	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   551: iload_2
    //   552: iload_2
    //   553: iconst_1
    //   554: iadd
    //   555: bipush 33
    //   557: invokevirtual 299	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   560: iload_2
    //   561: iconst_1
    //   562: iadd
    //   563: istore_2
    //   564: goto -340 -> 224
    //   567: astore 12
    //   569: aload 10
    //   571: astore 11
    //   573: aload 11
    //   575: astore 10
    //   577: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq -56 -> 524
    //   583: ldc 27
    //   585: iconst_2
    //   586: aload 12
    //   588: invokevirtual 317	java/lang/Error:toString	()Ljava/lang/String;
    //   591: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: aload 11
    //   596: astore 10
    //   598: goto -74 -> 524
    //   601: astore 12
    //   603: aload 11
    //   605: astore 10
    //   607: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -86 -> 524
    //   613: ldc 27
    //   615: iconst_2
    //   616: aload 12
    //   618: invokevirtual 321	java/lang/Exception:toString	()Ljava/lang/String;
    //   621: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload 11
    //   626: astore 10
    //   628: goto -104 -> 524
    //   631: aload 16
    //   633: areturn
    //   634: astore 12
    //   636: aload 10
    //   638: astore 11
    //   640: goto -37 -> 603
    //   643: astore 12
    //   645: aload 10
    //   647: astore 11
    //   649: goto -76 -> 573
    //   652: aload 13
    //   654: astore 10
    //   656: goto -170 -> 486
    //   659: aload 11
    //   661: astore 10
    //   663: goto -469 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	paramContext	Context
    //   0	666	1	paramInt1	int
    //   0	666	2	paramInt2	int
    //   0	666	3	paramBoolean	boolean
    //   34	502	4	i1	int
    //   81	35	5	i2	int
    //   4	121	6	i3	int
    //   15	120	7	i4	int
    //   27	118	8	i5	int
    //   21	138	9	i6	int
    //   46	255	10	localObject1	Object
    //   329	3	10	localException1	Exception
    //   345	317	10	localObject2	Object
    //   31	629	11	localObject3	Object
    //   240	243	12	localDrawable	Drawable
    //   567	20	12	localError1	java.lang.Error
    //   601	16	12	localException2	Exception
    //   634	1	12	localException3	Exception
    //   643	1	12	localError2	java.lang.Error
    //   234	419	13	localObject4	Object
    //   196	298	14	localObject5	Object
    //   237	136	15	localObject6	Object
    //   207	425	16	localSpannableString	SpannableString
    // Exception table:
    //   from	to	target	type
    //   176	194	329	java/lang/Exception
    //   262	274	567	java/lang/Error
    //   287	298	567	java/lang/Error
    //   306	326	567	java/lang/Error
    //   351	368	567	java/lang/Error
    //   376	388	567	java/lang/Error
    //   400	417	567	java/lang/Error
    //   425	437	567	java/lang/Error
    //   445	462	567	java/lang/Error
    //   470	482	567	java/lang/Error
    //   262	274	601	java/lang/Exception
    //   287	298	601	java/lang/Exception
    //   306	326	601	java/lang/Exception
    //   351	368	601	java/lang/Exception
    //   376	388	601	java/lang/Exception
    //   400	417	601	java/lang/Exception
    //   425	437	601	java/lang/Exception
    //   445	462	601	java/lang/Exception
    //   470	482	601	java/lang/Exception
    //   490	520	634	java/lang/Exception
    //   490	520	643	java/lang/Error
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
          break label410;
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
                  break label407;
                }
                localFriendsManagerImp.a(paramQQAppInterface);
                if (paramQQAppInterface != null) {
                  paramQQAppInterface.getBusiEntrys();
                }
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
          break label404;
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
      label404:
      continue;
      label407:
      continue;
      label410:
      Object localObject2 = null;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static ProfileCardTemplate a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int i3 = 0;
    if (paramLong == 0L) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true);
    int i4 = localArrayList.size();
    int i1 = 0;
    paramQQAppInterface = null;
    int i2 = i3;
    if (i1 < i4)
    {
      paramQQAppInterface = (ProfileCardTemplate)localArrayList.get(i1);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.jdField_a_of_type_Long == paramLong)) {
        i2 = 1;
      }
    }
    else
    {
      if ((i2 != 1) || (paramQQAppInterface == null)) {
        break label84;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i1 += 1;
      break;
      label84:
      paramQQAppInterface = null;
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_uploading.jpg");
    return localStringBuilder.toString();
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
    paramContext = paramContext.getDir("profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "6.0.1";
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
      label59:
      String str;
      if (i1 == 0)
      {
        paramProfileCardInfo = paramContext.getString(2131562338);
        str = "";
        if (localCard == null) {
          break label432;
        }
        i1 = localCard.age;
        label74:
        if (i1 > 0) {
          str = i1 + paramContext.getString(2131561415);
        }
        localObject = "";
        if (localCard == null) {
          break label448;
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
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramContext = (String)localObject + " ";
          }
          new StringBuilder().append(paramContext).append(localCard.strCity).toString();
        }
      }
      for (;;)
      {
        paramContext = paramProfileCardInfo;
        if (str != null)
        {
          paramContext = paramProfileCardInfo;
          if (str.length() > 0) {
            paramContext = paramProfileCardInfo + " " + str;
          }
        }
        return paramContext;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i1 = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label649;
        }
        i1 = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i1 != 1) {
          break label59;
        }
        paramProfileCardInfo = paramContext.getString(2131562104);
        break label59;
        label432:
        i1 = i2;
        if (localContactCard == null) {
          break label74;
        }
        i1 = localContactCard.bAge;
        break label74;
        label448:
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
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramContext = (String)localObject + " ";
            }
            new StringBuilder().append(paramContext).append(localContactCard.strCity).toString();
          }
        }
      }
      label649:
      i1 = -1;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    File localFile;
    do
    {
      return paramContext;
      paramContext = paramContext.getDir("profilecard", 0);
      paramString = (paramContext.getAbsolutePath() + File.separator + paramString).replace(File.separator + File.separator, File.separator);
      localFile = new File(paramString);
      paramContext = paramString;
    } while (localFile.exists());
    localFile.mkdirs();
    return paramString;
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
    String str = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return str + File.separator + "common" + File.separator;
    }
    if ((paramLong != 0L) && (paramLong > 0L))
    {
      paramQQAppInterface = a(paramQQAppInterface, paramLong);
      if (paramQQAppInterface != null) {
        return str + File.separator + paramQQAppInterface.jdField_a_of_type_Long + "_" + paramQQAppInterface.b;
      }
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
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return c(HexUtil.a(paramArrayOfByte));
  }
  
  /* Error */
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 592	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: astore 11
    //   6: aload 11
    //   8: invokestatic 658	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   11: astore 12
    //   13: new 445	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 659	java/util/ArrayList:<init>	()V
    //   20: astore 10
    //   22: aconst_null
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 6
    //   30: astore 8
    //   32: aload 9
    //   34: astore 7
    //   36: new 498	java/io/File
    //   39: dup
    //   40: aload 12
    //   42: invokespecial 573	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 12
    //   47: aload 6
    //   49: astore 8
    //   51: aload 9
    //   53: astore 7
    //   55: aload 12
    //   57: invokevirtual 576	java/io/File:exists	()Z
    //   60: ifeq +121 -> 181
    //   63: aload 6
    //   65: astore 8
    //   67: aload 9
    //   69: astore 7
    //   71: new 661	java/io/FileInputStream
    //   74: dup
    //   75: aload 12
    //   77: invokespecial 664	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: astore 6
    //   82: aload 6
    //   84: astore 8
    //   86: aload 6
    //   88: astore 7
    //   90: new 666	java/io/ByteArrayOutputStream
    //   93: dup
    //   94: invokespecial 667	java/io/ByteArrayOutputStream:<init>	()V
    //   97: astore 9
    //   99: aload 6
    //   101: astore 8
    //   103: aload 6
    //   105: astore 7
    //   107: sipush 4096
    //   110: newarray byte
    //   112: astore 11
    //   114: aload 6
    //   116: astore 8
    //   118: aload 6
    //   120: astore 7
    //   122: aload 6
    //   124: aload 11
    //   126: iconst_0
    //   127: sipush 4096
    //   130: invokevirtual 673	java/io/InputStream:read	([BII)I
    //   133: istore_2
    //   134: iload_2
    //   135: iconst_m1
    //   136: if_icmpeq +69 -> 205
    //   139: aload 6
    //   141: astore 8
    //   143: aload 6
    //   145: astore 7
    //   147: aload 9
    //   149: aload 11
    //   151: iconst_0
    //   152: iload_2
    //   153: invokevirtual 677	java/io/ByteArrayOutputStream:write	([BII)V
    //   156: goto -42 -> 114
    //   159: astore_0
    //   160: aload 8
    //   162: astore 7
    //   164: aload_0
    //   165: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   168: aload 8
    //   170: ifnull +8 -> 178
    //   173: aload 8
    //   175: invokevirtual 680	java/io/InputStream:close	()V
    //   178: aload 10
    //   180: areturn
    //   181: aload 6
    //   183: astore 8
    //   185: aload 9
    //   187: astore 7
    //   189: aload 11
    //   191: invokevirtual 684	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   194: ldc_w 506
    //   197: invokevirtual 690	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   200: astore 6
    //   202: goto -120 -> 82
    //   205: aload 6
    //   207: astore 8
    //   209: aload 6
    //   211: astore 7
    //   213: new 194	java/lang/String
    //   216: dup
    //   217: aload 9
    //   219: invokevirtual 694	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: ldc_w 696
    //   225: invokespecial 699	java/lang/String:<init>	([BLjava/lang/String;)V
    //   228: astore 9
    //   230: aload 9
    //   232: ifnull +549 -> 781
    //   235: aload 6
    //   237: astore 8
    //   239: aload 6
    //   241: astore 7
    //   243: aload 9
    //   245: invokevirtual 197	java/lang/String:length	()I
    //   248: ifle +533 -> 781
    //   251: aload 6
    //   253: astore 8
    //   255: aload 6
    //   257: astore 7
    //   259: new 701	org/json/JSONObject
    //   262: dup
    //   263: aload 9
    //   265: invokespecial 702	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   268: astore 9
    //   270: aload 6
    //   272: astore 8
    //   274: aload 6
    //   276: astore 7
    //   278: aload 9
    //   280: ldc_w 704
    //   283: invokevirtual 707	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   286: ifeq +495 -> 781
    //   289: aload 6
    //   291: astore 8
    //   293: aload 6
    //   295: astore 7
    //   297: aload 9
    //   299: ldc_w 704
    //   302: invokevirtual 711	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   305: astore 9
    //   307: aload 6
    //   309: astore 8
    //   311: aload 6
    //   313: astore 7
    //   315: aload 9
    //   317: invokevirtual 714	org/json/JSONArray:length	()I
    //   320: istore_3
    //   321: iconst_0
    //   322: istore_2
    //   323: iload_2
    //   324: iload_3
    //   325: if_icmpge +456 -> 781
    //   328: aload 6
    //   330: astore 8
    //   332: aload 6
    //   334: astore 7
    //   336: aload 9
    //   338: iload_2
    //   339: invokevirtual 718	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   342: astore 11
    //   344: aload 6
    //   346: astore 8
    //   348: aload 6
    //   350: astore 7
    //   352: new 454	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   355: dup
    //   356: invokespecial 719	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   359: astore 12
    //   361: aload 6
    //   363: astore 8
    //   365: aload 6
    //   367: astore 7
    //   369: aload 12
    //   371: aload 11
    //   373: ldc_w 721
    //   376: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   379: i2l
    //   380: putfield 455	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Long	J
    //   383: aload 6
    //   385: astore 8
    //   387: aload 6
    //   389: astore 7
    //   391: aload 12
    //   393: aload 11
    //   395: ldc_w 726
    //   398: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: putfield 730	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   404: aload 6
    //   406: astore 8
    //   408: aload 6
    //   410: astore 7
    //   412: aload 12
    //   414: aload 11
    //   416: ldc_w 732
    //   419: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 604	com/tencent/mobileqq/profile/ProfileCardTemplate:b	Ljava/lang/String;
    //   425: aload 6
    //   427: astore 8
    //   429: aload 6
    //   431: astore 7
    //   433: aload 12
    //   435: aload 11
    //   437: ldc_w 734
    //   440: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: putfield 735	com/tencent/mobileqq/profile/ProfileCardTemplate:c	Ljava/lang/String;
    //   446: aload 6
    //   448: astore 8
    //   450: aload 6
    //   452: astore 7
    //   454: aload 12
    //   456: aload 11
    //   458: ldc_w 737
    //   461: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   464: putfield 739	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_f_of_type_Int	I
    //   467: aload 6
    //   469: astore 8
    //   471: aload 6
    //   473: astore 7
    //   475: aload 12
    //   477: aload 11
    //   479: ldc_w 741
    //   482: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   485: putfield 743	com/tencent/mobileqq/profile/ProfileCardTemplate:g	I
    //   488: aload 6
    //   490: astore 8
    //   492: aload 6
    //   494: astore 7
    //   496: aload 12
    //   498: aload 11
    //   500: ldc_w 745
    //   503: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   506: putfield 747	com/tencent/mobileqq/profile/ProfileCardTemplate:h	I
    //   509: aload 6
    //   511: astore 8
    //   513: aload 6
    //   515: astore 7
    //   517: aload 12
    //   519: aload 11
    //   521: ldc_w 749
    //   524: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   527: putfield 751	com/tencent/mobileqq/profile/ProfileCardTemplate:i	I
    //   530: aload 6
    //   532: astore 8
    //   534: aload 6
    //   536: astore 7
    //   538: aload 12
    //   540: aload 11
    //   542: ldc_w 753
    //   545: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   548: putfield 755	com/tencent/mobileqq/profile/ProfileCardTemplate:d	Ljava/lang/String;
    //   551: aload 6
    //   553: astore 8
    //   555: aload 6
    //   557: astore 7
    //   559: aload 12
    //   561: aload 11
    //   563: ldc_w 757
    //   566: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   569: putfield 759	com/tencent/mobileqq/profile/ProfileCardTemplate:j	I
    //   572: aload 6
    //   574: astore 8
    //   576: aload 6
    //   578: astore 7
    //   580: aload 12
    //   582: aload 11
    //   584: ldc_w 761
    //   587: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   590: putfield 763	com/tencent/mobileqq/profile/ProfileCardTemplate:e	Ljava/lang/String;
    //   593: aload 6
    //   595: astore 8
    //   597: aload 6
    //   599: astore 7
    //   601: aload 12
    //   603: aload 11
    //   605: ldc_w 765
    //   608: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   611: putfield 767	com/tencent/mobileqq/profile/ProfileCardTemplate:k	I
    //   614: aload 6
    //   616: astore 8
    //   618: aload 6
    //   620: astore 7
    //   622: aload 12
    //   624: aload 11
    //   626: ldc_w 769
    //   629: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   632: putfield 771	com/tencent/mobileqq/profile/ProfileCardTemplate:l	I
    //   635: aload 6
    //   637: astore 8
    //   639: aload 6
    //   641: astore 7
    //   643: aload 12
    //   645: aload 11
    //   647: ldc_w 773
    //   650: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   653: putfield 775	com/tencent/mobileqq/profile/ProfileCardTemplate:m	I
    //   656: aload 6
    //   658: astore 8
    //   660: aload 6
    //   662: astore 7
    //   664: aload 12
    //   666: aload 11
    //   668: ldc_w 777
    //   671: invokevirtual 729	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   674: putfield 779	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   677: aload 6
    //   679: astore 8
    //   681: aload 6
    //   683: astore 7
    //   685: aload 11
    //   687: ldc_w 781
    //   690: invokevirtual 725	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   693: istore 4
    //   695: iload 4
    //   697: iconst_1
    //   698: if_icmpne +129 -> 827
    //   701: iconst_1
    //   702: istore 5
    //   704: aload 6
    //   706: astore 8
    //   708: aload 6
    //   710: astore 7
    //   712: aload 12
    //   714: iload 5
    //   716: putfield 783	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   719: iload_1
    //   720: ifne +12 -> 732
    //   723: iload 4
    //   725: iconst_1
    //   726: if_icmpne +6 -> 732
    //   729: goto +91 -> 820
    //   732: aload 6
    //   734: astore 8
    //   736: aload 6
    //   738: astore 7
    //   740: aload_0
    //   741: aload 12
    //   743: invokestatic 786	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/profile/ProfileCardTemplate;)Z
    //   746: ifeq +74 -> 820
    //   749: aload 6
    //   751: astore 8
    //   753: aload 6
    //   755: astore 7
    //   757: aload 10
    //   759: aload 12
    //   761: invokevirtual 789	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   764: pop
    //   765: goto +55 -> 820
    //   768: astore_0
    //   769: aload 7
    //   771: ifnull +8 -> 779
    //   774: aload 7
    //   776: invokevirtual 680	java/io/InputStream:close	()V
    //   779: aload_0
    //   780: athrow
    //   781: aload 6
    //   783: ifnull -605 -> 178
    //   786: aload 6
    //   788: invokevirtual 680	java/io/InputStream:close	()V
    //   791: aload 10
    //   793: areturn
    //   794: astore_0
    //   795: aload_0
    //   796: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   799: aload 10
    //   801: areturn
    //   802: astore_0
    //   803: aload_0
    //   804: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   807: aload 10
    //   809: areturn
    //   810: astore 6
    //   812: aload 6
    //   814: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   817: goto -38 -> 779
    //   820: iload_2
    //   821: iconst_1
    //   822: iadd
    //   823: istore_2
    //   824: goto -501 -> 323
    //   827: iconst_0
    //   828: istore 5
    //   830: goto -126 -> 704
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	paramQQAppInterface	QQAppInterface
    //   0	833	1	paramBoolean	boolean
    //   133	691	2	i1	int
    //   320	6	3	i2	int
    //   693	34	4	i3	int
    //   702	127	5	bool	boolean
    //   26	761	6	localObject1	Object
    //   810	3	6	localIOException	java.io.IOException
    //   34	741	7	localObject2	Object
    //   30	722	8	localObject3	Object
    //   23	314	9	localObject4	Object
    //   20	788	10	localArrayList	ArrayList
    //   4	682	11	localObject5	Object
    //   11	749	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	47	159	java/lang/Exception
    //   55	63	159	java/lang/Exception
    //   71	82	159	java/lang/Exception
    //   90	99	159	java/lang/Exception
    //   107	114	159	java/lang/Exception
    //   122	134	159	java/lang/Exception
    //   147	156	159	java/lang/Exception
    //   189	202	159	java/lang/Exception
    //   213	230	159	java/lang/Exception
    //   243	251	159	java/lang/Exception
    //   259	270	159	java/lang/Exception
    //   278	289	159	java/lang/Exception
    //   297	307	159	java/lang/Exception
    //   315	321	159	java/lang/Exception
    //   336	344	159	java/lang/Exception
    //   352	361	159	java/lang/Exception
    //   369	383	159	java/lang/Exception
    //   391	404	159	java/lang/Exception
    //   412	425	159	java/lang/Exception
    //   433	446	159	java/lang/Exception
    //   454	467	159	java/lang/Exception
    //   475	488	159	java/lang/Exception
    //   496	509	159	java/lang/Exception
    //   517	530	159	java/lang/Exception
    //   538	551	159	java/lang/Exception
    //   559	572	159	java/lang/Exception
    //   580	593	159	java/lang/Exception
    //   601	614	159	java/lang/Exception
    //   622	635	159	java/lang/Exception
    //   643	656	159	java/lang/Exception
    //   664	677	159	java/lang/Exception
    //   685	695	159	java/lang/Exception
    //   712	719	159	java/lang/Exception
    //   740	749	159	java/lang/Exception
    //   757	765	159	java/lang/Exception
    //   36	47	768	finally
    //   55	63	768	finally
    //   71	82	768	finally
    //   90	99	768	finally
    //   107	114	768	finally
    //   122	134	768	finally
    //   147	156	768	finally
    //   164	168	768	finally
    //   189	202	768	finally
    //   213	230	768	finally
    //   243	251	768	finally
    //   259	270	768	finally
    //   278	289	768	finally
    //   297	307	768	finally
    //   315	321	768	finally
    //   336	344	768	finally
    //   352	361	768	finally
    //   369	383	768	finally
    //   391	404	768	finally
    //   412	425	768	finally
    //   433	446	768	finally
    //   454	467	768	finally
    //   475	488	768	finally
    //   496	509	768	finally
    //   517	530	768	finally
    //   538	551	768	finally
    //   559	572	768	finally
    //   580	593	768	finally
    //   601	614	768	finally
    //   622	635	768	finally
    //   643	656	768	finally
    //   664	677	768	finally
    //   685	695	768	finally
    //   712	719	768	finally
    //   740	749	768	finally
    //   757	765	768	finally
    //   786	791	794	java/io/IOException
    //   173	178	802	java/io/IOException
    //   774	779	810	java/io/IOException
  }
  
  public static HashMap a(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = new File(paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath());
    if ((paramQQAppInterface != null) && (paramQQAppInterface.exists()))
    {
      paramQQAppInterface = paramQQAppInterface.list();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0))
      {
        HashMap localHashMap = new HashMap();
        while (i1 < paramQQAppInterface.length)
        {
          localHashMap.put(paramQQAppInterface[i1], Boolean.valueOf(true));
          i1 += 1;
        }
        return localHashMap;
      }
    }
    return null;
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
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    b = false;
    y = null;
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
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Resources paramResources, View paramView, StatusManager paramStatusManager, RichStatus paramRichStatus, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i2 = 0;
    TextView localTextView = (TextView)paramView.findViewById(2131231506);
    ImageView localImageView = (ImageView)paramView.findViewById(2131232620);
    if (paramRichStatus != null) {
      localObject1 = paramRichStatus.a(null, -8947849, paramResources.getColor(2131361825));
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
        label208:
        if (!paramBoolean) {
          break label524;
        }
        if (paramStatusManager != null) {
          break label433;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label220:
      if (paramBoolean)
      {
        i1 = 2130837860;
        label230:
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
          break label456;
        }
        if (paramRichStatus.c != null) {
          paramResources = "" + paramRichStatus.c;
        }
        paramStatusManager = paramResources;
        if (paramRichStatus.d != null) {
          paramStatusManager = paramResources + paramRichStatus.d;
        }
        if (paramRichStatus.jdField_a_of_type_JavaUtilArrayList == null) {
          break label450;
        }
        i1 = paramRichStatus.jdField_a_of_type_JavaUtilArrayList.size();
        label352:
        paramResources = paramStatusManager;
        label354:
        paramStatusManager = paramResources;
        if (i2 >= i1) {
          break label459;
        }
        paramStatusManager = (String)paramRichStatus.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (TextUtils.isEmpty(paramStatusManager)) {
          break label521;
        }
        paramResources = paramResources + paramStatusManager;
      }
      label521:
      for (;;)
      {
        i2 += 1;
        break label354;
        localObject1 = BitmapManager.a(paramResources, 2130839653);
        break;
        localTextView.setText((CharSequence)localObject2);
        break label208;
        label433:
        paramBoolean = paramStatusManager.a();
        break label220;
        i1 = 2130837803;
        break label230;
        label450:
        i1 = 0;
        break label352;
        label456:
        paramStatusManager = "";
        label459:
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
      label524:
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
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramBaseActivity, paramBaseActivity.d());
    localQQProgressDialog.show();
    new Thread(new hfe(paramBaseActivity, paramString2, paramBoolean, paramString1, paramString3, localQQProgressDialog)).start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i1 < arrayOfFile.length)
        {
          String str = arrayOfFile[i1].getName();
          if ((str.startsWith(String.valueOf(paramLong))) && (!str.endsWith(paramString)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramLong) + "_" + str;
            FileUtils.a(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
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
      for (paramString = String.format("http://activeqq.3g.qq.com/activeQQ/mqq/_qqinfo_wap20.jsp?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-" + paramQQAppInterface.b(), localObject1 });; paramString = String.format("http://activeqq.3g.qq.com/activeQQ/mqq/_qqinfo_wap20.jsp?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-" + paramQQAppInterface.b(), localObject1 }))
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
          break label394;
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
      label394:
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
      b = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    y = paramString;
    b = true;
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
        break label270;
      }
      str = "actPicDownloadV2.Card.Picture";
      long l3 = System.currentTimeMillis() - paramFileMsg.e;
      long l4 = paramFileMsg.jdField_a_of_type_Long;
      localHashMap.put("param_Server", StringUtil.a(paramFileMsg.i));
      l2 = l3;
      l1 = l4;
      if (paramInt == 1005)
      {
        localHashMap.put("param_fsized", paramFileMsg.d + "");
        localHashMap.put("param_fsizeo", paramFileMsg.jdField_a_of_type_Long + "");
        localHashMap.put("param_PicScale", paramFileMsg.T + "");
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
        break label285;
      }
    }
    label270:
    label285:
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
        localHashMap.put(BaseTransProcessor.L, paramString4);
        label315:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label378;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label315;
      localHashMap.put("param_errorDesc", paramString4);
      break label315;
      label378:
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
          break label388;
        }
      }
    }
    label388:
    for (paramString = String.format("http://activeqq.3g.qq.com/activeQQ/mqq/_qqinfo_wap20.jsp?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-" + paramQQAppInterface.b(), localObject1 });; paramString = String.format("http://activeqq.3g.qq.com/activeQQ/mqq/_qqinfo_wap20.jsp?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-" + paramQQAppInterface.b(), localObject1 }))
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
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = HexUtil.a(paramArrayOfByte);
      String str = HexUtil.a(paramArrayOfByte);
      new hfc(str, b(paramArrayOfByte)).start();
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
    return b;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ProfileCardTemplate paramProfileCardTemplate)
  {
    boolean bool2 = true;
    long l1 = NetConnInfoCenter.getServerTime();
    boolean bool1;
    if (((paramProfileCardTemplate.l > 100) && (l1 < paramProfileCardTemplate.l)) || ((paramProfileCardTemplate.m > 100) && (l1 > paramProfileCardTemplate.m))) {
      bool1 = false;
    }
    int i1;
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            paramQQAppInterface = paramQQAppInterface.a();
            bool1 = bool2;
          } while (paramQQAppInterface == null);
          bool1 = bool2;
        } while (paramQQAppInterface.length() <= 0);
        bool1 = bool2;
      } while (paramProfileCardTemplate.jdField_f_of_type_JavaLangString.length() <= 0);
      paramProfileCardTemplate = paramProfileCardTemplate.jdField_f_of_type_JavaLangString.split(",");
      int i2 = paramProfileCardTemplate.length;
      i1 = 0;
      if (i1 >= i2) {
        break label211;
      }
      arrayOfString = paramProfileCardTemplate[i1];
      if (!arrayOfString.contains("-")) {
        break label200;
      }
      arrayOfString = arrayOfString.split("-");
      if (arrayOfString.length != 2) {
        break;
      }
      l1 = Integer.parseInt(arrayOfString[0]);
      l2 = Integer.parseInt(arrayOfString[0]);
      l3 = Integer.parseInt(paramQQAppInterface);
      if (l3 < l1) {
        break;
      }
      bool1 = bool2;
    } while (l3 <= l2);
    label200:
    while (!paramQQAppInterface.equals(arrayOfString))
    {
      long l2;
      long l3;
      i1 += 1;
      break;
    }
    return true;
    label211:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    if (paramProfileCardTemplate != null)
    {
      paramProfileCardTemplate = a(paramQQAppInterface, paramProfileCardTemplate.jdField_a_of_type_Long);
      Object localObject = a(paramQQAppInterface, -1L);
      if ((paramProfileCardTemplate != null) && (localObject != null))
      {
        paramQQAppInterface = new File(paramProfileCardTemplate);
        paramProfileCardTemplate = new File(paramProfileCardTemplate + File.separator + "config.json");
        if (paramBoolean)
        {
          localObject = new File((String)localObject);
          if ((((File)localObject).isDirectory()) && (((File)localObject).listFiles().length > 1))
          {
            i1 = 1;
            if ((!paramQQAppInterface.isDirectory()) || (!paramProfileCardTemplate.exists()) || (i1 == 0)) {
              break label134;
            }
          }
        }
        label134:
        while ((paramQQAppInterface.isDirectory()) && (paramProfileCardTemplate.exists()))
        {
          for (;;)
          {
            return true;
            int i1 = 0;
          }
          return false;
        }
        return false;
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
      paramQQAppInterface.a().a(paramQQAppInterface, paramString);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return false;
    }
    paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(34)).a(paramString);
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
      paramImageView.setImageResource(2130840210);
      bool = true;
      continue;
      paramImageView.setImageResource(2130840207);
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    return new File(paramQQAppInterface + File.separator + String.format("%s_%s", new Object[] { paramString1, paramString2 })).exists();
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
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
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
  
  public static String c()
  {
    return y;
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
    jdField_a_of_type_Long = System.currentTimeMillis();
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
    ThreadManager.a().post(new hfd(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */