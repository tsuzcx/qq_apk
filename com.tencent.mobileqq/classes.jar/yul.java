import android.content.Context;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import java.lang.ref.WeakReference;

public final class yul
{
  private static volatile yul jdField_a_of_type_Yul;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile yud jdField_a_of_type_Yud;
  private yuf jdField_a_of_type_Yuf = new yun(this);
  private yuo jdField_a_of_type_Yuo = new yuo();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static yul a()
  {
    if (jdField_a_of_type_Yul == null) {}
    try
    {
      if (jdField_a_of_type_Yul == null) {
        jdField_a_of_type_Yul = new yul();
      }
      return jdField_a_of_type_Yul;
    }
    finally {}
  }
  
  private void a()
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isWebProcessRunning();
    yxp.b("GdtInterstitialPreDownloader", String.format("preDownloadOnMainProcess isWebProcessRunning:%b isModuleRunning:%b", new Object[] { localBoolean, Boolean.valueOf(QIPCServerHelper.getInstance().isModuleRunning("gdt_server_ipc")) }));
    if ((localBoolean == null) || (localBoolean.booleanValue() != true)) {
      return;
    }
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "gdt_server_ipc", "PRELOAD_INTERSTITIAL_MAIN_TO_TOOL", null, new yum(this));
  }
  
  private void b()
  {
    yxp.b("GdtInterstitialPreDownloader", "preDownloadOnToolProcess");
    if (this.jdField_a_of_type_Yud == null) {
      synchronized (jdField_a_of_type_Yul)
      {
        if (this.jdField_a_of_type_Yud == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Yud = new yud(new WeakReference(this.jdField_a_of_type_Yuf), yui.a().a(), -2147483648L);
          yyc.a(BaseApplicationImpl.getApplication());
        }
        return;
      }
    }
  }
  
  private void c()
  {
    yxp.b("GdtInterstitialPreDownloader", "preloadOnOtherProcess");
    this.jdField_a_of_type_Yuo.send(null);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Yud != null) {
      return this.jdField_a_of_type_Yud.a();
    }
    return -2147483648;
  }
  
  public void a(Context arg1)
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnWebProcess();
    yxp.b("GdtInterstitialPreDownloader", String.format("init %b isOnWebProcess:%b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), localBoolean }));
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      synchronized (jdField_a_of_type_Yul)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while ((localObject == null) || (localObject.booleanValue() != true));
    QIPCClientHelper.getInstance().register(yup.a());
    yxp.b("GdtInterstitialPreDownloader", "QIPCClientHelper.getInstance().register(ServerToClientIPCModule.getInstance())");
  }
  
  public void b(Context paramContext)
  {
    yxp.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
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
 * Qualified Name:     yul
 * JD-Core Version:    0.7.0.1
 */