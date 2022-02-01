package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.view.FolderLockDialog;

class ReadVirtualAdsMailFragment$7$2
  implements Runnable
{
  ReadVirtualAdsMailFragment$7$2(ReadVirtualAdsMailFragment.7 param7) {}
  
  public void run()
  {
    ReadVirtualAdsMailFragment.access$700(this.this$1.this$0).cancelDialog();
    ReadVirtualAdsMailFragment.access$700(this.this$1.this$0).dismissTips();
    ReadVirtualAdsMailFragment.access$700(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.7.2
 * JD-Core Version:    0.7.0.1
 */