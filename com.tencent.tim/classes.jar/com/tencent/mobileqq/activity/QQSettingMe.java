package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
import abcy;
import abcy.a;
import acch;
import acch.a;
import accn;
import accy;
import accz;
import acfd;
import acff;
import acfp;
import acha;
import achd;
import achf;
import aciu;
import acks;
import aclh;
import acny;
import acnz;
import advr;
import adyp;
import aeuv;
import aeuw;
import afdl;
import ahyj;
import aiwk;
import akjo;
import akjp;
import akka;
import aklk;
import allp;
import altq;
import amff;
import amfh;
import amfk;
import amhj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import ankt;
import anlm;
import anot;
import anoz;
import anpc;
import aobw;
import aofk;
import aogc;
import aogs;
import aogs.a;
import aoop.a;
import aqap;
import aqcl;
import aqdj;
import aqep;
import aqeu;
import aqft;
import aqgm;
import aqgv;
import aqgz;
import aqhq;
import aqhu;
import aqiw;
import aqqj;
import aqrt;
import aqrt.a;
import aqss;
import aqvl;
import auqy;
import aura;
import auvn;
import avja;
import avjg;
import avjj;
import avpw;
import avpw.d;
import avug;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.b;
import com.tencent.mobileqq.utils.VipUtils.b.a;
import com.tencent.mobileqq.utils.VipUtils.b.b;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import jll;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import oux;
import pmb;
import protocol.KQQConfig.UpgradeInfo;
import rpq;
import sxa;
import sxa.a;
import tencent.im.oidb.redInfo.RedInfo;
import vph;
import vpi;
import vpj;
import vpk;
import vpl;
import vpm;
import vpn;
import vpo;
import vpp;
import vpq;
import vpr;
import vps;
import vpt;
import vpu;
import vpv;
import vpw;
import vpx;
import vpy;
import vpz;
import vqa;
import vqb;
import vqd;
import vqe;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int bJW = 0;
  private static List<String> qZ = new ArrayList();
  private static List<String> ra = new ArrayList();
  private StringBuilder F;
  public TextView Fh;
  protected TextView Fi;
  private TextView Fj;
  public TextView Fk;
  protected TextView Fl;
  public TextView Fm;
  public TextView Fn;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  private abcy.a jdField_a_of_type_Abcy$a = new vqb(this);
  private abcy jdField_a_of_type_Abcy;
  private achf jdField_a_of_type_Achf = new vpx(this);
  private acnz jdField_a_of_type_Acnz = new vpr(this);
  private amff jdField_a_of_type_Amff;
  private amfk jdField_a_of_type_Amfk;
  private amhj jdField_a_of_type_Amhj;
  aogs.a jdField_a_of_type_Aogs$a = new vpw(this);
  private aogs jdField_a_of_type_Aogs;
  private aqrt.a jdField_a_of_type_Aqrt$a = new vpz(this);
  private SettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  protected DynamicAvatarView a;
  private MedalList jdField_a_of_type_ComTencentMobileqqDataMedalList;
  private LoveZoneTabRedDotView jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  public FixedBounceScrollView a;
  protected QVipMedalView a;
  public sxa.a a;
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  protected RedTouch[] a;
  protected RedTouchTextView[] a;
  private BroadcastReceiver aF = new vph(this);
  private String aPb;
  private String aPc;
  private String aPd = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1";
  private String aPe = "";
  private FrameLayout aX;
  private FrameLayout aY;
  protected boolean aZL = true;
  protected boolean aZM = true;
  protected boolean aZN;
  private boolean aZO;
  private boolean aZP;
  private boolean aZQ;
  private boolean aZR;
  private boolean aZS = true;
  private boolean aZT;
  private URLImageView aj;
  public QQAppInterface app;
  private HashSet<Integer> ay = new HashSet();
  private accz jdField_b_of_type_Accz = new vpt(this);
  private amfh jdField_b_of_type_Amfh;
  protected RedTouch b;
  protected AvatarLayout b;
  protected AnimationTextView b;
  protected RedDotTextView b;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private final int bJX = 4;
  private final int bJY = 1;
  int bJZ;
  private int bKa;
  private int bKb;
  private final int bKc = 0;
  private final int bKd = 1;
  public Handler bO = new vpi(this, Looper.getMainLooper());
  private acfd jdField_c_of_type_Acfd = new vpv(this);
  public BaseActivity c;
  private RichStatus jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus;
  private ConcurrentHashMap<String, auvn> cU = new ConcurrentHashMap();
  public ViewGroup cV;
  private ViewGroup cW;
  accn cardObserver = new vpu(this);
  long clickTime = 0L;
  private aclh jdField_d_of_type_Aclh = new vpy(this);
  public Card d;
  BusinessInfoCheckUpdate.AppInfo jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View.OnClickListener dt = new vpm(this);
  private ahyj jdField_e_of_type_Ahyj = new ahyj("QQSetting_me", "com.tencent.mobileqq:tool");
  private aklk jdField_e_of_type_Aklk = new vpq(this);
  BusinessInfoCheckUpdate.AppInfo jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  BusinessInfoCheckUpdate.AppInfo f;
  BusinessInfoCheckUpdate.AppInfo g;
  protected LinearLayout gp;
  protected LinearLayout gq;
  public LinearLayout gr;
  BusinessInfoCheckUpdate.AppInfo h;
  BusinessInfoCheckUpdate.AppInfo i;
  public boolean isInited;
  public boolean isResume;
  protected long iu;
  BusinessInfoCheckUpdate.AppInfo j;
  BusinessInfoCheckUpdate.AppInfo k;
  BusinessInfoCheckUpdate.AppInfo l = null;
  BusinessInfoCheckUpdate.AppInfo m = null;
  private ImageView mBackIcon;
  protected TextView mNickName;
  BusinessInfoCheckUpdate.AppInfo n;
  BusinessInfoCheckUpdate.AppInfo o;
  BusinessInfoCheckUpdate.AppInfo p;
  public View[] p;
  BusinessInfoCheckUpdate.AppInfo q;
  protected ImageView qP;
  private ImageView qQ;
  public ImageView qR;
  protected ImageView qS;
  protected ImageView qT;
  protected int type = 1;
  protected View uc;
  protected View ud;
  protected View ue;
  protected View uf;
  protected View ug;
  protected View uh;
  protected View ui;
  Handler uiHandler = new vqa(this, Looper.getMainLooper());
  protected View uj;
  protected View uk;
  private View ul;
  private View um;
  private View un;
  private View uo;
  protected View up;
  private View uq;
  protected RedTouch v;
  protected RedTouch w;
  protected RedTouch x;
  protected RedTouch y;
  
  static
  {
    qZ.add("h5.vip.qq.com");
    qZ.add("mc.vip.qq.com");
    qZ.add("m.vip.qq.com");
    qZ.add("proxy.vip.qq.com");
    qZ.add("red.vip.qq.com");
    qZ.add("r.vip.qq.com");
    qZ.add("cgi.vip.qq.com");
    qZ.add("iyouxi.vip.qq.com");
    ra.add("zb.vip.qq.com");
    ra.add("gxh.vip.qq.com");
    ra.add("g.vip.qq.com");
    ra.add("imgcache.gtimg.cn");
    ra.add("i.gtimg.cn");
    ra.add("imgcache.qq.com");
    ra.add("logic.content.qq.com");
  }
  
  @TargetApi(11)
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, FrameHelperActivity paramFrameHelperActivity)
  {
    this.jdField_a_of_type_Sxa$a = new a(this);
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.F = new StringBuilder();
    this.cV = ((ViewGroup)LayoutInflater.from(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561678, null));
    this.uc = this.cV.findViewById(2131368407);
    this.uc.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      this.uc.setContentDescription(acfp.m(2131712163));
    }
    this.uc.setOnTouchListener(this);
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.uc.findViewById(2131368375));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363324));
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.c(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.ud = this.uc.findViewById(2131368421);
    this.un = this.uc.findViewById(2131378436);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    int i1;
    label718:
    Object localObject1;
    String str;
    boolean bool;
    label1594:
    label1622:
    int[] arrayOfInt;
    int i3;
    int i2;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840645);
      this.uc.findViewById(2131372385).setOnClickListener(this);
      i1 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298881);
      this.bKa = (ankt.SCREEN_WIDTH - ankt.dip2px(94.0F) - i1 - ankt.dip2px(45.0F));
      this.bKb = (ankt.SCREEN_WIDTH - ankt.dip2px(94.0F) - i1 - ankt.dip2px(20.0F));
      this.mNickName = ((TextView)this.uc.findViewById(2131372384));
      this.mNickName.setMaxWidth(this.bKa);
      this.aPb = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.aPb == null) || ("".equals(this.aPb.trim()))) {
        this.aPb = paramFrameHelperActivity;
      }
      if (!anlm.ayn()) {
        break label2352;
      }
      this.un.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.un).a(53).a();
      this.ud.setVisibility(VasFaceManager.f(paramFrameHelperActivity, paramQQAppInterface));
      this.mNickName.setText(this.aPb);
      this.aj = ((URLImageView)this.uc.findViewById(2131372984));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.aj.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.uc.findViewById(2131375012));
      this.ue = this.uc.findViewById(2131374914);
      this.uf = this.uc.findViewById(2131374915);
      this.qP = ((ImageView)this.uc.findViewById(2131382021));
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.uc.findViewById(2131375050));
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.mBackIcon = ((ImageView)this.cV.findViewById(2131363231));
      this.aY = ((FrameLayout)this.cV.findViewById(2131363229));
      this.qQ = ((ImageView)this.cV.findViewById(2131375289));
      this.aX = ((FrameLayout)this.cV.findViewById(2131367582));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.aY.getLayoutParams();
        paramBaseActivity.topMargin = (ankt.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "Change mBackWrapper topMargin=" + paramBaseActivity.topMargin);
        }
        this.aY.setLayoutParams(paramBaseActivity);
      }
      this.mBackIcon.setOnClickListener(this);
      this.mBackIcon.setOnTouchListener(this);
      this.qQ.setOnClickListener(this);
      this.qQ.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setOnClickListener(this);
      this.gp = ((LinearLayout)this.cV.findViewById(2131372175));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.gp.getLayoutParams();
        paramBaseActivity.topMargin = (ankt.dip2px(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.gp.setLayoutParams(paramBaseActivity);
      }
      this.gp.setOnClickListener(this);
      this.gp.setOnTouchListener(this);
      this.v = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.gp.findViewById(2131378403)).a(53).a();
      this.ug = this.cV.findViewById(2131378397);
      this.x = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.ug).b(10).a(19).a();
      this.ug.setOnClickListener(this);
      this.ug.setOnTouchListener(jll.a);
      this.um = this.cV.findViewById(2131373656);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.cV.findViewById(2131371503));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298875);
      paramBaseActivity = this.cV.getResources();
      this.jdField_p_of_type_ArrayOfAndroidViewView = new View[14];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[14];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[14];
      paramFrameHelperActivity = new int[14];
      FrameHelperActivity tmp1352_1351 = paramFrameHelperActivity;
      tmp1352_1351[0] = 2131375018;
      FrameHelperActivity tmp1358_1352 = tmp1352_1351;
      tmp1358_1352[1] = 2131372189;
      FrameHelperActivity tmp1364_1358 = tmp1358_1352;
      tmp1364_1358[2] = 2131372186;
      FrameHelperActivity tmp1370_1364 = tmp1364_1358;
      tmp1370_1364[3] = 2131372177;
      FrameHelperActivity tmp1376_1370 = tmp1370_1364;
      tmp1376_1370[4] = 2131372180;
      FrameHelperActivity tmp1382_1376 = tmp1376_1370;
      tmp1382_1376[5] = 2131372185;
      FrameHelperActivity tmp1388_1382 = tmp1382_1376;
      tmp1388_1382[6] = 2131372149;
      FrameHelperActivity tmp1395_1388 = tmp1388_1382;
      tmp1395_1388[7] = 2131372181;
      FrameHelperActivity tmp1402_1395 = tmp1395_1388;
      tmp1402_1395[8] = 2131372187;
      FrameHelperActivity tmp1409_1402 = tmp1402_1395;
      tmp1409_1402[9] = 2131372188;
      FrameHelperActivity tmp1416_1409 = tmp1409_1402;
      tmp1416_1409[10] = 2131372182;
      FrameHelperActivity tmp1423_1416 = tmp1416_1409;
      tmp1423_1416[11] = 2131364191;
      FrameHelperActivity tmp1430_1423 = tmp1423_1416;
      tmp1430_1423[12] = 2131365547;
      FrameHelperActivity tmp1437_1430 = tmp1430_1423;
      tmp1437_1430[13] = 2131372148;
      tmp1437_1430;
      localObject1 = new int[14];
      Object tmp1453_1451 = localObject1;
      tmp1453_1451[0] = 2131701660;
      Object tmp1459_1453 = tmp1453_1451;
      tmp1459_1453[1] = 2131701641;
      Object tmp1465_1459 = tmp1459_1453;
      tmp1465_1459[2] = 2131701658;
      Object tmp1471_1465 = tmp1465_1459;
      tmp1471_1465[3] = 2131701671;
      Object tmp1477_1471 = tmp1471_1465;
      tmp1477_1471[4] = 2131701639;
      Object tmp1483_1477 = tmp1477_1471;
      tmp1483_1477[5] = 2131701691;
      Object tmp1489_1483 = tmp1483_1477;
      tmp1489_1483[6] = 2131701617;
      Object tmp1496_1489 = tmp1489_1483;
      tmp1496_1489[7] = 2131701625;
      Object tmp1503_1496 = tmp1496_1489;
      tmp1503_1496[8] = 2131701666;
      Object tmp1510_1503 = tmp1503_1496;
      tmp1510_1503[9] = 2131701628;
      Object tmp1517_1510 = tmp1510_1503;
      tmp1517_1510[10] = 2131701640;
      Object tmp1524_1517 = tmp1517_1510;
      tmp1524_1517[11] = 2131701608;
      Object tmp1531_1524 = tmp1524_1517;
      tmp1531_1524[12] = 2131701609;
      Object tmp1538_1531 = tmp1531_1524;
      tmp1538_1531[13] = 2131701638;
      tmp1538_1531;
      Object localObject2 = ThemeUtil.getCurrentThemeInfo();
      str = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty(str)) && (!"1000".equals(str)) && (!"1103".equals(str))) {
        break label2388;
      }
      bool = true;
      this.aZS = bool;
      if (!this.aZS) {
        break label2394;
      }
      i1 = this.cV.getResources().getColor(2131166725);
      arrayOfInt = a(this.aZS);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + str + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      i3 = ankt.dip2px(2.0F);
      localObject2 = this.cV.findViewById(2131371503);
      this.ul = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131371504);
      i2 = 0;
      label1729:
      if (i2 >= 14) {
        break label2427;
      }
      this.jdField_p_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
      this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
      this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      if (paramFrameHelperActivity[i2] == 2131372187) {
        this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131372188) {
        this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131364191) {
        this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131375018)
      {
        QzoneConfig.getInstance();
        if (!QzoneConfig.isQQCircleShowDrawTabEntrance()) {
          break label2412;
        }
        this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramFrameHelperActivity[i2] == 2131372181)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView = ((LoveZoneTabRedDotView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369476));
        if (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setVisibility(8);
        }
      }
      if (paramFrameHelperActivity[i2] == 2131372148)
      {
        this.gq = ((LinearLayout)this.jdField_p_of_type_ArrayOfAndroidViewView[i2]);
        this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
      Object localObject3 = (ImageView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369471);
      ((ImageView)localObject3).setImageResource(arrayOfInt[i2]);
      Object localObject4 = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369534);
      ((TextView)localObject4).setText(localObject1[i2]);
      if (!this.aZS) {
        ((TextView)localObject4).setTextColor(i1);
      }
      if (paramFrameHelperActivity[i2] == 2131372182) {
        a((ImageView)localObject3, (TextView)localObject4);
      }
      if ((anlm.ayn()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        ((TextView)localObject4).setTextColor(this.cV.getResources().getColor(2131166724));
      }
      localObject3 = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369518);
      ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
      ((TextView)localObject3).setVisibility(0);
      aqcl.changeAccessibilityForView(this.jdField_p_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(localObject1[i2]), Button.class.getName());
      localObject3 = this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369471);
      ((View)localObject3).setPadding(i3, i3, i3, i3);
      localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
      localObject4 = (RedTouchTextView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369534);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
      localLayoutParams.leftMargin -= i3;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2] = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).a(53).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
      if (paramFrameHelperActivity[i2] == 2131372148) {
        this.w = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2];
      }
      i2 += 1;
      break label1729;
      localObject1 = paramQQAppInterface.getBitmapFromCache(paramQQAppInterface.a(1, paramFrameHelperActivity, (byte)1, 0, 100, true));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject1);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840645);
      break;
      label2352:
      this.un.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.ud).a(53).a();
      break label718;
      label2388:
      bool = false;
      break label1594;
      label2394:
      i1 = this.cV.getResources().getColor(2131166726);
      break label1622;
      label2412:
      this.jdField_p_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
    }
    label2427:
    bUe();
    bUh();
    bTW();
    bTY();
    bTA();
    this.uk = this.cV.findViewById(2131369717);
    this.uk.setOnClickListener(this);
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)))
    {
      this.uk.setVisibility(0);
      this.uj = this.cV.findViewById(2131363644);
      this.ui = this.cV.findViewById(2131378151);
      this.ui.setOnClickListener(this);
      this.ui.setOnTouchListener(this);
      aqcl.changeAccessibilityForView(this.ui, acfp.m(2131712157), Button.class.getName());
      this.Fi = ((TextView)this.cV.findViewById(2131378153));
      this.qT = ((ImageView)this.cV.findViewById(2131374968));
      this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.cV.findViewById(2131378152));
      this.y = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.uh = this.cV.findViewById(2131372396);
      this.uh.setOnClickListener(this);
      this.uh.setOnTouchListener(this);
      aqcl.changeAccessibilityForView(this.uh, acfp.m(2131712140), Button.class.getName());
      this.Fh = ((TextView)this.cV.findViewById(2131372398));
      this.qR = ((ImageView)this.cV.findViewById(2131372397));
      this.qS = ((ImageView)this.jdField_p_of_type_ArrayOfAndroidViewView[6].findViewById(2131369460));
      this.uo = this.cV.findViewById(2131370749);
      this.Fj = ((TextView)this.cV.findViewById(2131380961));
      this.uo.setOnClickListener(this);
      this.uo.setOnTouchListener(this);
      this.gr = ((LinearLayout)this.cV.findViewById(2131382150));
      this.gr.setOnClickListener(this);
      this.gr.setOnTouchListener(this);
      this.Fk = ((TextView)this.cV.findViewById(2131379325));
      this.up = this.cV.findViewById(2131379309);
      this.Fl = ((TextView)this.cV.findViewById(2131379327));
      this.Fm = ((TextView)this.cV.findViewById(2131379326));
      this.Fn = ((TextView)this.cV.findViewById(2131382147));
      if (!anlm.ayn())
      {
        this.Fk.getPaint().setFakeBoldText(true);
        this.Fl.getPaint().setFakeBoldText(true);
        this.Fm.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label3094;
      }
      this.Fk.setTextColor(-6709582);
      this.Fl.setTextColor(-6709582);
      this.Fm.setTextColor(-6709582);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController = new SettingMeApolloViewController(this, this.cV);
      if (!this.aZS)
      {
        this.Fi.setTextColor(i1);
        this.Fh.setTextColor(i1);
        this.Fj.setTextColor(i1);
        this.qT.setImageResource(2130846987);
        this.qR.setImageResource(2130846962);
        this.Fk.setTextColor(i1);
        this.Fl.setTextColor(i1);
        this.Fm.setTextColor(i1);
        this.Fn.setTextColor(i1);
      }
      return;
      this.uk.setVisibility(8);
      break;
      label3094:
      this.Fk.setTextColor(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166725));
      this.Fl.setTextColor(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166725));
      this.Fm.setTextColor(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166725));
    }
  }
  
  private boolean Qv()
  {
    int i1 = 0;
    if (this.ul.getHeight() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() mMenuPanel.getHeight() == 0");
      }
      return false;
    }
    View localView = this.ul.findViewById(2131365547);
    Object localObject1 = new int[2];
    localView.getLocationOnScreen((int[])localObject1);
    localObject1 = new Rect(localObject1[0], localObject1[1], localObject1[0] + localView.getWidth(), localObject1[1] + localView.getHeight());
    Object localObject2 = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getLocationOnScreen((int[])localObject2);
    localObject2 = new Rect(localObject2[0], localObject2[1], localObject2[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getWidth(), localObject2[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() containerBounds = " + localObject2 + ", cardBounds = " + localObject1);
    }
    if (!((Rect)localObject2).contains((Rect)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() should adjust cuKingCard position");
      }
      localObject1 = (ViewGroup)localView.getParent();
      if (i1 >= ((ViewGroup)localObject1).getChildCount()) {
        break label271;
      }
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131372181) {
        break label264;
      }
    }
    for (;;)
    {
      if (i1 + 1 <= ((ViewGroup)localObject1).getChildCount())
      {
        ((ViewGroup)localObject1).removeView(localView);
        ((ViewGroup)localObject1).addView(localView, i1 + 1);
      }
      this.aZT = true;
      return true;
      label264:
      i1 += 1;
      break;
      label271:
      i1 = -1;
    }
  }
  
  private boolean Qw()
  {
    akjp localakjp = (akjp)this.app.getManager(160);
    localakjp.n(100601, false);
    localakjp.n(10016, false);
    localakjp.n(10015, false);
    RedTouchItem localRedTouchItem = localakjp.a(-7);
    if (localakjp.a(localRedTouchItem, true)) {}
    try
    {
      bUo();
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
      label109:
      if (QLog.isColorLevel())
      {
        QLog.d("QQSettingRedesign", 2, "update head icon red point: " + localRedTouchItem.redtouchType);
        return true;
        this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = null;
        return false;
      }
    }
    catch (Exception localException)
    {
      break label109;
    }
    return true;
  }
  
  private boolean Qx()
  {
    aqep.ev(this.app);
    Object localObject = (akjp)this.app.getManager(160);
    RedTouchItem localRedTouchItem = ((akjp)localObject).a(-4);
    if ((((akjp)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = aqhq.o(akjo.eE(-4));
        if ((localObject instanceof RedTouchItemExtMsg))
        {
          localObject = (RedTouchItemExtMsg)localObject;
          this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo = new redInfo.RedInfo();
          this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.mergeFrom(((RedTouchItemExtMsg)localObject).bytesData);
        }
        if (!QLog.isColorLevel()) {
          break label155;
        }
        QLog.d("QQSettingRedesign", 2, "updateProfileBubbleMsgInfo red point: " + localRedTouchItem.redtouchType);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQSettingRedesign", 2, localException.getMessage(), localException);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo = null;
      return false;
    }
    label155:
    return true;
  }
  
  private boolean Qy()
  {
    if (!this.isInited) {
      return true;
    }
    long l1 = aqvl.c(this.app, "setting_me_last_request_success_time", 0L);
    int i1 = aqvl.e(this.app, "setting_me_vip_sync_freq", 0);
    if (NetConnInfoCenter.getServerTime() - l1 <= i1)
    {
      QLog.e("QVipSettingMe.QQSettingRedesign", 1, "ignore the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + l1 + " and updateFrequency=" + i1);
      return false;
    }
    QLog.e("QVipSettingMe.QQSettingRedesign", 1, "need the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + l1 + " and updateFrequency=" + i1);
    return true;
  }
  
  private String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramString = new StringBuffer(paramString);
    if ((paramAppInfo != null) && (paramAppInfo.buffer != null))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (TextUtils.isEmpty(paramAppInfo)) {}
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo);
      String str = paramAppInfo.getString("trace_id");
      int i1 = paramAppInfo.getInt("trace_num");
      int i2 = paramAppInfo.getInt("ad_id");
      paramString.append("&").append("trace_id=").append(str);
      paramString.append("&").append("trace_num=").append(i1);
      paramString.append("&").append("trace_detail=").append(URLEncoder.encode("trace_detail_ad_id=" + i2, "UTF-8"));
      return paramString.toString();
    }
    catch (Exception paramAppInfo)
    {
      for (;;)
      {
        QLog.d("QQSettingRedesign", 1, "getMyMiniGameJumpUrl failed", paramAppInfo);
      }
    }
  }
  
  private void a(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = null;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramAppInfo != null)
    {
      localObject1 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).set(paramAppInfo);
      localAppInfo.set(paramAppInfo);
      if ((localAppInfo.iNewFlag.get() != 0) && (localAppInfo.red_display_info.get() != null) && (localAppInfo.red_display_info.red_type_info.get() != null))
      {
        Object localObject2 = new ArrayList(localAppInfo.red_display_info.red_type_info.get());
        int i2 = ((ArrayList)localObject2).size() - 1;
        int i1 = 0;
        if (i2 >= 0)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((ArrayList)localObject2).get(i2);
          int i3 = localRedTypeInfo.red_type.get();
          if (i3 == 0) {
            ((ArrayList)localObject2).remove(i2);
          }
          for (i1 = 1;; i1 = 1)
          {
            i2 -= 1;
            break;
            if ((i3 != 3) || (!RedTouchTextView.a(localRedTypeInfo, localAppInfo))) {
              break label283;
            }
            RedTouchTextView.setImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
          }
        }
        if (((ArrayList)localObject2).size() < 2) {
          ((ArrayList)localObject2).clear();
        }
        localAppInfo.red_display_info.red_type_info.set((List)localObject2);
        paramAppInfo = new ArrayList();
        if (i1 != 0)
        {
          localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
          paramAppInfo.add(localObject2);
        }
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.set(paramAppInfo);
      }
      paramAppInfo = localAppInfo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[paramInt].e((BusinessInfoCheckUpdate.AppInfo)localObject1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[paramInt].setAppInfo(paramAppInfo);
      return;
      label283:
      break;
      localAppInfo = null;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localAppInfo;
    }
  }
  
  private void a(ImageView paramImageView, TextView paramTextView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameIconUrl", "");
      if ((!TextUtils.isEmpty(str)) && (ThemeUtil.isDefaultTheme())) {
        paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(str), localURLDrawableOptions));
      }
      paramImageView = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameNameText", "");
      if (!TextUtils.isEmpty(paramImageView)) {
        paramTextView.setText(paramImageView);
      }
      return;
    }
    catch (Exception paramImageView)
    {
      QLog.e("QQSettingRedesign", 1, "set URL Drawable failed ", paramImageView);
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      int i1 = paramAppInfo.uiAppId.get();
      if (!this.ay.contains(Integer.valueOf(i1)))
      {
        this.ay.add(Integer.valueOf(i1));
        ((altq)this.app.getManager(36)).jq(i1, 30);
      }
    }
  }
  
  private void bPD()
  {
    this.uh.setOnClickListener(null);
    this.uh.setClickable(false);
    this.jdField_a_of_type_Aogs.ch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.cgR = 0;
    if (AppSetting.enableTalkBack) {
      if (ThemeUtil.isInNightMode(this.app)) {
        break label66;
      }
    }
    label66:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      aqcl.changeAccessibilityForView(this.uh, str, Button.class.getName());
      return;
    }
  }
  
  private void bTA()
  {
    View localView = this.jdField_p_of_type_ArrayOfAndroidViewView[12];
    if (localView != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.app.getCurrentAccountUin(), 4);
      if (!((SharedPreferences)localObject).getBoolean("drawerEnable", false)) {
        break label155;
      }
      String str = ((SharedPreferences)localObject).getString("drawerText", "");
      this.aPe = ((SharedPreferences)localObject).getString("drawerTextID", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label141;
      }
      localView.setVisibility(0);
      if (acha.isLocaleCN()) {
        ((TextView)localView.findViewById(2131369534)).setText(str);
      }
    }
    return;
    label141:
    localView.setVisibility(8);
    this.aPe = "";
    return;
    label155:
    localView.setVisibility(8);
    this.aPe = "";
  }
  
  private void bTB()
  {
    View localView = this.jdField_p_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (afdl.d(this.app, true))
      {
        String str = this.app.getApp().getSharedPreferences("call_tim_config_pre" + this.app.getCurrentUin(), 0).getString("call_tim_config_title", this.app.getApp().getString(2131701608));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131369534)).setText(str);
        anot.a(this.app, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void bTD()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.bTD();
    }
  }
  
  private void bTF()
  {
    this.qT.post(new QQSettingMe.9(this));
  }
  
  private void bTH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!SonicPreloader.isWifiOrG3OrG4()) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject2 = SonicPreloader.getSonicPreloadDataList(this.n, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(this.g, 1000);
      Object localObject1 = SonicPreloader.getSonicPreloadDataList(this.f, 1001);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if ((localObject2 != null) && (((SparseArray)localObject2).size() > 0))
      {
        int i1 = 0;
        if (i1 < ((SparseArray)localObject2).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject2).valueAt(i1);
          if (1000 == localSonicPreloadData.id)
          {
            localSonicPreloadData.url = this.aPd;
            localArrayList1.add(localSonicPreloadData);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (1001 == localSonicPreloadData.id)
            {
              localSonicPreloadData.url = aqqj.getUrl("personalIndex");
              localArrayList1.add(localSonicPreloadData);
            }
          }
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject2 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject2).url = this.aPd;
        localArrayList2.add(localObject2);
      }
      if ((localObject1 != null) && (((SparseArray)localObject1).size() > 0))
      {
        localObject1 = (SonicPreloadData)((SparseArray)localObject1).valueAt(0);
        ((SonicPreloadData)localObject1).url = aqqj.getUrl("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.app.getManager(13);
      if (((WebProcessManager)localObject1).U(localArrayList1)) {
        ((altq)this.app.getManager(36)).OS(String.valueOf("200010.200012"));
      }
      if (((WebProcessManager)localObject1).U(localArrayList2)) {
        this.g.preload_ts.set(System.currentTimeMillis());
      }
      if (((WebProcessManager)localObject1).U(localArrayList3)) {
        this.f.preload_ts.set(System.currentTimeMillis());
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "preloadSonicSession parse cost: " + (System.currentTimeMillis() - l1));
  }
  
  private void bTJ()
  {
    a(this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.f);
    a(this.g);
    a(this.h);
    a(this.i);
    a(this.j);
    a(this.k);
    a(this.o);
    a(this.jdField_p_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.q);
  }
  
  private void bTM()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.Fj == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateTalent error");
      }
      return;
    }
    String str1;
    if (this.jdField_d_of_type_ComTencentMobileqqDataCard.allowPeopleSee) {
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard.lLoginDays < 10000L) {
        str1 = String.format(acfp.m(2131701645), new Object[] { Long.valueOf(this.jdField_d_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(acfp.m(2131701689), new Object[] { Long.valueOf(this.jdField_d_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = acfp.m(2131701646))
    {
      this.Fj.setText(str1);
      aqcl.changeAccessibilityForView(this.uo, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = acfp.m(2131701688);
    }
  }
  
  private void bTT()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.c(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.aZR;
        this.aZR = this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.aux();
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, "updateHeadIcon, old:" + bool + " new:" + this.aZR);
        }
        if (bool != this.aZR) {
          bUf();
        }
        return;
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.e(this.m);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void bTU()
  {
    Object localObject2 = (akjp)this.app.getManager(160);
    Object localObject1 = ((akjp)localObject2).a(-4);
    if ((((akjp)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.um.findViewById(2131372834);
        localImageView = (ImageView)this.um.findViewById(2131368375);
        localTextView = (TextView)this.um.findViewById(2131371989);
        localView = this.um.findViewById(2131369517);
        if (!ThemeUtil.isInNightMode(this.app)) {
          break label385;
        }
        ((View)localObject2).setBackgroundResource(2130846966);
      }
      for (;;)
      {
        Object localObject3 = aqhu.c(true);
        localObject3 = aqdj.a(this.app, 1, l1 + "", 4, (Drawable)localObject3, (Drawable)localObject3);
        Drawable localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject3) && ((localDrawable instanceof aqdj))) {
          ((aqdj)localDrawable).cancel();
        }
        localImageView.setImageDrawable((Drawable)localObject3);
        localObject1 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131701627, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new vpk(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.um.setVisibility(0);
        anot.a(this.app, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label385:
        ((View)localObject2).setBackgroundResource(2130846965);
      }
    }
    this.um.setVisibility(8);
    ((ImageView)this.um.findViewById(2131368375)).setImageDrawable(null);
  }
  
  private void bTW()
  {
    Object localObject = this.jdField_p_of_type_ArrayOfAndroidViewView[7];
    String str = QzoneConfig.getInstance().getConfig("sweet_miniapp", "entrance", "0");
    if (localObject != null)
    {
      if ((this.app == null) || (TextUtils.isEmpty(str)) || ("0".equals(str))) {
        break label116;
      }
      ((View)localObject).setVisibility(0);
      localObject = this.app.getPreferences();
      if (localObject != null)
      {
        if (((SharedPreferences)localObject).getInt("love_state_for_current_uin" + this.app.getCurrentUin(), 0) != 1) {
          break label111;
        }
        bUk();
      }
    }
    return;
    label111:
    bUl();
    return;
    label116:
    ((View)localObject).setVisibility(8);
    bUl();
  }
  
  private void bTX()
  {
    Object localObject = this.jdField_p_of_type_ArrayOfAndroidViewView[7];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = aiwk.a(this.jdField_p_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      int i1 = aiwk.dp((String)localObject);
      aiwk.K("10", i1 + "", "1", LpReportInfo_dc03950.getReportUserType(this.app));
      this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setRedDotData(this.jdField_p_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        dp("0x800AAFA", "1");
      }
    }
    else
    {
      return;
    }
    dp("0x800AAFA", "2");
    a(7, this.jdField_p_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void bTY()
  {
    View localView = this.jdField_p_of_type_ArrayOfAndroidViewView[10];
    if ((localView != null) && (this.app != null))
    {
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1) == 0) {
        localView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localView.setVisibility(0);
  }
  
  private void bTZ()
  {
    int i1 = 0;
    Object localObject = this.jdField_p_of_type_ArrayOfAndroidViewView[10];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    try
    {
      a(10, this.q);
      localObject = this.app;
      if (RedTouch.c(this.q)) {
        i1 = 1;
      }
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800ACDC", "0X800ACDC", 0, i1, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bTz()
  {
    if (this.aZT) {
      return;
    }
    this.ul.getViewTreeObserver().addOnGlobalLayoutListener(new vps(this));
  }
  
  private void bUc()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[1].findViewById(2131369518);
      localTextView.setOnClickListener(this.dt);
      vpl localvpl = new vpl(this, localTextView);
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl);
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_density", 320);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mExtraInfo = localObject2;
        localObject2 = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
        localTextView.setBackgroundDrawable((Drawable)localObject1);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          localvpl.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(localvpl);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
  }
  
  private void bUd()
  {
    try
    {
      a(12, this.o);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bUe()
  {
    try
    {
      String str = this.app.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.app.getCurrentAccountUin() + "_" + acha.Ax(), "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[1].findViewById(2131369534);
        if (localTextView != null) {
          localTextView.setText(str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQSettingRedesign", 1, "updateVipText exception, e = ", localException);
    }
  }
  
  private void bUj()
  {
    Object localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    String str1 = ((SharedPreferences)localObject1).getString("drawer_cur_temp", null);
    Object localObject3 = ((SharedPreferences)localObject1).getString("drawer_cur_city", null);
    int i1 = ((SharedPreferences)localObject1).getInt("drawer_cur_adcode", 0);
    String str2 = ((SharedPreferences)localObject1).getString("drawer_cur_code", null);
    boolean bool = ((SharedPreferences)localObject1).getBoolean("drawer_show_flag", false);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateWeatherView cur_temp:" + str1 + ",cur_areainfo" + (String)localObject3 + ",cur_adcode:" + i1 + ",o_wea_code" + str2 + ",show_flag:" + bool);
    }
    if (!bool)
    {
      this.gr.setVisibility(8);
      this.gr.setClickable(false);
      this.Fn.setVisibility(4);
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
      return;
    }
    this.gr.setVisibility(0);
    this.Fn.setVisibility(0);
    this.gr.setClickable(true);
    this.Fk.setText(str1);
    localObject1 = ((String)localObject3).split("-");
    TextView localTextView = this.Fn;
    if (localObject1.length == 2) {
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      try
      {
        localObject1 = URLEncoder.encode((String)localObject3, "utf-8").toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("&city=").append((String)localObject1).append("&adcode=").append(i1);
        this.Fn.setTag(((StringBuilder)localObject3).toString());
        this.Fm.setText("o");
        wh(str1);
        wi(str2);
        return;
        localObject1 = localObject1[0];
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
        }
      }
    }
  }
  
  private void bUk()
  {
    Iterator localIterator = acch.xg.iterator();
    while (localIterator.hasNext())
    {
      acch.a locala = (acch.a)localIterator.next();
      if ((locala instanceof achd)) {
        ((achd)locala).bUk();
      }
    }
  }
  
  private void bUl()
  {
    Iterator localIterator = acch.xg.iterator();
    while (localIterator.hasNext())
    {
      acch.a locala = (acch.a)localIterator.next();
      if ((locala instanceof achd)) {
        ((achd)locala).bUl();
      }
    }
  }
  
  private void bUo()
  {
    Object localObject = (akjp)this.app.getManager(160);
    RedTouchItem localRedTouchItem1 = ((akjp)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((akjp)localObject).a(10016);
    int i1;
    if ((akka.bg(this.app)) && ((((akjp)localObject).a(localRedTouchItem1, false)) || (((akjp)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((akjp)localObject).GR();
        localObject = null;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        anot.a(this.app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      return;
      i1 = 0;
      break;
      localObject = "0X8007392";
      continue;
      localObject = "0X8007397";
      continue;
      localObject = "0X80073B8";
    }
  }
  
  private void bUq()
  {
    afdl.aq(this.app);
  }
  
  public static boolean bt(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    return (localCalendar2.get(1) == localCalendar1.get(1)) && (localCalendar2.get(6) - localCalendar1.get(6) == 0);
  }
  
  private void dp(String paramString1, String paramString2)
  {
    anot.a(this.app, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", "", "");
  }
  
  private void wb(String paramString)
  {
    Object localObject1;
    if (this.cW == null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.ul.getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.removeView(this.ul);
      FrameLayout localFrameLayout = new FrameLayout(this.cV.getContext());
      Object localObject2 = new ViewGroup.MarginLayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.ul, (ViewGroup.LayoutParams)localObject1);
      localObject2 = new FrameLayout(this.cV.getContext());
      localFrameLayout.addView((View)localObject2, new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams)localObject1));
      this.cW = ((ViewGroup)localObject2);
    }
    if (this.uq == null)
    {
      localObject1 = new TextView(this.cV.getContext());
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(1, 12.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundResource(2130845584);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.cW.addView((View)localObject1, paramString);
      this.uq = ((View)localObject1);
      this.uq.setVisibility(8);
    }
  }
  
  private void wf(String paramString)
  {
    boolean bool1;
    boolean bool2;
    label84:
    int i2;
    label97:
    long l1;
    int i4;
    boolean bool3;
    Object localObject;
    int i1;
    String str;
    try
    {
      if ((this.jdField_d_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.qP == null))
      {
        if (!QLog.isColorLevel()) {
          break label1656;
        }
        QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
        return;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      localResources = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
        break label1056;
      }
      bool1 = true;
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
        break label1062;
      }
      bool2 = true;
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
        break label1068;
      }
      i2 = 1;
      l1 = this.jdField_d_of_type_ComTencentMobileqqDataCard.uCurMulType;
      i4 = this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_d_of_type_ComTencentMobileqqDataCard.uCurMulType);
      }
      this.qP.setVisibility(8);
      bool3 = VipUtils.b.my(this.jdField_d_of_type_ComTencentMobileqqDataCard.nameplateVipType);
      localObject = null;
      i1 = 0;
      if (!bool3) {
        break label1657;
      }
      localObject = VipUtils.b.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, VipUtils.b.a.a(this.jdField_d_of_type_ComTencentMobileqqDataCard.nameplateVipType), VipUtils.b.mz(this.jdField_d_of_type_ComTencentMobileqqDataCard.grayNameplateFlag));
      i1 = VipUtils.b.a(VipUtils.b.a.a(this.jdField_d_of_type_ComTencentMobileqqDataCard.nameplateVipType));
    }
    catch (Throwable paramString)
    {
      SpannableStringBuilder localSpannableStringBuilder;
      Resources localResources;
      paramString.printStackTrace();
      return;
    }
    if (bool2)
    {
      i1 = VipUtils.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
      paramString = VipUtils.b.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_d_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
      i1 = 2130847937;
      i2 = 1;
      localObject = str;
    }
    for (;;)
    {
      label345:
      int i3 = i1;
      str = paramString;
      if (!bool3)
      {
        i3 = i1;
        str = paramString;
        if (i2 == 0)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1450;
          }
          QLog.e("QQSettingRedesign", 1, (String)localObject);
          label383:
          if (!bool1) {
            break label1481;
          }
          i1 = VipUtils.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          str = VipUtils.b.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_d_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          i3 = 2130847938;
        }
      }
      label437:
      if ((str != null) && (i3 != 0))
      {
        VipUtils.b(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.qP, str, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i3));
        this.qP.setVisibility(0);
        this.qP.setContentDescription(acfp.m(2131716834));
        this.qP.setFocusableInTouchMode(true);
        paramString = VipUtils.b.b.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, "VIA_SETTINGME");
        paramString.KR();
        this.qP.setOnTouchListener(paramString);
        if (this.qP.getVisibility() == 0)
        {
          i1 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298881);
          this.bKa = (ankt.SCREEN_WIDTH - ankt.dip2px(94.0F) - i1 - ankt.dip2px(45.0F) - ankt.dip2px(45.0F));
          this.mNickName.setMaxWidth(this.bKa);
        }
        if (aqrt.a().e(bool1, this.jdField_d_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
          localSpannableStringBuilder.append(aqeu.a(this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources, this.jdField_d_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_d_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_d_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
        }
        i2 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
          break label1578;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
        this.ue.setVisibility(0);
        this.uf.setVisibility(0);
        if (!ThemeUtil.isNowThemeIsDefault(this.app, true, null)) {
          break label1555;
        }
        this.ue.setBackgroundColor(Color.parseColor("#7bffffff"));
        label738:
        i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * rpq.dip2px(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - rpq.dip2px(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
        }
        i1 = i2;
        if (!this.aZN)
        {
          this.aZN = true;
          i1 = acny.e(this.app, this.app.getCurrentUin(), false);
          anot.a(this.app, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
          i1 = i2;
        }
        label889:
        localSpannableStringBuilder.append(aqeu.a(localResources, this.jdField_d_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQLevel, eQ(i1)));
        this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQLevel);
        h(bool1, bool2, i4);
        if (!AppSetting.enableTalkBack) {
          break label1656;
        }
        paramString = new StringBuilder();
        paramString.append(this.aPb);
        if (!bool1) {
          break label1628;
        }
        paramString.append("你是尊贵的超级会员");
        label1010:
        if (this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
          paramString.append(" 等级").append(this.jdField_d_of_type_ComTencentMobileqqDataCard.iQQLevel);
        }
        this.uc.setContentDescription(paramString.toString());
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label84;
        i2 = 0;
        break label97;
        str = "occur error: curMulType=" + l1 + " but bQQVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        continue;
      }
      label534:
      label1056:
      label1062:
      label1578:
      for (;;)
      {
        label1068:
        label1114:
        if (bool1)
        {
          i2 = VipUtils.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          if ((i2 & 0xF) != 1) {
            break label1717;
          }
          i1 = 1;
          label1147:
          paramString = VipUtils.b.a((i2 & 0xF) << 8 | i2 >> 8, i4, this.jdField_d_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          if (i1 == 0) {
            break label1722;
          }
          i1 = 2130847938;
          break label1708;
        }
        str = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        break label345;
        label1450:
        label1481:
        label1628:
        label1656:
        label1657:
        do
        {
          if (l1 == 6L)
          {
            if (i2 != 0)
            {
              i2 = VipUtils.a(this.app, paramString, false);
              if (i2 >> 8 == 3)
              {
                if ((i2 & 0xF) == 1)
                {
                  i1 = VipUtils.a(this.app, paramString, EVIPSPEC.E_SP_BIGCLUB);
                  paramString = VipUtils.b.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_d_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_d_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                  i1 = 2130847938;
                  break label1729;
                }
                i1 = VipUtils.a(this.app, paramString, EVIPSPEC.E_SP_BIGCLUB);
                paramString = VipUtils.b.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_d_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_d_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                i1 = 2130847936;
                break label1729;
              }
              str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i2;
              i2 = i1;
              paramString = (String)localObject;
              localObject = str;
              i1 = i3;
              break label1740;
            }
            str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen is false";
            i2 = 0;
            paramString = (String)localObject;
            localObject = str;
            break label345;
            QLog.e("QQSettingRedesign", 1, "it have not handle curMulType=" + l1);
            break label383;
            i3 = i1;
            str = paramString;
            if (!bool2) {
              break label437;
            }
            i1 = VipUtils.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
            str = VipUtils.b.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_d_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
            i3 = 2130847937;
            break label437;
            this.qP.setOnTouchListener(null);
            break label534;
            this.ue.setBackgroundColor(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166729));
            break label738;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
            this.ue.setVisibility(8);
            this.uf.setVisibility(8);
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label889;
            }
            QLog.d("QVipSettingMe.", 1, "medal list is null");
            i1 = i2;
            break label889;
            if (!bool2) {
              break label1010;
            }
            paramString.append("你是尊贵的会员");
            break label1010;
          }
          do
          {
            i2 = 0;
            paramString = (String)localObject;
            localObject = str;
            break;
            return;
            i3 = 0;
            str = null;
          } while (bool3);
          if ((l1 == 1L) || (l1 == 2L)) {
            break;
          }
          if (l1 == 3L) {
            break label1114;
          }
        } while (l1 != 4L);
      }
      for (;;)
      {
        label1555:
        label1708:
        i2 = 1;
        localObject = str;
        break;
        label1717:
        i1 = 0;
        break label1147;
        label1722:
        i1 = 2130847936;
      }
      label1729:
      localObject = null;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      label1740:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  private void wg(String paramString)
  {
    long l1 = System.currentTimeMillis();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.app.getManager(36)).getAppInfoByPath(String.valueOf(100400));
    Object localObject;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.exposure_max.get() >= 0)) {
      localObject = localAppInfo.buffer.get();
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i2;
      try
      {
        localObject = new JSONObject((String)localObject).optString("_jump_url");
        localStringBuilder = new StringBuilder();
        i2 = aqiw.getSystemNetwork(this.app.getApp().getApplicationContext());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label499;
        }
        localObject = this.aPd;
        i1 = 1;
        if (((String)localObject).contains("?")) {
          break label453;
        }
        localStringBuilder.append((String)localObject + "?platform=1&type=20001&networkInfo=" + i2);
        localObject = localStringBuilder.toString();
        localObject = ((altq)this.app.getManager(36)).b((String)localObject, localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label493;
        }
        bool = true;
        if ((paramString == null) || (i1 == 0)) {
          break label487;
        }
        paramString = (String)localObject + paramString;
        localObject = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
        ((Intent)localObject).putExtra("startOpenPageTime", l1);
        ((Intent)localObject).putExtra("portraitOnly", true);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("has_red_dot", bool);
        ((Intent)localObject).putExtra("leftBtnText", this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689606));
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
        paramString = (altq)this.app.getManager(36);
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler gotoOpenCenterBrowser");
        paramString.jq(100400, 31);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 2, "parse json exception " + localException);
      }
      String str = "";
      continue;
      label453:
      localStringBuilder.append(str + "&platform=1&type=20001&networkInfo=" + i2);
      continue;
      label487:
      paramString = str;
      continue;
      label493:
      boolean bool = false;
      continue;
      label499:
      int i1 = 0;
    }
  }
  
  private void wh(String paramString)
  {
    if ((this.Fk == null) || (this.Fn == null) || (this.Fl == null) || (this.Fm == null) || (this.gr == null) || (this.up == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.Fl.setVisibility(8);
    int i1;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1, paramString.length());
      this.Fl.setVisibility(0);
      this.Fl.setText("-");
      this.Fl.measure(0, 0);
      i1 = this.Fl.getMeasuredWidth();
      this.Fk.setText(paramString);
    }
    for (;;)
    {
      this.Fk.measure(0, 0);
      this.Fn.measure(0, 0);
      this.gr.measure(0, 0);
      this.Fm.measure(0, 0);
      int i4 = this.Fk.getMeasuredWidth();
      int i3 = this.gr.getMeasuredWidth();
      int i2 = (i3 - i4 - i1 - this.Fm.getMeasuredWidth()) / 2;
      i4 /= 2;
      i3 /= 2;
      paramString = (LinearLayout.LayoutParams)this.up.getLayoutParams();
      paramString.leftMargin = (i3 - (i1 + i2 + i4));
      this.up.setLayoutParams(paramString);
      return;
      i1 = 0;
    }
  }
  
  private void wi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：").append(this.Fn.getText()).append("，天气：");
      if (!paramString.equals("201")) {
        break label100;
      }
      localStringBuilder.append("晴");
    }
    for (;;)
    {
      localStringBuilder.append("，温度：").append(this.Fk.getText()).append("摄氏度");
      if ((AppSetting.enableTalkBack) && (localStringBuilder != null)) {
        this.gr.setContentDescription(localStringBuilder.toString());
      }
      return;
      label100:
      if (paramString.equals("202")) {
        localStringBuilder.append("多云");
      } else if (paramString.equals("203")) {
        localStringBuilder.append("阴");
      } else if (paramString.equals("204")) {
        localStringBuilder.append("雨");
      } else if (paramString.equals("205")) {
        localStringBuilder.append("雪");
      } else if (paramString.equals("206")) {
        localStringBuilder.append("雾");
      } else if (paramString.equals("207")) {
        localStringBuilder.append("沙尘");
      } else if (paramString.equals("208")) {
        localStringBuilder.append("霾");
      } else {
        localStringBuilder.append("未知");
      }
    }
  }
  
  private void wj(String paramString)
  {
    anot.a(this.app, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void xS(boolean paramBoolean)
  {
    ThreadManager.post(new QQSettingMe.12(this), 5, null, false);
  }
  
  public void Br(int paramInt)
  {
    QQToast.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).show(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public auvn a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (auvn)this.cU.get(paramString);
  }
  
  public DrawerFrame a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.b;
    }
    return null;
  }
  
  public void a(String paramString, auvn paramauvn)
  {
    if (paramauvn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.cU.put(paramString, paramauvn);
  }
  
  int[] a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new int[] { 2130846978, 2130846992, 2130846976, 2130846988, 2130846994, 2130846996, 2130846998, 2130846949, 2130846981, 2130846974, 2130846972, 2130846979, 2130846945, 2130846990 };
    }
    return new int[] { 2130846978, 2130846993, 2130846977, 2130846989, 2130846995, 2130846997, 2130846999, 2130846949, 2130846982, 2130846975, 2130846972, 2130846980, 2130846946, 2130846990 };
  }
  
  public void aJ(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.isInited);
    }
    if (this.isInited)
    {
      removeObserver();
      this.app = paramQQAppInterface;
      addObserver();
      this.jdField_a_of_type_Aogs.m(paramQQAppInterface);
      bTL();
      bUg();
      bTU();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.bHo();
      }
      return;
    }
    this.app = paramQQAppInterface;
  }
  
  protected void addObserver()
  {
    if (this.app != null)
    {
      this.app.addObserver(this.jdField_b_of_type_Accz, false);
      this.app.addObserver(this.jdField_c_of_type_Acfd, true);
      this.app.addObserver(this.cardObserver, true);
      this.app.registObserver(this.jdField_e_of_type_Aklk);
      this.app.addObserver(this.jdField_a_of_type_Acnz, true);
      this.app.addObserver(this.jdField_d_of_type_Aclh, true);
      this.app.addObserver(this.jdField_a_of_type_Achf, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.e);
      }
      this.jdField_a_of_type_Aogs.a(this.jdField_a_of_type_Aogs$a, true);
      this.jdField_a_of_type_Abcy = ((abcy)this.app.getManager(114));
      if (this.jdField_a_of_type_Abcy != null) {
        this.jdField_a_of_type_Abcy.a(this.jdField_a_of_type_Abcy$a);
      }
      aqrt.a().a(this.jdField_a_of_type_Aqrt$a);
      sxa.a().a(this.jdField_a_of_type_Sxa$a);
    }
  }
  
  @TargetApi(9)
  void b(RichStatus paramRichStatus)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    ImageView localImageView1 = (ImageView)this.ug.findViewById(2131377255);
    TextView localTextView = (TextView)this.ug.findViewById(2131377256);
    ImageView localImageView2 = (ImageView)this.ug.findViewById(2131368715);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    StringBuilder localStringBuilder = new StringBuilder(100);
    SharedPreferences.Editor localEditor;
    label272:
    Object localObject1;
    if (ThemeUtil.isNowThemeIsDefault(this.app, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.bKb);
      localEditor = this.app.getApp().getSharedPreferences("qqsettingme_signature" + this.app.getAccount(), 0).edit();
      if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label515;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_Amhj.i(paramRichStatus.actionId, 200));
      localImageView1.setVisibility(0);
      localStringBuilder.append(paramRichStatus.actionText);
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      localStringBuilder.append(' ');
      localEditor.putInt("actionId", paramRichStatus.actionId);
      localEditor.putString("actionText", paramRichStatus.actionText);
      localEditor.putString("dataText", paramRichStatus.dataText);
      if (paramRichStatus != null)
      {
        if (!paramRichStatus.hasTopic()) {
          break label548;
        }
        if (paramRichStatus.shouldShowAtHead())
        {
          localObject1 = paramRichStatus.topicToPlainText();
          localStringBuilder.append((String)localObject1);
          localEditor.putString("topics", (String)localObject1);
          localObject1 = localObject2;
          if (paramRichStatus.plainText != null)
          {
            localObject1 = localObject2;
            if (paramRichStatus.plainText.size() > 0) {
              localObject1 = (String)paramRichStatus.plainText.get(0);
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder.append((String)localObject1);
          }
          localEditor.putString("plainText", (String)localObject1);
        }
        if (paramRichStatus.shouldShowMixing())
        {
          paramRichStatus = paramRichStatus.getPlainText();
          localStringBuilder.append(paramRichStatus);
          localEditor.putString("plainMixTopic", paramRichStatus);
        }
      }
      label404:
      if (Build.VERSION.SDK_INT <= 8) {
        break label612;
      }
      localEditor.apply();
      label419:
      paramRichStatus = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramRichStatus)) {
        break label623;
      }
      localTextView.setText(2131701614);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.F.setLength(0);
        this.F.append("个性签名").append(paramRichStatus);
        this.ug.setContentDescription(this.F.toString());
      }
      if (anlm.ayn()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label515:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846970);
      localImageView1.setVisibility(8);
      break label272;
      label548:
      localObject1 = localObject3;
      if (paramRichStatus.plainText != null)
      {
        localObject1 = localObject3;
        if (paramRichStatus.plainText.size() > 0) {
          localObject1 = (String)paramRichStatus.plainText.get(0);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append((String)localObject1);
      }
      localEditor.putString("plainText", (String)localObject1);
      break label404;
      label612:
      localEditor.commit();
      break label419;
      label623:
      localImageView2.setVisibility(0);
      if (aqgz.aCD()) {
        localTextView.setText(new aofk(paramRichStatus + " ", 1, 16));
      } else {
        localTextView.setText(new aofk(paramRichStatus, 1, 16));
      }
    }
  }
  
  public void bPz()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_Aogs.KF();
    String str;
    if (i1 == 1) {
      if (this.aZS)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130846963);
        str = ((Resources)localObject2).getString(2131701647);
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.qR.setImageDrawable((Drawable)localObject2);
      }
      if (localObject1 != null)
      {
        this.Fh.setText((CharSequence)localObject1);
        this.uh.setOnClickListener(this);
      }
      return;
      localObject1 = ((Resources)localObject2).getDrawable(2130846962);
      break;
      if (i1 == 2)
      {
        if (this.aZS) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130846963);; localObject1 = ((Resources)localObject2).getDrawable(2130846962))
        {
          str = ((Resources)localObject2).getString(2131701647);
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  void bTC()
  {
    int i1 = 1;
    if (this.jdField_p_of_type_ArrayOfAndroidViewView[4] == null) {}
    String str;
    do
    {
      return;
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.app.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0);
      int i2 = localSharedPreferences.getInt("qqsettingme_f2f_guide_switch", 0);
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", acfp.m(2131712156));
      boolean bool = localSharedPreferences.getBoolean("qqsettingme_f2f_guide_flag", false);
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, String.format("updateFace2FaceGuide switch_hasShowed = %d_%b", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool) }));
      }
      if ((i2 == 1) && (!bool)) {}
      while ((i1 == 0) && (this.uq != null))
      {
        this.uq.setVisibility(8);
        return;
        i1 = 0;
      }
    } while ((i1 == 0) || ((this.uq != null) && (this.uq.getVisibility() == 0)));
    wb(str);
    this.uiHandler.sendEmptyMessageDelayed(0, 50L);
  }
  
  public void bTE()
  {
    SosoInterface.a(new vqd(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
  }
  
  public void bTG()
  {
    ThreadManager.post(new QQSettingMe.13(this), 5, null, false);
  }
  
  public void bTI()
  {
    bTJ();
    bTT();
    bTU();
    bTN();
    bTO();
    bTS();
    bTV();
    bUi();
    bTP();
    bTK();
    bTQ();
    bTR();
    bTX();
    bTZ();
    bUm();
    bUd();
    bUq();
  }
  
  protected void bTK()
  {
    try
    {
      a(5, this.j);
      ((allp)this.app.getManager(104)).d(this.j);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void bTL()
  {
    String str = this.app.getCurrentAccountUin();
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(aqhu.at());
      this.mNickName.setText("");
      this.mNickName.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.qP.setVisibility(8);
      return;
    }
    wd(str);
    if (ThemeUtil.isNowThemeIsDefault(this.app, true, null)) {
      this.mNickName.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new QQSettingMe.14(this, str), null, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from updateAccountInfo");
      }
      we(str);
      this.F.setLength(0);
      this.F.append(this.aPb);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      this.uc.setContentDescription(this.F.toString());
      return;
      this.mNickName.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  public void bTN()
  {
    boolean bool2 = true;
    boolean bool1 = aqap.bW(this.app);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView.showRedDot(bool1);
    }
    if ((!bool1) && (aciu.ix(1)))
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetRedDotTextView.showRedDot(true);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (!bool1) {
        this.y.g(this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
      return;
    }
  }
  
  protected void bTO()
  {
    try
    {
      a(2, this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void bTP()
  {
    try
    {
      this.x.e(this.i);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void bTQ()
  {
    try
    {
      a(3, this.k);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void bTR()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.app.getManager(36)).getAppInfoByPath(String.valueOf(1000017));
      if (!((adyp)this.app.getManager(112)).afT())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo1.red_type.set(9);
        localRedTypeInfo1.red_content.set("-1");
        localRedTypeInfo1.red_desc.set("");
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo2.red_type.set(0);
        localAppInfo.iNewFlag.set(1);
        localAppInfo.red_display_info.red_type_info.clear();
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo1);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo2);
        return;
      }
      localAppInfo.iNewFlag.set(0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void bTS()
  {
    try
    {
      a(6, this.f);
      if ((this.app != null) && (this.f != null) && (this.f.iNewFlag.get() == 1))
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
        if (localWebProcessManager != null) {
          localWebProcessManager.egu();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public void bTV()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5: invokevirtual 1475	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   8: putfield 2797	com/tencent/mobileqq/activity/QQSettingMe:aPc	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 2797	com/tencent/mobileqq/activity/QQSettingMe:aPc	Ljava/lang/String;
    //   16: invokestatic 2800	acny:a	(Ljava/lang/String;)LMQQ/PayRuleCfg;
    //   19: putfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   22: aload_0
    //   23: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: aload_0
    //   27: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   30: aload_0
    //   31: getfield 2802	com/tencent/mobileqq/activity/QQSettingMe:aZO	Z
    //   34: invokestatic 2805	acny:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LMQQ/PayRuleCfg;Z)Z
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   42: ifnonnull +271 -> 313
    //   45: ldc_w 367
    //   48: iconst_1
    //   49: ldc_w 2807
    //   52: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload_1
    //   56: ifeq +345 -> 401
    //   59: aload_0
    //   60: getfield 2802	com/tencent/mobileqq/activity/QQSettingMe:aZO	Z
    //   63: ifne +64 -> 127
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 2802	com/tencent/mobileqq/activity/QQSettingMe:aZO	Z
    //   71: aconst_null
    //   72: ldc_w 1706
    //   75: ldc_w 262
    //   78: ldc_w 262
    //   81: ldc_w 262
    //   84: ldc_w 2809
    //   87: aload_0
    //   88: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   91: invokestatic 2812	acny:a	(LMQQ/PayRuleCfg;)I
    //   94: iconst_1
    //   95: iconst_0
    //   96: ldc_w 1746
    //   99: aload_0
    //   100: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   103: getfield 2815	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   106: ldc_w 262
    //   109: ldc_w 262
    //   112: invokestatic 2818	anot:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   115: bipush 101
    //   117: aload_0
    //   118: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   121: getfield 2815	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   124: invokestatic 2822	acny:cf	(ILjava/lang/String;)V
    //   127: aload_0
    //   128: invokespecial 2824	com/tencent/mobileqq/activity/QQSettingMe:bUc	()V
    //   131: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +36 -> 170
    //   137: ldc_w 367
    //   140: iconst_2
    //   141: new 380	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 2826
    //   151: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 1521	com/tencent/mobileqq/activity/QQSettingMe:g	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   158: invokestatic 2828	altq:d	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/lang/String;
    //   161: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 530	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 659	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: new 1197	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   173: dup
    //   174: invokespecial 1248	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   177: astore_2
    //   178: aload_2
    //   179: aload_0
    //   180: getfield 1521	com/tencent/mobileqq/activity/QQSettingMe:g	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   183: invokevirtual 1251	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   186: iload_1
    //   187: ifeq +54 -> 241
    //   190: aload_2
    //   191: invokestatic 2831	com/tencent/mobileqq/redtouch/RedTouchTextView:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/util/List;
    //   194: ifnull +47 -> 241
    //   197: new 176	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 179	java/util/ArrayList:<init>	()V
    //   204: astore_3
    //   205: new 1061	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   208: dup
    //   209: invokespecial 1062	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: getfield 1068	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: iconst_0
    //   220: invokevirtual 1073	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   223: aload_3
    //   224: aload 4
    //   226: invokevirtual 1304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: aload_2
    //   231: getfield 1263	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   234: getfield 1272	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   237: aload_3
    //   238: invokevirtual 1303	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   241: aload_0
    //   242: iconst_1
    //   243: aload_2
    //   244: invokespecial 1767	com/tencent/mobileqq/activity/QQSettingMe:a	(ILcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   247: aload_0
    //   248: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   251: ifnull +61 -> 312
    //   254: aload_0
    //   255: getfield 1521	com/tencent/mobileqq/activity/QQSettingMe:g	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   258: ifnull +163 -> 421
    //   261: aload_0
    //   262: getfield 1521	com/tencent/mobileqq/activity/QQSettingMe:g	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   265: getfield 1255	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   268: invokevirtual 1259	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   271: iconst_1
    //   272: if_icmpeq +6 -> 278
    //   275: goto +146 -> 421
    //   278: ldc_w 367
    //   281: iconst_1
    //   282: ldc_w 2833
    //   285: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: new 2298	android/content/Intent
    //   291: dup
    //   292: aload_0
    //   293: getfield 374	com/tencent/mobileqq/activity/QQSettingMe:jdField_c_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   296: ldc_w 2835
    //   299: invokespecial 2303	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   302: astore_2
    //   303: aload_0
    //   304: getfield 374	com/tencent/mobileqq/activity/QQSettingMe:jdField_c_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   307: aload_2
    //   308: invokevirtual 2839	com/tencent/mobileqq/app/BaseActivity:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   311: pop
    //   312: return
    //   313: ldc_w 367
    //   316: iconst_1
    //   317: new 380	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 2841
    //   327: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   334: getfield 1800	MQQ/PayRuleCfg:iconText	Ljava/lang/String;
    //   337: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 2843
    //   343: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_1
    //   347: invokevirtual 1634	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   350: ldc_w 2845
    //   353: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 1173	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   360: getfield 1803	MQQ/PayRuleCfg:iconUrl	Ljava/lang/String;
    //   363: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 2847
    //   369: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 2802	com/tencent/mobileqq/activity/QQSettingMe:aZO	Z
    //   376: invokevirtual 1634	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: invokevirtual 530	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto -330 -> 55
    //   388: astore_2
    //   389: ldc_w 367
    //   392: iconst_1
    //   393: ldc_w 2849
    //   396: aload_2
    //   397: invokestatic 1365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: return
    //   401: aload_0
    //   402: invokevirtual 2852	com/tencent/mobileqq/activity/QQSettingMe:bUb	()V
    //   405: goto -274 -> 131
    //   408: astore_2
    //   409: ldc_w 367
    //   412: iconst_2
    //   413: ldc_w 2854
    //   416: aload_2
    //   417: invokestatic 1365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: return
    //   421: iload_1
    //   422: ifeq -110 -> 312
    //   425: goto -147 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	QQSettingMe
    //   37	385	1	bool	boolean
    //   177	131	2	localObject	Object
    //   388	9	2	localException	Exception
    //   408	9	2	localThrowable	Throwable
    //   204	34	3	localArrayList	ArrayList
    //   212	13	4	localRedTypeInfo	BusinessInfoCheckUpdate.RedTypeInfo
    // Exception table:
    //   from	to	target	type
    //   0	55	388	java/lang/Exception
    //   59	127	388	java/lang/Exception
    //   127	131	388	java/lang/Exception
    //   131	170	388	java/lang/Exception
    //   170	186	388	java/lang/Exception
    //   190	241	388	java/lang/Exception
    //   241	275	388	java/lang/Exception
    //   278	303	388	java/lang/Exception
    //   303	312	388	java/lang/Exception
    //   313	385	388	java/lang/Exception
    //   401	405	388	java/lang/Exception
    //   409	420	388	java/lang/Exception
    //   303	312	408	java/lang/Throwable
  }
  
  public void bUa()
  {
    if ((!TextUtils.isEmpty(this.aPc)) && (!this.aPc.equals(this.app.getCurrentAccountUin())))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler payRuleUin changed");
      bUb();
    }
  }
  
  public void bUb()
  {
    TextView localTextView = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[1].findViewById(2131369518);
    localTextView.setText("");
    localTextView.setBackgroundDrawable(null);
  }
  
  public void bUf()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.app.getManager(51)).a(this.app.getCurrentAccountUin(), false);
    if (anlm.ayn())
    {
      this.aj.setImageDrawable(null);
      this.aj.setVisibility(8);
    }
    label240:
    for (;;)
    {
      return;
      Object localObject;
      if ((!this.aZR) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        localObject = (AvatarPendantManager)this.app.getManager(46);
        ((AvatarPendantManager)localObject).eeO();
        this.aj.setVisibility(0);
        localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
        if (aqgm.cT(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.aj, 2, PendantInfo.ebR, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          anot.a(this.app, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 1) || (i1 != this.aZR)) {
          break label240;
        }
        this.app.reportClickEvent("CliOper", "0X8006728");
        return;
        ((PendantInfo)localObject).a(this.aj, 1, PendantInfo.ebR, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
        break;
        this.aj.setImageDrawable(null);
        this.aj.setVisibility(8);
      }
    }
  }
  
  public void bUg()
  {
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    if ((this.jdField_a_of_type_Amhj == null) || (this.ug == null)) {
      return;
    }
    if (this.jdField_a_of_type_Amfk == null)
    {
      this.jdField_a_of_type_Amfk = new vpn(this);
      this.jdField_b_of_type_Amfh = new vpo(this);
      this.jdField_a_of_type_Amff = new vpp(this);
      this.jdField_a_of_type_Amhj.addListener(this.jdField_a_of_type_Amfk);
      this.jdField_a_of_type_Amhj.addListener(this.jdField_b_of_type_Amfh);
      this.jdField_a_of_type_Amhj.addListener(this.jdField_a_of_type_Amff);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_Amhj.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.27(this));
      return;
    }
    b(localRichStatus);
  }
  
  void bUh()
  {
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    if (this.jdField_a_of_type_Amhj == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.ug.findViewById(2131377255);
    TextView localTextView = (TextView)this.ug.findViewById(2131377256);
    ImageView localImageView2 = (ImageView)this.ug.findViewById(2131368715);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    Object localObject1 = new StringBuilder(100);
    label117:
    Object localObject2;
    if (ThemeUtil.isNowThemeIsDefault(this.app, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.bKb);
      localObject2 = this.app.getApp().getSharedPreferences("qqsettingme_signature" + this.app.getAccount(), 0);
      String str1 = ((SharedPreferences)localObject2).getString("actionText", "");
      int i1 = ((SharedPreferences)localObject2).getInt("actionId", 0);
      String str2 = ((SharedPreferences)localObject2).getString("dataText", "");
      String str3 = ((SharedPreferences)localObject2).getString("plainText", "");
      String str4 = ((SharedPreferences)localObject2).getString("topics", "");
      localObject2 = ((SharedPreferences)localObject2).getString("plainMixTopic", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "preLoadSignature, actionText = " + str1 + " actionId = " + i1 + " dataText = " + str2 + " plainText = " + str3);
      }
      if (TextUtils.isEmpty(str1)) {
        break label513;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_Amhj.i(i1, 200));
      localImageView1.setVisibility(0);
      ((StringBuilder)localObject1).append(str1);
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject1).append(str2);
      }
      ((StringBuilder)localObject1).append(' ');
      label377:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label542;
      }
      if (!TextUtils.isEmpty(str4)) {
        ((StringBuilder)localObject1).append(str4);
      }
      if (!TextUtils.isEmpty(str3)) {
        ((StringBuilder)localObject1).append(str3);
      }
      label417:
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label553;
      }
      localTextView.setText(2131701614);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.F.setLength(0);
        this.F.append("个性签名").append((String)localObject1);
        this.ug.setContentDescription(this.F.toString());
      }
      if (!anlm.ayn()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label117;
      label513:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846970);
      localImageView1.setVisibility(8);
      break label377;
      label542:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label417;
      label553:
      localImageView2.setVisibility(0);
      if (aqgz.aCD()) {
        localTextView.setText((String)localObject1 + " ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
    }
  }
  
  protected void bUi()
  {
    try
    {
      a(4, this.h);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void bUm()
  {
    bUn();
    this.aZM = true;
  }
  
  protected void bUn()
  {
    localObject8 = null;
    Object localObject14 = null;
    String str1 = null;
    localObject13 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    localObject1 = acfp.m(2131712167);
    i1 = 0;
    int i3 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298881);
    int i4 = ankt.SCREEN_WIDTH;
    int i5 = ankt.dip2px(65.0F);
    int i6 = ankt.dip2px(15.0F);
    int i7 = this.qQ.getWidth();
    localSharedPreferences = this.app.getPreferences();
    l1 = localSharedPreferences.getLong("sign_in_time_stamp", 0L);
    str2 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_info", "");
    try
    {
      localObject2 = new JSONObject(str2);
      this.type = ((JSONObject)localObject2).optInt("type");
      i2 = ((JSONObject)localObject2).optInt("day");
      i1 = i2;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject10;
        label779:
        label1051:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + str2);
        }
        localJSONException1.printStackTrace();
        continue;
        localObject3 = null;
        i1 = 0;
        Object localObject5 = localObject1;
        localObject9 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "10", "");
        localObject5 = localObject1;
        Object localObject7 = localObject1;
        Object localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject9))
        {
          localObject5 = localObject1;
          localObject3 = new JSONObject((String)localObject9);
          i1 = 0;
          continue;
          localObject5 = localObject1;
          localObject1 = acfp.m(2131712160);
          localObject5 = localObject1;
          localObject3 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "41", "");
          localObject5 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject5 = localObject1;
            localObject3 = new JSONObject((String)localObject3);
            localObject5 = localObject1;
            l1 = ((JSONObject)localObject3).optInt("start_time");
            localObject5 = localObject1;
            l2 = ((JSONObject)localObject3).optInt("end_time");
            i1 = 1;
            localObject5 = localObject1;
            if (System.currentTimeMillis() > l1 * 1000L)
            {
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (System.currentTimeMillis() < l2 * 1000L) {}
            }
            else
            {
              localObject3 = null;
              i1 = 0;
              localObject5 = localObject1;
              localObject9 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "40", "");
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject9))
              {
                localObject5 = localObject1;
                localObject3 = new JSONObject((String)localObject9);
                i1 = 0;
              }
            }
          }
          else
          {
            localObject3 = null;
            i1 = 0;
            localObject5 = localObject1;
            localObject9 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "40", "");
            localObject5 = localObject1;
            localObject7 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject9))
            {
              localObject5 = localObject1;
              localObject3 = new JSONObject((String)localObject9);
              i1 = 0;
              continue;
              localObject1 = "";
              localObject3 = "";
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + str2);
              }
              ((JSONException)localObject5).printStackTrace();
              localObject5 = localObject8;
              continue;
              if (this.type == 1)
              {
                localObject1 = acfp.m(2131712167);
                localObject5 = null;
                localObject4 = null;
                continue;
              }
              if (this.type == 4)
              {
                localObject1 = acfp.m(2131712160);
                localObject5 = null;
                localObject4 = null;
                continue;
                localObject5 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject10);
                continue;
                if (QLog.isColorLevel()) {
                  QLog.i("DailySignIn", 2, "use default icon");
                }
                if (ThemeUtil.isNowThemeIsDefault(this.app, true, null))
                {
                  localObject5 = null;
                  try
                  {
                    localObject4 = BitmapFactory.decodeResource(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846990);
                    if (localObject4 == null) {
                      break label2157;
                    }
                    localObject7 = new BitmapDrawable(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources(), auqy.Y((Bitmap)localObject4));
                  }
                  catch (OutOfMemoryError localOutOfMemoryError)
                  {
                    for (;;)
                    {
                      localObject4 = localObject5;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
                        localObject4 = localObject5;
                      }
                    }
                  }
                  if ((this.jdField_d_of_type_ComTencentMobileqqDataCard != null) && ((aura.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_d_of_type_ComTencentMobileqqDataCard.isNoCover())))
                  {
                    ((TextView)localObject5).setTextColor(this.cV.getResources().getColor(2131166729));
                    continue;
                  }
                  ((TextView)localObject5).setTextColor(this.cV.getResources().getColor(2131166725));
                  continue;
                  ((TextView)localObject5).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
                  continue;
                  wj("0X800ACFB");
                  if (QLog.isColorLevel()) {
                    QLog.i("DailySignIn", 2, "use unsigned wording");
                  }
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  ((TextView)localObject7).setText((CharSequence)localObject1);
                  continue;
                }
              }
            }
          }
        }
        localObject1 = localJSONException4;
        continue;
        int i2 = i1;
      }
    }
    if (!bt(l1 * 1000L))
    {
      this.type = 1;
      i2 = 0;
      if (acha.Ax() != 1033)
      {
        localObject5 = localObject1;
        try
        {
          if (this.type == 1)
          {
            localObject5 = localObject1;
            localObject2 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "11", "");
            localObject5 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject5 = localObject1;
              localObject2 = new JSONObject((String)localObject2);
              localObject5 = localObject1;
              l1 = ((JSONObject)localObject2).optInt("start_time");
              localObject5 = localObject1;
              l2 = ((JSONObject)localObject2).optInt("end_time");
              i1 = 1;
              localObject5 = localObject1;
              if (System.currentTimeMillis() > l1 * 1000L)
              {
                localObject5 = localObject1;
                localObject7 = localObject1;
                if (System.currentTimeMillis() < l2 * 1000L) {
                  break label2169;
                }
              }
              localObject2 = null;
              i1 = 0;
              localObject5 = localObject1;
              localObject9 = localSharedPreferences.getString(this.app.getCurrentUin() + "sign_in_operation" + "10", "");
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject9)) {
                break label2169;
              }
              localObject5 = localObject1;
              localObject2 = new JSONObject((String)localObject9);
              i1 = 0;
              localObject9 = localObject1;
              localObject12 = localObject16;
              localObject11 = str1;
              if (localObject2 != null)
              {
                localObject10 = localObject1;
                localObject8 = localObject15;
                localObject7 = localObject14;
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          long l2;
          Object localObject9;
          Object localObject12;
          Object localObject11;
          Object localObject3;
          localObject1 = localObject5;
          localObject5 = localJSONException2;
          localObject4 = localObject8;
          localObject8 = localObject13;
        }
      }
      else
      {
        try
        {
          l1 = ((JSONObject)localObject2).optInt("start_time");
          localObject10 = localObject1;
          localObject8 = localObject15;
          localObject7 = localObject14;
          l2 = ((JSONObject)localObject2).optInt("end_time");
          localObject9 = localObject1;
          localObject12 = localObject16;
          localObject11 = str1;
          localObject10 = localObject1;
          localObject8 = localObject15;
          localObject7 = localObject14;
          if (System.currentTimeMillis() > l1 * 1000L)
          {
            localObject9 = localObject1;
            localObject12 = localObject16;
            localObject11 = str1;
            localObject10 = localObject1;
            localObject8 = localObject15;
            localObject7 = localObject14;
            if (System.currentTimeMillis() < l2 * 1000L)
            {
              localObject10 = localObject1;
              localObject8 = localObject15;
              localObject7 = localObject14;
              localObject5 = ((JSONObject)localObject2).optString("template_text");
              localObject10 = localObject5;
              localObject8 = localObject15;
              localObject7 = localObject14;
              str1 = ((JSONObject)localObject2).optString("bytes_url");
              if (i1 == 0) {
                break label1752;
              }
              localObject10 = localObject5;
              localObject8 = localObject15;
              localObject7 = localObject14;
              localObject1 = ((JSONObject)localObject2).optString("bytes_icon_url");
            }
          }
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            localObject1 = localOutOfMemoryError;
            localObject4 = localObject7;
          }
        }
        try
        {
          localObject7 = ((JSONObject)localObject2).optString("bytes_icon_custom_url");
          localObject2 = localObject1;
          localObject1 = localObject7;
          localObject9 = localObject5;
          localObject12 = localObject1;
          localObject11 = localObject2;
          localObject10 = localObject5;
          localObject8 = localObject1;
          localObject7 = localObject2;
          if (!TextUtils.isEmpty(str1))
          {
            localObject10 = localObject5;
            localObject8 = localObject1;
            localObject7 = localObject2;
            localSharedPreferences.edit().putString(this.app.getCurrentUin() + "sign_in_jump_url", str1).commit();
            localObject11 = localObject2;
            localObject12 = localObject1;
            localObject9 = localObject5;
          }
          localObject5 = localObject12;
          localObject2 = localObject11;
          localObject1 = localObject9;
        }
        catch (JSONException localJSONException4)
        {
          localObject4 = localObject1;
          localObject1 = localJSONException3;
          localObject8 = localObject13;
          Object localObject6 = localJSONException4;
          break label1783;
          break label1051;
          localObject4 = null;
          localObject6 = null;
          break label779;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView type=" + this.type + " iconUrl=" + (String)localObject2 + " wording=" + (String)localObject1 + " day=" + i2 + "covericonUrl" + (String)localObject5);
        }
        this.gp.setVisibility(0);
        this.gq.setVisibility(8);
        localObject7 = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846990);
        localObject8 = (URLImageView)this.gp.findViewById(2131378402);
        localObject9 = (ImageView)this.gq.findViewById(2131369471);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject10 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject10).mFailedDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mLoadingDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestHeight = 56;
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestWidth = 56;
          if ((this.jdField_d_of_type_ComTencentMobileqqDataCard != null) && ((aura.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_d_of_type_ComTencentMobileqqDataCard.isNoCover())))
          {
            localObject5 = URLDrawable.getDrawable((String)localObject5, (URLDrawable.URLDrawableOptions)localObject10);
            localObject7 = localObject5;
            if (QLog.isColorLevel())
            {
              QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject2);
              localObject7 = localObject5;
            }
            ThemeUtil.getCurrentThemeInfo().getString("themeId");
            ((URLImageView)localObject8).setImageDrawable((Drawable)localObject7);
            ((ImageView)localObject9).setImageDrawable((Drawable)localObject7);
            localObject5 = (TextView)this.gp.findViewById(2131378404);
            localObject7 = (TextView)this.gq.findViewById(2131369534);
            ((TextView)localObject5).setMaxWidth(i4 - i3 - i5 - (i6 + i7));
            if ((!anlm.ayn()) || (!"2920".equals(ThemeUtil.getCurrentThemeId()))) {
              break label1998;
            }
            ((TextView)localObject5).setTextColor(this.cV.getResources().getColor(2131166724));
            if (!ThemeUtil.isNowThemeIsDefault(this.app, true, null)) {
              break label2071;
            }
            ((TextView)localObject5).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            if (this.type != 4) {
              break label2083;
            }
            if (QLog.isColorLevel()) {
              QLog.i("DailySignIn", 2, "use signed wording:" + (String)localObject1);
            }
            wj("0X800ACFC");
            localObject2 = localObject1;
            if (i2 > 0) {
              localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(i2) });
            }
            ((TextView)localObject5).setText((CharSequence)localObject2);
            ((TextView)localObject7).setText((CharSequence)localObject2);
            this.v.dGB();
            this.w.dGB();
            return;
          }
        }
      }
    }
  }
  
  public void bUp()
  {
    this.jdField_e_of_type_Ahyj.dqV();
  }
  
  public void bpQ()
  {
    this.aPd = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.23(this));
  }
  
  public int eQ(int paramInt)
  {
    float f1 = 1.0F;
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    float f2 = ((Resources)localObject).getDimension(2131298879);
    float f3 = ((Resources)localObject).getDimension(2131298863);
    float f4 = ((Resources)localObject).getDimension(2131298867);
    float f5 = ((Resources)localObject).getDimension(2131298871);
    float f6 = ((Resources)localObject).getDimension(2131298874);
    float f7 = ((Resources)localObject).getDimension(2131298881);
    f3 = localDisplayMetrics.widthPixels - (f7 + (f3 + f4 + f5 + f6)) - paramInt;
    if (f2 <= 1.0F) {}
    for (;;)
    {
      int i1 = (int)Math.floor(f3 / f1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resizeQQLevelIconSize width=" + localDisplayMetrics.widthPixels);
        ((StringBuilder)localObject).append(",iconSize=" + f1);
        ((StringBuilder)localObject).append(",vipSize=" + paramInt);
        ((StringBuilder)localObject).append(",space=" + f3);
        ((StringBuilder)localObject).append(",maxIconSize=" + i1);
        QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
      }
      return i1;
      f1 = f2;
    }
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  /* Error */
  public void h(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 367
    //   9: iconst_2
    //   10: new 380	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3116
    //   20: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1634	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 3118
    //   30: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1634	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 3120
    //   40: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 657	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 530	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1638	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 1719	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 723	com/tencent/mobileqq/activity/QQSettingMe:jdField_p_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_1
    //   67: aaload
    //   68: ldc_w 821
    //   71: invokevirtual 432	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 507	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 723	com/tencent/mobileqq/activity/QQSettingMe:jdField_p_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_1
    //   84: aaload
    //   85: ldc_w 819
    //   88: invokevirtual 432	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 602	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 374	com/tencent/mobileqq/activity/QQSettingMe:jdField_c_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc_w 745
    //   110: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   113: astore 5
    //   115: invokestatic 1460	acha:isLocaleCN	()Z
    //   118: ifeq +400 -> 518
    //   121: iload_1
    //   122: ifeq +238 -> 360
    //   125: invokestatic 2126	aqrt:a	()Laqrt;
    //   128: getfield 3123	aqrt:cwF	Ljava/lang/String;
    //   131: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +209 -> 343
    //   137: invokestatic 2126	aqrt:a	()Laqrt;
    //   140: getfield 3123	aqrt:cwF	Ljava/lang/String;
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload 5
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 463	java/lang/String:length	()I
    //   158: bipush 8
    //   160: if_icmple +13 -> 173
    //   163: aload 5
    //   165: iconst_0
    //   166: bipush 8
    //   168: invokevirtual 2353	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore 6
    //   173: aload 7
    //   175: aload 6
    //   177: invokevirtual 573	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   180: aload_0
    //   181: getfield 245	com/tencent/mobileqq/activity/QQSettingMe:aZS	Z
    //   184: ifeq +437 -> 621
    //   187: ldc_w 2451
    //   190: istore_3
    //   191: aload 8
    //   193: iload_3
    //   194: invokevirtual 820	android/widget/ImageView:setImageResource	(I)V
    //   197: aload 6
    //   199: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +107 -> 309
    //   205: aload_0
    //   206: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: invokevirtual 516	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   212: ldc_w 1849
    //   215: iconst_0
    //   216: invokevirtual 1850	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   219: invokeinterface 2558 1 0
    //   224: new 380	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1852
    //   234: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 376	com/tencent/mobileqq/activity/QQSettingMe:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   244: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1854
    //   250: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokestatic 1857	acha:Ax	()I
    //   256: invokevirtual 657	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 530	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 6
    //   264: invokeinterface 2589 3 0
    //   269: invokeinterface 2633 1 0
    //   274: pop
    //   275: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +31 -> 309
    //   281: ldc_w 367
    //   284: iconst_2
    //   285: new 380	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 3125
    //   295: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 6
    //   300: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 530	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 659	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 723	com/tencent/mobileqq/activity/QQSettingMe:jdField_p_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   313: iconst_1
    //   314: aaload
    //   315: iconst_0
    //   316: invokevirtual 552	android/view/View:setVisibility	(I)V
    //   319: getstatic 416	com/tencent/common/config/AppSetting:enableTalkBack	Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 723	com/tencent/mobileqq/activity/QQSettingMe:jdField_p_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   329: iconst_1
    //   330: aaload
    //   331: aload 6
    //   333: ldc_w 846
    //   336: invokevirtual 851	java/lang/Class:getName	()Ljava/lang/String;
    //   339: invokestatic 857	aqcl:changeAccessibilityForView	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   342: return
    //   343: aload 9
    //   345: ldc_w 3126
    //   348: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   351: astore 6
    //   353: aload 6
    //   355: astore 5
    //   357: goto -208 -> 149
    //   360: iload_2
    //   361: ifeq +47 -> 408
    //   364: invokestatic 2126	aqrt:a	()Laqrt;
    //   367: getfield 3129	aqrt:cwD	Ljava/lang/String;
    //   370: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifne +18 -> 391
    //   376: invokestatic 2126	aqrt:a	()Laqrt;
    //   379: getfield 3129	aqrt:cwD	Ljava/lang/String;
    //   382: astore 6
    //   384: aload 6
    //   386: astore 5
    //   388: goto -239 -> 149
    //   391: aload 9
    //   393: ldc_w 3130
    //   396: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   399: astore 6
    //   401: aload 6
    //   403: astore 5
    //   405: goto -256 -> 149
    //   408: aload 6
    //   410: ldc_w 3132
    //   413: iconst_0
    //   414: invokeinterface 1724 3 0
    //   419: istore 4
    //   421: iload_3
    //   422: ifgt +8 -> 430
    //   425: iload 4
    //   427: ifle +47 -> 474
    //   430: invokestatic 2126	aqrt:a	()Laqrt;
    //   433: getfield 3135	aqrt:cwE	Ljava/lang/String;
    //   436: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifne +18 -> 457
    //   442: invokestatic 2126	aqrt:a	()Laqrt;
    //   445: getfield 3135	aqrt:cwE	Ljava/lang/String;
    //   448: astore 6
    //   450: aload 6
    //   452: astore 5
    //   454: goto -305 -> 149
    //   457: aload 9
    //   459: ldc_w 3136
    //   462: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   465: astore 6
    //   467: aload 6
    //   469: astore 5
    //   471: goto -322 -> 149
    //   474: invokestatic 2126	aqrt:a	()Laqrt;
    //   477: getfield 3139	aqrt:cwC	Ljava/lang/String;
    //   480: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne +18 -> 501
    //   486: invokestatic 2126	aqrt:a	()Laqrt;
    //   489: getfield 3139	aqrt:cwC	Ljava/lang/String;
    //   492: astore 6
    //   494: aload 6
    //   496: astore 5
    //   498: goto -349 -> 149
    //   501: aload 9
    //   503: ldc_w 745
    //   506: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   509: astore 6
    //   511: aload 6
    //   513: astore 5
    //   515: goto -366 -> 149
    //   518: iload_1
    //   519: ifeq +16 -> 535
    //   522: aload 9
    //   524: ldc_w 3126
    //   527: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   530: astore 6
    //   532: goto -359 -> 173
    //   535: iload_2
    //   536: ifeq +16 -> 552
    //   539: aload 9
    //   541: ldc_w 3130
    //   544: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   547: astore 6
    //   549: goto -376 -> 173
    //   552: aload 6
    //   554: ldc_w 3132
    //   557: iconst_0
    //   558: invokeinterface 1724 3 0
    //   563: istore 4
    //   565: iload_3
    //   566: ifgt +8 -> 574
    //   569: iload 4
    //   571: ifle +16 -> 587
    //   574: aload 9
    //   576: ldc_w 3136
    //   579: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   582: astore 6
    //   584: goto -411 -> 173
    //   587: aload 9
    //   589: ldc_w 745
    //   592: invokevirtual 844	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -424 -> 173
    //   600: astore 6
    //   602: ldc_w 367
    //   605: iconst_1
    //   606: ldc_w 3141
    //   609: aload 6
    //   611: invokestatic 1365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload 5
    //   616: astore 6
    //   618: goto -445 -> 173
    //   621: ldc_w 2464
    //   624: istore_3
    //   625: goto -434 -> 191
    //   628: astore 5
    //   630: ldc_w 367
    //   633: iconst_1
    //   634: ldc_w 3143
    //   637: aload 5
    //   639: invokestatic 1365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   642: goto -333 -> 309
    //   645: astore 6
    //   647: goto -45 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	QQSettingMe
    //   0	650	1	paramBoolean1	boolean
    //   0	650	2	paramBoolean2	boolean
    //   0	650	3	paramInt	int
    //   419	151	4	i1	int
    //   113	502	5	localObject1	Object
    //   628	10	5	localException1	Exception
    //   60	536	6	localObject2	Object
    //   600	10	6	localException2	Exception
    //   616	1	6	localObject3	Object
    //   645	1	6	localException3	Exception
    //   77	97	7	localTextView	TextView
    //   94	98	8	localImageView	ImageView
    //   103	485	9	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   115	121	600	java/lang/Exception
    //   125	145	600	java/lang/Exception
    //   343	353	600	java/lang/Exception
    //   364	384	600	java/lang/Exception
    //   391	401	600	java/lang/Exception
    //   408	421	600	java/lang/Exception
    //   430	450	600	java/lang/Exception
    //   457	467	600	java/lang/Exception
    //   474	494	600	java/lang/Exception
    //   501	511	600	java/lang/Exception
    //   522	532	600	java/lang/Exception
    //   539	549	600	java/lang/Exception
    //   552	565	600	java/lang/Exception
    //   574	584	600	java/lang/Exception
    //   587	597	600	java/lang/Exception
    //   205	309	628	java/lang/Exception
    //   153	173	645	java/lang/Exception
  }
  
  public void init()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.isInited);
    }
    if (true == this.isInited) {
      return;
    }
    this.isInited = true;
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = aqap.a().b();
    this.jdField_a_of_type_Aogs = new aogs(this.app);
    addObserver();
    bTL();
    bUg();
    bpQ();
    bTG();
    bPz();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.cCr();
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.cCl();
    }
    try
    {
      this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.aF, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      if (TextUtils.isEmpty(aqrt.a().cwD)) {
        ThreadManager.post(new QQSettingMe.8(this), 5, null, true);
      }
      bTF();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
        }
      }
    }
  }
  
  public boolean isResume()
  {
    return this.isResume;
  }
  
  public void k(@Nullable Boolean paramBoolean)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return;
    }
    if (this.aZP)
    {
      if ((anlm.ayn()) && (!ThemeUtil.isInNightMode(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((anlm.pq(paramBoolean)) && (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(paramBoolean)))
        {
          ImmersiveUtils.setStatusTextColor(false, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
          return;
        }
        ImmersiveUtils.setStatusTextColor(true, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        return;
      }
      ThemeUtil.adjustThemeStatusBar(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    Boolean localBoolean = paramBoolean;
    if (paramBoolean == null)
    {
      localBoolean = paramBoolean;
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard != null) {
        if ((!aura.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard)) && (this.jdField_d_of_type_ComTencentMobileqqDataCard.isNoCover())) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      if ((localBoolean == null) || (!ThemeUtil.isDefaultTheme())) {
        break label188;
      }
      if (!localBoolean.booleanValue()) {
        break;
      }
      ImmersiveUtils.setStatusTextColor(false, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(true, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
    return;
    label188:
    if (ThemeUtil.isNowThemeIsNight(this.app, true, null))
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    if (ThemeUtil.isGoldenTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(ThemeUtil.isDartStatusBar(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity), this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
  }
  
  protected String oW()
  {
    return this.app.getPreferences().getString(this.app.getCurrentUin() + "sign_in_jump_url", "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!this.isInited)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.clickTime != 0L) && (System.currentTimeMillis() - this.clickTime < 500L))
      {
        this.clickTime = System.currentTimeMillis();
      }
      else
      {
        this.clickTime = System.currentTimeMillis();
        Object localObject1;
        long l1;
        boolean bool;
        Object localObject5;
        Object localObject2;
        switch (paramView.getId())
        {
        case 2131369717: 
        default: 
          break;
        case 2131363231: 
          if (FrameHelperActivity.ZW())
          {
            FrameHelperActivity.EO(true);
            FrameHelperActivity.cuA();
            anot.a(this.app, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
          }
          break;
        case 2131372148: 
        case 2131372175: 
          if (this.aZM)
          {
            localObject1 = oW();
            localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("portraitOnly", true);
            ((Intent)localObject4).putExtra("uin", this.app.getCurrentAccountUin());
            ((Intent)localObject4).putExtra("hide_operation_bar", true);
            ((Intent)localObject4).putExtra("hide_more_button", true);
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_ad_daka");
            ((Intent)localObject4).putExtra("url", (String)localObject1);
            this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            if (this.type == 1) {
              wj("0X800ACFD");
            }
          }
          while (QLog.isColorLevel())
          {
            QLog.i("DailySignIn", 2, "mydaily onClick mDayliSignMode = " + this.aZM);
            break;
            if (this.type == 4)
            {
              wj("0X800ACFE");
              continue;
              localObject1 = this.app.getApp().getSharedPreferences("task_entry_config" + this.app.getCurrentAccountUin(), 0).getString("jump_url", "");
              localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
              ((Intent)localObject4).putExtra("portraitOnly", true);
              ((Intent)localObject4).putExtra("uin", this.app.getCurrentAccountUin());
              ((Intent)localObject4).putExtra("hide_operation_bar", true);
              ((Intent)localObject4).putExtra("hide_more_button", true);
              ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_ad_daka");
              ((Intent)localObject4).putExtra("url", (String)localObject1);
              this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
              anot.a(this.app, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
            }
          }
        case 2131372385: 
          localObject1 = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
          ((ProfileActivity.AllInOne)localObject1).bIZ = 1;
          ((ProfileActivity.AllInOne)localObject1).bJa = 8;
          ProfileActivity.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject1, 1009);
          this.app.reportClickEvent("CliOper", "0X80072D6");
          break;
        case 2131368407: 
          localObject1 = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
          ((ProfileActivity.AllInOne)localObject1).bIZ = 1;
          ((ProfileActivity.AllInOne)localObject1).bJa = 8;
          ProfileActivity.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject1, 1009);
          anot.a(this.app, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          this.app.reportClickEvent("CliOper", "0X80072D7");
          DrawerFrame.cgR = bJW;
          if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.aux()) {
            this.app.reportClickEvent("CliOper", "0X8006726");
          }
          break;
        case 2131375289: 
          localObject1 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
          localObject4 = this.app.getCurrentAccountUin();
          ((Intent)localObject1).putExtra("title", this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717228));
          ((Intent)localObject1).putExtra("nick", aqgv.n(this.app, (String)localObject4));
          ((Intent)localObject1).putExtra("uin", (String)localObject4);
          ((Intent)localObject1).putExtra("type", 1);
          ((Intent)localObject1).putExtra("reportFlag", 1);
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          anot.a(this.app, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
          break;
        case 2131372186: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.s(this.iu, l1))
          {
            this.iu = l1;
            if (QWalletHelper.isValidToLaunchQWallet(l1))
            {
              QWalletHelper.launchQWalletAct(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.app, true, true);
              anot.a(this.app, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
              aqeu.ey(this.app);
              ((altq)this.app.getManager(36)).jq(100007, 31);
              localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2];
              i1 = acny.e(this.app, this.app.getCurrentUin(), ((RedTouch)localObject1).aux());
              anot.a(this.app, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
              if (bJW > 0) {
                DrawerFrame.cgR = 2;
              } else {
                DrawerFrame.cgR = bJW;
              }
            }
          }
          break;
        case 2131372177: 
          if (!this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
          for (bool = true;; bool = false)
          {
            avja.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.app.getAccount(), null, -1, bool);
            avjg.b(this.app, 1, 0);
            avjj.ZS(this.app.getCurrentAccountUin());
            DrawerFrame.cgR = bJW;
            ((altq)this.app.getManager(36)).jq(103000, 31);
            break;
          }
        case 2131372185: 
          localObject1 = (altq)this.app.getManager(36);
          bool = false;
          localObject4 = new QZoneClickReport.a();
          ((QZoneClickReport.a)localObject4).aab("443");
          ((QZoneClickReport.a)localObject4).aac("3");
          ((QZoneClickReport.a)localObject4).nG(this.app.getLongAccountUin());
          if ((this.j != null) && (this.j.iNewFlag.get() == 1))
          {
            bool = true;
            ((QZoneClickReport.a)localObject4).aad("1");
            QZoneClickReport.startReportImediately(this.app.getCurrentAccountUin(), (QZoneClickReport.a)localObject4);
            ((altq)localObject1).jq(100180, 31);
          }
          try
          {
            l1 = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
            localObject5 = avpw.d.a();
            ((avpw.d)localObject5).cMP = String.valueOf(l1);
            localObject4 = this.app.getCurrentNickname();
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = aqgv.n(this.app, this.app.getCurrentAccountUin());
            }
            ((avpw.d)localObject5).nickname = ((String)localObject1);
            avpw.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (avpw.d)localObject5, Long.valueOf(l1), 0, bool, -1);
            localObject1 = new QZoneClickReport.a();
            ((QZoneClickReport.a)localObject1).actionType = "1";
            ((QZoneClickReport.a)localObject1).cMI = "0";
            ((QZoneClickReport.a)localObject1).tabletype = 4;
            ((QZoneClickReport.a)localObject1).sourceType = "3";
            ((QZoneClickReport.a)localObject1).sourceFrom = "drawerAlbumList";
            ((QZoneClickReport.a)localObject1).sourceTo = "QZonePhotoListActivity";
            QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.a)localObject1);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("source_type", "3");
            ((HashMap)localObject1).put("source_from", "drawerAlbumList");
            ((HashMap)localObject1).put("source_to", "QZonePhotoListActivity");
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
            anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
            DrawerFrame.cgR = bJW;
            continue;
            ((QZoneClickReport.a)localObject4).aad("2");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              l1 = 0L;
            }
          }
        case 2131372149: 
          localObject2 = (altq)this.app.getManager(36);
          ((altq)localObject2).jq(100005, 31);
          if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).aux()) {}
          for (localObject2 = avug.f(((altq)localObject2).getAppInfoByPath(String.valueOf(100005)));; localObject2 = avug.cp("outside", "3"))
          {
            VasWebviewUtil.openIndividuationIndex(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2);
            ThreadManager.post(new QQSettingMe.17(this), 5, null, true);
            anot.a(this.app, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
            DrawerFrame.cgR = bJW;
            break;
          }
        case 2131378151: 
          localObject2 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (aqap.bW(this.app)) {
            anot.a(this.app, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", aqap.BI(), "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
            accy.m(this.app, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
          }
          anot.a(this.app, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
          ((altq)this.app.getManager(36)).jq(100190, 31);
          DrawerFrame.cgR = bJW;
          break;
        case 2131372396: 
          if (!aogc.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, "", new vpj(this))) {
            bPD();
          }
          break;
        case 2131370749: 
          localObject2 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
          ((Intent)localObject2).putExtra("hide_more_button", true);
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          anot.a(this.app, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
          break;
        case 2131382150: 
          i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
          localObject2 = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7&areaId=" + i1;
          MiniAppLauncher.startMiniApp(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2, 2066, null);
          anot.a(this.app, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
          anot.a(this.app, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
          break;
        case 2131378397: 
          if ((this.jdField_a_of_type_Amhj != null) && (!this.jdField_a_of_type_Amhj.avO()))
          {
            ((altq)this.app.getManager(36)).jq(100450, 31);
            if ((this.ug != null) && (this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity != null))
            {
              localObject2 = (TextView)this.ug.findViewById(2131377256);
              if ((localObject2 != null) && (((TextView)localObject2).getText() != null))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("from_type", 3);
                SignTextEditFragment.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus, "", (Bundle)localObject2, -1);
              }
            }
            DrawerFrame.cgR = 0;
          }
          anot.a(this.app, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
          this.app.reportClickEvent("CliOper", "0X80072D8");
          this.app.reportClickEvent("CliOper", "0X800A669");
          break;
        case 2131375018: 
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_jump_from", "9");
          oux.e(this.app.getCurrentUin(), (Intent)localObject2);
          break;
        case 2131372189: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.s(this.iu, l1))
          {
            this.iu = l1;
            if (QLog.isColorLevel()) {
              QLog.i("QQSettingRedesign", 2, "enter vip");
            }
            ThreadManager.post(new QQSettingMe.19(this), 5, null, true);
            localObject2 = (altq)this.app.getManager(36);
            localObject4 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1];
            i1 = acny.e(this.app, this.app.getCurrentUin(), ((RedTouch)localObject4).aux());
            if (((RedTouch)localObject4).aux()) {}
            for (localObject2 = avug.f(((altq)localObject2).getAppInfoByPath(String.valueOf(100400)));; localObject2 = avug.cp("outside", "1"))
            {
              anot.a(this.app, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
              wg((String)localObject2);
              anot.a(this.app, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
              if (bJW <= 0) {
                break label2736;
              }
              DrawerFrame.cgR = 2;
              break;
            }
            DrawerFrame.cgR = bJW;
          }
          break;
        case 2131372180: 
          localObject2 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
          ((Intent)localObject2).putExtra("from", "FileAssistant");
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          anot.a(this.app, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          DrawerFrame.cgR = bJW;
          localObject2 = (altq)this.app.getManager(36);
          localObject4 = ((altq)localObject2).getAppInfoByPath(String.valueOf(100160));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0)) {
            ((altq)localObject2).jq(100160, 31);
          }
          try
          {
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("service_type", 2);
            ((JSONObject)localObject5).put("act_id", 1002);
            ((altq)localObject2).h((BusinessInfoCheckUpdate.AppInfo)localObject4, ((JSONObject)localObject5).toString());
            if ((this.uq != null) && (this.uq.getVisibility() == 0))
            {
              this.uq.setVisibility(8);
              BaseApplication.getContext().getSharedPreferences(this.app.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        case 2131372187: 
          if (bJW > 0) {
            DrawerFrame.cgR = 2;
          } else {
            DrawerFrame.cgR = bJW;
          }
          break;
        case 2131365547: 
          localObject5 = (altq)this.app.getManager(36);
          localObject4 = "";
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject5).getAppInfoByPath(String.valueOf(100500));
          localObject3 = localObject4;
          if (localAppInfo != null)
          {
            localObject3 = localObject4;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              localObject3 = avug.e(localAppInfo);
              ((altq)localObject5).jq(100500, 31);
            }
          }
          localObject4 = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.app.getCurrentAccountUin(), 4).getString("drawerUrl", "");
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
          }
          localObject3 = (String)localObject4 + (String)localObject3;
          localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[12];
          i1 = acny.e(this.app, this.app.getCurrentUin(), ((RedTouch)localObject3).aux());
          anot.a(this.app, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), this.aPe, "", "");
          break;
        case 2131372188: 
          QQStoryMemoriesActivity.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().getCurrentUid(), true);
          DrawerFrame.cgR = bJW;
          break;
        case 2131372182: 
          localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameJumpUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list.html%3Fmode%3Dchouti&_vt=3&via=2066&_sig=676003338");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (MiniAppLauncher.isMiniAppUrl((String)localObject3)) {
              MiniAppLauncher.startMiniApp(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, a((String)localObject3, this.q), 2066, null);
            }
          }
          else
          {
            localObject3 = this.app;
            if (!RedTouch.c(this.q)) {
              break label3520;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            anot.a((QQAppInterface)localObject3, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i1, "", "", "", "");
            localObject3 = (altq)this.app.getManager(36);
            if (localObject3 == null) {
              break;
            }
            ((altq)localObject3).jq(100077, 31);
            break;
            localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject3);
            this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            break label3397;
          }
        case 2131364191: 
          localObject3 = this.app.getApp();
          localObject4 = this.app.getCurrentUin();
          localObject4 = ((Context)localObject3).getSharedPreferences("call_tim_config_pre" + (String)localObject4, 0).getString("call_tim_config_url", null);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = aeuw.a().uh();
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "https://docs.qq.com/desktop/m/index.html";
          }
          localObject3 = aobw.bD((String)localObject4, "s_qq_drawer");
          localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
          ((Intent)localObject4).putExtra("tdsourcetag", "s_qq_drawer");
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          anot.a(this.app, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
          break;
        case 2131375012: 
          if (this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) {}
          for (localObject3 = null;; localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl)
          {
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label3809;
            }
            localObject3 = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
            ((ProfileActivity.AllInOne)localObject3).bIZ = 1;
            ((ProfileActivity.AllInOne)localObject3).bJa = 8;
            ProfileActivity.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject3, 1009);
            QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
            break;
          }
          localObject4 = new Intent(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("hide_operation_bar", true);
          ((Intent)localObject4).putExtra("hide_more_button", true);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          i1 = acny.e(this.app, this.app.getCurrentUin(), false);
          anot.a(this.app, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
          break;
        case 2131372834: 
          label2736:
          label3397:
          label3809:
          aqep.fw(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity);
          label3520:
          anot.a(this.app, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
        }
      }
    }
    int i1 = aiwk.dp(aiwk.a(this.jdField_p_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo));
    Object localObject3 = (altq)this.app.getManager(36);
    Object localObject4 = ((altq)localObject3).getAppInfoByPath(String.valueOf(100066));
    if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView == null) || (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.getVisibility() != 0)) {
        break label4110;
      }
      dp("0x800AAFB", "1");
    }
    for (;;)
    {
      ((altq)localObject3).jq(100066, 31);
      aiwk.b(this.app, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, 2066, "10", i1 + "");
      break;
      label4110:
      dp("0x800AAFB", "2");
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.bJZ)
    {
      this.bJZ = paramConfiguration.orientation;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from onConfigurationChanged");
      }
      we(this.app.getCurrentAccountUin());
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.isInited)
    {
      removeObserver();
      this.jdField_a_of_type_Aogs.destroy();
    }
    try
    {
      this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.aF);
      if (this.app != null)
      {
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(46);
        if (localAvatarPendantManager != null) {
          localAvatarPendantManager.clear();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.onDestroy();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  public void onDrawerClosed()
  {
    this.aZP = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.onDrawerClosed();
    }
    if ((this.uq != null) && (this.uq.getVisibility() == 0))
    {
      this.uq.setVisibility(8);
      BaseApplication.getContext().getSharedPreferences(this.app.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    k(null);
  }
  
  public void onDrawerOpened()
  {
    this.aZP = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.onDrawerOpened();
    }
    this.app.Jx(0);
    k(null);
    anot.a(this.app, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    if ((this.jdField_d_of_type_ComTencentMobileqqDataCard != null) && (aqss.k(this.app.getApp(), this.jdField_d_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_d_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label143;
      }
    }
    label143:
    for (int i1 = 99999;; i1 = this.jdField_d_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      return;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    this.isResume = false;
    this.aZN = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.onPause();
    }
    this.ay.clear();
    this.jdField_e_of_type_Ahyj.end();
    anoz.a().traceEnd("QQSettingMe");
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_Aogs != null) {
      this.jdField_a_of_type_Aogs.onPostThemeChanged();
    }
    Object localObject2;
    boolean bool;
    label131:
    int i1;
    label182:
    label218:
    label364:
    int i2;
    label391:
    label430:
    TextView localTextView;
    if (anlm.ayn())
    {
      this.un.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.un).a(53).a();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      bUf();
      bTU();
      this.aZQ = true;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      Object localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label597;
      }
      bool = true;
      this.aZS = bool;
      k(null);
      if (!this.aZS) {
        break label602;
      }
      i1 = this.cV.getResources().getColor(2131166725);
      this.qT.setImageResource(2130846983);
      this.qR.setImageResource(2130846963);
      if ((this.jdField_d_of_type_ComTencentMobileqqDataCard == null) || ((!aura.a(this.app, this.jdField_d_of_type_ComTencentMobileqqDataCard)) && (this.jdField_d_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
        break label639;
      }
      wR(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      this.Fi.setTextColor(i1);
      this.Fh.setTextColor(i1);
      this.Fj.setTextColor(i1);
      bTD();
      localObject2 = (ImageView)this.ug.findViewById(2131368715);
      if (!ThemeUtil.isNowThemeIsDefault(this.app, true, null)) {
        break label647;
      }
      this.Fk.setTextColor(-6709582);
      this.Fl.setTextColor(-6709582);
      this.Fm.setTextColor(-6709582);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1))) {
        break label674;
      }
      this.uk.setVisibility(0);
      bUm();
      wf(this.app.getCurrentAccountUin());
      bTM();
      this.Fn.setTextColor(i1);
      localObject1 = a(this.aZS);
      i2 = 0;
      if (i2 >= 14) {
        break label707;
      }
      if (this.jdField_p_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        localObject2 = (ImageView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369471);
        ((ImageView)localObject2).setImageResource(localObject1[i2]);
        localTextView = (TextView)this.jdField_p_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369534);
        if (this.aZS) {
          break label686;
        }
        localTextView.setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((anlm.ayn()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        localTextView.setTextColor(this.cV.getResources().getColor(2131166724));
      }
      if (i2 == 10) {
        a((ImageView)localObject2, localTextView);
      }
      i2 += 1;
      break label430;
      this.un.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity, this.ud).a(53).a();
      break;
      label597:
      bool = false;
      break label131;
      label602:
      i1 = this.cV.getResources().getColor(2131166726);
      this.qT.setImageResource(2130846987);
      this.qR.setImageResource(2130846962);
      break label182;
      label639:
      wR(false);
      break label218;
      label647:
      this.Fk.setTextColor(i1);
      this.Fl.setTextColor(i1);
      this.Fm.setTextColor(i1);
      break label364;
      label674:
      this.uk.setVisibility(8);
      break label391;
      label686:
      localTextView.setTextColor(this.cV.getResources().getColor(2131166724));
    }
    label707:
    ((advr)this.app.getManager(180)).GW(this.app.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      wd(this.app.getCurrentAccountUin());
    }
    ((acks)this.app.getBusinessHandler(87)).notifyUI(4, true, null);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    this.aZO = false;
    bUa();
    anoz.a().traceStart("QQSettingMe");
    if (!this.isInited) {
      init();
    }
    this.ul.setPadding(this.ul.getPaddingLeft(), ankt.dip2px(14.0F), this.ul.getPaddingRight(), this.ul.getPaddingBottom());
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(1);
    bUg();
    bTL();
    bpQ();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.cCr();
    }
    try
    {
      if (((WindowManager)this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() >= 480)
      {
        bUj();
        this.jdField_a_of_type_Abcy.a(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        bTG();
        bUo();
        bPz();
        Object localObject1 = this.app.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(this.aPb))) {
          ThreadManagerV2.executeOnSubThread(new QQSettingMe.4(this));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.cCl();
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.cCq();
        }
        this.isResume = true;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          long l1 = WebProcessManager.g((String)localObject1, "key_individuation_click_time");
          if ((l1 == -1L) || (System.currentTimeMillis() - l1 < 259200000L)) {
            WebProcessManager.E(ra, "key_individuation_dns_parse");
          }
          l1 = WebProcessManager.bi((String)localObject1);
          if (System.currentTimeMillis() - l1 < 604800000L) {
            WebProcessManager.E(qZ, "key_vip_dns_parse");
          }
        }
        localObject1 = this.jdField_p_of_type_ArrayOfAndroidViewView[9];
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = (pmb)this.app.getManager(181);
          if ((localObject2 == null) || (!((pmb)localObject2).In())) {
            break;
          }
          ((View)localObject1).setVisibility(0);
        }
        bTA();
        bTB();
        bTC();
        bTW();
        bTY();
        bTz();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW()) && (!ThemeUtil.isInNightMode(this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.app)) && (anlm.ayn())) {
          ImmersiveUtils.setStatusTextColor(true, this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        localObject1 = new int[14];
        Object tmp433_431 = localObject1;
        tmp433_431[0] = 2131375018;
        Object tmp439_433 = tmp433_431;
        tmp439_433[1] = 2131372189;
        Object tmp445_439 = tmp439_433;
        tmp445_439[2] = 2131372186;
        Object tmp451_445 = tmp445_439;
        tmp451_445[3] = 2131372177;
        Object tmp457_451 = tmp451_445;
        tmp457_451[4] = 2131372180;
        Object tmp463_457 = tmp457_451;
        tmp463_457[5] = 2131372185;
        Object tmp469_463 = tmp463_457;
        tmp469_463[6] = 2131372149;
        Object tmp476_469 = tmp469_463;
        tmp476_469[7] = 2131372181;
        Object tmp483_476 = tmp476_469;
        tmp483_476[8] = 2131372187;
        Object tmp490_483 = tmp483_476;
        tmp490_483[9] = 2131372188;
        Object tmp497_490 = tmp490_483;
        tmp497_490[10] = 2131372182;
        Object tmp504_497 = tmp497_490;
        tmp504_497[11] = 2131364191;
        Object tmp511_504 = tmp504_497;
        tmp511_504[12] = 2131365547;
        Object tmp518_511 = tmp511_504;
        tmp518_511[13] = 2131372148;
        tmp518_511;
        i2 = acny.e(this.app, this.app.getCurrentUin(), false);
        i1 = 0;
        for (;;)
        {
          if (i1 >= 14) {
            return;
          }
          if ((localObject1[i1] != 2131372189) || (this.jdField_p_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          localObject2 = ((altq)this.app.getManager(36)).getAppInfoByPath(String.valueOf(100400));
          int i3 = acny.e(this.app, this.app.getCurrentUin(), RedTouch.c((BusinessInfoCheckUpdate.AppInfo)localObject2));
          anot.a(this.app, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i3, 0, String.valueOf(i3), "", "", "");
          i1 += 1;
        }
        if (this.gr != null) {
          this.gr.setVisibility(8);
        }
        if (this.Fn != null) {
          this.Fn.setVisibility(4);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i2;
        int i1;
        QLog.e("QQSettingRedesign", 1, localThrowable, new Object[0]);
        continue;
        localThrowable.setVisibility(8);
        continue;
        if ((localThrowable[i1] == 2131372186) && (this.jdField_p_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          anot.a(this.app, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
        }
        else if ((localThrowable[i1] == 2131365547) && (this.jdField_p_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          anot.a(this.app, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), this.aPe, "", "");
        }
        else if (localThrowable[i1] == 2131375018)
        {
          QzoneConfig.getInstance();
          if (QzoneConfig.isQQCircleShowDrawTabEntrance()) {
            this.jdField_p_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
          } else {
            this.jdField_p_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
          }
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    do
    {
      return false;
      switch (paramView.getId())
      {
      default: 
        return false;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        paramView.setAlpha(0.5F);
        paramView.invalidate();
        return false;
      }
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    paramView.setAlpha(1.0F);
    paramView.invalidate();
    return false;
  }
  
  void preloadWebProcess()
  {
    ThreadManager.getSubThreadHandler().post(new WebPreloadTask(this));
  }
  
  protected void removeObserver()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_c_of_type_Acfd);
      this.app.removeObserver(this.cardObserver);
      this.app.removeObserver(this.jdField_b_of_type_Accz);
      this.app.removeObserver(this.jdField_a_of_type_Acnz);
      this.app.removeObserver(this.jdField_d_of_type_Aclh);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.e);
      }
      if (this.jdField_a_of_type_Amhj != null)
      {
        this.jdField_a_of_type_Amhj.removeListener(this.jdField_a_of_type_Amfk);
        this.jdField_a_of_type_Amhj.removeListener(this.jdField_b_of_type_Amfh);
        this.jdField_a_of_type_Amhj.removeListener(this.jdField_a_of_type_Amff);
      }
      if (this.jdField_a_of_type_Abcy != null)
      {
        this.jdField_a_of_type_Abcy.a(null);
        this.jdField_a_of_type_Abcy = null;
      }
      this.app.unRegistObserver(this.jdField_e_of_type_Aklk);
      this.app.removeObserver(this.jdField_a_of_type_Achf);
    }
    if (this.jdField_a_of_type_Aogs != null) {
      this.jdField_a_of_type_Aogs.a(this.jdField_a_of_type_Aogs$a, false);
    }
    aqrt.a().b(this.jdField_a_of_type_Aqrt$a);
    sxa.a().b(this.jdField_a_of_type_Sxa$a);
  }
  
  public int vC()
  {
    if (this.cU.size() > 0)
    {
      Iterator localIterator = this.cU.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((auvn)localIterator.next()).getBitmap();
        if (localBitmap == null) {
          break label70;
        }
        i1 = aqft.getBitmapSize(localBitmap) + i1;
      }
      label70:
      for (;;)
      {
        break;
        this.cU.clear();
        return i1;
      }
    }
    return 0;
  }
  
  public void wR(boolean paramBoolean)
  {
    if ((paramBoolean) || (!ThemeUtil.isDefaultTheme()))
    {
      this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.1(this, paramBoolean));
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.2(this));
  }
  
  public void wc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "[showExploreBox] url:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.wc(paramString);
    }
  }
  
  public void wd(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.15(this, paramString));
  }
  
  public void we(String paramString)
  {
    ThreadManager.post(new QQSettingMe.16(this, paramString), 5, null, false);
  }
  
  public static class WebPreloadTask
    implements Runnable
  {
    private WeakReference<QQSettingMe> dN;
    
    WebPreloadTask(QQSettingMe paramQQSettingMe)
    {
      this.dN = new WeakReference(paramQQSettingMe);
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if (this.dN == null) {
            return;
          }
          QQSettingMe localQQSettingMe = (QQSettingMe)this.dN.get();
          if ((localQQSettingMe == null) || (localQQSettingMe.app == null)) {
            break;
          }
          WebProcessManager localWebProcessManager = (WebProcessManager)localQQSettingMe.app.getManager(13);
          if (localWebProcessManager == null) {
            break;
          }
          if (ApolloUtil.a(localQQSettingMe.app, QQSettingMe.a(localQQSettingMe).d))
          {
            i = 100;
            localWebProcessManager.a(i, new vqe(this, localQQSettingMe));
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("QQSettingRedesign", 1, "WebPreloadTask preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
          return;
        }
        int i = -1;
      }
    }
  }
  
  static class a
    implements sxa.a
  {
    WeakReference<QQSettingMe> an;
    
    public a(QQSettingMe paramQQSettingMe)
    {
      this.an = new WeakReference(paramQQSettingMe);
    }
    
    public int uA()
    {
      QQSettingMe localQQSettingMe = (QQSettingMe)this.an.get();
      if (localQQSettingMe != null) {
        return localQQSettingMe.vC();
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */