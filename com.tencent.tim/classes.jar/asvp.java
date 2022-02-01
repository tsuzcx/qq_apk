import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

@ProxyService(proxy=MusicPlayerProxy.class)
public class asvp
  implements MusicPlayerProxy
{
  private static String sToken;
  private long lastBindServiceTime = -1L;
  private String mAppId;
  private String mAppName;
  private ajmi.a mCallback = new asvs(this);
  private ServiceConnection mConn = new asvq(this);
  private MusicPlayerProxy.MusicPlayerListener mMusicPlayerListener;
  private ajmj mService;
  
  private void bindQQPlayerService()
  {
    for (;;)
    {
      try
      {
        if (this.mService == null)
        {
          long l = System.currentTimeMillis();
          if ((this.lastBindServiceTime != -1L) && (l - this.lastBindServiceTime <= 10000L)) {
            continue;
          }
          this.lastBindServiceTime = l;
          Intent localIntent = new Intent(BaseApplication.getContext(), QQPlayerService.class);
          BaseApplication.getContext().bindService(localIntent, this.mConn, 33);
          QLog.e("MusicPlayerProxyImpl", 1, "bindQQPlayerService end!");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "bindQQPlayerService exception", localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.e("MusicPlayerProxyImpl", 1, "waiting for binding service");
    }
  }
  
  private String getMyToken()
  {
    if (sToken == null) {
      sToken = QQPlayerService.I(8, "MusicPlayerProxyImpl" + this.mAppId);
    }
    return sToken;
  }
  
  private void unbindQQPlayerService()
  {
    try
    {
      if (this.mService != null)
      {
        BaseApplication.getContext().unbindService(this.mConn);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "unbindQQPlayerService exception", localThrowable);
      }
    }
    finally {}
  }
  
  public com.tencent.qqmini.sdk.launcher.core.model.SongInfo getCurrentSong()
  {
    try
    {
      if (this.mService != null) {
        this.mService.a();
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSong exception ", localException);
      }
    }
  }
  
  public int getCurrentSongPosition()
  {
    if (this.mService != null) {
      try
      {
        int i = this.mService.getCurrentSongPosition();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.mService != null) {
      try
      {
        int i = this.mService.getDuration();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongDuration exception ", localException);
      }
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2)
  {
    this.mMusicPlayerListener = paramMusicPlayerListener;
    this.mAppId = paramString1;
    this.mAppName = paramString2;
    bindQQPlayerService();
  }
  
  public boolean isInit()
  {
    return this.mService != null;
  }
  
  public boolean isPlaying()
  {
    boolean bool = true;
    try
    {
      StringBuilder localStringBuilder;
      if ((this.mService == null) || (!this.mService.nt(getMyToken())))
      {
        localStringBuilder = new StringBuilder().append("getBackgroundAudioState: null ");
        if (this.mService != null) {
          break label65;
        }
      }
      label65:
      for (bool = true;; bool = false)
      {
        Log.i("MusicPlayerProxyImpl", bool);
        bool = false;
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "isPlaying exception ", localException);
    }
  }
  
  public void pause()
  {
    try
    {
      if (this.mService != null) {
        this.mService.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "pause exception ", localException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.mService != null) {
        this.mService.resume();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "resume exception ", localException);
    }
  }
  
  public void seekTo(int paramInt)
  {
    try
    {
      if (this.mService != null) {
        this.mService.seekTo(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "seekTo exception ", localException);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    try
    {
      if (this.mService != null) {
        this.mService.setPlayMode(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "setPlayMode exception ", localException);
    }
  }
  
  public void startPlay(com.tencent.qqmini.sdk.launcher.core.model.SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if ((paramArrayOfSongInfo == null) || (paramArrayOfSongInfo.length < 1)) {}
    while (this.mService == null) {
      return;
    }
    try
    {
      this.mService.ag(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      Bundle localBundle = this.mService.getExtras();
      Object localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        this.mService.setExtras((Bundle)localObject);
      }
      ((Bundle)localObject).putString("KEY_SOURCE_NAME", this.mAppName);
      this.mService.setExtras((Bundle)localObject);
      localObject = new com.tencent.mobileqq.music.SongInfo[paramArrayOfSongInfo.length];
      int i = 0;
      while (i < paramArrayOfSongInfo.length)
      {
        localObject[i] = new com.tencent.mobileqq.music.SongInfo();
        localObject[i].album = paramArrayOfSongInfo[i].album;
        localObject[i].coverUrl = paramArrayOfSongInfo[i].coverUrl;
        localObject[i].detailUrl = paramArrayOfSongInfo[i].detailUrl;
        localObject[i].duration = paramArrayOfSongInfo[i].duration;
        localObject[i].fromMini = paramArrayOfSongInfo[i].fromMini;
        localObject[i].id = paramArrayOfSongInfo[i].id;
        localObject[i].mid = paramArrayOfSongInfo[i].mid;
        localObject[i].singer = paramArrayOfSongInfo[i].singer;
        localObject[i].singerId = paramArrayOfSongInfo[i].singerId;
        localObject[i].startTime = paramArrayOfSongInfo[i].startTime;
        localObject[i].summary = paramArrayOfSongInfo[i].summary;
        localObject[i].title = paramArrayOfSongInfo[i].title;
        localObject[i].type = paramArrayOfSongInfo[i].type;
        localObject[i].uin = paramArrayOfSongInfo[i].uin;
        localObject[i].url = paramArrayOfSongInfo[i].url;
        i += 1;
      }
      this.mService.setPlayMode(100);
      this.mService.a(getMyToken(), (com.tencent.mobileqq.music.SongInfo[])localObject, paramInt);
      return;
    }
    catch (Exception paramArrayOfSongInfo)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "startPlay exception ", paramArrayOfSongInfo);
    }
  }
  
  public void stop()
  {
    try
    {
      if (this.mService != null) {
        this.mService.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "stop exception ", localException);
    }
  }
  
  public void unInit()
  {
    unbindQQPlayerService();
    this.mMusicPlayerListener = null;
    this.mAppId = null;
    this.mAppName = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvp
 * JD-Core Version:    0.7.0.1
 */