import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;

public class eti
  implements MediaPlayer.OnCompletionListener
{
  public eti(VideoViewX paramVideoViewX) {}
  
  @TargetApi(8)
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    VideoViewX.b(this.a);
    VideoViewX.c(this.a, 5);
    VideoViewX.d(this.a, 5);
    if (VideoViewX.a(this.a) != null)
    {
      VideoViewX.a(this.a).d();
      VideoViewX.a(this.a).c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this.a.a);
    }
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onCompletion(VideoViewX.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eti
 * JD-Core Version:    0.7.0.1
 */