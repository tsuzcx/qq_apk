import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;

public class ylf
  implements IMediaPlayer.OnCompletionListener
{
  public ylf(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    if (this.a.j == 10) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ylf
 * JD-Core Version:    0.7.0.1
 */