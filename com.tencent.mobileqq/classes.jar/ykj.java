import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ykj
  implements Runnable
{
  public ykj(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (this.a.b())
    {
      if (this.a.b <= 0L) {
        this.a.h();
      }
      ShortVideoPlayActivity.a(this.a, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (ShortVideoPlayActivity.a(this.a) != 0L)
      {
        ShortVideoPlayActivity.a(this.a, (int)(ShortVideoPlayActivity.a(this.a) * 10000L / this.a.b + 0.5D));
        if (!ShortVideoPlayActivity.a(this.a))
        {
          this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(ShortVideoPlayActivity.a(this.a));
          this.a.b(ShortVideoPlayActivity.a(this.a));
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.g != 0L))
    {
      if (!this.a.jdField_f_of_type_Boolean) {
        break label352;
      }
      ShortVideoPlayActivity.b(this.a, (int)(this.a.jdField_f_of_type_Long * 10000L / this.a.g));
      if (this.a.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.a)) {
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.a));
      }
    }
    if ((this.a.c()) && (ShortVideoPlayActivity.c(this.a) > 0) && (ShortVideoPlayActivity.a(this.a) != null) && (ShortVideoPlayActivity.a(this.a).getVisibility() == 0))
    {
      String str = ShortVideoUtils.a(this.a.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.c(this.a) * 1024);
      ShortVideoPlayActivity.a(this.a).setText(str + "/s");
    }
    if (this.a.isFinishing()) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
      }
    }
    label352:
    while (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      return;
      ShortVideoPlayActivity.b(this.a, 10000);
      break;
    }
    ((MqqHandler)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ykj
 * JD-Core Version:    0.7.0.1
 */