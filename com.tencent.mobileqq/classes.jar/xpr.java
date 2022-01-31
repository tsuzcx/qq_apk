import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xpr
  implements Runnable
{
  public xpr(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    this.a.e.setImageDrawable(new ColorDrawable(-16777216));
    this.a.e.setVisibility(0);
    this.a.a.postDelayed(new xps(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpr
 * JD-Core Version:    0.7.0.1
 */