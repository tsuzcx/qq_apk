import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;

public class afsc
{
  private static afsc a;
  private static byte[] lock = new byte[0];
  WtloginObserver d = new afse(this);
  private acfd e = new afsd(this);
  private WeakReference<QQAppInterface> gj;
  private Messenger mClient;
  
  private void Ii(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isWaiting", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setWaitingResponse");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    cp(localBundle2);
  }
  
  private void Ij(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("setMobileResult", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setMobileResult");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    cp(localBundle2);
  }
  
  private void Ne(int paramInt)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("checkDevLockSms_ret", paramInt);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "openEquipmentLock");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    cp(localBundle2);
  }
  
  public static afsc a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new afsc();
      }
      return a;
    }
  }
  
  private void closeWeb(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isBack", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "closeWeb");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    cp(localBundle2);
  }
  
  private void cp(Bundle paramBundle)
  {
    if (this.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.mClient.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("EquipLockWebImpl", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public static void unInit()
  {
    if (a != null) {
      synchronized (lock)
      {
        if ((a != null) && (a.gj != null))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)a.gj.get();
          if (localQQAppInterface != null) {
            localQQAppInterface.removeObserver(a.e);
          }
          a = null;
        }
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Messenger paramMessenger)
  {
    this.gj = new WeakReference(paramQQAppInterface);
    this.mClient = paramMessenger;
    paramQQAppInterface.addObserver(this.e);
  }
  
  public void ba(byte[] paramArrayOfByte)
  {
    QQAppInterface localQQAppInterface;
    if (this.gj != null)
    {
      localQQAppInterface = (QQAppInterface)this.gj.get();
      if (localQQAppInterface != null) {
        break label30;
      }
    }
    label30:
    for (int i = -1;; i = afsf.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), null, paramArrayOfByte, this.d))
    {
      Ne(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsc
 * JD-Core Version:    0.7.0.1
 */