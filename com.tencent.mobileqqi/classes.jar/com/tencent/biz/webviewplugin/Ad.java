package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView;
import bog;
import boh;
import boi;
import boj;
import bok;
import bol;
import bom;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mp.SSOHttp.GdtAdRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class Ad
  implements View.OnClickListener
{
  static final String jdField_a_of_type_JavaLangString = "http://web.p.qq.com/qqmpmobile/gdt/index.html?_bid=156";
  static final String jdField_b_of_type_JavaLangString = "qqbrowser ad";
  public int a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  public View a;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public CustomWebView a;
  private Ad.ScrollListener jdField_a_of_type_ComTencentBizWebviewpluginAd$ScrollListener;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  protected WebViewPluginEngine a;
  Runnable jdField_a_of_type_JavaLangRunnable = new bol(this);
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public boolean a;
  int jdField_b_of_type_Int;
  TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView b;
  public CustomWebView b;
  public Runnable b;
  public boolean b;
  int jdField_c_of_type_Int;
  TranslateAnimation jdField_c_of_type_AndroidViewAnimationTranslateAnimation;
  String jdField_c_of_type_JavaLangString = null;
  public boolean c;
  int jdField_d_of_type_Int = Build.VERSION.SDK_INT;
  TranslateAnimation jdField_d_of_type_AndroidViewAnimationTranslateAnimation;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  public int e;
  private String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = true;
  public int f;
  
  public Ad(QQBrowserActivity paramQQBrowserActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangRunnable = new bom(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView = paramQQBrowserActivity.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = paramQQBrowserActivity.getResources().getDisplayMetrics();
    j();
  }
  
  private Bitmap a(WebView paramWebView)
  {
    try
    {
      paramWebView = paramWebView.getDrawingCache();
      Bitmap localBitmap = Bitmap.createBitmap(paramWebView);
      paramWebView.recycle();
      return localBitmap;
    }
    catch (Exception paramWebView) {}
    return null;
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqbrowser ad", 2, "contentHeight:" + this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getContentHeight() + ",scale:" + this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getScale() + ",height:" + this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getHeight() + ",scrollY:" + this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getView().getScrollY());
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getContentHeight() * this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getScale() - (this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getHeight() + this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getView().getScrollY()) < 1.0F;
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131231184);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((CustomWebView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131231185));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131231186));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131231183));
    if (this.jdField_d_of_type_Int >= 11) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setLayerType(1, null);
    }
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    String str = localWebSettings.getUserAgentString();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localWebSettings.setUserAgentString((String)localObject + " " + QZoneHelper.a() + " " + "QQ/" + "6.0.2" + "." + "6602");
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(false);
    if (this.jdField_d_of_type_Int >= 8) {
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
    }
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ((AbsoluteLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).y = Math.max(this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels);
    this.jdField_e_of_type_Int = ((int)(16.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
    this.f = ((int)(17.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density) + 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizWebviewpluginAd$ScrollListener = new Ad.ScrollListener(this);
    localObject = new ArrayList();
    ((List)localObject).add(new AdWebviewPlugin());
    ((List)localObject).add(new OfflinePlugin());
    ((List)localObject).add(new SensorAPIJavaScript());
    ((List)localObject).add(new OpenCenterPlugin());
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = new WebViewPluginEngine(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, (List)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient(new CustomWebViewClient(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine));
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent().getStringExtra("puin");
    if (this.jdField_c_of_type_JavaLangString != null) {}
    for (this.jdField_e_of_type_JavaLangString = ("http://web.p.qq.com/qqmpmobile/gdt/index.html?_bid=156&puin=" + this.jdField_c_of_type_JavaLangString);; this.jdField_e_of_type_JavaLangString = "http://web.p.qq.com/qqmpmobile/gdt/index.html?_bid=156")
    {
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(this.jdField_a_of_type_ComTencentBizWebviewpluginAd$ScrollListener);
      return;
    }
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Int, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new boh(this));
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new boi(this));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_Int);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_Int, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new boj(this));
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new bok(this));
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    g();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearView();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.destroy();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqbrowser ad", 2, "onDetachedFromWindow exception : " + String.valueOf(localException));
        }
      }
    }
  }
  
  public void d()
  {
    h();
    this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
  }
  
  public void e()
  {
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("qqbrowser ad", 2, "get ad");
      }
      this.jdField_e_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d() == null);
    this.jdField_d_of_type_Boolean = false;
    SSOHttp.GdtAdRequest localGdtAdRequest = new SSOHttp.GdtAdRequest();
    if (this.jdField_a_of_type_MqqAppNewIntent == null)
    {
      this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), ProtoServlet.class);
      this.jdField_a_of_type_MqqObserverBusinessObserver = new bog(this);
      this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "QQMobileGdtSvr.GetAd");
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    localGdtAdRequest.url.set(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d());
    if (this.jdField_c_of_type_JavaLangString != null) {
      localGdtAdRequest.publicAccount.set(this.jdField_c_of_type_JavaLangString);
    }
    localGdtAdRequest.params.set("{\"ext\":{\"wapos\":\"ADR\"}}");
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGdtAdRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getLayoutParams();
      localLayoutParams.y = 0;
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setLayoutParams(localLayoutParams);
      localLayoutParams = (AbsoluteLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.y = Math.max(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels);
      localLayoutParams.height = this.f;
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    Bitmap localBitmap = a(this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView);
    if (localBitmap != null)
    {
      ((AbsoluteLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getLayoutParams()).y = 0;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation);
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void h()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      i = (int)(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getContentHeight() * this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getScale() - 0.1D) + 1;
    } while (i < 2);
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_Int = (this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getHeight() - this.jdField_a_of_type_Int - this.jdField_e_of_type_Int);
    k();
    this.jdField_a_of_type_Boolean = true;
    Object localObject = (AbsoluteLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((AbsoluteLayout.LayoutParams)localObject).y = this.jdField_b_of_type_Int;
    ((AbsoluteLayout.LayoutParams)localObject).height = (this.jdField_a_of_type_Int + this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a(this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView);
    if (localObject != null)
    {
      ((AbsoluteLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getLayoutParams()).y = (-this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  public void i()
  {
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.jdField_e_of_type_JavaLangString + "&url=" + URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d(), "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.jdField_e_of_type_JavaLangString + "&url=" + URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d()));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      if (this.jdField_a_of_type_Boolean) {
        g();
      }
    }
    else {
      return;
    }
    h();
    this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Ad
 * JD-Core Version:    0.7.0.1
 */