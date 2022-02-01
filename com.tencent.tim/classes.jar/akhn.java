import android.graphics.Rect;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class akhn
{
  private int mPos;
  private ViewPager mViewPager;
  
  private boolean a(LinearLayout paramLinearLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLinearLayout != null)
    {
      View localView = paramLinearLayout.getChildAt(0);
      bool1 = bool2;
      if (localView != null)
      {
        Rect localRect = new Rect();
        paramLinearLayout.getHitRect(localRect);
        bool1 = bool2;
        if (localView.getLocalVisibleRect(localRect))
        {
          bool1 = bool2;
          if (localRect.top == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean c(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListView != null)
    {
      bool1 = bool2;
      if (paramListView.getFirstVisiblePosition() == 0)
      {
        paramListView = paramListView.getChildAt(0);
        if (paramListView != null)
        {
          bool1 = bool2;
          if (paramListView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private View e()
  {
    Object localObject = this.mViewPager.getAdapter();
    if ((localObject != null) && ((localObject instanceof FragmentPagerAdapter)))
    {
      localObject = ((akcx.d)localObject).a(this.mViewPager.getCurrentItem());
      if (localObject == null) {
        Log.i("NestScrollHelper", "getScrollableView: fragment is null");
      }
      if ((localObject instanceof NearbyMomentFragment)) {
        return ((NearbyMomentFragment)localObject).e();
      }
      if ((localObject instanceof NearbyProfileFragment)) {
        return ((NearbyProfileFragment)localObject).e();
      }
    }
    return null;
  }
  
  public boolean isTop()
  {
    View localView = e();
    if (localView == null)
    {
      Log.e("NestScrollHelper", "isTop: scrollableView is null");
      return true;
    }
    if ((localView instanceof ListView)) {
      return c((ListView)localView);
    }
    if ((localView instanceof LinearLayout)) {
      return a((LinearLayout)localView);
    }
    return true;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = e();
    if (localView == null) {
      Log.e("NestScrollHelper", "smoothScrollBy: scrollableView is null");
    }
    while (!(localView instanceof ListView)) {
      return;
    }
    ((ListView)localView).smoothScrollBy(paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhn
 * JD-Core Version:    0.7.0.1
 */