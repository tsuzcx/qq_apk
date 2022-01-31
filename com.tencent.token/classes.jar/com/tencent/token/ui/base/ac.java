package com.tencent.token.ui.base;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import com.tencent.token.utils.t;

final class ac
  implements View.OnClickListener
{
  ac(ab paramab, QQUser paramQQUser) {}
  
  public final void onClick(View paramView)
  {
    t.b(this.a.mRealUin);
    ab.a(this.b).dismiss();
    ab.b(this.b).refreshList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ac
 * JD-Core Version:    0.7.0.1
 */