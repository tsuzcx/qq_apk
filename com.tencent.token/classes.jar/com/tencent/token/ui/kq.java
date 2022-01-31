package com.tencent.token.ui;

import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.dk;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.UserTask;

class kq
  extends UserTask
{
  kq(GetBarcodeVerifyMsgActivity paramGetBarcodeVerifyMsgActivity) {}
  
  public f a(String... paramVarArgs)
  {
    paramVarArgs = new f();
    if (!do.a().o())
    {
      f localf = do.a().q();
      paramVarArgs = localf;
      if (!localf.b()) {
        return localf;
      }
    }
    h.c("barcode user: " + do.a().d());
    if (do.a().d() > 0) {
      return dk.a().a(GetBarcodeVerifyMsgActivity.access$000(this.a));
    }
    paramVarArgs.b(110);
    return paramVarArgs;
  }
  
  public void a()
  {
    super.a();
    GetBarcodeVerifyMsgActivity.access$102(this.a, false);
  }
  
  public void a(f paramf)
  {
    GetBarcodeVerifyMsgActivity.access$102(this.a, false);
    if (this.a.isFinishing()) {
      return;
    }
    GetBarcodeVerifyMsgActivity.access$200(this.a).setText("");
    GetBarcodeVerifyMsgActivity.access$300(this.a).setVisibility(4);
    if (paramf.b())
    {
      if (dk.a().b() > 0)
      {
        GetBarcodeVerifyMsgActivity.access$400(this.a);
        GetBarcodeVerifyMsgActivity.access$502(this.a, new DualMsgShowDialog(this.a, 2131362156, 1));
        GetBarcodeVerifyMsgActivity.access$500(this.a).show();
        GetBarcodeVerifyMsgActivity.access$500(this.a).setOnDismissListener(GetBarcodeVerifyMsgActivity.access$600(this.a));
        return;
      }
      GetBarcodeVerifyMsgActivity.access$700(this.a);
      return;
    }
    if (10023 == paramf.a)
    {
      GetBarcodeVerifyMsgActivity.access$700(this.a);
      return;
    }
    if ((110 == paramf.a) || (111 == paramf.a))
    {
      this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231395), 2131230886, 2131230777, new kr(this), new ks(this), new kt(this));
      return;
    }
    if (10029 == paramf.a)
    {
      this.a.showUserDialog(2131230843, this.a.getString(2131231617), 2131231658, 2131230886, new ku(this), new kv(this));
      return;
    }
    f.a(this.a.getResources(), paramf);
    this.a.showUserDialog(2131230843, paramf.c, 2131230897, new kw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kq
 * JD-Core Version:    0.7.0.1
 */