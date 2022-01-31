import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class vsf
  implements OverScrollViewListener
{
  public vsf(HotChatPie paramHotChatPie) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    HotChatPie.a(this.a).setPullType(0);
    HotChatPie.a(this.a).c(HotChatPie.j);
    HotChatPie.a(this.a, 0, this.a.a.a());
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsf
 * JD-Core Version:    0.7.0.1
 */