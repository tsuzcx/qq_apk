import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class zpw
{
  public static ConcurrentHashMap<zpu, Boolean> a;
  private static volatile zpw a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static zpw a()
  {
    if (jdField_a_of_type_Zpw == null) {}
    try
    {
      if (jdField_a_of_type_Zpw == null) {
        jdField_a_of_type_Zpw = new zpw();
      }
      return jdField_a_of_type_Zpw;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new zpu(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull zpu paramzpu)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramzpu);
    yuk.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      bdkh.a(zpn.a(anzj.a(2131714647), null), "Story.UIUtils.monitor " + paramzpu.toString());
    }
    paramzpu.a.setDownloadListener(null);
    paramzpu.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramzpu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpw
 * JD-Core Version:    0.7.0.1
 */