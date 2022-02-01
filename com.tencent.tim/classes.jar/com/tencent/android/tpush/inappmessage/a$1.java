package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    this.a.cancel();
    this.a.b.finish();
    this.a.b.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.a.1
 * JD-Core Version:    0.7.0.1
 */