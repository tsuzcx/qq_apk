import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

public class veu
  implements Runnable
{
  public veu(RichStatItemBuilder paramRichStatItemBuilder, MessageForRichState paramMessageForRichState) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(RichStatItemBuilder.a().feedsId))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.a(1)).b(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin });
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "sign feedid is is null reget friend sign");
      }
    }
    SignatureHandler localSignatureHandler;
    do
    {
      return;
      localSignatureHandler = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.a(41);
    } while (localSignatureHandler == null);
    localSignatureHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     veu
 * JD-Core Version:    0.7.0.1
 */