import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;

public class bgo
  implements Runnable
{
  public bgo(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.a.a().j, null);
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.a.a().j, null, true, true);
    QAVNotification.a(this.a.jdField_a_of_type_AndroidContentContext).a(str, localBitmap, this.a.a().j, 44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgo
 * JD-Core Version:    0.7.0.1
 */