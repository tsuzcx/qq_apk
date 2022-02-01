import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class la
{
  public static AtomicBoolean L = new AtomicBoolean(false);
  public static int iM;
  public static AtomicInteger j = new AtomicInteger(1);
  private static ConcurrentHashMap<String, AtomicInteger> s = new ConcurrentHashMap();
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (!L.get()) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont.Report", 2, "report not enable");
      }
    }
    AtomicInteger localAtomicInteger1;
    long l3;
    int i;
    do
    {
      return;
      AtomicInteger localAtomicInteger2 = (AtomicInteger)s.get(paramString);
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        s.put(paramString, localAtomicInteger1);
      }
      long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("font_report_sp", 0).getLong(paramString, 0L);
      long l2 = j.get() * 60 * 60 * 1000;
      l3 = System.currentTimeMillis();
      if (l3 - l1 <= l2) {
        break;
      }
      i = localAtomicInteger1.incrementAndGet();
    } while (i != iM);
    VasWebviewUtil.reportFontPerformance(paramString, paramInt1, paramInt2, paramInt3, paramDouble, i);
    BaseApplicationImpl.getApplication().getSharedPreferences("font_report_sp", 0).edit().putLong(paramString, l3).commit();
    return;
    localAtomicInteger1.set(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     la
 * JD-Core Version:    0.7.0.1
 */