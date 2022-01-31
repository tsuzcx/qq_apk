package com.tencent.token.ui.base;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import com.tencent.token.utils.x;

class z
  implements View.OnClickListener
{
  z(y paramy, QQUser paramQQUser) {}
  
  public void onClick(View paramView)
  {
    x.b(this.a.mRealUin);
    y.a(this.b).dismiss();
    y.b(this.b).refreshList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.z
 * JD-Core Version:    0.7.0.1
 */