import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class utq
  implements Runnable
{
  public utq(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage != null)
    {
      localObject = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.id);
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed) || (((ApolloActionData)localObject).feeType != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1) || (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgType))) {
        break label331;
      }
      localObject = new uty(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo, 0);
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new uty(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed) && (ApolloItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder) != this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq))
        {
          if (((BaseChatPie)localObject).f() != 21) {
            break label321;
          }
          i = 1;
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.isDoubleAction()) {
            break label326;
          }
        }
      }
    }
    label321:
    label326:
    for (int j = 1;; j = 0)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "grouppluspv", i, j, new String[] { Integer.toString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.id) });
      ApolloItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq);
      return;
      i = 0;
      break;
    }
    label331:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
    {
      ThreadManager.getUIHandler().post(new utr(this));
      return;
    }
    QLog.i("ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */