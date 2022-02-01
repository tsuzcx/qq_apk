package com.huawei.updatesdk.service.f;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$1$1
  implements View.OnClickListener
{
  a$1$1(a.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a.a) != null) {
      a.a(this.a.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.f.a.1.1
 * JD-Core Version:    0.7.0.1
 */