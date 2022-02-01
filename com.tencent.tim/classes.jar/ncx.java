import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class ncx
  implements AbsListView.e
{
  public ncx(DailyTitleBarSwitcher paramDailyTitleBarSwitcher) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 1) && (this.b.getVisibility() == 0))
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null)
      {
        paramInt1 = paramAbsListView.getHeight();
        paramInt2 = paramAbsListView.getTop();
        if ((paramInt1 != 0) && (paramInt2 != 0))
        {
          float f = paramInt2 * -1.0F / paramInt1;
          DailyTitleBarSwitcher.a(this.b, DailyTitleBarSwitcher.a(this.b).getInterpolation(f));
          return;
        }
        DailyTitleBarSwitcher.a(this.b, 0.0F);
        return;
      }
      DailyTitleBarSwitcher.a(this.b, 0.0F);
      return;
    }
    DailyTitleBarSwitcher.a(this.b, 1.0F);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setLayerType(0, null);
      return;
    }
    this.b.setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncx
 * JD-Core Version:    0.7.0.1
 */