import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.qphone.base.util.QLog;

public class bji
  implements Runnable
{
  public bji(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "5s has past, remote has not open camera!");
    }
    if ((!this.a.b) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a == 2)) {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bji
 * JD-Core Version:    0.7.0.1
 */