package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.view.ContactEditComposeEmailView;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.List;
import moai.oss.KvHelper;

class ComposeEditEmailActivity$2
  implements View.OnClickListener
{
  ComposeEditEmailActivity$2(ComposeEditEmailActivity paramComposeEditEmailActivity) {}
  
  public void onClick(View paramView)
  {
    if (ComposeEditEmailActivity.access$000(this.this$0).size() > 1)
    {
      ComposeEditEmailActivity.access$102(this.this$0, (String)ComposeEditEmailActivity.access$000(this.this$0).get(0));
      ComposeEditEmailActivity.access$202(this.this$0, (String)ComposeEditEmailActivity.access$000(this.this$0).get(1));
    }
    ComposeEditEmailActivity.access$302(this.this$0, ComposeEditEmailActivity.access$500(this.this$0, ComposeEditEmailActivity.access$400(this.this$0).getNodeInputText()));
    if (ComposeEditEmailActivity.access$300(this.this$0).size() > 1)
    {
      ComposeEditEmailActivity.access$602(this.this$0, (String)ComposeEditEmailActivity.access$300(this.this$0).get(0));
      ComposeEditEmailActivity.access$702(this.this$0, (String)ComposeEditEmailActivity.access$300(this.this$0).get(1));
      KvHelper.eventComposeReceiverEditNickType(new double[0]);
    }
    if (StringExtention.isNullOrEmpty(ComposeEditEmailActivity.access$700(this.this$0)))
    {
      ComposeEditEmailActivity.access$702(this.this$0, ComposeEditEmailActivity.access$400(this.this$0).getNodeInputText());
      ComposeEditEmailActivity.access$602(this.this$0, "");
      ComposeEditEmailActivity.access$102(this.this$0, "");
    }
    QMContactManager.sharedInstance().postEditEmailNotification(ComposeEditEmailActivity.access$200(this.this$0), ComposeEditEmailActivity.access$700(this.this$0), ComposeEditEmailActivity.access$100(this.this$0), ComposeEditEmailActivity.access$600(this.this$0), ComposeEditEmailActivity.access$600(this.this$0), 0L);
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_email", ComposeEditEmailActivity.access$200(this.this$0));
    this.this$0.setResult(-1, localIntent);
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeEditEmailActivity.2
 * JD-Core Version:    0.7.0.1
 */