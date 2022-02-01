import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wys
  implements View.OnClickListener
{
  public wys(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ApolloItemBuilder.b)wja.a(paramView);
    abhh localabhh = (abhh)this.this$0.app.getManager(153);
    localObject = (MessageForApollo)((ApolloItemBuilder.b)localObject).mMessage;
    if (localObject == null) {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ApolloActionData localApolloActionData = ((abxk)this.this$0.app.getManager(155)).b(((MessageForApollo)localObject).mApolloMessage.id);
      if (localApolloActionData == null)
      {
        QLog.e("ApolloItemBuilder", 1, "ApolloActionData is null.");
      }
      else
      {
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(localApolloActionData.gameId, ((MessageForApollo)localObject).isSend(), "message", 0L, 1, 0, 0, 0, "", 333001, localApolloActionData.gameName);
        localStartCheckParam.version = localabhh.db(localApolloActionData.gameId);
        localStartCheckParam.disableMinGame = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "game tail click: " + localStartCheckParam.toString());
        }
        ApolloGameUtil.a(this.this$0.mContext, localStartCheckParam);
        VipUtils.a(this.this$0.app, "cmshow", "Apollo", "game_actiontail_clk", ApolloUtil.gi(this.this$0.sessionInfo.cZ), 0, new String[] { Integer.toString(((MessageForApollo)localObject).mApolloMessage.id), Integer.toString(localApolloActionData.gameId) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wys
 * JD-Core Version:    0.7.0.1
 */