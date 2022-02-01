import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aqdv
  implements Handler.Callback
{
  MqqHandler b;
  QQAppInterface mApp;
  
  public aqdv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = new aurf(ThreadManager.getFileThreadLooper(), this);
  }
  
  public void Y(int paramInt1, String paramString, int paramInt2)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("headType", paramInt1);
    localBundle.putString("id", paramString);
    localBundle.putInt("idType", paramInt2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void d(Setting paramSetting)
  {
    this.mApp.a(paramSetting);
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    localEntityManager.persistOrReplace(paramSetting);
    localEntityManager.close();
  }
  
  public void g(ArrayList<String> paramArrayList, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)localEntityManager.find(Setting.class, (String)paramArrayList.get(i));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = paramLong;
          this.mApp.a(localSetting);
          localEntityManager.update(localSetting);
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      localEntityTransaction.commit();
      localEntityTransaction.end();
    }
  }
  
  public Setting getFaceSetting(String paramString)
  {
    return this.mApp.getFaceSetting(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage.what = 4139;
      ConnectNearbyProcService.b(paramMessage);
    }
  }
  
  public String rA()
  {
    return ((FriendListHandler)this.mApp.getBusinessHandler(1)).rA();
  }
  
  public String rz()
  {
    return ((FriendListHandler)this.mApp.getBusinessHandler(1)).rz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdv
 * JD-Core Version:    0.7.0.1
 */