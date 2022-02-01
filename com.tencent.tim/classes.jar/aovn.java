import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.2;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class aovn
  implements auuo
{
  public aovn(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.BN == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.BN)
    {
      paramView.Q(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.BN == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.S(l);
      if (!aqiw.isNetworkAvailable(this.a.getActivity())) {
        break label97;
      }
      this.a.bX(0, true);
      this.a.mHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.1(this), 300L);
    }
    for (;;)
    {
      ((Contacts.a)paramView.getTag()).bpP = true;
      return true;
      l = this.a.BN;
      break;
      label97:
      this.a.mHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.2(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.BN == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.BN)
    {
      paramView.R(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovn
 * JD-Core Version:    0.7.0.1
 */