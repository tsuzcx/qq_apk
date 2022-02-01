package com.tencent.mobileqq.pic;

import akwv;
import akxb.a;
import akxe;
import akxl;
import akxq;
import akxv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.File;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BasePicOprerator$4
  implements Runnable
{
  public BasePicOprerator$4(akwv paramakwv, akxb.a parama) {}
  
  public void run()
  {
    Object localObject;
    akxv localakxv;
    long l;
    if ((this.a != null) && (this.this$0.e.j != null) && (this.a.bUF != null))
    {
      localObject = this.this$0.e.j;
      File localFile = new File(this.a.bUF);
      if (this.a.result == 0)
      {
        localakxv = (akxv)this.this$0.mApp.getManager(73);
        if (localakxv != null)
        {
          l = localFile.length();
          switch (this.a.dpA)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.this$0.mApp.a();
      if (((PicPreDownloader)localObject).b.contains(this.this$0.e))
      {
        ((PicPreDownloader)localObject).b.remove(this.this$0.e);
        ((PicPreDownloader)localObject).bC.decrementAndGet();
        ((PicPreDownloader)localObject).mp.remove(this.this$0.e.a.uuid);
        akxe.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.this$0.e.a.uniseq + ",cmd:" + this.this$0.e.dpE + ",curHandingNum:" + ((PicPreDownloader)localObject).bC.get());
        if ((this.a != null) && (this.a.bUF != null))
        {
          localObject = this.this$0.e.j;
          if ((localObject != null) && (((MessageForPic)localObject).size == 0L))
          {
            l = new File(this.a.bUF).length();
            this.this$0.mApp.a().a((MessageForPic)localObject, l);
          }
        }
        this.this$0.mApp.a().consume();
      }
      return;
      localakxv.al(13059, l);
      continue;
      localakxv.al(13060, l);
      localakxv.s((MessageForPic)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.4
 * JD-Core Version:    0.7.0.1
 */