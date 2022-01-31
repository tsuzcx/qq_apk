import android.view.View;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class dme
  implements OverScrollViewListener
{
  public dme(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.b.r())
    {
      SubAccountMessageActivity.a(this.a).a();
      return;
    }
    SubAccountMessageActivity.a(this.a).c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.b.r()) {
      return true;
    }
    SubAccountMessageActivity.a(this.a).a(0L);
    SubAccountMessageActivity.b(this.a, true);
    SubAccountMessageActivity.a(this.a, true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.b.r()) {
      return;
    }
    SubAccountMessageActivity.a(this.a).b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dme
 * JD-Core Version:    0.7.0.1
 */