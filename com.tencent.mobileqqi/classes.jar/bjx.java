import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.qphone.base.util.QLog;

public class bjx
  implements Runnable
{
  public bjx(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "mVideoController == null WHY???");
      }
    }
    for (;;)
    {
      return;
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.h();
      if (i == 1)
      {
        String str = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131560212);
        if ((str != null) && (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_BAD.ordinal(), str);
        }
      }
      while ((this.a.j != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.j, 3000L);
        return;
        if ((i == 0) && (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_BAD.ordinal());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjx
 * JD-Core Version:    0.7.0.1
 */