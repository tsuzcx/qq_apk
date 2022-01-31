import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class vqk
  implements View.OnClickListener
{
  public vqk(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    QQWalletRedPacketMsg localQQWalletRedPacketMsg;
    do
    {
      PasswdRedBagManager localPasswdRedBagManager;
      PasswdRedBagInfo localPasswdRedBagInfo;
      do
      {
        do
        {
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(1);
          }
          paramView = (MessageForQQWalletMsg)paramView.getTag();
          localQQWalletRedPacketMsg = paramView.mQQWalletRedPacketMsg;
          localPasswdRedBagManager = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
          if (!AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localPasswdRedBagManager.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localPasswdRedBagInfo = localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localPasswdRedBagInfo == null) || ((!localPasswdRedBagInfo.jdField_a_of_type_Boolean) && (!localPasswdRedBagInfo.b) && (!localPasswdRedBagInfo.c) && (localPasswdRedBagInfo.jdField_a_of_type_Long >= l))) {
          break;
        }
        localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localPasswdRedBagInfo, l, paramView.fromHBList);
        localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localPasswdRedBagInfo.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localPasswdRedBagInfo.b + ",isPasswdRedBagOverDue=" + localPasswdRedBagInfo.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, "点击输入口令");
      }
      localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqk
 * JD-Core Version:    0.7.0.1
 */