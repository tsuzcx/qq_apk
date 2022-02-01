import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class zga
  extends ViewPager.SimpleOnPageChangeListener
{
  zga(zfz paramzfz) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.cbS = this.a.b.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    zfz.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zga
 * JD-Core Version:    0.7.0.1
 */