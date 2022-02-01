import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel;
import mqq.app.AppRuntime;

public class avgq
  extends AbstractPluginCommunicationChannel
{
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getNickName()
    throws RemoteException
  {
    String str = null;
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface != null) {
      str = localQQAppInterface.getCurrentNickname();
    }
    return str;
  }
  
  public String getSKey()
    throws RemoteException
  {
    String str = null;
    if (getAppInterface() != null) {
      str = "getSKey";
    }
    return str;
  }
  
  public String getSid()
    throws RemoteException
  {
    throw new RuntimeException("NotSupported!");
  }
  
  public long getUin()
    throws RemoteException
  {
    long l = 0L;
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface != null) {
      l = localQQAppInterface.getLongAccountUin();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgq
 * JD-Core Version:    0.7.0.1
 */