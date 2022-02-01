package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;

class AttachImagePagerActivity$1
  implements Runnable
{
  AttachImagePagerActivity$1(AttachImagePagerActivity paramAttachImagePagerActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new File(this.val$filePath);
    String str = FileUtil.rename(((File)localObject).getParent().replaceFirst("/*$", "/"), ((File)localObject).getName());
    localObject = ((File)localObject).getParent() + "/" + str;
    int i = FileUtil.copySdcardFile(this.val$sourcePath, (String)localObject);
    AttachImagePagerActivity.access$000(this.this$0, new AttachImagePagerActivity.1.1(this, i, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.1
 * JD-Core Version:    0.7.0.1
 */