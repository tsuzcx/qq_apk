package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.token.cj;
import com.tencent.token.core.gamelogin.GameLoginService;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.dq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class yo
  extends cb
{
  yo(ScanLoginConfirmLoginActivity paramScanLoginConfirmLoginActivity)
  {
    super(paramScanLoginConfirmLoginActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      int i;
      try
      {
        switch (paramMessage.what)
        {
        case 4102: 
          this.a.dismissDialog();
          i = paramMessage.arg1;
          if (i == 0) {
            paramMessage = do.a().b(ScanLoginConfirmLoginActivity.access$000(this.a));
          }
          break;
        }
      }
      catch (Exception paramMessage)
      {
        Object localObject;
        paramMessage.printStackTrace();
        return;
      }
      try
      {
        localObject = cj.a(RqdApplication.l());
        if (!((cj)localObject).a()) {
          break label241;
        }
        ((cj)localObject).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$100(this.a).b(), ScanLoginConfirmLoginActivity.access$100(this.a).c());
        if (!w.h())
        {
          localObject = new Intent(this.a, GameLoginService.class);
          this.a.startService((Intent)localObject);
        }
        if (paramMessage.e != 1) {
          break label202;
        }
        paramMessage = new Intent(this.a, ScanLoginSuccActivity.class);
        this.a.startActivity(paramMessage);
      }
      catch (Exception paramMessage)
      {
        continue;
      }
      catch (Error paramMessage)
      {
        continue;
      }
      h.b("on closecode:" + i);
      this.a.finish();
      return;
      label202:
      paramMessage = new Intent(this.a, ScanLoginBindActivity.class);
      paramMessage.putExtra("qquin", ScanLoginConfirmLoginActivity.access$000(this.a));
      this.a.startActivity(paramMessage);
      continue;
      label241:
      w.j();
      if (paramMessage.e == 1)
      {
        if ((paramMessage.c) || (paramMessage.d)) {
          Toast.makeText(RqdApplication.l(), 2131231421, 0).show();
        } else {
          Toast.makeText(RqdApplication.l(), 2131231419, 0).show();
        }
      }
      else
      {
        paramMessage = new Intent(this.a, ScanLoginBindActivity.class);
        paramMessage.putExtra("qquin", ScanLoginConfirmLoginActivity.access$000(this.a));
        this.a.startActivity(paramMessage);
        continue;
        if (i == -1000) {
          Toast.makeText(RqdApplication.l(), 2131230960, 0).show();
        } else if (i == 8192) {
          Toast.makeText(RqdApplication.l(), 2131231407, 0).show();
        } else if ((paramMessage.getData() != null) && (paramMessage.getData().getByteArray("scanerror") != null)) {
          Toast.makeText(RqdApplication.l(), "登录失败:" + new String(paramMessage.getData().getByteArray("scanerror")), 0).show();
        } else {
          Toast.makeText(RqdApplication.l(), 2131231409, 0).show();
        }
      }
    }
    if (paramMessage.arg1 == 0)
    {
      paramMessage = do.a().b(ScanLoginConfirmLoginActivity.access$000(this.a));
      if (paramMessage != null)
      {
        if ((paramMessage.d) || (paramMessage.c))
        {
          paramMessage = paramMessage.b.getBytes();
          ScanLoginConfirmLoginActivity.access$100(this.a).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$200(this.a), paramMessage, w.l(), ScanLoginConfirmLoginActivity.access$300(this.a), 523005419L);
          return;
        }
        ScanLoginConfirmLoginActivity.access$100(this.a).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$200(this.a), null, w.l(), ScanLoginConfirmLoginActivity.access$300(this.a), 523005419L);
        return;
      }
      Toast.makeText(RqdApplication.l(), 2131231408, 0).show();
    }
    for (;;)
    {
      this.a.dismissDialog();
      this.a.finish();
      return;
      if (f.a(paramMessage.arg1)) {
        Toast.makeText(RqdApplication.l(), 2131230960, 0).show();
      } else {
        Toast.makeText(RqdApplication.l(), 2131231404, 0).show();
      }
    }
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      Toast.makeText(RqdApplication.l(), "登录失败:" + paramMessage.getData().getString("exception"), 0).show();
      return;
    }
    Toast.makeText(RqdApplication.l(), "登录失败", 0).show();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yo
 * JD-Core Version:    0.7.0.1
 */