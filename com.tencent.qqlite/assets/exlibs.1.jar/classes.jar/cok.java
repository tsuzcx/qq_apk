import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class cok
  implements MediaPlayer.OnPreparedListener
{
  public cok(ShortVideoPreviewActivity paramShortVideoPreviewActivity, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + ShortVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity));
    }
    ShortVideoPreviewActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity);
    ShortVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity).start();
    if (this.jdField_a_of_type_Int > 0) {
      ShortVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity).seekTo(this.jdField_a_of_type_Int);
    }
    ShortVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cok
 * JD-Core Version:    0.7.0.1
 */