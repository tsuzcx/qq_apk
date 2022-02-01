package com.tencent.qqmini.miniapp.core.page.pool;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandPagePool
{
  public static final String TAG = "AppBrandPagePool";
  private final ConcurrentLinkedQueue<AppBrandPage> mBrandPageList = new ConcurrentLinkedQueue();
  private PageWebviewPool mPageWebviewPool;
  
  public AppBrandPagePool(IMiniAppContext paramIMiniAppContext)
  {
    this.mPageWebviewPool = new PageWebviewPool(paramIMiniAppContext);
  }
  
  public void destroyCachePage()
  {
    this.mBrandPageList.clear();
    if (this.mPageWebviewPool != null) {
      this.mPageWebviewPool.destroyCachePage();
    }
  }
  
  public void destroyPageWebviewCache()
  {
    if (this.mPageWebviewPool != null) {
      this.mPageWebviewPool.destroyCachePage();
    }
  }
  
  public AppBrandPage getAppBrandPage(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    QMLog.d("AppBrandPagePool", "mBrandPageList size : " + this.mBrandPageList.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.mBrandPageList.poll();
    if (localAppBrandPage == null)
    {
      QMLog.i("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(paramIMiniAppContext, paramAppBrandPageContainer);
    }
    QMLog.i("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public EmbeddedState getEmbeddedState(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.mBrandPageList.size() > 0) && (this.mPageWebviewPool != null)) {
      return this.mPageWebviewPool.getEmbeddedState(paramAppBrandPageContainer);
    }
    return null;
  }
  
  public PageWebviewPool getPageWebviewPool()
  {
    return this.mPageWebviewPool;
  }
  
  public void initBaseJs(AppBrandPageContainer paramAppBrandPageContainer, BaselibLoader.BaselibContent paramBaselibContent)
  {
    if (this.mPageWebviewPool != null) {
      this.mPageWebviewPool.initBaseJs(paramAppBrandPageContainer, paramBaselibContent);
    }
  }
  
  public void preLoadAppBrandPage(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (paramIMiniAppContext == null) {}
    do
    {
      return;
      if (this.mBrandPageList.size() <= 0)
      {
        QMLog.d("AppBrandPagePool", "preLoadAppBrandPage");
        paramIMiniAppContext = new AppBrandPage(paramIMiniAppContext, paramAppBrandPageContainer);
        this.mBrandPageList.add(paramIMiniAppContext);
      }
    } while (this.mPageWebviewPool == null);
    this.mPageWebviewPool.preLoadAppBrandPage(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool
 * JD-Core Version:    0.7.0.1
 */