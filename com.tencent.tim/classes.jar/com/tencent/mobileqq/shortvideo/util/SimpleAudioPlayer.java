package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class SimpleAudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static int INVALID_AUDIO_STREAM = -999;
  public static final String TAG = "SimpleAudioPlayer";
  private AmrPlayerThread mPlayThread;
  private MediaPlayer mPlayer;
  private int mSeekToTime = -1;
  private volatile int phoneAudioStream = INVALID_AUDIO_STREAM;
  private String sourcePath;
  
  private boolean play(String paramString, int paramInt)
  {
    boolean bool = false;
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    label261:
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        this.sourcePath = paramString;
        if (!fileExistsAndNotEmpty(paramString))
        {
          if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().d("SimpleAudioPlayer", "file not found, " + paramString);
          }
          stop();
          return bool;
        }
        try
        {
          stopPlaying();
          this.mPlayer = new MediaPlayer();
          this.mPlayer.setDataSource(paramString);
          this.mSeekToTime = i;
          this.mPlayer.setOnCompletionListener(this);
          this.mPlayer.setOnErrorListener(this);
          if (this.mPlayThread == null)
          {
            this.mPlayThread = new AmrPlayerThread(null);
            this.mPlayThread.start();
          }
          if (!SdkContext.getInstance().getLogger().isEnable()) {
            break label261;
          }
          SdkContext.getInstance().getLogger().d("SimpleAudioPlayer", "play music time = " + (System.currentTimeMillis() - l));
        }
        catch (Exception paramString)
        {
          if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().e("SimpleAudioPlayer", "play on error, ", paramString);
          }
          onError(this.mPlayer, 0, 0);
        }
        continue;
        bool = true;
      }
      finally {}
    }
  }
  
  private void stopPlaying()
    throws InterruptedException
  {
    if (this.mPlayer != null)
    {
      if (this.mPlayer.isPlaying())
      {
        this.mPlayer.stop();
        this.mPlayThread = null;
      }
      this.mPlayer.reset();
      this.mPlayer.release();
      this.mPlayer = null;
    }
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 47	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 47	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   23: invokevirtual 144	android/media/MediaPlayer:isPlaying	()Z
    //   26: istore_1
    //   27: goto -12 -> 15
    //   30: astore_3
    //   31: iload_2
    //   32: istore_1
    //   33: invokestatic 68	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   36: invokevirtual 72	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   39: invokeinterface 78 1 0
    //   44: ifeq -29 -> 15
    //   47: invokestatic 68	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   50: invokevirtual 72	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   53: ldc 18
    //   55: ldc 166
    //   57: aload_3
    //   58: invokeinterface 135 4 0
    //   63: iload_2
    //   64: istore_1
    //   65: goto -50 -> 15
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SimpleAudioPlayer
    //   14	51	1	bool1	boolean
    //   1	63	2	bool2	boolean
    //   8	2	3	localMediaPlayer	MediaPlayer
    //   30	28	3	localIllegalStateException	java.lang.IllegalStateException
    //   68	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	30	java/lang/IllegalStateException
    //   4	9	68	finally
    //   19	27	68	finally
    //   33	63	68	finally
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.mPlayThread = null;
    stop();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.mPlayThread = null;
    stop();
    SdkContext.getInstance().getLogger().e("SimpleAudioPlayer", "playSimpleAudio " + this.sourcePath + "onError: " + paramInt1 + "," + paramInt2);
    return true;
  }
  
  public boolean play(String paramString)
  {
    return play(paramString, 0);
  }
  
  public boolean seekPlay(String paramString, int paramInt)
  {
    return play(paramString, paramInt);
  }
  
  public void setAudioStream(int paramInt)
  {
    this.phoneAudioStream = paramInt;
  }
  
  public void stop()
  {
    try
    {
      if (this.mPlayer != null)
      {
        if (this.mPlayer.isPlaying())
        {
          this.mPlayer.stop();
          this.mPlayThread = null;
        }
        this.mPlayer.reset();
        this.mPlayer.release();
        this.sourcePath = null;
        this.mPlayer = null;
        this.phoneAudioStream = INVALID_AUDIO_STREAM;
      }
      return;
    }
    finally {}
  }
  
  class AmrPlayerThread
    extends Thread
  {
    private AmrPlayerThread() {}
    
    public void run()
    {
      if (SdkContext.getInstance().getLogger().isEnable()) {
        SdkContext.getInstance().getLogger().d("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.this.sourcePath);
      }
      try
      {
        if (SimpleAudioPlayer.this.phoneAudioStream != SimpleAudioPlayer.INVALID_AUDIO_STREAM) {
          SimpleAudioPlayer.this.mPlayer.setAudioStreamType(SimpleAudioPlayer.this.phoneAudioStream);
        }
        SimpleAudioPlayer.this.mPlayer.prepare();
        SimpleAudioPlayer.this.mPlayer.start();
        if (SimpleAudioPlayer.this.mSeekToTime > 0) {
          SimpleAudioPlayer.this.mPlayer.seekTo(SimpleAudioPlayer.this.mSeekToTime);
        }
        return;
      }
      catch (Exception localException)
      {
        SdkContext.getInstance().getLogger().e("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.this.sourcePath + "error: " + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer
 * JD-Core Version:    0.7.0.1
 */