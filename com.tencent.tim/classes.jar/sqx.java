import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import com.tencent.biz.videostory.video.VsMediaPlayer.1;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;

public class sqx
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private long Di;
  private long Dj;
  private long Dk;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private sqx.a jdField_a_of_type_Sqx$a;
  private int byH = -1;
  private int byI;
  private volatile MediaPlayer mPlayer;
  private long mVideoDuration;
  private float mVolume = 1.0F;
  private Timer t;
  
  public sqx()
  {
    createMediaPlayer();
  }
  
  private void bzW()
  {
    bzX();
    this.t = new Timer();
    this.t.schedule(new VsMediaPlayer.1(this), 0L, 1000L);
  }
  
  private void bzX()
  {
    this.byI = 0;
    if (this.t != null) {
      this.t.cancel();
    }
  }
  
  private void createMediaPlayer()
  {
    this.mPlayer = new MediaPlayer();
    this.mPlayer.setAudioStreamType(3);
    this.mPlayer.setVolume(this.mVolume, this.mVolume);
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnSeekCompleteListener(this);
    this.mPlayer.setOnErrorListener(this);
  }
  
  private void replay()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      this.mPlayer.seekTo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicStart);
      bzW();
    }
  }
  
  public VsMusicItemInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ret_code", Integer.valueOf(0));
      ((HashMap)localObject).put("time_cost", Long.valueOf(this.Dk));
      ((HashMap)localObject).put("total_play_time", Long.valueOf(System.currentTimeMillis() - this.Dj));
      ((HashMap)localObject).put("video_duration", Long.valueOf(this.mVideoDuration));
      ((HashMap)localObject).put("music_source", Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.from));
      ((HashMap)localObject).put("file_size", Long.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.fileSize));
      ((HashMap)localObject).put("element_id", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
      sqn.n("edit_smart_music_play", sqn.b((HashMap)localObject));
    }
    if (paramVsMusicItemInfo == null) {}
    do
    {
      do
      {
        return;
        if ((paramVsMusicItemInfo.mUrl != null) && (paramVsMusicItemInfo.mUrl.trim().length() != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_Sqx$a == null);
      this.jdField_a_of_type_Sqx$a.a(this.mPlayer, -2, -1);
      return;
      localObject = Uri.parse(paramVsMusicItemInfo.mUrl);
      if (localObject != null) {
        break;
      }
    } while (this.jdField_a_of_type_Sqx$a == null);
    this.jdField_a_of_type_Sqx$a.a(this.mPlayer, -1, -1);
    return;
    this.Di = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    release();
    try
    {
      createMediaPlayer();
      this.mPlayer.setDataSource(BaseApplicationImpl.getContext(), (Uri)localObject);
      this.mPlayer.prepareAsync();
      return;
    }
    catch (IOException paramVsMusicItemInfo)
    {
      paramVsMusicItemInfo.printStackTrace();
    }
  }
  
  public void a(sqx.a parama)
  {
    this.jdField_a_of_type_Sqx$a = parama;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Sqx$a != null) && (paramInt1 != -38)) {
      this.jdField_a_of_type_Sqx$a.a(paramMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)) {
      paramMediaPlayer.seekTo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicStart);
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (this.jdField_a_of_type_Sqx$a != null) && (!paramMediaPlayer.isPlaying()))
    {
      this.Dk = (System.currentTimeMillis() - this.Di);
      this.Dj = System.currentTimeMillis();
      this.jdField_a_of_type_Sqx$a.a(paramMediaPlayer, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    }
  }
  
  public void pause()
  {
    if (this.mPlayer != null) {
      this.mPlayer.pause();
    }
  }
  
  public void release()
  {
    if (this.mPlayer != null)
    {
      stop();
      this.mPlayer.release();
      this.mPlayer = null;
    }
  }
  
  public void resume()
  {
    if ((this.mPlayer != null) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)) {
      this.mPlayer.start();
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.mPlayer != null) {
      this.mPlayer.seekTo((int)paramLong);
    }
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.mVideoDuration = paramLong;
  }
  
  public void setVolume(float paramFloat)
  {
    this.mVolume = paramFloat;
  }
  
  public void start()
  {
    if (this.mPlayer != null)
    {
      if (!this.mPlayer.isPlaying()) {
        break label30;
      }
      if (this.byH == -1) {
        replay();
      }
    }
    return;
    label30:
    this.mPlayer.start();
    bzW();
  }
  
  public void stop()
  {
    if (this.mPlayer != null) {
      this.mPlayer.stop();
    }
    bzX();
  }
  
  public void yO(int paramInt)
  {
    this.byH = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2);
    
    public abstract void a(MediaPlayer paramMediaPlayer, VsMusicItemInfo paramVsMusicItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqx
 * JD-Core Version:    0.7.0.1
 */