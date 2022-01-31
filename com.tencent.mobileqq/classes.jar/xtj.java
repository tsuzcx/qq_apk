import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class xtj
  implements DownloadProgressListener
{
  public xtj(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity, ArrayList paramArrayList) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QzDynamicVideoPreviewActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity))
    {
      QLog.e("QzDynamicVideoPreviewActivity", 2, new Object[] { "p2v get default music succ, download onDownloadFinish - timeout:", String.valueOf(System.currentTimeMillis() - QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity)) });
      return;
    }
    QzDynamicVideoPreviewActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, true);
    String str = QQStoryBGMusicUtils.a(paramString);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzDynamicVideoPreviewActivity", 2, "downloadDefaultMusic onDownloadFinish() url = " + paramString);
      }
      if ((QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity) != null) && (paramString.equals(QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).d)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(str);
        QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, true);
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).setMediaItems(this.jdField_a_of_type_JavaUtilArrayList);
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).resetVideoIndex();
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).prepare();
      return;
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      QLog.e("QzDynamicVideoPreviewActivity", 2, "downloadDefaultMusic music_download_failed");
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity));
      if (paramString == null)
      {
        QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(paramString);
        QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, true);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtj
 * JD-Core Version:    0.7.0.1
 */