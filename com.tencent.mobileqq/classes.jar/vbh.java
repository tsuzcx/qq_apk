import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import java.util.ArrayList;

public class vbh
  implements ViewPager.OnPageChangeListener
{
  public vbh(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFolderFragmentsPart.a(this.a, paramInt, 2);
    uxh.a();
    if ((QCircleFolderFragmentsPart.a(this.a) != null) && (QCircleFolderFragmentsPart.a(this.a).getChildCount() > paramInt)) {
      QCircleFolderFragmentsPart.a(this.a).getChildAt(paramInt).performClick();
    }
    if ((QCircleFolderFragmentsPart.a(this.a) != null) && (QCircleFolderFragmentsPart.a(this.a).size() > paramInt))
    {
      ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt)).a(paramInt);
      uzo localuzo = ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt)).a();
      if (localuzo != null) {
        QCircleFolderFragmentsPart.a(this.a, localuzo.a());
      }
    }
    this.a.b("tab_changed", Integer.valueOf(QCircleFolderFragmentsPart.a(this.a)));
    QCircleFolderFragmentsPart.a(this.a, QCircleFolderFragmentsPart.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbh
 * JD-Core Version:    0.7.0.1
 */