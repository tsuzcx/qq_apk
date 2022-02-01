import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;

public class vnm
  implements ViewPager.OnPageChangeListener
{
  public vnm(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((QCirclePersonalBottomView.a(this.a) != null) && (QCirclePersonalBottomView.a(this.a).getChildCount() > paramInt)) {
      QCirclePersonalBottomView.a(this.a).getChildAt(paramInt).performClick();
    }
    if (paramInt == 1) {
      QCirclePersonalBottomView.a(this.a, 20, 1);
    }
    while (paramInt != 2) {
      return;
    }
    QCirclePersonalBottomView.a(this.a, 21, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnm
 * JD-Core Version:    0.7.0.1
 */