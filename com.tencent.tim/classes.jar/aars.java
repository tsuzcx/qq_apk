import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.54.1;

public class aars
  implements qqz.a
{
  public aars(NewFlowCameraActivity paramNewFlowCameraActivity, long paramLong, int paramInt) {}
  
  public void onError()
  {
    ram.e("PTV.NewFlowCameraActivity", "generate manifest file failed. cost = " + (SystemClock.elapsedRealtime() - this.val$startTime));
  }
  
  public void onSuccess()
  {
    ram.i("PTV.NewFlowCameraActivity", "generate manifest file success. cost = " + (SystemClock.elapsedRealtime() - this.val$startTime));
    this.this$0.mUIHandler.post(new NewFlowCameraActivity.54.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aars
 * JD-Core Version:    0.7.0.1
 */