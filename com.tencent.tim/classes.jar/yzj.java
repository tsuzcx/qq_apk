import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class yzj
  extends ViewPager.SimpleOnPageChangeListener
{
  yzj(yzf paramyzf) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      yzf.a(this.b, yzf.a(this.b).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + yzf.b(this.b) + "  mPageChangedByIndicator:" + yzf.a(this.b));
    }
    if (yzf.a(this.b)) {
      yzf.b(this.b, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    yzf.a(this.b, paramInt);
    if (!yzf.a(this.b)) {
      anot.a(this.b.mApp, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + yzf.b(this.b) + " mPageChangedByIndicator:" + yzf.a(this.b));
    }
    yzf.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzj
 * JD-Core Version:    0.7.0.1
 */