package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class kv
  implements View.OnClickListener
{
  kv(ku paramku) {}
  
  public final void onClick(View paramView)
  {
    ku.d(this.a).findViewById(2131297271).setVisibility(8);
    ku.d(this.a).findViewById(2131297270).setVisibility(8);
    ku.d(this.a).setVisibility(8);
    this.a.a = false;
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kv
 * JD-Core Version:    0.7.0.1
 */