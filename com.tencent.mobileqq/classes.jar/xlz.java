import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicInteger;

public class xlz
  implements ActionSheet.OnButtonClickListener
{
  public xlz(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.a.a.b.get() == 4) {
      this.a.a(false);
    }
    this.a.a.a("FlowCameraActivity");
    this.a.d();
    FlowCameraMqqAction.b("", "0X800656F", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlz
 * JD-Core Version:    0.7.0.1
 */