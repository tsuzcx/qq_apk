import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvs
  implements View.OnClickListener
{
  xvs(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (BaseChatItemLayout.bdx) {}
    label323:
    label848:
    label1106:
    label1109:
    label1125:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(0);
      }
      long l = System.currentTimeMillis();
      if (aagc.s(xvk.dr, l))
      {
        xvk.dr = l;
        int m = avor.c(paramView.getTag(2131379209), 0);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        if ((localMessageForQQWalletMsg == null) || (this.b.sessionInfo == null))
        {
          QLog.i(xvk.TAG, 2, "error, qqWalletMsg: " + localMessageForQQWalletMsg + ", sessionInfo: " + this.b.sessionInfo);
        }
        else
        {
          Object localObject2 = null;
          Object localObject1 = this.b.sessionInfo.aTl;
          Object localObject4;
          Object localObject3;
          if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
          {
            localObject4 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            localMessageForQQWalletMsg.msgtype = -2025;
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = "";
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = "";
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = 0;
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId = 0;
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
            localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
            localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
            this.b.app.b().c(this.b.sessionInfo.aTl, this.b.sessionInfo.cZ, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
            localObject3 = localObject1;
            localObject2 = null;
            localObject1 = localObject4;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label1125;
            }
            if (QLog.isColorLevel()) {
              QLog.d(xvk.TAG, 2, "elem.actionsPriority: " + ((QQWalletTransferMsgElem)localObject1).actionsPriority);
            }
            int i;
            if (TextUtils.isEmpty(((QQWalletTransferMsgElem)localObject1).actionsPriority))
            {
              aagc.N(paramView.getContext(), ((QQWalletTransferMsgElem)localObject1).linkUrl);
              break;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
                break label1109;
              }
              if ((this.b.sessionInfo.cZ == 0) || (this.b.sessionInfo.cZ == 1000) || (this.b.sessionInfo.cZ == 1004) || (this.b.sessionInfo.cZ == 1001) || (this.b.sessionInfo.cZ == 10002) || (this.b.sessionInfo.cZ == 10004) || (this.b.sessionInfo.cZ == 1008))
              {
                i = 1;
                label510:
                if ((i == 0) || (localMessageForQQWalletMsg.isSend())) {
                  break label1106;
                }
                localObject1 = this.b.app.getCurrentAccountUin();
              }
            }
            for (;;)
            {
              if ((localMessageForQQWalletMsg.fromHBList != 1) && ((localMessageForQQWalletMsg.istroop == 1) || (localMessageForQQWalletMsg.istroop == 3000)) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)) {
                aaca.K(localMessageForQQWalletMsg.frienduin, localMessageForQQWalletMsg.istroop, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
              }
              localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
              localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
              localMessageForQQWalletMsg.msgtype = -2025;
              localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
              localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
              this.b.app.b().c(this.b.sessionInfo.aTl, this.b.sessionInfo.cZ, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
              anot.a(this.b.app, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId, "", "", "");
              if ((((QQWalletTransferMsgElem)localObject4).skinId > 0) && ((localMessageForQQWalletMsg.messageType == 2) || (localMessageForQQWalletMsg.messageType == 3))) {
                anot.a(this.b.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.click", 0, 0, "" + ((QQWalletTransferMsgElem)localObject4).skinId, "", "", "");
              }
              localObject3 = localObject1;
              localObject1 = localObject4;
              break label323;
              i = 0;
              break label510;
              localObject4 = ((QQWalletTransferMsgElem)localObject1).actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              if (j < localObject4.length) {
                if (!TextUtils.isEmpty(localObject4[j])) {
                  break label872;
                }
              }
              for (;;)
              {
                for (;;)
                {
                  j += 1;
                  break label848;
                  break;
                  try
                  {
                    label872:
                    k = Integer.valueOf(localObject4[j]).intValue();
                    if (k == 1)
                    {
                      if (!aagc.N(paramView.getContext(), ((QQWalletTransferMsgElem)localObject1).linkUrl)) {
                        break label1101;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(xvk.TAG, 2, "start browser...");
                    }
                  }
                  catch (Exception localException)
                  {
                    int k;
                    for (;;)
                    {
                      if (QLog.isDevelopLevel()) {
                        localException.printStackTrace();
                      }
                      k = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.d(xvk.TAG, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject4[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k == 2)
                    {
                      String str = avor.a(((QQWalletTransferMsgElem)localObject1).jumpUrl, xvk.a(this.b, m), true);
                      if (!aagc.M(paramView.getContext(), str)) {
                        break label1101;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(xvk.TAG, 2, "do jump action...");
                      break;
                    }
                    if ((k == 3) && (xvk.a(this.b, paramView.getContext(), (QQWalletTransferMsgElem)localObject1, (String)localObject2, localObject3, localMessageForQQWalletMsg, this.b.sessionInfo)))
                    {
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(xvk.TAG, 2, "do wallet action...");
                      break;
                    }
                    i = -1;
                  }
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = null;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvs
 * JD-Core Version:    0.7.0.1
 */