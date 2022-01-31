import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class urh
  implements uqz
{
  private final LinkedList<uri> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Integer, vci> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private void e()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
        uri localuri = new uri();
        localuri.a(localReportWatchVideoEntry);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localuri);
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
      uri localuri = (uri)((Iterator)localObject).next();
      if (localuri.jdField_a_of_type_Long < l - 86400000L)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localuri);
        localArrayList.add(localuri);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(vae.a);
    int i = 0;
    while ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < vae.a))
    {
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new vae().a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((vci)localObject).c), localObject);
    }
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new uri(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public void a(uri paramuri, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramuri))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramuri);
        wsv.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramuri.jdField_a_of_type_JavaLangString, paramuri.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().a().createEntityManager().b(paramuri.a());
      }
      return;
    }
  }
  
  public void a(@NonNull vci paramvci)
  {
    try
    {
      wsv.d("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramvci.c));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
        {
          paramvci = new urj();
          uht.a().dispatch(paramvci);
        }
      }
      return;
    }
    finally
    {
      paramvci = finally;
      throw paramvci;
    }
  }
  
  public boolean a(List<uri> paramList)
  {
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    awby localawby = localawbw.a();
    try
    {
      localawby.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        uri localuri = (uri)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localawbw.a(localReportWatchVideoEntry, "vid=?", new String[] { localuri.jdField_a_of_type_JavaLangString });
      }
    }
    finally
    {
      localawby.b();
    }
    localawby.b();
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
        wsv.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      f();
      wsv.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
      {
        urj localurj = new urj();
        uht.a().dispatch(localurj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urh
 * JD-Core Version:    0.7.0.1
 */