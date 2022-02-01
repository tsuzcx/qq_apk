import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvn
  implements View.OnClickListener
{
  xvn(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(11);
      }
      long l = System.currentTimeMillis();
      if (aagc.s(xvk.dr, l))
      {
        xvk.dr = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        zxj localzxj = (zxj)this.b.app.getManager(125);
        if (jof.a().dd(this.b.sessionInfo.aTl))
        {
          localzxj.cO(this.b.sessionInfo.aTl, 11);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.b.sessionInfo.cZ == 1)
          {
            localObject = (apsw)this.b.app.getManager(48);
            boolean bool = ((apsw)localObject).bg(this.b.sessionInfo.aTl, this.b.app.getCurrentAccountUin());
            localObject = ((apsw)localObject).a(this.b.sessionInfo.aTl, false);
            if ((bool) || ((localObject != null) && (((apsw.e)localObject).cSk)))
            {
              localzxj.cP(this.b.sessionInfo.aTl, 11);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject = localzxj.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject != null) && ((((zxi)localObject).isOpen) || (((zxi)localObject).isFinish) || (((zxi)localObject).bul) || (((zxi)localObject).expireTime < l)))
          {
            localzxj.z(localQQWalletRedPacketMsg.redPacketId, this.b.sessionInfo.aTl, this.b.sessionInfo.cZ);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=22", 0, null);
            localzxj.a(this.b.sessionInfo, (zxi)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((zxi)localObject).isOpen + ",isPasswdRedBagFinish=" + ((zxi)localObject).isFinish + ",isPasswdRedBagOverDue=" + ((zxi)localObject).bul);
            }
          }
          else
          {
            DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.b.e, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvn
 * JD-Core Version:    0.7.0.1
 */