import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.SurfaceViewUtil;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

public class yle
  implements IMediaPlayer.OnPreparedListener
{
  public yle(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.a.b);
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid())) {
      FMToastUtil.a(2131437422);
    }
    do
    {
      do
      {
        return;
        SurfaceViewUtil.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.e, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.d(), this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.e());
      } while (this.a.j != 10);
      paramIMediaPlayer.a(localSurfaceHolder);
      this.a.jdField_a_of_type_Int = paramIMediaPlayer.c();
    } while (this.a.jdField_a_of_type_Int <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.a(this.a.jdField_a_of_type_Int));
    }
    this.a.d.setText(ShortVideoUtils.a(this.a.jdField_a_of_type_Int));
    this.a.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yle
 * JD-Core Version:    0.7.0.1
 */