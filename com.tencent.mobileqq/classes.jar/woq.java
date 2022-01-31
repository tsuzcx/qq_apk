import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class woq
  implements OverScrollViewListener
{
  public woq(TroopView paramTroopView) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    TroopView.a(this.a).c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    TroopView.a(this.a).a(0L);
    TroopView.a(this.a, false);
    TroopView.a(this.a);
    TroopView.a(this.a, true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    TroopView.a(this.a).b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     woq
 * JD-Core Version:    0.7.0.1
 */