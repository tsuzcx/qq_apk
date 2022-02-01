package com.tencent.mobileqq.activity.aio;

import alin;
import alio;
import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import aqge;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.AudioHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import wkb;

public abstract class AudioPlayerBase
  implements alio, Runnable
{
  public static int INVALID_AUDIO_STREAM = -999;
  public static int bNK = -1;
  public static boolean bdf = true;
  public static volatile boolean bdg;
  public static boolean bdh;
  public static final List<Integer> rz = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  public alin a;
  public a a;
  protected Application application;
  public AudioManager audioManager;
  public volatile AudioHelper.a b;
  public volatile int bNL;
  protected boolean bdi;
  protected long mMsgTime = -1L;
  protected float mPlaySpeed = MediaPlayerManager.pC;
  protected volatile int phoneAudioStream = INVALID_AUDIO_STREAM;
  protected String sourcePath;
  protected Timer t;
  public Handler uiHandler = new wkb(this);
  
  public AudioPlayerBase(Context paramContext, a parama)
  {
    this.application = ((Application)paramContext.getApplicationContext());
    this.audioManager = ((AudioManager)this.application.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a = parama;
  }
  
  @TargetApi(14)
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!bdf) {}
    BluetoothAdapter localBluetoothAdapter;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    } while ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2) || (rz.contains(Integer.valueOf(bNK))) || (bdg) || (paramAudioManager.isBluetoothScoOn()) || (!paramAudioManager.isBluetoothScoAvailableOffCall()));
    return true;
  }
  
  public void Ce(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a.d(this, getCurrentPosition());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
  
  public void Cf(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "replay ", new Exception());
    }
    if (this.sourcePath != null) {
      play(this.sourcePath, paramInt);
    }
  }
  
  public alin a()
  {
    return this.jdField_a_of_type_Alin;
  }
  
  public void a(alin paramalin, int paramInt1, int paramInt2)
  {
    stop();
    QLog.e("AudioPlayer", 2, "onError: " + paramInt1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a.a(this, -2);
    }
  }
  
  public void aY(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 0;
      }
      AudioPlayer.bNK = i;
      AudioPlayer.bdg = false;
      return;
    }
    if (paramBoolean1) {}
    for (;;)
    {
      AudioPlayer.bNK = i;
      break;
      i = 0;
    }
  }
  
  public void ao(float paramFloat)
  {
    this.mPlaySpeed = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.i("AudioPlayer", 2, "setPlaySpeed: " + paramFloat);
    }
  }
  
  public abstract void bYF();
  
  public void bYG()
    throws IOException
  {
    i = 1;
    this.bdi = this.audioManager.isSpeakerphoneOn();
    this.b = c();
    this.audioManager.setMode(this.b.mode);
    this.audioManager.setSpeakerphoneOn(this.b.cTU);
    if (this.phoneAudioStream != INVALID_AUDIO_STREAM) {
      this.b.dZd = this.phoneAudioStream;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a.b(this, this.b.dZd);
    }
    aqge.m(this.application, true);
    if (this.jdField_a_of_type_Alin != null) {
      this.jdField_a_of_type_Alin.setStreamType(this.b.dZd);
    }
    try
    {
      this.jdField_a_of_type_Alin.prepare();
      i = this.audioManager.getStreamVolume(this.b.dZd);
      int j = this.audioManager.getStreamMaxVolume(this.b.dZd);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "currentVolume=" + i + " maxVolume=" + j);
      }
      if (i / j >= 0.18F) {
        break label326;
      }
      this.bNL = 0;
      this.uiHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.e("AudioPlayer", 2, "mPlayer.prepare error", localThrowable);
        if ((this.jdField_a_of_type_Alin instanceof SilkPlayer)) {}
        for (;;)
        {
          AudioPlayer.n(0, i, 3, localThrowable.toString());
          return;
          i = 0;
        }
        this.bNL = 1;
        this.uiHandler.removeMessages(1000);
        continue;
        i = 0;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a.c(this, this.bNL);
    }
    if ((this.jdField_a_of_type_Alin instanceof SilkPlayer))
    {
      i = 1;
      AudioPlayer.n(1, i, 0, "");
      bzW();
      return;
    }
  }
  
  public void bYH() {}
  
  public void bYI() {}
  
  public void bYJ()
  {
    if ((bdh) && (this.audioManager.isBluetoothScoOn()))
    {
      this.audioManager.setBluetoothScoOn(false);
      this.audioManager.stopBluetoothSco();
      bdh = false;
    }
  }
  
  protected void bzW()
  {
    if ((this.jdField_a_of_type_Alin instanceof AmrPlayer))
    {
      bzX();
      this.t = new Timer();
      this.t.schedule(new AudioPlayerBase.2(this), 0L, 100L);
    }
  }
  
  protected void bzX()
  {
    if (this.t != null) {
      this.t.cancel();
    }
  }
  
  protected abstract AudioHelper.a c();
  
  public void doOnDestory()
  {
    bYJ();
  }
  
  public void fT(long paramLong)
  {
    this.mMsgTime = paramLong;
  }
  
  public AudioManager getAudioManager()
  {
    return this.audioManager;
  }
  
  public int getCurrentPosition()
  {
    if (this.jdField_a_of_type_Alin == null) {
      return 0;
    }
    return this.jdField_a_of_type_Alin.getCurrentPosition();
  }
  
  public int getDuration()
  {
    if (this.jdField_a_of_type_Alin == null) {
      return 0;
    }
    return this.jdField_a_of_type_Alin.getDuration();
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public boolean isPlaying()
  {
    return (this.jdField_a_of_type_Alin != null) && (this.jdField_a_of_type_Alin.isPlaying());
  }
  
  public void onCompletion()
  {
    stop();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a.a(this);
    }
  }
  
  public boolean play(String paramString)
  {
    return play(paramString, 0);
  }
  
  protected abstract boolean play(String paramString, int paramInt);
  
  public void run()
  {
    try
    {
      this.audioManager.setMode(0);
      this.audioManager.setSpeakerphoneOn(this.bdi);
      aqge.m(this.application, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, localException, new Object[0]);
    }
  }
  
  public boolean seekPlay(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "seekPlay ", new Exception());
    }
    return play(paramString, paramInt);
  }
  
  public void setAudioStream(int paramInt)
  {
    this.phoneAudioStream = paramInt;
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/tencent/mobileqq/activity/aio/AudioPlayerBase:uiHandler	Landroid/os/Handler;
    //   6: sipush 1000
    //   9: invokevirtual 329	android/os/Handler:removeMessages	(I)V
    //   12: aload_0
    //   13: invokevirtual 346	com/tencent/mobileqq/activity/aio/AudioPlayerBase:bzX	()V
    //   16: aload_0
    //   17: getfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   20: ifnull +84 -> 104
    //   23: aload_0
    //   24: getfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   27: invokeinterface 378 1 0
    //   32: ifeq +12 -> 44
    //   35: aload_0
    //   36: getfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   39: invokeinterface 391 1 0
    //   44: aload_0
    //   45: getfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   48: invokeinterface 394 1 0
    //   53: aload_0
    //   54: getfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   57: invokeinterface 397 1 0
    //   62: aload_0
    //   63: getstatic 74	com/tencent/mobileqq/activity/aio/MediaPlayerManager:pC	F
    //   66: putfield 76	com/tencent/mobileqq/activity/aio/AudioPlayerBase:mPlaySpeed	F
    //   69: aload_0
    //   70: ldc2_w 77
    //   73: putfield 80	com/tencent/mobileqq/activity/aio/AudioPlayerBase:mMsgTime	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 197	com/tencent/mobileqq/activity/aio/AudioPlayerBase:sourcePath	Ljava/lang/String;
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 204	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Alin	Lalin;
    //   86: aload_0
    //   87: getstatic 46	com/tencent/mobileqq/activity/aio/AudioPlayerBase:INVALID_AUDIO_STREAM	I
    //   90: putfield 82	com/tencent/mobileqq/activity/aio/AudioPlayerBase:phoneAudioStream	I
    //   93: aload_0
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 403	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: invokestatic 408	ainb:a	()Lainb;
    //   107: invokevirtual 411	ainb:Rw	()Z
    //   110: ifeq -9 -> 101
    //   113: aload_0
    //   114: getstatic 46	com/tencent/mobileqq/activity/aio/AudioPlayerBase:INVALID_AUDIO_STREAM	I
    //   117: putfield 82	com/tencent/mobileqq/activity/aio/AudioPlayerBase:phoneAudioStream	I
    //   120: aload_0
    //   121: bipush 8
    //   123: aconst_null
    //   124: iconst_0
    //   125: invokestatic 403	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   128: goto -27 -> 101
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	AudioPlayerBase
    //   131	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	131	finally
    //   44	101	131	finally
    //   104	128	131	finally
  }
  
  protected void stopPlaying()
    throws InterruptedException
  {
    if (this.jdField_a_of_type_Alin != null)
    {
      if (this.jdField_a_of_type_Alin.isPlaying()) {
        this.jdField_a_of_type_Alin.stop();
      }
      this.jdField_a_of_type_Alin.reset();
      this.jdField_a_of_type_Alin.release();
      this.jdField_a_of_type_Alin = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AudioPlayerBase paramAudioPlayerBase);
    
    public abstract void a(AudioPlayerBase paramAudioPlayerBase, int paramInt);
    
    public abstract void b(AudioPlayerBase paramAudioPlayerBase, int paramInt);
    
    public abstract void c(AudioPlayerBase paramAudioPlayerBase, int paramInt);
    
    public abstract void d(AudioPlayerBase paramAudioPlayerBase, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayerBase
 * JD-Core Version:    0.7.0.1
 */