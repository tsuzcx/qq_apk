import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.bizparts.QCircleAggregationFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import java.util.ArrayList;

public class uzr
  implements ViewPager.OnPageChangeListener
{
  public uzr(QCircleAggregationFragmentsPart paramQCircleAggregationFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleAggregationFragmentsPart.a(this.a, paramInt, 2);
    uxh.a();
    if ((QCircleAggregationFragmentsPart.a(this.a) != null) && (QCircleAggregationFragmentsPart.a(this.a).getChildCount() > paramInt)) {
      QCircleAggregationFragmentsPart.a(this.a).getChildAt(paramInt).performClick();
    }
    if ((QCircleAggregationFragmentsPart.a(this.a) != null) && (QCircleAggregationFragmentsPart.a(this.a).size() > paramInt))
    {
      ((QCircleBaseAggregationFragment)QCircleAggregationFragmentsPart.a(this.a).get(paramInt)).a(paramInt);
      uzo localuzo = ((QCircleBaseAggregationFragment)QCircleAggregationFragmentsPart.a(this.a).get(paramInt)).a();
      if (localuzo != null) {
        QCircleAggregationFragmentsPart.a(this.a, localuzo.a());
      }
    }
    this.a.b("tab_changed", Integer.valueOf(QCircleAggregationFragmentsPart.a(this.a)));
    QCircleAggregationFragmentsPart.a(this.a, QCircleAggregationFragmentsPart.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */