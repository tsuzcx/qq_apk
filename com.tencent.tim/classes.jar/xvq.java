import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvq
  implements View.OnClickListener
{
  xvq(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(1);
      }
      long l = System.currentTimeMillis();
      if (aagc.s(xvk.dr, l))
      {
        xvk.dr = l;
        Object localObject = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
        zxj localzxj = (zxj)this.b.app.getManager(125);
        if (jof.a().dd(this.b.sessionInfo.aTl))
        {
          localzxj.cO(this.b.sessionInfo.aTl, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          zxi localzxi = localzxj.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localzxi != null) && ((localzxi.isOpen) || (localzxi.isFinish) || (localzxi.bul) || (localzxi.expireTime < l)))
          {
            localzxj.z(localQQWalletRedPacketMsg.redPacketId, this.b.sessionInfo.aTl, this.b.sessionInfo.cZ);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            localzxj.a(this.b.sessionInfo, localzxi, l, ((MessageForQQWalletMsg)localObject).fromHBList);
            localzxj.bm(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localzxi.isOpen + ",isPasswdRedBagFinish=" + localzxi.isFinish + ",isPasswdRedBagOverDue=" + localzxi.bul);
            }
          }
          else
          {
            if (this.b.e != null)
            {
              localObject = (wwn)this.b.e.a(27);
              if (localObject != null) {
                ((wwn)localObject).ai(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, acfp.m(2131712581));
              }
            }
            localzxj.bm(localQQWalletRedPacketMsg.redPacketId, false);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvq
 * JD-Core Version:    0.7.0.1
 */