import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtCanvasJsonManager.1;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class yyr
{
  private static volatile yyr jdField_a_of_type_Yyr;
  private int jdField_a_of_type_Int = 5;
  private volatile LruCache<String, String> jdField_a_of_type_AndroidUtilLruCache;
  
  private yyr()
  {
    a();
    this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(this.jdField_a_of_type_Int);
  }
  
  private int a()
  {
    int i = AdCanvas.getQueueLength(new WeakReference(BaseApplicationImpl.getContext()));
    yxs.b("GdtCanvasJsonManager", "getQueueLength :" + i);
    if (i == -2147483648) {
      yxs.d("GdtCanvasJsonManager", "getQueueLength error");
    }
    for (;;)
    {
      return this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = i;
    }
  }
  
  public static yyr a()
  {
    if (jdField_a_of_type_Yyr == null) {}
    try
    {
      if (jdField_a_of_type_Yyr == null) {
        jdField_a_of_type_Yyr = new yyr();
      }
      return jdField_a_of_type_Yyr;
    }
    finally {}
  }
  
  private void a(Ad paramAd, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      yxx localyxx = new yxx();
      localyxx.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)GdtAd.class.cast(paramAd));
      localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(paramInt1);
      localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(paramInt2);
      localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
      yxw.a(localyxx);
      return;
    }
    catch (Throwable paramAd)
    {
      yxs.d("GdtCanvasJsonManager", "rtp report error", paramAd);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString1, paramString2);
    return true;
  }
  
  public String a(Ad paramAd, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    for (;;)
    {
      yxs.b("GdtCanvasJsonManager", "getCachedCanvasJson failed :" + paramString);
      return null;
      if ((this.jdField_a_of_type_AndroidUtilLruCache != null) && (this.jdField_a_of_type_AndroidUtilLruCache.size() != 0))
      {
        str = (String)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        a(paramAd, 76, 1, 0L);
      }
    }
    a(paramAd, 76, 0, 0L);
    return str;
  }
  
  public void a(Ad paramAd, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    a(paramAd, 74, 0, 0L);
    AdThreadManager.INSTANCE.post(new GdtCanvasJsonManager.1(this, paramString2, l, paramAd, paramString1), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyr
 * JD-Core Version:    0.7.0.1
 */