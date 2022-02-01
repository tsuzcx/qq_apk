import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class via
  implements ViewPager.OnPageChangeListener
{
  public via(NearbyActivity paramNearbyActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("onPageSelected", new Object[] { Integer.valueOf(this.this$0.bIw), Integer.valueOf(this.this$0.bIC), Integer.valueOf(paramInt) });
    }
    Object localObject = this.this$0;
    int i = ((NearbyActivity.TabInfo)this.this$0.mg.get(paramInt)).tabIndex;
    ((NearbyActivity)localObject).bIw = i;
    NearbyBaseFragment.dan = i;
    if ((this.this$0.mClickTime == 0L) && (this.this$0.bIw == 2))
    {
      this.this$0.mClickTime = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.this$0.mClickTime) });
      }
    }
    if ((this.this$0.Gp == 0L) && (this.this$0.bIw == 1))
    {
      this.this$0.Gp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "mNowClickTime", new Object[] { "onPageSelected", Long.valueOf(this.this$0.Gp) });
      }
    }
    if (this.this$0.bIC != paramInt) {
      this.this$0.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    }
    if (this.this$0.bIC != -1)
    {
      i = this.this$0.bIC;
      if (this.this$0.bIC != this.this$0.bIx) {
        break label411;
      }
      i = 9;
    }
    for (;;)
    {
      if (TextUtils.equals(acfp.m(2131708643), ((NearbyActivity.TabInfo)this.this$0.mg.get(paramInt)).tabName)) {
        i = 11;
      }
      int j = ((NearbyActivity.TabInfo)this.this$0.mg.get(paramInt)).reportId;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          ajrk.m("report_switch_tab", new Object[] { ((NearbyActivity.TabInfo)this.this$0.mg.get(paramInt)).tabName, Integer.valueOf(j) });
        }
        i = j;
      }
      ajrk.a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "switch_tab", i);
      localObject = this.this$0.a(paramInt);
      if (localObject != null) {
        ((NearbyBaseFragment)localObject).ckW();
      }
      return;
      label411:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     via
 * JD-Core Version:    0.7.0.1
 */