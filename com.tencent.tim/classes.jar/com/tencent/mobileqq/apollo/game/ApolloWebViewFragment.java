package com.tencent.mobileqq.apollo.game;

import able;
import ablu;
import abmt;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import anot;
import aqzl;
import arbz;
import arcd;
import auwa;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import jqo;

public class ApolloWebViewFragment
  extends ApolloFragment
{
  View.OnLayoutChangeListener a;
  private boolean bDH;
  private int cpO;
  private int cpP;
  public Runnable fy = new ApolloWebViewFragment.2(this);
  private Rect mRect = new Rect();
  
  public ApolloWebViewFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new ablu(this);
  }
  
  private boolean Yx()
  {
    try
    {
      Uri localUri = Uri.parse(getCurrentUrl());
      if (localUri.isHierarchical())
      {
        boolean bool = TextUtils.isEmpty(localUri.getQueryParameter("_fv"));
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean Yy()
  {
    try
    {
      Object localObject = Uri.parse(getCurrentUrl());
      if (((Uri)localObject).isHierarchical())
      {
        String str = ((Uri)localObject).getQueryParameter("_wv");
        localObject = ((Uri)localObject).getQueryParameter("_wwv");
        if (TextUtils.isEmpty(str))
        {
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private void cCS()
  {
    if (auwa.hasNavBar(getHostActivity()))
    {
      getHostActivity().findViewById(16908290).addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
      this.bDH = true;
    }
  }
  
  public void BW(String paramString)
  {
    jqo.le("Web_readyToLoadUrl");
    if ((this.j == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    aBA();
    if (Build.VERSION.SDK_INT < 18) {
      this.j.clearView();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Arbz.cXQ) && (this.jdField_a_of_type_Arbz.auw > 0L))
      {
        anot.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Arbz.auw) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Arbz.flag);
        this.jdField_a_of_type_Arbz.auw = 0L;
      }
      this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl = System.currentTimeMillis();
      long l = this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl;
      l = this.jdField_a_of_type_Arbz.mClickTime;
      this.mUrl = paramString;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.j.loadUrl(this.mUrl);
      }
      jqo.lf("Web_readyToLoadUrl");
      this.jdField_a_of_type_Arbz.a(this.j, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      this.j.loadUrl("about:blank");
    }
  }
  
  public void bU(Bundle paramBundle)
  {
    super.bU(paramBundle);
    if (this.j != null)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        paramBundle.putExtra("Director", new WebGameFakeView.Director());
      }
      if (Build.VERSION.SDK_INT < 18) {
        this.j.clearView();
      }
    }
    else
    {
      return;
    }
    this.j.loadUrl("about:blank");
  }
  
  public void bV(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onShow] ");
    }
    String str1;
    if (paramBundle != null)
    {
      paramBundle.getInt("id");
      str1 = paramBundle.getString("url");
      String str2 = getCurrentUrl();
      abmt.x(new Object[] { "[launchWebGame], success load url:", str1 });
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1))) {
        break label81;
      }
      BW(str1);
    }
    for (;;)
    {
      super.bV(paramBundle);
      return;
      label81:
      if (this.j != null) {
        this.j.loadUrl(str1);
      }
    }
  }
  
  public void bW(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onForward] ");
    }
    if (paramBundle != null)
    {
      this.cpD = paramBundle.getInt("id");
      ThreadManager.post(new ApolloWebViewFragment.3(this, paramBundle.getString("url")), 8, null, false);
    }
    super.bW(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bDH) {
      getHostActivity().findViewById(16908290).removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str = paramWebView.getTitle();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = getIntent().getSerializableExtra("Director");
      if ((localObject != null) && ((localObject instanceof WebGameFakeView.Director)))
      {
        localObject = (WebGameFakeView.Director)localObject;
        if (!str.equals(((WebGameFakeView.Director)localObject).title))
        {
          ((WebGameFakeView.Director)localObject).title = str;
          able.a().cCG();
        }
      }
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.j != null) {}
    try
    {
      this.j.requestFocus();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
  }
  
  public int s(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_ui_frame");
    if (this.jdField_a_of_type_Arcd != null) {
      this.jdField_a_of_type_Arcd.cYk = true;
    }
    cCS();
    showPreview();
    this.aNf = 128;
    jqo.lf("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public boolean showPreview()
  {
    boolean bool = Yy();
    if (!bool)
    {
      this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen = true;
      this.jdField_a_of_type_Arcd.zP = false;
      this.jdField_a_of_type_Arcd.zQ = false;
    }
    if (!Yx()) {
      this.jdField_a_of_type_Arcd$a.Dr = 0L;
    }
    super.showPreview();
    if (!bool) {
      this.jdField_a_of_type_Aqzl.bC(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */