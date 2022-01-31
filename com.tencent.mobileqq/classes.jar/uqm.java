import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloGameItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uqm
  implements View.OnClickListener
{
  public uqm(ApolloGameItemBuilder paramApolloGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!ApolloGameItemBuilder.a(this.a)) || (this.a.a()) || (System.currentTimeMillis() - ApolloGameItemBuilder.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    ApolloManager localApolloManager;
    do
    {
      do
      {
        do
        {
          return;
          ApolloGameItemBuilder.a(this.a, System.currentTimeMillis());
          localMessageForApollo = (MessageForApollo)((ArkAppItemBubbleBuilder.Holder)AIOUtils.a(paramView)).a;
          if (localMessageForApollo == null)
          {
            QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            return;
          }
          QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
          if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
          {
            QQToast.a(paramView.getContext(), "消息接收失败，请查看其他消息", 0).a();
            return;
          }
          if (!ApolloEngine.a())
          {
            QLog.w("ApolloGameItemBuilder", 1, "apollo lib NOT loaded, click game return.");
            return;
          }
        } while ((!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() == null));
        paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      } while (paramView == null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break;
      }
      localApolloManager = (ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    } while (localApolloManager == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      int k = localApolloManager.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int m = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int j;
      if (localMessageForApollo.playerList == null)
      {
        j = 0;
        label343:
        VipUtils.a(paramView, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        if (localMessageForApollo.msgType != 4) {
          break label609;
        }
        i = 201;
        label410:
        j = localMessageForApollo.mGameMode;
        paramView = new CmGameStartChecker.StartCheckParam(localMessageForApollo.gameId, localMessageForApollo.isSend(), "message", localMessageForApollo.roomId, 1, j, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
        if (localMessageForApollo.msgType != 4) {
          break label616;
        }
        paramView.launchNewGame = true;
      }
      for (;;)
      {
        paramView.msgGameStatus = localMessageForApollo.gameStatus;
        paramView.extendJson = localMessageForApollo.gameExtendJson;
        ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, paramView);
        return;
        if (localMessageForApollo.gameStatus == 3)
        {
          i = 1;
          break;
        }
        if ((localMessageForApollo.gameStatus != 7) && (localMessageForApollo.gameStatus != 4) && (localMessageForApollo.gameStatus != 5) && (localMessageForApollo.gameStatus != 6)) {
          break label624;
        }
        i = 2;
        break;
        j = localMessageForApollo.playerList.size();
        break label343;
        label609:
        i = 200;
        break label410;
        label616:
        paramView.showAlertTips = true;
      }
      label624:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqm
 * JD-Core Version:    0.7.0.1
 */