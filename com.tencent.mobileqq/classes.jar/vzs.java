import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class vzs
{
  public static ConcurrentHashMap<vzq, Boolean> a;
  private static volatile vzs a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static vzs a()
  {
    if (jdField_a_of_type_Vzs == null) {}
    try
    {
      if (jdField_a_of_type_Vzs == null) {
        jdField_a_of_type_Vzs = new vzs();
      }
      return jdField_a_of_type_Vzs;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new vzq(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull vzq paramvzq)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvzq);
    veg.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      axps.a(vzj.a(ajyc.a(2131715866), null), "Story.UIUtils.monitor " + paramvzq.toString());
    }
    paramvzq.a.setDownloadListener(null);
    paramvzq.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvzq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzs
 * JD-Core Version:    0.7.0.1
 */