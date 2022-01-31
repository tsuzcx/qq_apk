import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.tencent.biz.subscribe.component.base.ComponentPageView;

public class wpi
  implements SwipeRefreshLayout.OnRefreshListener
{
  public wpi(ComponentPageView paramComponentPageView) {}
  
  public void onRefresh()
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpi
 * JD-Core Version:    0.7.0.1
 */