import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.a;
import java.util.Iterator;
import java.util.List;

public class riv
  implements ViewPager.OnPageChangeListener
{
  public riv(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.a)localIterator.next()).onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     riv
 * JD-Core Version:    0.7.0.1
 */