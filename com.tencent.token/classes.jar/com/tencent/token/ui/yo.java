package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class yo
  implements DialogInterface.OnClickListener
{
  yo(yn paramyn, QQUser paramQQUser) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      x.a(RqdApplication.i()).a(this.a.mRealUin + "", 523005419L);
      x.a(RqdApplication.i()).a(this.a.mRealUin + "", 523005425L);
      af.a().h(this.a.mRealUin, ScanLoginAccountListActivity.access$300(this.b.a));
      ax.a().b(this.a);
      ax.a().n();
      bd.a().f.a(s.f(this.a.mUin));
      bb.a().f.a(s.f(this.a.mUin));
      bd.a().f.a(s.f(this.a.mRealUin));
      bb.a().f.a(s.f(this.a.mRealUin));
      ScanLoginAccountListActivity.access$500(this.b.a).notifyDataSetChanged();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        e.c("clearUserLoginDataSync exception: " + paramDialogInterface.getMessage());
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yo
 * JD-Core Version:    0.7.0.1
 */