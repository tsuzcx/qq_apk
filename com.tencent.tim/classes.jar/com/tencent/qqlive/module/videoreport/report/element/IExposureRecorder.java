package com.tencent.qqlive.module.videoreport.report.element;

import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;

public abstract interface IExposureRecorder
{
  public abstract void clearExposure();
  
  public abstract Map<Long, ExposureInfoWrapper> getExposedRecords();
  
  public abstract boolean isExposed(long paramLong);
  
  public abstract void markExposed(ExposureElementInfo paramExposureElementInfo);
  
  public abstract void markUnexposed(long paramLong);
  
  public abstract void markUnexposed(Collection<Long> paramCollection);
  
  public abstract void registerOnExposureStatusListener(OnExposureStatusListener paramOnExposureStatusListener);
  
  public static class ExposureInfoWrapper
  {
    final WeakReference<Object> attachedPage;
    final Map<String, Object> exposureParams;
    final long exposureTime;
    final WeakReference<View> exposureView;
    
    public ExposureInfoWrapper(ExposureElementInfo paramExposureElementInfo, long paramLong)
    {
      this.exposureTime = paramLong;
      this.exposureView = new WeakReference(paramExposureElementInfo.getView());
      this.attachedPage = new WeakReference(paramExposureElementInfo.getPage());
      this.exposureParams = new ArrayMap();
      paramExposureElementInfo = paramExposureElementInfo.getFinalData();
      if ((paramExposureElementInfo != null) && (paramExposureElementInfo.eventParams != null)) {
        this.exposureParams.putAll(paramExposureElementInfo.eventParams);
      }
    }
  }
  
  public static class Factory
  {
    public static IExposureRecorder getInstance()
    {
      return ExposureRecorderImpl.getInstance();
    }
  }
  
  public static abstract interface OnExposureStatusListener
  {
    public abstract void onViewUnexposed(IExposureRecorder.ExposureInfoWrapper paramExposureInfoWrapper, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
 * JD-Core Version:    0.7.0.1
 */