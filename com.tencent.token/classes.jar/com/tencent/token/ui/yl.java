package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class yl
  extends bo
{
  yl(ScanLoginAccountListActivity paramScanLoginAccountListActivity)
  {
    super(paramScanLoginAccountListActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    switch (paramMessage.what)
    {
    default: 
    case 1006: 
    case 1019: 
    case 4097: 
      byte[] arrayOfByte;
      Handler localHandler;
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
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361907, paramMessage.c, 2131361800, null);
        return;
        paramMessage = ScanLoginAccountListActivity.access$400(this.a);
        localObject = ScanLoginAccountListActivity.access$100(this.a);
        arrayOfByte = ScanLoginAccountListActivity.access$200(this.a);
        localHandler = ScanLoginAccountListActivity.access$300(this.a);
        s.j();
        paramMessage.b((String)localObject, arrayOfByte, localHandler);
        return;
        i = paramMessage.arg1;
        if (i != 2) {
          break;
        }
      } while (this.a.isFinishing());
      new WtloginCaptchaDialog(this.a, ScanLoginAccountListActivity.access$300(this.a), ScanLoginAccountListActivity.access$100(this.a)).show();
      return;
      if (i == 0)
      {
        e.b("getstwithoutpasswd:succ");
        paramMessage = ScanLoginAccountListActivity.access$400(this.a);
        localObject = ScanLoginAccountListActivity.access$100(this.a);
        arrayOfByte = ScanLoginAccountListActivity.access$200(this.a);
        localHandler = ScanLoginAccountListActivity.access$300(this.a);
        s.j();
        paramMessage.b((String)localObject, arrayOfByte, localHandler);
        return;
      }
      if (i == -1000) {
        this.a.showToast(2131361943);
      }
      for (;;)
      {
        this.a.dismissDialog();
        return;
        if (i == 8192)
        {
          this.a.showToast(2131362089);
        }
        else if ((i == 15) || (i == 1) || (i == 16))
        {
          this.a.showToast(2131362068);
          paramMessage = new Intent(this.a, WtLoginAccountInput.class);
          paramMessage.putExtra("qquin", ScanLoginAccountListActivity.access$100(this.a));
          paramMessage.putExtra("scancode", ScanLoginAccountListActivity.access$200(this.a));
          paramMessage.putExtra("wtlogin_appid", 523005419L);
          paramMessage.putExtra("page_id", 6);
          this.a.startActivity(paramMessage);
          this.a.finish();
        }
        else if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
        }
        else
        {
          this.a.showToast(2131362091);
        }
      }
    case 4101: 
      this.a.dismissDialog();
      i = paramMessage.arg1;
      e.b("verify code,ret=" + i);
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
        if (i == 48)
        {
          this.a.showToast(2131362068);
          paramMessage = new Intent(this.a, WtLoginAccountInput.class);
          paramMessage.putExtra("qquin", ScanLoginAccountListActivity.access$100(this.a));
          paramMessage.putExtra("scancode", ScanLoginAccountListActivity.access$200(this.a));
          paramMessage.putExtra("wtlogin_appid", 523005419L);
          paramMessage.putExtra("page_id", 6);
          this.a.startActivity(paramMessage);
          this.a.finish();
        }
        else if (i == -1000)
        {
          this.a.showToast(2131361943);
        }
        else if (i == 8192)
        {
          this.a.showToast(2131362089);
        }
        else if ((paramMessage.getData() != null) && (paramMessage.getData().getByteArray("scanerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + new String(paramMessage.getData().getByteArray("scanerror")));
        }
        else
        {
          this.a.showToast(2131362084);
        }
      }
    }
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.showToast(2131362091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yl
 * JD-Core Version:    0.7.0.1
 */