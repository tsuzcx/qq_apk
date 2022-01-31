import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class wjk
  extends Handler
{
  public WeakReference a;
  
  public wjk(TroopView paramTroopView)
  {
    this.a = new WeakReference(paramTroopView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {}
    do
    {
      return;
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        TroopView.a(localTroopView).springBackOverScrollHeaderView();
        return;
      case 1: 
        TroopView.a(localTroopView).springBackOverScrollHeaderView();
        TroopView.a(localTroopView, 1, 2131434349);
        return;
      }
    } while ((!TroopView.a(localTroopView)) || (TroopView.b(localTroopView)));
    TroopView.f(localTroopView, true);
    TroopView.a(localTroopView, false);
    return;
    TroopView.a(localTroopView, true);
    return;
    TroopView.b(localTroopView);
    return;
    TroopView.c(localTroopView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjk
 * JD-Core Version:    0.7.0.1
 */