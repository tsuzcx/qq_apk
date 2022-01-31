import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;

class biz
  implements Handler.Callback
{
  biz(biy parambiy) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232201, true);
      this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(this.a.a.k);
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.a.k);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biz
 * JD-Core Version:    0.7.0.1
 */