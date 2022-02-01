import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.b;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;

public class yqa
  implements HeaderScrollView.a
{
  public yqa(TroopView paramTroopView) {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (TroopView.a(this.b) != null) {
      TroopView.a(this.b).fY(paramInt1, paramInt2);
    }
    if (paramInt1 >= paramInt2) {
      if (!TroopView.a(this.b))
      {
        TroopView.a(this.b, true);
        if (this.b.a != null) {
          this.b.a.Ay(TroopView.a(this.b));
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!TroopView.a(this.b));
      TroopView.a(this.b, false);
    } while (this.b.a == null);
    this.b.a.Ay(TroopView.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqa
 * JD-Core Version:    0.7.0.1
 */