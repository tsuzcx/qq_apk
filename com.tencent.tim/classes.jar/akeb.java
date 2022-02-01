import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

class akeb
  implements ViewPager.OnPageChangeListener
{
  akeb(akcx paramakcx) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.this$0.b.setSelectedTab(paramInt, true);
    Object localObject = (NearbyBaseFragment)this.this$0.mFragmentManager.findFragmentByTag("android:switcher:2131382093:" + paramInt);
    if (localObject != null) {
      ((NearbyBaseFragment)localObject).ckW();
    }
    if (this.this$0.a.mMode == 2)
    {
      if (paramInt == 0) {
        this.this$0.BB.setVisibility(8);
      }
    }
    else
    {
      if (paramInt != 0) {
        break label289;
      }
      localanov = new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.this$0.a.mMode != 2) {
        break label283;
      }
    }
    label283:
    for (localObject = "1";; localObject = "2")
    {
      localanov.a(new String[] { localObject }).report();
      return;
      this.this$0.BB.setVisibility(0);
      localanov = new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(akcx.a(this.this$0).uin);
      if (this.this$0.a.mMode == 2) {}
      for (localObject = "1";; localObject = "2")
      {
        localanov.a(new String[] { localObject }).report();
        break;
      }
    }
    label289:
    anov localanov = new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(akcx.a(this.this$0).uin);
    if (this.this$0.a.mMode == 2) {}
    for (localObject = "1";; localObject = "2")
    {
      localanov.a(new String[] { localObject }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akeb
 * JD-Core Version:    0.7.0.1
 */