import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class axjp
{
  private static final String TAG = axjp.class.getSimpleName();
  private ConcurrentLinkedQueue<axkj> W = new ConcurrentLinkedQueue();
  private long aCj;
  private long aCk;
  
  private axjp()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(axmr.a().HY() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static axjp a()
  {
    return axjp.b.b;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      axiy.e(TAG, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return localHashMap;
    }
    localHashMap.put("brightValue", String.valueOf(paramImageStatisticsData.lightness));
    localHashMap.put("contrastValue", String.valueOf(paramImageStatisticsData.contrast));
    localHashMap.put("saturationValue", String.valueOf(paramImageStatisticsData.saturation));
    localHashMap.put("scaleCValue", String.valueOf(paramImageStatisticsData.temperature));
    localHashMap.put("sharpenValue", String.valueOf(paramImageStatisticsData.sharpness));
    localHashMap.put("highlightValue", String.valueOf(paramImageStatisticsData.overexposure));
    localHashMap.put("shadowValue", String.valueOf(paramImageStatisticsData.underexposure));
    localHashMap.put("fadeValue", String.valueOf(paramImageStatisticsData.colorfulness));
    return localHashMap;
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      axiy.e(TAG, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((float)paramImageStatisticsData.lightness);
    arrayOfFloat[1] = ((float)paramImageStatisticsData.temperature);
    arrayOfFloat[2] = ((float)paramImageStatisticsData.overexposure);
    arrayOfFloat[3] = ((float)paramImageStatisticsData.underexposure);
    arrayOfFloat[4] = ((float)paramImageStatisticsData.contrast);
    arrayOfFloat[5] = ((float)paramImageStatisticsData.saturation);
    arrayOfFloat[6] = ((float)paramImageStatisticsData.sharpness);
    arrayOfFloat[7] = ((float)paramImageStatisticsData.colorfulness);
    return arrayOfFloat;
  }
  
  private void b(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList)
  {
    if (paramAppInterface == null)
    {
      axiy.e(TAG, "AppInterface is null");
      return;
    }
    axiy.i(TAG, "sendRequest");
    ((axbm)paramAppInterface.getBusinessHandler(3)).fA(paramArrayList);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, axkj paramaxkj)
  {
    axiy.i(TAG, "processAIFilter: " + paramaxkj.getClass().getSimpleName());
    if (paramaxkj == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    axjp.a locala = paramaxkj.a();
    boolean bool;
    if (paramaxkj.aOO())
    {
      bool = axmr.a().aPb();
      if (bool) {
        break label103;
      }
      axiy.e(TAG, "processAIFilter: AIFilter request failed: lut res not ready");
      if (locala != null) {
        locala.eLK();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = axmr.a().aPa();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label133;
        }
        axiy.e(TAG, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (locala == null);
      locala.eLK();
      return;
      if (aqiw.isNetworkAvailable()) {
        break label158;
      }
    } while (locala == null);
    label133:
    locala.a(-4, paramaxkj.a());
    return;
    label158:
    this.aCj = System.currentTimeMillis();
    this.W.offer(paramaxkj);
    paramaxkj.a(paramContext, new axjq(this, paramAppInterface, locala, paramaxkj));
  }
  
  public void aed(int paramInt)
  {
    axiy.e(TAG, "onResponseFailed: errorCode=" + paramInt);
    if ((this.W == null) || (this.W.size() == 0)) {}
    axkj localaxkj;
    do
    {
      return;
      localaxkj = (axkj)this.W.poll();
    } while (localaxkj == null);
    localaxkj.clear();
    axjp.a locala = localaxkj.a();
    if (locala != null)
    {
      locala.a(paramInt, localaxkj.a());
      return;
    }
    axiy.i(TAG, "no observer, abandon response");
  }
  
  public void eLJ()
  {
    axiy.i(TAG, "cancelProcess");
    if (this.W != null)
    {
      Iterator localIterator = this.W.iterator();
      while (localIterator.hasNext()) {
        ((axkj)localIterator.next()).removeObserver();
      }
    }
  }
  
  public void oG(List<axkm> paramList)
  {
    axiy.i(TAG, "onResponseSuccess");
    if ((this.W == null) || (this.W.size() == 0)) {}
    axkj localaxkj;
    do
    {
      return;
      localaxkj = (axkj)this.W.poll();
    } while (localaxkj == null);
    axiy.i(TAG, "proxy handleResponse");
    paramList = localaxkj.a(paramList);
    localaxkj.clear();
    this.aCk = System.currentTimeMillis();
    axiy.i(TAG, "AIFilterPref: cost = " + (this.aCk - this.aCj) + "ms");
    axjp.a locala = localaxkj.a();
    if (locala != null)
    {
      axiy.i(TAG, "has observer");
      if (paramList != null)
      {
        axiy.i(TAG, "observer onAIFilterApplySuccess");
        locala.a(0, paramList);
      }
      for (;;)
      {
        localaxkj.removeObserver();
        return;
        axiy.i(TAG, "observer onAIFilterAppliedFailed, errorCode=-5");
        locala.a(-5, localaxkj.a());
      }
    }
    axiy.i(TAG, "no observer, abandon response");
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, axkn paramaxkn);
    
    public abstract void eLK();
  }
  
  static class b
  {
    public static axjp b = new axjp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjp
 * JD-Core Version:    0.7.0.1
 */