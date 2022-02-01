import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;

public class yqi
  extends ViewPager.SimpleOnPageChangeListener
{
  public yqi(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (anwa.aze()) {}
    while (paramInt != 1) {
      return;
    }
    TroopView.a(this.b, TroopView.a(this.b).getCurrentItem());
  }
  
  public void onPageSelected(int paramInt)
  {
    if (anwa.aze()) {
      return;
    }
    TroopView.a(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqi
 * JD-Core Version:    0.7.0.1
 */