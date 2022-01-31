import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class uzd
  implements View.OnClickListener
{
  public uzd(PASingleItemBuilder paramPASingleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySPEventReport.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    uze localuze = (uze)AIOUtils.a(paramView);
    long l2 = -1L;
    ChatMessage localChatMessage = localuze.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    long l1 = l2;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      paramView = (MessageForPubAccount)localChatMessage;
      l1 = l2;
      if (paramView.mPAMessage != null)
      {
        l1 = l2;
        if (paramView.mPAMessage.mMsgId > 0L) {
          l1 = paramView.mPAMessage.mMsgId;
        }
      }
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) && (localChatMessage.istroop == 1))
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      if (((TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localChatMessage.uniseq)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    EcShopAssistantManager localEcShopAssistantManager;
    EcshopReportHandler localEcshopReportHandler;
    JumpAction localJumpAction;
    int i;
    if (TextUtils.isEmpty(localuze.f))
    {
      paramView = localuze.e;
      localEcShopAssistantManager = (EcShopAssistantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      localEcshopReportHandler = (EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (TextUtils.isEmpty(paramView)) {
        break label864;
      }
      localJumpAction = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if (localJumpAction != null) {
        break label644;
      }
      if (localuze.jdField_a_of_type_Long != 0L) {
        break label554;
      }
      i = 0;
      label318:
      if (i == 0) {
        break label588;
      }
      if (PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.jdField_a_of_type_Long, paramView)) {
        break label559;
      }
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.b, localuze.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      label406:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
      if ((localChatMessage != null) && (localEcShopAssistantManager != null) && (localEcshopReportHandler != null) && (localEcShopAssistantManager.a(localChatMessage.senderuin))) {
        localEcshopReportHandler.a(false, localChatMessage, 1, paramView);
      }
      if ((localChatMessage instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)localChatMessage;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
    }
    label554:
    label559:
    label588:
    label864:
    do
    {
      return;
      paramView = localuze.f;
      break;
      i = 1;
      break label318;
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
      break label406;
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.b, localuze.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      break label406;
      if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.jdField_a_of_type_Long, paramView))
        {
          PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.b, localuze.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
          break label406;
        }
        PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        break label406;
      }
      if (!localJumpAction.b())
      {
        PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.b, localuze.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
        break label406;
      }
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
      break label406;
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localuze.jdField_a_of_type_JavaLangString, localuze.b, localuze.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
    } while ((localChatMessage == null) || (localEcShopAssistantManager == null) || (localEcshopReportHandler == null) || (!localEcShopAssistantManager.a(localChatMessage.senderuin)));
    label644:
    localEcshopReportHandler.a(false, localChatMessage, 1, localuze.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzd
 * JD-Core Version:    0.7.0.1
 */