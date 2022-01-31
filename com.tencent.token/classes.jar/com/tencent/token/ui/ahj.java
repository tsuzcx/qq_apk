package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.p;

final class ahj
  implements View.OnClickListener
{
  ahj(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public final void onClick(View paramView)
  {
    p.a().a(System.currentTimeMillis(), 87);
    paramView = new Intent(this.a, FindPasswdActivity.class);
    if ((WtLoginAccountInput.access$100(this.a) != null) && (WtLoginAccountInput.access$100(this.a).getText() != null) && (WtLoginAccountInput.access$100(this.a).getText().length() != 0)) {}
    try
    {
      WtLoginAccountInput.access$602(this.a, Long.parseLong(WtLoginAccountInput.access$100(this.a).getText().toString()));
      paramView.putExtra("real_uin", Long.parseLong(WtLoginAccountInput.access$100(this.a).getText().toString()));
      paramView.putExtra("canchange_uin", true);
      this.a.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      this.a.showUserDialog(this.a.getResources().getString(2131362636));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahj
 * JD-Core Version:    0.7.0.1
 */