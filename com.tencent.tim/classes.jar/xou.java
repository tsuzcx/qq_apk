import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xou
  implements View.OnClickListener
{
  public xou(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 81) {
      rar.a(this.this$0.app, this.this$0.mContext, this.e, "clk_play");
    }
    while (this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 98)
    {
      wja.bcO = true;
      if (!this.this$0.Rk()) {
        break;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i;
    label86:
    Object localObject;
    label101:
    String str2;
    if ((antl.ew(this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mExtraData) & 0x2) != 0)
    {
      i = 1;
      if (!ajpc.a(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage, "isFaceScoreSecondMember")) {
        break label156;
      }
      localObject = "2";
      str2 = this.jdField_b_of_type_ComTencentMobileqqDataChatMessage.frienduin;
      if (i == 0) {
        break label162;
      }
    }
    label156:
    label162:
    for (String str1 = "2";; str1 = "1")
    {
      ajpc.b("clk_obj", str2, new String[] { localObject, "", "", str1 });
      break;
      i = 0;
      break label86;
      localObject = "1";
      break label101;
    }
    if ((((aqxh)this.this$0.app.getManager(76)).cZ(this.val$time)) && (this.jdField_b_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 38)) {}
    for (;;)
    {
      if ((this.e instanceof MessageForTroopNotification))
      {
        localObject = (MessageForTroopNotification)this.e;
        anot.a(this.this$0.app, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, ((MessageForTroopNotification)localObject).frienduin, "" + ((MessageForTroopNotification)localObject).feedType, "", "");
      }
      this.this$0.c((MessageForStructing)this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      break;
      this.dV.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xou
 * JD-Core Version:    0.7.0.1
 */