import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.gdtad.aditem.GdtHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class yjr
{
  private static AdClickUtil.Params a(yjs paramyjs)
  {
    WeakReference localWeakReference = null;
    if (paramyjs == null) {
      return null;
    }
    AdClickUtil.Params localParams = new AdClickUtil.Params();
    localParams.activity = paramyjs.jdField_a_of_type_JavaLangRefWeakReference;
    localParams.ad = paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localParams.reportForClick = paramyjs.jdField_a_of_type_Boolean;
    localParams.sceneID = paramyjs.jdField_b_of_type_Int;
    localParams.componentID = paramyjs.jdField_c_of_type_Int;
    localParams.enableAutoDownload = paramyjs.jdField_b_of_type_Boolean;
    if (paramyjs.jdField_b_of_type_JavaLangRefWeakReference != null) {
      localWeakReference = new WeakReference(paramyjs.jdField_b_of_type_JavaLangRefWeakReference.get());
    }
    localParams.appReceiver = localWeakReference;
    localParams.videoCeilingSupportedIfNotInstalled = paramyjs.jdField_c_of_type_Boolean;
    localParams.videoCeilingSupportedIfInstalled = paramyjs.d;
    localParams.videoSpliceSupported = paramyjs.e;
    localParams.mediaViewLocationRect = paramyjs.jdField_a_of_type_AndroidGraphicsRect;
    localParams.videoStartPositionMillis = paramyjs.jdField_a_of_type_Long;
    localParams.extrasForIntent = new Bundle();
    localParams.extrasForIntent.putString("big_brother_source_key", "biz_src_ads");
    if (paramyjs.jdField_a_of_type_AndroidOsBundle != null)
    {
      yny.b("GdtHandler", "toParams pass refId " + paramyjs.jdField_a_of_type_AndroidOsBundle);
      localParams.extrasForIntent.putAll(paramyjs.jdField_a_of_type_AndroidOsBundle);
    }
    for (;;)
    {
      localParams.videoPlayForced = paramyjs.f;
      localParams.antiSpamParams = paramyjs.jdField_a_of_type_JavaLangString;
      return localParams;
      yny.b("GdtHandler", "toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
    }
  }
  
  public static void a(yjs paramyjs)
  {
    yny.b("GdtHandler", "handle");
    ThreadManager.getSubThreadHandler().post(new GdtHandler.1(paramyjs));
    ypc localypc = ypc.a();
    Activity localActivity;
    if ((paramyjs != null) && (paramyjs.a()))
    {
      localActivity = (Activity)paramyjs.jdField_a_of_type_JavaLangRefWeakReference.get();
      localypc.a(localActivity, new ypd());
      paramyjs = AdClickUtil.handle(a(paramyjs));
      if (paramyjs == null) {
        break label104;
      }
    }
    label104:
    for (int i = paramyjs.getErrorCode();; i = 1)
    {
      yny.b("GdtHandler", String.format("handle errorCode:%d", new Object[] { Integer.valueOf(i) }));
      return;
      localActivity = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */