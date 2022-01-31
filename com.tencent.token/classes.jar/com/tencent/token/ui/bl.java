package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class bl
  implements View.OnClickListener
{
  bl(BaseActivity paramBaseActivity1, int paramInt, BaseActivity paramBaseActivity2) {}
  
  public void onClick(View paramView)
  {
    this.c.dismissDialog();
    if (this.a == 1)
    {
      this.c.gotoVerify(BaseActivity.access$100(this.c));
      return;
    }
    paramView = new Intent(this.b, WtLoginAccountInput.class);
    paramView.putExtra("page_id", 4);
    this.c.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bl
 * JD-Core Version:    0.7.0.1
 */