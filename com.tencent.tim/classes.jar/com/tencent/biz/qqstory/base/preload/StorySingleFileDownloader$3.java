package com.tencent.biz.qqstory.base.preload;

import java.util.Map;
import png;
import pno;

public class StorySingleFileDownloader$3
  implements Runnable
{
  public StorySingleFileDownloader$3(pno parampno, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = png.makeKey(this.val$vid, this.val$fileType);
    localObject = (png)pno.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((png)localObject).fD.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */