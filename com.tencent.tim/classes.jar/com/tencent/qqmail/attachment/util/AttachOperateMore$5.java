package com.tencent.qqmail.attachment.util;

import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;

class AttachOperateMore$5
  implements Runnable
{
  AttachOperateMore$5(AttachOperateMore paramAttachOperateMore, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(this.val$destPath);
    String str = FileUtil.rename(localFile.getParent().replaceFirst("/*$", "/"), localFile.getName());
    long l = AttachOperateMore.access$400(this.this$0).getAttach().getHashId();
    AttachOperateMore.access$500(this.this$0, l, this.val$sourcePath, localFile.getParent() + "/", str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.5
 * JD-Core Version:    0.7.0.1
 */