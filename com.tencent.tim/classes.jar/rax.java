import android.content.Intent;
import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.qphone.base.util.QLog;

public class rax
  extends achq
{
  public rax(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public void a(MessageForDanceMachine paramMessageForDanceMachine)
  {
    super.a(paramMessageForDanceMachine);
    if (!DanceMachineUploadVideoFragment.a(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.d("UploadDanceMachineVideo", 2, "do not need callback");
      }
    }
    do
    {
      return;
      DanceMachineUploadVideoFragment.a(this.this$0, false);
      if (paramMessageForDanceMachine != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UploadDanceMachineVideo", 2, "mfd is null");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "uuid : " + paramMessageForDanceMachine.uuid + "  md5 : " + paramMessageForDanceMachine.md5 + " thumbFilePath : " + paramMessageForDanceMachine.mThumbFilePath);
    }
    if (paramMessageForDanceMachine.errorCode == 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("upload_result", true);
      localIntent.putExtra("upload_video_uuid", paramMessageForDanceMachine.uuid);
      localIntent.putExtra("upload_video_md5", paramMessageForDanceMachine.md5);
      localIntent.putExtra("upload_video_thumb", paramMessageForDanceMachine.mThumbFilePath);
      localIntent.putExtra("share_method", DanceMachineUploadVideoFragment.a(this.this$0));
      localIntent.putExtra("current_nickname", this.this$0.app.getCurrentNickname());
      localIntent.putExtra("current_uin", this.this$0.app.getCurrentUin());
      if (DanceMachineUploadVideoFragment.a(this.this$0) != -1L) {
        localIntent.putExtra("upload_time_cost", SystemClock.elapsedRealtime() - DanceMachineUploadVideoFragment.a(this.this$0));
      }
      paramMessageForDanceMachine = this.this$0.mActivity;
      BaseActivity localBaseActivity = this.this$0.mActivity;
      paramMessageForDanceMachine.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.this$0.mActivity.finish();
      return;
      this.this$0.mActivity.setResult(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rax
 * JD-Core Version:    0.7.0.1
 */