import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class bgn
  implements MediaPlayer.OnCompletionListener
{
  public bgn(VideoController paramVideoController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion onClose");
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.g()) {
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
    this.a.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgn
 * JD-Core Version:    0.7.0.1
 */