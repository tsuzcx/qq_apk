package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.bean.d;
import com.tencent.token.core.protocolcenter.protocol.b;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import oicq.wlogin_sdk.tools.ErrMsg;

class ad
  extends cb
{
  ad(AccountPageActivity paramAccountPageActivity)
  {
    super(paramAccountPageActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    label311:
    label573:
    label588:
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
                  do
                  {
                    do
                    {
                      boolean bool;
                      do
                      {
                        do
                        {
                          return;
                          h.c("account page: what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
                          switch (paramMessage.what)
                          {
                          default: 
                            return;
                          case 1000: 
                            AccountPageActivity.access$302(this.a, do.a().e());
                          }
                        } while (AccountPageActivity.access$300(this.a) == null);
                        AccountPageActivity.access$400(this.a).setVisibility(0);
                        if (AccountPageActivity.mNeedShowIpcMsg)
                        {
                          AccountPageActivity.access$500(this.a).setTextColor(this.a.getResources().getColor(2131492921));
                          AccountPageActivity.access$500(this.a).setText(this.a.getResources().getString(2131231252));
                          AccountPageActivity.access$600(this.a).setImageDrawable(this.a.getResources().getDrawable(2130837590));
                          AccountPageActivity.access$600(this.a).setVisibility(0);
                          if (AccountPageActivity.access$700(this.a) != 3) {
                            break label588;
                          }
                          if (!AccountPageActivity.access$300(this.a).mIsZzb) {
                            break label573;
                          }
                          AccountPageActivity.access$800(this.a).setText(2131231133);
                        }
                        for (;;)
                        {
                          ((d)AccountPageActivity.access$1000(this.a).get(Integer.valueOf(4))).a(2, null);
                          ((d)AccountPageActivity.access$1000(this.a).get(Integer.valueOf(2))).a(1, null);
                          AccountPageActivity.access$710(this.a);
                          this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                          return;
                          this.a.dismissDialog();
                          if (paramMessage.arg1 == 0)
                          {
                            paramMessage = (RealNameStatusResult)paramMessage.obj;
                            localObject = new Intent(this.a, RealNameActivity.class);
                            ((Intent)localObject).putExtra("realname_result", paramMessage);
                            ((Intent)localObject).putExtra("zzb_recommend_view", true);
                            this.a.startActivity((Intent)localObject);
                            return;
                          }
                          if (paramMessage.arg1 == 165)
                          {
                            if (RqdApplication.b) {
                              break;
                            }
                            AccountPageActivity.access$200(this.a);
                            return;
                          }
                          paramMessage = (f)paramMessage.obj;
                          this.a.showUserDialog(paramMessage.c);
                          return;
                          AccountPageActivity.access$500(this.a).setTextColor(this.a.getResources().getColor(2131493051));
                          AccountPageActivity.access$600(this.a).setImageDrawable(this.a.getResources().getDrawable(2130837589));
                          break label311;
                          AccountPageActivity.access$900(this.a).setText(2131231133);
                        }
                        if (AccountPageActivity.access$700(this.a) == 2)
                        {
                          if (AccountPageActivity.access$300(this.a).mIsZzb) {
                            AccountPageActivity.access$800(this.a).setText(2131231135);
                          }
                          for (;;)
                          {
                            ((d)AccountPageActivity.access$1000(this.a).get(Integer.valueOf(4))).a(3, null);
                            ((d)AccountPageActivity.access$1000(this.a).get(Integer.valueOf(2))).a(2, null);
                            AccountPageActivity.access$710(this.a);
                            this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                            return;
                            AccountPageActivity.access$900(this.a).setText(2131231135);
                          }
                        }
                        if (AccountPageActivity.access$700(this.a) == 1)
                        {
                          if (AccountPageActivity.access$300(this.a).mIsZzb) {
                            AccountPageActivity.access$800(this.a).setText(2131231134);
                          }
                          for (;;)
                          {
                            ((d)AccountPageActivity.access$1000(this.a).get(Integer.valueOf(2))).a(3, null);
                            AccountPageActivity.access$710(this.a);
                            this.a.mHandler.sendEmptyMessageDelayed(1000, 700L);
                            return;
                            AccountPageActivity.access$900(this.a).setText(2131231134);
                          }
                        }
                        AccountPageActivity.access$1100(this.a);
                        AccountPageActivity.access$1200(this.a);
                        AccountPageActivity.access$1302(this.a, false);
                        bool = AccountPageActivity.access$1500(this.a, AccountPageActivity.access$1400(this.a));
                      } while ((AccountPageActivity.access$1400(this.a).mCanZzb != 1) || (bool) || (AccountPageActivity.access$300(this.a).mIsZzb));
                      AccountPageActivity.access$1600(this.a);
                      ch.a().a(System.currentTimeMillis(), 202);
                      return;
                      if (paramMessage.arg1 == 0)
                      {
                        cw.a().d(0L, 3, this.a.mHandler);
                        return;
                      }
                    } while (do.a().e() == null);
                    paramMessage = (f)paramMessage.obj;
                    h.c("err " + paramMessage.a);
                    f.a(this.a.getResources(), paramMessage);
                    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
                    this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new ae(this));
                    return;
                    if (paramMessage.arg1 == 0)
                    {
                      paramMessage = (QueryCaptchaResult)paramMessage.obj;
                      if (paramMessage.mNeedCaptcha)
                      {
                        this.a.gotoVerifyActivity(paramMessage);
                        return;
                      }
                      cw.a().d(this.a.mHandler);
                      return;
                    }
                    paramMessage = (f)paramMessage.obj;
                    this.a.showUserDialog(paramMessage.c);
                    return;
                  } while (paramMessage.arg1 != 0);
                  cw.a().d(this.a.mHandler);
                  return;
                  if (paramMessage.arg1 == 0)
                  {
                    paramMessage = cx.c();
                    paramMessage.i();
                    paramMessage.n();
                    AccountPageActivity.access$1700(this.a).b(this.a.mHandler);
                    return;
                  }
                  paramMessage = (f)paramMessage.obj;
                  h.c("err " + paramMessage.a);
                  f.a(this.a.getResources(), paramMessage);
                  h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
                  this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, new af(this));
                  return;
                  if (paramMessage.arg1 == 0)
                  {
                    if (AccountPageActivity.access$1800(this.a))
                    {
                      this.a.onResume();
                      AccountPageActivity.access$1802(this.a, false);
                    }
                    for (;;)
                    {
                      LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
                      return;
                      AccountPageActivity.access$100(this.a, null, null);
                      AccountPageActivity.access$1900(this.a);
                    }
                  }
                } while (do.a().e() == null);
                Object localObject = (f)paramMessage.obj;
                AccountPageActivity.access$100(this.a, (f)localObject, paramMessage);
                return;
                AccountPageActivity.access$2002(this.a, "");
                ds.a().a(ds.e, AccountPageActivity.access$2000(this.a), this.a.mHandler);
                return;
                localObject = (byte[])paramMessage.obj;
                if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0))
                {
                  AccountPageActivity.access$2002(this.a, w.a((byte[])localObject));
                  ds.a().a(ds.e, AccountPageActivity.access$2000(this.a), this.a.mHandler);
                  return;
                }
                ds.a().a(ds.e, AccountPageActivity.access$2000(this.a), this.a.mHandler);
                return;
                paramMessage = paramMessage.getData().getByteArray("sig");
                AccountPageActivity.access$2002(this.a, w.a(paramMessage));
                AccountPageActivity.access$2100(this.a);
                return;
                this.a.dismissDialog();
                if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
                {
                  this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
                  return;
                }
                this.a.showToast(2131231411);
                return;
                h.c("K_MSG_GETEVALACCOUNTRESULT");
                if (paramMessage.arg1 == 0) {
                  break;
                }
                localObject = (f)paramMessage.obj;
                AccountPageActivity.access$100(this.a, (f)localObject, paramMessage);
                if ((paramMessage.arg1 == 40) || (paramMessage.arg1 == 42) || (paramMessage.arg1 == 64))
                {
                  int i = paramMessage.arg1;
                  this.a.goToRemoveProtectH5WithLoginTask(this.a, ((f)localObject).c, (ErrMsg)((f)localObject).d, i);
                  return;
                }
                if ((paramMessage.arg1 == 10027) || (paramMessage.arg1 == 151) || (paramMessage.arg1 == 152))
                {
                  this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new ag(this));
                  return;
                }
              } while (paramMessage.arg1 != 165);
              if (!RqdApplication.b)
              {
                AccountPageActivity.access$200(this.a);
                return;
              }
              AccountPageActivity.access$2302(this.a, true);
              return;
            } while (paramMessage.arg1 != 0);
            AccountPageActivity.access$1402(this.a, (EvalAccountResult)paramMessage.obj);
            AccountPageActivity.mNeedRefreshEval = false;
            AccountPageActivity.access$2400(this.a).setEnabled(true);
            AccountPageActivity.access$2500(this.a, AccountPageActivity.access$1400(this.a));
            return;
            if (paramMessage.arg1 == 0)
            {
              AccountPageActivity.access$2608(this.a);
              AccountPageActivity.access$2702(this.a, AccountPageActivity.access$2700(this.a) + AccountPageActivity.access$2800(this.a).h());
              if (AccountPageActivity.access$2700(this.a) > 0)
              {
                LoginMsgActivity.setShowNewMsgCnt(true, AccountPageActivity.access$2700(this.a));
                h.c("newMsgCount:" + AccountPageActivity.access$2700(this.a));
              }
              if ((!ds.a().e()) || (AccountPageActivity.access$2600(this.a) > 5)) {
                break;
              }
              ds.a().a(ds.c, AccountPageActivity.access$2000(this.a), this.a.mHandler);
              return;
            }
            if (paramMessage.arg1 != 185) {
              break;
            }
          } while (do.a().e() == null);
          cp.a(RqdApplication.l()).a("" + do.a().e().mRealUin, this.a.mHandler, 523005419L, 64);
          return;
          AccountPageActivity.access$2602(this.a, 0);
          this.a.refreshLoginLocation();
          AccountPageActivity.access$1700(this.a).d(0L, this.a.mHandler);
          AccountPageActivity.access$000(this.a);
          return;
        } while (paramMessage.arg1 != 0);
        if (AccountPageActivity.access$2900(this.a).h() > 0) {
          AccountPageActivity.access$3000(this.a).setVisibility(0);
        }
        for (;;)
        {
          OpreateMsgActivity.setShowNewMsgCnt();
          return;
          AccountPageActivity.access$3000(this.a).setVisibility(4);
        }
      } while ((this.a.isFinishing()) || (paramMessage.arg1 != 0));
      AccountPageActivity.access$1802(this.a, true);
      AccountPageActivity.mNeedRefreshEval = true;
      paramMessage = (b)paramMessage.obj;
    } while ((paramMessage.a != 1) || (paramMessage.b == null) || (paramMessage.b.length() <= 0));
    AccountPageActivity.access$3102(this.a, new AlertDialog.Builder(this.a).setTitle(2131231314).setMessage(paramMessage.b).setPositiveButton(2131231313, new aj(this, paramMessage)).setNegativeButton(2131230886, new ai(this)).setOnCancelListener(new ah(this)).create());
    AccountPageActivity.access$3100(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ad
 * JD-Core Version:    0.7.0.1
 */