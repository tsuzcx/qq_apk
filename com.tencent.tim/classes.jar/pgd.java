import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class pgd
  implements RadioGroup.OnCheckedChangeListener
{
  public pgd(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QCirclePersonalBottomView.a(this.b).getId() == paramInt)
    {
      QCirclePersonalBottomView.a(this.b).setCurrentItem(0);
      ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.b).get(0)).onPageSelected(0);
      ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.b).get(1)).bhT();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if (QCirclePersonalBottomView.b(this.b).getId() == paramInt)
      {
        QCirclePersonalBottomView.a(this.b).setCurrentItem(1);
        ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.b).get(1)).onPageSelected(1);
        ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.b).get(0)).bhT();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgd
 * JD-Core Version:    0.7.0.1
 */