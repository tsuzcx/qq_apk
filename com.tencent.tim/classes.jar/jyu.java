import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import java.util.ArrayList;

public class jyu
  implements ViewPager.OnPageChangeListener
{
  public jyu(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReadInJoyNativeAdFragment.a(this.this$0, Math.max(ReadInJoyNativeAdFragment.a(this.this$0), paramInt + 1));
    ((jyy)ReadInJoyNativeAdFragment.a(this.this$0).get(paramInt)).onResume();
    if (paramInt + 1 < ReadInJoyNativeAdFragment.a(this.this$0).size()) {
      ((jyy)ReadInJoyNativeAdFragment.a(this.this$0).get(paramInt + 1)).aBp();
    }
    if ((ReadInJoyNativeAdFragment.a(this.this$0) != null) && (ReadInJoyNativeAdFragment.a(this.this$0).MS == 1) && ((ReadInJoyNativeAdFragment.b(this.this$0) == 1) || (ReadInJoyNativeAdFragment.b(this.this$0) == 2)))
    {
      if (paramInt != ReadInJoyNativeAdFragment.a(this.this$0).size() - 1) {
        break label155;
      }
      ReadInJoyNativeAdFragment.a(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      ReadInJoyNativeAdFragment.a(this.this$0);
      return;
      label155:
      ReadInJoyNativeAdFragment.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyu
 * JD-Core Version:    0.7.0.1
 */