import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.util.SurfaceViewUtil;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

public class xdx
  implements IMediaPlayer.OnPreparedListener
{
  public xdx(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "mMediaPlayer onPrepared: ");
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid()))
    {
      FMToastUtil.a(2131437422);
      return;
    }
    SurfaceViewUtil.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.n, this.a.o, this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.d(), this.a.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.e());
    paramIMediaPlayer.a(localSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdx
 * JD-Core Version:    0.7.0.1
 */