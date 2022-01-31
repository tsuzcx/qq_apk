package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static final int A = 26;
  public static final String A = "source_to_profile";
  public static final int B = 27;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 33;
  public static final int G = 34;
  public static final int H = 35;
  public static final int I = 36;
  public static final int J = 40;
  public static final int K = 41;
  public static final int L = 42;
  public static final int M = 45;
  public static final int N = 46;
  public static final int O = 47;
  public static final int P = 50;
  public static final int Q = 51;
  public static final int R = 52;
  public static final int S = 55;
  public static final int T = 56;
  public static final int U = 57;
  public static final int V = 58;
  public static final int W = 60;
  public static final int X = 61;
  public static final int Y = 70;
  public static final int Z = 71;
  private static final int a = 22578;
  protected static final String a = "http://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=tmsglist";
  public static final int[][] a = { { 2130840272, 2131361842 }, { 2130840275, 2131361843 }, { 2130840278, 2131361844 } };
  public static final int aA = 999;
  public static final int aB = 4;
  public static final int aC = 5;
  public static final int aD = 6;
  public static final int aE = 7;
  public static final int aF = 8;
  public static final int aG = 9;
  public static final int aH = 1;
  public static final int aI = 2;
  public static final int aJ = 3;
  public static final int aK = 4;
  public static final int aL = 5;
  public static final int aM = 6;
  public static final int aN = 100;
  public static final int aO = 101;
  public static final int aP = 102;
  public static final int aQ = 103;
  public static final int aa = 72;
  public static final int ab = 73;
  public static final int ac = 74;
  public static final int ad = 75;
  public static final int ae = 76;
  public static final int af = 800;
  public static final int ag = 803;
  public static final int ah = 804;
  public static final int ai = 880;
  public static final int aj = 881;
  public static final int ak = 1;
  public static final int al = 2;
  public static final int am = 3;
  public static final int an = 4;
  public static final int ao = 1;
  public static final int ap = 57;
  public static final int aq = 59;
  public static final int ar = 60;
  public static final int as = 61;
  public static final int at = 64;
  public static final int au = 65;
  public static final int av = 66;
  public static final int aw = 67;
  public static final int ax = 68;
  public static final int ay = 84;
  public static final int az = 87;
  protected static final String b = "http://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=account";
  protected static final String c = "http://fwd.z.qq.com:8080/forward.jsp?bid=255&g_f=5471&3g_sid=%s";
  public static final int d = 1000;
  public static final String d = "http://activeqq.3g.qq.com/activeQQ/mqq/_qqinfo_wap20.jsp?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s";
  public static final int e = 1001;
  public static final String e = "http://activeqq.3g.qq.com/activeQQ/mqq/modify_qqinfo_wap2.jsp?sid=%s&qq=%s&appid=%s&version=%s&g_f=10160";
  public static final int f = 1002;
  public static final String f = "http://fwd.3g.qq.com:8080/forward.jsp?bid=590&sid=%s";
  public static final int g = 1003;
  public static final String g = "http://xiangji.qq.com/downloading.php?chid=0041&sid=%s";
  public static final int h = 1004;
  protected static final String h = "http://m.qzone.com/l?sid=%s&g_f=22578&g=41&B_UID=%s";
  public static final int i = 1005;
  protected static final String i = "http://m.qzone.com/l?g=119&sid=%s&res_uin=%s&g_f=2000000082";
  public static final int j = 1006;
  protected static final String j = "http://mapp.3g.qq.com/touch/album/index.jsp";
  public static final int k = 1007;
  protected static final String k = "http://mapp.3g.qq.com/touch/album/index.jsp?B_UID=%s&sid=%s";
  public static final int l = 1008;
  protected static final String l = "http://sqq.3g.qq.com/html5/andr_mq/index.jsp?sid=%s&from=android&qq=%s&g_f=20183&rm=6005";
  public static final int m = 1009;
  protected static final String m = "http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s";
  public static final int n = 1010;
  protected static final String n = "http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka";
  public static final int o = 1011;
  protected static final String o = "http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon";
  public static final int p = 1012;
  protected static final String p = "http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromshezhi";
  public static final int q = 0;
  public static final String q = "http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017";
  public static final int r = 1;
  protected static final String r = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
  public static final int s = 2;
  protected static final String s = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
  public static final int t = 3;
  protected static final String t = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int u = 4;
  protected static final String u = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
  public static final int v = 19;
  protected static final String v = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
  public static final int w = 20;
  protected static final String w = "http://sqq.3g.qq.com/html5/andr_mq2/index.jsp&sid=%s&g_f=20184&rm=6005";
  public static final int x = 21;
  protected static final String x = "http://sqq.3g.qq.com/html5/andr_mq/index.jsp?qq=%s&sid=%s&from=android&g_f=20183&rm=6005";
  public static final int y = 22;
  public static final String y = "com.tencent.mobileqq.action.template_setup";
  public static final int z = 25;
  public static final String z = "AllInOne";
  
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
    if (paramAllInOne.a == 0) {
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
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    Object localObject1 = new File(AppConstants.an + "photo/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    paramActivity.startActivityForResult((Intent)localObject1, paramInt);
    return localObject2;
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, FriendProfileCardActivity.class);
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
      Intent localIntent = new Intent(paramContext, FriendProfileCardActivity.class);
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
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, FriendProfileCardActivity.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */