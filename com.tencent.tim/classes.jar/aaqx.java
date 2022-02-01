import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.FramePerformanceMonitor.a;
import com.tencent.qphone.base.util.QLog;

public class aaqx
  implements FramePerformanceMonitor.a
{
  public aaqx(NewFlowCameraActivity paramNewFlowCameraActivity, SharedPreferences paramSharedPreferences) {}
  
  public void a(adfg.a parama)
  {
    long l = parama.ag[((int)(parama.ag.length * NewFlowCameraActivity.a(this.this$0)))];
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "onDataRefresh: datatype=" + NewFlowCameraActivity.a(this.this$0) + " monitedValue=" + l);
    }
    if (parama.num >= 100)
    {
      if (l > NewFlowCameraActivity.a(this.this$0))
      {
        NewFlowCameraActivity.a(this.this$0, true, parama);
        NewFlowCameraActivity.a(this.this$0).cRe();
      }
    }
    else {
      return;
    }
    if (l < NewFlowCameraActivity.b(this.this$0))
    {
      NewFlowCameraActivity.a(this.this$0, false, parama);
      NewFlowCameraActivity.a(this.this$0).cRe();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Finished. Frame count = " + parama.num);
    }
    this.C.edit().putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_up_mark", 1).commit();
    NewFlowCameraActivity.a(this.this$0).cRe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqx
 * JD-Core Version:    0.7.0.1
 */