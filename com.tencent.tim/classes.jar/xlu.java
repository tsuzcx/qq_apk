import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xlu
  implements View.OnClickListener
{
  xlu(xlt paramxlt) {}
  
  public void onClick(View paramView)
  {
    if (this.a.Rk()) {}
    label145:
    label166:
    label201:
    label608:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (aagc.s(this.a.dr, l))
      {
        this.a.dr = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((xlt.a)wja.a(paramView)).mMessage;
        String str = this.a.sessionInfo.aTl;
        if (localMessageForQQWalletMsg != null)
        {
          QQWalletTransferMsgElem localQQWalletTransferMsgElem;
          Object localObject;
          int i;
          if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
          {
            localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            if (localMessageForQQWalletMsg.messageType == 9) {
              if (localMessageForQQWalletMsg.isSend())
              {
                anot.a(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.buyerclick", 0, 0, "", "", "", "");
                localObject = localMessageForQQWalletMsg.mQQWalletTransferMsg.body;
                if (localObject == null) {
                  break label298;
                }
                i = ((QQWalletAioBodyReserve)localObject).pfa_type;
                if (i != 1) {
                  break label303;
                }
                anot.a(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.qiukaitong.click", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d(xlt.TAG, 2, "onClick pfa_type=" + i);
                }
              }
            }
          }
          for (;;)
          {
            for (;;)
            {
              if (localQQWalletTransferMsgElem == null) {
                break label608;
              }
              if (TextUtils.isEmpty(localQQWalletTransferMsgElem.actionsPriority))
              {
                aagc.N(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl);
                break;
                anot.a(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payerclick", 0, 0, "", "", "", "");
                break label145;
                i = 0;
                break label166;
                if (i != 2) {
                  break label201;
                }
                anot.a(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.yikaitong.click", 0, 0, "", "", "", "");
                break label201;
                anot.a(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletTransferMsg.templateId, "", "", "");
                continue;
              }
              localObject = localQQWalletTransferMsgElem.actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              while (j < localObject.length)
              {
                if (!TextUtils.isEmpty(localObject[j])) {
                  break label438;
                }
                j += 1;
              }
              break;
              try
              {
                k = Integer.valueOf(localObject[j]).intValue();
                if (k == 1)
                {
                  if (aagc.N(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl)) {
                    break;
                  }
                  i = -1;
                }
              }
              catch (Exception localException)
              {
                int k;
                do
                {
                  do
                  {
                    for (;;)
                    {
                      if (QLog.isDevelopLevel()) {
                        localException.printStackTrace();
                      }
                      k = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.d(xlt.TAG, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k != 2) {
                      break;
                    }
                  } while (!aagc.M(paramView.getContext(), localQQWalletTransferMsgElem.jumpUrl));
                  break;
                } while ((k != 3) || (!xlt.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, null, str, localMessageForQQWalletMsg, this.a.sessionInfo)));
              }
            }
            break;
            localQQWalletTransferMsgElem = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlu
 * JD-Core Version:    0.7.0.1
 */