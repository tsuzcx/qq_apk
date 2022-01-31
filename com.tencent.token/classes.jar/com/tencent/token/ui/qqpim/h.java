package com.tencent.token.ui.qqpim;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

class h
  implements Runnable
{
  h(g paramg) {}
  
  public void run()
  {
    QQPimActivity.access$000(this.a.a).setText(this.a.a.getResources().getText(2131231303));
    Toast.makeText(this.a.a, this.a.a.getResources().getText(2131231307), 0).show();
    a.a(this.a.a, QQPimActivity.access$300(this.a.a));
    QQPimActivity.access$402(this.a.a, true);
    QQPimActivity.access$000(this.a.a).setVisibility(0);
    QQPimActivity.access$100(this.a.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.h
 * JD-Core Version:    0.7.0.1
 */