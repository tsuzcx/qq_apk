package com.tencent.mobileqq.apollo.task;

import abvj;
import abvm;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import aqge;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class ApolloAudioPlayer
  implements MediaPlayer.OnPreparedListener
{
  private abvm a;
  private String bie;
  public boolean mIsPaused;
  public Object mLock;
  private MediaPlayer mPlayer;
  
  private void dn(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[doPlayVoice], path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAudioPlayer", 2, "Fail to play, path is null or file not exist.");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.mPlayer == null) {
          this.mPlayer = new MediaPlayer();
        }
        this.mPlayer.setOnCompletionListener(new abvj(this, paramInt, paramString));
        try
        {
          boolean bool = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isMusicActive();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloAudioPlayer", 2, "isMusicActive:" + bool);
          }
        }
        catch (OutOfMemoryError paramString)
        {
          synchronized (this.mLock)
          {
            this.bie = paramString;
            aqge.m(BaseApplicationImpl.getContext(), true);
            long l = System.currentTimeMillis();
            this.mPlayer.reset();
            this.mPlayer.setDataSource(paramString);
            this.mPlayer.setOnPreparedListener(this);
            this.mPlayer.prepareAsync();
            this.mPlayer.start();
            QLog.e("ApolloAudioPlayer", 1, "AudioPlayer " + (System.currentTimeMillis() - l));
            return;
            paramString = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloAudioPlayer", 2, "play,oom->errInfo:" + paramString.getMessage());
              return;
            }
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloAudioPlayer", 2, "play, other->errInfo:" + paramString.getMessage());
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (!paramMediaPlayer.isPlaying())) {
      paramMediaPlayer.start();
    }
  }
  
  static class PlayRunnable
    implements Runnable
  {
    int ctb;
    WeakReference<ApolloAudioPlayer> fR;
    String mPath;
    
    public void run()
    {
      ApolloAudioPlayer localApolloAudioPlayer = (ApolloAudioPlayer)this.fR.get();
      if (localApolloAudioPlayer == null) {
        return;
      }
      ApolloAudioPlayer.a(localApolloAudioPlayer, this.mPath, this.ctb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAudioPlayer
 * JD-Core Version:    0.7.0.1
 */