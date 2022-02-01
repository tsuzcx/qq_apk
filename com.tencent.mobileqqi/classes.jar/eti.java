import android.widget.TextView;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;

public class eti
  extends ContactBindObserver
{
  private eti(VoipAddressBookView paramVoipAddressBookView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = VoipAddressBookView.a(this.a).b();
    if (!paramBoolean1)
    {
      VoipAddressBookView.a(this.a);
      VoipAddressBookView.b(this.a);
      if (((i == 0) || (i == 4)) && (this.a.j == 0)) {
        VoipAddressBookView.a(this.a, 2131562782, 3000L);
      }
    }
    do
    {
      return;
      VoipAddressBookView.a(this.a).setEnabled(true);
      if (i == 4)
      {
        if (VoipAddressBookView.b(this.a).d())
        {
          VoipAddressBookView.a(this.a).a(new etj(this));
          return;
        }
        VoipAddressBookView.c(this.a);
        this.a.a.sendEmptyMessageDelayed(1, 0L);
        return;
      }
    } while (!VoipAddressBookView.d(this.a).i());
    VoipAddressBookView.a(this.a, 2131562875, 0L, false);
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((!paramBoolean) || (!NetworkUtil.e(this.a.getContext())))
    {
      VoipAddressBookView.d(this.a);
      VoipAddressBookView.e(this.a);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      VoipAddressBookView.f(this.a);
      VoipAddressBookView.a(this.a, true);
      if (!paramBoolean2) {
        VoipAddressBookView.g(this.a);
      }
      return;
    }
    VoipAddressBookView.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eti
 * JD-Core Version:    0.7.0.1
 */