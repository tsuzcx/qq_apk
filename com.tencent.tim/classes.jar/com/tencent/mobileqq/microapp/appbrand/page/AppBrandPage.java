package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.p;
import com.tencent.mobileqq.microapp.apkg.s;
import com.tencent.mobileqq.microapp.apkg.t;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.appbrand.ui.SwipeBackLayout.a;
import com.tencent.mobileqq.microapp.ui.NavigationBar;
import com.tencent.mobileqq.microapp.ui.NavigationBar.Listener;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements PageWebview.PageWebViewListener, SwipeBackLayout.a, NavigationBar.Listener
{
  public static final String TAG = "AppBrandPage";
  private FrameLayout centerLayout;
  public FrameLayout fullScreenLayout = new FrameLayout(getContext());
  boolean isInitReady;
  private String mUrl;
  private NavigationBar navBar;
  private LinearLayout rootView;
  private TabBarView tabView;
  private g toastView;
  private Map webViewMap;
  
  public AppBrandPage(Context paramContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(paramContext, paramAppBrandPageContainer);
    paramAppBrandPageContainer.addView(this.fullScreenLayout, new FrameLayout.LayoutParams(-1, -1));
    paramAppBrandPageContainer.fullScreenLayout = this.fullScreenLayout;
    this.webViewMap = new HashMap();
  }
  
  public void cleanup()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).destroy();
      localIterator.remove();
    }
    removeAllViews();
    this.rootView = null;
    this.mUrl = null;
    this.isInitReady = false;
    super.cleanup();
  }
  
  public View createContentView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 4, "createContentView apkgInfo=" + this.apkgInfo);
    }
    LinearLayout localLinearLayout;
    if (this.rootView == null)
    {
      localLinearLayout = new LinearLayout(getContext());
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      this.centerLayout = new FrameLayout(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.weight = 1.0F;
      this.centerLayout.setLayoutParams(localLayoutParams);
      this.navBar = new NavigationBar(this.appBrandPageContainer.appBrandRuntime, getContext());
      this.navBar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      if (this.apkgInfo.b.d == null) {
        break label286;
      }
      this.tabView = new TabBarView(getContext());
      this.tabView.a(this.apkgInfo.b.d);
      this.tabView.a(this.appBrandPageContainer);
      if (!"top".equals(this.apkgInfo.b.d.e)) {
        break label259;
      }
      localLinearLayout.addView(this.navBar);
      localLinearLayout.addView(this.tabView);
      localLinearLayout.addView(this.centerLayout);
    }
    for (;;)
    {
      this.rootView = localLinearLayout;
      return this.rootView;
      label259:
      localLinearLayout.addView(this.navBar);
      localLinearLayout.addView(this.centerLayout);
      localLinearLayout.addView(this.tabView);
      continue;
      label286:
      localLinearLayout.addView(this.navBar);
      localLinearLayout.addView(this.centerLayout);
    }
  }
  
  public FrameLayout getCenterLayout()
  {
    return this.centerLayout;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    if (!TextUtils.isEmpty(this.mUrl)) {
      return getWebView(this.mUrl);
    }
    return null;
  }
  
  public WebviewContainer getCurrentWebviewContainer()
  {
    return (WebviewContainer)this.webViewMap.get(this.mUrl);
  }
  
  public NavigationBar getNavBar()
  {
    return this.navBar;
  }
  
  public TabBarView getTabBar()
  {
    return this.tabView;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public PageWebview getWebView(int paramInt)
  {
    Iterator localIterator = this.webViewMap.values().iterator();
    while (localIterator.hasNext())
    {
      PageWebview localPageWebview = ((WebviewContainer)localIterator.next()).getPageWebview();
      if ((localPageWebview != null) && (localPageWebview.pageWebviewId == paramInt)) {
        return localPageWebview;
      }
    }
    return null;
  }
  
  public PageWebview getWebView(String paramString)
  {
    paramString = (WebviewContainer)this.webViewMap.get(paramString);
    if (paramString != null) {
      return paramString.getPageWebview();
    }
    return null;
  }
  
  public void hideToastView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "hideToastView toastView=" + this.toastView);
    }
    if (this.toastView != null)
    {
      this.toastView.a();
      this.toastView = null;
    }
  }
  
  public boolean isHomePage()
  {
    return this.apkgInfo.i(this.mUrl);
  }
  
  public boolean isTabPage()
  {
    return this.apkgInfo.h(this.mUrl);
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    if (paramString1.equals(this.mUrl))
    {
      onAppRoute(paramString2, paramString1);
      return;
    }
    this.mUrl = paramString1;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (!this.webViewMap.containsKey(paramString1))
    {
      this.appBrandPageContainer.appBrandRuntime.i.loadAppServiceJs(paramString1);
      localObject1 = new WebviewContainer(getContext(), this.appBrandPageContainer.appBrandRuntime, this.apkgInfo, paramString1);
      localObject2 = h.a().b(this.apkgInfo.d);
      ((PageWebview)localObject2).swipeRefreshLayout = ((WebviewContainer)localObject1).swipeRefreshLayout;
      ((PageWebview)localObject2).mContext = getContext();
      ((PageWebview)localObject2).apkgInfo = this.apkgInfo;
      ((PageWebview)localObject2).appBrandRuntime = this.appBrandPageContainer.appBrandRuntime;
      ((PageWebview)localObject2).eventListener = this.appBrandPageContainer.appBrandRuntime.h;
      ((PageWebview)localObject2).openType = paramString2;
      ((PageWebview)localObject2).mRouteUrl = paramString1;
      ((PageWebview)localObject2).listener = this;
      ((WebviewContainer)localObject1).setPageWebview((PageWebview)localObject2);
      this.webViewMap.put(paramString1, localObject1);
      ((PageWebview)localObject2).loadPageWebviewJs(this.apkgInfo);
      QLog.d("AppBrandPage", 4, "loadUrl url=" + paramString1 + ",centerLayout=" + this.centerLayout + ",webViewContainer=" + localObject1);
      this.centerLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandPage", 4, "loadUrl put webViewContainer url=" + paramString1);
      }
      i = this.appBrandPageContainer.getPageCount();
      this.navBar.a(this);
      this.navBar.b(this.apkgInfo.i(paramString1));
      this.navBar.a(this.apkgInfo.b.c(paramString1).a);
      paramString2 = this.navBar;
      if (i <= 1) {
        break label562;
      }
      bool1 = true;
      label362:
      paramString2.a(bool1);
      this.navBar.a = getCurrentPageWebview();
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandPage", 4, "loadUrl url=" + paramString1 + ",pageCnt=" + i);
      }
      if (i != 1) {
        break label568;
      }
    }
    label562:
    label568:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = false;
      }
      setEnable(bool1);
      if (!isTabPage()) {
        break label573;
      }
      this.tabView.setVisibility(0);
      this.tabView.a(paramString1);
      return;
      localObject1 = this.webViewMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        WebviewContainer localWebviewContainer = (WebviewContainer)((Map.Entry)localObject2).getValue();
        if (((String)((Map.Entry)localObject2).getKey()).equals(paramString1))
        {
          localWebviewContainer.setVisibility(0);
          onAppRoute(paramString2, paramString1);
        }
        else
        {
          localWebviewContainer.setVisibility(8);
        }
      }
      break;
      bool1 = false;
      break label362;
    }
    label573:
    if (this.tabView != null) {
      this.tabView.setVisibility(8);
    }
    setCallback(this);
  }
  
  public void notifyChangePullDownRefreshStyle()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).notifyChangePullDownRefreshStyle();
    }
  }
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    super.onAppRoute(paramString1, paramString2);
    reportPageVisit(paramString2);
  }
  
  public void onClickBack(NavigationBar paramNavigationBar)
  {
    this.appBrandPageContainer.navigateBack(1, true);
  }
  
  public void onClickClose(NavigationBar paramNavigationBar)
  {
    this.appBrandPageContainer.appBrandRuntime.g();
  }
  
  public void onClickMore(NavigationBar paramNavigationBar) {}
  
  public void onLongClickBack(NavigationBar paramNavigationBar) {}
  
  public void onPageBackground()
  {
    super.onPageBackground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().onVideoPlayerPause();
    }
  }
  
  public void onPageForeground()
  {
    super.onPageForeground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().onVideoPlayerResume();
    }
  }
  
  public void onSwipeFinish()
  {
    this.appBrandPageContainer.navigateBack(1, true);
  }
  
  public void onWebViewReady(String paramString1, String paramString2)
  {
    onAppRoute(paramString1, paramString2);
  }
  
  public void reportPageVisit(String paramString)
  {
    JSONObject localJSONObject;
    if (this.appBrandPageContainer.appBrandRuntime.l != -1L) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("page", c.d(paramString));
      label37:
      VACDReportUtil.b(this.appBrandPageContainer.appBrandRuntime.l, null, "PageVisit", localJSONObject.toString(), 0, null);
      return;
    }
    catch (Throwable paramString)
    {
      break label37;
    }
  }
  
  public void showToastView(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "showToastView toastView=" + this.toastView);
    }
    if (this.toastView == null) {
      this.toastView = new g(getContext(), this);
    }
    this.toastView.a(paramString1, paramString2, paramCharSequence, paramInt, paramBoolean);
  }
  
  public void stopPullDownRefresh()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).stopPullDownRefresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */