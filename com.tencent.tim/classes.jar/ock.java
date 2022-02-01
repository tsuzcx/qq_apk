import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ock
  implements muw.a
{
  public ock(PublicAccountH5AbilityPlugin.6 param6, arhz paramarhz, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void d(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.val$loadingDialog.dismiss();
      i = paramBundle.getInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage VideoFeedsIPCClient.callback downloadResult=" + i);
      }
    }
    switch (i)
    {
    case 2: 
    default: 
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131718877, 0).show();
      return;
    }
    boolean bool = this.a.this$0.c.b("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
    }
    obw.a(this.a.this$0, this.aos, this.apF, this.bej, this.aJf, this.val$callback, this.val$vid, this.apG, this.apH, this.val$md5, this.lr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ock
 * JD-Core Version:    0.7.0.1
 */