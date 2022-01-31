import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

class bja
  implements Handler.Callback
{
  bja(biy parambiy) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if ((this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().h) && (!this.a.a.jdField_a_of_type_ComTencentAvVideoController.c())) {
        this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232201, this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
      }
    }
    else {
      return false;
    }
    this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232201, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bja
 * JD-Core Version:    0.7.0.1
 */