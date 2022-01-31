import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;

public class wdp
  implements View.OnClickListener
{
  public wdp(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag();
    this.a.setTab(paramView.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdp
 * JD-Core Version:    0.7.0.1
 */