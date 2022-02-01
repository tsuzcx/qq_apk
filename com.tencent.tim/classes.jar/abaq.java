import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class abaq
  implements aqup.c
{
  public abaq(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(aqup paramaqup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.this$0.mDuration);
    }
    SurfaceHolder localSurfaceHolder = this.this$0.mSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid())) {
      ahao.OS(2131692345);
    }
    do
    {
      do
      {
        return;
        aqfk.a(this.this$0.mSurfaceView, this.this$0.cns, this.this$0.cnu, this.this$0.a.getVideoWidth(), this.this$0.a.getVideoHeight());
      } while (this.this$0.cny != 10);
      paramaqup.setDisplay(localSurfaceHolder);
      this.this$0.duration = paramaqup.getDuration();
    } while (this.this$0.duration <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.stringForTime(this.this$0.duration));
    }
    this.this$0.OX.setText(ShortVideoUtils.stringForTime(this.this$0.duration));
    this.this$0.p.setMax(this.this$0.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abaq
 * JD-Core Version:    0.7.0.1
 */