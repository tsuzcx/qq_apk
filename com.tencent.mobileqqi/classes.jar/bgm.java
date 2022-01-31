import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgm
  implements MediaPlayer.OnCompletionListener
{
  public bgm(VideoController paramVideoController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion request");
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.f()) {
      return;
    }
    this.a.a(2131165204, 1, this.a.b);
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e = 6;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgm
 * JD-Core Version:    0.7.0.1
 */