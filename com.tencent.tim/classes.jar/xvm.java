import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvm
  implements View.OnClickListener
{
  xvm(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(9);
      }
      long l = System.currentTimeMillis();
      if (aagc.s(xvk.dr, l))
      {
        xvk.dr = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        zxj localzxj = (zxj)this.b.app.getManager(125);
        if (jof.a().dd(this.b.sessionInfo.aTl))
        {
          localzxj.cO(this.b.sessionInfo.aTl, 9);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.b.sessionInfo.cZ == 1)
          {
            localObject2 = (apsw)this.b.app.getManager(48);
            boolean bool = ((apsw)localObject2).bg(this.b.sessionInfo.aTl, this.b.app.getCurrentAccountUin());
            localObject2 = ((apsw)localObject2).a(this.b.sessionInfo.aTl, false);
            if ((bool) || ((localObject2 != null) && (((apsw.e)localObject2).cSk)))
            {
              localzxj.cP(this.b.sessionInfo.aTl, 9);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject2 = localzxj.a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject2 != null) && ((((zxi)localObject2).isOpen) || (((zxi)localObject2).isFinish) || (((zxi)localObject2).bul) || (((zxi)localObject2).expireTime < l)))
          {
            localzxj.z(((QQWalletRedPacketMsg)localObject1).redPacketId, this.b.sessionInfo.aTl, this.b.sessionInfo.cZ);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
            localObject1 = aagm.n(localMessageForQQWalletMsg);
            Bundle localBundle = new Bundle();
            localBundle.putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
            localzxj.a(this.b.sessionInfo, (zxi)localObject2, l, 262144, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((zxi)localObject2).isOpen + ",isPasswdRedBagFinish=" + ((zxi)localObject2).isFinish + ",isPasswdRedBagOverDue=" + ((zxi)localObject2).bul);
            }
          }
          else
          {
            RedPacketEmojiFragment.a(paramView.getContext(), this.b.e, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvm
 * JD-Core Version:    0.7.0.1
 */