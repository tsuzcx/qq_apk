import com.tencent.biz.subscribe.preloader.lib.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class yfp
{
  private static yfp jdField_a_of_type_Yfp;
  private final ConcurrentHashMap<String, yfs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      yfo.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static yfp a()
  {
    if (jdField_a_of_type_Yfp == null) {
      jdField_a_of_type_Yfp = new yfp();
    }
    return jdField_a_of_type_Yfp;
  }
  
  public <T> String a(String paramString, yfn<T> paramyfn)
  {
    return a(paramString, new Worker(paramString, paramyfn, (yfu)null));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      yfo.b("remove preloader id:" + paramString);
    }
    try
    {
      yfs localyfs = (yfs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localyfs != null) {
        localyfs.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yfo.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, yfu<T> paramyfu)
  {
    try
    {
      paramString = (yfs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramyfu);
      }
      return;
    }
    catch (Exception paramString)
    {
      yfo.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfp
 * JD-Core Version:    0.7.0.1
 */