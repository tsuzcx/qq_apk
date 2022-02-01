import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;

public class jxf
  implements ViewPager.OnPageChangeListener
{
  public jxf(VideoCoverFragment paramVideoCoverFragment, ViewPager.OnPageChangeListener paramOnPageChangeListener) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.d != null) {
      this.d.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.d != null) {
      this.d.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    VideoCoverFragment.a(this.this$0, paramInt);
    if (this.d != null) {
      this.d.onPageSelected(paramInt);
    }
    if (VideoCoverFragment.a(this.this$0) != null) {
      VideoCoverFragment.a(this.this$0).onPageSelected(paramInt);
    }
    if (VideoCoverFragment.a(this.this$0) != null) {
      VideoCoverFragment.a(this.this$0).a().setProgress(paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxf
 * JD-Core Version:    0.7.0.1
 */