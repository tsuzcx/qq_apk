import android.os.Handler;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.1;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.2;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.3;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.4;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.5;
import com.tencent.biz.subscribe.component.base.ComponentAdapter.1.6;

public class wpa
  extends RecyclerView.AdapterDataObserver
{
  wpa(woz paramwoz) {}
  
  public void onChanged()
  {
    woz.a(this.a).post(new ComponentAdapter.1.1(this));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    woz.a(this.a).post(new ComponentAdapter.1.2(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    woz.a(this.a).post(new ComponentAdapter.1.3(this, paramInt1, paramInt2, paramObject));
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    woz.a(this.a).post(new ComponentAdapter.1.4(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    woz.a(this.a).post(new ComponentAdapter.1.6(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    woz.a(this.a).post(new ComponentAdapter.1.5(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpa
 * JD-Core Version:    0.7.0.1
 */