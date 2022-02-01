package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class ReadVirtualAdsMailFragment$7
  implements QMUnlockFolderPwdWatcher
{
  ReadVirtualAdsMailFragment$7(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    ReadVirtualAdsMailFragment.access$1000(this.this$0, new ReadVirtualAdsMailFragment.7.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    ReadVirtualAdsMailFragment.access$900(this.this$0, new ReadVirtualAdsMailFragment.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.7
 * JD-Core Version:    0.7.0.1
 */