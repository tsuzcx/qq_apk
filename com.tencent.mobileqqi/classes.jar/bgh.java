import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;

public class bgh
  implements Runnable
{
  public bgh(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = UITools.a(this.a.a());
    QAVNotification.a(this.a.jdField_a_of_type_AndroidContentContext).a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a, str);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgh
 * JD-Core Version:    0.7.0.1
 */