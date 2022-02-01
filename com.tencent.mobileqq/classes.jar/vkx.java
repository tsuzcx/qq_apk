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

public class vkx
{
  private static String jdField_a_of_type_JavaLangString = "QCircleRichMediaDownLoadManager";
  private static vkx jdField_a_of_type_Vkx;
  private static final String b = antf.bg;
  private static final String c = uym.e + "feedRichMedia/";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QCircleRichMediaDownLoadManager");
  
  private vkx()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    bhmi.c(c + ".nomedia");
    NetworkMonitorReceiver.getInstance().registerReceiver();
  }
  
  public static vkx a()
  {
    if (jdField_a_of_type_Vkx == null) {}
    try
    {
      if (jdField_a_of_type_Vkx == null) {
        jdField_a_of_type_Vkx = new vkx();
      }
      return jdField_a_of_type_Vkx;
    }
    finally {}
  }
  
  private boolean a(vla paramvla)
  {
    if (bhmi.b(paramvla.c(), vla.a(paramvla)))
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.fromFile(new File(vla.a(paramvla))));
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
      MobileQQ.sMobileQQ.onSendBroadcast(BaseApplicationImpl.getApplication(), localIntent);
      if (vla.a(paramvla) != null) {
        vla.a(paramvla).a(true);
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramvla.a() + " ,move file to local album ");
      return true;
    }
    bhmi.a(paramvla.c(), true);
    return false;
  }
  
  private void b(vla paramvla)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleRichMediaDownLoadManager.2(this, paramvla));
  }
  
  private void c(@NotNull vla paramvla)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, paramvla.a() + ",download start ");
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new vky(this, paramvla);
    localbeum.jdField_a_of_type_JavaLangString = paramvla.a();
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = paramvla.c();
    localbeum.b = bhnv.a(bevn.a().a());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).getNetEngine(0).a(localbeum);
    }
    paramvla = new vkz(this, paramvla, localAppRuntime, localbeum);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(paramvla);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    bhmi.a(c);
  }
  
  public void a(vla paramvla)
  {
    if (paramvla != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new QCircleRichMediaDownLoadManager.1(this, paramvla));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkx
 * JD-Core Version:    0.7.0.1
 */