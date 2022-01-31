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

public class yzi
{
  public static volatile GdtAppBtnData a;
  private static ArrayList<yzk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static boolean a;
  private static boolean f;
  private static volatile boolean g;
  private static volatile boolean h;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdld jdField_a_of_type_Bdld = new yzl(this);
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtAppDownloadManager.1(this);
  public String a;
  private WeakReference<zad> jdField_a_of_type_JavaLangRefWeakReference;
  private yzg jdField_a_of_type_Yzg;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GdtAppDownloadManager.2(this);
  private final String jdField_b_of_type_JavaLangString = "GdtAppDownloadManager";
  public boolean b;
  private Runnable jdField_c_of_type_JavaLangRunnable = new GdtAppDownloadManager.5(this);
  private boolean jdField_c_of_type_Boolean;
  private Runnable jdField_d_of_type_JavaLangRunnable = new GdtAppDownloadManager.6(this);
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public yzi(Context paramContext, boolean paramBoolean1, GdtAd paramGdtAd, String paramString1, GdtCanvasAppBtnView paramGdtCanvasAppBtnView, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString2;
    i();
    this.jdField_a_of_type_Yzg = new yzg(paramString1, paramGdtCanvasAppBtnView, this);
    l();
    if (yyn.a()) {
      AdThreadManager.INSTANCE.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0, 1000L);
    }
    try
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramContext != null) && ((paramContext instanceof QQAppInterface)))
      {
        paramContext = ((QQAppInterface)paramContext).getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramContext)) {
          bcyb.a().a(Long.valueOf(paramContext).longValue());
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
    yxp.b("GdtAppBtnUIPresenter", "resetStaticVariables");
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
      yxp.d("GdtAppBtnUIPresenter", "startRealDownload param null");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString(bdlb.f, str1);
    ((Bundle)localObject).putString(bdlb.jdField_b_of_type_JavaLangString, str2);
    ((Bundle)localObject).putString(bdlb.j, str3);
    ((Bundle)localObject).putString(bdlb.l, str4);
    ((Bundle)localObject).putInt(bdlb.k, 2);
    ((Bundle)localObject).putInt(bdlb.E, 0);
    ((Bundle)localObject).putBoolean(bdlb.x, false);
    ((Bundle)localObject).putInt(bdlb.H, 0);
    ((Bundle)localObject).putBoolean(bdlb.y, true);
    ((Bundle)localObject).putBoolean(bdlb.h, true);
    ((Bundle)localObject).putBoolean(bdlb.r, false);
    ((Bundle)localObject).putBoolean(bdlb.J, false);
    ((Bundle)localObject).putString(bdlb.i, str5);
    ((Bundle)localObject).putString("big_brother_ref_source_key", paramGdtAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtAppBtnUIPresenter", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    bdho.a().a(paramActivity, (Bundle)localObject, "biz_src_ads", null, 0);
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
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    PBUInt32Field localPBUInt32Field = localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type;
    if (paramBoolean) {}
    for (int i = 36;; i = 37)
    {
      localPBUInt32Field.set(i);
      localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
      yxt.a(localyxu);
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
      jdField_a_of_type_JavaUtilArrayList.add(new yzj(this));
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
      ((yzk)jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  private void l()
  {
    yxp.a("GdtAppDownloadManager", "going fetch AppData");
    if ((!f) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null) && (yxr.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      f = true;
      AdThreadManager.INSTANCE.post(this.jdField_c_of_type_JavaLangRunnable, 4);
    }
  }
  
  private void m()
  {
    if ((!h) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData != null) && ((yyn.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp)) || (yyn.a())))
    {
      zcc.b(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      h = true;
    }
  }
  
  private void n()
  {
    yxp.a("GdtAppDownloadManager", "registerDownloadListener: " + this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      bdhk.a().a(this.jdField_a_of_type_Bdld);
    }
  }
  
  private void o()
  {
    yxp.a("GdtAppDownloadManager", "unregisterDownloadListener");
    bdhk.a().b(this.jdField_a_of_type_Bdld);
  }
  
  void a(GdtAppBtnData paramGdtAppBtnData, int paramInt)
  {
    g = true;
    yxp.c("GdtAppBtnUIPresenter", "startDownload " + paramGdtAppBtnData.packageName + " progress " + paramInt);
    paramGdtAppBtnData.cState = 3;
    this.jdField_a_of_type_Yzg.b(paramGdtAppBtnData, paramInt);
    n();
    yzn.a().a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.mGdtAd_appId, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
    yzn.a().a();
    yzn.a().a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramInt, this.jdField_c_of_type_Boolean);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Boolean = true;
    paramGdtAppBtnData.via = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getVia();
    a(localActivity, paramGdtAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    yxp.b("GdtAppBtnUIPresenter", "onDownloadPause " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzg.a(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    yxp.b("GdtAppBtnUIPresenter", "onDownloadError " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzg.a(paramDownloadInfo, paramInt1, paramString, paramInt2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(String paramString1, String paramString2)
  {
    yxp.b("GdtAppBtnUIPresenter", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzg.a(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void a(WeakReference<zad> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Yzg.a(paramList, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void b()
  {
    yxp.b("GdtAppBtnUIPresenter", "initDownloadApp");
    try
    {
      GdtAppBtnData localGdtAppBtnData = jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData;
      if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Yzg == null) || (localGdtAppBtnData == null) || (!localGdtAppBtnData.isValid()))
      {
        yxp.b("GdtAppBtnUIPresenter", "initDownloadApp return " + localGdtAppBtnData);
        return;
      }
      yxp.b("GdtAppBtnUIPresenter", "initDownloadApp begin");
      if (nmc.a(this.jdField_a_of_type_AndroidContentContext, localGdtAppBtnData.packageName))
      {
        yxp.c("GdtAppBtnUIPresenter", "already installed." + localGdtAppBtnData.packageName);
        j();
        this.jdField_a_of_type_Yzg.b(localGdtAppBtnData);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtAppDownloadManager", 1, "initDownloadApp: ", localThrowable);
      return;
    }
    DownloadInfo localDownloadInfo;
    if (yyn.b(this.jdField_a_of_type_AndroidContentContext, localThrowable.apkUrlhttp))
    {
      yxp.c("GdtAppBtnUIPresenter", "already finishDownload." + localThrowable.packageName);
      j();
      this.jdField_a_of_type_Yzg.a(localThrowable);
      yye.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, 270);
      localDownloadInfo = bdhk.a().b(localThrowable.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bdhk.a().a(localDownloadInfo);
      return;
    }
    int i = yyn.a(this.jdField_a_of_type_AndroidContentContext, localDownloadInfo);
    if (i >= 0)
    {
      yxp.c("GdtAppBtnUIPresenter", "isPkgDownloading." + localDownloadInfo.packageName + " " + i);
      a(localDownloadInfo, i);
      return;
    }
    if ((this.jdField_a_of_type_Yzg.jdField_a_of_type_Boolean) || ((this.jdField_c_of_type_Boolean) && (yyn.a())))
    {
      if (this.jdField_a_of_type_Yzg.jdField_a_of_type_Boolean)
      {
        yxp.c("GdtAppBtnUIPresenter", "autodownload by userClick");
        a(localDownloadInfo, 0);
        return;
      }
      if ((this.jdField_c_of_type_Boolean) && (yyn.a()))
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          yxp.c("GdtAppBtnUIPresenter", "autodownload for getAppData <1s");
          a(localDownloadInfo, 0);
          return;
        }
        yxp.c("GdtAppBtnUIPresenter", "dont autodownload for getAppData >1s");
      }
    }
    else
    {
      if (yyn.b(this.jdField_a_of_type_AndroidContentContext, localDownloadInfo) >= 0)
      {
        j();
        return;
      }
      yxp.c("GdtAppBtnUIPresenter", "initDownloadApp DOWNLOAD_NONE.");
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    yxp.b("GdtAppBtnUIPresenter", "onDownloadWait " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzg.b(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void b(String paramString1, String paramString2)
  {
    yxp.b("GdtAppBtnUIPresenter", "uninstallSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzg.b(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void c()
  {
    if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null)
    {
      this.jdField_a_of_type_Yzg.a(null, 0);
      return;
    }
    this.jdField_a_of_type_Yzg.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState);
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    yxp.b("GdtAppBtnUIPresenter", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzg.d(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void c(String paramString1, String paramString2)
  {
    yxp.b("GdtAppBtnUIPresenter", "packageReplaced " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Yzg.c(paramString1, paramString2, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void d()
  {
    f = false;
    o();
    this.jdField_a_of_type_Yzg = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    yxp.b("GdtAppBtnUIPresenter", "onDownloadCancel " + paramDownloadInfo.e);
    this.jdField_a_of_type_Yzg.c(paramDownloadInfo, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void e()
  {
    if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData != null)
    {
      if (!nmc.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName)) {
        break label63;
      }
      yxp.c("GdtAppBtnUIPresenter", "onActivityResume already installed." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
      this.jdField_a_of_type_Yzg.b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
    }
    label63:
    do
    {
      return;
      if (yyn.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp))
      {
        yxp.c("GdtAppBtnUIPresenter", "onActivityResume already finishDownload." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
        this.jdField_a_of_type_Yzg.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
        return;
      }
    } while ((jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 1) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 0) && (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.cState != 5));
    yxp.c("GdtAppBtnUIPresenter", "onActivityResume already installed or finishDownload but not exist." + jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
    this.jdField_a_of_type_Yzg.c(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
  }
  
  public void f()
  {
    if ((yxr.a(this.jdField_a_of_type_AndroidContentContext)) && (!f))
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
      yye.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, 238);
      return;
    }
    QLog.e("GdtAppBtnUIPresenter", 1, "reportForPaused ad == null:");
  }
  
  public void h()
  {
    n();
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Yzg == null) || (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData == null) || (!jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.isValid())) {
      return;
    }
    if (nmc.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName))
    {
      this.jdField_a_of_type_Yzg.b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
      this.jdField_a_of_type_Yzg.a(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.packageName);
      return;
    }
    if (yyn.b(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp))
    {
      this.jdField_a_of_type_Yzg.a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
      DownloadInfo localDownloadInfo = bdhk.a().b(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bdhk.a().a(localDownloadInfo);
      return;
    }
    int j = yyn.c(this.jdField_a_of_type_AndroidContentContext, jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtAppBtnData, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzi
 * JD-Core Version:    0.7.0.1
 */