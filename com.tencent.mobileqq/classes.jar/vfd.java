import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;

public class vfd
  implements Runnable
{
  public vfd(StructingMsgItemBuilder paramStructingMsgItemBuilder, VipGiftDownloadInfo paramVipGiftDownloadInfo, VipGiftManager paramVipGiftManager) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.d == 1L) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(6L, this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.a);
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext).runOnUiThread(new vfe(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfd
 * JD-Core Version:    0.7.0.1
 */