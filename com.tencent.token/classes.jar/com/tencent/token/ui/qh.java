package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.utils.x;

class qh
  implements View.OnClickListener
{
  qh(NetActiveSetDirBySeqActivity paramNetActiveSetDirBySeqActivity) {}
  
  public void onClick(View paramView)
  {
    x.a(this.a);
    if (NetActiveSetDirBySeqActivity.access$100(this.a) != null) {
      NetActiveSetDirBySeqActivity.access$100(this.a).clearFocus();
    }
    NetActiveSetDirBySeqActivity.access$202(this.a, NetActiveSetDirBySeqActivity.access$100(this.a).getText().toString());
    if ((NetActiveSetDirBySeqActivity.access$200(this.a) != null) && (NetActiveSetDirBySeqActivity.access$200(this.a).length() != 0))
    {
      this.a.showUserDialog(2131230935, NetActiveSetDirBySeqActivity.access$200(this.a) + this.a.getResources().getString(2131230865), 2131230863, 2131230862, new qi(this), new qj(this));
      return;
    }
    this.a.showToast(2131230957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qh
 * JD-Core Version:    0.7.0.1
 */