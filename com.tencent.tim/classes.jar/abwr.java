import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class abwr
  implements abwv
{
  public boolean ad(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    EntityTransaction localEntityTransaction;
    TraceData localTraceData;
    try
    {
      localObject = getApp();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).a().createEntityManager();
      localEntityTransaction = ((EntityManager)localObject).getTransaction();
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localTraceData = (TraceData)paramList.next();
          if (localTraceData.getStatus() == 1000)
          {
            ((EntityManager)localObject).persistOrReplace(localTraceData);
            continue;
            return true;
          }
        }
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      ((EntityManager)localObject).update(localTraceData);
      break;
      localEntityTransaction.commit();
      localEntityTransaction.end();
      ((EntityManager)localObject).close();
    }
  }
  
  public boolean ae(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    EntityTransaction localEntityTransaction;
    try
    {
      localObject = getApp();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).a().createEntityManager();
      localEntityTransaction = ((EntityManager)localObject).getTransaction();
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((EntityManager)localObject).remove((TraceData)paramList.next());
        continue;
        return true;
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      localEntityTransaction.commit();
      localEntityTransaction.end();
      ((EntityManager)localObject).close();
    }
  }
  
  public List<TraceData> dH()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return null;
    }
    return localQQAppInterface.a().createEntityManager().query(TraceData.class);
  }
  
  public QQAppInterface getApp()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwr
 * JD-Core Version:    0.7.0.1
 */