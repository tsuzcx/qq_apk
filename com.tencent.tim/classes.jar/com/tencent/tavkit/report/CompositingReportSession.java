package com.tencent.tavkit.report;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.camerasdk.avreporter.AVReportCenter;
import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;
import java.util.HashMap;
import java.util.Map;

public final class CompositingReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String REPORT_EVENT = "android_tavkit_compositing";
  public static final String REPORT_KEY_AVG_RENDER_TIME_US = "avg_render_time_us";
  private static final String REPORT_SERVICE = "TAVKit_Android";
  private static final String REPORT_VERSION = "1.3.4.2";
  private static final String TAG = "CompositingReportSessio";
  @Nullable
  private static IReporter reporter;
  private long beginTimeMs = 0L;
  private int failureCount = 0;
  @NonNull
  private final FilterChainReporter filterChainReporter;
  private float renderHeight;
  private float renderWidth;
  private int successCount = 0;
  private long totalCostUs = 0L;
  
  public CompositingReportSession(float paramFloat1, float paramFloat2)
  {
    this.renderWidth = paramFloat1;
    this.renderHeight = paramFloat2;
    this.filterChainReporter = new FilterChainReporter(null);
    FilterChainReportSession.setReporter(this.filterChainReporter);
  }
  
  private void commit()
  {
    Bean localBean = new Bean();
    localBean.timestamp = Long.valueOf(this.beginTimeMs * 1000L);
    Bean.access$102(localBean, this.totalCostUs / this.successCount);
    Bean.access$202(localBean, this.successCount);
    Bean.access$302(localBean, (int)this.renderHeight);
    Bean.access$402(localBean, (int)this.renderWidth);
    Log.d("CompositingReportSessio", "commit: bean = " + localBean);
    AVReportCenter.getInstance().commit(localBean, Boolean.valueOf(false));
    try
    {
      if (reporter != null) {
        reporter.onCommit(localBean.toMap(), this.filterChainReporter.values);
      }
      return;
    }
    finally {}
  }
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalCostUs = 0L;
    this.successCount = 0;
  }
  
  public static void setReporter(@Nullable IReporter paramIReporter)
  {
    try
    {
      reporter = paramIReporter;
      return;
    }
    finally
    {
      paramIReporter = finally;
      throw paramIReporter;
    }
  }
  
  public final void flush()
  {
    if (this.beginTimeMs == 0L) {
      return;
    }
    if (this.successCount >= 10) {
      commit();
    }
    reset();
  }
  
  public void tickFailed()
  {
    this.failureCount += 1;
  }
  
  public final void tickSuccess(long paramLong)
  {
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong / 1000L / 1000L);
    }
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
  
  static final class Bean
    extends BaseBean
  {
    @ReportKey(name="ext_int1")
    private long avg_render_time_us = 0L;
    @ReportKey(name="ext_int2")
    private long render_count = 0L;
    @ReportKey(name="ext_int4")
    private int render_height = 0;
    @ReportKey(name="ext_int3")
    private int render_width = 0;
    
    public Bean()
    {
      super("android_tavkit_compositing", "1.3.4.2");
    }
    
    public Map<String, Long> toMap()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("avg_render_time_us", Long.valueOf(this.avg_render_time_us));
      return localHashMap;
    }
    
    public String toString()
    {
      return "Bean{avg_render_time_us=" + this.avg_render_time_us + ", render_count=" + this.render_count + ", render_width=" + this.render_width + ", render_height=" + this.render_height + '}';
    }
  }
  
  static class FilterChainReporter
    implements FilterChainReportSession.IReporter
  {
    private Map<String, Long> values = new HashMap();
    
    public void onCommit(Map<String, Long> paramMap)
    {
      paramMap.putAll(paramMap);
    }
  }
  
  public static abstract interface IReporter
  {
    public abstract void onCommit(Map<String, Long> paramMap1, Map<String, Long> paramMap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession
 * JD-Core Version:    0.7.0.1
 */