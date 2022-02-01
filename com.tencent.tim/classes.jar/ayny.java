import android.support.v4.view.ViewPager.OnPageChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.a;
import java.util.Iterator;
import java.util.List;

public class ayny
  implements ViewPager.OnPageChangeListener
{
  public ayny(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.a)localIterator.next()).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = FaceViewPager.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.a)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.a)localIterator.next()).onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayny
 * JD-Core Version:    0.7.0.1
 */