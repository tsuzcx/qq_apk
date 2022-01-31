package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class fe
  implements View.OnClickListener
{
  fe(es parames) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.addFlags(67108864);
    paramView.putExtra("ish5zzb", this.a.a.ish5zzb);
    this.a.a.startActivity(paramView);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fe
 * JD-Core Version:    0.7.0.1
 */