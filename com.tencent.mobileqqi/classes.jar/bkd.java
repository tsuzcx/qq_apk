import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.qphone.base.util.QLog;

public class bkd
  implements Runnable
{
  bkd(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.w();
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal());
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO_FAIL, true);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkd
 * JD-Core Version:    0.7.0.1
 */