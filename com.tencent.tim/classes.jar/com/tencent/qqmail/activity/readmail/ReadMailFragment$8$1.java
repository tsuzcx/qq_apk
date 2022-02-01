package com.tencent.qqmail.activity.readmail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.paintpad.MailPaintPadActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$8$1
  implements View.OnClickListener
{
  ReadMailFragment$8$1(ReadMailFragment.8 param8) {}
  
  public void onClick(View paramView)
  {
    ReadMailFragment.access$2400(this.this$1.this$0).hideBubbleViewAndShowNext();
    DataCollector.logEvent("Event_Screenshot_Bubble_Disappear_Touch");
    ReadMailFragment.access$000(this.this$1.this$0).getInformation().setAccountId(ReadMailFragment.access$200(this.this$1.this$0));
    MailPaintPadActivity.extra_maildata = ReadMailFragment.access$000(this.this$1.this$0);
    int i = ReadMailFragment.access$2400(this.this$1.this$0).getMailType();
    if ((ReadMailFragment.access$2300(this.this$1.this$0) != null) && (ReadMailFragment.access$2300(this.this$1.this$0).getResourceLoader() != null) && (ReadMailFragment.access$2300(this.this$1.this$0).getResourceLoader().isAllImageCached())) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = Uri.parse(this.this$1.val$path);
      localObject = MailPaintPadActivity.createIntentForScreenShot(this.this$1.this$0.getActivity(), (Uri)localObject, ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$200(this.this$1.this$0), bool, ReadMailFragment.access$2500(this.this$1.this$0), i);
      this.this$1.this$0.startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.8.1
 * JD-Core Version:    0.7.0.1
 */