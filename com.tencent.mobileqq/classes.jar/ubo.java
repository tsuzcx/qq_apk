import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;

public class ubo
  implements ViewPager.OnPageChangeListener
{
  public ubo(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((QCirclePersonalBottomView.a(this.a) != null) && (QCirclePersonalBottomView.a(this.a).getChildCount() > paramInt)) {
      QCirclePersonalBottomView.a(this.a).getChildAt(paramInt).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubo
 * JD-Core Version:    0.7.0.1
 */