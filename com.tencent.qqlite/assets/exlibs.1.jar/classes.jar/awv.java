import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity.TabInfo;
import java.util.List;

public class awv
  extends PagerAdapter
{
  private awv(NearbyActivity paramNearbyActivity) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (paramObject != null) {
      ((ViewPager)paramView).removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return NearbyActivity.a(this.a).size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = ((FrameActivity.TabInfo)NearbyActivity.a(this.a).get(paramInt)).a.a();
    if ((localView.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewPager)paramView).addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awv
 * JD-Core Version:    0.7.0.1
 */