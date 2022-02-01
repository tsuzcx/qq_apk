import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.a;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.d;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajja
  implements View.OnClickListener
{
  public ajja(TabPageIndicator paramTabPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    TabPageIndicator.a(this.this$0, SystemClock.uptimeMillis());
    Object localObject = paramView.getTag();
    if ((localObject instanceof TabPageIndicator.a)) {}
    for (localObject = (TabPageIndicator.a)localObject;; localObject = null)
    {
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        int i = TabPageIndicator.a(this.this$0).getCurrentItem();
        int j = ((TabPageIndicator.a)localObject).index;
        this.this$0.setCurrentItem(j);
        ((TabPageIndicator.a)localObject).arrow.setVisibility(0);
        TabPageIndicator.a(this.this$0).setCurrentItem(j);
        if ((i == j) && (TabPageIndicator.a(this.this$0) != null)) {
          TabPageIndicator.a(this.this$0).QZ(j);
        }
        if (TabPageIndicator.a(this.this$0) != null) {
          TabPageIndicator.a(this.this$0).wu(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajja
 * JD-Core Version:    0.7.0.1
 */