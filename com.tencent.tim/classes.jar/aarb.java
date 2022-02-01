import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21.1.1;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.b;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;

public class aarb
  implements VideoFilterViewPager.b
{
  public aarb(NewFlowCameraActivity.21.1.1 param1) {}
  
  public void Go(int paramInt)
  {
    if (paramInt == 0)
    {
      NewFlowCameraActivity.b(this.a.a.a.this$0, true);
      if (this.a.a.a.this$0.zZ.getVisibility() == 0)
      {
        this.a.a.a.this$0.zZ.setVisibility(8);
        this.a.a.a.this$0.a.Dh(NewFlowCameraActivity.a(this.a.a.a.this$0));
      }
      return;
    }
    NewFlowCameraActivity.b(this.a.a.a.this$0, false);
    this.a.a.a.this$0.a.Dh(NewFlowCameraActivity.a(this.a.a.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarb
 * JD-Core Version:    0.7.0.1
 */