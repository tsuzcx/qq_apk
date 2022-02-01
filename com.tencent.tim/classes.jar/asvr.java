import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qphone.base.util.QLog;

class asvr
  implements IBinder.DeathRecipient
{
  asvr(asvq paramasvq, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    this.val$service.unlinkToDeath(this, 0);
    asvp.a(this.a.a, null);
    QLog.i("MusicPlayerProxyImpl", 2, "linkToDeath binderDied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvr
 * JD-Core Version:    0.7.0.1
 */