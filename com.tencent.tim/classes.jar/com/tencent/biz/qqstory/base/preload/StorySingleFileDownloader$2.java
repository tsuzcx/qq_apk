package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import pmq;
import pmq.a;
import pnb;
import png;
import pnh;
import pno;
import pno.a;
import psx;
import ram;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(pno parampno, String paramString, int paramInt, pno.a parama, boolean paramBoolean) {}
  
  public void run()
  {
    String str = png.makeKey(this.val$vid, this.val$fileType);
    if (pno.a(this.this$0).containsKey(str))
    {
      ram.w("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = pnh.a(this.val$vid, this.val$fileType, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      ram.w("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      pno.b(this.this$0, this.val$vid, this.val$fileType, this.a);
      return;
    }
    ram.w("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.aAQ) });
    if (this.aAQ)
    {
      localObject1 = pno.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (png)((Iterator)localObject1).next();
        pno.a(this.this$0).a((png)localObject2);
        Object localObject3 = ((png)localObject2).fD.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof pno.a)))
        {
          pno.a(this.this$0, this.val$vid, this.val$fileType, (pno.a)localObject3);
          ram.w("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((png)localObject2).downloadKey, str });
        }
      }
      pno.a(this.this$0).clear();
    }
    localObject1 = png.a(this.val$vid, this.val$fileType);
    Object localObject2 = ((pmq)psx.a(28)).b(this.val$vid, this.val$fileType);
    ((png)localObject1).downloadUrl = ((pmq.a)localObject2).url;
    ((png)localObject1).aAK = ((pmq.a)localObject2).aAJ;
    ((png)localObject1).compressLevel = ((pmq.a)localObject2).compressLevel;
    ((png)localObject1).fD.put("DOWNLOAD_TASK_KEY_LISTENER", this.a);
    if (((png)localObject1).aAK)
    {
      localObject2 = new File(((png)localObject1).atT);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        ram.w("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((png)localObject1).vid, Integer.valueOf(((png)localObject1).fileType) });
      }
    }
    pno.a(this.this$0).a((png)localObject1, this.this$0);
    pno.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */