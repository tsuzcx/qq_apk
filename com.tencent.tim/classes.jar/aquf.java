import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vashealth.VideoCallBack;
import com.tencent.qphone.base.util.QLog;

public class aquf
  extends Handler
{
  public aquf(VideoCallBack paramVideoCallBack, arhz paramarhz, String paramString, Activity paramActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return;
      if ((this.K != null) && (this.K.isShowing())) {
        this.K.dismiss();
      }
      i = paramMessage.arg1;
      if (i != 0) {
        break;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
      Intent localIntent = new Intent();
      localIntent.putExtra("video_dir", paramMessage);
      localIntent.putExtra("thumb_dir", this.vg);
      this.val$context.setResult(1, localIntent);
      this.val$context.finish();
    } while (!QLog.isColorLevel());
    QLog.i("VideoCallBack", 2, "encode success: " + paramMessage);
    return;
    this.val$context.setResult(2);
    this.val$context.finish();
    QLog.e("VideoCallBack", 1, "error! ret = " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquf
 * JD-Core Version:    0.7.0.1
 */