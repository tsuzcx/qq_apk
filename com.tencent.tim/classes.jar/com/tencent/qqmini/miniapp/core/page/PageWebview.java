package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.os.Handler;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BasePageWebview
{
  private static final String TAG = "PageWebview";
  private static final boolean enableEmbeddedLiveConfig;
  private static final boolean enableEmbeddedVideoConfiog;
  private AppBrandPageContainer mAppBrandPageContainer;
  private BrandPageWebview mBrandPageWebview;
  private IMiniAppContext mContext;
  private EmbeddedState mEmbeddedState;
  protected EmbeddedWidgetClientFactory mEmbeddedWidgetClientFactory;
  private boolean mPageJsLoadSucc = false;
  private ShareState mShareState;
  public int scrollY;
  public ArrayList<OnWebviewScrollListener> webviewScrollListenerList;
  
  static
  {
    boolean bool2 = true;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_video", 1) == 1)
    {
      bool1 = true;
      enableEmbeddedVideoConfiog = bool1;
      if (WnsConfig.getConfig("qqminiapp", "enable_embedded_live", 1) != 1) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enableEmbeddedLiveConfig = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public PageWebview(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer, BrandPageWebview paramBrandPageWebview)
  {
    super(paramIMiniAppContext.getContext(), paramAppBrandPageContainer);
    this.mContext = paramIMiniAppContext;
    this.mAppBrandPageContainer = paramAppBrandPageContainer;
    this.mBrandPageWebview = paramBrandPageWebview;
    this.mShareState = new ShareState();
    this.mEmbeddedState = new EmbeddedState();
    init();
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QMLog.e("PageWebview", "createBitmap failed", localOutOfMemoryError1);
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QMLog.e("PageWebview", "createBitmap failed again", localOutOfMemoryError2);
      }
    }
    return null;
  }
  
  public static Bitmap screenShot(WebView paramWebView, int paramInt1, int paramInt2)
  {
    if ((paramWebView == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    Bitmap localBitmap = createBitmap(paramInt1, paramInt2);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    PaintFlagsDrawFilter localPaintFlagsDrawFilter;
    float f;
    if (paramWebView.getX5WebViewExtension() != null)
    {
      localPaintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
      paramInt2 = QbSdk.getTbsVersion(paramWebView.getContext());
      if ((paramInt2 >= 43000) && (paramInt2 < 43105))
      {
        f = paramInt1 / paramWebView.getMeasuredWidth();
        localCanvas.scale(f, f);
        localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
        paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
        QMLog.d("PageWebview", "snapshot with snapshotVisible()");
        localCanvas.setDrawFilter(null);
      }
    }
    for (;;)
    {
      return localBitmap;
      f = paramInt1 / paramWebView.getContentWidth();
      localCanvas.scale(f, f);
      localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
      paramWebView.getX5WebViewExtension().snapshotWholePage(localCanvas, false, false);
      QMLog.d("PageWebview", "snapshot with snapshotWholePage()");
      break;
      f = paramInt1 / paramWebView.getMeasuredWidth();
      localCanvas.scale(f, f);
      paramWebView = paramWebView.capturePicture();
      if (paramWebView != null) {
        paramWebView.draw(localCanvas);
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mAppBrandPageContainer != null) {
      this.mAppBrandPageContainer.notifyOnPageWebViewDestory();
    }
    if ((this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
    {
      Iterator localIterator = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)localIterator.next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewDestory();
        }
        localIterator.remove();
      }
    }
  }
  
  public EmbeddedState getEmbeddedState()
  {
    return this.mEmbeddedState;
  }
  
  public EmbeddedWidgetClientFactory getEmbeddedWidgetClientFactory()
  {
    return this.mEmbeddedWidgetClientFactory;
  }
  
  public ShareState getShareState()
  {
    return this.mShareState;
  }
  
  public boolean handleBackPressed()
  {
    if (this.mBrandPageWebview != null) {
      return this.mBrandPageWebview.handleBackPressed();
    }
    return false;
  }
  
  public void init()
  {
    boolean bool2 = true;
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
    boolean bool1;
    try
    {
      if (getX5WebViewExtension() == null) {
        break label322;
      }
      long l = System.currentTimeMillis();
      this.mEmbeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
      Object localObject = getX5WebViewExtension();
      EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = this.mEmbeddedWidgetClientFactory;
      boolean bool3 = ((IX5WebViewExtension)localObject).registerEmbeddedWidget(new String[] { "video" }, localEmbeddedWidgetClientFactory);
      QMLog.d("miniapp-embedded", "registerEmbeddedWidget : " + bool3 + "; " + (System.currentTimeMillis() - l));
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if (((MiniAppProxy)localObject).isDebugVersion())
      {
        localObject = ((MiniAppProxy)localObject).getAccount();
        bool1 = AppLoaderFactory.g().getContext().getSharedPreferences((String)localObject + "_user_embedded_video_", 0).getBoolean("_user_embedded_video_", true);
        bool2 = AppLoaderFactory.g().getContext().getSharedPreferences((String)localObject + "_user_embedded_live_", 0).getBoolean("_user_embedded_live_", true);
        if ((!bool3) || (!bool1)) {
          break label323;
        }
        bool1 = true;
        break label309;
        this.mEmbeddedState.setEnableEmbeddedVideo(bool1);
        this.mEmbeddedState.setEnableEmbeddedLive(bool2);
      }
      else
      {
        if ((bool3) && (enableEmbeddedVideoConfiog))
        {
          bool1 = true;
          label270:
          if (!bool3) {
            break label290;
          }
          bool3 = enableEmbeddedLiveConfig;
          if (!bool3) {
            break label290;
          }
        }
        for (;;)
        {
          break;
          bool1 = false;
          break label270;
          label290:
          bool2 = false;
        }
      }
      if (!bool3) {
        break label328;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "registerEmbeddedWidget error,", localThrowable);
      return;
    }
    label309:
    if (bool2) {}
    label322:
    label323:
    label328:
    for (bool2 = true;; bool2 = false)
    {
      break;
      return;
      bool1 = false;
      break label309;
    }
  }
  
  public void onHide()
  {
    if (this.mAppBrandPageContainer.getShowingPage() != null)
    {
      String str = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();
      QMLog.d("PageWebview", "onHide :" + str + "  id:" + this.mPageWebviewId);
      ThreadManager.getSubThreadHandler().post(new PageWebview.1(this, str));
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QMLog.d("PageWebview", "pagewebview onPause, id is  " + this.mPageWebviewId);
    if (this.mAppBrandPageContainer != null) {
      this.mAppBrandPageContainer.notifyOnPageWebViewPause();
    }
    if (this.mBrandPageWebview != null) {
      this.mBrandPageWebview.evaluateJs("document.title=\"\"", null);
    }
    if ((this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
    {
      Iterator localIterator = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)localIterator.next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewPause();
        }
      }
    }
    onHide();
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume();
    QMLog.d("PageWebview", "pagewebview onResume, id is " + this.mPageWebviewId);
    if (this.mAppBrandPageContainer != null) {
      this.mAppBrandPageContainer.notifyOnPageWebViewResume();
    }
    if ((this.mBrandPageWebview != null) && (this.mAppBrandPageContainer != null) && (this.mContext != null)) {
      if (this.mContext.getMiniAppInfo() == null) {
        break label261;
      }
    }
    label261:
    for (Object localObject1 = this.mContext.getMiniAppInfo().appId;; localObject1 = null)
    {
      if (this.mAppBrandPageContainer.getShowingPage() != null) {}
      for (Object localObject2 = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();; localObject2 = null)
      {
        localObject1 = "\"" + (String)localObject1 + ":" + (String)localObject2 + ":VISIBLE\"";
        this.mBrandPageWebview.evaluateJs("document.title=" + (String)localObject1, null);
        if ((paramBoolean) && (this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
        {
          localObject1 = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if (localObject2 != null) {
              ((EmbeddedWidgetClientHolder)localObject2).webViewResume();
            }
          }
        }
        return;
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.webviewScrollListenerList != null) && (this.webviewScrollListenerList.size() > 0))
    {
      Iterator localIterator = this.webviewScrollListenerList.iterator();
      while (localIterator.hasNext()) {
        ((OnWebviewScrollListener)localIterator.next()).onVerticalScroll(paramInt2);
      }
    }
    this.scrollY = paramInt2;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2.put("windowWidth", (int)(paramInt1 / DisplayUtil.getDensity(getContext())));
      localJSONObject2.put("windowHeight", (int)(paramInt2 / DisplayUtil.getDensity(getContext())));
      localJSONObject1.put("size", localJSONObject2);
      this.mContext.performAction(ServiceSubscribeEvent.obtain("onViewDidResize", localJSONObject1.toString(), getPageWebViewId()));
      if (this.mPageJsLoadSucc)
      {
        this.mBrandPageWebview.evaluateSubscribeJS("onViewDidResize", localJSONObject1.toString(), getPageWebViewId());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("PageWebview", "onSizeChanged, JSONException!", localJSONException);
      }
      QMLog.d("PageWebview", "page not ready, do nothing.");
    }
  }
  
  public void removeWebviewScrollListener(OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    if ((this.webviewScrollListenerList != null) && (this.webviewScrollListenerList.contains(paramOnWebviewScrollListener))) {
      this.webviewScrollListenerList.remove(paramOnWebviewScrollListener);
    }
  }
  
  public void setOnWebviewScrollListener(OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    if (this.webviewScrollListenerList == null) {
      this.webviewScrollListenerList = new ArrayList();
    }
    this.webviewScrollListenerList.add(paramOnWebviewScrollListener);
  }
  
  public void setPageJsLoadSucc(boolean paramBoolean)
  {
    this.mPageJsLoadSucc = paramBoolean;
  }
  
  public void shotWebview(WebviewShotCallback paramWebviewShotCallback)
  {
    ThreadManager.getSubThreadHandler().post(new PageWebview.2(this, paramWebviewShotCallback));
  }
  
  public static abstract interface OnWebviewScrollListener
  {
    public abstract void onVerticalScroll(int paramInt);
  }
  
  public static abstract interface WebviewShotCallback
  {
    public abstract void onShotReady(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */