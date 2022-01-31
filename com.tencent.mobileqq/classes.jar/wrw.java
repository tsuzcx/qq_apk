import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.biz.videostory.capture.AEPlayShowTabView;
import com.tencent.image.ApngImage;

class wrw
  extends ViewPager.SimpleOnPageChangeListener
{
  wrw(wru paramwru) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      ApngImage.resumeAll();
      return;
    }
    ApngImage.pauseAll();
  }
  
  public void onPageSelected(int paramInt)
  {
    wru.a(this.a).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */