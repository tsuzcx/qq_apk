import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class thq
  implements ViewPager.OnPageChangeListener
{
  thq(tho paramtho) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!TextUtils.isEmpty(tho.a(this.a)))
    {
      this.a.a(tho.a(this.a));
      tho.a(this.a, null);
      QLog.d("ViolaInitDelegate", 1, "violaViewPager onPageScrolled potition : " + paramInt1 + " , mCurrentPosition:" + tho.a(this.a));
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < tho.a(this.a).size())
    {
      ViolaBaseView localViolaBaseView = (ViolaBaseView)tho.a(this.a).get(i);
      if (localViolaBaseView != null)
      {
        if (i == paramInt) {
          break label56;
        }
        localViolaBaseView.a(false);
        localViolaBaseView.onActivityPause();
      }
      for (;;)
      {
        i += 1;
        break;
        label56:
        localViolaBaseView.a(true);
        localViolaBaseView.onActivityResume();
      }
    }
    tho.a(this.a, paramInt);
    tho.a(this.a).dealFlingEnableWhenSwitcher(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     thq
 * JD-Core Version:    0.7.0.1
 */