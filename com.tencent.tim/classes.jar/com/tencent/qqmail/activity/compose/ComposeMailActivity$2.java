package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.util.QMAttachUtils;
import java.util.List;

class ComposeMailActivity$2
  implements Runnable
{
  ComposeMailActivity$2(ComposeMailActivity paramComposeMailActivity, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (this.val$selectedInfo != null)
    {
      if ((this.val$selectedInfo.size() > 0) && (!this.this$0.hasAttachCache)) {
        this.this$0.hasAttachCache = true;
      }
      QMAttachUtils.handleAddAttach(this.val$allAlbumAttach, this.this$0.composeMail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.2
 * JD-Core Version:    0.7.0.1
 */