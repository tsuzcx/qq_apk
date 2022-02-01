import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.CancellationSignalCompat;
import com.tencent.mm.vfs.StatisticsCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class aquk
  implements StatisticsCallback
{
  private static CopyOnWriteArrayList<Map<String, Object>> at = new CopyOnWriteArrayList();
  private static CopyOnWriteArrayList<Throwable> au = new CopyOnWriteArrayList();
  private static boolean cWg;
  
  private void reportErrorInner(Throwable paramThrowable)
  {
    annt.e(paramThrowable);
  }
  
  public void deleteFiles(CancellationSignalCompat paramCancellationSignalCompat) {}
  
  protected void efI()
  {
    try
    {
      cWg = true;
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Iterator localIterator2 = at.iterator();
      while (localIterator2.hasNext())
      {
        Map localMap = (Map)localIterator2.next();
        if (QLog.isColorLevel()) {
          QLog.d("VFSRegisterProxy", 2, "statisticsReportCache params -> " + localMap);
        }
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "vfs_statistics_tag", true, 0L, 0L, (HashMap)localMap, null);
      }
      at.clear();
    }
    catch (Exception localException)
    {
      QLog.d("VFSRegisterProxy", 1, "statisticsReportCache report error!", localException);
      return;
    }
    Iterator localIterator1 = au.iterator();
    while (localIterator1.hasNext()) {
      reportErrorInner((Throwable)localIterator1.next());
    }
    au.clear();
  }
  
  public void reportError(Throwable paramThrowable)
  {
    QLog.e("VFSRegisterProxy", 1, paramThrowable, new Object[0]);
    if (cWg)
    {
      reportErrorInner(paramThrowable);
      return;
    }
    au.add(paramThrowable);
  }
  
  public void statistics(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      try
      {
        paramMap.put("id", paramString);
        paramMap.put("phase", String.valueOf(paramInt));
        if (cWg)
        {
          paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "vfs_statistics_tag", true, 0L, 0L, (HashMap)paramMap, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("VFSRegisterProxy", 2, "report params -> " + paramMap + ", mCanAccurReport = " + cWg);
          return;
          at.add(paramMap);
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("VFSRegisterProxy", 1, "vfs report error!", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquk
 * JD-Core Version:    0.7.0.1
 */