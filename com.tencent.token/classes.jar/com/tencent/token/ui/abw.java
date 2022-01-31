package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;

class abw
  implements View.OnClickListener
{
  abw(abv paramabv, QQUser paramQQUser) {}
  
  public void onClick(View paramView)
  {
    this.b.a.dismissDialog();
    if (this.a == null)
    {
      paramView = new Intent(this.b.a, WtLoginAccountInput.class);
      paramView.putExtra("page_id", 4);
      this.b.a.startActivity(paramView);
    }
    while (this.a.mIsBinded) {
      return;
    }
    this.b.a.gotoVerify(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abw
 * JD-Core Version:    0.7.0.1
 */