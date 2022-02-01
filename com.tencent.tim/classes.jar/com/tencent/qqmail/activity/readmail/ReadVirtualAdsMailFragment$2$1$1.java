package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;

class ReadVirtualAdsMailFragment$2$1$1
  implements DialogInterface.OnDismissListener
{
  ReadVirtualAdsMailFragment$2$1$1(ReadVirtualAdsMailFragment.2.1 param1, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$itemView.getTag().equals(this.this$2.this$1.this$0.getString(2131719238)))
    {
      DataCollector.logEvent("Event_AD_Mail_Share_WeChat_Friend");
      ReadVirtualAdsMailFragment.access$200(this.this$2.this$1.this$0, ReadVirtualAdsMailFragment.access$000(this.this$2.this$1.this$0), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getSubject(), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getAbstracts(), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getImageUrl(), 0);
    }
    do
    {
      return;
      if (this.val$itemView.getTag().equals(this.this$2.this$1.this$0.getString(2131719229)))
      {
        DataCollector.logEvent("Event_AD_Mail_Share_WeChat_TimeLine");
        ReadVirtualAdsMailFragment.access$200(this.this$2.this$1.this$0, ReadVirtualAdsMailFragment.access$000(this.this$2.this$1.this$0), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getSubject(), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getAbstracts(), ReadVirtualAdsMailFragment.access$100(this.this$2.this$1.this$0).getImageUrl(), 1);
        return;
      }
    } while (!this.val$itemView.getTag().equals(this.this$2.this$1.this$0.getString(2131719233)));
    DataCollector.logEvent("Event_AD_Mail_Share_QQ_Friend");
    ReadVirtualAdsMailFragment.access$300(this.this$2.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */