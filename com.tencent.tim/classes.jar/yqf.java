import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class yqf
  implements SimpleSlidingIndicator.b
{
  public yqf(TroopView paramTroopView) {}
  
  public int d(int paramInt, boolean paramBoolean)
  {
    int i = TroopView.a(this.b).getCurrentItem();
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onTabChanged. position:" + paramInt + " currentClassifyPos:" + i);
    }
    Object localObject = TroopView.a(this.b).a(i, false);
    if (localObject != null)
    {
      localObject = (AddContactViewPagerTroopFragment)localObject;
      ypn localypn = (ypn)this.b.sV.get(i);
      if ((paramInt >= 0) && (paramInt < localypn.re.size()))
      {
        localypn.caz = paramInt;
        ypn.a locala = (ypn.a)localypn.re.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).dK(locala.keyword, locala.tagName);
        anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, locala.tagName, localypn.itemName, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqf
 * JD-Core Version:    0.7.0.1
 */