import android.view.SurfaceView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.qphone.base.util.QLog;

public class wyi
  implements IMediaPlayer.OnPlayStateListener
{
  public wyi(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.a.a.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "changePlayState, playState => " + this.a.a(paramInt));
      }
      return;
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyi
 * JD-Core Version:    0.7.0.1
 */