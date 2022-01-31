import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.lang.ref.WeakReference;

public class eya
  extends Handler
{
  private WeakReference a;
  
  public eya(VoipAddressBookView paramVoipAddressBookView)
  {
    this.a = new WeakReference(paramVoipAddressBookView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VoipAddressBookView localVoipAddressBookView = (VoipAddressBookView)this.a.get();
    if (localVoipAddressBookView == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message: " + paramMessage.what);
      case 1: 
        localVoipAddressBookView.k();
        return;
      case 2: 
        if ((VoipAddressBookView.a(localVoipAddressBookView)) && (!VoipAddressBookView.e(localVoipAddressBookView).i()))
        {
          VoipAddressBookView.i(localVoipAddressBookView);
          VoipAddressBookView.a(localVoipAddressBookView, false);
        }
        localVoipAddressBookView.j();
        localVoipAddressBookView.a.notifyDataSetChanged();
        return;
      }
      localVoipAddressBookView.j();
      localVoipAddressBookView.a.notifyDataSetChanged();
    } while (NetworkUtil.e(localVoipAddressBookView.getContext()));
    VoipAddressBookView.j(localVoipAddressBookView);
    VoipAddressBookView.a(localVoipAddressBookView, localVoipAddressBookView.getContext().getString(2131558968));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eya
 * JD-Core Version:    0.7.0.1
 */