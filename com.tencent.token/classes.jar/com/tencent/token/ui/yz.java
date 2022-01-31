package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.token.ax;
import com.tencent.token.az;
import com.tencent.token.core.gamelogin.GameLoginService;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.r;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class yz
  extends bo
{
  yz(ScanLoginConfirmLoginActivity paramScanLoginConfirmLoginActivity)
  {
    super(paramScanLoginConfirmLoginActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4102: 
      this.a.dismissDialog();
      i = paramMessage.arg1;
      if (i == 0)
      {
        paramMessage = ax.a().c(ScanLoginConfirmLoginActivity.access$000(this.a));
        Object localObject = r.a(RqdApplication.i());
        if (((r)localObject).a())
        {
          ((r)localObject).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$100(this.a).c(), ScanLoginConfirmLoginActivity.access$100(this.a).d());
          if (!s.f())
          {
            localObject = new Intent(this.a, GameLoginService.class);
            this.a.startService((Intent)localObject);
          }
          if (paramMessage.e == 1)
          {
            paramMessage = new Intent(this.a, ScanLoginSuccActivity.class);
            this.a.startActivity(paramMessage);
          }
        }
      }
      for (;;)
      {
        e.b("on closecode:" + i);
        this.a.finish();
        return;
        paramMessage = new Intent(this.a, ScanLoginBindActivity.class);
        paramMessage.putExtra("qquin", ScanLoginConfirmLoginActivity.access$000(this.a));
        this.a.startActivity(paramMessage);
        continue;
        s.h();
        if (paramMessage.e == 1)
        {
          if ((paramMessage.c) || (paramMessage.d)) {
            Toast.makeText(RqdApplication.i(), 2131362085, 0).show();
          } else {
            Toast.makeText(RqdApplication.i(), 2131362071, 0).show();
          }
        }
        else
        {
          paramMessage = new Intent(this.a, ScanLoginBindActivity.class);
          paramMessage.putExtra("qquin", ScanLoginConfirmLoginActivity.access$000(this.a));
          this.a.startActivity(paramMessage);
          continue;
          if (i == -1000) {
            Toast.makeText(RqdApplication.i(), 2131361943, 0).show();
          } else if (i == 8192) {
            Toast.makeText(RqdApplication.i(), 2131362089, 0).show();
          } else if ((paramMessage.getData() != null) && (paramMessage.getData().getByteArray("scanerror") != null)) {
            Toast.makeText(RqdApplication.i(), "登录失败:" + new String(paramMessage.getData().getByteArray("scanerror")), 0).show();
          } else {
            Toast.makeText(RqdApplication.i(), 2131362084, 0).show();
          }
        }
      }
    case 4103: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = ax.a().c(ScanLoginConfirmLoginActivity.access$000(this.a));
        if (paramMessage != null)
        {
          if ((paramMessage.d) || (paramMessage.c))
          {
            paramMessage = paramMessage.b.getBytes();
            ScanLoginConfirmLoginActivity.access$100(this.a).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$200(this.a), paramMessage, s.j(), ScanLoginConfirmLoginActivity.access$300(this.a));
            return;
          }
          ScanLoginConfirmLoginActivity.access$100(this.a).a(ScanLoginConfirmLoginActivity.access$000(this.a), ScanLoginConfirmLoginActivity.access$200(this.a), null, s.j(), ScanLoginConfirmLoginActivity.access$300(this.a));
          return;
        }
        Toast.makeText(RqdApplication.i(), 2131362087, 0).show();
      }
      for (;;)
      {
        this.a.dismissDialog();
        this.a.finish();
        return;
        switch (paramMessage.arg1)
        {
        default: 
          i = 0;
        }
        if (i != 0) {
          Toast.makeText(RqdApplication.i(), 2131361943, 0).show();
        } else {
          Toast.makeText(RqdApplication.i(), 2131362083, 0).show();
        }
      }
    }
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      Toast.makeText(RqdApplication.i(), "登录失败:" + paramMessage.getData().getString("exception"), 0).show();
      return;
    }
    Toast.makeText(RqdApplication.i(), "登录失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yz
 * JD-Core Version:    0.7.0.1
 */