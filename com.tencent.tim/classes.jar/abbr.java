import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class abbr
  implements auuo
{
  public abbr(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.this$0.g.Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.this$0.g.S(0L);
    if (aqiw.isNetSupport(this.this$0))
    {
      this.this$0.a.EQ(true);
      this.this$0.bBM = true;
      ((alsb)this.this$0.app.getManager(91)).updateQzoneFeeds();
      return true;
    }
    paramView = this.this$0.mHandler.obtainMessage(2000, 0, 0);
    this.this$0.mHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.this$0.g.R(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbr
 * JD-Core Version:    0.7.0.1
 */