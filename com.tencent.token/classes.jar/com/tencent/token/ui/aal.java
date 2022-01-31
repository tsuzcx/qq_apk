package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;

final class aal
  implements View.OnClickListener
{
  aal(SmsActitivity paramSmsActitivity) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == 2131296510)
    {
      this.a.closeAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.a.closeAnimation.setDuration(300L);
      this.a.viewRoot.startAnimation(this.a.closeAnimation);
      this.a.mHandler.sendEmptyMessageDelayed(2, 300L);
      paramView = new Intent("com.tencent.token.action.dualsms");
      paramView.putExtra("flag", 2);
      this.a.sendBroadcast(paramView);
    }
    while (paramView.getId() != 2131296511) {
      return;
    }
    this.a.viewRoot.setVisibility(4);
    paramView = new Intent("com.tencent.token.action.dualsms");
    paramView.putExtra("flag", 3);
    this.a.sendBroadcast(paramView);
    SmsActitivity.access$002(this.a, new AlertDialog.Builder(this.a).setTitle(this.a.getResources().getString(2131362104)).setMessage(this.a.getResources().getString(2131362105)).setPositiveButton(this.a.getResources().getString(2131362106), new aan(this)).setNegativeButton(this.a.getResources().getString(2131362107), new aam(this)).create());
    SmsActitivity.access$000(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aal
 * JD-Core Version:    0.7.0.1
 */