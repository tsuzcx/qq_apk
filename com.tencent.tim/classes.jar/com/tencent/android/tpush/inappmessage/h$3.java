package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class h$3
  implements View.OnClickListener
{
  h$3(h paramh) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.d.o();
    this.a.f.putExtra("inapp_custom_event_id", "INNER_MESSAGE");
    this.a.f.putExtra("inapp_button_event_id", this.a.d.p());
    ServiceStat.appReportNotificationClicked(b.e(), this.a.f);
    switch (this.a.d.c())
    {
    }
    for (;;)
    {
      this.a.cancel();
      this.a.b.finish();
      this.a.b.overridePendingTransition(0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.cancel();
      continue;
      h.a(this.a, str);
      continue;
      h.b(this.a, str);
      continue;
      h.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.h.3
 * JD-Core Version:    0.7.0.1
 */