import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.UITools;

public class bky
  implements Runnable
{
  public bky(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.g))
    {
      this.a.e = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
      VideoControlUI localVideoControlUI = this.a;
      localVideoControlUI.h += 1;
      if ((this.a.f != null) && (!this.a.i)) {
        this.a.f.setText(this.a.e);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bky
 * JD-Core Version:    0.7.0.1
 */