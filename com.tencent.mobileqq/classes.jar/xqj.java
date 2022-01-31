import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class xqj
  extends BroadcastReceiver
{
  public xqj(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((NewFlowCameraActivity.b(this.a)) && ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))) {
      return;
    }
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
      if (paramContext != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(paramContext);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.e();
      }
      this.a.k();
      return;
    }
    String str;
    int i;
    if ("tencent.video.q2v.startUploadPTV".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "receive ACTION_BLESS_UPLOAD_PTV.");
      }
      switch (paramIntent.getIntExtra("broadcastType", 1))
      {
      default: 
        return;
      case 1: 
        if (!TextUtils.isEmpty(NewFlowCameraActivity.a(this.a)))
        {
          str = "";
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
            str = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
          }
          i = paramIntent.getIntExtra("recordType", 0);
          if (i != 3) {
            break label315;
          }
          paramContext = "0X8008382";
        }
        break;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        FlowCameraMqqAction.a("", paramContext, str, "", NewFlowCameraActivity.a(this.a), "");
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, String.format("subAction[%s], activityId[%s], templateId[%s]", new Object[] { paramContext, NewFlowCameraActivity.a(this.a), str }));
        }
      }
      NewFlowCameraActivity.a(this.a, null);
      this.a.finish();
      return;
      label315:
      if (i == 2)
      {
        paramContext = "0X8008383";
        continue;
        this.a.onPause();
        return;
        if (!"tencent.video.q2v.nightMode".equals(paramContext)) {
          break;
        }
        boolean bool = paramIntent.getBooleanExtra("dark_mode_value", true);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "receive ACTION_NIGHT_MODE." + bool);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 3) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4))
        {
          GLVideoClipUtil.c();
          return;
        }
        if (bool)
        {
          NewFlowCameraActivity.c(this.a, true);
          NewFlowCameraActivity.a(this.a).setVisibility(0);
          NewFlowCameraActivity.d(this.a, true);
          GLVideoClipUtil.a(true);
          NewFlowCameraActivity.c(this.a);
          ReportController.b(null, "dc00898", "", "", "0X8007BB6", "0X8007BB6", 0, 0, "", "", "", "");
          if (!NewFlowCameraActivity.c(this.a)) {
            break;
          }
          NewFlowCameraActivity.e(this.a, false);
          NewFlowCameraActivity.a(this.a).setVisibility(0);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new xqk(this), 3000L);
          return;
        }
        NewFlowCameraActivity.a(this.a).setVisibility(8);
        NewFlowCameraActivity.c(this.a, false);
        NewFlowCameraActivity.d(this.a, false);
        GLVideoClipUtil.b();
        return;
      }
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqj
 * JD-Core Version:    0.7.0.1
 */