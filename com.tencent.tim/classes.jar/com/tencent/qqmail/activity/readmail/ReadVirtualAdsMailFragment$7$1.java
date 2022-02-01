package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.view.FolderLockDialog;

class ReadVirtualAdsMailFragment$7$1
  implements Runnable
{
  ReadVirtualAdsMailFragment$7$1(ReadVirtualAdsMailFragment.7 param7) {}
  
  public void run()
  {
    ReadVirtualAdsMailFragment.access$700(this.this$1.this$0).cancelDialog();
    ReadVirtualAdsMailFragment.access$700(this.this$1.this$0).dismissTips();
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131718967), 0).show();
    new NoteSender(0L, "1", "未分类", "folder").buildDataWithPredefinedHtmlAndTitle(ReadVirtualAdsMailFragment.access$800(this.this$1.this$0), ReadVirtualAdsMailFragment.access$100(this.this$1.this$0).getSubject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.7.1
 * JD-Core Version:    0.7.0.1
 */