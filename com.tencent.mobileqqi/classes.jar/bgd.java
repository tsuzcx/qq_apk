import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

public class bgd
  implements Runnable
{
  public bgd(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.n) {
      ((AudioManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgd
 * JD-Core Version:    0.7.0.1
 */