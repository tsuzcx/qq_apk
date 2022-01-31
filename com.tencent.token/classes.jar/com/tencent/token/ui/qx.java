package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.utils.t;

final class qx
  implements View.OnClickListener
{
  qx(NetActiveSetDirBySeqActivity paramNetActiveSetDirBySeqActivity) {}
  
  public final void onClick(View paramView)
  {
    t.a(this.a);
    NetActiveSetDirBySeqActivity.access$102(this.a, NetActiveSetDirBySeqActivity.access$200(this.a).getText().toString());
    if ((NetActiveSetDirBySeqActivity.access$100(this.a) != null) && (NetActiveSetDirBySeqActivity.access$100(this.a).length() != 0))
    {
      NetActiveSetDirBySeqActivity.access$302(this.a, new AlertDialog.Builder(this.a).setTitle(this.a.getResources().getString(2131362104)).setMessage(NetActiveSetDirBySeqActivity.access$100(this.a) + this.a.getResources().getString(2131361848)).setPositiveButton(this.a.getResources().getString(2131361853), new qz(this)).setNegativeButton(this.a.getResources().getString(2131361852), new qy(this)).create());
      NetActiveSetDirBySeqActivity.access$300(this.a).show();
      return;
    }
    this.a.showToast(2131361947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qx
 * JD-Core Version:    0.7.0.1
 */