import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost.3;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost.4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class awjf
  implements Observer
{
  public ArrayList<Bundle> EM = new ArrayList();
  public awje a;
  public QQAppInterface app;
  public boolean dnf;
  private Handler ee = new awjg(this, Looper.getMainLooper());
  ServiceConnection mServiceConnection = new awjh(this);
  
  public awjf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if ((this.app != null) && (this.app.b() != null)) {
      this.app.b().addObserver(this);
    }
    for (;;)
    {
      eAv();
      eDU();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost() construct!!!!! error: app == null");
      }
    }
  }
  
  private void cPi()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    do
    {
      do
      {
        return;
      } while (!localPluginCommunicationHandler.containsCmd("com.qqsmartdevice.remotecall"));
      localPluginCommunicationHandler.unregister("com.qqsmartdevice.remotecall");
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::unregisterRemoteCommand unregister CMD:com.qqsmartdevice.remotecall");
  }
  
  private void eDU()
  {
    if ((this.a == null) && (!this.dnf) && (this.app != null))
    {
      this.dnf = true;
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service now");
      this.ee.removeMessages(1);
      this.ee.sendEmptyMessageDelayed(1, 300000L);
      tar.a(this.app, "Net_Start_Service_Host", 0, 0, 0);
      awjb.a().f(this.app, this.mServiceConnection);
    }
  }
  
  public void eAu()
  {
    if ((this.EM.isEmpty()) || (this.a == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new SmartDeviceIPCHost.4(this));
        return;
      }
      while (!this.EM.isEmpty())
      {
        Bundle localBundle = (Bundle)this.EM.remove(0);
        localObject1 = "";
        Object localObject2 = localObject1;
        if (localBundle != null) {}
        try
        {
          localObject2 = localBundle.getString("notify_cmd");
          localObject1 = localObject2;
          localBundle.setClassLoader(getClass().getClassLoader());
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            QLog.d("SmartDeviceIPCHost", 2, "qq->plugin main thread doPostCachedMsg strNotifyCmd:" + (String)localObject2 + " thread:" + Thread.currentThread());
          }
          localObject1 = localObject2;
          this.a.b("com.qqsmartdevice.action.notify", localBundle);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + (String)localObject1);
        }
      }
    }
  }
  
  public void eAv()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    localPluginCommunicationHandler.register(new awji(this, "com.qqsmartdevice.remotecall"));
  }
  
  public void eo(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "params is null");
      }
    }
    Object localObject;
    do
    {
      boolean bool;
      syw localsyw;
      do
      {
        return;
        localObject = paramBundle.getString("notify_cmd");
        if ((this.a != null) || (this.app == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service not started strNotifyCmd:" + (String)localObject + " cached");
        }
        bool = paramBundle.getBoolean("forceStart", false);
        localsyw = (syw)this.app.getBusinessHandler(51);
      } while ((!bool) && ((localsyw == null) || (!localsyw.Nz())));
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service when post " + (String)localObject);
      eDU();
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new SmartDeviceIPCHost.3(this, paramBundle));
        return;
      }
      this.EM.add(paramBundle);
      eAu();
      return;
      eAu();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        this.a.b("com.qqsmartdevice.action.notify", paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, " plugin service transfer failed strNotifyCmd:" + (String)localObject);
  }
  
  public Bundle o(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    for (;;)
    {
      return paramBundle;
      String str = paramBundle.getString("notify_cmd");
      if ((this.a == null) && (this.app != null))
      {
        boolean bool = paramBundle.getBoolean("forceStart", false);
        paramBundle = (syw)this.app.getBusinessHandler(51);
        if ((bool) || ((paramBundle != null) && (paramBundle.Nz())))
        {
          QLog.d("SmartDeviceIPCHost", 1, "start plugin service when send " + str);
          eDU();
        }
        return null;
      }
      eAu();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        Bundle localBundle = this.a.transfer("com.qqsmartdevice.action.notify", paramBundle);
        paramBundle = localBundle;
        if (localBundle != null)
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service transfer failed strNotifyCmd:" + str);
        }
      }
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnDestory");
    }
    if (this.app != null)
    {
      if (this.app.b() != null) {
        this.app.b().deleteObserver(this);
      }
      this.app = null;
    }
    cPi();
  }
  
  public Bundle p(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("invoke_cmd");
    if ((QLog.isColorLevel()) && (!"invokeCmdGetFaceBitmap".equals(localObject))) {
      QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnRemoteInvoke strNotifyCmd:" + (String)localObject);
    }
    if (this.app == null) {
      return null;
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdOpenChatMsgActivity") == 0)
    {
      ((syw)this.app.getBusinessHandler(51)).bf(paramBundle);
      return null;
    }
    if (((String)localObject).equals("SmartDeviceHandler_makeSureProxyServiceStart"))
    {
      this.app.getBusinessHandler(50);
      if (this.a != null)
      {
        tar.a(this.app, "Net_Start_Service_Remote", 0, 1, 0);
        return null;
      }
      this.dnf = false;
      QLog.d("SmartDeviceIPCHost", 1, "try to start service again");
      eDU();
      tar.a(this.app, "Net_Start_Service_Remote", 0, 0, 0);
      return null;
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoChat") == 0)
    {
      if (!paramBundle.containsKey("devSubCode")) {
        break label726;
      }
      localObject = new HashMap();
      ((Map)localObject).put("devSubCode", paramBundle.getString("devSubCode"));
    }
    for (;;)
    {
      ChatActivityUtils.a(this.app, this.app.getApp().getApplicationContext(), 9500, paramBundle.getString("din"), paramBundle.getString("devName"), "", paramBundle.getBoolean("onlyAudio", false), paramBundle.getString("tinyid"), true, false, null, "from_internal", (Map)localObject);
      return null;
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoMessage") == 0)
      {
        szc.e(this.app, this.app.getApp().getApplicationContext(), paramBundle.getString("din"), paramBundle.getString("videoPath"));
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetBuddyName") == 0)
      {
        paramBundle = paramBundle.getString("Uin");
        paramBundle = aqgv.b(this.app, paramBundle, true);
        localObject = new Bundle();
        ((Bundle)localObject).putString("BuddyName", paramBundle);
        return localObject;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdTransFileController") == 0)
      {
        ((syw)this.app.getBusinessHandler(51)).bg(paramBundle);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetLockState") == 0)
      {
        i = afsf.a().a(this.app, BaseApplicationImpl.getApplication());
        paramBundle = new Bundle();
        paramBundle.putInt("LockState", i);
        return paramBundle;
      }
      if (((String)localObject).compareToIgnoreCase("qfind_localnotify") == 0)
      {
        long l = paramBundle.getLong("din");
        paramBundle = paramBundle.getString("msg");
        localObject = (MessageForText)anbi.d(-1000);
        ((MessageForText)localObject).msgtype = -1000;
        ((MessageForText)localObject).istroop = 9501;
        ((MessageForText)localObject).issend = 0;
        ((MessageForText)localObject).isread = false;
        ((MessageForText)localObject).selfuin = this.app.getCurrentAccountUin();
        ((MessageForText)localObject).senderuin = (l + "");
        ((MessageForText)localObject).frienduin = (l + "");
        ((MessageForText)localObject).msg = paramBundle;
        ((MessageForText)localObject).time = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
        this.app.a().T((MessageRecord)localObject);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("init_msgHandler") == 0)
      {
        this.app.getBusinessHandler(49);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetFaceBitmap") == 0)
      {
        paramBundle = paramBundle.getString("uin");
        paramBundle = this.app.getFaceBitmap(paramBundle, true);
        localObject = new Bundle();
        ((Bundle)localObject).putParcelable("face_bitmap", paramBundle);
        return localObject;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetUnreadMsgNum") != 0) {
        break;
      }
      paramBundle = paramBundle.getString("din");
      int i = this.app.a().A(paramBundle, 9501);
      paramBundle = new Bundle();
      paramBundle.putInt("unread", i);
      return paramBundle;
      label726:
      localObject = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 9501) && (this.app != null) && (this.app.a().A(paramObservable.frienduin, 9501) > 0))
      {
        paramObservable = new Bundle();
        paramObservable.putString("notify_cmd", "updateUnreadMsgsNum");
        eo(paramObservable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjf
 * JD-Core Version:    0.7.0.1
 */