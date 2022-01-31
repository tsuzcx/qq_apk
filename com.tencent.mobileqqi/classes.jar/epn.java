import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.lang.ref.WeakReference;

public class epn
  extends Handler
{
  private WeakReference a;
  
  public epn(ContactListView paramContactListView)
  {
    this.a = new WeakReference(paramContactListView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ContactListView localContactListView = (ContactListView)this.a.get();
    if (localContactListView == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message: " + paramMessage.what);
      case 1: 
        localContactListView.k();
        return;
      case 2: 
        if ((ContactListView.a(localContactListView)) && (!localContactListView.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i()))
        {
          localContactListView.g();
          ContactListView.a(localContactListView, false);
        }
        localContactListView.j();
        localContactListView.jdField_a_of_type_Epj.notifyDataSetChanged();
        return;
      }
      localContactListView.j();
      localContactListView.jdField_a_of_type_Epj.notifyDataSetChanged();
    } while (NetworkUtil.e(localContactListView.getContext()));
    localContactListView.i();
    localContactListView.b(localContactListView.getContext().getString(2131558968));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epn
 * JD-Core Version:    0.7.0.1
 */