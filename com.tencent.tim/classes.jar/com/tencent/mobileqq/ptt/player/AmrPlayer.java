package com.tencent.mobileqq.ptt.player;

import alin;
import alio;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import anpc;
import auru;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AmrPlayer
  implements alin, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback
{
  private alio jdField_a_of_type_Alio;
  private AmrPlayerThread jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread;
  private auru b;
  private AtomicBoolean dC = new AtomicBoolean(false);
  private String mFilePath;
  private MediaPlayer mPlayer;
  private int mSeekToTime = -1;
  Runnable task = new AmrPlayer.1(this);
  
  public AmrPlayer()
  {
    this.mPlayer = new MediaPlayer();
    this.b = new auru(Looper.getMainLooper(), this);
  }
  
  public AmrPlayer(Context paramContext, int paramInt)
  {
    this.mPlayer = MediaPlayer.create(paramContext, paramInt);
    this.b = new auru(this);
  }
  
  public void a(int paramInt, byte paramByte) {}
  
  public void a(alio paramalio)
  {
    this.jdField_a_of_type_Alio = paramalio;
  }
  
  public void ao(float paramFloat) {}
  
  public void bvB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr reStart");
    }
    this.mPlayer.setOnCompletionListener(this);
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnErrorListener(this);
    ThreadManager.post(this.task, 5, null, false);
  }
  
  public int getCurrentPosition()
  {
    if (!this.dC.get()) {
      return 0;
    }
    return this.mPlayer.getCurrentPosition();
  }
  
  public int getDuration()
  {
    if (!this.dC.get()) {
      return 0;
    }
    return this.mPlayer.getDuration();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_Alio != null)
      {
        this.jdField_a_of_type_Alio.a(this, 0, 0);
        paramMessage = new HashMap();
        paramMessage.put("param_succ_flag", "0");
        paramMessage.put("errCode", "0");
        paramMessage.put("param_version", Build.VERSION.SDK_INT + "");
        paramMessage.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, paramMessage, null);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_Alio == null)) {
      return true;
    }
    this.jdField_a_of_type_Alio.onCompletion();
    return true;
  }
  
  public boolean isPlaying()
  {
    return (this.mPlayer != null) && (this.mPlayer.isPlaying());
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onCompletion");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_Alio != null) {
      this.jdField_a_of_type_Alio.onCompletion();
    }
    this.dC.set(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onError");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_Alio != null) {
      this.jdField_a_of_type_Alio.a(this, paramInt1, paramInt2);
    }
    paramMediaPlayer = new HashMap();
    paramMediaPlayer.put("param_succ_flag", "0");
    paramMediaPlayer.put("errCode", paramInt1 + "");
    paramMediaPlayer.put("param_version", Build.VERSION.SDK_INT + "");
    paramMediaPlayer.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, paramMediaPlayer, null);
    this.dC.set(false);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onPrepared");
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr pause");
    }
    this.mPlayer.pause();
  }
  
  public void prepare()
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr prepare");
    }
    this.mPlayer.prepare();
    this.dC.set(true);
  }
  
  public void release()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr release");
    }
    this.dC.set(false);
    this.mPlayer.release();
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr reset");
    }
    this.mPlayer.reset();
  }
  
  public void seekTo(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr seekTo");
    }
    this.mSeekToTime = paramInt;
  }
  
  public void setDataSource(String paramString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setDataSource");
    }
    this.mFilePath = paramString;
    this.mPlayer.setDataSource(paramString);
  }
  
  public void setStreamType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setStreamType");
    }
    this.mPlayer.setAudioStreamType(paramInt);
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr start");
    }
    this.mPlayer.setOnCompletionListener(this);
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnErrorListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = new AmrPlayerThread(null);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread.start();
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr stop");
    }
    this.mPlayer.stop();
    this.dC.set(false);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
  }
  
  class AmrPlayerThread
    extends Thread
  {
    private AmrPlayerThread() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread " + AmrPlayer.a(AmrPlayer.this));
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
        }
        AmrPlayer.a(AmrPlayer.this).bYG();
        if (QLog.isColorLevel()) {
          QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
        }
        AmrPlayer.a(AmrPlayer.this).start();
        if (AmrPlayer.a(AmrPlayer.this, AmrPlayer.a(AmrPlayer.this) - 1000) > 0) {
          AmrPlayer.a(AmrPlayer.this).seekTo(AmrPlayer.a(AmrPlayer.this));
        }
        return;
      }
      catch (Exception localException)
      {
        while (AmrPlayer.a(AmrPlayer.this) == null) {}
        AmrPlayer.a(AmrPlayer.this).sendEmptyMessage(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */