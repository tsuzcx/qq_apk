import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.TroopWantGiftItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class vkw
  implements View.OnClickListener
{
  public vkw(TroopWantGiftItemBuilder paramTroopWantGiftItemBuilder, ChatMessage paramChatMessage, MessageForWantGiftMsg paramMessageForWantGiftMsg) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362152)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_send_him").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + "", "29" }).a();
      paramView = SharedPreUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext, "url");
      if (TextUtils.isEmpty(paramView)) {
        break label216;
      }
    }
    for (;;)
    {
      paramView = paramView.replace("{troopUin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForWantGiftMsg.frienduin).replace("{uin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForWantGiftMsg.senderuin).replace("{from}", "29");
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      label216:
      paramView = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */