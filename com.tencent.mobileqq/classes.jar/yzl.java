import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.1;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.2;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.4;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.5;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.6;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class yzl
{
  public static volatile GdtAppBtnData a;
  private static ArrayList<yzn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static boolean a;
  private static boolean f;
  private static volatile boolean g;
  private static volatile boolean h;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdko jdField_a_of_type_Bdko = new yzo(this);
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtAppDownloadManager.1(this);
  public String a;
  private WeakReference<zag> jdField_a_of_type_JavaLangRefWeakReference;
  private yzj jdField_a_of_type_Yzj;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GdtAppDownloadManager.2(this);
  private final String jdField_b_of_type_JavaLangString = "GdtAppDownloadManager";
  public boolean b;
  private Runnable jdField_c_of_type_JavaLangRunnable = new GdtAppDownloadManager.5(this);
  private boolean jdField_c_of_type_Boolean;
  private Runnable jdField_d_of_type_JavaLangRunnable = new GdtAppDownloadManager.6(this);
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public yzl(Context paramContext, boolean paramBoolean1, GdtAd paramGdtAd, String paramString1, GdtCanvasAppBtnView paramGdtCanvasAppBtnView, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString2;
    i();
    this.jdField_a_of_type_Yzj = new yzj(paramString1, paramGdtCanvasAppBtnView, this);
    l();
    if (yyq.a()) {
      AdThreadManager.INSTANCE.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0, 1000L);
    }
    try
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramContext != null) && ((paramContext instanceof QQAppInterface)))
      {
        paramContext = ((QQAppInterface)paramContext).getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramContext)) {
          bcxm.a().a(Long.valueOf(paramContext).longValue());
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a()
  {
    yxs.b("GdtAppBtnUIPresenter", "resetStaticVariables");
    jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData = null;
    g = false;
    h = false;
    jdField_a_of_type_Boolean = false;
  }
  
  private static void a(Activity paramActivity, GdtAppBtnData paramGdtAppBtnData)
  {
    if ((paramActivity == null) || (paramGdtAppBtnData == null)) {
      return;
    }
    String str1 = paramGdtAppBtnData.packageName;
    String str2 = paramGdtAppBtnData.mGdtAd_appId;
    String str3 = paramGdtAppBtnData.apkUrlhttp;
    String str4 = paramGdtAppBtnData.name;
    String str5 = paramGdtAppBtnData.via;
    Object localObject = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramGdtAppBtnData = (GdtAppBtnData)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramGdtAppBtnData = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      yxs.d("GdtAppBtnUIPresenter", "startRealDownload param null");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString(bdkm.f, str1);
    ((Bundle)localObject).putString(bdkm.jdField_b_of_type_JavaLangString, str2);
    ((Bundle)localObject).putString(bdkm.j, str3);
    ((Bundle)localObject).putString(bdkm.l, str4);
    ((Bundle)localObject).putInt(bdkm.k, 2);
    ((Bundle)localObject).putInt(bdkm.E, 0);
    ((Bundle)localObject).putBoolean(bdkm.x, false);
    ((Bundle)localObject).putInt(bdkm.H, 0);
    ((Bundle)localObject).putBoolean(bdkm.y, true);
    ((Bundle)localObject).putBoolean(bdkm.h, true);
    ((Bundle)localObject).putBoolean(bdkm.r, false);
    ((Bundle)localObject).putBoolean(bdkm.J, false);
    ((Bundle)localObject).putString(bdkm.i, str5);
    ((Bundle)localObject).putString("big_brother_ref_source_key", paramGdtAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtAppBtnUIPresenter", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    bdgz.a().a(paramActivity, (Bundle)localObject, "biz_src_ads", null, 0);
  }
  
  private void a(GdtAppBtnData paramGdtAppBtnData)
  {
    try
    {
      if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null) {
        jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData = paramGdtAppBtnData;
      }
      return;
    }
    finally
    {
      paramGdtAppBtnData = finally;
      throw paramGdtAppBtnData;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    yxx localyxx = new yxx();
    localyxx.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    PBUInt32Field localPBUInt32Field = localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type;
    if (paramBoolean) {}
    for (int i = 36;; i = 37)
    {
      localPBUInt32Field.set(i);
      localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
      yxw.a(localyxx);
      return;
    }
  }
  
  public static boolean a()
  {
    return g;
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      n();
      jdField_a_of_type_JavaUtilArrayList.add(new yzm(this));
    }
  }
  
  private void j()
  {
    AdThreadManager.INSTANCE.post(new GdtAppDownloadManager.4(this), 0);
  }
  
  private void k()
  {
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((yzn)jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  private void l()
  {
    yxs.a("GdtAppDownloadManager", "going fetch AppData");
    if ((!f) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null) && (yxu.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      f = true;
      AdThreadManager.INSTANCE.post(this.jdField_c_of_type_JavaLangRunnable, 4);
    }
  }
  
  private void m()
  {
    if ((!h) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData != null) && ((yyq.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp)) || (yyq.a())))
    {
      zcf.b(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      h = true;
    }
  }
  
  private void n()
  {
    yxs.a("GdtAppDownloadManager", "registerDownloadListener: " + this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      bdgv.a().a(this.jdField_a_of_type_Bdko);
    }
  }
  
  private void o()
  {
    yxs.a("GdtAppDownloadManager", "unregisterDownloadListener");
    bdgv.a().b(this.jdField_a_of_type_Bdko);
  }
  
  void a(GdtAppBtnData paramGdtAppBtnData, int paramInt)
  {
    g = true;
    yxs.c("GdtAppBtnUIPresenter", "startDownload " + paramGdtAppBtnData.packageName + " progress " + paramInt);
    paramGdtAppBtnData.cState = 3;
    this.jdField_a_of_type_Yzj.b(paramGdtAppBtnData, paramInt);
    n();
    yzq.a().a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.mGdtAd_appId, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
    yzq.a().a();
    yzq.a().a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramInt, this.jdField_c_of_type_Boolean);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Yzj.jdField_a_of_type_Boolean = true;
    paramGdtAppBtnData.via = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getVia();
    a(localActivity, paramGdtAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    yxs.b("GdtAppBtnUIPresenter", "onDownloadPause " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzj.a(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    yxs.b("GdtAppBtnUIPresenter", "onDownloadError " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzj.a(paramDownloadInfo, paramInt1, paramString, paramInt2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(String paramString1, String paramString2)
  {
    yxs.b("GdtAppBtnUIPresenter", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzj.a(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(WeakReference<zag> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Yzj.a(paramList, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void b()
  {
    yxs.b("GdtAppBtnUIPresenter", "initDownloadApp");
    try
    {
      GdtAppBtnData localGdtAppBtnData = jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData;
      if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Yzj == null) || (localGdtAppBtnData == null) || (!localGdtAppBtnData.isValid()))
      {
        yxs.b("GdtAppBtnUIPresenter", "initDownloadApp return " + localGdtAppBtnData);
        return;
      }
      yxs.b("GdtAppBtnUIPresenter", "initDownloadApp begin");
      if (nmf.a(this.jdField_a_of_type_AndroidContentContext, localGdtAppBtnData.packageName))
      {
        yxs.c("GdtAppBtnUIPresenter", "already installed." + localGdtAppBtnData.packageName);
        j();
        this.jdField_a_of_type_Yzj.b(localGdtAppBtnData);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtAppDownloadManager", 1, "initDownloadApp: ", localThrowable);
      return;
    }
    DownloadInfo localDownloadInfo;
    if (yyq.b(this.jdField_a_of_type_AndroidContentContext, localThrowable.apkUrlhttp))
    {
      yxs.c("GdtAppBtnUIPresenter", "already finishDownload." + localThrowable.packageName);
      j();
      this.jdField_a_of_type_Yzj.a(localThrowable);
      yyh.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, 270);
      localDownloadInfo = bdgv.a().b(localThrowable.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bdgv.a().a(localDownloadInfo);
      return;
    }
    int i = yyq.a(this.jdField_a_of_type_AndroidContentContext, localDownloadInfo);
    if (i >= 0)
    {
      yxs.c("GdtAppBtnUIPresenter", "isPkgDownloading." + localDownloadInfo.packageName + " " + i);
      a(localDownloadInfo, i);
      return;
    }
    if ((this.jdField_a_of_type_Yzj.jdField_a_of_type_Boolean) || ((this.jdField_c_of_type_Boolean) && (yyq.a())))
    {
      if (this.jdField_a_of_type_Yzj.jdField_a_of_type_Boolean)
      {
        yxs.c("GdtAppBtnUIPresenter", "autodownload by userClick");
        a(localDownloadInfo, 0);
        return;
      }
      if ((this.jdField_c_of_type_Boolean) && (yyq.a()))
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          yxs.c("GdtAppBtnUIPresenter", "autodownload for getAppData <1s");
          a(localDownloadInfo, 0);
          return;
        }
        yxs.c("GdtAppBtnUIPresenter", "dont autodownload for getAppData >1s");
      }
    }
    else
    {
      if (yyq.b(this.jdField_a_of_type_AndroidContentContext, localDownloadInfo) >= 0)
      {
        j();
        return;
      }
      yxs.c("GdtAppBtnUIPresenter", "initDownloadApp DOWNLOAD_NONE.");
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    yxs.b("GdtAppBtnUIPresenter", "onDownloadWait " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzj.b(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void b(String paramString1, String paramString2)
  {
    yxs.b("GdtAppBtnUIPresenter", "uninstallSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzj.b(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void c()
  {
    if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null)
    {
      this.jdField_a_of_type_Yzj.a(null, 0);
      return;
    }
    this.jdField_a_of_type_Yzj.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState);
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    yxs.b("GdtAppBtnUIPresenter", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzj.d(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void c(String paramString1, String paramString2)
  {
    yxs.b("GdtAppBtnUIPresenter", "packageReplaced " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzj.c(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void d()
  {
    f = false;
    o();
    this.jdField_a_of_type_Yzj = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    yxs.b("GdtAppBtnUIPresenter", "onDownloadCancel " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzj.c(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void e()
  {
    if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData != null)
    {
      if (!nmf.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName)) {
        break label63;
      }
      yxs.c("GdtAppBtnUIPresenter", "onActivityResume already installed." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
      this.jdField_a_of_type_Yzj.b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
    }
    label63:
    do
    {
      return;
      if (yyq.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp))
      {
        yxs.c("GdtAppBtnUIPresenter", "onActivityResume already finishDownload." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
        this.jdField_a_of_type_Yzj.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
        return;
      }
    } while ((jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 1) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 0) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 5));
    yxs.c("GdtAppBtnUIPresenter", "onActivityResume already installed or finishDownload but not exist." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
    this.jdField_a_of_type_Yzj.c(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void f()
  {
    if ((yxu.a(this.jdField_a_of_type_AndroidContentContext)) && (!f))
    {
      f = true;
      AdThreadManager.INSTANCE.post(this.jdField_d_of_type_JavaLangRunnable, 4);
    }
  }
  
  public void g()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null)
    {
      jdField_a_of_type_Boolean = true;
      yyh.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, 238);
      return;
    }
    QLog.e("GdtAppBtnUIPresenter", 1, "reportForPaused ad == null:");
  }
  
  public void h()
  {
    n();
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Yzj == null) || (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null) || (!jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.isValid())) {
      return;
    }
    if (nmf.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName))
    {
      this.jdField_a_of_type_Yzj.b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
      this.jdField_a_of_type_Yzj.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
      return;
    }
    if (yyq.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp))
    {
      this.jdField_a_of_type_Yzj.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
      DownloadInfo localDownloadInfo = bdgv.a().b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bdgv.a().a(localDownloadInfo);
      return;
    }
    int j = yyq.c(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzl
 * JD-Core Version:    0.7.0.1
 */