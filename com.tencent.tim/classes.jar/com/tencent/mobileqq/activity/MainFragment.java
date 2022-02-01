package com.tencent.mobileqq.activity;

import aahb;
import aajt;
import aali;
import abmt;
import acep;
import acfp;
import acjf;
import acyg;
import aeam;
import aehl;
import aglz;
import ahhj;
import aiyy;
import aizd;
import aizp;
import akrv;
import akwp;
import alkm;
import anaz;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;
import aneo;
import anlm;
import anop;
import anop.a;
import anot;
import anoz;
import anpc;
import aqap;
import aqcl;
import aqed;
import aqhv;
import aqik;
import aqju;
import aqmj;
import aqmq;
import aqnm;
import aqsd;
import aqxg;
import aqxh;
import aryy;
import aurk;
import ausb;
import ausj;
import aute;
import avsn;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.tim.timme.TimLeba;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQTabWidget.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import jnp;
import jnv;
import kvu;
import kxm;
import lcm;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import njn;
import odv;
import plr;
import protocol.KQQConfig.UpgradeInfo;
import rar;
import she;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import toh;
import tzc;
import vhe;
import vhf;
import vhg;
import vhh;
import vhi;
import vhj;
import vhk;
import vhm;
import vhn;
import vhp;
import vhq;
import vhr;
import wjw;
import wnr;
import zjq;
import zjt;
import zju;

public class MainFragment
  extends FrameHelperActivity
{
  public static final String aOe;
  public static final String aOf;
  public static final String aOg;
  public static final String aOh;
  private static boolean aYA;
  private static boolean aYB;
  private static boolean aYC;
  private static boolean aYE = true;
  public static boolean aYt;
  public static boolean aYu;
  public static boolean aYv;
  public static int bIj = -1;
  public static int bIk;
  public static int bIl = 1;
  public static int bIm = 2;
  public static int bIn = 3;
  public static int bIo = 4;
  public static int bIp = 5;
  public static int bIq = 7;
  public static int bIr = 2;
  public static int bIs = 8;
  private static int bIv;
  private static SparseArray<Animation> bn;
  private static final int[] fv;
  private static final int[] fw;
  private static final Random mRandom;
  private long Go;
  public Intent I;
  private Dialog V;
  private aali jdField_a_of_type_Aali = new aali(null);
  private b jdField_a_of_type_ComTencentMobileqqActivityMainFragment$b = new b();
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQTabWidget.a jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$a = new vhj(this);
  public zju a;
  private String aOi;
  public String aOj;
  private String aOk;
  private String aOl;
  private String aOm = "";
  private String aOn = "";
  public boolean aQW = true;
  boolean aYD = false;
  boolean aYF = false;
  private boolean aYw = true;
  private boolean aYx;
  private boolean aYy = true;
  private boolean aYz;
  private boolean afF;
  private QQAppInterface app;
  private QQBlurView jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private int bIt = -1;
  int bIu = 3;
  private SparseArray<TabDragAnimationView> bo;
  private SparseArray<TextView> bp;
  Runnable dV = new MainFragment.21(this);
  private Runnable jdField_do = new MainFragment.20(this);
  private HashMap<String, Object> gA;
  private HashMap<String, View> gz;
  private Intent mNewIntent;
  private Vibrator mVibrator;
  private SharedPreferences pref;
  private View[] s;
  public Dialog y;
  
  static
  {
    aOe = acfp.m(2131695649);
    aOf = acfp.m(2131695648);
    aOg = acfp.m(2131695652);
    aOh = acfp.m(2131695158);
    aYt = true;
    bn = new SparseArray(2);
    fv = new int[] { 2130851388, 2130842122, 2130842123, 2130842124, 2130842125, 2130842126, 2130842128, 2130842127 };
    fw = new int[] { 2130851387, 2130842129, 2130842130, 2130842131 };
    mRandom = new Random();
  }
  
  private void Bh(int paramInt)
  {
    QLog.d("MainFragment", 2, "update kandian tab, type : " + paramInt);
    if (paramInt == 0) {
      xC(false);
    }
    ReadInjoyTabDragAnimationView localReadInjoyTabDragAnimationView;
    do
    {
      do
      {
        return;
      } while (!(this.bo.get(bIq) instanceof ReadInjoyTabDragAnimationView));
      localReadInjoyTabDragAnimationView = (ReadInjoyTabDragAnimationView)this.bo.get(bIq);
      TextView localTextView = (TextView)this.bp.get(bIq);
      if ((localReadInjoyTabDragAnimationView == null) || (localTextView == null))
      {
        QLog.d("MainFragment", 2, "iconView is null, give up !");
        return;
      }
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (localReadInjoyTabDragAnimationView.getStyle() == 1);
    localReadInjoyTabDragAnimationView.tA(1);
    localReadInjoyTabDragAnimationView.pr(true);
    return;
    localReadInjoyTabDragAnimationView.pr(false);
    return;
    localReadInjoyTabDragAnimationView.tA(0);
    return;
    localReadInjoyTabDragAnimationView.setIsSelect(false);
    return;
    localReadInjoyTabDragAnimationView.setIsSelect(true);
  }
  
  private void Bi(int paramInt)
  {
    if ((!this.aYy) || (this.bo == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mIsDefaultTheme = ").append(this.aYy).append(", mTabDragIcon is null ");
        if (this.bo != null) {
          break label72;
        }
      }
      label72:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("DynimiIcon", 2, bool);
        return;
      }
    }
    Object localObject = (TabDragAnimationView)this.bo.get(bIk);
    ((TabDragAnimationView)localObject).setBgPressedDrawable(fv[0]);
    ((TabDragAnimationView)localObject).setBgDrawable(fw[0]);
  }
  
  private boolean OI()
  {
    return this.aYy;
  }
  
  private boolean Qe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    if (getCurrentTab() == bIp) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, "当前是nowtab的话，清理红点==>isCurrentTabNowTab:" + bool);
      }
      if ((!bool) || (this.app == null)) {
        break;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((jnv)this.app.getManager(70)).a();
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52)) {
        break;
      }
      a(37, null);
      return true;
    }
  }
  
  private boolean Qf()
  {
    RedTouch localRedTouch = (RedTouch)this.gz.get(aOg);
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.aux();
  }
  
  private static boolean Qg()
  {
    String str = ThemeUtil.getCurrentThemeId();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  private boolean Qh()
  {
    toh localtoh = this.app.a().a();
    if ((localtoh != null) && (aajt.a().fl.size() > 0))
    {
      Object localObject = new ArrayList(aajt.a().fl);
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
          if (localRecentBaseData != null)
          {
            if ((localRecentBaseData.mUnreadFlag == 1) || (localRecentBaseData.mUnreadFlag == 4)) {}
            for (int i = 1; (i != 0) && (localtoh.a(localRecentBaseData)); i = 0) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void Qq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    asR();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new e();
    ((e)localObject).aOo = getResources().getString(2131721682);
    localArrayList.add(new Pair(Integer.valueOf(2131372772), localObject));
    localObject = this.app.a().a("tim.tx.android.feedback");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      e locale = new e();
      locale.aOo = ((ResourcePluginInfo)localObject).strResName;
      locale.b = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131372771), locale));
    }
    localObject = new e();
    ((e)localObject).aOo = getResources().getString(2131695710);
    localArrayList.add(new Pair(Integer.valueOf(2131372770), localObject));
    localObject = new e();
    ((e)localObject).aOo = getResources().getString(2131691040);
    localArrayList.add(new Pair(Integer.valueOf(2131372769), localObject));
    localObject = ausj.d(getActivity());
    int i = 0;
    if (i < localArrayList.size())
    {
      if (2131372769 == ((Integer)((Pair)localArrayList.get(i)).first).intValue()) {
        ((ausj)localObject).addCancelButton(((e)((Pair)localArrayList.get(i)).second).aOo);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ausj)localObject).addButton(((e)((Pair)localArrayList.get(i)).second).aOo);
      }
    }
    ((ausj)localObject).a(new vhp(this, localArrayList, (ausj)localObject));
    ((ausj)localObject).setOnDismissListener(new vhq(this));
    ((ausj)localObject).setCanceledOnTouchOutside(true);
    this.V = ((Dialog)localObject);
    try
    {
      this.V.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2131563154, null);
    ((DragTextView)localView.findViewById(2131381236)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131379150)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131380957)).setText(paramInt5);
    return localView;
  }
  
  public static MainFragment a()
  {
    MainFragment localMainFragment = new MainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localMainFragment.setArguments(localBundle);
    return localMainFragment;
  }
  
  private void a(int paramInt, e parame)
  {
    if (parame == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, parame.aOo + " is execute");
          }
          if (paramInt == 2131372772)
          {
            parame = this.jdField_a_of_type_Zju.a();
            if ((parame == null) || (parame.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              QQToast.a(this.app.getApp(), 0, acfp.m(2131708002), 0).show(getResources().getDimensionPixelSize(2131299627));
            }
            for (;;)
            {
              anot.a(this.app, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (parame.a.iUpgradeType == 0) {
                QQToast.a(this.app.getApp(), 0, acfp.m(2131707998), 0).show(getResources().getDimensionPixelSize(2131299627));
              } else if ((parame != null) && (parame.a != null)) {
                UpgradeDetailActivity.a(getActivity(), aqap.a().b(), false, false, true);
              }
            }
          }
          if (paramInt != 2131372770) {
            break;
          }
          anot.a(this.app, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (!akwp.a().a(this.app, getActivity()));
        bFu();
        return;
        if (paramInt == 2131372769)
        {
          asR();
          return;
        }
      } while (parame.b == null);
      aehl.a(this.app, getActivity(), parame.b);
    } while (!"tim.tx.android.feedback".equals(parame.b.strPkgName));
    anot.a(this.app, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
  }
  
  private void a(int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((paramRedTouch != null) && (paramRedTypeInfo != null))
    {
      switch (paramRedTypeInfo.red_type.get())
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        paramRedTouch.a();
      }
      for (;;)
      {
        paramRedTouch.c(paramRedTypeInfo);
        return;
        paramRedTouch.b(15).a();
        if (paramInt == 33)
        {
          this.aOm = acfp.m(2131707999);
        }
        else
        {
          this.aOn = acfp.m(2131707997);
          continue;
          paramRedTouch.b(5).a();
          if (paramInt == 39) {
            paramRedTouch.b(15).a();
          }
          if (paramInt == 33)
          {
            String str = paramRedTypeInfo.red_content.get();
            try
            {
              if (Integer.parseInt(str) <= 99) {
                break label175;
              }
              this.aOm = "多于99条更新";
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localNumberFormatException.printStackTrace();
            }
            continue;
            label175:
            this.aOm = (paramRedTypeInfo.red_content.get() + acfp.m(2131708001));
          }
          else
          {
            this.aOn = (paramRedTypeInfo.red_content.get() + acfp.m(2131708000));
          }
        }
      }
    }
    if (paramRedTouch != null)
    {
      paramRedTouch.a();
      paramRedTouch.c(null);
    }
    if (paramInt == 33)
    {
      this.aOm = "";
      return;
    }
    this.aOn = "";
  }
  
  private void a(TabDragAnimationView paramTabDragAnimationView, QQAppInterface paramQQAppInterface, Runnable paramRunnable)
  {
    int i = fv[0];
    paramTabDragAnimationView.setBgPressedDrawable(i);
    if (paramRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(paramRunnable);
      ThreadManager.getSubThreadHandler().post(paramRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "updateTabFocusIcon currIndex = " + i);
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
    if (aYE)
    {
      aYE = false;
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
    }
  }
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    boolean bool = Qg();
    View[] arrayOfView = new View[7];
    arrayOfView[0] = paramLayoutInflater.inflate(2131559520, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131365363));
    int i = 2130851530;
    int j = 2130851531;
    if (bool)
    {
      j = -1;
      i = -1;
    }
    arrayOfView[2] = a(i, 2130851387, j, 2130851388, 2131695649, 11, 2);
    arrayOfView[2].setOnClickListener(new c(null));
    i = 2130851528;
    j = 2130851529;
    if (bool)
    {
      j = -1;
      i = -1;
    }
    View localView1 = a(i, 2130851385, j, 2130851386, 2131695648, 12, 3);
    localView1.setOnClickListener(new c(null));
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).a(49).d(3).a(true).b(5).a();
    i = 2130851533;
    if (bool) {
      i = -1;
    }
    localView1 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
    localView1.setOnClickListener(new a(localView1, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).a(49).d(3).a(true).b(5).a();
    View localView2 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
    localView2.setOnClickListener(new a(localView2, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).a(49).d(3).a(true).b(5).a();
    localView2 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
    localView2.setOnClickListener(new a(localView1, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).a(49).d(3).a(true).b(5).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.gz = new HashMap(8);
    this.gA = new HashMap(12);
    boolean bool = Qg();
    Object localObject = ((SplashActivity)getActivity()).u;
    ((SplashActivity)getActivity()).u = null;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject[1]);
      this.s = new View[] { localObject[2], null, localObject[3], localObject[4], null, localObject[5], null, localObject[6] };
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(this.jdField_a_of_type_Aali);
      this.gz.put(aOe, this.s[0]);
      this.gz.put(aOf, this.s[2]);
      this.gz.put(aOg, this.s[3]);
      this.gz.put("动态", this.s[7]);
      this.gz.put(aOe + "_num", this.s[0].findViewById(2131381236));
      this.gz.put(aOf + "_num", this.s[2].findViewById(2131381236));
      this.gz.put(aOg + "_num", this.s[3].findViewById(2131381236));
      this.gz.put("动态_num", this.s[7].findViewById(2131381236));
      localObject = (TabDragAnimationView)this.s[0].findViewById(2131379150);
      ((TabDragAnimationView)localObject).setTag(aOe);
      ((TabDragAnimationView)localObject).setOnDragListener(new vhg(this));
      ((TabDragAnimationView)localObject).setOnLongClickListener(new vhh(this));
      paramView = (QQTabWidget)paramView.findViewById(16908307);
      if (paramView == null) {
        break label910;
      }
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$a);
    }
    for (;;)
    {
      return this.s;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131365363));
      int i = 2130851528;
      int j = 2130851528;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      localObject = a(i, 2130851385, j, 2130851386, 2131695648, 12, 3);
      ((View)localObject).setOnClickListener(new c(null));
      i = 2130851533;
      if (bool) {
        i = -1;
      }
      View localView1 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
      localView1.setOnClickListener(new a(localView1, "lebaTab"));
      View localView2 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
      localView2.setOnClickListener(new a(localView2, "qzoneTab"));
      View localView3 = a(-1, 2130851536, i, 2130851535, 2131695652, 14, 4);
      localView3.setOnClickListener(new a(localView3, "lebaTabNew"));
      View localView4 = a(2130847373, 2130851389, 2130847374, 2130851390, 2131701921, 15, 5);
      localView4.setOnClickListener(new c(null));
      i = 2130851530;
      j = 2130851531;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      View localView5 = a(i, 2130851387, j, 2130851388, 2131695649, 11, 2);
      localView5.setOnClickListener(new c(null));
      this.s = new View[] { localView5, null, new RedTouchTab(getActivity(), (View)localObject).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView1).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView4).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView3).a(49).d(3).a(true).b(5).a(), null, new RedTouchTab(getActivity(), localView2).a(49).d(3).a(true).b(5).a() };
      break;
      label910:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
  }
  
  private void al(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.bo.get(paramInt1);
    if (localTabDragAnimationView != null)
    {
      if (this.aYy) {
        paramInt2 = -1;
      }
      localTabDragAnimationView.setFaceDrawable(paramInt2);
      if (!this.aYy) {
        break label53;
      }
    }
    label53:
    for (paramInt1 = i;; paramInt1 = paramInt3)
    {
      localTabDragAnimationView.setFacePressedDrawable(paramInt1);
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap)
  {
    if (paramHashMap != null) {}
    label154:
    label161:
    for (;;)
    {
      try
      {
        if (paramHashMap.get(aOh) == null) {
          continue;
        }
        paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(aOh)).getTag(2131376780);
        if (paramHashMap == null) {
          break label154;
        }
        j = eN(paramHashMap.red_type.get());
        if (j != 1) {
          continue;
        }
        i = Integer.parseInt(paramHashMap.red_content.get());
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MainFragment", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X80098E1", "0X80098E1", 0, 0, "" + j, "" + i, "", "");
      return;
      int i = 1;
      break label161;
      i = 0;
      int j = 0;
    }
  }
  
  private int bD(String paramString)
  {
    int i = bIk;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return i;
      if (paramString.equals(Conversation.class.getName())) {
        return bIk;
      }
      if (paramString.equals(Contacts.class.getName()))
      {
        i = bIm;
        bRu();
        return i;
      }
      if (paramString.equals(TimLeba.class.getName())) {
        return bIn;
      }
      if (paramString.equals(Now.class.getName())) {
        return bIp;
      }
      if (paramString.equals(ReadinjoyTabFrame.class.getName())) {
        return bIq;
      }
    } while (!paramString.equals(QzoneFrame.class.getName()));
    return bIs;
  }
  
  private int bE(String paramString)
  {
    if (this.gA == null) {
      return 0;
    }
    Object localObject = this.gA.get(paramString + "_new");
    int i;
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      i = 2;
    }
    for (;;)
    {
      return i;
      localObject = this.gA.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        i = 3;
      }
      else
      {
        paramString = this.gA.get(paramString + "_icon");
        if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private void bRA()
  {
    if (Qe()) {}
    do
    {
      do
      {
        return;
      } while (this.app == null);
      localObject = (jnv)this.app.getManager(70);
    } while ((this.gz == null) || (!this.gz.containsKey("NOW_num")));
    oidb_0x791.RedDotInfo localRedDotInfo = ((jnv)localObject).a();
    if (localRedDotInfo == null)
    {
      a(37, null);
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    Object localObject = "";
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return;
    case 8: 
    case 35: 
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "更新tab红点:" + jnv.a(localRedDotInfo));
      }
      a(37, localRedTypeInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MainFragmentQ.qqstory.redPoint", 2, "redDotInfo==>style:" + 0 + ", num:" + 0 + ", text:" + (String)localObject);
      return;
      if (localRedDotInfo.uint32_number.get() > 99) {}
      for (localObject = "99+";; localObject = localRedDotInfo.uint32_number.get() + "")
      {
        localRedTypeInfo.red_type.set(4);
        localRedTypeInfo.red_content.set((String)localObject);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        break;
      }
      localObject = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_content.set((String)localObject);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
    }
  }
  
  private void bRB()
  {
    awit.eDK();
    ((KandianMergeManager)this.app.getManager(162)).aIQ();
    if (awit.aMG())
    {
      Object localObject = (RedTouch)this.gz.get(aOh);
      if (localObject != null)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)localObject).getTag(2131376780);
        kxm.a(this.app, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
      ThreadManager.executeOnSubThread(new MainFragment.18(this));
    }
  }
  
  private void bRD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconDoubleClick mIsDefaultTheme = " + this.aYy);
    }
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1071));
      }
      if (this.aYy)
      {
        a((TabDragAnimationView)this.bo.get(bIk), this.app, this.jdField_do);
        if (!this.aYF) {
          this.aYF = true;
        }
      }
    }
  }
  
  private void bRE()
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.bo.get(bIk);
    Object localObject = (String)localTabDragAnimationView.getTag();
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconMoveResult mIsDefaultTheme = " + this.aYy + ", tag = " + (String)localObject);
    }
    if ((this.aYy) && (getCurrentTab() == bIk) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(aOe)))
    {
      localObject = (Conversation)a(Conversation.class);
      if (localObject == null) {
        break label152;
      }
    }
    label152:
    for (int i = ((Conversation)localObject).bGd;; i = 0)
    {
      if (i <= 0)
      {
        a(localTabDragAnimationView, this.app, this.jdField_do);
        if (!this.aYF) {
          this.aYF = true;
        }
      }
      return;
    }
  }
  
  private void bRH()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    for (;;)
    {
      return;
      Intent localIntent = null;
      if (aqed.aBX()) {
        if (aqmj.cd(localFragmentActivity))
        {
          localIntent = new Intent(getActivity(), KeepAliveGuideActivity.class);
          localIntent.putExtra("GUIDE_FIRST_RUN", 0);
          aqmj.N(localFragmentActivity, false);
        }
      }
      while (localIntent != null)
      {
        getActivity().runOnUiThread(new MainFragment.22(this, localIntent));
        return;
        if (Build.VERSION.SDK_INT >= 23) {
          localIntent = p();
        } else {
          localIntent = q();
        }
      }
    }
  }
  
  private void bRt()
  {
    try
    {
      Intent localIntent = getActivity().getIntent();
      if (localIntent != null) {
        localIntent.putExtra("current_tab_tag", getCurrentTab());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MainFragment", 1, "setCurrentIntentParams", localException);
    }
  }
  
  private void bRv()
  {
    this.bo = new SparseArray(3);
    this.bp = new SparseArray(3);
    d locald = new d(null);
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.s[0].findViewById(2131379150);
    localTabDragAnimationView.setOnTouchListener(locald);
    localTabDragAnimationView.Wx("消息");
    this.bo.put(bIk, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.s[2].findViewById(2131379150);
    localTabDragAnimationView.setOnTouchListener(locald);
    localTabDragAnimationView.setExpectedLogoMoveDistance(aqnm.dpToPx(2.0F));
    localTabDragAnimationView.Wx("联系人");
    this.bo.put(bIm, localTabDragAnimationView);
    if (!aYC)
    {
      localTabDragAnimationView = (TabDragAnimationView)this.s[3].findViewById(2131379150);
      localTabDragAnimationView.setOnTouchListener(locald);
      localTabDragAnimationView.Wx("我的");
      this.bo.put(bIn, localTabDragAnimationView);
    }
    this.bp.put(bIk, (TextView)this.s[0].findViewById(2131380957));
    this.bp.put(bIm, (TextView)this.s[2].findViewById(2131380957));
    if (!aYC) {
      this.bp.put(bIn, (TextView)this.s[3].findViewById(2131380957));
    }
  }
  
  private void bRw()
  {
    int j = -1;
    if (Qg()) {}
    for (int i = -1;; i = 2130844058)
    {
      View localView = kvu.a(i, 2130851393, j, 2130851394, 2131696077, 16, 8);
      if (localView != null)
      {
        localView.setOnClickListener(new vhi(this));
        this.s[6] = new RedTouch(getActivity(), localView).a(49).d(3).b(5).a();
        this.gz.put(aOh, this.s[6]);
        this.gz.put(aOh + "_num", this.s[6].findViewById(2131381236));
        localView.setContentDescription(getResources().getString(2131696077));
      }
      return;
      j = 2130844059;
    }
  }
  
  private void bRx()
  {
    boolean bool3 = true;
    Object localObject2 = (RedTouch)this.gz.get(aOh);
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if (localObject2 != null)
    {
      Object localObject3 = c();
      if ((localObject3 == null) || (!(localObject3 instanceof ReadinjoyTabFrame))) {
        break label293;
      }
      bool1 = true;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.app.getManager(162);
      localObject1 = localKandianMergeManager.l();
      if ((localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5)) {
        break label298;
      }
      bool2 = true;
      label84:
      if ((!bool1) || (localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 0)) {
        break label317;
      }
      localObject3 = (ReadinjoyTabFrame)localObject3;
      if (((((ReadinjoyTabFrame)localObject3).a() == null) || (((ReadinjoyTabFrame)localObject3).a().mChannelCoverId == 0)) && (localKandianMergeManager.ol() <= 0)) {
        break label317;
      }
      localObject1 = null;
    }
    label293:
    label298:
    label303:
    label308:
    label317:
    for (;;)
    {
      ((RedTouch)localObject2).setTag(2131376780, localObject1);
      a(39, (RedTouch)localObject2, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (isVisible()) && (kxm.isAppOnForeground(null)) && (localObject1 != null)) {
        kxm.a(this.app, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("updateKandianTabRedPoint isInTabFrame : ").append(bool1).append(", isRemoveRedPoint : ");
        if (localObject1 != null) {
          break label303;
        }
        bool1 = bool3;
        label236:
        localObject2 = ((StringBuilder)localObject2).append(bool1).append(", isNumRedPoint : ").append(bool2).append(", cnt : ");
        if (localObject1 == null) {
          break label308;
        }
      }
      for (localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get();; localObject1 = Integer.valueOf(0))
      {
        QLog.d("Q.readinjoy.4tab", 2, localObject1);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label84;
        bool1 = false;
        break label236;
      }
    }
  }
  
  private void cc(Intent paramIntent)
  {
    aqju localaqju = new aqju(getActivity(), 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(2131695165);
    localaqju.setMessage(2131695160);
    localaqju.setPositiveButton(2131695169, new vhm(this, paramIntent));
    localaqju.setNegativeButton(2131694716, new vhn(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    localaqju.show();
  }
  
  private void dn(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)this.gz.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label52:
    int i;
    Object localObject1;
    if (aOe.equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      i = bE(paramString1);
      localObject1 = (TextView)this.gz.get(paramString1 + "_num");
      if (i != 2) {
        break label281;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if (aOg.equals(paramString1)) {
        localStringBuilder.append(this.aOn);
      }
      localObject1 = (TextView)paramString2.findViewById(2131380957);
      Object localObject2 = paramString2.findViewById(2131379150);
      if (localObject2 != null)
      {
        ((View)localObject2).setContentDescription(paramString1);
        aqcl.Q((View)localObject2, false);
      }
      if (localObject1 != null) {
        aqcl.Q((View)localObject1, false);
      }
      if (!(paramString2 instanceof RedTouchTab)) {
        break label604;
      }
      ((RedTouchTab)paramString2).cq().setContentDescription(localStringBuilder.toString());
      return;
      if (aOf.equals(paramString1))
      {
        localStringBuilder.append("联系人 ");
        break label52;
      }
      if (aOg.equals(paramString1))
      {
        localStringBuilder.append(aOg);
        break label52;
      }
      if (!"NOW".equals(paramString1)) {
        break;
      }
      localStringBuilder.append(plr.asY + " ");
      break label52;
      label281:
      if (i == 3)
      {
        if (aOe.equals(paramString1))
        {
          localObject1 = ((TextView)localObject1).getText().toString();
          if ("".equals(localObject1)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append((String)localObject1 + "条未读");
          }
        }
        else if (aOf.equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0)
          {
            if ("99+".equals(localObject2)) {
              localStringBuilder.append("多于99条更新");
            } else {
              localStringBuilder.append((String)localObject2 + "条更新");
            }
          }
          else {
            localStringBuilder.append(this.aOm);
          }
        }
        else if ("NOW".equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0) {
            if ("99+".equals(localObject2)) {
              localStringBuilder.append("多于99个新的" + plr.asY);
            } else {
              localStringBuilder.append((String)localObject2 + "个新的" + plr.asY);
            }
          }
        }
      }
      else if (i == 1) {
        localStringBuilder.append("有新消息");
      } else if (aOf.equals(paramString1)) {
        localStringBuilder.append(this.aOm);
      }
    }
    label604:
    paramString2.setContentDescription(localStringBuilder.toString());
  }
  
  private static int eN(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 0: 
      return 2;
    case 3: 
      return 6;
    case 4: 
      return 5;
    case 5: 
      return 1;
    }
    return 4;
  }
  
  private void eO(View paramView)
  {
    if (paramView == null)
    {
      QLog.e("MainFragment", 1, "disableBlur: tabWidget == null");
      return;
    }
    paramView.setBackgroundResource(2130851026);
    int i = 0;
    label23:
    if (i < this.s.length) {
      if (this.s[i] != null) {
        break label48;
      }
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label48:
      this.s[i].setBackgroundResource(2130851538);
    }
  }
  
  private String getCurrentTabTag()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "getCurrentTabTag. mTabHost is null");
      }
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        str1 = "";
        str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag();
        localObject = str1;
      } while (str2 == null);
      if (str2.equals(Conversation.class.getName())) {
        return aOe;
      }
      if (str2.equals(Contacts.class.getName())) {
        return aOf;
      }
      if (str2.equals(TimLeba.class.getName())) {
        return aOg;
      }
      if (str2.equals(Now.class.getName())) {
        return "NOW";
      }
      localObject = str1;
    } while (!str2.equals(QzoneFrame.class.getName()));
    return "动态";
  }
  
  private void h(View paramView1, View paramView2)
  {
    boolean bool = true;
    if (paramView1 == null)
    {
      QLog.e("MainFragment", 1, "enableBlur: tabWidget == null");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.iD(paramView2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.YK(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.YJ(-1);
    paramView2 = this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView;
    label74:
    int i;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView2.setEnableBlur(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130841426);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.a(new vhk(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
      paramView1.setBackgroundColor(0);
      i = 0;
      label126:
      if (i < this.s.length) {
        if (this.s[i] != null) {
          break label157;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label126;
      break;
      bool = false;
      break label74;
      label157:
      this.s[i].setBackgroundColor(0);
    }
  }
  
  private static void h(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = 0;
    int j = 2;
    int k = 1;
    if (paramBoolean1)
    {
      bIk = 0;
      bIl = 1;
      bIm = 2;
      bIn = 3;
      bIp = -100;
    }
    for (bIo = -100;; bIo = -100)
    {
      if (aYC) {
        bIn = -100;
      }
      return;
      if (paramInt < 0) {
        break;
      }
      if (paramInt <= 0) {
        i = 1;
      }
      bIk = i;
      i = k;
      if (1 >= paramInt) {
        i = 2;
      }
      bIm = i;
      i = j;
      if (2 >= paramInt) {
        i = 3;
      }
      bIn = i;
      bIp = paramInt;
      bIl = -100;
    }
    bIk = 0;
    bIl = -100;
    bIm = 1;
    bIn = 2;
    if (paramBoolean2)
    {
      bIq = bIr;
      bIn = 3;
    }
    for (;;)
    {
      bIp = -100;
      bIl = -100;
      bIo = -100;
      break;
      bIq = -100;
    }
  }
  
  private Intent q()
  {
    if ((getActivity() != null) && (Build.VERSION.SDK_INT >= 21) && (aqmj.k(this.app.getCurrentUin(), getActivity())) && (QQToast.MK() == 0))
    {
      aqmj.f(this.app.getCurrentUin(), getActivity(), false);
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment_PushOpenNotify", 2, "doafterlogin");
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.parse("package:" + this.app.getApp().getPackageName()));
      return localIntent;
    }
    return null;
  }
  
  public static int r(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("main_tab_id"))) {
      return -2147483648;
    }
    switch (paramBundle.getInt("main_tab_id"))
    {
    case 7: 
    case 8: 
    default: 
      return -2147483648;
    case 1: 
      return bIk;
    case 2: 
      return bIl;
    case 3: 
      return bIm;
    case 4: 
      return bIn;
    case 5: 
      return bIo;
    case 6: 
      return bIp;
    }
    return bIs;
  }
  
  private void xC(boolean paramBoolean)
  {
    int k = this.bIu;
    boolean bool = aYC;
    if (this.afF)
    {
      i = 1;
      if (this.aYD == anlm.Vr()) {
        break label234;
      }
    }
    label234:
    for (int j = 1;; j = 0)
    {
      this.aYD = anlm.Vr();
      if ((!paramBoolean) && ((!this.app.bJb) || (this.s[1] != null)) && ((this.app.bJb) || (this.s[1] == null)) && (this.bIu == k) && (this.s[4] == null) && (i == 0) && (j == 0)) {
        break label788;
      }
      jsp.abw = false;
      kvu.mN(true);
      zjq.cdv |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.i("MainFragment", 2, "setFrames" + this.app.bJb);
      }
      this.bIu = k;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      j = this.s.length;
      i = 0;
      while (i < j)
      {
        localObject = this.s[i];
        if (localObject != null)
        {
          ((View)localObject).setSelected(false);
          ((View)localObject).setId(i + 16);
        }
        i += 1;
      }
      i = 0;
      break;
    }
    h(this.app.bJb, -100, false);
    bRv();
    Object localObject = a(Conversation.class);
    if (localObject != null) {
      ((Conversation)localObject).wQ(true);
    }
    this.s[1] = null;
    this.s[4] = null;
    this.gz.remove("NOW");
    this.gz.remove("NOW_num");
    f(Now.class);
    int i = this.bIu;
    if ((i == 0) && (this.s[4] != null)) {
      a(this.mRootView, Now.class, this.s[4]);
    }
    a(this.mRootView, Conversation.class, this.s[0]);
    if ((i == 1) && (this.s[4] != null)) {
      a(this.mRootView, Now.class, this.s[4]);
    }
    a(this.mRootView, Contacts.class, this.s[2]);
    f(ReadinjoyTabFrame.class);
    this.bo.remove(bIq);
    this.bp.remove(bIq);
    this.afF = false;
    if ((i == 2) && (this.s[4] != null)) {
      a(this.mRootView, Now.class, this.s[4]);
    }
    this.gz.put(aOg, this.s[3]);
    this.gz.put(aOg + "_num", this.s[3].findViewById(2131381236));
    if (avsn.b(getActivity(), this.app))
    {
      f(TimLeba.class);
      a(this.mRootView, QzoneFrame.class, this.s[7]);
      this.gz.put("动态", this.s[7]);
      this.gz.put("动态_num", this.s[7].findViewById(2131381236));
      localObject = (TabDragAnimationView)this.s[7].findViewById(2131379150);
      TextView localTextView = (TextView)this.s[7].findViewById(2131380957);
      this.bo.put(bIs, localObject);
      this.bp.put(bIs, localTextView);
    }
    for (;;)
    {
      if ((i == 3) && (this.s[4] != null)) {
        a(this.mRootView, Now.class, this.s[4]);
      }
      kvu.mN(false);
      xD(false);
      if (bool)
      {
        f(Leba.class);
        this.bo.remove(bIn);
        this.gz.remove(aOg);
        this.gz.remove(aOg + "_num");
      }
      label788:
      return;
      this.bo.remove(bIs);
      this.bp.remove(bIs);
      f(QzoneFrame.class);
      a(this.mRootView, TimLeba.class, this.s[3]);
    }
  }
  
  private void xD(boolean paramBoolean)
  {
    int m = 0;
    this.aYy = Qg();
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "checkEnableTabAnim() called with: onPostThemeChanged = [" + paramBoolean + "], mIsDefaultTheme=[" + this.aYy + "]");
    }
    float f = getResources().getDisplayMetrics().density;
    int i;
    int n;
    Object localObject1;
    int j;
    if (this.aYy)
    {
      i = Math.round(54.0F * f);
      n = Math.round(6.0F * f);
      if (this.bo == null) {
        break label377;
      }
      if (!this.aYy) {
        break label321;
      }
      localObject1 = (Conversation)a(Conversation.class);
      if (localObject1 == null) {
        break label315;
      }
      j = ((Conversation)localObject1).bGd;
      label136:
      Bi(j);
      label142:
      boolean bool = ThemeUtil.isNowThemeIsAnimate();
      j = 0;
      label150:
      if (j >= this.bo.size()) {
        break label377;
      }
      localObject1 = (TabDragAnimationView)this.bo.valueAt(j);
      ((TabDragAnimationView)localObject1).isThemeIsAnimate = bool;
      ((TabDragAnimationView)localObject1).P = null;
      if (!this.aYy) {
        break label359;
      }
      k = (int)(29.0F * f + 0.5F);
      label208:
      ((TabDragAnimationView)localObject1).setIconSize(k, k);
      ((TabDragAnimationView)localObject1).setAnimEnable(this.aYy);
      if (!this.aYy) {
        break label365;
      }
      k = 1;
      label236:
      ((TabDragAnimationView)localObject1).setIconGravity(k);
      if (!this.aYy) {
        break label371;
      }
    }
    Object localObject2;
    label315:
    label321:
    label359:
    label365:
    label371:
    for (int k = (int)(5.0F * f + 0.5F);; k = 0)
    {
      ((TabDragAnimationView)localObject1).setPadding(0, k, 0, k);
      localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      j += 1;
      break label150;
      i = -2;
      break;
      j = 0;
      break label136;
      localObject1 = (TabDragAnimationView)this.bo.get(bIk);
      ((TabDragAnimationView)localObject1).setBgPressedDrawable(fv[0]);
      ((TabDragAnimationView)localObject1).setBgDrawable(fw[0]);
      break label142;
      k = -1;
      break label208;
      k = 0;
      break label236;
    }
    label377:
    if (this.bp != null)
    {
      j = 0;
      if (j < this.bp.size())
      {
        localObject1 = (TextView)this.bp.valueAt(j);
        if (this.aYy)
        {
          ((TextView)localObject1).setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = n;
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          j += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    if (this.mRootView != null)
    {
      localObject1 = this.mRootView.findViewById(16908307);
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (this.aYy))
      {
        long l = System.currentTimeMillis();
        localObject2 = this.mRootView.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          j = ((View)localObject2).getPaddingBottom();
          if (((i <= 0) || (j == i)) || (QLog.isColorLevel())) {
            QLog.d("MainFragment", 2, "checkEnableTabAnim, height=" + i + ", padding=" + j + ", cost=" + (System.currentTimeMillis() - l));
          }
        }
      }
      localObject2 = this.mRootView.findViewById(16908305);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mRootView.findViewById(2131381456));
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.setDebugTag("TAB");
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      if (OI())
      {
        h((View)localObject1, (View)localObject2);
        i = m;
      }
      while (i < this.bo.size())
      {
        localObject1 = (TabDragAnimationView)this.bo.valueAt(i);
        ((TabDragAnimationView)localObject1).setEnableClickScaleAnimation(true);
        ((TabDragAnimationView)localObject1).setClickAnimationDrawable(null);
        i += 1;
        continue;
        eO((View)localObject1);
        i = m;
      }
      al(bIk, 2130851530, 2130851531);
      al(bIm, 2130851528, 2130851529);
      al(bIq, 2130844058, 2130844059);
      al(bIn, -1, 2130851533);
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756467);
    localReportDialog.setContentView(2131559304);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365867);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365863);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365852);
      if (paramString1 != null) {
        paramString1.setText(2131721058);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365858);
      if (paramString1 != null) {
        paramString1.setText(2131721079);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public RedTouch a(String paramString)
  {
    return (RedTouch)this.gz.get(paramString);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.gz == null) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 35: 
        case 36: 
        case 38: 
        default: 
          return;
        }
      } while (this.gz == null);
      a(paramInt, (RedTouch)this.gz.get(aOf), paramRedTypeInfo);
      return;
      paramRedTypeInfo = (RedTouch)this.gz.get(aOg);
      return;
    } while (this.gz == null);
    a(paramInt, (RedTouch)this.gz.get("NOW"), paramRedTypeInfo);
    return;
    bRx();
  }
  
  public void asR()
  {
    if ((this.V == null) || (this.V.isShowing())) {}
    try
    {
      this.V.dismiss();
      label24:
      this.V = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void bFu()
  {
    bFv();
    Dialog localDialog = a(getString(2131695589), null, new vhr(this));
    Object localObject = (TextView)localDialog.findViewById(2131365858);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new vhe(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365852);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new vhf(this));
    }
    localObject = getString(2131718627);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.aQW = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131364575);
    if ((bool) && (this.aQW)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.aQW);
    this.y = localDialog;
    this.y.show();
  }
  
  public void bFv()
  {
    if ((this.y == null) || (this.y.isShowing())) {}
    try
    {
      this.y.dismiss();
      label24:
      this.y = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void bJz() {}
  
  public void bMp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete[" + getCurrentTabTag() + "]");
    }
    super.bMp();
    Object localObject = b();
    if (localObject != null) {
      ((acep)localObject).bMp();
    }
    if (aYt)
    {
      this.jdField_a_of_type_Zju.cpH();
      aYt = false;
      ThreadManager.getUIHandler().postDelayed(new MainFragment.3(this), 2000L);
    }
    aqmq.track("Main_Start", null);
    localObject = getCurrentTabTag();
    if (aOe.equals(localObject)) {}
    try
    {
      abmt.a(getActivity(), (Conversation)a(Conversation.class));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MainFragment", 2, "show cmgame app pop error e=" + localThrowable.toString());
    }
  }
  
  protected void bRC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "revertConversationIconChange mPreResIndex = " + bIv);
    }
    aYE = true;
    this.aYF = false;
    Conversation localConversation = (Conversation)a(Conversation.class);
    if (localConversation != null) {}
    for (int i = localConversation.bGd;; i = 0)
    {
      Bi(i);
      return;
    }
  }
  
  public void bRF()
  {
    if (getCurrentTab() == bIk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      bRC();
    }
  }
  
  public void bRG()
  {
    if (getCurrentTab() == bIk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      bRC();
    }
  }
  
  void bRu()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.5(this), 500L);
  }
  
  public void bRy()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).isForeground()))
    {
      localObject = (aqxh)this.app.getManager(76);
      if (localObject != null)
      {
        aqxg localaqxg = ((aqxh)localObject).a();
        if ((localaqxg != null) && (isResumed()) && (localaqxg.status == 2L)) {
          ((aqxh)localObject).a(localaqxg, getActivity());
        }
      }
    }
  }
  
  public void bRz()
  {
    acep localacep = b();
    if (localacep != null) {
      localacep.bRz();
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 82)
    {
      Qq();
      bool = true;
    }
    while (paramInt != 4) {
      return bool;
    }
    paramKeyEvent = b();
    if ((paramKeyEvent != null) && (paramKeyEvent.onBackPressed())) {
      return true;
    }
    try
    {
      paramKeyEvent = (PendingIntent)getActivity().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
      if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!getActivity().getIntent().getBooleanExtra("share_from_aio", false))) {
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
        }
      }
      try
      {
        paramKeyEvent.send();
        getActivity().moveTaskToBack(true);
      }
      catch (PendingIntent.CanceledException paramKeyEvent)
      {
        for (;;)
        {
          QLog.e("MainFragment", 2, "failed to send PendingIntent", paramKeyEvent);
        }
      }
      return true;
    }
    catch (Throwable paramKeyEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "", paramKeyEvent);
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    this.mNewIntent = paramIntent;
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_Zju == null)
      {
        bool = true;
        QLog.d("MainFragment", 2, bool);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 1, "doOnNewIntent1 : url" + paramIntent.getStringExtra("url"));
      }
      aYB = false;
      if (this.jdField_a_of_type_Zju != null) {
        break label109;
      }
    }
    label109:
    do
    {
      return;
      bool = false;
      break;
      aahb.b(this.app, paramIntent);
      localObject1 = paramIntent.getExtras();
    } while (localObject1 == null);
    if (Boolean.valueOf(((Bundle)localObject1).getBoolean("EXIT", false)).booleanValue())
    {
      getActivity().finish();
      return;
    }
    int i;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      i = ((Bundle)localObject1).getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + i);
      }
      int j;
      Object localObject2;
      label431:
      label439:
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (i >= 0))
      {
        if (i == bIk)
        {
          j = ((Bundle)localObject1).getInt("conversation_index", -1);
          ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          if ((1 == j) && ((this.app == null) || (!this.app.bJb))) {}
        }
        else
        {
          if ((i != bIk) || (i != getCurrentTab())) {
            break label439;
          }
          paramIntent = (Conversation)a(Conversation.class);
          localObject2 = ((Bundle)localObject1).getString("from");
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "doOnNewIntent, same tab,from=" + (String)localObject2);
          }
          if (paramIntent == null) {
            break;
          }
          if ((!"10003".equals(localObject2)) && (!"10004".equals(localObject2))) {
            break label431;
          }
        }
        for (paramIntent.aUN = true;; paramIntent.aUN = false)
        {
          paramIntent.aUO = ((Bundle)localObject1).getBoolean("theme_back_to_conversation", false);
          return;
          if (!((Bundle)localObject1).containsKey("main_tab_id")) {
            break label1189;
          }
          i = r((Bundle)localObject1);
          break;
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null) {
              paramIntent.aUM = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((i == bIl) && (!this.app.bJb))
        {
          i = bIk;
          ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null) {
              paramIntent.aUM = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount()))
        {
          localObject3 = (Conversation)a(Conversation.class);
          localObject2 = ((Bundle)localObject1).getString("from");
          if (localObject3 != null)
          {
            if ("10003".equals(localObject2)) {
              ((Conversation)localObject3).aUN = true;
            }
          }
          else
          {
            label563:
            if (("smartdevice".equals(localObject2)) && (i == bIm))
            {
              localObject3 = (Contacts)a(Contacts.class);
              if (localObject3 != null) {
                ((Contacts)localObject3).Bh(true);
              }
            }
            if ((i == bIp) && (i == getCurrentTab()))
            {
              localObject3 = (Now)a(Now.class);
              if (localObject3 != null)
              {
                ((Now)localObject3).aYT = ((Bundle)localObject1).getBoolean("extra_from_share");
                ((Now)localObject3).aOA = ((Bundle)localObject1).getString("new_video_extra_info");
              }
            }
            if ((i == bIn) && ("campus_notice".equals(localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.cgR) }));
              }
              if (DrawerFrame.cgR == 0) {
                DrawerFrame.cgR = 3;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i);
          }
        }
      }
      for (;;)
      {
        try
        {
          i = paramIntent.getIntExtra("forward", -1);
          j = paramIntent.getIntExtra("uintype", -1);
          if ((i <= 0) || ((j != 1035) && (j != 1041) && (j != 1042)) || (!this.app.iz(284))) {
            break label936;
          }
          ((aizd)this.app.getManager(284)).R(getActivity(), paramIntent);
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MainFragment", 2, "", paramIntent);
        return;
        ((Conversation)localObject3).aUN = false;
        break label563;
        if (i == bIs)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(bIn);
        }
        else if ((i >= 0) && ((i == bIp) || (i == bIr)) && (i != getCurrentTab()))
        {
          this.I = paramIntent;
          continue;
          if ((i == bIr) && (awit.Vs()))
          {
            this.I = paramIntent;
            QLog.d("MainFragment", 1, "MainActivity:onNewIntent mTabHost, jump kandian tab fail, set pengingIntent");
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
          }
        }
      }
      label936:
      if (i == 2)
      {
        localObject1 = paramIntent.getParcelableExtra("AllInOne");
        if ((localObject1 instanceof ProfileActivity.AllInOne))
        {
          localObject1 = (ProfileActivity.AllInOne)localObject1;
          ((ProfileActivity.AllInOne)localObject1).bIZ = 100;
          ((ProfileActivity.AllInOne)localObject1).bJa = 6;
          ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
        }
      }
      for (;;)
      {
        paramIntent.removeExtra("forward");
        return;
        if (i == 3)
        {
          localObject1 = paramIntent.getStringExtra("url");
          localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
          if (j != -1)
          {
            ((Intent)localObject2).putExtra("uintype", j);
            if ((j == 1030) && (this.app.iz(240)))
            {
              localObject3 = new anop.a();
              ((anop.a)localObject3).Ur = "0X8009241";
              ((anop.a)localObject3).Uq = "点击业务Push";
              anop.a((String)localObject1, (anop.a)localObject3);
              anop.a(this.app, (anop.a)localObject3);
              ((aeam)this.app.getManager(240)).a(null);
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, "remove campus notice");
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 1, "doOnNewIntent : url" + (String)localObject1);
          }
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          startActivity((Intent)localObject2);
        }
      }
      label1189:
      i = -1;
    }
  }
  
  public void f(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.s == null) {}
    boolean bool;
    String str2;
    String str1;
    label56:
    Object localObject;
    label87:
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str2 = "";
      switch (paramInt1)
      {
      default: 
        str1 = "";
        switch (paramInt2)
        {
        default: 
          localObject = null;
          localTextView = (TextView)this.gz.get(str1 + "_num");
        }
        break;
      }
    } while ((localTextView == null) || (localObject == null));
    int i;
    if ((paramObject instanceof Integer)) {
      i = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label146:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
      label232:
      int m;
      int k;
      label318:
      int j;
      label367:
      int i1;
      int n;
      if (((String)localObject).equals(str1 + "_num"))
      {
        localSharedPreferences.edit().putInt((String)localObject + this.app.getAccount(), i).commit();
        this.gA.put(localObject, paramObject);
        i = 0;
        m = bE(str1);
        if (m != 3) {
          break label818;
        }
        localObject = this.gA.get(str1 + "_num");
        k = i;
        paramObject = str2;
        if ((localObject instanceof Integer))
        {
          k = ((Integer)localObject).intValue();
          paramObject = str2;
        }
        j = 0;
        if (paramInt1 != 32) {
          break label952;
        }
        if ((k <= 99) || (anlm.ayn())) {
          break label900;
        }
        m = getResources().getDimensionPixelSize(2131297700);
        if (!this.aYy) {
          break label889;
        }
        i = aqnm.dpToPx(7.0F);
        i1 = 4;
        j = 2130851410;
        n = i;
        i = i1;
        i1 = m;
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).setMargins(n, i1, 0, 0);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (Qh()) {
          this.aYF = false;
        }
        if (!this.aYF) {
          Bi(k);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i).append(",").append("num = ").append(k).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
          QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
        }
        aute.updateCustomNoteTxt(localTextView, i, k, j, 99, paramObject);
        if (!AppSetting.enableTalkBack) {
          break;
        }
        dn(aOe, getCurrentTabTag());
        dn(aOf, getCurrentTabTag());
        dn(aOg, getCurrentTabTag());
        dn("NOW", getCurrentTabTag());
        return;
        str1 = aOe;
        break label56;
        str1 = aOf;
        break label56;
        Bh(paramInt2);
        return;
        localObject = str1 + "_num";
        break label87;
        localObject = str1 + "_icon";
        break label87;
        localObject = str1 + "_new";
        break label87;
        if (!(paramObject instanceof Boolean)) {
          break label959;
        }
        bool = ((Boolean)paramObject).booleanValue();
        i = 0;
        break label146;
        localSharedPreferences.edit().putBoolean((String)localObject + this.app.getAccount(), bool).commit();
        break label232;
        label818:
        k = i;
        paramObject = str2;
        if (m != 5) {
          break label318;
        }
        localObject = this.gA.get(str1 + "_text");
        k = i;
        paramObject = str2;
        if (!(localObject instanceof String)) {
          break label318;
        }
        paramObject = (String)localObject;
        k = i;
        break label318;
        label889:
        i = aqnm.dpToPx(5.0F);
        break label367;
        label900:
        i1 = getResources().getDimensionPixelSize(2131297699);
        if (this.aYy) {}
        for (i = aqnm.dpToPx(7.0F);; i = aqnm.dpToPx(5.0F))
        {
          j = 0;
          n = i;
          i = m;
          break;
        }
        label952:
        i = m;
      }
      label959:
      i = 0;
    }
  }
  
  public String getCIOPageName()
  {
    if (b() != null) {
      return b().getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public int getCurrentTab()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return i;
    }
    QLog.e("MainFragment", 2, "getCurrentTab");
    return 0;
  }
  
  public String oT()
  {
    return this.aOi;
  }
  
  public String oU()
  {
    if ((getCurrentTab() == bIk) && ((b() instanceof Conversation)) && (((Conversation)c()).a.isResume())) {
      return "QQSettingMe";
    }
    return oT();
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    aYB = false;
    QQAppInterface localQQAppInterface = this.app;
    super.onAccountChanged();
    this.app = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.cvh = -1;
    this.aYx = false;
    ThreadManager.post(new MainFragment.4(this), 2, null, true);
    if ((this.app != null) && (this.jdField_a_of_type_Zju != null))
    {
      this.jdField_a_of_type_Zju.brx = false;
      this.jdField_a_of_type_Zju.cpF();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.aOj)) && (this.aOj.equals(this.app.getAccount()))) {}
    }
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("MainFragment", 241);
      localQQNotificationManager.cancel("MainFragment", 243);
      aneo localaneo = (aneo)this.app.getManager(10);
      if (localaneo != null) {
        localaneo.an(1, 0);
      }
      localQQNotificationManager.cancel("MainFragment", 265);
      ausb.a(this.app).ewB();
      localQQNotificationManager.cancel("MainFragment", 267);
      localQQNotificationManager.cancel("MainFragment", 274);
      localQQNotificationManager.cancel("MainFragment", 236);
      localQQNotificationManager.cancel("MainFragment", 271);
      localQQNotificationManager.cancel("MainFragment", 273);
      localQQNotificationManager.cancel("MainFragment", 239);
      localQQNotificationManager.cancel("MainFragment", 527);
    }
    catch (Exception localException2)
    {
      label260:
      break label260;
    }
    this.jdField_a_of_type_Zju.cpL();
    this.jdField_a_of_type_Zju.onAccountChanged(localQQAppInterface);
    if (this.app != null)
    {
      ((acjf)this.app.getManager(257)).a(this.jdField_a_of_type_Acjf$a);
      this.app.registObserver(this.jdField_a_of_type_Ahei);
      this.app.registObserver(this.jdField_a_of_type_Akth);
    }
    if (this.jdField_a_of_type_Akrv != null) {
      this.jdField_a_of_type_Akrv.onAccountChanged();
    }
    for (;;)
    {
      if ((this.aYz) || ((this.app != null) && (this.s != null) && (this.gz != null))) {}
      try
      {
        xC(false);
        acyg.bF();
        if (this.jdField_a_of_type_Zju != null) {
          this.jdField_a_of_type_Zju.brz = false;
        }
        getActivity().getIntent().removeExtra("if_check_account_same");
        if (this.app != null) {
          this.aOj = this.app.getAccount();
        }
        UserguideActivity.bXF();
        aqsd.SS(true);
        return;
        this.aYz = false;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          QLog.d("MainFragment", 2, "onAccountChange setFrame has error : " + localException1);
        }
      }
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    if (this.jdField_a_of_type_Akrv != null) {
      this.jdField_a_of_type_Akrv.onAccoutChangeFailed();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.app = getActivity().app;
    this.aOj = this.app.getAccount();
    this.jdField_a_of_type_Zju = new zju((SplashActivity)getActivity());
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)bn.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772097)
      {
        localObject = new wnr();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131427334));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
      }
      for (;;)
      {
        bn.put(paramInt2, localObject);
        return localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onCreateView + rootView =  " + this.mRootView);
    }
    if (this.mRootView == null)
    {
      paramViewGroup = getActivity().findViewById(2131378651);
      if (paramViewGroup != null)
      {
        ViewParent localViewParent = paramViewGroup.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(paramViewGroup);
        }
      }
      paramViewGroup = (SplashActivity)getActivity();
      if (paramViewGroup.u != null)
      {
        this.mRootView = paramViewGroup.u[0];
        paramLayoutInflater = new MainFragment.1(this);
        if (!StartService.cIM) {
          break label209;
        }
        paramLayoutInflater.run();
      }
    }
    for (;;)
    {
      paramLayoutInflater = getActivity().getIntent();
      if (paramLayoutInflater != null) {
        this.bIt = paramLayoutInflater.getIntExtra("current_tab_tag", -1);
      }
      she.a().byt();
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mRootView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break;
      if (this.mRootView.getParent() == null) {
        break;
      }
      ((ViewGroup)this.mRootView.getParent()).removeView(this.mRootView);
      break;
      label209:
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 2000L);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    bn.clear();
    if ((this.app != null) && (this.jdField_a_of_type_Zju != null))
    {
      if (!this.aYw)
      {
        this.jdField_a_of_type_Zju.cpG();
        this.aYw = true;
      }
      this.jdField_a_of_type_Zju.clear();
    }
    if (this.app != null)
    {
      ((acjf)this.app.getManager(257)).removeListener();
      this.app.unRegistObserver(this.jdField_a_of_type_Ahei);
      this.app.unRegistObserver(this.jdField_a_of_type_Akth);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      aglz.a().dih();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (aryy.PN()) {
        aryy.a().destroy();
      }
      TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        localThrowable.printStackTrace();
        continue;
        boolean bool = false;
        continue;
        if (SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false))
        {
          this.app.startPCActivePolling(this.app.getAccount(), "exitApp");
          this.app.exit(true);
        }
        else
        {
          this.app.exit(false);
        }
      }
    }
    if (!aYv)
    {
      bool = true;
      aYu = bool;
      aYv = false;
      if (this.app != null)
      {
        this.app.isClearTaskBySystem = aYu;
        if (!aYu) {
          break label301;
        }
        this.app.isBackground_Stop = true;
        localObject = new Intent("mqq.intent.action.EXIT" + getActivity().getPackageName());
        getActivity().sendBroadcast((Intent)localObject);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      }
      localObject = this.jdField_do;
      this.jdField_do = null;
      ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.jdField_a_of_type_Zju.cpG();
    if (this.app != null)
    {
      ((acjf)this.app.getManager(257)).removeListener();
      this.app.unRegistObserver(this.jdField_a_of_type_Ahei);
      this.app.unRegistObserver(this.jdField_a_of_type_Akth);
    }
    this.aYw = true;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.dV);
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    QLog.d("MainFragment", 1, "onHiddenChanged" + paramBoolean);
    if (paramBoolean)
    {
      this.aTK = true;
      onPause();
      onStop();
      this.aTK = false;
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      if (Build.VERSION.SDK_INT < 18) {
        this.mRootView.requestFocus();
      }
      if (getActivity().getIntent().getBooleanExtra("isFromAioFragment", false))
      {
        onStart();
        onResume();
      }
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    aqmj.co(this.app.getApp(), "");
    if (aizp.a().aqg()) {
      aizp.a().LJ(false);
    }
    aizp.a().bH(this.app);
    aiyy.a().Qv(1);
    this.aYz = true;
    acyg.bF();
    UserguideActivity.bXF();
    ThreadManager.getUIHandler().post(new MainFragment.15(this));
    super.onLogout(paramLogoutReason);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    bRt();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.bKT != 1) && (!this.aTK))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.Go != 0L) && (this.aOi != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.aOi, (int)(SystemClock.uptimeMillis() - this.Go), 0, null);
    }
    this.Go = 0L;
    asR();
    aalb.bwh = false;
    if (DrawerFrame.cgR == 2) {
      cuz();
    }
    FrameHelperActivity.EO(false);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
    }
    zjt.cpE();
    if (getCurrentTab() == bIk) {
      bRC();
    }
    bRt();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.aYD != anlm.Vr()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.s != null)) {
        xC(false);
      }
      acep localacep = a(Conversation.class);
      if (localacep != null) {
        ((Conversation)localacep).onPostThemeChanged();
      }
      localacep = a(Contacts.class);
      if (localacep != null) {
        ((Contacts)localacep).onPostThemeChanged();
      }
      localacep = a(Leba.class);
      if (localacep != null) {
        ((Leba)localacep).onPostThemeChanged();
      }
      localacep = a(Now.class);
      if (localacep != null) {
        ((Now)localacep).onPostThemeChanged();
      }
      localacep = a(ReadinjoyTabFrame.class);
      if (localacep != null) {
        ((ReadinjoyTabFrame)localacep).onPostThemeChanged();
      }
      localacep = a(QzoneFrame.class);
      if (localacep != null) {
        ((QzoneFrame)localacep).onPostThemeChanged();
      }
      xD(true);
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.bKT != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onResume return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onResume");
    }
    aqmq.track(null, "Main_OnResume");
    this.Go = SystemClock.uptimeMillis();
    FrameHelperActivity.EO(true);
    if (DrawerFrame.cgR > 0)
    {
      if ((DrawerFrame.cgR == 3) && (QLog.isColorLevel())) {
        QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", new Object[] { Integer.valueOf(getCurrentTab()) }));
      }
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).removeMessages(1031);
      }
      cuz();
    }
    xC(false);
    if (GuardManager.a != null) {
      GuardManager.a.y(6, null);
    }
    aalb.bwh = true;
    if (this.I != null)
    {
      localObject = this.I;
      this.I = null;
      ((SplashActivity)getActivity()).ch((Intent)localObject);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.2(this), 1000L);
    this.jdField_a_of_type_Zju.cpL();
    aqmq.track("Main_OnResume", null);
    Object localObject = (jnp)this.app.getBusinessHandler(43);
    if ((localObject != null) && (((jnp)localObject).yd()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    lcm.aKc();
    if (SplashActivity.bKV != 0)
    {
      tzc.a().stop(SplashActivity.bKV);
      SplashActivity.bKV = 0;
    }
    if (SplashActivity.GW != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOExit", 2, "exit aio cost = " + (SystemClock.uptimeMillis() - SplashActivity.GW));
      }
      SplashActivity.GW = 0L;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
    }
    if (this.bIt != -1)
    {
      setCurrentTab(this.bIt);
      this.bIt = -1;
    }
    aYB = false;
    if (this.jdField_a_of_type_Zju != null) {
      this.jdField_a_of_type_Zju.cD(getActivity().getIntent());
    }
    ahhj.z(getActivity(), getActivity().getIntent());
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.bKT != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart");
      }
      if ((this.aOk != null) && (this.aOk.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.aOl)))
      {
        aqhv localaqhv = aqik.c(this.app, getActivity(), this.aOk);
        localaqhv.setPkgName(this.aOl);
        localaqhv.ace();
        this.aOk = null;
        this.aOl = null;
      }
      if (!this.app.a.He()) {
        bRB();
      }
      ((wjw)this.app.getManager(218)).bYA();
    } while (this.jdField_a_of_type_Zju == null);
    this.jdField_a_of_type_Zju.cC(getActivity().getIntent());
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.bKT != 1) && (!this.aTK))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStop return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onStop");
    }
    if (DrawerFrame.cgR > 0) {
      cuz();
    }
    njn.a().pM(false);
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.Go != 0L) && (this.aOi != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.aOi, (int)(SystemClock.uptimeMillis() - this.Go), 0, null);
    }
    if (this.aOi != null) {
      anoz.a().traceEnd(this.aOi);
    }
    Object localObject = this.aOi;
    this.aOi = paramString;
    this.Go = SystemClock.uptimeMillis();
    anoz.a().traceStart(this.aOi);
    acep localacep = a();
    int j = bD((String)localObject);
    super.onTabChanged(paramString);
    if (j == bIk) {
      bRC();
    }
    aalb.bwh = true;
    int i = bIk;
    if (paramString.equals(Conversation.class.getName()))
    {
      paramString = aOe;
      i = bIk;
      anpc.report("tim_msg_tab");
    }
    label258:
    label709:
    label992:
    label1014:
    for (;;)
    {
      if ((j == bIl) && (i != bIl) && (this.app != null))
      {
        paramString = (alkm)this.app.getManager(38);
        if (paramString != null) {
          paramString.kH(anaz.gQ());
        }
      }
      if (((localacep instanceof ReadinjoyTabFrame)) || (i == bIq))
      {
        paramString = (ReadinjoyTabFrame)a(ReadinjoyTabFrame.class);
        if (paramString != null)
        {
          if (i == bIq)
          {
            odv.d(this.app);
            paramString.pH(true);
            Bh(5);
          }
        }
        else
        {
          lcm.qH(i);
          aurk.a(this.app, this, localacep, i);
          paramString = (DragTextView)this.gz.get(aOe + "_num");
          if (i != bIk) {
            break label709;
          }
          paramString.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
          paramString.setDragViewType(2);
          localObject = (TabDragAnimationView)this.bo.get(bIk);
          this.jdField_a_of_type_Aali.a = ((TabDragAnimationView)localObject);
          if (localObject != null) {
            if (QLog.isColorLevel()) {
              QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
            }
          }
        }
      }
      for (;;)
      {
        int k;
        try
        {
          ((TabDragAnimationView)localObject).setOnDoubleTapListener(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment$b);
          this.jdField_a_of_type_Aali.zC = paramString;
          this.aYy = Qg();
          paramString = (TabDragAnimationView)this.bo.get(i);
          if (paramString != null) {
            paramString.setPressChanged(true);
          }
          paramString = (TextView)this.bp.get(i);
          if (paramString != null) {
            paramString.setTextColor(getResources().getColor(2131167507));
          }
          j = 0;
          if (j >= this.bo.size()) {
            break label804;
          }
          k = this.bo.keyAt(j);
          if (k != i) {
            break label761;
          }
          j += 1;
          continue;
          if (paramString.equals(Contacts.class.getName()))
          {
            paramString = aOf;
            i = bIm;
            bRu();
            anpc.report("tim_contact_tab");
            break;
          }
          if (paramString.equals(TimLeba.class.getName()))
          {
            paramString = aOg;
            i = bIn;
            anpc.report("tim_mine_tab");
            break;
          }
          if (paramString.equals(QzoneFrame.class.getName()))
          {
            i = bIs;
            paramString = b();
            if ((paramString != null) && ((paramString instanceof QzoneFrame)))
            {
              boolean bool = Qf();
              ((QzoneFrame)paramString).BK(bool);
            }
            break;
          }
          if (paramString.equals(Now.class.getName()))
          {
            i = bIp;
            rar.a("story_tab", "clk", 0, ((jnv)this.app.getManager(70)).mO(), new String[0]);
            break;
          }
          if (!paramString.equals(ReadinjoyTabFrame.class.getName())) {
            break label1014;
          }
          paramString = aOh;
          i = bIq;
          break;
          paramString.pH(false);
          Bh(4);
          break label258;
          Bh(4);
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("DynimiIcon", 2, localThrowable1, new Object[0]);
          continue;
        }
        try
        {
          TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.bo.get(bIk);
          if (localTabDragAnimationView != null) {
            localTabDragAnimationView.setOnDoubleTapListener(null);
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.e("DynimiIcon", 2, localThrowable2, new Object[0]);
          }
        }
        paramString.setOnModeChangeListener(null);
        continue;
        label761:
        paramString = (TabDragAnimationView)this.bo.valueAt(j);
        if ((k - i <= 0) || ((k != bIm) || (k == bIq))) {}
        paramString.setPressChanged(false);
      }
      j = 0;
      if (j < this.bp.size())
      {
        if (this.bo.keyAt(j) == i) {}
        for (;;)
        {
          j += 1;
          break;
          ((TextView)this.bp.valueAt(j)).setTextColor(getResources().getColor(2131167506));
        }
      }
      if (((!this.aYy) || (!aYA)) || (this.jdField_b_of_type_MqqOsMqqHandler == null)) {
        this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new MainFragment.6(this, i), 100L);
      Qe();
      if ((ReadinjoyTabFrame.class.getName().equals(this.aOi)) || (QzoneFrame.class.getName().equals(this.aOi)))
      {
        IW(8);
        b();
        if ((localacep == null) || (!(localacep instanceof Leba))) {
          break label992;
        }
        ((Leba)localacep).bQu();
      }
      while ((localacep == null) || (!(localacep instanceof QzoneFrame)))
      {
        return;
        IW(0);
        break;
      }
      ((QzoneFrame)localacep).onSwitchOutofQzone();
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onViewCreated");
    }
    super.onViewCreated(paramView, paramBundle);
    if (this.s == null)
    {
      a(this.mRootView);
      xC(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
    ThreadManager.getSubThreadHandler().post(this.dV);
  }
  
  public Intent p()
  {
    long l1 = aqmj.a(this.app.getCurrentAccountUin(), this.app.getApp());
    long l2 = System.currentTimeMillis();
    long l3 = (l2 - l1) / 1000L / 60L / 60L;
    if (QLog.isDevelopLevel()) {
      QLog.d("MainFragment", 4, "IGNORE_BATTERY_OPTIMIZATIONS after: " + l3 + " hours");
    }
    boolean bool;
    if (l3 > 720L) {
      bool = true;
    }
    while (bool)
    {
      QLog.i("MainFragment", 2, " IGNORE_BATTERY_OPTIMIZATIONS time = " + l3 + "h_" + bool);
      aqmj.a(this.app.getCurrentAccountUin(), this.app.getApp(), l2);
      Intent localIntent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
      localIntent.setData(Uri.parse("package:com.tencent.tim"));
      if (localIntent.resolveActivity(getActivity().getPackageManager()) != null) {
        if (l1 == 0L)
        {
          return localIntent;
          bool = false;
        }
        else
        {
          getActivity().runOnUiThread(new MainFragment.25(this, localIntent));
        }
      }
    }
    return null;
  }
  
  public void setCurrentTab(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public String setLastActivityName()
  {
    if (ZW()) {
      return getString(2131690700);
    }
    return super.setLastActivityName();
  }
  
  public HashMap<String, View> y()
  {
    return this.gz;
  }
  
  static class a
    extends MainFragment.c
  {
    protected boolean aYG = true;
    protected String mFrom;
    protected View mTargetView;
    
    public a(View paramView, String paramString)
    {
      super();
      this.mTargetView = paramView;
      this.mFrom = paramString;
    }
    
    public void onClick(View paramView)
    {
      super.onClick(paramView);
      try
      {
        if (QSecFramework.a().c(1001).booleanValue())
        {
          if (!this.aYG) {
            break label106;
          }
          View localView = this.mTargetView;
          QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(80), localView }, null);
          this.aYG = false;
          if (QLog.isColorLevel()) {
            QLog.i("MainFragment", 2, "附近人机上报: lebaView onCreate, from=" + this.mFrom);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          label106:
          QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(80), Integer.valueOf(1), Integer.valueOf(6), "lebaClick", null }, null);
          if (QLog.isColorLevel()) {
            QLog.i("MainFragment", 2, "附近人机上报: lebaView onClick, from=" + this.mFrom);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MainFragment", 2, "ABotDragClickListener onClick exp=", localException);
          }
        }
      }
    }
  }
  
  public class b
    implements GestureDetector.OnDoubleTapListener
  {
    public b() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onDoubleTap() called with: e = [" + paramMotionEvent + "]");
      }
      paramMotionEvent = (Conversation)MainFragment.this.a(Conversation.class);
      if (paramMotionEvent != null) {}
      for (int i = paramMotionEvent.bGd;; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "onDoubleTap() unReadCount = " + i);
        }
        paramMotionEvent = MainFragment.this.b();
        if ((paramMotionEvent instanceof Conversation)) {
          ((Conversation)paramMotionEvent).bMg();
        }
        if (i == 0) {
          MainFragment.d(MainFragment.this);
        }
        return false;
      }
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static class c
    implements View.OnClickListener
  {
    public void onClick(View paramView)
    {
      MainFragment.am(true);
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (!MainFragment.Qi()) {
        localViewGroup.callOnClick();
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class d
    implements View.OnTouchListener
  {
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getActionMasked())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        FrameHelperActivity.EO(false);
        return false;
      }
      FrameHelperActivity.EO(true);
      return false;
    }
  }
  
  public static class e
  {
    String aOo;
    ResourcePluginInfo b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment
 * JD-Core Version:    0.7.0.1
 */