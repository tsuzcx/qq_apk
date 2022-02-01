package com.tencent.mobileqq.activity;

import aahb;
import aaiv;
import aaiw;
import aajb;
import aajg;
import aajg.a;
import aajt;
import aajx;
import aakj;
import aako;
import aakp;
import aakz;
import aala;
import aalb;
import aale;
import aamm;
import abbf;
import abmt;
import acbn;
import accc;
import accd;
import accn;
import accy;
import accz;
import acdl;
import acdv;
import acep;
import acfd;
import acff;
import acfp;
import acfs;
import acgf;
import achg;
import achq;
import acjq;
import acku;
import ackx;
import aclr;
import acmc;
import acmf;
import acnd;
import acnh;
import acqe;
import acxw;
import adah;
import adak;
import adaq;
import adrm;
import adue;
import aekv;
import afsr;
import afwh;
import aghq;
import agkh;
import agrt;
import ahyj;
import aibd;
import aibe;
import aibg;
import aicu;
import aiwd;
import aiyy;
import aizp;
import aizr;
import ajpd;
import aklk;
import aktr;
import akze;
import alkm;
import altq;
import altu;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anor;
import anot;
import anov;
import anpc;
import anre;
import anvv;
import anwa;
import anwa.a;
import anxk;
import aobw;
import aogc;
import aojn;
import aojs;
import aojv;
import aojz;
import aoko;
import aokp;
import aokv;
import aooi;
import aook;
import aptr;
import apuf;
import apuh;
import apuk;
import aqcy;
import aqeu;
import aqfp;
import aqft;
import aqgv;
import aqgw;
import aqgz;
import aqha;
import aqiw;
import aqiy;
import aqjl;
import aqmf;
import aqmj;
import aqmq;
import aqmr;
import aqxg;
import aqxh;
import arhz;
import aurf;
import aurk;
import ausb;
import ausj;
import auuo;
import auvk;
import avhc;
import awit;
import awkk;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.a;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog.a;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import inh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import jll;
import jxc;
import jxl;
import jxp;
import kaw;
import kbp;
import kdm;
import kxm;
import lcm;
import lcm.h;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import nyn;
import oan;
import obt;
import org.json.JSONException;
import org.json.JSONObject;
import pmd;
import pmj;
import pum;
import puy;
import puz;
import pvz;
import rar;
import swu;
import tog;
import txn;
import ury;
import usa;
import usb;
import usc;
import usd;
import use;
import usf;
import usg;
import ush;
import usi;
import usj;
import usk;
import usl;
import usm;
import usn;
import uso;
import usp;
import usq;
import usr;
import uss;
import ust;
import usu;
import usv;
import usw;
import usx;
import usy;
import usz;
import uta;
import utb;
import utc;
import utf;
import uth;
import uti;
import utj;
import utk;
import utl;
import utm;
import utn;
import uto;
import utp;
import utq;
import utt;
import vqo;
import wkh;
import ykf;
import yzp;
import zjt.a;

public class Conversation
  extends acep
  implements aajb, aajg.a, acbn, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, auuo, FrameHelperActivity.a, UpgradeTipsDialog.a, AbsListView.e, SwipListView.a, Observer
{
  public static long FL = -1L;
  public static boolean aVf = true;
  private static long lastClickTime;
  public long FM = 0L;
  long FN;
  public long FO = 0L;
  long FP = 0L;
  private long FQ;
  private long FR;
  private long FS = -1L;
  public Dialog I;
  Dialog J;
  private Dialog K;
  public ausj V;
  public aahb a;
  private aaiw jdField_a_of_type_Aaiw;
  public aajg a;
  public aakj a;
  private aakp jdField_a_of_type_Aakp;
  aala jdField_a_of_type_Aala;
  public aamm a;
  protected accd a;
  accn jdField_a_of_type_Accn = new usn(this);
  private final accz jdField_a_of_type_Accz = new usk(this);
  private final acfd jdField_a_of_type_Acfd = new ush(this);
  private acgf jdField_a_of_type_Acgf = new utb(this);
  private acku jdField_a_of_type_Acku = new d(this);
  private ackx jdField_a_of_type_Ackx = new usw(this);
  private aclr jdField_a_of_type_Aclr = new utc(this);
  acmc jdField_a_of_type_Acmc = new uso(this);
  private final acmf jdField_a_of_type_Acmf = new uss(this);
  acnh jdField_a_of_type_Acnh = new usl(this);
  private adah jdField_a_of_type_Adah = new a(this);
  private afsr jdField_a_of_type_Afsr = new utm(this);
  public aiwd a;
  private aktr jdField_a_of_type_Aktr = new uti(this);
  public akze a;
  protected Handler.Callback a;
  private anwa.a jdField_a_of_type_Anwa$a = new utn(this);
  aqxh jdField_a_of_type_Aqxh = null;
  private awkk jdField_a_of_type_Awkk;
  private DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityConversation$DateFormatChangeRunnable = new DateFormatChangeRunnable(null);
  private b jdField_a_of_type_ComTencentMobileqqActivityConversation$b;
  c jdField_a_of_type_ComTencentMobileqqActivityConversation$c = new c();
  private f jdField_a_of_type_ComTencentMobileqqActivityConversation$f;
  public QQSettingMe a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  public FrameHelperActivity a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
  private final inh jdField_a_of_type_Inh = new ust(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new uth(this);
  utq jdField_a_of_type_Utq = null;
  public utt a;
  vqo jdField_a_of_type_Vqo = new usx(this);
  yzp jdField_a_of_type_Yzp;
  public String aMA;
  public String aMB;
  public boolean aUM;
  public boolean aUN;
  public boolean aUO;
  public boolean aUP;
  protected boolean aUQ;
  public boolean aUR;
  boolean aUS = false;
  boolean aUT = false;
  boolean aUU = false;
  boolean aUV = false;
  boolean aUW = false;
  boolean aUX = false;
  private boolean aUY;
  private boolean aUZ;
  boolean aVa = false;
  boolean aVb = false;
  private boolean aVc = true;
  private boolean aVd;
  private boolean aVe;
  public volatile boolean aVg;
  private boolean aVh;
  private boolean aVi;
  private boolean aVj;
  private boolean aVk;
  public boolean aVl;
  boolean aVm = false;
  boolean aVn = false;
  public boolean aVo;
  private boolean aVp;
  private boolean aVq;
  private boolean aVr;
  private boolean aVs;
  private int ajD;
  private final BroadcastReceiver au = new usy(this);
  private final BroadcastReceiver av = new usz(this);
  private final BroadcastReceiver aw = new uta(this);
  private final acdl jdField_b_of_type_Acdl = new usr(this);
  acdv jdField_b_of_type_Acdv = new usp(this);
  private final acnd jdField_b_of_type_Acnd = new usi(this);
  private ahyj jdField_b_of_type_Ahyj = new ahyj("tool_adMessage", "com.tencent.mobileqq:tool");
  private final aklk jdField_b_of_type_Aklk = new usu(this);
  ImmersiveTitleBar2 jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final pmd jdField_b_of_type_Pmd = new usv(this);
  public pvz b;
  int bGb = -1;
  int bGc;
  int bGd;
  int bGe = 3;
  public volatile int bGf = 17;
  public volatile int bGg;
  private AtomicBoolean bu = new AtomicBoolean(false);
  private aghq jdField_c_of_type_Aghq;
  private ahyj jdField_c_of_type_Ahyj = new ahyj("tool_shop", "com.tencent.mobileqq:tool");
  protected Runnable cq = new Conversation.58(this);
  private ahyj d = new ahyj("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable dL;
  private Runnable dM = new Conversation.4(this);
  private Runnable dN = new Conversation.20(this);
  public Runnable dO = new Conversation.25(this);
  public PullRefreshHeader f;
  private arhz g;
  public MqqHandler g;
  public RelativeLayout gv;
  public RelativeLayout gw;
  RelativeLayout gx;
  public boolean isDestroy = false;
  boolean isInited = false;
  public RedTouch k;
  MqqHandler k;
  RedTouch l;
  public GestureDetector mGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new utk(this));
  public boolean mIsForeground = false;
  ImageView mLoadingView;
  private final achq mMsgObserver = new usm(this);
  ViewGroup mRootView;
  int mScrollState = 0;
  TextView nR;
  MqqHandler p = new aurf(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation$c);
  public ImageView pM;
  ImageView pN;
  public ArrayList<adue> pb = new ArrayList();
  public List<RecentBaseData> qE;
  final List<String> qF = new ArrayList(40);
  protected StringBuilder sb;
  View sg;
  View sh;
  View si;
  private View sj;
  private View sk;
  public long uC = 2000L;
  
  public Conversation()
  {
    this.jdField_a_of_type_Utt = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ury(this);
    this.jdField_a_of_type_Accd = new usj(this);
  }
  
  private void AA(int paramInt)
  {
    for (;;)
    {
      try
      {
        QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(this.app.a.He()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.aUV) });
        if (1 == paramInt)
        {
          this.aVg = true;
          this.k.sendEmptyMessage(18);
          h(1072, 500L, true);
          h(1073, 30000L, true);
          if (this.jdField_a_of_type_Utt != null) {
            this.jdField_a_of_type_Utt.bMT();
          }
        }
        if (!this.aUV)
        {
          boolean bool = this.isDestroy;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.aUV = true;
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_Aahb.bMT();
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.mUiHandler.sendEmptyMessage(19);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync cost=", Long.valueOf(System.currentTimeMillis() - l1), " all done!" });
        } else {
          QLog.d("Q.recent", 2, "doAfterMsgSync all done!");
        }
      }
      finally {}
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.bc(paramContext))
    {
      anot.a(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.ar(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.34(paramMqqHandler), l1 * 1000L);
      }
      return;
    }
    paramContext = paramMqqHandler.obtainMessage(1134065);
    paramContext.arg1 = 0;
    paramMqqHandler.sendMessage(paramContext);
  }
  
  private void aAz()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void aB(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onNetWorkStateChange isNetWorkConnect = " + paramBoolean + " what = " + paramInt);
    }
    if (paramInt != 10003) {}
    while (!paramBoolean) {
      return;
    }
    a(1064, 200L, true, "qboss_banner_net_change");
    h(1072, 400L, true);
  }
  
  private void aXh()
  {
    if (aiyy.a().apW()) {
      aiyy.a().Qv(3);
    }
  }
  
  private void ap(Message paramMessage)
  {
    for (;;)
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips");
        }
        if ((this.app != null) && (this.K == null))
        {
          boolean bool = paramMessage.obj instanceof UpgradeTIMWrapper;
          if (bool) {}
        }
        else
        {
          return;
        }
        localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper == null) || (TextUtils.isEmpty(localUpgradeTIMWrapper.title)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.msgContent)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.url))) {
          continue;
        }
        usa localusa = new usa(this);
        usb localusb = new usb(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.cse))
        {
          paramMessage = acfp.m(2131704498);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.csf)) {
            break label323;
          }
          str = acfp.m(2131704508);
          this.K = aqha.a(a(), localUpgradeTIMWrapper.title, localUpgradeTIMWrapper.msgContent, paramMessage, str, null, localusb, localusa);
          this.K.setCanceledOnTouchOutside(false);
          this.K.setOnDismissListener(new usc(this));
          if ((!this.isResume) || (this.K.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) || (accy.ac(this.app))) {
            continue;
          }
          this.K.show();
          anot.a(this.app, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          accy.cn(this.app);
          h(1134048, 0L, true);
          continue;
        }
        paramMessage = localUpgradeTIMWrapper.cse;
      }
      finally {}
      continue;
      label323:
      String str = localUpgradeTIMWrapper.csf;
    }
  }
  
  private void aq(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (accy.z(this.app) >= 5)
      {
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((accy.ac(this.app)) || (accy.g(this.app, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.app, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new usd(this));
  }
  
  private void atg()
  {
    try
    {
      if (this.jdField_g_of_type_Arhz == null)
      {
        this.jdField_g_of_type_Arhz = new arhz(a(), a().getTitleBarHeight());
        this.jdField_g_of_type_Arhz.setMessage(2131696678);
        this.jdField_g_of_type_Arhz.setBackAndSearchFilter(false);
        this.jdField_g_of_type_Arhz.setOnDismissListener(new utl(this));
      }
      this.jdField_g_of_type_Arhz.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ath()
  {
    try
    {
      if ((this.jdField_g_of_type_Arhz != null) && (this.jdField_g_of_type_Arhz.isShowing())) {
        ThreadManager.getUIHandlerV2().postDelayed(this.cq, 800L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bHR()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        anot.a(this.app, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void bMA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    achg localachg = (achg)this.app.getManager(159);
    if (localachg.aaE())
    {
      localachg.cJP();
      return;
    }
    this.aVb = localachg.aaF();
    ArrayList localArrayList = localachg.cw();
    if ((this.aVb) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localachg.cJQ();
      return;
    }
    localachg.cJR();
    this.aVb = false;
  }
  
  private void bMC()
  {
    this.jdField_c_of_type_Aghq = new usq(this);
  }
  
  private void bMD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDataListManager", 2, "preloadNextScreenUserFaceIcon:" + this.aVc);
    }
    int i;
    int j;
    int m;
    if (this.aVc)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() + 1;
      j = 1;
      m = 0;
      if ((j != 0) && (m < 10) && (i >= 0)) {
        break label103;
      }
    }
    label103:
    while (i >= this.jdField_a_of_type_Aajg.getCount())
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      j = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Aajg.getItem(i);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      m += 1;
      break;
      this.jdField_a_of_type_Aajg.a().a(((RecentBaseData)localObject).ng(), ((RecentBaseData)localObject).qx(), false);
      i += j;
    }
  }
  
  private void bME()
  {
    if ((this.isDestroy) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a[0] = new utf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a[1] = new zjt.a();
  }
  
  private void bMF()
  {
    if ((this.isResume) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b.Wt())) {
      ThreadManager.post(new Conversation.50(this), 5, null, true);
    }
  }
  
  private void bMH()
  {
    if ((this.jdField_g_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Aakj != null))
    {
      this.jdField_a_of_type_Aakj.W("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void bMI()
  {
    if (!this.isResume) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Aahb.hy(21)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.aVs = false;
        return;
      }
      if (this.aVs) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkPushBannerReport");
      }
      this.aVs = true;
      ThreadManager.post(new Conversation.51(this, this.jdField_a_of_type_Aahb.b(21, 2131362278)), 5, null, false);
      return;
    }
  }
  
  private void bMc()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.isInited);
    }
    if (this.isInited) {
      return;
    }
    this.jdField_a_of_type_Aajg.cuO();
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.isInited = true;
    if (!this.aUT) {
      this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    e(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void bMd()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_Awkk == null) {
        this.jdField_a_of_type_Awkk = new awkk(this.app, this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_Awkk.bMd();
    }
  }
  
  private void bMh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() >= 0)
    {
      this.aVr = true;
      this.FS = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void bMi()
  {
    if (this.aUQ)
    {
      anot.a(this.app, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Aajg != null)) {}
    }
    else
    {
      return;
    }
    int m = this.jdField_a_of_type_Aajg.getCount();
    int i = this.bGb + 1;
    label96:
    int j;
    for (;;)
    {
      if (i < m)
      {
        Object localObject = this.jdField_a_of_type_Aajg.getItem(i);
        if (!(localObject instanceof RecentBaseData))
        {
          i += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).Gq())
          {
            j = ((RecentBaseData)localObject).wU();
            label124:
            if (j <= 0) {
              break label276;
            }
            if (this.bGb != i) {
              this.bGb = i;
            }
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        if (aVf) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(this.bGb + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.bGb);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.bGb + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount(), 0);
        continue;
        if (aVf) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(aVf);
        }
        bMh();
        this.bGb = -1;
      }
      break;
      j = 0;
      break label124;
      label276:
      break label96;
    }
  }
  
  private void bMm()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.FP);
    if ((this.jdField_a_of_type_Aajg != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (aale.a().iP(str)) {
        this.FP = l1;
      }
    }
  }
  
  private void bMo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.aVk);
    }
    if ((!this.isResume) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isReady()))
    {
      if (this.isResume)
      {
        if ((!accy.ac(this.app)) && (!this.aVk))
        {
          h(1134047, 0L, true);
          this.aVk = true;
        }
        h(1134057, 0L, true);
      }
      return;
    }
    if ((this.K != null) && (this.K.isShowing()))
    {
      this.K.dismiss();
      this.K = null;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.show();
      accy.cn(this.app);
      int i = accy.z(this.app);
      accy.n(this.app, i + 1);
      anot.a(this.app, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      anot.a(this.app, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void bMq()
  {
    Manager localManager = this.app.getManager(36);
    if ((localManager instanceof altq))
    {
      int i = ((altq)localManager).ag("104000.104001", 100);
      if (i > 0) {
        n(8, acbn.bly, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.app.getCurrentUin() + "getSubscribeAccountRedDotNum  redNumByPath:" + i);
    }
  }
  
  private void bMu()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    bMD();
    h(1010, 0L, false);
    h(1023, 0L, false);
    h(1027, 0L, false);
    bMo();
    altu.l(this);
    if (!this.aUQ) {
      ((FriendListHandler)this.app.getBusinessHandler(1)).e(this.app.getCurrentAccountUin(), (byte)2);
    }
    bHR();
    ((anvv)this.app.getManager(361)).y(a());
  }
  
  private void bMv()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.sh == null);
      localObject = this.jdField_a_of_type_Aajg.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    boolean bool;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!ajpd.d(this.app, ((RecentUserBaseData)localObject).mUser)))
    {
      bool = localTroopManager.kv(((RecentUserBaseData)localObject).qx());
      label91:
      if (this.aVe == bool) {
        break label207;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "setLocalSearchBarByShowUpMask:mShowUPMask = " + this.aVe + ", dstMsg = " + bool);
      }
      if (!bool) {
        break label209;
      }
    }
    label207:
    label209:
    for (int i = 2130851333;; i = 2130851332)
    {
      if (bool) {}
      this.sh.setBackgroundResource(i);
      this.sh.findViewById(2131366542).setBackgroundResource(2130851343);
      this.aVe = bool;
      return;
      if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L)
      {
        bool = true;
        break label91;
      }
      bool = false;
      break label91;
      break;
    }
  }
  
  private void bMx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if ((this.app == null) || (!this.isInited)) {
      break label30;
    }
    label30:
    label170:
    for (;;)
    {
      return;
      if ((aobw.bK(this.app)) && (aobw.bL(this.app)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Aajg != null))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Aajg.getItem(i);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).wU() <= 0)) {}
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (!kaw.a().a(this.app))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.d == null) {
            break;
          }
          this.d.begin();
          return;
          i += 1;
          break label73;
        }
      }
    }
  }
  
  private void biP()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.dM);
    ThreadManager.getUIHandler().postDelayed(this.dM, 50L);
  }
  
  private void bpN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers" + this.bu);
    }
    synchronized (this.bu)
    {
      this.bu.set(false);
      Object localObject1;
      if (this.app != null)
      {
        this.app.removeObserver(this.jdField_a_of_type_Acfd);
        this.app.removeObserver(this.jdField_b_of_type_Acnd);
        this.app.removeObserver(this.jdField_a_of_type_Accd);
        this.app.removeObserver(this.jdField_a_of_type_Accz);
        this.app.removeObserver(this.mMsgObserver);
        this.app.removeObserver(this.jdField_a_of_type_Acnh);
        this.app.removeObserver(this.jdField_a_of_type_Accn);
        this.app.removeObserver(this.jdField_b_of_type_Acdv);
        this.app.removeObserver(this.jdField_a_of_type_Acmf);
        this.app.removeObserver(this.jdField_b_of_type_Acdl);
        this.app.removeObserver(this.jdField_a_of_type_Acgf);
        this.app.removeObserver(this.jdField_b_of_type_Pmd);
        this.app.unRegistObserver(this.jdField_b_of_type_Aklk);
        this.app.removeObserver(this.jdField_a_of_type_Ackx);
        this.app.removeObserver(this.jdField_a_of_type_Aclr);
        this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.app.removeObserver(this.jdField_a_of_type_Aktr);
        this.app.removeObserver(this.jdField_a_of_type_Afsr);
        this.app.removeObserver(this.jdField_a_of_type_Acmc);
        anwa.b(this.jdField_a_of_type_Anwa$a);
        if (this.app.a() != null) {
          this.app.a().deleteObserver(this.jdField_a_of_type_Inh);
        }
        if (this.app.b() != null) {
          this.app.b().deleteObserver(this);
        }
        if (this.jdField_c_of_type_Aghq != null) {
          this.app.a().deleteObserver(this.jdField_c_of_type_Aghq);
        }
        this.app.setHandler(getClass(), null);
        this.app.removeHandler(getClass());
        this.app.unRegistObserver(this.jdField_a_of_type_Vqo);
        this.app.removeObserver(this.jdField_a_of_type_Acku);
        this.app.removeObserver(this.jdField_a_of_type_Adah);
        localObject1 = (alkm)this.app.getManager(38);
        if (localObject1 != null) {
          ((alkm)localObject1).deleteObserver(this);
        }
        localObject1 = (altq)this.app.getManager(36);
        if (localObject1 != null) {
          ((altq)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Aiwd != null) {
          this.jdField_a_of_type_Aiwd.bpN();
        }
      }
      this.k.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f != null)
        {
          aojn.d(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f);
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f.release();
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f = null;
        }
        ((BaseActivity)localObject1).unregisterReceiver(this.aw);
        ((BaseActivity)localObject1).unregisterReceiver(this.au);
        ((BaseActivity)localObject1).unregisterReceiver(this.av);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, localException.toString());
          }
        }
      }
      return;
    }
  }
  
  private void fJ(long paramLong)
  {
    if (this.aUR) {
      h(1016, paramLong, true);
    }
  }
  
  private void fL(List<RecentBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.sb == null) {
      this.sb = new StringBuilder();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList(paramList);
      this.sb.append("SortedRecentInfo, [");
      TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (RecentBaseData)paramList.get(i);
        if ((localObject instanceof RecentUserBaseData))
        {
          localObject = (RecentUserBaseData)localObject;
          if (((((RecentUserBaseData)localObject).ng() == 1) && (!ajpd.d(this.app, ((RecentUserBaseData)localObject).mUser)) && (localTroopManager.kv(((RecentUserBaseData)localObject).qx()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.sb.append(((RecentUserBaseData)localObject).ng()).append("-").append(aqmr.getSimpleUinForPrint(((RecentUserBaseData)localObject).qx())).append("-").append(i).append(" , ");
          }
        }
        i += 1;
      }
      this.sb.setLength(0);
    }
    this.sb.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.sb.toString());
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365363));
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$b = new b(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$b, false);
    this.aUQ = true;
    this.app.bJd = false;
    this.mRootView = ((ViewGroup)findViewById(2131377546));
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mRootView.findViewById(2131379866));
    this.gw = ((RelativeLayout)this.mRootView.findViewById(2131365429));
    this.gv = ((RelativeLayout)this.mRootView.findViewById(2131378743));
    this.nR = ((TextView)this.mRootView.findViewById(2131369627));
    this.nR.setText(2131720735);
    IphoneTitleBarActivity.setLayerType(this.gw);
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gv, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.sg = this.mRootView.findViewById(2131370586);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mRootView.findViewById(2131376842));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839645));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(true);
        Object localObject3 = a();
        if ((localObject3 != null) && ((localObject3 instanceof SplashActivity)))
        {
          Object localObject2 = (SplashActivity)localObject3;
          Object localObject1 = ((SplashActivity)localObject2).uR;
          ((SplashActivity)localObject2).uR = null;
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131563008, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Yzp = new yzp(a(), 1, (View)localObject2);
            this.sh = ((View)localObject2);
          }
          this.jdField_a_of_type_Aahb = new aahb(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.app;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!aajt.a().bvW)
          {
            bool = true;
            this.jdField_a_of_type_Aajg = new aajg((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Aajg.Cr(true);
            this.jdField_a_of_type_Aajg.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Aajg);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Aajg.a(this);
            this.si = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.si.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.si, null, false);
            if ((TextUtils.isEmpty(aajt.a().bdn)) || (TextUtils.isEmpty(this.app.getCurrentUin())) || (this.app.getCurrentUin().equals(aajt.a().bdn))) {
              break label787;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Aajg.cS((List)localObject1);
            this.jdField_a_of_type_Aajg.FX(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.cIy();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.mUiHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Akze = new akze(this, this.mRootView);
            this.jdField_a_of_type_Aiwd = new aiwd(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.pM = ((ImageView)findViewById(2131365438));
            IphoneTitleBarActivity.setLayerType(this.pM);
            return;
            E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            E(this.gv, false);
            this.gw.setBackgroundResource(2130851105);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, "initUI setOverscrollHeader error" + localThrowable.getMessage());
            continue;
            bool = false;
            continue;
            label787:
            List localList = aajt.a().vp;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void j(AbsListView paramAbsListView)
  {
    int i;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Aajg != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label233;
      }
      i -= 1;
    }
    label226:
    label233:
    for (;;)
    {
      int m = paramAbsListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        Object localObject1;
        if (j < m + 1)
        {
          localObject1 = this.jdField_a_of_type_Aajg.getItem(j);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!aibg.isVisibleAreaSatisfied(paramAbsListView.getChildAt(j - i))) {
            break label226;
          }
          localObject1 = jxl.a().b(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.app));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Aajg));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((jxc)localObject1).Ux);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        aibd.a().V(localMessage);
        j += 1;
      }
    }
  }
  
  private void wM(boolean paramBoolean)
  {
    if (this.aUW != paramBoolean)
    {
      if (!paramBoolean) {
        break label149;
      }
      if (this.f == null)
      {
        QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
        this.aVl = true;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_b_of_type_Pvz == null) {
      this.jdField_b_of_type_Pvz = new pvz(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.f, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b, (BreathEffectView)this.mRootView.findViewById(2131368594));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b != null)) {
      this.jdField_b_of_type_Pvz.aCr = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b.Wt();
    }
    this.jdField_b_of_type_Pvz.aCq = this.isResume;
    this.jdField_b_of_type_Pvz.bni();
    for (this.aVl = false;; this.aVl = false)
    {
      this.aUW = paramBoolean;
      return;
      label149:
      if (this.jdField_b_of_type_Pvz != null) {
        this.jdField_b_of_type_Pvz.shutdown();
      }
    }
  }
  
  private void wN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers" + paramBoolean + this.bu);
    }
    AtomicBoolean localAtomicBoolean = this.bu;
    if (!paramBoolean) {}
    try
    {
      this.bu.set(true);
      this.k.sendEmptyMessageDelayed(17, 200L);
      return;
    }
    finally {}
    if (!this.bu.get()) {
      return;
    }
    this.app.setHandler(getClass(), this.jdField_g_of_type_MqqOsMqqHandler);
    this.app.addObserver(this.jdField_b_of_type_Acnd, true);
    this.app.addObserver(this.jdField_a_of_type_Accd, true);
    this.app.addObserver(this.jdField_a_of_type_Accz, true);
    this.app.addObserver(this.mMsgObserver, true);
    this.app.addObserver(this.jdField_a_of_type_Acnh, true);
    this.app.addObserver(this.jdField_a_of_type_Accn, true);
    this.app.addObserver(this.jdField_b_of_type_Acdv, true);
    this.app.addObserver(this.jdField_a_of_type_Acmf, true);
    this.app.registObserver(this.jdField_b_of_type_Aklk);
    this.app.addObserver(this.jdField_b_of_type_Acdl);
    this.app.addObserver(this.jdField_a_of_type_Acgf);
    this.app.addObserver(this.jdField_b_of_type_Pmd);
    this.app.addObserver(this.jdField_a_of_type_Ackx);
    this.app.registObserver(this.jdField_a_of_type_Vqo);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.app.addObserver(this.jdField_a_of_type_Aktr);
    this.app.addObserver(this.jdField_a_of_type_Afsr);
    this.app.addObserver(this.jdField_a_of_type_Acmc);
    anwa.a(this.jdField_a_of_type_Anwa$a);
    Object localObject2 = (altq)this.app.getManager(36);
    if (localObject2 != null) {
      ((altq)localObject2).addObserver(this);
    }
    if (this.jdField_c_of_type_Aghq == null) {
      bMC();
    }
    this.app.a().addObserver(this.jdField_c_of_type_Aghq);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f = new f(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f.addFilter(new Class[] { aojs.class, aojv.class, C2CPttDownloadProcessor.class, aojz.class, aokv.class, GroupPttDownloadProcessor.class, aokp.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$f);
    try
    {
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.au, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.av, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.aw, (IntentFilter)localObject2);
      if (this.app.isLogin())
      {
        this.app.addObserver(this.jdField_a_of_type_Acfd, true);
        this.app.b().addObserver(this);
        localObject2 = (alkm)this.app.getManager(38);
        if (localObject2 != null) {
          ((alkm)localObject2).addObserver(this);
        }
        this.app.a().cLY();
        this.app.a().addObserver(this.jdField_a_of_type_Inh);
        jll.bG(this.app.getApplication().getApplicationContext());
        this.app.addObserver(this.jdField_a_of_type_Aclr);
        this.app.addObserver(this.jdField_a_of_type_Acku);
        this.app.addObserver(this.jdField_a_of_type_Adah);
        if (this.jdField_a_of_type_Aiwd != null) {
          this.jdField_a_of_type_Aiwd.addObserver();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.cIF();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
    }
  }
  
  private void wO(boolean paramBoolean)
  {
    if ((!obt.aeg) || ((!paramBoolean) && (kaw.a().adq))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Aajg != null))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Aajg.getItem(i) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label151;
        }
        if ((this.jdField_b_of_type_Ahyj != null) && (!this.aUY))
        {
          this.jdField_b_of_type_Ahyj.begin();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.aUY = true;
        }
        kaw.a().adq = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.23(this), 1000L);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public void F(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode()) || ((this.aVp) && (this.aVq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation$b.G(paramInt, paramList);
      this.k.removeMessages(10);
      this.k.removeMessages(9);
      this.k.removeMessages(8);
      if (AppSetting.aNX) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
      }
      return;
    }
    Object localObject;
    int i;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList == null)
      {
        i = 0;
        QLog.i("Q.recent", 4, i + "]，shouldShowConversationMayknow = " + this.aVb);
      }
    }
    else if (this.jdField_a_of_type_Aajg != null)
    {
      if (paramInt != 0) {
        break label439;
      }
      if (this.aVb)
      {
        localObject = (achg)this.app.getManager(159);
        if ((((achg)localObject).bId) && (((achg)localObject).ag(paramList))) {
          ((achg)localObject).bId = false;
        }
      }
      this.jdField_a_of_type_Aajg.cS(paramList);
      if (this.aVi)
      {
        this.aVi = false;
        if (this.aVj)
        {
          if (!this.mIsForeground) {
            break label432;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new uto(this));
        }
      }
    }
    for (;;)
    {
      this.aVj = false;
      if (paramList != null) {
        aajt.a().u(paramList, this.app.getCurrentUin());
      }
      this.jdField_a_of_type_Aajg.FX(0);
      if (AppSetting.aNX) {
        ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      }
      this.app.ba(false, this.bGd);
      a(this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.aUX)
      {
        this.aUX = false;
        if ((((puz)this.app.getManager(252)).aBT) && (this.jdField_b_of_type_Pvz != null)) {
          this.jdField_b_of_type_Pvz.bnk();
        }
      }
      if (this.aUZ)
      {
        this.aUZ = false;
        bMx();
      }
      this.k.sendEmptyMessage(18);
      bMv();
      adak.a(this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      return;
      i = paramList.size();
      break;
      label432:
      ath();
    }
    label439:
    if (paramList == null)
    {
      paramInt = 0;
      label445:
      i = 0;
      label447:
      if (i < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i);
        if (localObject != null) {
          break label486;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label447;
      break;
      paramInt = paramList.size();
      break label445;
      label486:
      this.jdField_a_of_type_Aajg.c((RecentBaseData)localObject);
    }
  }
  
  protected int O(String paramString, int paramInt)
  {
    int i = 4;
    int j = 0;
    switch (paramInt)
    {
    default: 
      paramInt = j;
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
    case 0: 
      do
      {
        i = paramInt;
        return i;
        paramInt = 1;
      } while (aalb.q(this.app, paramString));
      return 4;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    case 1001: 
    case 1003: 
    case 10002: 
    case 10004: 
      return 5;
    case 1005: 
      return 6;
    case 1008: 
    case 1009: 
    case 1012: 
    case 1020: 
    case 1022: 
      return 7;
    case 5000: 
      return 8;
    case 7120: 
    case 7200: 
      return 9;
    case 6000: 
      return 10;
    }
    return 11;
  }
  
  protected boolean Pr()
  {
    return (this.mScrollState != 0) && (this.mScrollState != 1);
  }
  
  public aajg a()
  {
    return this.jdField_a_of_type_Aajg;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    aqmq.track(null, "Recent_Start");
    aqmq.track(null, "Recent_CreateView");
    Object localObject1 = a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).uQ;
      ((SplashActivity)localObject2).uQ = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2131559111, null);
      }
      aqmq.track("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public pvz a()
  {
    return this.jdField_b_of_type_Pvz;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "sendQbossRequest[what:" + paramInt + ",delay:" + paramLong + ",refreshType:" + paramString);
    }
    if (paramBoolean) {
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramString;
    this.jdField_g_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.f != null))
    {
      if (this.aUR) {
        this.f.pn();
      }
    }
    else {
      return;
    }
    this.f.Q(0L);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str;
    acxw localacxw;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      str = "1";
      localacxw = this.app.a().a();
      localObject2 = paramRecentBaseData.qx();
      localObject1 = (acff)this.app.getManager(51);
      if ((paramInt != 7000) || (acbn.bku.equals(localObject2))) {
        break label173;
      }
      anxk.o(this.app, (String)localObject2, paramBoolean);
      anot.a(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    int j;
    int i;
    for (;;)
    {
      j = O(paramRecentBaseData.qx(), paramInt);
      paramRecentBaseData = localacxw.q(false).iterator();
      i = 0;
      label162:
      while (paramRecentBaseData.hasNext())
      {
        if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
          break label1620;
        }
        i += 1;
      }
      str = "0";
      break;
      label173:
      if (paramInt == 5000)
      {
        if (this.jdField_a_of_type_Aala != null) {
          this.jdField_a_of_type_Aala.a(paramRecentBaseData, paramBoolean);
        }
        anot.a(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
      }
      else
      {
        if (paramInt != 5001) {
          break label262;
        }
        ((acfs)this.app.getManager(255)).aM(paramBoolean);
      }
    }
    label262:
    if (paramInt == 1)
    {
      paramString = (TroopManager)this.app.getManager(52);
      localObject1 = paramString.jr(paramRecentBaseData.qx());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (accc)this.app.getBusinessHandler(22);
        if (paramBoolean)
        {
          i = 0;
          label320:
          if (((accc)localObject2).N((String)localObject1, i)) {
            break label339;
          }
        }
      }
    }
    label332:
    label339:
    label606:
    label612:
    do
    {
      do
      {
        return;
        i = 1;
        break label320;
        paramString = paramString.c(paramRecentBaseData.qx());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          i = 0;
          localObject1 = new anov(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject2 = paramRecentBaseData.qx();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramString = "0";; paramString = "1")
        {
          ((anov)localObject1).a(new String[] { localObject2, String.valueOf(i), paramString }).report();
          break;
          i = 0;
          break label391;
          i = 3;
          break label391;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
        }
        i = paramRecentBaseData.ng();
        if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localacxw != null)) {
          break label612;
        }
      } while (!QLog.isColorLevel());
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localacxw != null) {
          break label606;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      localObject1 = localacxw.b((String)localObject2, i);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new RecentUser((String)localObject2, i);
      }
      if (!ajpd.d(this.app, paramString)) {
        break;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = (System.currentTimeMillis() / 1000L);; paramString.showUpTime = 0L)
      {
        localacxw.e(paramString);
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        break;
      }
      if ((paramInt == 0) && (((acff)localObject1).isFriend((String)localObject2)))
      {
        paramString = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          anot.a(paramString, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
          if (aqiw.isNetworkAvailable(this.app.getApp().getApplicationContext())) {
            break;
          }
          QQToast.a(a(), 1, 2131698346, 0).show(a().getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + (String)localObject2 + " userType: " + paramInt);
        }
        FriendsStatusUtil.g(this.app, (String)localObject2, paramBoolean);
        break;
      }
      i = paramRecentBaseData.ng();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localacxw != null)) {
        break label976;
      }
    } while (!QLog.isColorLevel());
    label391:
    paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
    if (localObject2 == null)
    {
      paramBoolean = true;
      paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
      if (localacxw != null) {
        break label970;
      }
    }
    label970:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("Q.recent", 2, paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
    label976:
    paramString = localacxw.b((String)localObject2, i);
    if (paramString == null) {
      paramString = new RecentUser((String)localObject2, i);
    }
    label1319:
    for (;;)
    {
      label1018:
      int m;
      if (paramBoolean)
      {
        paramString.showUpTime = (System.currentTimeMillis() / 1000L);
        localacxw.e(paramString);
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i != 7210) && (i != 7120)) {
          break label1274;
        }
        m = paramRecentBaseData.mUnreadNum;
        localObject1 = "0X80064C4";
        if (paramBoolean) {
          localObject1 = "0X80064C3";
        }
        if (i != 7120) {
          break label1629;
        }
      }
      label1099:
      label1232:
      label1620:
      label1623:
      label1626:
      label1629:
      for (j = 1;; j = 0)
      {
        Iterator localIterator = localacxw.q(false).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (((RecentUser)localIterator.next()).showUpTime == 0L) {
            break label1626;
          }
          i += 1;
        }
        for (;;)
        {
          break label1099;
          paramString.showUpTime = 0L;
          break label1018;
          anot.a(this.app, "dc00899", "Pb_account_lifeservice", "" + j, (String)localObject1, (String)localObject1, 0, 0, "" + m, "" + i, "", "");
          for (;;)
          {
            if ((7220 == paramString.getType()) && (acbn.blx.equals(localObject2)))
            {
              ((KandianMergeManager)this.app.getManager(162)).mT(paramBoolean);
              break;
              label1274:
              if (i == 1008)
              {
                j = paramRecentBaseData.mUnreadNum;
                localObject1 = "0X80064C8";
                if (paramBoolean) {
                  localObject1 = "0X80064C7";
                }
                localIterator = localacxw.q(false).iterator();
                i = 0;
                if (localIterator.hasNext())
                {
                  if (((RecentUser)localIterator.next()).showUpTime == 0L) {
                    break label1623;
                  }
                  i += 1;
                }
              }
            }
          }
          for (;;)
          {
            break label1319;
            anot.a(this.app, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject1, (String)localObject1, 0, 0, "" + j, "" + i, "", "");
            if (!"2290230341".equals(localObject2)) {
              break label1232;
            }
            if (paramBoolean) {}
            for (localObject1 = "0X80090E6";; localObject1 = "0X800915B")
            {
              if (paramBoolean) {
                anor.Vk(4);
              }
              anot.a(this.app, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
              break label1232;
              break;
            }
            anot.a(this.app, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(i), String.valueOf(j), "");
            if (paramInt != 7220) {
              break label332;
            }
            if (paramBoolean)
            {
              kbp.a(this.app, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
              return;
            }
            kbp.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
            return;
            break label162;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Aahb != null)) {
        this.jdField_a_of_type_Aahb.As(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        n(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    aalb.a(this.app, paramRecentUser, -1);
    QQToast.a(a(), acfp.m(2131704504), 0).show();
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.destroy();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = aqeu.J(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    aqeu.z(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    startActivity(localIntent);
    if (QQPlayerService.isPlaying())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public void a(Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    for (int i = 0;; i = paramMessage.what)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder(150);
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.app.bIT).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(aiyy.a().FC()).append(", what = ").append(i);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.app.bIT) {
        break;
      }
      n(i, true, paramBoolean);
      aB(i, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.2(this, i, paramBoolean));
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onMsgTabRecommendBClick uin = " + paramString);
    }
    int j = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (j == 2131376924))
    {
      bMK();
      ContactReportUtils.j(this.app, "msgtab_list_clk", 2);
      return;
    }
    achg localachg = (achg)this.app.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localachg.aaC();
    ArrayList localArrayList = localachg.cw();
    int i = 0;
    if (i < localArrayList.size())
    {
      paramView = (MayKnowRecommend)localArrayList.get(i);
      if (!paramView.uin.equals(paramString)) {}
    }
    for (;;)
    {
      i -= vr();
      if (paramView == null)
      {
        QLog.d("Q.recent", 1, "onMsgTabRecommendBClick recommend is null ");
        return;
        i += 1;
        break;
      }
      if (j == 2131377201)
      {
        if (!aqiw.isNetworkAvailable(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131693404), 0).show(a().getTitleBarHeight());
          return;
        }
        paramString = (acff)this.app.getManager(51);
        if ((!paramString.isFriend(paramView.uin)) && (!paramString.kd(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localachg.aaC());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131721053), null);
          anot.a(this.app, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          startActivity(paramContext);
        }
        for (;;)
        {
          anot.a(this.app, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          ContactReportUtils.a(this.app, paramView.uin, "frd_list_add", 25, 1, paramView.recommendReason, i, paramView.algBuffer, 2);
          return;
          if (paramString.isFriend(paramView.uin)) {
            paramView.friendStatus = 2;
          } else {
            paramView.friendStatus = 1;
          }
        }
      }
      paramString = paramView.getRecommendName(bool);
      if (!TextUtils.isEmpty(paramString)) {
        localAllInOne.aOH = paramString;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        localAllInOne.nickname = paramView.nick;
      }
      localAllInOne.bJa = 88;
      paramString = new Bundle();
      paramString.putString("recommend_reason", paramView.recommendReason);
      paramString.putInt("recommend_pos", i);
      paramString.putByteArray("recommend_algh_id", paramView.algBuffer);
      paramString.putInt("key_display_type", 2);
      ProfileActivity.a(paramContext, localAllInOne, paramString);
      ContactReportUtils.a(this.app, paramView.uin, "frd_list_clk", 25, 0, paramView.recommendReason, i, paramView.algBuffer, 2);
      return;
      i = 0;
      paramView = null;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    this.aVh = true;
    if (this.aUQ)
    {
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
        }
        bMK();
        ContactReportUtils.j(this.app, "msgtab_list_clk", 1);
      }
    }
    else {
      return;
    }
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
    {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.qx());
      return;
    }
    if ((paramRecentBaseData instanceof RecentItemRecommendTroopData))
    {
      ((achg)this.app.getManager(159)).b(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.qx());
      return;
    }
    aqmq.track(null, "AIO_Click_cost");
    aqiy.bk(null, "pubAcc_aio_open", "");
    aqfp.Sz(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
    }
    paramView = null;
    RecentUserBaseData localRecentUserBaseData;
    String str;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramView = localRecentUserBaseData.a();
      if (paramView == null) {
        break label736;
      }
      if ((paramView.getType() != 7120) && (paramView.getType() != 7210) && (paramView.getType() != 1008)) {
        break label679;
      }
      str = "0X80067EC";
      if (localRecentUserBaseData.mUnreadNum != 0) {
        break label811;
      }
      str = "0X80067ED";
    }
    label679:
    label811:
    for (int i = 0;; i = 1)
    {
      Object localObject = this.app.b().d(paramView.uin, paramView.getType());
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        anot.a(this.app, "dc00899", "Pb_account_lifeservice", "", str, str, 0, 0, paramView.uin + "", "" + l1, "" + i, "" + localRecentUserBaseData.mUnreadNum);
        aurk.a(this.app, paramView, paramRecentBaseData);
        adak.a(this.app, paramRecentBaseData);
        i = aalb.a(a(), this.app, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
        if ((paramView != null) && (paramView.lFlag == 16L) && (i == 0) && (this.jdField_b_of_type_Ahyj != null))
        {
          this.jdField_b_of_type_Ahyj.dqV();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "ad preload tool process hit");
          }
        }
        if ((paramView != null) && (String.valueOf(9970L).equals(paramView.uin)) && (this.jdField_c_of_type_Ahyj != null)) {
          this.jdField_c_of_type_Ahyj.dqV();
        }
        if ((paramView != null) && (paramView.getType() == 6004) && (this.d != null)) {
          this.d.dqV();
        }
        a(i, paramView);
        if (paramRecentBaseData != null)
        {
          aakz.b(this.app, paramRecentBaseData, paramView);
          paramRecentBaseData.cuQ();
          ausb.a(this.app).ZA(paramRecentBaseData.qx());
          this.aUS = true;
        }
        if (paramView != null)
        {
          paramRecentBaseData = (FeedsManager)this.app.getManager(275);
          paramRecentBaseData.setFeedInfoRead(paramView.uin);
          if (!FeedsManager.isShowStatus(paramView.uin)) {
            break label745;
          }
          paramString = (wkh)this.app.getManager(282);
          if (paramString != null)
          {
            l1 = paramString.T(paramView.uin);
            FeedsManager.saveToken(paramView.uin, l1);
            paramRecentBaseData.reportClickExpose();
            paramString.report(2, 2);
          }
        }
        for (;;)
        {
          aqmq.track("AIO_Click_cost", null);
          anpc.report("tim_msg_tab_msg_list_click");
          return;
          if (paramView.getType() == 6004) {
            if (paramRecentBaseData.wU() <= 0) {
              break label739;
            }
          }
          label736:
          label739:
          for (i = 1;; i = 2)
          {
            anot.a(this.app, "dc00898", "", "", "0X80090CC", "0X80090CC", i, 0, "", "", "", "");
            break;
          }
          label745:
          paramView = this.app.b().d(paramView.uin, paramView.getType());
          if ((paramView != null) && (paramView.msgtype == -1034))
          {
            paramView = (wkh)this.app.getManager(282);
            if (paramView != null) {
              paramView.report(2, 1);
            }
          }
        }
      }
    }
  }
  
  public void a(aqxh paramaqxh, aqxg paramaqxg)
  {
    if ((this.app.a != null) && (this.app.a.abT()) && (paramaqxg != null) && (paramaqxg.status == 0L) && (paramaqxg.uniseq != 0L)) {
      paramaqxh.me(paramaqxg.uniseq);
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.aUQ)
    {
      paramString = null;
      int i = -1;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = ((RecentUserBaseData)localObject).a();
        i = ((RecentUserBaseData)localObject).mPosition;
      }
      if (paramString != null)
      {
        aakz.a(this.app, paramRecentBaseData, paramString);
        aalb.a(this.app, paramString, i);
        this.jdField_a_of_type_Utq.b(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (alkm)this.app.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((alkm)localObject).fD(paramRecentBaseData.qx(), paramRecentBaseData.ng());
        anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.ng() == 3000)
          {
            anot.a(this.app, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "delRecentCallByUin Error");
          }
        }
        anot.a(this.app, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    bMo();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.ng();
    if (((i == 1) || (i == 5000)) && (this.jdField_a_of_type_Aala == null)) {
      this.jdField_a_of_type_Aala = new aala(this.app, a());
    }
    if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131692274)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!aqft.equalsWithNullCheck(paramString1, localResources.getString(aakb.fy[4]))) {
        break label408;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        aalb.a(this.app, paramString1.a(), true, true);
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      anot.a(this.app, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label408:
    while (!aqft.equalsWithNullCheck(paramString1, localResources.getString(aakb.fy[5])))
    {
      return;
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131692278)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131694512)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        if (i != 3000) {
          break;
        }
        new anov(this.app).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").report();
        break;
      }
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131694514)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        if (i != 3000) {
          break;
        }
        new anov(this.app).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").report();
        break;
      }
      if (!aqft.equalsWithNullCheck(paramString1, localResources.getString(2131696102))) {
        break;
      }
      this.jdField_a_of_type_Aakp.a(a(), paramRecentBaseData, this.app);
      anot.a(this.app, "dc00898", "", paramRecentBaseData.qx(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.app.a().D(paramString1.uin, paramString1.getType(), 1);
      this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    anot.a(this.app, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.aUR) }));
    }
    return a(paramListView);
  }
  
  public boolean a(aqxh paramaqxh, aqxg paramaqxg)
  {
    if ((paramaqxg == null) || (paramaqxh == null)) {}
    do
    {
      return false;
      if (paramaqxg.status == 3L) {
        paramaqxh.E(4L, paramaqxg.uniseq);
      }
    } while ((paramaqxg == null) || (paramaqxg.status != 2L) || (!this.app.a.abT()) || (!this.isResume));
    return true;
  }
  
  public boolean a(ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.aUR)) {}
    do
    {
      return true;
      if (this.f != null) {
        this.f.S(0L);
      }
      int i = 0;
      if (!this.app.a().aaO()) {
        i = 1;
      }
      if (i != 0)
      {
        this.aUR = true;
        wK(true);
        this.k.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.FM = SystemClock.uptimeMillis();
      aqmq.br("Conversation_PullToRefresh_start", 0L);
      bMn();
      ThreadManager.getSubThreadHandler().post(new Conversation.11(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((puz)this.app.getManager(252)).aBT)
      {
        ((puy)this.app.getManager(251)).a().vY(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.handlePullRefresh();
      }
      this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
      a(1064, 200L, true, "qboss_banner_pull_refresh");
      h(1072, 500L, true);
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
    return true;
  }
  
  public View aJ()
  {
    return this.gv;
  }
  
  public View aK()
  {
    return this.sg;
  }
  
  public View aL()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.AY;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.aUR) && (this.f != null)) {
      this.f.R(0L);
    }
  }
  
  void bMB()
  {
    if ((this.aVb) && (((achg)this.app.getManager(159)).kl("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Aajg.isEmpty()))
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int n;
      for (int i = -1; m <= i1; i = n)
      {
        n = i;
        if (m >= 0)
        {
          n = i;
          if (m < this.jdField_a_of_type_Aajg.getCount())
          {
            n = i;
            if (this.jdField_a_of_type_Aajg.getItem(m) != null)
            {
              Object localObject = this.jdField_a_of_type_Aajg.getItem(m);
              n = i;
              if ((localObject instanceof RecentItemMayKnowFriendVerticalListData))
              {
                int j = i;
                if (i < 0) {
                  j = vr();
                }
                localObject = ((RecentItemMayKnowFriendVerticalListData)localObject).a();
                n = j;
                if ((((RecentUser)localObject).extraInfo instanceof MayKnowRecommend))
                {
                  localObject = (MayKnowRecommend)((RecentUser)localObject).extraInfo;
                  localArrayList1.add(((MayKnowRecommend)localObject).uin);
                  localArrayList2.add(((MayKnowRecommend)localObject).recommendReason);
                  localArrayList3.add(Integer.valueOf(m - j));
                  localArrayList4.add(((MayKnowRecommend)localObject).algBuffer);
                  n = j;
                }
              }
            }
          }
        }
        m += 1;
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.app, 25, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 2, null);
      }
    }
  }
  
  public void bMG()
  {
    ThemeBackground.applyThemeBg(this.app, this.sg, 1, 2130838901, "-conversation-");
  }
  
  public void bMJ()
  {
    Object localObject = a();
    if (this.aUQ)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Aamm == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Aamm.a((aajg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.bGf + " currentUnreadCaredItemIndex: " + this.bGg);
      }
      int i = (int)(a().getResources().getDimension(2131299267) + a().getResources().getDimension(2131299284) / 2.0F);
      int j = this.bGg + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.bGg == 0) {
        i = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(j) });
        }
        this.jdField_a_of_type_Aamm.updateText();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(j, i);
        localObject = new Conversation.54(this, j);
        this.jdField_g_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    anot.a(this.app, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void bMK()
  {
    if (this.V == null)
    {
      this.V = ausj.b(a());
      this.V.addButton(2131692270);
      this.V.addCancelButton(2131721058);
      this.V.a(new utj(this));
    }
    this.V.show();
  }
  
  public void bMe()
  {
    bpN();
    bMy();
    if (this.jdField_a_of_type_Aahb != null) {
      this.jdField_a_of_type_Aahb.bC(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.sj != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.sj);
      this.sj = null;
    }
    if (this.jdField_a_of_type_Akze != null) {
      this.jdField_a_of_type_Akze.bMe();
    }
    if (this.pb != null)
    {
      Iterator localIterator = this.pb.iterator();
      while (localIterator.hasNext())
      {
        adue localadue = (adue)localIterator.next();
        if (localadue != null) {
          localadue.bMe();
        }
      }
    }
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1134068);
    anor.clear();
    if (this.jdField_a_of_type_Aakj != null) {
      this.jdField_a_of_type_Aakj.bwe = true;
    }
    if (this.jdField_a_of_type_Aakp != null) {
      this.jdField_a_of_type_Aakp.onAccountChanged(this.app);
    }
    if (this.jdField_a_of_type_Aaiw != null) {
      this.jdField_a_of_type_Aaiw.l(a());
    }
    if (this.jdField_a_of_type_Aiwd != null) {
      this.jdField_a_of_type_Aiwd.bMe();
    }
    if (this.jdField_a_of_type_Utt != null) {
      this.jdField_a_of_type_Utt.bMe();
    }
    if (this.jdField_a_of_type_Aamm != null) {
      this.jdField_a_of_type_Aamm.m(a());
    }
  }
  
  public void bMf()
  {
    super.bMf();
    bMg();
  }
  
  public void bMg()
  {
    if (SystemClock.uptimeMillis() - pvz.sScrollTimestamp > 500L)
    {
      bMi();
      if ((this.isResume) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_b_of_type_Pvz != null) {
          this.jdField_b_of_type_Pvz.bnp();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.aUQ);
    }
  }
  
  protected void bMj()
  {
    if (this.jdField_a_of_type_Aajg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.k.obtainMessage(7);
    this.k.sendMessage(localMessage);
  }
  
  public void bMk()
  {
    h(1068, 0L, true);
  }
  
  public void bMl()
  {
    h(1069, 0L, true);
  }
  
  public void bMn()
  {
    if (this.app.getCurrentAccountUin() != null)
    {
      if (this.k != null) {
        this.k.sendEmptyMessage(1058);
      }
      this.aUR = true;
      aXh();
      wK(true);
      boolean bool1 = this.jdField_a_of_type_Aahb.hx(1);
      boolean bool2 = this.jdField_a_of_type_Aahb.hx(9);
      if ((bool1) || (bool2)) {
        fJ(800L);
      }
    }
    else
    {
      return;
    }
    if (awit.B(this.app)) {
      lcm.a().aJS();
    }
    this.app.a.cNr();
    fJ(60000L);
    anot.a(this.app, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void bMp()
  {
    this.mIsForeground = true;
    if ((!this.isInited) && (!this.isDestroy))
    {
      bMc();
      aqmq.track("Recent_Start", null);
    }
    while (!this.isInited) {
      return;
    }
    h(1030, 0L, true);
  }
  
  public void bMr()
  {
    if (this.jdField_a_of_type_Utt != null) {
      this.jdField_a_of_type_Utt.wX(false);
    }
  }
  
  public void bMs()
  {
    long l1 = 0L;
    try
    {
      if (!this.aUU)
      {
        boolean bool = this.isDestroy;
        if (!bool) {
          break label23;
        }
      }
    }
    finally
    {
      try
      {
        label23:
        BaseActivity localBaseActivity;
        LayoutInflater localLayoutInflater;
        if (this.f == null) {
          this.f = ((PullRefreshHeader)localLayoutInflater.inflate(2131559847, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Aakj == null)
        {
          this.jdField_a_of_type_Aakj = new aakj(localBaseActivity);
          this.jdField_a_of_type_Aakj.W("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.app, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new use(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.mUiHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Aqxh = ((aqxh)this.app.getManager(76));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label350;
        }
      }
      localObject1 = finally;
    }
    return;
    this.aUU = true;
    localBaseActivity = a();
    localLayoutInflater = LayoutInflater.from(localBaseActivity);
    Object localObject2 = "in main thread ";
    label208:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", aqgz.getDeviceModel());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
        String str2 = this.app.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localanpc.collectPerformance(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label350:
      String str1 = "not in main thread ";
      this.f = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
      this.jdField_a_of_type_Aakj = null;
      this.aUU = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  public void bMt()
  {
    for (;;)
    {
      try
      {
        if (!this.aUT)
        {
          boolean bool = this.isDestroy;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.aUT = true;
        if (!this.aUU) {
          bMs();
        }
        bMG();
        if ((!this.aUV) && (!this.app.a.He())) {
          AA(2);
        }
        if (this.jdField_a_of_type_Utt != null) {
          this.jdField_a_of_type_Utt.bMt();
        }
        this.pM.setOnClickListener(this);
        this.gv.setOnTouchListener(new usf(this));
        this.jdField_a_of_type_Aamm = new aamm(this, this.mRootView);
        long l1 = System.currentTimeMillis();
        if (aekv.agV())
        {
          if (this.f == null) {
            this.f = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559847, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
          }
          long l2 = System.currentTimeMillis();
          QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.f);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVerticalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Aahb != null) && (this.aUQ)) {
          this.jdField_a_of_type_Aahb.cur();
        }
        if (this.jdField_a_of_type_Aahb != null) {
          this.jdField_a_of_type_Aahb.Cj(false);
        }
        h(1010, 5000L, false);
        a(1064, 5000L, true, "qboss_banner_login");
        h(1023, 0L, false);
        if (!this.app.a.He())
        {
          h(1055, 0L, false);
          a(this.jdField_g_of_type_MqqOsMqqHandler, a());
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.app.a.He()) });
          }
          if (!this.app.a.He())
          {
            h(1061, 0L, false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
            }
          }
          bMo();
          this.k.sendEmptyMessage(12);
          bME();
          if (this.aMA == null)
          {
            this.aMA = adaq.a().sc();
            if (this.aMA == null)
            {
              this.gx = ((RelativeLayout)this.mRootView.findViewById(2131368069));
              GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
              localGLSurfaceView.setRenderer(new usg(this));
              this.gx.addView(localGLSurfaceView);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_GPU", 2, "GL_RENDERER= " + this.aMA);
          }
          if (this.app.a.He()) {
            continue;
          }
          h(1059, 0L, false);
          continue;
        }
        if (!this.aVl) {
          break label625;
        }
      }
      finally {}
      h(1055, 0L, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
      }
      this.aVl = false;
      continue;
      label625:
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.app.a.He()) });
      }
    }
  }
  
  void bMw()
  {
    if ((this.app == null) || (!this.isInited)) {}
    label124:
    for (;;)
    {
      return;
      if (((kdm)this.app.getManager(88)).yZ())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Aajg != null))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Aajg.getItem(i) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (!kaw.a().a(this.app)) || (this.jdField_c_of_type_Ahyj == null)) {
            break label124;
          }
          this.jdField_c_of_type_Ahyj.begin();
          return;
          i += 1;
          break;
        }
      }
    }
  }
  
  void bMy()
  {
    if ((this.sk != null) && (this.sk.getVisibility() != 8)) {
      this.sk.setVisibility(8);
    }
  }
  
  public void bMz()
  {
    int i = 0;
    if (this.app == null) {}
    for (;;)
    {
      return;
      try
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          int j = alkm.X(this.app);
          QQMessageFacade localQQMessageFacade = this.app.b();
          if (localQQMessageFacade != null) {
            i = localQQMessageFacade.bl();
          }
          this.bGd = (i + j);
          if (QLog.isColorLevel())
          {
            QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s]", new Object[] { Integer.valueOf(this.bGd), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.app.bJb) }));
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "refreshRecentList invalidate params arg1: " + paramInt1 + ", arg2: " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt2 <= 10) && (paramInt2 >= 8)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2);
        return;
        if ((paramInt2 != 10) || ((paramObject instanceof Long))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj: " + paramObject);
      return;
      if (((paramInt2 != 8) && (paramInt2 != 9)) || ((paramObject instanceof String))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj:" + paramObject);
    return;
    if (!Pr())
    {
      this.aUS = false;
      Message localMessage = this.k.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.k.sendMessage(localMessage);
      return;
    }
    this.aUS = true;
  }
  
  public void fI(long paramLong)
  {
    e(0, 10, Long.valueOf(paramLong));
  }
  
  public void fK(long paramLong)
  {
    apuk localapuk = (apuk)this.app.getManager(164);
    if (localapuk != null) {
      localapuk.lT(paramLong);
    }
  }
  
  protected void fM(List<RecentBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.sb == null) {
      this.sb = new StringBuilder();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      this.sb.append("unreadinfo, [");
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if ((localRecentBaseData != null) && (localRecentBaseData.mUnreadNum > 0)) {
          this.sb.append(localRecentBaseData.ng()).append("-").append(localRecentBaseData.qx()).append("-").append(localRecentBaseData.mUnreadNum).append("-").append(localRecentBaseData.mUnreadFlag).append(" , ");
        }
      }
      this.sb.setLength(0);
    }
    this.sb.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.sb.toString());
  }
  
  public void h(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.isDestroy) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    auvk.traceBegin("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    boolean bool1;
    int i;
    int j;
    label651:
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
    case 10: 
    case 9: 
    case 8: 
      for (;;)
      {
        auvk.traceEnd();
        return true;
        if (!n(paramMessage)) {
          return true;
        }
        ((acfs)this.app.getManager(255)).cJg();
        aizp.a().dj(this.app);
        bMm();
        paramMessage = this.app.a().a();
        if (abbf.N(this.app)) {
          abbf.bN(this.app);
        }
        boolean bool2 = false;
        bool1 = bool2;
        if (this.app.a != null)
        {
          bool1 = bool2;
          if (this.app.a.He()) {
            bool1 = true;
          }
        }
        Object localObject1 = paramMessage.q(bool1);
        this.jdField_a_of_type_Aaiw.hG((List)localObject1);
        paramMessage = aajt.a().fl;
        Object localObject3 = this.app;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          aaiv.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Aaiw);
          fL(paramMessage);
          bMz();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          fM(paramMessage);
          if (this.jdField_a_of_type_Aahb != null) {}
          this.qF.clear();
          this.bGc = 0;
          this.k.removeMessages(10);
          this.k.removeMessages(9);
          this.k.removeMessages(8);
          this.FN = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          localObject1 = (pmj)this.app.getManager(197);
          ((pmj)localObject1).A(3, ((pmj)localObject1).aj(paramMessage));
          aqmq.br("Conversation_Refresh_global", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          continue;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!n(paramMessage)) {
          return true;
        }
        if (abbf.N(this.app)) {
          abbf.bN(this.app);
        }
        bMm();
        localObject3 = aajt.a().fl;
        localObject4 = this.app.a().a().q(false);
        this.jdField_a_of_type_Aaiw.hG((List)localObject4);
        ((List)localObject3).clear();
        RecentUser localRecentUser;
        String str;
        if (localObject4 == null)
        {
          i = 0;
          j = 0;
          if (j >= i) {
            break label843;
          }
          localRecentUser = (RecentUser)((List)localObject4).get(j);
          str = aajt.makeKey(localRecentUser.uin, localRecentUser.getType());
          localObject2 = aajt.a().a(str);
          if (localObject2 != null) {
            break label766;
          }
          localObject2 = aaiv.a(localRecentUser, this.app, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            aajt.a().c((RecentBaseData)localObject2, str);
            paramMessage = (Message)localObject2;
          }
        }
        for (;;)
        {
          if (paramMessage != null) {
            ((List)localObject3).add(paramMessage);
          }
          j += 1;
          break label651;
          i = ((List)localObject4).size();
          break;
          if (!this.qF.contains(str))
          {
            paramMessage = (Message)localObject2;
            if (!this.qF.contains(aajt.makeKey(localRecentUser.uin, -2147483648))) {}
          }
          else
          {
            if ((localObject2 instanceof RecentUserBaseData)) {
              ((RecentUserBaseData)localObject2).d(localRecentUser);
            }
            ((RecentBaseData)localObject2).c(this.app, a());
            paramMessage = (Message)localObject2;
          }
        }
        try
        {
          Collections.sort((List)localObject3, this.jdField_a_of_type_Aaiw);
          fL((List)localObject3);
          bMz();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          fM((List)localObject3);
          if (this.jdField_a_of_type_Aahb != null) {
            this.jdField_a_of_type_Aahb.cuq();
          }
          if (this.bGc <= 9) {
            this.bGc = 0;
          }
          this.qF.clear();
          this.k.removeMessages(9);
          this.k.removeMessages(8);
          this.FN = System.currentTimeMillis();
          paramMessage = new HashMap();
          paramMessage.put(BaseConstants.RDM_NoChangeFailCode, "");
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          aqmq.br("Conversation_Refresh_part", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        if (!n(paramMessage)) {
          return true;
        }
        paramMessage = aajt.a().fl;
        j = paramMessage.size();
        localObject2 = new ArrayList(j);
        i = 0;
        if (i < j) {
          for (;;)
          {
            try
            {
              localObject3 = (RecentBaseData)paramMessage.get(i);
              if (localObject3 == null) {
                i += 1;
              }
            }
            catch (Exception paramMessage)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("Q.recent", 4, paramMessage.toString());
              }
              return true;
            }
            localObject4 = aajt.makeKey(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
            if ((this.qF.contains(localObject4)) || (this.qF.contains(aajt.makeKey(((RecentBaseData)localObject3).qx(), -2147483648))))
            {
              ((RecentBaseData)localObject3).c(this.app, a());
              ((List)localObject2).add(localObject3);
            }
          }
        }
        bMz();
        this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject2).sendToTarget();
        fM(paramMessage);
        if (this.bGc <= 8)
        {
          this.bGc = 0;
          this.qF.clear();
        }
        this.k.removeMessages(8);
        this.FN = System.currentTimeMillis();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        aqmq.br("Conversation_Refresh_items", System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
      }
    case 11: 
      label766:
      bool1 = n(paramMessage);
      label843:
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.isInited + "," + bool1 + "]");
      }
      if (!bool1) {
        return true;
      }
      j = paramMessage.arg2;
      if ((j == 8) || (j == 9))
      {
        localObject2 = null;
        if ((paramMessage.obj instanceof String)) {
          localObject2 = (String)paramMessage.obj;
        }
        if ((localObject2 != null) && (!this.qF.contains(localObject2))) {
          this.qF.add(localObject2);
        }
        l1 = 0L;
      }
      break;
    }
    for (;;)
    {
      if (j >= this.bGc)
      {
        i = 8;
        for (;;)
        {
          if (i < j)
          {
            this.k.removeMessages(i);
            i += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label2074;
            }
            l1 = ((Long)paramMessage.obj).longValue();
            break;
          }
        }
        this.bGc = j;
      }
      if ((!this.isInited) || (this.k.hasMessages(this.bGc))) {
        break;
      }
      long l2 = Math.abs(System.currentTimeMillis() - this.FN);
      l1 = Math.max(this.uC - l2, l1);
      localObject2 = Message.obtain();
      ((Message)localObject2).arg1 = paramMessage.arg1;
      ((Message)localObject2).what = this.bGc;
      this.k.sendMessageDelayed((Message)localObject2, l1);
      break;
      aizp.a().dp(this.app);
      paramMessage = nyn.a();
      if (paramMessage != null) {
        paramMessage.ac(this.app);
      }
      paramMessage = oan.a();
      if (paramMessage != null) {
        paramMessage.ax(this.app);
      }
      aptr.eo(this.app);
      paramMessage = (apuf)this.app.getManager(81);
      if (paramMessage != null) {
        paramMessage.er(this.app);
      }
      for (;;)
      {
        paramMessage = (kdm)this.app.getManager(88);
        if (paramMessage != null) {
          paramMessage.aBP();
        }
        paramMessage = (aicu)this.app.getManager(236);
        if (paramMessage != null) {
          paramMessage.KW(true);
        }
        paramMessage = (acfs)this.app.getManager(255);
        if (paramMessage != null) {
          paramMessage.initManager();
        }
        acqe.a(this.app).cNR();
        paramMessage = (afwh)this.app.getManager(292);
        if (paramMessage != null) {
          paramMessage.initManager();
        }
        paramMessage = (pmj)this.app.getManager(197);
        paramMessage.z(1, paramMessage.aj(this.qE));
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      wN(true);
      break;
      runOnUiThread(new Conversation.24(this));
      break;
      this.jdField_g_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      paramMessage = (pmj)this.app.getManager(197);
      paramMessage.z(2, paramMessage.aj(aajt.a().fl));
      break;
      if (this.jdField_a_of_type_Aamm == null) {
        break;
      }
      this.jdField_a_of_type_Aamm.refresh();
      break;
      label2074:
      l1 = 0L;
    }
  }
  
  public boolean isForeground()
  {
    return this.mIsForeground;
  }
  
  public void n(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    e(0, paramInt1, aajt.makeKey(paramString, paramInt2));
  }
  
  void n(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (!paramBoolean1)
    {
      aXh();
      fJ(800L);
    }
    Object localObject1 = this.app.getHandler(AVNotifyCenter.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((MqqHandler)localObject1).obtainMessage(10010);
      ((Message)localObject2).obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject1).sendMessage((Message)localObject2);
    }
    if (this.app.bIT) {
      this.jdField_a_of_type_Aahb.gm(8, 0);
    }
    boolean bool1;
    int i;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      aiyy.a().LH(bool1);
      localObject1 = this.jdField_a_of_type_Aahb;
      if (!bool1) {
        break label244;
      }
      i = 2;
      ((aahb)localObject1).gm(1, i);
      bool2 = aiyy.a().apY();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      aiyy.a().LI(bool2);
      localObject1 = this.jdField_a_of_type_Aahb;
      i = j;
      if (bool2) {
        i = 2;
      }
      ((aahb)localObject1).gm(9, i);
      this.jdField_a_of_type_Aahb.d(-1, null);
      if (this.pb != null)
      {
        localObject1 = this.pb.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (adue)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((adue)localObject2).onNetStateChanged(paramBoolean1);
              continue;
              bool1 = false;
              break;
              label244:
              i = 0;
              break label111;
            }
          }
        }
      }
      wK(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(150);
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.app.bIT).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(aiyy.a().FC()).append(", msg = ").append(paramInt);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  protected boolean n(Message paramMessage)
  {
    if (((!this.mIsForeground) && (paramMessage.arg1 == 0)) || (!this.app.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "isRefreshRecentDataNecessary[isForeground:" + this.mIsForeground + ",msg.arg1:" + paramMessage.arg1 + ",isLogin:" + this.app.isLogin());
      }
      return false;
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    case 21: 
    default: 
    case 14002: 
    case 2: 
    case 1000: 
    case 1300: 
    case 9001: 
    case 9002: 
    case 9010: 
    case 14005: 
    case 14006: 
      Object localObject;
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
                    do
                    {
                      do
                      {
                        return;
                      } while ((paramIntent == null) || (paramInt2 != -1));
                      localObject = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
                    } while (localObject == null);
                    String str = paramIntent.getStringExtra("uin");
                    paramInt1 = paramIntent.getIntExtra("uintype", -1);
                    paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
                    aqmf.a(this.app, str, paramInt1, (AbsStructMsg)localObject, null);
                    VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.gi(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
                    return;
                  } while (a() == null);
                  a().setCanLock(false);
                  return;
                } while (paramInt2 != 0);
                finish();
                this.app.exit(false);
                return;
              } while ((-1 != paramInt2) || (paramIntent == null));
              paramIntent = paramIntent.getStringExtra("roomId");
            } while (paramIntent == null);
            apuh.f(a(), paramIntent, true);
            anot.a(this.app, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
            return;
          } while (paramInt2 != -1);
          QQToast.a(a(), 2, getString(2131721472), 0).show(a().getTitleBarHeight());
          return;
        } while (!QLog.isColorLevel());
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + -1);
        return;
        aakj.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
        return;
        localObject = abmt.a();
      } while (localObject == null);
      ((ApolloSurfaceView)localObject).runRenderTask(new Conversation.5(this, (ApolloSurfaceView)localObject, paramInt1, paramInt2, paramIntent));
      return;
    }
    ThreadManager.excute(new Conversation.6(this), 16, null, true);
  }
  
  public boolean onBackPressed()
  {
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.cuA();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.sj != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.sj);
      this.sj = null;
      PortalManager localPortalManager = (PortalManager)this.app.getManager(79);
      if (localPortalManager != null) {
        localPortalManager.i(a(), false);
      }
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.isMiniAppLauncherOpened()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.pM)
    {
      this.jdField_a_of_type_Aakj.t(this.gw, this.gw.getWidth() - getResources().getDimensionPixelSize(2131299274) - getResources().getDimensionPixelSize(2131299275), getResources().getDimensionPixelSize(2131299276));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).bRG();
      }
      if ((abmt.zG() <= 0) || (abmt.zF() <= 0)) {
        break label339;
      }
    }
    label339:
    for (int i = 1;; i = 0)
    {
      if (this.aUP) {
        this.aUP = false;
      }
      for (int j = 1;; j = 0)
      {
        VipUtils.a(abmt.getAppInterface(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i, "" + j });
        anot.a(this.app, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        rar.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        bMH();
        swu.bBD();
        this.aVh = true;
        anpc.report("tim_msg_tab_r_plus_click");
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((paramView == this.pN) || (paramView == this.l))
          {
            long l1 = System.currentTimeMillis();
            if (Math.abs(l1 - lastClickTime) < 500L) {
              lastClickTime = l1;
            } else {
              lastClickTime = l1;
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    pmj localpmj = (pmj)this.app.getManager(197);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    do
    {
      return;
      if (paramView.getId() == 2131363764)
      {
        anot.a(this.app, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        startActivity(paramView);
        return;
      }
      if ((paramView.getId() == 2131367595) || (paramView.getId() == 2131367597) || (paramView.getId() == 2131367598) || (paramView.getId() == 2131367599) || (paramView.getId() == 2131367600) || (paramView.getId() == 2131367601) || (paramView.getId() == 2131367602))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = aqgv.D(this.app, paramView);
        ChatActivityUtils.a(this.app, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131369914) || (!localpmj.s(paramObject)));
    localpmj.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_Aakj != null) && (this.jdField_a_of_type_Aakj.isShowing())) {
      this.jdField_a_of_type_Aakj.dismiss();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate()
  {
    aqmq.track(null, "Recent_OnCreate");
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Utq = new utq(this);
    this.jdField_g_of_type_MqqOsMqqHandler = new aqgw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.k = new aqgw(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Aakp = new aakp(this.jdField_g_of_type_MqqOsMqqHandler, a());
    initUI();
    aAz();
    wI(false);
    this.jdField_a_of_type_Aaiw = new aaiw(this.app);
    aqmq.track("Recent_OnCreate", null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.isDestroy = true;
    if (this.jdField_a_of_type_Aakp != null) {
      this.jdField_a_of_type_Aakp.onDestroy();
    }
    if (this.V != null)
    {
      this.V.a(null);
      this.V = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a(null);
    }
    this.aVb = false;
    aale.a().cvi();
    bpN();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Utq != null) {
      this.jdField_a_of_type_Utq.onDestory();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.dM);
    if (this.jdField_a_of_type_Yzp != null) {
      this.jdField_a_of_type_Yzp.onDestroy();
    }
    if (this.jdField_a_of_type_Aajg != null) {
      this.jdField_a_of_type_Aajg.onDestory();
    }
    if (this.jdField_b_of_type_Pvz != null) {
      this.jdField_b_of_type_Pvz.shutdown();
    }
    if (this.jdField_a_of_type_Aahb != null) {
      this.jdField_a_of_type_Aahb.bB(this.app);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    this.k.removeCallbacksAndMessages(null);
    try
    {
      localObject = this.app.a().a();
      if (localObject != null) {
        ((acxw)localObject).onDestroy();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label227:
      break label227;
    }
    this.jdField_g_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.p != null) {
      this.p.removeCallbacksAndMessages(null);
    }
    aizp.destroy();
    aizr.destroy();
    oan.destroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.onDestroy();
    }
    if (this.pb != null)
    {
      localObject = this.pb.iterator();
      while (((Iterator)localObject).hasNext())
      {
        adue localadue = (adue)((Iterator)localObject).next();
        if (localadue != null) {
          localadue.onDestroy();
        }
      }
      this.pb.clear();
    }
    if (this.sj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.sj);
      this.sj = null;
    }
    if (this.jdField_a_of_type_Aiwd != null)
    {
      this.jdField_a_of_type_Aiwd.onDestroy();
      this.jdField_a_of_type_Aiwd = null;
    }
    if (this.jdField_a_of_type_Awkk != null)
    {
      this.jdField_a_of_type_Awkk.onDestroy();
      this.jdField_a_of_type_Awkk = null;
    }
    if (this.dN != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.dN);
    }
    super.onDestroy();
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.aUR))
    {
      this.aUR = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
    }
    if (this.jdField_a_of_type_Aajg != null) {
      this.jdField_a_of_type_Aajg.bH(this.app);
    }
    this.jdField_a_of_type_Aahb.gm(21, 0);
    aajt.a().clearCache();
    if (this.jdField_a_of_type_Utq != null) {
      this.jdField_a_of_type_Utq.onLogout(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Akze != null) {
      this.jdField_a_of_type_Akze.onLogout(paramLogoutReason);
    }
    if (this.pb != null)
    {
      Iterator localIterator = this.pb.iterator();
      while (localIterator.hasNext())
      {
        adue localadue = (adue)localIterator.next();
        if (localadue != null) {
          localadue.onLogout(paramLogoutReason);
        }
      }
    }
    if ((this.I != null) && (this.I.isShowing()) && (!this.isDestroy)) {}
    try
    {
      this.I.dismiss();
      this.I = null;
      label177:
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1073);
      return;
    }
    catch (Exception paramLogoutReason)
    {
      break label177;
    }
  }
  
  public void onPause()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.onPause();
    this.jdField_a_of_type_Akze.onPause();
    if (FL > 0L)
    {
      FL = 0L;
      SosoInterface.io(FL);
    }
    Object localObject1;
    Object localObject2;
    if (this.pb != null)
    {
      localObject1 = this.pb.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (adue)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((adue)localObject2).onPause();
        }
      }
    }
    this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.aVs = false;
    if (this.app == null) {
      return;
    }
    if (AppSetting.aNX) {
      this.app.Fz(false);
    }
    aale.a().cvj();
    this.mIsForeground = false;
    if ((!this.aVh) && (!this.aVi) && (aako.L(this.app))) {
      if (System.currentTimeMillis() - this.FR > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Aajg.dv();
        localObject2 = this.app;
        ThreadManager.getSubThreadHandler().post(new Conversation.3(this, (QQAppInterface)localObject2, (List)localObject1));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.AP();
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.pause();
      }
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(10000);
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1070);
      this.k.removeMessages(10);
      this.k.removeMessages(9);
      this.k.removeMessages(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
      }
      if (this.jdField_a_of_type_Aakj != null) {
        this.jdField_a_of_type_Aakj.onPause();
      }
      this.app.bJc = false;
      kxm.N(this.app);
      if (this.jdField_c_of_type_Ahyj != null) {
        this.jdField_c_of_type_Ahyj.end();
      }
      if (this.d != null) {
        this.d.end();
      }
      this.jdField_g_of_type_MqqOsMqqHandler.removeMessages(1134062);
      anor.cIV = false;
      if (this.jdField_b_of_type_Pvz != null) {
        this.jdField_b_of_type_Pvz.onPause();
      }
      lcm.aKd();
      adak.cPx();
      if (this.jdField_a_of_type_Utt == null) {
        break;
      }
      this.jdField_a_of_type_Utt.onPause();
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "just switch account, don't save RU");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "enter AIO or switching account, don't save RU");
        }
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if ((!ThemeUtil.isDefaultTheme()) && (this.aVe) && (this.sh != null))
    {
      this.sh.setBackgroundResource(2130851332);
      this.sh.findViewById(2131366542).setBackgroundResource(2130851343);
      this.aVe = false;
    }
    bMG();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.onPostThemeChanged();
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gv, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Akze.onPostThemeChanged();
      if (this.pb == null) {
        break;
      }
      Iterator localIterator = this.pb.iterator();
      while (localIterator.hasNext())
      {
        adue localadue = (adue)localIterator.next();
        if (localadue != null) {
          localadue.onPostThemeChanged();
        }
      }
      E(this.gv, false);
      this.gw.setBackgroundResource(2130851105);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    }
    if (this.jdField_a_of_type_Aamm != null) {
      this.jdField_a_of_type_Aamm.onPostThemeChanged();
    }
    if (this.jdField_b_of_type_Pvz != null) {
      this.jdField_b_of_type_Pvz.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Aahb != null) {
      this.jdField_a_of_type_Aahb.d(-1, null);
    }
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "conversation onPostThemeChanged refresh because simple theme switch!");
      }
      this.k.sendEmptyMessage(10);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.cIy();
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.app == null) {
      return;
    }
    this.aVh = false;
    this.app.bJc = true;
    achg.bIg = true;
    if ((FL == -1L) && (SplashActivity.bax))
    {
      FL = SystemClock.elapsedRealtime();
      SosoInterface.io(FL);
    }
    super.onResume(paramBoolean);
    if (this.J != null) {
      this.J.dismiss();
    }
    if (this.aUO)
    {
      if (FrameHelperActivity.ZW())
      {
        FrameHelperActivity.EO(true);
        FrameHelperActivity.cuA();
      }
      this.aUO = false;
    }
    aale.a().cvk();
    if (this.jdField_a_of_type_Yzp != null) {
      this.jdField_a_of_type_Yzp.onResume();
    }
    if (AppSetting.aNX) {
      this.app.Fz(true);
    }
    this.mIsForeground = true;
    try
    {
      a().getWindow().setSoftInputMode(32);
      Object localObject1 = this.jdField_a_of_type_Aqxh;
      if (localObject1 != null)
      {
        localObject2 = ((aqxh)localObject1).a();
        if (localObject2 != null)
        {
          a((aqxh)localObject1, (aqxg)localObject2);
          if (a((aqxh)localObject1, (aqxg)localObject2) == true)
          {
            localObject1 = a();
            if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {
              ((SplashActivity)localObject1).bRy();
            }
          }
        }
      }
      if (this.jdField_a_of_type_Aahb != null)
      {
        boolean bool = aiyy.a().apY();
        localObject1 = this.jdField_a_of_type_Aahb;
        if (bool)
        {
          i = 2;
          ((aahb)localObject1).gm(9, i);
          aiyy.a().LI(bool);
          this.jdField_a_of_type_Aahb.cui();
          if (this.app.a().PC() == 0) {
            break label638;
          }
          i = 1;
          localObject1 = this.jdField_a_of_type_Aahb;
          if (i == 0) {
            break label643;
          }
          i = 2;
          ((aahb)localObject1).gm(38, i);
          if (!agrt.a().isPlaying()) {
            break label648;
          }
          i = 1;
          localObject1 = this.jdField_a_of_type_Aahb;
          if (i == 0) {
            break label653;
          }
          i = 2;
          ((aahb)localObject1).gm(39, i);
        }
      }
      else
      {
        adrm.a().cUd();
        if (this.app.W != null)
        {
          startActivity(this.app.W);
          this.app.W = null;
        }
        this.mScrollState = 0;
        if (!this.isInited) {
          break label658;
        }
        if (this.uC != 1000L) {
          this.uC = 1000L;
        }
        if (!this.aUT) {
          this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.aUS) && (this.jdField_a_of_type_Aajg != null)) {
          this.jdField_a_of_type_Aajg.notifyDataSetChanged();
        }
        fI(0L);
        bMj();
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        bMF();
        if (!this.aUN) {
          break label701;
        }
        if (FrameHelperActivity.ZW()) {
          FrameHelperActivity.cuA();
        }
        this.aUN = false;
        if ((this.jdField_a_of_type_Akze.mState != -1) && (this.jdField_a_of_type_Akze.mState != 1))
        {
          this.jdField_a_of_type_Akze.a.aUN = true;
          this.jdField_a_of_type_Akze.aUN = true;
        }
        this.jdField_a_of_type_Akze.cUs();
        if (this.pb == null) {
          break label724;
        }
        localObject1 = this.pb.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label719;
          }
          localObject2 = (adue)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            if (!this.aVo) {
              break;
            }
            ((adue)localObject2).aMB = this.aMB;
            ((adue)localObject2).aVo = true;
            ((adue)localObject2).cUs();
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.e("Q.recent", 1, localException, new Object[0]);
        continue;
        int i = 0;
        continue;
        label638:
        i = 0;
        continue;
        label643:
        i = 0;
        continue;
        label648:
        i = 0;
        continue;
        label653:
        i = 0;
        continue;
        label658:
        if (!this.aVd)
        {
          this.aVd = true;
          this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
        }
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
        continue;
        label701:
        this.jdField_a_of_type_Akze.onResume();
        continue;
        ((adue)localObject2).onResume();
      }
      label719:
      this.aVo = false;
      label724:
      if (this.aVm) {
        this.aVm = false;
      }
      if (AppSetting.enableTalkBack) {
        a().setTitle(getString(2131695649));
      }
      this.jdField_g_of_type_MqqOsMqqHandler.postDelayed(new Conversation.21(this), 500L);
      this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
      ((altq)this.app.getManager(36)).kP(System.currentTimeMillis());
      kxm.M(this.app);
      if (this.dL == null) {
        this.dL = new Conversation.22(this);
      }
      ThreadManagerV2.excute(this.dL, 32, null, true);
      if (!aqmj.as(a(), this.app.getCurrentAccountUin()))
      {
        Object localObject3 = this.app.a().a().q(false);
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          aqmj.cx(a(), this.app.getCurrentAccountUin());
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject2 = (TroopManager)this.app.getManager(52);
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          if ((localRecentUser.getType() == 1) && (localRecentUser.showUpTime > 0L))
          {
            ((TroopManager)localObject2).n(localRecentUser.uin, localRecentUser.showUpTime);
            localArrayList.add(localRecentUser.uin);
            n(9, localRecentUser.uin, 1);
          }
        }
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (aqmj.f(a(), this.app.getCurrentAccountUin()).contains(localObject3)) {
            localArrayList.remove(localObject3);
          }
        }
        if (localArrayList.size() == 0)
        {
          aqmj.cx(a(), this.app.getCurrentAccountUin());
          return;
        }
        ((accc)this.app.getBusinessHandler(22)).P(localArrayList, 0);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.dN, 5000L);
      j(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      aibe.a().a(this.app, this.jdField_a_of_type_Aajg, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      kaw.a().adq = false;
      if (!paramBoolean) {
        break label1345;
      }
    }
    this.aUY = true;
    for (;;)
    {
      if (this.jdField_a_of_type_Aiwd != null) {
        this.jdField_a_of_type_Aiwd.onResume();
      }
      wO(true);
      bMx();
      bMw();
      ApngImage.playByTag(2);
      if (!this.jdField_g_of_type_MqqOsMqqHandler.hasMessages(1053)) {
        this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
      }
      if (this.jdField_b_of_type_Pvz != null) {
        this.jdField_b_of_type_Pvz.onResume();
      }
      if (this.jdField_a_of_type_Aahb != null) {
        this.jdField_a_of_type_Aahb.onResume();
      }
      aakp.bJ(this.app);
      bMv();
      if (this.jdField_a_of_type_Aamm != null) {
        this.jdField_a_of_type_Aamm.cvp();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
      }
      aogc.a(null);
      if ((paramBoolean) && (this.jdField_a_of_type_Utt != null)) {
        this.jdField_a_of_type_Utt.wW(false);
      }
      if (paramBoolean) {
        break;
      }
      ykf.j(a());
      return;
      label1345:
      this.aUY = false;
      if (this.jdField_b_of_type_Ahyj != null) {
        this.jdField_b_of_type_Ahyj.end();
      }
    }
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView)
  {
    if (this.jdField_a_of_type_Aajg == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Aajg.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.qx()))) {
        anot.a(this.app, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!acbn.bly.equals(localRecentBaseData.qx())));
    int i;
    if (localRecentBaseData.mUnreadFlag == 2)
    {
      i = 1;
      if (localRecentBaseData.mUnreadFlag != 1) {
        break label168;
      }
    }
    label168:
    for (int j = localRecentBaseData.mUnreadNum;; j = 0)
    {
      int m = -1;
      if ((paramView.getTag(-1) instanceof Integer)) {
        m = ((Integer)paramView.getTag(-1)).intValue() + 1;
      }
      ThreadManager.executeOnSubThread(new Conversation.7(this, i, j, m));
      return;
      i = 0;
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.ajD != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = 1000.0D * (1.0D / (l1 - this.FQ));
      if (paramInt1 > this.ajD)
      {
        bool = true;
        this.aVc = bool;
        this.ajD = paramInt1;
        this.FQ = l1;
        if (QLog.isDebugVersion()) {
          QLog.d("RecentDataListManager", 2, "onScroll:" + d1 + " for Direction:" + this.aVc);
        }
        if (d1 > 25.0D) {
          break label328;
        }
        bMD();
      }
    }
    else
    {
      label117:
      if (paramInt1 + paramInt2 == paramInt3)
      {
        paramInt3 = ((ListView)paramAbsListView).getHeaderViewsCount();
        if (paramInt1 > paramInt3) {
          break label338;
        }
        paramInt3 = paramAbsListView.getChildAt(paramInt3 - paramInt1).getTop();
        paramInt2 = paramAbsListView.getChildAt(paramInt2 - 2).getBottom();
      }
    }
    label328:
    label338:
    for (paramInt2 = Math.max(0, paramInt3 + (paramAbsListView.getHeight() - paramInt2));; paramInt2 = 0)
    {
      paramAbsListView = (AbsListView.LayoutParams)this.si.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt2))
      {
        paramAbsListView.height = paramInt2;
        this.si.setLayoutParams(paramAbsListView);
      }
      if (paramInt1 == 0)
      {
        this.aVr = false;
        this.FS = -1L;
      }
      if ((this.aVr) && (SystemClock.elapsedRealtime() - this.FS > 800L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScroll cost time is below 1000 ms, isScroll2TopFlag: " + this.aVr + ", startScrollTime: " + this.FS);
        }
        this.aVr = false;
        this.FS = -1L;
      }
      return;
      bool = false;
      break;
      aqcy.D(this.app);
      break label117;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Conversation", 2, "onScrollStateChanged:" + paramInt);
    }
    if ((paramAbsListView instanceof ARMapHongBaoListView)) {
      ((ARMapHongBaoListView)paramAbsListView).setScrollState(paramInt);
    }
    int i;
    label162:
    Object localObject;
    if (paramInt != 0)
    {
      this.aVp = true;
      ApngImage.pauseByTag(2);
      this.mScrollState = paramInt;
      if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        break label319;
      }
      if (this.jdField_b_of_type_Pvz != null) {
        this.jdField_b_of_type_Pvz.onScrollStateChanged(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label419;
      }
      if (this.jdField_a_of_type_Aajg == null) {
        break label254;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int j = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int n = this.jdField_a_of_type_Aajg.getCount();
      this.bGb = Math.max(i, -1);
      if ((i < 0) || (i >= n) || (i > j - m)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Aajg.getItem(i);
      if ((localObject instanceof RecentBaseData)) {
        break label214;
      }
    }
    label214:
    do
    {
      i += 1;
      break label162;
      this.aVp = false;
      break;
      localObject = (RecentBaseData)localObject;
    } while ((!((RecentBaseData)localObject).Gq()) || (((RecentBaseData)localObject).wU() <= 0));
    this.bGb = i;
    label242:
    this.jdField_a_of_type_Aajg.Cq(false);
    aqfp.Sz(false);
    label254:
    if (paramInt == 0)
    {
      bMD();
      txn.a().stopMonitorScene("list_conv", false);
      ThreadRegulator.a().JX(2);
      j(paramAbsListView);
      aibe.a().a(this.app, this.jdField_a_of_type_Aajg, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      wO(false);
      bMx();
      bMI();
      bMB();
    }
    for (;;)
    {
      label319:
      if ((!this.aVp) && (this.aVq))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
        }
        this.k.sendEmptyMessage(10);
        this.aVq = false;
      }
      if (paramInt == 0)
      {
        if (this.aUS) {
          fI(100L);
        }
        ApngImage.playByTag(2);
      }
      if (this.jdField_a_of_type_Aahb != null) {
        this.jdField_a_of_type_Aahb.Ck(this.aVp);
      }
      lcm.h.onScrollStateChanged(paramAbsListView, paramInt);
      adak.a(this.app, paramAbsListView, paramInt);
      return;
      label419:
      if (this.jdField_a_of_type_Aajg == null) {
        break;
      }
      this.jdField_a_of_type_Aajg.Cq(true);
      aqfp.Sz(true);
      break;
      txn.a().startMonitorScene("list_conv");
      ThreadRegulator.a().JW(2);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_Aakj != null) && (this.jdField_a_of_type_Aakj.isShowing())) {
      this.jdField_a_of_type_Aakj.dismiss();
    }
    if (this.jdField_b_of_type_Ahyj != null) {
      this.jdField_b_of_type_Ahyj.end();
    }
    if (this.pb != null)
    {
      Iterator localIterator = this.pb.iterator();
      while (localIterator.hasNext())
      {
        adue localadue = (adue)localIterator.next();
        if (localadue != null) {
          localadue.onStop();
        }
      }
    }
    if (this.jdField_a_of_type_Aiwd != null) {
      this.jdField_a_of_type_Aiwd.onStop();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onStop();
    }
  }
  
  public void pE(boolean paramBoolean)
  {
    wI(true);
    this.aVi = paramBoolean;
    if (paramBoolean)
    {
      this.FR = System.currentTimeMillis();
      if (this.mIsForeground)
      {
        this.aVj = true;
        atg();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.mUiHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Utt != null) {
      this.jdField_a_of_type_Utt.bcH();
    }
  }
  
  public String setLastActivityName()
  {
    String str = acfp.m(2131704505);
    if (this.bGd <= 0) {
      return str;
    }
    if (this.bGd > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.bGd + ")";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int j = 2;
    Object localObject2;
    if ((paramObject instanceof MessageRecord))
    {
      localObject2 = (MessageRecord)paramObject;
      this.app.dF(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
      if ((!((MessageRecord)localObject2).isSendFromLocal()) || (((MessageRecord)localObject2).msgtype != -2002)) {}
    }
    label52:
    label210:
    label613:
    do
    {
      do
      {
        do
        {
          break label52;
          break label52;
          do
          {
            return;
          } while ((((MessageRecord)localObject2).isSendFromLocal()) && (((MessageRecord)localObject2).msgtype == -2000) && (!this.mIsForeground));
          if ((this.mIsForeground) && (jxp.c((MessageRecord)localObject2)))
          {
            j(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
            wO(false);
          }
          if ((this.mIsForeground) && (aibg.aC((MessageRecord)localObject2))) {
            aibe.a().a(this.app, this.jdField_a_of_type_Aajg, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          }
          int i = 10;
          Object localObject1 = Long.valueOf(0L);
          if ((((MessageRecord)localObject2).isSendFromLocal()) && ((!this.mIsForeground) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, acbn.blw)) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, acbn.blx))))
          {
            i = 9;
            localObject1 = aajt.makeKey(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (((MessageRecord)localObject2).isSend()) {
              aqjl.n(this.app, (MessageRecord)localObject2);
            }
            e(j, i, localObject1);
            this.aVq = true;
          }
          for (;;)
          {
            if (!(paramObservable instanceof alkm)) {
              break label613;
            }
            if ((paramObject instanceof Boolean))
            {
              boolean bool = ((Boolean)paramObject).booleanValue();
              if ((!this.aUQ) && (bool))
              {
                paramObservable = null;
                if (this.app != null) {
                  paramObservable = (alkm)this.app.getManager(38);
                }
                if (paramObservable != null) {
                  paramObservable.NR(false);
                }
              }
            }
            if ((!this.aUQ) || (this.jdField_a_of_type_Aahb == null)) {
              break;
            }
            this.jdField_a_of_type_Aahb.cur();
            return;
            if ((!this.mIsForeground) && (aalb.bwh) && (!this.jdField_g_of_type_MqqOsMqqHandler.hasMessages(1024))) {
              this.jdField_g_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
            }
            j = 0;
            break label210;
            if ((paramObject instanceof RecentUser))
            {
              fI(200L);
              if ((this.mIsForeground) && (((RecentUser)paramObject).getType() == 6004)) {
                this.aUZ = true;
              }
            }
            else if ((paramObject instanceof String[]))
            {
              localObject1 = (String[])paramObject;
              if ((localObject1.length == 2) && (acbn.bku.equals(localObject1[0])) && (localObject1[1] != null))
              {
                localObject2 = localObject1[0];
                n(8, localObject1[1], 7000);
              }
            }
            else if ((paramObject instanceof JSONObject))
            {
              JSONObject localJSONObject = (JSONObject)paramObject;
              try
              {
                i = localJSONObject.getInt("actionType");
                switch (i)
                {
                default: 
                  break;
                case 1: 
                  localObject1 = null;
                }
                try
                {
                  localObject2 = localJSONObject.getString("actionUin");
                  localObject1 = localObject2;
                  i = localJSONObject.getInt("actionUinType");
                  localObject1 = localObject2;
                }
                catch (JSONException localJSONException2)
                {
                  for (;;)
                  {
                    localJSONException2.printStackTrace();
                    i = -1;
                  }
                  n(8, localJSONException1, i);
                }
                if ((-1 == i) || (localObject1 == null)) {
                  fI(200L);
                }
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  localJSONException1.printStackTrace();
                  i = -1;
                }
              }
            }
          }
        } while ((!(paramObservable instanceof altq)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = (altq)paramObservable;
        paramObservable = altu.b(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (altu)paramObservable.get(0);
    } while ((paramObservable.type < 1) || (paramObservable.type > 4));
    altu.m(this);
  }
  
  int vr()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Aajg.getCount())
    {
      if ((this.jdField_a_of_type_Aajg.getItem(i) instanceof RecentItemMayKnowFriendVerticalListData)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  protected void wI(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 604	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 517
    //   9: iconst_2
    //   10: new 725	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 726	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 4323
    //   20: invokevirtual 732	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 735	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 744	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 747	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: ifnull +21 -> 58
    //   40: aload_0
    //   41: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   44: invokevirtual 4326	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   47: ifge +11 -> 58
    //   50: aload_0
    //   51: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   54: iconst_0
    //   55: invokevirtual 4329	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 3457	com/tencent/mobileqq/activity/Conversation:wN	(Z)V
    //   63: iload_1
    //   64: ifeq +360 -> 424
    //   67: invokestatic 762	aiyy:a	()Laiyy;
    //   70: invokevirtual 4330	aiyy:onDestroy	()V
    //   73: invokestatic 1627	aajt:a	()Laajt;
    //   76: invokevirtual 3812	aajt:clearCache	()V
    //   79: aload_0
    //   80: getfield 1450	com/tencent/mobileqq/activity/Conversation:aUR	Z
    //   83: ifeq +22 -> 105
    //   86: aload_0
    //   87: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   90: ifnull +15 -> 105
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 1450	com/tencent/mobileqq/activity/Conversation:aUR	Z
    //   98: aload_0
    //   99: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   102: invokevirtual 4333	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   105: aload_0
    //   106: getfield 636	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   109: ifnull +15 -> 124
    //   112: aload_0
    //   113: getfield 636	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   116: invokevirtual 4334	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 636	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   124: aload_0
    //   125: getfield 622	com/tencent/mobileqq/activity/Conversation:K	Landroid/app/Dialog;
    //   128: ifnull +15 -> 143
    //   131: aload_0
    //   132: getfield 622	com/tencent/mobileqq/activity/Conversation:K	Landroid/app/Dialog;
    //   135: invokevirtual 1208	android/app/Dialog:dismiss	()V
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 622	com/tencent/mobileqq/activity/Conversation:K	Landroid/app/Dialog;
    //   143: aload_0
    //   144: getfield 1619	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Yzp	Lyzp;
    //   147: ifnull +14 -> 161
    //   150: aload_0
    //   151: getfield 1619	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Yzp	Lyzp;
    //   154: aload_0
    //   155: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 4335	yzp:onAccountChanged	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   161: aload_0
    //   162: getfield 2134	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aala	Laala;
    //   165: ifnull +14 -> 179
    //   168: aload_0
    //   169: getfield 2134	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aala	Laala;
    //   172: aload_0
    //   173: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: invokevirtual 4337	aala:bK	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   179: aload_0
    //   180: getfield 1006	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aajg	Laajg;
    //   183: ifnull +25 -> 208
    //   186: aload_0
    //   187: getfield 1006	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aajg	Laajg;
    //   190: aload_0
    //   191: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   194: invokevirtual 4338	aajg:onAccountChanged	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   197: aload_0
    //   198: iconst_1
    //   199: bipush 10
    //   201: lconst_0
    //   202: invokestatic 611	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: invokevirtual 1108	com/tencent/mobileqq/activity/Conversation:e	(IILjava/lang/Object;)V
    //   208: aload_0
    //   209: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   212: ifnull +11 -> 223
    //   215: aload_0
    //   216: getfield 630	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   219: iconst_0
    //   220: invokevirtual 4166	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   223: aload_0
    //   224: iconst_0
    //   225: invokespecial 662	com/tencent/mobileqq/activity/Conversation:wM	(Z)V
    //   228: aload_0
    //   229: getfield 1805	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_Pvz	Lpvz;
    //   232: ifnull +14 -> 246
    //   235: aload_0
    //   236: getfield 1805	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_Pvz	Lpvz;
    //   239: aload_0
    //   240: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 4339	pvz:onAccountChanged	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   246: aload_0
    //   247: getfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   250: ifnull +16 -> 266
    //   253: aload_0
    //   254: getfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   257: aload_0
    //   258: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: invokeinterface 4340 2 0
    //   266: aload_0
    //   267: getfield 1121	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Awkk	Lawkk;
    //   270: ifnull +14 -> 284
    //   273: aload_0
    //   274: getfield 1121	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Awkk	Lawkk;
    //   277: aload_0
    //   278: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   281: invokevirtual 4341	awkk:onAccountChanged	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   284: ldc_w 517
    //   287: ldc_w 4343
    //   290: aload_0
    //   291: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: getfield 538	com/tencent/mobileqq/app/QQAppInterface:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   297: invokevirtual 544	com/tencent/mobileqq/app/automator/Automator:He	()Z
    //   300: invokestatic 549	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   303: invokestatic 4348	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   306: aload_0
    //   307: sipush 1055
    //   310: lconst_0
    //   311: iconst_0
    //   312: invokevirtual 572	com/tencent/mobileqq/activity/Conversation:h	(IJZ)V
    //   315: aload_0
    //   316: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   319: ifnull +10 -> 329
    //   322: aload_0
    //   323: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   326: invokevirtual 4350	aahb:onAccountChanged	()V
    //   329: aload_0
    //   330: getfield 258	com/tencent/mobileqq/activity/Conversation:isInited	Z
    //   333: ifeq +13 -> 346
    //   336: aload_0
    //   337: getfield 560	com/tencent/mobileqq/activity/Conversation:k	Lmqq/os/MqqHandler;
    //   340: bipush 12
    //   342: invokevirtual 566	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   345: pop
    //   346: aload_0
    //   347: getfield 592	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   350: getfield 598	com/tencent/mobileqq/app/FrameHelperActivity:mUiHandler	Landroid/os/Handler;
    //   353: iconst_4
    //   354: invokevirtual 601	android/os/Handler:sendEmptyMessage	(I)Z
    //   357: pop
    //   358: aload_0
    //   359: sipush 1035
    //   362: ldc2_w 4213
    //   365: iconst_0
    //   366: invokevirtual 572	com/tencent/mobileqq/activity/Conversation:h	(IJZ)V
    //   369: aload_0
    //   370: sipush 1010
    //   373: ldc2_w 4213
    //   376: iconst_1
    //   377: invokevirtual 572	com/tencent/mobileqq/activity/Conversation:h	(IJZ)V
    //   380: aload_0
    //   381: sipush 1063
    //   384: lconst_0
    //   385: iconst_1
    //   386: aconst_null
    //   387: invokevirtual 754	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   390: aload_0
    //   391: sipush 1064
    //   394: ldc2_w 4213
    //   397: iconst_1
    //   398: ldc_w 4352
    //   401: invokevirtual 754	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   404: aload_0
    //   405: aload_0
    //   406: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   409: bipush 76
    //   411: invokevirtual 958	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   414: checkcast 2686	aqxh
    //   417: putfield 270	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aqxh	Laqxh;
    //   420: aload_0
    //   421: invokespecial 3667	com/tencent/mobileqq/activity/Conversation:bMH	()V
    //   424: aload_0
    //   425: sipush 10001
    //   428: ldc2_w 4353
    //   431: iconst_0
    //   432: invokevirtual 572	com/tencent/mobileqq/activity/Conversation:h	(IJZ)V
    //   435: aload_0
    //   436: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   439: invokevirtual 1899	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   442: ifne +15 -> 457
    //   445: aload_0
    //   446: getfield 258	com/tencent/mobileqq/activity/Conversation:isInited	Z
    //   449: ifeq +8 -> 457
    //   452: aload_0
    //   453: lconst_0
    //   454: invokevirtual 3976	com/tencent/mobileqq/activity/Conversation:fI	(J)V
    //   457: aload_0
    //   458: ldc_w 4355
    //   461: ldc2_w 4356
    //   464: iconst_0
    //   465: invokevirtual 572	com/tencent/mobileqq/activity/Conversation:h	(IJZ)V
    //   468: invokestatic 1345	kaw:a	()Lkaw;
    //   471: aload_0
    //   472: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   475: invokevirtual 1259	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   478: invokevirtual 4360	kaw:lN	(Ljava/lang/String;)V
    //   481: getstatic 4365	ajee:cnM	Z
    //   484: ifeq +13 -> 497
    //   487: invokestatic 4368	ajee:a	()Lajee;
    //   490: aload_0
    //   491: getfield 533	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: invokevirtual 4369	ajee:onAccountChanged	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   497: return
    //   498: astore_2
    //   499: aload_0
    //   500: aconst_null
    //   501: putfield 636	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   504: goto -380 -> 124
    //   507: astore_2
    //   508: aload_0
    //   509: aconst_null
    //   510: putfield 636	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   513: aload_2
    //   514: athrow
    //   515: astore_2
    //   516: aload_0
    //   517: aconst_null
    //   518: putfield 622	com/tencent/mobileqq/activity/Conversation:K	Landroid/app/Dialog;
    //   521: goto -378 -> 143
    //   524: astore_2
    //   525: aload_0
    //   526: aconst_null
    //   527: putfield 622	com/tencent/mobileqq/activity/Conversation:K	Landroid/app/Dialog;
    //   530: aload_2
    //   531: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	Conversation
    //   0	532	1	paramBoolean	boolean
    //   498	1	2	localException1	Exception
    //   507	7	2	localObject1	Object
    //   515	1	2	localException2	Exception
    //   524	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   112	119	498	java/lang/Exception
    //   112	119	507	finally
    //   131	138	515	java/lang/Exception
    //   131	138	524	finally
  }
  
  protected void wJ(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean);
    }
    if (paramBoolean) {
      if (this.mLoadingView == null)
      {
        i = this.nR.getId();
        this.mLoadingView = new ImageView(a());
        this.mLoadingView.setId(2131370796);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * aqgz.getDesity()));
        this.gw.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject);
      }
    }
    while ((this.mLoadingView == null) || (this.mLoadingView.getVisibility() == 8)) {
      try
      {
        int i;
        Object localObject = a().getResources().getDrawable(2130839655);
        this.mLoadingView.setImageDrawable((Drawable)localObject);
        if ((localObject instanceof Animatable)) {
          ((Animatable)localObject).start();
        }
        if (this.mLoadingView.getVisibility() != 0) {
          this.mLoadingView.setVisibility(0);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    this.mLoadingView.setVisibility(8);
  }
  
  public void wK(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Aahb.hx(1);
    boolean bool2 = this.jdField_a_of_type_Aahb.hx(9);
    if (paramBoolean)
    {
      this.p.removeMessages(4);
      this.p.removeMessages(3);
    }
    if ((bool1) || (bool2))
    {
      wJ(false);
      return;
    }
    switch (aiyy.a().FC())
    {
    default: 
      return;
    }
    for (;;)
    {
      wJ(false);
      return;
      wJ(true);
      if (this.p.hasMessages(4)) {
        break;
      }
      this.p.sendEmptyMessageDelayed(4, 180000L);
      return;
      wJ(true);
      if (this.p.hasMessages(3)) {
        break;
      }
      this.p.sendEmptyMessageDelayed(3, 180000L);
      return;
      wJ(false);
    }
  }
  
  public void wL(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Utt != null) {
      this.jdField_a_of_type_Utt.wY(paramBoolean);
    }
  }
  
  public void wP(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Pvz != null) {
        this.jdField_b_of_type_Pvz.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b);
      }
    }
  }
  
  public void wQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
  }
  
  public class DateFormatChangeRunnable
    implements Runnable
  {
    private DateFormatChangeRunnable() {}
    
    public void run()
    {
      Object localObject = Settings.System.getString(Conversation.this.a().getContentResolver(), "date_format");
      if ((Conversation.this.a != null) && (aale.a().iP((String)localObject)) && (Conversation.this.mIsForeground)) {
        Conversation.this.h(1014, 0L, false);
      }
      anxk.aK(Conversation.this.app, (String)localObject);
      if (Conversation.this.app != null)
      {
        localObject = Conversation.this.app.getHandler(TroopAssistantActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(2);
        }
      }
    }
  }
  
  static class a
    extends adah
  {
    private WeakReference<Conversation> an;
    
    public a(Conversation paramConversation)
    {
      this.an = new WeakReference(paramConversation);
    }
    
    public void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
    {
      if ((paramBoolean) && (paramList != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
        }
        Conversation localConversation = (Conversation)this.an.get();
        if (localConversation != null)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)paramList.next();
            if (localAppletsAccountInfo != null) {
              localConversation.n(9, localAppletsAccountInfo.uin, 1038);
            }
          }
        }
      }
    }
  }
  
  class b
    implements DragFrameLayout.c
  {
    private final int mFlag = -2147483648;
    
    private b() {}
    
    public void G(int paramInt, List<RecentBaseData> paramList) {}
    
    public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
    {
      if (paramDragFrameLayout.getMode() == -1)
      {
        Conversation.this.k.sendEmptyMessage(10);
        FrameHelperActivity.EO(true);
        return;
      }
      FrameHelperActivity.EO(false);
    }
  }
  
  class c
    implements Handler.Callback
  {
    c() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      aiyy.a().Qv(paramMessage.what);
      if (paramMessage.what == 4)
      {
        Conversation.this.h(1134013, 0L, false);
        return true;
      }
      Conversation.this.wK(true);
      return true;
    }
  }
  
  static class d
    extends acku
  {
    private WeakReference<Conversation> an;
    
    public d(Conversation paramConversation)
    {
      this.an = new WeakReference(paramConversation);
    }
    
    public void wV(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "cameraRedTouchObserver notify dataChanged");
      }
      Conversation localConversation = (Conversation)this.an.get();
      if (localConversation != null)
      {
        localConversation.wL(false);
        Conversation.h(localConversation);
        localConversation.bMr();
      }
    }
  }
  
  public class e
  {
    private final String content;
    private final String title;
    private final String url;
    
    public e(String paramString1, String paramString2, String paramString3)
    {
      this.title = paramString1;
      this.content = paramString2;
      this.url = paramString3;
    }
    
    public void invoke()
    {
      utp localutp = new utp(this);
      Conversation.this.I = aqha.a(Conversation.this.a(), 230, this.title, this.content, acfp.m(2131704499), acfp.m(2131704503), localutp, localutp);
      Conversation.this.I.setCancelable(false);
      Conversation.this.I.show();
    }
  }
  
  static class f
    extends aook
  {
    final WeakReference<Conversation> mRef;
    
    public f(Conversation paramConversation)
    {
      this.mRef = new WeakReference(paramConversation);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int j = 0;
      Conversation localConversation = (Conversation)this.mRef.get();
      if (localConversation == null) {}
      do
      {
        aoko localaoko;
        int k;
        int i;
        do
        {
          do
          {
            return;
            localaoko = (aoko)paramMessage.obj;
          } while ((Conversation.a(localConversation) == null) || (localaoko == null) || (TextUtils.isEmpty(localaoko.mUin)));
          k = paramMessage.what;
          if (localaoko.fileType != 1)
          {
            i = j;
            if (localaoko.fileType != 2) {}
          }
          else if ((k != 1001) && (k != 1002) && (k != 1000) && (k != 1005))
          {
            i = j;
            if (k != 1003) {}
          }
          else
          {
            i = 1;
          }
        } while ((i == 0) && (((k != 1003) && (k != 2003)) || ((localaoko.fileType != 2) && (!localConversation.mIsForeground))));
        localConversation.n(8, localaoko.mUin, -2147483648);
      } while (!QLog.isColorLevel());
      QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
    }
    
    public void release()
    {
      this.mRef.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */