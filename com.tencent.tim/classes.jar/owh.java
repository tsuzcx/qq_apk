import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import java.util.ArrayList;

public class owh
  implements ViewPager.OnPageChangeListener
{
  public owh(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFolderFragmentsPart.a(this.this$0, paramInt, 2);
    ous.clearMemoryCache();
    if ((QCircleFolderFragmentsPart.a(this.this$0) != null) && (QCircleFolderFragmentsPart.a(this.this$0).getChildCount() > paramInt)) {
      QCircleFolderFragmentsPart.a(this.this$0).getChildAt(paramInt).performClick();
    }
    owa localowa;
    if ((QCircleFolderFragmentsPart.a(this.this$0) != null) && (QCircleFolderFragmentsPart.a(this.this$0).size() > paramInt))
    {
      ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.this$0).get(paramInt)).onPageSelected(paramInt);
      localowa = ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.this$0).get(paramInt)).a();
      if (localowa == null) {}
    }
    for (paramInt = localowa.getType();; paramInt = 0)
    {
      this.this$0.r("tab_changed", Integer.valueOf(paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owh
 * JD-Core Version:    0.7.0.1
 */