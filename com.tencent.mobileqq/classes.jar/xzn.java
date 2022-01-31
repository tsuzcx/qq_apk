import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xzn
  implements IFastRenderCallback
{
  public xzn(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onCompleted()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "FastRenderCallback onCompleted：" + QzDynamicVideoPreviewActivity.b(this.a));
    Object localObject = new File(QzDynamicVideoPreviewActivity.b(this.a));
    if (!((File)localObject).exists()) {
      QLog.e("QzDynamicVideoPreviewActivity", 2, "file do not exist ?! :" + QzDynamicVideoPreviewActivity.b(this.a));
    }
    for (;;)
    {
      if (!QzDynamicVideoPreviewActivity.b(this.a).endsWith(".mp4"))
      {
        QLog.d("QzDynamicVideoPreviewActivity", 2, "!renderingFilePath.endsWith(\".mp4\"");
        QzDynamicVideoPreviewActivity.b(this.a, QzDynamicVideoPreviewActivity.b(this.a) + ".mp4");
        FileUtils.d(((File)localObject).getPath(), QzDynamicVideoPreviewActivity.b(this.a));
        ((File)localObject).delete();
      }
      if ((QzDynamicVideoPreviewActivity.a(this.a) == null) || (QzDynamicVideoPreviewActivity.a(this.a).b == 0) || (QzDynamicVideoPreviewActivity.a(this.a).g == null) || (!new File(QzDynamicVideoPreviewActivity.a(this.a).g).exists())) {
        break;
      }
      QLog.d("QzDynamicVideoPreviewActivity", 2, "mixMusicToTempVideo ：" + QzDynamicVideoPreviewActivity.b(this.a));
      QzDynamicVideoPreviewActivity.b(this.a, QzDynamicVideoPreviewActivity.b(this.a));
      return;
      QLog.d("QzDynamicVideoPreviewActivity", 2, "file do exist ! :" + QzDynamicVideoPreviewActivity.b(this.a));
    }
    if (QzDynamicVideoPreviewActivity.b(this.a))
    {
      localObject = P2VGlobalConfig.P2V_VIDEO_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4";
      if (FileUtils.a(new File(QzDynamicVideoPreviewActivity.b(this.a)), new File((String)localObject)))
      {
        FileUtils.d(QzDynamicVideoPreviewActivity.b(this.a));
        QLog.d("QzDynamicVideoPreviewActivity", 2, "localVideo with waterMarker Path = " + (String)localObject);
      }
    }
    for (;;)
    {
      MediaScannerConnection.scanFile(this.a.getApplicationContext(), new String[] { QzDynamicVideoPreviewActivity.b(this.a) }, null, null);
      Message localMessage = new Message();
      Bundle localBundle = new Bundle();
      localBundle.putString("keySucceedGeneratePath", (String)localObject);
      localMessage.what = 30;
      localMessage.setData(localBundle);
      this.a.a.sendMessage(localMessage);
      return;
      localObject = QzDynamicVideoPreviewActivity.b(this.a);
      QLog.e("QzDynamicVideoPreviewActivity", 2, "localVideo with waterMarker copyFile failed, return path = " + (String)localObject);
      continue;
      localObject = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4";
      if (FileUtils.b(new File(QzDynamicVideoPreviewActivity.b(this.a)), new File((String)localObject)))
      {
        QLog.d("QzDynamicVideoPreviewActivity", 2, "localVideo with no waterMarker Path = " + (String)localObject);
      }
      else
      {
        localObject = QzDynamicVideoPreviewActivity.b(this.a);
        QLog.e("QzDynamicVideoPreviewActivity", 2, "localVideo with no waterMarker renameFile failed, return path = " + (String)localObject);
      }
    }
  }
  
  public void onError(int paramInt)
  {
    QzDynamicVideoPreviewActivity.a(this.a, false);
    QzDynamicVideoPreviewActivity.a(this.a).setWaterMarkerEnable(QzDynamicVideoPreviewActivity.b(this.a));
    QLog.d("QzDynamicVideoPreviewActivity", 2, "FastRenderCallback onError");
    if (QzDynamicVideoPreviewActivity.a(this.a).isHeld()) {
      QzDynamicVideoPreviewActivity.a(this.a).release();
    }
    this.a.runOnUiThread(new xzp(this, paramInt));
  }
  
  public void onProgress(int paramInt)
  {
    paramInt = (int)(paramInt * 0.98D);
    String str = paramInt + "%";
    this.a.runOnUiThread(new xzo(this, paramInt, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzn
 * JD-Core Version:    0.7.0.1
 */