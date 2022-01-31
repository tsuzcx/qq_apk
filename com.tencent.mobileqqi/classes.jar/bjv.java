import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bjv
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = false;
  
  bjv(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI, long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "ClickToRequestVideoRunnable-->Uin=" + this.jdField_a_of_type_Long + " videoSrv=" + this.jdField_a_of_type_Int + " needRequest=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)) {
      if (this.jdField_a_of_type_Int == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B7", "0X80041B7", 0, 0, "", "", "", "");
        if (!NetworkUtil.g((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          ReportController.b(null, "CliOper", "", "", "0X8004424", "0X8004424", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4) {
          this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.W();
        }
      }
    }
    for (;;)
    {
      MultiVideoCtrlLayerUI.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI);
      return;
      ReportController.b(null, "CliOper", "", "", "0X80041B8", "0X80041B8", 0, 0, "", "", "", "");
      if (NetworkUtil.g((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004423", "0X8004423", 0, 0, "", "", "", "");
      break;
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "ClickToRequestVideoRunnable-->Request Failed");
      }
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI != null) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjv
 * JD-Core Version:    0.7.0.1
 */