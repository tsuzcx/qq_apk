import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.tencent.biz.qqcircle.component.ComponentPageView;

public class tvl
  implements SwipeRefreshLayout.OnRefreshListener
{
  public tvl(ComponentPageView paramComponentPageView) {}
  
  public void onRefresh()
  {
    if (ComponentPageView.a(this.a) != null) {
      ComponentPageView.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvl
 * JD-Core Version:    0.7.0.1
 */