import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager.2;
import com.tencent.component.media.utils.LruCache;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;

public class vig
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vig jdField_a_of_type_Vig;
  private bmzb jdField_a_of_type_Bmzb;
  private LruCache<Integer, Typeface> jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new LruCache(8);
  private MultiHashMap<Integer, vii> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  
  public static vig a()
  {
    if (jdField_a_of_type_Vig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vig == null) {
        jdField_a_of_type_Vig = new vig();
      }
      return jdField_a_of_type_Vig;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneFontManager.2(this, paramString, paramInt));
  }
  
  public Typeface a(int paramInt, String paramString, vii paramvii)
  {
    ??? = (Typeface)this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.get(Integer.valueOf(paramInt));
    if (??? != null) {
      return ???;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.contains(Integer.valueOf(paramInt), paramvii)) {
        return null;
      }
      if (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(Integer.valueOf(paramInt), paramvii);
        return null;
      }
      this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(Integer.valueOf(paramInt), paramvii);
      if (this.jdField_a_of_type_Bmzb == null) {
        this.jdField_a_of_type_Bmzb = new vih(this, paramInt);
      }
      a(paramInt, bmyy.a(paramInt, paramString, null, false, this.jdField_a_of_type_Bmzb));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */