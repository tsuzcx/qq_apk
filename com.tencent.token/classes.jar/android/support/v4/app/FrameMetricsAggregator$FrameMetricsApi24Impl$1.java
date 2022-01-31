package android.support.v4.app;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;

class FrameMetricsAggregator$FrameMetricsApi24Impl$1
  implements Window.OnFrameMetricsAvailableListener
{
  FrameMetricsAggregator$FrameMetricsApi24Impl$1(FrameMetricsAggregator.FrameMetricsApi24Impl paramFrameMetricsApi24Impl) {}
  
  public void onFrameMetricsAvailable(Window paramWindow, FrameMetrics paramFrameMetrics, int paramInt)
  {
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x1) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[0], paramFrameMetrics.getMetric(8));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x2) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[1], paramFrameMetrics.getMetric(1));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x4) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[2], paramFrameMetrics.getMetric(3));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x8) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[3], paramFrameMetrics.getMetric(4));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x10) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[4], paramFrameMetrics.getMetric(5));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x40) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[6], paramFrameMetrics.getMetric(7));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x20) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[5], paramFrameMetrics.getMetric(6));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x80) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[7], paramFrameMetrics.getMetric(0));
    }
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.access$100(this.this$0) & 0x100) != 0) {
      this.this$0.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.access$200(this.this$0)[8], paramFrameMetrics.getMetric(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
 * JD-Core Version:    0.7.0.1
 */