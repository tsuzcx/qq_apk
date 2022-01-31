package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

final class aak
  extends Handler
{
  aak(SmsActitivity paramSmsActitivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.iv_icon = ((ImageView)this.a.findViewById(2131296503));
      this.a.iv_icon.setImageResource(2130837591);
      sendEmptyMessageDelayed(1, 1000L);
      return;
    case 1: 
      this.a.viewTitle = this.a.findViewById(2131296502);
      this.a.view = this.a.findViewById(2131296507);
      this.a.view.setVisibility(0);
      this.a.openAnimation = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 0.0F, 1, 0.0F);
      this.a.openAnimation.setDuration(300L);
      this.a.view.startAnimation(this.a.openAnimation);
      this.a.btnVerfiy = ((Button)this.a.findViewById(2131296510));
      this.a.btnVerfiy.setOnClickListener(this.a.onClick);
      this.a.btnCancel = ((Button)this.a.findViewById(2131296511));
      this.a.btnCancel.setOnClickListener(this.a.onClick);
      this.a.ivMid = ((ImageView)this.a.findViewById(2131296505));
      this.a.ivMid.setBackgroundColor(this.a.getResources().getColor(2131165263));
      this.a.ivDismiss = ((ImageView)this.a.findViewById(2131296506));
      return;
    case 2: 
      this.a.viewTitle.setVisibility(4);
      this.a.view.setVisibility(4);
      this.a.ivMid.setVisibility(4);
      this.a.ivDismiss.setVisibility(0);
      sendEmptyMessageDelayed(3, 800L);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aak
 * JD-Core Version:    0.7.0.1
 */