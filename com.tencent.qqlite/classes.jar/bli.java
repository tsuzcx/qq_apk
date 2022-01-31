import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity.TabInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bli
  extends PagerAdapter
{
  private bli(SplashActivity paramSplashActivity) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (paramObject != null) {
      ((ViewPager)paramView).removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return SplashActivity.a(this.a).size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    QLog.e("instantiateItem", 4, "------viewpager position------" + paramInt);
    QLog.e("instantiateItem", 4, "------viewpager size------" + getCount());
    View localView = ((FrameActivity.TabInfo)SplashActivity.a(this.a).get(paramInt)).a.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bli
 * JD-Core Version:    0.7.0.1
 */