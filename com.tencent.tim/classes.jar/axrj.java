import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.MusicPlayerScene.1;
import java.util.Iterator;
import java.util.List;

public class axrj
  implements AudioPlayerBase.a
{
  protected MusicItemInfo a;
  private long aCw;
  public AudioPlayer b = new AudioPlayer(BaseApplicationImpl.getApplication(), this);
  protected int mCurrentPosition = -1;
  protected List<axrk> mListener;
  
  public void Zx()
  {
    int i = -1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.b.isPlaying())
      {
        this.mCurrentPosition = this.b.getCurrentPosition();
        i = this.mCurrentPosition;
      }
      this.b.stop();
      c(i, this.a);
      localStringBuilder.append(" musicName=").append("");
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.mListener != null)
    {
      paramMusicItemInfo = this.mListener.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((axrk)paramMusicItemInfo.next()).e(paramInt, this.a);
      }
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    c(this.a);
    eOl();
    if (QLog.isColorLevel()) {
      QLog.d("MusicPlayerScene", 2, "MusicPlayerScene onCompletion");
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.mListener != null)
    {
      paramMusicItemInfo = this.mListener.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((axrk)paramMusicItemInfo.next()).g(paramInt, this.a);
      }
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(MusicItemInfo paramMusicItemInfo)
  {
    try
    {
      this.a = paramMusicItemInfo;
      this.mCurrentPosition = paramMusicItemInfo.musicStart;
      return;
    }
    finally
    {
      paramMusicItemInfo = finally;
      throw paramMusicItemInfo;
    }
  }
  
  protected void c(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.mListener != null)
    {
      paramMusicItemInfo = this.mListener.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((axrk)paramMusicItemInfo.next()).h(paramInt, this.a);
      }
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void c(MusicItemInfo paramMusicItemInfo)
  {
    if (this.mListener != null)
    {
      paramMusicItemInfo = this.mListener.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((axrk)paramMusicItemInfo.next()).e(this.a);
      }
    }
  }
  
  protected void d(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.mListener != null)
    {
      paramMusicItemInfo = this.mListener.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((axrk)paramMusicItemInfo.next()).f(paramInt, this.a);
      }
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    srl.a().fx(paramInt);
  }
  
  public void destroy()
  {
    try
    {
      this.mCurrentPosition = -1;
      this.a = null;
      if (this.b != null) {
        this.b.stop();
      }
      this.b = null;
      this.mListener = null;
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
      }
      return;
    }
    finally {}
  }
  
  public void eOk()
  {
    int j = -1;
    try
    {
      this.mCurrentPosition = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.b != null)
      {
        str1 = str2;
        i = j;
        if (this.a != null)
        {
          str1 = this.a.mMusicName;
          this.b.setAudioStream(3);
          if (this.a.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.a.musicStart);
            this.a.musicStart = 0;
          }
          i = this.a.musicStart;
          a(i, this.a);
          hj(this.a.getLocalPath(), this.a.musicStart + (int)this.aCw);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void eOl()
  {
    int j = -1;
    try
    {
      this.mCurrentPosition = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.b != null)
      {
        str1 = str2;
        i = j;
        if (this.a != null)
        {
          str1 = this.a.mMusicName;
          this.b.setAudioStream(3);
          if (this.a.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.a.musicStart);
            this.a.musicStart = 0;
          }
          if (isPlaying()) {
            this.b.stop();
          }
          i = this.a.musicStart;
          d(i, this.a);
          hj(this.a.getLocalPath(), this.a.musicStart);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void eOm()
  {
    if (this.mListener != null)
    {
      Iterator localIterator = this.mListener.iterator();
      while (localIterator.hasNext()) {
        ((axrk)localIterator.next()).stopMusic();
      }
    }
  }
  
  public int getCurrentPosition()
  {
    int i = -1;
    if (isPlaying()) {
      i = this.b.getCurrentPosition();
    }
    return i;
  }
  
  protected void hj(String paramString, int paramInt)
  {
    ThreadManager.postImmediately(new MusicPlayerScene.1(this, paramString, paramInt), null, true);
    this.aCw = 0L;
  }
  
  public boolean isPlaying()
  {
    try
    {
      if (this.b != null)
      {
        boolean bool = this.b.isPlaying();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void oJ(List<axrk> paramList)
  {
    this.mListener = paramList;
  }
  
  public void resumeMusic()
  {
    int j = -1;
    String str2 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
      String str1 = str2;
      int i = j;
      if (this.a != null)
      {
        str1 = str2;
        i = j;
        if (this.b != null)
        {
          str1 = str2;
          i = j;
          if (!this.b.isPlaying())
          {
            str1 = str2;
            i = j;
            if (this.mCurrentPosition != -1)
            {
              str1 = this.a.mMusicName;
              hj(this.a.getLocalPath(), this.mCurrentPosition);
              i = this.mCurrentPosition;
            }
          }
        }
      }
      b(i, this.a);
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void seekTo(long paramLong)
  {
    this.aCw = paramLong;
    if (this.a != null) {
      this.mCurrentPosition = (this.a.musicStart + (int)this.aCw);
    }
  }
  
  public void stopMusic()
  {
    try
    {
      this.mCurrentPosition = -1;
      String str = "";
      if (this.b != null) {
        this.b.stop();
      }
      if (this.a != null)
      {
        str = this.a.mMusicName;
        this.a = null;
      }
      eOm();
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene stopMusic musicName=" + str);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrj
 * JD-Core Version:    0.7.0.1
 */