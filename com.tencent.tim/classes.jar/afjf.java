import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class afjf
  implements IBinder.DeathRecipient
{
  public afjf(MessengerService.a parama) {}
  
  public void binderDied()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("MessengerService$IncomingHandler", 2, "-->binder died");
      MessengerService.a((MessengerService)this.this$0.gI.get());
      MessengerService.b((MessengerService)this.this$0.gI.get());
    }
    MessengerService localMessengerService;
    if (this.this$0.gI != null)
    {
      localMessengerService = (MessengerService)this.this$0.gI.get();
      if ((localMessengerService == null) || (localMessengerService.mClient == null)) {}
    }
    try
    {
      localMessengerService.mClient.getBinder().unlinkToDeath(MessengerService.a.a(this.this$0), 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MessengerService$IncomingHandler", 1, "-->binder died unlink to death error=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjf
 * JD-Core Version:    0.7.0.1
 */