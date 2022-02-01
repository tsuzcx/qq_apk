import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yqg
  implements zbi
{
  public yqg(TroopView paramTroopView) {}
  
  public void onRefresh()
  {
    if (anwa.aze())
    {
      localMessage = TroopView.a(this.b).obtainMessage(15);
      TroopView.a(this.b).sendMessage(localMessage);
    }
    do
    {
      return;
      if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
        break label105;
      }
      if (this.b.sV.size() <= 0) {
        break;
      }
    } while ((TroopView.a(this.b) == null) || (TroopView.a(this.b) == null));
    TroopView.a(this.b).refresh(TroopView.a(this.b).getCurrentItem());
    return;
    TroopView.b(this.b);
    return;
    label105:
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "refresh falied. network unavailable");
    }
    Message localMessage = TroopView.a(this.b).obtainMessage(13);
    TroopView.a(this.b).sendMessageDelayed(localMessage, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqg
 * JD-Core Version:    0.7.0.1
 */