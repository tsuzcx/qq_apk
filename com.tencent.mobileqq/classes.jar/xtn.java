import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import com.tencent.mobileqq.activity.richmedia.view.DynamicVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

public class xtn
  extends Handler
{
  public xtn(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10: 
      QLog.d("QzDynamicVideoPreviewActivity", 2, "handle msg - PREPARE_STATE_ONERROR");
      int i = paramMessage.getData().getInt("ONERROR_ERROR_KEY");
      this.a.d();
      switch (i)
      {
      case 3: 
      default: 
        if (i != -1)
        {
          QQToast.a(this.a, "合成错误(" + i + ")，请稍后重试", 0).a();
          return;
        }
        break;
      case 2: 
        QQToast.a(this.a, "获取尺寸错误，部分文件可能不存在", 0).a();
        return;
      case 4: 
      case 5: 
        QQToast.a(this.a, "存在不支持格式的素材，合成错误(" + i + ")", 0).a();
        return;
      }
      QQToast.a(this.a, "合成错误，请稍后重试", 0).a();
      return;
    case 20: 
      QLog.d("QzDynamicVideoPreviewActivity", 2, "handle msg - PREPARE_STATE_ONCOMPELETE");
      QzDynamicVideoPreviewActivity.a(this.a).setOnClickListener(this.a);
      QzDynamicVideoPreviewActivity.a(this.a).setSquareTypeAndColor(0, 0, 0, 0);
      this.a.d();
      this.a.a(20);
      if (!QzDynamicVideoPreviewActivity.a(this.a)) {
        this.a.e();
      }
      if ((!QzoneModuleManager.getInstance().isModuleDownloaded("cyber_clink.jar")) || (QzoneModuleManager.getInstance().checkIfNeedUpdate("cyber_clink.jar")))
      {
        QzDynamicVideoPreviewActivity.a(this.a);
        return;
      }
      QzDynamicVideoPreviewActivity.a(this.a).setVisibility(0);
      return;
    case 30: 
      paramMessage = paramMessage.getData().getString("keySucceedGeneratePath");
      QLog.d("QzDynamicVideoPreviewActivity", 2, "handle msg - GENERATE_VIDEO_SUCCESSFUL:" + paramMessage + ";generateState:" + QzDynamicVideoPreviewActivity.c(this.a));
      if (QzDynamicVideoPreviewActivity.b(this.a)) {
        QzDynamicVideoPreviewActivity.a(this.a, paramMessage);
      }
      QzDynamicVideoPreviewActivity.a(this.a, false);
      QzDynamicVideoPreviewActivity.a(this.a).setWaterMarkerEnable(QzDynamicVideoPreviewActivity.b(this.a));
      QzDynamicVideoPreviewActivity.b(this.a, true);
      QzDynamicVideoPreviewActivity.a(this.a, paramMessage);
      Object localObject;
      switch (QzDynamicVideoPreviewActivity.c(this.a))
      {
      default: 
        QLog.e("QzDynamicVideoPreviewActivity", 2, "generateState is invalid !");
        return;
      case 1: 
        localObject = Environment.getExternalStorageDirectory().toString() + File.separator;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.replace((CharSequence)localObject, "");
          QQToast.a(this.a, "已保存本地:" + paramMessage, 0).a();
        }
        QzDynamicVideoPreviewActivity.b(this.a);
        this.a.a();
        return;
      case 3: 
        QzDynamicVideoPreviewActivity.b(this.a);
        paramMessage = QZoneHelper.UserInfo.a();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_video_path", QzDynamicVideoPreviewActivity.a(this.a));
        QZoneHelper.c(this.a, paramMessage, (Bundle)localObject, 11);
        return;
      }
      QzDynamicVideoPreviewActivity.a(this.a, paramMessage, this.a.c);
      return;
    }
    QLog.e("QzDynamicVideoPreviewActivity", 2, "handle msg - GENERATE_VIDEO_FAILED");
    switch (paramMessage.getData().getInt("keyFailedErrCode", -1))
    {
    default: 
      QQToast.a(this.a, 2131432938, 0).a();
    }
    for (;;)
    {
      QzDynamicVideoPreviewActivity.c(this.a);
      return;
      QQToast.a(this.a, 2131432939, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtn
 * JD-Core Version:    0.7.0.1
 */