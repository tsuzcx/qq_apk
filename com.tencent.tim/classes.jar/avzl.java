import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.2;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class avzl
{
  private static avzl jdField_a_of_type_Avzl;
  private mobile_online_report_item jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
  private String cOw = "QZonlinetime";
  private String cOx = "QZonlinetimeLastRecord";
  int ezw = 0;
  private ArrayList<mobile_online_report_item> gw = new ArrayList();
  private ArrayList<mobile_online_report_item> gx = new ArrayList();
  private Runnable iD = new QzoneOnlineTimeCollectRptService.3(this);
  private long ib = 0L;
  private volatile boolean isForeground;
  private int mDelay = 10000;
  public long mUin = 0L;
  
  public static final avzl a()
  {
    if (jdField_a_of_type_Avzl == null) {
      jdField_a_of_type_Avzl = new avzl();
    }
    return jdField_a_of_type_Avzl;
  }
  
  private void aZ(ArrayList<mobile_online_report_item> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.ib = System.currentTimeMillis();
      paramArrayList = new ArrayList(paramArrayList);
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), avzm.class);
      localNewIntent.putExtra("list", paramArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
      return;
    }
    QLog.e("QzoneOnlineTimeCollectRptService", 1, "There is no record to report!");
  }
  
  private void eCS()
  {
    try
    {
      if (nQ())
      {
        if (this.gx.size() > 0) {
          this.gx.clear();
        }
        this.gx.addAll(this.gw);
        this.gw.clear();
        if (this.mUin != 0L) {
          aZ(this.gx);
        }
      }
      return;
    }
    finally {}
  }
  
  private void ig()
  {
    if ((this.gw != null) && (this.gw.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.gw.iterator();
      while (localIterator.hasNext())
      {
        mobile_online_report_item localmobile_online_report_item = (mobile_online_report_item)localIterator.next();
        if (localmobile_online_report_item != null) {
          localStringBuilder.append(localmobile_online_report_item.uptime + ";" + localmobile_online_report_item.downtime + ";");
        }
      }
      if (localStringBuilder.length() == 0) {
        break label249;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      LocalMultiProcConfig.putString(this.cOw + "_" + this.mUin, localStringBuilder.toString());
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "saveData mReportItems size:" + this.gw.size() + " mLastReportTime:" + this.ib + " re:" + localStringBuilder.toString());
      this.gw.clear();
    }
    for (;;)
    {
      LocalMultiProcConfig.putString(this.cOx + "_" + this.mUin, "");
      return;
      label249:
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "re length:0");
    }
  }
  
  private void initData()
  {
    if (this.mUin == 0L) {
      return;
    }
    long l1 = this.mUin;
    String str = LocalMultiProcConfig.getString(this.cOw + "_" + l1, "");
    Object localObject2 = LocalMultiProcConfig.getString(this.cOx + "_" + l1, "");
    long l2 = LocalMultiProcConfig.getLong("key_sp_qzone_crash_time_" + l1, 0L);
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.cOw + " lost time:" + (String)localObject2 + " sp:" + this.cOx + " crash time:" + l2);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (l2 != 0L)
      {
        localObject1 = localObject2;
        if (this.cOw.equals("QZonlinetime")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(";")) + ";" + l2;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str)) {
        localObject2 = str + ";" + (String)localObject1;
      }
      LocalMultiProcConfig.putString(this.cOw + "_" + l1, (String)localObject2);
      LocalMultiProcConfig.putString(this.cOx + "_" + l1, "");
    }
    for (;;)
    {
      LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + l1, 0L);
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "s:" + (String)localObject2);
      localObject1 = ((String)localObject2).split(";");
      if ((localObject1 == null) || (localObject1.length <= 1)) {
        break;
      }
      int i = 0;
      try
      {
        while (i < localObject1.length)
        {
          localObject2 = new mobile_online_report_item(l1, Long.parseLong(localObject1[i]), Long.parseLong(localObject1[(i + 1)]));
          this.gw.add(localObject2);
          i += 2;
        }
        localObject2 = str;
      }
      catch (Exception localException)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 1, "e:" + localException.toString());
        if ((this.gw.size() >= 1) && (this.gw.get(0) != null)) {
          this.ib = ((mobile_online_report_item)this.gw.get(0)).uptime;
        }
        eCS();
        return;
      }
    }
  }
  
  private boolean nQ()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    if (this.ib != 0L)
    {
      if ((System.currentTimeMillis() / 1000L - this.ib > localQzoneConfig.getConfig("ClientReport", "OnlineReportInterval", 3600)) || (this.gw.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1))) {
        bool1 = true;
      }
      return bool1;
    }
    if (this.gw.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void Il(int paramInt)
  {
    setType(paramInt);
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.1(this));
  }
  
  public void a(mobile_online_report_item parammobile_online_report_item)
  {
    if ((parammobile_online_report_item != null) && (parammobile_online_report_item.uptime != 0L) && (parammobile_online_report_item.downtime != 0L)) {
      this.gw.add(parammobile_online_report_item);
    }
    eCS();
  }
  
  public void acg(int paramInt)
  {
    if (paramInt != 1000)
    {
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService report failure resultCode:" + paramInt + " RetryTimes:" + this.ezw);
      if (this.ezw < 2)
      {
        aZ(this.gx);
        this.ezw += 1;
      }
      return;
    }
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService task succeed!");
    this.ezw = 0;
    if ((this.gx != null) && (this.gx.size() > 0))
    {
      paramInt = 0;
      while (paramInt < this.gx.size())
      {
        QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.cOw + " report uptime:" + ((mobile_online_report_item)this.gx.get(paramInt)).uptime + " downtime:" + ((mobile_online_report_item)this.gx.get(paramInt)).downtime);
        paramInt += 1;
      }
      this.gx.clear();
    }
    LocalMultiProcConfig.putString(this.cOw + "_" + this.mUin, "");
    LocalMultiProcConfig.putString(this.cOx + "_" + this.mUin, "");
  }
  
  public void eCO()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.2(this));
  }
  
  /* Error */
  public void eCP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   6: ifnonnull +31 -> 37
    //   9: aload_0
    //   10: new 169	NS_MOBILE_FEEDS/mobile_online_report_item
    //   13: dup
    //   14: invokespecial 350	NS_MOBILE_FEEDS/mobile_online_report_item:<init>	()V
    //   17: putfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   20: aload_0
    //   21: getfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   24: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   27: ldc2_w 299
    //   30: ldiv
    //   31: putfield 172	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   41: lconst_0
    //   42: putfield 184	NS_MOBILE_FEEDS/mobile_online_report_item:downtime	J
    //   45: aload_0
    //   46: getfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   49: lconst_0
    //   50: putfield 353	NS_MOBILE_FEEDS/mobile_online_report_item:loginuin	J
    //   53: aload_0
    //   54: getfield 349	avzl:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   57: lconst_0
    //   58: putfield 172	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   61: goto -41 -> 20
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	avzl
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	64	finally
    //   20	34	64	finally
    //   37	61	64	finally
  }
  
  public void eCQ()
  {
    try
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
      {
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.loginuin = this.mUin;
        a(this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void eCR()
  {
    mobile_online_report_item localmobile_online_report_item;
    if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime <= 0L) {
        break label185;
      }
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime == this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime) {
        localmobile_online_report_item = this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
      }
    }
    for (localmobile_online_report_item.downtime += 1L;; this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneOnlineTimeCollectRptService", 2, "update sp:" + this.cOx + " last time:" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      }
      LocalMultiProcConfig.putString(this.cOx + "_" + this.mUin, this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + ";" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      return;
      label185:
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime = (System.currentTimeMillis() / 1000L);
    }
  }
  
  public void setType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.cOw = "QZonlinetime";
      this.cOx = "QZonlinetimeLastRecord";
      return;
    case 1: 
      this.cOw = "QZonlinetime_web";
      this.cOx = "QZonlinetimeLastRecord_web";
      return;
    case 3: 
      this.cOw = "QZonlinetime_picture";
      this.cOx = "QZonlinetimeLastRecord_picture";
      return;
    }
    this.cOw = "QZonlinetime_video";
    this.cOx = "QZonlinetimeLastRecord_video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzl
 * JD-Core Version:    0.7.0.1
 */