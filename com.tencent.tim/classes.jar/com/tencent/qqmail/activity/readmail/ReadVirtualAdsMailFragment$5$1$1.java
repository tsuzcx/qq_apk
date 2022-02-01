package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.protocol.DataCollector;

class ReadVirtualAdsMailFragment$5$1$1
  implements DialogInterface.OnDismissListener
{
  ReadVirtualAdsMailFragment$5$1$1(ReadVirtualAdsMailFragment.5.1 param1, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$2.this$1.this$0.getString(2131695199)))
    {
      DataCollector.logEvent("Event_AD_Mail_Save_Note");
      ReadVirtualAdsMailFragment.access$500(this.this$2.this$1.this$0);
    }
    while (!this.val$tag.equals(this.this$2.this$1.this$0.getString(2131695618))) {
      return;
    }
    DataCollector.logEvent("Event_AD_Mail_Reject");
    ReadVirtualAdsMailFragment.access$600(this.this$2.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.5.1.1
 * JD-Core Version:    0.7.0.1
 */