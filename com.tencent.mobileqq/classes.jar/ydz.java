import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.tencent.biz.subscribe.component.base.ComponentPageView;

public class ydz
  implements SwipeRefreshLayout.OnRefreshListener
{
  public ydz(ComponentPageView paramComponentPageView) {}
  
  public void onRefresh()
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydz
 * JD-Core Version:    0.7.0.1
 */