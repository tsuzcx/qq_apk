import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class vzp
{
  public static ConcurrentHashMap<vzn, Boolean> a;
  private static volatile vzp a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static vzp a()
  {
    if (jdField_a_of_type_Vzp == null) {}
    try
    {
      if (jdField_a_of_type_Vzp == null) {
        jdField_a_of_type_Vzp = new vzp();
      }
      return jdField_a_of_type_Vzp;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new vzn(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull vzn paramvzn)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvzn);
    ved.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      axpu.a(vzg.a(ajya.a(2131715877), null), "Story.UIUtils.monitor " + paramvzn.toString());
    }
    paramvzn.a.setDownloadListener(null);
    paramvzn.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzp
 * JD-Core Version:    0.7.0.1
 */