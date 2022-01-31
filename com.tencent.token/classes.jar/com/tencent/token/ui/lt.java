package com.tencent.token.ui;

import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

final class lt
  implements TabHost.OnTabChangeListener
{
  lt(IndexActivity paramIndexActivity) {}
  
  public final void onTabChanged(String paramString)
  {
    int i = IndexActivity.access$1000(this.a).getCurrentTab();
    IndexActivity.access$2100(this.a, i);
    if (i == 2) {
      IndexActivity.access$600(this.a).setVisibility(4);
    }
    IndexActivity.access$2200(this.a);
    IndexActivity.access$2300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lt
 * JD-Core Version:    0.7.0.1
 */