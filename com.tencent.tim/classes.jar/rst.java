import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rst
  implements View.OnClickListener
{
  public rst(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    this.a.setTab(localInteger.intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rst
 * JD-Core Version:    0.7.0.1
 */