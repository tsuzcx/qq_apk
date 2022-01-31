import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QZoneVideoCompressor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class xtk
  implements Runnable
{
  public xtk(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    Object localObject1 = QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).g;
    QLog.d("ffmpeg_concat", 2, "start mix music videoInterval:" + this.jdField_a_of_type_Long);
    Object localObject4;
    ArrayList localArrayList;
    int i;
    if ((this.jdField_a_of_type_Long > this.b) && (this.b > 0L))
    {
      long l = this.jdField_a_of_type_Long / this.b;
      try
      {
        File localFile = new File((String)localObject1);
        localObject4 = new File(P2VGlobalConfig.CONCAT_FINAL_MP3);
        if (!((File)localObject4).exists()) {
          ((File)localObject4).createNewFile();
        }
        for (;;)
        {
          localArrayList = new ArrayList();
          i = 0;
          while (i < l + 1L)
          {
            localArrayList.add(localFile);
            i += 1;
          }
          ((File)localObject4).delete();
          ((File)localObject4).createNewFile();
        }
        QLog.e("ffmpeg_concat", 2, "mergeMp3Files get an IOException:" + localIOException1);
      }
      catch (IOException localIOException1) {}
      label186:
      if (!QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity)) {
        break label911;
      }
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity) + 2000L);
    }
    label908:
    label911:
    for (Object localObject2 = P2VGlobalConfig.P2V_VIDEO_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4";; localObject3 = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "p2v_" + System.currentTimeMillis() + ".mp4")
    {
      for (;;)
      {
        localObject4 = new String[12];
        localObject4[0] = "-i";
        localObject4[1] = this.jdField_a_of_type_JavaLangString;
        localObject4[2] = "-i";
        localObject4[3] = localObject1;
        localObject4[4] = "-t";
        localObject4[5] = (QzDynamicVideoPreviewActivity.b(QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity)) + "");
        localObject4[6] = "-vcodec";
        localObject4[7] = "copy";
        localObject4[8] = "-acodec";
        localObject4[9] = "copy";
        localObject4[10] = "-y";
        localObject4[11] = localObject2;
        QLog.d("ffmpeg_concat", 2, "args_2:" + Arrays.toString((Object[])localObject4));
        i = QZoneVideoCompressor.a((String[])localObject4);
        QLog.d("ffmpeg_concat", 2, "QZoneVideoCompressor.trimByFFmpeg(args_2) - ret2:" + i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d != null)
        {
          localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d);
          if (((File)localObject1).exists()) {
            ((File)localObject1).delete();
          }
        }
        if (i != 0) {
          break label948;
        }
        localObject1 = new Message();
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("keySucceedGeneratePath", (String)localObject2);
        ((Message)localObject1).setData((Bundle)localObject4);
        ((Message)localObject1).what = 30;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a.sendMessage((Message)localObject1);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(localArrayList, (File)localObject4);
        localObject2 = P2VGlobalConfig.CONCAT_FINAL_MP3;
        try
        {
          QLog.d("ffmpeg_concat", 2, "mergeMp3Files done:" + localObject4);
          localObject1 = localObject2;
        }
        catch (IOException localIOException3)
        {
          localObject1 = localObject2;
          localObject2 = localIOException3;
        }
      }
      break;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      i = ((String)localObject1).lastIndexOf(".");
      if ((i > -1) && (i < ((String)localObject1).length() - 1)) {}
      for (localObject2 = ((String)localObject1).substring(i);; localObject2 = "") {
        for (;;)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(QQStoryConstant.d);
          localStringBuffer.append(((String)localObject1).hashCode());
          localStringBuffer.append("_");
          localStringBuffer.append(QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).d);
          localStringBuffer.append("_");
          localStringBuffer.append(this.jdField_a_of_type_Long);
          localStringBuffer.append((String)localObject2);
          localObject2 = new String(localStringBuffer);
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d = new File((String)localObject2).getCanonicalPath();
            i = QZoneVideoCompressor.a(new String[] { "-i", localObject1, "-ss", QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).d), "-t", QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, (int)QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity)), "-acodec", "copy", "-y", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d });
            QLog.e("ffmpeg_concat", 2, "clipMusic - clipMusicRet:" + i);
            if (i != 0) {
              break label908;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.d;
            localObject1 = localObject2;
          }
          catch (IOException localIOException2)
          {
            QLog.e("ffmpeg_concat", 2, "clipMusic get an IOException:" + localIOException2);
          }
        }
      }
      break label186;
    }
    label948:
    localObject1 = new Message();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("keyFailedGenerateError", "mix failed, error ret = " + i);
    ((Bundle)localObject3).putInt("keyFailedErrCode", 11);
    ((Message)localObject1).setData((Bundle)localObject3);
    ((Message)localObject1).what = 40;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtk
 * JD-Core Version:    0.7.0.1
 */