import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.ContactsViewController;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.mobileqq.statistics.ReportController;

public class wsg
  extends ViewPager.SimpleOnPageChangeListener
{
  public wsg(ContactsViewController paramContactsViewController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ContactsViewController.a(this.a, ContactsViewController.a(this.a).getCurrentItem());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ContactsViewController.a(this.a, paramInt);
    if (!ContactsViewController.a(this.a)) {
      ReportController.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    ContactsViewController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsg
 * JD-Core Version:    0.7.0.1
 */