import android.text.TextUtils;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconConfig.Builder;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.TimBeaconReport.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class anpl
{
  private static final AtomicBoolean sInit = new AtomicBoolean(false);
  
  private static void a(EventResult paramEventResult)
  {
    if ((!paramEventResult.isSuccess()) && (paramEventResult.errorCode != 101) && (QLog.isColorLevel())) {
      QLog.d("TIMBeaconReport", 2, "EventResult{ eventID:" + paramEventResult.eventID + ", errorCode: " + paramEventResult.errorCode + ", errorMsg: " + paramEventResult.errMsg + "}");
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    if (aurs.aJC())
    {
      ThreadManagerV2.excute(new TimBeaconReport.1(paramString1, paramString2, paramString3, paramBoolean1, paramHashMap, paramBoolean2), 16, null, false);
      return;
    }
    b(paramString1, paramString2, paramString3, paramBoolean1, paramHashMap, paramBoolean2);
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a(paramString1, paramString2, true, paramHashMap, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean1, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    a("", paramString1, paramString2, paramBoolean1, paramHashMap, paramBoolean2);
  }
  
  private static boolean ayD()
  {
    return false;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString3)) {
      throw new RuntimeException("report a event with a empty key!");
    }
    BeaconEvent.Builder localBuilder = BeaconEvent.builder();
    if (!TextUtils.isEmpty(paramString1)) {
      localBuilder.withAppKey(paramString1);
    }
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.put("user_uin", paramString2);
    }
    localBuilder.withCode(paramString3);
    localBuilder.withIsSucceed(paramBoolean1);
    if (paramBoolean2) {
      localBuilder.withType(EventType.REALTIME);
    }
    localBuilder.withParams(paramString1);
    paramString1 = localBuilder.build();
    a(BeaconReport.getInstance().report(paramString1));
  }
  
  public static void c(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    a(paramString1, paramString2, paramHashMap, false);
  }
  
  public static void dSO()
  {
    anpj localanpj = anpj.a(BaseApplication.getContext());
    BeaconReport.getInstance().setAndroidID(localanpj.getAndroidID());
    BeaconReport.getInstance().setImei(localanpj.getImei());
    BeaconReport.getInstance().setImsi(localanpj.getImsi());
    BeaconReport.getInstance().setMac(localanpj.getMac());
    BeaconReport.getInstance().setModel(localanpj.getModel());
    BeaconReport.getInstance().setWifiMacAddress(localanpj.getWifiMacAddress());
    BeaconReport.getInstance().setImei2(localanpj.getImei2());
    BeaconReport.getInstance().setMeid(localanpj.getMeid());
    BeaconReport.getInstance().setOaid(localanpj.getOaid());
    BeaconReport.getInstance().setWifiSSID(localanpj.getWifiSSID());
  }
  
  private static void dSP()
  {
    anpm localanpm = new anpm();
    BeaconReport.getInstance().setLogger(localanpm);
  }
  
  public static void start()
  {
    start("");
  }
  
  public static void start(String paramString)
  {
    BaseApplication localBaseApplication;
    BeaconConfig localBeaconConfig;
    BeaconReport localBeaconReport;
    if (sInit.compareAndSet(false, true))
    {
      localBaseApplication = BaseApplication.getContext();
      if (aciu.abf()) {
        dSO();
      }
      localBeaconConfig = BeaconConfig.builder().auditEnable(false).setNormalPollingTime(30000L).qmspEnable(false).build();
      localBeaconReport = BeaconReport.getInstance();
      if (!ayD()) {
        break label133;
      }
      localBeaconReport.setLogAble(true);
      dSP();
    }
    for (;;)
    {
      localBeaconReport.setChannelID(AppSetting.getChannelId());
      if (!TextUtils.isEmpty(paramString)) {
        localBeaconReport.setAppVersion(paramString);
      }
      localBeaconReport.start(localBaseApplication, "0S20046TOQ1DG0PE", localBeaconConfig);
      QimeiSDK.getInstance().init(localBaseApplication);
      QLog.d("TIMBeaconReport", 1, new Object[] { "start: isDebugVersion = ", Boolean.valueOf(false), ", appVersion: ", paramString });
      return;
      label133:
      localBeaconReport.setLogAble(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpl
 * JD-Core Version:    0.7.0.1
 */