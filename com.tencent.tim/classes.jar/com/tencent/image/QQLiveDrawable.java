package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.util.Arrays;

public class QQLiveDrawable
  extends Drawable
{
  private static final String TAG = QQLiveDrawable.class.getSimpleName();
  public static final String URL_PROTOCOL = "qqlive";
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  public QQLiveState mQQLiveState;
  private int mTargetDensity = 160;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public QQLiveDrawable(QQLiveState paramQQLiveState, Resources paramResources)
  {
    this.mQQLiveState = paramQQLiveState;
    this.mQQLiveState.mVideo.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramQQLiveState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public QQLiveDrawable(QQLiveImage paramQQLiveImage, Resources paramResources)
  {
    this(new QQLiveState(paramQQLiveImage), paramResources);
    this.mQQLiveState.mTargetDensity = this.mTargetDensity;
  }
  
  public QQLiveDrawable(String paramString, Resources paramResources)
  {
    this(new QQLiveImage(paramString, null), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mVideoWidth = this.mQQLiveState.mVideo.getScaledWidth(this.mTargetDensity);
    this.mVideoHeight = this.mQQLiveState.mVideo.getScaledHeight(this.mTargetDensity);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mQQLiveState.mGravity, this.mVideoWidth, this.mVideoHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    copyBounds(this.mDstRect);
    this.mQQLiveState.mVideo.draw(paramCanvas, this.mDstRect, this.mQQLiveState.mPaint);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mQQLiveState;
  }
  
  public long getCurrentPosition()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getCurrentPosition();
    }
    return 0L;
  }
  
  public long getCurrentPostion()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getCurrentPosition();
    }
    return -1L;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mVideoWidth;
  }
  
  public long getMsgUniseq()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
      return this.mQQLiveState.mVideo.mParams.msgUniseq;
    }
    return 0L;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public int getPlayState()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getPlayState();
    }
    return 7;
  }
  
  public boolean isPaused()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.isPaused();
    }
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void onDetachedFromWindow()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.onDetachedFromWindow();
    }
  }
  
  public void pause()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.pause();
    }
  }
  
  public void recyleAndKeepPostion()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndKeepPostion();
    }
  }
  
  public void recyleAndNotKeepPosition()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndNotKeepPosition();
    }
  }
  
  public void recyleFor2Background()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleFor2Background();
    }
  }
  
  public void release()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.release();
    }
  }
  
  public void replay()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.replay();
    }
  }
  
  public void resume()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resume();
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resumeFromPosi(paramInt);
    }
  }
  
  public void seek(int paramInt)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.seek(paramInt);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mQQLiveState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mQQLiveState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setGravity(int paramInt)
  {
    this.mQQLiveState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
      this.mQQLiveState.mVideo.mParams.mMute = paramBoolean;
    }
  }
  
  public void setOnDownloadListener(OnDownloadListener paramOnDownloadListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnDownloadListener(paramOnDownloadListener);
    }
  }
  
  public void setOnLoopBackListener(OnLoopBackListener paramOnLoopBackListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnLoopBackListener(paramOnLoopBackListener);
    }
  }
  
  public void setOnStateListener(OnStateListener paramOnStateListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnStateListener(paramOnStateListener);
    }
  }
  
  public void setParams(QQLiveDrawableParams paramQQLiveDrawableParams)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.mParams = paramQQLiveDrawableParams;
    }
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  public void startVideo()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.start();
    }
  }
  
  public static class ErrorInfo
  {
    public String detailInfo;
    public int extra;
    public Object info;
    public int model;
    public int what;
    
    public String toString()
    {
      String str;
      switch (this.model)
      {
      default: 
        str = " MODEL_UNKNOW ";
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ErrorInfo : [ model =").append(this.model);
        localStringBuilder.append("\n modelDesc = ").append(str);
        localStringBuilder.append("\n what = ").append(this.what);
        localStringBuilder.append("\n extra = ").append(this.extra);
        localStringBuilder.append("\n detainInfo = ").append(this.detailInfo);
        localStringBuilder.append("\n info = ").append(this.info);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
        str = " MODEL_JAVA_LOGIC_ERR ";
        continue;
        str = " MODEL_PLAYER_CORE_ERR ";
        continue;
        str = " MODEL_CGI_GETVINFO_ERR ";
        continue;
        str = " MODEL_CGI_GETKEY_ERR ";
        continue;
        str = " MODEL_CGI_GETPROGINFO_ERR ";
        continue;
        str = " MODEL_DOWNLOAD_ERR ";
      }
    }
  }
  
  public static abstract interface OnDownloadListener
  {
    public abstract void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2);
  }
  
  public static abstract interface OnLoopBackListener
  {
    public abstract void onLoopBack(QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, long paramLong);
  }
  
  public static abstract interface OnStateListener
  {
    public static final int STATE_BUFFERING = 3;
    public static final int STATE_COMPLETE = 6;
    public static final int STATE_ERROR = 5;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITIALIZED = 8;
    public static final int STATE_PAUSE = 4;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PREPARED = 1;
    public static final int STATE_PREPARING = 9;
    public static final int STATE_RELEASED = 10;
    public static final int STATE_UNKNOW = 7;
    
    public abstract void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject);
  }
  
  public static class QQLiveDrawableParams
  {
    public static final int DATA_SOURCE_TYPE_FILE = 3;
    public static final int DATA_SOURCE_TYPE_THIRD = 2;
    public static final int DATA_SOURCE_TYPE_URL = 1;
    public static final int DATA_SOURCE_TYPE_URL_LIST = 4;
    public static final int DATA_SOURCE_TYPE_VID = 0;
    public static final ColorDrawable DEFAULT_LOADING_DRAWABLE = new ColorDrawable(-2236446);
    public static final boolean DEFAULT_MUTE_VALUE = true;
    public static final int PLAY_TYPE_LOCAL_FILE = 2;
    public static final int PLAY_TYPE_ONLINE_LIVE = 1;
    public static final int PLAY_TYPE_ONLINE_VOD = 0;
    public static final int PLAY_TYPE_THIRD = 3;
    public int mCoverHeight = 0;
    public ColorDrawable mCoverLoadingDrawable = DEFAULT_LOADING_DRAWABLE;
    public String mCoverUrl;
    public int mCoverWidth = 0;
    public String mDataSource;
    public volatile AbsThirdDataSourceAdapter mDataSourceAdapter;
    public int mDataSourceType;
    public QQLiveDrawable.OnDownloadListener mDownloadListener;
    public int mDuraion;
    public QQLiveDrawable.OnStateListener mListener;
    public QQLiveDrawable.OnLoopBackListener mLoopBackListener;
    public boolean mLoopback = true;
    public int mMaxPlayTimeMs;
    public boolean mMute = true;
    public boolean mPlayPause;
    public int mPlayType = 0;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public String mReportTag;
    public String mRequestFormat = "sd";
    public String mSavePath;
    public String mServerType;
    public int mStartPosi = 0;
    public String[] mUrls;
    public String mVid;
    public long mVideoTime;
    public long msgUniseq;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" QQLiveDrawableParams [");
      localStringBuilder.append("\n mMute: ").append(this.mMute);
      localStringBuilder.append("\n mRequestFormat: ").append(this.mRequestFormat);
      localStringBuilder.append("\n mPreviewWidth: ").append(this.mPreviewWidth);
      localStringBuilder.append("\n mPreviewHeight: ").append(this.mPreviewHeight);
      localStringBuilder.append("\n mStartPosi: ").append(this.mStartPosi);
      localStringBuilder.append("\n mPlayPause: ").append(this.mPlayPause);
      localStringBuilder.append("\n mListener: ").append(this.mListener);
      localStringBuilder.append("\n mDataSourceType: ").append(this.mDataSourceType);
      localStringBuilder.append("\n mDataSource: ").append(this.mDataSource);
      localStringBuilder.append("\n mCoverUrl: ").append(this.mCoverUrl);
      localStringBuilder.append("\n mLoopback: ").append(this.mLoopback);
      localStringBuilder.append("\n mMaxPlayTimeMs: ").append(this.mMaxPlayTimeMs);
      localStringBuilder.append("\n mPlayType: ").append(this.mPlayType);
      localStringBuilder.append("\n mUrls: ").append(Arrays.toString(this.mUrls));
      localStringBuilder.append("\n mServerType: ").append(this.mServerType);
      localStringBuilder.append("\n mSavePath: ").append(this.mSavePath);
      localStringBuilder.append("\n mVid: ").append(this.mVid);
      localStringBuilder.append("\n mDuraion: ").append(this.mDuraion);
      localStringBuilder.append("\n mVideoTime: ").append(this.mVideoTime);
      localStringBuilder.append("\n msgUniseq: ").append(this.msgUniseq);
      localStringBuilder.append("\n OnDownloadListener: ").append(this.mDownloadListener);
      localStringBuilder.append("\n OnLoopBackListener: ").append(this.mLoopBackListener);
      localStringBuilder.append("] ");
      return localStringBuilder.toString();
    }
  }
  
  static class QQLiveState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    int mGravity = 119;
    Paint mPaint = new Paint();
    int mTargetDensity = 160;
    public QQLiveImage mVideo;
    
    public QQLiveState(QQLiveImage paramQQLiveImage)
    {
      this.mVideo = paramQQLiveImage;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new QQLiveDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new QQLiveDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable
 * JD-Core Version:    0.7.0.1
 */