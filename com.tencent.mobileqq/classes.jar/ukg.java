import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class ukg
  implements TroopManager.ITroopMemberInfoCallBack
{
  public BaseChatItemLayout a;
  
  private ukg(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((localObject != null) && (((TroopInfo)localObject).isHomeworkTroop())) {}
    do
    {
      return;
      localObject = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    } while ((paramTroopMemberInfo == null) || (!TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject).a.senderuin, paramTroopMemberInfo.memberuin)));
    BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, paramTroopMemberInfo.globalTroopLevel);
    paramTroopMemberInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder) > 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramTroopMemberInfo.a((QQAppInterface)localObject, bool, BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder), false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.d == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.d.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.d.setTag(Integer.valueOf(2131361868));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukg
 * JD-Core Version:    0.7.0.1
 */