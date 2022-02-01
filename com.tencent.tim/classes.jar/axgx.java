import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.image.ApngImage;
import dov.com.qq.im.ae.play.AEPlayShowTabView;

class axgx
  extends ViewPager.SimpleOnPageChangeListener
{
  axgx(axgv paramaxgv) {}
  
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
    axgv.a(this.this$0).TX(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgx
 * JD-Core Version:    0.7.0.1
 */