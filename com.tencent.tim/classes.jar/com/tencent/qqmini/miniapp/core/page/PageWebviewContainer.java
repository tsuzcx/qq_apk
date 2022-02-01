package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, CoverView.JsRuntimeListener
{
  public static final String EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH = "onPullDownRefresh";
  public static final String TAG = "PageWebviewContainer";
  private boolean disableScroll = false;
  private boolean enableRefresh = false;
  private AbsAppBrandPage mBrandPage;
  private BrandPageWebview mBrandPageWebview;
  private IMiniAppContext mMiniAppContext;
  private NativeViewContainer mNaitveViewLayout;
  public int mNaitveViewScrollY = 0;
  private SwipeRefreshLayout mSwipeRefreshLayout;
  private String pageOrientation = WindowInfo.ORIENTATION_PORTRAIT;
  public int refreshStyleColor = -1;
  
  public PageWebviewContainer(IMiniAppContext paramIMiniAppContext, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(paramIMiniAppContext.getContext());
    this.mBrandPage = paramAbsAppBrandPage;
    this.mMiniAppContext = paramIMiniAppContext;
    this.mNaitveViewLayout = new NativeViewContainer(paramIMiniAppContext, this);
    ViewCompat.setImportantForAccessibility(this.mNaitveViewLayout, 4);
    this.mSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.mSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.mSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    notifyChangePullDownRefreshStyle(this.refreshStyleColor);
  }
  
  public void addViewOnPage(View paramView)
  {
    if (this.mBrandPage != null) {
      this.mBrandPage.addView(paramView);
    }
  }
  
  public void addViewOnPage(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mBrandPage != null) {
      this.mBrandPage.addView(paramView, paramLayoutParams);
    }
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mBrandPageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackFail(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.mBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mBrandPageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.mBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void cleanUp()
  {
    if (this.mBrandPageWebview != null) {
      this.mBrandPageWebview.cleanUp();
    }
    if (this.mNaitveViewLayout != null)
    {
      this.mNaitveViewLayout.destroy();
      this.mNaitveViewLayout.removeAllViews();
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.mBrandPageWebview != null) {
      this.mBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2)
  {
    if (this.mBrandPageWebview != null) {
      this.mBrandPageWebview.evaluateSubscribeJS(paramString1, paramString2, getWebViewId());
    }
  }
  
  public ApkgInfo getApkgInfo()
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null)) {
      return (ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo;
    }
    return null;
  }
  
  public Activity getAttachActivity()
  {
    if (this.mMiniAppContext != null) {
      return this.mMiniAppContext.getAttachedActivity();
    }
    return null;
  }
  
  public BrandPageWebview getBrandPageWebview()
  {
    return this.mBrandPageWebview;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    if (this.mBrandPage != null) {
      return this.mBrandPage.getCurrentPageWebview();
    }
    return null;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public NativeViewContainer getNativeViewContainer()
  {
    return this.mNaitveViewLayout;
  }
  
  public int getNativeViewScrollY()
  {
    return this.mNaitveViewScrollY;
  }
  
  public NavigationBar getNaviBar()
  {
    if (this.mBrandPage != null) {
      return this.mBrandPage.getNaviBar();
    }
    return null;
  }
  
  public int getNaviBarHeight()
  {
    if (getNaviBar() != null) {
      return getNaviBar().getHeight();
    }
    return 0;
  }
  
  public String getPageOrientation()
  {
    return this.pageOrientation;
  }
  
  public int getWebViewId()
  {
    return this.mBrandPageWebview.getRealView().getPageWebViewId();
  }
  
  public boolean handleBackPressed()
  {
    return (this.mNaitveViewLayout != null) && (this.mNaitveViewLayout.handleBackPressed());
  }
  
  public String handleNativeUIEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("PageWebviewContainer", "event = " + paramNativeViewRequestEvent.event + ", params = " + paramNativeViewRequestEvent.jsonParams);
    if ("startPullDownRefresh".equals(paramNativeViewRequestEvent.event)) {
      AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.3(this, paramNativeViewRequestEvent));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(paramNativeViewRequestEvent.event))
      {
        AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.4(this, paramNativeViewRequestEvent));
      }
      else if ("disableScrollBounce".equals(paramNativeViewRequestEvent.event))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
          if (!localJSONObject.has("disable")) {
            break label193;
          }
          AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), paramNativeViewRequestEvent));
        }
        catch (Exception localException1)
        {
          QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException1);
          paramNativeViewRequestEvent.fail("params error");
        }
        continue;
        label193:
        QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        paramNativeViewRequestEvent.fail("params error");
      }
      else if ("openDocument".equals(paramNativeViewRequestEvent.event))
      {
        try
        {
          AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.6(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optString("filePath"), paramNativeViewRequestEvent));
        }
        catch (JSONException paramNativeViewRequestEvent)
        {
          paramNativeViewRequestEvent.printStackTrace();
        }
      }
      else if ("scrollWebviewTo".equals(paramNativeViewRequestEvent.event))
      {
        try
        {
          Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
          long l = ((JSONObject)localObject).optLong("duration", 300L);
          float f = DisplayUtil.getDensity(this.mMiniAppContext.getContext());
          int i = (int)(((JSONObject)localObject).optInt("scrollTop") * f + 0.5F);
          localObject = getCurrentPageWebview();
          if (localObject != null)
          {
            ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject).getView().getScrollY(), i }).setDuration(l);
            ((ValueAnimator)localValueAnimator).addUpdateListener(new PageWebviewContainer.7(this, (PageWebview)localObject));
            localValueAnimator.addListener(new PageWebviewContainer.8(this, paramNativeViewRequestEvent));
            localValueAnimator.start();
          }
        }
        catch (Exception localException2)
        {
          QMLog.e("PageWebviewContainer", localException2.getMessage(), localException2);
          paramNativeViewRequestEvent.fail();
        }
      }
    }
  }
  
  public boolean isCustomNavibar()
  {
    if (this.mBrandPage != null) {
      return this.mBrandPage.isCustomNavibar();
    }
    return false;
  }
  
  public void notifyChangePullDownRefreshStyle(int paramInt)
  {
    this.refreshStyleColor = paramInt;
    this.mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(paramInt);
    if (paramInt == -1)
    {
      this.mSwipeRefreshLayout.setColorSchemeColors(new int[] { -16777216 });
      return;
    }
    this.mSwipeRefreshLayout.setColorSchemeColors(new int[] { -1 });
  }
  
  public void onCallbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramString, paramJSONObject, paramInt);
  }
  
  public void onCallbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventOK(paramString, paramJSONObject, paramInt);
  }
  
  public void onEvaluateSubscribeJS(String paramString1, String paramString2)
  {
    evaluateSubscribeJS(paramString1, paramString2);
  }
  
  public void onRefresh()
  {
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onPullDownRefresh", new JSONObject().toString(), getWebViewId()));
    }
  }
  
  public void removeBrandPageWebview()
  {
    if (this.mSwipeRefreshLayout != null) {
      this.mSwipeRefreshLayout.removeAllViews();
    }
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if ((this.mBrandPage != null) && (this.mBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().removeSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void setBrandPageWebview(BrandPageWebview paramBrandPageWebview)
  {
    if (paramBrandPageWebview != null)
    {
      this.mBrandPageWebview = paramBrandPageWebview;
      if (this.mBrandPageWebview.getRealView() != null)
      {
        this.mBrandPageWebview.getRealView().addView(this.mNaitveViewLayout, new FrameLayout.LayoutParams(-1, -1));
        this.mSwipeRefreshLayout.addView(this.mBrandPageWebview.getRealView(), new ViewGroup.LayoutParams(-1, -1));
        this.mBrandPageWebview.getRealView().setOnWebviewScrollListener(new PageWebviewContainer.2(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.mBrandPage != null) && (this.mBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if ((this.mBrandPage != null) && (this.mBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().setSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void updateContainerConfig(String paramString)
  {
    int i = 0;
    Boolean localBoolean;
    boolean bool;
    if (getApkgInfo() != null)
    {
      localBoolean = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.enablePullDownRefresh;
      if (localBoolean != null) {
        break label325;
      }
      bool = false;
      this.enableRefresh = bool;
      this.pageOrientation = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.pageOrientation;
      paramString = getApkgInfo().getAppConfigInfo().getPageInfo(paramString);
      if (paramString != null)
      {
        localBoolean = paramString.windowInfo.enablePullDownRefresh;
        if (localBoolean != null) {
          break label334;
        }
        bool = this.enableRefresh;
        label94:
        this.enableRefresh = bool;
        localBoolean = paramString.windowInfo.disableScroll;
        if (localBoolean != null) {
          break label343;
        }
        bool = this.disableScroll;
        label118:
        this.disableScroll = bool;
        paramString = paramString.windowInfo.pageOrientation;
        if (!TextUtils.isEmpty(paramString)) {
          this.pageOrientation = paramString;
        }
      }
      if (this.mSwipeRefreshLayout != null) {
        this.mSwipeRefreshLayout.setEnabled(this.enableRefresh);
      }
      if (this.disableScroll)
      {
        this.mBrandPageWebview.getRealView().setVerticalScrollBarEnabled(false);
        this.mBrandPageWebview.getRealView().setHorizontalScrollBarEnabled(false);
        if ((this.mBrandPageWebview.getRealView().getView() != null) && (this.mBrandPageWebview.getRealView().getView().getViewTreeObserver() != null) && (this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().isAlive())) {
          this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().addOnScrollChangedListener(new PageWebviewContainer.1(this));
        }
      }
      if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null) && (!this.mMiniAppContext.getAttachedActivity().isFinishing()))
      {
        if (!WindowInfo.ORIENTATION_AUTO.equals(this.pageOrientation)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.mMiniAppContext.getAttachedActivity().setRequestedOrientation(i);
      return;
      label325:
      bool = localBoolean.booleanValue();
      break;
      label334:
      bool = localBoolean.booleanValue();
      break label94;
      label343:
      bool = localBoolean.booleanValue();
      break label118;
      label352:
      if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(this.pageOrientation)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */