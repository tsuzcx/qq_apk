package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pmq;
import pmq.a;
import pnb;
import pnb.a;
import png;
import pnh;
import pni.a;
import pnm.a;
import pnr;
import psu;
import psx;
import ram;
import rar;
import rnw;
import rox;

@TargetApi(14)
public class PreloadDownloader
  implements pnb.a
{
  public static final Object bl = PreloadDownloader.class;
  protected DownloadRunnable a;
  protected volatile PreloadQueue a;
  protected pnm.a a;
  protected pnb b;
  protected volatile png b;
  protected final Object bm = new Object();
  protected Thread f;
  protected List<WeakReference<pni.a>> mn = Collections.synchronizedList(new ArrayList());
  
  public PreloadDownloader()
  {
    this.jdField_b_of_type_Pnb = new pnb();
    this.jdField_b_of_type_Pnb.dU(this.mn);
  }
  
  private void b(png parampng, ErrorMessage arg2)
  {
    parampng.status = 3;
    File localFile = new File(parampng.localPath);
    synchronized (bl)
    {
      Iterator localIterator = this.mn.iterator();
      while (localIterator.hasNext())
      {
        pni.a locala = (pni.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          locala.a(parampng.vid, parampng.fileType, localFile, parampng.bjt, parampng);
        }
      }
    }
    ((pmq)psx.a(28)).bg(parampng.vid, parampng.fileType);
  }
  
  private void c(png parampng, ErrorMessage arg2)
  {
    ram.w("Q.qqstory.download.preload.PreloadDownloader", String.format("download success , task = %s", new Object[] { parampng }));
    File localFile = new File(parampng.localPath);
    parampng.status = 3;
    synchronized (bl)
    {
      Iterator localIterator = this.mn.iterator();
      while (localIterator.hasNext())
      {
        pni.a locala = (pni.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          locala.b(parampng.vid, parampng.fileType, localFile, parampng.bjt, parampng);
        }
      }
    }
    ((pmq)psx.a(28)).bg(parampng.vid, parampng.fileType);
    boolean bool = rnw.fy(parampng.vid);
    int i;
    if (!parampng.aAL)
    {
      if (parampng.bjt == 0)
      {
        i = 1;
        if (!rnw.fy(parampng.vid)) {
          break label381;
        }
        ??? = "video_download_time_gs";
        label175:
        rar.b("download_video", ???, i, (int)parampng.Ag, new String[] { String.valueOf(new File(parampng.localPath).length()), String.valueOf(parampng.fileType), rar.getNetworkType(BaseApplication.getContext()), parampng.vid });
      }
    }
    else
    {
      if (!rnw.fy(parampng.vid)) {
        break label387;
      }
      ??? = "video_download_success_gs";
      label250:
      rar.b("download_video", ???, 0, 0, new String[] { String.valueOf(new File(parampng.localPath).length()), String.valueOf(parampng.fileType), rar.getNetworkType(BaseApplication.getContext()) });
      if ((!bool) && (parampng.fileType == 0))
      {
        ??? = ((psu)psx.a(5)).a(parampng.vid);
        if (??? != null) {
          break label393;
        }
      }
    }
    label387:
    label393:
    for (long l = 0L;; l = ???.mCreateTime)
    {
      rar.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l), String.valueOf(System.currentTimeMillis()), String.valueOf(parampng.compressLevel) });
      return;
      i = 0;
      break;
      label381:
      ??? = "video_download_time";
      break label175;
      ??? = "video_download_success";
      break label250;
    }
  }
  
  private void d(png parampng, ErrorMessage arg2)
  {
    Object localObject2;
    if (???.errorCode == 9037)
    {
      parampng.status = 2;
      ram.w("Q.qqstory.download.preload.PreloadDownloader", "download task cancel ," + parampng);
      synchronized (bl)
      {
        ??? = this.mn.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (pni.a)((WeakReference)((Iterator)???).next()).get();
          if (localObject2 != null) {
            ((pni.a)localObject2).b(parampng.vid, parampng.fileType, parampng);
          }
        }
      }
    }
    do
    {
      return;
      parampng.status = 4;
      ram.e("Q.qqstory.download.preload.PreloadDownloader", String.format("download error , errorMsg = %s , task = %s", new Object[] { ???, parampng }));
      synchronized (bl)
      {
        localObject2 = this.mn.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          pni.a locala = (pni.a)((WeakReference)((Iterator)localObject2).next()).get();
          if (locala != null) {
            locala.a(parampng.vid, parampng.fileType, ???, parampng.bjt, parampng);
          }
        }
      }
    } while ((???.errorCode == 9004) || (???.errorCode == 100) || (???.errorCode == 14));
    for (;;)
    {
      try
      {
        if (rnw.fy(parampng.vid))
        {
          localObject2 = "video_download_success_gs";
          if (!TextUtils.isEmpty(???.errorMsg)) {
            break label380;
          }
          ??? = "";
          if (???.errorCode != 9301) {
            break label453;
          }
          if (!rox.LN()) {
            break label405;
          }
          pnr.a().blX();
          i = 0;
          if (i == 0) {
            break;
          }
          rar.b("download_video", (String)localObject2, 0, ???.errorCode, new String[] { ???, String.valueOf(parampng.fileType), rar.getNetworkType(BaseApplication.getContext()), parampng.vid });
          return;
        }
      }
      catch (Exception parampng)
      {
        QLog.e("Q.qqstory.download.preload.PreloadDownloader", 1, parampng, new Object[0]);
        return;
      }
      localObject2 = "video_download_success";
      continue;
      label380:
      ??? = ???.errorMsg.substring(0, Math.min(???.errorMsg.length(), 20));
      continue;
      label405:
      ??? = (String)??? + " -" + rox.dY() / 1024L / 1024L + "M";
      int i = 1;
      continue;
      label453:
      i = 1;
    }
  }
  
  public png a()
  {
    return this.jdField_b_of_type_Png;
  }
  
  public void a(PreloadQueue paramPreloadQueue)
  {
    Object localObject1;
    if (paramPreloadQueue == null)
    {
      localObject1 = "null";
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue != null) {
        break label71;
      }
    }
    label71:
    for (Object localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue)
    {
      ram.w("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue newQueue = %s , currentQueue = %s", new Object[] { localObject1, localObject2 });
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue = paramPreloadQueue;
      if (localObject1 != null) {
        ((PreloadQueue)localObject1).releaseBlock();
      }
      if (paramPreloadQueue != null) {
        paramPreloadQueue.releaseBlock();
      }
      return;
      localObject1 = paramPreloadQueue;
      break;
    }
  }
  
  public void a(png arg1, ErrorMessage paramErrorMessage)
  {
    int j = 1;
    if ((??? == null) || (paramErrorMessage == null))
    {
      ram.e("Q.qqstory.download.preload.PreloadDownloader", "resp param is error");
      synchronized (this.bm)
      {
        this.bm.notifyAll();
        return;
      }
    }
    Object localObject = this.jdField_b_of_type_Png;
    if ((localObject != null) && (((png)localObject).equals(???))) {
      this.jdField_b_of_type_Png = null;
    }
    for (int i = 1;; i = 0)
    {
      ram.i("Q.qqstory.download.preload.PreloadDownloader", String.format("onResp , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? }));
      if (paramErrorMessage.errorCode == 12)
      {
        b(???, paramErrorMessage);
        synchronized (this.bm)
        {
          this.bm.notifyAll();
          return;
        }
      }
      if ((paramErrorMessage.errorCode == 9047) && (???.retryTime < 1) && (???.fileType == 1) && (!TextUtils.isEmpty(???.downloadUrl)) && (???.downloadUrl.startsWith("https")))
      {
        try
        {
          ram.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 error , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? });
          ???.downloadUrl = ???.downloadUrl.replace("https://", "http://");
          ???.retryTime += 1;
          if (this.jdField_b_of_type_Pnb.a(???, this))
          {
            this.jdField_b_of_type_Png = ???;
            if (!TextUtils.isEmpty(paramErrorMessage.errorMsg)) {
              break label360;
            }
            localObject = "";
            rar.b("download_video", "hostname_not_verified", 0, paramErrorMessage.errorCode, new String[] { localObject, String.valueOf(???.fileType), rar.getNetworkType(BaseApplication.getContext()), ???.vid });
            return;
          }
        }
        catch (Exception localException)
        {
          ram.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 protect error , errorMsg = %s", localException);
        }
      }
      else
      {
        if (paramErrorMessage.errorCode != 0) {
          break label385;
        }
        label323:
        if (j == 0) {
          break label391;
        }
        c(???, paramErrorMessage);
      }
      for (;;)
      {
        if (i == 0) {
          return;
        }
        synchronized (this.bm)
        {
          this.bm.notifyAll();
          return;
        }
        label360:
        String str = paramErrorMessage.errorMsg.substring(0, Math.min(paramErrorMessage.errorMsg.length(), 20));
        break;
        label385:
        j = 0;
        break label323;
        label391:
        d(???, paramErrorMessage);
      }
    }
  }
  
  public void a(pnm.a parama)
  {
    this.jdField_a_of_type_Pnm$a = parama;
  }
  
  public void b(pni.a parama)
  {
    synchronized (bl)
    {
      parama = new WeakReference(parama);
      this.mn.add(parama);
      return;
    }
  }
  
  public void c(png parampng)
  {
    if ((parampng == null) || (this.jdField_b_of_type_Pnb.a(parampng))) {}
    synchronized (this.bm)
    {
      this.bm.notifyAll();
      ram.w("Q.qqstory.download.preload.PreloadDownloader", "cancel task " + parampng);
      return;
    }
  }
  
  public void d(png arg1)
  {
    ram.i("Q.qqstory.download.preload.PreloadDownloader", "downloadTask , " + ???);
    rar.b("download_video", "video_download_start", 0, 0, new String[] { "", String.valueOf(???.fileType), rar.getNetworkType(BaseApplication.getContext()), ???.vid });
    File localFile = pnh.a(???.vid, ???.fileType, false, false);
    if (localFile != null)
    {
      ???.localPath = localFile.getAbsolutePath();
      a(???, new ErrorMessage(12, "ERR_DOWNLOAD_BEFORE"));
    }
    do
    {
      return;
      if (???.aAK)
      {
        localFile = new File(???.atT);
        if (localFile.exists())
        {
          localFile.delete();
          ram.w("Q.qqstory.download.preload.PreloadDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ???.vid, Integer.valueOf(???.fileType) });
        }
      }
    } while (!this.jdField_b_of_type_Pnb.a(???, this));
    try
    {
      synchronized (this.bm)
      {
        this.bm.wait(45000L);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.download.preload.PreloadDownloader", "wait error , %s", new Object[] { localInterruptedException.getMessage() });
      }
    }
  }
  
  public boolean isRunning()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable.aAP);
  }
  
  /* Error */
  public void onStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 444	com/tencent/biz/qqstory/base/preload/PreloadDownloader:isRunning	()Z
    //   6: ifeq +14 -> 20
    //   9: ldc 122
    //   11: ldc_w 446
    //   14: invokestatic 136	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 8	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable
    //   24: dup
    //   25: aload_0
    //   26: aconst_null
    //   27: invokespecial 449	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:<init>	(Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;Lpnl;)V
    //   30: putfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   33: aload_0
    //   34: getfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   37: iconst_1
    //   38: putfield 441	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:aAP	Z
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   46: ldc_w 451
    //   49: iconst_5
    //   50: invokestatic 457	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   53: putfield 459	com/tencent/biz/qqstory/base/preload/PreloadDownloader:f	Ljava/lang/Thread;
    //   56: aload_0
    //   57: getfield 459	com/tencent/biz/qqstory/base/preload/PreloadDownloader:f	Ljava/lang/Thread;
    //   60: invokevirtual 464	java/lang/Thread:start	()V
    //   63: ldc 122
    //   65: ldc_w 465
    //   68: invokestatic 136	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -54 -> 17
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	PreloadDownloader
    //   74	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	74	finally
    //   20	71	74	finally
  }
  
  /* Error */
  public void onStop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   6: ifnull +42 -> 48
    //   9: aload_0
    //   10: getfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   13: iconst_0
    //   14: putfield 441	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:aAP	Z
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 438	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   22: aload_0
    //   23: getfield 51	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_b_of_type_Pnb	Lpnb;
    //   26: invokevirtual 469	pnb:Iw	()Z
    //   29: ifeq +19 -> 48
    //   32: aload_0
    //   33: getfield 53	com/tencent/biz/qqstory/base/preload/PreloadDownloader:bm	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 53	com/tencent/biz/qqstory/base/preload/PreloadDownloader:bm	Ljava/lang/Object;
    //   43: invokevirtual 320	java/lang/Object:notifyAll	()V
    //   46: aload_1
    //   47: monitorexit
    //   48: ldc 122
    //   50: ldc_w 470
    //   53: invokestatic 136	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_2
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	PreloadDownloader
    //   64	4	1	localObject2	Object
    //   59	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	48	59	finally
    //   60	62	59	finally
    //   2	39	64	finally
    //   48	56	64	finally
    //   62	64	64	finally
  }
  
  public int sn()
  {
    PreloadQueue localPreloadQueue = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
    if (localPreloadQueue == null) {
      return 2147483647;
    }
    return localPreloadQueue.getId();
  }
  
  class DownloadRunnable
    implements Runnable
  {
    public volatile boolean aAP = true;
    
    private DownloadRunnable() {}
    
    public void run()
    {
      for (;;)
      {
        if (!this.aAP) {
          return;
        }
        if (PreloadDownloader.this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue == null)
        {
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        else
        {
          if ((PreloadDownloader.this.jdField_a_of_type_Pnm$a != null) && (!PreloadDownloader.this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
            PreloadDownloader.this.jdField_a_of_type_Pnm$a.vR(PreloadDownloader.this.sn());
          }
          ??? = PreloadDownloader.this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
          PreloadDownloader.this.b = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
          png localpng1 = PreloadDownloader.this.b;
          if (localpng1 != null)
          {
            localpng1.bjt = ((PreloadQueue)???).getId();
            for (;;)
            {
              Iterator localIterator;
              synchronized (PreloadDownloader.bl)
              {
                localIterator = PreloadDownloader.this.mn.iterator();
                if (!localIterator.hasNext()) {
                  break;
                }
                pni.a locala = (pni.a)((WeakReference)localIterator.next()).get();
                if (locala != null) {
                  locala.a(localpng1.vid, localpng1.fileType, localpng1);
                }
              }
              localIterator.remove();
            }
            localpng2.status = 1;
            if (TextUtils.isEmpty(localpng2.downloadUrl))
            {
              ??? = ((pmq)psx.a(28)).b(localpng2.vid, localpng2.fileType);
              localpng2.downloadUrl = ((pmq.a)???).url;
              localpng2.aAK = ((pmq.a)???).aAJ;
              localpng2.compressLevel = ((pmq.a)???).compressLevel;
              PreloadDownloader.this.d(localpng2);
            }
            else
            {
              PreloadDownloader.this.d(localpng2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader
 * JD-Core Version:    0.7.0.1
 */