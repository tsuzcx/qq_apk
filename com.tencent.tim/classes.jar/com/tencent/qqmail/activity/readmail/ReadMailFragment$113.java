package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.EditTextInWebView;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$113
  implements View.OnClickListener
{
  ReadMailFragment$113(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadMailFragment.access$17300(this.this$0) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = StringExtention.textToHtml(ReadMailFragment.access$17300(this.this$0).getText().toString().trim());
    if (ReadMailFragment.access$000(this.this$0).canReplyAll()) {}
    for (ComposeMailUI.QMComposeMailType localQMComposeMailType = ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL;; localQMComposeMailType = ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY)
    {
      ReadMailFragment.access$12600(this.this$0, localQMComposeMailType, str);
      ReadMailFragment.access$17600(this.this$0);
      ReadMailFragment.access$2400(this.this$0).getAttachBubbleView().setVisibility(8);
      ReadMailFragment.access$17300(this.this$0).setText("");
      ReadMailFragment.access$17700(this.this$0, ReadMailFragment.access$000(this.this$0).getInformation().getId());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.113
 * JD-Core Version:    0.7.0.1
 */