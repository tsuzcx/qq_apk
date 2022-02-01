package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import aqge;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import iiv;
import ivy;
import iya;
import java.lang.ref.WeakReference;
import jll;

public class SmallScreenVideoControlUI
  implements Animation.AnimationListener
{
  String QK = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  protected boolean VB;
  protected boolean VC;
  protected VideoController a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  TimmerRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
  protected iya a;
  protected int auE = 0;
  View[] i = new View[2];
  protected VideoAppInterface mApp;
  protected WeakReference<Context> mContext;
  protected Resources mRes;
  String mTime = null;
  protected TextView mTitleView;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, iya paramiya)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.mApp = paramVideoAppInterface;
    this.mContext = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.mRes = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.mRes == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramVideoAppInterface = paramSmallScreenService.getString(2131721703) + " 0x03";
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
      paramVideoAppInterface = this.mRes.getString(2131721703) + " 0x04";
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_Iya = paramiya;
  }
  
  public void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void V(String paramString, boolean paramBoolean) {}
  
  public void aR(String paramString1, String paramString2) {}
  
  public void amU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
  }
  
  public void amV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
  }
  
  public void amZ() {}
  
  public void ana() {}
  
  protected void ari()
  {
    if (this.i != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setRepeatMode(2);
      localAlphaAnimation.setRepeatCount(6);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(this);
      int j = 0;
      while (j < this.i.length)
      {
        if (this.i[j] != null)
        {
          this.i[j].setVisibility(0);
          this.i[j].startAnimation(localAlphaAnimation);
        }
        j += 1;
      }
    }
  }
  
  public int cv(int paramInt)
  {
    DoubleVideoCtrlUI.b(this.mApp, paramInt);
    return 0;
  }
  
  public void hF(boolean paramBoolean) {}
  
  protected void initUI()
  {
    SmallScreenRelativeLayout localSmallScreenRelativeLayout1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
    SmallScreenRelativeLayout localSmallScreenRelativeLayout2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(0);
    this.mTitleView = ((TextView)localSmallScreenRelativeLayout2.findViewById(2131374248));
    this.i[0] = localSmallScreenRelativeLayout1.findViewById(2131373969);
    this.i[1] = localSmallScreenRelativeLayout2.findViewById(2131373969);
  }
  
  public void je(boolean paramBoolean)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
    this.auE = 1;
    initUI();
  }
  
  protected void lM(int paramInt) {}
  
  public void lP(int paramInt)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onClose type = " + paramInt);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().tf()) || (this.jdField_a_of_type_ComTencentAvVideoController.OD))
    {
      lQ(paramInt);
      stopTimer();
      return;
    }
    if ((paramInt == 25) || (paramInt == 56)) {
      lQ(paramInt);
    }
    for (;;)
    {
      ari();
      return;
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.so()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().tg()))
      {
        lQ(65);
        aqge.a(2131230754, 1, new ivy(this));
      }
    }
  }
  
  void lQ(int paramInt)
  {
    lM(VideoControlUI.a(this.jdField_a_of_type_ComTencentAvVideoController.b(), paramInt));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.i != null)
    {
      int j = 0;
      while (j < this.i.length)
      {
        if (this.i[j] != null) {
          this.i[j].setVisibility(8);
        }
        j += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onConnected() {}
  
  public void onDestroy(long paramLong)
  {
    QLog.w("SmallScreenVideoControlUI", 1, "onDestroy, mUIState[" + this.auE + "->" + 6 + "], seq[" + paramLong + "]");
    this.auE = 6;
    stopTimer();
    if (this.mApp != null)
    {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
      this.mApp = null;
    }
    this.mRes = null;
    this.mContext = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.i = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_Iya = null;
    this.mTitleView = null;
  }
  
  public void onPause()
  {
    this.auE = 4;
  }
  
  public void onResume()
  {
    this.auE = 3;
  }
  
  public void onStart()
  {
    this.auE = 2;
  }
  
  public void onStop()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
    this.auE = 5;
    stopTimer();
  }
  
  @TargetApi(11)
  public void setRotation(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().PY) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PZ)) {}
  }
  
  public void startTimer()
  {
    if (this.VB) {}
    while (((this.auE < 2) || (this.auE > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
    }
    this.VB = true;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = new TimmerRunnable();
    }
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable, 0L);
  }
  
  public void stopTimer()
  {
    if (!this.VB) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
      }
      this.VB = false;
    } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable == null);
    if (this.mApp != null) {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
  }
  
  class TimmerRunnable
    implements Runnable
  {
    TimmerRunnable() {}
    
    public void run()
    {
      if ((SmallScreenVideoControlUI.this.a != null) && (SmallScreenVideoControlUI.this.VB))
      {
        long l = SmallScreenVideoControlUI.this.a.bt();
        if ((SmallScreenVideoControlUI.this.mTime == null) || (l != 0L))
        {
          SmallScreenVideoControlUI.this.mTime = jll.formatTime(l);
          if ((SmallScreenVideoControlUI.this.mTitleView != null) && (!SmallScreenVideoControlUI.this.VC))
          {
            SmallScreenVideoControlUI.this.mTitleView.setContentDescription(jll.dD(SmallScreenVideoControlUI.this.mTime));
            SmallScreenVideoControlUI.this.mTitleView.setText(SmallScreenVideoControlUI.this.mTime);
          }
        }
        SmallScreenVideoControlUI.this.mApp.getHandler().postDelayed(this, 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */