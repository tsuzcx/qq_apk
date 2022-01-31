import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.device.AdImei;
import com.tencent.ad.tangram.device.AdImeiAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import java.lang.ref.WeakReference;

public final class yyt
{
  private static volatile yyt jdField_a_of_type_Yyt;
  private AdAnalysisAdapter jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter = new yry();
  private AdCanvasAdapter jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter = new ysa();
  private AdImeiAdapter jdField_a_of_type_ComTencentAdTangramDeviceAdImeiAdapter = new ysb();
  private AdProgressDialogAdapter jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter = new ysf();
  private AdIPCManager.Adapter jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter = new ysc();
  private AdLogAdapter jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter = new ysd();
  private AdQQMINIProgramAdapter jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter = new ysg();
  private AdProcessManagerAdapter jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter = new yse();
  private AdThreadManagerAdapter jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter = new ysi();
  private AdToastAdapter jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter = new ysj();
  private AdVideoCeilingAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter = new ysk();
  private AdVideoSpliceAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter = new ysl();
  private AdBrowserAdapter jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter = new yrz();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static yyt a()
  {
    if (jdField_a_of_type_Yyt == null) {}
    try
    {
      if (jdField_a_of_type_Yyt == null) {
        jdField_a_of_type_Yyt = new yyt();
      }
      return jdField_a_of_type_Yyt;
    }
    finally {}
  }
  
  private void b(Context paramContext, yyu paramyyu)
  {
    AdIPCManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter));
    AdLog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter));
    AdAnalysis.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter));
    AdProcessManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter));
    AdThreadManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter));
    AdBrowser.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter));
    AdCanvas.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter));
    AdVideoCeiling.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter));
    AdQQMINIProgram.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter));
    AdVideoSplice.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter));
    AdToast.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter));
    AdProgressDialog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter));
    AdImei.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDeviceAdImeiAdapter));
  }
  
  private void c(Context paramContext, yyu paramyyu)
  {
    AdAnalysis.INSTANCE.init(paramContext);
  }
  
  private void d(Context paramContext, yyu paramyyu)
  {
    yyp.a(paramContext);
  }
  
  private void e(Context paramContext, yyu paramyyu)
  {
    yul.a().a(paramContext);
  }
  
  public void a(Context paramContext, yyu paramyyu)
  {
    yxp.b("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_Boolean = true;
    b(paramContext, paramyyu);
    c(paramContext, paramyyu);
    d(paramContext, paramyyu);
    e(paramContext, paramyyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyt
 * JD-Core Version:    0.7.0.1
 */