import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import java.util.ArrayList;

public class tsh
  implements ViewPager.OnPageChangeListener
{
  public tsh(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFolderFragmentsPart.a(this.a, paramInt, 2);
    tql.a();
    if ((QCircleFolderFragmentsPart.a(this.a) != null) && (QCircleFolderFragmentsPart.a(this.a).getChildCount() > paramInt)) {
      QCircleFolderFragmentsPart.a(this.a).getChildAt(paramInt).performClick();
    }
    tsa localtsa;
    if ((QCircleFolderFragmentsPart.a(this.a) != null) && (QCircleFolderFragmentsPart.a(this.a).size() > paramInt))
    {
      ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt)).a(paramInt);
      localtsa = ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt)).a();
      if (localtsa == null) {}
    }
    for (paramInt = localtsa.a();; paramInt = 0)
    {
      this.a.b("tab_changed", Integer.valueOf(paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsh
 * JD-Core Version:    0.7.0.1
 */