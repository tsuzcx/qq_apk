package cooperation.hce;

import aaai;
import aacs;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import avfj;
import avfm;
import avfn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@RequiresApi(api=19)
public class HceService
  extends HostApduService
  implements avfn
{
  private int ewT;
  private PowerManager mPowerManager;
  
  private boolean aKA()
  {
    boolean bool2 = true;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = bool2;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (aaai)((AppRuntime)localObject).getManager(245);
      bool1 = bool2;
      if (localObject != null) {
        if (((aaai)localObject).a("vfcBusCard", 1, new String[] { "switch" }) != 1) {
          break label90;
        }
      }
    }
    label90:
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IpcModule", 2, "vfcSwitch:" + bool1);
      }
      return bool1;
    }
  }
  
  private boolean aKz()
  {
    if (Build.VERSION.SDK_INT < 20) {
      return this.mPowerManager.isScreenOn();
    }
    return this.mPowerManager.isInteractive();
  }
  
  public static boolean bc(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo != null) && (paramString.equals(localRunningAppProcessInfo.processName))) {
            return true;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IpcModule", 2, "check process -- HceProcess is  dead");
    }
    return false;
  }
  
  public void dZ(Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("IpcModule", 2, "sendCAPDU capdu: " + avfj.bytesToHexString(paramBundle.getByteArray("capdu")) + " vfcFlag: " + avfm.FO());
      }
      paramBundle.putString("vfcAccountFlag", avfm.FO());
      aacs.a().ctN();
      paramBundle = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:hce", 1, "ApduIpcModule", "sendCapdu", paramBundle);
      this.ewT += 1;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.data;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getByteArray("radpdu");
          if (QLog.isColorLevel()) {
            QLog.d("apdu", 2, "收到插件的rapdu: " + avfj.bytesToHexString(paramBundle));
          }
          sendResponseApdu(paramBundle);
        }
      }
      return;
    }
    catch (Throwable paramBundle) {}
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!BaseApplicationImpl.sApplication.isRuntimeReady())) {
      return;
    }
    this.mPowerManager = ((PowerManager)getSystemService("power"));
  }
  
  public void onDeactivated(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apdu", 2, "onDeactivated reson: " + paramInt + " 交互次数: " + this.ewT);
    }
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("IpcModule", 2, "commandApdu=" + BaseApplicationImpl.sApplication.isRuntimeReady() + ",sInjectResult=" + BaseApplicationImpl.sInjectResult);
        }
        if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!BaseApplicationImpl.sApplication.isRuntimeReady())) {
          return avfj.hT;
        }
        localObject = avfm.a();
        if (this.mPowerManager == null) {
          this.mPowerManager = ((PowerManager)getSystemService("power"));
        }
        if ((!aKA()) || (localObject == null) || (!((avfm)localObject).isLogin()) || (!aKz()))
        {
          if (QLog.isColorLevel()) {
            QLog.w("IpcModule", 2, "processCommandApdu isRuntimeReady=" + BaseApplicationImpl.sApplication.isRuntimeReady() + ",sInjectResult=" + BaseApplicationImpl.sInjectResult);
          }
          return avfj.hT;
        }
        if ((!bc(this, "com.tencent.mobileqq:hce")) || ((!((avfm)localObject).cH(this)) && (((avfm)localObject).B(paramArrayOfByte))))
        {
          ((avfm)localObject).hW = paramArrayOfByte;
          switch (((avfm)localObject).B(paramArrayOfByte))
          {
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        Object localObject;
        paramArrayOfByte.printStackTrace();
        break label340;
        continue;
      }
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putByteArray("capdu", paramArrayOfByte);
      dZ((Bundle)localObject);
      break label340;
      if (QLog.isColorLevel()) {
        QLog.w("IpcModule", 2, "from last startTime：" + (System.currentTimeMillis() - ((avfm)localObject).iM()));
      }
      if (System.currentTimeMillis() - ((avfm)localObject).iM() > 5000L)
      {
        ((avfm)localObject).ezK();
        startActivity(new Intent(this, HcePluginInstallActivity.class));
      }
    }
    label340:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.hce.HceService
 * JD-Core Version:    0.7.0.1
 */