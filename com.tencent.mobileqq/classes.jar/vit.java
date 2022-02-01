import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.1;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class vit
{
  private static String jdField_a_of_type_JavaLangString = "QCircleRichMediaDownLoadManager";
  private static vit jdField_a_of_type_Vit;
  private static final String b = anhk.bg;
  private static final String c = uxb.e + "feedRichMedia/";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QCircleRichMediaDownLoadManager");
  
  private vit()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    bgmg.c(c + ".nomedia");
    NetworkMonitorReceiver.getInstance().registerReceiver();
  }
  
  public static vit a()
  {
    if (jdField_a_of_type_Vit == null) {}
    try
    {
      if (jdField_a_of_type_Vit == null) {
        jdField_a_of_type_Vit = new vit();
      }
      return jdField_a_of_type_Vit;
    }
    finally {}
  }
  
  private boolean a(viw paramviw)
  {
    if (bgmg.b(paramviw.c(), viw.a(paramviw)))
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.fromFile(new File(viw.a(paramviw))));
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
      MobileQQ.sMobileQQ.onSendBroadcast(BaseApplicationImpl.getApplication(), localIntent);
      if (viw.a(paramviw) != null) {
        viw.a(paramviw).a(true);
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramviw.a() + " ,move file to local album ");
      return true;
    }
    bgmg.a(paramviw.c(), true);
    return false;
  }
  
  private void b(viw paramviw)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleRichMediaDownLoadManager.2(this, paramviw));
  }
  
  private void c(@NotNull viw paramviw)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, paramviw.a() + ",download start ");
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new viu(this, paramviw);
    localbdvs.jdField_a_of_type_JavaLangString = paramviw.a();
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = paramviw.c();
    localbdvs.b = bgnt.a(bdwu.a().a());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).getNetEngine(0).a(localbdvs);
    }
    paramviw = new viv(this, paramviw, localAppRuntime, localbdvs);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(paramviw);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    bgmg.a(c);
  }
  
  public void a(viw paramviw)
  {
    if (paramviw != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new QCircleRichMediaDownLoadManager.1(this, paramviw));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vit
 * JD-Core Version:    0.7.0.1
 */