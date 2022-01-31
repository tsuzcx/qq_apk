import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;

public class etj
  implements MediaPlayer.OnErrorListener
{
  public etj(VideoViewX paramVideoViewX) {}
  
  @TargetApi(8)
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.d(VideoViewX.a(this.a), "Error: " + paramInt1 + "," + paramInt2);
    VideoViewX.b(this.a);
    VideoViewX.c(this.a, -1);
    VideoViewX.d(this.a, -1);
    VideoViewX.b(this.a, true);
    if (VideoViewX.a(this.a) != null)
    {
      VideoViewX.a(this.a).d();
      VideoViewX.a(this.a).c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this.a.a);
    }
    if ((VideoViewX.a(this.a) != null) && (VideoViewX.a(this.a).onError(VideoViewX.a(this.a), paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etj
 * JD-Core Version:    0.7.0.1
 */