import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.d;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.e;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajka
  implements View.OnClickListener
{
  public ajka(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onClick() called with: view = [" + paramView + "]");
    }
    MultiCardPageIndicator.a(this.this$0, SystemClock.uptimeMillis());
    Object localObject = paramView.getTag();
    if ((localObject instanceof MultiCardPageIndicator.a)) {}
    for (localObject = (MultiCardPageIndicator.a)localObject;; localObject = null)
    {
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        int i = MultiCardPageIndicator.a(this.this$0).getCurrentItem();
        int j = ((MultiCardPageIndicator.a)localObject).index;
        this.this$0.setCurrentItem(j);
        anot.a(null, "dc00898", "", "", "0X800A216", "0X800A216", 0, 0, "", "", "", "");
        ((MultiCardPageIndicator.a)localObject).arrow.setVisibility(0);
        MultiCardPageIndicator.a(this.this$0).setCurrentItem(j);
        if ((i == j) && (MultiCardPageIndicator.a(this.this$0) != null)) {
          MultiCardPageIndicator.a(this.this$0).QZ(j);
        }
        if (MultiCardPageIndicator.a(this.this$0) != null) {
          MultiCardPageIndicator.a(this.this$0).wu(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajka
 * JD-Core Version:    0.7.0.1
 */