import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.b;
import java.util.List;

public class ofi
  implements ViewPager.OnPageChangeListener
{
  public ofi(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      WSHomeFragment.b(this.this$0, true);
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        paramInt = 0;
        while (paramInt < WSHomeFragment.a(this.this$0).size())
        {
          Fragment localFragment = (Fragment)WSHomeFragment.a(this.this$0).get(paramInt);
          if ((localFragment instanceof WSBaseHomeFragment)) {
            ((WSBaseHomeFragment)localFragment).of(WSHomeFragment.mCurrentPageIndex);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((!WSHomeFragment.a(this.this$0)) || (WSHomeFragment.a(this.this$0) == null) || (WSHomeFragment.b(this.this$0) == null)) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      WSHomeFragment.a(this.this$0).e(paramFloat, true);
      WSHomeFragment.b(this.this$0).d(paramFloat, true);
      return;
    }
    WSHomeFragment.a(this.this$0).d(paramFloat, true);
    WSHomeFragment.b(this.this$0).e(paramFloat, true);
  }
  
  public void onPageSelected(int paramInt)
  {
    WSHomeFragment.mCurrentPageIndex = paramInt;
    WSHomeFragment.a(this.this$0, true);
    if (WSHomeFragment.mCurrentPageIndex == 0)
    {
      opn.pQ("focus");
      localWSPublicAccReport = WSPublicAccReport.getInstance();
      if (WSHomeFragment.a(this.this$0) == null)
      {
        paramInt = 0;
        localWSPublicAccReport.reportAttentionClick(paramInt);
        WSHomeFragment.a(this.this$0, 0);
        WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
        WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
      }
    }
    while (WSHomeFragment.mCurrentPageIndex != 1) {
      for (;;)
      {
        WSPublicAccReport localWSPublicAccReport;
        return;
        paramInt = WSHomeFragment.a(this.this$0).rR();
      }
    }
    opn.pQ("feeds");
    WSPublicAccReport.getInstance().reportRecommendClick();
    WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
    WSPublicAccReport.getInstance().reportPageVisitExit("focus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofi
 * JD-Core Version:    0.7.0.1
 */