import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneVipInfoManager.3;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

public class avqy
{
  private static avqy a;
  private static Object lock = new Object();
  private String cNe;
  private String cNf;
  private volatile boolean dot;
  private int exZ = -1;
  private SharedPreferences l;
  
  private avqy()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      this.l = localBaseApplicationImpl.getSharedPreferences("QZONE_VIP_INFO", i);
      if (this.l != null) {
        this.l.registerOnSharedPreferenceChangeListener(new avqz(this));
      }
      return;
    }
  }
  
  private void WJ(boolean paramBoolean)
  {
    if ((this.exZ >= 0) && (!paramBoolean)) {}
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        return;
      } while (this.l == null);
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    this.exZ = this.l.getInt(bU(localAppRuntime.getAccount()), 0);
    this.cNe = this.l.getString(bV(localAppRuntime.getAccount()), null);
    this.cNf = this.l.getString(bW(localAppRuntime.getAccount()), null);
  }
  
  public static avqy a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new avqy();
      }
      return a;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    String str = paramActivity.getResources().getString(2131718272);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString2);
    localIntent.putExtra("source", paramString3);
    localIntent.putExtra("viptype", paramInt1);
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("month", paramInt2);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1, null, false, null, true);
  }
  
  public static int aY(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = f(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  public static int aZ(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = f(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  private String bU(String paramString)
  {
    return "key_vip_info_bitmap_pre" + paramString;
  }
  
  private String bV(String paramString)
  {
    return "key_vip_info_personalized_vip_pre" + paramString;
  }
  
  private String bW(String paramString)
  {
    return "key_vip_info_custom_diamond_url_pre" + paramString;
  }
  
  public static int ba(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = f(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int bb(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = f(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int bc(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = f(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int bd(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = f(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public static int be(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = f(paramInt1, paramInt2, 26, 29);
      }
    }
    return i;
  }
  
  private void cvg()
  {
    WJ(false);
  }
  
  private void dSD()
  {
    if (this.l != null)
    {
      SharedPreferences.Editor localEditor = this.l.edit();
      if (localEditor != null)
      {
        this.dot = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (localAppRuntime != null)
        {
          localEditor.putInt(bU(localAppRuntime.getAccount()), this.exZ);
          localEditor.putString(bV(localAppRuntime.getAccount()), this.cNe);
          localEditor.putString(bW(localAppRuntime.getAccount()), this.cNf);
          localEditor.commit();
        }
      }
    }
  }
  
  public static void eT(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new QZoneVipInfoManager.3(paramQQAppInterface));
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1 << paramInt4 + 1 & paramInt1 | paramInt2 << paramInt3 | (1 << paramInt3) - 1 & paramInt1;
  }
  
  public static void h(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, "cm", 2, 1);
  }
  
  public static int lo(int paramInt)
  {
    return w(paramInt, 0, 1);
  }
  
  public static int lp(int paramInt)
  {
    return w(paramInt, 2, 5);
  }
  
  public static int lq(int paramInt)
  {
    return w(paramInt, 7, 8);
  }
  
  public static int lr(int paramInt)
  {
    return w(paramInt, 9, 12);
  }
  
  public static int ls(int paramInt)
  {
    return w(paramInt, 14, 16);
  }
  
  public static int lt(int paramInt)
  {
    return w(paramInt, 17, 20);
  }
  
  public static int lu(int paramInt)
  {
    return w(paramInt, 26, 29);
  }
  
  public static boolean nA(int paramInt)
  {
    return w(paramInt, 23, 23) != 0;
  }
  
  public static boolean nB(int paramInt)
  {
    return w(paramInt, 24, 24) != 0;
  }
  
  public static boolean nC(int paramInt)
  {
    return w(paramInt, 25, 25) != 0;
  }
  
  public static boolean nw(int paramInt)
  {
    return w(paramInt, 6, 6) != 0;
  }
  
  public static boolean nx(int paramInt)
  {
    return w(paramInt, 13, 13) != 0;
  }
  
  public static boolean ny(int paramInt)
  {
    return w(paramInt, 21, 21) != 0;
  }
  
  public static boolean nz(int paramInt)
  {
    return w(paramInt, 22, 22) != 0;
  }
  
  public static int s(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 6, 6);
    }
  }
  
  public static int t(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 13, 13);
    }
  }
  
  public static int u(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 21, 21);
    }
  }
  
  public static int v(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 22, 22);
    }
  }
  
  private static int w(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3 - paramInt2 + 1)
    {
    default: 
      paramInt3 = 0;
    }
    while (paramInt3 == 0)
    {
      return 0;
      paramInt3 = 1;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
      continue;
      paramInt3 = 15;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  public static int w(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 23, 23);
    }
  }
  
  public static int x(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 24, 24);
    }
  }
  
  public static int y(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return f(paramInt, i, 25, 25);
    }
  }
  
  public String Gf()
  {
    cvg();
    return this.cNf;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info)
  {
    boolean bool2 = true;
    WJ(true);
    this.exZ = aY(this.exZ, paramInt1);
    this.exZ = aZ(this.exZ, paramInt2);
    paramInt1 = this.exZ;
    if (paramInt3 != 0)
    {
      bool1 = true;
      this.exZ = s(paramInt1, bool1);
      if (paramstar_info != null)
      {
        this.exZ = ba(this.exZ, paramstar_info.iStarStatus);
        this.exZ = bb(this.exZ, paramstar_info.iStarLevel);
        paramInt1 = this.exZ;
        if (paramstar_info.isAnnualVip == 0) {
          break label317;
        }
        bool1 = true;
        label107:
        this.exZ = t(paramInt1, bool1);
        paramInt1 = this.exZ;
        if (paramstar_info.isHighStarVip == 0) {
          break label323;
        }
        bool1 = true;
        label133:
        this.exZ = w(paramInt1, bool1);
      }
      if (paramcombine_diamond_info != null)
      {
        this.exZ = bc(this.exZ, paramcombine_diamond_info.iShowType);
        this.exZ = bd(this.exZ, paramcombine_diamond_info.iVipLevel);
        paramInt1 = this.exZ;
        if (paramcombine_diamond_info.isAnnualVip == 0) {
          break label329;
        }
        bool1 = true;
        label196:
        this.exZ = u(paramInt1, bool1);
        paramInt1 = this.exZ;
        if (paramcombine_diamond_info.isAnnualVipEver == 0) {
          break label335;
        }
      }
    }
    label317:
    label323:
    label329:
    label335:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.exZ = v(paramInt1, bool1);
      paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
      paramcombine_diamond_info = new Bundle();
      paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.exZ);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.cNe);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoCustomDiamondUrl", this.cNf);
      paramstar_info.putExtras(paramcombine_diamond_info);
      BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
      dSD();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label107;
      bool1 = false;
      break label133;
      bool1 = false;
      break label196;
    }
  }
  
  public boolean aLr()
  {
    return getVipType() == 2;
  }
  
  public int getVipLevel()
  {
    cvg();
    return lp(this.exZ);
  }
  
  public int getVipType()
  {
    cvg();
    return lo(this.exZ);
  }
  
  public boolean isAnnualVip()
  {
    cvg();
    return nw(this.exZ);
  }
  
  public void setVipType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      cvg();
      this.exZ = aY(this.exZ, paramInt);
      dSD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqy
 * JD-Core Version:    0.7.0.1
 */