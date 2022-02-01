import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aafm
  implements View.OnClickListener
{
  public aafm(ViewPagerTabLayout paramViewPagerTabLayout) {}
  
  public void onClick(View paramView)
  {
    int i = ViewPagerTabLayout.a(this.b).indexOfChild(paramView);
    if (i != -1)
    {
      if (ViewPagerTabLayout.a(this.b).getCurrentItem() == i) {
        break label92;
      }
      if (ViewPagerTabLayout.a(this.b)) {
        break label81;
      }
      this.b.setCurrentTab(i, false);
      if (ViewPagerTabLayout.a(this.b) != null) {
        ViewPagerTabLayout.a(this.b).FR(i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label81:
      this.b.setCurrentTab(i);
      break;
      label92:
      if (ViewPagerTabLayout.a(this.b) != null) {
        ViewPagerTabLayout.a(this.b).FS(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafm
 * JD-Core Version:    0.7.0.1
 */