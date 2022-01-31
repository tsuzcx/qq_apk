package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.utils.w;

class yb
  extends cb
{
  yb(ScanLoginAccountListActivity paramScanLoginAccountListActivity)
  {
    super(paramScanLoginAccountListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    switch (paramMessage.what)
    {
    default: 
    case 1006: 
    case 1019: 
    case 4097: 
    case 4098: 
      do
      {
        return;
        this.a.dismissDialog();
        if (paramMessage.arg1 == 0)
        {
          paramMessage = new Intent(this.a, UnbindUinActivity.class);
          localObject = new Bundle();
          ((Bundle)localObject).putLong("hash_uin", ScanLoginAccountListActivity.access$000(this.a).mUin);
          ((Bundle)localObject).putLong("real_uin", ScanLoginAccountListActivity.access$000(this.a).mRealUin);
          paramMessage.putExtra("com.tencent.real_uin", (Bundle)localObject);
          this.a.startActivity(paramMessage);
          return;
        }
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131231509, paramMessage.c, 2131230897, null);
        return;
        ScanLoginAccountListActivity.access$400(this.a).a(ScanLoginAccountListActivity.access$100(this.a), ScanLoginAccountListActivity.access$200(this.a), ScanLoginAccountListActivity.access$300(this.a), w.l(), 523005419L);
        return;
        i = paramMessage.arg1;
        if (i != 2) {
          break;
        }
      } while (this.a.isFinishing());
      new WtloginCaptchaDialog(this.a, 2131362182, ScanLoginAccountListActivity.access$300(this.a), ScanLoginAccountListActivity.access$100(this.a)).show();
      return;
      if (i == 0)
      {
        h.b("getstwithoutpasswd:succ");
        ScanLoginAccountListActivity.access$400(this.a).a(ScanLoginAccountListActivity.access$100(this.a), ScanLoginAccountListActivity.access$200(this.a), ScanLoginAccountListActivity.access$300(this.a), w.l(), 523005419L);
        return;
      }
      if (i == -1000) {
        this.a.showToast(2131230960);
      }
      for (;;)
      {
        this.a.dismissDialog();
        return;
        if (i == 8192)
        {
          this.a.showToast(2131231407);
        }
        else if ((i == 15) || (i == 1) || (i == 16) || (i == -1004))
        {
          this.a.showToast(2131231406);
          ScanLoginAccountListActivity.access$500(this.a);
        }
        else if ((i == 40) || (i == 42) || (i == 64))
        {
          this.a.dismissDialog();
          this.a.goToRemoveProtectH5(this.a, paramMessage, i);
        }
        else if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
        }
        else
        {
          this.a.showToast(2131231411);
        }
      }
    case 4101: 
      this.a.dismissDialog();
      i = paramMessage.arg1;
      h.b("verify code,ret=" + i);
      if (i == 0)
      {
        localObject = new Intent(this.a, ScanLoginConfirmLoginActivity.class);
        ((Intent)localObject).putExtra("qquin", ScanLoginAccountListActivity.access$100(this.a));
        ((Intent)localObject).putExtra("scancode", ScanLoginAccountListActivity.access$200(this.a));
        ((Intent)localObject).putExtras(paramMessage.getData());
        this.a.startActivity((Intent)localObject);
      }
      for (;;)
      {
        this.a.finish();
        return;
        if ((i == 48) || (i == -1004))
        {
          this.a.showToast(2131231406);
          ScanLoginAccountListActivity.access$500(this.a);
        }
        else if (i == -1000)
        {
          this.a.showToast(2131230960);
        }
        else if (i == 8192)
        {
          this.a.showToast(2131231407);
        }
        else if ((paramMessage.getData() != null) && (paramMessage.getData().getByteArray("scanerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131231411) + ":" + new String(paramMessage.getData().getByteArray("scanerror")));
        }
        else
        {
          this.a.showToast(2131231409);
        }
      }
    case 4104: 
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131231411);
      return;
    }
    ScanLoginAccountListActivity.access$600(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yb
 * JD-Core Version:    0.7.0.1
 */