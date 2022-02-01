import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

public class vwg
{
  private static vwg jdField_a_of_type_Vwg;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Vector<vwi> jdField_a_of_type_JavaUtilVector = new Vector();
  private vwi jdField_a_of_type_Vwi;
  private boolean jdField_a_of_type_Boolean;
  
  /* Error */
  private Downloader a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	vwg:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 35	vwg:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 24	vwg:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   24: invokestatic 41	com/tencent/component/network/DownloaderFactory:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/DownloaderFactory;
    //   27: invokevirtual 44	com/tencent/component/network/DownloaderFactory:getCommonDownloader	()Lcom/tencent/component/network/downloader/Downloader;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 49	com/tencent/component/network/downloader/Downloader:enableResumeTransfer	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 35	vwg:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   44: aload_0
    //   45: getfield 35	vwg:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   48: ifnonnull +26 -> 74
    //   51: new 51	java/lang/RuntimeException
    //   54: dup
    //   55: ldc 53
    //   57: invokespecial 56	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 59	java/lang/Throwable:printStackTrace	()V
    //   71: goto -32 -> 39
    //   74: aload_0
    //   75: getfield 35	vwg:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   78: astore_1
    //   79: goto -65 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	vwg
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
  
  public static vwg a()
  {
    if (jdField_a_of_type_Vwg == null) {}
    try
    {
      jdField_a_of_type_Vwg = new vwg();
      return jdField_a_of_type_Vwg;
    }
    finally {}
  }
  
  private boolean a(vwi paramvwi)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (paramvwi.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilVector.add(0, paramvwi);
            return bool;
          }
          this.jdField_a_of_type_JavaUtilVector.add(paramvwi);
          continue;
        }
        if (paramvwi.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest == null) {
          break label86;
        }
      }
      finally {}
      if (a().download(paramvwi.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest, paramvwi.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Vwi = paramvwi;
        this.jdField_a_of_type_Boolean = true;
        continue;
        label86:
        if (a().download(paramvwi.jdField_b_of_type_JavaLangString, paramvwi.jdField_a_of_type_JavaLangString, paramvwi.jdField_b_of_type_Boolean, paramvwi.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener))
        {
          this.jdField_a_of_type_Vwi = paramvwi;
          this.jdField_a_of_type_Boolean = true;
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
  
  public final boolean a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    vwi localvwi = new vwi(this);
    localvwi.jdField_a_of_type_JavaLangString = paramString2;
    localvwi.jdField_b_of_type_JavaLangString = paramString1;
    localvwi.jdField_b_of_type_Boolean = paramBoolean1;
    localvwi.jdField_a_of_type_Boolean = paramBoolean2;
    localvwi.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    localvwi.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new vwh(this, localvwi);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(localvwi.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      localvwi.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest = paramDownloadRequest;
    }
    return a(localvwi);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwg
 * JD-Core Version:    0.7.0.1
 */