import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import dov.com.qq.im.capture.poi.FacePoiUI.3.1;
import dov.com.qq.im.capture.poi.FacePoiUI.3.2;

public class axto
  implements auuo
{
  axto(axtm paramaxtm) {}
  
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
      if (!aqiw.isNetworkAvailable(this.this$0.mRootView.getContext())) {
        break label114;
      }
      axtm.a(this.this$0).bmN();
      axtm.a(this.this$0).btk();
      new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.3.1(this), 300L);
    }
    for (;;)
    {
      ((Contacts.a)paramView.getTag()).bpP = true;
      return true;
      l = this.this$0.BN;
      break;
      label114:
      new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.3.2(this), 300L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axto
 * JD-Core Version:    0.7.0.1
 */