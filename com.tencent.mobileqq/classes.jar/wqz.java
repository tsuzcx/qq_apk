import com.tencent.biz.subscribe.preloader.lib.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class wqz
{
  private static wqz jdField_a_of_type_Wqz;
  private final ConcurrentHashMap<String, wrc> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      wqy.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static wqz a()
  {
    if (jdField_a_of_type_Wqz == null) {
      jdField_a_of_type_Wqz = new wqz();
    }
    return jdField_a_of_type_Wqz;
  }
  
  public <T> String a(String paramString, wqx<T> paramwqx)
  {
    return a(paramString, new Worker(paramString, paramwqx, (wre)null));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      wqy.b("remove preloader id:" + paramString);
    }
    try
    {
      wrc localwrc = (wrc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localwrc != null) {
        localwrc.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wqy.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, wre<T> paramwre)
  {
    try
    {
      paramString = (wrc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramwre);
      }
      return;
    }
    catch (Exception paramString)
    {
      wqy.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */