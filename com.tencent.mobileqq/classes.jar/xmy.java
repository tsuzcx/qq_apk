import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;

public class xmy
  implements Runnable
{
  public xmy(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    int i = (int)(this.a.a.getHeight() * 0.35F);
    ViewGroup.LayoutParams localLayoutParams = this.a.c.getLayoutParams();
    localLayoutParams.height = (i - this.a.d.getHeight());
    this.a.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmy
 * JD-Core Version:    0.7.0.1
 */