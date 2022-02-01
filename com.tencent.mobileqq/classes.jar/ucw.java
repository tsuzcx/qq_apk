import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.List;

public class ucw
  implements ViewPager.OnPageChangeListener
{
  public ucw(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      WSHomeFragment.b(this.a, true);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        WSHomeFragment.a(this.a, WSHomeFragment.a);
        return;
      }
    } while (paramInt != 0);
    if (WSHomeFragment.a(this.a) != WSHomeFragment.a)
    {
      paramInt = 0;
      while (paramInt < WSHomeFragment.a(this.a).size())
      {
        Fragment localFragment = (Fragment)WSHomeFragment.a(this.a).get(paramInt);
        if ((localFragment instanceof uod)) {
          ((uod)localFragment).a(WSHomeFragment.a);
        }
        paramInt += 1;
      }
    }
    WSHomeFragment.a(this.a, WSHomeFragment.a);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((!WSHomeFragment.a(this.a)) || (WSHomeFragment.a(this.a) == null) || (WSHomeFragment.b(this.a) == null)) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      }
      while ((WSHomeFragment.b(this.a)) && (!this.a.b))
      {
        WSHomeFragment.a(this.a).a(paramFloat);
        WSHomeFragment.b(this.a).a(paramFloat);
        return;
        WSHomeFragment.a(this.a).b(paramFloat, true);
        WSHomeFragment.b(this.a).a(paramFloat, true);
        continue;
        WSHomeFragment.a(this.a).a(paramFloat, true);
        WSHomeFragment.b(this.a).b(paramFloat, true);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    WSHomeFragment.a = paramInt;
    WSHomeFragment.a(this.a, true);
    String str;
    if (WSHomeFragment.b(this.a))
    {
      str = "feeds_fullscreen";
      WSHomeFragment.a(this.a);
      if (WSHomeFragment.a != 0) {
        break label130;
      }
      ups.d("focus");
      WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
      if (WSHomeFragment.a(this.a) != null) {
        break label116;
      }
      paramInt = 0;
      label60:
      localWSPublicAccReport.reportAttentionClick(paramInt, str);
      WSHomeFragment.a(this.a, 0);
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      WSPublicAccReport.getInstance().reportPageVisitExit(str);
      umw.c();
    }
    for (;;)
    {
      if (WSHomeFragment.b(this.a)) {
        WSHomeFragment.a(this.a);
      }
      return;
      str = "feeds";
      break;
      label116:
      paramInt = WSHomeFragment.a(this.a).a();
      break label60;
      label130:
      if (WSHomeFragment.a == 1)
      {
        ups.d(str);
        WSPublicAccReport.getInstance().reportRecommendClick();
        WSPublicAccReport.getInstance().reportPageVisitEnter(str);
        WSPublicAccReport.getInstance().reportPageVisitExit("focus");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucw
 * JD-Core Version:    0.7.0.1
 */