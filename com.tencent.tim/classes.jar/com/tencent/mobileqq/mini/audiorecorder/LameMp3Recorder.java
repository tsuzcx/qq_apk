package com.tencent.mobileqq.mini.audiorecorder;

import acfp;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LameMp3Recorder
{
  public static final int MSG_PLAY_ERROR = -11;
  public static final int MSG_PLAY_FINISH = 106;
  public static final int MSG_PLAY_PAUSE = 102;
  public static final int MSG_PLAY_RESUME = 103;
  public static final int MSG_PLAY_START = 101;
  public static final int MSG_PLAY_STOP = 105;
  public static final int MSG_PLAY_UPDATE = 104;
  public static final int MSG_RECORD_ERROR = -10;
  public static final int MSG_RECORD_FRAME = 6;
  public static final int MSG_RECORD_PAUSE = 2;
  public static final int MSG_RECORD_RESUME = 3;
  public static final int MSG_RECORD_START = 1;
  public static final int MSG_RECORD_STOP = 5;
  public static final int MSG_RECORD_UPDATE = 4;
  public static final String TAG = LameMp3Recorder.class.getName();
  private final AudioManager mAudioManger;
  private AudioRecordListener mAudioRecordListener;
  private int mCallbackFrameSize = 50;
  private int mCallbackTime = 500;
  private final LameMp3EncodeThread mEncodeThread = new LameMp3EncodeThread(this, this.mMainHandler);
  private final Handler mMainHandler = new MHandler(this);
  private int mMaxRecordTime = 30;
  private long mPauseTime;
  private List<Integer> mPauseTimeList = new ArrayList();
  private long mStartPlayTime;
  private long mStartTime;
  private OnErrorListener onErrorListener;
  private AudioPlayerListener onPlayListener;
  
  public LameMp3Recorder(Context paramContext)
  {
    this.mAudioManger = ((AudioManager)paramContext.getSystemService("audio"));
  }
  
  private void callOnRecordStop()
  {
    if (this.mAudioRecordListener != null) {
      this.mAudioRecordListener.onRecordStop(getRecordFilPath(), getRecordDuration(), getRecordFileSize());
    }
    if (this.mMainHandler.hasMessages(4)) {
      this.mMainHandler.removeMessages(4);
    }
  }
  
  public static Message generatePlayErrMsg(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -11;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  public static Message generateRecordErrMsg(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -10;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  public AudioRecordListener getAudioRecordListener()
  {
    return this.mAudioRecordListener;
  }
  
  public int getCallbackFrameSize()
  {
    return this.mCallbackFrameSize;
  }
  
  public int getCallbackTime()
  {
    return this.mCallbackTime;
  }
  
  public int getMaxRecordTime()
  {
    return this.mMaxRecordTime;
  }
  
  public int getPlayTime()
  {
    return (int)((System.currentTimeMillis() - this.mStartPlayTime) / 1000L);
  }
  
  public long getRecordDuration()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    Iterator localIterator = this.mPauseTimeList.iterator();
    for (l1 -= l2; localIterator.hasNext(); l1 -= ((Integer)localIterator.next()).intValue()) {}
    return l1;
  }
  
  public String getRecordFilPath()
  {
    return this.mEncodeThread.getRecordFilPath();
  }
  
  public long getRecordFileSize()
  {
    return new File(getRecordFilPath()).length();
  }
  
  public long getRecordTime()
  {
    return this.mEncodeThread.getRecordTime();
  }
  
  public int getTime()
  {
    return (int)(getRecordDuration() / 1000L);
  }
  
  public int getVoiceLevel()
  {
    return this.mEncodeThread.getVoiceLevel();
  }
  
  public boolean isPause()
  {
    if (!this.mEncodeThread.isRecording()) {
      return false;
    }
    return this.mEncodeThread.isPause();
  }
  
  public boolean isRecording()
  {
    return this.mEncodeThread.isRecording();
  }
  
  public void onDestory()
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.onDestory();
    }
  }
  
  public void playPause()
  {
    if (this.mEncodeThread.playPause()) {
      this.mMainHandler.sendEmptyMessage(102);
    }
  }
  
  public void playResume()
  {
    if (this.mEncodeThread.playResume()) {
      this.mMainHandler.sendEmptyMessage(103);
    }
  }
  
  public void playStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(TAG, 2, "请先设置音频播放路径");
      return;
    }
    this.mEncodeThread.setFilePlayPath(paramString);
    this.mEncodeThread.play();
  }
  
  public void playStop()
  {
    if (this.mEncodeThread.stopPlay()) {
      this.mMainHandler.sendEmptyMessage(105);
    }
  }
  
  public void recordPause()
  {
    if (this.mEncodeThread.isPause()) {
      return;
    }
    if (getTime() < 1)
    {
      this.mMainHandler.sendMessage(generateRecordErrMsg(acfp.m(2131707624)));
      recordStop();
    }
    this.mPauseTime = System.currentTimeMillis();
    this.mEncodeThread.setPause(true);
    this.mMainHandler.sendEmptyMessage(2);
  }
  
  public void recordResume()
  {
    if (!this.mEncodeThread.isPause()) {
      return;
    }
    int i = (int)(System.currentTimeMillis() - this.mPauseTime);
    if (i > 0) {
      this.mPauseTimeList.add(Integer.valueOf(i));
    }
    this.mEncodeThread.setPause(false);
    this.mMainHandler.sendEmptyMessage(3);
  }
  
  public void recordStart()
  {
    this.mPauseTimeList.clear();
    this.mEncodeThread.startRecord();
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void recordStop()
  {
    if (this.mEncodeThread.isRecording()) {
      this.mEncodeThread.restoreRecording();
    }
  }
  
  public void setAudioRecordListener(AudioRecordListener paramAudioRecordListener)
  {
    this.mAudioRecordListener = paramAudioRecordListener;
  }
  
  public void setAudioSource(String paramString)
  {
    this.mEncodeThread.setAudioSource(paramString);
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
    this.mEncodeThread.setCallbackFrameSize(paramInt);
  }
  
  public void setCallbackTime(int paramInt)
  {
    this.mCallbackTime = paramInt;
  }
  
  public void setEncodingPcmFormat(int paramInt)
  {
    this.mEncodeThread.setEncodingPcmFormat(paramInt);
  }
  
  public void setInSampleRate(int paramInt)
  {
    this.mEncodeThread.setInSampleRate(paramInt);
  }
  
  public void setMaxRecordTime(int paramInt)
  {
    this.mMaxRecordTime = paramInt;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void setOnPlayListener(AudioPlayerListener paramAudioPlayerListener)
  {
    this.onPlayListener = paramAudioPlayerListener;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mEncodeThread.setOutBitRate(paramInt);
  }
  
  public void setOutChannel(int paramInt)
  {
    this.mEncodeThread.setOutChannel(paramInt);
  }
  
  public void setOutSampleRate(int paramInt)
  {
    this.mEncodeThread.setOutSampleRate(paramInt);
  }
  
  public void setPlayMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAudioManger.setSpeakerphoneOn(false);
      this.mAudioManger.setMode(3);
      this.mEncodeThread.getMediaPlayer().setAudioStreamType(0);
      return;
    }
    this.mAudioManger.setMode(0);
    this.mAudioManger.setSpeakerphoneOn(true);
    this.mEncodeThread.getMediaPlayer().setAudioStreamType(3);
  }
  
  public void setQuality(int paramInt)
  {
    this.mEncodeThread.setQuality(paramInt);
  }
  
  public void setRecordFilPath(String paramString)
  {
    this.mEncodeThread.setRecordFilPath(paramString);
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mEncodeThread.setRecordFileFormat(paramString);
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mEncodeThread.setRecordTime(paramLong);
  }
  
  public void setSampleRate(int paramInt)
  {
    setInSampleRate(paramInt);
  }
  
  public static abstract interface AudioPlayerListener
  {
    public abstract void onPlayFinish();
    
    public abstract void onPlayPause();
    
    public abstract void onPlayResume();
    
    public abstract void onPlayStart();
    
    public abstract void onPlayStop();
    
    public abstract void onPlayUpdate(int paramInt1, int paramInt2);
  }
  
  public static abstract interface AudioRecordListener
  {
    public abstract void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void onRecordPause();
    
    public abstract void onRecordResume();
    
    public abstract void onRecordStart();
    
    public abstract void onRecordStop(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onRecordUpdate(int paramInt1, int paramInt2);
  }
  
  static class MHandler
    extends Handler
  {
    int level = 1;
    private final WeakReference<LameMp3Recorder> recorder;
    
    public MHandler(LameMp3Recorder paramLameMp3Recorder)
    {
      this.recorder = new WeakReference(paramLameMp3Recorder);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      LameMp3Recorder localLameMp3Recorder;
      if ((this.recorder != null) && (this.recorder.get() != null))
      {
        localLameMp3Recorder = (LameMp3Recorder)this.recorder.get();
        switch (paramMessage.what)
        {
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            paramMessage = (String)paramMessage.obj;
                            if ((!TextUtils.isEmpty(paramMessage)) && (localLameMp3Recorder.onErrorListener != null)) {
                              localLameMp3Recorder.onErrorListener.onErrorInfo(paramMessage);
                            }
                          } while (!hasMessages(4));
                          removeMessages(4);
                          return;
                          paramMessage = (String)paramMessage.obj;
                          if ((!TextUtils.isEmpty(paramMessage)) && (localLameMp3Recorder.onErrorListener != null)) {
                            localLameMp3Recorder.onErrorListener.onErrorInfo(paramMessage);
                          }
                          if (hasMessages(104)) {
                            removeMessages(104);
                          }
                          if ((!TextUtils.isEmpty(paramMessage)) && (localLameMp3Recorder.onErrorListener != null)) {
                            localLameMp3Recorder.onErrorListener.onErrorInfo(paramMessage);
                          }
                        } while (!hasMessages(104));
                        removeMessages(104);
                        return;
                        if (localLameMp3Recorder.mAudioRecordListener != null) {
                          localLameMp3Recorder.mAudioRecordListener.onRecordStart();
                        }
                      } while (hasMessages(4));
                      sendEmptyMessage(4);
                      return;
                      if (localLameMp3Recorder.mAudioRecordListener != null) {
                        localLameMp3Recorder.mAudioRecordListener.onRecordPause();
                      }
                    } while (!hasMessages(4));
                    removeMessages(4);
                    return;
                    if (localLameMp3Recorder.mAudioRecordListener != null) {
                      localLameMp3Recorder.mAudioRecordListener.onRecordResume();
                    }
                  } while (localLameMp3Recorder.mMainHandler.hasMessages(4));
                  localLameMp3Recorder.mMainHandler.sendEmptyMessage(4);
                  return;
                  if (localLameMp3Recorder.mAudioRecordListener != null) {
                    localLameMp3Recorder.mAudioRecordListener.onRecordStop(localLameMp3Recorder.getRecordFilPath(), localLameMp3Recorder.getRecordDuration(), localLameMp3Recorder.getRecordFileSize());
                  }
                } while (!hasMessages(4));
                removeMessages(4);
                return;
              } while (localLameMp3Recorder.mAudioRecordListener == null);
              byte[] arrayOfByte = (byte[])paramMessage.obj;
              if (paramMessage.arg1 == 1) {}
              for (;;)
              {
                localLameMp3Recorder.mAudioRecordListener.onRecordFrame(arrayOfByte, bool);
                return;
                bool = false;
              }
              if (hasMessages(4)) {
                removeMessages(4);
              }
              int i = localLameMp3Recorder.getTime();
              int j = localLameMp3Recorder.getVoiceLevel();
              if (localLameMp3Recorder.mAudioRecordListener != null) {
                localLameMp3Recorder.mAudioRecordListener.onRecordUpdate(j, i);
              }
              if (i == localLameMp3Recorder.mMaxRecordTime)
              {
                localLameMp3Recorder.mEncodeThread.restoreRecording();
                return;
              }
              sendEmptyMessageDelayed(4, localLameMp3Recorder.getMaxRecordTime());
              return;
              if (hasMessages(104)) {
                removeMessages(104);
              }
              i = (int)(System.currentTimeMillis() - localLameMp3Recorder.mStartPlayTime);
              this.level += 1;
              if (this.level > 5) {
                this.level = 1;
              }
              if (localLameMp3Recorder.onPlayListener != null) {
                localLameMp3Recorder.onPlayListener.onPlayUpdate(this.level, i / 1000);
              }
              sendEmptyMessageDelayed(104, localLameMp3Recorder.getMaxRecordTime());
              return;
              if (localLameMp3Recorder.onPlayListener != null) {
                localLameMp3Recorder.onPlayListener.onPlayStart();
              }
              LameMp3Recorder.access$502(localLameMp3Recorder, System.currentTimeMillis());
              sendEmptyMessageDelayed(104, localLameMp3Recorder.getMaxRecordTime());
              return;
              if (localLameMp3Recorder.onPlayListener != null) {
                localLameMp3Recorder.onPlayListener.onPlayPause();
              }
            } while (!hasMessages(104));
            removeMessages(104);
            return;
            if (localLameMp3Recorder.onPlayListener != null) {
              localLameMp3Recorder.onPlayListener.onPlayResume();
            }
          } while (hasMessages(104));
          sendEmptyMessage(104);
          return;
          if (localLameMp3Recorder.onPlayListener != null) {
            localLameMp3Recorder.onPlayListener.onPlayStop();
          }
        } while (!hasMessages(104));
        removeMessages(104);
        return;
        if (localLameMp3Recorder.onPlayListener != null) {
          localLameMp3Recorder.onPlayListener.onPlayFinish();
        }
      } while (!hasMessages(104));
      removeMessages(104);
    }
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onErrorInfo(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder
 * JD-Core Version:    0.7.0.1
 */