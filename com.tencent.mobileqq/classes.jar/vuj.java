import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzoneGetAlbumIntent.OnResultListener;

public class vuj
  implements QzoneGetAlbumIntent.OnResultListener
{
  public vuj(PhotoListPanel paramPhotoListPanel, String paramString) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0) {
      if (((TextUtils.isEmpty(PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel))) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) || (paramString1.equals(PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel))))
      {
        PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, paramString1, paramString2, true);
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)))) {
      return;
    }
    PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, "", "手机相册", true);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2);
    PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */