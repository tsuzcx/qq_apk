import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public class cid
  extends Handler
{
  private WeakReference a;
  
  public cid(ContactListView paramContactListView)
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
      case 4: 
      default: 
        throw new RuntimeException("Unknown message: " + paramMessage.what);
      case 1: 
        localContactListView.l();
        return;
      case 2: 
        if ((ContactListView.a(localContactListView)) && (!localContactListView.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()))
        {
          localContactListView.g();
          ContactListView.a(localContactListView, false);
        }
        localContactListView.j();
        return;
      case 3: 
        localContactListView.j();
      }
    } while (NetworkUtil.e(localContactListView.getContext()));
    localContactListView.i();
    localContactListView.b("网络不可用，请稍候重试.");
    return;
    localContactListView.b = ((List)paramMessage.obj);
    localContactListView.jdField_a_of_type_Chy.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cid
 * JD-Core Version:    0.7.0.1
 */