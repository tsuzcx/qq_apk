import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.qphone.base.util.QLog;

public class aard
  implements MessageQueue.IdleHandler
{
  public aard(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public boolean queueIdle()
  {
    if (anii.isFoundProduct(anii.KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj = true;
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "hit in black list! needChangeNewSurfaceView ");
      }
    }
    View localView = BaseActivity2.$(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if (localView != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    this.this$0.cwp();
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onResume();
    if ((!NewFlowCameraActivity.d(this.this$0)) && (!NewFlowCameraActivity.e(this.this$0))) {
      this.this$0.c.onResume();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      NewFlowCameraActivity.f(this.this$0, false);
      this.val$sp.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
      NewFlowCameraActivity.g(this.this$0, false);
      return false;
      if ((NewFlowCameraActivity.d(this.this$0)) && (!NewFlowCameraActivity.e(this.this$0)) && (this.byD)) {
        this.this$0.c.onResume();
      } else {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onResume from select music and do nothing in 1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aard
 * JD-Core Version:    0.7.0.1
 */