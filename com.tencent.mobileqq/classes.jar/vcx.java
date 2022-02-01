import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import java.util.ArrayList;

public class vcx
  implements ViewPager.OnPageChangeListener
{
  public vcx(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFolderFragmentsPart.a(this.a, paramInt, 2);
    uys.a();
    if ((QCircleFolderFragmentsPart.a(this.a) != null) && (QCircleFolderFragmentsPart.a(this.a).getChildCount() > paramInt)) {
      QCircleFolderFragmentsPart.a(this.a).getChildAt(paramInt).performClick();
    }
    if ((QCircleFolderFragmentsPart.b(this.a) != null) && (QCircleFolderFragmentsPart.b(this.a).size() > paramInt))
    {
      ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.b(this.a).get(paramInt)).a(paramInt);
      vbe localvbe = ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.b(this.a).get(paramInt)).a();
      if (localvbe != null) {
        QCircleFolderFragmentsPart.a(this.a, localvbe.a());
      }
    }
    this.a.b("tab_changed", Integer.valueOf(QCircleFolderFragmentsPart.a(this.a)));
    QCircleFolderFragmentsPart.a(this.a, QCircleFolderFragmentsPart.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcx
 * JD-Core Version:    0.7.0.1
 */