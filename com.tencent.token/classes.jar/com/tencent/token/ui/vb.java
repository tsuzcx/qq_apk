package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.RqdApplication;

final class vb
  implements View.OnClickListener
{
  vb(ux paramux) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.addFlags(67108864);
    if (RealNameFindActivity.access$500(this.a.a) == 1) {
      paramView.putExtra("index_from", 25);
    }
    for (;;)
    {
      paramView.putExtra("ish5zzb", RealNameFindActivity.access$1900(this.a.a));
      RqdApplication.f();
      this.a.a.startActivity(paramView);
      this.a.a.finish();
      return;
      paramView.putExtra("index_from", 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vb
 * JD-Core Version:    0.7.0.1
 */