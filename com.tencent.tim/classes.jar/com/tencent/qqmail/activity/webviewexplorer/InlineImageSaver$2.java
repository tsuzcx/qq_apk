package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.download.ImageDownloadManager;
import java.io.File;
import org.apache.commons.lang3.StringEscapeUtils;

class InlineImageSaver$2
  implements Runnable
{
  InlineImageSaver$2(InlineImageSaver paramInlineImageSaver, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = ImageDownloadManager.shareInstance().getThumbBitmapFromDiskCache(StringEscapeUtils.unescapeHtml4(this.val$url));
    if ((localFile != null) && (localFile.exists())) {
      InlineImageSaver.access$1000(this.this$0, this.val$name, localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver.2
 * JD-Core Version:    0.7.0.1
 */