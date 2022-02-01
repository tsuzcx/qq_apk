import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apim
  implements View.OnClickListener
{
  public apim(ComplexGuidViewPager paramComplexGuidViewPager) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.a.dZx();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apim
 * JD-Core Version:    0.7.0.1
 */