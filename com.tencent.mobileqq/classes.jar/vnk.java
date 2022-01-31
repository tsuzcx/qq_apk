import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class vnk
  implements View.OnClickListener
{
  public vnk(StructingMsgItemBuilder paramStructingMsgItemBuilder, BaseChatPie paramBaseChatPie, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    paramView = ((PublicAccountChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    ((PublicAccountChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnk
 * JD-Core Version:    0.7.0.1
 */