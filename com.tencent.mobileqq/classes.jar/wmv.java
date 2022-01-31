import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.ContactsViewController;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class wmv
  implements Handler.Callback
{
  public wmv(ContactsViewController paramContactsViewController) {}
  
  private void a()
  {
    if (ContactsViewController.a(this.a) != null) {
      ContactsViewController.a(this.a).setRefreshing(false);
    }
    if (ContactsViewController.a(this.a) != null) {
      ContactsViewController.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      QQToast.a(this.a.a(), 1, 2131434349, 0).b(ContactsViewController.a(this.a));
      a();
      return false;
    case 4: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label134;
        }
        ContactsViewController.a(this.a);
        if (ContactsViewController.a(this.a) == null) {
          break;
        }
        ContactsViewController.a(this.a).a(0);
        this.a.a.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      a();
      QQToast.a(this.a.a(), 1, 2131434349, 0).b(ContactsViewController.a(this.a));
      return false;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmv
 * JD-Core Version:    0.7.0.1
 */