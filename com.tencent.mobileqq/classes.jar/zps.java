import com.tencent.biz.richframework.preload.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zps
{
  private static zps jdField_a_of_type_Zps;
  private final ConcurrentHashMap<String, zpv> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      zpr.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static zps a()
  {
    if (jdField_a_of_type_Zps == null) {
      jdField_a_of_type_Zps = new zps();
    }
    return jdField_a_of_type_Zps;
  }
  
  public <T> String a(String paramString, zpq<T> paramzpq)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    return a(paramString, new Worker(paramString, paramzpq, (zpx)null, i));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {}
    try
    {
      zpv localzpv = (zpv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localzpv != null) {
        localzpv.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zpr.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, zpx<T> paramzpx)
  {
    try
    {
      paramString = (zpv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramzpx);
      }
      return;
    }
    catch (Exception paramString)
    {
      zpr.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zps
 * JD-Core Version:    0.7.0.1
 */