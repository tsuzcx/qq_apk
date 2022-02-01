import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class wyl
  implements View.OnClickListener
{
  wyl(wyk paramwyk) {}
  
  public void onClick(View paramView)
  {
    if ((!wyk.a(this.a)) || (this.a.Rk()) || (System.currentTimeMillis() - wyk.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    Object localObject;
    abhh localabhh;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            wyk.a(this.a, System.currentTimeMillis());
            localMessageForApollo = (MessageForApollo)((wzb.a)wja.a(paramView)).mMessage;
            if (localMessageForApollo == null)
            {
              QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            }
            else
            {
              QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
              if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
              {
                QQToast.a(paramView.getContext(), acfp.m(2131702485), 0).show();
              }
              else
              {
                if (ApolloEngine.BJ()) {
                  break;
                }
                QLog.w("ApolloGameItemBuilder", 1, "apollo lib NOT loaded, click game return.");
              }
            }
          }
        } while ((!(this.a.mContext instanceof FragmentActivity)) || (((FragmentActivity)this.a.mContext).getChatFragment() == null));
        localObject = ((FragmentActivity)this.a.mContext).getChatFragment().a();
      } while ((localObject == null) || (this.a.sessionInfo == null));
      localabhh = (abhh)this.a.app.getManager(153);
    } while (localabhh == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      label310:
      int k = localabhh.cd(this.a.app.getCurrentUin());
      localObject = ((BaseChatPie)localObject).app;
      int m = ApolloUtil.a(this.a.sessionInfo, this.a.app);
      if (localMessageForApollo.playerList == null) {}
      for (int j = 0;; j = localMessageForApollo.playerList.size())
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        wyk.a(this.a, localMessageForApollo);
        break;
        if (localMessageForApollo.gameStatus == 3)
        {
          i = 1;
          break label310;
        }
        if ((localMessageForApollo.gameStatus != 7) && (localMessageForApollo.gameStatus != 4) && (localMessageForApollo.gameStatus != 5) && (localMessageForApollo.gameStatus != 6)) {
          break label501;
        }
        i = 2;
        break label310;
      }
      label501:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyl
 * JD-Core Version:    0.7.0.1
 */