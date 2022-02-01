package com.tencent.qqlive.module.videoreport.report.element;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Map;

public class ElementExposureEndReporter
  implements IExposureRecorder.OnExposureStatusListener
{
  public static ElementExposureEndReporter getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  public void onViewUnexposed(IExposureRecorder.ExposureInfoWrapper paramExposureInfoWrapper, long paramLong)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.eventKey = "imp_end";
    localFinalData.eventParams = new ArrayMap();
    if (paramExposureInfoWrapper.exposureParams != null) {
      localFinalData.eventParams.putAll(paramExposureInfoWrapper.exposureParams);
    }
    localFinalData.eventParams.put("element_lvtm", String.valueOf(paramLong));
    FinalDataTarget.handle(paramExposureInfoWrapper.exposureView, localFinalData);
  }
  
  static class InstanceHolder
  {
    static final ElementExposureEndReporter INSTANCE = new ElementExposureEndReporter(null);
    
    static
    {
      IExposureRecorder.Factory.getInstance().registerOnExposureStatusListener(INSTANCE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter
 * JD-Core Version:    0.7.0.1
 */