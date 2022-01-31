package com.tencent.token.ui.qqpim;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

class p
  implements Runnable
{
  p(o paramo) {}
  
  public void run()
  {
    QQPimNewActivity.access$300(this.a.a).setText(this.a.a.getResources().getText(2131231303));
    Toast.makeText(this.a.a, this.a.a.getResources().getText(2131231307), 0).show();
    a.a(this.a.a, QQPimNewActivity.access$600(this.a.a));
    QQPimNewActivity.access$702(this.a.a, true);
    QQPimNewActivity.access$300(this.a.a).setVisibility(0);
    QQPimNewActivity.access$400(this.a.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.p
 * JD-Core Version:    0.7.0.1
 */