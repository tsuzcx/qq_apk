import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.qphone.base.util.QLog;

public class ylg
  implements IMediaPlayer.OnPlayStateListener
{
  public ylg(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.setVisibility(8);
      this.a.b.setImageResource(2130843369);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + this.a.a(paramInt));
      }
      return;
      this.a.b.setImageResource(2130843368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ylg
 * JD-Core Version:    0.7.0.1
 */