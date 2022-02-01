import com.tencent.biz.richframework.preload.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zan
{
  private static zan jdField_a_of_type_Zan;
  private final ConcurrentHashMap<String, zaq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      zam.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static zan a()
  {
    if (jdField_a_of_type_Zan == null) {
      jdField_a_of_type_Zan = new zan();
    }
    return jdField_a_of_type_Zan;
  }
  
  public <T> String a(String paramString, zal<T> paramzal)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    return a(paramString, new Worker(paramString, paramzal, (zas)null, i));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {}
    try
    {
      zaq localzaq = (zaq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localzaq != null) {
        localzaq.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zam.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, zas<T> paramzas)
  {
    try
    {
      paramString = (zaq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramzas);
      }
      return;
    }
    catch (Exception paramString)
    {
      zam.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zan
 * JD-Core Version:    0.7.0.1
 */