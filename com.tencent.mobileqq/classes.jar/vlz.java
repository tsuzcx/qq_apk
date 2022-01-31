import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class vlz
  implements Runnable
{
  public vlz(PhotoListPanel paramPhotoListPanel, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.peek());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (i == 0) && (!PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)))
    {
      if (PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel) == 2147483647) {
        PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
      {
        if (LocalMultiProcConfig.getInt4UinString(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString) == 0) {
          break label272;
        }
        i = 1;
        if (i != 0)
        {
          localBaseBusinessAlbumInfo = QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, localBaseBusinessAlbumInfo.a());
          PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, localBaseBusinessAlbumInfo.b());
          if (TextUtils.isEmpty(PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel))) {
            PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, "群相册");
          }
          bool = PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
          ThreadManager.getUIHandler().post(new vma(this, bool));
          QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_chat_pie");
        }
      }
    }
    label272:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      for (;;)
      {
        BaseBusinessAlbumInfo localBaseBusinessAlbumInfo;
        boolean bool;
        return;
        i = 0;
      }
    }
    ThreadManager.getUIHandler().post(new vmb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlz
 * JD-Core Version:    0.7.0.1
 */