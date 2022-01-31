import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yer
  implements SeekBar.OnSeekBarChangeListener
{
  public yer(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
    this.a.d();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStopTrackingTouch: 当前位置为 = " + i);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer != null)
    {
      if (this.a.a() == 2) {
        this.a.b();
      }
      this.a.c.setImageResource(2130843336);
      this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a();
      this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(i);
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.b.setEnabled(false);
      this.a.b.setTextColor(-2130706433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yer
 * JD-Core Version:    0.7.0.1
 */