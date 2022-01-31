import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class xoh
{
  public static ConcurrentHashMap<xof, Boolean> a;
  private static volatile xoh a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static xoh a()
  {
    if (jdField_a_of_type_Xoh == null) {}
    try
    {
      if (jdField_a_of_type_Xoh == null) {
        jdField_a_of_type_Xoh = new xoh();
      }
      return jdField_a_of_type_Xoh;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new xof(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull xof paramxof)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxof);
    wsv.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      azlf.a(xny.a(alpo.a(2131716249), null), "Story.UIUtils.monitor " + paramxof.toString());
    }
    paramxof.a.setDownloadListener(null);
    paramxof.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxof);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */