import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
import java.util.ArrayList;

class xvr
  implements View.OnClickListener
{
  xvr(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(10);
      }
      long l = System.currentTimeMillis();
      if (!aagc.s(xvk.dr, l)) {
        continue;
      }
      xvk.dr = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      zxj localzxj = (zxj)this.b.app.getManager(125);
      if (jof.a().dd(this.b.sessionInfo.aTl))
      {
        localzxj.cO(this.b.sessionInfo.aTl, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        continue;
      }
      Object localObject1 = localzxj.a(localQQWalletRedPacketMsg.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((zxi)localObject1).isOpen) || (((zxi)localObject1).isFinish) || (((zxi)localObject1).bul) || (((zxi)localObject1).expireTime < l)))
      {
        localzxj.z(localQQWalletRedPacketMsg.redPacketId, this.b.sessionInfo.aTl, this.b.sessionInfo.cZ);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localzxj.a(this.b.sessionInfo, (zxi)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, null);
        localzxj.bm(localQQWalletRedPacketMsg.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((zxi)localObject1).isOpen + ",isPasswdRedBagFinish=" + ((zxi)localObject1).isFinish + ",isPasswdRedBagOverDue=" + ((zxi)localObject1).bul);
        continue;
      }
      if (this.b.e != null)
      {
        localObject2 = (wwn)this.b.e.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((wwn)localObject2).k(localQQWalletRedPacketMsg.redPacketId, localzxj.hV(((zxi)localObject1).bbb), xvk.cI(localQQWalletRedPacketMsg.body.subChannel), localQQWalletRedPacketMsg.body.subChannel);
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(localQQWalletRedPacketMsg.redPacketId);
        localzxj.a(this.b.sessionInfo, (ArrayList)localObject1);
        label452:
        localzxj.bm(localQQWalletRedPacketMsg.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
      }
      catch (Throwable localThrowable)
      {
        break label452;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvr
 * JD-Core Version:    0.7.0.1
 */