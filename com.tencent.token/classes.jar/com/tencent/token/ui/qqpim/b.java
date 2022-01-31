package com.tencent.token.ui.qqpim;

import android.view.View;
import android.view.View.OnClickListener;

class b
  implements View.OnClickListener
{
  b(QQPim4GNotifyDialog paramQQPim4GNotifyDialog) {}
  
  public void onClick(View paramView)
  {
    if (QQPim4GNotifyDialog.a(this.a) != null) {
      QQPim4GNotifyDialog.a(this.a).a();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.b
 * JD-Core Version:    0.7.0.1
 */