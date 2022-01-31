import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.GenerateManifestCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xom
  implements QQStoryTakeVideoHelper.GenerateManifestCallback
{
  public xom(NewFlowCameraActivity paramNewFlowCameraActivity, long paramLong, int paramInt) {}
  
  public void a()
  {
    SLog.c("PTV.NewFlowCameraActivity", "generate manifest file success. cost = " + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.post(new xon(this));
  }
  
  public void b()
  {
    SLog.e("PTV.NewFlowCameraActivity", "generate manifest file failed. cost = " + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xom
 * JD-Core Version:    0.7.0.1
 */