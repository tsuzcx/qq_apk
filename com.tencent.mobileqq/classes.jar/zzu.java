import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzu
{
  public long a;
  public String a;
  public ConcurrentHashMap<Integer, Long> a;
  
  public zzu()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 9223372036854775807L;
  }
  
  public abstract void a();
  
  public void a(int paramInt, long paramLong)
  {
    long l = paramLong;
    if (paramLong != 9223372036854775807L) {
      l = paramLong + (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = paramString1;
  }
  
  public boolean a(int paramInt)
  {
    Long localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK", 2, "canReportWith validTime" + localLong + getClass().getSimpleName());
    }
    if (localLong != null) {
      return System.currentTimeMillis() - this.jdField_a_of_type_Long < localLong.longValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzu
 * JD-Core Version:    0.7.0.1
 */