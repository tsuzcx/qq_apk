package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.RqdApplication;

final class wa
  implements View.OnClickListener
{
  wa(vu paramvu) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.addFlags(67108864);
    if (RealNameSmsContentTipActivity.access$400(this.a.a) == 1) {
      paramView.putExtra("index_from", 25);
    }
    for (;;)
    {
      RqdApplication.f();
      this.a.a.startActivity(paramView);
      this.a.a.finish();
      return;
      paramView.putExtra("index_from", 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wa
 * JD-Core Version:    0.7.0.1
 */