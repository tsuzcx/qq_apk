import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class vrc
{
  public static final String a;
  private static volatile vrc jdField_a_of_type_Vrc;
  private List<SoftReference<Object>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = vrc.class.getSimpleName();
  }
  
  public static vrc a()
  {
    if (jdField_a_of_type_Vrc == null) {}
    try
    {
      if (jdField_a_of_type_Vrc == null) {
        jdField_a_of_type_Vrc = new vrc();
      }
      return jdField_a_of_type_Vrc;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "clear all");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString));
  }
  
  public boolean b(String paramString)
  {
    if (a(paramString))
    {
      paramString = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "mTagFollowMap getValue tagId null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrc
 * JD-Core Version:    0.7.0.1
 */