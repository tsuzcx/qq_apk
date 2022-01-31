import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.widget.SeekBar;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cnn
  implements MediaPlayer.OnPreparedListener
{
  public cnn(ShortVideoPlayActivity paramShortVideoPlayActivity, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mMediaPlayer onPrepared: mDuration=" + ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity));
    }
    if (ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) <= 0) {
      ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
    }
    ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
    if (ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.c();
      }
    }
    do
    {
      return;
      ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, false);
      ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).setVisibility(0);
      return;
      ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).start();
      if (this.jdField_a_of_type_Int > 0)
      {
        ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).seekTo(this.jdField_a_of_type_Int);
        ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).setProgress(this.jdField_a_of_type_Int);
      }
      ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, 1);
      ShortVideoPlayActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
    } while ((ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).getVideoWidth() != 0) && (ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).getVideoHeight() != 0));
    ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, 3);
    ShortVideoPlayActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnn
 * JD-Core Version:    0.7.0.1
 */