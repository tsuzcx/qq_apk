import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class auci
  implements AudioManager.OnAudioFocusChangeListener
{
  auci(aucd paramaucd) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (aucd.a(this.this$0) != null) {
      QLog.w("FileBrowserPresenterBase", 1, "onAudioFocusChange:mVideoView null!");
    }
    boolean bool;
    do
    {
      do
      {
        return;
        bool = aucd.a(this.this$0).isPlaying();
        if (paramInt != -2) {
          break;
        }
      } while (!bool);
      aucd.a(this.this$0);
      return;
    } while ((paramInt == 1) || (paramInt != -1) || (!bool));
    aucd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auci
 * JD-Core Version:    0.7.0.1
 */