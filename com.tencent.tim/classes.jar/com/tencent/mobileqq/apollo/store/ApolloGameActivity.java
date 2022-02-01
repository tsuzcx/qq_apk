package com.tencent.mobileqq.apollo.store;

import abkj;
import able;
import ablo;
import ablw;
import abmg;
import abmt;
import aboi;
import abos;
import aboz;
import abqg;
import abql;
import absu;
import absv;
import absw;
import absx;
import absz;
import abta;
import abtb;
import abtc;
import abtd;
import abte;
import abtf;
import abuj;
import abxi;
import acbn;
import acfp;
import afjy;
import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import anre;
import aqgz;
import aqha;
import aqhu;
import aqiw;
import aqju;
import aquz;
import aqva;
import aroc;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.a;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.c;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import jll;
import org.json.JSONObject;
import wja;

public class ApolloGameActivity
  extends FragmentActivity
  implements ablw, Handler.Callback, View.OnClickListener, Observer
{
  public static final String bhA = acbn.SDCARD_ROOT + "/QQ_Screenshot/cmshow_game_splash.png";
  public static int crx;
  private long ID;
  private long NS;
  private aqju S;
  private aqju T;
  public String TAG = "cmgame_process.ApolloGameActivity";
  private abos jdField_a_of_type_Abos;
  private abql jdField_a_of_type_Abql;
  private CmGameLoadingView jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView;
  private FrameworkView jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView;
  private a jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity$a;
  private Client.b jdField_a_of_type_ComTencentMobileqqEmosmClient$b = new abtb(this);
  private aqju af;
  private aqju ag;
  private CmGameStartChecker.StartCheckParam jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameDebugView jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView;
  private WebGameFakeView jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  private boolean bFd = true;
  private boolean bFe;
  private boolean bFf;
  private boolean bFg;
  private boolean bFh;
  private boolean bFi;
  private int cpN;
  private int crw;
  private auru e = new auru(Looper.getMainLooper(), this);
  private Bitmap eF;
  private RelativeLayout el;
  private Runnable fD = new ApolloGameActivity.1(this);
  private RelativeLayout ff;
  private CmGameStartChecker mCmGameStartChecker;
  private boolean mDestroyed;
  private boolean mIsPortrait;
  private int mOrientation;
  
  private boolean Zi()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (ApolloGameUtil.d(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 1, new Object[] { "game is cancel mStartCheckParam:", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
      }
      cET();
      finish();
      if (QLog.isColorLevel()) {}
      return true;
    }
    return false;
  }
  
  private CmGameStartChecker.StartCheckParam a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = (CmGameStartChecker.StartCheckParam)paramIntent.getSerializableExtra("extra_startcheckparam");
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e(this.TAG, 1, paramIntent, new Object[0]);
    }
    return null;
  }
  
  private void c(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return;
    }
    if ((paramCmGameInitParams.commFlag & 0x2) == 2)
    {
      Message localMessage = this.e.obtainMessage(107);
      localMessage.arg1 = 1;
      localMessage.obj = new Pair(paramCmGameInitParams.rpUrl, paramCmGameInitParams.rpIconUrl);
      this.e.sendMessage(localMessage);
      return;
    }
    paramCmGameInitParams = this.e.obtainMessage(107);
    paramCmGameInitParams.arg1 = 0;
    this.e.sendMessage(paramCmGameInitParams);
  }
  
  private void cEH()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      break label7;
    }
    label7:
    while (Zi()) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isGameRscExist)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        break label234;
      }
      if (this.jdField_a_of_type_Abos != null) {
        this.jdField_a_of_type_Abos.g(this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isEnableMSAA);
      }
    }
    label62:
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView = abqg.a(this, this.jdField_a_of_type_Abos, this.e, this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    if (abkj.a(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
      Ef(true);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red == 0)) {}
    for (int i = 0;; i = 1)
    {
      VipUtils.a(null, "cmshow", "Apollo", "exposureUniversialFrameShareButton", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(i) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, new Object[] { " onCreate_doInitGameUI cost time:" + (SystemClock.uptimeMillis() - l), ",isGameRscExist:", Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isGameRscExist) });
      return;
      label234:
      cEN();
      break label62;
    }
  }
  
  private void cEI()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    AppInterface localAppInterface;
    do
    {
      do
      {
        return;
        int i = crx + 1;
        crx = i;
        this.cpN = i;
        this.jdField_a_of_type_Abos = abmt.a(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.cpN);
        if (this.jdField_a_of_type_Abos != null)
        {
          this.jdField_a_of_type_Abos.l(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          this.jdField_a_of_type_Abos.bL(this);
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.requestCode = System.currentTimeMillis();
        localAppInterface = abmt.getAppInterface();
        if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) {
          break;
        }
        this.mCmGameStartChecker = new CmGameStartChecker(localAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity$a = new a(localAppInterface);
      } while (localAppInterface == null);
      if ((!aqiw.isNetSupport(this)) && (!abmt.c(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))) {
        break;
      }
      this.mCmGameStartChecker.a(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity$a);
    } while (abmt.b(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam));
    abmg.a(localAppInterface, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, "android.subgame", new abtc(this));
    return;
    QLog.w(this.TAG, 1, "[onCreate] no net");
    this.e.sendEmptyMessageDelayed(113, 1000L);
    return;
    QLog.i(this.TAG, 1, "onCreate_doInitLaunchData mLoadingOnMainProcess:true");
  }
  
  private void cEJ()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
      String str1 = ApolloUtil.dp(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      if (TextUtils.isEmpty(abmt.iA(str1)))
      {
        String str2 = abuj.m(new File(str1));
        if (!TextUtils.isEmpty(str2)) {
          abmt.ev(str1, str2);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, " onCreate_doInitGameJs cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  private void cEK()
  {
    this.mIsPortrait = true;
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 1)
    {
      this.mIsPortrait = false;
      super.setRequestedOrientation(8);
      if (!this.mIsPortrait) {
        break label139;
      }
    }
    label139:
    for (int i = 1;; i = 2)
    {
      this.mOrientation = i;
      this.ID = aqgz.i(true);
      this.NS = aqgz.hL();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, new Object[] { "onCreate_doActivityInfo mLastScreenWidth:", Long.valueOf(this.ID), ",mLastScrrenHeight:", Long.valueOf(this.NS) });
      }
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2)
      {
        this.mIsPortrait = false;
        super.setRequestedOrientation(0);
        break;
      }
      super.setRequestedOrientation(1);
      break;
    }
  }
  
  private void cEL()
  {
    this.el = ((RelativeLayout)LayoutInflater.from(this).inflate(2131558470, null));
    super.setContentView(this.el);
    q(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  private void cEM()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 319) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 318)) {
      cEW();
    }
    abmt.a(1, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.cpN);
    afjy.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$b);
    if (!afjy.a().ajq()) {
      afjy.a().a().doBindService(getApplicationContext());
    }
    aboz localaboz = abmt.a();
    if (localaboz != null) {
      localaboz.b(this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    ThreadManagerV2.excute(new ApolloGameActivity.5(this), 128, null, false);
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (this.jdField_a_of_type_Abos != null)) {
      this.jdField_a_of_type_Abos.cDI();
    }
    Zi();
  }
  
  private void cEN()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    while ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 1) || (this.bFh)) {
      return;
    }
    QQBrowserActivity.bJl += 1;
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(-1);
      this.mSystemBarComp.setStatusBarColor(-1);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("session_uin", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin);
    localBundle.putSerializable("game_init", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView = new WebGameFakeView(getWindow(), localBundle);
    this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.bDJ = true;
    this.bFh = true;
  }
  
  private void cEO()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 1) {
        super.setRequestedOrientation(8);
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2)
    {
      super.setRequestedOrientation(0);
      return;
    }
    super.setRequestedOrientation(1);
  }
  
  private void cEQ()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (!this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.showAlertTips)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkShowMsgAlert mStartCheckParam == null || !mStartCheckParam.showAlertTips");
      }
    }
    while (this.bFg) {
      return;
    }
    this.bFg = true;
    String str = "";
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 2) {
      str = acfp.m(2131702518);
    }
    for (;;)
    {
      if (this.ag == null) {
        this.ag = aqha.a(this, 0, null, str, 2131721079, 2131721058, null, new absw(this));
      }
      if (!TextUtils.isEmpty(str))
      {
        this.ag.setMessage(str);
        this.ag.show();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, new Object[] { "checkShowMsgAlert msgText:", str });
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 3) {
        str = acfp.m(2131702505);
      } else if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 4) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 5) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 6) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 7) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 8)) {
        str = acfp.m(2131702528);
      }
    }
  }
  
  private void cEU()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (!this.bFi))
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("StartCheckParam", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_on_game_activity_closed", localBundle, null);
      this.bFi = true;
    }
  }
  
  private void gZ(long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    ablo.d(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("game_loading_create_time", Long.valueOf(l1));
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_launch_time"))
      {
        l2 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_launch_time")).longValue();
        if ((l2 <= 0L) || (l2 != abmt.Oa)) {
          break label510;
        }
        l3 = l1 - l2;
        if (l3 <= 0L) {
          break label416;
        }
        localObject = "cmgame_loading_ui_launch_time";
        if (l3 >= 10000L)
        {
          localObject = "cmgame_loading_ui_launch_time_exception";
          this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        localHashMap.put("param_src", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), (String)localObject, true, l3, 0L, localHashMap, "", false);
        QLog.d("CmGameStat", 1, new Object[] { localObject, ", duration=", Long.valueOf(l3), ", launchTime=", Long.valueOf(l2), ", createTime=", Long.valueOf(l1), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      }
    }
    for (;;)
    {
      paramLong = SystemClock.uptimeMillis() - paramLong;
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_activity_create, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      if (paramLong <= 0L) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "cmgame_game_activity_create", true, paramLong, 0L, (HashMap)localObject, "", false);
      return;
      label416:
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_loading_ui_launch_time, invalid duration=", Long.valueOf(l3), ", receiveTime=", Long.valueOf(l2), ", createTime=", Long.valueOf(l1), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
      continue;
      label510:
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
      QLog.d("CmGameStat", 1, new Object[] { "invalid receiveTime=", Long.valueOf(l2), ", sLaunchGameTs=", Long.valueOf(abmt.Oa), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  private void q(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    this.ff = ((RelativeLayout)super.findViewById(2131377555));
    if (!paramStartCheckParam.mLoadingOnMainProcess)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView = CmGameLoadingView.a(this, this.mIsPortrait);
      this.ff.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.f(paramStartCheckParam);
      return;
    }
    QLog.i(this.TAG, 1, "initView mLoadingOnMainProcess:true");
  }
  
  public void D(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "[dismissLoadingPage] delayTime：", Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.DP(paramBoolean);
    }
    this.e.removeMessages(103);
    this.e.sendEmptyMessageDelayed(103, paramLong);
  }
  
  public void DW(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Abos != null) {
      this.jdField_a_of_type_Abos.DW(paramBoolean);
    }
  }
  
  public void Ef(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView == null)) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView == null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView = ((CmGameDebugView)abqg.a(this, this.jdField_a_of_type_Abos, this.e, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, 2));
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.setVisibility(8);
  }
  
  public CmGameStartChecker.StartCheckParam a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  }
  
  public WebGameFakeView a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  }
  
  public void a(int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, ApolloGameUtil.c paramc)
  {
    String str = String.format(acfp.m(2131702481), new Object[] { paramString });
    if (this.af == null)
    {
      this.af = aqha.b(this, 0, 2131559137, acfp.m(2131702488), str, acfp.m(2131702530), acfp.m(2131702515), new absx(this, paramIntent, paramString, paramBitmap, paramc, paramInt), new absz(this, paramc, paramInt));
      this.af.setPreviewImage(new BitmapDrawable(paramBitmap), true, 1);
      this.af.show();
      return;
    }
    this.af.setMessage(str);
    this.af.setPreviewImage(new BitmapDrawable(paramBitmap), true, 1);
    this.af.show();
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    ((FrameLayout)this.ff.findViewById(2131367885)).addView(paramApolloSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.onGameFailed(paramStartCheckParam, paramInt);
    }
  }
  
  public Bitmap as()
  {
    if (this.eF != null) {
      return this.eF;
    }
    return null;
  }
  
  public void at(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)) {
      ((CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).at(paramBoolean, paramString);
    }
  }
  
  public abql b()
  {
    return this.jdField_a_of_type_Abql;
  }
  
  public void b(CmGameInitParams paramCmGameInitParams)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (paramCmGameInitParams == null)) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId = paramCmGameInitParams.openId;
      paramCmGameInitParams.mIsEnableMSAA = this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isEnableMSAA;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess)
      {
        aboz localaboz = abmt.a();
        if (localaboz != null) {
          localaboz.bQ(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, paramCmGameInitParams.mSSORule);
        }
        abhh.bfR = paramCmGameInitParams.apolloGameSt;
        abhh.bfS = paramCmGameInitParams.apolloGameStkey;
      }
      c(paramCmGameInitParams);
      if ((this.eF != null) && (this.jdField_a_of_type_Abos != null)) {
        this.jdField_a_of_type_Abos.K(this.eF);
      }
      abmt.x(new Object[] { "[startGame], gameType:", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType) });
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        break;
      }
    } while (this.jdField_a_of_type_Abos == null);
    this.jdField_a_of_type_Abos.a(this, paramCmGameInitParams);
    this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startCallEngine = System.currentTimeMillis();
    return;
    if (this.jdField_a_of_type_Abos != null) {
      this.jdField_a_of_type_Abos.b(this, paramCmGameInitParams);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 5) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof QzoneGameFloatView)) && (this.e != null)) {
      this.e.post(this.fD);
    }
    cEN();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof QzoneGameFloatView)) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 5)) {
      ((QzoneGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).setFrameViewStyle(a());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      try
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.b == null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {
          ApolloGameUtil.a(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, null, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType, this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson);
        }
        for (;;)
        {
          if (abmt.b(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
            this.e.sendEmptyMessage(109);
          }
          this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(paramCmGameInitParams);
          D(true, 50L);
          return;
          if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mUpdated) {
            ApolloGameUtil.a(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.b, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType, this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, localThrowable, new Object[0]);
        }
      }
    }
    QLog.e(this.TAG, 1, "startGame but mWebGameFakeView is null, finish it!");
    finish();
  }
  
  public void cCT()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.cCT();
    }
  }
  
  public void cCU()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.cCU();
    }
  }
  
  public void cCV()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.cCV();
    }
  }
  
  public void cCW()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.cCW();
    }
  }
  
  public void cCb()
  {
    QLog.d(this.TAG, 1, "[onExeJsStart]");
    this.e.removeMessages(108);
    this.e.sendEmptyMessageDelayed(108, 10000L);
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("start_exe_js_time", Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public void cEP()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mOpenTempAIOOnFinish) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("friendUin", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin);
      localJSONObject.put("nickName", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIONickName);
      aboi.a("cs.open_cm_aio.local", localJSONObject.toString(), true, null, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.TAG, 1, localException, new Object[0]);
    }
  }
  
  public void cER()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[onFirstFrameDrawn]");
    }
    if (!this.bFd) {
      QLog.w(this.TAG, 2, "[onFirstFrameDrawn] call more than once");
    }
    D(false, 50L);
    this.e.removeMessages(108);
    long l5;
    long l2;
    Object localObject;
    if ((this.bFd) && (!this.bFf) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null))
    {
      l5 = SystemClock.uptimeMillis();
      l2 = 0L;
      QLog.d("CmGameStat", 1, new Object[] { "firstFrameTime=", Long.valueOf(l5), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("first_frame_callback_time", Long.valueOf(l5));
      l1 = l2;
      if (!this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("click_time")) {
        break label1409;
      }
      localObject = (Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("click_time");
      l1 = l2;
      if (localObject == null) {
        break label1409;
      }
      l1 = l2;
      if (((Long)localObject).longValue() <= 0L) {
        break label1409;
      }
      if (!this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_process_on")) {
        break label1438;
      }
    }
    label1409:
    label1412:
    label1438:
    for (long l1 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_process_on")).longValue();; l1 = 0L)
    {
      l2 = l5 - ((Long)localObject).longValue();
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_game_res")) {}
      for (long l3 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_game_res")).longValue();; l3 = 0L)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_confirm")) {}
        for (long l4 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_confirm")).longValue();; l4 = 0L)
        {
          int i = aroc.getNetType(null);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
          ((HashMap)localObject).put("param_processOn", String.valueOf(l1));
          ((HashMap)localObject).put("param_download", String.valueOf(l3));
          ((HashMap)localObject).put("param_downloadConfirm", String.valueOf(l4));
          ((HashMap)localObject).put("param_netType", String.valueOf(i));
          ((HashMap)localObject).put("param_src", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
          anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_click_to_show_game", true, l2, 0L, (HashMap)localObject, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_show_game, duration=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", processOn=", Long.valueOf(l1), ", downloadRes=", Long.valueOf(l3), ", downloadConfirm=", Long.valueOf(l4), ", netType=", Integer.valueOf(i), ", src=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src), "]" });
          l1 = l2;
          if (l4 == 0L) {
            if (l3 == 0L)
            {
              anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_launch_total_time_not_download", true, l2, 0L, (HashMap)localObject, "", false);
              l1 = l2;
              localObject = new HashMap();
              ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
              ((HashMap)localObject).put("param_src", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
              if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("start_exe_js_time"))
              {
                l2 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("start_exe_js_time")).longValue();
                if (l2 > 0L)
                {
                  l3 = l5 - l2;
                  if (l3 >= 0L) {
                    anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_first_frame_time", true, l3, 0L, (HashMap)localObject, "", false);
                  }
                  QLog.d("CmGameStat", 1, new Object[] { "cmgame_first_frame_time, duration=", Long.valueOf(l3), ", extJsTime=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
                }
              }
              if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("exe_js_end_time"))
              {
                l2 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("exe_js_end_time")).longValue();
                if (l2 > 0L)
                {
                  l3 = l5 - l2;
                  if (l3 >= 0L) {
                    anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_first_frame_time_new", true, l3, 0L, (HashMap)localObject, "", false);
                  }
                  abmt.x(new Object[] { "[handleFirstFrame], done cost:", Long.valueOf(l3) });
                  QLog.d("CmGameStat", 1, new Object[] { "cmgame_first_frame_time_new, duration=", Long.valueOf(l3), ", exeJsEndTime=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
                }
              }
              if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.Oh > 0L))
              {
                l2 = l5 - this.jdField_a_of_type_Abos.Oh;
                if (l2 >= 0L) {
                  anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_start_engine_to_first_frame", true, l2, 0L, (HashMap)localObject, "", false);
                }
                QLog.d("CmGameStat", 1, new Object[] { "cmgame_start_engine_to_first_frame, duration=", Long.valueOf(l2), ", mStartGameEngineTs=", Long.valueOf(this.jdField_a_of_type_Abos.Oh), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
              }
              if (this.bFe) {
                break label1412;
              }
              ((HashMap)localObject).put("param_Result", "1");
              anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_launch_result", true, 0L, 0L, (HashMap)localObject, "", false);
              QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, success", " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
              abmt.a(getAppInterface(), 1, 0, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0L, null);
              ((HashMap)localObject).clear();
              ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
              ((HashMap)localObject).put("param_timeout", "0");
              anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_first_frame_timeout", true, 0L, 0L, (HashMap)localObject, "", false);
            }
          }
          for (;;)
          {
            abmt.x(new Object[] { "[launchGame] success, all cost:", Long.valueOf(l1) });
            DW(true);
            this.bFd = false;
            return;
            anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_launch_total_time_with_download", true, l2, 0L, (HashMap)localObject, "", false);
            l1 = l2;
            break;
            QLog.w(this.TAG, 2, "[onFirstFrameDrawn] first frame too long");
          }
        }
      }
    }
  }
  
  public void cES()
  {
    long l2;
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_loading_resume_time")))
    {
      l2 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_loading_resume_time")).longValue();
      if (l2 > 0L) {
        if (!this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_process_on")) {
          break label487;
        }
      }
    }
    label487:
    for (long l1 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_process_on")).longValue();; l1 = 0L)
    {
      long l4 = SystemClock.uptimeMillis() - l2;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_game_res")) {}
      for (l2 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_game_res")).longValue();; l2 = 0L)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_confirm")) {}
        for (long l3 = ((Long)this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_confirm")).longValue();; l3 = 0L)
        {
          int i = aroc.getNetType(null);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.getVisibility() == 0)) {}
          for (String str = "1";; str = "0")
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            localHashMap.put("param_processOn", String.valueOf(l1));
            localHashMap.put("param_isLoading", str);
            localHashMap.put("param_download", String.valueOf(l2));
            localHashMap.put("param_downloadConfirm", String.valueOf(l3));
            localHashMap.put("param_netType", String.valueOf(i));
            localHashMap.put("param_gameProc", "1");
            anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_click_to_close", true, l4, 0L, localHashMap, "", false);
            QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_close, game proc, duration=", Long.valueOf(l4), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", processOn=", Long.valueOf(l1), ", isLoading=", str, ", downloadRes=", Long.valueOf(l2), ", downloadConfirm=", Long.valueOf(l3), ", netType=", Integer.valueOf(i), "]" });
            return;
          }
        }
      }
    }
  }
  
  public void cET()
  {
    this.bFi = true;
  }
  
  @TargetApi(21)
  public void cEV()
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null))
    {
      localObject1 = abxi.biw + "boxcard/" + Utils.Crc64String(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.logoUrl);
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        break label153;
      }
      localObject2 = new aquz(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.logoUrl, (File)localObject2);
      ((aquz)localObject2).cWy = false;
      ((aquz)localObject2).cxX = "apollo_res";
      ((aquz)localObject2).retryCount = 1;
      ((aquz)localObject2).cWz = true;
      if (aqva.a((aquz)localObject2, this.app) == 0) {
        break label153;
      }
      QLog.e(this.TAG, 1, "setTaskDescription download failed");
    }
    for (;;)
    {
      return;
      try
      {
        label153:
        localObject1 = BitmapFactory.decodeFile((String)localObject1);
        if (localObject1 != null)
        {
          int i = wja.dp2px(28.0F, getResources());
          int j = (int)(((Bitmap)localObject1).getWidth() / 3.0F);
          localObject2 = RoundedBitmapDrawableFactory.create(getResources(), (Bitmap)localObject1);
          ((RoundedBitmapDrawable)localObject2).setCornerRadius(j);
          ((RoundedBitmapDrawable)localObject2).setAntiAlias(true);
          setTaskDescription(new ActivityManager.TaskDescription(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name, aqhu.f((Drawable)localObject2, i, i)));
          ((Bitmap)localObject1).recycle();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.TAG, 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void cEW()
  {
    abta localabta = new abta(this);
    if (this.jdField_a_of_type_Abos != null)
    {
      String str = this.jdField_a_of_type_Abos.a().mTempAIOUin;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", str);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_query_voice_status", localBundle, localabta);
    }
  }
  
  public void dc(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.da(paramIntent);
    }
    DW(true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      do
      {
        return;
        if (paramIntent == null) {
          break;
        }
      } while (anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null);
      paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      VipUtils.a(null, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.gi(i), 0, new String[] { Integer.toString(j) });
      continue;
      if (this.jdField_a_of_type_Abos != null) {
        if (paramInt2 == -1)
        {
          this.jdField_a_of_type_Abos.o(0, 1, 0, "");
        }
        else
        {
          this.jdField_a_of_type_Abos.o(1, 1, 0, "");
          continue;
          if ((this.jdField_a_of_type_Abos != null) && (paramIntent != null))
          {
            i = paramIntent.getIntExtra("share_result_key", -1);
            if (i == 0) {}
            try
            {
              QQToast.a(getApplicationContext(), acfp.m(2131702482), 0).show();
              j = paramIntent.getIntExtra("uintype", -1);
              String str = paramIntent.getStringExtra("uin");
              j = ApolloGameUtil.a(abmt.getAppInterface(), j, str);
              this.jdField_a_of_type_Abos.o(i, 0, j, str);
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                QLog.e(this.TAG, 1, localThrowable1, new Object[0]);
              }
            }
            if ((this.jdField_a_of_type_Abos != null) && (paramIntent != null))
            {
              i = paramIntent.getIntExtra("share_result_key", -1);
              if (i == 0) {}
              try
              {
                QQToast.a(getApplicationContext(), acfp.m(2131702514), 0).show();
                this.jdField_a_of_type_Abos.HG(i);
              }
              catch (Throwable localThrowable2)
              {
                for (;;)
                {
                  QLog.e(this.TAG, 1, localThrowable2, new Object[0]);
                }
              }
              if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.b() != null)) {
                this.jdField_a_of_type_Abos.b().runRenderTask(new ApolloGameActivity.12(this, paramInt1, paramInt2, paramIntent));
              }
            }
          }
        }
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      QLog.d(this.TAG, 1, new Object[] { "[doOnConfigurationChanged] new orientation=", Integer.valueOf(paramConfiguration.orientation), ", mOrientation=", Integer.valueOf(this.mOrientation) });
      if (this.mOrientation != paramConfiguration.orientation)
      {
        this.mOrientation = paramConfiguration.orientation;
        this.e.removeMessages(105);
        this.e.sendEmptyMessageDelayed(105, 500L);
      }
      long l = aqgz.i(true);
      if ((this.ID != l) && (this.ID != this.NS))
      {
        QLog.d(this.TAG, 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l) });
        this.e.sendEmptyMessageDelayed(102, 500L);
      }
      this.ID = l;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = SystemClock.uptimeMillis();
    ApolloGameStateMachine.a().reset();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = a(super.getIntent());
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
    {
      QLog.e(this.TAG, 1, "[doOnCreate] no start param");
      finish();
      return false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {
      QLog.i(this.TAG, 1, "[doOnCreate] game is new, gameId:" + this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
    }
    paramBundle = abmt.a();
    if (paramBundle != null) {
      paramBundle.DX(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr);
    }
    long l2;
    int i;
    if (!this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr)
    {
      abmt.bEa = true;
      l2 = System.currentTimeMillis() - this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs;
      QLog.i(this.TAG, 1, "[game_launch_cost], activity onCreate:" + l2);
      i = this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
        break label442;
      }
    }
    label442:
    for (paramBundle = null;; paramBundle = this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      abmt.x(new Object[] { "[launchGame], gameId:", Integer.valueOf(i), ", gameName:", paramBundle, ", mLoadingOnMainProcess:", Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess), ", start cost:", Long.valueOf(l2) });
      ThreadManager.post(new ApolloGameActivity.3(this), 8, null, false);
      cEK();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " onCreate_doActivityInfo cost time:" + (SystemClock.uptimeMillis() - l1));
      }
      l2 = SystemClock.uptimeMillis();
      cEL();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " onCreate_doInitUI cost time:" + (SystemClock.uptimeMillis() - l2));
      }
      l2 = SystemClock.uptimeMillis();
      gZ(l1);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " onCreate_doReport cost time:" + (SystemClock.uptimeMillis() - l2));
      }
      return true;
      abmt.bEa = false;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i(this.TAG, 1, "[doOnDestroy] this:" + this);
    ablo.e(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.e.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.destroy(false);
    }
    if (this.jdField_a_of_type_Abql != null) {
      this.jdField_a_of_type_Abql.onDestroy();
    }
    this.mDestroyed = true;
    ApolloGameStateMachine.a().deleteObserver(this);
    if (this.ag != null) {
      this.ag.dismiss();
    }
    if (this.jdField_a_of_type_Abos != null)
    {
      this.jdField_a_of_type_Abos.doOnDestroy();
      abmt.b(this.jdField_a_of_type_Abos.getGameId(), this.cpN);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      abmt.aB(5, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.cpN);
      localObject = abmt.a();
      if (localObject != null) {
        ((aboz)localObject).d(this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        QQBrowserActivity.bJl -= 1;
      }
      if (abmt.NZ == this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs) {
        abmt.NZ = 0L;
      }
    }
    able.a().destroy();
    if (this.af != null) {
      this.af.dismiss();
    }
    if (this.S != null) {
      this.S.dismiss();
    }
    if (this.T != null) {
      this.T.dismiss();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_game_friUin", this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_audio_exit_room", (Bundle)localObject, null);
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) {
        ApolloGameUtil.cGl();
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.onDestroy();
    }
    Object localObject = abmt.a();
    if (localObject != null) {
      ((abkj)localObject).onDestroy();
    }
    afjy.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$b);
    cEU();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (3 == paramInt)
    {
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    cEO();
    super.doOnNewIntent(paramIntent);
    QLog.d(this.TAG, 1, "[doOnNewIntent]");
    ablo.d(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    try
    {
      if (this.jdField_a_of_type_Abos != null)
      {
        if (this.jdField_a_of_type_Abos.b() == null) {
          return;
        }
        if (paramIntent != null)
        {
          paramIntent = a(paramIntent);
          if (paramIntent != null)
          {
            if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramIntent != null)) {
              this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap = paramIntent.statMap;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, new Object[] { "try update gameParam:", paramIntent.extendJson });
            }
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("gameParam", paramIntent.extendJson);
            abmt.a().callbackFromRequest(this.jdField_a_of_type_Abos.b().getLuaState(), 0, "sc.game_param_update.local", localJSONObject.toString());
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.TAG, 1, paramIntent, new Object[0]);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    QLog.d(this.TAG, 1, "[doOnPause]");
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      abmt.aB(3, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.cpN);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Abos != null)
        {
          if (!this.jdField_a_of_type_Abos.YN()) {
            continue;
          }
          ApolloSurfaceView localApolloSurfaceView = this.jdField_a_of_type_Abos.b();
          if (localApolloSurfaceView != null) {
            abmt.a().callbackFromRequest(localApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_disactivity.local", "{}");
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.TAG, 1, localException, new Object[0]);
        continue;
      }
      this.e.removeMessages(100);
      if (this.jdField_a_of_type_Abos != null) {
        this.jdField_a_of_type_Abos.doOnPause();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.onBackground();
      }
      if (this.jdField_a_of_type_Abql != null) {
        this.jdField_a_of_type_Abql.onPause();
      }
      ablo.e(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      this.bFf = true;
      return;
      abmt.a().callbackFromRequest(this.jdField_a_of_type_Abos.getGameId(), 0, "cs.xy_life_cycle_event_disactivity.local", "{}");
    }
  }
  
  public void doOnResume()
  {
    QLog.d(this.TAG, 1, "doOnResume");
    cEO();
    super.doOnResume();
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      abmt.aB(2, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.cpN);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Abos != null)
        {
          if (!this.jdField_a_of_type_Abos.YN()) {
            continue;
          }
          localObject = this.jdField_a_of_type_Abos.b();
          if (localObject != null) {
            abmt.a().callbackFromRequest(((ApolloSurfaceView)localObject).getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(this.TAG, 1, localException, new Object[0]);
        continue;
      }
      this.crw = 0;
      this.e.sendEmptyMessageDelayed(100, 500L);
      if (this.jdField_a_of_type_Abos != null) {
        this.jdField_a_of_type_Abos.doOnResume();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.onForeground();
      }
      localObject = abmt.a();
      if (localObject != null) {
        ((aboz)localObject).c(this, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
      if (this.jdField_a_of_type_Abql != null) {
        this.jdField_a_of_type_Abql.onResume();
      }
      ablo.d(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)) {
        this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("game_loading_resume_time", Long.valueOf(SystemClock.uptimeMillis()));
      }
      Zi();
      return;
      abmt.a().callbackFromRequest(this.jdField_a_of_type_Abos.getGameId(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      abmt.aB(4, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.cpN);
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19))
    {
      View localView = getWindow().getDecorView();
      if (!abmt.b(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
        localView.setSystemUiVisibility(5894);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    cEU();
  }
  
  public void gQ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "[onReadGameMainJs] duration=", Long.valueOf(paramLong) });
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramLong >= 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_game_mainjs_read_time", true, paramLong, 0L, localHashMap, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_mainjs_read_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  public void gR(long paramLong)
  {
    QLog.d(this.TAG, 1, new Object[] { "[onExeJsEnd] duration=", Long.valueOf(paramLong) });
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("exe_js_end_time", Long.valueOf(SystemClock.uptimeMillis()));
      }
      if (paramLong >= 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        localHashMap.put("param_src", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
        anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_exe_js_time", true, paramLong, 0L, localHashMap, "", false);
        abmt.x(new Object[] { "[executeJs], done cost:", Long.valueOf(paramLong) });
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_exe_js_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.cDf();
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public void ha(long paramLong)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramLong > 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_game_view_create_time", true, paramLong, 0L, localHashMap, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_view_create_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "handleMessage what:", Integer.valueOf(paramMessage.what) });
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      cEH();
      continue;
      this.crw += 1;
      if (this.crw < 3)
      {
        this.e.sendEmptyMessageDelayed(100, 500L);
        continue;
        QLog.d(this.TAG, 1, "[handleMessage] close game timeout, just finish");
        finish();
        cEP();
        continue;
        cEU();
        if (this.jdField_a_of_type_Abos != null) {
          this.jdField_a_of_type_Abos.DV(true);
        }
        boolean bool;
        if (this.jdField_a_of_type_Abql == null)
        {
          bool = true;
          if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode != 1) {
            break label358;
          }
          bool = false;
        }
        for (;;)
        {
          this.jdField_a_of_type_Abql = new abql(this.el, bool, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView == null) {
            break label374;
          }
          QLog.d(this.TAG, 1, "[handleMessage] remove loading rootView.");
          paramMessage = new AlphaAnimation(1.0F, 0.0F);
          paramMessage.setDuration(300L);
          paramMessage.setAnimationListener(new abtd(this));
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.PM.getVisibility() == 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.PM.setText("100%");
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.startAnimation(paramMessage);
          if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enableMenu)) {
            break;
          }
          QLog.d(this.TAG, 1, "[handleMessage] remove top menu");
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.setVisibility(8);
          break;
          label358:
          if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2) {
            bool = false;
          }
        }
        label374:
        QLog.e(this.TAG, 1, "[handleMessage] loading root is null");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.resetView();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.PL.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.fB.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)))
          {
            CmGameFloatView localCmGameFloatView = (CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView;
            int i;
            if (paramMessage.arg1 == 1) {
              i = 1;
            }
            for (;;)
            {
              if ((i != 0) && (paramMessage.obj != null))
              {
                paramMessage = (Pair)paramMessage.obj;
                String str = (String)paramMessage.first;
                if (!TextUtils.isEmpty(str))
                {
                  localCmGameFloatView.u(true, str, (String)paramMessage.second);
                  break;
                  i = 0;
                  continue;
                }
                localCmGameFloatView.u(false, null, null);
                break;
              }
            }
            localCmGameFloatView.u(false, null, null);
            continue;
            if (this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.bDI = true;
              this.jdField_b_of_type_ComTencentMobileqqApolloGameWebGameFakeView.dX(getWindow().getDecorView());
              getWindow().addFlags(2048);
              getWindow().clearFlags(1024);
              getWindow().clearFlags(67108864);
              getWindow().clearFlags(134217728);
              getWindow().setFlags(256, 65536);
              getWindow().clearFlags(256);
              getWindow().clearFlags(512);
              getWindow().addFlags(256);
              findViewById(2131368717).setVisibility(8);
              getWindow().getDecorView().setSystemUiVisibility(0);
              ImmersiveUtils.clearCoverForStatus(getWindow(), true);
              continue;
              if ((!this.bFf) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
              {
                paramMessage = new HashMap();
                paramMessage.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
                paramMessage.put("param_Result", "0");
                paramMessage.put("param_FailCode", String.valueOf(-14));
                anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_launch_result", false, 0L, 0L, paramMessage, "", false);
                QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, failed, first frame timeout", " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", failCode=", Integer.valueOf(-14), "]" });
                paramMessage.clear();
                paramMessage.put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
                paramMessage.put("param_timeout", "1");
                anpc.a(getAppInterface().getApp()).collectPerformance(getCurrentAccountUin(), "cmgame_first_frame_timeout", true, 0L, 0L, paramMessage, "", false);
                this.bFe = true;
                abmt.a(getAppInterface(), 1, 1, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, -14L, null);
                abmt.x(new Object[] { "[handleFirstFrame], wait time out" });
                abmt.x(new Object[] { "[handleFirstFrame], 未收到游戏方的首帧回调，请优化" });
                if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr)
                {
                  QQToast.a(getApplicationContext(), acfp.m(2131702517), 1).show();
                  continue;
                  if ("dialog_type_permission".equals((String)paramMessage.obj))
                  {
                    if (this.T == null)
                    {
                      paramMessage = aqha.a(this, 230).setMessage(getString(2131697844)).setTitle(getString(2131697845)).setNegativeButton(2131721058, new abtf(this));
                      if (!jll.i(this)) {
                        break label1094;
                      }
                    }
                    label1094:
                    for (i = 2131697846;; i = 2131697847)
                    {
                      this.T = paramMessage.setPositiveButton(i, new abte(this));
                      this.T.show();
                      break;
                    }
                  }
                  if (this.S == null) {
                    this.S = aqha.a(this, 230).setMessage(acfp.m(2131702510)).setPositiveButton(getString(2131721079), new absv(this)).setNegativeButton(getString(2131721058), new absu(this));
                  }
                  this.S.show();
                  continue;
                  abqg.a(this, this.jdField_a_of_type_Abos, this.e, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, 1);
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.cEh();
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
                      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.onGameFailed(null, -10L);
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
  
  public void i(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)) {
      ((CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).i(paramBoolean1, paramBoolean2, paramString);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void n(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
      return;
    }
    paramStartCheckParam.statMap = this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap;
    this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public boolean onBackEvent()
  {
    QLog.i(this.TAG, 1, "[onBackEvent]");
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 3112)) {
      return super.onBackEvent();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame))
    {
      cEP();
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YM()))
    {
      QLog.d(this.TAG, 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_Abos.caS();
      overridePendingTransition(0, 0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 8))
    {
      super.setRequestedOrientation(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "[setRequestedOrientation], requestedOrientation:" + paramInt);
      }
    }
  }
  
  public void setStatusColor(int paramInt)
  {
    this.mNeedStatusTrans = true;
    setImmersiveStatus(0);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(paramInt);
      this.mSystemBarComp.setStatusBarColor(paramInt);
    }
  }
  
  public void setTheme(int paramInt)
  {
    for (;;)
    {
      try
      {
        CmGameStartChecker.StartCheckParam localStartCheckParam = a(getIntent());
        if ((localStartCheckParam != null) && (localStartCheckParam.notFullScreen))
        {
          super.setTheme(2131755355);
          if (!QLog.isColorLevel()) {
            break;
          }
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("onCreate notFullScreen:");
          if ((localStartCheckParam != null) && (localStartCheckParam.notFullScreen))
          {
            bool = true;
            QLog.d(str, 2, bool);
          }
        }
        else
        {
          super.setTheme(2131755354);
          continue;
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        QLog.e(this.TAG, 1, localException, new Object[0]);
        return;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
  
  public void yk(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 110;
    localMessage.obj = paramString;
    this.e.removeMessages(110);
    this.e.sendMessage(localMessage);
  }
  
  class a
    extends CmGameStartChecker.a
  {
    public a(AppInterface paramAppInterface)
    {
      super(false);
    }
    
    public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.b paramb, long paramLong)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this)) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d(ApolloGameActivity.this.TAG, 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
            return;
            if ((ApolloGameActivity.a(ApolloGameActivity.this) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(ApolloGameActivity.this).requestCode)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(ApolloGameActivity.this.TAG, 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
          return;
          if (paramLong > 0L) {
            break;
          }
          QLog.d(ApolloGameActivity.this.TAG, 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
        } while (paramb == null);
        paramb.b(paramStartCheckParam);
        return;
        if ((ApolloGameActivity.a(ApolloGameActivity.this) != null) && (ApolloGameActivity.a(ApolloGameActivity.this).statMap != null)) {
          ApolloGameActivity.a(ApolloGameActivity.this).statMap.put("download_confirm", Long.valueOf(1L));
        }
      } while (ApolloGameActivity.a(ApolloGameActivity.this) == null);
      ApolloGameActivity.a(ApolloGameActivity.this).onDownloadConfirm(paramStartCheckParam, paramb, paramLong);
    }
    
    public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      super.onDownloadGameResDown(paramStartCheckParam);
      if ((ApolloGameActivity.a(ApolloGameActivity.this) != null) && (ApolloGameActivity.a(ApolloGameActivity.this).statMap != null)) {
        ApolloGameActivity.a(ApolloGameActivity.this).statMap.put("download_game_res", Long.valueOf(1L));
      }
    }
    
    public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      QLog.d(ApolloGameActivity.this.TAG, 1, "[onDownloadGameResFail]");
      onGameFailed(paramStartCheckParam, -12L);
    }
    
    public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this) != null) {
        ApolloGameActivity.a(ApolloGameActivity.this).onDownloadGameResProgress(paramStartCheckParam, paramInt);
      }
    }
    
    public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this)) {}
      do
      {
        return;
        QLog.d(ApolloGameActivity.this.TAG, 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
        if (paramStartCheckParam == null)
        {
          QLog.e(ApolloGameActivity.this.TAG, 1, "onCheckGameFinish mStartCheckParam == null");
          return;
        }
        if (paramLong != 0L)
        {
          onGameFailed(paramStartCheckParam, paramLong);
          return;
        }
      } while (ApolloGameActivity.a(ApolloGameActivity.this) == null);
      ApolloGameActivity.a(ApolloGameActivity.this).a(paramLong, paramStartCheckParam);
    }
    
    public void onGameCheckRetry(int paramInt)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this)) {}
      while (ApolloGameActivity.a(ApolloGameActivity.this) == null) {
        return;
      }
      ApolloGameActivity.a(ApolloGameActivity.this).a(paramInt, ApolloGameActivity.a(ApolloGameActivity.this));
    }
    
    public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this) != null) {
        ApolloGameActivity.a(ApolloGameActivity.this).onGameFailed(paramStartCheckParam, paramLong);
      }
    }
    
    public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        if (paramStartCheckParam != null) {
          break label43;
        }
        QLog.d(ApolloGameActivity.this.TAG, 2, "showGameLifeTip mStartCheckParam is null");
      }
      for (;;)
      {
        onGameFailed(paramStartCheckParam, -1L);
        return;
        label43:
        QLog.d(ApolloGameActivity.this.TAG, 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
      }
    }
    
    public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      super.onGetGameData(paramStartCheckParam);
      if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
        QLog.e(ApolloGameActivity.this.TAG, 1, "onGetGameData startCheckParam == null or game is null");
      }
      do
      {
        return;
        ApolloGameActivity.a(ApolloGameActivity.this).game = paramStartCheckParam.game;
        if (ApolloGameActivity.a(ApolloGameActivity.this) != null) {
          ApolloGameActivity.a(ApolloGameActivity.this).l(ApolloGameActivity.a(ApolloGameActivity.this));
        }
      } while (ApolloGameActivity.a(ApolloGameActivity.this) == null);
      ApolloGameActivity.a(ApolloGameActivity.this).g(paramStartCheckParam);
    }
    
    public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (ApolloGameActivity.a(ApolloGameActivity.this)) {}
      do
      {
        do
        {
          return;
          QLog.d(ApolloGameActivity.this.TAG, 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
          if (paramStartCheckParam != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(ApolloGameActivity.this.TAG, 2, "onVerifyGameFinish mStartCheckParam == null");
        return;
        if ((ApolloGameActivity.a(ApolloGameActivity.this) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(ApolloGameActivity.this).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(ApolloGameActivity.this.TAG, 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (ApolloGameActivity.a(ApolloGameActivity.this) != null) {
        ApolloGameActivity.a(ApolloGameActivity.this).a(paramStartCheckParam, paramLong);
      }
      if (paramLong != 0L)
      {
        onGameFailed(paramStartCheckParam, paramLong);
        return;
      }
      if (paramCmGameInitParams != null)
      {
        paramCmGameInitParams.appId = ApolloGameActivity.a(ApolloGameActivity.this).game.appId;
        paramCmGameInitParams.commFlag = ApolloGameActivity.a(ApolloGameActivity.this).commFlag;
        paramCmGameInitParams.rpUrl = ApolloGameActivity.a(ApolloGameActivity.this).rpUrl;
        paramCmGameInitParams.rpIconUrl = ApolloGameActivity.a(ApolloGameActivity.this).rpIconUrl;
      }
      if (paramCmGameInitParams != null) {
        paramCmGameInitParams.accessTokenRet = 0;
      }
      ApolloGameActivity.this.b(paramCmGameInitParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity
 * JD-Core Version:    0.7.0.1
 */