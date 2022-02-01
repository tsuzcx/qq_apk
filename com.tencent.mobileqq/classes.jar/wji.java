import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class wji
  implements wja
{
  private final LinkedList<wjj> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Integer, wuj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private void e()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().query(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
        wjj localwjj = new wjj();
        localwjj.a(localReportWatchVideoEntry);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localwjj);
      }
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList.size());
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wjj localwjj = (wjj)((Iterator)localObject).next();
      if (localwjj.jdField_a_of_type_Long < l - 86400000L)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localwjj);
        localArrayList.add(localwjj);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(wsf.a);
    int i = 0;
    while ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < wsf.a))
    {
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new wsf().a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((wuj)localObject).c), localObject);
    }
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new wjj(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public void a(wjj paramwjj, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramwjj))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramwjj);
        ykq.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramwjj.jdField_a_of_type_JavaLangString, paramwjj.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().a().createEntityManager().persistOrReplace(paramwjj.a());
      }
      return;
    }
  }
  
  public void a(@NonNull wuj paramwuj)
  {
    try
    {
      ykq.d("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramwuj.c));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
        {
          paramwuj = new wjk();
          wad.a().dispatch(paramwuj);
        }
      }
      return;
    }
    finally
    {
      paramwuj = finally;
      throw paramwuj;
    }
  }
  
  public boolean a(List<wjj> paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        wjj localwjj = (wjj)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localEntityManager.remove(localReportWatchVideoEntry, "vid=?", new String[] { localwjj.jdField_a_of_type_JavaLangString });
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityTransaction.end();
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        e();
        ykq.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      f();
      ykq.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
      {
        wjk localwjk = new wjk();
        wad.a().dispatch(localwjk);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        g();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wji
 * JD-Core Version:    0.7.0.1
 */