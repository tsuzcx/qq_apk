import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class zmb
{
  public static ConcurrentHashMap<zlz, Boolean> a;
  private static volatile zmb a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static zmb a()
  {
    if (jdField_a_of_type_Zmb == null) {}
    try
    {
      if (jdField_a_of_type_Zmb == null) {
        jdField_a_of_type_Zmb = new zmb();
      }
      return jdField_a_of_type_Zmb;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new zlz(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull zlz paramzlz)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramzlz);
    yqp.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      bcrp.a(zls.a(anni.a(2131714538), null), "Story.UIUtils.monitor " + paramzlz.toString());
    }
    paramzlz.a.setDownloadListener(null);
    paramzlz.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramzlz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmb
 * JD-Core Version:    0.7.0.1
 */