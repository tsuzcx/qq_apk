import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;

class xsq
{
  public static ConcurrentHashMap<xso, Boolean> a;
  private static volatile xsq a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static xsq a()
  {
    if (jdField_a_of_type_Xsq == null) {}
    try
    {
      if (jdField_a_of_type_Xsq == null) {
        jdField_a_of_type_Xsq = new xsq();
      }
      return jdField_a_of_type_Xsq;
    }
    finally {}
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new xso(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull xso paramxso)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxso);
    wxe.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      azpo.a(xsh.a(alud.a(2131716261), null), "Story.UIUtils.monitor " + paramxso.toString());
    }
    paramxso.a.setDownloadListener(null);
    paramxso.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxso);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsq
 * JD-Core Version:    0.7.0.1
 */