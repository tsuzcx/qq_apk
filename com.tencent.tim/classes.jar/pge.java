import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;

public class pge
  implements ViewPager.OnPageChangeListener
{
  public pge(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((QCirclePersonalBottomView.a(this.b) != null) && (QCirclePersonalBottomView.a(this.b).getChildCount() > paramInt)) {
      QCirclePersonalBottomView.a(this.b).getChildAt(paramInt).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pge
 * JD-Core Version:    0.7.0.1
 */