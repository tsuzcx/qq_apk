import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nck
  implements View.OnClickListener
{
  long mLastTime = 0L;
  
  public nck(BaseTabbar paramBaseTabbar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastTime < 300L)
    {
      this.mLastTime = 0L;
      if (this.a.b != null) {
        this.a.b.pc(this.val$position);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mLastTime = l;
      this.a.setSelectedTab(this.val$position, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nck
 * JD-Core Version:    0.7.0.1
 */