import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xzs
  implements Runnable
{
  public xzs(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity, long paramLong, String paramString) {}
  
  private void a(String paramString)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyFailedGenerateError", paramString);
    localBundle.putInt("keyFailedErrCode", 11);
    localMessage.setData(localBundle);
    localMessage.what = 40;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a.sendMessage(localMessage);
  }
  
  public void run()
  {
    String str = QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).g;
    QLog.d("ffmpeg_concat", 2, "start mix music videoInterval:" + this.jdField_a_of_type_Long);
    Object localObject;
    if (QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity))
    {
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity) + 2000L);
      localObject = P2VGlobalConfig.P2V_VIDEO_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4";
    }
    try
    {
      for (;;)
      {
        int i = QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).d;
        int j = QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).f;
        FFmpegUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, this.jdField_a_of_type_JavaLangString, str, i, j, (String)localObject, true, new xzt(this, (String)localObject));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d != null)
        {
          localObject = new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
        }
        return;
        localObject = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4";
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("ffmpeg_concat", 2, "combinBackgroundMusic error", localThrowable);
        a("mix failed, error combinBackgroundMusic");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzs
 * JD-Core Version:    0.7.0.1
 */