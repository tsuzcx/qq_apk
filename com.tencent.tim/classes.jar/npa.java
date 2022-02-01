import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.2;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class npa
{
  private static volatile npa a;
  public static String anc = "readinjoy_report";
  public static String and = "readinjoy_entertime";
  public static String ane = "readinjoy_folderstatus";
  public static String anf = "readinjoy_kandianmode";
  public static String ang = "readinjoy_hearttime";
  private static volatile int baR;
  public npa.a a;
  final Object aS = new Object();
  private int appStatus = 2;
  private boolean atL;
  private int baN;
  public int baO;
  private int baP;
  private int baQ;
  private int baS;
  TimerTask d = null;
  private long ie = -1L;
  public long lastReportTime;
  private boolean reported;
  Timer timer = null;
  private long xZ;
  
  public npa()
  {
    this.jdField_a_of_type_Npa$a = null;
  }
  
  public static npa a()
  {
    if (jdField_a_of_type_Npa == null) {}
    try
    {
      if (jdField_a_of_type_Npa == null) {
        jdField_a_of_type_Npa = new npa();
      }
      return jdField_a_of_type_Npa;
    }
    finally {}
  }
  
  public static void tQ(int paramInt)
  {
    baR = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time , int mode , int status) , time =" + paramLong + "   local time = " + System.currentTimeMillis() + ",isWeishi:" + this.atL);
    }
    this.ie = paramLong;
    this.baN = paramInt2;
    this.baO = paramInt1;
    this.reported = false;
  }
  
  public void aZO()
  {
    synchronized (this.aS)
    {
      if (this.d != null)
      {
        this.d.cancel();
        this.d = null;
      }
      if (this.timer != null)
      {
        this.timer.cancel();
        this.timer = null;
      }
      return;
    }
  }
  
  public void aZP()
  {
    if (this.jdField_a_of_type_Npa$a == null) {
      this.jdField_a_of_type_Npa$a = new npa.a(null);
    }
    ReadInJoyGlobalReporter.2 local2 = new ReadInJoyGlobalReporter.2(this);
    if (AppSetting.aNS)
    {
      ThreadManager.executeOnSubThread(local2, true);
      return;
    }
    local2.run();
  }
  
  public void aZQ()
  {
    ReadInJoyGlobalReporter.3 local3 = new ReadInJoyGlobalReporter.3(this);
    if (AppSetting.aNS)
    {
      ThreadManager.executeOnSubThread(local3, true);
      return;
    }
    local3.run();
  }
  
  protected void aa(QQAppInterface arg1)
  {
    aZO();
    synchronized (this.aS)
    {
      if (this.d == null) {
        this.d = new ReadInJoyGlobalReporter.1(this);
      }
      if (this.timer == null)
      {
        this.timer = new Timer();
        this.timer.schedule(this.d, 1000L, 10000L);
      }
      return;
    }
  }
  
  public void ab(QQAppInterface paramQQAppInterface)
  {
    stopReport();
    c(paramQQAppInterface, -1L, -1, -1);
    c(paramQQAppInterface, -1L);
    jdField_a_of_type_Npa = null;
    this.atL = false;
  }
  
  public long b(QQAppInterface paramQQAppInterface)
  {
    long l = -1L;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(anc + paramQQAppInterface, 0);
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong(ang, -1L);
    }
    return l;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time) , time =" + paramLong + ",isWeishi:" + this.atL);
    }
    this.ie = paramLong;
    this.reported = false;
    c(paramQQAppInterface, paramLong, this.baO, this.baN);
    aa(paramQQAppInterface);
    aZP();
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramInt2);
    if (i(paramQQAppInterface))
    {
      paramLong = b(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "Last heart time =" + paramLong + "  currect time=" + NetConnInfoCenter.getServerTimeMillis() + "  last entertime=" + this.ie);
      }
      if ((paramLong == -1L) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) >= 15000L)) {
        break label188;
      }
      this.ie = this.xZ;
      this.baN = this.baQ;
      this.baO = this.baP;
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "quite error,set enter time =" + this.ie);
      }
    }
    for (;;)
    {
      this.reported = false;
      aa(paramQQAppInterface);
      c(paramQQAppInterface, this.ie, paramInt1, paramInt2);
      aZP();
      return;
      label188:
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(anc + paramQQAppInterface, 0).edit();
      paramQQAppInterface.putLong(ang, paramLong);
      paramQQAppInterface.commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(anc + paramQQAppInterface, 0).edit();
    paramQQAppInterface.putLong(and, paramLong);
    paramQQAppInterface.putInt(ane, paramInt2);
    paramQQAppInterface.putInt(anf, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public boolean i(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(anc + paramQQAppInterface, 0);
    if (paramQQAppInterface != null)
    {
      this.xZ = paramQQAppInterface.getLong(and, -1L);
      this.baP = paramQQAppInterface.getInt(anf, -1);
      this.baQ = paramQQAppInterface.getInt(ane, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "Load report time from sharedpreferences, time =" + this.xZ);
    }
    if (this.xZ != -1L) {
      bool = true;
    }
    return bool;
  }
  
  public void pW(boolean paramBoolean)
  {
    this.atL = paramBoolean;
  }
  
  public void report()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "report time is =" + this.ie + ",isWeishi:" + this.atL);
    }
    if (NetConnInfoCenter.getServerTimeMillis() - this.lastReportTime < 3000L)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "too often");
      return;
    }
    if (this.reported)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "has report");
      return;
    }
    this.reported = true;
    this.lastReportTime = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", this.baN);
      localJSONObject.put("kandian_mode", "" + this.baO);
      localJSONObject.put("kandian_mode_new", kct.nd());
      if (!lhf.Ci()) {
        break label298;
      }
      str = "1";
      localJSONObject.put("is_requesting_articles", str);
      localJSONObject.put("articles_request_type", lhf.oB());
      if (!lhf.Cj()) {
        break label364;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str;
        label298:
        QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
        continue;
        int i = 0;
      }
    }
    localJSONObject.put("hit_preload_cache", i);
    localJSONObject.put("os", 1);
    localJSONObject.put("version", kct.XU);
    localJSONObject.put("channel_id", baR);
    if (this.atL) {
      kbp.a(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.ie) / 1000.0D), "", "", localJSONObject.toString(), false);
    }
    for (;;)
    {
      lhf.nx(false);
      lhf.aMm();
      return;
      str = "0";
      break;
      kbp.a(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.ie) / 1000.0D), "", "", localJSONObject.toString(), false);
    }
  }
  
  public void stopReport()
  {
    aZO();
    aZQ();
  }
  
  public class a
    extends BroadcastReceiver
  {
    private String action;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.action = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.action)) {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + npa.a(npa.this));
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + npa.a(npa.this));
              }
            } while (npa.a(npa.this) != 2);
            npa.this.report();
            npa.this.aZO();
            return;
          } while (!"android.intent.action.USER_PRESENT".equals(this.action));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + npa.a(npa.this));
          }
        } while ((npa.a(npa.this) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
        paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (paramContext == null);
      npa.this.b(paramContext, NetConnInfoCenter.getServerTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npa
 * JD-Core Version:    0.7.0.1
 */