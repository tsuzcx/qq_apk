import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import java.util.Iterator;
import java.util.List;

public class zfr
  implements ViewPager.OnPageChangeListener
{
  public zfr(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((zfs)localIterator.next()).b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfr
 * JD-Core Version:    0.7.0.1
 */