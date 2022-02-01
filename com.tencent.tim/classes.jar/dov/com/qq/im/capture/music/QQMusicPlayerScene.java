package dov.com.qq.im.capture.music;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import auru;
import axrj;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class QQMusicPlayerScene
  extends axrj
  implements Handler.Callback
{
  private Timer ai;
  auru d = new auru(Looper.getMainLooper(), this);
  private boolean dwm = true;
  private TimerTask f;
  
  public void Zx()
  {
    int i = -1;
    String str = "";
    try
    {
      this.dwm = false;
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.b.isPlaying())
      {
        this.mCurrentPosition = this.b.getCurrentPosition();
        i = this.mCurrentPosition;
      }
      if (this.a != null) {
        str = this.a.mMusicName;
      }
      this.b.stop();
      eOp();
      c(i, this.a);
      localStringBuilder.append(" musicName=").append(str);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  protected void aZ(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.postImmediately(new QQMusicPlayerScene.1(this, paramString, paramInt1, paramInt2), null, true);
  }
  
  public void aeG(int paramInt)
  {
    eOp();
    this.ai = new Timer();
    this.f = new MyMusicTimerTask(null);
    this.ai.schedule(this.f, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "setMyMusicTimer");
    }
  }
  
  public void destroy()
  {
    try
    {
      this.dwm = false;
      eOp();
      this.a = null;
      super.destroy();
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene destroy");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void eOk()
  {
    int i = -1;
    String str = "";
    for (;;)
    {
      try
      {
        this.dwm = true;
        this.mCurrentPosition = -1;
        StringBuilder localStringBuilder = new StringBuilder("startMusic");
        if ((this.b != null) && (this.a != null))
        {
          this.b.setAudioStream(3);
          str = this.a.mMusicName;
          if (this.a.musicDuration < this.a.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.a.musicDuration);
            localStringBuilder.append(" musicEnd=").append(this.a.musicEnd);
            this.a.musicStart = 0;
            this.a.musicEnd = this.a.musicDuration;
          }
          if (this.a.musicEnd <= this.a.musicStart)
          {
            localStringBuilder.append(" musicEnd <= musicStart don't play music musicName=").append(str);
            localStringBuilder.append(" musicEnd=").append(this.a.musicEnd);
            localStringBuilder.append(" musicStart=").append(this.a.musicStart);
            localStringBuilder.append("\n");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            a(-1, this.a);
            return;
          }
          j = this.a.musicStart;
          a(j, this.a);
          i = this.a.musicEnd - this.a.musicStart;
          aZ(this.a.getLocalPath(), this.a.musicStart, i);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void eOl()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        this.mCurrentPosition = -1;
        String str = "";
        this.dwm = true;
        StringBuilder localStringBuilder = new StringBuilder("replayMusic");
        if ((this.b != null) && (this.a != null))
        {
          str = this.a.mMusicName;
          this.b.setAudioStream(3);
          if (this.a.musicDuration < this.a.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.a.musicDuration);
            localStringBuilder.append(" musicEnd=").append(this.a.musicEnd);
            this.a.musicStart = 0;
            this.a.musicEnd = this.a.musicDuration;
          }
          if (this.a.musicEnd <= this.a.musicStart)
          {
            a(-1, this.a);
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
            }
            return;
          }
          j = this.a.musicStart;
          i = this.a.musicEnd - this.a.musicStart;
          if (isPlaying()) {
            this.b.stop();
          }
          d(j, this.a);
          aZ(this.a.getLocalPath(), this.a.musicStart, i);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void eOp()
  {
    if (this.ai != null)
    {
      this.ai.cancel();
      this.ai = null;
    }
    if (this.f != null)
    {
      this.f.cancel();
      this.f = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "cancelMyMusicTimer");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "handleMessage MSG_MUSIC_REPLAY isNeedPlay=" + this.dwm);
      }
      if (this.dwm) {
        eOl();
      } else {
        stopMusic();
      }
    }
  }
  
  public void resumeMusic()
  {
    int i = -1;
    String str = "";
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
        this.dwm = true;
        if ((this.a != null) && (this.b != null) && (!this.b.isPlaying()) && (this.mCurrentPosition != -1))
        {
          str = this.a.mMusicName;
          if (this.mCurrentPosition >= this.a.musicEnd)
          {
            localStringBuilder.append(" mCurrentPosition>=musicEnd reset musicName").append(str);
            localStringBuilder.append(" mCurrentPosition=").append(this.mCurrentPosition);
            localStringBuilder.append(" musicEnd").append(this.a.musicEnd);
            this.mCurrentPosition = this.a.musicStart;
          }
          i = this.a.musicEnd - this.mCurrentPosition;
          if (i <= 0)
          {
            a(-1, this.a);
            localStringBuilder.append("resumeMusic music info musicEnd <= musicStart don't play music");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            return;
          }
          aZ(this.a.getLocalPath(), this.mCurrentPosition, i);
          j = this.mCurrentPosition;
          b(j, this.a);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void stopMusic()
  {
    try
    {
      this.dwm = false;
      String str = "";
      eOp();
      if (this.a != null)
      {
        str = this.a.mMusicName;
        this.a = null;
      }
      super.stopMusic();
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene stopMusic musicName=" + str);
      }
      return;
    }
    finally {}
  }
  
  class MyMusicTimerTask
    extends TimerTask
  {
    private MyMusicTimerTask() {}
    
    public void run()
    {
      QQMusicPlayerScene.this.d.sendEmptyMessage(1);
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "MyMusicTimerTask MSG_MUSIC_REPLAY");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */