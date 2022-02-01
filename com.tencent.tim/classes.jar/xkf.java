import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xkf
  implements View.OnClickListener
{
  xkf(xke paramxke) {}
  
  public void onClick(View paramView)
  {
    lcm.a().a(this.a.sessionInfo.aTl, null);
    xke.a locala = (xke.a)wja.a(paramView);
    ChatMessage localChatMessage = locala.mMessage;
    MessageForPubAccount localMessageForPubAccount;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((this.a.app != null) && (localChatMessage.istroop == 1))
      {
        anot.a(this.a.app, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.sessionInfo.aTl, "", "", "");
        if (((apsa)this.a.app.getManager(132)).E(this.a.sessionInfo.aTl, localChatMessage.uniseq)) {
          anot.a(this.a.app, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.sessionInfo.aTl, "", "", "");
        }
      }
      xke.a(this.a, locala, localChatMessage, l);
      xke.a(this.a, localChatMessage);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkf
 * JD-Core Version:    0.7.0.1
 */