package com.tencent.mobileqq.apollo.game;

import ablo;
import abls;
import ablt;
import abmt;
import abos;
import abxi;
import acfp;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anre;
import aqgz;
import aqha;
import aqju;
import aqmf;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.a;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import wja;

public class ApolloWebGameActivity
  extends BaseActivity
  implements Handler.Callback, Observer
{
  private long ID;
  private long NS;
  private abos jdField_a_of_type_Abos;
  private a jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$a;
  private aqju ae;
  private CmGameStartChecker.StartCheckParam b;
  private int cpN;
  private auru e = new auru(Looper.getMainLooper(), this);
  private RelativeLayout el;
  private CmGameStartChecker mCmGameStartChecker;
  private boolean mDestroyed;
  private ImageView mLoadingView;
  
  private void showErrorTips(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(this, paramString, 0).show();
    }
    super.finish();
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    this.el.addView(paramApolloSurfaceView, localLayoutParams);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "setGameView ApolloSurfaceView:" + paramApolloSurfaceView);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      AbsStructMsg localAbsStructMsg = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      aqmf.a(this.app, str, i, localAbsStructMsg, null);
      VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.gi(i), 0, new String[] { Integer.toString(j) });
    }
    if ((paramInt2 == -1) && (paramIntent != null) && ((paramInt1 == 14006) || (paramInt1 == 14005)) && (this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.b() != null)) {
      this.jdField_a_of_type_Abos.b().runRenderTask(new ApolloWebGameActivity.3(this, paramInt1, paramInt2, paramIntent));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      long l = aqgz.i(true);
      if ((this.ID != l) && (this.ID != this.NS))
      {
        QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l) });
        this.e.sendEmptyMessageDelayed(18, 500L);
      }
      this.ID = l;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ApolloGameStateMachine.a().reset();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.el = new RelativeLayout(this);
    this.mLoadingView = new ImageView(this);
    this.mLoadingView.setImageResource(2130839651);
    paramBundle = new RelativeLayout.LayoutParams(wja.dp2px(25.0F, super.getResources()), wja.dp2px(25.0F, super.getResources()));
    paramBundle.addRule(13, -1);
    this.el.addView(this.mLoadingView, paramBundle);
    setContentView(this.el);
    paramBundle = (CmGameStartChecker.StartCheckParam)super.getIntent().getSerializableExtra("extra_startcheckparam");
    if (paramBundle == null)
    {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] no start param");
      finish();
      showErrorTips(acfp.m(2131702727));
      return false;
    }
    if (paramBundle.game == null) {
      QLog.i("cmgame_process.ApolloWebGameActivity", 1, "[doOnCreate] game is new, gameId:" + this.b.gameId);
    }
    paramBundle.requestCode = System.currentTimeMillis();
    this.b = paramBundle;
    int i = ApolloGameActivity.crx + 1;
    ApolloGameActivity.crx = i;
    this.cpN = i;
    this.jdField_a_of_type_Abos = abmt.a(paramBundle.gameId, this.cpN);
    if (this.jdField_a_of_type_Abos != null) {
      this.jdField_a_of_type_Abos.l(paramBundle);
    }
    paramBundle = abmt.getAppInterface();
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$a = new a(paramBundle);
    this.mCmGameStartChecker = new CmGameStartChecker(paramBundle);
    this.mCmGameStartChecker.a(this.b, this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity$a);
    abmt.aB(1, this.b.gameId, this.cpN);
    QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnCreate");
    ablo.d(this.b);
    this.ID = aqgz.i(true);
    this.NS = aqgz.hL();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "doOnCreate mLastScreenWidth:", Long.valueOf(this.ID), ",mLastScrrenHeight:", Long.valueOf(this.NS) });
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.ae != null) && (this.ae.isShowing())) {
        this.ae.dismiss();
      }
      this.e.removeCallbacksAndMessages(null);
      this.mDestroyed = true;
      ApolloGameStateMachine.a().deleteObserver(this);
      if (this.jdField_a_of_type_Abos != null)
      {
        this.jdField_a_of_type_Abos.doOnDestroy();
        abmt.b(this.jdField_a_of_type_Abos.getGameId(), this.cpN);
      }
      if (this.b != null) {
        abmt.aB(5, this.b.gameId, this.cpN);
      }
      ablo.e(this.b);
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "doOnDestroy");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("cmgame_process.ApolloWebGameActivity", 1, localException, new Object[0]);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.b != null) {
      abmt.aB(3, this.b.gameId, this.cpN);
    }
    if (this.jdField_a_of_type_Abos != null) {
      this.jdField_a_of_type_Abos.doOnPause();
    }
    ablo.e(this.b);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.b != null) {
      abmt.aB(2, this.b.gameId, this.cpN);
    }
    if (this.jdField_a_of_type_Abos != null) {
      this.jdField_a_of_type_Abos.doOnResume();
    }
    ablo.d(this.b);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 17: 
      localObject = (String)paramMessage.obj;
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = acfp.m(2131702736);
      }
      showErrorTips(paramMessage);
      return false;
    case 15: 
      this.mLoadingView.setVisibility(8);
      return false;
    case 16: 
      this.mLoadingView.setVisibility(8);
      if (this.ae == null)
      {
        paramMessage = new abls(this);
        localObject = new ablt(this);
      }
      try
      {
        this.ae = aqha.a(this, 0, acfp.m(2131702733), acfp.m(2131702734), acfp.m(2131702735), acfp.m(2131702731), paramMessage, (DialogInterface.OnClickListener)localObject);
        if (this.ae != null)
        {
          this.ae.show();
          return false;
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
          QLog.e("cmgame_process.ApolloWebGameActivity", 2, paramMessage.getMessage());
        }
        showErrorTips(acfp.m(2131702732));
        paramMessage = new Intent(this, QQBrowserActivity.class);
        paramMessage.putExtra("url", abxi.bjl);
        startActivity(paramMessage);
        c(this);
        return false;
      }
    }
    d(this);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bundle))) {}
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
      if (ApolloWebGameActivity.a(ApolloWebGameActivity.this)) {}
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
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloWebGameActivity.a(ApolloWebGameActivity.this) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(ApolloWebGameActivity.this).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
      } while (paramb == null);
      paramb.b(paramStartCheckParam);
    }
    
    public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      QLog.d("cmgame_process.ApolloWebGameActivity", 1, "[onDownloadGameResFail]");
      paramStartCheckParam = ApolloWebGameActivity.a(ApolloWebGameActivity.this).obtainMessage(17);
      paramStartCheckParam.obj = acfp.m(2131702728);
      ApolloWebGameActivity.a(ApolloWebGameActivity.this).sendMessage(paramStartCheckParam);
    }
    
    public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (ApolloWebGameActivity.a(ApolloWebGameActivity.this)) {}
      do
      {
        do
        {
          do
          {
            return;
            QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onGameCheckFinish] resultCode=", Long.valueOf(paramLong) });
            if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloWebGameActivity.a(ApolloWebGameActivity.this) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(ApolloWebGameActivity.this).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
      } while (paramLong == 0L);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish resultCode != 0");
      }
      paramCmGameInitParams = ApolloWebGameActivity.a(ApolloWebGameActivity.this).obtainMessage(17);
      paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
      ApolloWebGameActivity.a(ApolloWebGameActivity.this).sendMessage(paramCmGameInitParams);
    }
    
    public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      if (ApolloWebGameActivity.a(ApolloWebGameActivity.this)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        if (paramStartCheckParam != null) {
          break label39;
        }
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "showGameLifeTip mStartCheckParam is null");
      }
      for (;;)
      {
        onGameCheckFinish(-1L, paramStartCheckParam, null);
        return;
        label39:
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
      }
    }
    
    public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      super.onGetGameData(paramStartCheckParam);
      if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
        QLog.e("cmgame_process.ApolloWebGameActivity", 1, "onGetGameData startCheckParam == null or game is null");
      }
      do
      {
        return;
        ApolloWebGameActivity.a(ApolloWebGameActivity.this).game = paramStartCheckParam.game;
      } while (ApolloWebGameActivity.a(ApolloWebGameActivity.this) == null);
      ApolloWebGameActivity.a(ApolloWebGameActivity.this).l(ApolloWebGameActivity.a(ApolloWebGameActivity.this));
    }
    
    public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
    {
      if (ApolloWebGameActivity.a(ApolloWebGameActivity.this)) {}
      do
      {
        do
        {
          do
          {
            return;
            QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
            if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloWebGameActivity.a(ApolloWebGameActivity.this) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(ApolloWebGameActivity.this).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong != 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish resultCode != 0");
          }
          paramCmGameInitParams = ApolloWebGameActivity.a(ApolloWebGameActivity.this).obtainMessage(17);
          paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
          ApolloWebGameActivity.a(ApolloWebGameActivity.this).sendMessage(paramCmGameInitParams);
          return;
        }
        ApolloWebGameActivity.a(ApolloWebGameActivity.this).startCallEngine = System.currentTimeMillis();
        ApolloGameStateMachine.a().n(1, "ApolloWebGameActivity.openGame");
        ApolloGameStateMachine.a().n(2, "ApolloWebGameActivity.openGame");
      } while (ApolloWebGameActivity.a(ApolloWebGameActivity.this) == null);
      ApolloWebGameActivity.a(ApolloWebGameActivity.this).a(ApolloWebGameActivity.this, paramCmGameInitParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity
 * JD-Core Version:    0.7.0.1
 */