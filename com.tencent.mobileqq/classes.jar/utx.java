import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;

public class utx
  implements View.OnClickListener
{
  public utx(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int k = 1;
    int i;
    int j;
    label68:
    ApolloMessage localApolloMessage;
    if (ApolloItemBuilder.a(this.a) != null)
    {
      paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (paramView != null)
      {
        if (paramView.f() != 21) {
          break label131;
        }
        i = 1;
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!ApolloItemBuilder.a(this.a).isDoubleAction()) {
          break label136;
        }
        j = 1;
        VipUtils.a(paramView, "cmshow", "Apollo", "groupplusclick", i, j, new String[] { Integer.toString(ApolloItemBuilder.a(this.a).mApolloMessage.id) });
      }
      localApolloMessage = ApolloItemBuilder.a(this.a).mApolloMessage;
      if ((localApolloMessage != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break label141;
      }
    }
    label131:
    label136:
    label141:
    ApolloMainInfo localApolloMainInfo;
    do
    {
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      localApolloMainInfo = new ApolloMainInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = new ApolloActionData();
      ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      if (localApolloDaoManager == null) {
        break label376;
      }
      paramView = localApolloDaoManager.a(localApolloMessage.id);
    } while (paramView == null);
    label376:
    for (;;)
    {
      paramView.peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        paramView.atNickName = new String(localApolloMessage.text);
      }
      paramView.inputText = ApolloItemBuilder.a(this.a).inputText;
      localApolloMainInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramView;
      if (ApolloItemBuilder.a(this.a).isBarrageMode()) {}
      for (i = k;; i = 0)
      {
        localApolloMainInfo.d = i;
        localApolloMainInfo.b = ApolloItemBuilder.a(this.a).inputText;
        localApolloMainInfo.e = ApolloItemBuilder.a(this.a).audioId;
        localApolloMainInfo.jdField_a_of_type_Float = ApolloItemBuilder.a(this.a).audioStartTime;
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localApolloMainInfo);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */