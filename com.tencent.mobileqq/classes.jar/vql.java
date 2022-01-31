import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class vql
  implements View.OnClickListener
{
  public vql(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (BaseChatItemLayout.a) {}
    label403:
    label685:
    label848:
    label851:
    label862:
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(0);
      }
      long l = System.currentTimeMillis();
      if (QWalletRedPkgUtils.a(this.a.jdField_a_of_type_Long, l))
      {
        this.a.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (localMessageForQQWalletMsg != null)
        {
          QQWalletTransferMsgElem localQQWalletTransferMsgElem;
          Object localObject3;
          Object localObject2;
          if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
          {
            localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
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
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
          for (;;)
          {
            label254:
            if (localQQWalletTransferMsgElem == null) {
              break label862;
            }
            int i;
            if (TextUtils.isEmpty(localQQWalletTransferMsgElem.actionsPriority))
            {
              QWalletRedPkgUtils.b(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl);
              return;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
                break label851;
              }
              if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
              {
                i = 1;
                if ((i == 0) || (localMessageForQQWalletMsg.isSend())) {
                  break label848;
                }
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              }
            }
            for (;;)
            {
              for (;;)
              {
                if ((localMessageForQQWalletMsg.fromHBList != 1) && ((localMessageForQQWalletMsg.istroop == 1) || (localMessageForQQWalletMsg.istroop == 3000)) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)) {
                  NotifyMsgManager.a(localMessageForQQWalletMsg.frienduin, localMessageForQQWalletMsg.istroop, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
                }
                localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
                localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
                localMessageForQQWalletMsg.msgtype = -2025;
                localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
                localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId, "", "", "");
                localObject2 = localObject1;
                localObject1 = localObject3;
                break label254;
                i = 0;
                break label403;
                localObject3 = localQQWalletTransferMsgElem.actionsPriority.split("\\|");
                int j = 0;
                i = 0;
                while (j < localObject3.length)
                {
                  if (!TextUtils.isEmpty(localObject3[j])) {
                    break label685;
                  }
                  j += 1;
                }
                break;
                try
                {
                  k = Integer.valueOf(localObject3[j]).intValue();
                  if (k == 1)
                  {
                    if (QWalletRedPkgUtils.b(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl)) {
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
                          QLog.d(QQWalletHbItemUtils.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject3[j] + " to Interger,", localException);
                          k = i;
                        }
                      }
                      if (k != 2) {
                        break;
                      }
                    } while (!QWalletRedPkgUtils.a(paramView.getContext(), localQQWalletTransferMsgElem.jumpUrl));
                    return;
                  } while ((k != 3) || (!QQWalletHbItemUtils.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, (String)localObject1, localObject2, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)));
                  return;
                }
              }
            }
            localObject2 = localObject1;
            localObject1 = null;
            localQQWalletTransferMsgElem = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vql
 * JD-Core Version:    0.7.0.1
 */