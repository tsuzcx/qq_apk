import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.ui.DoubleVideoCtrlUI;

public class bjk
  implements Runnable
{
  public bjk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.a == null) || (this.a.e == null)) {
      return;
    }
    if (this.a.a.d())
    {
      this.a.e.setEnabled(true);
      return;
    }
    this.a.e.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjk
 * JD-Core Version:    0.7.0.1
 */