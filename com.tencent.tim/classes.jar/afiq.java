import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;

public class afiq
  extends afkn
{
  public afiq(MessengerService paramMessengerService) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    int i = 2;
    if (this.a.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      int j = Integer.valueOf(paramEmoticonPackage.epId).intValue();
      if (paramInt == 0) {
        i = 0;
      }
      for (;;)
      {
        paramEmoticonPackage = new Bundle();
        paramEmoticonPackage.putInt("packetid", j);
        paramEmoticonPackage.putInt("peoriodtype", 1);
        paramEmoticonPackage.putInt("resultcode", i);
        localMessage.setData(paramEmoticonPackage);
        this.a.mClient.send(localMessage);
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
        }
        return;
        if (paramInt != 11007) {
          if (paramInt == 11001) {
            i = 1;
          } else if (paramInt == 11000) {
            i = 6;
          } else {
            i = -1;
          }
        }
      }
      return;
    }
    catch (Exception paramEmoticonPackage)
    {
      return;
    }
    catch (RemoteException paramEmoticonPackage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afiq
 * JD-Core Version:    0.7.0.1
 */