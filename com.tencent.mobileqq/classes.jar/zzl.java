import com.tencent.biz.richframework.preload.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl
{
  private static zzl jdField_a_of_type_Zzl;
  private final ConcurrentHashMap<String, zzo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (a(paramString))
    {
      zzk.b("preLoader ID is used, please note that remove!");
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWorker);
    paramWorker.a();
    return paramString;
  }
  
  public static zzl a()
  {
    if (jdField_a_of_type_Zzl == null) {
      jdField_a_of_type_Zzl = new zzl();
    }
    return jdField_a_of_type_Zzl;
  }
  
  public <T> String a(String paramString, zzj<T> paramzzj)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    return a(paramString, new Worker(paramString, paramzzj, (zzq)null, i));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {}
    try
    {
      zzo localzzo = (zzo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localzzo != null) {
        localzzo.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzk.a(localException);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public <T> void a(String paramString, zzq<T> paramzzq)
  {
    try
    {
      paramString = (zzo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramzzq);
      }
      return;
    }
    catch (Exception paramString)
    {
      zzk.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzl
 * JD-Core Version:    0.7.0.1
 */