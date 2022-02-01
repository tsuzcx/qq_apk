package dov.com.qq.im;

import android.content.Intent;
import android.text.TextUtils;
import anpc;
import axim;
import com.tencent.common.app.BaseApplicationImpl;
import rar;

class QIMCameraCaptureActivity$1
  implements Runnable
{
  QIMCameraCaptureActivity$1(QIMCameraCaptureActivity paramQIMCameraCaptureActivity, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "enter_story_capture_count", true, 0L, 0L, null, "");
    rar.a("video_shoot_new", "shoot_exp", rar.ea(this.eCv), 0, new String[] { "", "", "", String.valueOf(this.this$0.getIntent().getIntExtra("entrance_type", 0)) });
    if (!TextUtils.isEmpty(this.this$0.getIntent().getStringExtra("KEY_ISENTER_SO_DOWNLOAD"))) {}
    for (;;)
    {
      axim.a().Yk(bool);
      axim.a().eLi();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity.1
 * JD-Core Version:    0.7.0.1
 */