package com.tencent.tav.report;

import android.util.Log;
import com.tencent.camerasdk.avreporter.AVReportCenter;
import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;

public final class ExportReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "ExportReportSession";
  private long beginTimeMs = 0L;
  private long compositeTimeUs = 0L;
  private long exportStartTimeNs = 0L;
  private long fileDurationUs = 0L;
  private long framePerSecond = 0L;
  private boolean success = false;
  private int successCount = 0;
  private long totalCostUs = 0L;
  
  private void commit()
  {
    if ((this.beginTimeMs == 0L) || (this.exportStartTimeNs == 0L))
    {
      Log.e("ExportReportSession", "commit: 数据错误，beginTimeMs = " + this.beginTimeMs + "， exportStartTimeNs = " + this.exportStartTimeNs);
      return;
    }
    if (this.successCount >= 10) {
      doCommit();
    }
    reset();
  }
  
  private void doCommit()
  {
    Bean localBean = new Bean();
    localBean.timestamp = Long.valueOf(this.beginTimeMs * 1000L);
    Bean.access$002(localBean, this.compositeTimeUs);
    if (this.success) {}
    for (int i = 1;; i = 0)
    {
      Bean.access$102(localBean, i);
      Bean.access$202(localBean, this.totalCostUs / this.successCount);
      Bean.access$302(localBean, this.fileDurationUs);
      Bean.access$402(localBean, this.framePerSecond);
      Log.d("ExportReportSession", "doCommit: bean = " + localBean);
      AVReportCenter.getInstance().commit(localBean, Boolean.valueOf(false));
      return;
    }
  }
  
  public void onExportError()
  {
    this.success = false;
    commit();
  }
  
  public void onExportStart(long paramLong)
  {
    this.exportStartTimeNs = paramLong;
    this.beginTimeMs = System.currentTimeMillis();
  }
  
  public void onExportSuccess()
  {
    if (this.exportStartTimeNs <= 0L)
    {
      Log.e("ExportReportSession", "onExportSuccess: 数据错误，exportStartTimeNs = " + this.exportStartTimeNs);
      return;
    }
    this.success = true;
    this.compositeTimeUs = ((System.nanoTime() - this.exportStartTimeNs) / 1000L);
    commit();
  }
  
  public void reset()
  {
    Log.d("ExportReportSession", "reset() called");
    this.compositeTimeUs = 0L;
    this.success = false;
    this.totalCostUs = 0L;
    this.successCount = 0;
    this.fileDurationUs = 0L;
    this.framePerSecond = 0L;
  }
  
  public void setFileDurationUs(long paramLong)
  {
    this.fileDurationUs = paramLong;
  }
  
  public void setFramePerSecond(int paramInt)
  {
    this.framePerSecond = paramInt;
  }
  
  public final void tickExport(long paramLong)
  {
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
  
  static final class Bean
    extends BaseBean
  {
    @ReportKey(name="ext_int3")
    private long avg_render_time = 0L;
    @ReportKey(name="ext_int1")
    private long composite_time = 0L;
    @ReportKey(name="ext_int4")
    private long file_duration = 0L;
    @ReportKey(name="ext_int5")
    private long frame_per_second = 0L;
    @ReportKey(name="ext_int2")
    private int success = 0;
    
    public Bean()
    {
      super("android_avfoundation_export", "1.1.-");
    }
    
    public String toString()
    {
      return "Bean{composite_time=" + this.composite_time + ", success=" + this.success + ", avg_render_time=" + this.avg_render_time + ", file_duration=" + this.file_duration + ", frame_per_second=" + this.frame_per_second + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession
 * JD-Core Version:    0.7.0.1
 */