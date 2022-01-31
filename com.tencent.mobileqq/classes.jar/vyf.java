import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.gdtad.net.GdtAdHandler.ReportInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class vyf
  implements Runnable
{
  public vyf(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    if (this.a.Y) {}
    EcshopReportHandler localEcshopReportHandler;
    do
    {
      return;
      this.a.Y = true;
      localEcshopReportHandler = (EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localEcshopReportHandler == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    if ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))
    {
      localObject2 = new GdtAdHandler.ReportInfo();
      ((GdtAdHandler.ReportInfo)localObject2).jdField_a_of_type_Int = 2;
      localObject1 = GdtAdHandler.a((GdtAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
      ((GdtAdHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(110)).a((GdtAdHandler.ReportInfo)localObject1, null);
    }
    for (;;)
    {
      int i = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("jump_from", 4);
      if (i != 2) {
        break;
      }
      localEcshopReportHandler.a(134243865, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i, false);
      return;
      if ((localObject1 instanceof MessageForArkApp)) {
        localEcshopReportHandler.a(134243863, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
      } else {
        localEcshopReportHandler.a(134243857, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyf
 * JD-Core Version:    0.7.0.1
 */