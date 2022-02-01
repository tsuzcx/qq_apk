import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xkh
  implements View.OnClickListener
{
  xkh(xkg paramxkg) {}
  
  public void onClick(View paramView)
  {
    lcm.a().a(this.a.sessionInfo.aTl, null);
    Object localObject1 = (xkg.a)wja.a(paramView);
    if (obj.d(((xkg.a)localObject1).aVa, this.a.mContext)) {}
    for (;;)
    {
      localObject1 = ((xkg.a)localObject1).mMessage;
      if ((localObject1 instanceof MessageForPubAccount))
      {
        localObject1 = (MessageForPubAccount)localObject1;
        if ((((MessageForPubAccount)localObject1).mPAMessage != null) && (((MessageForPubAccount)localObject1).mPAMessage.mMsgId > 0L)) {
          anot.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", ((MessageForPubAccount)localObject1).frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(((MessageForPubAccount)localObject1).mPAMessage.mMsgId), "", "", "");
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((xkg.a)localObject1).aVb == null) || (!((xkg.a)localObject1).aVb.equals("open_local"))) {
        break;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("schemaurl", ((xkg.a)localObject1).aVc);
      ((Bundle)localObject2).putString("uin", this.a.app.getCurrentAccountUin());
      OpenAppClient.r((Activity)this.a.mContext, (Bundle)localObject2);
    }
    Object localObject2 = new Intent(this.a.mContext, PublicAccountBrowser.class);
    ((Intent)localObject2).putExtra("uin", this.a.app.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("url", ((xkg.a)localObject1).aVc);
    ((Intent)localObject2).putExtra("assignBackText", this.a.mContext.getResources().getString(2131691039));
    ((Intent)localObject2).putExtra("puin", this.a.sessionInfo.aTl);
    ((Intent)localObject2).putExtra("source_name", this.a.sessionInfo.aTn);
    MessageForPubAccount localMessageForPubAccount;
    if ((((xkg.a)localObject1).mMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)((xkg.a)localObject1).mMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {
        break label475;
      }
    }
    label475:
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if (l >= 0L) {
        ((Intent)localObject2).putExtra("msg_id", String.valueOf(l));
      }
      ((Intent)localObject2).putExtra("fromAio", true);
      ((Intent)localObject2).putExtra("big_brother_source_key", ocp.fq(this.a.sessionInfo.aTl));
      ocp.f((Intent)localObject2, ((xkg.a)localObject1).aVc);
      this.a.mContext.startActivity((Intent)localObject2);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, ((xkg.a)localObject1).aVc, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkh
 * JD-Core Version:    0.7.0.1
 */