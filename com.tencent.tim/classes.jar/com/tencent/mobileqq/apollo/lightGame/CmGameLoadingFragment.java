package com.tencent.mobileqq.apollo.lightGame;

import abmc;
import abmg;
import abmm;
import abmt;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anpc;
import aqiw;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.a;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CmGameLoadingFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private a jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingFragment$a;
  private CmGameLoadingView jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView;
  private CmGameStartChecker.StartCheckParam b;
  private boolean bDS;
  private boolean bDT;
  private boolean bDU;
  private auru e = new auru(Looper.getMainLooper(), this);
  private RelativeLayout el;
  private RelativeLayout jh;
  private ImageView mCloseBtn;
  private CmGameStartChecker mCmGameStartChecker;
  private long mCreateTime;
  private boolean mDestroyed;
  private boolean mIsPortrait;
  private int mOrientation;
  
  public void DO(boolean paramBoolean)
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onGameUICreated]");
    this.e.removeMessages(2);
    this.e.sendMessageDelayed(this.e.obtainMessage(2), 600L);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.cDf();
    }
    this.bDU = true;
    cDe();
  }
  
  public void cDe()
  {
    if ((this.bDS) && (this.bDT) && (this.bDU))
    {
      this.e.removeMessages(4);
      this.e.sendMessageDelayed(this.e.obtainMessage(4), 150L);
      this.bDS = false;
      this.bDT = false;
      this.bDU = false;
    }
  }
  
  public void gU(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.cDg();
      this.e.sendMessageDelayed(this.e.obtainMessage(3), paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.onGameFailed(null, -10L);
        continue;
        if (this.jh != null)
        {
          this.jh.setVisibility(4);
          continue;
          paramMessage = super.getActivity();
          if (paramMessage != null)
          {
            paramMessage.finish();
            continue;
            QLog.d("cmgame_process.CmGameLoadingFragment", 1, " restart ApolloGameActivity");
            if (this.b != null) {
              this.b.mStartType = 3;
            }
            ApolloGameUtil.a(getActivity(), this.b);
          }
        }
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onBackEvent]");
    if (this.b != null) {
      abmm.a().i(this.b);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b != null) {
        abmm.a().i(this.b);
      }
      Object localObject = super.getActivity();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
      localObject = abmt.getAppInterface();
      if ((this.b != null) && (localObject != null))
      {
        long l = SystemClock.uptimeMillis() - this.mCreateTime;
        if (l > 0L)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_gameId", String.valueOf(this.b.gameId));
          localHashMap.put("param_isLoading", "1");
          localHashMap.put("param_gameProc", "0");
          anpc.a(((AppInterface)localObject).getApp()).collectPerformance(((AppInterface)localObject).getCurrentAccountUin(), "cmgame_click_to_close", true, l, 0L, localHashMap, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_close, main proc, duration=", Long.valueOf(l), " [gameId=", Integer.valueOf(this.b.gameId), "]" });
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onCreateView]");
    paramBundle = super.getActivity();
    if (paramBundle == null)
    {
      paramLayoutInflater = null;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    this.el = new RelativeLayout(paramBundle);
    this.el.setBackgroundColor(0);
    this.b = ((CmGameStartChecker.StartCheckParam)paramBundle.getIntent().getSerializableExtra("extra_startcheckparam"));
    label106:
    int i;
    if (this.b != null)
    {
      this.mIsPortrait = true;
      if (this.b.viewMode == 1)
      {
        this.mIsPortrait = false;
        paramBundle.setRequestedOrientation(8);
        if (!this.mIsPortrait) {
          break label617;
        }
        i = 1;
        label116:
        this.mOrientation = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView = CmGameLoadingView.a(paramBundle, this.mIsPortrait);
        this.el.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView, new RelativeLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.f(this.b);
        paramViewGroup = abmt.getAppInterface();
        this.mCmGameStartChecker = new CmGameStartChecker(paramViewGroup);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingFragment$a = new a(paramViewGroup);
        abmm.a().a(this, this.b);
        if (paramViewGroup != null)
        {
          if ((!aqiw.isNetSupport(paramBundle)) && (!abmt.c(this.b))) {
            break label623;
          }
          this.mCmGameStartChecker.a(this.b, this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingFragment$a);
          if (!abmt.b(this.b)) {
            abmg.a(paramViewGroup, this.b.gameId, "android.subgame", new abmc(this));
          }
        }
        label273:
        if (this.b.enableMenu)
        {
          this.jh = ((RelativeLayout)paramLayoutInflater.inflate(2131559005, null));
          this.mCloseBtn = ((ImageView)this.jh.findViewById(2131363823));
          this.mCloseBtn.setOnClickListener(this);
          paramLayoutInflater = super.getResources();
          i = (int)paramLayoutInflater.getDimension(2131296521);
          int j = (int)paramLayoutInflater.getDimension(2131296520);
          paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
          paramLayoutInflater.addRule(11);
          paramLayoutInflater.addRule(10);
          paramLayoutInflater.rightMargin = j;
          paramLayoutInflater.topMargin = i;
          this.el.addView(this.jh, paramLayoutInflater);
        }
        this.mCreateTime = SystemClock.uptimeMillis();
        long l = this.mCreateTime - abmt.Oc;
        if ((l > 0L) && (paramViewGroup != null))
        {
          paramLayoutInflater = new HashMap();
          paramLayoutInflater.put("param_gameId", String.valueOf(this.b.gameId));
          paramLayoutInflater.put("param_src", String.valueOf(this.b.src));
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramViewGroup.getCurrentAccountUin(), "cmgame_main_proc_loading_time", true, l, 0L, paramLayoutInflater, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_main_proc_loading_time, duration=", Long.valueOf(l), ", sOpenLoadingTs=", Long.valueOf(abmt.Oc), ", createTime=", Long.valueOf(this.mCreateTime), " [gameId=", Integer.valueOf(this.b.gameId), "]" });
        }
      }
    }
    for (;;)
    {
      paramLayoutInflater = this.el;
      break;
      if (this.b.viewMode == 2)
      {
        this.mIsPortrait = false;
        paramBundle.setRequestedOrientation(0);
        break label106;
      }
      paramBundle.setRequestedOrientation(1);
      break label106;
      label617:
      i = 2;
      break label116;
      label623:
      QLog.w("cmgame_process.CmGameLoadingFragment", 1, "[onCreate] no net");
      this.e.sendEmptyMessageDelayed(1, 1000L);
      abmm.a().a(this.b, -1L, null);
      break label273;
      QLog.e("cmgame_process.CmGameLoadingFragment", 1, "[onCreateView] mStartCheckParam null");
    }
  }
  
  public void onDestroyView()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onDestroyView]");
    super.onDestroyView();
    this.mDestroyed = true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "[onPause]");
    }
    this.bDS = true;
    this.bDT = false;
  }
  
  public void onResume()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onResume]");
    super.onResume();
    this.e.removeMessages(2);
    if (this.jh != null) {
      this.jh.setVisibility(0);
    }
    this.bDT = true;
    cDe();
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "[onStop]");
    }
    this.bDS = false;
  }
  
  class a
    extends CmGameStartChecker.a
  {
    public a(AppInterface paramAppInterface)
    {
      super(true);
    }
    
    public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.b paramb, long paramLong)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this)) {}
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
            QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
            return;
            if ((CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(CmGameLoadingFragment.this).requestCode)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
          return;
          if (paramLong > 0L) {
            break;
          }
          QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
        } while (paramb == null);
        paramb.b(paramStartCheckParam);
        return;
        if ((CmGameLoadingFragment.a(CmGameLoadingFragment.this) != null) && (CmGameLoadingFragment.a(CmGameLoadingFragment.this).statMap != null)) {
          CmGameLoadingFragment.a(CmGameLoadingFragment.this).statMap.put("download_confirm", Long.valueOf(1L));
        }
      } while (CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null);
      CmGameLoadingFragment.a(CmGameLoadingFragment.this).onDownloadConfirm(paramStartCheckParam, paramb, paramLong);
    }
    
    public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      super.onDownloadGameResDown(paramStartCheckParam);
      if ((CmGameLoadingFragment.a(CmGameLoadingFragment.this) != null) && (CmGameLoadingFragment.a(CmGameLoadingFragment.this).statMap != null)) {
        CmGameLoadingFragment.a(CmGameLoadingFragment.this).statMap.put("download_game_res", Long.valueOf(1L));
      }
    }
    
    public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onDownloadGameResFail]");
      onGameFailed(paramStartCheckParam, -12L);
    }
    
    public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this) != null) {
        CmGameLoadingFragment.a(CmGameLoadingFragment.this).onDownloadGameResProgress(paramStartCheckParam, paramInt);
      }
    }
    
    public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this)) {}
      do
      {
        return;
        if (paramStartCheckParam == null)
        {
          QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onCheckGameFinish mStartCheckParam == null");
          return;
        }
        if (paramLong != 0L)
        {
          onGameFailed(paramStartCheckParam, paramLong);
          return;
        }
      } while (CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null);
      CmGameLoadingFragment.a(CmGameLoadingFragment.this).a(paramLong, paramStartCheckParam);
    }
    
    public void onGameCheckRetry(int paramInt)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this)) {}
      while (CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null) {
        return;
      }
      CmGameLoadingFragment.a(CmGameLoadingFragment.this).a(paramInt, CmGameLoadingFragment.a(CmGameLoadingFragment.this));
    }
    
    public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
    {
      abmm.a().a(paramStartCheckParam, paramLong, null);
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this) != null) {
        CmGameLoadingFragment.a(CmGameLoadingFragment.this).onGameFailed(paramStartCheckParam, paramLong);
      }
    }
    
    public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        if (paramStartCheckParam != null) {
          break label38;
        }
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "showGameLifeTip mStartCheckParam is null");
      }
      for (;;)
      {
        onGameFailed(paramStartCheckParam, -1L);
        return;
        label38:
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
      }
    }
    
    public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      super.onGetGameData(paramStartCheckParam);
      if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
        QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onGetGameData startCheckParam == null or game is null");
      }
      do
      {
        return;
        CmGameLoadingFragment.a(CmGameLoadingFragment.this).game = paramStartCheckParam.game;
      } while (CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null);
      CmGameLoadingFragment.a(CmGameLoadingFragment.this).g(paramStartCheckParam);
    }
    
    public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (CmGameLoadingFragment.a(CmGameLoadingFragment.this)) {}
      do
      {
        do
        {
          do
          {
            return;
            if ((paramCmGameInitParams != null) && (CmGameLoadingFragment.a(CmGameLoadingFragment.this) != null))
            {
              paramCmGameInitParams.commFlag = CmGameLoadingFragment.a(CmGameLoadingFragment.this).commFlag;
              paramCmGameInitParams.mSSORule = CmGameLoadingFragment.a(CmGameLoadingFragment.this).mSSORule;
              if (CmGameLoadingFragment.a(CmGameLoadingFragment.this).game != null) {
                paramCmGameInitParams.appId = CmGameLoadingFragment.a(CmGameLoadingFragment.this).game.appId;
              }
              paramCmGameInitParams.rpUrl = CmGameLoadingFragment.a(CmGameLoadingFragment.this).rpUrl;
              paramCmGameInitParams.rpIconUrl = CmGameLoadingFragment.a(CmGameLoadingFragment.this).rpIconUrl;
            }
            if (paramCmGameInitParams != null) {
              paramCmGameInitParams.accessTokenRet = 0;
            }
            abmm.a().a(paramStartCheckParam, paramLong, paramCmGameInitParams);
            QLog.d("cmgame_process.CmGameLoadingFragment", 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
            if (paramStartCheckParam != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish mStartCheckParam == null");
          return;
          if ((CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(CmGameLoadingFragment.this).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong != 0L)
        {
          onGameFailed(paramStartCheckParam, paramLong);
          return;
        }
      } while (CmGameLoadingFragment.a(CmGameLoadingFragment.this) == null);
      CmGameLoadingFragment.a(CmGameLoadingFragment.this).a(paramStartCheckParam, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment
 * JD-Core Version:    0.7.0.1
 */