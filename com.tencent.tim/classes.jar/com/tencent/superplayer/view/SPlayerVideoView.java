package com.tencent.superplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SPlayerVideoView
  extends FrameLayout
  implements ISPlayerVideoView
{
  private static AtomicInteger sVideoViewIdCreater = new AtomicInteger(1000);
  private ISPlayerViewBase.ViewCreateCallBack mBlockCallback = new SPlayerVideoView.1(this);
  private AtomicBoolean mChangingSurfaceObject = new AtomicBoolean(false);
  private Context mContext;
  private AtomicBoolean mDetachingView = new AtomicBoolean(false);
  private ISPlayerViewBase mDisPlayView = null;
  private int mHeight = 0;
  private boolean mIsSurfaceReady = false;
  private boolean mIsUseTextureView;
  private SurfaceObject mStoredSurfaceObject;
  private SurfaceObject mSurfaceObject = new SurfaceObject();
  private String mTAG;
  private List<ISPlayerVideoView.IVideoViewCallBack> mVideoViewCallBackList;
  private int mVideoViewId;
  private ISPlayerViewBase.ViewCreateCallBack mViewCallBack = new SPlayerVideoView.2(this);
  private int mWidth = 0;
  
  public SPlayerVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext.getApplicationContext());
    this.mContext = paramContext.getApplicationContext();
    this.mIsUseTextureView = paramBoolean;
    this.mVideoViewId = sVideoViewIdCreater.getAndAdd(1);
    this.mTAG = ("SPlayerVideoView-" + this.mVideoViewId);
    if (Build.VERSION.SDK_INT < 14) {
      this.mIsUseTextureView = false;
    }
    initViewAfterV4();
  }
  
  private void callOnSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceChanged(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceCreate(Object paramObject)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceCreated(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceDestroy(Object paramObject)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceDestroy(paramObject);
        }
      }
    }
  }
  
  private void initSurfaceObject(Object paramObject)
  {
    if (this.mIsUseTextureView)
    {
      paramObject = (SurfaceTexture)paramObject;
      if (this.mSurfaceObject.surfaceTexture == paramObject) {
        return;
      }
      this.mSurfaceObject.surfaceTexture = paramObject;
      this.mSurfaceObject.surface = new Surface(paramObject);
      LogUtil.d(this.mTAG, "创建Surface实例，Surface=" + this.mSurfaceObject.surface);
      return;
    }
    paramObject = (SurfaceHolder)paramObject;
    this.mSurfaceObject.surfaceTexture = null;
    this.mSurfaceObject.surface = paramObject.getSurface();
  }
  
  private void initViewAfterV4()
  {
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams2.gravity = 17;
    setLayoutParams(localLayoutParams1);
    this.mDisPlayView = SPlayerViewFactory.createPlayView(this.mContext, this.mIsUseTextureView);
    this.mDisPlayView.setVideoViewTagId(String.valueOf(this.mVideoViewId));
    this.mDisPlayView.setViewCallBack(this.mViewCallBack);
    addView((View)this.mDisPlayView, localLayoutParams2);
  }
  
  public void addViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack)
  {
    if (paramIVideoViewCallBack == null) {}
    do
    {
      return;
      if (this.mVideoViewCallBackList == null) {
        this.mVideoViewCallBackList = new CopyOnWriteArrayList();
      }
    } while (this.mVideoViewCallBackList.contains(paramIVideoViewCallBack));
    this.mVideoViewCallBackList.add(paramIVideoViewCallBack);
  }
  
  public void changeSurfaceObject(SurfaceObject paramSurfaceObject)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mChangingSurfaceObject.set(true);
      this.mSurfaceObject = paramSurfaceObject;
      disableViewCallback();
      ((SPlayerTextureView)this.mDisPlayView).setSurfaceTexture(paramSurfaceObject.surfaceTexture);
      this.mIsSurfaceReady = true;
      ThreadUtil.runOnUiThread(new SPlayerVideoView.5(this));
      this.mChangingSurfaceObject.set(false);
    }
  }
  
  public boolean disableViewCallback()
  {
    if (this.mDisPlayView == null) {
      return false;
    }
    if ((!this.mIsSurfaceReady) && (!this.mChangingSurfaceObject.get()))
    {
      LogUtil.i(this.mTAG, "detach from old parent view , but view not ready");
      return false;
    }
    if (this.mDetachingView.get())
    {
      LogUtil.i(this.mTAG, "detach from old parent view , but is detaching");
      return true;
    }
    if (!(this.mDisPlayView instanceof SPlayerTextureView))
    {
      LogUtil.i(this.mTAG, "detach from old parent view , but not texture view");
      return false;
    }
    LogUtil.i(this.mTAG, "detach from old parent view");
    this.mDetachingView.set(true);
    this.mDisPlayView.setViewCallBack(this.mBlockCallback);
    return true;
  }
  
  public boolean enableViewCallback()
  {
    LogUtil.i(this.mTAG, "attach to new parent view");
    if ((this.mDisPlayView != null) && ((this.mDisPlayView instanceof SPlayerTextureView)) && (this.mStoredSurfaceObject != null) && (((SPlayerTextureView)this.mDisPlayView).getSurfaceTexture() != this.mStoredSurfaceObject.surfaceTexture) && (Build.VERSION.SDK_INT >= 16)) {
      ((SPlayerTextureView)this.mDisPlayView).setSurfaceTexture(this.mStoredSurfaceObject.surfaceTexture);
    }
    if (this.mDisPlayView != null) {
      this.mDisPlayView.setViewCallBack(this.mViewCallBack);
    }
    this.mDetachingView.set(false);
    return true;
  }
  
  public String getLogTag()
  {
    return "SPlayerVideoView-" + this.mVideoViewId + "|SPlayerTextureView-" + this.mVideoViewId;
  }
  
  public View getRenderView()
  {
    return (View)this.mDisPlayView;
  }
  
  public int getRenderViewHeight()
  {
    if (this.mDisPlayView == null) {
      return 0;
    }
    return ((View)this.mDisPlayView).getHeight();
  }
  
  public int getRenderViewWidth()
  {
    if (this.mDisPlayView == null) {
      return 0;
    }
    return ((View)this.mDisPlayView).getWidth();
  }
  
  public SurfaceObject getStoredSurfaceObject()
  {
    return this.mStoredSurfaceObject;
  }
  
  public Surface getSurface()
  {
    if (this.mIsSurfaceReady) {
      return this.mSurfaceObject.surface;
    }
    return null;
  }
  
  public boolean isSurfaceReady()
  {
    return this.mIsSurfaceReady;
  }
  
  public boolean isTextureView()
  {
    return this.mIsUseTextureView;
  }
  
  public void removeViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack)
  {
    if (this.mVideoViewCallBackList != null)
    {
      if (paramIVideoViewCallBack == null) {
        this.mVideoViewCallBackList.clear();
      }
    }
    else {
      return;
    }
    this.mVideoViewCallBackList.remove(paramIVideoViewCallBack);
  }
  
  public void setDegree(int paramInt)
  {
    if (this.mDisPlayView != null) {
      this.mDisPlayView.setDegree(paramInt);
    }
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "setFixedSize, vW: " + paramInt1 + ", vH: " + paramInt2);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.mDisPlayView.setVideoWidthAndHeight(paramInt1, paramInt2);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ((View)this.mDisPlayView).requestLayout();
      return;
    }
    ThreadUtil.runOnUiThread(new SPlayerVideoView.3(this));
  }
  
  public void setScaleParam(float paramFloat)
  {
    this.mDisPlayView.setScaleParam(paramFloat);
  }
  
  public void setXYaxis(int paramInt)
  {
    try
    {
      this.mDisPlayView.setXYaxis(paramInt);
      ThreadUtil.runOnUiThread(new SPlayerVideoView.4(this));
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(this.mTAG, localException.getMessage());
    }
  }
  
  public String toString()
  {
    return "SuperPlayerVideoInfo[" + this.mTAG + "]";
  }
  
  public class SurfaceObject
  {
    Surface surface;
    SurfaceTexture surfaceTexture;
    
    public SurfaceObject() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */