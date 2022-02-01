import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class xvp
  implements View.OnClickListener
{
  xvp(xvk paramxvk) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null) {
        this.b.a.FJ(2);
      }
      long l = System.currentTimeMillis();
      if (aagc.s(xvk.dr, l))
      {
        xvk.dr = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        Object localObject2 = (zxj)this.b.app.getManager(125);
        if (jof.a().dd(this.b.sessionInfo.aTl))
        {
          ((zxj)localObject2).cO(this.b.sessionInfo.aTl, 2);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.b.sessionInfo.cZ == 1)
          {
            localObject3 = (apsw)this.b.app.getManager(48);
            boolean bool = ((apsw)localObject3).bg(this.b.sessionInfo.aTl, this.b.app.getCurrentAccountUin());
            localObject3 = ((apsw)localObject3).a(this.b.sessionInfo.aTl, false);
            if ((bool) || ((localObject3 != null) && (((apsw.e)localObject3).cSk)))
            {
              ((zxj)localObject2).cP(this.b.sessionInfo.aTl, 2);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject3 = ((zxj)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject3 != null) && ((((zxi)localObject3).isOpen) || (((zxi)localObject3).isFinish) || (((zxi)localObject3).bul) || (((zxi)localObject3).expireTime < l)))
          {
            ((zxj)localObject2).z(((QQWalletRedPacketMsg)localObject1).redPacketId, this.b.sessionInfo.aTl, this.b.sessionInfo.cZ);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
            localObject1 = aagm.n(localMessageForQQWalletMsg);
            ((zxj)localObject2).a(this.b.sessionInfo, (zxi)localObject3, l, 65536, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((zxi)localObject3).isOpen + ",isPasswdRedBagFinish=" + ((zxi)localObject3).isFinish + ",isPasswdRedBagOverDue=" + ((zxi)localObject3).bul);
            }
          }
          else
          {
            localObject2 = new Intent();
            if (this.b.e != null) {
              ((Intent)localObject2).putExtra("session", this.b.e.sessionInfo);
            }
            ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
            ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
            localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
            Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            Object localObject5 = aagc.a(this.b.app, this.b.sessionInfo);
            int j = ((Bundle)localObject5).getInt("groupType");
            localObject5 = ((Bundle)localObject5).getString("name");
            int i = 0;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
              i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
            }
            localObject3 = aagc.a(this.b.app, this.b.sessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.b.sessionInfo.aTl, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
            ((Bundle)localObject4).putString("callbackSn", "0");
            ((Intent)localObject2).putExtra("detail_bundle", (Bundle)localObject4);
            ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
            ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            if (!(paramView.getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            PublicFragmentActivity.b.start(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketVoiceFragment.class);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvp
 * JD-Core Version:    0.7.0.1
 */