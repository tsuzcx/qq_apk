import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import java.util.Iterator;
import java.util.List;

public class vcr
  implements ViewPager.OnPageChangeListener
{
  public vcr(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((vcs)localIterator.next()).b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcr
 * JD-Core Version:    0.7.0.1
 */