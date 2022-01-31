import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class zpc
  implements Runnable
{
  public zpc(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler) {}
  
  public void run()
  {
    while (!TroopQZoneUploadAlbumHandler.a(this.a)) {
      try
      {
        i = ((Integer)TroopQZoneUploadAlbumHandler.a(this.a).take()).intValue();
        if ((this.a.jdField_a_of_type_AndroidOsMessenger == null) || (this.a.jdField_a_of_type_AndroidOsMessenger.getBinder() == null) || (!this.a.jdField_a_of_type_AndroidOsMessenger.getBinder().isBinderAlive()) || (!this.a.jdField_a_of_type_AndroidOsMessenger.getBinder().pingBinder()))
        {
          QLog.i("UploadPhoto", 1, "需要重新创建连接");
          this.a.b();
          TroopQZoneUploadAlbumHandler.a(this.a);
          TroopQZoneUploadAlbumHandler.a(this.a).offer(Integer.valueOf(i));
          TroopQZoneUploadAlbumHandler.a(this.a, true);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        TroopQZoneUploadAlbumHandler.a(this.a, true);
        QLog.e("UploadPhoto", 1, localInterruptedException, new Object[0]);
        continue;
        Message localMessage = Message.obtain(null, 998, i, 0);
        if (this.a.b == null) {
          this.a.b = new Messenger(this.a.jdField_a_of_type_AndroidOsHandler);
        }
        localMessage.replyTo = this.a.b;
        this.a.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("UploadPhoto", 1, localRemoteException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpc
 * JD-Core Version:    0.7.0.1
 */