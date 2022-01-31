import android.media.MediaPlayer;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.OnTrimVDPlayCompelteListener;
import com.tencent.qphone.base.util.QLog;

public class xkc
  implements FixedSizeVideoView.OnTrimVDPlayCompelteListener
{
  public xkc(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    if (EditLocalVideoActivity.a(this.a))
    {
      QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------1   mStartTime=" + EditLocalVideoActivity.a(this.a) + " mEndTime=" + EditLocalVideoActivity.b(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.a(this.a).pause();
      paramMediaPlayer.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.c(this.a, false);
      EditLocalVideoActivity.b(this.a).setVisibility(0);
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------2   mStartTime=" + EditLocalVideoActivity.a(this.a) + " mEndTime=" + EditLocalVideoActivity.b(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
    paramMediaPlayer.seekTo(EditLocalVideoActivity.a(this.a));
    EditLocalVideoActivity.a(this.a).start();
  }
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    if (EditLocalVideoActivity.a(this.a))
    {
      QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------3   mStartTime=" + EditLocalVideoActivity.a(this.a) + " mEndTime=" + EditLocalVideoActivity.b(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.c(this.a, false);
      EditLocalVideoActivity.b(this.a).setVisibility(0);
    }
    while (EditLocalVideoActivity.b(this.a) == 0) {
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------4   mStartTime=" + EditLocalVideoActivity.a(this.a) + " mEndTime=" + EditLocalVideoActivity.b(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
    paramFixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.a(this.a), EditLocalVideoActivity.b(this.a) - EditLocalVideoActivity.a(this.a));
    paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.a(this.a));
    paramFixedSizeVideoView.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkc
 * JD-Core Version:    0.7.0.1
 */