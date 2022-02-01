package com.tencent.qqlive.module.videoreport.dtreport;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Configuration.Builder;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNonFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAdditionalReportHandler;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTReportChannel;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

public class DTReportComponent
  implements IVideoReportComponent
{
  private static final int VISIT_BACKGROUND_TIME = 30000;
  private Configuration mConfiguration = createDefaultConfiguration(paramBuilder);
  
  private DTReportComponent(Builder paramBuilder)
  {
    initVideoReport(paramBuilder);
    DTHandleEventFormatFactory.setElementFormatMode(paramBuilder.mElementFormatMode);
    DTReportChannel.getInstance().setReport(paramBuilder.mDTReport);
    DTEventDynamicParams.getInstance().setDTCommonParams(paramBuilder.mParamProvider);
  }
  
  public static Builder builder(@NonNull IDTParamProvider paramIDTParamProvider)
  {
    return new Builder(paramIDTParamProvider);
  }
  
  private Configuration createDefaultConfiguration(Builder paramBuilder)
  {
    return new Configuration.Builder().visitBackgroundTime(30000L).formatter(getFormatter(paramBuilder.mElementFormatMode)).independentPageOut(paramBuilder.mIndependentPageOut).build();
  }
  
  private IFormatter getFormatter(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new DTParamsNonFlattenFormatter();
    }
    return new DTParamsFlattenFormatter();
  }
  
  private void initVideoReport(Builder paramBuilder)
  {
    VideoReport.setDebugMode(paramBuilder.mEnableDebug);
    VideoReport.addReporter(DTReportChannel.getInstance());
    VideoReportInner.getInstance().addInnerReporter(DTReportChannel.getInstance());
    VideoReport.registerEventDynamicParams(DTEventDynamicParams.getInstance());
    VideoReport.setEventAdditionalReport(DTAdditionalReportHandler.getInstance());
  }
  
  public Configuration getConfiguration()
  {
    return this.mConfiguration;
  }
  
  public static class Builder
  {
    private IDTReport mDTReport;
    private int mElementFormatMode = 0;
    private boolean mEnableDebug;
    private boolean mIndependentPageOut = false;
    private IDTParamProvider mParamProvider;
    
    Builder(IDTParamProvider paramIDTParamProvider)
    {
      if (paramIDTParamProvider == null) {
        throw new IllegalArgumentException("dtParamProvider不可为空");
      }
      this.mParamProvider = paramIDTParamProvider;
    }
    
    public DTReportComponent build()
    {
      return new DTReportComponent(this, null);
    }
    
    public Builder dtReport(IDTReport paramIDTReport)
    {
      this.mDTReport = paramIDTReport;
      return this;
    }
    
    public Builder elementFormatMode(@DTConfigConstants.ElementFormatMode int paramInt)
    {
      this.mElementFormatMode = paramInt;
      return this;
    }
    
    public Builder enableDebug(boolean paramBoolean)
    {
      this.mEnableDebug = paramBoolean;
      return this;
    }
    
    public Builder independentPageOut(boolean paramBoolean)
    {
      this.mIndependentPageOut = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent
 * JD-Core Version:    0.7.0.1
 */