import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xmw
  implements CompoundButton.OnCheckedChangeListener
{
  public xmw(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    NewFlowCameraActivity.a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmw
 * JD-Core Version:    0.7.0.1
 */