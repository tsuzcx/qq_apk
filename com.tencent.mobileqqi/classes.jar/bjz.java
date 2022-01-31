import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.ui.MultiVideoEnterPage;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.qphone.base.util.QLog;

public class bjz
  implements Runnable
{
  public bjz(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "RefreshFaceRunnable");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.b();
    }
    if (this.a.c) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjz
 * JD-Core Version:    0.7.0.1
 */