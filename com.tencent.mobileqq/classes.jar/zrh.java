import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.scenetracker.SceneReportRunnable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class zrh
  implements Handler.Callback
{
  private static zrh jdField_a_of_type_Zrh;
  public Handler a;
  public ArrayList<zrg> a;
  
  static
  {
    if (!zrh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private zrh()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  public static zrh a()
  {
    if (jdField_a_of_type_Zrh == null) {}
    try
    {
      if (jdField_a_of_type_Zrh == null) {
        jdField_a_of_type_Zrh = new zrh();
      }
      return jdField_a_of_type_Zrh;
    }
    finally {}
  }
  
  private void a(zrg paramzrg, long paramLong)
  {
    if (paramzrg.a())
    {
      double d1 = paramzrg.jdField_a_of_type_Double * 100.0D;
      double d2 = paramzrg.jdField_b_of_type_Double * 100.0D;
      if (QLog.isColorLevel()) {
        QLog.i("reportToDenta", 2, "reportToDenta" + paramzrg.jdField_a_of_type_JavaLangString + " " + d1 + ", sys " + d2 + " mem " + paramzrg.jdField_a_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuUsage", String.valueOf(d1));
      localHashMap.put("sysUsage", String.valueOf(d2));
      localHashMap.put("memory", String.valueOf(paramzrg.jdField_a_of_type_Long));
      localHashMap.put("scene", String.valueOf(paramzrg.jdField_a_of_type_JavaLangString));
      localHashMap.put("duration", String.valueOf(paramLong));
      awrn.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public zrg a(String paramString)
  {
    zrg localzrg2 = b(paramString);
    zrg localzrg1 = localzrg2;
    if (localzrg2 == null)
    {
      localzrg1 = new zrg();
      localzrg1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localzrg1);
    }
    return localzrg1;
  }
  
  public void a()
  {
    if ((zrc.a.size() > 0) || (zrc.b.size() > 0))
    {
      SceneReportRunnable localSceneReportRunnable = SceneReportRunnable.a(BaseApplicationImpl.processName);
      awri.a().jdField_a_of_type_AndroidOsHandler.post(localSceneReportRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramString).sendToTarget();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public zrg b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zrg localzrg = (zrg)localIterator.next();
      if (TextUtils.equals(localzrg.jdField_a_of_type_JavaLangString, paramString)) {
        return localzrg;
      }
    }
    return null;
  }
  
  public void b(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return false;
            localObject1 = zrc.a().a();
          } while (localObject1 == null);
          paramMessage = (String)paramMessage.obj;
          localObject2 = b(paramMessage);
          if ((!jdField_a_of_type_Boolean) && (localObject2 != null)) {
            throw new AssertionError();
          }
          localObject2 = a(paramMessage);
          l1 = System.currentTimeMillis();
          localzrk1 = new zrk();
          localzrk1.jdField_a_of_type_Double = ((zrf)localObject1).jdField_a_of_type_Long;
          localzrk1.jdField_b_of_type_Long = ((zrf)localObject1).f;
          localzrk1.jdField_a_of_type_JavaLangString = paramMessage;
          localzrk1.jdField_a_of_type_Long = l1;
          localzrk1.jdField_a_of_type_Int = 0;
          ((zrg)localObject2).jdField_a_of_type_Zrk = localzrk1;
          zrc.b.add(localzrk1);
          ((zrg)localObject2).a((zrf)localObject1);
          return false;
          paramMessage = (String)paramMessage.obj;
          localObject1 = b(paramMessage);
        } while (localObject1 == null);
        localObject2 = zrc.a().a();
      } while (localObject2 == null);
      zrk localzrk1 = ((zrg)localObject1).jdField_a_of_type_Zrk;
      zrk localzrk2 = new zrk();
      localzrk2.jdField_a_of_type_JavaLangString = paramMessage;
      localzrk2.jdField_a_of_type_Double = ((zrf)localObject2).jdField_a_of_type_Long;
      localzrk2.jdField_b_of_type_Long = ((zrf)localObject2).f;
      localzrk2.jdField_b_of_type_Double = ((localzrk2.jdField_a_of_type_Double - localzrk1.jdField_a_of_type_Double) * 1000.0D);
      long l1 = localzrk2.jdField_b_of_type_Long;
      long l2 = localzrk1.jdField_b_of_type_Long;
      localzrk2.jdField_a_of_type_Long = localzrk1.jdField_a_of_type_Long;
      localzrk2.jdField_a_of_type_Int = 1;
      zrc.b.add(localzrk2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      ((zrg)localObject1).a((zrf)localObject2);
      a();
      a((zrg)localObject1, l1 - l2);
      return false;
    }
    paramMessage = zrc.a().a();
    if (paramMessage != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((zrg)((Iterator)localObject1).next()).a(paramMessage);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zrh
 * JD-Core Version:    0.7.0.1
 */