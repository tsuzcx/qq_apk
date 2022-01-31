package com.tencent.token.ui;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.token.utils.w;

class oj
  extends ClickableSpan
{
  oj(LogoActivity paramLogoActivity) {}
  
  public void onClick(@NonNull View paramView)
  {
    w.a(this.a, "https://www.qq.com/privacy.htm");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16740609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.oj
 * JD-Core Version:    0.7.0.1
 */