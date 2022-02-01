import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yte
  implements View.OnClickListener
{
  public yte(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    this.a.setTab(localInteger.intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yte
 * JD-Core Version:    0.7.0.1
 */