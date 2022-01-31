package com.tencent.token.ui.base;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;

final class dr
  implements View.OnClickListener
{
  dr(dk paramdk) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(dk.a(this.a), IndexActivity.class);
    paramView.putExtra("index_from", 16);
    dk.a(this.a).startActivity(paramView);
    dk.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dr
 * JD-Core Version:    0.7.0.1
 */