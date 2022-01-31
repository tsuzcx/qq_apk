package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class ye
  implements DialogInterface.OnClickListener
{
  ye(yd paramyd, QQUser paramQQUser) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      cp.a(RqdApplication.l()).a(this.a.mRealUin + "", 523005419L);
      cw.a().h(this.a.mRealUin, ScanLoginAccountListActivity.access$300(this.b.a));
      do.a().b(this.a);
      do.a().n();
      du.a().f.a(w.f(this.a.mUin));
      ds.a().f.a(w.f(this.a.mUin));
      du.a().f.a(w.f(this.a.mRealUin));
      ds.a().f.a(w.f(this.a.mRealUin));
      ScanLoginAccountListActivity.access$700(this.b.a).notifyDataSetChanged();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        h.c("clearUserLoginDataSync exception: " + paramDialogInterface.getMessage());
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ye
 * JD-Core Version:    0.7.0.1
 */