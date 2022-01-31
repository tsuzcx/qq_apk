import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class vin
  implements View.OnClickListener
{
  public vin(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof MessageForText))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
      return;
    }
    MessageForText localMessageForText = (MessageForText)paramView;
    int i;
    if (localMessageForText.sb != null)
    {
      paramView = localMessageForText.sb.toString();
      if (!LoveLanguageManager.b(paramView)) {
        break label275;
      }
      paramView = LoveLanguageManager.b(paramView);
      i = 1;
    }
    for (;;)
    {
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      if ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(paramView, localSendMsgParams, 0);
      }
      LoveLanguageManager localLoveLanguageManager = (LoveLanguageManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273);
      if ((i != 0) && (localLoveLanguageManager.a())) {
        localSendMsgParams.i = true;
      }
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, null, localSendMsgParams);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      paramView = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((paramView != null) && (paramView.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", paramView, "");
        return;
        paramView = localMessageForText.msg;
        i = 0;
        break;
      }
      label275:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vin
 * JD-Core Version:    0.7.0.1
 */