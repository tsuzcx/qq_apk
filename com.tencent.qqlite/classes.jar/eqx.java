import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.QLog;

public class eqx
  implements AudioManager.OnAudioFocusChangeListener
{
  public eqx(VideoViewX paramVideoViewX) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case -2: 
    case -1: 
    case -3: 
      do
      {
        return;
        if (this.a.a())
        {
          this.a.c = true;
          this.a.b();
        }
        if (QLog.isColorLevel()) {
          QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,loss focus");
        }
        this.a.b = false;
        return;
      } while ((this.a.a()) && (!QLog.isColorLevel()));
      QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,temporarily lost audio focus");
      return;
    }
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).setVolume(1.0F, 1.0F);
    }
    if ((!this.a.a()) && (this.a.c)) {
      this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,gain focus");
    }
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqx
 * JD-Core Version:    0.7.0.1
 */