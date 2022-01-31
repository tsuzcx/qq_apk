import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.vipgift.VipGiftManager;

public class vff
  implements View.OnClickListener
{
  public vff(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 70)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "obj", "Clk_talk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "", "", "");
      com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
      if (!StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
        break label257;
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 81)
      {
        StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, "clk_play");
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 98)
      {
        int i;
        label129:
        String str1;
        label144:
        String str3;
        if ((StructMsgItemLayout26.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mExtraData) & 0x2) != 0)
        {
          i = 1;
          if (!FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "isFaceScoreSecondMember")) {
            break label199;
          }
          str1 = "2";
          str3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
          if (i == 0) {
            break label205;
          }
        }
        label199:
        label205:
        for (String str2 = "2";; str2 = "1")
        {
          FaceScoreUtils.a("clk_obj", str3, new String[] { str1, "", "", str2 });
          break;
          i = 0;
          break label129;
          str1 = "1";
          break label144;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 109) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081EF", "0X80081EF", 0, 0, "", "", "", "");
      break;
      label257:
      if ((((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75)).b(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 38)) {}
      while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing instanceof MessageForTroopNotification))
      {
        paramView = (MessageForTroopNotification)this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramView.frienduin, "" + paramView.feedType, "", "");
        return;
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vff
 * JD-Core Version:    0.7.0.1
 */