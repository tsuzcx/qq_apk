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

public class ywh
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private volatile MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private ywi jdField_a_of_type_Ywi;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private long c;
  private long d;
  
  public ywh()
  {
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicStart);
      h();
    }
  }
  
  private void h()
  {
    i();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VsMediaPlayer.1(this), 0L, 1000L);
  }
  
  private void i()
  {
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
  }
  
  public VsMusicItemInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        break label30;
      }
      if (this.jdField_a_of_type_Int == -1) {
        g();
      }
    }
    return;
    label30:
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    h();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ret_code", Integer.valueOf(0));
      ((HashMap)localObject).put("time_cost", Long.valueOf(this.c));
      ((HashMap)localObject).put("total_play_time", Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long));
      ((HashMap)localObject).put("video_duration", Long.valueOf(this.d));
      ((HashMap)localObject).put("music_source", Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.jdField_a_of_type_Int));
      ((HashMap)localObject).put("file_size", Long.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.fileSize));
      ((HashMap)localObject).put("element_id", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
      yvu.a("edit_smart_music_play", yvu.a((HashMap)localObject));
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
      } while (this.jdField_a_of_type_Ywi == null);
      this.jdField_a_of_type_Ywi.a(this.jdField_a_of_type_AndroidMediaMediaPlayer, -2, -1);
      return;
      localObject = Uri.parse(paramVsMusicItemInfo.mUrl);
      if (localObject != null) {
        break;
      }
    } while (this.jdField_a_of_type_Ywi == null);
    this.jdField_a_of_type_Ywi.a(this.jdField_a_of_type_AndroidMediaMediaPlayer, -1, -1);
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    b();
    try
    {
      f();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(BaseApplicationImpl.getContext(), (Uri)localObject);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramVsMusicItemInfo)
    {
      paramVsMusicItemInfo.printStackTrace();
    }
  }
  
  public void a(ywi paramywi)
  {
    this.jdField_a_of_type_Ywi = paramywi;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      c();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo((int)paramLong);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    i();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ywi != null) && (paramInt1 != -38)) {
      this.jdField_a_of_type_Ywi.a(paramMediaPlayer, paramInt1, paramInt2);
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
    if ((paramMediaPlayer != null) && (this.jdField_a_of_type_Ywi != null) && (!paramMediaPlayer.isPlaying()))
    {
      this.c = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Ywi.a(paramMediaPlayer, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywh
 * JD-Core Version:    0.7.0.1
 */