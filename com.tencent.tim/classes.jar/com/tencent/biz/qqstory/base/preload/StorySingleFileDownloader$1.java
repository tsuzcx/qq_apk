package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import pnb;
import png;
import pno;
import pno.a;
import ram;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(pno parampno) {}
  
  public void run()
  {
    Iterator localIterator = pno.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      png localpng = (png)localIterator.next();
      pno.a(this.this$0).a(localpng);
      Object localObject = localpng.fD.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof pno.a)))
      {
        pno.a(this.this$0, localpng.vid, localpng.fileType, (pno.a)localObject);
        ram.w("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localpng.downloadKey });
      }
    }
    pno.a(this.this$0).clear();
    ram.w("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */