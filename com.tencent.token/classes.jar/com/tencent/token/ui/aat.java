package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class aat
  implements View.OnClickListener
{
  aat(aas paramaas) {}
  
  public final void onClick(View paramView)
  {
    if (SmsContentTipActivity.access$2100(this.a.a) == 10)
    {
      paramView = new Intent(this.a.a, IndexActivity.class);
      paramView.putExtra("index_from", 16);
      this.a.a.startActivity(paramView);
    }
    for (;;)
    {
      this.a.a.finish();
      return;
      paramView = new Intent(this.a.a, IndexActivity.class);
      this.a.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aat
 * JD-Core Version:    0.7.0.1
 */