package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static final int A = 4;
  protected static final String A = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
  public static final int B = 19;
  protected static final String B = "http://sqq.3g.qq.com/html5/andr_mq2/index.jsp&sid=%s&g_f=20184&rm=6005";
  public static final int C = 20;
  protected static final String C = "http://sqq.3g.qq.com/html5/andr_mq/index.jsp?qq=%s&sid=%s&from=android&g_f=20183&rm=6005";
  public static final int D = 21;
  public static final String D = "AllInOne";
  public static final int E = 22;
  public static final String E = "source_to_profile";
  public static final int F = 25;
  public static final int G = 26;
  public static final int H = 27;
  public static final int I = 30;
  public static final int J = 31;
  public static final int K = 32;
  public static final int L = 33;
  public static final int M = 34;
  public static final int N = 35;
  public static final int O = 36;
  public static final int P = 37;
  public static final int Q = 40;
  public static final int R = 41;
  public static final int S = 42;
  public static final int T = 45;
  public static final int U = 46;
  public static final int V = 47;
  public static final int W = 50;
  public static final int X = 51;
  public static final int Y = 52;
  public static final int Z = 55;
  private static final int a = 22578;
  public static final int[][] a = { { 2130839418, 2131427368 }, { 2130839421, 2131427369 }, { 2130839424, 2131427370 } };
  public static final int aA = 65;
  public static final int aB = 66;
  public static final int aC = 67;
  public static final int aD = 68;
  public static final int aE = 84;
  public static final int aF = 87;
  public static final int aG = 4;
  public static final int aH = 5;
  public static final int aI = 6;
  public static final int aJ = 7;
  public static final int aK = 8;
  public static final int aL = 9;
  public static final int aM = 10;
  public static final int aN = 12;
  public static final int aO = 14;
  public static final int aP = 15;
  public static final int aQ = 16;
  public static final int aR = 17;
  public static final int aS = 18;
  public static final int aT = 19;
  public static final int aU = 30;
  public static final int aV = 999;
  public static final int aW = 1;
  public static final int aX = 2;
  public static final int aY = 3;
  public static final int aZ = 4;
  public static final int aa = 56;
  public static final int ab = 57;
  public static final int ac = 58;
  public static final int ad = 60;
  public static final int ae = 61;
  public static final int af = 70;
  public static final int ag = 73;
  public static final int ah = 74;
  public static final int ai = 75;
  public static final int aj = 75;
  public static final int ak = 7;
  public static final int al = 800;
  public static final int am = 803;
  public static final int an = 804;
  public static final int ao = 880;
  public static final int ap = 881;
  public static final int aq = 1;
  public static final int ar = 2;
  public static final int as = 3;
  public static final int at = 4;
  public static final int au = 1;
  public static final int av = 57;
  public static final int aw = 59;
  public static final int ax = 60;
  public static final int ay = 61;
  public static final int az = 64;
  public static final int ba = 5;
  public static final int bb = 6;
  public static final int bc = 100;
  public static final int bd = 101;
  public static final int be = 102;
  public static final int bf = 103;
  protected static final String f = "http://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=tmsglist";
  protected static final String g = "http://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=account";
  public static final int h = 1000;
  protected static final String h = "http://fwd.z.qq.com:8080/forward.jsp?bid=255&g_f=5471&3g_sid=%s";
  public static final int i = 1001;
  public static final String i = "http://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027";
  public static final int j = 1002;
  public static final String j = "http://activeqq.3g.qq.com/activeQQ/mqq/modify_qqinfo_wap2.jsp?sid=%s&qq=%s&appid=%s&version=%s&g_f=10160";
  public static final int k = 1003;
  public static final String k = "http://fwd.3g.qq.com:8080/forward.jsp?bid=590&sid=%s";
  public static final int l = 1004;
  public static final String l = "http://xiangji.qq.com/downloading.php?chid=0041&sid=%s";
  public static final int m = 1005;
  protected static final String m = "http://m.qzone.com/l?sid=%s&g_f=22578&g=41&B_UID=%s";
  public static final int n = 1006;
  protected static final String n = "http://m.qzone.com/l?g=119&sid=%s&res_uin=%s&g_f=2000000082";
  public static final int o = 1007;
  protected static final String o = "http://mapp.3g.qq.com/touch/album/index.jsp";
  public static final int p = 1008;
  protected static final String p = "http://mapp.3g.qq.com/touch/album/index.jsp?B_UID=%s&sid=%s";
  public static final int q = 1009;
  protected static final String q = "http://sqq.3g.qq.com/html5/andr_mq/index.jsp?sid=%s&from=android&qq=%s&g_f=20183&rm=6005";
  public static final int r = 1010;
  protected static final String r = "http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123";
  public static final int s = 1011;
  protected static final String s = "http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka";
  public static final int t = 1012;
  protected static final String t = "http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon";
  public static final int u = 1013;
  protected static final String u = "http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromshezhi";
  public static final int v = 1014;
  public static final String v = "http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017";
  public static final int w = 0;
  protected static final String w = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
  public static final int x = 1;
  protected static final String x = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
  public static final int y = 2;
  protected static final String y = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int z = 3;
  protected static final String z = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 57) {
      return 57;
    }
    if (paramInt == 59) {
      return 59;
    }
    if (paramInt == 60) {
      return 60;
    }
    if (paramInt == 61) {
      return 61;
    }
    if (paramInt == 64) {
      return 64;
    }
    if (paramInt == 65) {
      return 65;
    }
    if (paramInt == 66) {
      return 66;
    }
    if (paramInt == 67) {
      return 67;
    }
    if (paramInt == 68) {
      return 68;
    }
    if (paramInt == 84) {
      return 84;
    }
    if (paramInt == 87) {
      return 87;
    }
    return 999;
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 0) {
      return 2;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static long a(ProfileActivity.AllInOne paramAllInOne)
  {
    long l1 = 0L;
    if (ProfileActivity.AllInOne.a(paramAllInOne)) {
      l1 = 0L | 1L;
    }
    long l2 = l1 | 0x4;
    l1 = l2;
    if (ProfileActivity.AllInOne.f(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    return l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
  }
  
  public static Intent a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramAllInOne != null) && (BmqqSegmentUtil.a(paramContext, paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, BmqqProfileCardActivity.class);
    }
    if (((paramContext instanceof BaseActivity)) && (CrmUtils.c(((BaseActivity)paramContext).app, paramAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramContext = new Intent(paramContext, EnterpriseDetailActivity.class);
      paramContext.putExtra("uin", paramAllInOne.jdField_a_of_type_JavaLangString);
      paramContext.putExtra("need_finish", true);
      return paramContext;
    }
    return new Intent(paramContext, FriendProfileCardActivity.class);
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    Object localObject = new File(AppConstants.as + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = Uri.fromFile(new File(AppConstants.as + "photo/" + System.currentTimeMillis() + ".jpg"));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localObject;
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */