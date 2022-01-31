package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.b;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dm;
import com.tencent.token.do;
import com.tencent.token.fe;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.utils.x;
import org.json.JSONArray;

class lp
  extends mv
{
  lp(IndexActivity paramIndexActivity)
  {
    super(paramIndexActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    int i;
    for (;;)
    {
      try
      {
        i = paramMessage.arg1;
        switch (paramMessage.what)
        {
        case 3069: 
          if ((paramMessage.arg1 != 0) || (dm.a().b() <= 0)) {
            break label2281;
          }
          bool1 = RqdApplication.b;
          if (bool1) {
            break label2281;
          }
          try
          {
            new DualMsgShowDialog(this.a, 2131362156, 0, false, 0L).show();
            return;
          }
          catch (Exception paramMessage)
          {
            return;
          }
        case 4004: 
          if (paramMessage.arg1 != 0) {
            break label278;
          }
          if (paramMessage.arg2 == 1)
          {
            bool1 = bool2;
            paramMessage = new Intent(this.a, NoCheckWithAuthActivity.class);
            paramMessage.putExtra("bindTokenSucc", true);
            paramMessage.putExtra("bindMobileSucc", bool1);
            this.a.startActivity(paramMessage);
            return;
          }
          break;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      bool1 = false;
    }
    label278:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
    return;
    this.a.dismissDialog();
    Object localObject;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1)
      {
        bool1 = bool3;
        paramMessage = new Intent(this.a, NoCheckWithAuthActivity.class);
        paramMessage.putExtra("bindTokenSucc", true);
        paramMessage.putExtra("bindMobileSucc", bool1);
        this.a.startActivity(paramMessage);
      }
    }
    else
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        postDelayed(new lq(this, (DeterminVerifyFactorsResult)paramMessage.obj), 10L);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
      paramMessage = (byte[])paramMessage.obj;
      IndexActivity.access$202(this.a, paramMessage);
      if (paramMessage != null)
      {
        IndexActivity.access$202(this.a, paramMessage);
        cw.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$100(this.a), IndexActivity.access$300(this.a));
        return;
        if (i == 0)
        {
          cw.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$100(this.a), IndexActivity.access$300(this.a), 1);
          return;
        }
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showToast(paramMessage.c);
        return;
        localObject = (byte[])paramMessage.obj;
        if ((i == 0) && (localObject != null))
        {
          IndexActivity.access$202(this.a, (byte[])localObject);
          cw.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$100(this.a), IndexActivity.access$300(this.a));
          return;
        }
        if (i == 2)
        {
          if (!this.a.isFinishing()) {
            new WtloginCaptchaDialog(this.a, 2131362182, IndexActivity.access$100(this.a), Long.toString(this.a.curruser.mRealUin)).show();
          }
        }
        else
        {
          if (i == -1000)
          {
            this.a.dismissDialog();
            this.a.showToast(2131230960);
            return;
          }
          if (i != 8192) {
            break label2287;
          }
          this.a.dismissDialog();
          this.a.showToast(2131231407);
          return;
          label1058:
          this.a.dismissDialog();
          this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new lr(this));
          return;
        }
      }
    }
    for (;;)
    {
      label1097:
      this.a.dismissDialog();
      IndexActivity.access$500(this.a, paramMessage, i);
      return;
      label2281:
      label2287:
      do
      {
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
          return;
        }
        this.a.showToast(2131231411);
        return;
        if (paramMessage.arg1 == 0)
        {
          paramMessage = do.a().e();
          h.a("curruser.verify_sms" + paramMessage.verify_sms);
          if (paramMessage.verify_sms == 1)
          {
            this.a.dismissDialog();
            localObject = new Intent(this.a, UnbindUinActivity.class);
            Bundle localBundle = new Bundle();
            localBundle.putLong("hash_uin", paramMessage.mUin);
            localBundle.putLong("real_uin", paramMessage.mRealUin);
            ((Intent)localObject).putExtra("com.tencent.real_uin", localBundle);
            this.a.startActivity((Intent)localObject);
            return;
          }
          cw.a().a(paramMessage.mUin, paramMessage.mRealUin, 2, IndexActivity.access$100(this.a));
          return;
        }
        this.a.dismissDialog();
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showTipDialog(2131231509, paramMessage.c);
        return;
        localObject = new StringBuilder().append("unbind");
        if (paramMessage.arg1 == 0) {
          bool1 = true;
        }
        h.a(bool1);
        if (paramMessage.arg1 == 0)
        {
          IndexActivity.access$600(this.a, this.a.curruser);
          do.a().n();
          paramMessage = new Intent(this.a, IndexActivity.class);
          paramMessage.putExtra("index_from", 16);
          paramMessage.addFlags(67108864);
          this.a.startActivity(paramMessage);
          this.a.showUserDialog(0, this.a.getString(2131230763) + this.a.curruser.mRealUin + this.a.getString(2131231511), 2131230897, IndexActivity.access$700(this.a), IndexActivity.access$800(this.a));
          this.a.remsumeMenu();
          return;
        }
        paramMessage = (f)paramMessage.obj;
        f.a(this.a.getResources(), paramMessage);
        this.a.dismissDialog();
        IndexActivity.access$900(this.a, paramMessage.c);
        return;
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (ConfigResult)paramMessage.obj;
          if (paramMessage != null)
          {
            if ((paramMessage.mStartUpImgUrl != null) && (paramMessage.mStartUpImgUrl.length() > 0))
            {
              long l = cx.c().s() / 1000L;
              if ((paramMessage.mStartUpImgStartTime > 0L) && (paramMessage.mStartUpImgEndTime > 0L) && (l < paramMessage.mStartUpImgEndTime) && ((x.a.mStartUpImgStartTime != paramMessage.mStartUpImgStartTime) || ((x.a.mStartUpImgUrl != null) && (!x.a.mStartUpImgUrl.equals(paramMessage.mStartUpImgUrl))) || (x.a.mStartUpImgEndTime != paramMessage.mStartUpImgEndTime))) {
                cw.a().a(paramMessage, IndexActivity.access$100(this.a));
              }
            }
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.utils_icon_flag"));
            h.b("IndexActivity--->to UtilsActivity");
          }
        }
        try
        {
          if (!fe.a().i()) {
            break label2281;
          }
          paramMessage = new HandlerThread("loguploader", 1);
          paramMessage.start();
          paramMessage = new Handler(paramMessage.getLooper());
          paramMessage.postDelayed(new ls(this, paramMessage), 30000L);
          return;
        }
        catch (Exception paramMessage)
        {
          return;
        }
        if ((!this.a.isFinishing()) && (paramMessage.arg1 == 0))
        {
          AccountPageActivity.mNeedRefreshEval = true;
          paramMessage = (b)paramMessage.obj;
          if ((paramMessage.a == 1) && (paramMessage.b != null) && (paramMessage.b.length() > 0))
          {
            IndexActivity.access$1002(this.a, new AlertDialog.Builder(this.a).setTitle(2131231314).setMessage(paramMessage.b).setPositiveButton(2131231313, new lv(this, paramMessage)).setNegativeButton(2131230886, new lu(this)).setOnCancelListener(new lt(this)).create());
            IndexActivity.access$1000(this.a).show();
            return;
            if (paramMessage.arg1 == 0)
            {
              this.a.onResume();
              LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
              return;
              if ((!this.a.isFinishing()) && (paramMessage.arg1 == 0))
              {
                paramMessage = (JSONArray)paramMessage.obj;
                if ((paramMessage != null) && (paramMessage.length() > 0))
                {
                  cw.a().a(paramMessage, IndexActivity.access$100(this.a));
                  return;
                  if (paramMessage.arg1 == 165)
                  {
                    if (!RqdApplication.b)
                    {
                      IndexActivity.access$1100(this.a);
                      return;
                    }
                    IndexActivity.access$1202(this.a, true);
                    return;
                    this.a.dismissDialog();
                    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
                    {
                      IndexActivity.access$900(this.a, this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
                      return;
                    }
                    IndexActivity.access$900(this.a, this.a.getResources().getString(2131231411));
                    return;
                    IndexActivity.access$1300(this.a);
                    return;
                  }
                }
              }
            }
          }
        }
        return;
        bool1 = false;
        break;
        if ((i == 1) || (i == 15) || (i == 16)) {
          break label1058;
        }
        if ((i == 40) || (i == 42)) {
          break label1097;
        }
      } while (i != 64);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lp
 * JD-Core Version:    0.7.0.1
 */