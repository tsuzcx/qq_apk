import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class vqj
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public vqj(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    QQWalletRedPacketMsg localQQWalletRedPacketMsg;
    do
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(2);
              }
              l = System.currentTimeMillis();
            } while (!QWalletRedPkgUtils.a(this.jdField_a_of_type_Long, l));
            this.jdField_a_of_type_Long = l;
            localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
            localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
            localObject1 = (PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
            if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break;
            }
            ((PasswdRedBagManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break;
          }
          localObject2 = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
          boolean bool = ((TroopGagMgr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject2 = ((TroopGagMgr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          if ((!bool) && ((localObject2 == null) || (!((TroopGagMgr.SelfGagInfo)localObject2).jdField_a_of_type_Boolean))) {
            break;
          }
          ((PasswdRedBagManager)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        return;
        localObject2 = ((PasswdRedBagManager)localObject1).a(localQQWalletRedPacketMsg.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localObject2 == null) || ((!((PasswdRedBagInfo)localObject2).jdField_a_of_type_Boolean) && (!((PasswdRedBagInfo)localObject2).b) && (!((PasswdRedBagInfo)localObject2).c) && (((PasswdRedBagInfo)localObject2).jdField_a_of_type_Long >= l))) {
          break;
        }
        ((PasswdRedBagManager)localObject1).a(localQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
        ((PasswdRedBagManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (PasswdRedBagInfo)localObject2, l, 65536, localMessageForQQWalletMsg.fromHBList);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((PasswdRedBagInfo)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((PasswdRedBagInfo)localObject2).b + ",isPasswdRedBagOverDue=" + ((PasswdRedBagInfo)localObject2).c);
      return;
      Object localObject1 = new Intent();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((Intent)localObject1).putExtra("session", this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      ((Intent)localObject1).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
      Object localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject4 = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int j = ((Bundle)localObject4).getInt("groupType");
      localObject4 = ((Bundle)localObject4).getString("name");
      int i = 0;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
      }
      localObject2 = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject4, (String)localObject2, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("json", ((JSONObject)localObject2).toString());
      ((Bundle)localObject3).putString("callbackSn", "0");
      ((Intent)localObject1).putExtra("detail_bundle", (Bundle)localObject3);
      ((Intent)localObject1).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject1).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      PublicFragmentActivity.Launcher.a(paramView.getContext(), (Intent)localObject1, PublicTransFragmentActivity.class, RedPacketRecordFragment.class);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqj
 * JD-Core Version:    0.7.0.1
 */