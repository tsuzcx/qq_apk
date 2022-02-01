import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yqj
  implements SimpleCheckableSlidingIndicator.b
{
  public yqj(TroopView paramTroopView) {}
  
  public void Eu(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRepeatClick. position:" + paramInt);
    }
    if (paramInt != -1)
    {
      TroopView.a(this.b).setCurrentPosition(-1, false);
      int i = TroopView.a(this.b).getCurrentItem();
      if (QLog.isColorLevel()) {
        QLog.i("addContacts.TroopView", 2, "onCurrentTabClick. position:" + paramInt + " currentClassifyPos:" + i);
      }
      Object localObject = TroopView.a(this.b).a(i, false);
      if (localObject != null)
      {
        localObject = (AddContactViewPagerTroopFragment)localObject;
        ypn localypn = (ypn)this.b.sV.get(i);
        localypn.caz = -1;
        ((AddContactViewPagerTroopFragment)localObject).dK(localypn.keyword, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */