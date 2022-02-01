import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.a;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.qphone.base.util.QLog;

public class yqe
  implements ContactsBaseFragment.b
{
  public yqe(TroopView paramTroopView) {}
  
  public void ckJ()
  {
    if ((TroopView.a(this.b) != null) && (!TroopView.a(this.b).US())) {
      TroopView.a(this.b).scrollTo(0, TroopView.a(this.b).kk());
    }
  }
  
  public void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = TroopView.a(this.b);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(14, paramInt, i);
      TroopView.a(this.b).sendMessage(paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqe
 * JD-Core Version:    0.7.0.1
 */