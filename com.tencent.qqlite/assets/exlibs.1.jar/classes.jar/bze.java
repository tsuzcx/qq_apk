import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;

public class bze
  implements DialogInterface.OnClickListener
{
  public bze(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie, PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BusinessCmrTmpChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie).mIsAgreeSyncLbs = false;
    BusinessCmrTmpChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie).mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a(BusinessCmrTmpChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie));
    BusinessCmrTmpChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bze
 * JD-Core Version:    0.7.0.1
 */