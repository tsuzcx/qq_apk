import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi.2.1;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi.2.2;
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class rdr
  implements auuo
{
  rdr(rdp paramrdp) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.this$0.BN == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.this$0.BN)
    {
      paramView.Q(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.this$0.BN == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.S(l);
      if (!aqiw.isNetworkAvailable(this.this$0.getContext())) {
        break label118;
      }
      if (this.this$0.b != null) {
        this.this$0.b.bmN();
      }
      this.this$0.btk();
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.1(this), 300L);
    }
    for (;;)
    {
      ((Contacts.a)paramView.getTag()).bpP = true;
      return true;
      l = this.this$0.BN;
      break;
      label118:
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.2(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.this$0.BN == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.this$0.BN)
    {
      paramView.R(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdr
 * JD-Core Version:    0.7.0.1
 */