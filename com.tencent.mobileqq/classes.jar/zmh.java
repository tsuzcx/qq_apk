import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class zmh
{
  public int a;
  public long a;
  private Map<Integer, Long> a;
  public int b = -1;
  
  public zmh()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    if (this.jdField_a_of_type_Long < paramLong)
    {
      this.jdField_a_of_type_Long = paramLong;
      this.b = paramInt;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((Long)((Map.Entry)localIterator.next()).getValue()).longValue() + l) {}
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      return "there_is_no_frame";
    }
    this.jdField_a_of_type_Int = ((int)l / this.jdField_a_of_type_JavaUtilMap.size());
    localStringBuilder.append("avg:").append(this.jdField_a_of_type_Int).append("|max:").append(this.jdField_a_of_type_Long).append("|maxId:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmh
 * JD-Core Version:    0.7.0.1
 */