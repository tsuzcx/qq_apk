import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import java.util.List;

public class wzv
  extends PagerAdapter
{
  public wzv(CommonHbFragment paramCommonHbFragment) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)CommonHbFragment.b(this.a).get(paramInt));
  }
  
  public int getCount()
  {
    if (CommonHbFragment.b(this.a) != null) {
      return CommonHbFragment.b(this.a).size();
    }
    return 0;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)CommonHbFragment.b(this.a).get(paramInt), 0);
    return CommonHbFragment.b(this.a).get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzv
 * JD-Core Version:    0.7.0.1
 */