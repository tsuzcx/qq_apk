import com.tencent.biz.subscribe.preloader.lib.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ykc
{
  private static ykc jdField_a_of_type_Ykc;
  private final ConcurrentHashMap<String, ykf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      ykb.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static ykc a()
  {
    if (jdField_a_of_type_Ykc == null) {
      jdField_a_of_type_Ykc = new ykc();
    }
    return jdField_a_of_type_Ykc;
  }
  
  public <T> String a(String paramString, yka<T> paramyka)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    return a(paramString, new Worker(paramString, paramyka, (ykh)null, i));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {}
    try
    {
      ykf localykf = (ykf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localykf != null) {
        localykf.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ykb.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, ykh<T> paramykh)
  {
    try
    {
      paramString = (ykf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramykh);
      }
      return;
    }
    catch (Exception paramString)
    {
      ykb.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykc
 * JD-Core Version:    0.7.0.1
 */