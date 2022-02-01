import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class tvc
  implements ViewPager.OnPageChangeListener
{
  tvc(tva paramtva) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!TextUtils.isEmpty(tva.a(this.a)))
    {
      this.a.a(tva.a(this.a));
      tva.a(this.a, null);
      QLog.d("ViolaInitDelegate", 1, "violaViewPager onPageScrolled potition : " + paramInt1 + " , mCurrentPosition:" + tva.a(this.a));
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < tva.a(this.a).size())
    {
      ViolaBaseView localViolaBaseView = (ViolaBaseView)tva.a(this.a).get(i);
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
    tva.a(this.a, paramInt);
    tva.a(this.a).dealFlingEnableWhenSwitcher(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvc
 * JD-Core Version:    0.7.0.1
 */