import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class abmy
  implements abnm
{
  public static String TAG = "cmgame_process.ApolloGameMusicPlayer";
  private AudioManager.OnAudioFocusChangeListener c = new abna(this);
  AtomicBoolean cp = new AtomicBoolean(false);
  private int cqe = 1;
  private MediaPlayer e;
  AudioManager mAudioManager;
  private int mGameId;
  private final Object mLock = new Object();
  private SharedPreferences mPref;
  private WeakReference<AppInterface> n;
  private List<MediaPlayer> wr = Collections.synchronizedList(new ArrayList());
  
  public abmy(AppInterface paramAppInterface, int paramInt)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    }
    this.mPref = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", i);
    this.n = new WeakReference(paramAppInterface);
    this.mGameId = paramInt;
    this.mAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    e(paramAppInterface);
  }
  
  private void DS(boolean paramBoolean)
  {
    if (this.mAudioManager == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (int i = this.mAudioManager.requestAudioFocus(this.c, 3, 2); QLog.isColorLevel(); i = this.mAudioManager.abandonAudioFocus(this.c))
      {
        QLog.d(TAG, 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
        return;
      }
    }
  }
  
  private MediaPlayer a(int paramInt)
  {
    synchronized (this.mLock)
    {
      if (this.wr != null)
      {
        Iterator localIterator = this.wr.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt)) {
            return localMediaPlayer;
          }
        }
      }
      return null;
    }
  }
  
  private MediaPlayer b(int paramInt)
  {
    if ((this.e != null) && (this.e.hashCode() == paramInt)) {
      return this.e;
    }
    return null;
  }
  
  private void e(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    while (this.mPref == null) {
      return;
    }
    this.cqe = this.mPref.getInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + this.mGameId, 1);
  }
  
  public void Zx()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[pauseMusic], gameId:", Integer.valueOf(this.mGameId) });
    }
    this.cp.set(true);
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameMusicPlayer", 2, "pauseMusic bMute false");
        }
        DS(false);
        synchronized (this.mLock)
        {
          if (this.wr != null)
          {
            Iterator localIterator = this.wr.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.pause();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "pause error:", localException);
        }
        return;
      }
    } while (this.e == null);
    this.e.pause();
  }
  
  public int a(abjq paramabjq, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if (paramabjq == null) {
      return -1;
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",musicPath:", paramString, ",loopCount:", Integer.valueOf(paramInt2), ",gameId", Integer.valueOf(this.mGameId), ",gameId:", Integer.valueOf(this.mGameId), ",pos:", Integer.valueOf(paramInt3), ",volumn,:", Float.valueOf(paramFloat) });
    }
    if ((this.mGameId > 0) && ((this.cqe == 0) || (localObject1 == null) || (!abmt.YK()) || (paramabjq == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "DO NOT play music.");
      }
      return -1;
    }
    if (-1 == paramInt2) {
      paramInt2 = 2147483647;
    }
    for (;;)
    {
      label288:
      label688:
      for (localObject1 = null;; localObject1 = null)
      {
        boolean bool;
        try
        {
          if ((paramabjq instanceof ApolloSurfaceView))
          {
            localObject1 = ((ApolloSurfaceView)paramabjq).getRender();
            if (localObject1 == null) {
              continue;
            }
            bool = URLUtil.isNetworkUrl(paramString);
            if (!bool) {
              break label288;
            }
          }
          for (localObject1 = paramString;; localObject1 = ((File)localObject1).getPath())
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label370;
            }
            QLog.w(TAG, 1, "music NOT exist.path:" + paramString);
            return -1;
            if (!(paramabjq instanceof ApolloTextureView)) {
              break;
            }
            localObject1 = ((ApolloTextureView)paramabjq).getRender();
            break;
            localObject1 = ((ApolloRender)localObject1).getRscPath(paramString, "mp3");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label688;
            }
            localObject1 = new File((String)localObject1);
            if (!((File)localObject1).exists()) {
              break label688;
            }
          }
          if (paramInt1 != 0) {
            break label450;
          }
        }
        catch (Throwable paramabjq)
        {
          QLog.e(TAG, 1, "[playMusic], errInfo->" + paramabjq.getMessage());
          return -1;
        }
        label370:
        paramString = a((String)localObject1, paramInt2);
        if (paramString != null)
        {
          if (-1 != paramInt3) {
            paramString.seekTo(paramInt3);
          }
          if (-1.0F != paramFloat) {
            paramString.setVolume(paramFloat, paramFloat);
          }
          localObject1 = abmt.a();
          if (localObject1 != null) {
            ((ApolloCmdChannel)localObject1).playMusicInner(paramabjq, paramString.hashCode(), paramLong);
          }
          return paramString.hashCode();
        }
        return -1;
        label450:
        if (this.mGameId == -10000) {
          stopMusic(0, paramString);
        }
        for (;;)
        {
          try
          {
            paramString = new MediaPlayer();
            synchronized (this.mLock)
            {
              this.wr.add(paramString);
              DS(true);
              paramString.setDataSource((String)localObject1);
              if (paramInt2 == 2147483647)
              {
                bool = true;
                paramString.setLooping(bool);
                if (paramInt2 != 2147483647)
                {
                  paramString.setOnCompletionListener(new abmz(this, paramInt2, paramabjq, paramLong));
                  if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "create player, audio_sessionID: " + paramString.getAudioSessionId());
                  }
                }
                paramString.prepare();
                paramString.start();
                if (-1 != paramInt3) {
                  paramString.seekTo(paramInt3);
                }
                if (-1.0F != paramFloat) {
                  paramString.setVolume(paramFloat, paramFloat);
                }
                localObject1 = abmt.a();
                if (localObject1 != null) {
                  ((ApolloCmdChannel)localObject1).playMusicInner(paramabjq, paramString.hashCode(), paramLong);
                }
                paramInt1 = paramString.hashCode();
                return paramInt1;
              }
            }
            bool = false;
          }
          catch (Throwable paramabjq)
          {
            QLog.e(TAG, 1, "prepare - start :", paramabjq);
            return -1;
          }
        }
      }
    }
  }
  
  public MediaPlayer a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.e == null) {
          this.e = new MediaPlayer();
        }
        this.e.stop();
        this.e.reset();
        DS(true);
        this.e.setDataSource(paramString);
        paramString = this.e;
        if (paramInt != 2147483647) {
          continue;
        }
        bool = true;
        paramString.setLooping(bool);
        this.e.prepare();
        this.e.start();
      }
      catch (Throwable paramString)
      {
        boolean bool;
        QLog.e(TAG, 1, "prepare - start :", paramString);
        continue;
      }
      return this.e;
      bool = false;
    }
  }
  
  public AppInterface a()
  {
    if (this.n == null) {
      return null;
    }
    return (AppInterface)this.n.get();
  }
  
  public void a(int paramInt, AppInterface arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[setMusicSwitch], sw:", Integer.valueOf(paramInt), ",gameId:", Integer.valueOf(this.mGameId) });
    }
    if ((this.mPref == null) || (??? == null)) {}
    do
    {
      do
      {
        return;
        this.cqe = paramInt;
        this.mPref.edit().putInt("apollo_game_music_switch" + ???.getCurrentAccountUin() + "_" + this.mGameId, paramInt).commit();
      } while (paramInt != 0);
      synchronized (this.mLock)
      {
        if (this.wr != null)
        {
          Iterator localIterator = this.wr.iterator();
          while (localIterator.hasNext())
          {
            MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
            if (localMediaPlayer != null) {
              localMediaPlayer.reset();
            }
          }
        }
      }
    } while (this.e == null);
    this.e.reset();
  }
  
  public int c(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.mGameId) });
    }
    e(paramAppInterface);
    return this.cqe;
  }
  
  public int gc(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[getCurPosition], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      paramInt = localMediaPlayer.getCurrentPosition();
    }
    do
    {
      return paramInt;
      localMediaPlayer = b(paramInt);
      paramInt = i;
    } while (localMediaPlayer == null);
    return localMediaPlayer.getCurrentPosition();
  }
  
  public int getDuration(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[getDuration], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      paramInt = localMediaPlayer.getDuration();
    }
    do
    {
      return paramInt;
      localMediaPlayer = b(paramInt);
      paramInt = i;
    } while (localMediaPlayer == null);
    return localMediaPlayer.getDuration();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[onDestroy],gameId:", Integer.valueOf(this.mGameId) });
    }
    DS(false);
    if (!this.cp.get()) {
      this.cp.set(false);
    }
    synchronized (this.mLock)
    {
      if (this.wr == null) {
        break label144;
      }
      Iterator localIterator = this.wr.iterator();
      while (localIterator.hasNext())
      {
        MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
        if (localMediaPlayer != null)
        {
          localMediaPlayer.stop();
          localMediaPlayer.release();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "stop front music.");
    }
    this.wr.clear();
    label144:
    if (this.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "stop back music.");
      }
      this.e.stop();
      this.e.release();
      this.e = null;
    }
  }
  
  public void pauseMusic(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[pauseMusic], path:", ???, ",gameId:", Integer.valueOf(this.mGameId) });
    }
    synchronized (this.mLock)
    {
      if (this.wr != null)
      {
        Iterator localIterator = this.wr.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            if (this.wr.size() == 1) {
              DS(false);
            }
            localMediaPlayer.pause();
            return;
          }
        }
      }
      if ((this.e != null) && (this.e.hashCode() == paramInt))
      {
        DS(false);
        this.e.pause();
        return;
      }
    }
  }
  
  public void resumeMusic()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[resumeMusic], gameId:", Integer.valueOf(this.mGameId) });
    }
    if ((this.cqe == 0) || (abmt.YI()) || (abmt.YJ()) || (!abmt.YK())) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "DO NOT play music.");
      }
    }
    do
    {
      return;
      this.cp.set(false);
      DS(true);
      try
      {
        synchronized (this.mLock)
        {
          if (this.wr != null)
          {
            Iterator localIterator = this.wr.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.start();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, "resumeMusic error:", localException);
        return;
      }
    } while (this.e == null);
    this.e.start();
  }
  
  public void resumeMusic(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[resumeMusic], path:", ???, ",gameId:", Integer.valueOf(this.mGameId) });
    }
    synchronized (this.mLock)
    {
      if (this.wr != null)
      {
        Iterator localIterator = this.wr.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            DS(true);
            localMediaPlayer.start();
            return;
          }
        }
      }
      if ((this.e != null) && (this.e.hashCode() == paramInt))
      {
        DS(true);
        this.e.start();
        return;
      }
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[seekTo], hashCode:", Integer.valueOf(paramInt1), ",pos:", Integer.valueOf(paramInt2) });
    }
    MediaPlayer localMediaPlayer = a(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
    localMediaPlayer = b(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
  }
  
  public void stopMusic(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[stopMusic], path:", ???, ",gameId:", Integer.valueOf(this.mGameId) });
    }
    DS(false);
    for (;;)
    {
      MediaPlayer localMediaPlayer1;
      synchronized (this.mLock)
      {
        if (this.wr == null) {
          break label206;
        }
        if (this.mGameId != -10000) {
          break label137;
        }
        if (this.wr.size() <= 0) {
          break label134;
        }
        localMediaPlayer1 = (MediaPlayer)this.wr.get(0);
      }
      try
      {
        localMediaPlayer1.stop();
        localMediaPlayer1.release();
        this.wr.remove(localMediaPlayer1);
        continue;
        localObject = finally;
        throw localObject;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
        }
      }
    }
    label134:
    return;
    label137:
    Iterator localIterator = this.wr.iterator();
    while (localIterator.hasNext())
    {
      MediaPlayer localMediaPlayer2 = (MediaPlayer)localIterator.next();
      if ((localMediaPlayer2 != null) && (localMediaPlayer2.hashCode() == paramInt))
      {
        this.wr.remove(localMediaPlayer2);
        localMediaPlayer2.stop();
        localMediaPlayer2.release();
        return;
      }
    }
    label206:
    if ((this.e != null) && (this.e.hashCode() == paramInt))
    {
      this.e.stop();
      this.e.release();
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmy
 * JD-Core Version:    0.7.0.1
 */