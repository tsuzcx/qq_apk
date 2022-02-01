import android.media.MediaPlayer;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.a;
import com.tencent.qphone.base.util.QLog;

public class aapb
  implements FixedSizeVideoView.a
{
  public aapb(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    if (EditLocalVideoActivity.b(this.this$0))
    {
      QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------3   mStartTime=" + EditLocalVideoActivity.c(this.this$0) + " mEndTime=" + EditLocalVideoActivity.d(this.this$0) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.this$0));
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.e(this.this$0));
      EditLocalVideoActivity.b(this.this$0, false);
      EditLocalVideoActivity.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (EditLocalVideoActivity.a(this.this$0) != null) {
        EditLocalVideoActivity.a(this.this$0).cwa();
      }
      do
      {
        return;
      } while (EditLocalVideoActivity.d(this.this$0) == 0);
      QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------4   mStartTime=" + EditLocalVideoActivity.c(this.this$0) + " mEndTime=" + EditLocalVideoActivity.d(this.this$0) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.this$0));
      paramFixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.c(this.this$0), EditLocalVideoActivity.d(this.this$0) - EditLocalVideoActivity.c(this.this$0));
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.c(this.this$0));
      paramFixedSizeVideoView.start();
    }
  }
  
  public void b(MediaPlayer paramMediaPlayer)
  {
    if (EditLocalVideoActivity.b(this.this$0))
    {
      QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------1   mStartTime=" + EditLocalVideoActivity.c(this.this$0) + " mEndTime=" + EditLocalVideoActivity.d(this.this$0) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.this$0));
      EditLocalVideoActivity.a(this.this$0).pause();
      paramMediaPlayer.seekTo(EditLocalVideoActivity.e(this.this$0));
      EditLocalVideoActivity.b(this.this$0, false);
      EditLocalVideoActivity.a(this.this$0).setVisibility(0);
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------2   mStartTime=" + EditLocalVideoActivity.c(this.this$0) + " mEndTime=" + EditLocalVideoActivity.d(this.this$0) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.this$0));
    paramMediaPlayer.seekTo(EditLocalVideoActivity.c(this.this$0));
    EditLocalVideoActivity.a(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */