package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

class SuperPlayerListenerCallBack
  implements ListenerCombine.ISuperPlayerCombine
{
  private static final int ON_CAPTURE_IMAGE_FAILED = 7;
  private static final int ON_CAPTURE_IMAGE_SUCCEED = 6;
  private static final int ON_COMPLETION = 4;
  private static final int ON_DEFINITION_INFO_UPDATE = 9;
  private static final int ON_ERROR = 2;
  private static final int ON_INFO = 3;
  private static final int ON_SEEK_COMPLETE = 5;
  private static final int ON_TVIDEO_NETINFO_UPDATE = 10;
  private static final int ON_VIDEO_PREPARED = 1;
  private static final int ON_VIDEO_SIZE_CHANGED = 8;
  private CallBackEventHandler mCallBackEventHandler;
  private AtomicBoolean mIsBlockCallback = new AtomicBoolean(false);
  private WeakReference<SuperPlayerListenerMgr> mListenerMgrWeakReference;
  private Queue<Message> mMessageQueue = new LinkedList();
  private WeakReference<ISuperPlayer> mPlayerWeakReference;
  
  SuperPlayerListenerCallBack(ISuperPlayer paramISuperPlayer, SuperPlayerListenerMgr paramSuperPlayerListenerMgr, Looper paramLooper)
  {
    this.mPlayerWeakReference = new WeakReference(paramISuperPlayer);
    this.mListenerMgrWeakReference = new WeakReference(paramSuperPlayerListenerMgr);
    this.mCallBackEventHandler = new CallBackEventHandler(paramLooper);
  }
  
  private void handleOnAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onAudioFrameOutput(paramTPAudioFrameBuffer);
    }
  }
  
  private void handleOnCaptureImageFailed(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCaptureImageFailed(localISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  private void handleOnCaptureImageSucceed(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCaptureImageSucceed(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  private void handleOnCompletion()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCompletion(localISuperPlayer);
    }
  }
  
  private void handleOnDefinitionUpdate(String paramString, ArrayList<String> paramArrayList)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((paramArrayList != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onDefinitionInfoUpdate(localISuperPlayer, paramString, paramArrayList);
    }
  }
  
  private boolean handleOnError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      return localSuperPlayerListenerMgr.onError(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  private boolean handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      return localSuperPlayerListenerMgr.onInfo(localISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  private void handleOnSeekComplete()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onSeekComplete(localISuperPlayer);
    }
  }
  
  private void handleOnTVideoNetInfoUpdate(TVideoNetInfo paramTVideoNetInfo)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((paramTVideoNetInfo != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onTVideoNetInfoUpdate(localISuperPlayer, paramTVideoNetInfo);
    }
  }
  
  private void handleOnVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoFrameOutput(paramTPVideoFrameBuffer);
    }
  }
  
  private void handleOnVideoPrepared()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoPrepared(localISuperPlayer);
    }
  }
  
  private void handleOnVideoSizeChanged(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoSizeChanged(localISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  /* Error */
  private void internalMessage(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/superplayer/player/SuperPlayerListenerCallBack:mCallBackEventHandler	Lcom/tencent/superplayer/player/SuperPlayerListenerCallBack$CallBackEventHandler;
    //   6: iload_1
    //   7: aload_2
    //   8: invokestatic 210	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 77	com/tencent/superplayer/player/SuperPlayerListenerCallBack:mIsBlockCallback	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   16: invokevirtual 213	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   19: ifeq +17 -> 36
    //   22: aload_0
    //   23: getfield 70	com/tencent/superplayer/player/SuperPlayerListenerCallBack:mMessageQueue	Ljava/util/Queue;
    //   26: aload_2
    //   27: invokeinterface 219 2 0
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_2
    //   37: invokevirtual 222	android/os/Message:sendToTarget	()V
    //   40: goto -7 -> 33
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SuperPlayerListenerCallBack
    //   0	48	1	paramInt	int
    //   0	48	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	43	finally
    //   36	40	43	finally
  }
  
  public ISuperPlayer getPlayer()
  {
    if ((this.mPlayerWeakReference != null) && (this.mPlayerWeakReference.get() != null)) {
      return (ISuperPlayer)this.mPlayerWeakReference.get();
    }
    return null;
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    handleOnAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = new OnCaptureImageFailedParams(null);
    paramISuperPlayer.id = paramInt1;
    paramISuperPlayer.errCode = paramInt2;
    internalMessage(7, paramISuperPlayer);
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramISuperPlayer = new OnCaptureImageSucceeParams(null);
    paramISuperPlayer.id = paramInt1;
    paramISuperPlayer.width = paramInt2;
    paramISuperPlayer.height = paramInt3;
    paramISuperPlayer.bitmap = paramBitmap;
    internalMessage(6, paramISuperPlayer);
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    internalMessage(4, null);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    paramISuperPlayer = new OnDefinitionInfoParams(null);
    paramISuperPlayer.currentDefinition = paramString;
    paramISuperPlayer.definitionList = paramArrayList;
    internalMessage(9, paramISuperPlayer);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new OnErrorParams(null);
    paramISuperPlayer.module = paramInt1;
    paramISuperPlayer.errorType = paramInt2;
    paramISuperPlayer.errorCode = paramInt3;
    paramISuperPlayer.extraInfo = paramString;
    internalMessage(2, paramISuperPlayer);
    return true;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new OnInfoParams(null);
    paramISuperPlayer.what = paramInt;
    paramISuperPlayer.arg1 = paramLong1;
    paramISuperPlayer.arg2 = paramLong2;
    paramISuperPlayer.extra = paramObject;
    internalMessage(3, paramISuperPlayer);
    return true;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    internalMessage(5, null);
  }
  
  public void onSubtitleData(ISuperPlayer paramISuperPlayer, TPSubtitleData paramTPSubtitleData)
  {
    paramISuperPlayer = (ISuperPlayer)this.mPlayerWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((paramTPSubtitleData != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onSubtitleData(paramISuperPlayer, paramTPSubtitleData);
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    internalMessage(10, paramTVideoNetInfo);
  }
  
  public void onVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    handleOnVideoFrameOutput(paramTPVideoFrameBuffer);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    internalMessage(1, null);
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = new OnVideoSizeParams(null);
    paramISuperPlayer.width = paramInt1;
    paramISuperPlayer.height = paramInt2;
    internalMessage(8, paramISuperPlayer);
  }
  
  void setIsBlockCallback(boolean paramBoolean)
  {
    try
    {
      this.mIsBlockCallback.set(paramBoolean);
      if ((!paramBoolean) && (!this.mMessageQueue.isEmpty())) {
        while (!this.mMessageQueue.isEmpty())
        {
          Message localMessage = (Message)this.mMessageQueue.poll();
          if (localMessage != null) {
            this.mCallBackEventHandler.sendMessage(localMessage);
          }
        }
      }
    }
    finally {}
  }
  
  class CallBackEventHandler
    extends Handler
  {
    public CallBackEventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        SuperPlayerListenerCallBack.this.handleOnVideoPrepared();
        return;
      case 2: 
        paramMessage = (SuperPlayerListenerCallBack.OnErrorParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnError(paramMessage.module, paramMessage.errorType, paramMessage.errorCode, paramMessage.extraInfo);
        return;
      case 3: 
        paramMessage = (SuperPlayerListenerCallBack.OnInfoParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnInfo(paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.extra);
        return;
      case 4: 
        SuperPlayerListenerCallBack.this.handleOnCompletion();
        return;
      case 5: 
        SuperPlayerListenerCallBack.this.handleOnSeekComplete();
        return;
      case 6: 
        paramMessage = (SuperPlayerListenerCallBack.OnCaptureImageSucceeParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnCaptureImageSucceed(paramMessage.id, paramMessage.width, paramMessage.height, paramMessage.bitmap);
        return;
      case 7: 
        paramMessage = (SuperPlayerListenerCallBack.OnCaptureImageFailedParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnCaptureImageFailed(paramMessage.id, paramMessage.errCode);
        return;
      case 8: 
        paramMessage = (SuperPlayerListenerCallBack.OnVideoSizeParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnVideoSizeChanged(paramMessage.width, paramMessage.height);
        return;
      case 9: 
        paramMessage = (SuperPlayerListenerCallBack.OnDefinitionInfoParams)paramMessage.obj;
        SuperPlayerListenerCallBack.this.handleOnDefinitionUpdate(paramMessage.currentDefinition, paramMessage.definitionList);
        return;
      }
      SuperPlayerListenerCallBack.this.handleOnTVideoNetInfoUpdate((TVideoNetInfo)paramMessage.obj);
    }
  }
  
  static class OnCaptureImageFailedParams
  {
    int errCode;
    int id;
  }
  
  static class OnCaptureImageSucceeParams
  {
    Bitmap bitmap;
    int height;
    int id;
    int width;
  }
  
  static class OnDefinitionInfoParams
  {
    String currentDefinition;
    ArrayList<String> definitionList;
  }
  
  static class OnErrorParams
  {
    int errorCode;
    int errorType;
    String extraInfo;
    int module;
  }
  
  static class OnInfoParams
  {
    long arg1;
    long arg2;
    Object extra;
    int what;
  }
  
  static class OnVideoSizeParams
  {
    int height;
    int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerListenerCallBack
 * JD-Core Version:    0.7.0.1
 */