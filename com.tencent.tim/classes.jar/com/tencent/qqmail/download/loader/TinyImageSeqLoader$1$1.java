package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;

class TinyImageSeqLoader$1$1
  implements Runnable
{
  TinyImageSeqLoader$1$1(TinyImageSeqLoader.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = this.val$copyPath;
    if (FileUtil.isFileExist(this.val$copyPath)) {
      str = new File(this.val$copyPath).getParent();
    }
    this.this$1.this$0.handleDownSuccess(this.val$url, this.this$1.val$attachId, str);
    DataCollector.logDetailEvent("DetailEvent_App_Download", this.this$1.val$accountId, 0L, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.1.1
 * JD-Core Version:    0.7.0.1
 */