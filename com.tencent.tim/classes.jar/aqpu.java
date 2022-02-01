import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aqpu
  implements MediaPlayer.OnCompletionListener
{
  aqpu(aqpt paramaqpt, AudioManager paramAudioManager) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    synchronized (this.this$0.lock)
    {
      ???.release();
      this.this$0.mediaPlayer = null;
      this.this$0.ebv = 0;
      this.this$0.mPlayProgress.setProgress(0);
      this.this$0.Fi.setImageDrawable(this.this$0.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847956));
      this.b.abandonAudioFocus(this.this$0.jdField_d_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    synchronized (this.this$0.a)
    {
      this.this$0.a.aNy = 6;
      return;
      ??? = finally;
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpu
 * JD-Core Version:    0.7.0.1
 */