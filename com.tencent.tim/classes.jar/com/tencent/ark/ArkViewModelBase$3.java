package com.tencent.ark;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import java.util.HashMap;

class ArkViewModelBase$3
  implements Runnable
{
  ArkViewModelBase$3(ArkViewModelBase paramArkViewModelBase, ArkViewModelBase.AppInfo paramAppInfo, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if (!ArkViewModelBase.sAppInit)
    {
      this.this$0.initLibrary();
      ArkViewModelBase.sAppInit = true;
    }
    this.this$0.mHasLoaded = true;
    this.this$0.mSyncRectLock = true;
    this.this$0.mTimeRecord.beginOfCreateView = System.currentTimeMillis();
    ArkAppPreloader.preloadCommon(this.val$info.scale, this.val$storagePath, this.val$cachePath);
    ??? = this.this$0.mApplication;
    if (this.this$0.mApplication != null) {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("profiling.doLoadArkApp.find.preApplication.this.%h.application.%h", new Object[] { this.this$0, this.this$0.mApplication }));
    }
    if (ArkViewModelBase.ENV.mIsDebug) {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.beginOfCreateApplication.this.%h.queueKey=%s", new Object[] { this.this$0, this.this$0.mQueueKey }));
    }
    this.this$0.mTimeRecord.beginOfCreateApplication = System.currentTimeMillis();
    this.this$0.mApplication = ark.Application.Create(this.val$info.name, this.val$info.path);
    if (this.this$0.mApplication == null)
    {
      ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mApplication.create.fail!!");
      this.this$0.onLoadReport(104);
      i = 0;
    }
    while (i == 0)
    {
      this.this$0.mHasLoaded = false;
      this.this$0.mSyncRectLock = false;
      if (this.this$0.mAppScriptType == 2) {
        this.this$0.mLoadFailed = true;
      }
      this.this$0.onRunAppFailed();
      return;
      if (??? != null)
      {
        ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("profiling.doLoadArkApp.release.preApplication.this.%h.application.%h", new Object[] { this.this$0, ??? }));
        this.this$0.applicationRelease((ark.Application)???);
        ((ark.Application)???).Release();
      }
      ArkStateCenter.getInstance().addArkViewModel(this.this$0);
      this.this$0.applicationCreate(this.this$0.mApplication);
      this.this$0.mTimeRecord.beginOfRunApplication = System.currentTimeMillis();
      if (!this.this$0.mApplication.Load(this.val$storagePath, this.val$resPath, this.val$cachePath))
      {
        if ((this.this$0.mApplication.GetScriptType() == 2) && (!ark.Application.JSCLoaded()))
        {
          this.this$0.mInit = false;
          this.this$0.mLoadFailed = true;
          this.this$0.onLoadReport(107);
          i = 0;
        }
        else
        {
          this.this$0.onLoadReport(106);
          i = 0;
        }
      }
      else if (!this.this$0.mApplication.Run(this.this$0.mAppCallback, this.this$0.mAppInfo.appConfig))
      {
        this.this$0.onLoadReport(102);
        i = 0;
      }
      else
      {
        if (this.this$0.mContainer != null)
        {
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mContainer.not.null");
          this.this$0.mContainer.DeletePtr();
        }
        this.this$0.mTimeRecord.beginOfCreateContainer = System.currentTimeMillis();
        this.this$0.beforeContainerCreate();
        this.this$0.mContainer = new ark.Container();
        ??? = this.this$0.mContainer;
        if (!this.this$0.mIsGpuRendering)
        {
          bool = true;
          label579:
          ((ark.Container)???).SetDisableGPURendering(bool);
          ??? = this.this$0.mContainer;
          if ((this.this$0.mIsGpuRendering) && (!EGLContextHolder.sIsGPURasterDisabled)) {
            break label708;
          }
        }
        label708:
        for (boolean bool = true;; bool = false)
        {
          ((ark.Container)???).SetDisableGPURasterization(bool);
          this.this$0.mContainer.SetShowFps(ArkViewModelBase.ENV.mShowFps);
          this.this$0.mContainer.SetContainerCallback(this.this$0);
          if (this.this$0.mContainer.CreateRootView(this.this$0.mApplication, this.val$info.view)) {
            break label714;
          }
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.CreateRootView.fail!!");
          this.this$0.onLoadReport(105);
          i = 0;
          break;
          bool = false;
          break label579;
        }
        label714:
        i = 1;
      }
    }
    this.this$0.mTimeRecord.beginOfInitContainer = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.val$viewId)) {
      this.this$0.mContainer.SetID(this.val$viewId);
    }
    int j = this.val$info.width;
    int k = this.val$info.height;
    int i = j;
    if (j <= 0) {
      i = this.this$0.mRectArkContainer.width();
    }
    j = k;
    if (k <= 0) {
      j = this.this$0.mRectArkContainer.height();
    }
    ??? = this.this$0.limitToSizeRange(i, j);
    this.this$0.mContainer.SetSize(((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
    this.this$0.mContainer.SetMetadata(this.val$info.meta, "json");
    this.this$0.mTimeRecord.endOfCreateView = System.currentTimeMillis();
    this.this$0.mSyncRectLock = false;
    if (this.this$0.notInSizeRange(this.this$0.mRectArkContainer.width(), this.this$0.mRectArkContainer.height()))
    {
      ??? = this.this$0.limitToSizeRange(this.this$0.mRectArkContainer.width(), this.this$0.mRectArkContainer.height());
      this.this$0.mRectContainer.set(0, 0, ((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
    }
    for (;;)
    {
      ??? = this.this$0.mViewImpl;
      if ((this.this$0.mAttached) && (??? != null)) {
        break;
      }
      ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mViewImpl.null");
      this.this$0.onLoadReport(103);
      return;
      this.this$0.mRectContainer = this.this$0.mRectArkContainer;
    }
    this.this$0.mNeedFirstPaint = true;
    ArkVsync.getInstance().addFrameCallback(this.this$0.mQueueKey, this.this$0);
    this.this$0.mContainer.SetBorderType(((ArkViewImplement)???).mBorderType);
    this.this$0.mContainer.SetBorderRadiusTop(((ArkViewImplement)???).mClipRadiusTop);
    this.this$0.mContainer.SetBorderRadius(((ArkViewImplement)???).mClipRadius);
    this.this$0.mContainer.SetBorderHornLeft(((ArkViewImplement)???).mAlignLeft);
    this.this$0.SyncRect(this.this$0.mRectContainerF.left, this.this$0.mRectContainerF.top, this.this$0.mRectContainerF.right, this.this$0.mRectContainerF.bottom);
    this.this$0.mTimeRecord.endOfDisplyView = System.currentTimeMillis();
    if (ArkViewModelBase.ENV.mIsDebug) {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.endOfDisplyView.this.%h", new Object[] { this.this$0 }));
    }
    synchronized (ArkViewModelBase.sAppSizeHint)
    {
      ArkViewModelBase.sAppSizeHint.put(String.format("%s_%s", new Object[] { this.val$info.path, this.val$info.view }), new ArkViewModelBase.Size(this.this$0.mRectContainer.width(), this.this$0.mRectContainer.height()));
      this.this$0.onAppDisplay(this.this$0.mTimeRecord);
      this.this$0.onLoadReport(100);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.3
 * JD-Core Version:    0.7.0.1
 */