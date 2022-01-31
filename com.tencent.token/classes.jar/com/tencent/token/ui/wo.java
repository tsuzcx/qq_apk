package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.RqdApplication;

final class wo
  implements View.OnClickListener
{
  wo(wn paramwn) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.addFlags(67108864);
    if (this.a.a.mSourceId == 1)
    {
      paramView.putExtra("index_from", 25);
      RqdApplication.f();
    }
    for (;;)
    {
      paramView.putExtra("ish5zzb", RealNameStep0VerifyMobileDownActivity.access$700(this.a.a));
      this.a.a.startActivity(paramView);
      this.a.a.finish();
      return;
      paramView.putExtra("index_from", 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wo
 * JD-Core Version:    0.7.0.1
 */