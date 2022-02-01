package com.tencent.qqlive.module.videoreport;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.inner.DefaultLogger;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

public class Configuration
{
  private static final Builder DEFAULT_BUILDER = new Builder();
  private static final DefaultLogger DEFAULT_LOGGER = new DefaultLogger();
  private static final String TAG = "Configuration";
  private static volatile Configuration sDefaultInstance;
  private final long mClickReportInterval;
  private boolean mDefaultDataCollectEnable;
  private boolean mDefaultReportEnable;
  private final double mElementExposureMinRate;
  private final long mElementExposureMinTime;
  private final ReportPolicy mElementReportPolicy;
  private final IFormatter mFormatter;
  private boolean mIndependentPageOut;
  private final ILogger mLogger;
  private final double mPageExposureMinRate;
  private final long mPageExposureMinTime;
  private final long mVisitBackgroundTime;
  
  private Configuration()
  {
    this(DEFAULT_BUILDER);
  }
  
  private Configuration(Builder paramBuilder)
  {
    this.mDefaultReportEnable = paramBuilder.mDefaultReportEnable;
    this.mDefaultDataCollectEnable = paramBuilder.mDefaultDataCollectEnable;
    this.mVisitBackgroundTime = paramBuilder.mVisitBackgroundTime;
    this.mPageExposureMinTime = paramBuilder.mPageExposureMinTime;
    this.mPageExposureMinRate = paramBuilder.mPageExposureMinRate;
    this.mElementExposureMinTime = paramBuilder.mElementExposureMinTime;
    this.mElementExposureMinRate = paramBuilder.mElementExposureMinRate;
    this.mClickReportInterval = paramBuilder.mClickReportInterval;
    this.mElementReportPolicy = paramBuilder.mElementReportPolicy;
    this.mLogger = paramBuilder.mLogger;
    this.mFormatter = ((IFormatter)BaseUtils.nullAs(paramBuilder.mFormatter, new DefaultFormatter()));
    this.mIndependentPageOut = paramBuilder.mIndependentPageOut;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Configuration getDefault()
  {
    if (sDefaultInstance == null) {}
    try
    {
      if (sDefaultInstance == null) {
        sDefaultInstance = new Configuration();
      }
      return sDefaultInstance;
    }
    finally {}
  }
  
  private boolean isDefaultReportEnable()
  {
    return this.mDefaultReportEnable;
  }
  
  private void setDefaultReportEnable(boolean paramBoolean)
  {
    this.mDefaultReportEnable = paramBoolean;
  }
  
  public long getClickReportInterval()
  {
    return this.mClickReportInterval;
  }
  
  public double getElementExposureMinRate()
  {
    return this.mElementExposureMinRate;
  }
  
  public long getElementExposureMinTime()
  {
    return this.mElementExposureMinTime;
  }
  
  public ReportPolicy getElementReportPolicy()
  {
    return this.mElementReportPolicy;
  }
  
  @NonNull
  public IFormatter getFormatter()
  {
    return this.mFormatter;
  }
  
  public ILogger getLogger()
  {
    if (this.mLogger == null) {
      return DEFAULT_LOGGER;
    }
    return this.mLogger;
  }
  
  public double getPageExposureMinRate()
  {
    return this.mPageExposureMinRate;
  }
  
  public long getPageExposureMinTime()
  {
    return this.mPageExposureMinTime;
  }
  
  public long getVisitBackgroundTime()
  {
    return this.mVisitBackgroundTime;
  }
  
  public boolean isDefaultDataCollectEnable()
  {
    return this.mDefaultDataCollectEnable;
  }
  
  public boolean isIndependentPageOut()
  {
    return this.mIndependentPageOut;
  }
  
  public void setDefaultDataCollectEnable(boolean paramBoolean)
  {
    this.mDefaultDataCollectEnable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Configuration{mDefaultReportEnable=").append(this.mDefaultReportEnable).append(", mDefaultDataCollectEnable=").append(this.mDefaultDataCollectEnable).append(", mVisitBackgroundTime=").append(this.mVisitBackgroundTime).append(", mPageExposureMinTime=").append(this.mPageExposureMinTime).append(", mPageExposureMinRate=").append(this.mPageExposureMinRate).append(", mElementExposureMinTime=").append(this.mElementExposureMinTime).append(", mElementExposureMinRate=").append(this.mElementExposureMinRate).append(", mElementReportPolicy=").append(this.mElementReportPolicy.name()).append(", mLogger=");
    if (this.mLogger != null) {}
    for (String str = this.mLogger.getClass().getName();; str = "null") {
      return str + '}';
    }
  }
  
  public static class Builder
  {
    private long mClickReportInterval = 500L;
    private boolean mDefaultDataCollectEnable = true;
    private boolean mDefaultReportEnable = true;
    private double mElementExposureMinRate = 0.01D;
    private long mElementExposureMinTime = 200L;
    private ReportPolicy mElementReportPolicy = ReportPolicy.REPORT_POLICY_ALL;
    private IFormatter mFormatter;
    private boolean mIndependentPageOut = false;
    private ILogger mLogger = Configuration.DEFAULT_LOGGER;
    private double mPageExposureMinRate = 0.4D;
    private long mPageExposureMinTime = 200L;
    private long mVisitBackgroundTime = 900000L;
    
    private Builder defaultReportEnable(boolean paramBoolean)
    {
      this.mDefaultReportEnable = paramBoolean;
      return this;
    }
    
    public Configuration build()
    {
      Configuration localConfiguration = new Configuration(this, null);
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("Configuration", "build: " + localConfiguration);
      }
      return localConfiguration;
    }
    
    public Builder clickReportInterval(long paramLong)
    {
      this.mClickReportInterval = paramLong;
      return this;
    }
    
    public Builder defaultDataCollectEnable(boolean paramBoolean)
    {
      this.mDefaultDataCollectEnable = paramBoolean;
      return this;
    }
    
    public Builder elementExposureMinRate(double paramDouble)
    {
      if (paramDouble > 1.0D)
      {
        this.mElementExposureMinRate = 1.0D;
        return this;
      }
      if (paramDouble < 0.0D)
      {
        this.mElementExposureMinRate = 0.0D;
        return this;
      }
      this.mElementExposureMinRate = paramDouble;
      return this;
    }
    
    public Builder elementExposureMinTime(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.mElementExposureMinTime = 0L;
        return this;
      }
      this.mElementExposureMinTime = paramLong;
      return this;
    }
    
    public Builder elementReportPolicy(ReportPolicy paramReportPolicy)
    {
      this.mElementReportPolicy = paramReportPolicy;
      return this;
    }
    
    public Builder formatter(IFormatter paramIFormatter)
    {
      this.mFormatter = paramIFormatter;
      return this;
    }
    
    public Builder independentPageOut(boolean paramBoolean)
    {
      this.mIndependentPageOut = paramBoolean;
      return this;
    }
    
    public Builder logger(ILogger paramILogger)
    {
      this.mLogger = paramILogger;
      return this;
    }
    
    public Builder pageExposureMinRate(double paramDouble)
    {
      if (paramDouble > 1.0D)
      {
        this.mPageExposureMinRate = 1.0D;
        return this;
      }
      if (paramDouble < 0.0D)
      {
        this.mPageExposureMinRate = 0.0D;
        return this;
      }
      this.mPageExposureMinRate = paramDouble;
      return this;
    }
    
    public Builder pageExposureMinTime(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.mPageExposureMinTime = 0L;
        return this;
      }
      this.mPageExposureMinTime = paramLong;
      return this;
    }
    
    public Builder visitBackgroundTime(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.mVisitBackgroundTime = 0L;
        return this;
      }
      this.mVisitBackgroundTime = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.Configuration
 * JD-Core Version:    0.7.0.1
 */