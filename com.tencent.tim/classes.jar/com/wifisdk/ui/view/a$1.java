package com.wifisdk.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    a.c(this.uU).M(a.b(this.uU));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.wifisdk.ui.view.a.1
 * JD-Core Version:    0.7.0.1
 */