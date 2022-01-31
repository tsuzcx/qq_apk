import com.tencent.biz.subscribe.preloader.lib.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class wrc
{
  private static wrc jdField_a_of_type_Wrc;
  private final ConcurrentHashMap<String, wrf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      wrb.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static wrc a()
  {
    if (jdField_a_of_type_Wrc == null) {
      jdField_a_of_type_Wrc = new wrc();
    }
    return jdField_a_of_type_Wrc;
  }
  
  public <T> String a(String paramString, wra<T> paramwra)
  {
    return a(paramString, new Worker(paramString, paramwra, (wrh)null));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      wrb.b("remove preloader id:" + paramString);
    }
    try
    {
      wrf localwrf = (wrf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localwrf != null) {
        localwrf.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wrb.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, wrh<T> paramwrh)
  {
    try
    {
      paramString = (wrf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramwrh);
      }
      return;
    }
    catch (Exception paramString)
    {
      wrb.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrc
 * JD-Core Version:    0.7.0.1
 */