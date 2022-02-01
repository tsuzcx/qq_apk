import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2;
import com.tencent.qphone.base.util.QLog;

public class anyw
  implements MediaPlayer.OnSeekCompleteListener
{
  public anyw(VideoSprite.2 param2) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.this$0.mMediaPlayer.start();
      this.a.this$0.mIsPrepared = true;
      if (this.a.this$0.a != null) {
        this.a.this$0.mHandler.postDelayed(this.a.this$0, 33L);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "playVideo: " + QLog.getStackTraceString(paramMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyw
 * JD-Core Version:    0.7.0.1
 */