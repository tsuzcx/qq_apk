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

public class vug
  implements Runnable
{
  public vug(PhotoListPanel paramPhotoListPanel, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    boolean bool1 = false;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.peek());
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      i = 1;
      boolean bool2 = PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      if (((i == 0) && (!bool2)) || (j != 0) || (PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel))) {
        break label357;
      }
      if (PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel) == 2147483647) {
        PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel));
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.p))
      {
        if (LocalMultiProcConfig.getInt4UinString(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString) == 0) {
          break label345;
        }
        j = 1;
        if ((j != 0) || (bool2))
        {
          localObject = QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, ((BaseBusinessAlbumInfo)localObject).a());
          PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel, ((BaseBusinessAlbumInfo)localObject).b());
          if (TextUtils.isEmpty(PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)))
          {
            localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
            if (i == 0) {
              break label350;
            }
            localObject = "群相册";
            PhotoListPanel.b(localPhotoListPanel, (String)localObject);
          }
          if ((PhotoListPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.p)) {
            bool1 = true;
          }
          ThreadManager.getUIHandler().post(new vuh(this, bool2, bool1));
          QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_chat_pie");
        }
      }
    }
    label345:
    label350:
    label357:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      for (;;)
      {
        PhotoListPanel localPhotoListPanel;
        return;
        i = 0;
        break;
        j = 0;
        continue;
        Object localObject = "手机相册";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.p = false;
    ThreadManager.getUIHandler().post(new vui(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vug
 * JD-Core Version:    0.7.0.1
 */