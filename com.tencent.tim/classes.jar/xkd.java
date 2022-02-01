import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class xkd
  implements View.OnClickListener
{
  xkd(xkc paramxkc) {}
  
  public void onClick(View paramView)
  {
    xkc.a locala = (xkc.a)paramView.getTag();
    Object localObject = wja.a(paramView);
    MessageForPubAccount localMessageForPubAccount;
    if ((localObject instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localObject;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((locala == null) || (!(localObject instanceof MessageForPubAccount))) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener holder = " + locala + ", msg = " + localObject);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForPubAccount = (MessageForPubAccount)localObject;
        if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
        }
      }
      PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(locala.itemIndex);
      lcm.a().a(this.a.sessionInfo.aTl, null);
      if (this.a.app != null)
      {
        anot.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.sessionInfo.aTl, "mp_msg_msgpic_click", "aio_morpic_click", locala.itemIndex + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
        if (localMessageForPubAccount.istroop == 1)
        {
          anot.a(this.a.app, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.sessionInfo.aTl, "", "", "");
          if (((apsa)this.a.app.getManager(132)).E(this.a.sessionInfo.aTl, localMessageForPubAccount.uniseq)) {
            anot.a(this.a.app, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.sessionInfo.aTl, "", "", "");
          }
        }
      }
      if (TextUtils.isEmpty(localItem.a_actionData)) {}
      for (localObject = localItem.actionData;; localObject = localItem.a_actionData)
      {
        xkc.a(this.a, localItem, locala, (String)localObject, l);
        xkc.a(this.a, localMessageForPubAccount, locala, l, (String)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkd
 * JD-Core Version:    0.7.0.1
 */