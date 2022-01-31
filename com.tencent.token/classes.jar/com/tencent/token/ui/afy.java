package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.do;

class afy
  implements View.OnClickListener
{
  afy(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public void onClick(View paramView)
  {
    if ((do.a().d() >= 3) && (do.a().d(WtLoginAccountInput.access$700(this.a)) == null))
    {
      this.a.showUserDialog(2131230935, this.a.getResources().getString(2131230877), 2131230897, null);
      return;
    }
    ch.a().a(System.currentTimeMillis(), 87);
    paramView = new Intent(this.a, FindPasswdActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afy
 * JD-Core Version:    0.7.0.1
 */