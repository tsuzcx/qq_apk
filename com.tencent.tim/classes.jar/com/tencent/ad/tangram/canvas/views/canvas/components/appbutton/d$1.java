package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public void onClick(View paramView)
  {
    this.this$0.doClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d.1
 * JD-Core Version:    0.7.0.1
 */