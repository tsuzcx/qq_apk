import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;

public class bkc
  implements Runnable
{
  bkc(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    boolean bool = false;
    this.a.M();
    MultiVideoCtrlLayerUI.a(this.a);
    VideoAppInterface localVideoAppInterface = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (this.a.c == 2) {
      bool = true;
    }
    localVideoAppInterface.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(bool) });
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkc
 * JD-Core Version:    0.7.0.1
 */