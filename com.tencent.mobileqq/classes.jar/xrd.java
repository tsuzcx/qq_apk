import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xrd
  implements Runnable
{
  public xrd(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (!this.a.a.isEnabled())) {
      this.a.a.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrd
 * JD-Core Version:    0.7.0.1
 */