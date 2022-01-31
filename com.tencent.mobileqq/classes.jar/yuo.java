import android.content.Context;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import java.lang.ref.WeakReference;

public final class yuo
{
  private static volatile yuo jdField_a_of_type_Yuo;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile yug jdField_a_of_type_Yug;
  private yui jdField_a_of_type_Yui = new yuq(this);
  private yur jdField_a_of_type_Yur = new yur();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static yuo a()
  {
    if (jdField_a_of_type_Yuo == null) {}
    try
    {
      if (jdField_a_of_type_Yuo == null) {
        jdField_a_of_type_Yuo = new yuo();
      }
      return jdField_a_of_type_Yuo;
    }
    finally {}
  }
  
  private void a()
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isWebProcessRunning();
    yxs.b("GdtInterstitialPreDownloader", String.format("preDownloadOnMainProcess isWebProcessRunning:%b isModuleRunning:%b", new Object[] { localBoolean, Boolean.valueOf(QIPCServerHelper.getInstance().isModuleRunning("gdt_server_ipc")) }));
    if ((localBoolean == null) || (localBoolean.booleanValue() != true)) {
      return;
    }
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "gdt_server_ipc", "PRELOAD_INTERSTITIAL_MAIN_TO_TOOL", null, new yup(this));
  }
  
  private void b()
  {
    yxs.b("GdtInterstitialPreDownloader", "preDownloadOnToolProcess");
    if (this.jdField_a_of_type_Yug == null) {
      synchronized (jdField_a_of_type_Yuo)
      {
        if (this.jdField_a_of_type_Yug == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Yug = new yug(new WeakReference(this.jdField_a_of_type_Yui), yul.a().a(), -2147483648L);
          yyf.a(BaseApplicationImpl.getApplication());
        }
        return;
      }
    }
  }
  
  private void c()
  {
    yxs.b("GdtInterstitialPreDownloader", "preloadOnOtherProcess");
    this.jdField_a_of_type_Yur.send(null);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Yug != null) {
      return this.jdField_a_of_type_Yug.a();
    }
    return -2147483648;
  }
  
  public void a(Context arg1)
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnWebProcess();
    yxs.b("GdtInterstitialPreDownloader", String.format("init %b isOnWebProcess:%b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), localBoolean }));
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      synchronized (jdField_a_of_type_Yuo)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while ((localObject == null) || (localObject.booleanValue() != true));
    QIPCClientHelper.getInstance().register(yus.a());
    yxs.b("GdtInterstitialPreDownloader", "QIPCClientHelper.getInstance().register(ServerToClientIPCModule.getInstance())");
  }
  
  public void b(Context paramContext)
  {
    yxs.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = AdProcessManager.INSTANCE.isOnWebProcess();
    if (AdProcessManager.INSTANCE.isOnMainProcess().booleanValue())
    {
      a();
      return;
    }
    if ((paramContext != null) && (paramContext.booleanValue() == true))
    {
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuo
 * JD-Core Version:    0.7.0.1
 */