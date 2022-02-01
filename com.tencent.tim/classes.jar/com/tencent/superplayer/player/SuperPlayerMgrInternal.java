package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import java.util.LinkedList;
import java.util.Queue;

class SuperPlayerMgrInternal
{
  private static final int MSG_INDEX = 0;
  private static final int MSG_OPEN_MEDIA_PLAYER = 1;
  private static final int MSG_PAUSE = 13;
  private static final int MSG_PAUSE_DOWNLOAD = 89;
  private static final int MSG_RELEASE = 21;
  private static final int MSG_RESET = 15;
  private static final int MSG_RESUME_DOWNLOAD = 90;
  private static final int MSG_SEEK_TO = 23;
  private static final int MSG_SEEK_TO_BY_MODE = 24;
  private static final int MSG_SET_AUDIO_GAIN_RATIO = 31;
  private static final int MSG_SET_BUSINESS_DOWNLOAD_STRATEGY = 92;
  private static final int MSG_SET_LOOPBACK = 29;
  private static final int MSG_SET_LOOPBACK_WITH_POSITION = 85;
  private static final int MSG_SET_OUTPUT_MUTE = 27;
  private static final int MSG_SET_PLAY_SPEED_RATIO = 9;
  private static final int MSG_SET_SURFACE = 6;
  private static final int MSG_START = 12;
  private static final int MSG_STOP = 14;
  private static final int MSG_SWITCH_DEFINITION = 88;
  private static final int MSG_SWITCH_DEFINITION_FOR_URL = 93;
  private static final int MSG_UPDATE_PLAYER_VIDEO_VIEW = 5;
  private EventHandler mEventHandler;
  private SPlayerManagerInternalListener mHandleListener;
  private volatile boolean mIsNeedBlockMessage = true;
  private volatile boolean mIsReleased = false;
  private String mLogTag;
  private Looper mLooper;
  private Queue<Message> mPendingMessages = new LinkedList();
  
  SuperPlayerMgrInternal(String paramString, Looper paramLooper, SPlayerManagerInternalListener paramSPlayerManagerInternalListener)
  {
    this.mLogTag = paramString;
    this.mLooper = paramLooper;
    this.mEventHandler = new EventHandler(this.mLooper, null);
    this.mHandleListener = paramSPlayerManagerInternalListener;
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        boolean bool = this.mIsReleased;
        if (bool) {
          return;
        }
        localMessage = this.mEventHandler.obtainMessage();
        localMessage.what = paramInt1;
        localMessage.arg1 = paramInt2;
        localMessage.arg2 = paramInt3;
        localMessage.obj = paramObject;
        if (isNeedBlockMessage(paramInt1))
        {
          this.mPendingMessages.offer(localMessage);
          continue;
        }
        if (paramInt1 != 21) {
          break label100;
        }
      }
      finally {}
      this.mIsReleased = true;
      this.mPendingMessages.clear();
      label100:
      this.mEventHandler.sendMessage(localMessage);
      while (!this.mPendingMessages.isEmpty())
      {
        paramObject = (Message)this.mPendingMessages.poll();
        if (paramObject != null) {
          this.mEventHandler.sendMessage(paramObject);
        }
      }
    }
  }
  
  private void internalMessage(int paramInt, Object paramObject)
  {
    internalMessage(paramInt, 0, 0, paramObject);
  }
  
  private boolean isNeedBlockMessage(int paramInt)
  {
    if (this.mIsNeedBlockMessage) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return this.mIsNeedBlockMessage;
      this.mIsNeedBlockMessage = false;
    }
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mHandleListener.handleAddSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mHandleListener.handleDeselectTrack(paramInt, paramLong);
  }
  
  int getBufferPercent()
  {
    return this.mHandleListener.handleGetBufferPercent();
  }
  
  long getCurrentPositionMs()
  {
    return this.mHandleListener.handleGetCurrentPosition();
  }
  
  long getDurationMs()
  {
    return this.mHandleListener.handleGetDuration();
  }
  
  public long getFileSizeBytes()
  {
    return this.mHandleListener.handleGetFileSizeBytes();
  }
  
  MediaInfo getMediaInfo()
  {
    return this.mHandleListener.handleGetMediaInfo();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mHandleListener.handleGetProgramInfo();
  }
  
  String getStreamDumpInfo()
  {
    return this.mHandleListener.handleGetStreamDumpInfo();
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mHandleListener.handleGetTrackInfo();
  }
  
  int getVideoHeight()
  {
    return this.mHandleListener.handleGetVideoHeight();
  }
  
  int getVideoRotation()
  {
    return this.mHandleListener.handleGetVideoRotation();
  }
  
  int getVideoWidth()
  {
    return this.mHandleListener.handleGetVideoWidth();
  }
  
  boolean isBuffering()
  {
    return this.mHandleListener.handleIsBuffering();
  }
  
  void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    SuperPlayerMgrCommons.OpenMediaParams localOpenMediaParams = new SuperPlayerMgrCommons.OpenMediaParams();
    localOpenMediaParams.context = paramContext;
    localOpenMediaParams.videoInfo = paramSuperPlayerVideoInfo;
    localOpenMediaParams.startPositionMilsec = paramLong;
    localOpenMediaParams.playerOption = paramSuperPlayerOption;
    internalMessage(1, localOpenMediaParams);
  }
  
  void pause()
  {
    internalMessage(13, null);
  }
  
  void pauseDownload()
  {
    internalMessage(89, null);
  }
  
  void release()
  {
    internalMessage(21, null);
  }
  
  void reset()
  {
    internalMessage(15, null);
  }
  
  void resumeDownload()
  {
    internalMessage(90, null);
  }
  
  void seekTo(int paramInt)
  {
    internalMessage(23, paramInt, 0, null);
  }
  
  void seekTo(int paramInt1, int paramInt2)
  {
    internalMessage(24, paramInt1, paramInt2, null);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mHandleListener.handleSelectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mHandleListener.handleSelectTrack(paramInt, paramLong);
  }
  
  void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    internalMessage(92, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
  }
  
  void setIsNeedBlockMessage(boolean paramBoolean)
  {
    try
    {
      this.mIsNeedBlockMessage = paramBoolean;
      if (!this.mIsNeedBlockMessage) {
        while (!this.mPendingMessages.isEmpty())
        {
          Message localMessage = (Message)this.mPendingMessages.poll();
          if (localMessage != null) {
            this.mEventHandler.sendMessage(localMessage);
          }
        }
      }
    }
    finally {}
  }
  
  void setLoopback(boolean paramBoolean)
  {
    internalMessage(29, Boolean.valueOf(paramBoolean));
  }
  
  void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    SuperPlayerMgrCommons.LoopbackParams localLoopbackParams = new SuperPlayerMgrCommons.LoopbackParams();
    localLoopbackParams.isLoopback = paramBoolean;
    localLoopbackParams.loopStartPositionMs = paramLong1;
    localLoopbackParams.loopEndPositionMs = paramLong2;
    internalMessage(85, localLoopbackParams);
  }
  
  void setOutputMute(boolean paramBoolean)
  {
    internalMessage(27, Boolean.valueOf(paramBoolean));
  }
  
  void setPlaySpeedRatio(float paramFloat)
  {
    internalMessage(9, Float.valueOf(paramFloat));
  }
  
  void setSurface(Surface paramSurface)
  {
    internalMessage(6, paramSurface);
  }
  
  void start()
  {
    internalMessage(12, null);
  }
  
  void stop()
  {
    internalMessage(14, null);
  }
  
  void switchDefinition(String paramString, int paramInt)
  {
    SuperPlayerMgrCommons.SwitchDefnParams localSwitchDefnParams = new SuperPlayerMgrCommons.SwitchDefnParams();
    localSwitchDefnParams.defn = paramString;
    localSwitchDefnParams.mode = paramInt;
    internalMessage(88, localSwitchDefnParams);
  }
  
  void switchDefinitionForUrl(String paramString, int paramInt)
  {
    SuperPlayerMgrCommons.SwitchDefnForUrlParams localSwitchDefnForUrlParams = new SuperPlayerMgrCommons.SwitchDefnForUrlParams();
    localSwitchDefnForUrlParams.url = paramString;
    localSwitchDefnForUrlParams.mode = paramInt;
    internalMessage(93, localSwitchDefnForUrlParams);
  }
  
  void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    internalMessage(5, paramISPlayerVideoView);
  }
  
  class EventHandler
    extends Handler
  {
    private EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (SuperPlayerMgrInternal.this.mHandleListener == null)
      {
        LogUtil.e(SuperPlayerMgrInternal.this.mLogTag, "handle listener is null, return");
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        paramMessage = (SuperPlayerMgrCommons.OpenMediaParams)paramMessage.obj;
        SuperPlayerMgrInternal.this.mHandleListener.handleOpenMediaPlayer(paramMessage.context, paramMessage.videoInfo, paramMessage.startPositionMilsec, paramMessage.playerOption);
        return;
      case 5: 
        SuperPlayerMgrInternal.this.mHandleListener.handleUpdatePlayerVideoView((ISPlayerVideoView)paramMessage.obj);
        return;
      case 6: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSetSurface((Surface)paramMessage.obj);
        return;
      case 9: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSetPlaySpeedRatio(((Float)paramMessage.obj).floatValue());
        return;
      case 12: 
        SuperPlayerMgrInternal.this.mHandleListener.handleStart();
        return;
      case 13: 
        SuperPlayerMgrInternal.this.mHandleListener.handlePause();
        return;
      case 14: 
        SuperPlayerMgrInternal.this.mHandleListener.handleStop();
        return;
      case 15: 
        SuperPlayerMgrInternal.this.mHandleListener.handleReset();
        return;
      case 21: 
        SuperPlayerMgrInternal.this.mHandleListener.handleRelease();
        return;
      case 23: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSeekTo(paramMessage.arg1);
        return;
      case 24: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSeekTo(paramMessage.arg1, paramMessage.arg2);
        return;
      case 27: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSetOutputMute(((Boolean)paramMessage.obj).booleanValue());
        return;
      case 29: 
        SuperPlayerMgrInternal.this.mHandleListener.handleSetLoopback(((Boolean)paramMessage.obj).booleanValue());
        return;
      case 85: 
        paramMessage = (SuperPlayerMgrCommons.LoopbackParams)paramMessage.obj;
        SuperPlayerMgrInternal.this.mHandleListener.handleSetLoopback(paramMessage.isLoopback, paramMessage.loopStartPositionMs, paramMessage.loopEndPositionMs);
        return;
      case 88: 
        paramMessage = (SuperPlayerMgrCommons.SwitchDefnParams)paramMessage.obj;
        SuperPlayerMgrInternal.this.mHandleListener.handleSwitchDefinition(paramMessage.defn, paramMessage.mode);
        return;
      case 93: 
        paramMessage = (SuperPlayerMgrCommons.SwitchDefnForUrlParams)paramMessage.obj;
        SuperPlayerMgrInternal.this.mHandleListener.handleSwitchDefinitionForUrl(paramMessage.url, paramMessage.mode);
        return;
      case 89: 
        SuperPlayerMgrInternal.this.mHandleListener.handlePauseDownload();
        return;
      case 90: 
        SuperPlayerMgrInternal.this.mHandleListener.handleResumeDownload();
        return;
      }
      paramMessage = (int[])paramMessage.obj;
      SuperPlayerMgrInternal.this.mHandleListener.handleSetBusinessDownloadStrategy(paramMessage[0], paramMessage[1], paramMessage[2], paramMessage[3]);
    }
  }
  
  static abstract interface SPlayerManagerInternalListener
  {
    public abstract void handleAddSubtitleSource(String paramString1, String paramString2, String paramString3);
    
    public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2);
    
    public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void handleDeselectTrack(int paramInt, long paramLong);
    
    public abstract int handleGetBufferPercent();
    
    public abstract long handleGetCurrentPosition();
    
    public abstract long handleGetDuration();
    
    public abstract long handleGetFileSizeBytes();
    
    public abstract MediaInfo handleGetMediaInfo();
    
    public abstract TPProgramInfo[] handleGetProgramInfo();
    
    public abstract String handleGetStreamDumpInfo();
    
    public abstract TPTrackInfo[] handleGetTrackInfo();
    
    public abstract int handleGetVideoHeight();
    
    public abstract int handleGetVideoRotation();
    
    public abstract int handleGetVideoWidth();
    
    public abstract boolean handleIsBuffering();
    
    public abstract void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption);
    
    public abstract void handlePause();
    
    public abstract void handlePauseDownload();
    
    public abstract void handleRelease();
    
    public abstract void handleReset();
    
    public abstract void handleResumeDownload();
    
    public abstract void handleSeekTo(int paramInt);
    
    public abstract void handleSeekTo(int paramInt1, int paramInt2);
    
    public abstract void handleSelectProgram(int paramInt, long paramLong);
    
    public abstract void handleSelectTrack(int paramInt, long paramLong);
    
    public abstract void handleSetBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void handleSetLoopback(boolean paramBoolean);
    
    public abstract void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract boolean handleSetOutputMute(boolean paramBoolean);
    
    public abstract void handleSetPlaySpeedRatio(float paramFloat);
    
    public abstract void handleSetSurface(Surface paramSurface);
    
    public abstract void handleStart();
    
    public abstract void handleStop();
    
    public abstract void handleSwitchDefinition(String paramString, int paramInt);
    
    public abstract void handleSwitchDefinitionForUrl(String paramString, int paramInt);
    
    public abstract void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal
 * JD-Core Version:    0.7.0.1
 */