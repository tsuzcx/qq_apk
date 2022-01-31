import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;

public class bje
  implements Runnable
{
  public bje(AVActivity paramAVActivity) {}
  
  public void run()
  {
    int i = 0;
    int j;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(j, i);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e, null);
      return;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bje
 * JD-Core Version:    0.7.0.1
 */