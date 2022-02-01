import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class vqn
{
  public static final String a;
  private static volatile vqn jdField_a_of_type_Vqn;
  private List<SoftReference<Object>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = vqn.class.getSimpleName();
  }
  
  public static vqn a()
  {
    if (jdField_a_of_type_Vqn == null) {}
    try
    {
      if (jdField_a_of_type_Vqn == null) {
        jdField_a_of_type_Vqn = new vqn();
      }
      return jdField_a_of_type_Vqn;
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
        QLog.e(jdField_a_of_type_JavaLangString, 1, "mUinFollowMap getValue uin null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */