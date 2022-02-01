import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

public class avrq
{
  private static avrq jdField_a_of_type_Avrq;
  private Vector<avrq.a> W = new Vector();
  private avrq.a jdField_a_of_type_Avrq$a;
  private Context context = BaseApplicationImpl.getContext();
  private boolean isDownloading;
  private Downloader mImageDownloader;
  
  public static avrq a()
  {
    if (jdField_a_of_type_Avrq == null) {}
    try
    {
      jdField_a_of_type_Avrq = new avrq();
      return jdField_a_of_type_Avrq;
    }
    finally {}
  }
  
  private boolean a(avrq.a parama)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.isDownloading)
        {
          if (parama.doy)
          {
            this.W.add(0, parama);
            return bool;
          }
          this.W.add(parama);
          continue;
        }
        if (parama.downloadRequest == null) {
          break label86;
        }
      }
      finally {}
      if (getDownloader().download(parama.downloadRequest, parama.priority))
      {
        this.jdField_a_of_type_Avrq$a = parama;
        this.isDownloading = true;
        continue;
        label86:
        if (getDownloader().download(parama.url, parama.path, parama.priority, parama.d))
        {
          this.jdField_a_of_type_Avrq$a = parama;
          this.isDownloading = true;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  /* Error */
  private Downloader getDownloader()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	avrq:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 95	avrq:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 30	avrq:context	Landroid/content/Context;
    //   24: invokestatic 101	com/tencent/component/network/DownloaderFactory:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/DownloaderFactory;
    //   27: invokevirtual 104	com/tencent/component/network/DownloaderFactory:getCommonDownloader	()Lcom/tencent/component/network/downloader/Downloader;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 107	com/tencent/component/network/downloader/Downloader:enableResumeTransfer	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 95	avrq:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   44: aload_0
    //   45: getfield 95	avrq:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   48: ifnonnull +26 -> 74
    //   51: new 109	java/lang/RuntimeException
    //   54: dup
    //   55: ldc 111
    //   57: invokespecial 114	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   71: goto -32 -> 39
    //   74: aload_0
    //   75: getfield 95	avrq:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   78: astore_1
    //   79: goto -65 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	avrq
    //   13	28	1	localObject1	Object
    //   61	4	1	localObject2	Object
    //   78	1	1	localDownloader1	Downloader
    //   30	8	2	localDownloader2	Downloader
    //   66	2	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   20	31	61	finally
    //   33	37	61	finally
    //   39	61	61	finally
    //   67	71	61	finally
    //   74	79	61	finally
    //   20	31	66	java/lang/Throwable
    //   33	37	66	java/lang/Throwable
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    avrq.a locala = new avrq.a();
    locala.path = paramString2;
    locala.url = paramString1;
    locala.priority = paramBoolean1;
    locala.doy = paramBoolean2;
    locala.c = paramDownloadListener;
    locala.d = new avrr(this, locala);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(locala.d);
      locala.downloadRequest = paramDownloadRequest;
    }
    return a(locala);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    getDownloader().abort(paramString, paramDownloadListener);
    if (this.W.size() > 0)
    {
      paramString = (avrq.a)this.W.get(0);
      this.W.remove(0);
      this.isDownloading = false;
      a(paramString);
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    getDownloader().cancel(paramString, paramDownloadListener);
    if (this.W.size() > 0)
    {
      paramString = (avrq.a)this.W.get(0);
      this.W.remove(0);
      this.isDownloading = false;
      a(paramString);
    }
  }
  
  public final boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    return a(null, null, paramBoolean, false, paramDownloadRequest, paramDownloadRequest.getListener());
  }
  
  public final boolean download(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean, false, paramDownloadListener);
  }
  
  class a
  {
    Downloader.DownloadListener c;
    Downloader.DownloadListener d;
    DownloadRequest downloadRequest;
    boolean doy;
    String path;
    boolean priority;
    String url;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrq
 * JD-Core Version:    0.7.0.1
 */