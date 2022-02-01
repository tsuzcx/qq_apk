import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.battery.BatteryMonitor;
import com.tencent.qapmsdk.battery.config.BatteryConfig;
import com.tencent.qapmsdk.battery.config.CmdMeta;
import com.tencent.qapmsdk.battery.config.CpuMeta;
import com.tencent.qapmsdk.battery.config.GPSMeta;
import com.tencent.qapmsdk.battery.config.LogMeta;
import com.tencent.qapmsdk.battery.config.TrafficMeta;
import com.tencent.qapmsdk.battery.config.WakeLockMeta;
import com.tencent.qapmsdk.battery.config.WifiMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.ILogCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MainService;
import mqq.util.IServiceCmdCallback;

public class txw
  extends txq
  implements txi
{
  private AtomicBoolean br = new AtomicBoolean(false);
  private AtomicBoolean bs = new AtomicBoolean(false);
  private List<txv> qa = new ArrayList();
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  protected void bER()
  {
    Object localObject1 = oC();
    try
    {
      Object localObject2 = ((String)localObject1).split("\\|");
      localObject1 = localObject2[0].split(";");
      long l = Long.parseLong(localObject1[3]);
      localObject1 = new BatteryConfig(localObject1[2].equals("1"), (l + 60L) * 1000L);
      ((BatteryConfig)localObject1).cpuConfig = new CpuMeta().parse(localObject2[1]);
      ((BatteryConfig)localObject1).logConfig = new LogMeta().parse(localObject2[3]);
      ((BatteryConfig)localObject1).cmdConfig = new CmdMeta().parse(localObject2[4]);
      ((BatteryConfig)localObject1).wakeLockConfig = new WakeLockMeta().parse(localObject2[5]);
      ((BatteryConfig)localObject1).wifiConfig = new WifiMeta().parse(localObject2[6]);
      ((BatteryConfig)localObject1).gpsConfig = new GPSMeta().parse(localObject2[7]);
      if (BaseApplicationImpl.sProcessId == 1) {
        ((BatteryConfig)localObject1).trafficConfig = new TrafficMeta().parse(localObject2[2]);
      }
      localObject2 = new txx();
      QAPM.setProperty(306, localObject2);
      QLog.setLogCallback((QLog.ILogCallback)localObject2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("MSF.D.MonitorSocket");
      localArrayList.add("Q.msg.MsgProxy|addMsgQueue");
      localArrayList.add("Q.db.Cache|writeRunable");
      localArrayList.add("Q.msg.MsgProxy|writeRunable");
      localArrayList.add("Q.db.Cache|addMsgQueue");
      localArrayList.add("SQLiteOpenHelper| getWritableDatabase");
      localArrayList.add("SQLiteOpenHelper| getReadableDatabase");
      BatteryMonitor.getInstance().setLogWhite(localArrayList, 0);
      localArrayList = new ArrayList();
      localArrayList.add("OidbSvc.0x58b_0");
      BatteryMonitor.getInstance().setLogWhite(localArrayList, 150);
      localArrayList.clear();
      localArrayList.add("IncreaseURLSvr.QQHeadUrlReq");
      localArrayList.add("AvatarInfoSvr.QQHeadUrlReq");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 100);
      localArrayList.clear();
      localArrayList.add("OnlinePush.RespPush");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 120);
      localArrayList.clear();
      localArrayList.add("CliLogSvc.UploadReq");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 50);
      localArrayList.clear();
      localArrayList.add("OidbSvc.0x787_1");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 90);
      localArrayList.clear();
      localArrayList.add("friendlist.getTroopMemberList");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 40);
      localArrayList.clear();
      localArrayList.add("MessageSvc.PbDeleteMsg");
      BatteryMonitor.getInstance().setCmdWhite(localArrayList, 100);
      MainService.setServiceCmdCallback((IServiceCmdCallback)localObject2);
      BatteryMonitor.getInstance().setupConfig((BatteryConfig)localObject1);
      QLog.i("MagnifierSDK.QAPM.QAPMBatteryWrapper", 1, "openBattery");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("MagnifierSDK.QAPM.QAPMBatteryWrapper", 1, "openBattery", localException);
      }
    }
    this.qa.add(new txu());
    this.qa.add(new txz());
    this.qa.add(new txy());
  }
  
  public void bET()
  {
    if (this.bs.compareAndSet(false, true))
    {
      Iterator localIterator = this.qa.iterator();
      while (localIterator.hasNext()) {
        ((txv)localIterator.next()).onHookReady();
      }
    }
  }
  
  public String oC()
  {
    return b().getOldStrategy("0.002;0.000025;1;3600;5|5,30,60;5,0;5,1|5,30,60;5,1|2,200,300,20|2,30,40,20|30;3,10;10,120|3,15;10,300|3,15,10,300|1800|1800||0;0;8;8;5;5;1;0|");
  }
  
  public String oF()
  {
    return "battery";
  }
  
  protected void onAfterStart()
  {
    super.onAfterStart();
    if (this.br.get()) {
      bET();
    }
  }
  
  public void onGPSScan(String paramString, Object[] paramArrayOfObject)
  {
    BatteryMonitor.getInstance().onGPSScan(paramString, paramArrayOfObject);
  }
  
  public void onHookReady()
  {
    if ((this.br.compareAndSet(false, true)) && (isStarted())) {
      bET();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txw
 * JD-Core Version:    0.7.0.1
 */