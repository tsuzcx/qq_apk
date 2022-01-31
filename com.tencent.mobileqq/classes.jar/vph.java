import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;

public class vph
  implements Runnable
{
  public vph(PhotoListPanel paramPhotoListPanel, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_Boolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vph
 * JD-Core Version:    0.7.0.1
 */