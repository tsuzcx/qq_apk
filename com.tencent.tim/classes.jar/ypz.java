import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

public class ypz
  implements ypq.c
{
  public ypz(TroopView paramTroopView) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "AddContactTroopClassifyAdapter.onItemClickListener onItemClick. position:" + paramInt);
    }
    TroopView.a(this.b, TroopView.a(this.b).getCurrentItem());
    TroopView.b(this.b, paramInt);
    TroopView.a(this.b).setCurrentItem(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypz
 * JD-Core Version:    0.7.0.1
 */