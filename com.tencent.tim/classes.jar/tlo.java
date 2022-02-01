import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.ark.AdArkAdapter;
import com.tencent.ad.tangram.ark.AdArkView;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.download.AdDownloader;
import com.tencent.ad.tangram.canvas.download.AdDownloaderAdapter;
import com.tencent.ad.tangram.canvas.report.AdReport;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.resource.AdResource;
import com.tencent.ad.tangram.canvas.resource.AdResourceAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import java.lang.ref.WeakReference;

public final class tlo
{
  private static volatile tlo jdField_a_of_type_Tlo;
  private AdArkAdapter jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter = new tez();
  private AdCanvasAdapter jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter = new tfe();
  private AdCanvasDownloadListenerAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter = new tfg();
  private AdDownloaderAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdDownloaderAdapter = new tfh();
  private AdReportAdapter jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter = new tfu();
  private AdResourceAdapter jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter = new tfv();
  private AdProgressDialogAdapter jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter = new tfr();
  private AdImageViewAdapter jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter = new tfm();
  private AdIPCManager.Adapter jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter = new tfi();
  private AdLogAdapter jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter = new tfo();
  private AdQQMINIProgramAdapter jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter = new tfs();
  private AdOfflineAdapter jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter = new tfp();
  private AdProcessManagerAdapter jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter = new tfq();
  private AdThreadManagerAdapter jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter = new tfw();
  private AdToastAdapter jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter = new tfx();
  private AdVersionAdapter jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter = new tfy();
  private AdVideoCeilingAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter = new tfz();
  private AdVideoSpliceAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter = new tga();
  private AdBrowserAdapter jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter = new tfd();
  private volatile boolean initialized;
  
  public static tlo a()
  {
    if (jdField_a_of_type_Tlo == null) {}
    try
    {
      if (jdField_a_of_type_Tlo == null) {
        jdField_a_of_type_Tlo = new tlo();
      }
      return jdField_a_of_type_Tlo;
    }
    finally {}
  }
  
  private void b(Context paramContext, tlo.a parama)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter));
    AdLog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter));
    AdProcessManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter));
    AdThreadManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter));
    AdBrowser.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter));
    AdCanvas.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter));
    AdVideoCeiling.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter));
    AdQQMINIProgram.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter));
    AdVideoSplice.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter));
    AdToast.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter));
    AdProgressDialog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter));
    AdImageViewBuilder.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter));
    AdDownloader.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdDownloaderAdapter));
    AdArkView.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter));
    AdReport.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter));
    AdResource.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter));
    AdVersion.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter));
    AdCanvasDownloadListener.setAdapter(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter);
    AdOffline.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter));
  }
  
  private void c(Context paramContext, tlo.a parama)
  {
    AdAnalysis.INSTANCE.init(paramContext);
  }
  
  private void d(Context paramContext, tlo.a parama)
  {
    tho.a().init();
  }
  
  private void e(Context paramContext, tlo.a parama)
  {
    AdExposureListHolder.getInstance().init(paramContext);
  }
  
  public AdIPCManager.Adapter a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter;
  }
  
  public void a(Context paramContext, tlo.a parama)
  {
    tkw.i("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    b(paramContext, parama);
    c(paramContext, parama);
    d(paramContext, parama);
    e(paramContext, parama);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlo
 * JD-Core Version:    0.7.0.1
 */