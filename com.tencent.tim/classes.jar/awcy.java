import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.util.QZoneDistributedAppCtrl.1;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class awcy
  implements Handler.Callback
{
  private static awcy a;
  private static Object lock = new Object();
  public static String mUin;
  
  awcy(String paramString)
  {
    mUin = paramString;
  }
  
  private void A(boolean paramBoolean, int paramInt, String paramString)
  {
    LocalMultiProcConfig.putBool("comboqz_protect_enable", paramBoolean);
    LocalMultiProcConfig.putInt("qzapp_vercode", paramInt);
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        LocalMultiProcConfig.putString("qzh5_url", paramString);
      }
      LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", false);
      LocalMultiProcConfig.putString("comboqz_qua", avpq.getQUA3());
    }
  }
  
  public static awcy a(String paramString)
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new awcy(paramString);
      }
      return a;
    }
  }
  
  public static void au(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("key_rndev_bundle_url");
    paramMap = (String)paramMap.get("key_rndev_bundle_on");
    LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
    LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", paramMap);
    QLog.i("QZoneDistributedAppCtrl", 1, "rnbundleurl=" + str + ",rndevon=" + paramMap);
  }
  
  private void b(awcy.a parama)
  {
    boolean bool2 = false;
    int i = parama.cmd;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    long l2;
    switch (i)
    {
    case 6: 
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
    case 4: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
      do
      {
        do
        {
          return;
          eDk();
          return;
          avpw.jdMethod_do(BaseApplicationImpl.getContext(), mUin);
          return;
        } while (!(localObject instanceof QQAppInterface));
        avpw.e((AppRuntime)localObject, true);
        return;
        eDk();
      } while (!(localObject instanceof QQAppInterface));
      avpw.bp((QQAppInterface)localObject, "QZoneDistributedAppCtrl");
      return;
    case 7: 
      parama = (String)parama.data.get("key_upload_dbname");
      awcu.at(BaseApplicationImpl.getContext(), mUin, parama);
      return;
    case 8: 
      awcu.dq(BaseApplicationImpl.getContext(), mUin);
      return;
    case 9: 
      localObject = (String)parama.data.get("key_trace_baseTime");
      parama = (String)parama.data.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(parama)) {
          break label451;
        }
        l2 = 1800000L;
        label311:
        if (l1 > 0L) {
          break label1189;
        }
        l1 = System.currentTimeMillis();
      }
      break;
    }
    label451:
    boolean bool1;
    label1189:
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          l3 = l2;
          if (l2 <= 0L) {
            l3 = 1800000L;
          }
          l2 = l1 - l3;
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + l2 + "ms\t offsettime: " + l3 + "\t trace endTime: " + l1 + "ms");
          }
          awcu.b(BaseApplicationImpl.getContext(), mUin, l2, l1);
          return;
          try
          {
            l1 = Long.valueOf((String)localObject).longValue();
            l1 *= 1000L;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            l1 = 0L;
          }
        }
        break;
        try
        {
          l2 = Long.valueOf(parama).longValue();
          l2 *= 1000L;
        }
        catch (NumberFormatException parama)
        {
          parama.printStackTrace();
          l2 = 0L;
        }
      }
      break label311;
      String str = (String)parama.data.get("key_avsdk_startTime");
      parama = (String)parama.data.get("key_avsdk_endTime");
      long l3 = awcu.bs(str);
      l2 = awcu.bs(parama);
      if (l3 == -1L) {
        break;
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = System.currentTimeMillis();
      }
      l2 = l1;
      if (l3 > l1) {
        l2 = System.currentTimeMillis();
      }
      awcu.c(BaseApplicationImpl.getContext(), mUin, l3, l2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str + ",endTime=" + parama);
      return;
      awcu.ds(BaseApplicationImpl.getContext(), mUin);
      return;
      try
      {
        bool1 = Boolean.parseBoolean((String)parama.data.get("key_qzcombo_protect"));
        parama = (String)parama.data.get("key_ctrl_param_enable");
      }
      catch (Throwable parama)
      {
        for (;;)
        {
          try
          {
            i = Integer.parseInt((String)parama.data.get("key_qzapp_versioncode"));
          }
          catch (Throwable parama)
          {
            i = 82;
            continue;
          }
          try
          {
            parama = (String)parama.data.get("key_qzh5_url");
            A(bool1, i, parama);
            return;
          }
          catch (Throwable parama)
          {
            continue;
            bool1 = false;
            continue;
          }
          parama = parama;
          i = 82;
          bool1 = bool2;
          QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", parama);
          parama = "";
        }
      }
      if (!TextUtils.isEmpty(parama)) {
        ServerListProvider.enableDebug(Boolean.valueOf(parama).booleanValue());
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param：" + parama);
      return;
      parama = (String)parama.data.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(parama))
      {
        if (!Boolean.valueOf(parama).booleanValue()) {
          break label881;
        }
        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + parama);
        return;
        label881:
        LocalMultiProcConfig.putString("LooperMonitor", "-1");
      }
      str = (String)parama.data.get("key_path_tencent");
      if (TextUtils.isEmpty(str))
      {
        str = (String)parama.data.get("key_path_data");
        bool1 = true;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        parama = (String)parama.data.get("key_upload_maxsize");
        try
        {
          l1 = Long.valueOf(parama).longValue();
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("CMD_UPLOAD_CUSTOM, param：");
            if (bool1)
            {
              parama = "dataPath";
              QLog.w("QZoneDistributedAppCtrl", 4, parama + "," + str);
            }
          }
          else
          {
            awcu.a(BaseApplicationImpl.getContext(), str, mUin, l1, bool1);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param：" + parama + ",error:Not long");
            }
            l1 = 1048576L;
            continue;
            parama = "tencentPath";
          }
        }
        str = (String)parama.data.get("key_wns_config_main");
        parama = (String)parama.data.get("key_wns_config_second");
        QzoneConfig.getInstance().printWNSConfig(str, parama);
        aqtz.efH();
        return;
        parama = (String)parama.data.get("key_url");
        awcu.dr(BaseApplicationImpl.getContext(), parama);
        return;
        au(parama.data);
        return;
      }
    }
  }
  
  private void c(awcy.a parama)
  {
    int i = parama.cmd;
    switch (i)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
      break;
    }
  }
  
  public static void eDk()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
  }
  
  public void a(awcy.a parama)
  {
    if (parama != null) {
      ThreadManager.executeOnNetWorkThread(new QZoneDistributedAppCtrl.1(this, parama));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      b((awcy.a)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((awcy.a)paramMessage.obj);
    }
  }
  
  public static final class a
  {
    public int cmd;
    public Map<String, String> data = new HashMap();
    
    public String toString()
    {
      return "ctrl:[cmd = " + this.cmd + ", data = " + this.data + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcy
 * JD-Core Version:    0.7.0.1
 */