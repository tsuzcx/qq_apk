import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import java.util.List;

public class ueg
  implements RadioGroup.OnCheckedChangeListener
{
  public ueg(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QCirclePersonalBottomView.a(this.a).getId() == paramInt)
    {
      QCirclePersonalBottomView.a(this.a).setCurrentItem(0);
      ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.a).get(0)).a(0);
      ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.a).get(1)).e();
    }
    while (QCirclePersonalBottomView.b(this.a).getId() != paramInt) {
      return;
    }
    QCirclePersonalBottomView.a(this.a).setCurrentItem(1);
    ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.a).get(1)).a(1);
    ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.a(this.a).get(0)).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */