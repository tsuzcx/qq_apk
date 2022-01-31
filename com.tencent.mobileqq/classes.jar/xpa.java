import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class xpa
  extends OrientationEventListener
{
  public xpa(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpa
 * JD-Core Version:    0.7.0.1
 */