import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeReporter.2;
import com.tencent.av.business.manager.report.VideoNodeReporter.3;
import com.tencent.av.business.manager.report.VideoNodeReporter.4;
import com.tencent.av.business.manager.report.VideoNodeReporter.5;
import com.tencent.av.business.manager.report.VideoNodeReporter.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class ikr
  extends ijo
{
  static String NB;
  int aoh;
  Handler.Callback b = new iks(this);
  public List<ikr.a> fi = new ArrayList();
  Handler handler;
  HandlerThread handlerThread = new HandlerThread("VideoNodeReportThread");
  
  public ikr(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.handlerThread.start();
    this.handler = new Handler(this.handlerThread.getLooper(), this.b);
    String[] arrayOfString = BaseApplicationImpl.processName.split(":");
    Object localObject = null;
    paramVideoAppInterface = localObject;
    if (arrayOfString != null)
    {
      paramVideoAppInterface = localObject;
      if (arrayOfString.length == 2) {
        paramVideoAppInterface = arrayOfString[1];
      }
    }
    NB = "avideo_node_report_" + paramVideoAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, "construct VideoNodeReporter  sSPName = " + NB);
    }
  }
  
  private String ah(long paramLong)
  {
    String str = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).getString(String.valueOf(paramLong), "");
    QLog.d("VideoNodeReporter", 1, "getSpSessionRecord roomId = " + paramLong + ",result = " + str);
    return str;
  }
  
  private void anC()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0);
    Map localMap = localSharedPreferences.getAll();
    if ((localMap != null) && (localMap.size() > 0))
    {
      QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord, allContent.size() = " + localMap.size());
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          bW(Long.decode((String)localEntry.getKey()).longValue());
        }
        catch (Exception localException)
        {
          QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord Exception ", localException);
          localSharedPreferences.edit().remove((String)localEntry.getKey()).commit();
        }
      }
    }
    QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord allContent = " + localMap);
  }
  
  private void bX(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).edit();
    localEditor.remove(String.valueOf(paramLong));
    localEditor.commit();
    igd.aK("VideoNodeReporter", "removeSpSessionRecord,roomId = " + paramLong);
  }
  
  private void e(long paramLong1, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, " reportNode ,node = " + paramInt + ",value = " + paramLong2 + ",roomId = " + paramLong1);
    }
    Object localObject2 = a(paramLong1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ikr.a();
      ((ikr.a)localObject1).roomId = paramLong1;
      this.fi.add(localObject1);
    }
    localObject2 = this.mApp.getCurrentAccountUin();
    iiv localiiv = this.mApp.b().b();
    if (((ikr.a)localObject1).roomId == localiiv.getRoomId()) {
      ((ikr.a)localObject1).a(localiiv, (String)localObject2);
    }
    localObject2 = ((ikr.a)localObject1).gQ();
    localObject1 = ((ikr.a)localObject1).c(paramInt, paramLong2);
    p(paramLong1, (String)localObject2 + (String)localObject1);
  }
  
  static String gP()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
  }
  
  private void p(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, "writeSpSessionRecord,roomId = " + paramLong + ",detail = " + paramString);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).edit();
    localEditor.putString(String.valueOf(paramLong), paramString);
    localEditor.commit();
  }
  
  ikr.a a(long paramLong)
  {
    if (this.fi.size() > 0)
    {
      Iterator localIterator = this.fi.iterator();
      while (localIterator.hasNext())
      {
        ikr.a locala = (ikr.a)localIterator.next();
        if (paramLong == locala.roomId) {
          return locala;
        }
      }
    }
    return null;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    igd.aK("VideoNodeReporter", " onSessionStatusChanged :" + paramInt + ",para = " + paramString2);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    if (this.fi.size() > 0)
    {
      paramString1 = this.fi.iterator();
      while (paramString1.hasNext()) {
        ((ikr.a)paramString1.next()).lx = System.currentTimeMillis();
      }
    }
    r(38, this.aoh);
  }
  
  public void anB()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)this.mApp.getApplication().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l1 = aqgz.L(Process.myPid()) / 1024L / 1024L;
      long l2 = localMemoryInfo.availMem / 1024L / 1024L;
      long l3 = localMemoryInfo.threshold / 1024L / 1024L;
      boolean bool = localMemoryInfo.lowMemory;
      QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,availMem = " + l2 + ",threshold = " + l3 + ",isLowMemory = " + bool + ",pss = " + l1);
      r(21, l3);
      r(15, l2);
      r(22, l1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  public void bV(long paramLong)
  {
    QLog.d("VideoNodeReporter", 1, "updateCallerRoomId roomId = " + paramLong);
    this.handler.post(new VideoNodeReporter.2(this, paramLong));
  }
  
  public void bW(long paramLong)
  {
    this.handler.post(new VideoNodeReporter.6(this, paramLong));
  }
  
  protected boolean cs(String paramString)
  {
    return true;
  }
  
  public void d(long paramLong1, int paramInt, long paramLong2)
  {
    QLog.d("VideoNodeReporter", 1, " reportByRoomId ,node = " + paramInt + ",value = " + paramLong2);
    if ((this.mApp == null) || (this.mApp.b() == null) || (this.mApp.b().b() == null))
    {
      igd.aK("VideoNodeReporter", " reportByRoomId error 0: " + paramInt + "|" + this.mApp);
      return;
    }
    if (this.mApp.RD)
    {
      igd.aK("VideoNodeReporter", " reportByRoomId error 1 ,exit has been called,node = " + paramInt);
      return;
    }
    if (paramLong1 == 0L)
    {
      QLog.d("VideoNodeReporter", 1, "reportByRoomId rooid is 0", new Throwable("test"));
      return;
    }
    this.handler.post(new VideoNodeReporter.4(this, paramLong1, paramInt, paramLong2));
  }
  
  public void iZ(String paramString)
  {
    this.handler.post(new VideoNodeReporter.5(this, paramString));
  }
  
  public void kS(int paramInt)
  {
    this.aoh = paramInt;
  }
  
  protected void onCreate()
  {
    igd.aK("VideoNodeReporter", "onCreate ");
    anC();
  }
  
  public void r(int paramInt, long paramLong)
  {
    QLog.d("VideoNodeReporter", 1, " report ,node = " + paramInt + ",value = " + paramLong);
    if ((this.mApp == null) || (this.mApp.b() == null) || (this.mApp.b().b() == null))
    {
      igd.aK("VideoNodeReporter", " report error 0: " + paramInt + "|" + this.mApp);
      return;
    }
    if (this.mApp.RD)
    {
      igd.aK("VideoNodeReporter", " report error 1 ,exit has been called,node = " + paramInt);
      return;
    }
    this.handler.post(new VideoNodeReporter.3(this, paramInt, paramLong));
  }
  
  public static class a
  {
    String ND;
    public String NE = "KilledBySystem";
    boolean RX = false;
    public int amM = -1;
    long[] h = new long[41];
    public long lx;
    public long ly;
    public String peerUin;
    public long roomId = -1L;
    public String selfUin;
    public int sessionType = -1;
    
    public void a(iiv paramiiv, String paramString)
    {
      if (paramiiv != null)
      {
        if (paramiiv.amM != -1) {
          this.amM = paramiiv.amM;
        }
        if (paramiiv.amI != 0) {
          this.sessionType = paramiiv.amI;
        }
        if (!TextUtils.isEmpty(paramiiv.peerUin)) {
          this.peerUin = paramiiv.peerUin;
        }
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.selfUin = paramString;
      }
    }
    
    public String c(int paramInt, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < 41))
      {
        StringBuilder localStringBuilder;
        if (paramLong == 1L)
        {
          this.h[paramInt] = 1L;
          localStringBuilder = new StringBuilder();
          paramInt = 0;
          label34:
          if (paramInt >= 41) {
            break label242;
          }
          switch (paramInt)
          {
          default: 
            localStringBuilder.append(String.valueOf(this.h[paramInt])).append('|');
          }
        }
        for (;;)
        {
          paramInt += 1;
          break label34;
          this.h[paramInt] = paramLong;
          break;
          if (this.h[14] == 0L)
          {
            this.ND = ikr.gP();
            this.h[14] = 1L;
          }
          localStringBuilder.append(this.ND).append('|');
          continue;
          localStringBuilder.append(this.NE).append('|');
          continue;
          localStringBuilder.append(0).append('|');
          continue;
          if (this.lx > 0L) {
            this.ly = ((System.currentTimeMillis() - this.lx) / 1000L);
          }
          localStringBuilder.append(this.ly).append('|');
        }
        label242:
        return localStringBuilder.toString();
      }
      igd.aK("VideoNodeReporter", "buildBody report error:" + paramInt);
      return null;
    }
    
    public String gQ()
    {
      String str1 = Build.MODEL;
      String str2 = String.valueOf(Build.VERSION.SDK_INT);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Android").append('|');
      localStringBuilder.append(str1).append('|');
      localStringBuilder.append(str2).append('|');
      localStringBuilder.append(str2).append('|');
      localStringBuilder.append(this.selfUin).append('|');
      localStringBuilder.append(this.peerUin).append('|');
      if (this.sessionType != -1) {
        localStringBuilder.append(this.sessionType).append('|');
      }
      for (;;)
      {
        localStringBuilder.append(this.amM).append('|');
        return localStringBuilder.toString();
        localStringBuilder.append(String.valueOf(this.h[20])).append('|');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikr
 * JD-Core Version:    0.7.0.1
 */