package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.kingkong.Common;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.el;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import java.util.HashMap;

final class aa
  extends bo
{
  aa(AccountPageActivity paramAccountPageActivity)
  {
    super(paramAccountPageActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    label461:
    label476:
    label1009:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  Handler localHandler;
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        e.c("account page: what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
                        switch (paramMessage.what)
                        {
                        default: 
                          return;
                        case 1000: 
                          AccountPageActivity.access$202(this.a, ax.a().e());
                        }
                      } while (AccountPageActivity.access$200(this.a) == null);
                      AccountPageActivity.access$300(this.a).clearAnimation();
                      AccountPageActivity.access$300(this.a).setVisibility(0);
                      if (AccountPageActivity.mNeedShowIpcMsg)
                      {
                        AccountPageActivity.access$400(this.a).setTextColor(this.a.getResources().getColor(2131165344));
                        AccountPageActivity.access$400(this.a).setText(this.a.getResources().getString(2131362310));
                        AccountPageActivity.access$300(this.a).setImageDrawable(this.a.getResources().getDrawable(2130837509));
                        if (AccountPageActivity.access$500(this.a) != 3) {
                          break label476;
                        }
                        if (!AccountPageActivity.access$200(this.a).mIsZzb) {
                          break label461;
                        }
                        AccountPageActivity.access$600(this.a).setText(2131362321);
                      }
                      for (;;)
                      {
                        ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(4))).a(2, null);
                        ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(2))).a(1, null);
                        ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(3))).a(1, null);
                        AccountPageActivity.access$510(this.a);
                        this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                        return;
                        AccountPageActivity.access$400(this.a).setTextColor(this.a.getResources().getColor(2131165335));
                        AccountPageActivity.access$300(this.a).setImageDrawable(this.a.getResources().getDrawable(2130837507));
                        break;
                        AccountPageActivity.access$700(this.a).setText(2131362321);
                      }
                      if (AccountPageActivity.access$500(this.a) == 2)
                      {
                        if (AccountPageActivity.access$200(this.a).mIsZzb) {
                          AccountPageActivity.access$600(this.a).setText(2131362319);
                        }
                        for (;;)
                        {
                          ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(4))).a(3, null);
                          ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(2))).a(2, null);
                          ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(3))).a(1, null);
                          AccountPageActivity.access$510(this.a);
                          this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                          return;
                          AccountPageActivity.access$700(this.a).setText(2131362319);
                        }
                      }
                      if (AccountPageActivity.access$500(this.a) == 1)
                      {
                        if (AccountPageActivity.access$200(this.a).mIsZzb) {
                          AccountPageActivity.access$600(this.a).setText(2131362320);
                        }
                        for (;;)
                        {
                          ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(2))).a(3, null);
                          ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(3))).a(2, null);
                          AccountPageActivity.access$510(this.a);
                          this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                          return;
                          AccountPageActivity.access$700(this.a).setText(2131362320);
                        }
                      }
                      ((com.tencent.token.core.bean.d)AccountPageActivity.access$800(this.a).get(Integer.valueOf(3))).a(3, null);
                      AccountPageActivity.access$900(this.a);
                      AccountPageActivity.access$1100(this.a, AccountPageActivity.access$1000(this.a));
                      return;
                      if (paramMessage.arg1 == 0)
                      {
                        com.tencent.token.af.a().f(0L, 3, this.a.mHandler);
                        return;
                      }
                    } while (ax.a().e() == null);
                    paramMessage = (com.tencent.token.global.d)paramMessage.obj;
                    e.c("err " + paramMessage.a);
                    com.tencent.token.global.d.a(this.a.getResources(), paramMessage);
                    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
                    this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new ab(this));
                    return;
                    if (paramMessage.arg1 != 0) {
                      break label1009;
                    }
                    paramMessage = (QueryCaptchaResult)paramMessage.obj;
                    if (!paramMessage.mNeedCaptcha) {
                      break;
                    }
                    localObject = this.a;
                    localHandler = this.a.mHandler;
                  } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
                  new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
                  return;
                  com.tencent.token.af.a().d(this.a.mHandler);
                  return;
                  paramMessage = (com.tencent.token.global.d)paramMessage.obj;
                  this.a.showUserDialog(paramMessage.c);
                  return;
                  if (paramMessage.arg1 == 0)
                  {
                    paramMessage = com.tencent.token.ag.c();
                    paramMessage.i();
                    paramMessage.n();
                    AccountPageActivity.access$1200(this.a).b(this.a.mHandler);
                    return;
                  }
                  paramMessage = (com.tencent.token.global.d)paramMessage.obj;
                  e.c("err " + paramMessage.a);
                  com.tencent.token.global.d.a(this.a.getResources(), paramMessage);
                  e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
                  this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new ac(this));
                  return;
                  if (paramMessage.arg1 == 0)
                  {
                    if (AccountPageActivity.access$1300(this.a))
                    {
                      this.a.onResume();
                      AccountPageActivity.access$1302(this.a, false);
                    }
                    for (;;)
                    {
                      paramMessage = "0";
                      if (ax.a().e() != null) {
                        paramMessage = "" + ax.a().e().mRealUin;
                      }
                      Common.OnLogin(this.a, paramMessage);
                      LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
                      return;
                      AccountPageActivity.access$100(this.a, null, null);
                      AccountPageActivity.access$1400(this.a);
                    }
                  }
                } while (ax.a().e() == null);
                Object localObject = (com.tencent.token.global.d)paramMessage.obj;
                AccountPageActivity.access$100(this.a, (com.tencent.token.global.d)localObject, paramMessage);
                return;
                AccountPageActivity.access$1502(this.a, "");
                bb.a().a(bb.e, AccountPageActivity.access$1500(this.a), this.a.mHandler);
                return;
                localObject = (byte[])paramMessage.obj;
                if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0)) {
                  AccountPageActivity.access$1502(this.a, s.a((byte[])localObject));
                }
                bb.a().a(bb.e, AccountPageActivity.access$1500(this.a), this.a.mHandler);
                return;
                this.a.dismissDialog();
                if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
                {
                  this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
                  return;
                }
                this.a.showToast(2131362091);
                return;
                e.c("K_MSG_GETEVALACCOUNTRESULT");
                if (paramMessage.arg1 == 0) {
                  break;
                }
                localObject = (com.tencent.token.global.d)paramMessage.obj;
                AccountPageActivity.access$100(this.a, (com.tencent.token.global.d)localObject, paramMessage);
                if ((paramMessage.arg1 == 10027) || (paramMessage.arg1 == 151) || (paramMessage.arg1 == 152))
                {
                  this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new ad(this));
                  return;
                }
              } while (paramMessage.arg1 != 165);
              if (!RqdApplication.b)
              {
                AccountPageActivity.access$1600(this.a);
                return;
              }
              AccountPageActivity.access$1702(this.a, true);
              return;
            } while (paramMessage.arg1 != 0);
            AccountPageActivity.access$1002(this.a, (EvalAccountResult)paramMessage.obj);
            AccountPageActivity.mNeedRefreshEval = false;
            AccountPageActivity.access$1800(this.a, AccountPageActivity.access$1000(this.a));
            return;
            if (paramMessage.arg1 == 0)
            {
              AccountPageActivity.access$1908(this.a);
              AccountPageActivity.access$2012(this.a, AccountPageActivity.access$2100(this.a).i());
              if (AccountPageActivity.access$2000(this.a) > 0)
              {
                LoginMsgActivity.setShowNewMsgCnt(true, AccountPageActivity.access$2000(this.a));
                e.c("newMsgCount:" + AccountPageActivity.access$2000(this.a));
              }
              if ((!bb.a().e()) || (AccountPageActivity.access$1900(this.a) > 5)) {
                break;
              }
              bb.a().a(bb.c, AccountPageActivity.access$1500(this.a), this.a.mHandler);
              return;
            }
            if (paramMessage.arg1 != 185) {
              break;
            }
          } while (ax.a().e() == null);
          x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, this.a.mHandler, false);
          return;
          AccountPageActivity.access$1902(this.a, 0);
          this.a.refreshLoginLocation();
          AccountPageActivity.access$1200(this.a).d(0L, this.a.mHandler);
          AccountPageActivity.access$000(this.a);
          return;
        } while (paramMessage.arg1 != 0);
        if (AccountPageActivity.access$2200(this.a).i() > 0) {
          AccountPageActivity.access$2300(this.a).setVisibility(0);
        }
        OpreateMsgActivity.setShowNewMsgCnt();
        return;
      } while ((this.a.isFinishing()) || (paramMessage.arg1 != 0));
      AccountPageActivity.access$1302(this.a, true);
      AccountPageActivity.mNeedRefreshEval = true;
      paramMessage = (el)paramMessage.obj;
    } while ((paramMessage.a != 1) || (paramMessage.b == null) || (paramMessage.b.length() <= 0));
    AccountPageActivity.access$2402(this.a, new AlertDialog.Builder(this.a).setTitle(2131362452).setMessage(paramMessage.b).setPositiveButton(2131362453, new ag(this, paramMessage)).setNegativeButton(2131361804, new af(this)).setOnCancelListener(new ae(this)).create());
    AccountPageActivity.access$2400(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aa
 * JD-Core Version:    0.7.0.1
 */