import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.OnViewPagerItemVisiableChangeListener;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;

class xqi
  implements VideoFilterViewPager.OnViewPagerItemVisiableChangeListener
{
  xqi(xqh paramxqh) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      NewFlowCameraActivity.b(this.a.a.a.a, true);
      if (this.a.a.a.a.d.getVisibility() == 0)
      {
        this.a.a.a.a.d.setVisibility(8);
        this.a.a.a.a.a.a(NewFlowCameraActivity.a(this.a.a.a.a));
      }
      return;
    }
    NewFlowCameraActivity.b(this.a.a.a.a, false);
    this.a.a.a.a.a.a(NewFlowCameraActivity.a(this.a.a.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqi
 * JD-Core Version:    0.7.0.1
 */