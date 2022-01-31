import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class vmw
{
  public static ConcurrentHashMap<vmu, Boolean> a;
  private static volatile vmw a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static vmw a()
  {
    if (jdField_a_of_type_Vmw == null) {}
    try
    {
      if (jdField_a_of_type_Vmw == null) {
        jdField_a_of_type_Vmw = new vmw();
      }
      return jdField_a_of_type_Vmw;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new vmu(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull vmu paramvmu)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvmu);
    urk.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      awpu.a(vmn.a(ajjy.a(2131650075), null), "Story.UIUtils.monitor " + paramvmu.toString());
    }
    paramvmu.a.setDownloadListener(null);
    paramvmu.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvmu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmw
 * JD-Core Version:    0.7.0.1
 */