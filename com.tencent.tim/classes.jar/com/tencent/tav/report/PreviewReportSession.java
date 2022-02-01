package com.tencent.tav.report;

import android.util.Log;
import com.tencent.camerasdk.avreporter.AVReportCenter;
import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;

public final class PreviewReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "PreviewReportSession";
  private long beginTimeMs = 0L;
  private int frameCount = 0;
  private long totalReadCostUs = 0L;
  private long totalRenderCount = 0L;
  
  private void commit()
  {
    Bean localBean = new Bean();
    localBean.timestamp = Long.valueOf(this.beginTimeMs * 1000L);
    Bean.access$002(localBean, this.totalReadCostUs / this.frameCount);
    Bean.access$102(localBean, this.frameCount);
    Bean.access$202(localBean, this.totalRenderCount / this.frameCount);
    Bean.access$302(localBean, this.frameCount);
    Log.d("PreviewReportSession", "commit: bean = " + localBean);
    AVReportCenter.getInstance().commit(localBean, Boolean.valueOf(false));
  }
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalReadCostUs = 0L;
    this.totalRenderCount = 0L;
    this.frameCount = 0;
  }
  
  public final void flush()
  {
    if (this.beginTimeMs == 0L) {
      return;
    }
    if (this.frameCount >= 10) {
      commit();
    }
    reset();
  }
  
  public final void tickPreview(long paramLong1, long paramLong2)
  {
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong1 / 1000L / 1000L);
    }
    this.frameCount += 1;
    this.totalReadCostUs += paramLong1 / 1000L;
    this.totalRenderCount += paramLong2 / 1000L;
  }
  
  static final class Bean
    extends BaseBean
  {
    @ReportKey(name="ext_int1")
    private long avg_read_sample_time_us = 0L;
    @ReportKey(name="ext_int3")
    private long avg_render_time_us = 0L;
    @ReportKey(name="ext_int2")
    private long read_sample_count = 0L;
    @ReportKey(name="ext_int4")
    private long render_count = 0L;
    
    public Bean()
    {
      super("android_avfoundation_preview", "1.1.-");
    }
    
    public String toString()
    {
      return "Bean{avg_read_sample_time_us=" + this.avg_read_sample_time_us + ", read_sample_count=" + this.read_sample_count + ", avg_render_time_us=" + this.avg_render_time_us + ", render_count=" + this.render_count + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.report.PreviewReportSession
 * JD-Core Version:    0.7.0.1
 */