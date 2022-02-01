import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;

public class jwv
  implements ViewPager.OnPageChangeListener
{
  public jwv(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    PublicAccountAdvertisementActivity localPublicAccountAdvertisementActivity = this.this$0;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      PublicAccountAdvertisementActivity.a(localPublicAccountAdvertisementActivity, bool);
      return;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    PublicAccountAdvertisementActivity localPublicAccountAdvertisementActivity = this.this$0;
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      PublicAccountAdvertisementActivity.a(localPublicAccountAdvertisementActivity, bool);
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwv
 * JD-Core Version:    0.7.0.1
 */