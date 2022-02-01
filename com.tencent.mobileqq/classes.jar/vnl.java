import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vnl
  implements RadioGroup.OnCheckedChangeListener
{
  public vnl(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QCirclePersonalBottomView.a(this.a).getId() == paramInt)
    {
      QCirclePersonalBottomView.a(this.a).setCurrentItem(0);
      QCirclePersonalBottomView.a(this.a, 0);
      QCirclePersonalBottomView.a(this.a, 19, 6);
    }
    for (;;)
    {
      this.a.a();
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if (QCirclePersonalBottomView.b(this.a).getId() == paramInt)
      {
        QCirclePersonalBottomView.a(this.a).setCurrentItem(1);
        QCirclePersonalBottomView.a(this.a, 1);
        QCirclePersonalBottomView.a(this.a, 20, 2);
      }
      else if (QCirclePersonalBottomView.c(this.a).getId() == paramInt)
      {
        QCirclePersonalBottomView.a(this.a).setCurrentItem(2);
        QCirclePersonalBottomView.a(this.a, 2);
        QCirclePersonalBottomView.a(this.a, 21, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnl
 * JD-Core Version:    0.7.0.1
 */