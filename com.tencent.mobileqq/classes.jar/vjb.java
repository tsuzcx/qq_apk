import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.component.media.utils.LruCache;
import com.tencent.qphone.base.util.BaseApplication;

public class vjb
{
  private static LruCache<Integer, Bitmap> jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static vjb a()
  {
    return vjd.a();
  }
  
  public LruCache<Integer, Bitmap> a()
  {
    if (jdField_a_of_type_ComTencentComponentMediaUtilsLruCache == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaUtilsLruCache == null)
      {
        int j = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getMemoryClass() * 131072;
        int i = j;
        if (j > 52428800) {
          i = 52428800;
        }
        jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new vjc(this, i);
      }
      return jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */