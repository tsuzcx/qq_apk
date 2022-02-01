import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.3.1;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ujo
  implements ViewPager.OnPageChangeListener
{
  public ujo(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      WSHomeFragment.c(this.a, true);
    }
    while (paramInt != 0) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WSHomeFragment.3.1(this), 100L);
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
    WSHomeFragment.b(this.a, true);
    String str;
    if (WSHomeFragment.b(this.a))
    {
      str = "feeds_fullscreen";
      WSHomeFragment.a(this.a);
      if (WSHomeFragment.a != 0) {
        break label146;
      }
      uyo.d("focus");
      WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
      if (WSHomeFragment.a(this.a) != null) {
        break label132;
      }
      paramInt = 0;
      label69:
      localWSPublicAccReport.reportAttentionClick(paramInt, str, WSHomeFragment.a(this.a));
      WSHomeFragment.a(this.a, 0);
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      WSPublicAccReport.getInstance().reportPageVisitExit(str);
      uvr.c();
    }
    for (;;)
    {
      if (WSHomeFragment.b(this.a)) {
        WSHomeFragment.a(this.a);
      }
      return;
      str = "feeds";
      break;
      label132:
      paramInt = WSHomeFragment.a(this.a).a();
      break label69;
      label146:
      if (WSHomeFragment.a == 1)
      {
        uyo.d(str);
        WSPublicAccReport.getInstance().reportRecommendClick(WSHomeFragment.a(this.a));
        WSPublicAccReport.getInstance().reportPageVisitEnter(str);
        WSPublicAccReport.getInstance().reportPageVisitExit("focus");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujo
 * JD-Core Version:    0.7.0.1
 */