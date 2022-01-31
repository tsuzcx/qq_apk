import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.qphone.base.util.QLog;

public class bjy
  implements Runnable
{
  public bjy(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "PressCameraBtnRunnable");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label85;
      }
      this.a.z();
    }
    for (;;)
    {
      if (!this.a.h) {
        this.a.h = true;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      return;
      label85:
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "onEnterRoomSuc-->go on stage fail,can not find the session");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjy
 * JD-Core Version:    0.7.0.1
 */