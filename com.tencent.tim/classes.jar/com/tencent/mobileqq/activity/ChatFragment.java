package com.tencent.mobileqq.activity;

import acff;
import ahiy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import aprg;
import aqiy;
import aqjc;
import aqmq;
import asgx;
import aurf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import jqs;
import lcm;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import umk;
import wit;
import wiv;
import wnb;
import xva;
import xwk;
import xwl;
import xwq;
import xxh;
import xxt;
import xya;
import xyi;
import xys;
import xzk;
import xzp;
import yam;
import ybb;
import ybl;
import ybt;
import ycd;
import ydw;
import ydz;
import yfh;
import yhv;

public class ChatFragment
  extends ReportV4Fragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static boolean aTL;
  private static SparseArray<Animation> bn = new SparseArray(2);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new umk(this);
  a jdField_a_of_type_ComTencentMobileqqActivityChatFragment$a;
  wiv jdField_a_of_type_Wiv;
  private boolean aTK;
  public QQAppInterface app;
  public BaseChatPie b;
  public TopGestureLayout b;
  public SystemBarCompact b;
  boolean isFirstDraw = false;
  public FragmentActivity mActivity;
  public Context mContext;
  b mMyDispatchDrawListener;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private boolean A(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ybt)))
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ybt(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean B(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ydz)))
    {
      if (((this.mActivity instanceof SplashActivity)) || ((this.mActivity instanceof ChatActivity))) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ydz(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean C(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xya)))
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xya(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean D(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ycd)))
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ycd(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean E(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xwq)))
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xwq(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean F(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xyi)))
    {
      if (((this.mActivity instanceof SplashActivity)) || ((this.mActivity instanceof ChatActivity))) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xyi(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean G(Intent paramIntent)
  {
    boolean bool1 = true;
    String str = paramIntent.getStringExtra("uin");
    HotChatManager localHotChatManager = this.app.a(true);
    boolean bool2 = localHotChatManager.kj(str);
    boolean bool3 = paramIntent.getBooleanExtra("isGameRoom", false);
    if ((bool2) || (bool3))
    {
      bJw();
      a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
      paramIntent = localHotChatManager.a(str);
      if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool3)) {
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xzp(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
      }
    }
    for (;;)
    {
      bool1 = false;
      do
      {
        return bool1;
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new yam(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
        break;
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().equals(TroopChatPie.class))) {
          break label192;
        }
      } while ((!(this.mActivity instanceof SplashActivity)) && (!(this.mActivity instanceof ChatActivity)));
      bJw();
      return true;
      label192:
      bJw();
      a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new TroopChatPie(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    }
  }
  
  private boolean H(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xwk)))
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xwk(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean I(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xys)) && (!(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xwq)) && (!(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ydw)))
    {
      if (((this.mActivity instanceof SplashActivity)) || ((this.mActivity instanceof ChatActivity))) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xys(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  private boolean Pk()
  {
    return ((this.mActivity instanceof SplashActivity)) && (SplashActivity.bKT == 1);
  }
  
  public static ChatFragment a()
  {
    ChatFragment localChatFragment = new ChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localChatFragment.setArguments(localBundle);
    return localChatFragment;
  }
  
  @Nullable
  private Boolean a(Intent paramIntent, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 2: 
    default: 
      return null;
    case 1: 
      if (!E(paramIntent)) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    case 3: 
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ybl)))
      {
        if ((this.mActivity instanceof SplashActivity)) {
          bJw();
        }
        return Boolean.valueOf(false);
      }
      bJw();
      a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ybl(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
      return Boolean.valueOf(true);
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new yfh(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return Boolean.valueOf(true);
  }
  
  private void a(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  private void bJv()
  {
    long l;
    if (isVisible())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.hide(this);
      localFragmentTransaction.commitAllowingStateLoss();
      aqmq.track("AIO_preLoad_Cost", null);
      l = SystemClock.uptimeMillis() - wit.HK;
      aqjc.b(this.mContext, this.app.getCurrentAccountUin(), 10, l);
      if (QLog.isColorLevel()) {}
    }
    else
    {
      return;
    }
    QLog.d("Q.aio.ChatFragment", 2, "AIO preLoad cost:" + l);
  }
  
  private void bJx()
  {
    int i = -1;
    if (this.isFirstDraw)
    {
      if (this.mActivity.getIntent() != null) {
        i = this.mActivity.getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        String str2 = this.mActivity.getIntent().getStringExtra("KEY_FROM");
        String str1 = str2;
        if (str2 == null)
        {
          ComponentName localComponentName = this.mActivity.getCallingActivity();
          str1 = str2;
          if (localComponentName != null) {
            str1 = localComponentName.getClassName();
          }
        }
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + aqmq.atn + ",from:" + str1);
      }
      if (!QQAppInterface.bIQ) {
        break label237;
      }
    }
    label237:
    for (int j = 0;; j = 1)
    {
      aqjc.bm("actFPSAIO", SystemClock.uptimeMillis());
      aqjc.b(this.mContext, this.app.getCurrentAccountUin(), i, aqmq.atn);
      this.isFirstDraw = false;
      ThreadManager.post(new ChatFragment.1(this, i, j), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "AIOTime aioOpenTimeReport end Cost " + aqmq.atn + " AIOType: " + i + " firstOpenAIO: " + j);
      }
      return;
    }
  }
  
  private int d(Intent paramIntent)
  {
    int m = 1;
    int i = paramIntent.getIntExtra("uintype", -1);
    int j;
    if (i == 1026)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
        j = 1;
      }
    }
    else
    {
      do
      {
        return j;
        if (i != 0) {
          break;
        }
        if ((jqs.d(this.app, paramIntent.getStringExtra("uin"), i)) || (asgx.ag(this.app, paramIntent.getStringExtra("uin"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
          }
          paramIntent.putExtra("uintype", 1024);
          return 1024;
        }
        j = i;
      } while (!aprg.V(this.app, paramIntent.getStringExtra("uin")));
      return 1043;
      String str;
      if (i == 1025)
      {
        str = paramIntent.getStringExtra("uin");
        if ((TextUtils.isEmpty(str)) || (!((acff)this.app.getManager(51)).isFriend(str))) {
          break label384;
        }
        paramIntent.putExtra("uintype", 0);
        i = 0;
      }
      label384:
      for (;;)
      {
        return i;
        int k;
        if (i == 1024)
        {
          str = paramIntent.getStringExtra("uin");
          j = i;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          k = m;
          if (!jqs.d(this.app, str, i))
          {
            if (asgx.ag(this.app, str)) {
              k = m;
            }
          }
          else
          {
            label243:
            j = i;
            if (k != 0) {
              break;
            }
            j = i;
            if (!((acff)this.app.getManager(51)).isFriend(str)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
            }
            paramIntent.putExtra("uintype", 0);
          }
        }
        for (;;)
        {
          return 0;
          k = 0;
          break label243;
          if (i == 1043)
          {
            paramIntent.putExtra("uintype", 0);
            return i;
          }
          j = i;
          if (i != 1000) {
            break;
          }
          str = paramIntent.getStringExtra("uin");
          j = i;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          j = i;
          if (!((acff)this.app.getManager(51)).isFriend(str)) {
            break;
          }
          paramIntent.putExtra("uintype", 0);
        }
      }
    }
    return 1;
  }
  
  public static void wp(boolean paramBoolean)
  {
    if (aTL != paramBoolean) {
      aTL = paramBoolean;
    }
  }
  
  private boolean z(Intent paramIntent)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if ((this.mActivity instanceof SplashActivity)) {
        bJw();
      }
      return true;
    }
    bJw();
    a(this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new BaseChatPie(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
    return false;
  }
  
  public void Ap(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(paramInt, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "fight doInMultiWindowModeStatusBarVisibilityChange  = " + paramInt);
    }
  }
  
  public BaseChatPie a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public void bJu()
  {
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp =null new compact");
      }
      int i = getResources().getColor(2131167361);
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.beq) || (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bes) || (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode)) {
        break label200;
      }
      localDrawable = xva.a().o(4);
      if (localDrawable == null) {
        break label173;
      }
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "duration=====" + (l2 - l1));
      }
      return;
      label173:
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130847060));
      break;
      label200:
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.ber) && (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bet) && (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode))
      {
        localDrawable = yhv.a().r(4);
        if (localDrawable != null)
        {
          this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
          break;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130847060));
        break;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130847060));
      break;
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp isStatusBarVisible=" + this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.beq) && (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bes) && (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode))
      {
        localDrawable = xva.a().o(4);
        if (QLog.isColorLevel()) {
          QLog.i("systembar", 2, "isQimUserOnline=====" + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.beq + "drawable = " + localDrawable);
        }
        if (localDrawable != null) {
          this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
        }
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible) || (getActivity() == null)) {
          break label804;
        }
        if ((!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.beq) || (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bes) || (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode)) {
          break label806;
        }
        this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
        break;
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130847060));
          continue;
          if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.ber) && (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bet) && (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode))
          {
            localDrawable = yhv.a().r(4);
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "isTimUserOnline=====" + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.ber + "drawable = " + localDrawable);
            }
            if (localDrawable != null) {
              this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
            } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130847060));
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "333 isDefaultTheme =====" + ThemeUtil.isDefaultOrDIYTheme(false));
            }
            if (ThemeUtil.isDefaultOrDIYTheme(false))
            {
              this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130847060));
            }
            else
            {
              this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(null);
              this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167361));
            }
          }
        }
      }
      label804:
      continue;
      label806:
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.ber) && (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.bet) && (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.isNightMode)) {
        this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
      } else {
        this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void bJw()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie");
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.vn() != 6) {
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnStop();
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnDestroy();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie already cleared.");
  }
  
  public void bJy()
  {
    if (x(this.mActivity.getIntent())) {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.bII();
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        wp(false);
        this.isFirstDraw = true;
      }
      this.uiHandler.removeMessages(1);
      return;
      if (y(this.mActivity.getIntent()))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
          }
          this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
          View localView = View.inflate(this.mActivity, 2131558888, null);
          this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(localView);
          this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.af(false);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.ChatFragment", 2, "onNewIntent mRootView == null---created a new Pie");
        }
      }
      else
      {
        boolean bool = this.mActivity instanceof ChatActivity;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mBasePie.doOnCreate(false) reuse the pie.");
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.af(false);
      }
    }
  }
  
  public void bJz()
  {
    int j = 0;
    int k = 1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = k;
      if (getActivity() != null)
      {
        i = k;
        if (getActivity().isInMultiWindow())
        {
          i = k;
          if (getActivity().isNeedStatusBarGone())
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.aio.ChatFragment", 4, "fight onMulitWindowModePause isNeedStatusBarGone = true");
            }
            i = 0;
          }
        }
      }
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (int i = j;; i = 2)
    {
      Ap(i);
      return;
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingLToR " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.vW(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingRToL " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bJw();
    }
  }
  
  protected void onAccountChanged()
  {
    this.app = getActivity().app;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onAttach");
    }
    aqmq.track(null, "AIO_Super_onAttach");
    super.onAttach(paramActivity);
    aqmq.track("AIO_Super_onAttach", "AIO_onAttach");
    this.jdField_a_of_type_Wiv = new wiv();
    this.mActivity = ((FragmentActivity)paramActivity);
    Intent localIntent = this.mActivity.getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 1026))
    {
      localIntent.putExtra("uintype", 1);
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "check UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    this.app = this.mActivity.app;
    this.mContext = paramActivity;
    this.mMyDispatchDrawListener = new b();
    aqmq.track("AIO_onAttach", null);
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onBackEvent " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      return this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.onBackEvent();
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreate");
    }
    aqmq.track(null, "AIO_Super_onCreate");
    super.onCreate(paramBundle);
    aqmq.track("AIO_Super_onCreate", null);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)bn.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772090)
      {
        localObject = new wnb();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131427334));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
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
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.onCreateDialog(paramInt);
    }
    return null;
  }
  
  @TargetApi(14)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreateView");
    }
    aqmq.track(null, "AIO_onCreateView");
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$a = new a();
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout(this.mActivity, this.mMyDispatchDrawListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$a);
      paramLayoutInflater = (View)paramViewGroup.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setBackgroundResource(2130851275);
      }
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = View.inflate(this.mActivity, 2131558888, null);
        this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(paramLayoutInflater);
        wp(false);
        this.isFirstDraw = true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setFitsSystemWindows(true);
          this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()) - 10, 0, 0);
        }
        aqmq.track("AIO_onCreateView", null);
        paramLayoutInflater = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramLayoutInflater);
        paramLayoutInflater = null;
        continue;
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent() != null) {
        ((ViewGroup)this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent()).removeView(this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      }
    }
  }
  
  public void onDestroy()
  {
    aqmq.track(null, "AIO_Super_onDestroy");
    super.onDestroy();
    aqmq.track("AIO_Super_onDestroy", "AIO_onDestroy");
    bn.clear();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onDestroy " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    if (this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact = null;
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp destroy");
      }
    }
    aqmq.track("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    aqmq.track(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null)
    {
      localTopGestureLayout.setOnFlingGesture(null);
      localTopGestureLayout.setMyDispatchDrawListener(null);
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    aqmq.track("AIO_Super_onDestroyView", null);
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onHiddenChanged hidden = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.aTK = true;
      onPause();
      onStop();
      this.aTK = false;
      this.uiHandler.sendEmptyMessageDelayed(1, 500L);
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      Intent localIntent = this.mActivity.getIntent();
      if (localIntent.getBooleanExtra("isFromMainTab", false))
      {
        onStart();
        onResume();
      }
      else if (localIntent.getBooleanExtra("isFromContactTab", false))
      {
        onStart();
      }
    }
  }
  
  public void onPause()
  {
    aqmq.track(null, "AIO_Super_onPause");
    super.onPause();
    aqmq.track("AIO_Super_onPause", "AIO_onPause");
    if ((Pk()) && (!this.aTK))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnPause();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_Wiv != null) {
      this.jdField_a_of_type_Wiv.bYs();
    }
    aqmq.track("AIO_onPause", null);
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131167361);
      this.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.onPreThemeChanged();
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.onPrepareDialog(paramInt, paramDialog);
    }
  }
  
  public void onResume()
  {
    aqmq.track(null, "AIO_Super_onResume");
    super.onResume();
    aqmq.track("AIO_Super_onResume", "AIO_onResume");
    if (Pk())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume return");
      }
      bJv();
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      bJu();
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnResume();
    }
    getActivity().getWindow().setSoftInputMode(18);
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartChat, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    aqmq.track("AIO_onResume", "AIO_onDrawView");
  }
  
  public void onStart()
  {
    super.onStart();
    if (Pk()) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnStart();
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onStart " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
        }
      }
    } while (this.mActivity.getIntent() == null);
    String str = this.mActivity.getIntent().getStringExtra("uin");
    int i = this.mActivity.getIntent().getIntExtra("uintype", -1);
    lcm.a().a(1, null, str, i, -1);
  }
  
  public void onStop()
  {
    aqmq.track(null, "AIO_Super_onStop");
    super.onStop();
    aqmq.track("AIO_Super_onStop", "AIO_onStop");
    if ((Pk()) && (!this.aTK))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.doOnStop();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    aqmq.track("AIO_onStop", null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    aqmq.track(null, "AIO_Super_onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    aqmq.track("AIO_Super_onViewCreated", "AIO_onViewCreated");
    aqmq.track(null, "AIO_onCreate_getPieCost");
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    y(this.mActivity.getIntent());
    aqmq.track("AIO_onCreate_getPieCost", null);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (!Pk()) {
        break label145;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.bGD();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
      }
    }
    for (;;)
    {
      aqmq.track("AIO_onViewCreated", null);
      return;
      label145:
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.af(false);
    }
  }
  
  public void sm(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.fV(paramInt);
    }
  }
  
  public void wl(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.wl(paramBoolean);
    }
  }
  
  protected boolean x(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "canReuseChatPie: " + bool1);
      }
      return bool1;
      bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool3 = ahiy.ab(paramIntent);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.aSY)
        {
          String str1 = paramIntent.getStringExtra("uin");
          String str2 = this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a().aTl;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = bool2;
            if (str1.equals(str2))
            {
              int i = paramIntent.getIntExtra("uintype", -1);
              bool1 = bool2;
              if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a().cZ == i) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean y(Intent paramIntent)
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.bHy();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "getChatPie doOnNewIntent_clearBusinessData " + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    Object localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "getChatPie uin=" + ((String)localObject).substring(((String)localObject).length() - 4));
    }
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getChatPie subType = ").append(i).append(" type = ").append(paramIntent.getIntExtra("uintype", -1)).append(" mRootView is null?: ");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
      {
        bool1 = true;
        QLog.i("Q.aio.ChatFragment", 2, bool1);
      }
    }
    else
    {
      localObject = a(paramIntent, i);
      if (localObject == null) {
        break label241;
      }
      bool1 = ((Boolean)localObject).booleanValue();
    }
    label241:
    do
    {
      return bool1;
      bool1 = false;
      break;
      switch (d(paramIntent))
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
        }
        bool1 = bool2;
      }
    } while (z(paramIntent));
    for (;;)
    {
      return true;
      if (I(paramIntent))
      {
        return false;
        if (H(paramIntent))
        {
          return false;
          if (G(paramIntent))
          {
            return false;
            if (F(paramIntent))
            {
              return false;
              if (E(paramIntent))
              {
                return false;
                if (D(paramIntent))
                {
                  return false;
                  if (C(paramIntent))
                  {
                    return false;
                    if (B(paramIntent))
                    {
                      return false;
                      if (A(paramIntent))
                      {
                        return false;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xwl(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                        continue;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xxt(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                        continue;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ybb(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                        continue;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new ydw(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                        continue;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xxh(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                        continue;
                        bJw();
                        this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = new xzk(this.app, this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.mActivity, this.mContext);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void zZ(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.aSE) && (!this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.aSY)) {
        break label75;
      }
      QLog.i("Q.aio.ChatFragment", 1, "onShowFirst return|" + paramInt + " hasDestory:" + this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.aSY);
    }
    for (;;)
    {
      bJz();
      return;
      label75:
      this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.zZ(paramInt);
    }
  }
  
  public class a
    implements TopGestureLayout.InterceptTouchEventListener
  {
    public a() {}
    
    public void OnDispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (ChatFragment.this.b != null) {
        ChatFragment.this.b.OnDispatchTouchEvent(paramMotionEvent);
      }
    }
    
    public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (ChatFragment.this.b != null) {
        return ChatFragment.this.b.OnInterceptTouchEvent(paramMotionEvent);
      }
      return true;
    }
  }
  
  public class b
  {
    public b() {}
    
    public void bJA()
    {
      if ((ChatFragment.aTL) && (ChatFragment.this.isFirstDraw))
      {
        aqmq.bU("AIO_Start_cost", null);
        SuspendThreadManager.a().dTf();
        aqmq.track("AIO_onDrawView", "AIO_SysMsgCost");
        ChatFragment.a(ChatFragment.this);
        if (ChatFragment.this.mActivity.getIntent().getIntExtra("uintype", -1) == 1008)
        {
          String str = ChatFragment.this.mActivity.getIntent().getStringExtra("uin");
          aqiy.bk("pubAcc_aio_open", null, str);
          aqiy.bk("pubAcc_structMsg_display", null, str);
        }
        ChatFragment.access$002(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */