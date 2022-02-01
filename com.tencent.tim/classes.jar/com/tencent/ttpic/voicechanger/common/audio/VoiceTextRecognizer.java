package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceTextRecognizer
{
  private static final int STATE_CREATED = 0;
  private static final int STATE_DESTROYED = 3;
  private static final int STATE_ERROR = 4;
  private static final int STATE_INITED = 1;
  private static final int STATE_STARTED = 2;
  private static final String TAG = VoiceTextRecognizer.class.getSimpleName();
  private static String WX_VOICE_RECOGNIZER_APPID = "WXARS1340SNG1518003481_56355";
  private static final VoiceTextRecognizer sInstance = new VoiceTextRecognizer();
  protected HandlerThread handlerThread;
  private Handler mHandler;
  private VRListener mListener = new VRListener();
  private int mState = 0;
  private VRErrorListener mVRErrorListener;
  private VTChangeListener mVTListener;
  
  public static VoiceTextRecognizer getInstance()
  {
    try
    {
      VoiceTextRecognizer localVoiceTextRecognizer = sInstance;
      return localVoiceTextRecognizer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setWxVoiceRecognizerAppid(String paramString)
  {
    WX_VOICE_RECOGNIZER_APPID = paramString;
  }
  
  public void destroy()
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VoiceTextRecognizer.3(this));
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    if ((this.mState == 1) || (this.mState == 2)) {
      LogUtils.e(TAG, "mState == STATE_INITED || mState == STATE_STARTED");
    }
    do
    {
      return;
      if (this.mHandler == null)
      {
        if (this.handlerThread == null)
        {
          this.handlerThread = new HandlerThread("VIDEO_TEXT_RECOGNIZER_" + System.currentTimeMillis());
          this.handlerThread.start();
        }
        if (this.handlerThread.getLooper() != null) {
          this.mHandler = new Handler(this.handlerThread.getLooper());
        }
      }
    } while (this.mHandler == null);
    this.mHandler.post(new VoiceTextRecognizer.1(this, paramBoolean, paramContext));
  }
  
  public void recognizeFromPCMBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mState != 2) {
      return;
    }
    VoiceRecognizer.shareInstance().appendData(paramArrayOfByte, 0, paramInt, false);
  }
  
  public void setVRErrorListener(VRErrorListener paramVRErrorListener)
  {
    this.mVRErrorListener = paramVRErrorListener;
  }
  
  public void setVoiceTextListener(VTChangeListener paramVTChangeListener)
  {
    this.mVTListener = paramVTChangeListener;
  }
  
  public void start()
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VoiceTextRecognizer.2(this));
  }
  
  static enum ErrorCode
  {
    SO_NOT_LOAD(-1000);
    
    public final int value;
    
    private ErrorCode(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface VRErrorListener
  {
    public abstract void onError(int paramInt);
  }
  
  public class VRListener
    implements VoiceRecognizerListener
  {
    public VRListener() {}
    
    public void onGetError(int paramInt)
    {
      LogUtils.e(VoiceTextRecognizer.TAG, "onGetError, errorCode = " + paramInt);
      if (VoiceTextRecognizer.this.mVTListener != null) {
        VoiceTextRecognizer.this.mVTListener.onError(paramInt);
      }
      if (VoiceTextRecognizer.this.mVRErrorListener != null) {
        VoiceTextRecognizer.this.mVRErrorListener.onError(paramInt);
      }
      VoiceTextRecognizer.access$402(VoiceTextRecognizer.this, 4);
    }
    
    public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
    {
      LogUtils.e(VoiceTextRecognizer.TAG, "onGetResult, text = " + paramVoiceRecognizerResult.text);
      if (VoiceTextRecognizer.this.mVTListener != null)
      {
        VoiceTextRecognizer.this.mVTListener.onVTChanged(paramVoiceRecognizerResult.text);
        if (paramVoiceRecognizerResult.isEnd) {
          VoiceTextRecognizer.this.mVTListener.onVTChanged("");
        }
      }
    }
    
    public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
    
    public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
    
    public void onVolumeChanged(int paramInt) {}
  }
  
  public static abstract interface VTChangeListener
  {
    public abstract void onError(int paramInt);
    
    public abstract void onVTChanged(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer
 * JD-Core Version:    0.7.0.1
 */