import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager.2;
import com.tencent.component.media.utils.LruCache;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;

public class vgc
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vgc jdField_a_of_type_Vgc;
  private blxz jdField_a_of_type_Blxz;
  private LruCache<Integer, Typeface> jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new LruCache(8);
  private MultiHashMap<Integer, vge> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  
  public static vgc a()
  {
    if (jdField_a_of_type_Vgc == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vgc == null) {
        jdField_a_of_type_Vgc = new vgc();
      }
      return jdField_a_of_type_Vgc;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneFontManager.2(this, paramString, paramInt));
  }
  
  public Typeface a(int paramInt, String paramString, vge paramvge)
  {
    ??? = (Typeface)this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.get(Integer.valueOf(paramInt));
    if (??? != null) {
      return ???;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.contains(Integer.valueOf(paramInt), paramvge)) {
        return null;
      }
      if (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(Integer.valueOf(paramInt), paramvge);
        return null;
      }
      this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(Integer.valueOf(paramInt), paramvge);
      if (this.jdField_a_of_type_Blxz == null) {
        this.jdField_a_of_type_Blxz = new vgd(this, paramInt);
      }
      a(paramInt, blxw.a(paramInt, paramString, null, false, this.jdField_a_of_type_Blxz));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgc
 * JD-Core Version:    0.7.0.1
 */