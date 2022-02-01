package com.tencent.ttpic.videoshelf.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;

public class VideoShelfPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener, IVideoShelfPlayerListener
{
  private static final int STATE_ERROR = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PAUSED = 4;
  private static final int STATE_PLAYBACK_COMPLETED = 5;
  private static final int STATE_PLAYING = 3;
  private static final int STATE_PREPARED = 2;
  private static final int STATE_PREPARING = 1;
  private static final String TAG = "VideoShelfPlayView";
  private final int FLUSH_FORCE = 2;
  private final int START_PLAY = 1;
  private int mCurrentState = 0;
  private Handler mHandler = new VideoShelfPlayView.1(this);
  private int mHeightVideo = 0;
  private boolean mIsInited = false;
  private boolean mIsNotCalledStart = true;
  private boolean mIsSurfaceDetroyed = true;
  private boolean mIsVideoFile = true;
  private Surface mPlaySurface;
  private IVideoShelfPlayerListener mPreparedlistener;
  private IVideoShelfPlayer mVideoSehlfPlayer;
  private int mWidthVideo = 0;
  
  public VideoShelfPlayView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public VideoShelfPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public VideoShelfPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  @TargetApi(21)
  public VideoShelfPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initView();
  }
  
  private boolean initVideoShelfPlayer()
  {
    if (!this.mIsInited) {
      return false;
    }
    if (this.mVideoSehlfPlayer == null) {
      try
      {
        if (this.mIsVideoFile) {}
        for (Object localObject = new VideoShelfPlayer();; localObject = new PagShelfPlayer())
        {
          this.mVideoSehlfPlayer = ((IVideoShelfPlayer)localObject);
          if (this.mPreparedlistener != null) {
            this.mVideoSehlfPlayer.setVideoShelfPlayerListener(this.mPreparedlistener);
          }
          if (this.mPlaySurface != null) {
            this.mVideoSehlfPlayer.setSurface(this.mPlaySurface);
          }
          this.mVideoSehlfPlayer.reset();
          this.mVideoSehlfPlayer.setVideoShelfPlayerListener(this);
          break;
        }
        return true;
      }
      catch (PagNotSupportSystemException localPagNotSupportSystemException)
      {
        Log.e("VideoShelfPlayView", localPagNotSupportSystemException.getMessage());
        TTPTLogger.e("VideoShelfPlayView", localPagNotSupportSystemException.getMessage());
        return false;
      }
    }
  }
  
  private void initView()
  {
    this.mCurrentState = 0;
    setSurfaceTextureListener(this);
  }
  
  private boolean isInPlaybackState()
  {
    return (this.mVideoSehlfPlayer != null) && (this.mCurrentState != -1) && (this.mCurrentState != 0) && (this.mCurrentState != 1);
  }
  
  public void flush()
  {
    Log.i("VideoShelfPlayView", "called flush.");
    if ((!this.mIsSurfaceDetroyed) && (isInPlaybackState()) && (initVideoShelfPlayer())) {
      this.mVideoSehlfPlayer.flush();
    }
  }
  
  public double getAspectRatio()
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (initVideoShelfPlayer())
    {
      d1 = d2;
      if (getVideoHeight() != 0) {
        d1 = getVideoWidth() * 1.0D / getVideoHeight();
      }
    }
    return d1;
  }
  
  public int getCurrentPosition()
  {
    if (initVideoShelfPlayer()) {
      return this.mVideoSehlfPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public IVideoShelfPlayer getPlayer()
  {
    return this.mVideoSehlfPlayer;
  }
  
  public int getVideoHeight()
  {
    if ((this.mHeightVideo == 0) && (initVideoShelfPlayer())) {
      this.mHeightVideo = this.mVideoSehlfPlayer.getVideoHeight();
    }
    return this.mHeightVideo;
  }
  
  public int getVideoWidth()
  {
    if ((this.mWidthVideo == 0) && (initVideoShelfPlayer())) {
      this.mWidthVideo = this.mVideoSehlfPlayer.getVideoWidth();
    }
    return this.mWidthVideo;
  }
  
  public boolean isHorizontalVideo()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (initVideoShelfPlayer())
    {
      bool1 = bool2;
      if (getVideoWidth() > getVideoHeight()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2)
  {
    updateVideoSize(paramInt1, paramInt2);
    if (this.mPreparedlistener != null) {
      this.mPreparedlistener.onChangVideoSize(paramInt1, paramInt2);
    }
  }
  
  public void onCompletion()
  {
    this.mCurrentState = 5;
    if (this.mPreparedlistener != null) {
      this.mPreparedlistener.onCompletion();
    }
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    this.mCurrentState = -1;
    if (this.mPreparedlistener != null) {
      this.mPreparedlistener.onError(paramInt, paramString, paramObject);
    }
    return false;
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer)
  {
    if (this.mPreparedlistener != null) {
      this.mPreparedlistener.onPrepared(paramIVideoShelfPlayer);
    }
    this.mCurrentState = 2;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.i("VideoShelfPlayView", "onSurfaceTextureAvailable.");
    this.mPlaySurface = new Surface(paramSurfaceTexture);
    if (initVideoShelfPlayer())
    {
      this.mVideoSehlfPlayer.setSurface(this.mPlaySurface);
      this.mIsSurfaceDetroyed = false;
      if (this.mIsNotCalledStart) {
        this.mHandler.sendEmptyMessage(1);
      }
      if (4 == this.mCurrentState) {
        this.mHandler.sendEmptyMessage(2);
      }
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.i("VideoShelfPlayView", "onSurfaceTextureDestroyed.");
    this.mIsSurfaceDetroyed = true;
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.i("VideoShelfPlayView", "onSurfaceTextureSizeChanged.");
    if (initVideoShelfPlayer()) {
      this.mVideoSehlfPlayer.surfaceUpdateSize();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onUpdateRate(long paramLong)
  {
    if (this.mPreparedlistener != null) {
      this.mPreparedlistener.onUpdateRate(paramLong);
    }
  }
  
  public void pause()
  {
    if ((isInPlaybackState()) && (initVideoShelfPlayer()) && (this.mVideoSehlfPlayer.isPlaying()))
    {
      this.mVideoSehlfPlayer.pause();
      this.mCurrentState = 4;
    }
  }
  
  public void resume()
  {
    if (initVideoShelfPlayer()) {
      this.mVideoSehlfPlayer.start();
    }
  }
  
  public void setAudioPath(String paramString)
  {
    if (initVideoShelfPlayer()) {
      this.mVideoSehlfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(false), paramString });
    }
  }
  
  public void setAudioPathFromAsset(String paramString, AssetManager paramAssetManager)
  {
    if (initVideoShelfPlayer()) {
      this.mVideoSehlfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(true), paramAssetManager, paramString });
    }
  }
  
  public void setOnPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener)
  {
    this.mPreparedlistener = paramIVideoShelfPlayerListener;
  }
  
  public void setParam(String paramString, Object... paramVarArgs)
  {
    if (initVideoShelfPlayer()) {
      this.mVideoSehlfPlayer.setParam(paramString, paramVarArgs);
    }
  }
  
  public void setVideoFilePath(String paramString)
  {
    if (initVideoShelfPlayer())
    {
      this.mVideoSehlfPlayer.setDataSource(paramString);
      this.mCurrentState = 1;
      this.mVideoSehlfPlayer.prepare();
    }
  }
  
  public void setVideoFilePathFromAsset(String paramString, AssetManager paramAssetManager)
  {
    if (initVideoShelfPlayer())
    {
      this.mVideoSehlfPlayer.setDataSource(paramAssetManager, paramString);
      this.mCurrentState = 1;
      this.mVideoSehlfPlayer.prepare();
    }
  }
  
  public void setVideoType(boolean paramBoolean)
  {
    this.mIsInited = true;
    this.mIsVideoFile = paramBoolean;
    initVideoShelfPlayer();
  }
  
  public void start()
  {
    if ((isInPlaybackState()) && (this.mPlaySurface != null) && (initVideoShelfPlayer()))
    {
      this.mVideoSehlfPlayer.seekTo(this.mVideoSehlfPlayer.getCurrentPosition());
      this.mVideoSehlfPlayer.start();
      this.mIsNotCalledStart = false;
      this.mCurrentState = 3;
      return;
    }
    this.mIsNotCalledStart = true;
  }
  
  public void stop()
  {
    this.mIsNotCalledStart = false;
    if (initVideoShelfPlayer())
    {
      this.mVideoSehlfPlayer.stop();
      this.mVideoSehlfPlayer.setVideoShelfPlayerListener(null);
    }
    this.mCurrentState = 0;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.mWidthVideo = paramInt1;
    this.mHeightVideo = paramInt2;
    Log.i("VideoShelfPlayer", "call onGlobalLayout.w:" + paramInt1 + ",h:" + paramInt2);
    double d = getAspectRatio();
    if (isHorizontalVideo()) {
      if (d < 3.0D)
      {
        paramInt1 = (int)(getWidth() / d);
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).height = paramInt1;
        setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    while (d <= 0.3333333333333333D) {
      return;
    }
    paramInt1 = (int)(d * getHeight());
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView
 * JD-Core Version:    0.7.0.1
 */