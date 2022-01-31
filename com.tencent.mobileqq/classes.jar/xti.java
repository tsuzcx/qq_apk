import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import java.util.ArrayList;

public class xti
  implements Runnable
{
  public xti(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    QQStoryMusicInfo localQQStoryMusicInfo;
    if (!QzDynamicVideoPreviewActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity))
    {
      QzDynamicVideoPreviewActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, true);
      localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity));
      if (localQQStoryMusicInfo != null) {
        break label82;
      }
      QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, false);
    }
    for (;;)
    {
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).setMediaItems(this.jdField_a_of_type_JavaUtilArrayList);
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).resetVideoIndex();
      QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity).prepare();
      return;
      label82:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity.a(localQQStoryMusicInfo);
      QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQzDynamicVideoPreviewActivity, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xti
 * JD-Core Version:    0.7.0.1
 */