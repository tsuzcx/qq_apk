package com.tencent.token.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.token.utils.s;

final class rr
  extends ClickableSpan
{
  rr(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity) {}
  
  public final void onClick(View paramView)
  {
    s.a(this.a, this.a.getString(2131362126), this.a.getString(2131362125));
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rr
 * JD-Core Version:    0.7.0.1
 */