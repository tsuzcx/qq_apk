import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.VideoLayerUI;
import java.util.List;

public class blv
  implements Runnable
{
  public blv(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.e);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.f);
      RecvMsg localRecvMsg = (RecvMsg)this.a.jdField_a_of_type_JavaUtilList.remove(0);
      this.a.b(localRecvMsg);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.e, 3000L);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.f, 3000L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blv
 * JD-Core Version:    0.7.0.1
 */