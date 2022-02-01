package com.tencent.qqmail.attachment.view;

import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class AttachFolderThumbListener$1
  implements CompressImageWatcher
{
  AttachFolderThumbListener$1(AttachFolderThumbListener paramAttachFolderThumbListener, File paramFile) {}
  
  public void onError(String paramString1, String paramString2) {}
  
  public void onSuccess(String paramString1, String paramString2)
  {
    if ((AttachFolderThumbListener.access$000(this.this$0) != null) && (AttachFolderThumbListener.access$100(this.this$0) != null) && (AttachFolderThumbListener.access$100(this.this$0).needRefreshImage(AttachFolderThumbListener.access$200(this.this$0), AttachFolderThumbListener.access$300(this.this$0)))) {
      Threads.runOnMainThread(new AttachFolderThumbListener.1.1(this, ImageUtil.memSafeScaleImage(this.val$image.getAbsolutePath(), 1, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin.ordinal())));
    }
  }
  
  public void onWait(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.AttachFolderThumbListener.1
 * JD-Core Version:    0.7.0.1
 */