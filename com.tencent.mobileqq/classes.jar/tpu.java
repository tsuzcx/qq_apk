import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class tpu
  extends AccessibilityDelegateCompat
{
  public tpu(XViewPager paramXViewPager) {}
  
  private boolean a()
  {
    return (XViewPager.a(this.a) != null) && (XViewPager.a(this.a).getCount() > 1);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(XViewPager.class.getName());
    paramView = AccessibilityRecordCompat.obtain();
    paramView.setScrollable(a());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (XViewPager.a(this.a) != null))
    {
      paramView.setItemCount(XViewPager.a(this.a).getCount());
      paramView.setFromIndex(XViewPager.a(this.a));
      paramView.setToIndex(XViewPager.a(this.a));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(XViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(a());
    if (this.a.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.a.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.a.canScrollHorizontally(1))
      {
        this.a.setCurrentItem(XViewPager.a(this.a) + 1);
        return true;
      }
      return false;
    }
    if (this.a.canScrollHorizontally(-1))
    {
      this.a.setCurrentItem(XViewPager.a(this.a) - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpu
 * JD-Core Version:    0.7.0.1
 */