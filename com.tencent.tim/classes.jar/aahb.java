import MWIFI.SCGet3rdCloudCheck;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.recent.BannerManager.41;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.a;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import cooperation.qlink.QlAndQQInterface.WorkState;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aahb
  implements Handler.Callback
{
  public static final boolean aTl = AppSetting.enableTalkBack;
  public long LT;
  public long LU;
  private aaje jdField_a_of_type_Aaje;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private aagz[] jdField_a_of_type_ArrayOfAagz = new aagz[42];
  private volatile aahb.d jdField_b_of_type_Aahb$d;
  private ajdo.a jdField_b_of_type_Ajdo$a;
  private SparseArray<ArrayList<Integer>> bO;
  private SparseArray<ArrayList<Integer>> bP;
  private String bcZ = "";
  public String bda;
  public String bdb;
  public String bdc;
  public String bdd;
  private boolean bvB = true;
  private boolean bvC;
  public boolean bvD;
  public boolean bvE;
  public boolean bvF;
  public boolean bvG;
  private boolean bvH;
  private boolean bvI = true;
  public boolean bvJ;
  private volatile aahb.d c;
  public int cgH;
  public int cgI;
  public int cgJ;
  private MqqHandler g = new aqgw(this);
  boolean isDestroy = false;
  private XListView mListView;
  public float rp;
  
  public aahb(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.mListView = paramXListView;
    if (this.cgJ == 0) {
      this.cgJ = wja.dp2px(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
  }
  
  private void FV(int paramInt)
  {
    int i = 28;
    if (i <= 35)
    {
      if (this.jdField_a_of_type_ArrayOfAagz[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfAagz[i].state == 2) {
          if (i != paramInt)
          {
            gn(i, paramInt);
            this.jdField_a_of_type_ArrayOfAagz[i].state = 0;
          }
          else if ((i == 35) && (this.jdField_b_of_type_Aahb$d != null) && (!this.c.equals(this.jdField_b_of_type_Aahb$d)))
          {
            gn(i, paramInt);
          }
        }
      }
    }
  }
  
  private boolean Q(View paramView)
  {
    aehp localaehp = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localaehp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      initConfig();
      return false;
    }
    int m = localaehp.hc(0);
    if (m > 0)
    {
      ((ADView)paramView.findViewById(2131362278)).ehD();
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (a(localaehp, i, paramView)) {
          k = j + 1;
        }
        i += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + j);
      }
      if (j > 0)
      {
        cul();
        return true;
      }
    }
    return false;
  }
  
  private boolean Wq()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private boolean Wr()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  @Nullable
  public static aahb.d a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, aahb.b paramb)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new aahb.d(1, paramString1, paramInt, paramString2, paramb);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(aagz paramaagz)
  {
    if ((paramaagz == null) || (paramaagz.view != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramaagz.cgG;
        switch (i)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramaagz.view = bl();
        continue;
        paramaagz.view = aX();
        continue;
        paramaagz.view = bn();
        continue;
        paramaagz.view = bj();
        continue;
        paramaagz.view = bh();
        continue;
        paramaagz.view = bg();
        continue;
        paramaagz.view = bi();
        continue;
        paramaagz.view = bm();
        continue;
        paramaagz.view = bp();
        continue;
        paramaagz.view = bo();
        continue;
        paramaagz.view = bo();
        continue;
        paramaagz.view = by();
        continue;
        paramaagz.view = bq();
        continue;
        paramaagz.view = bB();
        continue;
        paramaagz.view = aZ();
        continue;
        paramaagz.view = bA();
        continue;
        paramaagz.view = bk();
        continue;
        paramaagz.view = bD();
        continue;
        paramaagz.view = br();
        continue;
        paramaagz.view = bs();
        continue;
        paramaagz.view = bt();
        continue;
        paramaagz.view = bu();
        continue;
        paramaagz.view = bw();
        continue;
        paramaagz.view = bv();
        continue;
        paramaagz.view = bx();
        continue;
        paramaagz.view = bz();
        continue;
        paramaagz.view = bC();
        continue;
        paramaagz.view = bd();
        continue;
        paramaagz.view = be();
        continue;
        paramaagz.view = bf();
        continue;
        paramaagz.view = bc();
        continue;
        paramaagz.view = bb();
        continue;
        paramaagz.view = ba();
        continue;
        paramaagz.view = bE();
        continue;
        paramaagz.view = bF();
        continue;
        paramaagz.view = bG();
        continue;
        paramaagz.view = aY();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramaagz);
      return;
      paramaagz.view = bi();
    }
  }
  
  private void a(aagz paramaagz, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramaagz).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramaagz.cgG == 35) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramaagz == null) || (paramaagz.view == null)) {
      label83:
      return;
    }
    TextHook.updateFont(paramaagz.view);
    for (;;)
    {
      try
      {
        switch (paramaagz.cgG)
        {
        case 5: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 40: 
          if (!(paramaagz.view instanceof TipsBar)) {
            break label83;
          }
          a((TipsBar)paramaagz.view);
          return;
        }
      }
      catch (Throwable paramaagz)
      {
        paramaagz.printStackTrace();
        return;
      }
      fY(paramaagz.view);
      continue;
      k(paramaagz.view, paramMessage);
      continue;
      g(paramaagz.view, paramMessage);
      continue;
      j(paramaagz.view, paramMessage);
      continue;
      f(paramaagz.view, paramMessage);
      continue;
      fX(paramaagz.view);
      continue;
      l(paramaagz.view, paramMessage);
      continue;
      fZ(paramaagz.view);
      continue;
      paramaagz.view.findViewById(2131381303).setVisibility(0);
      continue;
      paramaagz.view.findViewById(2131381303).setVisibility(0);
      continue;
      t(paramaagz.view, paramMessage);
      continue;
      ga(paramaagz.view);
      continue;
      n(paramaagz.view, paramMessage);
      continue;
      o(paramaagz.view, paramMessage);
      continue;
      p(paramaagz.view, paramMessage);
      continue;
      r(paramaagz.view, paramMessage);
      continue;
      q(paramaagz.view, paramMessage);
      continue;
      s(paramaagz.view, paramMessage);
      continue;
      u(paramaagz.view, paramMessage);
      continue;
      gb(paramaagz.view);
      continue;
      a(paramaagz.view, paramMessage);
      continue;
      b(paramaagz.view, paramMessage, paramaagz.state);
      continue;
      a(paramaagz.view, paramMessage, paramaagz.state);
      continue;
      gc(paramaagz.view);
      continue;
      d(paramaagz.view, paramMessage);
      continue;
      e(paramaagz.view, paramMessage);
      continue;
      i(paramaagz.view, paramMessage);
      continue;
      c(paramaagz.view, paramMessage);
      continue;
      b(paramaagz.view, paramMessage);
      continue;
      aeaq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, paramaagz.view);
      continue;
      m(paramaagz.view, paramMessage);
      continue;
      w(paramaagz.view, paramMessage);
      continue;
      v(paramaagz.view, paramMessage);
      continue;
      gd(paramaagz.view);
      continue;
      h(paramaagz.view, paramMessage);
    }
  }
  
  private void a(View paramView, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_Aaje != null) {
        this.jdField_a_of_type_Aaje.cuG();
      }
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof yut))) {
      return;
    }
    anot.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131374851).setVisibility(0);
    paramMessage = (yut)paramMessage.obj;
    ((TextView)paramView.findViewById(2131363293)).setText(paramMessage.text);
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramView.setOnClickListener(new aaiq(this, paramMessage));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_plguinType", -1);
    String str1 = paramIntent.getStringExtra("banner_pluginId");
    String str2 = paramIntent.getStringExtra("banner_pluginName");
    String str3 = paramIntent.getStringExtra("banner_pluginProxyActivityName");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("banner_pluginIntent");
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (i < 0) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (localIntent == null) || (j < 0))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from plugin, " + paramString1 + " / " + paramString2 + " / " + paramString3 + " / " + i + " / " + str1 + " / " + str2 + " / " + str3 + " / " + localIntent + " / " + j);
      return;
    }
    paramIntent = new aahb.h(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.getCurrentUin(), i);
    paramIntent.a(a(paramQQAppInterface, j, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from webview, " + paramString1 + " / " + paramString2 + " / " + paramString3);
      return;
    }
    try
    {
      String str1 = new URL(paramString3).getHost();
      paramString3 = new aahb.i(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = aaha.bU(str1);
      }
      paramString3.a(a(paramQQAppInterface, paramInt2, paramString1, paramString2, paramString3));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private void a(TipsBar paramTipsBar, int paramInt)
  {
    if ((paramInt == 2) && (this.bvH == true) && ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false))))
    {
      paramTipsBar.setBarType(6);
      return;
    }
    paramTipsBar.setBarType(paramInt);
  }
  
  private static void a(String paramString1, Intent paramIntent, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    paramString1 = new aahb.a(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, i, paramString2, paramString3, paramString1));
  }
  
  private boolean a(aehp paramaehp, int paramInt, View paramView)
  {
    anqr localanqr = new anqr(paramaehp.h(0, paramInt), paramaehp.E(0, paramInt), paramaehp.a(0, paramInt));
    localanqr.cgV = paramaehp.D(0, paramInt);
    localanqr.md5 = paramaehp.F(0, paramInt);
    boolean bool = localanqr.pD(paramaehp.D(0, paramInt));
    if ((localanqr.time != null) && (localanqr.time.contains("|")) && (!aqcv.D(Long.parseLong(localanqr.time.substring(0, localanqr.time.indexOf("|"))), Long.parseLong(localanqr.time.substring(localanqr.time.indexOf("|") + 1))))) {}
    label468:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localanqr.cgT)))
      {
        localanqr.a = aqik.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localanqr.cgT);
        if (localanqr.a == null) {}
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label468;
          }
          Object localObject = paramaehp.g(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramaehp = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559851, null);
          ImageView localImageView = (ImageView)paramaehp.findViewById(2131362054);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          i = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramaehp.findViewById(2131373862);
          ((ImageView)localObject).setTag(localanqr);
          ((ImageView)localObject).setContentDescription(acfp.m(2131703042));
          ((ImageView)localObject).setOnClickListener(new aain(this));
          paramaehp.setTag(localanqr);
          ((ADView)paramView.findViewById(2131362278)).av(paramaehp, paramInt);
          paramView.setTag(2131362278, localanqr.id);
          return true;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aahb.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramd);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramd;
      paramQQAppInterface.sendMessage(localMessage);
      return true;
    }
    return false;
  }
  
  private void aI(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof aahb.d)) {}
    do
    {
      return;
      int i = ((aahb.d)paramMessage.obj).cgO;
    } while (!paramMessage.obj.equals(this.jdField_b_of_type_Aahb$d));
    gm(35, 0);
    d(35, paramMessage);
  }
  
  private void aJ(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof aahb.d)) {
      return;
    }
    int i = ((aahb.d)paramMessage.obj).cgO;
    this.c = ((aahb.d)paramMessage.obj);
    gm(35, 2);
    this.jdField_b_of_type_Aahb$d = this.c;
    d(35, paramMessage);
    c((aahb.d)paramMessage.obj);
  }
  
  private View aY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View aZ()
  {
    if (this.jdField_a_of_type_Aaje != null) {
      return this.jdField_a_of_type_Aaje.bH();
    }
    return null;
  }
  
  private void b(aahb.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramd);
    }
    Message localMessage = this.g.obtainMessage(201);
    localMessage.obj = paramd;
    this.g.sendMessage(localMessage);
  }
  
  private void b(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    a(paramView);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramView.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).csl);
    }
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (alkm)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(38);
    if (paramMessage != null) {}
    for (int i = paramMessage.HD();; i = 0)
    {
      if (i == 0) {}
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramView.getVisibility() != 0);
        paramView.setVisibility(8);
        return;
        paramView.findViewById(2131374849).setVisibility(0);
        ((TextView)paramView.findViewById(2131374850)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131700816), new Object[] { Integer.valueOf(i) }));
      } while (i > 0);
      this.g.sendEmptyMessage(7);
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = 0;
    if ((!paramIntent.hasExtra("banner_businessCategory")) || (!paramIntent.hasExtra("banner_wording"))) {
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_businessCategory");
    String str2 = paramIntent.getStringExtra("banner_wording");
    String str3 = paramIntent.getStringExtra("banner_webViewUrl");
    String str4 = paramIntent.getStringExtra("banner_activityName");
    String str5 = paramIntent.getStringExtra("banner_fragmentName");
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    int k = paramIntent.getIntExtra("banner_activityFlag", 0);
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("banner_pendingIntent");
    Bundle localBundle = paramIntent.getBundleExtra("banner_webview_extra");
    boolean bool = paramIntent.getBooleanExtra("force_no_reload", false);
    if (!TextUtils.isEmpty(str3)) {
      i = 1;
    }
    if (str5 != null)
    {
      a(str5, paramIntent, paramQQAppInterface, str1, str2);
      return;
    }
    if (i != 0)
    {
      a(paramQQAppInterface, str1, str2, str3, str4, j, k, localBundle, bool);
      return;
    }
    if (str1.equals("readinjoy_video_feeds"))
    {
      msk.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
      return;
    }
    if (localPendingIntent == null)
    {
      a(paramQQAppInterface, paramIntent, str1, str2, str4);
      return;
    }
    b(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (i < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from pendingIntent, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + i);
      return;
    }
    paramIntent = new aahb.g(paramPendingIntent, paramQQAppInterface);
    paramIntent.a(a(paramQQAppInterface, i, paramString1, paramString2, paramIntent));
  }
  
  private View bA()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839723));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719613));
    localTipsBar.setOnClickListener(new aaih(this));
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return localTipsBar;
  }
  
  private View bB()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559850, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131373858).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131364677)).setOnClickListener(new aaii(this));
    return localView;
  }
  
  private View bC()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845903));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131700851));
    localTipsBar.setOnClickListener(new aaij(this));
    return localTipsBar;
  }
  
  private View bD()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562053, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131375282);
    localView.setOnClickListener(new aaik(this));
    localImageView.setOnClickListener(new aaim(this));
    return localView;
  }
  
  private void bD(QQAppInterface paramQQAppInterface)
  {
    gm(15, 0);
    this.g.removeMessages(11);
    if ((this.jdField_b_of_type_Ajdo$a != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_b_of_type_Ajdo$a);
      this.jdField_b_of_type_Ajdo$a = null;
    }
  }
  
  private View bE()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.TB(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void bE(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_b_of_type_Aahb$d);
    }
    if ((this.jdField_b_of_type_Aahb$d != null) && (this.jdField_b_of_type_Aahb$d.a.isNeedAutoCloseWhenAccountChange())) {
      b(this.jdField_b_of_type_Aahb$d);
    }
  }
  
  private View bF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838366));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bG()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847863));
    localTipsBar.showArrow(true);
    localTipsBar.setOnClickListener(new aaip(this));
    return localTipsBar;
  }
  
  private View ba()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131701612));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839515));
    localTipsBar.setButtonText(acfp.m(2131703038));
    localTipsBar.getButton().setBackgroundResource(0);
    localTipsBar.getButton().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167312));
    localTipsBar.setOriginalOnClickListener(new aait(this));
    localTipsBar.setOnClickListener(new aaiu(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bb()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130851655));
    localTipsBar.TB(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.csl);
    localTipsBar.setOnClickListener(new aahd(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new aahe(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bc()
  {
    return adrm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private View bd()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692355));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838366));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View be()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130851625));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838609));
    localTipsBar.setTipsText(acfp.m(2131703036));
    localTipsBar.setVisibility(8);
    localTipsBar.TB(true);
    localTipsBar.setOnClickListener(new aahf(this));
    localTipsBar.setCloseListener(new aahg(this));
    return localTipsBar;
  }
  
  private View bg()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130842136));
    localTipsBar.setOnClickListener(new aahj(this, localTipsBar));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bh()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561141, null);
    localView.setOnClickListener(new aahk(this));
    localView.findViewById(2131374704).setVisibility(8);
    return localView;
  }
  
  private View bi()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696276));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838366));
    localTipsBar.setOnClickListener(new aahl(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bj()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696271));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838366));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bk()
  {
    AdvancedTipsBar localAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localAdvancedTipsBar, 2);
    aeaq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAdvancedTipsBar);
    return localAdvancedTipsBar;
  }
  
  private View bl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561233, null);
    ((TextView)localView.findViewById(2131374850)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131700816));
    localView.findViewById(2131374849).setVisibility(8);
    return localView;
  }
  
  private View bm()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562245, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private View bn()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561075, null);
    localView.findViewById(2131382270).setOnClickListener(new aahm(this));
    localView.findViewById(2131382269).setVisibility(8);
    return localView;
  }
  
  private View bo()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563298, null);
    TextView localTextView = (TextView)localView.findViewById(2131381304);
    localTextView.setOnClickListener(new aaho(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131721583));
    ((ImageView)localView.findViewById(2131364704)).setOnClickListener(new aahq(this));
    localView.findViewById(2131381303).setVisibility(8);
    return localView;
  }
  
  private View bp()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839267));
    localTipsBar.TB(true);
    localTipsBar.setCloseListener(new aahr(this));
    localTipsBar.setOnClickListener(new aahs(this));
    return localTipsBar;
  }
  
  private View bq()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559116, null);
    View localView2 = localView1.findViewById(2131365439);
    localView1.setOnClickListener(new aaht(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private View br()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130842136));
    localTipsBar.setOnClickListener(new aahu(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bs()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130842135));
    localTipsBar.TB(true);
    localTipsBar.setOnClickListener(new aahv(this));
    localTipsBar.setCloseListener(new aahb.c(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View bt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.TB(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838448));
    return localTipsBar;
  }
  
  private View bu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsText(acfp.m(2131703043));
    localTipsBar.TB(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838449));
    return localTipsBar;
  }
  
  private View bv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558695, null);
    localView.findViewById(2131362525).setVisibility(8);
    return localView;
  }
  
  private View bw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558697, null);
    localView.findViewById(2131362552).setVisibility(8);
    return localView;
  }
  
  private View bx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    a(localTipsBar, 2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838441));
    localTipsBar.setVisibility(8);
    localTipsBar.TB(true);
    return localTipsBar;
  }
  
  private View by()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131563297, null);
    TextView localTextView = (TextView)localView.findViewById(2131381304);
    localTextView.setOnClickListener(new aaie(this));
    localTextView.setText("");
    if (AppSetting.enableTalkBack) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131721584));
    }
    ((ImageView)localView.findViewById(2131364685)).setOnClickListener(new aaif(this));
    localView.findViewById(2131381303).setVisibility(8);
    return localView;
  }
  
  private View bz()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559676, null);
    localView.setOnClickListener(new aaig(this));
    localView.findViewById(2131372076).setVisibility(8);
    return localView;
  }
  
  private void c(aahb.d paramd)
  {
    this.g.removeMessages(201);
    Message localMessage = this.g.obtainMessage(201);
    localMessage.obj = paramd;
    this.g.sendMessageDelayed(localMessage, 900000L);
  }
  
  private void c(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      paramView.setOnClickListener(new aahp(this));
    }
  }
  
  private void cul()
  {
    this.g.removeMessages(101);
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l = localCalendar.getTimeInMillis() - (l - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l);
    }
    this.g.sendEmptyMessageDelayed(101, l);
  }
  
  private void cum()
  {
    gm(33, 0);
    d(33, null);
  }
  
  private void cun()
  {
    if (this.bO == null) {
      return;
    }
    int i = 0;
    label10:
    Object localObject;
    if (i < 6)
    {
      localObject = (ArrayList)this.bO.get(i);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label46:
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int j = ((Integer)((Iterator)localObject).next()).intValue();
        aagz localaagz = this.jdField_a_of_type_ArrayOfAagz[j];
        if ((localaagz != null) && (localaagz.view != null) && (localaagz.bvz))
        {
          this.mListView.removeHeaderView(localaagz.view);
          localaagz.bvz = false;
          if (!localaagz.Wm()) {
            localaagz.view = null;
          }
        }
      }
    }
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692355));
      a((TipsBar)paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramMessage = (String)paramMessage.obj;
        anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramView.setOnClickListener(new aaia(this, paramMessage));
        return;
      }
    }
  }
  
  private void e(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localObject != null) {
        break label43;
      }
    }
    label43:
    while ((paramMessage == null) || (paramMessage.obj == null))
    {
      return;
      localObject = null;
      break;
    }
    paramMessage = (Bundle)paramMessage.obj;
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    paramView.setTipsText(paramMessage.getString("expireMsg"));
    int i = paramMessage.getInt("expireType", 4);
    Object localObject = paramMessage.getString("themeId");
    int j = paramMessage.getInt("authResult");
    anot.a(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(i), "", "", "");
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramView.setOnClickListener(new aail(this, j, (String)localObject, i));
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (agrt.a().isPlaying())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697003);
        String str = agrt.a().vI();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
          return;
        }
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void fX(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691997));
  }
  
  private void fY(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696276));
    if (hx(11))
    {
      gm(11, 0);
      this.bdb = null;
      this.cgI = -1;
      this.bdd = null;
    }
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  private void fZ(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {
      return;
    }
    TipsBar localTipsBar = (TipsBar)paramView;
    a(localTipsBar);
    if ((this.bdc != null) && ("1600000104".equals(this.bdc.trim())))
    {
      localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691333));
      return;
    }
    if ((rwr.fd(this.cgI)) && (TextUtils.isEmpty(this.bdd))) {
      this.bdd = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.bdd))
    {
      localTipsBar.setTipsText(this.bdd);
      if (this.cgI != 5) {
        break label218;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839266));
      label126:
      if (this.cgI != 4) {
        break label268;
      }
    }
    label268:
    for (int i = 23;; i = 10)
    {
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", i, 0, "", "", "", "");
      return;
      paramView = "QQ";
      if (this.LU == 77313L) {
        paramView = "TIM";
      }
      localTipsBar.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696747), new Object[] { paramView }));
      break;
      label218:
      if (rwr.fd(this.cgI))
      {
        localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839268));
        break label126;
      }
      localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839267));
      break label126;
    }
  }
  
  private void g(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "https://qq.com")
    {
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new aair(this, paramMessage));
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void ga(View paramView)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (QQPlayerService.isPlaying())
    {
      paramView.setVisibility(0);
      SongInfo localSongInfo = QQPlayerService.a();
      if (localSongInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697003);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.title));
      }
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramView.setVisibility(8);
    gm(36, 0);
    d(-1, null);
  }
  
  private void gb(View paramView)
  {
    paramView.findViewById(2131373858).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362279);
    paramView = (ADView)paramView.findViewById(2131362278);
    if (isPortrait())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.ehE();
    }
    for (;;)
    {
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
      return;
      localRelativeLayout.setPadding(0, -1, 0, 0);
    }
  }
  
  private void gc(View paramView)
  {
    paramView.findViewById(2131375281).setVisibility(0);
    ((TextView)paramView.findViewById(2131375283)).setText(acfp.m(2131703030));
  }
  
  private void gd(View paramView)
  {
    if (!(paramView instanceof TipsBar)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
      return;
    }
    paramView = (TipsBar)paramView;
    a(paramView);
    rwp localrwp = (rwp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(335);
    String str = localrwp.nj();
    if (TextUtils.isEmpty(str))
    {
      cus();
      return;
    }
    paramView.setTipsText(str);
    int i = localrwp.uc();
    if (i == 1)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847865));
      return;
    }
    if (i == 2)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847864));
      return;
    }
    if (i == 3)
    {
      paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847866));
      return;
    }
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847863));
  }
  
  private void gn(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + paramInt1 + " / " + paramInt2);
    }
    if ((paramInt1 == 35) && (this.jdField_b_of_type_Aahb$d != null)) {
      this.jdField_b_of_type_Aahb$d.a.onOverride();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 33);
      localObject = aboy.c();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label177;
      }
      if (((aboy)localObject).f != null) {
        break label146;
      }
    }
    label146:
    for (Object localObject = "-1";; localObject = ((aboy)localObject).f.gameId + "")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label177:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void h(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {}
    while ((paramMessage == null) || (!(paramMessage.obj instanceof String))) {
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    paramView = (TipsBar)paramView;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839597));
    a(paramView);
    paramView.setTipsText(str);
    paramView.setOnClickListener(new aais(this, i));
    paramView.setVisibility(0);
  }
  
  private void i(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateApolloGameBanner: ").append(paramView).append(" / ").append(paramMessage).append(" / ");
      if (paramMessage == null) {
        break label85;
      }
    }
    label85:
    for (Object localObject = paramMessage.obj;; localObject = null)
    {
      QLog.d("Q.recent.banner", 2, localObject);
      if (paramView != null) {
        break;
      }
      return;
    }
    paramView.setVisibility(0);
    if ((paramMessage != null) && ((paramMessage.obj instanceof String)))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.", 2, " updateApolloGameBanner (String) msg.obj:" + (String)paramMessage.obj);
      }
    }
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  private void initConfig()
  {
    ThreadManager.post(new BannerManager.41(this), 5, null, false);
  }
  
  private boolean isPortrait()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private void j(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131374704);
    paramMessage = (TextView)paramView.findViewById(2131374705);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().PC();
      if (i != 0)
      {
        localView.setVisibility(0);
        int j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = acfp.m(2131703034);
        if (1 == j) {
          paramView = acfp.m(2131703044);
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131700543) + paramView + String.valueOf(i) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131700544));
          anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == j) {
            paramView = acfp.m(2131703033);
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void k(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131382270);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131721915);
    }
    for (;;)
    {
      paramView.findViewById(2131382269).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131721914);
      }
    }
  }
  
  private void l(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof altu))
      {
        paramMessage = (altu)paramMessage.obj;
        localObject2 = paramMessage.content;
        localObject1 = (TextView)paramView.findViewById(2131377124);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.iconUrl != null) && (!TextUtils.isEmpty(paramMessage.iconUrl)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130848299);
          localObject2 = URLDrawable.getDrawable(paramMessage.iconUrl, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131377123);
        if ((paramMessage.buttonText != null) && (!TextUtils.isEmpty(paramMessage.buttonText))) {
          ((Button)localObject1).setText(paramMessage.buttonText);
        }
        localObject2 = paramMessage.c;
        localaltq = (altq)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
        if ((paramMessage.bYn != null) && (localObject2 != null) && (localaltq != null))
        {
          ((Button)localObject1).setOnClickListener(new aahn(this, localaltq, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
          this.g.sendEmptyMessageDelayed(9, paramMessage.leftTime);
          a((BusinessInfoCheckUpdate.AppInfo)localObject2, paramMessage.bYn);
          paramView.setVisibility(0);
        }
      }
    }
    while (paramView.getVisibility() != 8)
    {
      Object localObject2;
      Object localObject1;
      altq localaltq;
      return;
    }
    this.g.sendEmptyMessage(9);
  }
  
  private void m(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (FriendsStatusUtil.bc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      if (paramMessage == null) {
        return;
      }
      TipsBar localTipsBar = (TipsBar)paramView;
      if (paramMessage.arg1 == 2)
      {
        localTipsBar.setVisibility(0);
        anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void n(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if (paramMessage == null) {}
    do
    {
      return;
      if (paramMessage.what == 1134059)
      {
        paramView.setVisibility(0);
        paramMessage = (Pair)paramMessage.obj;
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + acfp.m(2131703035)));
        paramView.setTag(paramMessage);
        return;
      }
    } while (paramMessage.what != 1134060);
    if (paramMessage.obj != null)
    {
      paramMessage = (Long)paramMessage.obj;
      Pair localPair = (Pair)paramView.getTag();
      if ((localPair != null) && (((Long)localPair.first).equals(paramMessage)))
      {
        paramView.setVisibility(8);
        gm(34, 0);
      }
    }
    for (;;)
    {
      d(-1, null);
      return;
      paramView.setVisibility(8);
      gm(34, 0);
    }
  }
  
  private void o(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || (paramMessage.what != 1134027)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReaderBar", 2, "updateReaderBar msg " + paramMessage);
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReaderBar", 2, "updateReaderBar msg.obj = " + paramMessage.obj);
        }
      } while (!(paramMessage.obj instanceof String));
      paramMessage = ((String)paramMessage.obj).split("@#");
    } while (paramMessage.length != 3);
    String str1 = paramMessage[0];
    String str2 = paramMessage[2];
    long l = Long.parseLong(paramMessage[1]);
    ((TipsBar)paramView).setTipsText(acfp.m(2131703041) + str1 + "》");
    paramView.setOnClickListener(new aahw(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new aahb.c(13, this.g));
    paramView.setVisibility(0);
    this.g.removeMessages(13);
    this.g.sendEmptyMessageDelayed(13, 900000L);
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  private void p(View paramView, Message paramMessage)
  {
    Object localObject2 = null;
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || (paramMessage.what != 1134043)) {
      if (QLog.isColorLevel()) {
        QLog.d("runningState", 2, "updateRunningBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RunningBar", 2, "updateRunningBar msg.obj = " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof JSONObject)) {}
      try
      {
        Long localLong = Long.valueOf(((JSONObject)paramMessage.obj).getLong("runningState"));
        Object localObject1 = ((JSONObject)paramMessage.obj).getString("cookieUrl");
        String str = ((JSONObject)paramMessage.obj).optString("title");
        ((JSONObject)paramMessage.obj).optInt("actid");
        int i = ((JSONObject)paramMessage.obj).optInt("appid");
        if (localLong.longValue() == 1L)
        {
          ((TipsBar)paramView).setTipsText(acfp.m(2131703040));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramView.setOnClickListener(new aahx(this, (String)localObject1, localLong, i));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, i);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramView instanceof TipsBar)) {
            ((TipsBar)paramView).setCloseListener(new aahb.c(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramView = new Bundle();
            paramMessage.obj = paramView;
            paramMessage = Message.obtain(paramMessage);
            artp.a().a((String)localObject2, new aahy(this, paramView, paramMessage));
          }
          anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramView).setTipsText(acfp.m(2131703032));
            localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
          }
          else
          {
            if (localLong.longValue() == 3L)
            {
              ((TipsBar)paramView).setTipsText(str);
              localObject1 = (String)localObject1 + "&ADTAG=qqlist.tongzhi.hongbao.click";
              localObject2 = ((JSONObject)paramMessage.obj).optString("icon");
              continue;
              if (!(paramMessage.obj instanceof Bundle)) {
                break;
              }
              paramMessage = (Bundle)paramMessage.obj;
              if (!paramMessage.containsKey("icon")) {
                break;
              }
              paramMessage = (Bitmap)paramMessage.getParcelable("icon");
              ((TipsBar)paramView).setTipsIcon(new BitmapDrawable(paramMessage));
              return;
            }
            localObject1 = null;
          }
        }
        return;
      }
      catch (JSONException paramView) {}
    }
  }
  
  private void q(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134041) && (paramMessage.what != 1134042))) {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserBar", 2, "updateBrowserBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134042)
        {
          paramView.setVisibility(8);
          return;
        }
        localTextView = (TextView)paramView.findViewById(2131362528);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int i = paramMessage.getInt("icon");
      if (i != -1) {
        ((ImageView)paramView.findViewById(2131362527)).setImageResource(i);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new aahz(this, paramMessage));
    paramView.findViewById(2131362525).setVisibility(0);
    this.g.removeMessages(15);
    this.g.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private void r(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134039)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComicBar", 2, "updateComicBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    int j;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramView.findViewById(2131362534);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("comicName");
      str = ((Bundle)localObject).getString("comicId");
      j = ((Bundle)localObject).getInt("type", -1);
    } while (TextUtils.isEmpty(paramMessage));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    int k = (int)(localTextView.getPaint().measureText(paramMessage) / paramMessage.length());
    int i;
    if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels)
    {
      i = ((DisplayMetrics)localObject).heightPixels;
      i = (int)((i - ((DisplayMetrics)localObject).density * 65.0F) / k) - 8;
      if (paramMessage.length() <= i) {
        break label437;
      }
      paramMessage = paramMessage.substring(0, i) + "...";
    }
    label437:
    for (;;)
    {
      if ((j >= 100) && (j <= 300)) {
        localTextView.setText(acfp.m(2131703028) + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new aaib(this, str));
        paramView.findViewById(2131362552).setVisibility(0);
        this.g.removeMessages(14);
        this.g.sendEmptyMessageDelayed(14, 900000L);
        anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        i = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(acfp.m(2131703039) + paramMessage + "》");
      }
    }
  }
  
  private void s(View paramView, Message paramMessage)
  {
    if ((paramView instanceof TipsBar)) {
      a((TipsBar)paramView);
    }
    if ((paramMessage == null) || ((paramMessage.what != 1134049) && (paramMessage.what != 1134050))) {
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg.obj = " + paramMessage.obj);
      }
      if (paramMessage.what == 1134050)
      {
        paramView.setVisibility(8);
        return;
      }
      if (((paramMessage.obj instanceof Bundle)) && ((paramView instanceof TipsBar)))
      {
        paramView = (TipsBar)paramView;
        paramMessage = (Bundle)paramMessage.obj;
        String str = (String)paramMessage.getCharSequence("tips");
        int i = paramMessage.getInt("icon");
        if (paramMessage.containsKey("iconURLBitmap")) {
          paramView.setTipsIcon(new BitmapDrawable((Bitmap)paramMessage.getParcelable("iconURLBitmap")));
        }
        while (!TextUtils.isEmpty(str))
        {
          paramView.setTipsText(str);
          paramView.setOnClickListener(new aaid(this, paramMessage));
          paramView.setCloseListener(new aahb.c(30, this.g));
          a(paramView);
          paramView.setVisibility(0);
          this.g.removeMessages(30);
          this.g.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
          return;
          if (i != 1) {
            paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i));
          }
        }
      }
    }
  }
  
  private void t(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131381303).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131381304);
    if (paramMessage != null)
    {
      if (accy.ad(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label93;
      }
      paramMessage = aqap.a().b();
      if ((paramMessage != null) && (paramMessage.b != null) && (paramMessage.b.dialog != null)) {
        paramView.setText(paramMessage.b.dialog.csd);
      }
    }
    else
    {
      return;
    }
    paramView.setText(acfp.m(2131703029));
    return;
    label93:
    paramMessage = aqap.a().b();
    if ((paramMessage != null) && (paramMessage.b != null) && (paramMessage.b.dialog != null))
    {
      paramView.setText(paramMessage.b.dialog.csc);
      return;
    }
    paramView.setText(acfp.m(2131703037));
  }
  
  private void u(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      jfs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramView, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    }
  }
  
  private void v(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner");
    }
    paramMessage = (SCGet3rdCloudCheck)paramMessage.obj;
    paramView.setTipsText(paramMessage.tips);
    paramView.setOnClickListener(new aaio(this, paramMessage));
    paramView.setVisibility(0);
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.g.removeMessages(202);
    this.g.sendEmptyMessageDelayed(202, 7000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int i = 398680;; i = 398678)
    {
      armm.aU(paramView, i);
      return;
    }
  }
  
  @SuppressLint({"ResourceType"})
  private void w(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    a(paramView);
    if (paramMessage == null) {
      return;
    }
    paramMessage = (aahb.d)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(aaha.fA(paramMessage.cgP)));
    paramView.setTipsText(paramMessage.wording);
    paramView.setOnClickListener(new aahb.f(paramMessage, this.g));
    paramView.setCloseListener(new aahb.e(paramMessage, this.g));
    paramView.setVisibility(0);
    anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  public void As(String paramString)
  {
    if ((hx(16)) && (!TextUtils.isEmpty(this.bcZ)) && (!TextUtils.isEmpty(paramString)) && (this.bcZ.equals(paramString)))
    {
      this.bcZ = "";
      this.g.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void Cj(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfAagz[15] != null) {
      gm(15, 0);
    }
    this.g.removeMessages(11);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(11);
      int i;
      if (localPhoneContactManagerImp != null)
      {
        i = localPhoneContactManagerImp.xw();
        if (i == 0) {
          this.g.sendEmptyMessageDelayed(11, 1000L);
        }
      }
      else
      {
        return;
      }
      if ((this.jdField_b_of_type_Ajdo$a == null) && (!this.isDestroy))
      {
        this.jdField_b_of_type_Ajdo$a = new aahc(this);
        localPhoneContactManagerImp.a(this.jdField_b_of_type_Ajdo$a);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + i + ", isFirstShow = " + paramBoolean);
      }
      if ((i == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfAagz[15] != null) && (this.jdField_a_of_type_ArrayOfAagz[15].state != 2)) {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        gm(15, 2);
        anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
        return;
      }
      gm(15, 0);
      return;
    }
    this.g.removeMessages(11);
    this.g.sendEmptyMessageDelayed(11, 1000L);
  }
  
  public void Ck(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aaje != null) {
      this.jdField_a_of_type_Aaje.Cp(paramBoolean);
    }
  }
  
  public void Cl(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAagz[21];
    if ((localObject1 == null) || (((aagz)localObject1).view == null)) {}
    label19:
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    do
    {
      do
      {
        do
        {
          break label19;
          do
          {
            return;
          } while (!((aagz)localObject1).bvz);
          localObject1 = ((aagz)localObject1).view;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131373858);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.cgJ) && (((View)localObject1).findViewById(2131364677).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131364677).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.cgJ;
      ((View)localObject1).requestLayout();
      localObject1 = b(21, 2131362278);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)localObject1);
          anot.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        i = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131364677).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = b(21, 2131362278);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject2);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", i, 0, "", "", "", "");
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      i = 0;
    }
  }
  
  public void Cm(boolean paramBoolean)
  {
    this.bvH = paramBoolean;
  }
  
  public boolean Wn()
  {
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a.abT();
  }
  
  public boolean Wo()
  {
    aaje localaaje = aaje.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    if (localaaje == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Aaje == null) || (!this.jdField_a_of_type_Aaje.getClass().isInstance(localaaje)) || (!localaaje.getClass().isInstance(this.jdField_a_of_type_Aaje)))
      {
        this.jdField_a_of_type_Aaje = localaaje;
        cup();
      }
    } while (this.jdField_a_of_type_Aaje == null);
    boolean bool = this.jdField_a_of_type_Aaje.Wo();
    QLog.i("QBoss.ADBanner.Manager", 1, "isNeedShowQBossADBanner: " + bool);
    return bool;
  }
  
  public boolean Wp()
  {
    boolean bool1 = true;
    boolean bool2 = Wq();
    if ((this.bvG) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (Wr())
      {
        if (this.jdField_a_of_type_ArrayOfAagz[21] == null) {
          this.jdField_a_of_type_ArrayOfAagz[21] = new aagz(21, 0);
        }
        a(this.jdField_a_of_type_ArrayOfAagz[21]);
        View localView = this.jdField_a_of_type_ArrayOfAagz[21].view;
        if (localView != null) {}
        for (bool1 = Q(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131373858).setVisibility(0);
            this.bvG = true;
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false).commit();
          }
          break;
        }
      }
      bool1 = false;
    }
  }
  
  public int a(SparseArray<ArrayList<Integer>> paramSparseArray, int paramInt)
  {
    int k = 0;
    int j = 0;
    int i;
    if (paramSparseArray == null) {
      i = j;
    }
    do
    {
      do
      {
        return i;
        paramSparseArray = (ArrayList)paramSparseArray.get(paramInt);
        i = j;
      } while (paramSparseArray == null);
      i = j;
    } while (paramSparseArray.size() <= 0);
    paramSparseArray = paramSparseArray.iterator();
    for (paramInt = k;; paramInt = ((Integer)paramSparseArray.next()).intValue() + paramInt)
    {
      i = paramInt;
      if (!paramSparseArray.hasNext()) {
        break;
      }
    }
  }
  
  public void a(TipsBar paramTipsBar)
  {
    if (this.bvH) {
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false))) {
        if (paramTipsBar.MN() == 2) {
          paramTipsBar.setBarType(6);
        }
      }
    }
    for (;;)
    {
      paramTipsBar.ehH();
      return;
      if (paramTipsBar.MN() == 6)
      {
        paramTipsBar.setBarType(2);
      }
      else if ((!ThemeUtil.isInNightMode(BaseApplicationImpl.sApplication.getRuntime())) && (paramTipsBar.MN() == 2))
      {
        paramTipsBar.setBarType(2);
        continue;
        if (paramTipsBar.MN() == 6) {
          paramTipsBar.setBarType(2);
        }
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    altq localaltq;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (!aqmr.isEmpty((String)localObject)) {
        localaltq = (altq)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("msg").getJSONObject(paramString);
      if ((localJSONObject != null) && (localJSONObject.getInt("blue_bar_stat") == 1))
      {
        localJSONObject.put("blue_bar_stat", 2);
        paramAppInfo.buffer.set(((JSONObject)localObject).toString());
        localaltq.b(paramAppInfo, false);
        a(paramAppInfo, paramString, 2);
      }
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, int paramInt)
  {
    altq localaltq;
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent.banner", 2, "onReportRenewBannerExposure");
      }
      localaltq = (altq)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      localaltq.a(paramAppInfo, localJSONObject, paramInt);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void aH(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    String str = localBundle.getString("iconURL");
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = Message.obtain(paramMessage);
      artp.a().a(str, new aaic(this, localBundle, paramMessage));
      return;
    }
    gm(31, 2);
    d(31, paramMessage);
  }
  
  public View aX()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561234, null);
    localView.findViewById(2131374851).setVisibility(8);
    return localView;
  }
  
  public void aw(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + paramFloat + ",mIsStoryShow:" + this.bvJ);
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAagz[21];
    if ((localObject1 == null) || (((aagz)localObject1).view == null))
    {
      break label67;
      break label67;
    }
    for (;;)
    {
      label67:
      return;
      if (!((aagz)localObject1).bvz) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        Cl(true);
        return;
      }
      localObject1 = ((aagz)localObject1).view;
      if (localObject1 == null) {
        break;
      }
      int i = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131373858);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int j = this.cgJ;
      label159:
      Object localObject2;
      int k;
      if (this.bvJ)
      {
        if (localLayoutParams.height == this.cgJ) {
          break;
        }
        if (paramFloat < -j)
        {
          paramFloat = 0.0F;
          i = 0;
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height = " + localLayoutParams.height + "height:" + i + ",alpha:" + paramFloat);
          }
          if (localLayoutParams.height == i) {
            break;
          }
          if (i == 0)
          {
            localObject2 = b(21, 2131362278);
            k = 0;
            j = k;
            if (localObject2 != null)
            {
              j = k;
              if (!(localObject2 instanceof String)) {}
            }
          }
        }
      }
      try
      {
        j = Integer.parseInt((String)localObject2);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X80094CD", "0X80094CD", j, 0, "", "", "", "");
        localLayoutParams.height = i;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
        return;
        if (paramFloat >= -3.0F)
        {
          i = this.cgJ;
          paramFloat = 1.0F;
          break label159;
        }
        paramFloat = (j - i) / this.cgJ;
        i = j - i;
        break label159;
        if (localLayoutParams.height == 0) {
          continue;
        }
        ((View)localObject1).findViewById(2131364677).setVisibility(4);
        if (paramFloat < this.rp - j)
        {
          paramFloat = 0.0F;
          i = 0;
          break label159;
        }
        if (paramFloat < this.rp)
        {
          i = (int)(j + paramFloat - this.rp);
          paramFloat = i / j;
          break label159;
        }
        i = this.cgJ;
        paramFloat = 1.0F;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          j = k;
        }
      }
    }
  }
  
  public Object b(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAagz.length)) {}
    for (aagz localaagz = this.jdField_a_of_type_ArrayOfAagz[paramInt1];; localaagz = null)
    {
      Object localObject1 = localObject2;
      if (localaagz != null)
      {
        localObject1 = localObject2;
        if (localaagz.view != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localaagz.view.getTag();
        }
      }
      return localObject1;
      label58:
      return localaagz.view.getTag(paramInt2);
    }
  }
  
  public MqqHandler b()
  {
    return this.g;
  }
  
  public void b(boolean paramBoolean, float paramFloat)
  {
    this.bvJ = paramBoolean;
    this.rp = paramFloat;
  }
  
  public void bB(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.isDestroy = true;
      if ((this.jdField_b_of_type_Ajdo$a != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).b(this.jdField_b_of_type_Ajdo$a);
        this.jdField_b_of_type_Ajdo$a = null;
      }
      this.g.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.recent.banner", 2, "onDestroy", paramQQAppInterface);
    }
  }
  
  public void bC(QQAppInterface paramQQAppInterface)
  {
    gm(10, 0);
    bD(paramQQAppInterface);
    cum();
    bE(paramQQAppInterface);
  }
  
  public void bMT()
  {
    if (this.jdField_a_of_type_Aaje != null) {
      this.jdField_a_of_type_Aaje.bMT();
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = ((anec)localAppInterface.getManager(12)).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.init();
    }
  }
  
  public void cui()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().lh() <= 0) {
        break label34;
      }
      gm(37, 2);
    }
    label34:
    int i;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.bF()) {
        break;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().getSessionType();
      if (i == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().bG() > 0L)
        {
          gm(37, 2);
          return;
        }
        gm(37, 0);
        return;
      }
      if (i == 1)
      {
        gm(37, 2);
        return;
      }
    } while (i != 2);
    gm(37, 2);
    return;
    gm(37, 0);
  }
  
  public void cuj()
  {
    if (hx(11))
    {
      gm(11, 0);
      this.bdb = null;
      this.cgI = -1;
      this.bdd = null;
      this.LU = 0L;
      d(-1, null);
    }
  }
  
  public void cuk()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAagz[21];
    ViewGroup localViewGroup;
    int j;
    int i;
    if ((localObject != null) && (((aagz)localObject).view != null))
    {
      localObject = (ADView)((aagz)localObject).view.findViewById(2131362278);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount() - 1;
        i = 0;
        if (j >= 0)
        {
          View localView = localViewGroup.getChildAt(j);
          anqr localanqr = (anqr)localView.getTag();
          String str = localanqr.time;
          int k = str.indexOf("|");
          if (aqcv.D(Long.parseLong(str.substring(0, k)), Long.parseLong(str.substring(k + 1)))) {
            break label291;
          }
          ((ADView)localObject).c(0, j, localView);
          aehp.a.Hz(localanqr.cgV);
          i = 1;
        }
      }
    }
    label291:
    for (;;)
    {
      j -= 1;
      break;
      if (i != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).ehD();
          gm(21, 0);
          d(-1, null);
          this.bvG = false;
        }
        for (;;)
        {
          localObject = new aehr(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), aevk.mCurUin);
          if (localObject != null)
          {
            ((aehr)localObject).cXa();
            ((aehr)localObject).cXb();
          }
          return;
          cul();
        }
      }
      cul();
      return;
    }
  }
  
  public void cuo()
  {
    gm(20, 0);
    d(-1, null);
    if (this.jdField_a_of_type_Aaje != null) {
      this.jdField_a_of_type_Aaje.onRecycle();
    }
  }
  
  public void cup()
  {
    if (this.jdField_a_of_type_ArrayOfAagz != null)
    {
      aagz localaagz = this.jdField_a_of_type_ArrayOfAagz[20];
      if ((localaagz != null) && (localaagz.view != null) && (localaagz.bvz))
      {
        this.mListView.removeHeaderView(localaagz.view);
        localaagz.bvz = false;
        localaagz.view = null;
      }
    }
  }
  
  public void cuq()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int i;
    label82:
    int j;
    label84:
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((aizp.a().L(localQQAppInterface, this.bcZ)) || (this.bvC)))
      {
        localList = localQQAppInterface.a().a().q(false);
        if (localList != null) {
          break label135;
        }
        i = 0;
        j = 0;
        k = m;
        if (j >= i) {
          break label153;
        }
        if (((RecentUser)localList.get(j)).getType() != 5000) {
          break label146;
        }
        if (this.bvC) {
          this.g.sendEmptyMessage(1);
        }
      }
    }
    label135:
    label146:
    label153:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      i = localList.size();
      break label82;
      j += 1;
      break label84;
      if (k < i)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(k);
        if (localRecentUser.getType() != 1) {}
        do
        {
          do
          {
            k += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (aizp.a().K(localQQAppInterface, localRecentUser.uin)) || (aizp.a().j(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().A(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.bvC) && (!TextUtils.isEmpty(this.bcZ)) && (this.bcZ.equals(localRecentUser.uin))) {
              break;
            }
            this.bcZ = localRecentUser.uin;
            if ((!this.bvB) || (!aizp.a().L(localQQAppInterface, this.bcZ))) {
              break;
            }
            return;
          }
        } while ((TextUtils.isEmpty(this.bcZ)) || (!this.bcZ.equals(localRecentUser.uin)));
        this.g.sendEmptyMessage(1);
        return;
      }
    } while ((!this.bvC) || (TextUtils.isEmpty(this.bcZ)));
    this.g.sendEmptyMessage(1);
  }
  
  public void cur() {}
  
  public void cus()
  {
    if (hx(27))
    {
      gm(27, 0);
      this.bdb = null;
      d(-1, null);
    }
  }
  
  /* Error */
  public void d(int paramInt, Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 201
    //   8: iconst_4
    //   9: new 203	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 2317
    //   19: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 2319
    //   29: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   46: ifnonnull +16 -> 62
    //   49: aload_0
    //   50: new 1296	android/util/SparseArray
    //   53: dup
    //   54: bipush 6
    //   56: invokespecial 2323	android/util/SparseArray:<init>	(I)V
    //   59: putfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: bipush 6
    //   67: if_icmpge +56 -> 123
    //   70: aload_0
    //   71: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   74: iload_3
    //   75: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   78: checkcast 1302	java/util/ArrayList
    //   81: astore 6
    //   83: aload 6
    //   85: ifnonnull +30 -> 115
    //   88: new 1302	java/util/ArrayList
    //   91: dup
    //   92: iconst_1
    //   93: invokespecial 2324	java/util/ArrayList:<init>	(I)V
    //   96: astore 6
    //   98: aload_0
    //   99: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   102: iload_3
    //   103: aload 6
    //   105: invokevirtual 2326	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   108: iload_3
    //   109: iconst_1
    //   110: iadd
    //   111: istore_3
    //   112: goto -48 -> 64
    //   115: aload 6
    //   117: invokevirtual 2328	java/util/ArrayList:clear	()V
    //   120: goto -12 -> 108
    //   123: aload_0
    //   124: getfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   127: ifnonnull +16 -> 143
    //   130: aload_0
    //   131: new 1296	android/util/SparseArray
    //   134: dup
    //   135: bipush 6
    //   137: invokespecial 2323	android/util/SparseArray:<init>	(I)V
    //   140: putfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   143: iconst_1
    //   144: istore_3
    //   145: iload_3
    //   146: bipush 26
    //   148: if_icmpgt +54 -> 202
    //   151: aload_0
    //   152: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   155: iload_3
    //   156: aaload
    //   157: ifnull +172 -> 329
    //   160: aload_0
    //   161: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   164: iload_3
    //   165: aaload
    //   166: invokevirtual 1332	aagz:Wm	()Z
    //   169: ifeq +160 -> 329
    //   172: aload_0
    //   173: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   176: iconst_0
    //   177: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   180: checkcast 1302	java/util/ArrayList
    //   183: astore 6
    //   185: aload_0
    //   186: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   189: ifnull +13 -> 202
    //   192: aload 6
    //   194: iload_3
    //   195: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   201: pop
    //   202: bipush 27
    //   204: istore_3
    //   205: iload_3
    //   206: bipush 27
    //   208: if_icmpgt +54 -> 262
    //   211: aload_0
    //   212: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   215: iload_3
    //   216: aaload
    //   217: ifnull +119 -> 336
    //   220: aload_0
    //   221: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   224: iload_3
    //   225: aaload
    //   226: invokevirtual 1332	aagz:Wm	()Z
    //   229: ifeq +107 -> 336
    //   232: aload_0
    //   233: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   236: iconst_1
    //   237: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   240: checkcast 1302	java/util/ArrayList
    //   243: astore 6
    //   245: aload_0
    //   246: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   249: ifnull +13 -> 262
    //   252: aload 6
    //   254: iload_3
    //   255: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: bipush 28
    //   264: istore_3
    //   265: iload_3
    //   266: bipush 35
    //   268: if_icmpgt +75 -> 343
    //   271: aload_0
    //   272: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   275: iload_3
    //   276: aaload
    //   277: ifnull +45 -> 322
    //   280: aload_0
    //   281: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   284: iload_3
    //   285: aaload
    //   286: invokevirtual 1332	aagz:Wm	()Z
    //   289: ifeq +33 -> 322
    //   292: aload_0
    //   293: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   296: iconst_2
    //   297: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   300: checkcast 1302	java/util/ArrayList
    //   303: astore 6
    //   305: aload_0
    //   306: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   309: ifnull +13 -> 322
    //   312: aload 6
    //   314: iload_3
    //   315: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: iload_3
    //   323: iconst_1
    //   324: iadd
    //   325: istore_3
    //   326: goto -61 -> 265
    //   329: iload_3
    //   330: iconst_1
    //   331: iadd
    //   332: istore_3
    //   333: goto -188 -> 145
    //   336: iload_3
    //   337: iconst_1
    //   338: iadd
    //   339: istore_3
    //   340: goto -135 -> 205
    //   343: bipush 36
    //   345: istore_3
    //   346: iload_3
    //   347: bipush 36
    //   349: if_icmpgt +52 -> 401
    //   352: aload_0
    //   353: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   356: iload_3
    //   357: aaload
    //   358: ifnull +238 -> 596
    //   361: aload_0
    //   362: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   365: iload_3
    //   366: aaload
    //   367: invokevirtual 1332	aagz:Wm	()Z
    //   370: ifeq +226 -> 596
    //   373: aload_0
    //   374: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   377: iconst_3
    //   378: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   381: checkcast 1302	java/util/ArrayList
    //   384: astore 6
    //   386: aload 6
    //   388: ifnull +13 -> 401
    //   391: aload 6
    //   393: iload_3
    //   394: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   400: pop
    //   401: bipush 37
    //   403: istore_3
    //   404: iload_3
    //   405: bipush 39
    //   407: if_icmpgt +52 -> 459
    //   410: aload_0
    //   411: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   414: iload_3
    //   415: aaload
    //   416: ifnull +187 -> 603
    //   419: aload_0
    //   420: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   423: iload_3
    //   424: aaload
    //   425: invokevirtual 1332	aagz:Wm	()Z
    //   428: ifeq +175 -> 603
    //   431: aload_0
    //   432: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   435: iconst_4
    //   436: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   439: checkcast 1302	java/util/ArrayList
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +13 -> 459
    //   449: aload 6
    //   451: iload_3
    //   452: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   458: pop
    //   459: bipush 40
    //   461: istore_3
    //   462: iload_3
    //   463: bipush 41
    //   465: if_icmpgt +52 -> 517
    //   468: aload_0
    //   469: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   472: iload_3
    //   473: aaload
    //   474: ifnull +136 -> 610
    //   477: aload_0
    //   478: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   481: iload_3
    //   482: aaload
    //   483: invokevirtual 1332	aagz:Wm	()Z
    //   486: ifeq +124 -> 610
    //   489: aload_0
    //   490: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   493: iconst_5
    //   494: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   497: checkcast 1302	java/util/ArrayList
    //   500: astore 6
    //   502: aload 6
    //   504: ifnull +13 -> 517
    //   507: aload 6
    //   509: iload_3
    //   510: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokevirtual 2330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   516: pop
    //   517: iconst_0
    //   518: istore 5
    //   520: iconst_1
    //   521: istore_3
    //   522: iconst_1
    //   523: istore 4
    //   525: iload 5
    //   527: bipush 6
    //   529: if_icmpge +88 -> 617
    //   532: aload_0
    //   533: getfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   536: iload 5
    //   538: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   541: checkcast 2290	java/util/List
    //   544: astore 6
    //   546: aload_0
    //   547: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   550: iload 5
    //   552: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   555: checkcast 2290	java/util/List
    //   558: astore 7
    //   560: aload 7
    //   562: aload 6
    //   564: invokeinterface 2331 2 0
    //   569: ifne +598 -> 1167
    //   572: iconst_0
    //   573: istore 4
    //   575: aload 7
    //   577: invokeinterface 2333 1 0
    //   582: ifne +582 -> 1164
    //   585: iconst_0
    //   586: istore_3
    //   587: iload 5
    //   589: iconst_1
    //   590: iadd
    //   591: istore 5
    //   593: goto -68 -> 525
    //   596: iload_3
    //   597: iconst_1
    //   598: iadd
    //   599: istore_3
    //   600: goto -254 -> 346
    //   603: iload_3
    //   604: iconst_1
    //   605: iadd
    //   606: istore_3
    //   607: goto -203 -> 404
    //   610: iload_3
    //   611: iconst_1
    //   612: iadd
    //   613: istore_3
    //   614: goto -152 -> 462
    //   617: iload 4
    //   619: ifeq +23 -> 642
    //   622: iload_3
    //   623: ifeq +19 -> 642
    //   626: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +12 -> 641
    //   632: ldc 201
    //   634: iconst_2
    //   635: ldc_w 2335
    //   638: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: return
    //   642: iload_3
    //   643: ifeq +23 -> 666
    //   646: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq +12 -> 661
    //   652: ldc 201
    //   654: iconst_2
    //   655: ldc_w 2337
    //   658: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_0
    //   662: invokespecial 2339	aahb:cun	()V
    //   665: return
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   671: iconst_2
    //   672: invokevirtual 2341	aahb:a	(Landroid/util/SparseArray;I)I
    //   675: istore_3
    //   676: aload_0
    //   677: aload_0
    //   678: getfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   681: iconst_2
    //   682: invokevirtual 2341	aahb:a	(Landroid/util/SparseArray;I)I
    //   685: istore 5
    //   687: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +32 -> 722
    //   693: ldc 201
    //   695: iconst_2
    //   696: new 203	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 2343
    //   706: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload_3
    //   710: iload 5
    //   712: isub
    //   713: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: iload 4
    //   724: ifne +59 -> 783
    //   727: aload_0
    //   728: invokespecial 2339	aahb:cun	()V
    //   731: iconst_0
    //   732: istore_3
    //   733: iload_3
    //   734: bipush 6
    //   736: if_icmpge +47 -> 783
    //   739: aload_0
    //   740: getfield 2321	aahb:bP	Landroid/util/SparseArray;
    //   743: iload_3
    //   744: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   747: checkcast 1302	java/util/ArrayList
    //   750: astore 6
    //   752: aload 6
    //   754: ifnull +22 -> 776
    //   757: aload_0
    //   758: getfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   761: iload_3
    //   762: aload 6
    //   764: invokevirtual 2346	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   767: checkcast 1302	java/util/ArrayList
    //   770: checkcast 1302	java/util/ArrayList
    //   773: invokevirtual 2326	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: istore_3
    //   780: goto -47 -> 733
    //   783: iconst_0
    //   784: istore 5
    //   786: iconst_0
    //   787: istore_3
    //   788: iload 5
    //   790: bipush 6
    //   792: if_icmpge +274 -> 1066
    //   795: aload_0
    //   796: getfield 1294	aahb:bO	Landroid/util/SparseArray;
    //   799: iload 5
    //   801: invokevirtual 1300	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   804: checkcast 1302	java/util/ArrayList
    //   807: astore 6
    //   809: iload_3
    //   810: istore 4
    //   812: aload 6
    //   814: ifnull +14 -> 828
    //   817: aload 6
    //   819: invokevirtual 1305	java/util/ArrayList:size	()I
    //   822: ifne +18 -> 840
    //   825: iload_3
    //   826: istore 4
    //   828: iload 5
    //   830: iconst_1
    //   831: iadd
    //   832: istore 5
    //   834: iload 4
    //   836: istore_3
    //   837: goto -49 -> 788
    //   840: aload 6
    //   842: invokevirtual 1309	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   845: astore 7
    //   847: iload_3
    //   848: istore 4
    //   850: aload 7
    //   852: invokeinterface 1314 1 0
    //   857: ifeq -29 -> 828
    //   860: aload 7
    //   862: invokeinterface 1318 1 0
    //   867: checkcast 918	java/lang/Integer
    //   870: invokevirtual 1321	java/lang/Integer:intValue	()I
    //   873: istore 4
    //   875: aload_0
    //   876: getfield 108	aahb:jdField_a_of_type_ArrayOfAagz	[Laagz;
    //   879: iload 4
    //   881: aaload
    //   882: astore 8
    //   884: aload 8
    //   886: ifnull -39 -> 847
    //   889: aload_0
    //   890: aload 8
    //   892: invokespecial 2044	aahb:a	(Laagz;)V
    //   895: iload_3
    //   896: istore 4
    //   898: aload 8
    //   900: getfield 278	aagz:view	Landroid/view/View;
    //   903: ifnull +86 -> 989
    //   906: iload_3
    //   907: istore 4
    //   909: aload 8
    //   911: getfield 1324	aagz:bvz	Z
    //   914: ifne +75 -> 989
    //   917: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +12 -> 932
    //   923: ldc 201
    //   925: iconst_2
    //   926: ldc_w 2348
    //   929: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: aload 8
    //   934: getfield 281	aagz:cgG	I
    //   937: bipush 21
    //   939: if_icmpne +28 -> 967
    //   942: aload_0
    //   943: getfield 2143	aahb:bvJ	Z
    //   946: ifeq +21 -> 967
    //   949: aload 8
    //   951: getfield 278	aagz:view	Landroid/view/View;
    //   954: ldc_w 1003
    //   957: invokevirtual 188	android/view/View:findViewById	(I)Landroid/view/View;
    //   960: invokevirtual 1963	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   963: iconst_0
    //   964: putfield 1968	android/view/ViewGroup$LayoutParams:height	I
    //   967: aload_0
    //   968: getfield 112	aahb:mListView	Lcom/tencent/widget/XListView;
    //   971: aload 8
    //   973: getfield 278	aagz:view	Landroid/view/View;
    //   976: iconst_1
    //   977: invokevirtual 2351	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;I)V
    //   980: aload 8
    //   982: iconst_1
    //   983: putfield 1324	aagz:bvz	Z
    //   986: iconst_1
    //   987: istore 4
    //   989: iload 4
    //   991: istore_3
    //   992: aload_2
    //   993: ifnull +12 -> 1005
    //   996: iload_1
    //   997: aload 8
    //   999: getfield 281	aagz:cgG	I
    //   1002: if_icmpeq +54 -> 1056
    //   1005: aload_0
    //   1006: aload 8
    //   1008: aconst_null
    //   1009: invokespecial 2353	aahb:a	(Laagz;Landroid/os/Message;)V
    //   1012: goto -165 -> 847
    //   1015: astore 6
    //   1017: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1020: ifeq +33 -> 1053
    //   1023: ldc 201
    //   1025: iconst_4
    //   1026: new 203	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   1033: ldc_w 2355
    //   1036: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload 6
    //   1041: invokevirtual 2356	java/lang/Exception:toString	()Ljava/lang/String;
    //   1044: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1053: goto -61 -> 992
    //   1056: aload_0
    //   1057: aload 8
    //   1059: aload_2
    //   1060: invokespecial 2353	aahb:a	(Laagz;Landroid/os/Message;)V
    //   1063: goto -51 -> 1012
    //   1066: iload_3
    //   1067: ifeq -426 -> 641
    //   1070: aload_0
    //   1071: getfield 110	aahb:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1074: ifnull +78 -> 1152
    //   1077: aload_0
    //   1078: getfield 110	aahb:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1081: getfield 150	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1084: astore_2
    //   1085: aload_2
    //   1086: ifnull -445 -> 641
    //   1089: aload_2
    //   1090: sipush 252
    //   1093: invokevirtual 902	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1096: checkcast 2358	puz
    //   1099: getfield 2361	puz:aBT	Z
    //   1102: ifeq -461 -> 641
    //   1105: aload_0
    //   1106: getfield 112	aahb:mListView	Lcom/tencent/widget/XListView;
    //   1109: invokevirtual 2364	com/tencent/widget/XListView:getFirstVisiblePosition	()I
    //   1112: istore_1
    //   1113: iload_1
    //   1114: aload_0
    //   1115: getfield 112	aahb:mListView	Lcom/tencent/widget/XListView;
    //   1118: invokevirtual 2367	com/tencent/widget/XListView:getHeaderViewsCount	()I
    //   1121: if_icmpgt -480 -> 641
    //   1124: aload_0
    //   1125: getfield 112	aahb:mListView	Lcom/tencent/widget/XListView;
    //   1128: iconst_0
    //   1129: invokevirtual 2369	com/tencent/widget/XListView:getHeaderViewsCount	(I)I
    //   1132: istore_3
    //   1133: iload_3
    //   1134: iconst_m1
    //   1135: if_icmpeq -494 -> 641
    //   1138: iload_3
    //   1139: iload_1
    //   1140: if_icmpgt -499 -> 641
    //   1143: aload_0
    //   1144: getfield 112	aahb:mListView	Lcom/tencent/widget/XListView;
    //   1147: iload_3
    //   1148: invokevirtual 2372	com/tencent/widget/XListView:setSelection	(I)V
    //   1151: return
    //   1152: aconst_null
    //   1153: astore_2
    //   1154: goto -69 -> 1085
    //   1157: astore 6
    //   1159: iconst_1
    //   1160: istore_3
    //   1161: goto -144 -> 1017
    //   1164: goto -577 -> 587
    //   1167: goto -592 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1170	0	this	aahb
    //   0	1170	1	paramInt	int
    //   0	1170	2	paramMessage	Message
    //   63	1098	3	i	int
    //   523	467	4	j	int
    //   518	315	5	k	int
    //   81	760	6	localObject1	Object
    //   1015	25	6	localException1	Exception
    //   1157	1	6	localException2	Exception
    //   558	303	7	localObject2	Object
    //   882	176	8	localaagz	aagz
    // Exception table:
    //   from	to	target	type
    //   898	906	1015	java/lang/Exception
    //   909	932	1015	java/lang/Exception
    //   932	967	1015	java/lang/Exception
    //   967	980	1015	java/lang/Exception
    //   980	986	1157	java/lang/Exception
  }
  
  public int fL(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAagz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAagz[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((aagz)localObject1).state;
  }
  
  public void gm(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 4, "updateBanerState|[" + paramInt1 + "," + paramInt2 + "]");
    }
    if ((paramInt1 >= 1) && (paramInt1 <= 41))
    {
      if (this.jdField_a_of_type_ArrayOfAagz[paramInt1] == null) {
        break label101;
      }
      this.jdField_a_of_type_ArrayOfAagz[paramInt1].state = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 28) && (paramInt1 <= 35) && (paramInt2 == 2)) {
        FV(paramInt1);
      }
      return;
      label101:
      if ((this.jdField_a_of_type_ArrayOfAagz[paramInt1] == null) && (aagz.hw(paramInt2))) {
        this.jdField_a_of_type_ArrayOfAagz[paramInt1] = new aagz(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      anot.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 17, 0, "", "", "", "");
      continue;
      gm(16, 0);
      this.bcZ = "";
      d(16, paramMessage);
      continue;
      gm(17, 0);
      d(17, paramMessage);
      continue;
      gm(4, 2);
      d(4, paramMessage);
      continue;
      gm(4, 0);
      d(4, paramMessage);
      continue;
      gm(24, 0);
      d(24, paramMessage);
      continue;
      gm(25, 0);
      d(25, paramMessage);
      continue;
      gm(23, 2);
      d(23, paramMessage);
      continue;
      gm(23, 0);
      d(23, paramMessage);
      continue;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner");
        }
        cuk();
      }
      catch (Exception paramMessage) {}
      if (QLog.isColorLevel())
      {
        QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
        continue;
        Cj(true);
        continue;
        gm(28, 0);
        d(28, paramMessage);
        continue;
        gm(29, 0);
        d(29, paramMessage);
        continue;
        gm(30, 0);
        d(30, paramMessage);
        continue;
        gm(31, 0);
        d(31, paramMessage);
        continue;
        gm(26, 0);
        d(26, paramMessage);
        continue;
        aJ(paramMessage);
        continue;
        aI(paramMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "handler msg MSG_HIDE_WIFI_SECURITY_CHECK");
        }
        gm(2, 0);
        d(2, paramMessage);
      }
    }
  }
  
  public boolean hx(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAagz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAagz[paramInt];
      }
    }
    return (localObject1 != null) && (((aagz)localObject1).Wm());
  }
  
  public boolean hy(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfAagz.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfAagz[paramInt];
      }
    }
    return (localObject1 != null) && (((aagz)localObject1).bvz);
  }
  
  public void onAccountChanged()
  {
    this.g.removeMessages(101);
    gm(41, 0);
    gm(12, 0);
    gm(14, 0);
    gm(32, 0);
    gm(33, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfAagz[21];
    if ((localObject != null) && (((aagz)localObject).view != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((aagz)localObject).view.findViewById(2131362279);
      localObject = (ADView)((aagz)localObject).view.findViewById(2131362278);
      if (localObject != null)
      {
        ((ADView)localObject).ehF();
        ((ADView)localObject).ehD();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.bvG = false;
    cuj();
    cus();
    gm(16, 0);
    this.bvB = true;
    this.bvC = false;
    this.bcZ = "";
    gm(7, 0);
    gm(17, 0);
    gm(18, 0);
    gm(23, 0);
    gm(6, 0);
    gm(20, 0);
    if (this.jdField_a_of_type_Aaje != null) {
      this.jdField_a_of_type_Aaje.cuJ();
    }
    gm(28, 0);
    gm(31, 0);
    cui();
    cur();
    d(-1, null);
    Cj(false);
    this.bvE = false;
    this.bvF = false;
  }
  
  public void onResume()
  {
    QLog.i("Q.recent.banner", 1, "onResume");
    if (this.jdField_a_of_type_Aaje != null) {
      this.jdField_a_of_type_Aaje.cuH();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.dpw();
    }
  }
  
  static class a
    implements aahb.b
  {
    private aahb.d a;
    private String bdi;
    private final WeakReference<QQAppInterface> n;
    
    public a(String paramString, QQAppInterface paramQQAppInterface)
    {
      this.bdi = paramString;
      this.n = new WeakReference(paramQQAppInterface);
    }
    
    public void a(@Nullable aahb.d paramd)
    {
      this.a = paramd;
    }
    
    public boolean isNeedAutoCloseWhenAccountChange()
    {
      return true;
    }
    
    public void onClose()
    {
      if (this.a == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      aahb.a(localQQAppInterface, this.a);
    }
    
    public void onEnter()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
      if (localQQAppInterface == null) {
        return;
      }
      Intent localIntent;
      if (BaseActivity.sTopActivity != null)
      {
        localIntent = new Intent();
        localIntent.putExtra("public_fragment_window_feature", 1);
        localIntent.addFlags(268435456);
      }
      for (;;)
      {
        try
        {
          PublicTransFragmentActivity.start(localQQAppInterface.getApp(), localIntent, Class.forName(this.bdi));
          aahb.a(localQQAppInterface, this.a);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "sTopActivity is null");
        }
      }
    }
    
    public void onOverride() {}
  }
  
  public static abstract interface b
  {
    public abstract boolean isNeedAutoCloseWhenAccountChange();
    
    public abstract void onClose();
    
    public abstract void onEnter();
    
    public abstract void onOverride();
  }
  
  static class c
    implements View.OnClickListener
  {
    private final MqqHandler b;
    private final int cgN;
    
    public c(int paramInt, MqqHandler paramMqqHandler)
    {
      this.cgN = paramInt;
      this.b = paramMqqHandler;
    }
    
    public void onClick(View paramView)
    {
      this.b.sendEmptyMessage(this.cgN);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  public static final class d
  {
    @NonNull
    public final aahb.b a;
    @NonNull
    public final String bdj;
    public final int cgO;
    public final int cgP;
    @NonNull
    public final String wording;
    
    public d(int paramInt1, @NonNull String paramString1, int paramInt2, @NonNull String paramString2, @NonNull aahb.b paramb)
    {
      this.cgO = paramInt1;
      this.bdj = paramString1;
      this.cgP = paramInt2;
      this.wording = paramString2;
      this.a = paramb;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this == paramObject) {
        bool1 = true;
      }
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
                return bool1;
                bool1 = bool2;
              } while (paramObject == null);
              bool1 = bool2;
            } while (getClass() != paramObject.getClass());
            paramObject = (d)paramObject;
            bool1 = bool2;
          } while (this.cgO != paramObject.cgO);
          bool1 = bool2;
        } while (this.cgP != paramObject.cgP);
        bool1 = bool2;
      } while (!this.bdj.equals(paramObject.bdj));
      return this.wording.equals(paramObject.wording);
    }
    
    public int hashCode()
    {
      return ((this.cgO * 31 + this.bdj.hashCode()) * 31 + this.cgP) * 31 + this.wording.hashCode();
    }
    
    public String toString()
    {
      return "MessageToShowBanner{bannerLev=" + this.cgO + ", businessCategory='" + this.bdj + '\'' + ", iconIdx=" + this.cgP + ", wording='" + this.wording + '\'' + ", callback=" + this.a + '}';
    }
  }
  
  static class e
    implements View.OnClickListener
  {
    private MqqHandler b;
    private aahb.d d;
    
    e(aahb.d paramd, MqqHandler paramMqqHandler)
    {
      this.d = paramd;
      this.b = paramMqqHandler;
    }
    
    public void onClick(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, this.d.bdj + " on close");
      }
      Message localMessage = this.b.obtainMessage(201);
      localMessage.obj = this.d;
      this.b.sendMessage(localMessage);
      this.d.a.onClose();
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class f
    implements View.OnClickListener
  {
    private MqqHandler b;
    private aahb.d d;
    
    f(aahb.d paramd, MqqHandler paramMqqHandler)
    {
      this.b = paramMqqHandler;
      this.d = paramd;
    }
    
    public void onClick(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, this.d.bdj + " on enter");
      }
      this.d.a.onEnter();
      anot.c(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class g
    implements aahb.b
  {
    @Nullable
    private aahb.d jdField_a_of_type_Aahb$d;
    @NonNull
    private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
    @NonNull
    private final WeakReference<QQAppInterface> n;
    
    public g(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface)
    {
      this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
      this.n = new WeakReference(paramQQAppInterface);
    }
    
    public void a(@Nullable aahb.d paramd)
    {
      this.jdField_a_of_type_Aahb$d = paramd;
    }
    
    public boolean isNeedAutoCloseWhenAccountChange()
    {
      return true;
    }
    
    public void onClose()
    {
      if (this.jdField_a_of_type_Aahb$d == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      aahb.a(localQQAppInterface, this.jdField_a_of_type_Aahb$d);
    }
    
    public void onEnter()
    {
      if (this.jdField_a_of_type_Aahb$d == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      try
      {
        this.jdField_a_of_type_AndroidAppPendingIntent.send();
        aahb.a(localQQAppInterface, this.jdField_a_of_type_Aahb$d);
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        for (;;)
        {
          QLog.e("Q.recent.banner", 1, "send pending intent fail with " + this.jdField_a_of_type_AndroidAppPendingIntent + "\r\n" + localCanceledException);
        }
      }
    }
    
    public void onOverride() {}
  }
  
  static class h
    implements aahb.b
  {
    @Nullable
    private aahb.d a;
    @NonNull
    private final String bdk;
    private final int cdu;
    @NonNull
    private final String mActivityName;
    @NonNull
    private final Intent mIntent;
    @NonNull
    private final String mPluginID;
    @Nullable
    private final String mPluginName;
    @NonNull
    private final String mUin;
    @NonNull
    private final WeakReference<QQAppInterface> n;
    
    public h(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull Intent paramIntent, @NonNull String paramString5, int paramInt)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.mActivityName = paramString1;
      this.bdk = paramString2;
      this.mPluginID = paramString3;
      this.mPluginName = paramString4;
      this.mIntent = paramIntent;
      this.mUin = paramString5;
      this.cdu = paramInt;
    }
    
    public void a(@Nullable aahb.d paramd)
    {
      this.a = paramd;
    }
    
    public boolean isNeedAutoCloseWhenAccountChange()
    {
      return true;
    }
    
    public void onClose()
    {
      if (this.a == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      aahb.a(localQQAppInterface, this.a);
    }
    
    public void onEnter()
    {
      if (this.a == null) {}
      QQAppInterface localQQAppInterface;
      BaseActivity localBaseActivity;
      do
      {
        do
        {
          return;
          localQQAppInterface = (QQAppInterface)this.n.get();
        } while (localQQAppInterface == null);
        localBaseActivity = BaseActivity.sTopActivity;
      } while ((localBaseActivity == null) || (localBaseActivity.isFinishing()));
      try
      {
        Class localClass = Class.forName(this.bdk).asSubclass(Activity.class);
        this.mIntent.putExtra("banner_fromBanner", true);
        avfw.d locald = new avfw.d(this.cdu);
        locald.mPluginName = this.mPluginName;
        locald.cKu = this.mActivityName;
        locald.K = localClass;
        locald.mPluginID = this.mPluginID;
        locald.mUin = this.mUin;
        locald.mIntent = this.mIntent;
        locald.mRequestCode = -1;
        avfw.a(localBaseActivity, locald);
        aahb.a(localQQAppInterface, this.a);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        QLog.e("Q.recent.banner", 1, "return to plugin error, can not find the ckass " + this.bdk);
      }
    }
    
    public void onOverride() {}
  }
  
  static class i
    implements aahb.b
  {
    @Nullable
    private aahb.d a;
    private final boolean bvK;
    private final int cgQ;
    @Nullable
    private final String mActivityName;
    @Nullable
    private final Bundle mExtra;
    @NonNull
    private final String mUrl;
    @NonNull
    private final WeakReference<QQAppInterface> n;
    
    public i(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
    {
      this.mUrl = paramString1;
      this.n = new WeakReference(paramQQAppInterface);
      this.mActivityName = paramString2;
      this.cgQ = paramInt;
      this.mExtra = paramBundle;
      this.bvK = paramBoolean;
    }
    
    public void a(@Nullable aahb.d paramd)
    {
      this.a = paramd;
    }
    
    public boolean isNeedAutoCloseWhenAccountChange()
    {
      return true;
    }
    
    public void onClose()
    {
      if (this.a == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      aahb.a(localQQAppInterface, this.a);
    }
    
    public void onEnter()
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onEnter: " + this.a + " / " + this.mActivityName + " / " + this.cgQ + " / " + this.mUrl);
      }
      if (this.a == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      Object localObject3 = QQBrowserActivity.class;
      Object localObject1 = localObject3;
      if (!TextUtils.isEmpty(this.mActivityName)) {}
      try
      {
        localObject1 = Class.forName(this.mActivityName);
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        localObject3 = localBaseActivity;
        if (localBaseActivity == null)
        {
          localObject3 = BaseApplicationImpl.getContext();
          QLog.d("Q.recent.banner", 1, "sTopActivity is null,set Application context");
        }
        if (localObject3 != null)
        {
          localObject1 = new Intent(localQQAppInterface.getApp(), (Class)localObject1);
          ((Intent)localObject1).setFlags(this.cgQ);
          ((Intent)localObject1).putExtra("banner_fromBanner", true);
          ((Intent)localObject1).putExtra("url", this.mUrl);
          ((Intent)localObject1).putExtra("banner_webview_extra", this.mExtra);
          ((Intent)localObject1).putExtra("force_no_reload", this.bvK);
        }
        for (;;)
        {
          try
          {
            ((Context)localObject3).startActivity((Intent)localObject1);
            aahb.a(localQQAppInterface, this.a);
            return;
          }
          catch (Exception localException)
          {
            QLog.d("Q.recent.banner", 1, "startActivity,error =" + localException);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "sTopActivity is null");
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
        }
      }
    }
    
    public void onOverride()
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "banner for " + this.mUrl + " is overrided");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahb
 * JD-Core Version:    0.7.0.1
 */