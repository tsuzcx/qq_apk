package com.tencent.mobileqq.activity;

import accn;
import acep;
import acfd;
import acfp;
import acgu;
import acgw;
import acje;
import acyz;
import aegp;
import aegs;
import aegu;
import aevs;
import afsr;
import ahyj;
import aime;
import aimf;
import aimj;
import aimq;
import aims;
import aiws;
import ajdp;
import ajpj;
import ajpm;
import ajpo;
import ajqo;
import ajrb;
import ajrk;
import akjp;
import akjq;
import aklk;
import akll;
import akln;
import akum;
import altq;
import amxh;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anec;
import aneo;
import anlm;
import anny;
import anot;
import anov;
import anpc;
import anpf;
import anpv;
import anwa;
import anwa.a;
import aqcl;
import aqho;
import aqhv;
import aqik;
import aqmj;
import aqqj;
import aqrb;
import areg;
import arwu;
import aurf;
import aurk;
import aurr;
import auvj;
import avug;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.a;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.a;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jnp;
import jnv;
import jsp;
import kec;
import lcm;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import oux;
import pco;
import puz;
import ram;
import rar;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import tzc;
import vew;
import vex;
import vey;
import vez;
import vfa;
import vfb;
import vfc;
import vfd;
import vfe;
import vff;
import vfg;
import vfh;
import vfi;
import vfj;
import vfk;
import vfl;
import vfm;
import vfo;
import vfq.b;
import vfu;
import vqn;
import zjo;
import zjo.a;
import zjq;

public class Leba
  extends acep
  implements aimj, View.OnClickListener, ViewStub.OnInflateListener, CommonLoadingView.a, AbsListView.e, QzoneConfig.a, vfq.b
{
  static long Gk;
  public static int bHT;
  private static List<String> qN = new ArrayList();
  private static List<String> qO = new ArrayList();
  private static List<String> qP = new ArrayList();
  private TextView DS;
  private TextView DT;
  private TextView DU;
  private TextView DV;
  private TextView DW;
  private TextView DX;
  private TextView DY;
  protected final long Gj = 30000L;
  long Gl;
  Intent H;
  private EditText I;
  protected final String TASK_ID = "mobileMP" + System.currentTimeMillis();
  private accn jdField_a_of_type_Accn = new vfl(this);
  private acyz jdField_a_of_type_Acyz = new vfh(this);
  private aimf jdField_a_of_type_Aimf;
  ajpo jdField_a_of_type_Ajpo = new vfk(this);
  private akll jdField_a_of_type_Akll = new vff(this);
  private akln jdField_a_of_type_Akln = new vfe(this);
  anwa.a jdField_a_of_type_Anwa$a = new vfo(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new vew(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private vfu jdField_a_of_type_Vfu;
  private zjo jdField_a_of_type_Zjo;
  private volatile boolean aVx = true;
  private volatile boolean aVy;
  private boolean aXL;
  private volatile boolean aXM;
  private boolean aXN = true;
  private boolean aXO;
  private boolean aXP;
  private boolean aXQ;
  private boolean aXR;
  private acje jdField_b_of_type_Acje = new vfi(this);
  private ahyj jdField_b_of_type_Ahyj = new ahyj("web_leba", "com.tencent.mobileqq:tool");
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new vex(this);
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImmersiveTitleBar2 jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private vfu jdField_b_of_type_Vfu;
  private final int bHR = 1;
  private int bHS;
  private volatile int bHU;
  private volatile int bHV;
  private Set<String> bf = new HashSet();
  AtomicBoolean by = new AtomicBoolean(false);
  acfd jdField_c_of_type_Acfd = new vfj(this);
  private afsr jdField_c_of_type_Afsr = new vfm(this);
  private ImageSwitcher jdField_c_of_type_AndroidWidgetImageSwitcher;
  private long createTime;
  private aklk jdField_d_of_type_Aklk = new vfg(this);
  private ImageSwitcher jdField_d_of_type_AndroidWidgetImageSwitcher;
  private Runnable dT = new Leba.1(this);
  private Button dk;
  private ImageSwitcher e;
  public aurf e;
  private ahyj f = new ahyj("qzone_leba", "com.tencent.mobileqq:qzone");
  private RelativeLayout gL;
  private RelativeLayout gM;
  private RelativeLayout gN;
  private RelativeLayout gw;
  private boolean mClickable = true;
  private boolean mHasInited;
  private View mRootView;
  private TextView mTitle;
  private RedTouch p;
  private ImageView pW;
  private List<aevs> qL;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> qM = new ArrayList();
  private ImageView qj;
  private ImageView qk;
  private ImageView ql;
  private ImageView qm;
  private ImageView qn;
  MqqHandler s = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  private View tA;
  private View ty;
  private View tz;
  
  static
  {
    qN.add("jiankang.qq.com");
    qN.add("guahao.com");
    qN.add("91160.com");
    qO.add("m.gamecenter.qq.com");
    qO.add("web.gamecenter.qq.com");
    qO.add("imgcache.qq.com");
    qO.add("imgcache.gtimg.cn");
    qO.add("youxi.vip.qq.com");
    qP.add("cdn.vip.qq.com");
    qP.add("comic.vip.qq.com");
    qP.add("reader.sh.vip.qq.com");
    qP.add("ac.tc.qq.com");
    qP.add("img-qq.ac.qq.com");
  }
  
  public Leba()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = aiws.a();
    this.jdField_e_of_type_Aurf = new aurf(this.jdField_b_of_type_AndroidOsHandler$Callback);
  }
  
  private void Bd(int paramInt)
  {
    if ((this.tA != null) && ((this.tA.getVisibility() == 0) || (QzoneConfig.isQQCircleShowLebaEntrance())))
    {
      zjq.cdv |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  private boolean PO()
  {
    return (this.tA != null) && (this.tA.getVisibility() == 0);
  }
  
  private boolean PP()
  {
    return (this.jdField_a_of_type_Zjo != null) && (this.jdField_a_of_type_Zjo.yk() == 1);
  }
  
  private aevs a()
  {
    if (this.qL != null)
    {
      Iterator localIterator = this.qL.iterator();
      while (localIterator.hasNext())
      {
        aevs localaevs = (aevs)localIterator.next();
        if ((localaevs != null) && (localaevs.a != null) && (localaevs.a.strPkgName != null) && (localaevs.a.strResName != null) && (localaevs.a.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localaevs;
        }
      }
    }
    return null;
  }
  
  private void a(aimq paramaimq)
  {
    if (paramaimq == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramaimq.WP), Integer.valueOf(paramaimq.position), Integer.valueOf(paramaimq.redPointType), Boolean.valueOf(paramaimq.bCg), Integer.valueOf(paramaimq.ddP) }));
    if (paramaimq.bCg)
    {
      anpv localanpv = aims.a("plugin_clk");
      localanpv.cgp = String.valueOf(paramaimq.WP);
      localanpv.cgq = String.valueOf(paramaimq.position);
      localanpv.r1 = String.valueOf(paramaimq.redPointType);
      localanpv.r2 = String.valueOf(paramaimq.ddP);
      localanpv.r3 = String.valueOf(paramaimq.ddQ);
      localanpv.r4 = ThemeUtil.getCurrentThemeId();
      anny.b(this.app, localanpv);
      return;
    }
    anot.c(this.app, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramaimq.WP), String.valueOf(paramaimq.position), String.valueOf(paramaimq.redPointType), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((altq)this.app.getManager(36)).i(paramAppInfo);
  }
  
  private void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((this.app == null) || (this.app.a == null)) {
      return;
    }
    WebProcessManager.Tb(true);
    preloadWebProcess();
    int i = aims.a(paramBoolean, paramRedTypeInfo);
    anot.a(this.app, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(i), "");
    paramRedTypeInfo = this.app.a.dZ();
    LebaPluginInfo localLebaPluginInfo;
    if (paramRedTypeInfo != null)
    {
      i = 0;
      if (i < paramRedTypeInfo.size())
      {
        localLebaPluginInfo = (LebaPluginInfo)paramRedTypeInfo.get(i);
        if (localLebaPluginInfo == null) {}
        while ((TextUtils.isEmpty(localLebaPluginInfo.strPkgName)) || (!localLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localLebaPluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l), null, false);
      bQM();
      return;
    }
  }
  
  private void aC()
  {
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131379866));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.gM = ((RelativeLayout)this.mRootView.findViewById(2131379791));
    IphoneTitleBarActivity.setLayerType((ViewGroup)findViewById(2131377361));
    this.gw = ((RelativeLayout)findViewById(2131370340));
    this.mTitle = ((TextView)findViewById(2131369627));
    this.mTitle.setText(2131720741);
    this.pW = ((ImageView)findViewById(2131369594));
    this.pW.setVisibility(0);
    this.pW.setOnClickListener(this);
    if (anlm.Vr()) {
      this.pW.setVisibility(4);
    }
    this.p = new RedTouch(a(), this.pW).a(53).a();
    bQI();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gM, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      E(this.gM, false);
      this.gw.setBackgroundResource(2130851105);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, List<String> paramList)
  {
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("Leba", 1, "showQQCircleRedDot: " + paramInt + ", " + paramBoolean + ", " + i);
      if (this.bHU != paramInt)
      {
        this.bHU = paramInt;
        this.aVx = true;
      }
      if (this.aVy != paramBoolean)
      {
        this.aVy = paramBoolean;
        this.aVx = true;
      }
      if (this.bHV != i)
      {
        this.bHV = i;
        this.aVx = true;
      }
      runOnUiThread(new Leba.37(this, paramInt, paramBoolean, i, paramList));
      return;
    }
  }
  
  private void bQA()
  {
    if (QSecFramework.a().c(1001).booleanValue()) {
      QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(81), Integer.valueOf(1), Integer.valueOf(6), "nearbyClick1", null }, null);
    }
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - Gk);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    Gk = l1;
    Object localObject3 = (altq)this.app.getManager(36);
    Object localObject2 = ((altq)localObject3).getAppInfoByPath(String.valueOf(100510));
    ((akjp)this.app.getManager(160)).RT(100510);
    zjq.cdv |= 0x1;
    Object localObject1 = ((altq)localObject3).getAppInfoByPath("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    int i;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1082;
      }
      Object localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1082;
      }
      localObject4 = ((List)localObject4).iterator();
      for (i = 2; ((Iterator)localObject4).hasNext(); i = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1079;
        }
      }
    }
    for (;;)
    {
      ((altq)localObject3).OS("100510.100517");
      localObject3 = (jnp)this.app.getBusinessHandler(43);
      ((jnp)localObject3).nW(60);
      ((jnp)localObject3).nW(59);
      localObject3 = (jnv)this.app.getManager(70);
      if (((jnv)localObject3).ye())
      {
        akjq.a().l(this.app, "home", "official_push_click");
        if (this.bHS != 0) {
          ThreadManagerV2.excute(new Leba.22(this, (ajpj)this.app.getManager(106)), 16, null, false);
        }
      }
      ((jnv)localObject3).ls(false);
      int j;
      boolean bool;
      if (this.jdField_a_of_type_Zjo == null)
      {
        j = -1;
        this.jdField_e_of_type_Aurf.post(new Leba.23(this));
        ThreadManagerV2.excute(new Leba.24(this, (ajpj)this.app.getManager(106)), 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1073;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        anot.c(this.app, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          ajrk.m("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        ajqo.Rn(0);
        if (!ajrb.nF(this.app.getAccount()))
        {
          localObject2 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          if ((j == 56) || (j == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.S(a(), (Intent)localObject2);
          label711:
          if (j != 59) {
            break label909;
          }
          new anov(this.app).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").report();
        }
        for (;;)
        {
          ajpm.D(this.app, j);
          if (bool) {
            anot.a(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          lcm.a().ag("FuJin", bool);
          return;
          j = this.jdField_a_of_type_Zjo.yj();
          break;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          a().startActivity((Intent)localObject2);
          break label711;
          label909:
          if (j == 60)
          {
            localObject1 = ((jnv)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new anov(this.app).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").report();
            } else {
              new anov(this.app).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").report();
            }
          }
          else if (j == 61)
          {
            new anov(this.app).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").report();
          }
        }
        label1073:
        bool = false;
      }
      label1079:
      break;
      label1082:
      i = 2;
    }
  }
  
  private void bQB()
  {
    if ((a() != null) && (a().app != null))
    {
      ajdp localajdp = (ajdp)a().app.getManager(10);
      if (localajdp != null)
      {
        if (this.aXL)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localajdp.QC(3);
        }
        localajdp.LO(false);
      }
    }
    this.aXL = false;
  }
  
  private void bQC()
  {
    int i = vw();
    if (i != 0) {
      pco.b("", 1, 2L, i);
    }
  }
  
  private void bQD()
  {
    zjq.a().brs = true;
    ((altq)this.app.getManager(36)).OS("150000");
    if ((this.app.a() != null) && (this.app.a().aav())) {}
    for (int i = 1; i != 0; i = 0)
    {
      PublicFragmentActivity.start(a(), LebaTableMgrFragment.class);
      return;
    }
    startActivity(new Intent(a(), LebaListMgrActivity.class));
  }
  
  private void bQE()
  {
    bQF();
    bQG();
    this.jdField_e_of_type_Aurf.sendEmptyMessageDelayed(1134006, 200L);
    bQI();
    if ((this.jdField_a_of_type_Zjo != null) && (!this.app.a().abu)) {
      this.jdField_a_of_type_Zjo.notifyDataSetChanged();
    }
  }
  
  private void bQF()
  {
    ThreadManager.post(new Leba.35(this), 5, null, false);
  }
  
  private void bQG()
  {
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (anlm.Vr()) || (this.aXM))
    {
      if (this.tA != null) {
        this.tA.setVisibility(8);
      }
      QLog.e("Leba", 1, "updateQQCircleRedFlag hide");
      return;
    }
    if (this.tA != null) {
      this.tA.setVisibility(0);
    }
    QLog.e("Leba", 1, "updateQQCircleRedFlag show");
    ThreadManager.post(new Leba.36(this), 5, null, false);
  }
  
  private void bQH()
  {
    int i = vw();
    if ((i != 0) && (this.aVx))
    {
      pco.b("", 1, 1L, i);
      this.aVx = false;
    }
  }
  
  private void bQI()
  {
    if (anlm.Vr()) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      if (this.app == null)
      {
        QLog.i("Leba", 1, "updateIconEntryRedTouch app == null");
        return;
      }
      localAppInfo = ((altq)this.app.getManager(36)).getAppInfoByPath("150000");
    } while (this.p == null);
    this.p.a(53).a().e(localAppInfo);
    a(localAppInfo);
  }
  
  private void bQJ()
  {
    Object localObject = (jnv)this.app.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((jnv)localObject).a(1);
      if (localRedDotInfo != null) {
        jnp.a(this.app, localRedDotInfo);
      }
      localObject = ((jnv)localObject).a(6);
      if (localObject != null) {
        jnp.a(this.app, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void bQN()
  {
    this.bf.add("com.tx.gamecenter.android");
    this.bf.add("com.android.music");
    this.bf.add("com.qq.yijianfankui");
    this.bf.add("com.life.android");
    this.bf.add("com.tencent.citylife.android");
    this.bf.add("com.tx.android.txnews.new2");
    this.bf.add("com.tencent.Health");
    this.bf.add("com.android.ketang");
    this.bf.add("com.tencent.zhibojian");
    this.bf.add("qzone_feedlist");
  }
  
  private void bQP()
  {
    aimq localaimq = new aimq();
    if ((this.app.a() != null) && (this.app.a().aav())) {}
    for (boolean bool = true;; bool = false)
    {
      localaimq.bCg = bool;
      localaimq.WP = 10000L;
      localaimq.position = 0;
      localaimq.redPointType = vx();
      localaimq.ddQ = 2;
      if (this.jdField_a_of_type_Zjo != null) {
        localaimq.ddQ = aims.ib(this.jdField_a_of_type_Zjo.yk());
      }
      a(localaimq);
      return;
    }
  }
  
  private void bQQ()
  {
    aimq localaimq = new aimq();
    if ((this.app.a() != null) && (this.app.a().aav())) {}
    for (boolean bool = true;; bool = false)
    {
      localaimq.bCg = bool;
      localaimq.WP = 10004L;
      localaimq.position = 0;
      localaimq.redPointType = vy();
      localaimq.ddQ = 0;
      a(localaimq);
      return;
    }
  }
  
  private void bQs()
  {
    ThreadManager.executeOnSubThread(new Leba.8(this));
  }
  
  private void bQt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter");
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      QLog.d("Q.lebatab.leba", 1, "preloadForGameCenter, net type not match, abort");
      return;
    }
    String str = oS();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("Q.lebatab.leba", 1, "preloadForGameCenter, gameCenterUrl null");
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = a();
    if ((localObject1 != null) && (((aevs)localObject1).a != null)) {}
    for (long l1 = ((aevs)localObject1).a.uiResId;; l1 = 489L)
    {
      localObject1 = (altq)this.app.getManager(36);
      Object localObject2 = ((altq)localObject1).getAppInfoByPath("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject1).getAppInfoByPath(String.valueOf(l1));
      Object localObject3 = SonicPreloader.getSonicPreloadDataList((BusinessInfoCheckUpdate.AppInfo)localObject2, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(localAppInfo, 1002);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
      {
        i = 0;
        if (i < ((SparseArray)localObject3).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(i);
          if (localSonicPreloadData.id != 1002) {
            break label370;
          }
          localSonicPreloadData.url = str;
          ((ArrayList)localObject2).add(localSonicPreloadData);
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject3 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject3).url = str;
        localArrayList.add(localObject3);
      }
      localObject3 = (WebProcessManager)this.app.getManager(13);
      if (((WebProcessManager)localObject3).U((ArrayList)localObject2)) {
        ((altq)localObject1).OS(String.valueOf("200010.200011"));
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if (((WebProcessManager)localObject3).U(localArrayList)) {
          localAppInfo.preload_ts.set(System.currentTimeMillis());
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label427;
        }
        QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
        return;
        label370:
        i += 1;
        break;
        QLog.d("Q.lebatab.leba", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
        localArrayList.add(new SonicPreloadData(0, str, true, 0L, 1));
        ((WebProcessManager)localObject3).U(localArrayList);
      }
      label427:
      break;
    }
  }
  
  private void bQw()
  {
    if (this.tA != null)
    {
      this.tA.setVisibility(8);
      this.aXM = true;
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void bQy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)findViewById(2131370342));
      this.qj = ((ImageView)findViewById(2131370332));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(getResources().getDrawable(2130851241));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      }
    }
    else
    {
      if (this.qL == null) {
        this.qL = new ArrayList();
      }
      Object localObject;
      if (this.ty == null)
      {
        this.ty = LayoutInflater.from(a()).inflate(2131561400, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.tz = this.ty.findViewById(2131376042);
        localObject = (ImageView)this.tz.findViewById(2131370398);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(auvj.euM);
        }
        ((ImageView)localObject).setImageResource(2130846231);
        this.tz.setBackgroundResource(2130839642);
        ((TextView)this.tz.findViewById(2131370399)).setText(2131720732);
        this.tz.setOnClickListener(this);
        this.qk = ((ImageView)this.ty.findViewById(2131376044));
        this.DS = ((TextView)this.ty.findViewById(2131376088));
        this.DU = ((TextView)this.ty.findViewById(2131376249));
        this.DW = ((TextView)this.ty.findViewById(2131376584));
        this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.ty.findViewById(2131376045));
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new vey(this));
        this.qm = ((ImageView)this.ty.findViewById(2131376057));
        this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.ty.findViewById(2131376046));
        this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new vez(this));
        bQz();
        this.jdField_a_of_type_Vfu = new vfu(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.qm, this.jdField_e_of_type_Aurf, this.app);
        if (this.mRootView != null) {
          this.gL = ((RelativeLayout)this.mRootView.findViewById(2131377546));
        }
        this.gN = ((RelativeLayout)this.ty.findViewById(2131370331));
        this.I = ((EditText)this.gN.findViewById(2131366542));
        this.I.setCursorVisible(false);
        aqcl.b(this.I, getString(2131692173));
        this.DY = ((TextView)this.gN.findViewById(2131380917));
        this.dk = ((Button)this.gN.findViewById(2131363801));
        this.dk.setVisibility(8);
        this.aXR = BaseApplicationImpl.sApplication.getSharedPreferences(this.app.getAccount(), 0).getBoolean("has_search_bar", false);
        bQv();
        this.I.setOnFocusChangeListener(new vfa(this));
        if (AppSetting.enableTalkBack) {
          aqcl.iq(this.ty);
        }
        acfp.m(2131720732);
        aqcl.changeAccessibilityForView(this.tz, Button.class.getName());
      }
      if (this.jdField_a_of_type_Zjo != null)
      {
        localObject = new zjo.a();
        ((zjo.a)localObject).app = this.app;
        ((zjo.a)localObject).qL = this.qL;
        ((zjo.a)localObject).context = a();
        ((zjo.a)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((zjo.a)localObject).rM = this.ty;
        ((zjo.a)localObject).jdField_a_of_type_Aimj = this;
        this.jdField_a_of_type_Zjo.a((zjo.a)localObject);
      }
      if (this.jdField_a_of_type_Aimf == null)
      {
        this.jdField_a_of_type_Aimf = new aimf(a());
        this.jdField_a_of_type_Aimf.u(this.mRootView);
        int i = a().getTitleBarHeight();
        int j = (int)aqho.convertDpToPixel(a(), 5.0F);
        this.jdField_a_of_type_Aimf.onCreate();
        this.jdField_a_of_type_Aimf.EP(i - j);
      }
      bQL();
    }
  }
  
  private void bQz()
  {
    this.tA = this.ty.findViewById(2131375019);
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (anlm.Vr())) {
      this.tA.setVisibility(8);
    }
    for (;;)
    {
      this.ql = ((ImageView)this.tA.findViewById(2131370398));
      if ((this.ql instanceof ThemeImageView)) {
        ((ThemeImageView)this.ql).setMaskShape(auvj.euM);
      }
      this.ql.setImageResource(2130846234);
      this.tA.setBackgroundResource(2130839642);
      ((TextView)this.tA.findViewById(2131375025)).setText(2131720731);
      this.tA.setOnClickListener(this);
      this.DT = ((TextView)this.tA.findViewById(2131375027));
      this.DV = ((TextView)this.tA.findViewById(2131375026));
      this.DX = ((TextView)this.tA.findViewById(2131375028));
      this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.tA.findViewById(2131375021));
      this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new vfb(this));
      this.qn = ((ImageView)this.tA.findViewById(2131375023));
      this.jdField_e_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.tA.findViewById(2131375022));
      this.jdField_e_of_type_AndroidWidgetImageSwitcher.setFactory(new vfc(this));
      this.jdField_b_of_type_Vfu = new vfu(this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageSwitcher, this.qn, this.jdField_e_of_type_Aurf, this.app);
      return;
      this.tA.setVisibility(0);
    }
  }
  
  private void bpN()
  {
    if (this.app != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Akln);
      this.app.removeObserver(this.jdField_a_of_type_Akll);
      this.app.unRegistObserver(this.jdField_d_of_type_Aklk);
      this.app.e(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.app.removeObserver(this.jdField_c_of_type_Acfd);
      this.app.removeObserver(this.jdField_a_of_type_Acyz);
      this.app.removeObserver(this.jdField_b_of_type_Acje);
      this.app.removeObserver(this.jdField_a_of_type_Accn);
      this.app.unRegistObserver(this.jdField_a_of_type_Ajpo);
      this.app.setHandler(getClass(), null);
      this.app.removeHandler(getClass());
      this.app.removeObserver(this.jdField_c_of_type_Afsr);
      anwa.b(this.jdField_a_of_type_Anwa$a);
    }
  }
  
  private String oS()
  {
    Object localObject2 = aqqj.getUrl("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((aevs)localObject3).a == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((aevs)localObject3).a.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = aqik.c(this.app, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((aqhv)localObject3).getAttribute("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
  }
  
  private void preloadWebProcess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadWebProcess");
    }
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
    if (localWebProcessManager == null) {
      return;
    }
    if (localWebProcessManager.aFT()) {
      localWebProcessManager.Yc(202);
    }
    bQs();
  }
  
  private int vw()
  {
    int j = 0;
    int i;
    if ((this.bHU > 0) && (this.aVy) && (this.bHV > 0)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if ((this.aVy) && (this.bHV > 0)) {
          return 1;
        }
        if (this.bHU > 0) {
          return 2;
        }
        i = j;
      } while (this.bHU != 0);
      i = j;
    } while (this.aVy);
    return 4;
  }
  
  private int vx()
  {
    int j = 0;
    int i;
    if ((this.DU != null) && (this.DU.getVisibility() == 0) && (this.DS != null) && (this.DS.getVisibility() == 0)) {
      i = 7;
    }
    do
    {
      do
      {
        return i;
        if ((this.DU != null) && (this.DU.getVisibility() == 0)) {
          return 4;
        }
        if ((this.DS != null) && (this.DS.getVisibility() == 0)) {
          return 5;
        }
        i = j;
      } while (this.DW == null);
      i = j;
    } while (this.DW.getVisibility() != 0);
    return 6;
  }
  
  private int vy()
  {
    int k = 1;
    int m = 0;
    int i;
    int j;
    if (this.bHU > 0)
    {
      i = 1;
      if (this.bHV <= 0) {
        break label62;
      }
      j = 1;
      label23:
      if ((!this.aVy) || (this.bHV != 0) || (this.bHU != 0)) {
        break label67;
      }
      label44:
      if (i == 0) {
        break label74;
      }
      if (j == 0) {
        break label72;
      }
      i = 7;
    }
    label62:
    label67:
    label72:
    label74:
    do
    {
      return i;
      i = 0;
      break;
      j = 0;
      break label23;
      k = 0;
      break label44;
      return 4;
      if (j != 0) {
        return 5;
      }
      i = m;
    } while (k == 0);
    return 8;
  }
  
  public boolean PN()
  {
    return this.mHasInited;
  }
  
  protected Intent a(Class<?> paramClass)
  {
    return new Intent(a(), paramClass);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.mRootView = paramLayoutInflater.inflate(2131559487, null);
    this.jdField_a_of_type_Zjo = new zjo();
    return this.mRootView;
  }
  
  public aqhv a(aevs paramaevs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, aqhv paramaqhv)
  {
    if (paramaevs.a.strPkgName.equals("com.tx.gamecenter.android")) {
      paramaqhv.gY("platformId=qq_m");
    }
    do
    {
      return paramaqhv;
      if (paramaevs.a.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return b(paramaevs, paramAppInfo, paramaqhv);
      }
      if (paramaevs.a.strPkgName.equals("com.read.android"))
      {
        paramaqhv.fj("ChannelID", "100020");
        return paramaqhv;
      }
    } while (paramaevs.a.uiResId != jsp.aCT);
    return c(paramaevs, paramAppInfo, paramaqhv);
  }
  
  public b a(aevs paramaevs, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("com.cmshow.game.android".equals(paramaevs.a.strPkgName)) {
      a(this.app, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    Object localObject;
    short s1;
    String str;
    if (paramaevs.a.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = hf("vipGameCenter");
      List localList;
      int i;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramaevs.a.strGotoUrl;
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s1 = paramShort;
        if (!paramBoolean1) {
          break label367;
        }
        str = "-1";
        localList = ((altq)this.app.getManager(36)).getAppInfoByPath(String.valueOf(paramaevs.a.uiResId)).missions.get();
        localObject = str;
        if (localList == null) {
          break label304;
        }
        localObject = str;
        if (localList.size() <= 0) {
          break label304;
        }
        localObject = "-1";
        i = 0;
        label181:
        if (i >= localList.size()) {
          break label304;
        }
        if (i != 0) {
          break label263;
        }
      }
      label263:
      for (localObject = (String)localList.get(i);; localObject = (String)localObject + "_" + (String)localList.get(i))
      {
        i += 1;
        break label181;
        if (paramString.startsWith("http")) {
          paramShort = 0;
        }
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use IndividuationUrl url=" + paramString);
        break;
      }
      label304:
      if (paramShort == 0)
      {
        paramString = paramString + "&missions=" + (String)localObject;
        QLog.i("Q.lebatab.leba", 1, "[dealGameCenterUrl] add redPointId :" + paramString);
        s1 = paramShort;
        localObject = paramString;
      }
    }
    for (;;)
    {
      label367:
      if (paramBoolean2)
      {
        if (paramaevs.a.uiResId != 0L) {
          break label608;
        }
        if ((this.DS != null) && (this.DS.getVisibility() == 0)) {
          paramBoolean3 = true;
        }
      }
      label404:
      label608:
      for (;;)
      {
        lcm.a().W((int)paramaevs.a.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new b();
          paramString.url = ((String)localObject);
          paramString.type = s1;
          paramString.ajc = paramBoolean3;
          paramString.aXT = paramBoolean1;
          paramString.aXU = paramBoolean2;
          paramString.d = paramaevs;
          return paramString;
          if (paramShort != 2) {
            break label611;
          }
          str = aqik.c(this.app, a(), paramString).getAttribute("url");
          paramString = paramString.replace(str, str + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label404;
          lcm.a().W((int)paramaevs.a.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramaevs.a.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramaevs.a.uiResId == 7966L) {
            paramBoolean3 = paramBoolean1;
          }
        }
      }
      label611:
      break;
      localObject = paramString;
      s1 = paramShort;
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onIconDownload, status=" + paramInt + ", url=" + paramString);
    }
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    ((Integer)paramVarArgs[0]).intValue();
  }
  
  public void a(aevs paramaevs)
  {
    if (paramaevs.a.strPkgName.equals("qzone_feedlist"))
    {
      anpf.a().Re(this.app.getCurrentAccountUin());
      anpf.a().Rd(this.app.getCurrentAccountUin());
      this.f.dqV();
      anot.a(this.app, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramaevs = (aneo)this.app.getManager(10);
      if (paramaevs != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramaevs.LO(true);
      }
      anot.a(this.app, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  protected void a(aevs paramaevs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, altq paramaltq)
  {
    if ((paramaevs.a != null) && (paramaevs.a.uiResId > 0L))
    {
      paramaltq = (WebProcessManager)this.app.getManager(13);
      String str = String.valueOf(paramaevs.a.uiResId);
      if ((paramAppInfo != null) && (paramaltq != null) && (paramaltq.rI(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.25(this, str, paramAppInfo));
      }
      if (paramaevs.a.strPkgName.equals(areg.cAh)) {
        ThreadManager.post(new Leba.26(this), 5, null, false);
      }
      if (paramaevs.a.uiResId == 7759L) {
        aegu.cJ(this.app);
      }
    }
  }
  
  public void a(View paramView, aevs paramaevs)
  {
    if (clickable()) {
      ThreadManager.post(new Leba.18(this, paramView, paramaevs), 8, null, true);
    }
  }
  
  public void a(View paramView, aevs paramaevs, aimq paramaimq)
  {
    if ((paramaevs == null) || (paramaevs.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramaevs.a.toString());
        a(paramaimq);
        paramaimq = (altq)this.app.getManager(36);
        if ((paramaevs != null) && (paramaevs.a != null) && (paramaevs.a.uiResId == jsp.aCT))
        {
          rar.a("dynamic", "clk_story", 0, ((jnv)this.app.getManager(70)).mP(), new String[0]);
          a(paramView, paramaevs);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramaevs != null) && (paramaevs.a != null) && (7719L == paramaevs.a.uiResId))
      {
        bQA();
        paramaimq.jq(100510, 31);
        return;
      }
      if ((paramaevs != null) && (paramaevs.a != null) && (826L == paramaevs.a.uiResId))
      {
        c(paramView, paramaevs);
        return;
      }
      if ((paramaevs != null) && (paramaevs.a != null) && (7720L == paramaevs.a.uiResId))
      {
        ExtendFriendPublicFragmentActivity.ao(a(), 2);
        if ((paramaevs.a == null) || (paramaevs.a.uiResId <= 0L)) {
          break;
        }
        paramaimq.jq((int)paramaevs.a.uiResId, 31);
        return;
      }
      if ((paramaevs != null) && (paramaevs.a != null) && (7759L == paramaevs.a.uiResId))
      {
        aegp localaegp = ((aegs)this.app.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramaimq = str;
        if (localaegp != null)
        {
          paramaimq = str;
          if (!TextUtils.isEmpty(localaegp.bwV)) {
            paramaimq = localaegp.bwV;
          }
        }
        paramaevs.a.strGotoUrl = paramaimq;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, aevs paramaevs)
  {
    if ((paramaevs == null) || (paramaevs.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramaevs.a.strGotoUrl;
    String str2 = paramaevs.a.strResName;
    short s1 = paramaevs.a.sResSubType;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramView != null)
    {
      bool1 = bool3;
      if ((paramView instanceof RedTouch)) {
        bool1 = ((RedTouch)paramView).auw();
      }
    }
    paramaevs = a(paramaevs, str1, s1, bool1, paramBoolean, false);
    aevs localaevs = paramaevs.d;
    str1 = paramaevs.url;
    s1 = paramaevs.type;
    bool3 = paramaevs.aXT;
    boolean bool4 = paramaevs.aXU;
    paramBoolean = paramaevs.ajc;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s1);
    }
    altq localaltq = (altq)this.app.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath(localaevs.a.uiResId + "");
    int k = 0;
    int j = 0;
    int m = 0;
    int i = 0;
    if (localaevs.a.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = avug.c(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localaevs.a.strPkgName.equals("com.tx.gamecenter.android")) {
          break label842;
        }
        paramBoolean |= true;
      }
    }
    label517:
    label554:
    label842:
    for (;;)
    {
      new ArrayList();
      if ((localAppInfo.red_display_info != null) && (localAppInfo.red_display_info.red_type_info != null))
      {
        paramaevs = localAppInfo.red_display_info.red_type_info.get();
        if ((paramaevs == null) || (paramaevs.size() < 2)) {}
      }
      for (i = ((BusinessInfoCheckUpdate.RedTypeInfo)paramaevs.get(1)).red_type.get();; i = 0)
      {
        k = localAppInfo.num.get();
        paramaevs = "status=" + i + "&number=" + k + "&path=" + localAppInfo.path.get();
        j = i;
        i = k;
        Object localObject = (anec)this.app.getManager(12);
        if (localObject != null) {
          if (((anec)localObject).ee(localaevs.a.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label749;
            }
            localaltq.OS(localaevs.a.uiResId + "");
            bool2 = bool1;
            if (bool1) {
              runOnUiThread(new Leba.21(this));
            }
          }
        }
        for (bool2 = bool1;; bool2 = false)
        {
          bool1 = paramBoolean;
          paramBoolean = bool2;
          for (;;)
          {
            localObject = new b();
            ((b)localObject).url = str1;
            ((b)localObject).name = str2;
            ((b)localObject).type = s1;
            ((b)localObject).isNew = paramBoolean;
            ((b)localObject).ajc = bool1;
            ((b)localObject).aIG = paramaevs;
            ((b)localObject).aXT = bool3;
            ((b)localObject).c = localAppInfo;
            ((b)localObject).bHY = j;
            ((b)localObject).bHZ = i;
            ((b)localObject).view = paramView;
            ((b)localObject).aXU = bool4;
            ((b)localObject).d = localaevs;
            ((b)localObject).a = localaltq;
            a((b)localObject);
            return;
            paramaevs = "status=" + -1 + "&number=0" + "&path=" + localaevs.a.uiResId;
            break;
            bool1 = false;
            break label517;
            label749:
            localaltq.jq((int)localaevs.a.uiResId, 31);
            break label554;
            if (localaevs.a.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = ak(false);
              paramaevs = null;
              bool1 = paramBoolean;
              i = m;
              j = k;
              paramBoolean = bool2;
            }
            else
            {
              paramaevs = null;
              bool1 = paramBoolean;
              i = m;
              j = k;
              paramBoolean = bool2;
            }
          }
        }
      }
    }
  }
  
  protected void a(aqhv paramaqhv)
  {
    if (paramaqhv != null) {
      paramaqhv.ace();
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, new String[0]);
  }
  
  public void a(b paramb)
  {
    Object localObject2 = paramb.url;
    Object localObject1 = paramb.name;
    int i = paramb.type;
    boolean bool1 = paramb.isNew;
    boolean bool2 = paramb.ajc;
    String str1 = paramb.aIG;
    boolean bool3 = paramb.aXT;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramb.c;
    int j = paramb.bHY;
    int k = paramb.bHZ;
    Object localObject3 = paramb.view;
    boolean bool4 = paramb.aXU;
    localObject3 = paramb.d;
    altq localaltq = paramb.a;
    if ((localObject2 == null) || ("".equals(localObject2))) {
      a((aevs)localObject3, localAppInfo, localaltq);
    }
    String str2;
    do
    {
      return;
      str2 = (String)aime.ln.get(Long.valueOf(((aevs)localObject3).a.uiResId));
      if (i != 0) {
        break;
      }
      localObject1 = localObject2;
      if (((String)localObject2).contains("plg_uin=1")) {
        localObject1 = (String)localObject2 + "&mqquin=" + this.app.getCurrentAccountUin();
      }
      paramb = (b)localObject1;
      if (((String)localObject1).contains("plg_vkey=1")) {
        paramb = (String)localObject1 + "&mqqvkey=" + this.app.rL();
      }
      localObject2 = a(QQBrowserActivity.class);
      if (paramb.contains("plg_nld=1")) {
        ((Intent)localObject2).putExtra("reportNld", true);
      }
      localObject1 = paramb;
      if (!TextUtils.isEmpty(str1))
      {
        ((Intent)localObject2).putExtra("redTouch", str1);
        localObject1 = paramb;
        if (paramb.contains("red_touch=1")) {
          localObject1 = paramb + "&" + str1;
        }
      }
      this.jdField_b_of_type_Ahyj.dqV();
      ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("is_from_leba", true);
      ((Intent)localObject2).putExtra("leba_resid", ((aevs)localObject3).a.uiResId);
      ((Intent)localObject2).putExtra("has_red_dot", bool2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      if (!TextUtils.isEmpty(str2)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", str2);
      }
    } while (!a((aevs)localObject3, (String)localObject1, (Intent)localObject2, bool3, bool2, localAppInfo));
    startActivity((Intent)localObject2);
    while (i != 2)
    {
      a((aevs)localObject3, localAppInfo, localaltq);
      b((aevs)localObject3);
      return;
    }
    paramb = b(this.app, a(), (String)localObject2);
    if (paramb != null)
    {
      paramb = a((aevs)localObject3, localAppInfo, paramb);
      paramb.fj("from_leba", "fromleba");
      paramb.fj("leba_resid", String.valueOf(((aevs)localObject3).a.uiResId));
      paramb.fj("config_res_plugin_item_name", (String)localObject1);
      paramb.fj("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      paramb.SC(bool1);
      paramb.setPkgName(((aevs)localObject3).a.strPkgName);
      paramb.UJ(str1);
      paramb.SD(bool2);
      paramb.setAppInfo(localAppInfo);
      if (!TextUtils.isEmpty(str2)) {
        paramb.fj("download_sourceid", str2);
      }
      if ((((aevs)localObject3).a.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject2))) {
        break label716;
      }
      MiniAppLauncher.startMiniApp(a(), (String)localObject2, 2050, null);
    }
    for (;;)
    {
      aurk.a(this.app, (aevs)localObject3, j, k);
      if (this.bf.contains(((aevs)localObject3).a.strPkgName)) {
        this.jdField_b_of_type_Ahyj.dqV();
      }
      a((aevs)localObject3);
      break;
      label716:
      a(paramb);
    }
  }
  
  public void a(String paramString, a parama)
  {
    if (parama == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        parama.onSuccess();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      parama.onSuccess();
      return;
    }
    String str1;
    int i;
    if (paramString.equals(getResources().getString(2131695230)))
    {
      str1 = getResources().getString(2131695227);
      paramString = getResources().getString(2131695232);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        SharedPreferences localSharedPreferences = a().getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          String str2 = this.app.getCurrentAccountUin();
          str2 = arwu.toMD5("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            runOnUiThread(new Leba.41(this, str1, localSharedPreferences, str2, parama));
            return;
            if (paramString.equals(getResources().getString(2131695229)))
            {
              str1 = getResources().getString(2131695226);
              paramString = getResources().getString(2131695231);
              i = 1;
              continue;
            }
            if (!paramString.equals(getResources().getString(2131695228))) {
              break label320;
            }
            str1 = getResources().getString(2131695225);
            i = 1;
            continue;
          }
        }
      }
      parama.onSuccess();
      return;
      label320:
      paramString = null;
      str1 = null;
      i = 0;
    }
  }
  
  public boolean a(aevs paramaevs, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int i = 0;
    if ((paramaevs.a.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", aurr.addParameter(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        startActivity(paramIntent);
        this.by.set(true);
        vO(paramaevs.a.strGotoUrl);
        paramaevs = (kec)this.app.getBusinessHandler(88);
        if (paramaevs != null) {
          paramaevs.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
        return false;
      }
      this.by.set(false);
      this.H = paramIntent;
      vO(paramaevs.a.strGotoUrl);
      this.jdField_e_of_type_Aurf.sendEmptyMessageDelayed(1134007, 1000L);
      return false;
    }
    if (paramaevs.a.uiResId == 5647L)
    {
      StringBuilder localStringBuilder;
      if (!paramString.contains("?"))
      {
        paramString = paramString + "?hasRedDot=" + paramBoolean2;
        if ((!paramBoolean2) || (paramAppInfo == null)) {
          break label521;
        }
        localStringBuilder = new StringBuilder();
        paramAppInfo = paramAppInfo.missions.get();
        if (paramAppInfo.size() <= 0) {
          break label424;
        }
        label315:
        if (i >= paramAppInfo.size()) {
          break label424;
        }
        if (i != paramAppInfo.size() - 1) {
          break label397;
        }
        localStringBuilder.append((String)paramAppInfo.get(i));
      }
      for (;;)
      {
        i += 1;
        break label315;
        paramString = paramString + "&hasRedDot=" + paramBoolean2;
        break;
        label397:
        localStringBuilder.append((String)paramAppInfo.get(i)).append("_");
      }
      label424:
      paramString = paramString + "&missions=" + localStringBuilder.toString();
    }
    label521:
    for (;;)
    {
      paramIntent.putExtra("url", paramString);
      if ("com.cmshow.game.android".equals(paramaevs.a.strPkgName))
      {
        paramIntent.putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
        paramIntent.putExtra("hide_operation_bar", true);
        paramIntent.putExtra("hide_more_button", true);
        paramIntent.putExtra("portraitOnly", true);
      }
      return true;
    }
  }
  
  public void aXN()
  {
    super.aXN();
  }
  
  public boolean ak(boolean paramBoolean)
  {
    aneo localaneo = (aneo)this.app.getManager(10);
    boolean bool = paramBoolean;
    if (localaneo != null) {
      if (localaneo.jn(2) <= 0)
      {
        bool = paramBoolean;
        if (localaneo.jn(1) <= 0) {}
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }
  
  public void at(Message paramMessage)
  {
    if ((this.H == null) || (this.app == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      kec localkec = (kec)this.app.getBusinessHandler(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.Gl);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.H.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = aurr.addParameter(str2, "code", paramMessage.auth_code.get());
        this.H.putExtra("url", str3);
        this.H.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.by.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          startActivity(this.H);
          this.by.set(true);
          vO(str2);
          if (localkec != null) {
            localkec.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localkec != null) {
            localkec.a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.by.get())
        {
          if (localkec != null) {
            localkec.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          startActivity(this.H);
          this.by.set(true);
        }
      }
    }
  }
  
  public aqhv b(aevs paramaevs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, aqhv paramaqhv)
  {
    paramaevs = (jnv)this.app.getManager(70);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramaevs.getAppId();
    if (i > 0) {
      localStringBuffer.append("redid=" + i);
    }
    int j = paramaevs.mN();
    if (j > 0) {
      if (localStringBuffer.length() != 0) {
        break label255;
      }
    }
    label255:
    for (paramaevs = "";; paramaevs = "&rpnumber=" + j)
    {
      localStringBuffer.append(paramaevs);
      QLog.i("Leba", 1, "xqbl redid=" + i + ",rpnumber=" + j);
      try
      {
        paramaevs = new JSONObject(paramAppInfo.buffer.get());
        if (paramaevs != null)
        {
          paramaevs = paramaevs.optJSONObject("param");
          if (paramaevs != null)
          {
            paramAppInfo = paramaevs.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramAppInfo != null)
            {
              paramaevs = paramAppInfo.optString("_red_ext_bid");
              paramAppInfo = paramAppInfo.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramaevs)) {
                localStringBuffer.append("&bid=").append(paramaevs);
              }
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&pid=").append(paramAppInfo);
              }
            }
          }
        }
      }
      catch (Exception paramaevs)
      {
        for (;;)
        {
          QLog.i("Leba", 1, "handerSpecialWhenJumpScheme", paramaevs);
        }
      }
      if (localStringBuffer.length() > 0) {
        paramaqhv.gY(localStringBuffer.toString());
      }
      return paramaqhv;
    }
  }
  
  public aqhv b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return aqik.c(paramQQAppInterface, paramContext, paramString);
  }
  
  public void b(aevs paramaevs)
  {
    if (paramaevs.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      anpc.a(a()).a(this.app, this.app.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramaevs.WP == 1047L) {
      akum.b().sourceType = 4;
    }
    runOnUiThread(new Leba.43(this));
    if (!paramaevs.a.strPkgName.equals("qzone_feedlist")) {
      this.aXL = true;
    }
  }
  
  public void b(View paramView, aevs paramaevs)
  {
    if ((paramaevs == null) || (paramaevs.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramaevs.a.strResName, new vfd(this, paramView, paramaevs));
  }
  
  public void bMe()
  {
    super.bMe();
    bpN();
    if (this.jdField_a_of_type_Vfu != null) {
      this.jdField_a_of_type_Vfu.bQU();
    }
    if (this.jdField_b_of_type_Vfu != null) {
      this.jdField_b_of_type_Vfu.bQU();
    }
  }
  
  protected void bQK()
  {
    Object localObject = (altq)this.app.getManager(36);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject).getAppInfoByPath("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((altq)localObject).getAppInfoByPath("886.100171");
          i = j;
          if (localAppInfo != null)
          {
            i = j;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = j;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        j = i;
        if (i == -1)
        {
          localObject = ((altq)localObject).getAppInfoByPath("886.100172");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                j = 2;
              }
            }
          }
        }
        if (j != -1) {
          anot.a(this.app, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
        }
        if (((jnv)this.app.getManager(70)).ye()) {
          akjq.a().l(this.app, "entry", "official_push_exp");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + j);
      }
      return;
      j = -1;
      break;
      j = -1;
    }
  }
  
  void bQL()
  {
    ThemeBackground.applyThemeBg(this.app, this.qj, 4, 2130838901, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.aXO = true;
    }
  }
  
  public void bQM()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    if (this.app != null)
    {
      ajdp localajdp = (ajdp)this.app.getManager(10);
      aneq.cFc = true;
      if (localajdp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localajdp.QC(3);
      }
      if (this.app.a != null)
      {
        this.app.a.cJt();
        this.app.a.cJw();
      }
    }
    if (!ZV()) {
      cIu();
    }
    Bd(2);
  }
  
  public void bQO()
  {
    if ((this.H == null) || (this.app == null) || (this.by.get() == true)) {}
    kec localkec;
    do
    {
      return;
      localkec = (kec)this.app.getBusinessHandler(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.H.putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivity(this.H);
      this.by.set(true);
    } while (localkec == null);
    localkec.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
  
  public void bQu()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  protected void bQv()
  {
    RelativeLayout localRelativeLayout;
    if (this.gN != null)
    {
      localRelativeLayout = this.gN;
      if (!amxh.awj()) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void bQx()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.10(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT())) {
      localWebProcessManager.Yc(202);
    }
  }
  
  public aqhv c(aevs paramaevs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, aqhv paramaqhv)
  {
    Object localObject = (jnv)this.app.getManager(70);
    paramAppInfo = ((jnv)localObject).a();
    paramaevs = paramAppInfo;
    if (paramAppInfo == null)
    {
      paramaevs = paramAppInfo;
      if (((puz)this.app.getManager(252)).aBT)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
        }
        paramaevs = ((jnv)localObject).a(52);
        if (paramaevs != null) {
          break label223;
        }
        paramaevs = ((jnv)localObject).a(35);
      }
    }
    label223:
    for (;;)
    {
      paramAppInfo = paramaqhv;
      if (paramaevs != null)
      {
        paramAppInfo = paramaqhv;
        if (paramaevs.uint32_appid.get() == 37) {
          localObject = null;
        }
      }
      try
      {
        paramAppInfo = new JSONObject(paramaevs.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject = paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          ram.w("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { paramAppInfo.getMessage() });
          continue;
          paramaevs = String.valueOf(paramaevs.uint32_appid.get());
        }
      }
      paramAppInfo = paramaqhv;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInfo = aqik.c(this.app, a(), (String)localObject);
      }
      if (paramaevs == null)
      {
        paramaevs = "";
        paramAppInfo.fj("redid", paramaevs);
        paramAppInfo.fj("lebaVersion", "old");
        return paramAppInfo;
      }
    }
  }
  
  void c(View paramView, aevs paramaevs)
  {
    if (paramaevs == null) {
      return;
    }
    paramaevs.a.strGotoUrl = acgu.bow;
    String str = aqmj.T(a(), this.app.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramaevs.a.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramaevs.a.strGotoUrl);
    }
    b(paramView, paramaevs);
    bQJ();
    anot.c(this.app, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  boolean clickable()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.mClickable;
      if (this.mClickable)
      {
        this.mClickable = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.19(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public String hf(String paramString)
  {
    return aqqj.getUrl(paramString);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    bQv();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Vfu != null) {
      this.jdField_a_of_type_Vfu.onAccountChanged(this.app);
    }
    if (this.jdField_b_of_type_Vfu != null) {
      this.jdField_b_of_type_Vfu.onAccountChanged(this.app);
    }
    zjq.a().reset();
    bQE();
    if (this.jdField_a_of_type_Aimf != null) {
      this.jdField_a_of_type_Aimf.onAccountChanged(this.app);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (!clickable()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369594: 
      case 2131369612: 
        anot.a(this.app, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        bQD();
        break;
      case 2131375019: 
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_enable_splash", true);
        ((Intent)localObject).putExtra("key_jump_from", "3");
        oux.u(a(), (Intent)localObject);
        bQQ();
        bQC();
        Bd(1);
        break;
      case 2131376042: 
        if (QLog.isColorLevel()) {
          QLog.d("HardCoder", 2, "launch qzone");
        }
        bHT = tzc.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
        localObject = (aevs)zjq.a().hq.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new Leba.33(this, (aevs)localObject), null, true);
        bQP();
        aqcl.s(this.tz, acfp.m(2131720732));
        MiniSdkLauncher.preLaunchMiniAppCheckinFromLeba();
      }
    }
  }
  
  public void onConfigChange()
  {
    if (this.aXM)
    {
      QLog.d("Leba", 1, "onConfigChange");
      this.aXM = false;
      runOnUiThread(new Leba.40(this));
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    aC();
    bQN();
    ((ViewStub)findViewById(2131378886)).setOnInflateListener(this);
    ((CommonLoadingView)findViewById(2131365078)).setOnFirstDrawListener(this);
    this.createTime = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void onDestroy()
  {
    bpN();
    if (this.jdField_a_of_type_Vfu != null) {
      this.jdField_a_of_type_Vfu.bQU();
    }
    if (this.jdField_b_of_type_Vfu != null) {
      this.jdField_b_of_type_Vfu.bQU();
    }
    if (this.jdField_a_of_type_Aimf != null) {
      this.jdField_a_of_type_Aimf.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onFirstDraw()
  {
    this.jdField_e_of_type_Aurf.post(new Leba.2(this));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    pE(false);
    if (!this.mHasInited) {
      onResume(true);
    }
    this.mHasInited = true;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onLogout");
    }
  }
  
  public void onPause()
  {
    ApngImage.pauseByTag(4);
    super.onPause();
    WebProcessManager.Tb(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.pause();
    }
    this.f.end();
    this.jdField_b_of_type_Ahyj.end();
    ajqo.Ro(0);
    this.jdField_e_of_type_Aurf.removeMessages(1134010);
    if (this.jdField_a_of_type_Vfu != null) {
      this.jdField_a_of_type_Vfu.bQS();
    }
    if (this.jdField_b_of_type_Vfu != null) {
      this.jdField_b_of_type_Vfu.bQS();
    }
    if (this.jdField_a_of_type_Zjo != null) {
      this.jdField_a_of_type_Zjo.e(vx(), PO(), vy());
    }
    if (this.jdField_a_of_type_Aimf != null) {
      this.jdField_a_of_type_Aimf.onPause();
    }
    this.jdField_e_of_type_Aurf.postDelayed(new Leba.3(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onPause");
    }
    this.aVx = true;
    Bd(3);
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.qj != null) {
      this.qj.setTag(null);
    }
    bQL();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gM, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_e_of_type_Aurf.sendEmptyMessageDelayed(11340002, 0L);
      if (this.pW != null)
      {
        if (!anlm.Vr()) {
          break label218;
        }
        this.pW.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zjo != null) {
        this.jdField_a_of_type_Zjo.onPostThemeChanged();
      }
      if (this.jdField_a_of_type_Vfu != null) {
        this.jdField_a_of_type_Vfu.onPostThemeChanged();
      }
      if (this.jdField_b_of_type_Vfu != null) {
        this.jdField_b_of_type_Vfu.onPostThemeChanged();
      }
      if (this.jdField_a_of_type_Aimf != null) {
        this.jdField_a_of_type_Aimf.onPostThemeChanged();
      }
      if (this.ty != null) {
        TextHook.updateFont(this.ty);
      }
      return;
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      E(this.gM, false);
      this.gw.setBackgroundResource(2130851105);
      break;
      label218:
      this.pW.setVisibility(0);
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + zjq.cdv);
    }
    AbstractGifImage.resumeAll();
    lcm.a().aJU();
    if (this.aXQ)
    {
      ThreadRegulator.a().JX(4);
      this.aXQ = false;
    }
    vqn.aN(this.app);
    if (this.jdField_a_of_type_Vfu != null) {
      this.jdField_a_of_type_Vfu.bQT();
    }
    if (this.jdField_b_of_type_Vfu != null) {
      this.jdField_b_of_type_Vfu.bQT();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((altq)this.app.getManager(36)).kP(System.currentTimeMillis());
    if ((!this.mHasInited) || ((zjq.cdv & 0x4) != 0)) {
      this.jdField_e_of_type_Aurf.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.Tb(true);
      this.jdField_e_of_type_Aurf.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (ajpj)this.app.getManager(106)), 16, null, false);
      bQI();
      Object localObject;
      if (AppSetting.enableTalkBack)
      {
        this.mTitle.setFocusable(true);
        this.pW.setContentDescription(getString(2131692128));
        localObject = getString(2131695650);
        this.mTitle.setContentDescription((CharSequence)localObject);
        a().setTitle(getString(2131695650));
      }
      if (this.jdField_a_of_type_Zjo != null) {
        this.jdField_a_of_type_Zjo.onResume();
      }
      if (this.jdField_a_of_type_Aimf != null) {
        this.jdField_a_of_type_Aimf.onResume(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.aXP) && (a() != null))
      {
        this.aXP = true;
        ThreadManagerV2.executeOnSubThread(this.dT);
      }
      if (this.app.a() != null) {
        this.app.a().cJu();
      }
      return;
      if (zjq.cdv > 0)
      {
        localObject = new ArrayList();
        acgw.F((List)localObject, zjq.a().e(this.app));
        if (this.qL != null)
        {
          this.qL.clear();
          this.qL.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Zjo != null)
          {
            this.jdField_a_of_type_Zjo.notifyDataSetChanged();
            bQE();
          }
        }
        zjq.cdv = 0;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (this.aXO)
      {
        if (paramInt != 0)
        {
          ApngImage.pauseByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
          }
        }
        if (paramInt == 0)
        {
          ApngImage.playByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged SCROLL_STATE_IDLE");
          }
        }
      }
    } while (this.jdField_a_of_type_Zjo == null);
    this.jdField_a_of_type_Zjo.onScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onStop");
    }
  }
  
  public void pE(boolean paramBoolean)
  {
    try
    {
      bQy();
      this.app.cLv();
      this.app.setHandler(getClass(), this.jdField_e_of_type_Aurf);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.app.registObserver(this.jdField_a_of_type_Akln);
      this.app.addObserver(this.jdField_a_of_type_Akll);
      this.app.registObserver(this.jdField_d_of_type_Aklk);
      this.app.addObserver(this.jdField_c_of_type_Acfd);
      this.app.addObserver(this.jdField_a_of_type_Acyz);
      this.app.addObserver(this.jdField_b_of_type_Acje);
      this.app.addObserver(this.jdField_a_of_type_Accn, true);
      this.app.registObserver(this.jdField_a_of_type_Ajpo);
      this.app.addObserver(this.jdField_c_of_type_Afsr);
      anwa.a(this.jdField_a_of_type_Anwa$a);
      if (paramBoolean) {
        bQw();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.lebatab.leba", 1, "leba fillData->initLebaView exception:" + localException, localException);
      }
    }
  }
  
  public String setLastActivityName()
  {
    return acfp.m(2131707641);
  }
  
  void vO(String paramString)
  {
    ((aqrb)this.app.getBusinessHandler(71)).Vy(paramString);
    this.Gl = System.currentTimeMillis();
  }
  
  public static abstract interface a
  {
    public abstract void onSuccess();
  }
  
  public static class b
  {
    altq a;
    String aIG;
    boolean aXT;
    boolean aXU;
    boolean ajc;
    int bHY;
    int bHZ;
    BusinessInfoCheckUpdate.AppInfo c;
    aevs d;
    boolean isNew;
    String name;
    short type;
    String url;
    View view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */