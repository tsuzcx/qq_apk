import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.22.1;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class aarc
  extends BroadcastReceiver
{
  public aarc(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((NewFlowCameraActivity.b(this.this$0)) && ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))) {
      return;
    }
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.$(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
      if (paramContext != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(paramContext);
      }
      if ((this.this$0.c != null) && (this.this$0.c.a != null)) {
        this.this$0.c.a.dQh();
      }
      this.this$0.cwl();
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
        if (!TextUtils.isEmpty(NewFlowCameraActivity.a(this.this$0)))
        {
          str = "";
          if (this.this$0.jdField_a_of_type_Aasb != null) {
            str = this.this$0.jdField_a_of_type_Aasb.qD();
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
        aaqi.h("", paramContext, str, "", NewFlowCameraActivity.a(this.this$0), "");
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, String.format("subAction[%s], activityId[%s], templateId[%s]", new Object[] { paramContext, NewFlowCameraActivity.a(this.this$0), str }));
        }
      }
      NewFlowCameraActivity.a(this.this$0, null);
      this.this$0.finish();
      return;
      label315:
      if (i == 2)
      {
        paramContext = "0X8008383";
        continue;
        this.this$0.onPause();
        return;
        if (!"tencent.video.q2v.nightMode".equals(paramContext)) {
          break;
        }
        boolean bool = paramIntent.getBooleanExtra("dark_mode_value", true);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "receive ACTION_NIGHT_MODE." + bool);
        }
        if ((this.this$0.c.aL.get() == 3) || (this.this$0.c.aL.get() == 4))
        {
          GLVideoClipUtil.czn();
          return;
        }
        if (bool)
        {
          NewFlowCameraActivity.c(this.this$0, true);
          NewFlowCameraActivity.a(this.this$0).setVisibility(0);
          NewFlowCameraActivity.d(this.this$0, true);
          GLVideoClipUtil.enableNightMode(true);
          NewFlowCameraActivity.c(this.this$0);
          anot.a(null, "dc00898", "", "", "0X8007BB6", "0X8007BB6", 0, 0, "", "", "", "");
          if (!NewFlowCameraActivity.c(this.this$0)) {
            break;
          }
          NewFlowCameraActivity.e(this.this$0, false);
          NewFlowCameraActivity.a(this.this$0).setVisibility(0);
          this.this$0.mUIHandler.postDelayed(new NewFlowCameraActivity.22.1(this), 3000L);
          return;
        }
        NewFlowCameraActivity.a(this.this$0).setVisibility(8);
        NewFlowCameraActivity.c(this.this$0, false);
        NewFlowCameraActivity.d(this.this$0, false);
        GLVideoClipUtil.czm();
        return;
      }
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarc
 * JD-Core Version:    0.7.0.1
 */