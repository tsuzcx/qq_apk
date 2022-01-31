package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;

class afx
  implements View.OnClickListener
{
  afx(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 87);
    paramView = new Intent(this.a, FindPasswdActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afx
 * JD-Core Version:    0.7.0.1
 */