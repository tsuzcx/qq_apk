package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aniq;
import ankt;
import arcd;
import auru;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import rav;
import raw;
import rfl;
import rfl.a;
import rfm;

public class DanceMachineQQBrowserActivity
  extends QQTranslucentBrowserActivity
{
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "startDialog :" + System.currentTimeMillis());
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramInt4 == 0)
    {
      localIntent.setClass(paramActivity, DanceMachineQQBrowserActivity.class);
      if (paramInt4 != 0) {
        break label231;
      }
      localIntent.putExtra("isFullScreen", true);
      localIntent.putExtra("dance_machine_score", new Integer(paramInt5).toString());
      paramString = String.format("https://ti.qq.com/dance-rank/popup-738.html?_wv=536870912&_nav_alpha=true&_fv=0&new_record=%s&score=%s", new Object[] { paramInt2 + "", paramInt5 + "" });
      label154:
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "url : " + paramString);
      }
      localIntent.putExtra("url", paramString);
      if (!(paramActivity instanceof QQStoryBaseActivity)) {
        break label289;
      }
      ((QQStoryBaseActivity)paramActivity).f(localIntent, 9102040);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(0, 0);
      return;
      localIntent.setClass(paramActivity, QQBrowserActivity.class);
      break;
      label231:
      if ((paramInt1 == 3000) || (paramInt1 == 1))
      {
        if (paramInt1 == 3000) {}
        for (paramIntent = "tlz";; paramIntent = "qun")
        {
          paramString = String.format("https://ti.qq.com/dance-rank/index.html?_wv=2&type=%s&num=%s", new Object[] { paramIntent, paramString });
          break;
        }
      }
      paramString = "https://ti.qq.com/dance-rank/index.html?_wv=536870912&_nav_alpha=true";
      break label154;
      label289:
      paramActivity.startActivityForResult(localIntent, 9102040);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.s = DanceMachineQQBrowserFragment.class;
    super.doOnCreate(paramBundle);
    return true;
  }
  
  public void doOnResume()
  {
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new rav(this));
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }
  
  public static class DanceMachineQQBrowserFragment
    extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
    implements Handler.Callback, rfl.a
  {
    private String Qr;
    private rfm a;
    auru d = new auru(this);
    private String mAudioPath;
    private String mVideoPath;
    
    private void q(RelativeLayout paramRelativeLayout)
    {
      FadedButton localFadedButton = new FadedButton(getActivity());
      localFadedButton.setBackgroundResource(2130846841);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ankt.dip2px(40.0F), ankt.dip2px(40.0F));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.bottomMargin = ankt.dip2px(35.0F);
      localFadedButton.setLayoutParams(localLayoutParams);
      localFadedButton.setOnClickListener(new raw(this));
      paramRelativeLayout.addView(localFadedButton);
    }
    
    public void brY()
    {
      this.jdField_a_of_type_Rfm.o("share_VIDEO", null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "onShareVideoClick");
      }
    }
    
    public void cA(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onBattleClick shareWebUrl : " + paramString1, " rank : " + paramString2 });
      }
      this.jdField_a_of_type_Rfm.o("share_PK", paramString1, paramString2, this.Qr);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 12)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachineQQBrowserActivity", 2, "Page TimeOut");
        }
        if (getActivity() != null) {
          getActivity().finish();
        }
      }
      return false;
    }
    
    @TargetApi(11)
    public int o(Bundle paramBundle)
    {
      int i = super.o(paramBundle);
      if (super.getWebView() != null) {
        this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      }
      return i;
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Rfm.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      this.d.sendEmptyMessageDelayed(12, 30000L);
      paramBundle = getIntent().getExtras();
      this.mAudioPath = paramBundle.getString("KEY_AUDIO_FILE_PATH");
      this.mVideoPath = paramBundle.getString("KEY_VIDEO_FILE_PATH");
      this.Qr = paramBundle.getString("dance_machine_score", "0");
      this.jdField_a_of_type_Rfm = new rfm();
      this.jdField_a_of_type_Rfm.a(getActivity(), this.mAudioPath, this.mVideoPath, this.mApp);
      aniq.ckG = this.intent.getIntExtra("KEY_AUDIO_CHANNEL", aniq.ckG);
      aniq.dHj = this.intent.getIntExtra("KEY_BITRATE", aniq.dHj);
      aniq.mAudioFormat = this.intent.getIntExtra("KEY_AUDIO_FORMAT", aniq.mAudioFormat);
      aniq.bth = this.intent.getIntExtra("KEY_SAMPLE_RATE", aniq.bth);
      rfl.a().a(this);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "fragment onCreate : " + System.currentTimeMillis());
      }
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      this.jdField_a_of_type_Rfm.doOnDestroy();
      rfl.a().btK();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "onPageFinished");
      }
      this.j.setVisibility(0);
      q(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      this.d.removeMessages(12);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "onReceivedError ,   errorCode : " + paramInt + " errorDetail : " + paramString1 + " errorURL : " + paramString2);
      }
      this.d.removeMessages(12);
      getActivity().finish();
    }
    
    public int p(Bundle paramBundle)
    {
      int i = super.p(paramBundle);
      getWebView().setVisibility(8);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */