package com.tencent.mobileqq.activity.aio.panel;

import aagd;
import aeah;
import afgw;
import ahzd;
import akyu;
import akza;
import altq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anjo;
import anot;
import aogk;
import aqcx;
import aqft;
import asgx;
import axgk;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jof;
import org.jetbrains.annotations.NotNull;
import wja;
import wmj;
import wvm;
import wwg;
import xks;
import xro;
import xrt;
import xva;
import xva.a;
import xya;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static Boolean Z = Boolean.valueOf(false);
  public static Boolean aa = Boolean.valueOf(true);
  public static int bWD;
  public static boolean bij;
  private int As = -1;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$b;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$c;
  private boolean aCH;
  public wvm b;
  private boolean bei = true;
  private boolean bik;
  private Map<int[], int[]> hR = new HashMap();
  private Map<int[], int[]> hS = new HashMap();
  QQAppInterface mApp;
  public Context mContext;
  private SessionInfo mSessionInfo;
  public int mViewHeight = 100;
  public SharedPreferences pref;
  public ArrayList<int[]> qI = new ArrayList();
  
  public PanelIconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    this.mContext = paramContext;
    setBackgroundResource(2130850892);
    bWD = wja.dp2px(40.0F, paramContext.getResources());
    initMap();
  }
  
  public static boolean C(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((afgw)paramQQAppInterface.getManager(334)).ajj();
  }
  
  private boolean SD()
  {
    return (this.mSessionInfo != null) && (aqft.rj(this.mSessionInfo.aTl));
  }
  
  @NotNull
  private RedTouch a(akyu paramakyu, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.mContext, paramRedDotImageView).a(53).c(15).d(3).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    altq localaltq = (altq)this.mApp.getManager(36);
    if (paramInt == 8)
    {
      paramakyu = localaltq.c(10);
      if (paramakyu != null) {
        paramRedDotImageView.c(paramakyu);
      }
    }
    do
    {
      return paramRedDotImageView;
      paramakyu = localaltq.a(4, String.valueOf(paramakyu.dqk));
    } while (paramakyu == null);
    paramRedDotImageView.e(paramakyu);
    localaltq.e(paramakyu, "");
    return paramRedDotImageView;
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23)
    {
      if (a(this.mApp, this.pref))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
        paramRedDotImageView.showRedDot(true);
      }
    }
    else
    {
      if (paramInt == 26)
      {
        if (!b(this.mApp, this.pref)) {
          break label222;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
        paramRedDotImageView.showRedDot(true);
      }
      label100:
      if (paramInt == 3)
      {
        if (!C(this.mApp)) {
          break label230;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
        paramRedDotImageView.showRedDot(true);
      }
      label145:
      if (paramInt != 2) {
        break label244;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.mApp.getManager(36)).getAppInfoByPath("103100.103300");
      if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
        break label238;
      }
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
      paramRedDotImageView.showRedDot(true);
    }
    label222:
    label230:
    label238:
    label244:
    do
    {
      return;
      paramRedDotImageView.showRedDot(false);
      break;
      paramRedDotImageView.showRedDot(false);
      break label100;
      paramRedDotImageView.showRedDot(false);
      break label145;
      paramRedDotImageView.showRedDot(false);
      return;
      if (paramInt == 6)
      {
        if (!ShortVideoUtils.cFK)
        {
          Z = Boolean.valueOf(ShortVideoUtils.pd(this.mApp.getCurrentUin()));
          ShortVideoUtils.cFK = true;
        }
        aa = Boolean.valueOf(anjo.pl(anjo.cet));
        if (!aa.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(11);
          paramRedDotImageView.setReddotYOffsetDp(8);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850758));
          paramRedDotImageView.showRedDot(true);
          return;
        }
        if (Z.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
          paramRedDotImageView.showRedDot(true);
          anot.a(this.mApp, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
          return;
        }
        paramRedDotImageView.showRedDot(false);
        return;
      }
      if (paramInt == 10)
      {
        aagd.a(this.mApp, paramRedDotImageView, this.As);
        return;
      }
      if (paramInt == 8)
      {
        if (gE(this.As))
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
          paramRedDotImageView.showRedDot(true);
          return;
        }
        paramRedDotImageView.showRedDot(false);
        return;
      }
    } while (paramInt != 24);
    if (!ShortVideoUtils.cFL)
    {
      bij = ShortVideoUtils.pe(this.mApp.getCurrentUin());
      ShortVideoUtils.cFL = true;
    }
    if (bij)
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130851401));
      paramRedDotImageView.showRedDot(true);
      anot.a(this.mApp, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.showRedDot(false);
  }
  
  private void a(akyu paramakyu, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramakyu.tag) && (paramSessionInfo != null) && (aqft.rj(paramSessionInfo.aTl)))
    {
      paramakyu.mDrawable = paramContext.getResources().getDrawable(xro.iv[2]);
      paramakyu.fi = paramakyu.mDrawable;
      paramakyu.tag = xro.iv[0];
      paramakyu.dql = xro.iv[3];
      paramakyu.contentDescription = paramContext.getResources().getString(xro.iv[1]);
    }
  }
  
  private void a(akyu paramakyu, ArrayList<xva.a> paramArrayList, int paramInt)
  {
    int i = paramakyu.tag;
    RedDotImageView localRedDotImageView = new RedDotImageView(this.mContext);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, aqcx.dip2px(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramakyu.mn != null) && (paramakyu.mn.length > 0))
    {
      if (((paramakyu.mn.length >= 6) && (this.mSessionInfo != null) && (this.mSessionInfo.beq) && (this.mSessionInfo.bes) && (!this.mSessionInfo.isNightMode)) || ((paramakyu.mn.length >= 6) && (this.mSessionInfo != null) && (this.mSessionInfo.ber) && (this.mSessionInfo.bet) && (!this.mSessionInfo.isNightMode)) || ((paramakyu.mn.length >= 6) && (this.mSessionInfo != null) && (gB(this.mSessionInfo.cZ))))
      {
        xva.a locala = new xva.a();
        locala.index = paramInt;
        locala.c = localRedDotImageView;
        paramArrayList.add(locala);
      }
    }
    else {
      if (!this.bik) {
        break label364;
      }
    }
    label364:
    for (paramArrayList = paramakyu.fi;; paramArrayList = paramakyu.mDrawable)
    {
      localRedDotImageView.setImageDrawable(paramArrayList);
      if (AppSetting.enableTalkBack) {
        localRedDotImageView.setContentDescription(paramakyu.contentDescription);
      }
      if (paramakyu.dql > 0) {
        localRedDotImageView.setId(paramakyu.dql);
      }
      localRedDotImageView.setLongClickable(true);
      localRedDotImageView.setOnLongClickListener(this);
      localRedDotImageView.setOnClickListener(this);
      localRedDotImageView.setSelected(false);
      V(localRedDotImageView, i);
      if (this.bei) {
        break label372;
      }
      a(i, localRedDotImageView);
      addView(localRedDotImageView, localLayoutParams);
      return;
      localRedDotImageView.setImageResource(paramakyu.mn[2]);
      break;
    }
    label372:
    addView(a(paramakyu, i, localRedDotImageView), localLayoutParams);
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    this.bei = true;
    this.aCH = false;
    this.qI.add(xro.hD);
    this.qI.add(xro.hO);
    cew();
    ceu();
    if (xro.bih) {
      this.qI.add(xro.ie);
    }
    this.qI.add(xro.hH);
    if (aqft.rj(paramSessionInfo.aTl))
    {
      this.qI.add(xro.iw);
      this.bei = false;
      return;
    }
    this.qI.add(xro.ia);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramInt == 1024) && (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl))) {
      this.qI.add(xro.hz);
    }
    ArrayList localArrayList = this.qI;
    if (this.bik)
    {
      arrayOfInt = xro.hP;
      localArrayList.add(arrayOfInt);
      cev();
      localArrayList = this.qI;
      if (!this.bik) {
        break label163;
      }
    }
    label163:
    for (int[] arrayOfInt = xro.hI;; arrayOfInt = xro.hE)
    {
      localArrayList.add(arrayOfInt);
      this.qI.add(xro.ib);
      if ((paramInt == 1024) && (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl)))
      {
        this.qI.remove(xro.ib);
        this.qI.add(xro.hW);
      }
      return;
      arrayOfInt = xro.hL;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<int[]> paramArrayList)
  {
    if ((paramInt == 1024) && (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl))) {
      paramArrayList.add(xro.hD);
    }
    paramArrayList.add(xro.hO);
    ceu();
    paramArrayList.add(xro.hH);
    paramArrayList.add(xro.ic);
    if ((paramInt == 1024) && (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl)))
    {
      paramArrayList.remove(xro.ib);
      paramArrayList.add(xro.ia);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.bei = false;
    this.aCH = false;
    this.mSessionInfo = paramSessionInfo;
    this.mApp = paramQQAppInterface;
    this.pref = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.cZ;
    EmojiStickerManager.a().mCurType = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.qI.clear();
    ShortVideoUtils.cFE = ShortVideoUtils.awJ();
    if (i == 3000)
    {
      this.qI.add(xro.hD);
      this.qI.add(xro.hO);
      cew();
      ceu();
      this.qI.add(xro.hH);
      this.qI.add(xro.ia);
      if (this.qI.size() != 0) {
        break label785;
      }
      setCustomHeight(0);
    }
    for (;;)
    {
      this.As = i;
      ces();
      return;
      if (i == 1)
      {
        a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, this.qI);
        break;
      }
      if (gC(i))
      {
        a(paramQQAppInterface, paramSessionInfo, i, this.qI);
        break;
      }
      if (gB(i))
      {
        this.qI.add(xro.hD);
        this.qI.add(xro.hO);
        ceu();
        cet();
        this.qI.add(xro.hH);
        break;
      }
      if (i == 1036)
      {
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.hH);
        this.qI.add(xro.iz);
        break;
      }
      if (a(paramQQAppInterface, paramSessionInfo, i))
      {
        a(paramSessionInfo);
        break;
      }
      if (i == 10004)
      {
        this.qI.add(xro.hD);
        this.qI.add(xro.hO);
        ceu();
        cet();
        this.qI.add(xro.hH);
        this.qI.add(xro.ia);
        break;
      }
      if (gD(i))
      {
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.il);
        this.qI.add(xro.hH);
        break;
      }
      if (i == 1020)
      {
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.hH);
        this.qI.add(xro.ic);
        break;
      }
      if (i == 1005)
      {
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.hH);
        this.qI.add(xro.ic);
        break;
      }
      if (i == 1003)
      {
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.ic);
        cet();
        break;
      }
      if (i == 1010)
      {
        this.qI.add(xro.hD);
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.hH);
        this.qI.add(xro.ia);
        break;
      }
      if (gA(i))
      {
        this.qI.add(xro.hO);
        ceu();
        cet();
        this.qI.add(xro.hH);
        break;
      }
      if (i == 1025)
      {
        this.qI.add(xro.hD);
        this.qI.add(xro.hO);
        ceu();
        this.qI.add(xro.hH);
        this.qI.add(xro.ia);
        break;
      }
      this.qI.add(xro.hO);
      ceu();
      this.qI.add(xro.hH);
      break;
      label785:
      setCustomHeight(bWD);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, ArrayList<int[]> paramArrayList)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.kj(paramSessionInfo.aTl)))
    {
      paramQQAppInterface = localHotChatManager.a(paramSessionInfo.aTl);
      paramArrayList.add(xro.hD);
      paramArrayList.add(xro.iy);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(xro.ii);
      }
      paramArrayList.add(xro.ik);
      paramArrayList.add(xro.hH);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(xro.ia);
      }
      return;
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.aTl);
    a(jof.a().dd(paramSessionInfo.aTl), bool, paramQQAppInterface, paramBaseChatPie, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    if (this.bik)
    {
      paramQQAppInterface = xro.hP;
      paramArrayList.add(paramQQAppInterface);
      cev();
      paramArrayList.add(xro.il);
      if (!this.bik) {
        break label54;
      }
    }
    label54:
    for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      paramQQAppInterface = xro.hL;
      break;
    }
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!aqft.rj(paramSessionInfo.aTl));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = xks.c(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = xks.c(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(xks.TAG, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    return (paramInt == 0) || (ChatActivityUtils.q(paramQQAppInterface, paramSessionInfo.aTl));
  }
  
  private void aQ(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) {
      this.qI.clear();
    }
  }
  
  private void b(SessionInfo paramSessionInfo)
  {
    this.bei = true;
    this.aCH = false;
    this.qI.add(xro.hz);
    ArrayList localArrayList = this.qI;
    if (this.bik)
    {
      arrayOfInt = xro.hP;
      localArrayList.add(arrayOfInt);
      cex();
      cev();
      if (xro.bih) {
        this.qI.add(xro.id);
      }
      localArrayList = this.qI;
      if (!this.bik) {
        break label124;
      }
    }
    label124:
    for (int[] arrayOfInt = xro.hI;; arrayOfInt = xro.hE)
    {
      localArrayList.add(arrayOfInt);
      if (!aqft.rj(paramSessionInfo.aTl)) {
        break label131;
      }
      this.qI.add(xro.iv);
      this.bei = false;
      return;
      arrayOfInt = xro.hL;
      break;
    }
    label131:
    this.qI.add(xro.hW);
  }
  
  private void b(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    paramArrayList.add(xro.hz);
    int[] arrayOfInt;
    if (this.bik)
    {
      arrayOfInt = xro.hP;
      paramArrayList.add(arrayOfInt);
      cev();
      if (ahzd.a(paramQQAppInterface).aoB()) {
        paramArrayList.add(xro.ip);
      }
      if (!this.bik) {
        break label72;
      }
    }
    label72:
    for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = xro.hL;
      break;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = xks.n(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = xks.b(paramSharedPreferences);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(xks.TAG, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.kj(paramSessionInfo.aTl)))
    {
      paramSessionInfo = localHotChatManager.a(paramSessionInfo.aTl);
      this.qI.add(xro.hz);
      this.qI.add(xro.ix);
      if (!paramSessionInfo.isRobotHotChat) {
        this.qI.add(xro.ih);
      }
      this.qI.add(xro.ij);
      paramBaseChatPie = this.qI;
      if (this.bik) {}
      for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        if (!paramSessionInfo.isRobotHotChat) {
          this.qI.add(xro.hW);
        }
        return;
      }
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.aTl);
    a(jof.a().dd(paramSessionInfo.aTl), bool, paramQQAppInterface, paramBaseChatPie);
  }
  
  private void cet()
  {
    if (ahzd.a(this.mApp).aoB()) {
      this.qI.add(xro.iq);
    }
  }
  
  private void ceu()
  {
    if ((ShortVideoUtils.awN()) || (!this.qI.contains(xro.hV))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        xro.hS[2] = 2130845717;
        xro.hS[5] = 0;
        xro.hS[6] = 0;
      }
      return;
    }
  }
  
  private void cev()
  {
    if ((ShortVideoUtils.awN()) || (!this.qI.contains(xro.hV))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.qI.add(xro.hS);
      }
      return;
    }
  }
  
  private void cew()
  {
    if (ShortVideoUtils.awN()) {
      xro.hV[2] = 2130845728;
    }
    for (;;)
    {
      this.qI.add(xro.hV);
      return;
      xro.hV[2] = 2130845717;
    }
  }
  
  private void cex()
  {
    if (ShortVideoUtils.awN())
    {
      xro.hV[2] = 2130838296;
      xro.hV[5] = 2130850958;
      xro.hV[6] = 2130850959;
    }
    for (;;)
    {
      this.qI.add(xro.hV);
      return;
      xro.hV[2] = 2130838201;
      xro.hV[5] = 2130850860;
      xro.hV[6] = 2130850861;
    }
  }
  
  private void g(BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList;
    if ((paramBaseChatPie != null) && ((paramBaseChatPie instanceof xya)))
    {
      if (((xya)paramBaseChatPie).Td()) {
        this.qI.add(xro.hz);
      }
      if (((xya)paramBaseChatPie).Tc())
      {
        localArrayList = this.qI;
        if (!this.bik) {
          break label122;
        }
      }
    }
    label122:
    for (int[] arrayOfInt = xro.hP;; arrayOfInt = xro.hL)
    {
      localArrayList.add(arrayOfInt);
      cev();
      if (((xya)paramBaseChatPie).SZ())
      {
        this.qI.add(xro.ig);
        this.qI.add(xro.if);
      }
      if (((xya)paramBaseChatPie).Tb()) {
        this.qI.add(xro.il);
      }
      return;
    }
  }
  
  private boolean gA(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  private boolean gB(int paramInt)
  {
    return (paramInt == 1033) || (paramInt == 1034);
  }
  
  private boolean gC(int paramInt)
  {
    return (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1009) || (paramInt == 1024);
  }
  
  private boolean gD(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008);
  }
  
  private void gn(List<akyu> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (akyu)paramList.get(i);
      if (!a(((akyu)localObject).tag, this.mSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((akyu)localObject, this.mSessionInfo, this.mContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((akyu)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      xva.a().j((ArrayList)localObject, this.qI);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private void initMap()
  {
    this.hS.put(xro.hE, xro.hI);
    this.hS.put(xro.hF, xro.hJ);
    this.hS.put(xro.hG, xro.hK);
    this.hS.put(xro.hL, xro.hP);
    this.hS.put(xro.hM, xro.hQ);
    this.hS.put(xro.hN, xro.hR);
    this.hR.put(xro.hI, xro.hE);
    this.hR.put(xro.hJ, xro.hF);
    this.hR.put(xro.hK, xro.hG);
    this.hR.put(xro.hP, xro.hL);
    this.hR.put(xro.hQ, xro.hM);
    this.hR.put(xro.hR, xro.hN);
  }
  
  private void xs(String paramString)
  {
    if (((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://"))) || (paramString.startsWith("https://")))
    {
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.mContext.startActivity(localIntent);
    }
  }
  
  private void xt(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.mContext, paramString, 2053, null);
    }
  }
  
  public void V(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!LightVideoConfigMgr.a().aPZ());
    paramView.setOnLongClickListener(new xrt(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      setBackgroundResource(2130850892);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130845722);
    a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    if (this.mApp == null) {
      this.mApp = paramQQAppInterface;
    }
    this.qI.clear();
    a(paramBoolean, false, paramQQAppInterface, paramBaseChatPie);
    if (paramBaseChatPie.sessionInfo != null) {}
    for (this.As = paramBaseChatPie.sessionInfo.cZ;; this.As = 1)
    {
      this.bei = false;
      ces();
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    a(paramBoolean1, paramBoolean2, paramQQAppInterface, paramBaseChatPie, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, boolean paramBoolean3)
  {
    this.bei = false;
    if (paramBoolean1)
    {
      this.qI.add(xro.hB);
      paramBaseChatPie = this.qI;
      if (this.bik)
      {
        paramQQAppInterface = xro.hQ;
        paramBaseChatPie.add(paramQQAppInterface);
        this.qI.add(xro.hT);
        paramBaseChatPie = this.qI;
        if (!this.bik) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = xro.hJ;; paramQQAppInterface = xro.hF)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.qI.add(xro.hX);
        return;
        paramQQAppInterface = xro.hM;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.qI.add(xro.hD);
      this.qI.add(xro.hO);
      cew();
      ceu();
      if (paramBoolean2) {
        this.qI.add(xro.ic);
      }
      for (;;)
      {
        this.qI.add(xro.hH);
        this.qI.add(xro.ia);
        return;
        if (xro.bih) {
          this.qI.add(xro.ie);
        }
      }
    }
    this.aCH = true;
    this.qI.add(xro.hz);
    paramBaseChatPie = this.qI;
    if (this.bik)
    {
      paramQQAppInterface = xro.hP;
      paramBaseChatPie.add(paramQQAppInterface);
      cex();
      cev();
      if (!paramBoolean2) {
        break label304;
      }
      this.qI.add(xro.ib);
      label261:
      paramBaseChatPie = this.qI;
      if (!this.bik) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.qI.add(xro.hW);
      return;
      paramQQAppInterface = xro.hL;
      break;
      if (!xro.bih) {
        break label261;
      }
      this.qI.add(xro.id);
      break label261;
    }
  }
  
  public void aX(QQAppInterface paramQQAppInterface)
  {
    if (this.mApp == null) {
      this.mApp = paramQQAppInterface;
    }
    this.qI.clear();
    this.qI.add(xro.hB);
    ArrayList localArrayList = this.qI;
    if (this.bik)
    {
      paramQQAppInterface = xro.hQ;
      localArrayList.add(paramQQAppInterface);
      this.qI.add(xro.hT);
      if (ahzd.a(this.mApp).aoB()) {
        this.qI.add(xro.it);
      }
      localArrayList = this.qI;
      if (!this.bik) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = xro.hJ;; paramQQAppInterface = xro.hF)
    {
      localArrayList.add(paramQQAppInterface);
      this.bei = false;
      ces();
      return;
      paramQQAppInterface = xro.hM;
      break;
    }
  }
  
  public void aY(QQAppInterface paramQQAppInterface)
  {
    if (this.mApp == null) {
      this.mApp = paramQQAppInterface;
    }
    this.qI.clear();
    this.qI.add(xro.hC);
    ArrayList localArrayList = this.qI;
    if (this.bik)
    {
      paramQQAppInterface = xro.hR;
      localArrayList.add(paramQQAppInterface);
      this.qI.add(xro.hU);
      if (ahzd.a(this.mApp).aoB()) {
        this.qI.add(xro.ip);
      }
      localArrayList = this.qI;
      if (!this.bik) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = xro.hK;; paramQQAppInterface = xro.hG)
    {
      localArrayList.add(paramQQAppInterface);
      this.bei = false;
      ces();
      return;
      paramQQAppInterface = xro.hN;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, false);
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    this.bei = false;
    this.aCH = false;
    this.mSessionInfo = paramSessionInfo;
    this.mApp = paramQQAppInterface;
    this.pref = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.cZ;
    EmojiStickerManager.a().mCurType = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.qI.clear();
    ShortVideoUtils.cFE = ShortVideoUtils.awJ();
    if (i == 3000)
    {
      this.qI.add(xro.hz);
      paramSessionInfo = this.qI;
      if (this.bik)
      {
        paramQQAppInterface = xro.hP;
        paramSessionInfo.add(paramQQAppInterface);
        cex();
        cev();
        paramSessionInfo = this.qI;
        if (!this.bik) {
          break label220;
        }
        paramQQAppInterface = xro.hI;
        label162:
        paramSessionInfo.add(paramQQAppInterface);
        this.qI.add(xro.hW);
        label179:
        aQ(i, paramBoolean);
        if (this.qI.size() != 0) {
          break label1104;
        }
        setCustomHeight(0);
      }
    }
    for (;;)
    {
      this.As = i;
      ces();
      return;
      paramQQAppInterface = xro.hL;
      break;
      label220:
      paramQQAppInterface = xro.hE;
      break label162;
      if (i == 1)
      {
        c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        break label179;
      }
      if (gC(i))
      {
        a(paramQQAppInterface, paramSessionInfo, i);
        break label179;
      }
      if (gB(i))
      {
        b(paramQQAppInterface, this.qI);
        break label179;
      }
      if (i == 1036)
      {
        paramSessionInfo = this.qI;
        if (this.bik)
        {
          paramQQAppInterface = xro.hP;
          label308:
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          paramSessionInfo = this.qI;
          if (!this.bik) {
            break label361;
          }
        }
        label361:
        for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.qI.add(xro.iz);
          break;
          paramQQAppInterface = xro.hL;
          break label308;
        }
      }
      if (a(paramQQAppInterface, paramSessionInfo, i))
      {
        b(paramSessionInfo);
        break label179;
      }
      if (i == 10004)
      {
        b(paramQQAppInterface, this.qI);
        this.qI.add(xro.hW);
        break label179;
      }
      if (gD(i))
      {
        a(paramQQAppInterface, this.qI);
        break label179;
      }
      if (i == 1020)
      {
        paramSessionInfo = this.qI;
        if (this.bik)
        {
          paramQQAppInterface = xro.hP;
          label463:
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          paramSessionInfo = this.qI;
          if (!this.bik) {
            break label516;
          }
        }
        label516:
        for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.qI.add(xro.ib);
          break;
          paramQQAppInterface = xro.hL;
          break label463;
        }
      }
      if (i == 1008) {
        break label179;
      }
      if (i == 1005)
      {
        paramSessionInfo = this.qI;
        if (this.bik)
        {
          paramQQAppInterface = xro.hP;
          label555:
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          paramSessionInfo = this.qI;
          if (!this.bik) {
            break label608;
          }
        }
        label608:
        for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.qI.add(xro.ib);
          break;
          paramQQAppInterface = xro.hL;
          break label555;
        }
      }
      if (i == 1003)
      {
        paramBaseChatPie = this.qI;
        if (this.bik) {}
        for (paramSessionInfo = xro.hP;; paramSessionInfo = xro.hL)
        {
          paramBaseChatPie.add(paramSessionInfo);
          cev();
          this.qI.add(xro.ib);
          if (!ahzd.a(paramQQAppInterface).aoB()) {
            break;
          }
          this.qI.add(xro.ip);
          break;
        }
      }
      if (i == 1010)
      {
        this.qI.add(xro.hz);
        paramSessionInfo = this.qI;
        if (this.bik)
        {
          paramQQAppInterface = xro.hP;
          label726:
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          paramSessionInfo = this.qI;
          if (!this.bik) {
            break label779;
          }
        }
        label779:
        for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.qI.add(xro.hW);
          break;
          paramQQAppInterface = xro.hL;
          break label726;
        }
      }
      if (gA(i))
      {
        a(paramQQAppInterface, this.qI);
        break label179;
      }
      if (i == 6000)
      {
        paramSessionInfo = this.qI;
        if (this.bik) {}
        for (paramQQAppInterface = xro.hP;; paramQQAppInterface = xro.hL)
        {
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          this.qI.add(xro.il);
          this.qI.add(xro.im);
          break;
        }
      }
      if (i == 6003)
      {
        paramSessionInfo = this.qI;
        if (this.bik) {}
        for (paramQQAppInterface = xro.hP;; paramQQAppInterface = xro.hL)
        {
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          this.qI.add(xro.il);
          break;
        }
      }
      if (i == 1025)
      {
        this.qI.add(xro.hz);
        paramSessionInfo = this.qI;
        if (this.bik)
        {
          paramQQAppInterface = xro.hP;
          label963:
          paramSessionInfo.add(paramQQAppInterface);
          cev();
          paramSessionInfo = this.qI;
          if (!this.bik) {
            break label1016;
          }
        }
        label1016:
        for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.qI.add(xro.hW);
          break;
          paramQQAppInterface = xro.hL;
          break label963;
        }
      }
      if (i == 9501)
      {
        g(paramBaseChatPie);
        break label179;
      }
      paramSessionInfo = this.qI;
      if (this.bik)
      {
        paramQQAppInterface = xro.hP;
        label1055:
        paramSessionInfo.add(paramQQAppInterface);
        cev();
        paramSessionInfo = this.qI;
        if (!this.bik) {
          break label1097;
        }
      }
      label1097:
      for (paramQQAppInterface = xro.hI;; paramQQAppInterface = xro.hE)
      {
        paramSessionInfo.add(paramQQAppInterface);
        break;
        paramQQAppInterface = xro.hL;
        break label1055;
      }
      label1104:
      setCustomHeight(bWD);
    }
  }
  
  public ArrayList<int[]> bK()
  {
    return this.qI;
  }
  
  public void ccM()
  {
    int i;
    if ((getVisibility() == 0) && (this.bei)) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if ((!(localView.getTag() instanceof Integer)) || (((Integer)localView.getTag()).intValue() != 8)) {
          break label90;
        }
        if ((localView instanceof RedTouch))
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((altq)this.mApp.getManager(36)).c(10);
          ((RedTouch)localView).c(localRedTypeInfo);
        }
      }
      return;
      label90:
      i -= 1;
    }
  }
  
  public void ces()
  {
    int j = 0;
    removeAllViews();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.bei)
    {
      localObject1 = localObject2;
      if (!SD())
      {
        localObject2 = akza.a(this.bik, this.mContext);
        if ((localObject2 == null) && (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder().append("session: ");
          if (this.mSessionInfo != null) {
            break label252;
          }
        }
      }
    }
    int i;
    label252:
    for (localObject1 = "";; localObject1 = Integer.valueOf(this.mSessionInfo.cZ))
    {
      QLog.e("PanelIconLinearLayout", 2, localObject1 + " did not use config");
      localObject1 = localObject2;
      if ((!this.aCH) && (this.bei) && (localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label446;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.qI.size())
      {
        localObject2 = (int[])this.qI.get(i);
        localObject3 = new akyu();
        ((akyu)localObject3).tag = localObject2[0];
        ((akyu)localObject3).contentDescription = this.mContext.getResources().getString(localObject2[1]);
        ((akyu)localObject3).mDrawable = this.mContext.getResources().getDrawable(localObject2[2]);
        ((akyu)localObject3).dql = localObject2[3];
        ((akyu)localObject3).mn = ((int[])localObject2);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
    }
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        localObject2 = (akyu)((List)localObject1).get(i);
        if ((!this.bik) && (localObject2 != null) && (((akyu)localObject2).mDrawable == null))
        {
          localObject3 = akza.n(((akyu)localObject2).id);
          if (localObject3 != null) {
            ((akyu)localObject2).mDrawable = this.mContext.getResources().getDrawable(localObject3[2]);
          }
        }
        if ((this.bik) && (localObject2 != null) && (((akyu)localObject2).fi == null))
        {
          localObject3 = akza.n(((akyu)localObject2).id);
          if (localObject3 == null) {
            break label403;
          }
          ((akyu)localObject2).fi = this.mContext.getResources().getDrawable(localObject3[2]);
        }
        for (;;)
        {
          i += 1;
          break;
          label403:
          if (((akyu)localObject2).mDrawable != null) {
            ((akyu)localObject2).fi = ((akyu)localObject2).mDrawable;
          }
        }
      }
      gn((List)localObject1);
      aogk.a().q(this.mContext, this);
      return;
      i = j;
      continue;
      label446:
      i = j;
    }
  }
  
  public void e(int[] paramArrayOfInt, int paramInt)
  {
    int i = bK().indexOf(paramArrayOfInt);
    if (i < 0) {
      if (this.bik)
      {
        paramArrayOfInt = (int[])this.hS.get(paramArrayOfInt);
        if (paramArrayOfInt == null) {
          break label205;
        }
        i = bK().indexOf(paramArrayOfInt);
      }
    }
    label205:
    for (;;)
    {
      if (i < 0) {
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "updateIconNumbers error index =  " + i);
        }
      }
      do
      {
        return;
        paramArrayOfInt = (int[])this.hR.get(paramArrayOfInt);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "updateIconNumbers index =  " + i + ",num = " + paramInt);
        }
        paramArrayOfInt = getChildAt(i);
        if ((paramArrayOfInt instanceof RedDotImageView))
        {
          ((RedDotImageView)paramArrayOfInt).setUnreadNumber(paramInt);
          return;
        }
      } while ((!(paramArrayOfInt instanceof RedTouch)) || (!(((RedTouch)paramArrayOfInt).cq() instanceof RedDotImageView)));
      ((RedDotImageView)((RedTouch)paramArrayOfInt).cq()).setUnreadNumber(paramInt);
      return;
    }
  }
  
  public boolean gE(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 3000) {}
    }
    else
    {
      bool1 = bool2;
      if (ScribbleResMgr.Z(this.mContext, this.mApp.getCurrentAccountUin())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {}
    int i;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((Integer)localObject1).intValue() == 6)
      {
        axgk.a().eJx();
        axgk.a().acy("userClick");
      }
      akyu localakyu = akza.a(((Integer)localObject1).intValue());
      if (localakyu != null) {
        xro.a(this.mApp, this.mSessionInfo, 4, String.valueOf(localakyu.dqk), localakyu.id);
      }
      do
      {
        do
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$b != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$b.k(paramView.getTag());
            }
            try
            {
              i = ((Integer)paramView.getTag()).intValue();
              if (i != 2) {
                break label292;
              }
              ((altq)this.mApp.getManager(36)).OS("103100.103300");
              if ((paramView instanceof RedDotImageView)) {
                ((RedDotImageView)paramView).showRedDot(false);
              }
              anot.a(this.mApp, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
            }
            catch (Exception localException)
            {
              QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + localException.getMessage());
            }
          }
          break;
          localObject2 = akza.a(((Integer)localException).intValue(), true);
        } while (localObject2 == null);
        if ("web".equals(((akyu)localObject2).actionType))
        {
          xs(((akyu)localObject2).action);
          break;
        }
      } while (!"miniapp".equals(((akyu)localObject2).actionType));
      xt(((akyu)localObject2).action);
    }
    label292:
    if (i == 10)
    {
      wmj.Co(1);
      localObject2 = "";
      if ((this.mSessionInfo.cZ == 0) || (this.mSessionInfo.cZ == 1000) || (this.mSessionInfo.cZ == 1004)) {
        break label687;
      }
      if (this.mSessionInfo.cZ == 10008) {
        break label687;
      }
    }
    for (;;)
    {
      anot.a(this.mApp, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject2, 0, 0, "", "", "", "");
      aagd.a(this.mApp, paramView, this.As);
      break;
      if (this.mSessionInfo.cZ == 3000)
      {
        localObject2 = "entrance.click.group.quick";
      }
      else if (this.mSessionInfo.cZ == 1)
      {
        localObject2 = "entrance.click.chatgroup.quick";
        continue;
        if (i == 6)
        {
          if ((ShortVideoUtils.awM()) && (aeah.afY())) {
            anot.a(this.mApp, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!aa.booleanValue())
          {
            setShowRed(6, false);
            anjo.QD(anjo.cet);
            break;
          }
          if (!Z.booleanValue()) {
            break;
          }
          setShowRed(6, false);
          ShortVideoUtils.cP(this.mApp.getCurrentUin(), false);
          anot.a(this.mApp, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
          Z = Boolean.valueOf(false);
          break;
        }
        if (i == 24)
        {
          if (!bij) {
            break;
          }
          setShowRed(24, false);
          ShortVideoUtils.cQ(this.mApp.getCurrentUin(), false);
          anot.a(this.mApp, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
          bij = false;
          break;
        }
        if ((i != 8) || (!gE(this.As))) {
          break;
        }
        ScribbleResMgr.bR(this.mContext, this.mApp.getCurrentAccountUin());
        setShowRed(8, false);
        break;
        label687:
        localObject2 = "entrance.click.c2c.quick";
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a.S(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$c != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$c.e(paramView.getTag());
    }
    switch (((Integer)localObject).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.b == null);
      paramView = (wwg)this.b.a(7);
    } while (paramView == null);
    paramView.ccA();
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, System.identityHashCode(this) + " onMeasure() called with: w = [" + getMeasuredWidth() + "], h = [" + getMeasuredHeight() + "]");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a.R(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(11)
  public void setAllAlpha(float paramFloat)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).setAlpha(paramFloat);
      }
      for (;;)
      {
        i += 1;
        break;
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        getChildAt(i).startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public void setAllEnable(boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setAllUnSelected()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  @TargetApi(11)
  public void setChildAlpha(int paramInt, float paramFloat)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localView.setAlpha(paramFloat);
      }
    }
    else {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localView.startAnimation(localAlphaAnimation);
  }
  
  public void setChildContentDescription(int paramInt, String paramString)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if ((localView != null) && (AppSetting.enableTalkBack)) {
      localView.setContentDescription(paramString);
    }
  }
  
  public void setChildImageSource(int paramInt1, int paramInt2)
  {
    ImageView localImageView = (ImageView)findViewWithTag(Integer.valueOf(paramInt1));
    if (localImageView != null) {
      localImageView.setImageResource(paramInt2);
    }
  }
  
  public void setChildVisible(int paramInt1, int paramInt2)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt1));
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, "setCustomHeight() called with: height = [" + paramInt + "]");
    }
    this.mViewHeight = paramInt;
    requestLayout();
  }
  
  public void setEnable(int paramInt, boolean paramBoolean)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setHelperProvider(wvm paramwvm)
  {
    this.b = paramwvm;
  }
  
  public void setInterceptListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$a = parama;
  }
  
  public void setPanelIconListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$b = paramb;
  }
  
  public void setPanelIconLongListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$c = paramc;
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getTag().equals(Integer.valueOf(paramInt))) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setSelected(false);
      }
    }
  }
  
  public void setShowRed(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < getChildCount())
      {
        localObject = getChildAt(i);
        if (!((View)localObject).getTag().equals(Integer.valueOf(paramInt))) {
          break label119;
        }
        if (!this.bei) {
          break label82;
        }
        localObject = akza.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          xro.a(this.mApp, this.mSessionInfo, 4, String.valueOf(((akyu)localObject).dqk), ((akyu)localObject).id);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130851401));
      ((RedDotImageView)localObject).showRedDot(paramBoolean);
      return;
      label119:
      i += 1;
    }
  }
  
  public void setUnSelected(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt))) {
          localView.setSelected(false);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void zx(boolean paramBoolean)
  {
    ArrayList localArrayList;
    if (paramBoolean)
    {
      this.qI.clear();
      this.qI.add(xro.hz);
      localArrayList = this.qI;
      if (!this.bik) {
        break label76;
      }
      arrayOfInt = xro.hP;
      localArrayList.add(arrayOfInt);
      localArrayList = this.qI;
      if (!this.bik) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = xro.hI;; arrayOfInt = xro.hE)
    {
      localArrayList.add(arrayOfInt);
      this.bei = false;
      ces();
      return;
      arrayOfInt = xro.hL;
      break;
    }
  }
  
  public void zy(boolean paramBoolean)
  {
    int i = 0;
    boolean bool2 = ThemeUtil.isNowThemeIsDefault(this.mApp, false, null);
    boolean bool1;
    int j;
    label47:
    int k;
    label88:
    int[] arrayOfInt;
    if ((paramBoolean) && (bool2))
    {
      bool1 = true;
      this.bik = bool1;
      if ((this.mApp == null) || (this.mContext == null)) {
        break label163;
      }
      j = 1;
      if ((this.bei) || (!bool2)) {
        break label200;
      }
      if ((this.qI == null) || (this.qI.size() <= 0)) {
        break label199;
      }
      int m = this.qI.size();
      k = 0;
      if (k >= m) {
        break label187;
      }
      arrayOfInt = (int[])this.qI.get(k);
      if (!paramBoolean) {
        break label168;
      }
      arrayOfInt = (int[])this.hS.get(arrayOfInt);
      label129:
      if (arrayOfInt == null) {
        break label209;
      }
      this.qI.set(k, arrayOfInt);
      i = 1;
    }
    label163:
    label168:
    label187:
    label199:
    label200:
    label209:
    for (;;)
    {
      k += 1;
      break label88;
      bool1 = false;
      break;
      j = 0;
      break label47;
      arrayOfInt = (int[])this.hR.get(arrayOfInt);
      break label129;
      if ((i != 0) && (j != 0)) {
        ces();
      }
      do
      {
        return;
      } while (j == 0);
      ces();
      return;
    }
  }
  
  public class AioIconAnimationDrawabale
    extends DetectableAnimationDrawable
  {
    public RedDotImageView b;
    public int[] iA;
    
    public void onAnimationFinish()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "onAnimationFinish," + this.b.isSelected());
      }
      if (this.iA != null) {
        this.b.setImageResource(this.iA[2]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean R(MotionEvent paramMotionEvent);
    
    public abstract boolean S(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void k(Object paramObject);
  }
  
  public static abstract interface c
  {
    public abstract boolean e(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */