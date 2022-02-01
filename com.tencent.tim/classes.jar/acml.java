import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class acml
  implements Printer
{
  public static int sLogThreshold = 200;
  private String lastLog;
  private int mFamily = 0;
  private String mLooperName;
  private long msgCount;
  private int notReortedLoopCount;
  private long startTime;
  private long totalCost;
  
  acml(int paramInt, String paramString)
  {
    this.mFamily = paramInt;
    this.mLooperName = paramString;
  }
  
  private static String format(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {
      return null;
    }
    int i = paramString.indexOf('(');
    if (i == -1) {
      return null;
    }
    int j = paramString.indexOf(')', i);
    if (j == -1) {
      return null;
    }
    String str1 = paramString.substring(i + 1, j);
    int k = paramString.indexOf("} ", j);
    if (k == -1) {
      return null;
    }
    j = paramString.indexOf('@', k + 2);
    i = j;
    if (j == -1)
    {
      j = paramString.indexOf(':', k + 2);
      i = j;
      if (j == -1)
      {
        i = paramString.indexOf(' ', k + 2);
        if (i == -1) {
          break label150;
        }
      }
    }
    String str2 = paramString.substring(k + 2, i);
    i = paramString.indexOf(": ", i);
    if (i == -1)
    {
      return null;
      label150:
      return null;
    }
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.startTime = SystemClock.uptimeMillis();
      this.lastLog = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.mFamily)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.mFamily);
      }
    }
    while ((this.startTime == 0L) || (!paramString.startsWith("<<"))) {
      return;
    }
    this.msgCount += 1L;
    long l = SystemClock.uptimeMillis() - this.startTime;
    this.startTime = 0L;
    this.totalCost += l;
    Object localObject = null;
    paramString = (String)localObject;
    if (QLog.isColorLevel())
    {
      if (!ThreadSetting.logcatBgTaskMonitor) {
        break label192;
      }
      paramString = format(this.lastLog);
      QLog.d("AutoMonitor", 2, this.mLooperName + ", cost=" + l + ", " + paramString);
    }
    while (l > sLogThreshold) {
      if (!UnifiedMonitor.a().whetherReportThisTime(this.mFamily))
      {
        this.notReortedLoopCount = 0;
        return;
        label192:
        paramString = (String)localObject;
        if (l >= 200L)
        {
          paramString = format(this.lastLog);
          QLog.e("AutoMonitor", 2, this.mLooperName + " OOT cost=" + l + ", " + paramString);
        }
      }
      else
      {
        HashMap localHashMap;
        if (paramString == null)
        {
          paramString = format(this.lastLog);
          localHashMap = new HashMap(8);
          localObject = BaseActivity.sTopActivity;
          if (localObject == null) {
            break label338;
          }
        }
        label338:
        for (localObject = localObject.getClass().getName();; localObject = "")
        {
          localHashMap.put("act", localObject);
          UnifiedMonitor.a().addEvent(this.mFamily, paramString, (int)l, this.notReortedLoopCount, localHashMap);
          this.notReortedLoopCount = 0;
          return;
          break;
        }
      }
    }
    if (UnifiedMonitor.a().whetherStackEnabled(this.mFamily)) {
      UnifiedMonitor.a().notifyNotTimeout(this.mFamily);
    }
    this.notReortedLoopCount += 1;
  }
  
  void setDebugSettings(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global.LooperPrinter", 2, "setting threshold, threshold=" + paramInt);
    }
    sLogThreshold = paramInt;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.msgCount + ", totalCost = " + this.totalCost + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acml
 * JD-Core Version:    0.7.0.1
 */