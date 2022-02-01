import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class avhp
{
  private static avhp a;
  private List<avhp.a> LB;
  private final Object fZ = new Object();
  private Runnable mReportRunnable;
  
  public static avhp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avhp();
      }
      return a;
    }
    finally {}
  }
  
  private void a(avhp.a parama)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + parama);
    }
    synchronized (this.fZ)
    {
      if (this.LB == null) {
        this.LB = new ArrayList();
      }
      this.LB.add(parama);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    avhp localavhp = a();
    if (localavhp != null) {
      localavhp.a(new avhp.a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  private void eAh()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
    }
    for (;;)
    {
      return;
      synchronized (this.fZ)
      {
        List localList = this.LB;
        this.LB = null;
        if ((localList != null) && (localList.size() != 0))
        {
          ??? = anpc.a(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            avhp.a locala = (avhp.a)localIterator.next();
            ((anpc)???).collectPerformance(locala.getUin(), locala.getTagName(), locala.isSuccess(), locala.getDuration(), locala.getSize(), locala.ah(), null);
          }
        }
      }
    }
    localObject1.clear();
  }
  
  public static void erH()
  {
    avhp localavhp = a();
    if (localavhp != null) {
      localavhp.eAf();
    }
  }
  
  public static void erI()
  {
    avhp localavhp = a();
    if (localavhp != null) {
      localavhp.eAg();
    }
  }
  
  private static void start()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    avhp localavhp = a();
    if (localavhp != null) {
      localavhp.eAh();
    }
  }
  
  protected void destory()
  {
    eAg();
    try
    {
      a = null;
      return;
    }
    finally {}
  }
  
  public void eAf()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.mReportRunnable == null)
    {
      this.mReportRunnable = new QlinkReliableReport.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(this.mReportRunnable, 60000L);
    }
  }
  
  public void eAg()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.mReportRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mReportRunnable);
      this.mReportRunnable = null;
    }
  }
  
  protected void init() {}
  
  static class a
  {
    private boolean dnb;
    private long mDuration;
    private long mSize;
    private String mTagName;
    private String mUin;
    private HashMap<String, String> qA;
    
    public a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
    {
      this.mUin = paramString1;
      this.mTagName = paramString2;
      this.dnb = paramBoolean;
      this.mDuration = paramLong1;
      this.mSize = paramLong2;
      this.qA = paramHashMap;
    }
    
    public HashMap<String, String> ah()
    {
      return this.qA;
    }
    
    public long getDuration()
    {
      return this.mDuration;
    }
    
    public long getSize()
    {
      return this.mSize;
    }
    
    public String getTagName()
    {
      return this.mTagName;
    }
    
    public String getUin()
    {
      return this.mUin;
    }
    
    public boolean isSuccess()
    {
      return this.dnb;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin[");
      localStringBuilder.append(this.mUin);
      localStringBuilder.append("], tagName[");
      localStringBuilder.append(this.mTagName);
      localStringBuilder.append("], success[");
      localStringBuilder.append(this.dnb);
      localStringBuilder.append("], size[");
      localStringBuilder.append(this.mSize);
      localStringBuilder.append("]");
      localStringBuilder.append(this.dnb);
      return localStringBuilder.toString();
    }
  }
  
  public static class b
    extends acxq
  {
    public b(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
    {
      super(paramProxyManager);
    }
    
    protected void destory()
    {
      avhp.a().destory();
    }
    
    protected void init()
    {
      avhp.a().init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avhp
 * JD-Core Version:    0.7.0.1
 */